package com.tencent.mobileqq.onlinestatus.auto;

import com.tencent.commonsdk.util.notification.QQNotificationManager;

final class AutoStatusManager$4
  implements Runnable
{
  public void run()
  {
    QQNotificationManager.getInstance().cancel("AutoStatusManager", 3000530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager.4
 * JD-Core Version:    0.7.0.1
 */