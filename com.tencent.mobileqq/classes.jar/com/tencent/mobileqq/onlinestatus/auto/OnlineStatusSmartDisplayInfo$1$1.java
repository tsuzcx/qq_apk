package com.tencent.mobileqq.onlinestatus.auto;

import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo.UpdateUIListener;
import com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager;

class OnlineStatusSmartDisplayInfo$1$1
  implements Runnable
{
  OnlineStatusSmartDisplayInfo$1$1(OnlineStatusSmartDisplayInfo.1 param1, int paramInt) {}
  
  public void run()
  {
    this.b.a.b = OnlineStatusSmartDisplayInfo.c(this.b.a).a(Integer.valueOf(this.a));
    OnlineStatusSmartDisplayInfo.d(this.b.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.OnlineStatusSmartDisplayInfo.1.1
 * JD-Core Version:    0.7.0.1
 */