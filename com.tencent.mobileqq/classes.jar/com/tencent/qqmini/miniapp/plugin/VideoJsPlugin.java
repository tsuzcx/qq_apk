package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy.Bridge;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

@JsPlugin
public class VideoJsPlugin
  extends BaseJsPlugin
  implements VideoJsProxy.Bridge
{
  public static final String API_CHOOSE_VIDEO = "chooseVideo";
  public static final String API_SAVE_VIDEO_TO_ALBUM = "saveVideoToPhotosAlbum";
  public static final String TAG = "VideoJsPlugin";
  private ConcurrentHashMap<Integer, RequestEvent> bridgeMap;
  private VideoJsProxy mImpl = (VideoJsProxy)ProxyManager.get(VideoJsProxy.class);
  private ToastView toastView;
  
  @JsEvent({"chooseVideo"})
  public void chooseVideo(RequestEvent paramRequestEvent)
  {
    try
    {
      this.mImpl.chooseVideo(this.mMiniAppContext.getAttachedActivity(), paramRequestEvent.event, paramRequestEvent.jsonParams, paramRequestEvent.callbackId);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("VideoJsPlugin", paramRequestEvent.event + " error,", localThrowable);
      paramRequestEvent.fail();
    }
  }
  
  public void hideLoading()
  {
    AppBrandTask.runTaskOnUiThread(new VideoJsPlugin.3(this));
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    this.mImpl.setResponseListener(this);
    this.bridgeMap = new ConcurrentHashMap();
    this.mImpl.create(paramIMiniAppContext);
  }
  
  public void onDestroy()
  {
    if (this.mImpl != null) {
      this.mImpl.destroy();
    }
    if (this.bridgeMap != null) {
      this.bridgeMap.clear();
    }
    super.onDestroy();
  }
  
  public boolean onInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    QMLog.d("VideoJsPlugin", "onInterceptJsEvent event=" + paramRequestEvent.event + ",jsonParams=" + paramRequestEvent.jsonParams + ",callbackId=" + paramRequestEvent.callbackId + ",webview=" + paramRequestEvent.jsService);
    if (this.bridgeMap != null) {
      this.bridgeMap.put(Integer.valueOf(paramRequestEvent.callbackId), paramRequestEvent);
    }
    return super.onInterceptJsEvent(paramRequestEvent);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void responseCancel(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (this.bridgeMap != null)
    {
      paramString = (RequestEvent)this.bridgeMap.get(Integer.valueOf(paramInt));
      if (paramString != null) {
        paramString.cancel(paramJSONObject);
      }
    }
  }
  
  public void responseFail(int paramInt, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if (this.bridgeMap != null)
    {
      paramString1 = (RequestEvent)this.bridgeMap.get(Integer.valueOf(paramInt));
      if (paramString1 != null) {
        paramString1.fail(paramString2);
      }
    }
  }
  
  public void responseOk(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (this.bridgeMap != null)
    {
      paramString = (RequestEvent)this.bridgeMap.get(Integer.valueOf(paramInt));
      if (paramString != null) {
        paramString.ok(paramJSONObject);
      }
    }
  }
  
  @JsEvent({"saveVideoToPhotosAlbum"})
  public void saveVideoToPhotosAlbum(RequestEvent paramRequestEvent)
  {
    try
    {
      this.mImpl.saveVideoToPhotosAlbum(this.mMiniAppContext.getAttachedActivity(), paramRequestEvent.event, paramRequestEvent.jsonParams, paramRequestEvent.callbackId);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("VideoJsPlugin", paramRequestEvent.event + " error,", localThrowable);
      paramRequestEvent.fail();
    }
  }
  
  public void sendNativeViewEvent(RequestEvent paramRequestEvent, int paramInt)
  {
    super.sendNativeViewEvent(paramRequestEvent, paramInt);
  }
  
  public void sendSubscribeEvent(String paramString1, String paramString2)
  {
    super.sendSubscribeEvent(paramString1, paramString2);
  }
  
  public void showLoading(String paramString)
  {
    QMLog.i("VideoJsPlugin", "showLoading " + paramString);
    AppBrandTask.runTaskOnUiThread(new VideoJsPlugin.1(this, paramString));
  }
  
  public void updateLoading(String paramString)
  {
    AppBrandTask.runTaskOnUiThread(new VideoJsPlugin.2(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoJsPlugin
 * JD-Core Version:    0.7.0.1
 */