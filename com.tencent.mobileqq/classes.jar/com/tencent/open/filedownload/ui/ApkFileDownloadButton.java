package com.tencent.open.filedownload.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.appstore.report.AppExposureDataBuilder;
import com.tencent.open.appstore.report.ClickDataBuilder;
import com.tencent.open.appstore.report.ReportDataBuilder;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.filedownload.TaskInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.File;
import mqq.os.MqqHandler;

public class ApkFileDownloadButton
  extends RelativeLayout
  implements View.OnClickListener
{
  protected RelativeLayout a;
  protected TextView b;
  protected TaskInfo c;
  private TextView d;
  private ProgressBar e;
  private Button f;
  private TextView g;
  private int h = 1;
  private Context i;
  private String j = "";
  private DownloadListener k = new ApkFileDownloadButton.1(this);
  private ApkFileDownloadButton.EventCallback l;
  
  public ApkFileDownloadButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ApkFileDownloadButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ApkFileDownloadButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.i = paramContext;
    LayoutInflater.from(paramContext).inflate(2131625680, this);
    j();
    DownloadManagerV2.a().a(this.k);
  }
  
  private void b(DownloadInfo paramDownloadInfo)
  {
    if (AppNetConnInfo.isMobileConn())
    {
      ApkFileDownloadButton.4 local4 = new ApkFileDownloadButton.4(this);
      paramDownloadInfo = new ApkFileDownloadButton.5(this, paramDownloadInfo);
      DialogUtil.a(this.i, 230, HardCodeUtil.a(2131898528), HardCodeUtil.a(2131898526), 2131887648, 2131888568, paramDownloadInfo, local4).show();
      AppCenterReporter.a(AppExposureDataBuilder.a().l(this.c.a).k("5").m("0").n(this.c.d).b(this.c.i).c(this.c.f).h(this.c.e));
      return;
    }
    h();
    c(paramDownloadInfo);
  }
  
  private void c(DownloadInfo paramDownloadInfo)
  {
    Object localObject;
    if (paramDownloadInfo == null)
    {
      localObject = new DownloadInfo();
      ((DownloadInfo)localObject).M = this.c.a;
      ((DownloadInfo)localObject).N = this.c.b;
      ((DownloadInfo)localObject).O = this.c.c;
      ((DownloadInfo)localObject).h = this.c.d;
      ((DownloadInfo)localObject).d = this.c.e;
      ((DownloadInfo)localObject).e = this.c.f;
      ((DownloadInfo)localObject).f = this.c.i;
      paramDownloadInfo = new StringBuilder();
      paramDownloadInfo.append("_");
      paramDownloadInfo.append(GlobalUtil.calcMD5AsString(this.c.e));
      ((DownloadInfo)localObject).g = paramDownloadInfo.toString();
      ((DownloadInfo)localObject).x = true;
      ((DownloadInfo)localObject).r = this.j;
      ((DownloadInfo)localObject).b();
    }
    else
    {
      paramDownloadInfo.e = this.c.f;
      paramDownloadInfo.x = true;
      if ((paramDownloadInfo.a() == 4) && (new File(paramDownloadInfo.q).exists()))
      {
        localObject = this.c;
        ((TaskInfo)localObject).k = 4;
        ((TaskInfo)localObject).j = 100;
        g();
      }
      localObject = paramDownloadInfo;
      if (TextUtils.isEmpty(paramDownloadInfo.r))
      {
        paramDownloadInfo.r = this.j;
        localObject = paramDownloadInfo;
      }
    }
    DownloadManagerV2.a().b((DownloadInfo)localObject);
    paramDownloadInfo = this.l;
    if (paramDownloadInfo != null) {
      paramDownloadInfo.b();
    }
  }
  
  private void j()
  {
    setClickable(true);
    this.a = ((RelativeLayout)findViewById(2131445004));
    this.d = ((TextView)findViewById(2131448991));
    this.e = ((ProgressBar)findViewById(2131440737));
    this.f = ((Button)findViewById(2131429953));
    this.f.setOnClickListener(this);
    this.b = ((TextView)findViewById(2131448982));
    this.b.setText(b(1));
    this.b.setOnClickListener(this);
    this.g = ((TextView)findViewById(2131448983));
  }
  
  private void setProgress(float paramFloat)
  {
    float f1 = paramFloat;
    if (paramFloat < 0.0F) {
      f1 = 0.0F;
    }
    paramFloat = f1;
    if (f1 > 1.0F) {
      paramFloat = 1.0F;
    }
    this.e.setProgress((int)(paramFloat * 100.0F));
  }
  
  private void setProgress(int paramInt)
  {
    setProgress(paramInt * 1.0F / 100.0F);
  }
  
  protected String a(int paramInt)
  {
    return "default";
  }
  
  public void a()
  {
    if (this.c.k != 4) {
      DownloadManagerV2.a().e(this.c.e);
    }
  }
  
  protected void a(DownloadInfo paramDownloadInfo)
  {
    DownloadManagerV2.a().d(paramDownloadInfo);
  }
  
  protected void a(String paramString) {}
  
  protected void a(String paramString, boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean)
  {
    b();
    i();
    if (paramBoolean) {
      AppCenterReporter.b(ClickDataBuilder.a().a("202").l(this.c.a).k(this.c.b).m(this.c.c).n(this.c.d).b(this.c.i).c(this.c.f).h(this.c.e));
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ApkFileDownloadButton.EventCallback localEventCallback = this.l;
      if (localEventCallback != null) {
        localEventCallback.d();
      }
    }
    b(paramBoolean1);
  }
  
  protected boolean a(DownloadInfo paramDownloadInfo, TaskInfo paramTaskInfo)
  {
    if ((paramDownloadInfo != null) && (paramTaskInfo != null)) {
      return TextUtils.equals(paramDownloadInfo.d, paramTaskInfo.e);
    }
    return false;
  }
  
  protected String b(int paramInt)
  {
    if (paramInt == 4) {
      return HardCodeUtil.a(2131898531);
    }
    return HardCodeUtil.a(2131898533);
  }
  
  public void b()
  {
    a();
    DownloadManagerV2.a().b(this.k);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.c == null)
    {
      LogUtility.b("ApkFileDownloadButton_", "[onClick] mApkInfo == null!");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onClick] state=");
    ((StringBuilder)localObject).append(this.c.k);
    LogUtility.b("ApkFileDownloadButton_", ((StringBuilder)localObject).toString());
    DownloadManagerV2.a().a(this.k);
    DownloadInfo localDownloadInfo = DownloadManagerV2.a().b(this.c.e);
    if (localDownloadInfo != null)
    {
      this.c.k = localDownloadInfo.a();
      if (TextUtils.isEmpty(localDownloadInfo.r)) {
        localDownloadInfo.r = this.j;
      }
    }
    int m = this.c.k;
    String str = "400";
    if (m != 4)
    {
      if (localDownloadInfo != null)
      {
        localObject = str;
        if (localDownloadInfo.a() == 4)
        {
          localObject = str;
          if (new File(localDownloadInfo.q).exists()) {}
        }
      }
      else
      {
        localObject = "900";
      }
      b(localDownloadInfo);
    }
    else if ((localDownloadInfo != null) && (localDownloadInfo.a() == 4) && (new File(localDownloadInfo.q).exists()))
    {
      this.c.k = 4;
      g();
      i();
      a(localDownloadInfo);
      localObject = "305";
    }
    else
    {
      if (localDownloadInfo != null)
      {
        localObject = str;
        if (localDownloadInfo.a() == 4)
        {
          localObject = str;
          if (new File(localDownloadInfo.q).exists()) {}
        }
      }
      else
      {
        localObject = "900";
      }
      b(localDownloadInfo);
    }
    if (paramBoolean) {
      AppCenterReporter.b(ClickDataBuilder.a().a((String)localObject).l(this.c.a).k(this.c.b).m(this.c.c).n(this.c.d).b(this.c.i).c(this.c.f).h(this.c.e));
    }
    a((String)localObject, paramBoolean);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ApkFileDownloadButton.EventCallback localEventCallback = this.l;
      if (localEventCallback != null) {
        localEventCallback.a();
      }
    }
    a(paramBoolean1);
  }
  
  public void c()
  {
    DownloadManagerV2.a().b(this.k);
    this.k = null;
  }
  
  public void d()
  {
    this.c.k = 1;
    g();
    i();
  }
  
  protected void e()
  {
    i();
    ApkFileDownloadButton.EventCallback localEventCallback = this.l;
    if (localEventCallback != null) {
      localEventCallback.c();
    }
  }
  
  protected void f()
  {
    this.g.setVisibility(8);
  }
  
  protected void g()
  {
    setProgressHintText(getProgressHintTextRes());
    if (this.c.k == 4) {
      this.c.j = 100;
    }
    this.b.setText(b(this.c.k));
    setProgress(this.c.j);
    int m = 1;
    if (this.c.k == 4) {
      m = 3;
    }
    if (this.a.getVisibility() == 0) {
      m = 2;
    }
    this.g.setText(a(m));
  }
  
  protected String getProgressHintText()
  {
    return HardCodeUtil.a(2131898529);
  }
  
  protected String getProgressHintTextRes()
  {
    if ((this.c.k != 4) && (this.c.j != 100))
    {
      if (this.c.h == 0L) {
        return getProgressHintText();
      }
      String str1 = NewUpgradeDialog.a((float)(this.c.h * this.c.j / 100L), true, 2);
      String str2 = NewUpgradeDialog.a((float)this.c.h, true, 2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getProgressHintText());
      localStringBuilder.append("(");
      localStringBuilder.append(str1);
      localStringBuilder.append("/");
      localStringBuilder.append(str2);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    return b(4);
  }
  
  protected void h()
  {
    ThreadManager.getUIHandler().post(new ApkFileDownloadButton.2(this));
  }
  
  protected void i()
  {
    ThreadManager.getUIHandler().post(new ApkFileDownloadButton.3(this));
  }
  
  public final void onClick(View paramView)
  {
    ApkFileDownloadButton.EventCallback localEventCallback;
    if (paramView == this.f)
    {
      localEventCallback = this.l;
      if (localEventCallback != null) {
        localEventCallback.a();
      }
      a(true);
    }
    else if (paramView == this.b)
    {
      localEventCallback = this.l;
      if (localEventCallback != null) {
        localEventCallback.d();
      }
      b(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setApkInfo(TaskInfo paramTaskInfo)
  {
    this.c = TaskInfo.a(paramTaskInfo);
    g();
  }
  
  public void setEventCallback(ApkFileDownloadButton.EventCallback paramEventCallback)
  {
    this.l = paramEventCallback;
  }
  
  protected void setProgressHintText(String paramString)
  {
    this.d.setText(paramString);
  }
  
  public void setSource(String paramString)
  {
    this.j = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.filedownload.ui.ApkFileDownloadButton
 * JD-Core Version:    0.7.0.1
 */