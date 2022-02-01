package com.tencent.open.downloadnew;

import android.os.Bundle;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import oicq.wlogin_sdk.tools.util;

class MyAppApi$13$1
  implements Runnable
{
  MyAppApi$13$1(MyAppApi.13 param13, byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentOpenBaseTicketUtils.a();
    for (;;)
    {
      try
      {
        Object localObject = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_AndroidOsBundle);
        DownloadManager.a().e((DownloadInfo)localObject);
        if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length != 0))
        {
          localObject = new StringBuilder();
          TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct;
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append("&identity=");
          ((StringBuilder)localObject).append(util.buf_to_string(this.jdField_a_of_type_ArrayOfByte));
          localTMAssistantCallYYBParamStruct.uin = ((StringBuilder)localObject).toString();
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.d = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_Long;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OpenSDK startToAppDetail param SNGAppId=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId);
        ((StringBuilder)localObject).append(" apkId=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskApkId);
        ((StringBuilder)localObject).append(" taskAppId=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskAppId);
        ((StringBuilder)localObject).append(" packageName=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskPackageName);
        ((StringBuilder)localObject).append(" version=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskVersion);
        ((StringBuilder)localObject).append(" uin=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin);
        ((StringBuilder)localObject).append(" via=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.via);
        LogUtility.a("State_Log", ((StringBuilder)localObject).toString());
        LogUtility.c("TIME-STATISTIC", "mDownloadSdk.startToDownloadTaskList");
        if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a() <= 2)
        {
          ((TMAssistantCallYYB_V1)this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a()).startToDownloadTaskList(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.b);
          return;
        }
        int i = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_AndroidOsBundle.getInt(DownloadConstants.k);
        int j = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_AndroidOsBundle);
        boolean bool1 = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_Boolean;
        boolean bool2 = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.b;
        if (i == 3)
        {
          bool1 = false;
          bool2 = false;
          ((TMAssistantCallYYB_V2)this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a()).startToDownloadTaskList(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$13.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, bool1, bool2, j);
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
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.13.1
 * JD-Core Version:    0.7.0.1
 */