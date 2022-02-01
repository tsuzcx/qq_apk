package com.tencent.qqmini.miniapp.plugin;

import android.os.Bundle;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.IPlayOuterListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class LivePlayerEmbeddedWidgetClient$2
  implements TXLivePlayerJSAdapter.IPlayOuterListener
{
  LivePlayerEmbeddedWidgetClient$2(LivePlayerEmbeddedWidgetClient paramLivePlayerEmbeddedWidgetClient) {}
  
  public void onNetStatus(Bundle paramBundle)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("VIDEO_BITRATE", paramBundle.get("VIDEO_BITRATE"));
      localJSONObject2.put("AUDIO_BITRATE", paramBundle.get("AUDIO_BITRATE"));
      localJSONObject2.put("VIDEO_FPS", paramBundle.get("VIDEO_FPS"));
      localJSONObject2.put("VIDEO_GOP", paramBundle.get("VIDEO_GOP"));
      localJSONObject2.put("NET_SPEED", paramBundle.get("NET_SPEED"));
      localJSONObject2.put("NET_JITTER", paramBundle.get("NET_JITTER"));
      localJSONObject2.put("VIDEO_WIDTH", paramBundle.get("VIDEO_WIDTH"));
      localJSONObject2.put("VIDEO_HEIGHT", paramBundle.get("VIDEO_HEIGHT"));
      localJSONObject1.put("viewId", LivePlayerEmbeddedWidgetClient.access$000(this.this$0));
      localJSONObject1.put("info", localJSONObject2);
      LivePlayerEmbeddedWidgetClient.access$200(this.this$0, "onXWebLivePlayerNetStatus", localJSONObject1.toString(), LivePlayerEmbeddedWidgetClient.access$100(this.this$0));
      QMLog.e("miniapp-embedded-live-player", "operate start evaluateSubcribeJS onLivePlayerNetStatus = " + localJSONObject1.toString());
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    QMLog.d("miniapp-embedded-live-player", "onPlayEvent code:" + paramInt);
    JSONObject localJSONObject;
    if (2028 == paramInt) {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("viewId", LivePlayerEmbeddedWidgetClient.access$000(this.this$0));
        localJSONObject.put("errCode", paramInt);
        paramBundle = paramBundle.get("EVT_GET_METADATA");
        if ((paramBundle instanceof HashMap)) {
          localJSONObject.put("errMsg", new JSONObject((HashMap)paramBundle));
        }
        LivePlayerEmbeddedWidgetClient.access$200(this.this$0, "onXWebLivePlayerMetadata", localJSONObject.toString(), LivePlayerEmbeddedWidgetClient.access$100(this.this$0));
        QMLog.e("miniapp-embedded-live-player", "operate start evaluateSubcribeJS onXWebLivePlayerMetadata = " + localJSONObject.toString());
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("viewId", LivePlayerEmbeddedWidgetClient.access$000(this.this$0));
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", paramBundle.get("EVT_MSG"));
      LivePlayerEmbeddedWidgetClient.access$200(this.this$0, "onXWebLivePlayerEvent", localJSONObject.toString(), LivePlayerEmbeddedWidgetClient.access$100(this.this$0));
      QMLog.e("miniapp-embedded-live-player", "operate start evaluateSubcribeJS onLivePlayerEvent = " + localJSONObject.toString());
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePlayerEmbeddedWidgetClient.2
 * JD-Core Version:    0.7.0.1
 */