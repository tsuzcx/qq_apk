package com.tencent.qzonehub.api.report.lp;

import android.content.SharedPreferences;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.report.lp.LpReportNewIntent;

@QAPI(process={"all"})
public abstract interface ILpReportUtils
  extends QRouteApi
{
  public static final int DC00518_NETWORK_TYPE_2G = 2;
  public static final int DC00518_NETWORK_TYPE_3G = 3;
  public static final int DC00518_NETWORK_TYPE_4G = 4;
  public static final int DC00518_NETWORK_TYPE_5G = 5;
  public static final int DC00518_NETWORK_TYPE_CABLE = 6;
  public static final int DC00518_NETWORK_TYPE_UNKNOWN = 9;
  public static final int DC00518_NETWORK_TYPE_WIFI = 1;
  
  public abstract int convertNetworkTypeToFitInDc00518(int paramInt);
  
  public abstract String getAPN();
  
  public abstract String getAccount();
  
  public abstract String getAlphaConfig(String paramString1, String paramString2, String paramString3);
  
  public abstract int getChatSettingForTroopQZONEPHOTOCode();
  
  public abstract String getDeviceInfor();
  
  public abstract String getIMEI();
  
  public abstract String getIMSI();
  
  public abstract String getInternalCacheDir();
  
  public abstract long getLongAccountUin();
  
  public abstract String getModuleFilePath(String paramString);
  
  public abstract int getNetworkType();
  
  public abstract String getQUA3();
  
  public abstract String getReportUserType(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract long getServerTimeMillis();
  
  public abstract SharedPreferences getSharedPreferences(String paramString);
  
  public abstract String getVersionForHabo();
  
  public abstract int getnetworkType();
  
  public abstract boolean isBackgroundPause();
  
  public abstract boolean isWap();
  
  public abstract boolean loadModule(String paramString, ClassLoader paramClassLoader, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void reportImdeWMDReport();
  
  public abstract void showToast(String paramString, int paramInt);
  
  public abstract void startServlet(LpReportNewIntent paramLpReportNewIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.report.lp.ILpReportUtils
 * JD-Core Version:    0.7.0.1
 */