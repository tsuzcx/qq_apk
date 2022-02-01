package com.tencent.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import mqq.app.AppActivity;

final class PermissionUtil$1
  implements DialogInterface.OnClickListener
{
  PermissionUtil$1(AppActivity paramAppActivity, PermissionUtil.SDCardPermissionCallback paramSDCardPermissionCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramDialogInterface.setData(Uri.fromParts("package", this.jdField_a_of_type_MqqAppAppActivity.getPackageName(), null));
      this.jdField_a_of_type_MqqAppAppActivity.startActivity(paramDialogInterface);
    }
    while (this.jdField_a_of_type_ComTencentUtilPermissionUtil$SDCardPermissionCallback == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentUtilPermissionUtil$SDCardPermissionCallback.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.util.PermissionUtil.1
 * JD-Core Version:    0.7.0.1
 */