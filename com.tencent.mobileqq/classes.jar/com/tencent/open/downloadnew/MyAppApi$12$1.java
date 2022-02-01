package com.tencent.open.downloadnew;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import oicq.wlogin_sdk.tools.util;

class MyAppApi$12$1
  implements Runnable
{
  MyAppApi$12$1(MyAppApi.12 param12, byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentOpenBaseTicketUtils.a();
    for (;;)
    {
      try
      {
        ThreadManager.excute(new MyAppApi.12.1.1(this, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_AndroidOsBundle)), 32, null, true);
        if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length != 0))
        {
          localStringBuilder = new StringBuilder();
          TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct;
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          localStringBuilder.append("&identity=");
          localStringBuilder.append(util.buf_to_string(this.jdField_a_of_type_ArrayOfByte));
          localTMAssistantCallYYBParamStruct.uin = localStringBuilder.toString();
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.d = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_Long;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("OpenSDK startToAppDetail param SNGAppId=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId);
        localStringBuilder.append(" apkId=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskApkId);
        localStringBuilder.append(" taskAppId=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskAppId);
        localStringBuilder.append(" packageName=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskPackageName);
        localStringBuilder.append(" version=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskVersion);
        localStringBuilder.append(" uin=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin);
        localStringBuilder.append(" via=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.via);
        LogUtility.a("MyAppApi", localStringBuilder.toString());
        LogUtility.c("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
        if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a() <= 2)
        {
          ((TMAssistantCallYYB_V1)this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a()).startToAppDetail(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.b);
          return;
        }
        int i = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_AndroidOsBundle.getInt(DownloadConstants.k);
        int j = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_AndroidOsBundle);
        boolean bool1 = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_Boolean;
        boolean bool2 = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.b;
        if (i == 3)
        {
          bool1 = false;
          bool2 = false;
          ((TMAssistantCallYYB_V2)this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a()).startToAppDetail(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$12.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, bool1, bool2, j);
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
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.12.1
 * JD-Core Version:    0.7.0.1
 */