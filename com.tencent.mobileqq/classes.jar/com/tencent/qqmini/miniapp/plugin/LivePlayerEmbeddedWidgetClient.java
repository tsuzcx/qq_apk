package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.qqmini.miniapp.core.page.BrandPageWebview;
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterError;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.IPlayOuterListener;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import java.util.Map;
import org.json.JSONObject;

public class LivePlayerEmbeddedWidgetClient
  implements IExtendedEmbeddedWidgetClient
{
  private static final String TAG = "miniapp-embedded-live-player";
  public static volatile boolean mIsInited = false;
  private IJsService callBackWebview;
  private int curPageWebviewId;
  private int height = -1;
  private boolean isPageBackground;
  private TXLivePlayerJSAdapter livePlayerJSAdapter;
  private Map<String, String> mAttributes;
  private IMiniAppContext mMiniAppContext;
  private Surface mSurface = null;
  private String mTagName;
  private IEmbeddedWidget mWidget;
  private int viewId = -1;
  private int width = -1;
  
  public LivePlayerEmbeddedWidgetClient(IMiniAppContext paramIMiniAppContext, String paramString, Map<String, String> paramMap, IEmbeddedWidget paramIEmbeddedWidget)
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
  
  private TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener getAudioVolumeEvaluationListener()
  {
    return new LivePlayerEmbeddedWidgetClient.1(this);
  }
  
  private TXLivePlayerJSAdapter.IPlayOuterListener getPlayerListener()
  {
    return new LivePlayerEmbeddedWidgetClient.2(this);
  }
  
  /* Error */
  private static void saveJpeg(android.graphics.Bitmap paramBitmap, java.io.File paramFile)
  {
    // Byte code:
    //   0: new 115	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 117	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 123	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_1
    //   16: aload_0
    //   17: getstatic 129	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   20: bipush 100
    //   22: bipush 100
    //   24: invokestatic 135	java/lang/Math:min	(II)I
    //   27: aload_1
    //   28: invokevirtual 141	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_1
    //   33: invokevirtual 144	java/io/BufferedOutputStream:flush	()V
    //   36: aload_1
    //   37: ifnull +7 -> 44
    //   40: aload_1
    //   41: invokevirtual 147	java/io/BufferedOutputStream:close	()V
    //   44: return
    //   45: astore_0
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 147	java/io/BufferedOutputStream:close	()V
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
      if (QMLog.isColorLevel()) {
        QMLog.d("miniapp-embedded-live-player", "enterBackground: " + localTXJSAdapterError);
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
      if (QMLog.isColorLevel()) {
        QMLog.d("miniapp-embedded-live-player", "enterForeground: " + localTXJSAdapterError);
      }
    } while (localTXJSAdapterError.errorCode != 0);
    return true;
  }
  
  public IMiniAppContext getMiniAppContext()
  {
    return this.mMiniAppContext;
  }
  
  public void handleInsertXWebLivePlayer(JSONObject paramJSONObject, IJsService paramIJsService)
  {
    this.callBackWebview = paramIJsService;
    if ((paramIJsService instanceof BrandPageWebview)) {
      this.curPageWebviewId = ((BrandPageWebview)paramIJsService).getWebViewId();
    }
    for (;;)
    {
      if (paramJSONObject != null)
      {
        QMLog.d("miniapp-embedded-live-player", "handleInsertXWebLivePlayer : " + paramJSONObject.toString());
        this.viewId = paramJSONObject.optInt("viewId");
        if (paramJSONObject.has("position"))
        {
          paramIJsService = paramJSONObject.optJSONObject("position");
          this.width = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramIJsService.optInt("width", -1) + 0.5F));
          float f = DisplayUtil.getDensity(AppLoaderFactory.g().getContext());
          this.height = ((int)(paramIJsService.optInt("height", -1) * f + 0.5F));
        }
        this.livePlayerJSAdapter = new TXLivePlayerJSAdapter(AppLoaderFactory.g().getContext());
        this.livePlayerJSAdapter.initEmbeddedLivePlayer(paramJSONObject);
        this.livePlayerJSAdapter.setPlayListener(getPlayerListener());
        this.livePlayerJSAdapter.setItxAudioVolumeEvaluationOuterListener(getAudioVolumeEvaluationListener());
        this.livePlayerJSAdapter.setSurface(this.mSurface);
        this.livePlayerJSAdapter.setSurfaceSize(this.width, this.height);
      }
      return;
      QMLog.e("miniapp-embedded-live-player", "cant get webviewId from " + paramIJsService);
    }
  }
  
  public void handleOperateXWebLivePlayer(JSONObject paramJSONObject, int paramInt)
  {
    QMLog.d("miniapp-embedded-live-player", "handleOperateXWebLivePlayer : " + paramJSONObject.toString());
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
        takePhoto("operateXWebLivePlayer", bool1, paramInt);
      }
      this.livePlayerJSAdapter.operateLivePlayer(str1, paramJSONObject);
      evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebLivePlayer", new JSONObject()).toString());
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
      QMLog.d("miniapp-embedded-live-player", "handleUpdateXWebLivePlayer : " + paramJSONObject.toString());
      if (paramJSONObject.has("position"))
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
        this.width = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * localJSONObject.optInt("width", -1) + 0.5F));
        float f = DisplayUtil.getDensity(AppLoaderFactory.g().getContext());
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
    QMLog.i("miniapp-embedded-live-player", "LivePlayerEmbeddedWidgetClient.nativeDestroy " + this);
    release();
  }
  
  public void nativePause()
  {
    QMLog.i("miniapp-embedded-live-player", "LivePlayerEmbeddedWidgetClient.nativePause " + this);
    if (!this.isPageBackground) {
      this.isPageBackground = enterBackground();
    }
  }
  
  public void nativeResume()
  {
    QMLog.i("miniapp-embedded-live-player", "LivePlayerEmbeddedWidgetClient.nativeResume " + this);
    if (this.isPageBackground) {
      if (enterForeground()) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      this.isPageBackground = bool;
      return;
    }
  }
  
  public void onActive()
  {
    QMLog.i("miniapp-embedded-live-player", "LivePlayerEmbeddedWidgetClient.onActive");
  }
  
  public void onDeactive()
  {
    QMLog.i("miniapp-embedded-live-player", "LivePlayerEmbeddedWidgetClient.onDeactive");
  }
  
  public void onDestroy()
  {
    QMLog.i("miniapp-embedded-live-player", "LivePlayerEmbeddedWidgetClient.onDestroy");
  }
  
  public void onRectChanged(Rect paramRect)
  {
    QMLog.i("miniapp-embedded-live-player", "LivePlayerEmbeddedWidgetClient.onRectChanged, rect:" + paramRect.toString() + "； size : " + (paramRect.right - paramRect.left) + "," + (paramRect.bottom - paramRect.top));
  }
  
  public void onRequestRedraw()
  {
    QMLog.i("miniapp-embedded-live-player", "LivePlayerEmbeddedWidgetClient.onRequestRedraw");
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    QMLog.d("miniapp-embedded-live-player", "onSurfaceCreated: " + paramSurface);
    if ((paramSurface == null) || (!paramSurface.isValid()))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onSurfaceCreated isValid() : ");
      if (paramSurface != null)
      {
        paramSurface = Boolean.valueOf(paramSurface.isValid());
        QMLog.e("miniapp-embedded-live-player", paramSurface);
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
    QMLog.i("miniapp-embedded-live-player", "LivePlayerEmbeddedWidgetClient.onSurfaceDestroyed");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    QMLog.i("miniapp-embedded-live-player", "LivePlayerEmbeddedWidgetClient.onTouchEvent, rect:" + paramMotionEvent.toString());
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    QMLog.i("miniapp-embedded-live-player", "LivePlayerEmbeddedWidgetClient.onVisibilityChanged ： " + paramBoolean);
  }
  
  public void release()
  {
    if (this.livePlayerJSAdapter != null)
    {
      this.livePlayerJSAdapter.uninitLivePlayer();
      this.livePlayerJSAdapter.setSurface(null);
    }
  }
  
  public void takePhoto(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.livePlayerJSAdapter == null) {
      return;
    }
    QMLog.e("miniapp-embedded-live-player", "takePhoto invoke");
    this.livePlayerJSAdapter.setSnapshotListener(new LivePlayerEmbeddedWidgetClient.3(this, paramString, paramInt));
    this.livePlayerJSAdapter.takePhoto(paramBoolean);
  }
  
  public void webViewDestory()
  {
    QMLog.i("miniapp-embedded-live-player", "LivePlayerEmbeddedWidgetClient.webviewDestory " + this);
    release();
  }
  
  public void webViewPause()
  {
    QMLog.i("miniapp-embedded-live-player", "LivePlayerEmbeddedWidgetClient.webviewPause " + this);
    if (!this.isPageBackground) {
      this.isPageBackground = enterBackground();
    }
  }
  
  public void webViewResume()
  {
    QMLog.i("miniapp-embedded-live-player", "LivePlayerEmbeddedWidgetClient.webviewResume " + this);
    if (this.isPageBackground) {
      if (enterForeground()) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      this.isPageBackground = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePlayerEmbeddedWidgetClient
 * JD-Core Version:    0.7.0.1
 */