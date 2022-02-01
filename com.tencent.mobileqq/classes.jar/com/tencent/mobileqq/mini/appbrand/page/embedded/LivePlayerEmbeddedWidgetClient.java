package com.tencent.mobileqq.mini.appbrand.page.embedded;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.media.live.TXJSAdapterError;
import com.tencent.mobileqq.mini.widget.media.live.TXLivePlayerJSAdapter;
import com.tencent.mobileqq.mini.widget.media.live.TXLivePlayerJSAdapter.IPlayOuterListener;
import com.tencent.mobileqq.mini.widget.media.live.TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class LivePlayerEmbeddedWidgetClient
  implements IExtendedEmbeddedWidgetClient
{
  private static final String TAG = "miniapp-embedded-live-player";
  public static volatile boolean mIsInited;
  private JsRuntime callBackWebview;
  private BaseAppBrandRuntime curAppBrandRuntime;
  private int curPageWebviewId;
  private int height = -1;
  private boolean isPageBackground;
  private TXLivePlayerJSAdapter livePlayerJSAdapter;
  private Map<String, String> mAttributes;
  private Surface mSurface;
  private String mTagName;
  private IEmbeddedWidget mWidget;
  private int viewId = -1;
  private int width = -1;
  
  public LivePlayerEmbeddedWidgetClient(String paramString, Map<String, String> paramMap, IEmbeddedWidget paramIEmbeddedWidget)
  {
    this.mTagName = paramString;
    this.mAttributes = paramMap;
    this.mWidget = paramIEmbeddedWidget;
  }
  
  @NotNull
  private TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener getAudioVolumeEvaluationListener()
  {
    return new LivePlayerEmbeddedWidgetClient.1(this);
  }
  
  @NotNull
  private TXLivePlayerJSAdapter.IPlayOuterListener getLivePlayListener()
  {
    return new LivePlayerEmbeddedWidgetClient.2(this);
  }
  
  /* Error */
  private static void saveJpeg(android.graphics.Bitmap paramBitmap, java.io.File paramFile)
  {
    // Byte code:
    //   0: new 88	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 90	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 96	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_1
    //   16: aload_0
    //   17: getstatic 102	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   20: bipush 100
    //   22: bipush 100
    //   24: invokestatic 108	java/lang/Math:min	(II)I
    //   27: aload_1
    //   28: invokevirtual 114	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_1
    //   33: invokevirtual 117	java/io/BufferedOutputStream:flush	()V
    //   36: aload_1
    //   37: ifnull +7 -> 44
    //   40: aload_1
    //   41: invokevirtual 120	java/io/BufferedOutputStream:close	()V
    //   44: return
    //   45: astore_0
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 120	java/io/BufferedOutputStream:close	()V
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
    if (this.livePlayerJSAdapter == null) {}
    TXJSAdapterError localTXJSAdapterError;
    do
    {
      return false;
      localTXJSAdapterError = this.livePlayerJSAdapter.enterBackground(2);
      if (QLog.isColorLevel()) {
        QLog.d("miniapp-embedded-live-player", 2, "enterBackground: " + localTXJSAdapterError);
      }
    } while (localTXJSAdapterError.errorCode != 0);
    return true;
  }
  
  public boolean enterForeground()
  {
    if (this.livePlayerJSAdapter == null) {}
    TXJSAdapterError localTXJSAdapterError;
    do
    {
      return false;
      localTXJSAdapterError = this.livePlayerJSAdapter.enterForeground();
      if (QLog.isColorLevel()) {
        QLog.d("miniapp-embedded-live-player", 2, "enterForeground: " + localTXJSAdapterError);
      }
    } while (localTXJSAdapterError.errorCode != 0);
    return true;
  }
  
  public AppBrandRuntime getAppBrandRuntime()
  {
    return (AppBrandRuntime)this.curAppBrandRuntime;
  }
  
  public void handleInsertXWebLivePlayer(JSONObject paramJSONObject, JsRuntime paramJsRuntime, BaseAppBrandRuntime paramBaseAppBrandRuntime)
  {
    this.callBackWebview = paramJsRuntime;
    this.curAppBrandRuntime = paramBaseAppBrandRuntime;
    this.curPageWebviewId = paramJsRuntime.getPageWebViewId();
    if (paramJSONObject != null)
    {
      QLog.d("miniapp-embedded-live-player", 2, "handleInsertXWebLivePlayer : " + paramJSONObject.toString());
      this.viewId = paramJSONObject.optInt("viewId");
      if (paramJSONObject.has("position"))
      {
        paramJsRuntime = paramJSONObject.optJSONObject("position");
        this.width = ((int)(DisplayUtil.getDensity(this.callBackWebview.getContextEx()) * paramJsRuntime.optInt("width", -1) + 0.5F));
        float f = DisplayUtil.getDensity(this.callBackWebview.getContextEx());
        this.height = ((int)(paramJsRuntime.optInt("height", -1) * f + 0.5F));
      }
      this.livePlayerJSAdapter = new TXLivePlayerJSAdapter(this.curAppBrandRuntime.activity);
      this.livePlayerJSAdapter.initEmbeddedLivePlayer(paramJSONObject);
      this.livePlayerJSAdapter.setPlayListener(getLivePlayListener());
      this.livePlayerJSAdapter.setItxAudioVolumeEvaluationOuterListener(getAudioVolumeEvaluationListener());
      this.livePlayerJSAdapter.setSurface(this.mSurface);
      this.livePlayerJSAdapter.setSurfaceSize(this.width, this.height);
    }
  }
  
  public void handleOperateXWebLivePlayer(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt)
  {
    QLog.d("miniapp-embedded-live-player", 2, "handleOperateXWebLivePlayer : " + paramJSONObject.toString());
    if ((paramJSONObject.optInt("viewId", -1) == this.viewId) && (paramJSONObject.has("type")))
    {
      String str1 = paramJSONObject.optString("type");
      if ("snapshot".equalsIgnoreCase(str1))
      {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramJSONObject != null)
        {
          String str2 = paramJSONObject.optString("quality");
          bool1 = bool2;
          if (str2 != null)
          {
            bool1 = bool2;
            if (str2.equalsIgnoreCase("compressed")) {
              bool1 = true;
            }
          }
        }
        takePhoto(paramJsRuntime, "operateXWebLivePlayer", bool1, paramInt);
      }
      this.livePlayerJSAdapter.operateLivePlayer(str1, paramJSONObject);
      paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePlayer", new JSONObject()).toString());
    }
  }
  
  public void handleRemoveXWebLivePlayer()
  {
    release();
  }
  
  public void handleUpdateXWebLivePlayer(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      QLog.d("miniapp-embedded-live-player", 2, "handleUpdateXWebLivePlayer : " + paramJSONObject.toString());
      if (paramJSONObject.has("position"))
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
        this.width = ((int)(DisplayUtil.getDensity(this.callBackWebview.getContextEx()) * localJSONObject.optInt("width", -1) + 0.5F));
        float f = DisplayUtil.getDensity(this.callBackWebview.getContextEx());
        this.height = ((int)(localJSONObject.optInt("height", -1) * f + 0.5F));
        this.livePlayerJSAdapter.setSurfaceSize(this.width, this.height);
      }
      if (this.livePlayerJSAdapter != null) {
        this.livePlayerJSAdapter.updateLivePlayer(paramJSONObject);
      }
    }
  }
  
  public void nativeDestroy()
  {
    QLog.i("miniapp-embedded-live-player", 1, "LivePlayerEmbeddedWidgetClient.nativeDestroy " + this);
    release();
  }
  
  public void nativePause()
  {
    QLog.i("miniapp-embedded-live-player", 1, "LivePlayerEmbeddedWidgetClient.nativePause " + this);
    if (!this.isPageBackground) {
      this.isPageBackground = enterBackground();
    }
  }
  
  public void nativeResume()
  {
    boolean bool = true;
    QLog.i("miniapp-embedded-live-player", 1, "LivePlayerEmbeddedWidgetClient.nativeResume " + this);
    if (this.isPageBackground) {
      if (enterForeground()) {
        break label48;
      }
    }
    for (;;)
    {
      this.isPageBackground = bool;
      return;
      label48:
      bool = false;
    }
  }
  
  public void onActive()
  {
    QLog.i("miniapp-embedded-live-player", 2, "LivePlayerEmbeddedWidgetClient.onActive");
  }
  
  public void onDeactive()
  {
    QLog.i("miniapp-embedded-live-player", 2, "LivePlayerEmbeddedWidgetClient.onDeactive");
  }
  
  public void onDestroy()
  {
    QLog.i("miniapp-embedded-live-player", 2, "LivePlayerEmbeddedWidgetClient.onDestroy");
  }
  
  public void onRectChanged(Rect paramRect)
  {
    QLog.i("miniapp-embedded-live-player", 2, "LivePlayerEmbeddedWidgetClient.onRectChanged, rect:" + paramRect.toString() + "； size : " + (paramRect.right - paramRect.left) + "," + (paramRect.bottom - paramRect.top));
  }
  
  public void onRequestRedraw()
  {
    QLog.i("miniapp-embedded-live-player", 2, "LivePlayerEmbeddedWidgetClient.onRequestRedraw");
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    QLog.d("miniapp-embedded-live-player", 1, "onSurfaceCreated: " + paramSurface);
    if ((paramSurface == null) || (!paramSurface.isValid()))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onSurfaceCreated isValid() : ");
      if (paramSurface != null)
      {
        paramSurface = Boolean.valueOf(paramSurface.isValid());
        QLog.e("miniapp-embedded-live-player", 1, paramSurface);
      }
    }
    do
    {
      return;
      paramSurface = null;
      break;
      this.mSurface = paramSurface;
    } while (this.livePlayerJSAdapter == null);
    this.livePlayerJSAdapter.setSurface(this.mSurface);
  }
  
  public void onSurfaceDestroyed(Surface paramSurface)
  {
    QLog.i("miniapp-embedded-live-player", 2, "LivePlayerEmbeddedWidgetClient.onSurfaceDestroyed");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    QLog.i("miniapp-embedded-live-player", 2, "LivePlayerEmbeddedWidgetClient.onTouchEvent, rect:" + paramMotionEvent.toString());
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    QLog.i("miniapp-embedded-live-player", 2, "LivePlayerEmbeddedWidgetClient.onVisibilityChanged ： " + paramBoolean);
  }
  
  public void release()
  {
    if (this.livePlayerJSAdapter != null)
    {
      this.livePlayerJSAdapter.uninitLivePlayer();
      this.livePlayerJSAdapter.setSurface(null);
    }
  }
  
  public void takePhoto(JsRuntime paramJsRuntime, String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.livePlayerJSAdapter == null) {
      return;
    }
    QLog.e("miniapp-embedded-live-player", 1, "takePhoto invoke");
    this.livePlayerJSAdapter.setSnapshotListener(new LivePlayerEmbeddedWidgetClient.3(this, paramString, paramJsRuntime, paramInt));
    this.livePlayerJSAdapter.takePhoto(paramBoolean);
  }
  
  public void webViewDestory()
  {
    QLog.i("miniapp-embedded-live-player", 1, "LivePlayerEmbeddedWidgetClient.webviewDestory " + this);
    release();
  }
  
  public void webViewPause()
  {
    QLog.i("miniapp-embedded-live-player", 1, "LivePlayerEmbeddedWidgetClient.webviewPause " + this);
    if (!this.isPageBackground) {
      this.isPageBackground = enterBackground();
    }
  }
  
  public void webViewResume()
  {
    boolean bool = true;
    QLog.i("miniapp-embedded-live-player", 1, "LivePlayerEmbeddedWidgetClient.webviewResume " + this);
    if (this.isPageBackground) {
      if (enterForeground()) {
        break label48;
      }
    }
    for (;;)
    {
      this.isPageBackground = bool;
      return;
      label48:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.LivePlayerEmbeddedWidgetClient
 * JD-Core Version:    0.7.0.1
 */