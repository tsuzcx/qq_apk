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
      ((IJsService)localObject).evaluateSubscribeJS(paramString1, paramString2, this.curPageWebviewId);
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
    //   0: aconst_null
    //   1: astore_2
    //   2: new 114	java/io/BufferedOutputStream
    //   5: dup
    //   6: new 116	java/io/FileOutputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   14: invokespecial 122	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   17: astore_1
    //   18: aload_0
    //   19: getstatic 128	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   22: bipush 100
    //   24: bipush 100
    //   26: invokestatic 134	java/lang/Math:min	(II)I
    //   29: aload_1
    //   30: invokevirtual 140	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   33: pop
    //   34: aload_1
    //   35: invokevirtual 143	java/io/BufferedOutputStream:flush	()V
    //   38: aload_1
    //   39: invokevirtual 146	java/io/BufferedOutputStream:close	()V
    //   42: return
    //   43: astore_0
    //   44: goto +6 -> 50
    //   47: astore_0
    //   48: aload_2
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull +7 -> 58
    //   54: aload_1
    //   55: invokevirtual 146	java/io/BufferedOutputStream:close	()V
    //   58: aload_0
    //   59: athrow
    //   60: astore_0
    //   61: return
    //   62: astore_1
    //   63: goto -5 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	paramBitmap	android.graphics.Bitmap
    //   0	66	1	paramFile	java.io.File
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
    Object localObject = this.livePlayerJSAdapter;
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((TXLivePlayerJSAdapter)localObject).enterBackground(2);
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterBackground: ");
      localStringBuilder.append(localObject);
      QMLog.d("miniapp-embedded-live-player", localStringBuilder.toString());
    }
    if (((TXJSAdapterError)localObject).errorCode == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean enterForeground()
  {
    Object localObject = this.livePlayerJSAdapter;
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((TXLivePlayerJSAdapter)localObject).enterForeground();
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterForeground: ");
      localStringBuilder.append(localObject);
      QMLog.d("miniapp-embedded-live-player", localStringBuilder.toString());
    }
    if (((TXJSAdapterError)localObject).errorCode == 0) {
      bool = true;
    }
    return bool;
  }
  
  public IMiniAppContext getMiniAppContext()
  {
    return this.mMiniAppContext;
  }
  
  public int getViewId()
  {
    return this.viewId;
  }
  
  public void handleInsertXWebLivePlayer(JSONObject paramJSONObject, IJsService paramIJsService)
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
      QMLog.e("miniapp-embedded-live-player", localStringBuilder.toString());
    }
    if (paramJSONObject != null)
    {
      paramIJsService = new StringBuilder();
      paramIJsService.append("handleInsertXWebLivePlayer : ");
      paramIJsService.append(paramJSONObject.toString());
      QMLog.d("miniapp-embedded-live-player", paramIJsService.toString());
      this.viewId = paramJSONObject.optInt("viewId");
      if (paramJSONObject.has("position"))
      {
        paramIJsService = paramJSONObject.optJSONObject("position");
        this.width = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramIJsService.optInt("width", -1) + 0.5F));
        this.height = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramIJsService.optInt("height", -1) + 0.5F));
      }
      this.livePlayerJSAdapter = new TXLivePlayerJSAdapter(AppLoaderFactory.g().getContext());
      this.livePlayerJSAdapter.initEmbeddedLivePlayer(paramJSONObject);
      this.livePlayerJSAdapter.setPlayListener(getPlayerListener());
      this.livePlayerJSAdapter.setItxAudioVolumeEvaluationOuterListener(getAudioVolumeEvaluationListener());
      this.livePlayerJSAdapter.setSurface(this.mSurface);
      this.livePlayerJSAdapter.setSurfaceSize(this.width, this.height);
    }
  }
  
  public void handleOperateXWebLivePlayer(JSONObject paramJSONObject, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleOperateXWebLivePlayer : ");
    ((StringBuilder)localObject).append(paramJSONObject.toString());
    QMLog.d("miniapp-embedded-live-player", ((StringBuilder)localObject).toString());
    if ((paramJSONObject.optInt("viewId", -1) == this.viewId) && (paramJSONObject.has("type")))
    {
      localObject = paramJSONObject.optString("type");
      if ("snapshot".equalsIgnoreCase((String)localObject))
      {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramJSONObject != null)
        {
          String str = paramJSONObject.optString("quality");
          bool1 = bool2;
          if (str != null)
          {
            bool1 = bool2;
            if (str.equalsIgnoreCase("compressed")) {
              bool1 = true;
            }
          }
        }
        takePhoto("operateXWebLivePlayer", bool1, paramInt);
      }
      this.livePlayerJSAdapter.operateLivePlayer((String)localObject, paramJSONObject);
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleUpdateXWebLivePlayer : ");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QMLog.d("miniapp-embedded-live-player", ((StringBuilder)localObject).toString());
      if (paramJSONObject.has("position"))
      {
        localObject = paramJSONObject.optJSONObject("position");
        this.width = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * ((JSONObject)localObject).optInt("width", -1) + 0.5F));
        this.height = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * ((JSONObject)localObject).optInt("height", -1) + 0.5F));
        this.livePlayerJSAdapter.setSurfaceSize(this.width, this.height);
      }
      localObject = this.livePlayerJSAdapter;
      if (localObject != null) {
        ((TXLivePlayerJSAdapter)localObject).updateLivePlayer(paramJSONObject);
      }
    }
  }
  
  public void nativeDestroy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePlayerEmbeddedWidgetClient.nativeDestroy ");
    localStringBuilder.append(this);
    QMLog.i("miniapp-embedded-live-player", localStringBuilder.toString());
    release();
  }
  
  public void nativePause()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePlayerEmbeddedWidgetClient.nativePause ");
    localStringBuilder.append(this);
    QMLog.i("miniapp-embedded-live-player", localStringBuilder.toString());
    if (!this.isPageBackground) {
      this.isPageBackground = enterBackground();
    }
  }
  
  public void nativeResume()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePlayerEmbeddedWidgetClient.nativeResume ");
    localStringBuilder.append(this);
    QMLog.i("miniapp-embedded-live-player", localStringBuilder.toString());
    if (this.isPageBackground) {
      this.isPageBackground = (enterForeground() ^ true);
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
    release();
  }
  
  public void onRectChanged(Rect paramRect)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePlayerEmbeddedWidgetClient.onRectChanged, rect:");
    localStringBuilder.append(paramRect.toString());
    localStringBuilder.append("； size : ");
    localStringBuilder.append(paramRect.right - paramRect.left);
    localStringBuilder.append(",");
    localStringBuilder.append(paramRect.bottom - paramRect.top);
    QMLog.i("miniapp-embedded-live-player", localStringBuilder.toString());
  }
  
  public void onRequestRedraw()
  {
    QMLog.i("miniapp-embedded-live-player", "LivePlayerEmbeddedWidgetClient.onRequestRedraw");
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceCreated: ");
    localStringBuilder.append(paramSurface);
    QMLog.d("miniapp-embedded-live-player", localStringBuilder.toString());
    if ((paramSurface != null) && (paramSurface.isValid()))
    {
      this.mSurface = paramSurface;
      paramSurface = this.livePlayerJSAdapter;
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
    QMLog.e("miniapp-embedded-live-player", localStringBuilder.toString());
  }
  
  public void onSurfaceDestroyed(Surface paramSurface)
  {
    QMLog.i("miniapp-embedded-live-player", "LivePlayerEmbeddedWidgetClient.onSurfaceDestroyed");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePlayerEmbeddedWidgetClient.onTouchEvent, rect:");
    localStringBuilder.append(paramMotionEvent.toString());
    QMLog.i("miniapp-embedded-live-player", localStringBuilder.toString());
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePlayerEmbeddedWidgetClient.onVisibilityChanged ： ");
    localStringBuilder.append(paramBoolean);
    QMLog.i("miniapp-embedded-live-player", localStringBuilder.toString());
  }
  
  public void release()
  {
    TXLivePlayerJSAdapter localTXLivePlayerJSAdapter = this.livePlayerJSAdapter;
    if (localTXLivePlayerJSAdapter != null)
    {
      localTXLivePlayerJSAdapter.uninitLivePlayer();
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
  
  public void webViewDestroy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePlayerEmbeddedWidgetClient.webViewDestroy ");
    localStringBuilder.append(this);
    QMLog.i("miniapp-embedded-live-player", localStringBuilder.toString());
    release();
  }
  
  public void webViewPause()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePlayerEmbeddedWidgetClient.webviewPause ");
    localStringBuilder.append(this);
    QMLog.i("miniapp-embedded-live-player", localStringBuilder.toString());
    if (!this.isPageBackground) {
      this.isPageBackground = enterBackground();
    }
  }
  
  public void webViewResume()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePlayerEmbeddedWidgetClient.webviewResume ");
    localStringBuilder.append(this);
    QMLog.i("miniapp-embedded-live-player", localStringBuilder.toString());
    if (this.isPageBackground) {
      this.isPageBackground = (enterForeground() ^ true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePlayerEmbeddedWidgetClient
 * JD-Core Version:    0.7.0.1
 */