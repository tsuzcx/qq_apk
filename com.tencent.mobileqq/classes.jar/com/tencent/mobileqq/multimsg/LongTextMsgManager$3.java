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
    Object localObject2 = ",errStr:";
    label653:
    label820:
    try
    {
      if ((paramDownResult.jdField_a_of_type_Int == 0) && (paramDownResult.jdField_a_of_type_ArrayOfByte != null))
      {
        localObject1 = new HashMap();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
      }
    }
    catch (Exception localException1)
    {
      Object localObject1;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      String str;
      long l;
      StringBuilder localStringBuilder;
      label583:
      label881:
      break label1121;
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("requestDownloadLongTextMsg mr:");
          ((StringBuilder)localObject4).append(((MessageRecord)localObject3).toString());
          QLog.d("StructLongTextMsg", 2, ((StringBuilder)localObject4).toString());
        }
        localObject5 = new MessageInfo();
        ((MessageInfo)localObject5).jdField_a_of_type_Int = ((MessageRecord)localObject3).istroop;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramDownResult.jdField_a_of_type_ArrayOfByte, (HashMap)localObject1, null, (MessageInfo)localObject5);
        if ((localObject4 != null) && (((ArrayList)localObject4).size() == 1) && ((((MessageRecord)((ArrayList)localObject4).get(0)).msgtype == -1000) || (((MessageRecord)((ArrayList)localObject4).get(0)).msgtype == -1051) || (((MessageRecord)((ArrayList)localObject4).get(0)).msgtype == -1035)))
        {
          if (((MessageRecord)((ArrayList)localObject4).get(0)).msgtype == -1035)
          {
            localObject1 = (MessageRecord)((ArrayList)localObject4).get(0);
            MessageRecord.copyMessageRecordStatusField((MessageRecord)localObject1, (MessageRecord)localObject3);
            ((MessageRecord)localObject1).selfuin = ((MessageRecord)localObject3).selfuin;
            ((MessageRecord)localObject1).frienduin = ((MessageRecord)localObject3).frienduin;
            ((MessageRecord)localObject1).senderuin = ((MessageRecord)localObject3).senderuin;
            ((MessageRecord)localObject1).istroop = ((MessageRecord)localObject3).istroop;
            ((MessageRecord)localObject1).msgId = ((MessageRecord)localObject3).msgId;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop, ((MessageRecord)localObject3).uniseq);
            ((MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a(true, this.jdField_a_of_type_Int);
          }
          else
          {
            ((MessageRecord)localObject3).msg = ((MessageRecord)((ArrayList)localObject4).get(0)).msg;
            ((MessageRecord)localObject3).saveExtInfoToExtStr("long_text_recv_state", "1");
            ((MessageRecord)localObject3).removeExtInfoToExtStr("long_text_msg_resid");
            localObject1 = null;
          }
          if (((((MessageRecord)((ArrayList)localObject4).get(0)).istroop != 1) || (((MessageRecord)localObject3).istroop != 1)) && ((((MessageRecord)((ArrayList)localObject4).get(0)).istroop != 3000) || (((MessageRecord)localObject3).istroop != 3000))) {
            continue;
          }
          ((MessageInfo)localObject5).jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(13, this.jdField_a_of_type_Long);
          ((MessageInfo)localObject5).jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(24, this.jdField_a_of_type_Long);
          str = ((MessageRecord)localObject3).frienduin;
          l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(str, ((MessageRecord)localObject3).istroop);
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("requestDownloadLongTextMsg update MessageInfo-- groupUin:");
          localStringBuilder.append(str);
          localStringBuilder.append("lastSeq:");
          localStringBuilder.append(l);
          localStringBuilder.append(",shMsgSeq:");
        }
      }
      catch (Exception localException2)
      {
        break label881;
        break label583;
        break label653;
      }
      try
      {
        localStringBuilder.append(((MessageRecord)localObject3).shmsgseq);
        localStringBuilder.append(",msgInfo.hasFlag:");
        localStringBuilder.append(((MessageInfo)localObject5).a());
        QLog.d("StructLongTextMsg", 2, localStringBuilder.toString());
        if ((((MessageRecord)localObject3).shmsgseq > l) && (((MessageInfo)localObject5).a()))
        {
          ((MessageRecord)localObject3).mMessageInfo = ((MessageInfo)localObject5);
          localObject2 = (BaseMessageManagerForTroopAndDisc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(1);
          localObject5 = new ArrayList();
          ((ArrayList)localObject5).add(localObject3);
          ((BaseMessageManagerForTroopAndDisc)localObject2).a(str, (ArrayList)localObject5);
        }
        if ((((MessageRecord)((ArrayList)localObject4).get(0)).msgtype == -1035) && (localObject1 != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().notifyUI(1000, true, this.jdField_a_of_type_JavaLangString);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, ((MessageRecord)localObject3).msg);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, "extStr", ((MessageRecord)localObject3).extStr);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().notifyUI(999, true, this.jdField_a_of_type_JavaLangString);
          break label820;
          ((MessageForLongTextMsg)localObject3).loading = false;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().notifyUI(999, true, this.jdField_a_of_type_JavaLangString);
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("requestDownloadLongTextMsg onDownload success end! cost:");
          ((StringBuilder)localObject1).append(System.currentTimeMillis() - this.b);
          QLog.d("StructLongTextMsg", 2, ((StringBuilder)localObject1).toString());
        }
        ((MessageForLongTextMsg)localObject3).loading = false;
      }
      catch (Exception localException3)
      {
        break label976;
      }
    }
    localObject4 = ",cost:";
    localObject1 = localObject2;
    localObject2 = localObject4;
    break label1133;
    localObject2 = ",cost:";
    localObject3 = ",errStr:";
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
    }
    catch (Exception localException4)
    {
      boolean bool;
      label972:
      label976:
      break label1118;
    }
    try
    {
      bool = localObject1 instanceof MessageForLongTextMsg;
      if (!bool) {}
    }
    catch (Exception localException5)
    {
      break label1098;
    }
    try
    {
      ((MessageForLongTextMsg)localObject1).loading = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().notifyUI(999, true, this.jdField_a_of_type_JavaLangString);
    }
    catch (Exception localException6)
    {
      break label972;
    }
    localObject3 = localObject1;
    localObject2 = ",cost:";
    localObject1 = ",errStr:";
    break label1133;
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("requestDownloadLongTextMsg onDownload failed! resultCode:");
      ((StringBuilder)localObject4).append(paramDownResult.jdField_a_of_type_Int);
      ((StringBuilder)localObject4).append(",errCode: ");
      ((StringBuilder)localObject4).append(paramDownResult.b);
    }
    try
    {
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append(paramDownResult.jdField_a_of_type_JavaLangString);
    }
    catch (Exception localException7)
    {
      label1095:
      label1098:
      break label1095;
    }
    try
    {
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append(System.currentTimeMillis() - this.b);
      QLog.d("StructLongTextMsg", 2, ((StringBuilder)localObject4).toString());
    }
    catch (Exception localException8)
    {
      break label1098;
    }
    localObject2 = ",cost:";
    localObject4 = ",errStr:";
    localObject3 = localObject1;
    localObject1 = localObject4;
    break label1133;
    label1118:
    label1121:
    localObject2 = ",cost:";
    localObject1 = ",errStr:";
    localObject3 = null;
    label1133:
    if ((localObject3 != null) && ((localObject3 instanceof MessageForLongTextMsg)))
    {
      ((MessageForLongTextMsg)localObject3).loading = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().notifyUI(999, true, this.jdField_a_of_type_JavaLangString);
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("requestDownloadLongTextMsg onDownload exception! resultCode:");
      ((StringBuilder)localObject3).append(paramDownResult.jdField_a_of_type_Int);
      ((StringBuilder)localObject3).append(",errCode: ");
      ((StringBuilder)localObject3).append(paramDownResult.b);
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(paramDownResult.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(System.currentTimeMillis() - this.b);
      QLog.d("StructLongTextMsg", 2, ((StringBuilder)localObject3).toString());
    }
    ((LongTextMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, paramDownResult.jdField_a_of_type_Int, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.LongTextMsgManager.3
 * JD-Core Version:    0.7.0.1
 */