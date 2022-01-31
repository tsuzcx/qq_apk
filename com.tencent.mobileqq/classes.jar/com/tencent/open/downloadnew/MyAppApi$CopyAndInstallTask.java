package com.tencent.open.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;

public class MyAppApi$CopyAndInstallTask
  extends YybHandleUtil.InstallBaseTask
{
  MyAppApi.InstallParams jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams;
  
  public MyAppApi$CopyAndInstallTask(MyAppApi paramMyAppApi, Activity paramActivity, MyAppApi.InstallParams paramInstallParams)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams = paramInstallParams;
  }
  
  protected void a(Boolean paramBoolean)
  {
    a();
    if (paramBoolean.booleanValue())
    {
      if (YybHandleUtil.a())
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_b_of_type_Boolean = false;
        long l = -1L;
        switch (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Int)
        {
        case 1: 
        default: 
          l = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_Long = l;
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_b_of_type_Long = System.currentTimeMillis();
          if ((paramBoolean.booleanValue()) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle != null))
          {
            paramBoolean = StaticAnalyz.a(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.h), "NEWYYB");
            StaticAnalyz.a("311", paramBoolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.a));
            Context localContext = CommonDataAdapter.a().a();
            if (localContext != null) {
              StaticAnalyz.a(localContext, "312", paramBoolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.a));
            }
          }
          if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing())) {
            this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.dismiss();
          }
          return;
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.e = true;
          if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
          {
            l = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a().addDownloadTaskFromAuthorize(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
          }
          else
          {
            LogUtility.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
            continue;
            l = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.b(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
            continue;
            l = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.b(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle);
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
      }
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      return;
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.CopyAndInstallTask
 * JD-Core Version:    0.7.0.1
 */