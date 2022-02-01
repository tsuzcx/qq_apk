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
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("VIDEO_BITRATE", paramBundle.get("VIDEO_BITRATE"));
      ((JSONObject)localObject).put("AUDIO_BITRATE", paramBundle.get("AUDIO_BITRATE"));
      ((JSONObject)localObject).put("VIDEO_FPS", paramBundle.get("VIDEO_FPS"));
      ((JSONObject)localObject).put("VIDEO_GOP", paramBundle.get("VIDEO_GOP"));
      ((JSONObject)localObject).put("NET_SPEED", paramBundle.get("NET_SPEED"));
      ((JSONObject)localObject).put("NET_JITTER", paramBundle.get("NET_JITTER"));
      ((JSONObject)localObject).put("VIDEO_WIDTH", paramBundle.get("VIDEO_WIDTH"));
      ((JSONObject)localObject).put("VIDEO_HEIGHT", paramBundle.get("VIDEO_HEIGHT"));
      paramBundle = new JSONObject();
      paramBundle.put("viewId", LivePlayerEmbeddedWidgetClient.access$000(this.this$0));
      paramBundle.put("info", localObject);
      LivePlayerEmbeddedWidgetClient.access$200(this.this$0, "onXWebLivePlayerNetStatus", paramBundle.toString(), LivePlayerEmbeddedWidgetClient.access$100(this.this$0));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("operate start evaluateSubcribeJS onLivePlayerNetStatus = ");
      ((StringBuilder)localObject).append(paramBundle.toString());
      QMLog.e("miniapp-embedded-live-player", ((StringBuilder)localObject).toString());
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPlayEvent code:");
    ((StringBuilder)localObject).append(paramInt);
    QMLog.d("miniapp-embedded-live-player", ((StringBuilder)localObject).toString());
    if (2028 == paramInt) {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("viewId", LivePlayerEmbeddedWidgetClient.access$000(this.this$0));
        ((JSONObject)localObject).put("errCode", paramInt);
        paramBundle = paramBundle.get("EVT_GET_METADATA");
        if ((paramBundle instanceof HashMap)) {
          ((JSONObject)localObject).put("errMsg", new JSONObject((HashMap)paramBundle));
        }
        LivePlayerEmbeddedWidgetClient.access$200(this.this$0, "onXWebLivePlayerMetadata", ((JSONObject)localObject).toString(), LivePlayerEmbeddedWidgetClient.access$100(this.this$0));
        paramBundle = new StringBuilder();
        paramBundle.append("operate start evaluateSubcribeJS onXWebLivePlayerMetadata = ");
        paramBundle.append(((JSONObject)localObject).toString());
        QMLog.e("miniapp-embedded-live-player", paramBundle.toString());
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
      localObject = new JSONObject();
      ((JSONObject)localObject).put("viewId", LivePlayerEmbeddedWidgetClient.access$000(this.this$0));
      ((JSONObject)localObject).put("errCode", paramInt);
      ((JSONObject)localObject).put("errMsg", paramBundle.get("EVT_MSG"));
      LivePlayerEmbeddedWidgetClient.access$200(this.this$0, "onXWebLivePlayerEvent", ((JSONObject)localObject).toString(), LivePlayerEmbeddedWidgetClient.access$100(this.this$0));
      paramBundle = new StringBuilder();
      paramBundle.append("operate start evaluateSubcribeJS onLivePlayerEvent = ");
      paramBundle.append(((JSONObject)localObject).toString());
      QMLog.e("miniapp-embedded-live-player", paramBundle.toString());
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