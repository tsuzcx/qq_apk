package com.tencent.mobileqq.multimsg;

import aean;
import aeau;
import agsg;
import android.content.Intent;
import android.os.Bundle;
import aunj;
import axpf;
import axpm;
import bbdn;
import bdll;
import bhse;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
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
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiMsgManager$1
  implements Runnable
{
  public MultiMsgManager$1(axpf paramaxpf, SessionInfo paramSessionInfo, ArrayList paramArrayList, QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a().getBooleanArray("forward_write_together_is_expired");
    Object localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int j = 0;
    int i = 0;
    ChatMessage localChatMessage;
    Object localObject1;
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localChatMessage = (ChatMessage)((Iterator)localObject3).next();
        if ((!(localChatMessage instanceof MessageForWriteTogether)) || (!localChatMessage.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (localObject2 == null) || (localObject2[this.jdField_a_of_type_JavaUtilArrayList.indexOf(localChatMessage)] != 0)) {
          if (localChatMessage.msgtype == -2000)
          {
            localObject1 = (MessageForPic)localChatMessage;
            aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForPic)localObject1, this.jdField_a_of_type_Int);
            i += 1;
            label150:
            if (j >= axpf.a(this.this$0)) {
              break label1610;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        Thread.sleep(axpf.b(this.this$0));
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "sendMultuMsgSeperaterFromLocal delay  i = " + j + " mDelayTime = " + axpf.b(this.this$0));
        }
        j += 1;
        break;
        if (localChatMessage.msgtype == -2011)
        {
          if (!(localChatMessage instanceof MessageForStructing)) {
            break label1613;
          }
          localObject1 = ((MessageForStructing)localChatMessage).structingMsg;
          if ((localObject1 == null) || (!(localObject1 instanceof StructMsgForImageShare))) {
            break label1613;
          }
          ((AbsStructMsg)localObject1).forwardID = this.jdField_a_of_type_Int;
          StructMsgForImageShare.sendAndUploadImageShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (StructMsgForImageShare)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, 0);
          k = 1;
          if ((k == 0) && ((localChatMessage instanceof MessageForStructing)))
          {
            localObject1 = ((MessageForStructing)localChatMessage).structingMsg;
            ((AbsStructMsg)localObject1).parentUniseq = localChatMessage.uniseq;
            ((AbsStructMsg)localObject1).forwardID = this.jdField_a_of_type_Int;
            bhse.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (AbsStructMsg)localObject1, null);
          }
          break label150;
        }
        if (localChatMessage.msgtype == -5008)
        {
          localObject1 = ((MessageForArkApp)localChatMessage).ark_app_message;
          ((ArkAppMessage)localObject1).uniSeq = localChatMessage.uniseq;
          ((ArkAppMessage)localObject1).forwardID = this.jdField_a_of_type_Int;
          aean.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArkAppMessage)localObject1);
          break label150;
        }
        if (localChatMessage.msgtype == -5017)
        {
          localObject1 = ((MessageForArkApp)localChatMessage).ark_app_message;
          ((ArkAppMessage)localObject1).uniSeq = localChatMessage.uniseq;
          ((ArkAppMessage)localObject1).forwardID = this.jdField_a_of_type_Int;
          aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArkAppMessage)localObject1);
          break label150;
        }
        if (localChatMessage.msgtype == -5016)
        {
          QLog.e("MultiMsg_TAG", 1, "MSG_TYPE_ARK_BABYQ_REPLY no longer supported");
          break label150;
        }
        if (localChatMessage.msgtype == -5013)
        {
          localObject1 = ((MessageForArkFlashChat)localChatMessage).ark_app_message;
          ((ArkFlashChatMessage)localObject1).uniSeq = localChatMessage.uniseq;
          ((ArkFlashChatMessage)localObject1).forwardID = this.jdField_a_of_type_Int;
          aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArkFlashChatMessage)localObject1, this.jdField_a_of_type_Int);
          break label150;
        }
        if ((localChatMessage.msgtype == -1035) || (localChatMessage.msgtype == -1036))
        {
          if (localChatMessage.msgtype == -1036)
          {
            localObject1 = (MessageForMixedMsg)((MessageForLongMsg)localChatMessage).rebuildLongMsg();
            agsg.a().a(localChatMessage, (MessageRecord)localObject1, this.jdField_a_of_type_Int);
            ((MessageForMixedMsg)localObject1).mForwardFromUniSeq = localChatMessage.uniseq;
            ((MessageForMixedMsg)localObject1).forwardID = this.jdField_a_of_type_Int;
            bbdn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMixedMsg)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Int);
            break label150;
          }
          localObject1 = (MessageForMixedMsg)localChatMessage;
          continue;
        }
        if (localChatMessage.msgtype == -2022)
        {
          localObject1 = (MessageForShortVideo)localChatMessage;
          ((MessageForShortVideo)localObject1).forwardID = this.jdField_a_of_type_Int;
          aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForShortVideo)localObject1);
          break label150;
        }
        if (((localChatMessage instanceof MessageForFile)) || ((localChatMessage instanceof MessageForTroopFile)))
        {
          localObject1 = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
          if ((localObject1 != null) && (((Intent)localObject1).getExtras() != null))
          {
            localObject4 = (ForwardFileInfo)((Intent)localObject1).getExtras().getParcelable("fileinfo");
            String str2 = ((Intent)localObject1).getStringExtra("forward_filepath");
            if (localObject4 != null)
            {
              ((ForwardFileInfo)localObject4).c(localChatMessage.uniseq);
              ((ForwardFileInfo)localObject4).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
              aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseActivity.sTopActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (Intent)localObject1, str2, (ForwardFileInfo)localObject4, false);
            }
          }
          break label150;
        }
        if ((localChatMessage instanceof MessageForReplyText))
        {
          localObject1 = (MessageForReplyText)localChatMessage;
          bbdn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 0, this.jdField_a_of_type_Int, true);
          break label150;
        }
        localObject1 = localChatMessage.msg;
        Object localObject4 = new aeau();
        ((aeau)localObject4).g = true;
        ((aeau)localObject4).j = true;
        localObject1 = aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, null, (aeau)localObject4);
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          agsg.a().a(localObject1[0], localChatMessage.uniseq, this.jdField_a_of_type_Int);
          agsg.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.uniseq, this.jdField_a_of_type_Int);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "sendMultuMsgSeperaterFromLocal sendMsg cost = " + (System.currentTimeMillis() - l));
      }
      String str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      localObject2 = (ChatMessage)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (localObject2 != null) {}
      for (j = ((ChatMessage)localObject2).istroop;; j = 0)
      {
        if (j == 0) {
          j = 1;
        }
        for (;;)
        {
          if (m == 0) {
            k = 1;
          }
          for (;;)
          {
            label1091:
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str1, "0X8004876", "0X8004876", 0, 0, j + "", k + "", "" + this.jdField_a_of_type_JavaUtilArrayList.size(), "" + i + "");
            i = 1;
            label1215:
            int n;
            if (m == 0)
            {
              i = 1;
              n = this.jdField_a_of_type_JavaUtilArrayList.size();
              localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
              k = 0;
              j = 0;
              label1237:
              if (!((Iterator)localObject2).hasNext()) {
                break label1431;
              }
              localObject3 = (MessageRecord)((Iterator)localObject2).next();
              if (((MessageRecord)localObject3).msgtype != -2022) {
                break label1396;
              }
              m = k;
              k = j + 1;
              j = m;
            }
            label1431:
            for (;;)
            {
              m = k;
              k = j;
              j = m;
              break label1237;
              if (j == 3000)
              {
                j = 2;
                break;
              }
              if (j != 1) {
                break label1600;
              }
              j = 3;
              break;
              if (m == 3000)
              {
                k = 2;
                break label1091;
              }
              if (m != 1) {
                break label1595;
              }
              k = 3;
              break label1091;
              if ((m == 3000) || (m == 1))
              {
                i = 2;
                break label1215;
              }
              if ((m == 1000) || (m == 1004))
              {
                i = 3;
                break label1215;
              }
              if (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
                break label1215;
              }
              i = 4;
              break label1215;
              label1396:
              if ((((MessageRecord)localObject3).msgtype == -2005) || (((MessageRecord)localObject3).msgtype == -2017))
              {
                m = k + 1;
                k = j;
                j = m;
                continue;
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str1, "0X8009ABF", "0X8009ABF", i, 0, n + "", n + "", "" + j, "" + k);
                axpm.a("report_0X8009ABF:fromType:%d,msgCount:%d,msgSize:%d,videoMsgCount:%d,fileMsgCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k) });
              }
              else
              {
                m = j;
                j = k;
                k = m;
              }
            }
            label1595:
            k = 4;
          }
          label1600:
          j = 4;
        }
      }
      label1610:
      continue;
      label1613:
      int k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager.1
 * JD-Core Version:    0.7.0.1
 */