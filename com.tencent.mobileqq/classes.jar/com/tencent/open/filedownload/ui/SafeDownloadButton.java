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
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713451);
  private static final String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131713454);
  private long jdField_a_of_type_Long = 0L;
  private boolean jdField_a_of_type_Boolean = false;
  private TaskInfo jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo;
  private boolean jdField_b_of_type_Boolean = false;
  
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
  
  private String c()
  {
    try
    {
      String str = "tmast://download?downl_url=" + URLEncoder.encode(this.jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo.e, "UTF-8") + "&down_ticket=" + URLEncoder.encode(this.jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo.e, "UTF-8") + "&oplist=1;2&via=" + this.jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo.d;
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return "";
  }
  
  private void k()
  {
    if ((this.jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo == null) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo.e))) {
      return;
    }
    AppCenterReporter.b(ClickDataBuilder.a().a("200").k(this.jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_a_of_type_JavaLangString).j(this.jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_b_of_type_JavaLangString).l(this.jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo.c).m(this.jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo.d).a(this.jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo.h).b(this.jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo.f).g(this.jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo.e));
    QQAppInterface localQQAppInterface = ((BaseActivity)getContext()).app;
    if (this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h)
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009AC4", "0X8009AC4", 0, 0, "1", "", str, "");
      l();
      return;
    }
  }
  
  private void l()
  {
    String str = c();
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(str));
    localIntent.addFlags(268435456);
    try
    {
      BaseApplication.getContext().startActivity(localIntent);
      LogUtility.b("SafeDownloadButton_", "goToYYBByTmast success! jumpUrl=" + str);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      LogUtility.e("SafeDownloadButton_", "ActivityNotFoundException e=" + localActivityNotFoundException.getMessage());
    }
  }
  
  private void m()
  {
    String str = c();
    Bundle localBundle = new Bundle();
    localBundle.putString("url", str);
    DownloadApi.a(localBundle);
    DownloadApi.b(localBundle);
    LogUtility.b("SafeDownloadButton_", "writeTmastCmd success! jumpUrl=" + str);
  }
  
  protected String a()
  {
    return HardCodeUtil.a(2131713456);
  }
  
  protected String a(int paramInt)
  {
    if (paramInt == 1) {
      return jdField_a_of_type_JavaLangString;
    }
    return jdField_b_of_type_JavaLangString;
  }
  
  protected void a(DownloadInfo paramDownloadInfo)
  {
    this.jdField_a_of_type_Boolean = true;
    m();
    super.a(paramDownloadInfo);
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.equals(paramString, "com.tencent.android.qqdownloader"))
    {
      LogUtility.b("SafeDownloadButton_", HardCodeUtil.a(2131713453) + this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        ThreadManager.getUIHandler().post(new SafeDownloadButton.1(this));
      }
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    if ((paramBoolean) && (("900".equals(paramString)) || ("400".equals(paramString))))
    {
      localQQAppInterface = ((BaseActivity)getContext()).app;
      if (this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h != null) {
        break label73;
      }
    }
    label73:
    for (paramString = "";; paramString = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h)
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009AC4", "0X8009AC4", 0, 0, "2", "", paramString, "");
      return;
    }
  }
  
  protected String b(int paramInt)
  {
    if (paramInt == 4) {
      return HardCodeUtil.a(2131713455);
    }
    return HardCodeUtil.a(2131713452);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (CommonUtils.a())
    {
      this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_b_of_type_Int = 1;
      g();
      k();
      return;
    }
    super.b(paramBoolean);
  }
  
  protected void e()
  {
    this.jdField_a_of_type_Boolean = true;
    m();
    super.e();
  }
  
  public void j()
  {
    long l = System.currentTimeMillis();
    LogUtility.b("SafeDownloadButton_", "onResume " + this.jdField_b_of_type_Boolean + ",currentTimestamp=" + l + ",mYYBInstallSuccessTimestamp= " + this.jdField_a_of_type_Long);
    if (this.jdField_b_of_type_Boolean)
    {
      if (l - this.jdField_a_of_type_Long < 5000L) {
        l();
      }
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void setOriApkInfo(TaskInfo paramTaskInfo)
  {
    this.jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo = TaskInfo.a(paramTaskInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.filedownload.ui.SafeDownloadButton
 * JD-Core Version:    0.7.0.1
 */