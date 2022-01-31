package com.tencent.mobileqq.highway.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.System;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;

public class HwNetworkUtil
{
  public static final int CARRIER_OPERATOR_TYPE_CHINAMOBILE = 2;
  public static final int CARRIER_OPERATOR_TYPE_CHINATELECOM = 4;
  public static final int CARRIER_OPERATOR_TYPE_CHINAUNICOM = 3;
  public static final int CARRIER_OPERATOR_TYPE_UNKOWN = 1;
  public static final String TAG = "HwNetworkUtil";
  
  public static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
  
  public static int getCarrierOperatorType(Context paramContext)
  {
    paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
    if (paramContext != null)
    {
      if ((paramContext.startsWith("46000")) || (paramContext.startsWith("46002"))) {
        return 2;
      }
      if (paramContext.startsWith("46001")) {
        return 3;
      }
      if (paramContext.startsWith("46003")) {
        return 4;
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
      CellLocation localCellLocation = paramContext.getCellLocation();
      if ((localCellLocation instanceof CdmaCellLocation))
      {
        paramContext = (CdmaCellLocation)paramContext.getCellLocation();
        if (paramContext != null) {
          return paramContext.getBaseStationId();
        }
      }
      else if ((localCellLocation instanceof GsmCellLocation))
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
      paramContext.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("HwNetworkUtil", 2, "getCellId() error " + paramContext, paramContext);
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
      return null;
    }
    return null;
  }
  
  public static String getCurrentWifiBSSID(Context paramContext)
  {
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    if (paramContext.getSSID() == null) {
      paramContext = null;
    }
    String str;
    do
    {
      return paramContext;
      paramContext = paramContext.getBSSID();
      if (paramContext == null) {
        return null;
      }
      str = paramContext.replaceAll(":", "");
      paramContext = str;
    } while (!str.equals("<unknown ssid>"));
    return null;
  }
  
  public static String getCurrentWifiSSID(Context paramContext)
  {
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    if ((paramContext == null) || (paramContext.getSSID() == null)) {
      paramContext = null;
    }
    String str;
    do
    {
      return paramContext;
      str = paramContext.getSSID().replaceAll("\"", "");
      paramContext = str;
    } while (!str.equals("<unknown ssid>"));
    return null;
  }
  
  public static String getIMSI(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return "46000";
    }
    try
    {
      paramContext = paramContext.getSubscriberId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("HwNetworkUtil", 2, "getIMSI() error " + paramContext, paramContext);
      }
    }
    return "46000";
  }
  
  public static String getNetworkName(Context paramContext)
  {
    switch (getSystemNetwork(paramContext))
    {
    default: 
      return "UNKOWN";
    case 1: 
      return "Wi-Fi";
    }
    return BdhUtils.getApnType(paramContext);
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
      if ((paramContext != null) && (paramContext.isAvailable())) {}
      switch (paramContext.getType())
      {
      case 8: 
      default: 
        return 0;
      }
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
      return 5;
    }
    return 1;
    switch (AppNetConnInfo.getMobileInfo())
    {
    default: 
      return 2;
    case 3: 
    case 4: 
      return 4;
    }
    return 3;
  }
  
  public static boolean is3Gor4G(Context paramContext)
  {
    int i;
    try
    {
      i = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType();
      if (QLog.isColorLevel()) {
        QLog.d("is3Gor4G", 2, "type:" + i);
      }
      if ((i == 0) && (paramContext != null))
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext != null)
        {
          paramContext = paramContext.getActiveNetworkInfo();
          if ((paramContext != null) && (paramContext.isConnected())) {
            switch (paramContext.getType())
            {
            case 0: 
              i = paramContext.getSubtype();
            }
          }
        }
      }
    }
    catch (Exception paramContext) {}
    while ((i != 8) && (i != 13) && (i != 3) && (i != 15) && (i != 10) && (i != 5) && (i != 14) && (i != 6) && (i != 9) && (i != 12)) {
      return false;
    }
    return true;
  }
  
  public static boolean isAirplaneModeOn(Context paramContext)
  {
    boolean bool = false;
    if (Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0) != 0) {
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
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean isMobileNetworkInfo(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {}
    while ((paramNetworkInfo.getType() != 0) && (50 != paramNetworkInfo.getType())) {
      return false;
    }
    return true;
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
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isConnected())) {}
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.getType() == 1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.HwNetworkUtil
 * JD-Core Version:    0.7.0.1
 */