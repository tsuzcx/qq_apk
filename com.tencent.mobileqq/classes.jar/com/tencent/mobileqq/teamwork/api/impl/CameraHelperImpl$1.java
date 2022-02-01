package com.tencent.mobileqq.teamwork.api.impl;

import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class CameraHelperImpl$1
{
  CameraHelperImpl$1(CameraHelperImpl paramCameraHelperImpl) {}
  
  @QQPermissionDenied(1819)
  public void denied()
  {
    QLog.e("CameraHelperImpl", 1, "checkPermission user denied");
    CameraHelperImpl.access$000(this.a);
    CameraHelperImpl.access$100(this.a, false, 1830003);
  }
  
  @QQPermissionGrant(1819)
  public void grant()
  {
    QLog.d("CameraHelperImpl", 1, "checkPermission user grant");
    CameraHelperImpl.access$000(this.a);
    CameraHelperImpl.access$100(this.a, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.CameraHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */