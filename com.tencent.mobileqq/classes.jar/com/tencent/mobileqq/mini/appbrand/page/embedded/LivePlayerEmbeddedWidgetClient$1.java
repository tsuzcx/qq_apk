package com.tencent.mobileqq.mini.appbrand.page.embedded;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.media.live.TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class LivePlayerEmbeddedWidgetClient$1
  implements TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener
{
  LivePlayerEmbeddedWidgetClient$1(LivePlayerEmbeddedWidgetClient paramLivePlayerEmbeddedWidgetClient) {}
  
  public void onAudioVolumeEvaluationNotify(int paramInt)
  {
    QLog.d("miniapp-embedded-live-player", 2, "onAudioVolumeEvaluationNotify code:" + paramInt);
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("viewId", LivePlayerEmbeddedWidgetClient.access$000(this.this$0));
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("volume", paramInt);
      localJSONObject1.put("info", localJSONObject2);
      ((AppBrandRuntime)LivePlayerEmbeddedWidgetClient.access$200(this.this$0)).serviceRuntime.evaluateSubcribeJS("onXWebLivePlayerAudioVolume", localJSONObject1.toString(), LivePlayerEmbeddedWidgetClient.access$100(this.this$0));
      LivePlayerEmbeddedWidgetClient.access$300(this.this$0).evaluateSubcribeJS("onXWebLivePlayerAudioVolume", localJSONObject1.toString(), LivePlayerEmbeddedWidgetClient.access$100(this.this$0));
      if (QLog.isColorLevel()) {
        QLog.e("miniapp-embedded-live-player", 1, "onAudioVolumeEvaluationNotify resultObj.toString() = " + localJSONObject1.toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.LivePlayerEmbeddedWidgetClient.1
 * JD-Core Version:    0.7.0.1
 */