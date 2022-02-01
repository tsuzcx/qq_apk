package com.tencent.mobileqq.realname;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
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
      return null;
      paramInt = paramBundle.getInt("result");
      paramBundle = paramBundle.getString("source");
      if (QLog.isColorLevel()) {
        QLog.i("RealName", 2, "result is : " + paramInt);
      }
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((paramBundle != null) && (paramString != null) && ((TextUtils.equals(paramBundle, "avgame")) || (TextUtils.equals(paramBundle, "watchtogether"))))
      {
        paramBundle = (ConfigHandler)paramString.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
        if (paramBundle != null)
        {
          if (paramInt == 0) {}
          for (boolean bool = true;; bool = false)
          {
            if (bool) {
              paramString.getPreferences().edit().putBoolean("has_auth_real_name_av", bool).commit();
            }
            if (QLog.isColorLevel()) {
              QLog.i("RealName", 2, "notifyUI");
            }
            paramBundle.notifyUI(15, true, new Object[] { Boolean.valueOf(bool) });
            return null;
          }
        }
      }
    } while ((paramInt == 0) || (paramString == null));
    ((ConfigHandler)paramString.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).f();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.realname.RealNameModule
 * JD-Core Version:    0.7.0.1
 */