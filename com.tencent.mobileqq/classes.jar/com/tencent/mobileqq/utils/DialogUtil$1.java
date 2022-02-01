package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.util.PermissionUtil.SDCardPermissionCallback;

final class DialogUtil$1
  implements DialogInterface.OnClickListener
{
  DialogUtil$1(Activity paramActivity, PermissionUtil.SDCardPermissionCallback paramSDCardPermissionCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramDialogInterface.setData(Uri.fromParts("package", this.a.getPackageName(), null));
      this.a.startActivity(paramDialogInterface);
      return;
    }
    paramDialogInterface = this.b;
    if (paramDialogInterface != null) {
      paramDialogInterface.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DialogUtil.1
 * JD-Core Version:    0.7.0.1
 */