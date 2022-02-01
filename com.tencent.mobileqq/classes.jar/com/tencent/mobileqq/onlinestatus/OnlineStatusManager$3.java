package com.tencent.mobileqq.onlinestatus;

import axvk;
import com.tencent.qphone.base.util.QLog;

public class OnlineStatusManager$3
  implements Runnable
{
  public OnlineStatusManager$3(axvk paramaxvk) {}
  
  public void run()
  {
    axvk.a(this.this$0, true);
    QLog.d("OnlineStatusManager", 1, "cancel background runnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusManager.3
 * JD-Core Version:    0.7.0.1
 */