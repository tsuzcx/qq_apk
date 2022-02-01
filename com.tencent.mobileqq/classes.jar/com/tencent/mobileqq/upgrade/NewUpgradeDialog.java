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
  private static boolean o = false;
  private static int p = 3;
  private static long s;
  protected final WeakReference<Activity> a;
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  TextView f;
  TextView g;
  ProgressBar h;
  ImageView i;
  protected View.OnClickListener j = new NewUpgradeDialog.4(this);
  private boolean k = false;
  private DownloadListener l;
  private int m = 1;
  private boolean n = true;
  private boolean q = false;
  private volatile boolean r = false;
  
  public NewUpgradeDialog(Activity paramActivity)
  {
    super(paramActivity);
    this.a = new WeakReference(paramActivity);
    requestWindowFeature(1);
    paramActivity = new ColorDrawable();
    paramActivity.setAlpha(0);
    getWindow().setBackgroundDrawable(paramActivity);
    setContentView(2131625524);
    this.l = new NewUpgradeDialog.YYBDownloadListener(this);
    this.n = ControlPolicyUtil.b();
    DownloadManager.b();
    setOnKeyListener(new NewUpgradeDialog.1(this));
    a();
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, p, 1, 100));
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, p, 2, 100));
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, p, 3, 100));
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, p, 4, 100));
    AppCircleReportManager.a().a(16, STUtils.a(10010, p, 1, 100));
    AppCircleReportManager.a().a(16, STUtils.a(10010, p, 2, 100));
    AppCircleReportManager.a().a(16, STUtils.a(10010, p, 3, 100));
    AppCircleReportManager.a().a(16, STUtils.a(10010, p, 4, 100));
    if (p == 2)
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
      i1 = (int)paramDouble;
      d1 = i1;
      Double.isNaN(d1);
      if (paramDouble >= d1 + 0.95D)
      {
        localStringBuilder.append(i1 + 1);
        break label79;
      }
    }
    localStringBuilder.append((int)paramDouble);
    label79:
    localStringBuilder.append(".");
    int i2 = 0;
    double d1 = 1.0D;
    int i1 = 0;
    while (i1 < paramInt)
    {
      d1 *= 10.0D;
      i1 += 1;
    }
    double d2 = (int)paramDouble;
    Double.isNaN(d2);
    paramDouble = Math.round((paramDouble - d2) * d1);
    Double.isNaN(paramDouble);
    paramDouble = Math.abs(paramDouble / d1);
    i1 = i2;
    while (i1 < paramInt)
    {
      paramDouble *= 10.0D;
      localStringBuilder.append((int)paramDouble % 10);
      i1 += 1;
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
    o = SPSettings.a();
    if (o)
    {
      p = 2;
      return;
    }
    p = 3;
  }
  
  private void a(int paramInt)
  {
    this.m = paramInt;
    this.g.getPaint().setFakeBoldText(false);
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
              this.g.setText(HardCodeUtil.a(2131905409));
            }
          }
          else {
            this.g.setText(HardCodeUtil.a(2131905416));
          }
        }
        else {
          this.g.setText(HardCodeUtil.a(2131905412));
        }
      }
      else
      {
        this.g.setText(HardCodeUtil.a(2131905402));
        return;
      }
    }
    this.g.setText(HardCodeUtil.a(2131905414));
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (System.currentTimeMillis() - s <= 1000L) {
      return false;
    }
    s = System.currentTimeMillis();
    Object localObject = UpgradeController.a().d();
    if ((localObject != null) && (((UpgradeDetailWrapper)localObject).b != null) && (((UpgradeDetailWrapper)localObject).e != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("sdkShowNotification", 0);
      localBundle.putBoolean("showNetworkDialog", false);
      localBundle.putString("appName", ((UpgradeDetailWrapper)localObject).e.a);
      localBundle.putString("url", ((UpgradeDetailWrapper)localObject).b.strNewSoftwareURL);
      localBundle.putString("via", "ANDROIDQQ.YYB.QQUPDATE");
      String str = String.valueOf(((UpgradeDetailWrapper)localObject).b.iAppid);
      localBundle.putString("appId", str);
      localBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
      localBundle.putBoolean("autoInstall", true);
      int i2 = ((UpgradeDetailWrapper)localObject).e.d;
      int i1 = i2;
      if (i2 == 999) {
        i1 = 718;
      }
      localBundle.putInt("versionCode", i1);
      localBundle.putString("packageName", BaseApplicationImpl.getApplication().getPackageName());
      localBundle.putInt("downloadType", 1);
      localBundle.putBoolean("autoDownload", true);
      localObject = DownloadManager.b().d(str);
      if (localObject != null) {
        localObject = ((DownloadInfo)localObject).q;
      } else {
        localObject = "";
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists()))
      {
        localBundle.putInt(DownloadConstants.k, 5);
        DownloadApi.a(localBundle, "biz_src_jc_update", UpgradeController.a().d().d);
        return true;
      }
      if ((!ControlPolicyUtil.l()) && (!MyAppApi.l().w()))
      {
        UpgradeDetailActivity.a(paramActivity, UpgradeController.a().d(), false, true, true);
        return true;
      }
      ThreadManager.getSubThreadHandler().post(new NewUpgradeDialog.7(paramActivity, localBundle));
      return true;
    }
    ToastUtil.a().a(HardCodeUtil.a(2131905406));
    return false;
  }
  
  public static void b()
  {
    o = true;
    p = 2;
  }
  
  private void f()
  {
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, p, 3, 300));
    AppCircleReportManager.a().a(21, STUtils.a(10010, p, 3, 300));
    DownloadInfo localDownloadInfo = DownloadManager.b().d("1101070898");
    DownloadManager.b().d(localDownloadInfo);
  }
  
  private void g()
  {
    ThreadManager.getUIHandler().post(new NewUpgradeDialog.5(this));
    j();
    f();
  }
  
  private void h()
  {
    this.n = ControlPolicyUtil.b();
    if (this.n)
    {
      if (!APNUtil.i((Context)this.a.get()))
      {
        ToastUtil.a().a(HardCodeUtil.a(2131905401));
        return;
      }
      a(2);
      DownloadManager.b().a(DownloadManager.b().d("1101070898"));
    }
  }
  
  private void i()
  {
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, p, 3, 200));
    AppCircleReportManager.a().a(17, STUtils.a(10010, p, 3, 200));
    if (p == 2) {
      ReportController.b(null, "dc00898", "", "", "0X8008F81", "0X8008F81", 0, 0, "", "", "", "");
    } else {
      ReportController.b(null, "dc00898", "", "", "0X8008F84", "0X8008F84", 0, 0, "", "", "", "");
    }
    MyAppApi.l();
    if (MyAppApi.m())
    {
      a((Activity)this.a.get());
      dismiss();
      ((Activity)this.a.get()).finish();
      return;
    }
    this.k = true;
    this.q = true;
    DownloadInfo localDownloadInfo = DownloadManager.b().d("1101070898");
    this.n = ControlPolicyUtil.b();
    if (this.n)
    {
      if (!APNUtil.i((Context)this.a.get()))
      {
        ToastUtil.a().a(HardCodeUtil.a(2131905403));
        this.k = false;
        this.q = false;
        return;
      }
      if ((localDownloadInfo != null) && (localDownloadInfo.a() != 4)) {
        a(localDownloadInfo.t, localDownloadInfo.a());
      }
      if ((localDownloadInfo == null) || (localDownloadInfo.a() == 1) || (localDownloadInfo.a() == 10) || (localDownloadInfo.a() == 3) || (localDownloadInfo.a() == 4))
      {
        LogUtility.b("NewUpgradeDialog", STUtils.a(10010, p, 3, 500));
        AppCircleReportManager.a().a(18, STUtils.a(10010, p, 3, 500));
        MyAppApi.l().a((Activity)this.a.get(), "ANDROIDQQ.NEWYYB.QQUPDATE", true);
      }
    }
    else
    {
      ThreadManager.post(new NewUpgradeDialog.6(this), 5, null, false);
    }
    DownloadManager.b().a(this.l);
  }
  
  private void j()
  {
    Object localObject1 = UpgradeController.a().d();
    if ((localObject1 != null) && (((UpgradeDetailWrapper)localObject1).b != null) && (((UpgradeDetailWrapper)localObject1).e != null))
    {
      int i2 = ((UpgradeDetailWrapper)localObject1).e.d;
      int i1 = i2;
      if (i2 == 999) {
        i1 = 718;
      }
      i2 = 0;
      try
      {
        int i3 = BaseActivity.sTopActivity.getPackageManager().getPackageInfo(BaseActivity.sTopActivity.getPackageName(), 0).versionCode;
        i2 = i3;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        localNameNotFoundException.printStackTrace();
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("tmast://appdetails?r=0.9138136501079244&pname=com.tencent.mobileqq&oplist=1%3B2&via=ANDROIDQQ.NEWYYB.QQUPDATE&appid=");
      ((StringBuilder)localObject2).append(((UpgradeDetailWrapper)localObject1).b.iAppid);
      ((StringBuilder)localObject2).append("&versioncode=");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append("&hostpname=");
      ((StringBuilder)localObject2).append(BaseApplicationImpl.getApplication().getPackageName());
      ((StringBuilder)localObject2).append("&hostversioncode=");
      ((StringBuilder)localObject2).append(i2);
      ((StringBuilder)localObject2).append("\"\n");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("url", (String)localObject1);
      DownloadApi.a((Bundle)localObject2);
      DownloadApi.b((Bundle)localObject2);
      MyAppApi.l().b();
      l();
      return;
    }
    ToastUtil.a().a(HardCodeUtil.a(2131905411));
  }
  
  private void k()
  {
    this.g.getPaint().setFakeBoldText(true);
    this.g.setText(HardCodeUtil.a(2131905405));
    this.h.setProgress(0);
    this.k = true;
    this.m = 1;
  }
  
  private void l()
  {
    UpgradeDetailWrapper localUpgradeDetailWrapper = UpgradeController.a().d();
    if ((localUpgradeDetailWrapper != null) && (localUpgradeDetailWrapper.b != null) && (localUpgradeDetailWrapper.e != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("sdkShowNotification", 0);
      localBundle.putBoolean("showNetworkDialog", false);
      localBundle.putString("appName", localUpgradeDetailWrapper.e.a);
      localBundle.putString("url", localUpgradeDetailWrapper.b.strNewSoftwareURL);
      localBundle.putString("via", "ANDROIDQQ.YYB.QQUPDATE");
      localBundle.putString("appId", String.valueOf(localUpgradeDetailWrapper.b.iAppid));
      localBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
      localBundle.putBoolean("autoInstall", true);
      int i2 = localUpgradeDetailWrapper.e.d;
      int i1 = i2;
      if (i2 == 999) {
        i1 = 718;
      }
      localBundle.putInt("versionCode", i1);
      localBundle.putString("packageName", "com.tencent.mobileqq");
      localBundle.putInt("downloadType", 1);
      localBundle.putBoolean("autoDownload", true);
      ThreadManager.getSubThreadHandler().post(new NewUpgradeDialog.8(this, localBundle));
      return;
    }
    ToastUtil.a().a(HardCodeUtil.a(2131905404));
  }
  
  public NewUpgradeDialog a(long paramLong)
  {
    String str = a((float)paramLong, true, 2);
    if (!TextUtils.isEmpty(str))
    {
      TextView localTextView = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131905408));
      localStringBuilder.append(str);
      localTextView.setText(localStringBuilder.toString());
    }
    return this;
  }
  
  public NewUpgradeDialog a(DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    this.f.setVisibility(0);
    this.f.setOnClickListener(new NewUpgradeDialog.3(this, paramOnClickListener, paramBoolean));
    return this;
  }
  
  public NewUpgradeDialog a(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.b.setText(paramCharSequence);
      this.b.setVisibility(0);
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
    this.m = paramInt2;
    a(paramInt2);
    if (paramInt2 == 4) {
      paramInt1 = 100;
    }
    if (paramInt1 < 0)
    {
      this.k = this.q;
      paramInt2 = 0;
    }
    else
    {
      paramInt2 = paramInt1;
      if (paramInt1 >= 100)
      {
        this.k = false;
        paramInt2 = 100;
      }
    }
    this.h.setProgress(paramInt2);
    if (this.k)
    {
      this.h.setVisibility(0);
      return;
    }
    this.h.setVisibility(4);
  }
  
  public NewUpgradeDialog b(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.e.setText(paramCharSequence);
    }
    return this;
  }
  
  public NewUpgradeDialog c(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.d.setText(paramCharSequence);
    }
    paramCharSequence = new SpannableString("推荐使用\"省流升级\",通过QQ官方下载器\"应用宝\"升级,节省流量速度更快");
    paramCharSequence.setSpan(new ForegroundColorSpan(Color.parseColor("#0099EE")), 21, 24, 17);
    this.d.setText(paramCharSequence);
    this.d.setVisibility(0);
    return this;
  }
  
  public void c()
  {
    this.n = ControlPolicyUtil.b();
    if (this.n)
    {
      if (!APNUtil.i((Context)this.a.get()))
      {
        ToastUtil.a().a(HardCodeUtil.a(2131905413));
        return;
      }
      a(3);
      DownloadManager.b().g("1101070898");
    }
  }
  
  public void d()
  {
    DownloadInfo localDownloadInfo = DownloadManager.b().d("1101070898");
    if ((localDownloadInfo != null) && (localDownloadInfo.a() == 2)) {
      DownloadManager.b().g("1101070898");
    }
  }
  
  public void dismiss()
  {
    try
    {
      if (this.m != 2)
      {
        this.q = false;
        DownloadManager.b().b(this.l);
        this.l = null;
      }
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.b = ((TextView)findViewById(2131431880));
    this.c = ((TextView)findViewById(2131448996));
    this.e = ((TextView)findViewById(2131431876));
    this.d = ((TextView)findViewById(2131448992));
    this.f = ((TextView)findViewById(2131431864));
    this.g = ((TextView)findViewById(2131431870));
    this.g.setVisibility(0);
    this.g.getPaint().setFakeBoldText(true);
    this.g.setOnClickListener(this.j);
    this.h = ((ProgressBar)findViewById(2131440726));
    this.h.setProgress(0);
    this.i = ((ImageView)findViewById(2131435546));
    this.i.setOnClickListener(new NewUpgradeDialog.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.NewUpgradeDialog
 * JD-Core Version:    0.7.0.1
 */