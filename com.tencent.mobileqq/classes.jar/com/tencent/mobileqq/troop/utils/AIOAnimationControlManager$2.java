package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
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
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactState = paramRspBody.uint32_play_state.get();
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkInteract interactId: ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactId);
        ((StringBuilder)localObject1).append(", interactState: ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactState);
        QLog.d("AIOAnimationControlManager", 2, ((StringBuilder)localObject1).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.alreadyPlayMicroseconds = paramRspBody.uint64_already_pay_microseconds.get();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.playTotalMicroseconds = paramRspBody.uint64_play_total_microseconds.get();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactState == 2) && (paramRspBody.msg_finish_info.has()))
      {
        paramRspBody = (oidb_0x962.FinishInfo)paramRspBody.msg_finish_info.get();
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactText = paramRspBody.bytes_text.get().toStringUtf8();
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.participateNum = paramRspBody.uint32_participate_num.get();
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactFirstUin = paramRspBody.uint64_first_uin.get();
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactFirstNickname = paramRspBody.bytes_first_nick_name.get().toStringUtf8();
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interacEndtUrl = paramRspBody.bytes_url.get().toStringUtf8();
      }
      else
      {
        localObject1 = (List)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.c.get(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin);
        paramRspBody = (oidb_0x962.RspBody)localObject1;
        if (localObject1 == null)
        {
          paramRspBody = new ArrayList();
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.c.put(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, paramRspBody);
        }
      }
      try
      {
        if (!paramRspBody.contains(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips))
        {
          paramRspBody.add(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
          if (paramRspBody.size() > 5) {
            paramRspBody.remove(0);
          }
        }
        paramRspBody = (List)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.b.get(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin);
        if (paramRspBody != null) {
          try
          {
            paramRspBody.remove(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
          }
          finally {}
        }
        if (this.jdField_a_of_type_Boolean)
        {
          AIOAnimationControlManager.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager);
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.notifyObservers(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager().update(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
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
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_AndroidOsHandler.post(new AIOAnimationControlManager.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.2
 * JD-Core Version:    0.7.0.1
 */