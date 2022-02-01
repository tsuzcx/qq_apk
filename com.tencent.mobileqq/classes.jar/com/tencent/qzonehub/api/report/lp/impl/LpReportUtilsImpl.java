package com.tencent.qzonehub.api.report.lp.impl;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.open.base.ToastUtil;
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
  public int convertNetworkTypeToFitInDc00518(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      return 9;
    case 1: 
      return 1;
    case 3: 
      return 2;
    case 2: 
      return 3;
    }
    return 4;
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
  
  public String getInternalCacheDir()
  {
    return CacheManager.getInternalCacheDir();
  }
  
  public long getLongAccountUin()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
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
        if (localSharedPreferences.getInt("love_state_for_current_uin" + paramBaseQQAppInterface.getCurrentUin(), 0) == 1) {
          return "1";
        }
        return "2";
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
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramLpReportNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qzonehub.api.report.lp.impl.LpReportUtilsImpl
 * JD-Core Version:    0.7.0.1
 */