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
      this.l.onError("skey is null");
      return;
    }
    int m = this.a.mQQWalletRedPacketMsg.elem.C;
    long l1 = this.b.getLongAccountUin();
    String str = this.a.mQQWalletRedPacketMsg.redPacketId;
    int n = this.a.mQQWalletRedPacketMsg.elem.B;
    int i1 = this.l.mIsHeadSetOn;
    long l2 = Long.parseLong(this.a.senderuin);
    long l3 = AppSetting.d();
    int i2 = this.c;
    if (i2 == 0) {}
    while (m != 1)
    {
      localObject = null;
      break;
    }
    Object localObject = new GroupVoiceInfo(Long.parseLong(this.a.frienduin), this.d.b, this.d.c);
    GroupVoiceInfo localGroupVoiceInfo;
    if (this.c == 0) {
      localGroupVoiceInfo = null;
    } else {
      localGroupVoiceInfo = new GroupVoiceInfo(Long.parseLong(this.a.frienduin), this.e, this.f);
    }
    C2CVoiceInfo localC2CVoiceInfo1;
    if ((this.c == 0) && (m == 1)) {
      localC2CVoiceInfo1 = new C2CVoiceInfo(this.d.d);
    } else {
      localC2CVoiceInfo1 = null;
    }
    C2CVoiceInfo localC2CVoiceInfo2;
    if (this.c == 0) {
      localC2CVoiceInfo2 = new C2CVoiceInfo(this.g);
    } else {
      localC2CVoiceInfo2 = null;
    }
    paramString = new SongRedPackMatchReq(l1, str, n, m, i1, l2, paramString, l3, i2, 0, "8.8.17", (GroupVoiceInfo)localObject, localGroupVoiceInfo, localC2CVoiceInfo1, localC2CVoiceInfo2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl.3
 * JD-Core Version:    0.7.0.1
 */