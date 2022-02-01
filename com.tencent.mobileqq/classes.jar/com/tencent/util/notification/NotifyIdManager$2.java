package com.tencent.util.notification;

import com.tencent.commonsdk.util.notification.QQNotificationManager;

class NotifyIdManager$2
  implements Runnable
{
  NotifyIdManager$2(NotifyIdManager paramNotifyIdManager, QQNotificationManager paramQQNotificationManager) {}
  
  public void run()
  {
    int i = 512;
    while (i < 522)
    {
      this.a.cancel("NotifyIdManager", i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.notification.NotifyIdManager.2
 * JD-Core Version:    0.7.0.1
 */