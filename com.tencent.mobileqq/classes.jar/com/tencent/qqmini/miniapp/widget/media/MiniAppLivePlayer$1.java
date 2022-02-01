package com.tencent.qqmini.miniapp.widget.media;

import android.os.Bundle;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.IPlayOuterListener;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
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
      if (this.this$0.miniAppContextRef != null) {
        paramBundle = (IMiniAppContext)this.this$0.miniAppContextRef.get();
      } else {
        paramBundle = null;
      }
      if (paramBundle != null) {
        paramBundle.performAction(ServiceSubscribeEvent.obtain("onLivePlayerNetStatus", localJSONObject1.toString(), this.this$0.webviewId));
      }
      this.val$req.jsService.evaluateSubscribeJS("onLivePlayerNetStatus", localJSONObject1.toString(), this.this$0.webviewId);
      paramBundle = new StringBuilder();
      paramBundle.append("operate start evaluateSubcribeJS onLivePlayerNetStatus = ");
      paramBundle.append(localJSONObject1.toString());
      QMLog.e("MiniAppLivePlayer", paramBundle.toString());
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPlayEvent code:");
    localStringBuilder.append(paramInt);
    QMLog.d("MiniAppLivePlayer", localStringBuilder.toString());
    MiniAppLivePlayer.access$000(this.this$0, paramInt, paramBundle, this.val$req);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.1
 * JD-Core Version:    0.7.0.1
 */