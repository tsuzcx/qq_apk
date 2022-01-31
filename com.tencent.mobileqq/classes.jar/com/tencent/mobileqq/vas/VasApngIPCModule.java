package com.tencent.mobileqq.vas;

import akpm;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class VasApngIPCModule
  extends QIPCModule
{
  private static VasApngIPCModule jdField_a_of_type_ComTencentMobileqqVasVasApngIPCModule;
  public static String a;
  private int jdField_a_of_type_Int;
  public VasQuickUpdateManager.CallBacker a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "action_download_apng_so";
  }
  
  private VasApngIPCModule(String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new akpm(this);
  }
  
  public static VasApngIPCModule a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqVasVasApngIPCModule == null) {
        jdField_a_of_type_ComTencentMobileqqVasVasApngIPCModule = new VasApngIPCModule("VasApngIPCModule");
      }
      VasApngIPCModule localVasApngIPCModule = jdField_a_of_type_ComTencentMobileqqVasVasApngIPCModule;
      return localVasApngIPCModule;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasApngUtil.IPCModule", 2, "onCall action = " + paramString);
    }
    if (jdField_a_of_type_JavaLangString.equals(paramString)) {
      if ((BaseApplicationImpl.getApplication() != null) && ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)))
      {
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        VasApngUtil.a(paramString, "VasApngIPCModule");
        paramString = (VasQuickUpdateManager)paramString.getManager(183);
        if (paramString != null) {
          paramString.a(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
        }
        this.jdField_a_of_type_Int = paramInt;
      }
    }
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("VasApngUtil.IPCModule", 2, "onCall action = " + paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasApngIPCModule
 * JD-Core Version:    0.7.0.1
 */