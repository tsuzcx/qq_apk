package com.tencent.mobileqq.troop.troopgame;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.util.TroopGameCardUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class TroopMemGradeLevelBuilder
{
  Handler jdField_a_of_type_AndroidOsHandler = new TroopMemGradeLevelBuilder.1(this, Looper.getMainLooper());
  private BaseChatItemLayout jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  
  public TroopMemGradeLevelBuilder(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)) {}
    do
    {
      NickNameExtenderViewBasicAbility localNickNameExtenderViewBasicAbility;
      do
      {
        return;
        localNickNameExtenderViewBasicAbility = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(NickNameLayoutProcessor.e);
      } while ((localNickNameExtenderViewBasicAbility == null) || (!localNickNameExtenderViewBasicAbility.checkViewNonNull()));
      if ((AnonymousChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) || ("1000000".equals(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin)) || ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTroopConfess)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemGradeLevelBuilder", 2, "handleMemberGradeLevel not need show");
        }
        a(false);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop != 1);
    TroopGameCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, new TroopMemGradeLevelBuilder.3(this));
  }
  
  private void a(boolean paramBoolean)
  {
    int i = 1;
    Message localMessage = new Message();
    localMessage.what = 1;
    if (paramBoolean) {}
    for (;;)
    {
      localMessage.arg1 = i;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
      i = 0;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new TroopMemGradeLevelBuilder.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopMemGradeLevelBuilder
 * JD-Core Version:    0.7.0.1
 */