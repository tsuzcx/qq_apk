package com.tencent.mobileqq.fragment;

import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import mqq.os.MqqHandler;

class QQSettingChatOperationFragment$2$1
  implements Runnable
{
  QQSettingChatOperationFragment$2$1(QQSettingChatOperationFragment.2 param2) {}
  
  public void run()
  {
    QQSettingChatOperationFragment.a(this.a.a).getMsgHandler().d(true);
    QQSettingChatOperationFragment.a(this.a.a).getMessageFacade().j();
    TroopAssistantManager.a().j(QQSettingChatOperationFragment.a(this.a.a));
    this.a.a.a.sendEmptyMessageDelayed(0, 1000L);
    MqqHandler localMqqHandler = QQSettingChatOperationFragment.a(this.a.a).getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingChatOperationFragment.2.1
 * JD-Core Version:    0.7.0.1
 */