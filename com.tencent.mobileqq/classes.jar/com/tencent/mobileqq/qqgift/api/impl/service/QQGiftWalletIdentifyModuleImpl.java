package com.tencent.mobileqq.qqgift.api.impl.service;

import android.app.Activity;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftWalletIdentifyModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftWalletIdentifyModule.QQGiftWalletIdentifyCallback;
import com.tencent.mobileqq.qqgift.sso.IQQGiftSsoModule;
import com.tencent.mobileqq.qqgift.sso.QQGiftRspData;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qlive.qlive_real_name_auth_svr.qlive_real_name_auth_svr.nano.GetMQQAuthReq;

public class QQGiftWalletIdentifyModuleImpl
  implements IQQGiftWalletIdentifyModule
{
  private IQQGiftSDK a;
  private QQCustomDialog b;
  private int c = -1;
  
  private void a(IQQGiftWalletIdentifyModule.QQGiftWalletIdentifyCallback paramQQGiftWalletIdentifyCallback) {}
  
  private void a(boolean paramBoolean, QQGiftRspData paramQQGiftRspData, Activity paramActivity, IQQGiftWalletIdentifyModule.QQGiftWalletIdentifyCallback paramQQGiftWalletIdentifyCallback)
  {
    if ((paramQQGiftRspData != null) && (paramQQGiftRspData.a() != null))
    {
      this.c = paramQQGiftRspData.c();
      int i;
      if (paramBoolean)
      {
        i = this.c;
        if (i == 0)
        {
          paramQQGiftWalletIdentifyCallback.identifyFinish(true, i, "");
          return;
        }
        if (i == -11153)
        {
          paramQQGiftWalletIdentifyCallback.identifyFinish(false, i, "未实名认证");
          return;
        }
        if (i == -11154) {
          paramQQGiftWalletIdentifyCallback.identifyFinish(false, i, "未成年暂不支持打赏");
        }
      }
      else
      {
        i = this.c;
        paramQQGiftRspData = new StringBuilder();
        paramQQGiftRspData.append("realNameAuthStatus got wrong, realNameAuthStatus:");
        paramQQGiftRspData.append(this.c);
        paramQQGiftWalletIdentifyCallback.identifyFinish(false, i, paramQQGiftRspData.toString());
      }
      return;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("onReceiveMqqAuthReq data is null! data:");
    paramActivity.append(paramQQGiftRspData);
    QLog.e("QQGiftWalletIdentifyModuleImpl", 1, paramActivity.toString());
    paramQQGiftWalletIdentifyCallback.identifyFinish(false, -3, "出错了，请稍后再试");
  }
  
  private void b(Activity paramActivity, IQQGiftWalletIdentifyModule.QQGiftWalletIdentifyCallback paramQQGiftWalletIdentifyCallback)
  {
    GetMQQAuthReq localGetMQQAuthReq = new GetMQQAuthReq();
    ((IQQGiftSsoModule)this.a.a("sso_module")).a("trpc.qlive.qlive_real_name_auth_svr.QliveRealNameAuthSvr", "GetMQQAuth", GetMQQAuthReq.toByteArray(localGetMQQAuthReq), 101, new QQGiftWalletIdentifyModuleImpl.1(this, paramActivity, paramQQGiftWalletIdentifyCallback));
  }
  
  public void a() {}
  
  public void a(Activity paramActivity, IQQGiftWalletIdentifyModule.QQGiftWalletIdentifyCallback paramQQGiftWalletIdentifyCallback)
  {
    int i = this.c;
    if (i == -1)
    {
      b(paramActivity, paramQQGiftWalletIdentifyCallback);
      return;
    }
    if (i == 0)
    {
      paramQQGiftWalletIdentifyCallback.identifyFinish(true, i, "");
      return;
    }
    if (i == -11153)
    {
      paramQQGiftWalletIdentifyCallback.identifyFinish(false, i, "未实名认证");
      return;
    }
    if (i == -11154)
    {
      paramQQGiftWalletIdentifyCallback.identifyFinish(false, i, "未成年暂不支持打赏");
      return;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("realNameAuthStatus got wrong, realNameAuthStatus:");
    paramActivity.append(this.c);
    paramQQGiftWalletIdentifyCallback.identifyFinish(false, i, paramActivity.toString());
  }
  
  public void a(IQQGiftSDK paramIQQGiftSDK)
  {
    this.a = paramIQQGiftSDK;
    this.c = -1;
  }
  
  public void b()
  {
    this.b = null;
    this.c = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.service.QQGiftWalletIdentifyModuleImpl
 * JD-Core Version:    0.7.0.1
 */