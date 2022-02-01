package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.PayResponse;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$15
  implements PayProxy.IPayResultCallBack
{
  PayJsPlugin$15(PayJsPlugin paramPayJsPlugin, RequestEvent paramRequestEvent, boolean paramBoolean, String paramString) {}
  
  public void onPayCallBack(PayProxy.PayResponse paramPayResponse)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("resultCode", paramPayResponse.getResultCode());
      label21:
      String str3 = null;
      str2 = null;
      String str4 = null;
      str1 = null;
      m = -1;
      int i1 = -1;
      int n = -1;
      i3 = 0;
      k = m;
      j = i1;
      i = n;
      i2 = i3;
      if (this.val$toolConsume)
      {
        str2 = str3;
        str1 = str4;
        k = m;
        j = i1;
        i = n;
      }
      try
      {
        JSONObject localJSONObject2 = new JSONObject(this.val$callbackSn);
        str2 = str3;
        str1 = str4;
        k = m;
        j = i1;
        i = n;
        str3 = localJSONObject2.optString("appId", null);
        str2 = str3;
        str1 = str4;
        k = m;
        j = i1;
        i = n;
        str4 = localJSONObject2.optString("prepayId", null);
        str2 = str3;
        str1 = str4;
        k = m;
        j = i1;
        i = n;
        m = localJSONObject2.optInt("balanceAmount", -1);
        str2 = str3;
        str1 = str4;
        k = m;
        j = i1;
        i = n;
        i1 = localJSONObject2.optInt("topupAmount", -1);
        str2 = str3;
        str1 = str4;
        k = m;
        j = i1;
        i = n;
        n = localJSONObject2.optInt("starCurrency", -1);
        str2 = str3;
        str1 = str4;
        k = m;
        j = i1;
        i = n;
        i2 = localJSONObject2.optInt("setEnv", 0);
        i = n;
        j = i1;
        k = m;
        str1 = str4;
        str2 = str3;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          QMLog.e("PayJsPlugin", "", localJSONException2);
          i2 = i3;
          continue;
          if (this.val$toolConsume)
          {
            this.this$0.invokeMidasQuery(str1, str2, i, i2, PayJsPlugin.access$2300(this.this$0, str2, str1, i, k, j, m, i2, this.val$req));
          }
          else
          {
            str1 = paramPayResponse.getResultMsg();
            PayJsPlugin.access$700(this.this$0, this.val$req, localJSONObject1, str1);
          }
        }
      }
      m = PayJsPlugin.access$2100(this.this$0, paramPayResponse);
      if ((paramPayResponse.getResultCode() == 0) && (paramPayResponse.getPayState() == 0))
      {
        PayJsPlugin.access$2200(this.this$0, localJSONObject1, str2, str1, k, j, i, i2, m, this.val$toolConsume, this.val$req);
        QMLog.i("PayJsPlugin", "handleRechargeGame onPayCallBack, , resultCode = " + paramPayResponse.getResultCode() + ", resultMsg = " + paramPayResponse.getResultMsg() + "extendInfo = " + paramPayResponse.getExtendInfo());
        return;
      }
    }
    catch (JSONException localJSONException1)
    {
      String str2;
      String str1;
      int m;
      int i3;
      int k;
      int j;
      int i;
      int i2;
      break label21;
    }
  }
  
  public void payNeedLogin()
  {
    QMLog.e("PayJsPlugin", "handleRechargeGame payNeedLogin");
    PayJsPlugin.access$700(this.this$0, this.val$req, null, "payNeedLogin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.15
 * JD-Core Version:    0.7.0.1
 */