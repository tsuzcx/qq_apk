package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.mini.app.AppLoaderManager;
import com.tencent.mobileqq.minigame.ui.PayForFriendView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack;

@ProxyService(proxy=PayProxy.class)
public class PayProxyImpl
  extends PayProxy
{
  private String a = "PayProxyImpl";
  
  public void callJs(String paramString, View paramView)
  {
    if ((TextUtils.isEmpty(paramString)) || (!(paramView instanceof PayForFriendView)))
    {
      QLog.d("[minigame] PayForFriendView", 1, "PayProxyImpl callJs: param error");
      return;
    }
    ((PayForFriendView)paramView).callJs(paramString);
  }
  
  public View getPayForFriendView(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    QLog.d("[minigame] PayForFriendView", 1, "PayProxyImpl getPayForFriendView: prepayId:" + paramString1 + " appId:" + paramString2);
    paramContext = new PayForFriendView(paramContext);
    if (paramContext.setUrl(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt)) {
      return paramContext;
    }
    return null;
  }
  
  public Bundle midasPay(Activity paramActivity, String paramString, PayProxy.IPayResultCallBack paramIPayResultCallBack, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null))
    {
      QLog.d(this.a, 1, "goMidasPay error, params is null");
      paramActivity = new Bundle();
      paramActivity.putInt("retCode", -1);
      return paramActivity;
    }
    int i = paramBundle.getInt("payparmas_request_code", 0);
    if (i == 0)
    {
      QLog.d(this.a, 1, "goMidasPay error, requestSource is empty");
      paramActivity = new Bundle();
      paramActivity.putInt("retCode", -1);
      return paramActivity;
    }
    QLog.d(this.a, 1, "goMidasPay requestSource = " + i);
    return PayBridgeActivity.a(AppLoaderManager.sMiniAppInterface, paramActivity, new PayProxyImpl.1(this, new Handler(Looper.getMainLooper()), paramIPayResultCallBack), i, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.PayProxyImpl
 * JD-Core Version:    0.7.0.1
 */