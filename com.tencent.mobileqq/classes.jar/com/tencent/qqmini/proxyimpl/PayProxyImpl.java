package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.mini.app.AppLoaderManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.core.proxy.PayProxy.IPayResultCallBack;

public class PayProxyImpl
  extends PayProxy
{
  private String TAG = "PayProxyImpl";
  
  public Bundle midasPay(Activity paramActivity, String paramString, PayProxy.IPayResultCallBack paramIPayResultCallBack, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null))
    {
      QLog.d(this.TAG, 1, "goMidasPay error, params is null");
      paramActivity = new Bundle();
      paramActivity.putInt("retCode", -1);
      return paramActivity;
    }
    int i = paramBundle.getInt("payparmas_request_code", 0);
    if (i == 0)
    {
      QLog.d(this.TAG, 1, "goMidasPay error, requestSource is empty");
      paramActivity = new Bundle();
      paramActivity.putInt("retCode", -1);
      return paramActivity;
    }
    QLog.d(this.TAG, 1, "goMidasPay requestSource = " + i);
    return PayBridgeActivity.a(AppLoaderManager.sMiniAppInterface, paramActivity, new PayProxyImpl.1(this, new Handler(Looper.getMainLooper()), paramIPayResultCallBack), i, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.PayProxyImpl
 * JD-Core Version:    0.7.0.1
 */