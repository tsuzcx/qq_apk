package com.tencent.open.downloadnew;

import android.os.Bundle;
import bflp;
import bflw;
import bfoh;
import bfox;
import bfoy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import oicq.wlogin_sdk.tools.util;

public class MyAppApi$10$1
  implements Runnable
{
  public MyAppApi$10$1(bfoy parambfoy, byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    boolean bool2 = false;
    this.jdField_a_of_type_Bfoy.jdField_a_of_type_Bflw.a();
    for (;;)
    {
      boolean bool3;
      try
      {
        ThreadManager.excute(new MyAppApi.10.1.1(this, this.jdField_a_of_type_Bfoy.jdField_a_of_type_Bfox.a(this.jdField_a_of_type_Bfoy.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.jdField_a_of_type_Bfoy.jdField_a_of_type_AndroidOsBundle)), 32, null, true);
        if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length != 0))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          this.jdField_a_of_type_Bfoy.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin = (this.jdField_a_of_type_JavaLangString + "&identity=" + util.buf_to_string(this.jdField_a_of_type_ArrayOfByte));
          this.jdField_a_of_type_Bfoy.jdField_a_of_type_Bfox.d = this.jdField_a_of_type_Bfoy.jdField_a_of_type_Long;
        }
        bflp.a("MyAppApi", "OpenSDK startToAppDetail param SNGAppId=" + this.jdField_a_of_type_Bfoy.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + this.jdField_a_of_type_Bfoy.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + this.jdField_a_of_type_Bfoy.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + this.jdField_a_of_type_Bfoy.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskPackageName + " version=" + this.jdField_a_of_type_Bfoy.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskVersion + " uin=" + this.jdField_a_of_type_Bfoy.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin + " via=" + this.jdField_a_of_type_Bfoy.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.via);
        bflp.c("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
        if (this.jdField_a_of_type_Bfoy.jdField_a_of_type_Bfox.a() <= 2)
        {
          ((TMAssistantCallYYB_V1)this.jdField_a_of_type_Bfoy.jdField_a_of_type_Bfox.a()).startToAppDetail(this.jdField_a_of_type_Bfoy.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bfoy.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.jdField_a_of_type_Bfoy.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bfoy.b);
          return;
        }
        int i = this.jdField_a_of_type_Bfoy.jdField_a_of_type_AndroidOsBundle.getInt(bfoh.k);
        int j = this.jdField_a_of_type_Bfoy.jdField_a_of_type_Bfox.a(this.jdField_a_of_type_Bfoy.jdField_a_of_type_AndroidOsBundle);
        boolean bool1 = this.jdField_a_of_type_Bfoy.jdField_a_of_type_Boolean;
        bool3 = this.jdField_a_of_type_Bfoy.b;
        if (i == 3)
        {
          bool1 = false;
          ((TMAssistantCallYYB_V2)this.jdField_a_of_type_Bfoy.jdField_a_of_type_Bfox.a()).startToAppDetail(this.jdField_a_of_type_Bfoy.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bfoy.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, bool1, bool2, j);
          return;
        }
      }
      catch (Exception localException)
      {
        bflp.b("MyAppApi", "startToAppDetail err", localException);
        return;
      }
      bool2 = bool3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.10.1
 * JD-Core Version:    0.7.0.1
 */