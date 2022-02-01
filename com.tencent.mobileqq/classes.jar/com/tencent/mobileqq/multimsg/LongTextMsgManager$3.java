package com.tencent.mobileqq.multimsg;

import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

final class LongTextMsgManager$3
  implements DownCallBack
{
  LongTextMsgManager$3(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong1, long paramLong2) {}
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    for (;;)
    {
      try
      {
        if ((paramDownResult.jdField_a_of_type_Int != 0) || (paramDownResult.jdField_a_of_type_ArrayOfByte == null)) {
          continue;
        }
        Object localObject1 = new HashMap();
        localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg mr:" + localMessageRecord.toString());
          }
          Object localObject4 = new MessageInfo();
          ((MessageInfo)localObject4).jdField_a_of_type_Int = localMessageRecord.istroop;
          ArrayList localArrayList1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramDownResult.jdField_a_of_type_ArrayOfByte, (HashMap)localObject1, null, (MessageInfo)localObject4);
          if ((localArrayList1 == null) || (localArrayList1.size() != 1) || ((((MessageRecord)localArrayList1.get(0)).msgtype != -1000) && (((MessageRecord)localArrayList1.get(0)).msgtype != -1051) && (((MessageRecord)localArrayList1.get(0)).msgtype != -1035))) {
            continue;
          }
          localObject1 = null;
          if (((MessageRecord)localArrayList1.get(0)).msgtype == -1035)
          {
            localObject1 = (MessageRecord)localArrayList1.get(0);
            MessageRecord.copyMessageRecordStatusField((MessageRecord)localObject1, localMessageRecord);
            ((MessageRecord)localObject1).selfuin = localMessageRecord.selfuin;
            ((MessageRecord)localObject1).frienduin = localMessageRecord.frienduin;
            ((MessageRecord)localObject1).senderuin = localMessageRecord.senderuin;
            ((MessageRecord)localObject1).istroop = localMessageRecord.istroop;
            ((MessageRecord)localObject1).msgId = localMessageRecord.msgId;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
            ((MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a(true, this.jdField_a_of_type_Int);
            if (((((MessageRecord)localArrayList1.get(0)).istroop == 1) && (localMessageRecord.istroop == 1)) || ((((MessageRecord)localArrayList1.get(0)).istroop == 3000) && (localMessageRecord.istroop == 3000) && (localObject4 != null)))
            {
              ((MessageInfo)localObject4).jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(13, this.jdField_a_of_type_Long);
              ((MessageInfo)localObject4).jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(24, this.jdField_a_of_type_Long);
              String str = localMessageRecord.frienduin;
              long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(str, localMessageRecord.istroop);
              if (QLog.isColorLevel()) {
                QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg update MessageInfo-- groupUin:" + str + "lastSeq:" + l + ",shMsgSeq:" + localMessageRecord.shmsgseq + ",msgInfo.hasFlag:" + ((MessageInfo)localObject4).a());
              }
              if ((localMessageRecord.shmsgseq > l) && (((MessageInfo)localObject4).a()))
              {
                localMessageRecord.mMessageInfo = ((MessageInfo)localObject4);
                localObject4 = (BaseMessageManagerForTroopAndDisc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(1);
                ArrayList localArrayList2 = new ArrayList();
                localArrayList2.add(localMessageRecord);
                ((BaseMessageManagerForTroopAndDisc)localObject4).a(str, localArrayList2);
              }
            }
            if ((((MessageRecord)localArrayList1.get(0)).msgtype != -1035) || (localObject1 == null)) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().notifyUI(1000, true, this.jdField_a_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg onDownload success end! cost:" + (System.currentTimeMillis() - this.b));
            }
            ((MessageForLongTextMsg)localMessageRecord).loading = false;
            ((LongTextMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, paramDownResult.jdField_a_of_type_Int, 1);
            return;
          }
          localMessageRecord.msg = ((MessageRecord)localArrayList1.get(0)).msg;
          localMessageRecord.saveExtInfoToExtStr("long_text_recv_state", "1");
          localMessageRecord.removeExtInfoToExtStr("long_text_msg_resid");
          continue;
          if (localObject2 == null) {
            continue;
          }
        }
        catch (Exception localException1)
        {
          localObject2 = localMessageRecord;
        }
      }
      catch (Exception localException2)
      {
        MessageRecord localMessageRecord;
        Object localObject2;
        Object localObject3 = null;
        continue;
      }
      if ((localObject2 instanceof MessageForLongTextMsg))
      {
        ((MessageForLongTextMsg)localObject2).loading = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().notifyUI(999, true, this.jdField_a_of_type_JavaLangString);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg onDownload exception! resultCode:" + paramDownResult.jdField_a_of_type_Int + ",errCode: " + paramDownResult.b + ",errStr:" + paramDownResult.jdField_a_of_type_JavaLangString + ",cost:" + (System.currentTimeMillis() - this.b));
        continue;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, localMessageRecord.msg);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, "extStr", localMessageRecord.extStr);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().notifyUI(999, true, this.jdField_a_of_type_JavaLangString);
        continue;
        ((MessageForLongTextMsg)localMessageRecord).loading = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().notifyUI(999, true, this.jdField_a_of_type_JavaLangString);
        continue;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
        try
        {
          if ((localObject2 instanceof MessageForLongTextMsg))
          {
            ((MessageForLongTextMsg)localObject2).loading = false;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().notifyUI(999, true, this.jdField_a_of_type_JavaLangString);
          }
          if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg onDownload failed! resultCode:" + paramDownResult.jdField_a_of_type_Int + ",errCode: " + paramDownResult.b + ",errStr:" + paramDownResult.jdField_a_of_type_JavaLangString + ",cost:" + (System.currentTimeMillis() - this.b));
          }
        }
        catch (Exception localException3) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.LongTextMsgManager.3
 * JD-Core Version:    0.7.0.1
 */