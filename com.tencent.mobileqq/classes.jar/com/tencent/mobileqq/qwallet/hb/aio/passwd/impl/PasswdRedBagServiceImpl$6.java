package com.tencent.mobileqq.qwallet.hb.aio.passwd.impl;

import Wallet.GetRandomHbIdiomReq;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl.OnGetSkeyListener;
import com.tencent.mobileqq.qwallet.impl.QWalletCommonServlet;
import mqq.observer.BusinessObserver;

class PasswdRedBagServiceImpl$6
  implements VoiceRedPacketHelperImpl.OnGetSkeyListener
{
  PasswdRedBagServiceImpl$6(PasswdRedBagServiceImpl paramPasswdRedBagServiceImpl, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver) {}
  
  public void a(String paramString)
  {
    if (PasswdRedBagServiceImpl.access$200(this.d) != null)
    {
      GetRandomHbIdiomReq localGetRandomHbIdiomReq = new GetRandomHbIdiomReq();
      localGetRandomHbIdiomReq.makeUin = PasswdRedBagServiceImpl.access$200(this.d).getLongAccountUin();
      localGetRandomHbIdiomReq.subchannel = this.a;
      localGetRandomHbIdiomReq.sKey = paramString;
      localGetRandomHbIdiomReq.appid = AppSetting.d();
      localGetRandomHbIdiomReq.fromType = this.b;
      localGetRandomHbIdiomReq.platform = 0;
      localGetRandomHbIdiomReq.qqVersion = "8.8.17";
      QWalletCommonServlet.a(localGetRandomHbIdiomReq, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.impl.PasswdRedBagServiceImpl.6
 * JD-Core Version:    0.7.0.1
 */