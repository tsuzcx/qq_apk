package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bdnw;
import com.tencent.qqmini.sdk.core.proxy.PayProxy.IPayResultCallBack;
import com.tencent.qqmini.sdk.core.proxy.PayProxy.PayResponse;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$9$1
  implements PayProxy.IPayResultCallBack
{
  PayJsPlugin$9$1(PayJsPlugin.9 param9) {}
  
  public void onPayCallBack(PayProxy.PayResponse paramPayResponse)
  {
    JSONObject localJSONObject1 = new JSONObject();
    label21:
    label591:
    try
    {
      localJSONObject1.put("resultCode", paramPayResponse.getResultCode());
      String str4 = null;
      str3 = null;
      String str5 = null;
      str1 = null;
      int i1 = -1;
      int i2 = -1;
      n = -1;
      i3 = 0;
      i = n;
      j = i1;
      k = i2;
      m = i3;
      if (this.this$1.val$toolConsume)
      {
        str3 = str4;
        str1 = str5;
        i = n;
        j = i1;
        k = i2;
      }
      try
      {
        JSONObject localJSONObject2 = new JSONObject(this.this$1.val$callbackSn);
        str3 = str4;
        str1 = str5;
        i = n;
        j = i1;
        k = i2;
        str4 = localJSONObject2.optString("appId", null);
        str3 = str4;
        str1 = str5;
        i = n;
        j = i1;
        k = i2;
        str5 = localJSONObject2.optString("prepayId", null);
        str3 = str4;
        str1 = str5;
        i = n;
        j = i1;
        k = i2;
        i1 = localJSONObject2.optInt("balanceAmount", -1);
        str3 = str4;
        str1 = str5;
        i = n;
        j = i1;
        k = i2;
        i2 = localJSONObject2.optInt("topupAmount", -1);
        str3 = str4;
        str1 = str5;
        i = n;
        j = i1;
        k = i2;
        n = localJSONObject2.optInt("starCurrency", -1);
        str3 = str4;
        str1 = str5;
        i = n;
        j = i1;
        k = i2;
        m = localJSONObject2.optInt("setEnv", 0);
        k = i2;
        j = i1;
        i = n;
        str1 = str5;
        str3 = str4;
      }
      catch (JSONException localJSONException3)
      {
        for (;;)
        {
          bdnw.d("PayJsPlugin", "", localJSONException3);
          m = i3;
          continue;
          n = 3;
          continue;
          bdnw.b("PayJsPlugin", "handleRechargeGame onPayCallBack, , consumeAppid = " + str3 + ", consumePrepayId = " + str1 + ", consumeStarCurrency = " + i + ", consumeTopupAmount = " + k + ", consumeBalanceAmount = " + j + ", payChannel = " + n);
          try
          {
            localJSONObject1.put("resultCode", -4);
            str1 = paramPayResponse.getResultMsg();
            PayJsPlugin.access$200(this.this$1.this$0, this.this$1.val$req, localJSONObject1, str1);
          }
          catch (JSONException localJSONException1)
          {
            for (;;)
            {
              localJSONException1.printStackTrace();
            }
          }
          PayJsPlugin.access$300(this.this$1.this$0, this.this$1.val$req, localJSONObject1);
          continue;
          if (this.this$1.val$toolConsume)
          {
            this.this$1.this$0.invokeMidasQuery(localJSONException1, str3, i, m, new PayJsPlugin.9.1.1(this, str3, localJSONException1, i, j, k, n, m));
          }
          else
          {
            String str2 = paramPayResponse.getResultMsg();
            PayJsPlugin.access$200(this.this$1.this$0, this.this$1.val$req, localJSONObject1, str2);
          }
        }
      }
      if (paramPayResponse.getPayChannel() == 8)
      {
        n = 2;
        if ((paramPayResponse.getResultCode() != 0) || (paramPayResponse.getPayState() != 0)) {
          break label613;
        }
        if (!this.this$1.val$toolConsume) {
          break label591;
        }
        if ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str1)) || (i == -1) || (k == -1) || (j == -1) || (n == -1)) {
          break label468;
        }
        this.this$1.this$0.invokeMidasConsume(this.this$1.val$req, str3, str1, i, j, k, n, m);
        bdnw.b("PayJsPlugin", "handleRechargeGame onPayCallBack, , resultCode = " + paramPayResponse.getResultCode() + ", resultMsg = " + paramPayResponse.getResultMsg() + "extendInfo = " + paramPayResponse.getExtendInfo());
      }
    }
    catch (JSONException localJSONException2)
    {
      String str3;
      String str1;
      int n;
      int i3;
      int i;
      int j;
      int k;
      int m;
      label468:
      label613:
      break label21;
    }
  }
  
  public void payNeedLogin()
  {
    bdnw.d("PayJsPlugin", "handleMidasMonthCardPay payNeedLogin");
    PayJsPlugin.access$200(this.this$1.this$0, this.this$1.val$req, null, "payNeedLogin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.PayJsPlugin.9.1
 * JD-Core Version:    0.7.0.1
 */