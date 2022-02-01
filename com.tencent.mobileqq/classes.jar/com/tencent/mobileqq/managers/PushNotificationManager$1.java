package com.tencent.mobileqq.managers;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.QConfPushBean;

class PushNotificationManager$1
  implements Runnable
{
  PushNotificationManager$1(PushNotificationManager paramPushNotificationManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    PushNotificationManager.a(this.this$0, (QConfPushBean)QConfigManager.a().a(390));
    MsgNotifyPushDialog.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.PushNotificationManager.1
 * JD-Core Version:    0.7.0.1
 */