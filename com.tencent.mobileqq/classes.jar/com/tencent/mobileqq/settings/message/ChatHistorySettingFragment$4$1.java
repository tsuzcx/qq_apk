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
    ChatHistorySettingFragment.a(this.a.b).getMsgHandler().f(true);
    ChatHistorySettingFragment.a(this.a.b).getMessageFacade().v();
    TroopAssistantManager.a().r(ChatHistorySettingFragment.a(this.a.b));
    this.a.b.f.sendEmptyMessageDelayed(0, 1000L);
    MqqHandler localMqqHandler = ChatHistorySettingFragment.a(this.a.b).getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.ChatHistorySettingFragment.4.1
 * JD-Core Version:    0.7.0.1
 */