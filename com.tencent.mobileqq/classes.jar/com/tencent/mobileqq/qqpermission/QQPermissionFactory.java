package com.tencent.mobileqq.qqpermission;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.util.QPLog;

public class QQPermissionFactory
{
  public static QQPermission a(Activity paramActivity)
  {
    return a(paramActivity, null, a((QQPermissionConfig)paramActivity.getClass().getAnnotation(QQPermissionConfig.class)));
  }
  
  private static QQPermission a(Activity paramActivity, Fragment paramFragment, BusinessConfig paramBusinessConfig)
  {
    if (((paramFragment == null) || (paramFragment.getContext() == null)) && (paramActivity == null))
    {
      QPLog.b("QQPermissionFactory", new Object[] { "getQQPermission: activity or fragment is null" });
      return null;
    }
    if (paramBusinessConfig == null)
    {
      QPLog.b("QQPermissionFactory", new Object[] { "getQQPermission: BusinessConfig is null" });
      return null;
    }
    paramActivity = new QQPermission(paramActivity, paramFragment);
    paramActivity.a(paramBusinessConfig);
    return paramActivity;
  }
  
  public static QQPermission a(Activity paramActivity, BusinessConfig paramBusinessConfig)
  {
    return a(paramActivity, null, paramBusinessConfig);
  }
  
  public static QQPermission a(Fragment paramFragment)
  {
    return a(null, paramFragment, a((QQPermissionConfig)paramFragment.getClass().getAnnotation(QQPermissionConfig.class)));
  }
  
  public static QQPermission a(Fragment paramFragment, BusinessConfig paramBusinessConfig)
  {
    return a(null, paramFragment, paramBusinessConfig);
  }
  
  private static BusinessConfig a(QQPermissionConfig paramQQPermissionConfig)
  {
    if (paramQQPermissionConfig == null) {
      return null;
    }
    return new BusinessConfig(paramQQPermissionConfig.id(), paramQQPermissionConfig.scene());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.QQPermissionFactory
 * JD-Core Version:    0.7.0.1
 */