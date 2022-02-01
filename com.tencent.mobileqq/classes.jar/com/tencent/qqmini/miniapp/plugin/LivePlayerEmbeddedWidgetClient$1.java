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
    QMLog.d("miniapp-embedded-live-player", "onAudioVolumeEvaluationNotify code:" + paramInt);
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("viewId", LivePlayerEmbeddedWidgetClient.access$000(this.this$0));
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("volume", paramInt);
      localJSONObject1.put("info", localJSONObject2);
      LivePlayerEmbeddedWidgetClient.access$200(this.this$0, "onXWebLivePlayerAudioVolume", localJSONObject1.toString(), LivePlayerEmbeddedWidgetClient.access$100(this.this$0));
      if (QMLog.isColorLevel()) {
        QMLog.e("miniapp-embedded-live-player", "onXWebLivePlayerAudioVolume resultObj.toString() = " + localJSONObject1.toString());
      }
      return;
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