package com.tencent.open.downloadnew;

import android.os.Bundle;
import com.tencent.open.base.LogUtility;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;

class MyAppApi$13$2
  implements Runnable
{
  MyAppApi$13$2(MyAppApi.13 param13) {}
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.a.jdField_a_of_type_AndroidOsBundle);
    DownloadManager.a().e((DownloadInfo)localObject);
    for (;;)
    {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OpenSDK startToDownloadTaskList param SNGAppId=");
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
        LogUtility.c("TIME-STATISTIC", "mDownloadSdk.startToDownloadTaskList");
        if (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a() <= 2)
        {
          ((TMAssistantCallYYB_V1)this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a()).startToDownloadTaskList(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.a.jdField_a_of_type_Boolean, this.a.b);
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
          ((TMAssistantCallYYB_V2)this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a()).startToDownloadTaskList(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, bool1, bool2, j);
          return;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("--startToDownloadTaskList--Exception = ");
        localStringBuilder.append(localException);
        LogUtility.e("MyAppApi", localStringBuilder.toString());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.13.2
 * JD-Core Version:    0.7.0.1
 */