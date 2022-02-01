package com.tencent.open.downloadnew;

import android.os.Bundle;
import bisy;
import bitf;
import bivp;
import bivr;
import biwe;
import biwg;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import oicq.wlogin_sdk.tools.util;

public class MyAppApi$11$1
  implements Runnable
{
  public MyAppApi$11$1(biwg parambiwg, byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    boolean bool2 = false;
    this.jdField_a_of_type_Biwg.jdField_a_of_type_Bitf.a();
    for (;;)
    {
      boolean bool3;
      try
      {
        Object localObject = this.jdField_a_of_type_Biwg.jdField_a_of_type_Biwe.a(this.jdField_a_of_type_Biwg.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.jdField_a_of_type_Biwg.jdField_a_of_type_AndroidOsBundle);
        bivr.a().e((DownloadInfo)localObject);
        if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length != 0))
        {
          localObject = new StringBuilder();
          this.jdField_a_of_type_Biwg.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin = (this.jdField_a_of_type_JavaLangString + "&identity=" + util.buf_to_string(this.jdField_a_of_type_ArrayOfByte));
          this.jdField_a_of_type_Biwg.jdField_a_of_type_Biwe.d = this.jdField_a_of_type_Biwg.jdField_a_of_type_Long;
        }
        bisy.a("State_Log", "OpenSDK startToAppDetail param SNGAppId=" + this.jdField_a_of_type_Biwg.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + this.jdField_a_of_type_Biwg.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + this.jdField_a_of_type_Biwg.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + this.jdField_a_of_type_Biwg.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskPackageName + " version=" + this.jdField_a_of_type_Biwg.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskVersion + " uin=" + this.jdField_a_of_type_Biwg.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin + " via=" + this.jdField_a_of_type_Biwg.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.via);
        bisy.c("TIME-STATISTIC", "mDownloadSdk.startToDownloadTaskList");
        if (this.jdField_a_of_type_Biwg.jdField_a_of_type_Biwe.a() <= 2)
        {
          ((TMAssistantCallYYB_V1)this.jdField_a_of_type_Biwg.jdField_a_of_type_Biwe.a()).startToDownloadTaskList(this.jdField_a_of_type_Biwg.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Biwg.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.jdField_a_of_type_Biwg.jdField_a_of_type_Boolean, this.jdField_a_of_type_Biwg.b);
          return;
        }
        int i = this.jdField_a_of_type_Biwg.jdField_a_of_type_AndroidOsBundle.getInt(bivp.k);
        int j = this.jdField_a_of_type_Biwg.jdField_a_of_type_Biwe.a(this.jdField_a_of_type_Biwg.jdField_a_of_type_AndroidOsBundle);
        boolean bool1 = this.jdField_a_of_type_Biwg.jdField_a_of_type_Boolean;
        bool3 = this.jdField_a_of_type_Biwg.b;
        if (i == 3)
        {
          bool1 = false;
          ((TMAssistantCallYYB_V2)this.jdField_a_of_type_Biwg.jdField_a_of_type_Biwe.a()).startToDownloadTaskList(this.jdField_a_of_type_Biwg.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Biwg.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, bool1, bool2, j);
          return;
        }
      }
      catch (Exception localException)
      {
        bisy.b("MyAppApi", "startToAppDetail err", localException);
        return;
      }
      bool2 = bool3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.11.1
 * JD-Core Version:    0.7.0.1
 */