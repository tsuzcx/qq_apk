package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.PayResponse;
import org.json.JSONException;
import org.json.JSONObject;

class PayProxyImpl$PayResultRecevicer
  extends ResultReceiver
{
  PayProxy.IPayResultCallBack a;
  
  public PayProxyImpl$PayResultRecevicer(PayProxyImpl paramPayProxyImpl, Handler paramHandler, PayProxy.IPayResultCallBack paramIPayResultCallBack)
  {
    super(paramHandler);
    this.a = paramIPayResultCallBack;
  }
  
  private void a(int paramInt, Bundle paramBundle, String paramString)
  {
    localPayResponse = new PayProxy.PayResponse(this.b);
    paramString = paramBundle.getString("result");
    String str = paramBundle.getString("callbackSn");
    j = -1;
    int i = j;
    if ((TextUtils.isEmpty(str)) || (JSONUtil.isJson(str))) {}
    for (;;)
    {
      try
      {
        i = new JSONObject(str).optInt("seq", -1);
        QLog.d(PayProxyImpl.a(this.b), 2, "onReceiveResult seq = " + i + " callbackSn=" + str + " result = " + paramString);
        JSONObject localJSONObject1 = new JSONObject();
        try
        {
          JSONObject localJSONObject2 = new JSONObject(paramString);
          j = -1;
          paramString = "";
          paramBundle = null;
          if (localJSONObject2 != null)
          {
            j = localJSONObject2.optInt("resultCode", -1);
            paramString = localJSONObject2.optString("resultMsg", "");
            paramBundle = localJSONObject2.optJSONObject("data");
          }
          QLog.d(PayProxyImpl.a(this.b), 1, "onReceiveResult seq = " + i + " callbackSn=" + str + " ret = " + j);
          localJSONObject1.put("resultCode", j);
          localPayResponse.setResultMsg(paramString);
          if (j != 0) {
            break label381;
          }
          localPayResponse.setResultCode(0);
          localPayResponse.setPayState(0);
          if ((paramInt == 9) && (paramBundle != null)) {
            localJSONObject1.put("data", paramBundle);
          }
          localPayResponse.setExtendInfo(localJSONObject1.toString());
          localPayResponse.setPayChannel(localJSONObject2.optInt("payChannel", -1));
        }
        catch (Throwable paramBundle)
        {
          for (;;)
          {
            QLog.e(PayProxyImpl.a(this.b), 1, paramBundle, new Object[0]);
            localPayResponse.setResultCode(-1);
            localPayResponse.setPayState(2);
            continue;
            localPayResponse.setResultCode(j);
            localPayResponse.setPayState(2);
          }
        }
        if (this.a != null) {
          this.a.onPayCallBack(localPayResponse);
        }
        return;
      }
      catch (JSONException paramBundle)
      {
        QLog.e(PayProxyImpl.a(this.b), 1, paramBundle, new Object[0]);
        i = j;
        continue;
      }
      try
      {
        i = Integer.parseInt(str);
      }
      catch (NumberFormatException paramBundle)
      {
        QLog.e(PayProxyImpl.a(this.b), 1, paramBundle, new Object[0]);
        i = j;
      }
      continue;
      label381:
      if (j != -1) {
        break;
      }
      localPayResponse.setResultCode(-1);
      localPayResponse.setPayState(2);
      localPayResponse.setResultMsg(paramString);
    }
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    QLog.d(PayProxyImpl.a(this.b), 2, "onReceiveResult resultCode = " + paramInt + " resultData = " + paramBundle);
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
      a(paramInt, paramBundle, "requestMidasPayment");
      return;
    case 9: 
      a(paramInt, paramBundle, "requestPayment");
      return;
    case 7: 
      a(paramInt, paramBundle, "requestMidasGoodsPay");
      return;
    }
    a(paramInt, paramBundle, "requestMidasMonthCardPay");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.PayProxyImpl.PayResultRecevicer
 * JD-Core Version:    0.7.0.1
 */