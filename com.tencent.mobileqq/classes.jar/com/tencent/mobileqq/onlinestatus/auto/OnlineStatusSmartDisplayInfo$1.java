package com.tencent.mobileqq.onlinestatus.auto;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager.OnAutoStatusChangedListener;

class OnlineStatusSmartDisplayInfo$1
  implements AutoStatusManager.OnAutoStatusChangedListener
{
  OnlineStatusSmartDisplayInfo$1(OnlineStatusSmartDisplayInfo paramOnlineStatusSmartDisplayInfo) {}
  
  public void a(int paramInt)
  {
    if ((OnlineStatusSmartDisplayInfo.a(this.a)) && (OnlineStatusSmartDisplayInfo.b(this.a) != null)) {
      ThreadManagerV2.getUIHandlerV2().post(new OnlineStatusSmartDisplayInfo.1.1(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.OnlineStatusSmartDisplayInfo.1
 * JD-Core Version:    0.7.0.1
 */