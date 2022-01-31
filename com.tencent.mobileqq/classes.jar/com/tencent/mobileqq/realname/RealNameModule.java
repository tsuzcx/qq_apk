package com.tencent.mobileqq.realname;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class RealNameModule
  extends QIPCModule
{
  private static RealNameModule jdField_a_of_type_ComTencentMobileqqRealnameRealNameModule;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  
  private RealNameModule(String paramString)
  {
    super(paramString);
  }
  
  public static RealNameModule a()
  {
    if (jdField_a_of_type_ComTencentMobileqqRealnameRealNameModule != null) {
      return jdField_a_of_type_ComTencentMobileqqRealnameRealNameModule;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqRealnameRealNameModule == null) {
        jdField_a_of_type_ComTencentMobileqqRealnameRealNameModule = new RealNameModule("REAL_NAME");
      }
      RealNameModule localRealNameModule = jdField_a_of_type_ComTencentMobileqqRealnameRealNameModule;
      return localRealNameModule;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RealName", 2, "onCall s: " + paramString);
    }
    if (paramBundle == null) {}
    do
    {
      do
      {
        return null;
        paramInt = paramBundle.getInt("result");
        if (QLog.isColorLevel()) {
          QLog.i("RealName", 2, "result is : " + paramInt);
        }
      } while (paramInt == 0);
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (paramString == null);
    ((ConfigHandler)paramString.a(4)).f();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.realname.RealNameModule
 * JD-Core Version:    0.7.0.1
 */