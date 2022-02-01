package com.tencent.mobileqq.settings.message;

import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import mqq.os.MqqHandler;

class ChatHistorySettingFragment$4$1
  implements Runnable
{
  ChatHistorySettingFragment$4$1(ChatHistorySettingFragment.4 param4) {}
  
  public void run()
  {
    ChatHistorySettingFragment.a(this.a.a).getMsgHandler().d(true);
    ChatHistorySettingFragment.a(this.a.a).getMessageFacade().j();
    TroopAssistantManager.a().j(ChatHistorySettingFragment.a(this.a.a));
    this.a.a.a.sendEmptyMessageDelayed(0, 1000L);
    MqqHandler localMqqHandler = ChatHistorySettingFragment.a(this.a.a).getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.ChatHistorySettingFragment.4.1
 * JD-Core Version:    0.7.0.1
 */