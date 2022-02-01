package com.tencent.mobileqq.utils;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.oidb.cmd0x962.oidb_0x962.FinishInfo;
import tencent.im.oidb.cmd0x962.oidb_0x962.RspBody;

class AIOAnimationControlManager$2
  extends TroopGiftCallback
{
  AIOAnimationControlManager$2(AIOAnimationControlManager paramAIOAnimationControlManager, MessageForDeliverGiftTips paramMessageForDeliverGiftTips, boolean paramBoolean) {}
  
  public void a(int paramInt, oidb_0x962.RspBody paramRspBody)
  {
    if (paramInt == 0)
    {
      this.a.interactState = paramRspBody.uint32_play_state.get();
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkInteract interactId: ");
        ((StringBuilder)localObject1).append(this.a.interactId);
        ((StringBuilder)localObject1).append(", interactState: ");
        ((StringBuilder)localObject1).append(this.a.interactState);
        QLog.d("AIOAnimationControlManager", 2, ((StringBuilder)localObject1).toString());
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
      }
      else
      {
        localObject1 = (List)this.c.n.get(this.a.frienduin);
        paramRspBody = (oidb_0x962.RspBody)localObject1;
        if (localObject1 == null)
        {
          paramRspBody = new ArrayList();
          this.c.n.put(this.a.frienduin, paramRspBody);
        }
      }
      try
      {
        if (!paramRspBody.contains(this.a))
        {
          paramRspBody.add(this.a);
          if (paramRspBody.size() > 5) {
            paramRspBody.remove(0);
          }
        }
        paramRspBody = (List)this.c.e.get(this.a.frienduin);
        if (paramRspBody != null) {
          try
          {
            paramRspBody.remove(this.a);
          }
          finally {}
        }
        if (this.b)
        {
          AIOAnimationControlManager.b(this.c);
          this.c.notifyObservers(this.a);
        }
        this.c.p.getEntityManagerFactory().createEntityManager().update(this.a);
      }
      finally {}
    }
    else if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("checkInteract errorCode: ");
      paramRspBody.append(paramInt);
      QLog.e("AIOAnimationControlManager", 2, paramRspBody.toString());
    }
    this.c.j.post(new AIOAnimationControlManager.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AIOAnimationControlManager.2
 * JD-Core Version:    0.7.0.1
 */