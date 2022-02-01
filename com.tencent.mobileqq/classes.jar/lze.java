import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.BaseActivity;

public class lze
  extends lzd
  implements DialogInterface.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new lzf(this);
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private QQCustomDialog b;
  
  public lze(BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
  }
  
  private QQCustomDialog a()
  {
    QQCustomDialog localQQCustomDialog;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      localQQCustomDialog = bhdj.a(this.jdField_a_of_type_MqqAppBaseActivity, 230).setMessage(2131695611).setNegativeButton(2131690697, this);
      if (!c()) {
        break label79;
      }
    }
    label79:
    for (int i = 2131695615;; i = 2131695626)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = localQQCustomDialog.setPositiveButton(i, this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131695613);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
      return this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    }
  }
  
  static boolean a()
  {
    return !"vivo".equalsIgnoreCase(DeviceInfoUtil.getManufactureInfo());
  }
  
  private QQCustomDialog b()
  {
    if (this.b == null)
    {
      this.b = bhdj.a(this.jdField_a_of_type_MqqAppBaseActivity, 230).setMessage(2131695450).setPositiveButton(2131695367, this);
      this.b.setCancelable(false);
      this.b.setCanceledOnTouchOutside(false);
    }
    return this.b;
  }
  
  private boolean c()
  {
    if ((lzr.a(this.jdField_a_of_type_MqqAppBaseActivity, "miui.intent.action.APP_PERM_EDITOR")) || (lzr.a(this.jdField_a_of_type_MqqAppBaseActivity, "com.meizu.safe.security.SHOW_APPSEC")) || (lzr.a(this.jdField_a_of_type_MqqAppBaseActivity, "huawei.intent.action.NOTIFICATIONMANAGER")) || (lzr.a(this.jdField_a_of_type_MqqAppBaseActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION"))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (bool1) {
        bool2 = b();
      }
      return bool2;
    }
  }
  
  protected void a()
  {
    if (lzr.b(this.jdField_a_of_type_MqqAppBaseActivity))
    {
      QLog.w("FloatWindowPrivacyModel", 1, "锁屏中，不弹1");
      this.jdField_a_of_type_MqqAppBaseActivity.finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      a();
      a("onResume.1", this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      return;
    }
    if (!lzr.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()))
    {
      b();
      a("onResume.1", this.b);
      return;
    }
    QLog.w("FloatWindowPrivacyModel", 1, "onResume, finish");
    this.jdField_a_of_type_MqqAppBaseActivity.finish();
  }
  
  protected void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.jdField_a_of_type_MqqAppBaseActivity.getAppRuntime());
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.video.v2q.SmallScreenState");
    this.jdField_a_of_type_MqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (lzr.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())) {
      this.jdField_a_of_type_MqqAppBaseActivity.finish();
    }
  }
  
  protected void b() {}
  
  boolean b()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.equalsIgnoreCase("PCKM80"))) {
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FloatWindowPrivacyModel", 2, "isSupport, manufacturer[" + Build.MANUFACTURER + "], model[" + Build.MODEL + "], bSupport[" + bool1 + "]");
      }
      return bool1;
      if (Build.MANUFACTURER.equalsIgnoreCase("VIVO"))
      {
        bool1 = bool2;
        if (!Build.MODEL.equalsIgnoreCase("V1838A"))
        {
          bool1 = bool2;
          if (!Build.MODEL.equalsIgnoreCase("V1936A"))
          {
            bool1 = bool2;
            if (Build.MODEL.equalsIgnoreCase("vivo X9s L")) {}
          }
        }
      }
      else if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI"))
      {
        bool1 = bool2;
        if (Build.MODEL.equalsIgnoreCase("H60-L01")) {}
      }
      else if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"))
      {
        bool1 = bool2;
        if (Build.MODEL.equalsIgnoreCase("MI 5X")) {}
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  protected void c() {}
  
  protected void d()
  {
    this.jdField_a_of_type_MqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  void e()
  {
    boolean bool3 = false;
    String str3 = this.jdField_a_of_type_MqqAppBaseActivity.getPackageName();
    Object localObject1 = null;
    if ((a()) && (lzr.a(this.jdField_a_of_type_MqqAppBaseActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION"))) {
      localObject1 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + str3));
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_MqqAppBaseActivity.startActivity((Intent)localObject1);
        localObject1 = "ACTION_ANDROID";
        bool2 = true;
      }
      catch (Exception localException1)
      {
        Object localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", localException1);
        str1 = "Exception:" + localException1.getMessage();
        bool2 = false;
        continue;
      }
      boolean bool1 = bool2;
      localObject3 = localObject1;
      if (!bool2)
      {
        bool1 = bool2;
        localObject3 = localObject1;
        if (lzr.a(this.jdField_a_of_type_MqqAppBaseActivity, "miui.intent.action.APP_PERM_EDITOR"))
        {
          localObject3 = new Intent("miui.intent.action.APP_PERM_EDITOR");
          ((Intent)localObject3).setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
          ((Intent)localObject3).putExtra("extra_pkgname", str3);
        }
      }
      try
      {
        this.jdField_a_of_type_MqqAppBaseActivity.startActivity((Intent)localObject3);
        localObject3 = "ACTION_MIUI";
        bool1 = true;
      }
      catch (Exception localException3)
      {
        if (!QLog.isColorLevel()) {
          break label536;
        }
        QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", localException3);
        bool1 = false;
        str2 = str1;
        continue;
      }
      boolean bool2 = bool1;
      localObject1 = localObject3;
      if (!bool1)
      {
        bool2 = bool1;
        localObject1 = localObject3;
        if (lzr.a(this.jdField_a_of_type_MqqAppBaseActivity, "com.meizu.safe.security.SHOW_APPSEC"))
        {
          localObject1 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
          ((Intent)localObject1).setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
          ((Intent)localObject1).putExtra("packageName", str3);
        }
      }
      try
      {
        this.jdField_a_of_type_MqqAppBaseActivity.startActivity((Intent)localObject1);
        localObject1 = "ACTION_MEIZU";
        bool2 = true;
      }
      catch (Exception localException2)
      {
        label536:
        if (!QLog.isColorLevel()) {
          break label564;
        }
        QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", localException2);
        label564:
        bool2 = false;
        localObject2 = str2;
        continue;
      }
      if ((!bool2) && ("vivo".equalsIgnoreCase(DeviceInfoUtil.getManufactureInfo())) && (lzr.a(this.jdField_a_of_type_MqqAppBaseActivity, "permission.intent.action.softPermissionDetail")))
      {
        localObject3 = new Intent("permission.intent.action.softPermissionDetail");
        try
        {
          ((Intent)localObject3).putExtra("packagename", str3);
          this.jdField_a_of_type_MqqAppBaseActivity.startActivity((Intent)localObject3);
          localObject1 = "ACTION_VIVO";
          bool1 = true;
        }
        catch (Exception localException4)
        {
          if (!QLog.isColorLevel()) {
            break label592;
          }
          QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", localException4);
          bool1 = false;
          continue;
        }
        localObject3 = localObject1;
        bool2 = bool1;
        if (!bool1)
        {
          localObject3 = localObject1;
          bool2 = bool1;
          if (lzr.a(this.jdField_a_of_type_MqqAppBaseActivity, "huawei.intent.action.NOTIFICATIONMANAGER"))
          {
            localObject3 = new Intent();
            ((Intent)localObject3).setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
            try
            {
              this.jdField_a_of_type_MqqAppBaseActivity.startActivity((Intent)localObject3);
              localObject1 = "ACTION_HUAWEI_1";
              bool1 = true;
            }
            catch (Exception localException5)
            {
              if (!QLog.isColorLevel()) {
                break label616;
              }
              QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", localException5);
              bool1 = false;
              continue;
            }
            localObject3 = localObject1;
            bool2 = bool1;
            if (!bool1)
            {
              localObject3 = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
              try
              {
                this.jdField_a_of_type_MqqAppBaseActivity.startActivity((Intent)localObject3);
                localObject3 = "ACTION_HUAWEI_2";
                bool1 = true;
              }
              catch (Exception localException6)
              {
                String str1;
                String str2;
                Object localObject2;
                Object localObject4 = localObject2;
                bool1 = bool3;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", localException6);
                localObject4 = localObject2;
                bool1 = bool3;
                continue;
                this.jdField_a_of_type_Int += 1;
                this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
                return;
              }
              QLog.w("FloatWindowPrivacyModel", 1, "openPermissionActivity, openSuccess[" + bool1 + "], code[" + (String)localObject3 + "]");
              if (!bool1)
              {
                b();
                a("openPermissionActivity", this.b);
                return;
              }
            }
          }
        }
        label592:
        label616:
        bool1 = bool2;
        continue;
      }
      bool1 = bool2;
      continue;
      bool2 = false;
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface.equals(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog)) {
      switch (paramInt)
      {
      }
    }
    while (!paramDialogInterface.equals(this.b))
    {
      return;
      boolean bool = this.jdField_a_of_type_MqqAppBaseActivity.getIntent().getBooleanExtra("is_video", false);
      paramDialogInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      lzr.a(paramDialogInterface, lzr.a(paramDialogInterface, bool) + 1, bool);
      this.jdField_a_of_type_MqqAppBaseActivity.finish();
      return;
      if (c())
      {
        e();
        return;
      }
      b();
      a("WHICH_POSITIVE", this.b);
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_MqqAppBaseActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lze
 * JD-Core Version:    0.7.0.1
 */