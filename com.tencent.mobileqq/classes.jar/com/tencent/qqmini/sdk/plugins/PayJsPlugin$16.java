package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$16
  implements PayJsPlugin.IStarQueryListener
{
  PayJsPlugin$16(PayJsPlugin paramPayJsPlugin, RequestEvent paramRequestEvent, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void onResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      int i = paramJSONObject.optInt("resultCode");
      int j = paramJSONObject.optInt("rechargeNum");
      if ((i == 0) && (j <= 0))
      {
        this.this$0.invokeMidasConsume(this.val$req, this.val$constAppId, this.val$constPrepayId, this.val$constStarCurrency, this.val$constBalanceAmount, this.val$constTopupAmount, this.val$constPayChannel, this.val$constSetEnv);
        return;
      }
      paramJSONObject = new JSONObject();
      try
      {
        paramJSONObject.put("resultCode", -3);
        paramJSONObject.put("errMsg", "支付失败");
        PayJsPlugin.access$700(this.this$0, this.val$req, paramJSONObject, "");
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
    }
    PayJsPlugin.access$700(this.this$0, this.val$req, null, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.16
 * JD-Core Version:    0.7.0.1
 */