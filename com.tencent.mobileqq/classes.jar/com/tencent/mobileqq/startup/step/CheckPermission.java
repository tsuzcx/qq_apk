package com.tencent.mobileqq.startup.step;

import alud;
import alzc;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Process;
import aznp;
import azns;
import aznt;
import aznu;
import aznv;
import aznw;
import aznx;
import azny;
import aznz;
import bdgm;
import bdjz;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

public class CheckPermission
  extends Step
  implements DialogInterface.OnClickListener, QQPermissionCallback
{
  private static final String[] EXPLAINS = { alud.a(2131702160), "QQ使用电话权限确定本机号码和设备ID，以保证帐号登录的安全性。QQ不会拨打其他号码或终止通话。\n请在设置中开启电话权限，以正常使用QQ功能。" };
  private static final String[] PERMS;
  private static final String[] PERMS_STORAGE = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE" };
  private static boolean sHasPhonePermission;
  private static boolean sHasStoragePermission;
  private static boolean sHasStorageReadAndWritePermission;
  private static boolean sPrivatePolicyShow = true;
  private static boolean sSystemPermissionShow;
  private AppActivity mAct;
  
  static
  {
    PERMS = new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
  }
  
  public static boolean isHasPhonePermission(Context paramContext)
  {
    boolean bool2 = sHasPhonePermission;
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label48;
      }
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.checkSelfPermission(PERMS[1]) == 0)
        {
          sHasPhonePermission = true;
          bool1 = sHasPhonePermission;
        }
      }
    }
    return bool1;
    label48:
    sHasPhonePermission = true;
    return sHasPhonePermission;
  }
  
  public static boolean isHasStoragePermission(Context paramContext)
  {
    boolean bool2 = sHasStoragePermission;
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label48;
      }
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.checkSelfPermission(PERMS[0]) == 0)
        {
          sHasStoragePermission = true;
          bool1 = sHasStoragePermission;
        }
      }
    }
    return bool1;
    label48:
    sHasStoragePermission = true;
    return sHasStoragePermission;
  }
  
  public static boolean isHasStorageReadAndWritePermission(Context paramContext)
  {
    boolean bool2 = sHasStorageReadAndWritePermission;
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label62;
      }
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.checkSelfPermission(PERMS_STORAGE[0]) == 0)
        {
          bool1 = bool2;
          if (paramContext.checkSelfPermission(PERMS_STORAGE[1]) == 0)
          {
            sHasStorageReadAndWritePermission = true;
            bool1 = sHasStorageReadAndWritePermission;
          }
        }
      }
    }
    return bool1;
    label62:
    sHasStorageReadAndWritePermission = true;
    return sHasStorageReadAndWritePermission;
  }
  
  public static void requestPhonePermission(AppActivity paramAppActivity, int paramInt, QQPermissionCallback paramQQPermissionCallback)
  {
    paramAppActivity.requestPermissions(paramQQPermissionCallback, paramInt, new String[] { PERMS[1] });
  }
  
  public static void requestSDCardPermission(AppActivity paramAppActivity, aznz paramaznz)
  {
    paramAppActivity.requestPermissions(new aznu(paramaznz, paramAppActivity), 1, new String[] { PERMS[0] });
  }
  
  public static void requestStoragePermission(AppActivity paramAppActivity, int paramInt, QQPermissionCallback paramQQPermissionCallback)
  {
    paramAppActivity.requestPermissions(paramQQPermissionCallback, paramInt, new String[] { PERMS[0] });
  }
  
  @TargetApi(23)
  public static void requestStorePermission(Activity paramActivity, aznz paramaznz)
  {
    if ((paramActivity instanceof AppActivity))
    {
      requestSDCardPermission((AppActivity)paramActivity, paramaznz);
      return;
    }
    if ((paramActivity instanceof BaseActivity))
    {
      ((BaseActivity)paramActivity).requestPermissions(new aznv(paramaznz, paramActivity), 1, new String[] { PERMS[0] });
      return;
    }
    paramActivity.requestPermissions(new String[] { PERMS[0] }, 1);
  }
  
  public static void requestStorePermissionWithWarning(Activity paramActivity, aznz paramaznz)
  {
    if ((paramActivity instanceof BaseActivity)) {
      ((BaseActivity)paramActivity).requestPermissions(new aznw(paramaznz, paramActivity), 1, new String[] { PERMS[0] });
    }
  }
  
  @TargetApi(23)
  public static void requestStoreReadAndWritePermission(Activity paramActivity, aznz paramaznz)
  {
    if ((paramActivity instanceof AppActivity))
    {
      AppActivity localAppActivity = (AppActivity)paramActivity;
      ((AppActivity)paramActivity).requestPermissions(new aznx(paramaznz, localAppActivity), 1, PERMS_STORAGE);
      return;
    }
    if ((paramActivity instanceof BaseActivity))
    {
      ((BaseActivity)paramActivity).requestPermissions(new azny(paramaznz, paramActivity), 1, PERMS_STORAGE);
      return;
    }
    paramActivity.requestPermissions(PERMS_STORAGE, 1);
  }
  
  public static void showSDCardExplainDialog(AppActivity paramAppActivity, aznz paramaznz)
  {
    try
    {
      String str1 = alud.a(2131708334);
      String str2 = alud.a(2131702157);
      bdjz localbdjz = bdgm.a(paramAppActivity, 230);
      localbdjz.setTitle(str2);
      localbdjz.setMessage(str1);
      paramAppActivity = new aznt(paramAppActivity, paramaznz);
      localbdjz.setNegativeButton(alud.a(2131702159), paramAppActivity);
      localbdjz.setPositiveButton(alud.a(2131702158), paramAppActivity);
      localbdjz.setOnDismissListener(null);
      localbdjz.show();
      return;
    }
    catch (Throwable paramAppActivity) {}
  }
  
  @TargetApi(23)
  public boolean checkPermission(AppActivity paramAppActivity)
  {
    if ((paramAppActivity != null) && (this.mAct != paramAppActivity)) {
      this.mAct = paramAppActivity;
    }
    if ((this.mAct == null) || (this.mAct.isFinishing())) {}
    for (;;)
    {
      return true;
      if (sPrivatePolicyShow)
      {
        if (alzc.a(0))
        {
          paramAppActivity = new azns(this);
          alzc.a(this.mAct, "", paramAppActivity, paramAppActivity).show();
          return false;
        }
        if (sSystemPermissionShow)
        {
          int i = PERMS.length;
          if (Build.VERSION.SDK_INT > 28) {
            i = 1;
          }
          int j = 0;
          while (j < i)
          {
            if (paramAppActivity.checkSelfPermission(PERMS[j]) != 0)
            {
              this.mAct.requestPermissions(this, j + 1, new String[] { PERMS[j] });
              return false;
            }
            j += 1;
          }
        }
      }
    }
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("AutoMonitor", 1, "deny" + paramInt);
    paramArrayOfString = EXPLAINS[(paramInt - 1)];
    paramArrayOfInt = alud.a(2131702157);
    bdjz localbdjz = bdgm.a(this.mAct, 230);
    localbdjz.setTitle(paramArrayOfInt);
    localbdjz.setMessage(paramArrayOfString);
    localbdjz.setNegativeButton(alud.a(2131702159), this);
    localbdjz.setPositiveButton(alud.a(2131702158), this);
    localbdjz.setOnDismissListener(null);
    localbdjz.show();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("AutoMonitor", 1, "grant" + paramInt);
    this.mAct = null;
    this.mDirector.b();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramDialogInterface.setData(Uri.fromParts("package", this.mAct.getPackageName(), null));
      this.mAct.startActivity(paramDialogInterface);
    }
    this.mAct.superFinish();
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.CheckPermission
 * JD-Core Version:    0.7.0.1
 */