package com.tencent.open.filedownload.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.appstore.report.ClickDataBuilder;
import com.tencent.open.appstore.report.ReportDataBuilder;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.filedownload.CommonUtils;
import com.tencent.open.filedownload.TaskInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

public class SafeDownloadButton
  extends ApkFileDownloadButton
{
  private static final String d = HardCodeUtil.a(2131910970);
  private static final String e = HardCodeUtil.a(2131910973);
  private TaskInfo f;
  private boolean g = false;
  private boolean h = false;
  private long i = 0L;
  
  public SafeDownloadButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SafeDownloadButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SafeDownloadButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String getTaskTmastUrl()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tmast://download?downl_url=");
      ((StringBuilder)localObject).append(URLEncoder.encode(this.f.e, "UTF-8"));
      ((StringBuilder)localObject).append("&down_ticket=");
      ((StringBuilder)localObject).append(URLEncoder.encode(this.f.e, "UTF-8"));
      ((StringBuilder)localObject).append("&oplist=1;2&via=");
      ((StringBuilder)localObject).append(this.f.d);
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return "";
  }
  
  private void k()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((TaskInfo)localObject).e)) {
        return;
      }
      AppCenterReporter.b(ClickDataBuilder.a().a("200").l(this.f.a).k(this.f.b).m(this.f.c).n(this.f.d).b(this.f.i).c(this.f.f).h(this.f.e));
      QQAppInterface localQQAppInterface = ((BaseActivity)getContext()).app;
      if (this.c.i == null) {
        localObject = "";
      } else {
        localObject = this.c.i;
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009AC4", "0X8009AC4", 0, 0, "1", "", (String)localObject, "");
      l();
    }
  }
  
  private void l()
  {
    String str = getTaskTmastUrl();
    Object localObject = new Intent("android.intent.action.VIEW");
    ((Intent)localObject).setData(Uri.parse(str));
    ((Intent)localObject).addFlags(268435456);
    try
    {
      BaseApplication.getContext().startActivity((Intent)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("goToYYBByTmast success! jumpUrl=");
      ((StringBuilder)localObject).append(str);
      LogUtility.b("SafeDownloadButton_", ((StringBuilder)localObject).toString());
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ActivityNotFoundException e=");
      ((StringBuilder)localObject).append(localActivityNotFoundException.getMessage());
      LogUtility.e("SafeDownloadButton_", ((StringBuilder)localObject).toString());
    }
  }
  
  private void m()
  {
    String str = getTaskTmastUrl();
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("url", str);
    DownloadApi.a((Bundle)localObject);
    DownloadApi.b((Bundle)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("writeTmastCmd success! jumpUrl=");
    ((StringBuilder)localObject).append(str);
    LogUtility.b("SafeDownloadButton_", ((StringBuilder)localObject).toString());
  }
  
  protected String a(int paramInt)
  {
    if (paramInt == 1) {
      return d;
    }
    return e;
  }
  
  protected void a(DownloadInfo paramDownloadInfo)
  {
    this.g = true;
    m();
    super.a(paramDownloadInfo);
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.equals(paramString, "com.tencent.android.qqdownloader"))
    {
      paramString = new StringBuilder();
      paramString.append(HardCodeUtil.a(2131910972));
      paramString.append(this.g);
      LogUtility.b("SafeDownloadButton_", paramString.toString());
      if (this.g)
      {
        this.h = true;
        this.i = System.currentTimeMillis();
        ThreadManager.getUIHandler().post(new SafeDownloadButton.1(this));
      }
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (("900".equals(paramString)) || ("400".equals(paramString))))
    {
      QQAppInterface localQQAppInterface = ((BaseActivity)getContext()).app;
      if (this.c.i == null) {
        paramString = "";
      } else {
        paramString = this.c.i;
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009AC4", "0X8009AC4", 0, 0, "2", "", paramString, "");
    }
  }
  
  protected String b(int paramInt)
  {
    if (paramInt == 4) {
      return HardCodeUtil.a(2131910974);
    }
    return HardCodeUtil.a(2131910971);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (CommonUtils.a())
    {
      this.c.k = 1;
      g();
      k();
      return;
    }
    super.b(paramBoolean);
  }
  
  protected void e()
  {
    this.g = true;
    m();
    super.e();
  }
  
  protected String getProgressHintText()
  {
    return HardCodeUtil.a(2131910975);
  }
  
  public void j()
  {
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResume ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",currentTimestamp=");
    localStringBuilder.append(l);
    localStringBuilder.append(",mYYBInstallSuccessTimestamp= ");
    localStringBuilder.append(this.i);
    LogUtility.b("SafeDownloadButton_", localStringBuilder.toString());
    if (this.h)
    {
      if (l - this.i < 5000L) {
        l();
      }
      this.h = false;
    }
  }
  
  public void setOriApkInfo(TaskInfo paramTaskInfo)
  {
    this.f = TaskInfo.a(paramTaskInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.filedownload.ui.SafeDownloadButton
 * JD-Core Version:    0.7.0.1
 */