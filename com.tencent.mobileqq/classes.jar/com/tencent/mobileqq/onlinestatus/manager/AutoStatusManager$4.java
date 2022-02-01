package com.tencent.mobileqq.onlinestatus.manager;

import com.tencent.commonsdk.util.notification.QQNotificationManager;

class AutoStatusManager$4
  implements Runnable
{
  AutoStatusManager$4(AutoStatusManager paramAutoStatusManager) {}
  
  public void run()
  {
    QQNotificationManager.getInstance().cancel("AutoStatusManager", 3000530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager.4
 * JD-Core Version:    0.7.0.1
 */