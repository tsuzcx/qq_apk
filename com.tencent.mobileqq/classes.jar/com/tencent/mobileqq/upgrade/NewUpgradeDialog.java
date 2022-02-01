package com.tencent.mobileqq.upgrade;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SPSettings;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.appcircle.st.STUtils;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.downloadnew.ControlPolicyUtil;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;

public class NewUpgradeDialog
  extends QQCustomDialog
{
  private static long jdField_a_of_type_Long = 0L;
  private static int jdField_b_of_type_Int = 3;
  private static boolean jdField_c_of_type_Boolean = false;
  private int jdField_a_of_type_Int = 1;
  protected View.OnClickListener a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener;
  protected final WeakReference<Activity> a;
  private boolean jdField_a_of_type_Boolean = false;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = false;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  private volatile boolean jdField_e_of_type_Boolean = false;
  TextView f;
  
  public NewUpgradeDialog(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new NewUpgradeDialog.4(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    requestWindowFeature(1);
    paramActivity = new ColorDrawable();
    paramActivity.setAlpha(0);
    getWindow().setBackgroundDrawable(paramActivity);
    setContentView(2131559502);
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new NewUpgradeDialog.YYBDownloadListener(this);
    this.jdField_b_of_type_Boolean = ControlPolicyUtil.b();
    DownloadManager.a();
    setOnKeyListener(new NewUpgradeDialog.1(this));
    a();
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, jdField_b_of_type_Int, 1, 100));
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, jdField_b_of_type_Int, 2, 100));
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, jdField_b_of_type_Int, 3, 100));
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, jdField_b_of_type_Int, 4, 100));
    AppCircleReportManager.a().a(16, STUtils.a(10010, jdField_b_of_type_Int, 1, 100));
    AppCircleReportManager.a().a(16, STUtils.a(10010, jdField_b_of_type_Int, 2, 100));
    AppCircleReportManager.a().a(16, STUtils.a(10010, jdField_b_of_type_Int, 3, 100));
    AppCircleReportManager.a().a(16, STUtils.a(10010, jdField_b_of_type_Int, 4, 100));
    if (jdField_b_of_type_Int == 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X8008F7F", "0X8008F7F", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X8008F82", "0X8008F82", 0, 0, "", "", "", "");
  }
  
  public static String a(double paramDouble, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt <= 0)
    {
      localStringBuilder.append((int)Math.round(paramDouble));
      return localStringBuilder.toString();
    }
    if (paramInt == 1)
    {
      i = (int)paramDouble;
      d1 = i;
      Double.isNaN(d1);
      if (paramDouble >= d1 + 0.95D)
      {
        localStringBuilder.append(i + 1);
        break label79;
      }
    }
    localStringBuilder.append((int)paramDouble);
    label79:
    localStringBuilder.append(".");
    int j = 0;
    double d1 = 1.0D;
    int i = 0;
    while (i < paramInt)
    {
      d1 *= 10.0D;
      i += 1;
    }
    double d2 = (int)paramDouble;
    Double.isNaN(d2);
    paramDouble = Math.round((paramDouble - d2) * d1);
    Double.isNaN(paramDouble);
    paramDouble = Math.abs(paramDouble / d1);
    i = j;
    while (i < paramInt)
    {
      paramDouble *= 10.0D;
      localStringBuilder.append((int)paramDouble % 10);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(float paramFloat, boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(a(paramFloat / 1024.0F / 1024.0F, paramInt));
    if (paramBoolean)
    {
      localStringBuilder.append("MB");
      return localStringBuilder.toString();
    }
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    jdField_c_of_type_Boolean = SPSettings.a();
    if (jdField_c_of_type_Boolean)
    {
      jdField_b_of_type_Int = 2;
      return;
    }
    jdField_b_of_type_Int = 3;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.f.getPaint().setFakeBoldText(false);
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 10)
            {
              if (paramInt == 20) {}
            }
            else {
              this.f.setText(HardCodeUtil.a(2131707594));
            }
          }
          else {
            this.f.setText(HardCodeUtil.a(2131707601));
          }
        }
        else {
          this.f.setText(HardCodeUtil.a(2131707597));
        }
      }
      else
      {
        this.f.setText(HardCodeUtil.a(2131707587));
        return;
      }
    }
    this.f.setText(HardCodeUtil.a(2131707599));
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (System.currentTimeMillis() - jdField_a_of_type_Long <= 1000L) {
      return false;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject = UpgradeController.a().a();
    if ((localObject != null) && (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) && (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("sdkShowNotification", 0);
      localBundle.putBoolean("showNetworkDialog", false);
      localBundle.putString("appName", ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("url", ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
      localBundle.putString("via", "ANDROIDQQ.YYB.QQUPDATE");
      String str = String.valueOf(((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iAppid);
      localBundle.putString("appId", str);
      localBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
      localBundle.putBoolean("autoInstall", true);
      int j = ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int;
      int i = j;
      if (j == 999) {
        i = 718;
      }
      localBundle.putInt("versionCode", i);
      localBundle.putString("packageName", BaseApplicationImpl.getApplication().getPackageName());
      localBundle.putInt("downloadType", 1);
      localBundle.putBoolean("autoDownload", true);
      localObject = DownloadManager.a().a(str);
      if (localObject != null) {
        localObject = ((DownloadInfo)localObject).l;
      } else {
        localObject = "";
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists()))
      {
        localBundle.putInt(DownloadConstants.k, 5);
        DownloadApi.a(localBundle, "biz_src_jc_update", UpgradeController.a().a().jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
        return true;
      }
      if ((!ControlPolicyUtil.h()) && (!MyAppApi.a().g()))
      {
        UpgradeDetailActivity.a(paramActivity, UpgradeController.a().a(), false, true, true);
        return true;
      }
      ThreadManager.getSubThreadHandler().post(new NewUpgradeDialog.7(paramActivity, localBundle));
      return true;
    }
    ToastUtil.a().a(HardCodeUtil.a(2131707591));
    return false;
  }
  
  public static void b()
  {
    jdField_c_of_type_Boolean = true;
    jdField_b_of_type_Int = 2;
  }
  
  private void e()
  {
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, jdField_b_of_type_Int, 3, 300));
    AppCircleReportManager.a().a(21, STUtils.a(10010, jdField_b_of_type_Int, 3, 300));
    DownloadInfo localDownloadInfo = DownloadManager.a().a("1101070898");
    DownloadManager.a().c(localDownloadInfo);
  }
  
  private void f()
  {
    ThreadManager.getUIHandler().post(new NewUpgradeDialog.5(this));
    i();
    e();
  }
  
  private void g()
  {
    this.jdField_b_of_type_Boolean = ControlPolicyUtil.b();
    if (this.jdField_b_of_type_Boolean)
    {
      if (!APNUtil.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))
      {
        ToastUtil.a().a(HardCodeUtil.a(2131707586));
        return;
      }
      a(2);
      DownloadManager.a().a(DownloadManager.a().a("1101070898"));
    }
  }
  
  private void h()
  {
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, jdField_b_of_type_Int, 3, 200));
    AppCircleReportManager.a().a(17, STUtils.a(10010, jdField_b_of_type_Int, 3, 200));
    if (jdField_b_of_type_Int == 2) {
      ReportController.b(null, "dc00898", "", "", "0X8008F81", "0X8008F81", 0, 0, "", "", "", "");
    } else {
      ReportController.b(null, "dc00898", "", "", "0X8008F84", "0X8008F84", 0, 0, "", "", "", "");
    }
    MyAppApi.a();
    if (MyAppApi.b())
    {
      a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      dismiss();
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    DownloadInfo localDownloadInfo = DownloadManager.a().a("1101070898");
    this.jdField_b_of_type_Boolean = ControlPolicyUtil.b();
    if (this.jdField_b_of_type_Boolean)
    {
      if (!APNUtil.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))
      {
        ToastUtil.a().a(HardCodeUtil.a(2131707588));
        this.jdField_a_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = false;
        return;
      }
      if ((localDownloadInfo != null) && (localDownloadInfo.a() != 4)) {
        a(localDownloadInfo.f, localDownloadInfo.a());
      }
      if ((localDownloadInfo == null) || (localDownloadInfo.a() == 1) || (localDownloadInfo.a() == 10) || (localDownloadInfo.a() == 3) || (localDownloadInfo.a() == 4))
      {
        LogUtility.b("NewUpgradeDialog", STUtils.a(10010, jdField_b_of_type_Int, 3, 500));
        AppCircleReportManager.a().a(18, STUtils.a(10010, jdField_b_of_type_Int, 3, 500));
        MyAppApi.a().a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), "ANDROIDQQ.NEWYYB.QQUPDATE", true);
      }
    }
    else
    {
      ThreadManager.post(new NewUpgradeDialog.6(this), 5, null, false);
    }
    DownloadManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
  }
  
  private void i()
  {
    Object localObject1 = UpgradeController.a().a();
    if ((localObject1 != null) && (((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) && (((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo != null))
    {
      int j = ((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int;
      int i = j;
      if (j == 999) {
        i = 718;
      }
      j = 0;
      try
      {
        int k = BaseActivity.sTopActivity.getPackageManager().getPackageInfo(BaseActivity.sTopActivity.getPackageName(), 0).versionCode;
        j = k;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        localNameNotFoundException.printStackTrace();
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("tmast://appdetails?r=0.9138136501079244&pname=com.tencent.mobileqq&oplist=1%3B2&via=ANDROIDQQ.NEWYYB.QQUPDATE&appid=");
      ((StringBuilder)localObject2).append(((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iAppid);
      ((StringBuilder)localObject2).append("&versioncode=");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("&hostpname=");
      ((StringBuilder)localObject2).append(BaseApplicationImpl.getApplication().getPackageName());
      ((StringBuilder)localObject2).append("&hostversioncode=");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append("\"\n");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("url", (String)localObject1);
      DownloadApi.a((Bundle)localObject2);
      DownloadApi.b((Bundle)localObject2);
      MyAppApi.a().a();
      k();
      return;
    }
    ToastUtil.a().a(HardCodeUtil.a(2131707596));
  }
  
  private void j()
  {
    this.f.getPaint().setFakeBoldText(true);
    this.f.setText(HardCodeUtil.a(2131707590));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 1;
  }
  
  private void k()
  {
    UpgradeDetailWrapper localUpgradeDetailWrapper = UpgradeController.a().a();
    if ((localUpgradeDetailWrapper != null) && (localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) && (localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("sdkShowNotification", 0);
      localBundle.putBoolean("showNetworkDialog", false);
      localBundle.putString("appName", localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("url", localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
      localBundle.putString("via", "ANDROIDQQ.YYB.QQUPDATE");
      localBundle.putString("appId", String.valueOf(localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iAppid));
      localBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
      localBundle.putBoolean("autoInstall", true);
      int j = localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int;
      int i = j;
      if (j == 999) {
        i = 718;
      }
      localBundle.putInt("versionCode", i);
      localBundle.putString("packageName", "com.tencent.mobileqq");
      localBundle.putInt("downloadType", 1);
      localBundle.putBoolean("autoDownload", true);
      ThreadManager.getSubThreadHandler().post(new NewUpgradeDialog.8(this, localBundle));
      return;
    }
    ToastUtil.a().a(HardCodeUtil.a(2131707589));
  }
  
  public NewUpgradeDialog a(long paramLong)
  {
    String str = a((float)paramLong, true, 2);
    if (!TextUtils.isEmpty(str))
    {
      TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131707593));
      localStringBuilder.append(str);
      localTextView.setText(localStringBuilder.toString());
    }
    return this;
  }
  
  public NewUpgradeDialog a(DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new NewUpgradeDialog.3(this, paramOnClickListener, paramBoolean));
    return this;
  }
  
  public NewUpgradeDialog a(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    return this;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateView--progress--");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" state = ");
    localStringBuilder.append(paramInt2);
    LogUtility.c("NewUpgradeDialog", localStringBuilder.toString());
    this.jdField_a_of_type_Int = paramInt2;
    a(paramInt2);
    if (paramInt2 == 4) {
      paramInt1 = 100;
    }
    if (paramInt1 < 0)
    {
      this.jdField_a_of_type_Boolean = this.jdField_d_of_type_Boolean;
      paramInt2 = 0;
    }
    else
    {
      paramInt2 = paramInt1;
      if (paramInt1 >= 100)
      {
        this.jdField_a_of_type_Boolean = false;
        paramInt2 = 100;
      }
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt2);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
  }
  
  public NewUpgradeDialog b(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    }
    return this;
  }
  
  public NewUpgradeDialog c(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    }
    paramCharSequence = new SpannableString("推荐使用\"省流升级\",通过QQ官方下载器\"应用宝\"升级,节省流量速度更快");
    paramCharSequence.setSpan(new ForegroundColorSpan(Color.parseColor("#0099EE")), 21, 24, 17);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    return this;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = ControlPolicyUtil.b();
    if (this.jdField_b_of_type_Boolean)
    {
      if (!APNUtil.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))
      {
        ToastUtil.a().a(HardCodeUtil.a(2131707598));
        return;
      }
      a(3);
      DownloadManager.a().a("1101070898");
    }
  }
  
  public void d()
  {
    DownloadInfo localDownloadInfo = DownloadManager.a().a("1101070898");
    if ((localDownloadInfo != null) && (localDownloadInfo.a() == 2)) {
      DownloadManager.a().a("1101070898");
    }
  }
  
  public void dismiss()
  {
    try
    {
      if (this.jdField_a_of_type_Int != 2)
      {
        this.jdField_d_of_type_Boolean = false;
        DownloadManager.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = null;
      }
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365648));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380083));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365644));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380079));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365633));
    this.f = ((TextView)findViewById(2131365639));
    this.f.setVisibility(0);
    this.f.getPaint().setFakeBoldText(true);
    this.f.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131373123));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368634));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new NewUpgradeDialog.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.NewUpgradeDialog
 * JD-Core Version:    0.7.0.1
 */