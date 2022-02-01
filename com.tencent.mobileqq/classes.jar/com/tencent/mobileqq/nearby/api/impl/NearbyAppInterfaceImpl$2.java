package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class NearbyAppInterfaceImpl$2
  implements Runnable
{
  NearbyAppInterfaceImpl$2(NearbyAppInterfaceImpl paramNearbyAppInterfaceImpl) {}
  
  public void run()
  {
    synchronized (this.this$0.mLock)
    {
      boolean bool = this.this$0.mDPCInit;
      if (!bool)
      {
        try
        {
          ((IDPCApi)QRoute.api(IDPCApi.class)).registerBroadCast(this.this$0);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyAppInterface", 2, "onDestroy: ", localException);
          }
        }
        this.this$0.mDPCInit = true;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbyAppInterfaceImpl.2
 * JD-Core Version:    0.7.0.1
 */