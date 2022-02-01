package com.tencent.open.downloadnew;

import android.os.Bundle;
import bjtx;
import bjue;
import bjwo;
import bjwq;
import bjxd;
import bjxf;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import oicq.wlogin_sdk.tools.util;

public class MyAppApi$11$1
  implements Runnable
{
  public MyAppApi$11$1(bjxf parambjxf, byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    boolean bool2 = false;
    this.jdField_a_of_type_Bjxf.jdField_a_of_type_Bjue.a();
    for (;;)
    {
      boolean bool3;
      try
      {
        Object localObject = this.jdField_a_of_type_Bjxf.jdField_a_of_type_Bjxd.a(this.jdField_a_of_type_Bjxf.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.jdField_a_of_type_Bjxf.jdField_a_of_type_AndroidOsBundle);
        bjwq.a().e((DownloadInfo)localObject);
        if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length != 0))
        {
          localObject = new StringBuilder();
          this.jdField_a_of_type_Bjxf.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin = (this.jdField_a_of_type_JavaLangString + "&identity=" + util.buf_to_string(this.jdField_a_of_type_ArrayOfByte));
          this.jdField_a_of_type_Bjxf.jdField_a_of_type_Bjxd.d = this.jdField_a_of_type_Bjxf.jdField_a_of_type_Long;
        }
        bjtx.a("State_Log", "OpenSDK startToAppDetail param SNGAppId=" + this.jdField_a_of_type_Bjxf.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + this.jdField_a_of_type_Bjxf.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + this.jdField_a_of_type_Bjxf.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + this.jdField_a_of_type_Bjxf.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskPackageName + " version=" + this.jdField_a_of_type_Bjxf.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskVersion + " uin=" + this.jdField_a_of_type_Bjxf.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin + " via=" + this.jdField_a_of_type_Bjxf.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.via);
        bjtx.c("TIME-STATISTIC", "mDownloadSdk.startToDownloadTaskList");
        if (this.jdField_a_of_type_Bjxf.jdField_a_of_type_Bjxd.a() <= 2)
        {
          ((TMAssistantCallYYB_V1)this.jdField_a_of_type_Bjxf.jdField_a_of_type_Bjxd.a()).startToDownloadTaskList(this.jdField_a_of_type_Bjxf.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bjxf.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.jdField_a_of_type_Bjxf.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bjxf.b);
          return;
        }
        int i = this.jdField_a_of_type_Bjxf.jdField_a_of_type_AndroidOsBundle.getInt(bjwo.k);
        int j = this.jdField_a_of_type_Bjxf.jdField_a_of_type_Bjxd.a(this.jdField_a_of_type_Bjxf.jdField_a_of_type_AndroidOsBundle);
        boolean bool1 = this.jdField_a_of_type_Bjxf.jdField_a_of_type_Boolean;
        bool3 = this.jdField_a_of_type_Bjxf.b;
        if (i == 3)
        {
          bool1 = false;
          ((TMAssistantCallYYB_V2)this.jdField_a_of_type_Bjxf.jdField_a_of_type_Bjxd.a()).startToDownloadTaskList(this.jdField_a_of_type_Bjxf.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bjxf.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, bool1, bool2, j);
          return;
        }
      }
      catch (Exception localException)
      {
        bjtx.b("MyAppApi", "startToAppDetail err", localException);
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