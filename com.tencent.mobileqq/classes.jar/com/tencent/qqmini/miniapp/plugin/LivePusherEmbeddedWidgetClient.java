package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
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
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.FileUtils;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import java.io.File;
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
  
  private File copyFile(String paramString1, String paramString2)
  {
    Object localObject1 = new File(paramString2);
    Object localObject2 = localObject1;
    String str;
    if (!((File)localObject1).exists())
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(paramString1))
      {
        QMLog.e("miniapp-embedded-live-pusher", "file no exists, try to copy again.");
        try
        {
          File localFile = new File(paramString1);
          localObject2 = localObject1;
          if (!localFile.exists()) {
            break label281;
          }
          localObject2 = localObject1;
          if (!localFile.isFile()) {
            break label281;
          }
          localObject2 = localObject1;
          if (localFile.length() <= 0L) {
            break label281;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("download Succeed but target file not exists, try copy from download tmp file:");
          ((StringBuilder)localObject2).append(paramString1);
          ((StringBuilder)localObject2).append(", length:");
          ((StringBuilder)localObject2).append(localFile.length());
          ((StringBuilder)localObject2).append(", to:");
          ((StringBuilder)localObject2).append(paramString2);
          QMLog.w("miniapp-embedded-live-pusher", ((StringBuilder)localObject2).toString());
          paramString2 = FileUtils.createFile(paramString2);
          try
          {
            if ((FileUtils.copyFile(localFile, paramString2)) && (paramString2.exists()) && (paramString2.length() == localFile.length()))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("copy from download tmp file:");
              ((StringBuilder)localObject1).append(paramString1);
              ((StringBuilder)localObject1).append(" success");
              QMLog.d("miniapp-embedded-live-pusher", ((StringBuilder)localObject1).toString());
            }
            else if (paramString2.exists())
            {
              paramString2.delete();
            }
            return paramString2;
          }
          catch (Throwable localThrowable1) {}
          localObject1 = new StringBuilder();
        }
        catch (Throwable localThrowable2)
        {
          paramString2 = (String)localObject1;
        }
        ((StringBuilder)localObject1).append("try copy from download tmp file exception! tmp file:");
        ((StringBuilder)localObject1).append(paramString1);
        QMLog.e("miniapp-embedded-live-pusher", ((StringBuilder)localObject1).toString(), localThrowable2);
        str = paramString2;
      }
    }
    label281:
    return str;
  }
  
  private void evaluateCallbackJs(int paramInt, String paramString)
  {
    IJsService localIJsService = this.callBackWebview;
    if (localIJsService != null) {
      localIJsService.evaluateCallbackJs(paramInt, paramString);
    }
  }
  
  private void evaluateSubscribeJS(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = this.mMiniAppContext;
    if (localObject != null) {
      ((IMiniAppContext)localObject).performAction(ServiceSubscribeEvent.obtain(paramString1, paramString2, paramInt));
    }
    localObject = this.callBackWebview;
    if (localObject != null) {
      ((IJsService)localObject).evaluateSubscribeJS(paramString1, paramString2, paramInt);
    }
  }
  
  private DownloaderProxy.DownloadListener getBGMDownloadListener(JSONObject paramJSONObject, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DownloaderProxy paramDownloaderProxy)
  {
    return new LivePusherEmbeddedWidgetClient.4(this, paramString2, paramString3, paramInt, paramString4, paramJSONObject, paramString1, paramDownloaderProxy);
  }
  
  private void handleBGMDownloadFailed(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.downloadMap.remove(paramString2, paramString3);
    paramString2 = new StringBuilder();
    paramString2.append("playBGM - download onDownloadFailed failed:");
    paramString2.append(paramString1);
    QMLog.e("miniapp-embedded-live-pusher", paramString2.toString());
    paramString2 = new JSONObject();
    try
    {
      paramString2.put("viewId", paramInt);
      paramString2.put("errMsg", paramString1);
      paramString2.put("errCode", 10003);
      evaluateSubscribeJS("onXWebLivePusherError", paramString2.toString(), this.curPageWebviewId);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void handleBGMDownloadSuc(int paramInt, String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, String paramString4)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playBGM - download onDownloadSucceed statusCode:");
      ((StringBuilder)localObject).append(paramInt);
      QMLog.e("miniapp-embedded-live-pusher", ((StringBuilder)localObject).toString());
      if (this.needToStopDownloadBGM)
      {
        QMLog.e("miniapp-embedded-live-pusher", "playBGM - download onDownloadSucceed but needToStopDownloadBGM");
        return;
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject = copyFile(paramString1, paramString2);
        this.downloadMap.remove(paramString3);
        if ((((File)localObject).exists()) && (((File)localObject).canRead()))
        {
          if (QMLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("download success bgmFilePath:");
            paramString1.append(paramString2);
            QMLog.d("miniapp-embedded-live-pusher", paramString1.toString());
          }
          paramJSONObject.put("BGMFilePath", paramString2);
          this.livePusherJSAdapter.operateLivePusher(paramString4, paramJSONObject);
          return;
        }
        paramString2 = new StringBuilder();
        paramString2.append("download failed, filepath not exists, tmpFile:");
        paramString2.append(paramString1);
        QMLog.d("miniapp-embedded-live-pusher", paramString2.toString());
        return;
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
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
    localDownloaderProxy.download(str2, null, str3, 60, getBGMDownloadListener(paramJSONObject, paramInt2, paramString, str1, str2, str3, localDownloaderProxy));
    evaluateCallbackJs(paramInt1, ApiUtil.wrapCallbackOk("operateXWebLivePusher", null).toString());
  }
  
  private void handleSetBGMPosition(JSONObject paramJSONObject, int paramInt, String paramString)
  {
    try
    {
      paramJSONObject.put("BGMPosition", paramJSONObject.getInt("position") * 1000);
      this.livePusherJSAdapter.operateLivePusher(paramString, paramJSONObject);
    }
    catch (JSONException paramJSONObject)
    {
      paramString = new StringBuilder();
      paramString.append("setBGMPosition - JSONException:");
      paramString.append(paramJSONObject);
      QMLog.e("miniapp-embedded-live-pusher", paramString.toString());
    }
    evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePusher", null).toString());
  }
  
  private void handleSnapShotEvent(JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("quality");
      if ((paramJSONObject != null) && (paramJSONObject.equalsIgnoreCase("compressed")))
      {
        bool = true;
        break label33;
      }
    }
    boolean bool = false;
    label33:
    takePhoto("operateXWebLivePusher", bool, paramInt);
  }
  
  private void handleStartAudioRecord(JSONObject paramJSONObject, int paramInt)
  {
    String str = MiniAppFileManager.getInstance().getTmpPath("pcm");
    long l = paramJSONObject.optLong("maxDuration");
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("recordFile:");
    paramJSONObject.append(str);
    QMLog.d("miniapp-embedded-live-pusher", paramJSONObject.toString());
    int i = this.livePusherJSAdapter.startDumpAudioData(str);
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("recordResult:");
    paramJSONObject.append(i);
    QMLog.d("miniapp-embedded-live-pusher", paramJSONObject.toString());
    if (i == 0)
    {
      JSONObject localJSONObject = new JSONObject();
      paramJSONObject = str;
      try
      {
        str = MiniAppFileManager.getInstance().getWxFilePath(str);
        paramJSONObject = str;
        StringBuilder localStringBuilder = new StringBuilder();
        paramJSONObject = str;
        localStringBuilder.append("recordFile transformed:");
        paramJSONObject = str;
        localStringBuilder.append(str);
        paramJSONObject = str;
        QMLog.d("miniapp-embedded-live-pusher", localStringBuilder.toString());
        paramJSONObject = str;
        localJSONObject.put("tempFilePath", str);
        paramJSONObject = str;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      this.tempAudioFilePath = paramJSONObject;
      evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePusher", localJSONObject).toString());
      this.handler.postDelayed(this.stopDumpRunnable, l);
    }
    else
    {
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
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("recordResult:");
    paramJSONObject.append(i);
    QMLog.d("miniapp-embedded-live-pusher", paramJSONObject.toString());
  }
  
  private void handleStopAudioRecord(int paramInt)
  {
    QMLog.d("miniapp-embedded-live-pusher", "stopDumpAudioData");
    this.handler.removeCallbacks(this.stopDumpRunnable);
    this.livePusherJSAdapter.stopDumpAudioData();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      boolean bool = StringUtil.isEmpty(this.tempAudioFilePath);
      if (!bool)
      {
        localJSONObject.put("tempFilePath", this.tempAudioFilePath);
        this.tempAudioFilePath = null;
      }
      else
      {
        localJSONObject.put("tempFilePath", "");
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePusher", localJSONObject).toString());
  }
  
  private void handleStopBGMEvent(JSONObject paramJSONObject, int paramInt, String paramString)
  {
    this.needToStopDownloadBGM = true;
    this.livePusherJSAdapter.operateLivePusher(paramString, paramJSONObject);
    evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePusher", null).toString());
  }
  
  /* Error */
  private static void saveJpeg(android.graphics.Bitmap paramBitmap, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 452	java/io/BufferedOutputStream
    //   5: dup
    //   6: new 454	java/io/FileOutputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 457	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   14: invokespecial 460	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   17: astore_1
    //   18: aload_0
    //   19: getstatic 466	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   22: bipush 100
    //   24: bipush 100
    //   26: invokestatic 472	java/lang/Math:min	(II)I
    //   29: aload_1
    //   30: invokevirtual 478	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   33: pop
    //   34: aload_1
    //   35: invokevirtual 481	java/io/BufferedOutputStream:flush	()V
    //   38: aload_1
    //   39: invokevirtual 484	java/io/BufferedOutputStream:close	()V
    //   42: return
    //   43: astore_0
    //   44: goto +6 -> 50
    //   47: astore_0
    //   48: aload_2
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull +7 -> 58
    //   54: aload_1
    //   55: invokevirtual 484	java/io/BufferedOutputStream:close	()V
    //   58: aload_0
    //   59: athrow
    //   60: astore_0
    //   61: return
    //   62: astore_1
    //   63: goto -5 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	paramBitmap	android.graphics.Bitmap
    //   0	66	1	paramFile	File
    //   1	48	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	38	43	finally
    //   2	18	47	finally
    //   38	42	60	java/lang/Exception
    //   54	58	62	java/lang/Exception
  }
  
  public boolean enterBackground()
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("miniapp-embedded-live-pusher", "enterBackground");
    }
    TXLivePusherJSAdapter localTXLivePusherJSAdapter = this.livePusherJSAdapter;
    if (localTXLivePusherJSAdapter != null) {
      localTXLivePusherJSAdapter.enterBackground(false);
    }
    return true;
  }
  
  public boolean enterForeground()
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("miniapp-embedded-live-pusher", "enterForeground");
    }
    TXLivePusherJSAdapter localTXLivePusherJSAdapter = this.livePusherJSAdapter;
    if (localTXLivePusherJSAdapter != null) {
      localTXLivePusherJSAdapter.enterForeground();
    }
    return true;
  }
  
  public IMiniAppContext getMiniAppContext()
  {
    return this.mMiniAppContext;
  }
  
  public int getViewId()
  {
    return this.viewId;
  }
  
  public void handleInsertXWebLivePusher(JSONObject paramJSONObject, IJsService paramIJsService)
  {
    this.callBackWebview = paramIJsService;
    if ((paramIJsService instanceof BrandPageWebview))
    {
      this.curPageWebviewId = ((BrandPageWebview)paramIJsService).getWebViewId();
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cant get webviewId from ");
      localStringBuilder.append(paramIJsService);
      QMLog.e("miniapp-embedded-live-pusher", localStringBuilder.toString());
    }
    if (paramJSONObject != null)
    {
      paramIJsService = new StringBuilder();
      paramIJsService.append("handleInsertXWebLivePusher : ");
      paramIJsService.append(paramJSONObject.toString());
      QMLog.d("miniapp-embedded-live-pusher", paramIJsService.toString());
      this.viewId = paramJSONObject.optInt("viewId");
      if (paramJSONObject.has("position"))
      {
        paramIJsService = paramJSONObject.optJSONObject("position");
        this.width = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramIJsService.optInt("width", -1) + 0.5F));
        this.height = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramIJsService.optInt("height", -1) + 0.5F));
      }
      this.livePusherJSAdapter = new TXLivePusherJSAdapter(AppLoaderFactory.g().getContext());
      this.livePusherJSAdapter.setSurface(this.mSurface);
      this.livePusherJSAdapter.setSurfaceSize(this.width, this.height);
      this.livePusherJSAdapter.initEmbeddedLivePusher(paramJSONObject);
      this.livePusherJSAdapter.setBGMNotifyListener(new LivePusherEmbeddedWidgetClient.2(this));
      this.livePusherJSAdapter.setPushListener(new LivePusherEmbeddedWidgetClient.3(this));
    }
    paramJSONObject = this.livePusherJSAdapter;
    if (paramJSONObject != null) {
      paramJSONObject.updateHomeOrientation(this.mMiniAppContext);
    }
  }
  
  public void handleOperateXWebLivePusher(JSONObject paramJSONObject, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleOperateXWebLivePusher : ");
    ((StringBuilder)localObject).append(paramJSONObject.toString());
    QMLog.d("miniapp-embedded-live-pusher", ((StringBuilder)localObject).toString());
    int i = paramJSONObject.optInt("viewId", -1);
    if ((i == this.viewId) && (paramJSONObject.has("type")))
    {
      localObject = paramJSONObject.optString("type");
      if (this.livePusherJSAdapter != null)
      {
        if ("playBGM".equals(localObject))
        {
          handlePlayBGMEvent(paramJSONObject, paramInt, i, (String)localObject);
          return;
        }
        if ("stopBGM".equals(localObject))
        {
          handleStopBGMEvent(paramJSONObject, paramInt, (String)localObject);
          return;
        }
        if ("setBGMPosition".equals(localObject))
        {
          handleSetBGMPosition(paramJSONObject, paramInt, (String)localObject);
          return;
        }
        if ("snapshot".equals(localObject))
        {
          handleSnapShotEvent(paramJSONObject, paramInt);
          return;
        }
        if (((String)localObject).equalsIgnoreCase("startAudioRecord"))
        {
          handleStartAudioRecord(paramJSONObject, paramInt);
          return;
        }
        if (((String)localObject).equalsIgnoreCase("stopAudioRecord"))
        {
          handleStopAudioRecord(paramInt);
          return;
        }
        this.livePusherJSAdapter.operateLivePusher((String)localObject, paramJSONObject);
        evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePusher", null).toString());
      }
    }
  }
  
  public void handleRemoveXWebLivePusher()
  {
    release();
  }
  
  public void handleUpdateXWebLivePusher(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleUpdateXWebLivePusher : ");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QMLog.d("miniapp-embedded-live-pusher", ((StringBuilder)localObject).toString());
      if (paramJSONObject.has("position"))
      {
        localObject = paramJSONObject.optJSONObject("position");
        this.width = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * ((JSONObject)localObject).optInt("width", -1) + 0.5F));
        this.height = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * ((JSONObject)localObject).optInt("height", -1) + 0.5F));
        this.livePusherJSAdapter.setSurfaceSize(this.width, this.height);
      }
      localObject = this.livePusherJSAdapter;
      if (localObject != null) {
        ((TXLivePusherJSAdapter)localObject).updateLivePusher(paramJSONObject);
      }
    }
  }
  
  public void nativeDestroy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePusherEmbeddedWidgetClient.nativeDestroy ");
    localStringBuilder.append(this);
    QMLog.d("miniapp-embedded-live-pusher", localStringBuilder.toString());
    release();
  }
  
  public void nativePause()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePusherEmbeddedWidgetClient.nativePause ");
    localStringBuilder.append(this);
    QMLog.d("miniapp-embedded-live-pusher", localStringBuilder.toString());
    enterBackground();
  }
  
  public void nativeResume()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePusherEmbeddedWidgetClient.nativeResume ");
    localStringBuilder.append(this);
    QMLog.d("miniapp-embedded-live-pusher", localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePusherEmbeddedWidgetClient.onRectChanged, rect:");
    localStringBuilder.append(paramRect.toString());
    localStringBuilder.append("； size : ");
    localStringBuilder.append(paramRect.right - paramRect.left);
    localStringBuilder.append(",");
    localStringBuilder.append(paramRect.bottom - paramRect.top);
    QMLog.d("miniapp-embedded-live-pusher", localStringBuilder.toString());
  }
  
  public void onRequestRedraw()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onRequestRedraw");
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceCreated: ");
    localStringBuilder.append(paramSurface);
    QMLog.d("miniapp-embedded-live-pusher", localStringBuilder.toString());
    if ((paramSurface != null) && (paramSurface.isValid()))
    {
      this.mSurface = paramSurface;
      paramSurface = this.livePusherJSAdapter;
      if (paramSurface != null) {
        paramSurface.setSurface(this.mSurface);
      }
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceCreated isValid() : ");
    if (paramSurface != null) {
      paramSurface = Boolean.valueOf(paramSurface.isValid());
    } else {
      paramSurface = null;
    }
    localStringBuilder.append(paramSurface);
    QMLog.e("miniapp-embedded-live-pusher", localStringBuilder.toString());
  }
  
  public void onSurfaceDestroyed(Surface paramSurface)
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onSurfaceDestroyed");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePusherEmbeddedWidgetClient.onTouchEvent, rect:");
    localStringBuilder.append(paramMotionEvent.toString());
    QMLog.d("miniapp-embedded-live-pusher", localStringBuilder.toString());
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePusherEmbeddedWidgetClient.onVisibilityChanged ： ");
    localStringBuilder.append(paramBoolean);
    QMLog.d("miniapp-embedded-live-pusher", localStringBuilder.toString());
  }
  
  public void release()
  {
    this.handler.removeCallbacks(this.stopDumpRunnable);
    TXLivePusherJSAdapter localTXLivePusherJSAdapter = this.livePusherJSAdapter;
    if (localTXLivePusherJSAdapter != null)
    {
      localTXLivePusherJSAdapter.unInitLivePusher();
      this.livePusherJSAdapter.setSurface(null);
    }
  }
  
  public void takePhoto(String paramString, boolean paramBoolean, int paramInt)
  {
    TXLivePusherJSAdapter localTXLivePusherJSAdapter = this.livePusherJSAdapter;
    if (localTXLivePusherJSAdapter == null) {
      return;
    }
    localTXLivePusherJSAdapter.takePhoto(paramBoolean, new LivePusherEmbeddedWidgetClient.5(this, paramString, paramInt));
  }
  
  public void webViewDestroy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePusherEmbeddedWidgetClient.webViewDestroy ");
    localStringBuilder.append(this);
    QMLog.d("miniapp-embedded-live-pusher", localStringBuilder.toString());
    release();
  }
  
  public void webViewPause()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePusherEmbeddedWidgetClient.webviewPause ");
    localStringBuilder.append(this);
    QMLog.d("miniapp-embedded-live-pusher", localStringBuilder.toString());
    enterBackground();
  }
  
  public void webViewResume()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePusherEmbeddedWidgetClient.webviewResume ");
    localStringBuilder.append(this);
    QMLog.d("miniapp-embedded-live-pusher", localStringBuilder.toString());
    enterForeground();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePusherEmbeddedWidgetClient
 * JD-Core Version:    0.7.0.1
 */