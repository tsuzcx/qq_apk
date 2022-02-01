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
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("VIDEO_BITRATE", paramBundle.get("VIDEO_BITRATE"));
      localJSONObject.put("AUDIO_BITRATE", paramBundle.get("AUDIO_BITRATE"));
      localJSONObject.put("VIDEO_FPS", paramBundle.get("VIDEO_FPS"));
      localJSONObject.put("VIDEO_GOP", paramBundle.get("VIDEO_GOP"));
      localJSONObject.put("NET_SPEED", paramBundle.get("NET_SPEED"));
      localJSONObject.put("NET_JITTER", paramBundle.get("NET_JITTER"));
      localJSONObject.put("VIDEO_WIDTH", paramBundle.get("VIDEO_WIDTH"));
      localJSONObject.put("VIDEO_HEIGHT", paramBundle.get("VIDEO_HEIGHT"));
      paramBundle = new JSONObject();
      paramBundle.put("viewId", LivePlayerEmbeddedWidgetClient.access$000(this.this$0));
      paramBundle.put("info", localJSONObject);
      LivePlayerEmbeddedWidgetClient.access$200(this.this$0, "onXWebLivePlayerNetStatus", paramBundle.toString(), LivePlayerEmbeddedWidgetClient.access$100(this.this$0));
      QMLog.e("miniapp-embedded-live-player", "operate start evaluateSubcribeJS onLivePlayerNetStatus = " + paramBundle.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePlayerEmbeddedWidgetClient.2
 * JD-Core Version:    0.7.0.1
 */