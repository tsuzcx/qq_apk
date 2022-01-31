package com.tencent.qqmini.sdk.core.plugins;

import bdfz;
import bdnw;
import com.tencent.qqmini.sdk.core.proxy.PayProxy.IPayResultCallBack;
import com.tencent.qqmini.sdk.core.proxy.PayProxy.PayResponse;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$7
  implements PayProxy.IPayResultCallBack
{
  PayJsPlugin$7(PayJsPlugin paramPayJsPlugin, bdfz parambdfz) {}
  
  public void onPayCallBack(PayProxy.PayResponse paramPayResponse)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("resultCode", paramPayResponse.getResultCode());
      label19:
      if ((paramPayResponse.getResultCode() == 0) && (paramPayResponse.getPayState() == 0)) {
        PayJsPlugin.access$300(this.this$0, this.val$req, localJSONObject);
      }
      for (;;)
      {
        bdnw.b("PayJsPlugin", "handleMidasGoodsPay onPayCallBack, , resultCode = " + paramPayResponse.getResultCode() + ", resultMsg = " + paramPayResponse.getResultMsg() + "extendInfo = " + paramPayResponse.getExtendInfo());
        return;
        if ((paramPayResponse.getResultCode() == 2) || (paramPayResponse.getPayState() == 1))
        {
          PayJsPlugin.access$000(this.this$0, this.val$req, localJSONObject);
        }
        else
        {
          String str = paramPayResponse.getResultMsg();
          PayJsPlugin.access$200(this.this$0, this.val$req, localJSONObject, str);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      break label19;
    }
  }
  
  public void payNeedLogin()
  {
    bdnw.d("PayJsPlugin", "handleMidasMonthCardPay payNeedLogin");
    PayJsPlugin.access$200(this.this$0, this.val$req, null, "payNeedLogin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.PayJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */