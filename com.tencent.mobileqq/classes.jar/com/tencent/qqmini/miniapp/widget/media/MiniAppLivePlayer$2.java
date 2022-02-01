package com.tencent.qqmini.miniapp.widget.media;

import com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppLivePlayer$2
  implements TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener
{
  MiniAppLivePlayer$2(MiniAppLivePlayer paramMiniAppLivePlayer, RequestEvent paramRequestEvent) {}
  
  public void onAudioVolumeEvaluationNotify(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onAudioVolumeEvaluationNotify code:");
    ((StringBuilder)localObject).append(paramInt);
    QMLog.d("MiniAppLivePlayer", ((StringBuilder)localObject).toString());
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("livePlayerId", this.this$0.livePlayerId);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("volume", paramInt);
      localJSONObject.put("info", localObject);
      if (this.this$0.miniAppContextRef != null) {
        localObject = (IMiniAppContext)this.this$0.miniAppContextRef.get();
      } else {
        localObject = null;
      }
      if (localObject != null) {
        ((IMiniAppContext)localObject).performAction(ServiceSubscribeEvent.obtain("onLivePlayerAudioVolumeNotify", localJSONObject.toString(), this.this$0.webviewId));
      }
      this.val$req.jsService.evaluateSubscribeJS("onLivePlayerAudioVolumeNotify", localJSONObject.toString(), this.this$0.webviewId);
      if (QMLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAudioVolumeEvaluationNotify resultObj.toString() = ");
        ((StringBuilder)localObject).append(localJSONObject.toString());
        QMLog.e("MiniAppLivePlayer", ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.2
 * JD-Core Version:    0.7.0.1
 */