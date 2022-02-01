package com.tencent.mobileqq.teamwork.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ICameraHelper
  extends QRouteApi
{
  public static final long DELAY_CAMERA_PERMISSION_UNCERTAIN = 10000L;
  public static final int ERROR_CAMERA_PERMISSION_DENIED = 1830003;
  public static final int ERROR_CAMERA_PERMISSION_UNCERTAIN = 1830004;
  public static final String METHOD_CAMERA_CHECK_PERMISSION = "cameraCheckPermission";
  public static final int MSG_CAMERA_PERMISSION_UNCERTAIN = 1;
  public static final int REQUEST_CODE_CAMERA_PERMISSION = 1819;
  
  public abstract boolean checkPermission(String paramString);
  
  public abstract void destroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.ICameraHelper
 * JD-Core Version:    0.7.0.1
 */