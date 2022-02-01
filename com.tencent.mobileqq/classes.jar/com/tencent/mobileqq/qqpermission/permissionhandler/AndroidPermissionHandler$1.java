package com.tencent.mobileqq.qqpermission.permissionhandler;

import androidx.annotation.RequiresApi;
import mqq.app.QQPermissionCallback;

class AndroidPermissionHandler$1
  implements QQPermissionCallback
{
  AndroidPermissionHandler$1(AndroidPermissionHandler paramAndroidPermissionHandler) {}
  
  @RequiresApi(api=23)
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  @RequiresApi(api=23)
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a(paramInt, paramArrayOfString, paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler.1
 * JD-Core Version:    0.7.0.1
 */