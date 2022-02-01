package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x962.oidb_0x962.FinishInfo;
import tencent.im.oidb.cmd0x962.oidb_0x962.RspBody;

class TroopInteractGiftAnimationController$2
  extends TroopGiftCallback
{
  TroopInteractGiftAnimationController$2(TroopInteractGiftAnimationController paramTroopInteractGiftAnimationController, int paramInt, String paramString, MessageForDeliverGiftTips paramMessageForDeliverGiftTips, boolean paramBoolean) {}
  
  public void a(int paramInt, oidb_0x962.RspBody paramRspBody)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportInteract: errorCode = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", times = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", giftID = ");
      localStringBuilder.append(this.b);
      QLog.d("TroopInteractGiftAnimationController", 2, localStringBuilder.toString());
    }
    this.c.interactState = paramRspBody.uint32_play_state.get();
    this.c.alreadyPlayMicroseconds = paramRspBody.uint64_already_pay_microseconds.get();
    this.c.playTotalMicroseconds = paramRspBody.uint64_play_total_microseconds.get();
    if ((this.c.interactState == 2) && (paramRspBody.msg_finish_info.has()))
    {
      paramRspBody = (oidb_0x962.FinishInfo)paramRspBody.msg_finish_info.get();
      this.c.interactText = paramRspBody.bytes_text.get().toStringUtf8();
      this.c.participateNum = paramRspBody.uint32_participate_num.get();
      this.c.interactFirstUin = paramRspBody.uint64_first_uin.get();
      this.c.interactFirstNickname = paramRspBody.bytes_first_nick_name.get().toStringUtf8();
      this.c.interacEndtUrl = paramRspBody.bytes_url.get().toStringUtf8();
    }
    if ((this.e.a != null) && (this.d)) {
      this.e.a.d.getEntityManagerFactory().createEntityManager().update(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.2
 * JD-Core Version:    0.7.0.1
 */