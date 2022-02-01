package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class LivePlayerEmbeddedWidgetClient$1
  implements TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener
{
  LivePlayerEmbeddedWidgetClient$1(LivePlayerEmbeddedWidgetClient paramLivePlayerEmbeddedWidgetClient) {}
  
  public void onAudioVolumeEvaluationNotify(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onAudioVolumeEvaluationNotify code:");
    ((StringBuilder)localObject1).append(paramInt);
    QMLog.d("miniapp-embedded-live-player", ((StringBuilder)localObject1).toString());
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("viewId", LivePlayerEmbeddedWidgetClient.access$000(this.this$0));
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("volume", paramInt);
      ((JSONObject)localObject1).put("info", localObject2);
      LivePlayerEmbeddedWidgetClient.access$200(this.this$0, "onXWebLivePlayerAudioVolume", ((JSONObject)localObject1).toString(), LivePlayerEmbeddedWidgetClient.access$100(this.this$0));
      if (QMLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onXWebLivePlayerAudioVolume resultObj.toString() = ");
        ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
        QMLog.e("miniapp-embedded-live-player", ((StringBuilder)localObject2).toString());
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
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePlayerEmbeddedWidgetClient.1
 * JD-Core Version:    0.7.0.1
 */