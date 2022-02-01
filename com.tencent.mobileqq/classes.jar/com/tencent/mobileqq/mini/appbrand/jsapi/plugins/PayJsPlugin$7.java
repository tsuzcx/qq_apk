package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$7
  implements MiniProgramShareUtils.OnShareListener
{
  PayJsPlugin$7(PayJsPlugin paramPayJsPlugin, int paramInt, String paramString) {}
  
  public void onShared(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("resultCode", 0);
        PayJsPlugin.access$500(this.this$0, this.val$callbackId, this.val$eventName, localJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("PayJsPlugin", 1, "handlePayByFriend put resultCode error", localJSONException);
        }
      }
    }
    PayJsPlugin.access$200(this.this$0, this.val$callbackId, this.val$eventName, null, "分享失败");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PayJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */