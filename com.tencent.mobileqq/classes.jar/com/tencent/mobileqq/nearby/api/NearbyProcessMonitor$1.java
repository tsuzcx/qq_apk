package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.qroute.QRoute;

final class NearbyProcessMonitor$1
  implements Runnable
{
  NearbyProcessMonitor$1(String paramString) {}
  
  public void run()
  {
    NearbyProcessMonitor.b(this.a);
    NearbyProcessMonitor.a(this.a);
    NearbyProcessMonitor.a += 1;
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).preloadNearbyProcessStart(this.a);
    NearbyProcessMonitor.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbyProcessMonitor.1
 * JD-Core Version:    0.7.0.1
 */