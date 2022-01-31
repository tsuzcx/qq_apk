package com.tencent.mobileqq.mini.widget.media;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.media.live.TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppLivePlayer$2
  implements TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener
{
  MiniAppLivePlayer$2(MiniAppLivePlayer paramMiniAppLivePlayer) {}
  
  public void onAudioVolumeEvaluationNotify(int paramInt)
  {
    QLog.d("MiniAppLivePlayer", 2, "onAudioVolumeEvaluationNotify code:" + paramInt);
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("livePlayerId", this.this$0.livePlayerId);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("volume", paramInt);
      localJSONObject1.put("info", localJSONObject2);
      this.this$0.serviceWebview.evaluateSubcribeJS("onLivePlayerAudioVolumeNotify", localJSONObject1.toString(), this.this$0.webviewId);
      if (QLog.isColorLevel()) {
        QLog.e("MiniAppLivePlayer", 1, "onAudioVolumeEvaluationNotify resultObj.toString() = " + localJSONObject1.toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppLivePlayer.2
 * JD-Core Version:    0.7.0.1
 */