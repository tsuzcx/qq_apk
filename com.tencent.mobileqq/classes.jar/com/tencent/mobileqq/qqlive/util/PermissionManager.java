package com.tencent.mobileqq.qqlive.util;

import android.os.Build.VERSION;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.qphone.base.util.QLog;

public class PermissionManager
{
  BusinessConfig a = new BusinessConfig("biz_src_qqlive_camera_record_android", "qq_live_game");
  private QQPermission b = null;
  
  private void a(Fragment paramFragment, String[] paramArrayOfString, QQPermission.BasePermissionsListener paramBasePermissionsListener)
  {
    if (this.b == null) {
      this.b = QQPermissionFactory.a(paramFragment, this.a);
    }
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      if ((Build.VERSION.SDK_INT >= 23) && ((this.b.a("android.permission.CAMERA") != 0) || (this.b.a("android.permission.RECORD_AUDIO") != 0)))
      {
        this.b.a(paramArrayOfString, 2, new PermissionManager.1(this, paramBasePermissionsListener));
        return;
      }
      paramBasePermissionsListener.a();
      return;
    }
    QLog.d("PermissionManager", 1, "the permission is empty");
  }
  
  public void a(Fragment paramFragment, QQPermission.BasePermissionsListener paramBasePermissionsListener)
  {
    a(paramFragment, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" }, paramBasePermissionsListener);
  }
  
  public void b(Fragment paramFragment, QQPermission.BasePermissionsListener paramBasePermissionsListener)
  {
    a(paramFragment, new String[] { "android.permission.ACCESS_COARSE_LOCATION" }, paramBasePermissionsListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.util.PermissionManager
 * JD-Core Version:    0.7.0.1
 */