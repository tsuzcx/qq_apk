package com.tencent.mobileqq.startup.step;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.PermissionUtil;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class CheckPermission
  extends Step
  implements DialogInterface.OnClickListener, QQPermissionCallback
{
  private static final String[] EXPLAINS = { HardCodeUtil.a(2131701848), "QQ使用电话权限确定本机号码和设备ID，以保证帐号登录的安全性。QQ不会拨打其他号码或终止通话。\n请在设置中开启电话权限，以正常使用QQ功能。" };
  private static boolean sPrivatePolicyShow = true;
  private static boolean sSystemPermissionShow = false;
  private AppActivity mAct;
  
  public static boolean isHasStoragePermission(Context paramContext)
  {
    return PermissionUtil.a(paramContext);
  }
  
  public static boolean isHasStorageReadAndWritePermission(Context paramContext)
  {
    return PermissionUtil.b(paramContext);
  }
  
  public static void requestSDCardPermission(AppActivity paramAppActivity, CheckPermission.SDCardPermissionCallback paramSDCardPermissionCallback)
  {
    PermissionUtil.b(paramAppActivity, paramSDCardPermissionCallback);
  }
  
  public static void requestStoragePermission(AppActivity paramAppActivity, int paramInt, QQPermissionCallback paramQQPermissionCallback)
  {
    PermissionUtil.a(paramAppActivity, paramInt, paramQQPermissionCallback);
  }
  
  public static void requestStorePermission(Activity paramActivity, CheckPermission.SDCardPermissionCallback paramSDCardPermissionCallback)
  {
    PermissionUtil.a(paramActivity, paramSDCardPermissionCallback);
  }
  
  public static void requestStorePermissionWithWarning(Activity paramActivity, CheckPermission.SDCardPermissionCallback paramSDCardPermissionCallback)
  {
    PermissionUtil.b(paramActivity, paramSDCardPermissionCallback);
  }
  
  public static void requestStoreReadAndWritePermission(Activity paramActivity, CheckPermission.SDCardPermissionCallback paramSDCardPermissionCallback)
  {
    PermissionUtil.c(paramActivity, paramSDCardPermissionCallback);
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
        if (!PrivacyPolicyHelper.a())
        {
          paramAppActivity = new CheckPermission.1(this);
          PrivacyPolicyHelper.a(this.mAct, "", paramAppActivity, paramAppActivity).show();
          return false;
        }
        if (sSystemPermissionShow)
        {
          int i = PermissionUtil.a.length;
          if (Build.VERSION.SDK_INT > 28) {
            i = 1;
          }
          int j = 0;
          while (j < i)
          {
            if (paramAppActivity.checkSelfPermission(PermissionUtil.a[j]) != 0)
            {
              this.mAct.requestPermissions(this, j + 1, new String[] { PermissionUtil.a[j] });
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
    paramArrayOfInt = HardCodeUtil.a(2131701845);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.mAct, 230);
    localQQCustomDialog.setTitle(paramArrayOfInt);
    localQQCustomDialog.setMessage(paramArrayOfString);
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131701847), this);
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131701846), this);
    localQQCustomDialog.setOnDismissListener(null);
    localQQCustomDialog.show();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("AutoMonitor", 1, "grant" + paramInt);
    this.mAct = null;
    this.mDirector.a();
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