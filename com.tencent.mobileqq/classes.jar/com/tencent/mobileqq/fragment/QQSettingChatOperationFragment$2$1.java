package com.tencent.mobileqq.fragment;

import android.os.Handler;
import aqja;
import asfb;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import mqq.os.MqqHandler;

public class QQSettingChatOperationFragment$2$1
  implements Runnable
{
  public QQSettingChatOperationFragment$2$1(aqja paramaqja) {}
  
  public void run()
  {
    QQSettingChatOperationFragment.a(this.a.a).a().d(true);
    QQSettingChatOperationFragment.a(this.a.a).a().h();
    asfb.a().j(QQSettingChatOperationFragment.a(this.a.a));
    this.a.a.a.sendEmptyMessageDelayed(0, 1000L);
    MqqHandler localMqqHandler = QQSettingChatOperationFragment.a(this.a.a).getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingChatOperationFragment.2.1
 * JD-Core Version:    0.7.0.1
 */