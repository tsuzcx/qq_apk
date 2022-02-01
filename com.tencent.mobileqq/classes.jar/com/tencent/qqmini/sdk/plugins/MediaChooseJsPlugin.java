package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy.Bridge;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

@JsPlugin
public class MediaChooseJsPlugin
  extends BaseJsPlugin
  implements MediaChooseJsProxy.Bridge
{
  public static final String API_CHOOSE_MEDIA = "chooseMedia";
  public static final String TAG = "MediaJsPlugin";
  private ConcurrentHashMap<Integer, RequestEvent> bridgeMap;
  private MediaChooseJsProxy mImpl = (MediaChooseJsProxy)ProxyManager.get(MediaChooseJsProxy.class);
  private ToastView toastView;
  
  @JsEvent({"chooseMedia"})
  public void chooseMedia(RequestEvent paramRequestEvent)
  {
    try
    {
      this.mImpl.chooseMedia(this.mMiniAppContext.getAttachedActivity(), paramRequestEvent.event, paramRequestEvent.jsonParams, paramRequestEvent.callbackId);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("MediaJsPlugin", paramRequestEvent.event + " error,", localThrowable);
      paramRequestEvent.fail();
    }
  }
  
  public void hideLoading()
  {
    AppBrandTask.runTaskOnUiThread(new MediaChooseJsPlugin.3(this));
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
    QMLog.d("MediaJsPlugin", "onInterceptJsEvent event=" + paramRequestEvent.event + ",jsonParams=" + paramRequestEvent.jsonParams + ",callbackId=" + paramRequestEvent.callbackId + ",webview=" + paramRequestEvent.jsService);
    if (this.bridgeMap != null) {
      this.bridgeMap.put(Integer.valueOf(paramRequestEvent.callbackId), paramRequestEvent);
    }
    return super.onInterceptJsEvent(paramRequestEvent);
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
  
  public void showLoading(String paramString)
  {
    QMLog.i("MediaJsPlugin", "showLoading " + paramString);
    AppBrandTask.runTaskOnUiThread(new MediaChooseJsPlugin.1(this, paramString));
  }
  
  public void updateLoading(String paramString)
  {
    AppBrandTask.runTaskOnUiThread(new MediaChooseJsPlugin.2(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.MediaChooseJsPlugin
 * JD-Core Version:    0.7.0.1
 */