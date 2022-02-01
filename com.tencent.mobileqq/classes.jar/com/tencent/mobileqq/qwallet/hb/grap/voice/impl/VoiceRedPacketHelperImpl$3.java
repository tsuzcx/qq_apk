package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import Wallet.C2CVoiceInfo;
import Wallet.GroupVoiceInfo;
import Wallet.SongRedPackMatchReq;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.impl.QWalletCommonServlet;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.qphone.base.util.QLog;

class VoiceRedPacketHelperImpl$3
  implements VoiceRedPacketHelperImpl.OnGetSkeyListener
{
  VoiceRedPacketHelperImpl$3(VoiceRedPacketHelperImpl paramVoiceRedPacketHelperImpl, MessageForQQWalletMsg paramMessageForQQWalletMsg1, BaseQQAppInterface paramBaseQQAppInterface, int paramInt, VoiceRedPacketHelperImpl.RecordMsgInfo paramRecordMsgInfo, long paramLong, byte[] paramArrayOfByte, String paramString, MessageForQQWalletMsg paramMessageForQQWalletMsg2, MessageForPtt paramMessageForPtt, BaseTransProcessor paramBaseTransProcessor, BaseMessageObserver paramBaseMessageObserver) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.onError("skey is null");
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.o;
    long l1 = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getLongAccountUin();
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId;
    int j = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.n;
    int k = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.mIsHeadSetOn;
    long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin);
    long l3 = AppSetting.a();
    int m = this.jdField_a_of_type_Int;
    if (m == 0) {}
    while (i != 1)
    {
      localObject = null;
      break;
    }
    Object localObject = new GroupVoiceInfo(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin), this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$RecordMsgInfo.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$RecordMsgInfo.jdField_a_of_type_ArrayOfByte);
    GroupVoiceInfo localGroupVoiceInfo;
    if (this.jdField_a_of_type_Int == 0) {
      localGroupVoiceInfo = null;
    } else {
      localGroupVoiceInfo = new GroupVoiceInfo(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin), this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte);
    }
    C2CVoiceInfo localC2CVoiceInfo1;
    if ((this.jdField_a_of_type_Int == 0) && (i == 1)) {
      localC2CVoiceInfo1 = new C2CVoiceInfo(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$RecordMsgInfo.jdField_a_of_type_JavaLangString);
    } else {
      localC2CVoiceInfo1 = null;
    }
    C2CVoiceInfo localC2CVoiceInfo2;
    if (this.jdField_a_of_type_Int == 0) {
      localC2CVoiceInfo2 = new C2CVoiceInfo(this.jdField_a_of_type_JavaLangString);
    } else {
      localC2CVoiceInfo2 = null;
    }
    paramString = new SongRedPackMatchReq(l1, str, j, i, k, l2, paramString, l3, m, 0, "8.7.0", (GroupVoiceInfo)localObject, localGroupVoiceInfo, localC2CVoiceInfo1, localC2CVoiceInfo2);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SongRedPackMatchReq :");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("VoiceRedPacketHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
    QWalletCommonServlet.a(paramString, new VoiceRedPacketHelperImpl.3.1(this, System.currentTimeMillis()));
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelperImpl", 2, "checkAndSendMessage() sendRequest");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl.3
 * JD-Core Version:    0.7.0.1
 */