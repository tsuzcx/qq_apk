package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.qphone.base.util.QLog;

class NearbyAppInterface$2
  implements Runnable
{
  NearbyAppInterface$2(NearbyAppInterface paramNearbyAppInterface) {}
  
  public void run()
  {
    synchronized (this.this$0.a)
    {
      boolean bool = this.this$0.d;
      if (!bool) {}
      try
      {
        DeviceProfileManager.a(this.this$0, 215).a(this.this$0);
        this.this$0.d = true;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyAppInterface", 2, "onDestroy: ", localException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyAppInterface.2
 * JD-Core Version:    0.7.0.1
 */