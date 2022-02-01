package com.tencent.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

public class PermissionUtil
{
  public static final String[] a = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
  public static final String[] b = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE" };
  private static boolean c;
  private static boolean d;
  
  @TargetApi(23)
  public static void a(Activity paramActivity, PermissionUtil.SDCardPermissionCallback paramSDCardPermissionCallback)
  {
    if ((paramActivity instanceof AppActivity))
    {
      b((AppActivity)paramActivity, paramSDCardPermissionCallback);
      return;
    }
    if ((paramActivity instanceof BaseActivity))
    {
      ((BaseActivity)paramActivity).requestPermissions(new PermissionUtil.3(paramSDCardPermissionCallback, paramActivity), 1, new String[] { a[0] });
      return;
    }
    paramActivity.requestPermissions(new String[] { a[0] }, 1);
  }
  
  public static void a(AppActivity paramAppActivity, int paramInt, QQPermissionCallback paramQQPermissionCallback)
  {
    paramAppActivity.requestPermissions(paramQQPermissionCallback, paramInt, new String[] { a[0] });
  }
  
  public static void a(AppActivity paramAppActivity, PermissionUtil.SDCardPermissionCallback paramSDCardPermissionCallback)
  {
    try
    {
      String str1 = HardCodeUtil.a(2131913955);
      String str2 = HardCodeUtil.a(2131913953);
      QQCustomDialog localQQCustomDialog = DialogUtil.a(paramAppActivity, 230);
      localQQCustomDialog.setTitle(str2);
      localQQCustomDialog.setMessage(str1);
      paramAppActivity = new PermissionUtil.1(paramAppActivity, paramSDCardPermissionCallback);
      localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131898212), paramAppActivity);
      localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131913954), paramAppActivity);
      localQQCustomDialog.setOnDismissListener(null);
      localQQCustomDialog.show();
      return;
    }
    catch (Throwable paramAppActivity) {}
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = c;
    boolean bool1 = bool2;
    if (!bool2) {
      if (Build.VERSION.SDK_INT >= 23)
      {
        bool1 = bool2;
        if (paramContext != null)
        {
          bool1 = bool2;
          if (paramContext.checkSelfPermission(a[0]) == 0)
          {
            c = true;
            return c;
          }
        }
      }
      else
      {
        c = true;
        bool1 = c;
      }
    }
    return bool1;
  }
  
  public static void b(Activity paramActivity, PermissionUtil.SDCardPermissionCallback paramSDCardPermissionCallback)
  {
    if ((paramActivity instanceof BaseActivity)) {
      ((BaseActivity)paramActivity).requestPermissions(new PermissionUtil.4(paramSDCardPermissionCallback, paramActivity), 1, new String[] { a[0] });
    }
  }
  
  public static void b(AppActivity paramAppActivity, PermissionUtil.SDCardPermissionCallback paramSDCardPermissionCallback)
  {
    paramAppActivity.requestPermissions(new PermissionUtil.2(paramSDCardPermissionCallback, paramAppActivity), 1, new String[] { a[0] });
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool2 = d;
    boolean bool1 = bool2;
    if (!bool2) {
      if (Build.VERSION.SDK_INT >= 23)
      {
        bool1 = bool2;
        if (paramContext != null)
        {
          bool1 = bool2;
          if (paramContext.checkSelfPermission(b[0]) == 0)
          {
            bool1 = bool2;
            if (paramContext.checkSelfPermission(b[1]) == 0)
            {
              d = true;
              return d;
            }
          }
        }
      }
      else
      {
        d = true;
        bool1 = d;
      }
    }
    return bool1;
  }
  
  @TargetApi(23)
  public static void c(Activity paramActivity, PermissionUtil.SDCardPermissionCallback paramSDCardPermissionCallback)
  {
    if ((paramActivity instanceof AppActivity))
    {
      paramActivity = (AppActivity)paramActivity;
      paramActivity.requestPermissions(new PermissionUtil.5(paramSDCardPermissionCallback, paramActivity), 1, b);
      return;
    }
    if ((paramActivity instanceof BaseActivity))
    {
      ((BaseActivity)paramActivity).requestPermissions(new PermissionUtil.6(paramSDCardPermissionCallback, paramActivity), 1, b);
      return;
    }
    paramActivity.requestPermissions(b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.PermissionUtil
 * JD-Core Version:    0.7.0.1
 */