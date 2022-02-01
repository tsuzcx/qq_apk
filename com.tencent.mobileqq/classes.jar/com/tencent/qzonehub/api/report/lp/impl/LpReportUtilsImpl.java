package com.tencent.qzonehub.api.report.lp.impl;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import common.config.service.QzoneAlphaConfig;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.report.lp.LpReportNewIntent;
import cooperation.qzone.report.wmd.WMDReportManager;
import mqq.app.AppRuntime;

public class LpReportUtilsImpl
  implements ILpReportUtils
{
  protected static final String TAG = "LpReportUtilsImpl";
  
  public int convertNetworkTypeToFitInDc00518(int paramInt)
  {
    int i = 1;
    if (paramInt != 1)
    {
      i = 3;
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 6) {
            return 9;
          }
          return 4;
        }
        return 2;
      }
    }
    return i;
  }
  
  public String getAPN()
  {
    return cooperation.qzone.util.NetworkState.getAPN();
  }
  
  public String getAccount()
  {
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null) && (BaseApplicationImpl.getApplication().getRuntime().getAccount() != null)) {
      return BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }
    return "";
  }
  
  public String getAlphaConfig(String paramString1, String paramString2, String paramString3)
  {
    return QzoneAlphaConfig.a().a(paramString1, paramString2, paramString3);
  }
  
  public int getChatSettingForTroopQZONEPHOTOCode()
  {
    return 7;
  }
  
  public String getDeviceInfor()
  {
    return PlatformInfor.g().getDeviceInfor();
  }
  
  public String getIMEI()
  {
    return PlatformInfor.g().getIMEI();
  }
  
  public String getIMSI()
  {
    return PlatformInfor.g().getIMSI();
  }
  
  public String getInternalCacheDir()
  {
    return CacheManager.getInternalCacheDir();
  }
  
  public long getLongAccountUin()
  {
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
      return BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    }
    QLog.e("LpReportUtilsImpl", 1, "getLongAccountUin runtime null");
    return 0L;
  }
  
  public String getModuleFilePath(String paramString)
  {
    return QzoneModuleManager.getInstance().getModuleFilePath(paramString);
  }
  
  public int getNetworkType()
  {
    return com.tencent.component.network.module.common.NetworkState.g().getNetworkType();
  }
  
  public String getQUA3()
  {
    return QUA.getQUA3();
  }
  
  public String getReportUserType(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramBaseQQAppInterface != null)
    {
      SharedPreferences localSharedPreferences = paramBaseQQAppInterface.getPreferences();
      if (localSharedPreferences != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("love_state_for_current_uin");
        localStringBuilder.append(paramBaseQQAppInterface.getCurrentUin());
        if (localSharedPreferences.getInt(localStringBuilder.toString(), 0) == 1) {
          return "1";
        }
      }
    }
    return "2";
  }
  
  public long getServerTimeMillis()
  {
    return NetConnInfoCenter.getServerTimeMillis();
  }
  
  public SharedPreferences getSharedPreferences(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString, 0);
  }
  
  public String getVersionForHabo()
  {
    return QUA.getVersionForHabo();
  }
  
  public int getnetworkType()
  {
    return cooperation.qzone.util.NetworkState.getNetworkType();
  }
  
  public boolean isBackgroundPause()
  {
    return (BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null) && (BaseApplicationImpl.getApplication().getRuntime().isBackgroundPause);
  }
  
  public boolean isWap()
  {
    return cooperation.qzone.util.NetworkState.isWap();
  }
  
  public boolean loadModule(String paramString, ClassLoader paramClassLoader, boolean paramBoolean1, boolean paramBoolean2)
  {
    return QzoneModuleManager.getInstance().loadModule(paramString, getClass().getClassLoader(), false, false);
  }
  
  public void reportImdeWMDReport()
  {
    WMDReportManager.getInstance().reportImediately();
  }
  
  public void showToast(String paramString, int paramInt)
  {
    ToastUtil.a().a(paramString, paramInt);
  }
  
  public void startServlet(LpReportNewIntent paramLpReportNewIntent)
  {
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null))
    {
      BaseApplicationImpl.getApplication().getRuntime().startServlet(paramLpReportNewIntent);
      return;
    }
    QLog.e("LpReportUtilsImpl", 1, "startServlet runtime null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.report.lp.impl.LpReportUtilsImpl
 * JD-Core Version:    0.7.0.1
 */