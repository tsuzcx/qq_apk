package com.tencent.mobileqq.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;
import tencent.im.oidb.cmd0x962.oidb_0x962.FinishInfo;
import tencent.im.oidb.cmd0x962.oidb_0x962.RspBody;

class AIOAnimationControlManager$9
  extends TroopGiftCallback
{
  AIOAnimationControlManager$9(AIOAnimationControlManager paramAIOAnimationControlManager, MessageForDeliverGiftTips paramMessageForDeliverGiftTips, List paramList1, boolean paramBoolean, List paramList2, String paramString) {}
  
  public void a(int paramInt, oidb_0x962.RspBody paramRspBody)
  {
    if (paramInt == 0)
    {
      this.a.interactState = paramRspBody.uint32_play_state.get();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkInteract interactId: ");
        localStringBuilder.append(this.a.interactId);
        localStringBuilder.append(", interactState: ");
        localStringBuilder.append(this.a.interactState);
        QLog.d("AIOAnimationControlManager", 2, localStringBuilder.toString());
      }
      this.a.alreadyPlayMicroseconds = paramRspBody.uint64_already_pay_microseconds.get();
      this.a.playTotalMicroseconds = paramRspBody.uint64_play_total_microseconds.get();
      if ((this.a.interactState == 2) && (paramRspBody.msg_finish_info.has()))
      {
        paramRspBody = (oidb_0x962.FinishInfo)paramRspBody.msg_finish_info.get();
        this.a.interactText = paramRspBody.bytes_text.get().toStringUtf8();
        this.a.participateNum = paramRspBody.uint32_participate_num.get();
        this.a.interactFirstUin = paramRspBody.uint64_first_uin.get();
        this.a.interactFirstNickname = paramRspBody.bytes_first_nick_name.get().toStringUtf8();
        this.a.interacEndtUrl = paramRspBody.bytes_url.get().toStringUtf8();
        this.b.remove(this.a);
        if (this.c)
        {
          this.f.a(this.a, false);
          if (this.b.isEmpty())
          {
            paramRspBody = this.d;
            if (paramRspBody != null) {
              Collections.sort(paramRspBody, this.f.r);
            }
          }
        }
        paramRspBody = this.f;
        paramRspBody.a = 1;
        paramRspBody.a(this.c);
      }
      else
      {
        this.f.k();
        this.f.a = 2;
        if (this.c)
        {
          paramRspBody = this.d;
          if (paramRspBody != null) {
            paramRspBody.clear();
          }
        }
        if (this.f.g != null)
        {
          this.b.remove(this.a);
          this.f.m.a(this.a, this.e, true, new AIOAnimationControlManager.9.1(this));
        }
      }
      this.f.p.getEntityManagerFactory().createEntityManager().update(this.a);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("checkInteract errorCode: ");
      paramRspBody.append(paramInt);
      QLog.e("AIOAnimationControlManager", 2, paramRspBody.toString());
    }
    this.b.remove(this.a);
    if (!this.c)
    {
      this.f.a(this.a, false);
      if (this.b.isEmpty()) {
        Collections.sort(this.d, this.f.r);
      }
    }
    paramRspBody = this.f;
    paramRspBody.a = 1;
    paramRspBody.a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AIOAnimationControlManager.9
 * JD-Core Version:    0.7.0.1
 */