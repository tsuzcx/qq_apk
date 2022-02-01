package com.tencent.open.downloadnew;

import android.os.Bundle;
import com.tencent.open.base.LogUtility;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;

class MyAppApi$12$2
  implements Runnable
{
  MyAppApi$12$2(MyAppApi.12 param12) {}
  
  public void run()
  {
    LogUtility.c("TIME-STATISTIC", "onGetA1Fail");
    Object localObject = this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.a.jdField_a_of_type_AndroidOsBundle);
    DownloadManager.a().e((DownloadInfo)localObject);
    for (;;)
    {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OpenSDK startToAppDetail param SNGAppId=");
        ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId);
        ((StringBuilder)localObject).append(" apkId=");
        ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskApkId);
        ((StringBuilder)localObject).append(" taskAppId=");
        ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskAppId);
        ((StringBuilder)localObject).append(" packageName=");
        ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskPackageName);
        ((StringBuilder)localObject).append(" version=");
        ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskVersion);
        ((StringBuilder)localObject).append(" uin=");
        ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin);
        ((StringBuilder)localObject).append(" via=");
        ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.via);
        LogUtility.a("State_Log", ((StringBuilder)localObject).toString());
        LogUtility.c("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
        if (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a() <= 2)
        {
          ((TMAssistantCallYYB_V1)this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a()).startToAppDetail(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.a.jdField_a_of_type_Boolean, this.a.b);
          return;
        }
        int i = this.a.jdField_a_of_type_AndroidOsBundle.getInt(DownloadConstants.k);
        int j = this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.a.jdField_a_of_type_AndroidOsBundle);
        boolean bool1 = this.a.jdField_a_of_type_Boolean;
        boolean bool2 = this.a.b;
        if (i == 3)
        {
          bool1 = false;
          bool2 = false;
          ((TMAssistantCallYYB_V2)this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a()).startToAppDetail(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, bool1, bool2, j);
          return;
        }
      }
      catch (Exception localException)
      {
        LogUtility.b("MyAppApi", "startToAppDetail err", localException);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.12.2
 * JD-Core Version:    0.7.0.1
 */