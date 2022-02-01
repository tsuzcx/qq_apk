package com.tencent.util;

import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

final class PermissionUtil$5
  implements QQPermissionCallback
{
  PermissionUtil$5(PermissionUtil.SDCardPermissionCallback paramSDCardPermissionCallback, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    PermissionUtil.a(this.b, this.a);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = this.a;
    if (paramArrayOfString != null) {
      paramArrayOfString.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.PermissionUtil.5
 * JD-Core Version:    0.7.0.1
 */