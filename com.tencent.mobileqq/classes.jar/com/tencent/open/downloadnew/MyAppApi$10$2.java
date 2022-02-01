package com.tencent.open.downloadnew;

import android.os.Bundle;
import bhzm;
import bibw;
import biby;
import bicl;
import bicm;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;

public class MyAppApi$10$2
  implements Runnable
{
  public MyAppApi$10$2(bicm parambicm) {}
  
  public void run()
  {
    boolean bool2 = false;
    bhzm.c("TIME-STATISTIC", "onGetA1Fail");
    DownloadInfo localDownloadInfo = this.a.jdField_a_of_type_Bicl.a(this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.a.jdField_a_of_type_AndroidOsBundle);
    biby.a().e(localDownloadInfo);
    for (;;)
    {
      boolean bool3;
      try
      {
        bhzm.a("State_Log", "OpenSDK startToAppDetail param SNGAppId=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskPackageName + " version=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskVersion + " uin=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin + " via=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.via);
        bhzm.c("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
        if (this.a.jdField_a_of_type_Bicl.a() <= 2)
        {
          ((TMAssistantCallYYB_V1)this.a.jdField_a_of_type_Bicl.a()).startToAppDetail(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.a.jdField_a_of_type_Boolean, this.a.b);
          return;
        }
        int i = this.a.jdField_a_of_type_AndroidOsBundle.getInt(bibw.k);
        int j = this.a.jdField_a_of_type_Bicl.a(this.a.jdField_a_of_type_AndroidOsBundle);
        boolean bool1 = this.a.jdField_a_of_type_Boolean;
        bool3 = this.a.b;
        if (i == 3)
        {
          bool1 = false;
          ((TMAssistantCallYYB_V2)this.a.jdField_a_of_type_Bicl.a()).startToAppDetail(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, bool1, bool2, j);
          return;
        }
      }
      catch (Exception localException)
      {
        bhzm.b("MyAppApi", "startToAppDetail err", localException);
        return;
      }
      bool2 = bool3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.10.2
 * JD-Core Version:    0.7.0.1
 */