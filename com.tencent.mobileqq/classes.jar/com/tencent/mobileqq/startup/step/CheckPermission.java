package com.tencent.mobileqq.startup.step;

import amtj;
import amxq;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Process;
import bcad;
import bcag;
import bcah;
import bcai;
import bcaj;
import bcak;
import bcal;
import bcam;
import bcan;
import bfur;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

public class CheckPermission
  extends Step
  implements DialogInterface.OnClickListener, QQPermissionCallback
{
  private static final String[] EXPLAINS = { amtj.a(2131700922), "QQ使用电话权限确定本机号码和设备ID，以保证帐号登录的安全性。QQ不会拨打其他号码或终止通话。\n请在设置中开启电话权限，以正常使用QQ功能。" };
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
  
  public static void requestSDCardPermission(AppActivity paramAppActivity, bcan parambcan)
  {
    paramAppActivity.requestPermissions(new bcai(parambcan, paramAppActivity), 1, new String[] { PERMS[0] });
  }
  
  public static void requestStoragePermission(AppActivity paramAppActivity, int paramInt, QQPermissionCallback paramQQPermissionCallback)
  {
    paramAppActivity.requestPermissions(paramQQPermissionCallback, paramInt, new String[] { PERMS[0] });
  }
  
  @TargetApi(23)
  public static void requestStorePermission(Activity paramActivity, bcan parambcan)
  {
    if ((paramActivity instanceof AppActivity))
    {
      requestSDCardPermission((AppActivity)paramActivity, parambcan);
      return;
    }
    if ((paramActivity instanceof BaseActivity))
    {
      ((BaseActivity)paramActivity).requestPermissions(new bcaj(parambcan, paramActivity), 1, new String[] { PERMS[0] });
      return;
    }
    paramActivity.requestPermissions(new String[] { PERMS[0] }, 1);
  }
  
  public static void requestStorePermissionWithWarning(Activity paramActivity, bcan parambcan)
  {
    if ((paramActivity instanceof BaseActivity)) {
      ((BaseActivity)paramActivity).requestPermissions(new bcak(parambcan, paramActivity), 1, new String[] { PERMS[0] });
    }
  }
  
  @TargetApi(23)
  public static void requestStoreReadAndWritePermission(Activity paramActivity, bcan parambcan)
  {
    if ((paramActivity instanceof AppActivity))
    {
      AppActivity localAppActivity = (AppActivity)paramActivity;
      ((AppActivity)paramActivity).requestPermissions(new bcal(parambcan, localAppActivity), 1, PERMS_STORAGE);
      return;
    }
    if ((paramActivity instanceof BaseActivity))
    {
      ((BaseActivity)paramActivity).requestPermissions(new bcam(parambcan, paramActivity), 1, PERMS_STORAGE);
      return;
    }
    paramActivity.requestPermissions(PERMS_STORAGE, 1);
  }
  
  public static void showSDCardExplainDialog(AppActivity paramAppActivity, bcan parambcan)
  {
    try
    {
      String str1 = amtj.a(2131707052);
      String str2 = amtj.a(2131700919);
      QQCustomDialog localQQCustomDialog = bfur.a(paramAppActivity, 230);
      localQQCustomDialog.setTitle(str2);
      localQQCustomDialog.setMessage(str1);
      paramAppActivity = new bcah(paramAppActivity, parambcan);
      localQQCustomDialog.setNegativeButton(amtj.a(2131700921), paramAppActivity);
      localQQCustomDialog.setPositiveButton(amtj.a(2131700920), paramAppActivity);
      localQQCustomDialog.setOnDismissListener(null);
      localQQCustomDialog.show();
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
        if (amxq.a(0))
        {
          paramAppActivity = new bcag(this);
          amxq.a(this.mAct, "", paramAppActivity, paramAppActivity).show();
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
    paramArrayOfInt = amtj.a(2131700919);
    QQCustomDialog localQQCustomDialog = bfur.a(this.mAct, 230);
    localQQCustomDialog.setTitle(paramArrayOfInt);
    localQQCustomDialog.setMessage(paramArrayOfString);
    localQQCustomDialog.setNegativeButton(amtj.a(2131700921), this);
    localQQCustomDialog.setPositiveButton(amtj.a(2131700920), this);
    localQQCustomDialog.setOnDismissListener(null);
    localQQCustomDialog.show();
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