package com.tencent.mobileqq.troop.data;

import acka;
import ajjz;
import alfo;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import arom;
import awqx;
import awuw;
import aylz;
import aymq;
import ayms;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;
import mnf;

public class TroopAioMsgNavigateBar$2
  implements Runnable
{
  public TroopAioMsgNavigateBar$2(aymq paramaymq) {}
  
  public void run()
  {
    if ((!this.this$0.b()) || (!this.this$0.jdField_a_of_type_Boolean)) {
      return;
    }
    this.this$0.jdField_b_of_type_Boolean = true;
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    this.this$0.jdField_a_of_type_JavaLangObject = null;
    ??? = (arom)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    Object localObject2;
    long l1;
    long l2;
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      this.this$0.jdField_e_of_type_Int = ((arom)???).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject2 = (TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (localObject2 != null)
      {
        localObject2 = ((TroopManager)localObject2).b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject2 != null) && (((TroopInfo)localObject2).hasOrgs())) {
          this.this$0.jdField_e_of_type_Boolean = true;
        }
      }
      this.this$0.jdField_a_of_type_JavaUtilList = ((arom)???).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_e_of_type_Int);
      if (!this.this$0.c()) {
        break label907;
      }
      this.this$0.jdField_d_of_type_Long = ((arom)???).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (this.this$0.jdField_d_of_type_Long != -1L) {
        Collections.sort(this.this$0.jdField_a_of_type_JavaUtilList, new ayms(this));
      }
      if ((this.this$0.jdField_a_of_type_JavaUtilList != null) && (!this.this$0.jdField_a_of_type_JavaUtilList.isEmpty())) {
        this.this$0.jdField_c_of_type_Long = ((Long)this.this$0.jdField_a_of_type_JavaUtilList.get(this.this$0.jdField_a_of_type_JavaUtilList.size() - 1)).longValue();
      }
      if (this.this$0.jdField_e_of_type_Boolean)
      {
        ??? = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (??? != null)
        {
          l1 = ((QQMessageFacade.Message)???).shmsgseq;
          l2 = this.this$0.jdField_c_of_type_Long;
          awqx.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "his_owner", 0, 0, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", l1 - l2 + "");
        }
      }
      if ((this.this$0.jdField_a_of_type_JavaUtilList == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (this.this$0.jdField_a_of_type_Acka == null)) {
        break label647;
      }
      localObject2 = (ChatMessage)this.this$0.jdField_a_of_type_Acka.getItem(this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
      if (localObject2 == null) {
        break label647;
      }
    }
    label647:
    label907:
    label1176:
    label1705:
    label4404:
    for (;;)
    {
      int i;
      Object localObject8;
      Object localObject7;
      aylz localaylz;
      Object localObject6;
      Object localObject5;
      synchronized (this.this$0.jdField_a_of_type_JavaUtilList)
      {
        i = this.this$0.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i >= 0)
        {
          if (((ChatMessage)localObject2).shmsgseq <= ((Long)this.this$0.jdField_a_of_type_JavaUtilList.get(i)).longValue()) {
            this.this$0.jdField_a_of_type_JavaUtilList.remove(i);
          }
          i -= 1;
          continue;
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
            break;
          }
          this.this$0.jdField_e_of_type_Int = ((arom)???).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
          break;
        }
        this.this$0.jdField_b_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        l1 = aymq.jdField_a_of_type_Long;
        localObject8 = (MessageRecord)this.this$0.jdField_a_of_type_Acka.getItem(this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
        if (localObject8 != null) {
          l1 = ((MessageRecord)localObject8).shmsgseq;
        }
        localObject7 = "";
        localObject2 = null;
        localaylz = null;
        localObject6 = "";
        if (this.this$0.jdField_e_of_type_Int != 1) {
          break label1176;
        }
        if (this.this$0.jdField_b_of_type_Long < l1) {
          break label1011;
        }
        i = 0;
        if (i == 0) {
          break label4392;
        }
        ??? = String.format(this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getString(2131632330), new Object[] { Integer.valueOf(this.this$0.jdField_d_of_type_Int) });
        localObject2 = aylz.a(this.this$0.jdField_e_of_type_Int, this.this$0.jdField_c_of_type_Long, this.this$0.jdField_d_of_type_Int);
        bool1 = true;
        localObject5 = localObject6;
        bool2 = bool1;
        if (this.this$0.c())
        {
          bool2 = bool1;
          if (this.this$0.jdField_a_of_type_JavaUtilList.isEmpty()) {
            bool2 = false;
          }
        }
        this.this$0.g = bool2;
        this.this$0.jdField_c_of_type_JavaLangString = ((String)???);
        this.this$0.jdField_b_of_type_JavaLangObject = localObject2;
        this.this$0.jdField_d_of_type_JavaLangString = ((String)localObject5);
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(101);
        return;
      }
      label1601:
      label1863:
      label2001:
      label2129:
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        this.this$0.jdField_c_of_type_Long = ((arom)???).b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      } else {
        label1623:
        label1883:
        label2272:
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
        {
          this.this$0.jdField_c_of_type_Long = ((arom)???).b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
          continue;
          label1011:
          if (this.this$0.jdField_d_of_type_Int < 30)
          {
            ??? = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            if (??? != null)
            {
              long l3 = ((QQMessageFacade.Message)???).shmsgseq;
              for (l2 = 0L;; l2 += 1L)
              {
                if (l2 >= this.this$0.jdField_d_of_type_Int) {
                  break label4404;
                }
                ??? = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l3);
                if ((??? != null) && (((MessageRecord)???).msgtype != -2058) && (((MessageRecord)???).shmsgseq < l1))
                {
                  i = 1;
                  break;
                }
                l3 -= 1L;
              }
            }
          }
          else
          {
            i = 1;
            continue;
            if (this.this$0.jdField_e_of_type_Int == 23)
            {
              localObject5 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_c_of_type_Long);
              if ((localObject5 == null) || (((MessageRecord)localObject5).shmsgseq >= l1)) {
                break label4381;
              }
              ??? = this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getString(2131631793);
              localObject4 = aylz.a(this.this$0.jdField_e_of_type_Int, this.this$0.jdField_c_of_type_Long, this.this$0.jdField_d_of_type_Int);
              localObject5 = ((MessageRecord)localObject5).senderuin;
              bool1 = true;
            }
            for (;;)
            {
              break;
              if (this.this$0.jdField_e_of_type_Int == 14)
              {
                localObject8 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_c_of_type_Long);
                localObject4 = localaylz;
                ??? = localObject7;
                bool1 = bool2;
                localObject5 = localObject6;
                if (localObject8 == null) {
                  break;
                }
                localObject4 = localaylz;
                ??? = localObject7;
                bool1 = bool2;
                localObject5 = localObject6;
                if (((MessageRecord)localObject8).shmsgseq >= l1) {
                  break;
                }
                ??? = this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getString(2131631791);
                localObject4 = aylz.a(this.this$0.jdField_e_of_type_Int, this.this$0.jdField_c_of_type_Long, this.this$0.jdField_d_of_type_Int);
                localObject5 = ((MessageRecord)localObject8).senderuin;
                bool1 = true;
                break;
              }
              if ((this.this$0.jdField_e_of_type_Int == 17) || (this.this$0.jdField_e_of_type_Int == 100))
              {
                localObject4 = aylz.a(this.this$0.jdField_e_of_type_Int, this.this$0.jdField_c_of_type_Long, this.this$0.jdField_d_of_type_Int);
                localObject7 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_c_of_type_Long);
                if ((this.this$0.jdField_a_of_type_JavaUtilList != null) && (!this.this$0.jdField_a_of_type_JavaUtilList.isEmpty()))
                {
                  localObject5 = this.this$0.jdField_a_of_type_AndroidContentContext.getResources();
                  if (this.this$0.jdField_e_of_type_Int == 17)
                  {
                    i = 2131628808;
                    if (this.this$0.jdField_a_of_type_JavaUtilList.size() <= 99) {
                      break label1863;
                    }
                    ??? = "99+";
                    ??? = ((Resources)localObject5).getString(i, new Object[] { ??? });
                    if (!this.this$0.jdField_e_of_type_Boolean) {
                      break label4378;
                    }
                    if (this.this$0.jdField_a_of_type_JavaUtilList.size() != 1) {
                      break label1883;
                    }
                    awqx.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "focus", 0, 0, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                  }
                }
              }
              for (;;)
              {
                if (MessageForQQWalletMsg.isRedPacketMsg((MessageRecord)localObject7))
                {
                  ??? = (MessageForQQWalletMsg)localObject7;
                  if ((((MessageForQQWalletMsg)???).messageType == 7) || (((MessageForQQWalletMsg)???).messageType == 8))
                  {
                    ??? = this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131653443);
                    ((aylz)localObject4).jdField_b_of_type_Boolean = true;
                  }
                }
                for (;;)
                {
                  localObject5 = localObject6;
                  if (localObject7 != null) {
                    localObject5 = ((MessageRecord)localObject7).senderuin;
                  }
                  if (QLog.isColorLevel())
                  {
                    localObject6 = new StringBuilder().append("需要定位的第一条消息是否已经拉到本地：");
                    if (localObject7 == null) {
                      break label2001;
                    }
                  }
                  for (bool1 = true;; bool1 = false)
                  {
                    QLog.d("TroopAioMsgNavigateBar.troop.special_msg.special_attention", 2, bool1);
                    bool1 = bool3;
                    if (localObject8 != null)
                    {
                      bool1 = bool3;
                      if (this.this$0.jdField_c_of_type_Long < ((MessageRecord)localObject8).shmsgseq) {
                        bool1 = true;
                      }
                    }
                    break;
                    i = 2131633818;
                    break label1601;
                    ??? = Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size());
                    break label1623;
                    awqx.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "msg_owner", 0, 0, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaUtilList.size() + "", "", "");
                    break label1705;
                    ??? = this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getString(2131653834);
                    break label1705;
                    ??? = this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131653426);
                    ((aylz)localObject4).jdField_a_of_type_Boolean = true;
                    break label1764;
                  }
                  if (this.this$0.jdField_e_of_type_Int == 11)
                  {
                    localaylz = aylz.a(this.this$0.jdField_e_of_type_Int, this.this$0.jdField_c_of_type_Long, this.this$0.jdField_d_of_type_Int);
                    ??? = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_c_of_type_Long);
                    if ((this.this$0.jdField_a_of_type_JavaUtilList != null) && (!this.this$0.jdField_a_of_type_JavaUtilList.isEmpty()))
                    {
                      localObject7 = this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getString(2131632964);
                      if (??? != null) {
                        localObject6 = ((MessageRecord)???).senderuin;
                      }
                      if (QLog.isColorLevel())
                      {
                        localObject4 = new StringBuilder().append("需要定位的第一条消息是否已经拉到本地：");
                        if (??? == null) {
                          break label2272;
                        }
                      }
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      QLog.d("TroopAioMsgNavigateBar.troop.special_msg.confess_to_me", 2, bool1);
                      localObject4 = localaylz;
                      ??? = localObject7;
                      bool1 = bool2;
                      localObject5 = localObject6;
                      if (localObject8 == null) {
                        break;
                      }
                      localObject4 = localaylz;
                      ??? = localObject7;
                      bool1 = bool2;
                      localObject5 = localObject6;
                      if (this.this$0.jdField_c_of_type_Long >= ((MessageRecord)localObject8).shmsgseq) {
                        break;
                      }
                      bool1 = true;
                      localObject4 = localaylz;
                      ??? = localObject7;
                      localObject5 = localObject6;
                      break;
                      localObject7 = this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getString(2131632964);
                      break label2129;
                    }
                  }
                  if (this.this$0.jdField_e_of_type_Int == 6)
                  {
                    localObject8 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_c_of_type_Long);
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getString(2131631970);
                    localObject4 = aylz.a(this.this$0.jdField_e_of_type_Int, this.this$0.jdField_c_of_type_Long, this.this$0.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.this$0.jdField_e_of_type_Int == 26)
                  {
                    localObject8 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_c_of_type_Long);
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getString(2131632199);
                    localObject4 = aylz.a(this.this$0.jdField_e_of_type_Int, this.this$0.jdField_c_of_type_Long, this.this$0.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    if (mnf.a((MessageRecord)localObject8)) {}
                    for (i = 2;; i = 1)
                    {
                      awqx.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_topmsgcue", i, 0, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                      break;
                    }
                  }
                  if (this.this$0.jdField_e_of_type_Int == 18)
                  {
                    localObject8 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_c_of_type_Long);
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getString(2131631854);
                    localObject4 = aylz.a(this.this$0.jdField_e_of_type_Int, this.this$0.jdField_c_of_type_Long, this.this$0.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.this$0.jdField_e_of_type_Int == 21)
                  {
                    localObject8 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_c_of_type_Long);
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    if ((StructMsgForGeneralShare)awuw.a(((MessageRecord)localObject8).msgData) == null) {
                      if (QLog.isColorLevel()) {
                        QLog.d("TroopAioMsgNavigateBar", 2, "showNavigateBarIfNeeded() :calendarMsg getStructMsg is null");
                      }
                    }
                    for (??? = this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getString(2131631824);; ??? = StructMsgForGeneralShare.remindBrief)
                    {
                      localObject4 = aylz.a(this.this$0.jdField_e_of_type_Int, this.this$0.jdField_c_of_type_Long, this.this$0.jdField_d_of_type_Int);
                      localObject5 = ((MessageRecord)localObject8).senderuin;
                      bool1 = true;
                      this.this$0.jdField_a_of_type_JavaLangString = StructMsgForGeneralShare.eventType;
                      awqx.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_calendar", "", "notice", "exp", 0, 0, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_JavaLangString, "", "");
                      break;
                    }
                  }
                  if (this.this$0.jdField_e_of_type_Int == 22)
                  {
                    localObject8 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_c_of_type_Long);
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getString(2131632207);
                    localObject4 = aylz.a(this.this$0.jdField_e_of_type_Int, ((MessageRecord)localObject8).shmsgseq, this.this$0.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    MessageForReplyText.reportReplyMsg(null, "AIOchat", "Appear_topmsgcue_reply", this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
                    break;
                  }
                  if (this.this$0.jdField_e_of_type_Int == 3)
                  {
                    localObject8 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_c_of_type_Long);
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131632134);
                    localObject4 = aylz.a(this.this$0.jdField_e_of_type_Int, this.this$0.jdField_c_of_type_Long, this.this$0.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.this$0.jdField_e_of_type_Int == 4)
                  {
                    localObject8 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_c_of_type_Long);
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131632135);
                    localObject4 = aylz.a(this.this$0.jdField_e_of_type_Int, this.this$0.jdField_c_of_type_Long, this.this$0.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.this$0.jdField_e_of_type_Int == 5)
                  {
                    localObject8 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_c_of_type_Long);
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131631982);
                    localObject4 = aylz.a(this.this$0.jdField_e_of_type_Int, this.this$0.jdField_c_of_type_Long, this.this$0.jdField_d_of_type_Int);
                    localObject5 = "";
                    bool1 = true;
                    break;
                  }
                  if (this.this$0.jdField_e_of_type_Int == 19)
                  {
                    localObject8 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_c_of_type_Long);
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131627289);
                    localObject4 = aylz.a(this.this$0.jdField_e_of_type_Int, this.this$0.jdField_c_of_type_Long, this.this$0.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.this$0.jdField_e_of_type_Int == 13)
                  {
                    localObject8 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_c_of_type_Long);
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131632780);
                    localObject4 = aylz.a(this.this$0.jdField_e_of_type_Int, this.this$0.jdField_c_of_type_Long, this.this$0.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.this$0.jdField_e_of_type_Int == 20)
                  {
                    localObject8 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_c_of_type_Long);
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    localObject4 = localaylz;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (!(localObject8 instanceof MessageForArkApp)) {
                      break;
                    }
                    ??? = alfo.a((MessageForArkApp)localObject8);
                    localObject4 = aylz.a(this.this$0.jdField_e_of_type_Int, this.this$0.jdField_c_of_type_Long, this.this$0.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  localObject4 = localaylz;
                  ??? = localObject7;
                  bool1 = bool2;
                  localObject5 = localObject6;
                  if (this.this$0.jdField_e_of_type_Int != 24) {
                    break;
                  }
                  localObject8 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
                  ajjz localajjz = (ajjz)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255);
                  localObject4 = localaylz;
                  ??? = localObject7;
                  bool1 = bool2;
                  localObject5 = localObject6;
                  if (localajjz == null) {
                    break;
                  }
                  localObject8 = localajjz.a((String)localObject8);
                  localObject4 = localaylz;
                  ??? = localObject7;
                  bool1 = bool2;
                  localObject5 = localObject6;
                  if (localObject8 == null) {
                    break;
                  }
                  localObject4 = localaylz;
                  ??? = localObject7;
                  bool1 = bool2;
                  localObject5 = localObject6;
                  if (((HotChatItemData)localObject8).mGameId <= 0) {
                    break;
                  }
                  localObject4 = HotChatCenterFragment.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((HotChatItemData)localObject8).mHotChatCode, ((HotChatItemData)localObject8).mGameId);
                  if (localObject4 != null)
                  {
                    ??? = ((AioPushData)localObject4).wording;
                    bool1 = true;
                    this.this$0.jdField_a_of_type_JavaLangObject = localObject4;
                  }
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("TroopAioMsgNavigateBar", 2, "[showNavigateBarIfNeeded] for " + ((HotChatItemData)localObject8).mHotChatCode + " " + ((HotChatItemData)localObject8).mGameId);
                    }
                    localObject4 = localaylz;
                    localObject5 = localObject6;
                    break;
                    bool1 = false;
                    ??? = localObject7;
                  }
                }
              }
              localObject5 = "";
              ??? = localObject7;
            }
            Object localObject4 = null;
            ??? = "";
            bool1 = false;
            continue;
          }
          label1764:
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar.2
 * JD-Core Version:    0.7.0.1
 */