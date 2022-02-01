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
  private int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  protected RelativeLayout a;
  protected TextView a;
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new ApkFileDownloadButton.1(this);
  protected TaskInfo a;
  private ApkFileDownloadButton.EventCallback jdField_a_of_type_ComTencentOpenFiledownloadUiApkFileDownloadButton$EventCallback;
  private String jdField_a_of_type_JavaLangString = "";
  private TextView b;
  private TextView c;
  
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
  
  private void a(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    paramFloat = f;
    if (f > 1.0F) {
      paramFloat = 1.0F;
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramFloat * 100.0F));
  }
  
  private void a(int paramInt)
  {
    a(paramInt * 1.0F / 100.0F);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131559651, this);
    j();
    DownloadManagerV2.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
  }
  
  private void b(DownloadInfo paramDownloadInfo)
  {
    if (AppNetConnInfo.isMobileConn())
    {
      ApkFileDownloadButton.4 local4 = new ApkFileDownloadButton.4(this);
      paramDownloadInfo = new ApkFileDownloadButton.5(this, paramDownloadInfo);
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, HardCodeUtil.a(2131700496), HardCodeUtil.a(2131700494), 2131690728, 2131691606, paramDownloadInfo, local4).show();
      AppCenterReporter.a(AppExposureDataBuilder.a().k(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_a_of_type_JavaLangString).j("5").l("0").m(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.d).a(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h).b(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.f).g(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.e));
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
      ((DownloadInfo)localObject).t = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_a_of_type_JavaLangString;
      ((DownloadInfo)localObject).u = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_b_of_type_JavaLangString;
      ((DownloadInfo)localObject).v = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.c;
      ((DownloadInfo)localObject).h = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.d;
      ((DownloadInfo)localObject).d = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.e;
      ((DownloadInfo)localObject).e = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.f;
      ((DownloadInfo)localObject).f = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h;
      paramDownloadInfo = new StringBuilder();
      paramDownloadInfo.append("_");
      paramDownloadInfo.append(GlobalUtil.calcMD5AsString(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.e));
      ((DownloadInfo)localObject).g = paramDownloadInfo.toString();
      ((DownloadInfo)localObject).b = true;
      ((DownloadInfo)localObject).m = this.jdField_a_of_type_JavaLangString;
      ((DownloadInfo)localObject).a();
    }
    else
    {
      paramDownloadInfo.e = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.f;
      paramDownloadInfo.b = true;
      if ((paramDownloadInfo.a() == 4) && (new File(paramDownloadInfo.l).exists()))
      {
        localObject = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo;
        ((TaskInfo)localObject).jdField_b_of_type_Int = 4;
        ((TaskInfo)localObject).jdField_a_of_type_Int = 100;
        g();
      }
      localObject = paramDownloadInfo;
      if (TextUtils.isEmpty(paramDownloadInfo.m))
      {
        paramDownloadInfo.m = this.jdField_a_of_type_JavaLangString;
        localObject = paramDownloadInfo;
      }
    }
    DownloadManagerV2.a().b((DownloadInfo)localObject);
    paramDownloadInfo = this.jdField_a_of_type_ComTencentOpenFiledownloadUiApkFileDownloadButton$EventCallback;
    if (paramDownloadInfo != null) {
      paramDownloadInfo.b();
    }
  }
  
  private void j()
  {
    setClickable(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376722));
    this.b = ((TextView)findViewById(2131380078));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131373132));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363996));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380069));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(b(1));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131380070));
  }
  
  protected String a()
  {
    return HardCodeUtil.a(2131700497);
  }
  
  protected String a(int paramInt)
  {
    return "default";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_b_of_type_Int != 4) {
      DownloadManagerV2.a().a(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.e);
    }
  }
  
  protected void a(DownloadInfo paramDownloadInfo)
  {
    DownloadManagerV2.a().a(paramDownloadInfo);
  }
  
  protected void a(String paramString) {}
  
  protected void a(String paramString, boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean)
  {
    b();
    i();
    if (paramBoolean) {
      AppCenterReporter.b(ClickDataBuilder.a().a("202").k(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_a_of_type_JavaLangString).j(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_b_of_type_JavaLangString).l(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.c).m(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.d).a(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h).b(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.f).g(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.e));
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ApkFileDownloadButton.EventCallback localEventCallback = this.jdField_a_of_type_ComTencentOpenFiledownloadUiApkFileDownloadButton$EventCallback;
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
  
  protected String b()
  {
    if ((this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_b_of_type_Int != 4) && (this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_a_of_type_Int != 100))
    {
      if (this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_a_of_type_Long == 0L) {
        return a();
      }
      String str1 = NewUpgradeDialog.a((float)(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_a_of_type_Long * this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_a_of_type_Int / 100L), true, 2);
      String str2 = NewUpgradeDialog.a((float)this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_a_of_type_Long, true, 2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a());
      localStringBuilder.append("(");
      localStringBuilder.append(str1);
      localStringBuilder.append("/");
      localStringBuilder.append(str2);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    return b(4);
  }
  
  protected String b(int paramInt)
  {
    if (paramInt == 4) {
      return HardCodeUtil.a(2131700500);
    }
    return HardCodeUtil.a(2131700502);
  }
  
  public void b()
  {
    a();
    DownloadManagerV2.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
  }
  
  protected void b(String paramString)
  {
    this.b.setText(paramString);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo == null)
    {
      LogUtility.b("ApkFileDownloadButton_", "[onClick] mApkInfo == null!");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onClick] state=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_b_of_type_Int);
    LogUtility.b("ApkFileDownloadButton_", ((StringBuilder)localObject).toString());
    DownloadManagerV2.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
    DownloadInfo localDownloadInfo = DownloadManagerV2.a().b(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.e);
    if (localDownloadInfo != null)
    {
      this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_b_of_type_Int = localDownloadInfo.a();
      if (TextUtils.isEmpty(localDownloadInfo.m)) {
        localDownloadInfo.m = this.jdField_a_of_type_JavaLangString;
      }
    }
    int i = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_b_of_type_Int;
    String str = "400";
    if (i != 4)
    {
      if (localDownloadInfo != null)
      {
        localObject = str;
        if (localDownloadInfo.a() == 4)
        {
          localObject = str;
          if (new File(localDownloadInfo.l).exists()) {}
        }
      }
      else
      {
        localObject = "900";
      }
      b(localDownloadInfo);
    }
    else if ((localDownloadInfo != null) && (localDownloadInfo.a() == 4) && (new File(localDownloadInfo.l).exists()))
    {
      this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_b_of_type_Int = 4;
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
          if (new File(localDownloadInfo.l).exists()) {}
        }
      }
      else
      {
        localObject = "900";
      }
      b(localDownloadInfo);
    }
    if (paramBoolean) {
      AppCenterReporter.b(ClickDataBuilder.a().a((String)localObject).k(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_a_of_type_JavaLangString).j(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_b_of_type_JavaLangString).l(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.c).m(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.d).a(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h).b(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.f).g(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.e));
    }
    a((String)localObject, paramBoolean);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ApkFileDownloadButton.EventCallback localEventCallback = this.jdField_a_of_type_ComTencentOpenFiledownloadUiApkFileDownloadButton$EventCallback;
      if (localEventCallback != null) {
        localEventCallback.a();
      }
    }
    a(paramBoolean1);
  }
  
  public void c()
  {
    DownloadManagerV2.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = null;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_b_of_type_Int = 1;
    g();
    i();
  }
  
  protected void e()
  {
    i();
    ApkFileDownloadButton.EventCallback localEventCallback = this.jdField_a_of_type_ComTencentOpenFiledownloadUiApkFileDownloadButton$EventCallback;
    if (localEventCallback != null) {
      localEventCallback.c();
    }
  }
  
  protected void f()
  {
    this.c.setVisibility(8);
  }
  
  protected void g()
  {
    b(b());
    if (this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_b_of_type_Int == 4) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_a_of_type_Int = 100;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(b(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_b_of_type_Int));
    a(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_a_of_type_Int);
    int i = 1;
    if (this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_b_of_type_Int == 4) {
      i = 3;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
      i = 2;
    }
    this.c.setText(a(i));
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
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      localEventCallback = this.jdField_a_of_type_ComTencentOpenFiledownloadUiApkFileDownloadButton$EventCallback;
      if (localEventCallback != null) {
        localEventCallback.a();
      }
      a(true);
    }
    else if (paramView == this.jdField_a_of_type_AndroidWidgetTextView)
    {
      localEventCallback = this.jdField_a_of_type_ComTencentOpenFiledownloadUiApkFileDownloadButton$EventCallback;
      if (localEventCallback != null) {
        localEventCallback.d();
      }
      b(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setApkInfo(TaskInfo paramTaskInfo)
  {
    this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo = TaskInfo.a(paramTaskInfo);
    g();
  }
  
  public void setEventCallback(ApkFileDownloadButton.EventCallback paramEventCallback)
  {
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiApkFileDownloadButton$EventCallback = paramEventCallback;
  }
  
  public void setSource(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.filedownload.ui.ApkFileDownloadButton
 * JD-Core Version:    0.7.0.1
 */