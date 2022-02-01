package com.tencent.qqmini.miniapp.widget.media;

import com.tencent.qqmini.miniapp.widget.media.live.TXLivePushListenerReflect.OnBGMNotify;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppLivePusher$2
  implements TXLivePushListenerReflect.OnBGMNotify
{
  MiniAppLivePusher$2(MiniAppLivePusher paramMiniAppLivePusher, RequestEvent paramRequestEvent) {}
  
  public void onBGMComplete(int paramInt)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniAppLivePusher", "onBGMComplete, errCode:" + paramInt);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("livePusherId", this.this$0.livePusherId);
      localJSONObject.put("errCode", paramInt);
      if (this.this$0.miniAppContextRef != null) {}
      for (IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.this$0.miniAppContextRef.get();; localIMiniAppContext = null)
      {
        if (localIMiniAppContext != null) {
          localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onLivePusherBGMComplete", localJSONObject.toString(), this.this$0.webviewId));
        }
        this.val$req.jsService.evaluateSubscribeJS("onLivePusherBGMComplete", localJSONObject.toString(), this.this$0.webviewId);
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void onBGMProgress(long paramLong1, long paramLong2)
  {
    if (QMLog.isColorLevel()) {
      QMLog.e("MiniAppLivePusher", "onBGMProgress progress:" + paramLong1 + ",duration:" + paramLong2);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("livePusherId", this.this$0.livePusherId);
      localJSONObject.put("progress", paramLong1);
      localJSONObject.put("duration", paramLong2);
      if (this.this$0.miniAppContextRef != null) {}
      for (IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.this$0.miniAppContextRef.get();; localIMiniAppContext = null)
      {
        if (localIMiniAppContext != null) {
          localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onLivePusherBGMProgress", localJSONObject.toString(), this.this$0.webviewId));
        }
        this.val$req.jsService.evaluateSubscribeJS("onLivePusherBGMProgress", localJSONObject.toString(), this.this$0.webviewId);
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void onBGMStart()
  {
    QMLog.e("MiniAppLivePusher", "onBGMStart");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("livePusherId", this.this$0.livePusherId);
      if (this.this$0.miniAppContextRef != null) {}
      for (IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.this$0.miniAppContextRef.get();; localIMiniAppContext = null)
      {
        if (localIMiniAppContext != null) {
          localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onLivePusherBGMStart", localJSONObject.toString(), this.this$0.webviewId));
        }
        this.val$req.jsService.evaluateSubscribeJS("onLivePusherBGMStart", localJSONObject.toString(), this.this$0.webviewId);
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePusher.2
 * JD-Core Version:    0.7.0.1
 */