package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$PayResultRecevicer
  extends ResultReceiver
{
  public PayJsPlugin$PayResultRecevicer(PayJsPlugin paramPayJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  private void handlePayResult(int paramInt, Bundle paramBundle, String paramString)
  {
    String str4 = paramBundle.getString("result");
    String str3 = paramBundle.getString("callbackSn");
    String str1 = null;
    localJSONObject1 = null;
    localObject2 = null;
    localJSONObject2 = null;
    int i3 = -1;
    int i2 = -1;
    n = -1;
    int i5 = 0;
    int i4 = -1;
    paramBundle = localJSONObject1;
    Object localObject1 = localJSONObject2;
    int j = n;
    int k = i3;
    int m = i2;
    i = i4;
    int i1 = i5;
    if (!TextUtils.isEmpty(str3))
    {
      if (!JSONUtil.isJson(str3)) {
        break label656;
      }
      paramBundle = str1;
      localObject1 = localObject2;
      j = n;
      k = i3;
      m = i2;
      i = i4;
    }
    for (;;)
    {
      try
      {
        localJSONObject1 = new JSONObject(str3);
        paramBundle = str1;
        localObject1 = localObject2;
        j = n;
        k = i3;
        m = i2;
        i = i4;
        i4 = localJSONObject1.optInt("seq", -1);
        paramBundle = str1;
        localObject1 = localObject2;
        j = n;
        k = i3;
        m = i2;
        i = i4;
        str1 = localJSONObject1.optString("appId", null);
        paramBundle = str1;
        localObject1 = localObject2;
        j = n;
        k = i3;
        m = i2;
        i = i4;
        localObject2 = localJSONObject1.optString("prepayId", null);
        paramBundle = str1;
        localObject1 = localObject2;
        j = n;
        k = i3;
        m = i2;
        i = i4;
        i3 = localJSONObject1.optInt("balanceAmount", -1);
        paramBundle = str1;
        localObject1 = localObject2;
        j = n;
        k = i3;
        m = i2;
        i = i4;
        i2 = localJSONObject1.optInt("topupAmount", -1);
        paramBundle = str1;
        localObject1 = localObject2;
        j = n;
        k = i3;
        m = i2;
        i = i4;
        n = localJSONObject1.optInt("starCurrency", -1);
        paramBundle = str1;
        localObject1 = localObject2;
        j = n;
        k = i3;
        m = i2;
        i = i4;
        i1 = localJSONObject1.optInt("setEnv", 0);
        i = i4;
        m = i2;
        k = i3;
        j = n;
        localObject1 = localObject2;
        paramBundle = str1;
      }
      catch (JSONException localJSONException2)
      {
        QLog.e("PayJsPlugin", 1, localJSONException2, new Object[0]);
        i1 = i5;
        continue;
      }
      QLog.d("PayJsPlugin", 2, "onReceiveResult seq = " + i + " callbackSn=" + str3 + " result = " + str4);
      localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject2 = new JSONObject(str4);
        localObject2 = null;
        if (localJSONObject2 == null) {
          break label944;
        }
        n = localJSONObject2.optInt("resultCode", -1);
        str1 = localJSONObject2.optString("resultMsg", "");
        localObject2 = localJSONObject2.optJSONObject("data");
      }
      catch (Throwable localThrowable1)
      {
        paramBundle = localJSONObject1;
        for (;;)
        {
          QLog.e("PayJsPlugin", 1, localThrowable1, new Object[0]);
          try
          {
            if (PayJsPlugin.access$500(this.this$0)) {
              paramBundle.put("resultCode", -3);
            }
            for (;;)
            {
              PayJsPlugin.access$200(this.this$0, i, paramString, paramBundle, "");
              return;
              if ((paramInt == 9) && (localObject2 != null)) {
                localJSONObject1.put("data", localObject2);
              }
              PayJsPlugin.access$400(this.this$0, i, paramString, localJSONObject1);
              return;
              if (n == -1) {}
              for (paramBundle = ApiUtil.wrapCallbackCancel(paramString, null, localJSONException2);; paramBundle = ApiUtil.wrapCallbackFail(paramString, localJSONObject2, localJSONException2))
              {
                try
                {
                  if (PayJsPlugin.access$500(this.this$0)) {
                    paramBundle.put("resultCode", -3);
                  }
                  if (n != -1) {
                    break label908;
                  }
                  PayJsPlugin.access$000(this.this$0, i, paramString, paramBundle);
                  return;
                }
                catch (Throwable localThrowable2) {}
                break;
              }
              PayJsPlugin.access$200(this.this$0, i, paramString, localJSONObject2, localJSONException2);
              return;
              paramBundle.put("resultCode", -1);
            }
          }
          catch (JSONException localJSONException1)
          {
            for (;;)
            {
              localJSONException1.printStackTrace();
            }
          }
        }
        n = -1;
        String str2 = "";
        continue;
      }
      QLog.d("PayJsPlugin", 1, "onReceiveResult seq = " + i + " callbackSn=" + str3 + " ret = " + n + " miniGameAutoConsume = " + PayJsPlugin.access$500(this.this$0));
      localJSONObject1.put("resultCode", n);
      if (n != 0) {
        break label840;
      }
      if (!PayJsPlugin.access$500(this.this$0)) {
        break label806;
      }
      paramInt = localJSONObject2.optInt("payChannel", -1);
      if ((TextUtils.isEmpty(paramBundle)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (j == -1) || (m == -1) || (k == -1) || (paramInt == -1)) {
        break;
      }
      this.this$0.invokeMidasConsume(paramBundle, (String)localObject1, j, k, m, paramInt, null, paramString, i, i1);
      return;
      try
      {
        label656:
        i = Integer.parseInt(str3);
        paramBundle = localJSONObject1;
        localObject1 = localJSONObject2;
        j = n;
        k = i3;
        m = i2;
        i1 = i5;
      }
      catch (NumberFormatException paramBundle)
      {
        QLog.e("PayJsPlugin", 1, paramBundle, new Object[0]);
        paramBundle = localJSONObject1;
        localObject1 = localJSONObject2;
        j = n;
        k = i3;
        m = i2;
        i = i4;
        i1 = i5;
      }
    }
    localJSONObject1.put("resultCode", -4);
    PayJsPlugin.access$200(this.this$0, i, paramString, localJSONObject1, localJSONException2);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    QLog.d("PayJsPlugin", 2, "onReceiveResult resultCode = " + paramInt + " resultData = " + paramBundle);
    switch (paramInt)
    {
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return;
    case 6: 
      handlePayResult(paramInt, paramBundle, "requestMidasPayment");
      return;
    case 9: 
      handlePayResult(paramInt, paramBundle, "requestPayment");
      return;
    case 7: 
      handlePayResult(paramInt, paramBundle, "requestMidasGoodsPay");
      return;
    }
    handlePayResult(paramInt, paramBundle, "requestMidasMonthCardPay");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PayJsPlugin.PayResultRecevicer
 * JD-Core Version:    0.7.0.1
 */