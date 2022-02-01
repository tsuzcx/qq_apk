package com.tencent.util;

import android.app.Activity;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

final class PermissionUtil$3
  implements QQPermissionCallback
{
  PermissionUtil$3(PermissionUtil.SDCardPermissionCallback paramSDCardPermissionCallback, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = this.a;
    if (paramArrayOfString != null) {
      paramArrayOfString.b();
    }
    DialogUtil.a(this.b);
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
 * Qualified Name:     com.tencent.util.PermissionUtil.3
 * JD-Core Version:    0.7.0.1
 */