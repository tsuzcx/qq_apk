package com.tencent.mobileqq.onlinestatus;

import com.tencent.qphone.base.util.QLog;

class OnlineStatusManager$4
  implements Runnable
{
  OnlineStatusManager$4(OnlineStatusManager paramOnlineStatusManager) {}
  
  public void run()
  {
    OnlineStatusManager.a(this.this$0, true);
    QLog.d("OnlineStatusManager", 1, "cancel background runnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusManager.4
 * JD-Core Version:    0.7.0.1
 */