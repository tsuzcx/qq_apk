package com.tencent.open.downloadnew;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;

class MyAppApi$8
  implements DialogInterface.OnClickListener
{
  MyAppApi$8(MyAppApi paramMyAppApi, boolean paramBoolean1, DialogInterface.OnClickListener paramOnClickListener, Bundle paramBundle, int paramInt1, boolean paramBoolean2, Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean3, boolean paramBoolean4, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LogUtility.c("MyAppApi", "---onConfirm--onClick");
    if (!MyAppApi.b())
    {
      paramDialogInterface = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi;
      paramDialogInterface.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams = new MyAppApi.InstallParams(paramDialogInterface);
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      if (this.jdField_b_of_type_Boolean)
      {
        paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.q);
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0, this.jdField_b_of_type_JavaLangString, paramDialogInterface);
        if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(0, 1);
        }
      }
      else
      {
        paramDialogInterface = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi;
        new MyAppApi.CopyAndInstallTask(paramDialogInterface, this.jdField_a_of_type_AndroidAppActivity, paramDialogInterface.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams).execute(new Void[0]);
      }
    }
    else
    {
      if ((!ControlPolicyUtil.h()) && (!this.c))
      {
        paramDialogInterface = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
        if (paramDialogInterface != null) {
          paramDialogInterface.onClick(null, 0);
        }
      }
      else if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Boolean, this.d);
      }
      else
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Boolean, this.d);
      }
      if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.dismiss();
      }
    }
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append(this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.f));
    paramDialogInterface.append("_");
    paramDialogInterface.append(this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.c));
    paramDialogInterface.append("_");
    paramDialogInterface.append(this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.d));
    paramDialogInterface = paramDialogInterface.toString();
    this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.c = true;
    StaticAnalyz.a("201", StaticAnalyz.a(this.jdField_a_of_type_JavaLangString, "NEWYYB"), this.jdField_b_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis() / 1000L);
    localStringBuilder.append("|");
    localStringBuilder.append(100);
    localStringBuilder.append("|");
    localStringBuilder.append(paramDialogInterface);
    paramDialogInterface = localStringBuilder.toString();
    AppCircleReportManager.a().a(25, paramDialogInterface);
    ReportController.b(null, "dc00898", "", "", "0X8008F7D", "0X8008F7D", 0, 0, "", "", "", "");
    if (this.jdField_b_of_type_Int == 1)
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append(this.jdField_a_of_type_AndroidOsBundle.getString("pageId"));
      paramDialogInterface.append("_");
      paramDialogInterface.append(this.jdField_a_of_type_AndroidOsBundle.getString("moduleId"));
      paramDialogInterface.append("_");
      paramDialogInterface.append(this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.f));
      paramDialogInterface.append("_");
      paramDialogInterface.append(this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.c));
      paramDialogInterface.append("_");
      paramDialogInterface.append(this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.d));
      paramDialogInterface = paramDialogInterface.toString();
      AppCenterReporter.b("6006", "1", "0", this.jdField_a_of_type_JavaLangString, paramDialogInterface);
    }
    if (("ANDROID.QQ.YYBXZGAMECENTER".equals(this.jdField_a_of_type_JavaLangString)) || ("ANDROID.QQ.NEWYYBXZGAMECENTER".equals(this.jdField_a_of_type_JavaLangString))) {
      GameCenterUtils.a(null, "765", "205010", this.jdField_b_of_type_JavaLangString, "76501", "1", "156");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.8
 * JD-Core Version:    0.7.0.1
 */