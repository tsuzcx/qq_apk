package com.tencent.mobileqq.mixedmsg;

import acvh;
import arno;
import atpl;
import avau;
import awbi;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MixedMsgManager$1
  implements Runnable
{
  public MixedMsgManager$1(arno paramarno, SessionInfo paramSessionInfo, int paramInt, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.a.getAccount();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b;
    localObject2 = awbi.a(this.this$0.a, str, (String)localObject2, j);
    int i;
    if (this.jdField_a_of_type_Int == 0)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.forwardID;
      acvh.a().a(((MessageForMixedMsg)localObject2).uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq, i);
      ((MessageForMixedMsg)localObject2).extraflag = 32772;
      ((MessageForMixedMsg)localObject2).msgData = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgData;
      ((MessageForMixedMsg)localObject2).msgElemList = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgElemList;
      if (this.jdField_a_of_type_Boolean) {
        break label208;
      }
      ((MessageForMixedMsg)localObject2).mForwardFromIsTroop = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop;
      ((MessageForMixedMsg)localObject2).mForwardFromUin = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin;
    }
    for (;;)
    {
      localObject3 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
        if ((localMessageRecord instanceof MessageForPic)) {
          localMessageRecord.istroop = j;
        }
      }
      i = this.jdField_a_of_type_Int;
      break;
      label208:
      ((MessageForMixedMsg)localObject2).mIsResend = true;
    }
    ((MessageForMixedMsg)localObject2).prewrite();
    Object localObject3 = (avau)this.this$0.a.getManager(326);
    ((avau)localObject3).a(str, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq, ((MessageForMixedMsg)localObject2).uniseq);
    ((avau)localObject3).a((MessageRecord)localObject2, null);
    this.this$0.a.a().notifyUI(1000, true, str);
    localObject3 = new ArrayList();
    localObject1 = atpl.a(7, (MessageForMixedMsg)localObject2, j, (String)localObject1, str, this.this$0.a.getAccount());
    if (localObject1 != null) {
      ((ArrayList)localObject3).addAll((Collection)localObject1);
    }
    while (((ArrayList)localObject3).size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "[forwardMixedMsg]Upload pictures, count is [" + ((ArrayList)localObject3).size() + "], goto requestUploadPics");
      }
      arno.a(this.this$0, this.this$0.a, str, j, (ArrayList)localObject3, (MessageForMixedMsg)localObject2);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("MixedMsgManager", 2, "[forwardMixedMsg]createForwardPicInfos from MessageForMixedMsg failed");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "[forwardMixedMsg]There's not any picture messages, goto onPackAndSendMsg");
    }
    arno.a(this.this$0, this.this$0.a, str, j, (MessageForMixedMsg)localObject2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgManager.1
 * JD-Core Version:    0.7.0.1
 */