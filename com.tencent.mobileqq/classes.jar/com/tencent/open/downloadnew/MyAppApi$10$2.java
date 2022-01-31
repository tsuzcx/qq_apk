package com.tencent.open.downloadnew;

import android.os.Bundle;
import bfhg;
import bfjy;
import bfkb;
import bfko;
import bfkp;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;

public class MyAppApi$10$2
  implements Runnable
{
  public MyAppApi$10$2(bfkp parambfkp) {}
  
  public void run()
  {
    boolean bool2 = false;
    bfhg.c("TIME-STATISTIC", "onGetA1Fail");
    DownloadInfo localDownloadInfo = this.a.jdField_a_of_type_Bfko.a(this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.a.jdField_a_of_type_AndroidOsBundle);
    bfkb.a().e(localDownloadInfo);
    for (;;)
    {
      boolean bool3;
      try
      {
        bfhg.a("State_Log", "OpenSDK startToAppDetail param SNGAppId=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskPackageName + " version=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskVersion + " uin=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin + " via=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.via);
        bfhg.c("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
        if (this.a.jdField_a_of_type_Bfko.a() <= 2)
        {
          ((TMAssistantCallYYB_V1)this.a.jdField_a_of_type_Bfko.a()).startToAppDetail(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.a.jdField_a_of_type_Boolean, this.a.b);
          return;
        }
        int i = this.a.jdField_a_of_type_AndroidOsBundle.getInt(bfjy.k);
        int j = this.a.jdField_a_of_type_Bfko.a(this.a.jdField_a_of_type_AndroidOsBundle);
        boolean bool1 = this.a.jdField_a_of_type_Boolean;
        bool3 = this.a.b;
        if (i == 3)
        {
          bool1 = false;
          ((TMAssistantCallYYB_V2)this.a.jdField_a_of_type_Bfko.a()).startToAppDetail(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, bool1, bool2, j);
          return;
        }
      }
      catch (Exception localException)
      {
        bfhg.b("MyAppApi", "startToAppDetail err", localException);
        return;
      }
      bool2 = bool3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.10.2
 * JD-Core Version:    0.7.0.1
 */