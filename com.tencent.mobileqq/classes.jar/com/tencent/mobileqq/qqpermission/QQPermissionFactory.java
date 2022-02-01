package com.tencent.mobileqq.qqpermission;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;

public class QQPermissionFactory
{
  public static QQPermission a(Fragment paramFragment)
  {
    QQPermission localQQPermission = null;
    if (paramFragment != null)
    {
      if (paramFragment.getContext() == null) {
        return null;
      }
      QQPermissionConfig localQQPermissionConfig = (QQPermissionConfig)paramFragment.getClass().getAnnotation(QQPermissionConfig.class);
      if (localQQPermissionConfig == null) {
        return null;
      }
      localQQPermission = new QQPermission(paramFragment);
      localQQPermission.a(localQQPermissionConfig);
    }
    return localQQPermission;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.QQPermissionFactory
 * JD-Core Version:    0.7.0.1
 */