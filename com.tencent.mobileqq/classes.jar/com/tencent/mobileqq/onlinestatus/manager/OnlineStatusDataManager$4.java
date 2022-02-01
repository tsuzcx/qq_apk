package com.tencent.mobileqq.onlinestatus.manager;

import com.tencent.qphone.base.util.QLog;

class OnlineStatusDataManager$4
  implements Runnable
{
  OnlineStatusDataManager$4(OnlineStatusDataManager paramOnlineStatusDataManager) {}
  
  public void run()
  {
    OnlineStatusDataManager.a(this.this$0, true);
    QLog.d("OnlineStatusDataManagerImpl", 1, "cancel background runnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager.4
 * JD-Core Version:    0.7.0.1
 */