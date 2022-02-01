package com.tencent.util;

import android.app.Activity;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

final class PermissionUtil$4
  implements QQPermissionCallback
{
  PermissionUtil$4(PermissionUtil.SDCardPermissionCallback paramSDCardPermissionCallback, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentUtilPermissionUtil$SDCardPermissionCallback);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = this.jdField_a_of_type_ComTencentUtilPermissionUtil$SDCardPermissionCallback;
    if (paramArrayOfString != null) {
      paramArrayOfString.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.PermissionUtil.4
 * JD-Core Version:    0.7.0.1
 */