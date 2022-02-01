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
        Object localObject = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi;
        ((MyAppApi)localObject).jdField_a_of_type_Boolean = true;
        ((MyAppApi)localObject).jdField_b_of_type_Boolean = false;
        long l = -1L;
        int i = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Int;
        if (i != 0)
        {
          if (i != 2)
          {
            if (i != 3) {
              l = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
            } else {
              l = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.b(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle);
            }
          }
          else
          {
            localObject = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi;
            ((MyAppApi)localObject).e = true;
            if (((MyAppApi)localObject).jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null) {
              l = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a().addDownloadTaskFromAuthorize(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
            } else {
              LogUtility.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
            }
          }
        }
        else {
          l = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.b(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
        }
        localObject = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi;
        ((MyAppApi)localObject).jdField_a_of_type_Long = l;
        ((MyAppApi)localObject).jdField_b_of_type_Long = System.currentTimeMillis();
        if ((paramBoolean.booleanValue()) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle != null))
        {
          paramBoolean = StaticAnalyz.a(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.i), "NEWYYB");
          StaticAnalyz.a("311", paramBoolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.b));
          localObject = CommonDataAdapter.a().a();
          if (localObject != null) {
            StaticAnalyz.a((Context)localObject, "312", paramBoolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.b));
          }
        }
        if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.dismiss();
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
        }
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
      }
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
    }
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.CopyAndInstallTask
 * JD-Core Version:    0.7.0.1
 */