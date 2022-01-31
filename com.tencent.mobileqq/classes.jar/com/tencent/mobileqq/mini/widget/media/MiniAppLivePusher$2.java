package com.tencent.mobileqq.mini.widget.media;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.media.live.TXLivePushListenerReflect.OnBGMNotify;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppLivePusher$2
  implements TXLivePushListenerReflect.OnBGMNotify
{
  MiniAppLivePusher$2(MiniAppLivePusher paramMiniAppLivePusher) {}
  
  public void onBGMComplete(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLivePusher", 2, "onBGMComplete, errCode:" + paramInt);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("livePusherId", this.this$0.livePusherId);
      localJSONObject.put("errCode", paramInt);
      this.this$0.serviceWebview.evaluateSubcribeJS("onLivePusherBGMComplete", localJSONObject.toString(), this.this$0.webviewId);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void onBGMProgress(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MiniAppLivePusher", 1, "onBGMProgress progress:" + paramLong1 + ",duration:" + paramLong2);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("livePusherId", this.this$0.livePusherId);
      localJSONObject.put("progress", paramLong1);
      localJSONObject.put("duration", paramLong2);
      this.this$0.serviceWebview.evaluateSubcribeJS("onLivePusherBGMProgress", localJSONObject.toString(), this.this$0.webviewId);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void onBGMStart()
  {
    QLog.e("MiniAppLivePusher", 1, "onBGMStart");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("livePusherId", this.this$0.livePusherId);
      this.this$0.serviceWebview.evaluateSubcribeJS("onLivePusherBGMStart", localJSONObject.toString(), this.this$0.webviewId);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppLivePusher.2
 * JD-Core Version:    0.7.0.1
 */