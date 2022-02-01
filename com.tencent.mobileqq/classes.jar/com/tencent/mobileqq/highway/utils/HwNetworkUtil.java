package com.tencent.mobileqq.highway.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class HwNetworkUtil
{
  public static final int CARRIER_OPERATOR_TYPE_CHINAMOBILE = 2;
  public static final int CARRIER_OPERATOR_TYPE_CHINATELECOM = 4;
  public static final int CARRIER_OPERATOR_TYPE_CHINAUNICOM = 3;
  public static final int CARRIER_OPERATOR_TYPE_UNKOWN = 1;
  private static final String IMSI_ACCESS_BUS_ID = "7aa881";
  public static final String TAG = "HwNetworkUtil";
  
  public static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
  
  public static int getCarrierOperatorType(Context paramContext)
  {
    paramContext = getIMSI();
    if (paramContext != null) {
      if ((!paramContext.startsWith("46000")) && (!paramContext.startsWith("46002")))
      {
        if (paramContext.startsWith("46001")) {
          return 3;
        }
        if (paramContext.startsWith("46003")) {
          return 4;
        }
      }
      else
      {
        return 2;
      }
    }
    return 1;
  }
  
  public static int getCellId(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return -1;
    }
    try
    {
      localObject = paramContext.getCellLocation();
      if ((localObject instanceof CdmaCellLocation))
      {
        paramContext = (CdmaCellLocation)paramContext.getCellLocation();
        if (paramContext != null) {
          return paramContext.getBaseStationId();
        }
      }
      else if ((localObject instanceof GsmCellLocation))
      {
        paramContext = (GsmCellLocation)paramContext.getCellLocation();
        if (paramContext != null)
        {
          int i = paramContext.getCid();
          return i;
        }
      }
    }
    catch (Exception paramContext)
    {
      Object localObject;
      paramContext.printStackTrace();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getCellId() error ");
        ((StringBuilder)localObject).append(paramContext);
        QLog.d("HwNetworkUtil", 2, ((StringBuilder)localObject).toString(), paramContext);
      }
    }
    return -1;
  }
  
  public static String getCurrentApn(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.getType() == 0)) {
        return paramContext.getExtraInfo();
      }
    }
    return null;
  }
  
  public static String getCurrentWifiBSSID(Context paramContext)
  {
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    if (paramContext.getSSID() == null) {
      return null;
    }
    paramContext = paramContext.getBSSID();
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.replaceAll(":", "");
    if (paramContext.equals("<unknown ssid>")) {
      return null;
    }
    return paramContext;
  }
  
  public static String getCurrentWifiSSID(Context paramContext)
  {
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    if (paramContext != null)
    {
      if (paramContext.getSSID() == null) {
        return null;
      }
      paramContext = paramContext.getSSID().replaceAll("\"", "");
      if (paramContext.equals("<unknown ssid>")) {
        return null;
      }
      return paramContext;
    }
    return null;
  }
  
  private static String getIMSI()
  {
    try
    {
      String str = (String)getMethodIMSI().invoke(null, new Object[] { "7aa881" });
      return str;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIMSI() error ");
      localStringBuilder.append(localException);
      QLog.e("HwNetworkUtil", 1, localStringBuilder.toString(), localException);
    }
    return null;
  }
  
  protected static Method getMethodIMSI()
  {
    try
    {
      Method localMethod = Class.forName("com.tencent.util.QQDeviceInfo").getMethod("getIMSI", new Class[] { String.class });
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
    return null;
  }
  
  public static String getNetworkName(Context paramContext)
  {
    int i = getSystemNetwork(paramContext);
    if (i != 1)
    {
      if ((i != 2) && (i != 3) && (i != 4)) {
        return "UNKOWN";
      }
      return BdhUtils.getApnType(paramContext);
    }
    return "Wi-Fi";
  }
  
  public static int getNetworkType(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext != null) {
        return paramContext.getType();
      }
    }
    return -1;
  }
  
  public static int getSystemNetwork(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    catch (SecurityException paramContext)
    {
      paramContext.printStackTrace();
    }
    paramContext = null;
    if ((paramContext != null) && (paramContext.isAvailable())) {
      switch (paramContext.getType())
      {
      case 8: 
      default: 
        break;
      case 9: 
        return 5;
      case 1: 
      case 6: 
        return 1;
      case 0: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 7: 
        int i = AppNetConnInfo.getMobileInfo();
        if (i != 2)
        {
          if ((i != 3) && (i != 4)) {
            return 2;
          }
          return 4;
        }
        return 3;
      }
    }
    return 0;
  }
  
  public static boolean is3Gor4G(Context paramContext)
  {
    try
    {
      int j = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("type:");
        localStringBuilder.append(j);
        QLog.d("is3Gor4G", 2, localStringBuilder.toString());
      }
      int i = j;
      if (j == 0)
      {
        i = j;
        if (paramContext != null)
        {
          paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
          i = j;
          if (paramContext != null)
          {
            paramContext = paramContext.getActiveNetworkInfo();
            i = j;
            if (paramContext != null)
            {
              i = j;
              if (paramContext.isConnected()) {
                if (paramContext.getType() != 0) {
                  i = j;
                } else {
                  i = paramContext.getSubtype();
                }
              }
            }
          }
        }
      }
      if ((i == 8) || (i == 13) || (i == 3) || (i == 15) || (i == 10) || (i == 5) || (i == 14) || (i == 6) || (i == 9) || (i == 12)) {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      label175:
      break label175;
    }
    return false;
  }
  
  public static boolean isAirplaneModeOn(Context paramContext)
  {
    paramContext = paramContext.getContentResolver();
    boolean bool = false;
    if (Settings.System.getInt(paramContext, "airplane_mode_on", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isMobileNetWork(Context paramContext)
  {
    try
    {
      boolean bool = isMobileNetworkInfo(((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo());
      return bool;
    }
    catch (Exception paramContext)
    {
      label18:
      break label18;
    }
    return false;
  }
  
  public static boolean isMobileNetworkInfo(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {
      return false;
    }
    return (paramNetworkInfo.getType() == 0) || (50 == paramNetworkInfo.getType());
  }
  
  public static boolean isNetSupport(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext != null)
      {
        int i = 0;
        while (i < paramContext.length)
        {
          NetworkInfo.State localState1 = paramContext[i].getState();
          NetworkInfo.State localState2 = NetworkInfo.State.CONNECTED;
          if (localState1 == localState2) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isAvailable());
  }
  
  @Deprecated
  static boolean isNetworkConnected(Context paramContext)
  {
    boolean bool2 = false;
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.isConnected()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    boolean bool2 = false;
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.getType() == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isWifiEnabled(Context paramContext)
  {
    try
    {
      boolean bool = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().getTypeName().toLowerCase().equals("wifi");
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.HwNetworkUtil
 * JD-Core Version:    0.7.0.1
 */