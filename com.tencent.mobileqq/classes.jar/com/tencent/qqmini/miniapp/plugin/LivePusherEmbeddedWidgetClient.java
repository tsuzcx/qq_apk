package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.qqmini.miniapp.core.page.BrandPageWebview;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class LivePusherEmbeddedWidgetClient
  implements IExtendedEmbeddedWidgetClient
{
  private static final String TAG = "miniapp-embedded-live-pusher";
  public static volatile boolean mIsInited = false;
  private IJsService callBackWebview;
  private int curPageWebviewId;
  private ConcurrentHashMap<String, String> downloadMap = new ConcurrentHashMap();
  private AtomicInteger downloadTaskId = new AtomicInteger(0);
  private Handler handler = new Handler(Looper.getMainLooper());
  private int height = -1;
  private TXLivePusherJSAdapter livePusherJSAdapter;
  private Map<String, String> mAttributes;
  private IMiniAppContext mMiniAppContext;
  private Surface mSurface = null;
  private String mTagName;
  private IEmbeddedWidget mWidget;
  private boolean needToStopDownloadBGM = false;
  private Runnable stopDumpRunnable = new LivePusherEmbeddedWidgetClient.1(this);
  private String tempAudioFilePath = null;
  private int viewId = -1;
  private int width = -1;
  
  public LivePusherEmbeddedWidgetClient(IMiniAppContext paramIMiniAppContext, String paramString, Map<String, String> paramMap, IEmbeddedWidget paramIEmbeddedWidget)
  {
    this.mTagName = paramString;
    this.mAttributes = paramMap;
    this.mWidget = paramIEmbeddedWidget;
    this.mMiniAppContext = paramIMiniAppContext;
  }
  
  private void evaluateCallbackJs(int paramInt, String paramString)
  {
    if (this.callBackWebview != null) {
      this.callBackWebview.evaluateCallbackJs(paramInt, paramString);
    }
  }
  
  private void evaluateSubscribeJS(String paramString1, String paramString2, int paramInt)
  {
    if (this.mMiniAppContext != null) {
      this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(paramString1, paramString2, paramInt));
    }
    if (this.callBackWebview != null) {
      this.callBackWebview.evaluateSubscribeJS(paramString1, paramString2, this.curPageWebviewId);
    }
  }
  
  private void handlePlayBGMEvent(JSONObject paramJSONObject, int paramInt1, int paramInt2, String paramString)
  {
    this.needToStopDownloadBGM = false;
    String str1 = String.valueOf(this.downloadTaskId.getAndIncrement());
    String str2 = paramJSONObject.optString("url");
    this.downloadMap.put(str1, str2);
    String str3 = MiniAppFileManager.getInstance().getTmpPathByUrl(str2);
    DownloaderProxy localDownloaderProxy = (DownloaderProxy)ProxyManager.get(DownloaderProxy.class);
    localDownloaderProxy.download(str2, null, str3, 60, new LivePusherEmbeddedWidgetClient.4(this, str1, str2, paramInt2, str3, paramJSONObject, paramString, localDownloaderProxy));
    evaluateCallbackJs(paramInt1, ApiUtil.wrapCallbackOk("operateXWebLivePusher", null).toString());
  }
  
  private void handleSetBGMPosition(JSONObject paramJSONObject, int paramInt, String paramString)
  {
    try
    {
      paramJSONObject.put("BGMPosition", paramJSONObject.getInt("position") * 1000);
      this.livePusherJSAdapter.operateLivePusher(paramString, paramJSONObject);
      evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePusher", null).toString());
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        QMLog.e("miniapp-embedded-live-pusher", "setBGMPosition - JSONException:" + paramJSONObject);
      }
    }
  }
  
  private void handleSnapShotEvent(JSONObject paramJSONObject, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("quality");
      bool1 = bool2;
      if (paramJSONObject != null)
      {
        bool1 = bool2;
        if (paramJSONObject.equalsIgnoreCase("compressed")) {
          bool1 = true;
        }
      }
    }
    takePhoto("operateXWebLivePusher", bool1, paramInt);
  }
  
  private void handleStartAudioRecord(JSONObject paramJSONObject, int paramInt)
  {
    Object localObject = MiniAppFileManager.getInstance().getTmpPath("pcm");
    long l = paramJSONObject.optLong("maxDuration");
    QMLog.d("miniapp-embedded-live-pusher", "recordFile:" + (String)localObject);
    int i = this.livePusherJSAdapter.startDumpAudioData((String)localObject);
    QMLog.d("miniapp-embedded-live-pusher", "recordResult:" + i);
    JSONObject localJSONObject;
    if (i == 0) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        paramJSONObject = MiniAppFileManager.getInstance().getWxFilePath((String)localObject);
        ((JSONException)localObject).printStackTrace();
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          QMLog.d("miniapp-embedded-live-pusher", "recordFile transformed:" + paramJSONObject);
          localJSONObject.put("tempFilePath", paramJSONObject);
          this.tempAudioFilePath = paramJSONObject;
          evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePusher", localJSONObject).toString());
          this.handler.postDelayed(this.stopDumpRunnable, l);
          QMLog.d("miniapp-embedded-live-pusher", "recordResult:" + i);
          return;
        }
        catch (JSONException localJSONException1)
        {
          break label207;
        }
        localJSONException2 = localJSONException2;
        paramJSONObject = (JSONObject)localObject;
        localObject = localJSONException2;
      }
      label207:
      continue;
      if (i == -1)
      {
        evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("operateXWebLivePusher", null, "LivePusher is recording").toString());
        return;
      }
      if (i == -2) {
        evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("operateXWebLivePusher", null, "LivePusher creates recordFile failed").toString());
      } else if (i == -3) {
        evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("operateXWebLivePusher", null, "LivePusher not support current format").toString());
      } else {
        evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("operateXWebLivePusher", null, "LivePusher starts recording fail").toString());
      }
    }
  }
  
  private void handleStopAudioRecord(int paramInt)
  {
    QMLog.d("miniapp-embedded-live-pusher", "stopDumpAudioData");
    this.handler.removeCallbacks(this.stopDumpRunnable);
    this.livePusherJSAdapter.stopDumpAudioData();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!StringUtil.isEmpty(this.tempAudioFilePath))
      {
        localJSONObject.put("tempFilePath", this.tempAudioFilePath);
        this.tempAudioFilePath = null;
      }
      for (;;)
      {
        evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePusher", localJSONObject).toString());
        return;
        localJSONObject.put("tempFilePath", "");
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void handleStopBGMEvent(JSONObject paramJSONObject, int paramInt, String paramString)
  {
    this.needToStopDownloadBGM = true;
    this.livePusherJSAdapter.operateLivePusher(paramString, paramJSONObject);
    evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePusher", null).toString());
  }
  
  /* Error */
  private static void saveJpeg(android.graphics.Bitmap paramBitmap, java.io.File paramFile)
  {
    // Byte code:
    //   0: new 345	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 347	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 350	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 353	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_1
    //   16: aload_0
    //   17: getstatic 359	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   20: bipush 100
    //   22: bipush 100
    //   24: invokestatic 365	java/lang/Math:min	(II)I
    //   27: aload_1
    //   28: invokevirtual 371	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_1
    //   33: invokevirtual 374	java/io/BufferedOutputStream:flush	()V
    //   36: aload_1
    //   37: ifnull +7 -> 44
    //   40: aload_1
    //   41: invokevirtual 377	java/io/BufferedOutputStream:close	()V
    //   44: return
    //   45: astore_0
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 377	java/io/BufferedOutputStream:close	()V
    //   56: aload_0
    //   57: athrow
    //   58: astore_0
    //   59: return
    //   60: astore_1
    //   61: goto -5 -> 56
    //   64: astore_0
    //   65: goto -17 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramBitmap	android.graphics.Bitmap
    //   0	68	1	paramFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   0	16	45	finally
    //   40	44	58	java/lang/Exception
    //   52	56	60	java/lang/Exception
    //   16	36	64	finally
  }
  
  public boolean enterBackground()
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("miniapp-embedded-live-pusher", "enterBackground");
    }
    if (this.livePusherJSAdapter != null) {
      this.livePusherJSAdapter.enterBackground(false);
    }
    return true;
  }
  
  public boolean enterForeground()
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("miniapp-embedded-live-pusher", "enterForeground");
    }
    if (this.livePusherJSAdapter != null) {
      this.livePusherJSAdapter.enterForeground();
    }
    return true;
  }
  
  public IMiniAppContext getMiniAppContext()
  {
    return this.mMiniAppContext;
  }
  
  public void handleInsertXWebLivePusher(JSONObject paramJSONObject, IJsService paramIJsService)
  {
    this.callBackWebview = paramIJsService;
    if ((paramIJsService instanceof BrandPageWebview)) {
      this.curPageWebviewId = ((BrandPageWebview)paramIJsService).getWebViewId();
    }
    for (;;)
    {
      if (paramJSONObject != null)
      {
        QMLog.d("miniapp-embedded-live-pusher", "handleInsertXWebLivePusher : " + paramJSONObject.toString());
        this.viewId = paramJSONObject.optInt("viewId");
        if (paramJSONObject.has("position"))
        {
          paramIJsService = paramJSONObject.optJSONObject("position");
          this.width = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramIJsService.optInt("width", -1) + 0.5F));
          float f = DisplayUtil.getDensity(AppLoaderFactory.g().getContext());
          this.height = ((int)(paramIJsService.optInt("height", -1) * f + 0.5F));
        }
        this.livePusherJSAdapter = new TXLivePusherJSAdapter(AppLoaderFactory.g().getContext());
        this.livePusherJSAdapter.setSurface(this.mSurface);
        this.livePusherJSAdapter.setSurfaceSize(this.width, this.height);
        this.livePusherJSAdapter.initEmbeddedLivePusher(paramJSONObject);
        this.livePusherJSAdapter.setBGMNotifyListener(new LivePusherEmbeddedWidgetClient.2(this));
        this.livePusherJSAdapter.setPushListener(new LivePusherEmbeddedWidgetClient.3(this));
      }
      return;
      QMLog.e("miniapp-embedded-live-pusher", "cant get webviewId from " + paramIJsService);
    }
  }
  
  public void handleOperateXWebLivePusher(JSONObject paramJSONObject, int paramInt)
  {
    QMLog.d("miniapp-embedded-live-pusher", "handleOperateXWebLivePusher : " + paramJSONObject.toString());
    int i = paramJSONObject.optInt("viewId", -1);
    String str;
    if ((i == this.viewId) && (paramJSONObject.has("type")))
    {
      str = paramJSONObject.optString("type");
      if (this.livePusherJSAdapter != null)
      {
        if (!"playBGM".equals(str)) {
          break label92;
        }
        handlePlayBGMEvent(paramJSONObject, paramInt, i, str);
      }
    }
    return;
    label92:
    if ("stopBGM".equals(str))
    {
      handleStopBGMEvent(paramJSONObject, paramInt, str);
      return;
    }
    if ("setBGMPosition".equals(str))
    {
      handleSetBGMPosition(paramJSONObject, paramInt, str);
      return;
    }
    if ("snapshot".equals(str))
    {
      handleSnapShotEvent(paramJSONObject, paramInt);
      return;
    }
    if (str.equalsIgnoreCase("startAudioRecord"))
    {
      handleStartAudioRecord(paramJSONObject, paramInt);
      return;
    }
    if (str.equalsIgnoreCase("stopAudioRecord"))
    {
      handleStopAudioRecord(paramInt);
      return;
    }
    this.livePusherJSAdapter.operateLivePusher(str, paramJSONObject);
    evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePusher", null).toString());
  }
  
  public void handleRemoveXWebLivePusher()
  {
    release();
  }
  
  public void handleUpdateXWebLivePusher(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      QMLog.d("miniapp-embedded-live-pusher", "handleUpdateXWebLivePusher : " + paramJSONObject.toString());
      if (paramJSONObject.has("position"))
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
        this.width = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * localJSONObject.optInt("width", -1) + 0.5F));
        float f = DisplayUtil.getDensity(AppLoaderFactory.g().getContext());
        this.height = ((int)(localJSONObject.optInt("height", -1) * f + 0.5F));
        this.livePusherJSAdapter.setSurfaceSize(this.width, this.height);
      }
      if (this.livePusherJSAdapter != null) {
        this.livePusherJSAdapter.updateLivePusher(paramJSONObject);
      }
    }
  }
  
  public void nativeDestroy()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.nativeDestroy " + this);
    release();
  }
  
  public void nativePause()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.nativePause " + this);
    enterBackground();
  }
  
  public void nativeResume()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.nativeResume " + this);
    enterForeground();
  }
  
  public void onActive()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onActive");
  }
  
  public void onDeactive()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onDeactive");
  }
  
  public void onDestroy()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onDestroy");
    release();
  }
  
  public void onRectChanged(Rect paramRect)
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onRectChanged, rect:" + paramRect.toString() + "； size : " + (paramRect.right - paramRect.left) + "," + (paramRect.bottom - paramRect.top));
  }
  
  public void onRequestRedraw()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onRequestRedraw");
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    QMLog.d("miniapp-embedded-live-pusher", "onSurfaceCreated: " + paramSurface);
    if ((paramSurface == null) || (!paramSurface.isValid()))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onSurfaceCreated isValid() : ");
      if (paramSurface != null)
      {
        paramSurface = Boolean.valueOf(paramSurface.isValid());
        QMLog.e("miniapp-embedded-live-pusher", paramSurface);
      }
    }
    do
    {
      return;
      paramSurface = null;
      break;
      this.mSurface = paramSurface;
    } while (this.livePusherJSAdapter == null);
    this.livePusherJSAdapter.setSurface(this.mSurface);
  }
  
  public void onSurfaceDestroyed(Surface paramSurface)
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onSurfaceDestroyed");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onTouchEvent, rect:" + paramMotionEvent.toString());
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onVisibilityChanged ： " + paramBoolean);
  }
  
  public void release()
  {
    this.handler.removeCallbacks(this.stopDumpRunnable);
    if (this.livePusherJSAdapter != null)
    {
      this.livePusherJSAdapter.unInitLivePusher();
      this.livePusherJSAdapter.setSurface(null);
    }
  }
  
  public void takePhoto(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.livePusherJSAdapter == null) {
      return;
    }
    this.livePusherJSAdapter.takePhoto(paramBoolean, new LivePusherEmbeddedWidgetClient.5(this, paramString, paramInt));
  }
  
  public void webViewDestory()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.webviewDestory " + this);
    release();
  }
  
  public void webViewPause()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.webviewPause " + this);
    enterBackground();
  }
  
  public void webViewResume()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.webviewResume " + this);
    enterForeground();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePusherEmbeddedWidgetClient
 * JD-Core Version:    0.7.0.1
 */