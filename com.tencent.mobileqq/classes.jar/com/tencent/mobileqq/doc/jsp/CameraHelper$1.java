package com.tencent.mobileqq.doc.jsp;

import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class CameraHelper$1
{
  CameraHelper$1(CameraHelper paramCameraHelper) {}
  
  @QQPermissionDenied(1819)
  public void denied()
  {
    QLog.e("CameraHelper", 1, "checkPermission user denied");
    CameraHelper.a(this.a);
    CameraHelper.a(this.a, false, 1830003);
  }
  
  @QQPermissionGrant(1819)
  public void grant()
  {
    QLog.d("CameraHelper", 1, "checkPermission user grant");
    CameraHelper.a(this.a);
    CameraHelper.a(this.a, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doc.jsp.CameraHelper.1
 * JD-Core Version:    0.7.0.1
 */