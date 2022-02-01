package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.PayResponse;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$14$1
  implements PayProxy.IPayResultCallBack
{
  PayJsPlugin$14$1(PayJsPlugin.14 param14) {}
  
  public void onPayCallBack(PayProxy.PayResponse paramPayResponse)
  {
    JSONObject localJSONObject1 = new JSONObject();
    label21:
    label544:
    label566:
    try
    {
      localJSONObject1.put("resultCode", paramPayResponse.getResultCode());
      String str3 = null;
      str2 = null;
      String str4 = null;
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
        str2 = str3;
        str1 = str4;
        i = n;
        j = i1;
        k = i2;
      }
      try
      {
        JSONObject localJSONObject2 = new JSONObject(this.this$1.val$callbackSn);
        str2 = str3;
        str1 = str4;
        i = n;
        j = i1;
        k = i2;
        str3 = localJSONObject2.optString("appId", null);
        str2 = str3;
        str1 = str4;
        i = n;
        j = i1;
        k = i2;
        str4 = localJSONObject2.optString("prepayId", null);
        str2 = str3;
        str1 = str4;
        i = n;
        j = i1;
        k = i2;
        i1 = localJSONObject2.optInt("balanceAmount", -1);
        str2 = str3;
        str1 = str4;
        i = n;
        j = i1;
        k = i2;
        i2 = localJSONObject2.optInt("topupAmount", -1);
        str2 = str3;
        str1 = str4;
        i = n;
        j = i1;
        k = i2;
        n = localJSONObject2.optInt("starCurrency", -1);
        str2 = str3;
        str1 = str4;
        i = n;
        j = i1;
        k = i2;
        m = localJSONObject2.optInt("setEnv", 0);
        k = i2;
        j = i1;
        i = n;
        str1 = str4;
        str2 = str3;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          QMLog.e("PayJsPlugin", "", localJSONException2);
          m = i3;
          continue;
          n = 3;
          continue;
          QMLog.i("PayJsPlugin", "handleRechargeGame onPayCallBack, , consumeAppid = " + str2 + ", consumePrepayId = " + str1 + ", consumeStarCurrency = " + i + ", consumeTopupAmount = " + k + ", consumeBalanceAmount = " + j + ", payChannel = " + n);
          continue;
          PayJsPlugin.access$1600(this.this$1.this$0, this.this$1.val$req, localJSONObject1);
          continue;
          if (this.this$1.val$toolConsume)
          {
            this.this$1.this$0.invokeMidasQuery(str1, str2, i, m, new PayJsPlugin.14.1.1(this, str2, str1, i, j, k, n, m));
          }
          else
          {
            str1 = paramPayResponse.getResultMsg();
            PayJsPlugin.access$700(this.this$1.this$0, this.this$1.val$req, localJSONObject1, str1);
          }
        }
      }
      if (paramPayResponse.getPayChannel() == 8)
      {
        n = 2;
        if ((paramPayResponse.getResultCode() != 0) || (paramPayResponse.getPayState() != 0)) {
          break label566;
        }
        if (!this.this$1.val$toolConsume) {
          break label544;
        }
        if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1)) || (i == -1) || (k == -1) || (j == -1) || (n == -1)) {
          break label468;
        }
        this.this$1.this$0.invokeMidasConsume(this.this$1.val$req, str2, str1, i, j, k, n, m);
        QMLog.i("PayJsPlugin", "handleRechargeGame onPayCallBack, , resultCode = " + paramPayResponse.getResultCode() + ", resultMsg = " + paramPayResponse.getResultMsg() + "extendInfo = " + paramPayResponse.getExtendInfo());
      }
    }
    catch (JSONException localJSONException1)
    {
      String str2;
      String str1;
      int n;
      int i3;
      int i;
      int j;
      int k;
      int m;
      label468:
      break label21;
    }
  }
  
  public void payNeedLogin()
  {
    QMLog.e("PayJsPlugin", "handleRechargeGame payNeedLogin");
    PayJsPlugin.access$700(this.this$1.this$0, this.this$1.val$req, null, "payNeedLogin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.14.1
 * JD-Core Version:    0.7.0.1
 */