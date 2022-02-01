package com.tencent.mobileqq.mini.widget.media;

import android.os.Bundle;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.media.live.TXLivePlayerJSAdapter.IPlayOuterListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppLivePlayer$1
  implements TXLivePlayerJSAdapter.IPlayOuterListener
{
  MiniAppLivePlayer$1(MiniAppLivePlayer paramMiniAppLivePlayer) {}
  
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
      localJSONObject1.put("livePlayerId", this.this$0.livePlayerId);
      localJSONObject1.put("info", localJSONObject2);
      this.this$0.serviceWebview.evaluateSubcribeJS("onLivePlayerNetStatus", localJSONObject1.toString(), this.this$0.webviewId);
      QLog.e("MiniAppLivePlayer", 4, "operate start evaluateSubcribeJS onLivePlayerNetStatus = " + localJSONObject1.toString());
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    QLog.d("MiniAppLivePlayer", 1, "onPlayEvent code:" + paramInt);
    JSONObject localJSONObject;
    if (2028 == paramInt) {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("livePlayerId", this.this$0.livePlayerId);
        localJSONObject.put("errCode", paramInt);
        paramBundle = paramBundle.get("EVT_GET_METADATA");
        if ((paramBundle instanceof HashMap)) {
          localJSONObject.put("errMsg", new JSONObject((HashMap)paramBundle));
        }
        this.this$0.serviceWebview.evaluateSubcribeJS("onLivePlayerMetadata", localJSONObject.toString(), this.this$0.webviewId);
        QLog.e("MiniAppLivePlayer", 1, "operate start evaluateSubcribeJS onLivePlayerMetadata = " + localJSONObject.toString());
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("MiniAppLivePlayer", 1, " onLivePlayerMetadata get an Exception " + paramBundle);
        return;
      }
    }
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("livePlayerId", this.this$0.livePlayerId);
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", paramBundle.get("EVT_MSG"));
      this.this$0.serviceWebview.evaluateSubcribeJS("onLivePlayerEvent", localJSONObject.toString(), this.this$0.webviewId);
      QLog.e("MiniAppLivePlayer", 1, "operate start evaluateSubcribeJS onLivePlayerEvent = " + localJSONObject.toString());
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppLivePlayer.1
 * JD-Core Version:    0.7.0.1
 */