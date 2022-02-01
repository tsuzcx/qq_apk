package com.tencent.open.downloadnew;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;

class MyAppApi$18
  implements DialogInterface.OnClickListener
{
  MyAppApi$18(MyAppApi paramMyAppApi, Bundle paramBundle, boolean paramBoolean, Activity paramActivity, String paramString1, DialogInterface.OnClickListener paramOnClickListener, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LogUtility.c("MyAppApi", "---onConfirm--onClick");
    if (!MyAppApi.b())
    {
      paramDialogInterface = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi;
      paramDialogInterface.a = new MyAppApi.InstallParams(paramDialogInterface);
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.b = true;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_Int = 2;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0, "", "");
      }
      else
      {
        paramDialogInterface = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi;
        new MyAppApi.CopyAndInstallTask(paramDialogInterface, this.jdField_a_of_type_AndroidAppActivity, paramDialogInterface.a).execute(new Void[0]);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.c = true;
    StaticAnalyz.a("201", StaticAnalyz.a(this.jdField_a_of_type_JavaLangString, "NEWYYB"), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.18
 * JD-Core Version:    0.7.0.1
 */