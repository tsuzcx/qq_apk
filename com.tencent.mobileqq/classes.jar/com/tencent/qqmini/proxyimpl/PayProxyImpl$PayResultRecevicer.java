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
    paramString = new PayProxy.PayResponse(this.b);
    Object localObject1 = paramBundle.getString("result");
    paramBundle = paramBundle.getString("callbackSn");
    if (!TextUtils.isEmpty(paramBundle)) {
      if (JSONUtil.isJson(paramBundle)) {
        try
        {
          i = new JSONObject(paramBundle).optInt("seq", -1);
        }
        catch (JSONException localJSONException)
        {
          QLog.e(PayProxyImpl.a(this.b), 1, localJSONException, new Object[0]);
          break label110;
        }
      } else {
        try
        {
          i = Integer.parseInt(paramBundle);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e(PayProxyImpl.a(this.b), 1, localNumberFormatException, new Object[0]);
        }
      }
    }
    label110:
    int i = -1;
    Object localObject2 = PayProxyImpl.a(this.b);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("onReceiveResult seq = ");
    ((StringBuilder)localObject3).append(i);
    ((StringBuilder)localObject3).append(" callbackSn=");
    ((StringBuilder)localObject3).append(paramBundle);
    ((StringBuilder)localObject3).append(" result = ");
    ((StringBuilder)localObject3).append((String)localObject1);
    QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    localObject2 = new JSONObject();
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      int j = ((JSONObject)localObject1).optInt("resultCode", -1);
      localObject3 = ((JSONObject)localObject1).optString("resultMsg", "");
      JSONObject localJSONObject = ((JSONObject)localObject1).optJSONObject("data");
      String str = PayProxyImpl.a(this.b);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveResult seq = ");
      localStringBuilder.append(i);
      localStringBuilder.append(" callbackSn=");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(" ret = ");
      localStringBuilder.append(j);
      QLog.d(str, 1, localStringBuilder.toString());
      ((JSONObject)localObject2).put("resultCode", j);
      paramString.setResultMsg((String)localObject3);
      if (j == 0)
      {
        paramString.setResultCode(0);
        paramString.setPayState(0);
        if ((paramInt == 9) && (localJSONObject != null)) {
          ((JSONObject)localObject2).put("data", localJSONObject);
        }
        paramString.setExtendInfo(((JSONObject)localObject2).toString());
        paramString.setPayChannel(((JSONObject)localObject1).optInt("payChannel", -1));
      }
      else
      {
        if (j == -1)
        {
          paramString.setResultCode(-1);
          paramString.setPayState(2);
        }
        else
        {
          paramString.setResultCode(j);
          paramString.setPayState(2);
        }
        paramString.setResultMsg((String)localObject3);
      }
    }
    catch (Throwable paramBundle)
    {
      QLog.e(PayProxyImpl.a(this.b), 1, paramBundle, new Object[0]);
      paramString.setResultCode(-1);
      paramString.setPayState(2);
    }
    paramBundle = this.a;
    if (paramBundle != null) {
      paramBundle.onPayCallBack(paramString);
    }
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    String str = PayProxyImpl.a(this.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveResult resultCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" resultData = ");
    localStringBuilder.append(paramBundle);
    QLog.d(str, 2, localStringBuilder.toString());
    if (paramInt != 6)
    {
      if (paramInt != 7)
      {
        if (paramInt != 9)
        {
          if (paramInt != 14) {
            return;
          }
          a(paramInt, paramBundle, "requestMidasMonthCardPay");
          return;
        }
        a(paramInt, paramBundle, "requestPayment");
        return;
      }
      a(paramInt, paramBundle, "requestMidasGoodsPay");
      return;
    }
    a(paramInt, paramBundle, "requestMidasPayment");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.PayProxyImpl.PayResultRecevicer
 * JD-Core Version:    0.7.0.1
 */