package com.tencent.qqmini.miniapp.plugin;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXLivePushListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class LivePusherEmbeddedWidgetClient$3
  implements TXLivePushListenerReflect.ITXLivePushListener
{
  LivePusherEmbeddedWidgetClient$3(LivePusherEmbeddedWidgetClient paramLivePusherEmbeddedWidgetClient) {}
  
  public void onNetStatus(Bundle paramBundle)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("info", localJSONObject2);
      localJSONObject2.put("CPU_USAGE", paramBundle.getString("CPU_USAGE"));
      localJSONObject2.put("VIDEO_WIDTH", paramBundle.getInt("VIDEO_WIDTH"));
      localJSONObject2.put("VIDEO_HEIGHT", paramBundle.getInt("VIDEO_HEIGHT"));
      localJSONObject2.put("NET_SPEED", paramBundle.getInt("NET_SPEED"));
      localJSONObject2.put("NET_JITTER", paramBundle.getInt("NET_JITTER"));
      localJSONObject2.put("VIDEO_FPS", paramBundle.getInt("VIDEO_FPS"));
      localJSONObject2.put("VIDEO_GOP", paramBundle.getInt("VIDEO_GOP"));
      localJSONObject2.put("AUDIO_BITRATE", paramBundle.getInt("AUDIO_BITRATE"));
      localJSONObject2.put("AUDIO_CACHE", paramBundle.getInt("AUDIO_CACHE"));
      localJSONObject2.put("VIDEO_CACHE", paramBundle.getInt("VIDEO_CACHE"));
      localJSONObject2.put("V_SUM_CACHE_SIZE", paramBundle.getInt("V_SUM_CACHE_SIZE"));
      localJSONObject2.put("V_DEC_CACHE_SIZE", paramBundle.getInt("V_DEC_CACHE_SIZE"));
      localJSONObject2.put("AV_RECV_INTERVAL", paramBundle.getInt("AV_RECV_INTERVAL"));
      localJSONObject2.put("AV_PLAY_INTERVAL", paramBundle.getInt("AV_PLAY_INTERVAL"));
      localJSONObject2.put("AUDIO_CACHE_THRESHOLD", String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }));
      localJSONObject2.put("VIDEO_BITRATE", paramBundle.getInt("VIDEO_BITRATE"));
      localJSONObject2.put("AUDIO_DROP", paramBundle.getInt("AUDIO_DROP"));
      localJSONObject2.put("VIDEO_DROP", paramBundle.getInt("VIDEO_DROP"));
      localJSONObject2.put("SERVER_IP", paramBundle.getString("SERVER_IP"));
      localJSONObject2.put("AUDIO_PLAY_INFO", paramBundle.getString("AUDIO_PLAY_INFO"));
      try
      {
        LivePusherEmbeddedWidgetClient.access$300(this.this$0, "onXWebLivePusherNetStatus", localJSONObject1.toString(), LivePusherEmbeddedWidgetClient.access$200(this.this$0));
        return;
      }
      catch (JSONException paramBundle) {}
      paramBundle.printStackTrace();
    }
    catch (JSONException paramBundle) {}
  }
  
  public void onPushEvent(int paramInt, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPushEvent i:");
    ((StringBuilder)localObject).append(paramInt);
    QMLog.e("miniapp-embedded-live-pusher", ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("viewId", LivePusherEmbeddedWidgetClient.access$100(this.this$0));
      ((JSONObject)localObject).put("errCode", paramInt);
      if (paramBundle != null) {
        ((JSONObject)localObject).put("errMsg", paramBundle.getString("EVT_MSG"));
      }
      LivePusherEmbeddedWidgetClient.access$300(this.this$0, "onXWebLivePusherEvent", ((JSONObject)localObject).toString(), LivePusherEmbeddedWidgetClient.access$200(this.this$0));
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePusherEmbeddedWidgetClient.3
 * JD-Core Version:    0.7.0.1
 */