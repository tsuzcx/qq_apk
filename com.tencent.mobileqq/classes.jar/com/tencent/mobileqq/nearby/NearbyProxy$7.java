package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.nearby.ipc.NearbyProxyObserver;
import com.tencent.qphone.base.util.QLog;

class NearbyProxy$7
  extends NearbyProxyObserver
{
  NearbyProxy$7(NearbyProxy paramNearbyProxy, int paramInt) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("realHasUnreadMsg", new Object[] { "onNearbyProcStart" });
    }
    NearbyProxy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyProxy, 4100, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyProxy.7
 * JD-Core Version:    0.7.0.1
 */