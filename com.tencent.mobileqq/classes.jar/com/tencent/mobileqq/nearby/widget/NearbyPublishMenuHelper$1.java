package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

final class NearbyPublishMenuHelper$1
  implements QQPermissionCallback
{
  NearbyPublishMenuHelper$1(Context paramContext, String paramString, AppActivity paramAppActivity, Intent paramIntent) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPublishMenuHelper", 2, "permissions deny");
    }
    DialogUtil.a(this.c, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPublishMenuHelper", 2, "permissions grant");
    }
    try
    {
      NearbyPublishMenuHelper.c(this.a).edit().putString("camera_photo_path", this.b).commit();
      this.c.startActivityForResult(this.d, 1001);
      if (QLog.isColorLevel())
      {
        QLog.d("NearbyPublishMenuHelper", 2, "takePhoto");
        return;
      }
    }
    catch (Exception paramArrayOfString)
    {
      QLog.e("NearbyPublishMenuHelper", 1, paramArrayOfString, new Object[0]);
      QQToast.makeText(this.a, 2131887645, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper.1
 * JD-Core Version:    0.7.0.1
 */