package com.tencent.mobileqq.mini.appbrand.page.embedded;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.media.live.TXLivePusherJSAdapter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
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
  public static volatile boolean mIsInited;
  private JsRuntime callBackWebview;
  private BaseAppBrandRuntime curAppBrandRuntime;
  private int curPageWebviewId;
  private ConcurrentHashMap<String, String> downloadMap = new ConcurrentHashMap();
  private AtomicInteger downloadTaskId = new AtomicInteger(0);
  private Handler handler = new Handler(Looper.getMainLooper());
  private int height = -1;
  private TXLivePusherJSAdapter livePusherJSAdapter;
  private Map<String, String> mAttributes;
  private Surface mSurface;
  private String mTagName;
  private IEmbeddedWidget mWidget;
  private boolean needToStopDownloadBGM;
  private Runnable stopDumpRunnable = new LivePusherEmbeddedWidgetClient.1(this);
  private String tempAudioFilePath;
  private int viewId = -1;
  private int width = -1;
  
  public LivePusherEmbeddedWidgetClient(String paramString, Map<String, String> paramMap, IEmbeddedWidget paramIEmbeddedWidget)
  {
    this.mTagName = paramString;
    this.mAttributes = paramMap;
    this.mWidget = paramIEmbeddedWidget;
  }
  
  private void evaluateSubcribeJS(JsRuntime paramJsRuntime, String paramString1, String paramString2, int paramInt)
  {
    ((AppBrandRuntime)this.curAppBrandRuntime).serviceRuntime.evaluateSubcribeJS(paramString1, paramString2, paramInt);
    paramJsRuntime.evaluateSubcribeJS(paramString1, paramString2, paramInt);
  }
  
  /* Error */
  private static void saveJpeg(android.graphics.Bitmap paramBitmap, java.io.File paramFile)
  {
    // Byte code:
    //   0: new 136	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 138	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 144	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_1
    //   16: aload_0
    //   17: getstatic 150	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   20: bipush 100
    //   22: bipush 100
    //   24: invokestatic 156	java/lang/Math:min	(II)I
    //   27: aload_1
    //   28: invokevirtual 162	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_1
    //   33: invokevirtual 165	java/io/BufferedOutputStream:flush	()V
    //   36: aload_1
    //   37: ifnull +7 -> 44
    //   40: aload_1
    //   41: invokevirtual 168	java/io/BufferedOutputStream:close	()V
    //   44: return
    //   45: astore_0
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 168	java/io/BufferedOutputStream:close	()V
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
    if (QLog.isColorLevel()) {
      QLog.d("miniapp-embedded-live-pusher", 2, "enterBackground");
    }
    if (this.livePusherJSAdapter != null) {
      this.livePusherJSAdapter.enterBackground(false);
    }
    return true;
  }
  
  public boolean enterForeground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("miniapp-embedded-live-pusher", 2, "enterForeground");
    }
    if (this.livePusherJSAdapter != null) {
      this.livePusherJSAdapter.enterForeground();
    }
    return true;
  }
  
  public AppBrandRuntime getAppBrandRuntime()
  {
    return (AppBrandRuntime)this.curAppBrandRuntime;
  }
  
  public void handleInsertXWebLivePusher(JSONObject paramJSONObject, JsRuntime paramJsRuntime, BaseAppBrandRuntime paramBaseAppBrandRuntime)
  {
    this.callBackWebview = paramJsRuntime;
    this.curAppBrandRuntime = paramBaseAppBrandRuntime;
    this.curPageWebviewId = paramJsRuntime.getPageWebViewId();
    if (paramJSONObject != null)
    {
      QLog.d("miniapp-embedded-live-pusher", 2, "handleInsertXWebLivePusher : " + paramJSONObject.toString());
      this.viewId = paramJSONObject.optInt("viewId");
      if (paramJSONObject.has("position"))
      {
        paramBaseAppBrandRuntime = paramJSONObject.optJSONObject("position");
        this.width = ((int)(DisplayUtil.getDensity(this.callBackWebview.getContextEx()) * paramBaseAppBrandRuntime.optInt("width", -1) + 0.5F));
        float f = DisplayUtil.getDensity(this.callBackWebview.getContextEx());
        this.height = ((int)(paramBaseAppBrandRuntime.optInt("height", -1) * f + 0.5F));
      }
      this.livePusherJSAdapter = new TXLivePusherJSAdapter(this.curAppBrandRuntime.activity);
      this.livePusherJSAdapter.setSurface(this.mSurface);
      this.livePusherJSAdapter.setSurfaceSize(this.width, this.height);
      this.livePusherJSAdapter.initEmbeddedLivePusher(paramJSONObject);
      this.livePusherJSAdapter.setBGMNotifyListener(new LivePusherEmbeddedWidgetClient.2(this, paramJsRuntime));
      this.livePusherJSAdapter.setPushListener(new LivePusherEmbeddedWidgetClient.3(this, paramJsRuntime));
    }
  }
  
  public void handleOperateXWebLivePusher(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt)
  {
    QLog.d("miniapp-embedded-live-pusher", 2, "handleOperateXWebLivePusher : " + paramJSONObject.toString());
    int i = paramJSONObject.optInt("viewId", -1);
    Object localObject1;
    Object localObject2;
    if ((i == this.viewId) && (paramJSONObject.has("type")))
    {
      localObject1 = paramJSONObject.optString("type");
      if (this.livePusherJSAdapter != null)
      {
        if (!"playBGM".equals(localObject1)) {
          break label186;
        }
        this.needToStopDownloadBGM = false;
        String str1 = String.valueOf(this.downloadTaskId.getAndIncrement());
        localObject2 = paramJSONObject.optString("url");
        this.downloadMap.put(str1, localObject2);
        String str2 = MiniAppFileManager.getInstance().getTmpPathByUrl((String)localObject2);
        MiniappDownloadUtil.getInstance().download((String)localObject2, str2, true, new LivePusherEmbeddedWidgetClient.4(this, str1, (String)localObject2, i, paramJsRuntime, str2, paramJSONObject, (String)localObject1), Downloader.DownloadMode.FastMode, null);
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePusher", null).toString());
      }
    }
    return;
    label186:
    if ("stopBGM".equals(localObject1))
    {
      this.needToStopDownloadBGM = true;
      this.livePusherJSAdapter.operateLivePusher((String)localObject1, paramJSONObject);
      paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePusher", null).toString());
      return;
    }
    if ("setBGMPosition".equals(localObject1)) {
      try
      {
        paramJSONObject.put("BGMPosition", paramJSONObject.getInt("position") * 1000);
        this.livePusherJSAdapter.operateLivePusher((String)localObject1, paramJSONObject);
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePusher", null).toString());
        return;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          QLog.e("miniapp-embedded-live-pusher", 1, "setBGMPosition - JSONException:" + paramJSONObject);
        }
      }
    }
    if ("snapshot".equals(localObject1))
    {
      boolean bool2 = false;
      paramJSONObject = paramJSONObject.optString("quality");
      boolean bool1 = bool2;
      if (paramJSONObject != null)
      {
        bool1 = bool2;
        if (paramJSONObject.equalsIgnoreCase("compressed")) {
          bool1 = true;
        }
      }
      takePhoto(paramJsRuntime, "operateXWebLivePusher", bool1, paramInt);
      return;
    }
    if (((String)localObject1).equalsIgnoreCase("startAudioRecord"))
    {
      localObject1 = MiniAppFileManager.getInstance().getTmpPath("pcm");
      long l = paramJSONObject.optLong("maxDuration");
      QLog.d("miniapp-embedded-live-pusher", 2, "recordFile:" + (String)localObject1);
      i = this.livePusherJSAdapter.startDumpAudioData((String)localObject1);
      QLog.d("miniapp-embedded-live-pusher", 2, "recordResult:" + i);
      if (i == 0) {
        localObject2 = new JSONObject();
      }
      for (;;)
      {
        try
        {
          paramJSONObject = MiniAppFileManager.getInstance().getWxFilePath((String)localObject1);
          ((JSONException)localObject1).printStackTrace();
        }
        catch (JSONException localJSONException3)
        {
          try
          {
            QLog.d("miniapp-embedded-live-pusher", 2, "recordFile transformed:" + paramJSONObject);
            ((JSONObject)localObject2).put("tempFilePath", paramJSONObject);
            this.tempAudioFilePath = paramJSONObject;
            paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePusher", (JSONObject)localObject2).toString());
            this.handler.postDelayed(this.stopDumpRunnable, l);
            QLog.d("miniapp-embedded-live-pusher", 2, "recordResult:" + i);
            return;
          }
          catch (JSONException localJSONException2)
          {
            break label607;
          }
          localJSONException3 = localJSONException3;
          paramJSONObject = (JSONObject)localObject1;
          localObject1 = localJSONException3;
        }
        label607:
        continue;
        if (i == -1)
        {
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("operateXWebLivePusher", null, "LivePusher is recording").toString());
          return;
        }
        if (i == -2) {
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("operateXWebLivePusher", null, "LivePusher creates recordFile failed").toString());
        } else if (i == -3) {
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("operateXWebLivePusher", null, "LivePusher not support current format").toString());
        } else {
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("operateXWebLivePusher", null, "LivePusher starts recording fail").toString());
        }
      }
    }
    if (((String)localObject1).equalsIgnoreCase("stopAudioRecord"))
    {
      QLog.d("miniapp-embedded-live-pusher", 2, "stopDumpAudioData");
      this.handler.removeCallbacks(this.stopDumpRunnable);
      this.livePusherJSAdapter.stopDumpAudioData();
      paramJSONObject = new JSONObject();
      try
      {
        if (!StringUtil.isEmpty(this.tempAudioFilePath))
        {
          paramJSONObject.put("tempFilePath", this.tempAudioFilePath);
          this.tempAudioFilePath = null;
        }
        for (;;)
        {
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePusher", paramJSONObject).toString());
          return;
          paramJSONObject.put("tempFilePath", "");
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localJSONException1.printStackTrace();
        }
      }
    }
    this.livePusherJSAdapter.operateLivePusher(localJSONException1, paramJSONObject);
    paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePusher", null).toString());
  }
  
  public void handleRemoveXWebLivePusher()
  {
    release();
  }
  
  public void handleUpdateXWebLivePusher(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      QLog.d("miniapp-embedded-live-pusher", 2, "handleUpdateXWebLivePusher : " + paramJSONObject.toString());
      if (paramJSONObject.has("position"))
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
        this.width = ((int)(DisplayUtil.getDensity(this.callBackWebview.getContextEx()) * localJSONObject.optInt("width", -1) + 0.5F));
        float f = DisplayUtil.getDensity(this.callBackWebview.getContextEx());
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
    QLog.i("miniapp-embedded-live-pusher", 1, "LivePusherEmbeddedWidgetClient.nativeDestroy " + this);
    release();
  }
  
  public void nativePause()
  {
    QLog.i("miniapp-embedded-live-pusher", 1, "LivePusherEmbeddedWidgetClient.nativePause " + this);
    enterBackground();
  }
  
  public void nativeResume()
  {
    QLog.i("miniapp-embedded-live-pusher", 1, "LivePusherEmbeddedWidgetClient.nativeResume " + this);
    enterForeground();
  }
  
  public void onActive()
  {
    QLog.i("miniapp-embedded-live-pusher", 2, "LivePusherEmbeddedWidgetClient.onActive");
  }
  
  public void onDeactive()
  {
    QLog.i("miniapp-embedded-live-pusher", 2, "LivePusherEmbeddedWidgetClient.onDeactive");
  }
  
  public void onDestroy()
  {
    QLog.i("miniapp-embedded-live-pusher", 2, "LivePusherEmbeddedWidgetClient.onDestroy");
    release();
  }
  
  public void onRectChanged(Rect paramRect)
  {
    QLog.i("miniapp-embedded-live-pusher", 2, "LivePusherEmbeddedWidgetClient.onRectChanged, rect:" + paramRect.toString() + "； size : " + (paramRect.right - paramRect.left) + "," + (paramRect.bottom - paramRect.top));
  }
  
  public void onRequestRedraw()
  {
    QLog.i("miniapp-embedded-live-pusher", 2, "LivePusherEmbeddedWidgetClient.onRequestRedraw");
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    QLog.d("miniapp-embedded-live-pusher", 1, "onSurfaceCreated: " + paramSurface);
    if ((paramSurface == null) || (!paramSurface.isValid()))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onSurfaceCreated isValid() : ");
      if (paramSurface != null)
      {
        paramSurface = Boolean.valueOf(paramSurface.isValid());
        QLog.e("miniapp-embedded-live-pusher", 1, paramSurface);
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
    QLog.i("miniapp-embedded-live-pusher", 2, "LivePusherEmbeddedWidgetClient.onSurfaceDestroyed");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    QLog.i("miniapp-embedded-live-pusher", 2, "LivePusherEmbeddedWidgetClient.onTouchEvent, rect:" + paramMotionEvent.toString());
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    QLog.i("miniapp-embedded-live-pusher", 2, "LivePusherEmbeddedWidgetClient.onVisibilityChanged ： " + paramBoolean);
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
  
  public void takePhoto(JsRuntime paramJsRuntime, String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.livePusherJSAdapter == null) {
      return;
    }
    this.livePusherJSAdapter.takePhoto(paramBoolean, new LivePusherEmbeddedWidgetClient.5(this, paramString, paramJsRuntime, paramInt));
  }
  
  public void webViewDestory()
  {
    QLog.i("miniapp-embedded-live-pusher", 1, "LivePusherEmbeddedWidgetClient.webviewDestory " + this);
    release();
  }
  
  public void webViewPause()
  {
    QLog.i("miniapp-embedded-live-pusher", 1, "LivePusherEmbeddedWidgetClient.webviewPause " + this);
    enterBackground();
  }
  
  public void webViewResume()
  {
    QLog.i("miniapp-embedded-live-pusher", 1, "LivePusherEmbeddedWidgetClient.webviewResume " + this);
    enterForeground();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.LivePusherEmbeddedWidgetClient
 * JD-Core Version:    0.7.0.1
 */