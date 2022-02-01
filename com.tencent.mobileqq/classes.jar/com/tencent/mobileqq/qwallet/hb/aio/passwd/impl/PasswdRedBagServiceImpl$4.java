package com.tencent.mobileqq.qwallet.hb.aio.passwd.impl;

import Wallet.GetBroadCastHbIdiomReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl.OnGetSkeyListener;
import com.tencent.mobileqq.qwallet.impl.QWalletCommonServlet;
import java.util.ArrayList;

class PasswdRedBagServiceImpl$4
  implements VoiceRedPacketHelperImpl.OnGetSkeyListener
{
  PasswdRedBagServiceImpl$4(PasswdRedBagServiceImpl paramPasswdRedBagServiceImpl, ArrayList paramArrayList, BaseSessionInfo paramBaseSessionInfo) {}
  
  public void a(String paramString)
  {
    GetBroadCastHbIdiomReq localGetBroadCastHbIdiomReq = new GetBroadCastHbIdiomReq();
    localGetBroadCastHbIdiomReq.billnos = this.a;
    localGetBroadCastHbIdiomReq.sKey = paramString;
    localGetBroadCastHbIdiomReq.appid = AppSetting.d();
    int j = this.b.a;
    int i = 1;
    if (j != 1) {
      if (this.b.a == 3000) {
        i = 2;
      } else {
        i = 0;
      }
    }
    localGetBroadCastHbIdiomReq.fromType = i;
    localGetBroadCastHbIdiomReq.platform = 0;
    localGetBroadCastHbIdiomReq.qqVersion = "8.8.17";
    QWalletCommonServlet.a(localGetBroadCastHbIdiomReq, new PasswdRedBagServiceImpl.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.impl.PasswdRedBagServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */