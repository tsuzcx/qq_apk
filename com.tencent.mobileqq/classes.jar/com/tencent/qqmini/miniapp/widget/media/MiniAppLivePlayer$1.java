package com.tencent.qqmini.miniapp.widget.media;

import android.os.Bundle;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.IPlayOuterListener;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppLivePlayer$1
  implements TXLivePlayerJSAdapter.IPlayOuterListener
{
  MiniAppLivePlayer$1(MiniAppLivePlayer paramMiniAppLivePlayer, RequestEvent paramRequestEvent) {}
  
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
      if (this.this$0.miniAppContextRef != null) {}
      for (paramBundle = (IMiniAppContext)this.this$0.miniAppContextRef.get();; paramBundle = null)
      {
        if (paramBundle != null) {
          paramBundle.performAction(ServiceSubscribeEvent.obtain("onLivePlayerNetStatus", localJSONObject1.toString(), this.this$0.webviewId));
        }
        this.val$req.jsService.evaluateSubscribeJS("onLivePlayerNetStatus", localJSONObject1.toString(), this.this$0.webviewId);
        QMLog.e("MiniAppLivePlayer", "operate start evaluateSubcribeJS onLivePlayerNetStatus = " + localJSONObject1.toString());
        return;
      }
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    QMLog.d("MiniAppLivePlayer", "onPlayEvent code:" + paramInt);
    if (2028 == paramInt) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("livePlayerId", this.this$0.livePlayerId);
        localJSONObject.put("errCode", paramInt);
        paramBundle = paramBundle.get("EVT_GET_METADATA");
        if ((paramBundle instanceof HashMap)) {
          localJSONObject.put("errMsg", new JSONObject((HashMap)paramBundle));
        }
        if (this.this$0.miniAppContextRef != null) {}
        for (paramBundle = (IMiniAppContext)this.this$0.miniAppContextRef.get();; paramBundle = null)
        {
          if (paramBundle != null) {
            paramBundle.performAction(ServiceSubscribeEvent.obtain("onLivePlayerMetadata", localJSONObject.toString(), this.this$0.webviewId));
          }
          this.val$req.jsService.evaluateSubscribeJS("onLivePlayerMetadata", localJSONObject.toString(), this.this$0.webviewId);
          QMLog.e("MiniAppLivePlayer", "operate start evaluateSubcribeJS onLivePlayerMetadata = " + localJSONObject.toString());
          return;
        }
        try
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("livePlayerId", this.this$0.livePlayerId);
          localJSONObject.put("errCode", paramInt);
          localJSONObject.put("errMsg", paramBundle.get("EVT_MSG"));
          if (this.this$0.miniAppContextRef != null)
          {
            paramBundle = (IMiniAppContext)this.this$0.miniAppContextRef.get();
            if (paramBundle != null) {
              paramBundle.performAction(ServiceSubscribeEvent.obtain("onLivePlayerEvent", localJSONObject.toString(), this.this$0.webviewId));
            }
            this.val$req.jsService.evaluateSubscribeJS("onLivePlayerEvent", localJSONObject.toString(), this.this$0.webviewId);
            QMLog.e("MiniAppLivePlayer", "operate start evaluateSubcribeJS onLivePlayerEvent = " + localJSONObject.toString());
            return;
          }
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    for (;;)
    {
      paramBundle = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.1
 * JD-Core Version:    0.7.0.1
 */