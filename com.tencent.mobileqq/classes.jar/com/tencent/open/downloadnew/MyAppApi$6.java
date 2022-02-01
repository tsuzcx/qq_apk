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

class MyAppApi$6
  implements DialogInterface.OnClickListener
{
  MyAppApi$6(MyAppApi paramMyAppApi, boolean paramBoolean1, DialogInterface.OnClickListener paramOnClickListener, Bundle paramBundle, int paramInt1, boolean paramBoolean2, Activity paramActivity, String paramString1, boolean paramBoolean3, boolean paramBoolean4, String paramString2, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LogUtility.c("MyAppApi", "---onConfirm--onClick");
    if (!this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.b())
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams = new MyAppApi.InstallParams(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi);
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0);
        if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(0, 1);
        }
      }
    }
    label636:
    for (;;)
    {
      paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.d);
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.c = true;
      StaticAnalyz.a("201", StaticAnalyz.a(this.jdField_a_of_type_JavaLangString, "NEWYYB"), this.jdField_b_of_type_JavaLangString);
      paramDialogInterface = System.currentTimeMillis() / 1000L + "|" + 100 + "|" + paramDialogInterface;
      AppCircleReportManager.a().a(25, paramDialogInterface);
      ReportController.b(null, "dc00898", "", "", "0X8008F7D", "0X8008F7D", 0, 0, "", "", "", "");
      if (this.jdField_b_of_type_Int == 1)
      {
        paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString("pageId") + "_" + this.jdField_a_of_type_AndroidOsBundle.getString("moduleId") + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.d);
        AppCenterReporter.b("6006", "1", "0", this.jdField_a_of_type_JavaLangString, paramDialogInterface);
      }
      if (("ANDROID.QQ.YYBXZGAMECENTER".equals(this.jdField_a_of_type_JavaLangString)) || ("ANDROID.QQ.NEWYYBXZGAMECENTER".equals(this.jdField_a_of_type_JavaLangString))) {
        GameCenterUtils.a(null, "765", "205010", this.jdField_b_of_type_JavaLangString, "76501", "1", "156");
      }
      return;
      new MyAppApi.CopyAndInstallTask(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams).execute(new Void[0]);
      continue;
      if ((ControlPolicyUtil.h()) || (this.c)) {
        if (this.jdField_a_of_type_Int == 0) {
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Boolean, this.d);
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog == null) || (!this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing())) {
          break label636;
        }
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.dismiss();
        break;
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Boolean, this.d);
        continue;
        if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
          this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.6
 * JD-Core Version:    0.7.0.1
 */