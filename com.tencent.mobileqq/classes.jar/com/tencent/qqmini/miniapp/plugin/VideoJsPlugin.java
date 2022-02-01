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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRequestEvent.event);
      localStringBuilder.append(" error,");
      QMLog.e("VideoJsPlugin", localStringBuilder.toString(), localThrowable);
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
    Object localObject = this.mImpl;
    if (localObject != null) {
      ((VideoJsProxy)localObject).destroy();
    }
    localObject = this.bridgeMap;
    if (localObject != null) {
      ((ConcurrentHashMap)localObject).clear();
    }
    super.onDestroy();
  }
  
  public boolean onInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onInterceptJsEvent event=");
    ((StringBuilder)localObject).append(paramRequestEvent.event);
    ((StringBuilder)localObject).append(",jsonParams=");
    ((StringBuilder)localObject).append(paramRequestEvent.jsonParams);
    ((StringBuilder)localObject).append(",callbackId=");
    ((StringBuilder)localObject).append(paramRequestEvent.callbackId);
    ((StringBuilder)localObject).append(",webview=");
    ((StringBuilder)localObject).append(paramRequestEvent.jsService);
    QMLog.d("VideoJsPlugin", ((StringBuilder)localObject).toString());
    localObject = this.bridgeMap;
    if (localObject != null) {
      ((ConcurrentHashMap)localObject).put(Integer.valueOf(paramRequestEvent.callbackId), paramRequestEvent);
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
    paramString = this.bridgeMap;
    if (paramString != null)
    {
      paramString = (RequestEvent)paramString.get(Integer.valueOf(paramInt));
      if (paramString != null) {
        paramString.cancel(paramJSONObject);
      }
    }
  }
  
  public void responseFail(int paramInt, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    paramString1 = this.bridgeMap;
    if (paramString1 != null)
    {
      paramString1 = (RequestEvent)paramString1.get(Integer.valueOf(paramInt));
      if (paramString1 != null) {
        paramString1.fail(paramString2);
      }
    }
  }
  
  public void responseOk(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    paramString = this.bridgeMap;
    if (paramString != null)
    {
      paramString = (RequestEvent)paramString.get(Integer.valueOf(paramInt));
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRequestEvent.event);
      localStringBuilder.append(" error,");
      QMLog.e("VideoJsPlugin", localStringBuilder.toString(), localThrowable);
      paramRequestEvent.fail();
    }
  }
  
  protected void sendNativeViewEvent(RequestEvent paramRequestEvent, int paramInt)
  {
    super.sendNativeViewEvent(paramRequestEvent, paramInt);
  }
  
  protected void sendSubscribeEvent(String paramString1, String paramString2)
  {
    super.sendSubscribeEvent(paramString1, paramString2);
  }
  
  public void showLoading(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showLoading ");
    localStringBuilder.append(paramString);
    QMLog.i("VideoJsPlugin", localStringBuilder.toString());
    AppBrandTask.runTaskOnUiThread(new VideoJsPlugin.1(this, paramString));
  }
  
  public void updateLoading(String paramString)
  {
    AppBrandTask.runTaskOnUiThread(new VideoJsPlugin.2(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoJsPlugin
 * JD-Core Version:    0.7.0.1
 */