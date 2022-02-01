package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProxyObserver;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify;

class NearbyProxy$8
  extends NearbyProxyObserver
{
  NearbyProxy$8(NearbyProxy paramNearbyProxy, SubMsgType0x27.AppointmentNotify paramAppointmentNotify) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("hasOnLinePush", new Object[] { "onNearbyProcStart" });
    }
    NearbyProxy.a(this.b, 4101, new Object[] { this.a.toByteArray() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbyProxy.8
 * JD-Core Version:    0.7.0.1
 */