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
  private static RealNameModule a;
  private static Object b = new Object();
  
  private RealNameModule(String paramString)
  {
    super(paramString);
  }
  
  public static RealNameModule a()
  {
    ??? = a;
    if (??? != null) {
      return ???;
    }
    synchronized (b)
    {
      if (a == null) {
        a = new RealNameModule("REAL_NAME");
      }
      RealNameModule localRealNameModule = a;
      return localRealNameModule;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall s: ");
      localStringBuilder.append(paramString);
      QLog.i("RealName", 2, localStringBuilder.toString());
    }
    if (paramBundle == null) {
      return null;
    }
    paramInt = paramBundle.getInt("result");
    paramString = paramBundle.getString("source");
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("result is : ");
      paramBundle.append(paramInt);
      QLog.i("RealName", 2, paramBundle.toString());
    }
    paramBundle = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString != null) && (paramBundle != null) && ((TextUtils.equals(paramString, "avgame")) || (TextUtils.equals(paramString, "watchtogether"))))
    {
      paramString = (ConfigHandler)paramBundle.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
      if (paramString != null)
      {
        boolean bool;
        if (paramInt == 0) {
          bool = true;
        } else {
          bool = false;
        }
        if (bool) {
          paramBundle.getPreferences().edit().putBoolean("has_auth_real_name_av", bool).commit();
        }
        if (QLog.isColorLevel()) {
          QLog.i("RealName", 2, "notifyUI");
        }
        paramString.notifyUI(15, true, new Object[] { Boolean.valueOf(bool) });
        return null;
      }
    }
    if (paramInt == 0) {
      return null;
    }
    if (paramBundle != null) {
      ((ConfigHandler)paramBundle.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).n();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.realname.RealNameModule
 * JD-Core Version:    0.7.0.1
 */