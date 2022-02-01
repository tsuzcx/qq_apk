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
    localIdiomRedPackMatchReq.grabUin = PasswdRedBagServiceImpl.access$600(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagServiceImpl).getLongAccountUin();
    localIdiomRedPackMatchReq.billno = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdPasswdRedBagInfo.jdField_a_of_type_JavaLangString;
    localIdiomRedPackMatchReq.inputIdiom = this.jdField_a_of_type_JavaLangString;
    localIdiomRedPackMatchReq.hbIdiom = PasswdRedBagServiceImpl.access$700(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdImplPasswdRedBagServiceImpl, this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdPasswdRedBagInfo);
    localIdiomRedPackMatchReq.makeUin = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdPasswdRedBagInfo.c);
    localIdiomRedPackMatchReq.sKey = paramString;
    localIdiomRedPackMatchReq.appid = AppSetting.a();
    localIdiomRedPackMatchReq.subchannel = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdPasswdRedBagInfo.a();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int;
    int i = 1;
    if (j != 1) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000) {
        i = 2;
      } else {
        i = 0;
      }
    }
    localIdiomRedPackMatchReq.fromType = i;
    localIdiomRedPackMatchReq.platform = 0;
    localIdiomRedPackMatchReq.qqVersion = "8.7.0";
    QWalletCommonServlet.a(localIdiomRedPackMatchReq, new PasswdRedBagServiceImpl.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.impl.PasswdRedBagServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */