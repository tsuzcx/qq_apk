package com.tencent.mobileqq.multimsg;

import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.replymsg.ReplyMsgSender;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

class MultiMsgManager$1
  implements Runnable
{
  MultiMsgManager$1(MultiMsgManager paramMultiMsgManager, SessionInfo paramSessionInfo, ArrayList paramArrayList, QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a().getBooleanArray("forward_write_together_is_expired");
    Object localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int k = 0;
    int i = 0;
    for (;;)
    {
      boolean bool = ((Iterator)localObject4).hasNext();
      j = 1;
      if (!bool) {
        break;
      }
      localObject5 = (ChatMessage)((Iterator)localObject4).next();
      if ((!(localObject5 instanceof MessageForWriteTogether)) || (!((ChatMessage)localObject5).frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (localObject3 == null) || (localObject3[this.jdField_a_of_type_JavaUtilArrayList.indexOf(localObject5)] != 0))
      {
        Object localObject1;
        if (((ChatMessage)localObject5).msgtype == -2000)
        {
          localObject1 = (MessageForPic)localObject5;
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForPic)localObject1, this.jdField_a_of_type_Int);
          j = k + 1;
        }
        else
        {
          if (((ChatMessage)localObject5).msgtype == -2011)
          {
            bool = localObject5 instanceof MessageForStructing;
            if (bool)
            {
              localObject1 = ((MessageForStructing)localObject5).structingMsg;
              if ((localObject1 != null) && ((localObject1 instanceof StructMsgForImageShare)))
              {
                ((AbsStructMsg)localObject1).forwardID = this.jdField_a_of_type_Int;
                StructMsgForImageShare.sendAndUploadImageShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (StructMsgForImageShare)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, 0);
                break label257;
              }
            }
            j = 0;
            label257:
            if ((j == 0) && (bool))
            {
              localObject1 = ((MessageForStructing)localObject5).structingMsg;
              ((AbsStructMsg)localObject1).parentUniseq = ((ChatMessage)localObject5).uniseq;
              ((AbsStructMsg)localObject1).forwardID = this.jdField_a_of_type_Int;
              ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (AbsStructMsg)localObject1, null);
            }
          }
          else
          {
            if (((ChatMessage)localObject5).msgtype != -5008) {
              break label379;
            }
            localObject1 = ((MessageForArkApp)localObject5).ark_app_message;
            ((ArkAppMessage)localObject1).uniSeq = ((ChatMessage)localObject5).uniseq;
            ((ArkAppMessage)localObject1).forwardID = this.jdField_a_of_type_Int;
            ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArkAppMessage)localObject1);
          }
          for (;;)
          {
            break;
            label379:
            if (((ChatMessage)localObject5).msgtype == -5017)
            {
              localObject1 = ((MessageForArkApp)localObject5).ark_app_message;
              ((ArkAppMessage)localObject1).uniSeq = ((ChatMessage)localObject5).uniseq;
              ((ArkAppMessage)localObject1).forwardID = this.jdField_a_of_type_Int;
              ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArkAppMessage)localObject1);
            }
            else if (((ChatMessage)localObject5).msgtype == -5016)
            {
              QLog.e("MultiMsg_TAG", 1, "MSG_TYPE_ARK_BABYQ_REPLY no longer supported");
            }
            else if (((ChatMessage)localObject5).msgtype == -5013)
            {
              localObject1 = ((MessageForArkFlashChat)localObject5).ark_app_message;
              ((ArkFlashChatMessage)localObject1).uniSeq = ((ChatMessage)localObject5).uniseq;
              j = this.jdField_a_of_type_Int;
              ((ArkFlashChatMessage)localObject1).forwardID = j;
              ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArkFlashChatMessage)localObject1, j);
            }
            else if ((((ChatMessage)localObject5).msgtype != -1035) && (((ChatMessage)localObject5).msgtype != -1036))
            {
              if (((ChatMessage)localObject5).msgtype == -2022)
              {
                localObject1 = (MessageForShortVideo)localObject5;
                ((MessageForShortVideo)localObject1).forwardID = this.jdField_a_of_type_Int;
                ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForShortVideo)localObject1);
              }
              else if ((!(localObject5 instanceof MessageForFile)) && (!(localObject5 instanceof MessageForTroopFile)))
              {
                if (((ChatMessage)localObject5).msgtype == -3017)
                {
                  localObject1 = (MessageForDLFile)localObject5;
                  j = ((MessageForDLFile)localObject1).deviceType;
                  long l2 = ((MessageForDLFile)localObject1).associatedId;
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(j).a(l2);
                  if ((localObject1 != null) && (FileUtils.fileExistsAndNotEmpty(((DataLineMsgRecord)localObject1).path))) {
                    this.this$0.a((ChatMessage)localObject5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                  }
                }
                else if ((localObject5 instanceof MessageForReplyText))
                {
                  localObject1 = (MessageForReplyText)localObject5;
                  ReplyMsgSender.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 0, this.jdField_a_of_type_Int, true);
                }
                else
                {
                  localObject1 = ((ChatMessage)localObject5).msg;
                  localObject6 = new ChatActivityFacade.SendMsgParams();
                  ((ChatActivityFacade.SendMsgParams)localObject6).g = true;
                  ((ChatActivityFacade.SendMsgParams)localObject6).j = true;
                  localObject1 = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, null, (ChatActivityFacade.SendMsgParams)localObject6);
                  if ((localObject1 != null) && (localObject1.length > 0))
                  {
                    ForwardOrderManager.a().a(localObject1[0], ((ChatMessage)localObject5).uniseq, this.jdField_a_of_type_Int);
                    ForwardOrderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ChatMessage)localObject5).uniseq, this.jdField_a_of_type_Int);
                  }
                }
              }
              else
              {
                this.this$0.a((ChatMessage)localObject5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              }
            }
            else
            {
              if (((ChatMessage)localObject5).msgtype == -1036)
              {
                localObject1 = (MessageForMixedMsg)((MessageForLongMsg)localObject5).rebuildLongMsg();
                ForwardOrderManager.a().a((MessageRecord)localObject5, (MessageRecord)localObject1, this.jdField_a_of_type_Int);
              }
              else
              {
                localObject1 = (MessageForMixedMsg)localObject5;
              }
              ((MessageForMixedMsg)localObject1).mForwardFromUniSeq = ((ChatMessage)localObject5).uniseq;
              ((MessageForMixedMsg)localObject1).forwardID = this.jdField_a_of_type_Int;
              ReplyMsgSender.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMixedMsg)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Int);
            }
          }
          j = k;
        }
        m = MultiMsgManager.a(this.this$0);
        k = i;
        i = k;
        if (k < m)
        {
          try
          {
            Thread.sleep(MultiMsgManager.b(this.this$0));
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("sendMultuMsgSeperaterFromLocal delay  i = ");
            ((StringBuilder)localObject2).append(k);
            ((StringBuilder)localObject2).append(" mDelayTime = ");
            ((StringBuilder)localObject2).append(MultiMsgManager.b(this.this$0));
            QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject2).toString());
          }
          i = k + 1;
        }
        k = j;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendMultuMsgSeperaterFromLocal sendMsg cost = ");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l1);
      QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    localObject3 = (ChatMessage)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    if (localObject3 != null) {
      i = ((ChatMessage)localObject3).istroop;
    } else {
      i = 0;
    }
    if (i == 0) {
      i = 1;
    } else if (i == 3000) {
      i = 2;
    } else if (i == 1) {
      i = 3;
    } else {
      i = 4;
    }
    if (m == 0) {
      j = 1;
    } else if (m == 3000) {
      j = 2;
    } else if (m == 1) {
      j = 3;
    } else {
      j = 4;
    }
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(i);
    ((StringBuilder)localObject4).append("");
    localObject4 = ((StringBuilder)localObject4).toString();
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append(j);
    ((StringBuilder)localObject5).append("");
    localObject5 = ((StringBuilder)localObject5).toString();
    Object localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append("");
    ((StringBuilder)localObject6).append(this.jdField_a_of_type_JavaUtilArrayList.size());
    localObject6 = ((StringBuilder)localObject6).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(k);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject3, "CliOper", "", (String)localObject2, "0X8004876", "0X8004876", 0, 0, (String)localObject4, (String)localObject5, (String)localObject6, localStringBuilder.toString());
    if (m == 0) {}
    do
    {
      i = 1;
      break label1471;
      if ((m == 3000) || (m == 1)) {
        break label1469;
      }
      if ((m == 1000) || (m == 1004)) {
        break;
      }
    } while (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
    i = 4;
    break label1471;
    i = 3;
    break label1471;
    label1469:
    i = 2;
    label1471:
    m = this.jdField_a_of_type_JavaUtilArrayList.size();
    localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    k = 0;
    int j = 0;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (MessageRecord)((Iterator)localObject3).next();
      if (((MessageRecord)localObject4).msgtype == -2022) {
        k += 1;
      } else if ((((MessageRecord)localObject4).msgtype == -2005) || (((MessageRecord)localObject4).msgtype == -2017)) {
        j += 1;
      }
    }
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(m);
    ((StringBuilder)localObject4).append("");
    localObject4 = ((StringBuilder)localObject4).toString();
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append(m);
    ((StringBuilder)localObject5).append("");
    localObject5 = ((StringBuilder)localObject5).toString();
    localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append("");
    ((StringBuilder)localObject6).append(k);
    localObject6 = ((StringBuilder)localObject6).toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(j);
    ReportController.b((AppRuntime)localObject3, "CliOper", "", (String)localObject2, "0X8009ABF", "0X8009ABF", i, 0, (String)localObject4, (String)localObject5, (String)localObject6, localStringBuilder.toString());
    MultiMsgUtil.a("report_0X8009ABF:fromType:%d,msgCount:%d,msgSize:%d,videoMsgCount:%d,fileMsgCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager.1
 * JD-Core Version:    0.7.0.1
 */