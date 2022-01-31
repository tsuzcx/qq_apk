package com.tencent.mobileqq.utils;

import akda;
import akdb;
import akdc;
import akdd;
import akde;
import akdf;
import akdh;
import akdi;
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
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper.NewApkInfo;
import com.tencent.mobileqq.statistics.ReportController;
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
  private static long jdField_a_of_type_Long;
  private static int jdField_b_of_type_Int = 3;
  private static boolean jdField_c_of_type_Boolean;
  private int jdField_a_of_type_Int = 1;
  protected View.OnClickListener a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener;
  public final WeakReference a;
  private boolean jdField_a_of_type_Boolean;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  private volatile boolean jdField_e_of_type_Boolean;
  TextView f;
  
  public NewUpgradeDialog(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new akdd(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    requestWindowFeature(1);
    paramActivity = new ColorDrawable();
    paramActivity.setAlpha(0);
    getWindow().setBackgroundDrawable(paramActivity);
    setContentView(2130969138);
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new NewUpgradeDialog.YYBDownloadListener(this);
    this.jdField_b_of_type_Boolean = ControlPolicyUtil.b();
    DownloadManager.a();
    setOnKeyListener(new akda(this));
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
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt <= 0)
    {
      localStringBuilder.append((int)Math.round(paramDouble));
      return localStringBuilder.toString();
    }
    if ((paramInt == 1) && (paramDouble >= (int)paramDouble + 0.95D)) {
      localStringBuilder.append((int)paramDouble + 1);
    }
    double d1;
    for (;;)
    {
      localStringBuilder.append(".");
      d1 = 1.0D;
      i = 0;
      while (i < paramInt)
      {
        d1 *= 10.0D;
        i += 1;
      }
      localStringBuilder.append((int)paramDouble);
    }
    paramDouble = Math.abs(Math.round((paramDouble - (int)paramDouble) * d1) / d1);
    int i = j;
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
    if (paramBoolean) {
      return "MB";
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
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      this.f.setText("应用宝下载中");
      return;
    case 1: 
    case 20: 
      this.f.setText("应用宝下载中");
      return;
    case 3: 
      this.f.setText("继续");
      return;
    case 4: 
      this.f.setText("下载已完成");
      return;
    }
    this.f.setText("下载已取消");
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (System.currentTimeMillis() - jdField_a_of_type_Long <= 1000L) {
      return false;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject1 = UpgradeController.a().a();
    if ((localObject1 == null) || (((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo == null))
    {
      ToastUtil.a().a("更新信息不全，无法更新");
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("sdkShowNotification", 0);
    localBundle.putBoolean("showNetworkDialog", false);
    localBundle.putString("appName", ((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_JavaLangString);
    localBundle.putString("url", ((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
    localBundle.putString("via", "ANDROIDQQ.YYB.QQUPDATE");
    Object localObject2 = String.valueOf(((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iAppid);
    localBundle.putString("appId", (String)localObject2);
    localBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    localBundle.putBoolean("autoInstall", true);
    int j = ((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int;
    int i = j;
    if (j == 999) {
      i = 718;
    }
    localBundle.putInt("versionCode", i);
    localBundle.putString("packageName", BaseApplicationImpl.getApplication().getPackageName());
    localBundle.putInt("downloadType", 1);
    localBundle.putBoolean("autoDownload", true);
    localObject2 = DownloadManager.a().a((String)localObject2);
    localObject1 = "";
    if (localObject2 != null) {
      localObject1 = ((DownloadInfo)localObject2).k;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new File((String)localObject1);
      if ((localObject1 != null) && (((File)localObject1).exists()))
      {
        localBundle.putInt(DownloadConstants.j, 5);
        DownloadApi.a(localBundle, 1, UpgradeController.a().a().jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
        return true;
      }
    }
    if ((ControlPolicyUtil.h()) || (MyAppApi.a().g())) {
      ThreadManager.getSubThreadHandler().post(new akdh(paramActivity, localBundle));
    }
    for (;;)
    {
      return true;
      UpgradeDetailActivity.a(paramActivity, UpgradeController.a().a(), false, true, true);
    }
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
    ThreadManager.getUIHandler().post(new akde(this));
    i();
    e();
  }
  
  private void g()
  {
    this.jdField_b_of_type_Boolean = ControlPolicyUtil.b();
    if (this.jdField_b_of_type_Boolean)
    {
      if (!APNUtil.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
        ToastUtil.a().a("网络连接错误，请检查网络并重试!");
      }
    }
    else {
      return;
    }
    a(2);
    DownloadManager.a().a(DownloadManager.a().a("1101070898"));
  }
  
  private void h()
  {
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, jdField_b_of_type_Int, 3, 200));
    AppCircleReportManager.a().a(17, STUtils.a(10010, jdField_b_of_type_Int, 3, 200));
    if (jdField_b_of_type_Int == 2) {
      ReportController.b(null, "dc00898", "", "", "0X8008F81", "0X8008F81", 0, 0, "", "", "", "");
    }
    while (MyAppApi.a().b())
    {
      a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      dismiss();
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
      return;
      ReportController.b(null, "dc00898", "", "", "0X8008F84", "0X8008F84", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    DownloadInfo localDownloadInfo = DownloadManager.a().a("1101070898");
    this.jdField_b_of_type_Boolean = ControlPolicyUtil.b();
    if (this.jdField_b_of_type_Boolean)
    {
      if (!APNUtil.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))
      {
        ToastUtil.a().a("网络连接错误，请检查网络并重试!");
        this.jdField_a_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = false;
        return;
      }
      if ((localDownloadInfo != null) && (localDownloadInfo.a() != 4)) {
        a(localDownloadInfo.g, localDownloadInfo.a());
      }
      if ((localDownloadInfo == null) || (localDownloadInfo.a() == 1) || (localDownloadInfo.a() == 10) || (localDownloadInfo.a() == 3) || (localDownloadInfo.a() == 4))
      {
        LogUtility.b("NewUpgradeDialog", STUtils.a(10010, jdField_b_of_type_Int, 3, 500));
        AppCircleReportManager.a().a(18, STUtils.a(10010, jdField_b_of_type_Int, 3, 500));
        MyAppApi.a().a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), "ANDROIDQQ.NEWYYB.QQUPDATE", true);
      }
    }
    for (;;)
    {
      DownloadManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
      return;
      ThreadManager.post(new akdf(this), 5, null, false);
    }
  }
  
  private void i()
  {
    int j = 0;
    Object localObject = UpgradeController.a().a();
    if ((localObject == null) || (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo == null))
    {
      ToastUtil.a().a("更新信息不全，无法更新");
      return;
    }
    int k = ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int;
    int i = k;
    if (k == 999) {
      i = 718;
    }
    try
    {
      k = BaseActivity.sTopActivity.getPackageManager().getPackageInfo(BaseActivity.sTopActivity.getPackageName(), 0).versionCode;
      j = k;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Bundle localBundle;
        localNameNotFoundException.printStackTrace();
      }
    }
    localObject = "tmast://appdetails?r=0.9138136501079244&pname=com.tencent.mobileqq&oplist=1%3B2&via=ANDROIDQQ.NEWYYB.QQUPDATE&appid=" + ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iAppid + "&versioncode=" + i + "&hostpname=" + BaseApplicationImpl.getApplication().getPackageName() + "&hostversioncode=" + j + "\"\n";
    localBundle = new Bundle();
    localBundle.putString("url", (String)localObject);
    DownloadApi.a(localBundle);
    DownloadApi.b(localBundle);
    MyAppApi.a().a();
    k();
  }
  
  private void j()
  {
    this.f.getPaint().setFakeBoldText(true);
    this.f.setText("省流升级");
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 1;
  }
  
  private void k()
  {
    UpgradeDetailWrapper localUpgradeDetailWrapper = UpgradeController.a().a();
    if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo == null))
    {
      ToastUtil.a().a("更新信息不全，无法更新");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("sdkShowNotification", 0);
    localBundle.putBoolean("showNetworkDialog", false);
    localBundle.putString("appName", localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_JavaLangString);
    localBundle.putString("url", localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
    localBundle.putString("via", "ANDROIDQQ.YYB.QQUPDATE");
    localBundle.putString("appId", String.valueOf(localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iAppid));
    localBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    localBundle.putBoolean("autoInstall", true);
    int j = localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int;
    int i = j;
    if (j == 999) {
      i = 718;
    }
    localBundle.putInt("versionCode", i);
    localBundle.putString("packageName", "com.tencent.mobileqq");
    localBundle.putInt("downloadType", 1);
    localBundle.putBoolean("autoDownload", true);
    ThreadManager.getSubThreadHandler().post(new akdi(this, localBundle));
  }
  
  public NewUpgradeDialog a(long paramLong)
  {
    String str = a((float)paramLong, true, 2);
    if (!TextUtils.isEmpty(str)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("大小:" + str);
    }
    return this;
  }
  
  public NewUpgradeDialog a(DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new akdc(this, paramOnClickListener, paramBoolean));
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
    int i = 100;
    LogUtility.c("NewUpgradeDialog", "updateView--progress--" + paramInt1 + " state = " + paramInt2);
    this.jdField_a_of_type_Int = paramInt2;
    a(paramInt2);
    if (paramInt2 == 4) {
      paramInt1 = 100;
    }
    for (;;)
    {
      if (paramInt1 < 0)
      {
        this.jdField_a_of_type_Boolean = this.jdField_d_of_type_Boolean;
        paramInt1 = 0;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt1);
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          return;
          if (paramInt1 >= 100)
          {
            this.jdField_a_of_type_Boolean = false;
            paramInt1 = i;
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          return;
        }
      }
    }
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
      if (!APNUtil.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
        ToastUtil.a().a("网络连接错误，请检查网络并重试!");
      }
    }
    else {
      return;
    }
    a(3);
    DownloadManager.a().a("1101070898");
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364034));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363803));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362776));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365329));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364037));
    this.f = ((TextView)findViewById(2131364038));
    this.f.setVisibility(0);
    this.f.getPaint().setFakeBoldText(true);
    this.f.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131363005));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365332));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new akdb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.NewUpgradeDialog
 * JD-Core Version:    0.7.0.1
 */