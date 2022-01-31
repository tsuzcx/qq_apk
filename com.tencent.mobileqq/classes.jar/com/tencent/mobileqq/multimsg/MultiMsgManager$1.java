package com.tencent.mobileqq.multimsg;

import aael;
import aaes;
import acvh;
import android.content.Intent;
import android.os.Bundle;
import apck;
import arxu;
import aryb;
import aurn;
import awqx;
import baic;
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
  public MultiMsgManager$1(arxu paramarxu, ArrayList paramArrayList, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int j = 0;
    int i = 0;
    Object localObject3;
    Object localObject1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ChatMessage)((Iterator)localObject2).next();
      if (((ChatMessage)localObject3).msgtype == -2000)
      {
        localObject1 = (MessageForPic)localObject3;
        aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForPic)localObject1, this.jdField_a_of_type_Int);
        i += 1;
        label79:
        if (j >= arxu.a(this.this$0)) {
          break label1537;
        }
      }
    }
    for (;;)
    {
      try
      {
        Thread.sleep(arxu.b(this.this$0));
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "sendMultuMsgSeperaterFromLocal delay  i = " + j + " mDelayTime = " + arxu.b(this.this$0));
        }
        j += 1;
        break;
        if (((ChatMessage)localObject3).msgtype == -2011)
        {
          if (!(localObject3 instanceof MessageForStructing)) {
            break label1540;
          }
          localObject1 = ((MessageForStructing)localObject3).structingMsg;
          if ((localObject1 == null) || (!(localObject1 instanceof StructMsgForImageShare))) {
            break label1540;
          }
          ((AbsStructMsg)localObject1).forwardID = this.jdField_a_of_type_Int;
          StructMsgForImageShare.sendAndUploadImageShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (StructMsgForImageShare)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, 0);
          k = 1;
          if ((k == 0) && ((localObject3 instanceof MessageForStructing)))
          {
            localObject1 = ((MessageForStructing)localObject3).structingMsg;
            ((AbsStructMsg)localObject1).parentUniseq = ((ChatMessage)localObject3).uniseq;
            ((AbsStructMsg)localObject1).forwardID = this.jdField_a_of_type_Int;
            baic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (AbsStructMsg)localObject1, null);
          }
          break label79;
        }
        if (((ChatMessage)localObject3).msgtype == -5008)
        {
          localObject1 = ((MessageForArkApp)localObject3).ark_app_message;
          ((ArkAppMessage)localObject1).uniSeq = ((ChatMessage)localObject3).uniseq;
          ((ArkAppMessage)localObject1).forwardID = this.jdField_a_of_type_Int;
          aael.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArkAppMessage)localObject1);
          break label79;
        }
        if (((ChatMessage)localObject3).msgtype == -5017)
        {
          localObject1 = ((MessageForArkApp)localObject3).ark_app_message;
          ((ArkAppMessage)localObject1).uniSeq = ((ChatMessage)localObject3).uniseq;
          ((ArkAppMessage)localObject1).forwardID = this.jdField_a_of_type_Int;
          aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArkAppMessage)localObject1);
          break label79;
        }
        if (((ChatMessage)localObject3).msgtype == -5016)
        {
          QLog.e("MultiMsg_TAG", 1, "MSG_TYPE_ARK_BABYQ_REPLY no longer supported");
          break label79;
        }
        if (((ChatMessage)localObject3).msgtype == -5013)
        {
          localObject1 = ((MessageForArkFlashChat)localObject3).ark_app_message;
          ((ArkFlashChatMessage)localObject1).uniSeq = ((ChatMessage)localObject3).uniseq;
          ((ArkFlashChatMessage)localObject1).forwardID = this.jdField_a_of_type_Int;
          aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArkFlashChatMessage)localObject1, this.jdField_a_of_type_Int);
          break label79;
        }
        if ((((ChatMessage)localObject3).msgtype == -1035) || (((ChatMessage)localObject3).msgtype == -1036))
        {
          if (((ChatMessage)localObject3).msgtype == -1036)
          {
            localObject1 = (MessageForMixedMsg)((MessageForLongMsg)localObject3).rebuildLongMsg();
            acvh.a().a((MessageRecord)localObject3, (MessageRecord)localObject1, this.jdField_a_of_type_Int);
            ((MessageForMixedMsg)localObject1).mForwardFromUniSeq = ((ChatMessage)localObject3).uniseq;
            ((MessageForMixedMsg)localObject1).forwardID = this.jdField_a_of_type_Int;
            aurn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMixedMsg)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Int);
            break label79;
          }
          localObject1 = (MessageForMixedMsg)localObject3;
          continue;
        }
        if (((ChatMessage)localObject3).msgtype == -2022)
        {
          localObject1 = (MessageForShortVideo)localObject3;
          ((MessageForShortVideo)localObject1).forwardID = this.jdField_a_of_type_Int;
          aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForShortVideo)localObject1);
          break label79;
        }
        if (((localObject3 instanceof MessageForFile)) || ((localObject3 instanceof MessageForTroopFile)))
        {
          localObject1 = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject3);
          if ((localObject1 != null) && (((Intent)localObject1).getExtras() != null))
          {
            localObject4 = (ForwardFileInfo)((Intent)localObject1).getExtras().getParcelable("fileinfo");
            String str2 = ((Intent)localObject1).getStringExtra("forward_filepath");
            if (localObject4 != null)
            {
              ((ForwardFileInfo)localObject4).c(((ChatMessage)localObject3).uniseq);
              ((ForwardFileInfo)localObject4).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
              aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseActivity.sTopActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (Intent)localObject1, str2, (ForwardFileInfo)localObject4, false);
            }
          }
          break label79;
        }
        if ((localObject3 instanceof MessageForReplyText))
        {
          localObject1 = (MessageForReplyText)localObject3;
          aurn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 0, this.jdField_a_of_type_Int, true);
          break label79;
        }
        localObject1 = ((ChatMessage)localObject3).msg;
        Object localObject4 = new aaes();
        ((aaes)localObject4).g = true;
        ((aaes)localObject4).j = true;
        localObject1 = aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, null, (aaes)localObject4);
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          acvh.a().a(localObject1[0], ((ChatMessage)localObject3).uniseq, this.jdField_a_of_type_Int);
          acvh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ChatMessage)localObject3).uniseq, this.jdField_a_of_type_Int);
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
            label1018:
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str1, "0X8004876", "0X8004876", 0, 0, j + "", k + "", "" + this.jdField_a_of_type_JavaUtilArrayList.size(), "" + i + "");
            i = 1;
            label1142:
            int n;
            if (m == 0)
            {
              i = 1;
              n = this.jdField_a_of_type_JavaUtilArrayList.size();
              localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
              k = 0;
              j = 0;
              label1164:
              if (!((Iterator)localObject2).hasNext()) {
                break label1358;
              }
              localObject3 = (MessageRecord)((Iterator)localObject2).next();
              if (((MessageRecord)localObject3).msgtype != -2022) {
                break label1323;
              }
              m = k;
              k = j + 1;
              j = m;
            }
            for (;;)
            {
              m = k;
              k = j;
              j = m;
              break label1164;
              if (j == 3000)
              {
                j = 2;
                break;
              }
              if (j != 1) {
                break label1527;
              }
              j = 3;
              break;
              if (m == 3000)
              {
                k = 2;
                break label1018;
              }
              if (m != 1) {
                break label1522;
              }
              k = 3;
              break label1018;
              if ((m == 3000) || (m == 1))
              {
                i = 2;
                break label1142;
              }
              if ((m == 1000) || (m == 1004))
              {
                i = 3;
                break label1142;
              }
              if (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
                break label1142;
              }
              i = 4;
              break label1142;
              label1323:
              if ((((MessageRecord)localObject3).msgtype == -2005) || (((MessageRecord)localObject3).msgtype == -2017))
              {
                m = k + 1;
                k = j;
                j = m;
                continue;
                label1358:
                awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str1, "0X8009ABF", "0X8009ABF", i, 0, n + "", n + "", "" + j, "" + k);
                aryb.a("report_0X8009ABF:fromType:%d,msgCount:%d,msgSize:%d,videoMsgCount:%d,fileMsgCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k) });
              }
              else
              {
                m = j;
                j = k;
                k = m;
              }
            }
            label1522:
            k = 4;
          }
          label1527:
          j = 4;
        }
      }
      label1537:
      continue;
      label1540:
      int k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager.1
 * JD-Core Version:    0.7.0.1
 */