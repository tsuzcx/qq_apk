package com.tencent.mobileqq.onlinestatus;

import azbv;
import com.tencent.qphone.base.util.QLog;

public class OnlineStatusManager$4
  implements Runnable
{
  public OnlineStatusManager$4(azbv paramazbv) {}
  
  public void run()
  {
    azbv.a(this.this$0, true);
    QLog.d("OnlineStatusManager", 1, "cancel background runnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusManager.4
 * JD-Core Version:    0.7.0.1
 */