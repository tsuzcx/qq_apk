package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.OnBGMNotify;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class LivePusherEmbeddedWidgetClient$2
  implements TXLivePushListenerReflect.OnBGMNotify
{
  LivePusherEmbeddedWidgetClient$2(LivePusherEmbeddedWidgetClient paramLivePusherEmbeddedWidgetClient) {}
  
  public void onBGMComplete(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onBGMComplete, errCode:");
    ((StringBuilder)localObject).append(paramInt);
    QMLog.d("miniapp-embedded-live-pusher", ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("viewId", LivePusherEmbeddedWidgetClient.access$100(this.this$0));
      ((JSONObject)localObject).put("errCode", paramInt);
      LivePusherEmbeddedWidgetClient.access$300(this.this$0, "onXWebLivePusherBGMComplete", ((JSONObject)localObject).toString(), LivePusherEmbeddedWidgetClient.access$200(this.this$0));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void onBGMProgress(long paramLong1, long paramLong2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onBGMProgress progress:");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(",duration:");
    ((StringBuilder)localObject).append(paramLong2);
    QMLog.e("miniapp-embedded-live-pusher", ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("viewId", LivePusherEmbeddedWidgetClient.access$100(this.this$0));
      ((JSONObject)localObject).put("progress", paramLong1);
      ((JSONObject)localObject).put("duration", paramLong2);
      LivePusherEmbeddedWidgetClient.access$300(this.this$0, "onXWebLivePusherBGMProgress", ((JSONObject)localObject).toString(), LivePusherEmbeddedWidgetClient.access$200(this.this$0));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void onBGMStart()
  {
    QMLog.e("miniapp-embedded-live-pusher", "onBGMStart");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", LivePusherEmbeddedWidgetClient.access$100(this.this$0));
      LivePusherEmbeddedWidgetClient.access$300(this.this$0, "onXWebLivePusherBGMStart", localJSONObject.toString(), LivePusherEmbeddedWidgetClient.access$200(this.this$0));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePusherEmbeddedWidgetClient.2
 * JD-Core Version:    0.7.0.1
 */