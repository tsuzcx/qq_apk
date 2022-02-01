package com.tencent.mobileqq.qwallet.hb.aio.passwd.impl;

import Wallet.IdiomRedPackMatchReq;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl.OnGetSkeyListener;
import com.tencent.mobileqq.qwallet.impl.QWalletCommonServlet;

class PasswdRedBagServiceImpl$5
  implements VoiceRedPacketHelperImpl.OnGetSkeyListener
{
  PasswdRedBagServiceImpl$5(PasswdRedBagServiceImpl paramPasswdRedBagServiceImpl, PasswdRedBagInfo paramPasswdRedBagInfo, String paramString, BaseSessionInfo paramBaseSessionInfo, long paramLong, int paramInt) {}
  
  public void a(String paramString)
  {
    IdiomRedPackMatchReq localIdiomRedPackMatchReq = new IdiomRedPackMatchReq();
    localIdiomRedPackMatchReq.grabUin = PasswdRedBagServiceImpl.access$200(this.f).getLongAccountUin();
    localIdiomRedPackMatchReq.billno = this.a.a;
    localIdiomRedPackMatchReq.inputIdiom = this.b;
    localIdiomRedPackMatchReq.hbIdiom = PasswdRedBagServiceImpl.access$300(this.f, this.a);
    localIdiomRedPackMatchReq.makeUin = Long.parseLong(this.a.c);
    localIdiomRedPackMatchReq.sKey = paramString;
    localIdiomRedPackMatchReq.appid = AppSetting.d();
    localIdiomRedPackMatchReq.subchannel = this.a.b();
    int j = this.c.a;
    int i = 1;
    if (j != 1) {
      if (this.c.a == 3000) {
        i = 2;
      } else {
        i = 0;
      }
    }
    localIdiomRedPackMatchReq.fromType = i;
    localIdiomRedPackMatchReq.platform = 0;
    localIdiomRedPackMatchReq.qqVersion = "8.8.17";
    QWalletCommonServlet.a(localIdiomRedPackMatchReq, new PasswdRedBagServiceImpl.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.impl.PasswdRedBagServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */