package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProxyObserver;
import com.tencent.qphone.base.util.QLog;

class NearbyProxy$7
  extends NearbyProxyObserver
{
  NearbyProxy$7(NearbyProxy paramNearbyProxy, int paramInt) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("realHasUnreadMsg", new Object[] { "onNearbyProcStart" });
    }
    NearbyProxy.a(this.b, 4100, new Object[] { Integer.valueOf(this.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbyProxy.7
 * JD-Core Version:    0.7.0.1
 */