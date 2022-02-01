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
    if (this.jdField_a_of_type_ComTencentUtilPermissionUtil$SDCardPermissionCallback != null) {
      this.jdField_a_of_type_ComTencentUtilPermissionUtil$SDCardPermissionCallback.b();
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_ComTencentUtilPermissionUtil$SDCardPermissionCallback != null) {
      this.jdField_a_of_type_ComTencentUtilPermissionUtil$SDCardPermissionCallback.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.util.PermissionUtil.3
 * JD-Core Version:    0.7.0.1
 */