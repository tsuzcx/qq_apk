package com.tencent.open.downloadnew;

import android.os.Bundle;
import bflp;
import bfoh;
import bfok;
import bfox;
import bfoz;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;

public class MyAppApi$11$2
  implements Runnable
{
  public MyAppApi$11$2(bfoz parambfoz) {}
  
  public void run()
  {
    boolean bool2 = false;
    DownloadInfo localDownloadInfo = this.a.jdField_a_of_type_Bfox.a(this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.a.jdField_a_of_type_AndroidOsBundle);
    bfok.a().e(localDownloadInfo);
    for (;;)
    {
      boolean bool3;
      try
      {
        bflp.a("State_Log", "OpenSDK startToDownloadTaskList param SNGAppId=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskPackageName + " version=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskVersion + " uin=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin + " via=" + this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.via);
        bflp.c("TIME-STATISTIC", "mDownloadSdk.startToDownloadTaskList");
        if (this.a.jdField_a_of_type_Bfox.a() <= 2)
        {
          ((TMAssistantCallYYB_V1)this.a.jdField_a_of_type_Bfox.a()).startToDownloadTaskList(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.a.jdField_a_of_type_Boolean, this.a.b);
          return;
        }
        int i = this.a.jdField_a_of_type_AndroidOsBundle.getInt(bfoh.k);
        int j = this.a.jdField_a_of_type_Bfox.a(this.a.jdField_a_of_type_AndroidOsBundle);
        boolean bool1 = this.a.jdField_a_of_type_Boolean;
        bool3 = this.a.b;
        if (i == 3)
        {
          bool1 = false;
          ((TMAssistantCallYYB_V2)this.a.jdField_a_of_type_Bfox.a()).startToDownloadTaskList(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, bool1, bool2, j);
          return;
        }
      }
      catch (Exception localException)
      {
        bflp.e("MyAppApi", "--startToDownloadTaskList--Exception = " + localException);
        return;
      }
      bool2 = bool3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.11.2
 * JD-Core Version:    0.7.0.1
 */