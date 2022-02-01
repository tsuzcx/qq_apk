package cooperation.qzone.util;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.qphone.base.util.BaseApplication;

public class WiFiDash
{
  public static final String EMPTY = "";
  public static final String NOT_AVALIBLE = "N/A";
  static volatile String currBSSID = null;
  
  public static String getBSSID()
  {
    if (currBSSID == null) {}
    try
    {
      if (currBSSID == null) {
        updateBSSID();
      }
      if (("N/A".equals(currBSSID)) || ("00:00:00:00:00:00".equals(currBSSID)) || ("FF:FF:FF:FF:FF:FF".equalsIgnoreCase(currBSSID))) {
        return null;
      }
    }
    finally {}
    return currBSSID;
  }
  
  public static int getSignalLevel()
  {
    Object localObject = queryWifiInfo("N/A");
    if (localObject == "N/A") {
      return -1;
    }
    return WifiManager.calculateSignalLevel(((WifiInfo)localObject).getRssi(), 5);
  }
  
  public static String getWifiInfo()
  {
    Object localObject = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (localObject == null) {
      return "[-]";
    }
    try
    {
      localObject = ((WifiManager)localObject).getConnectionInfo();
      if (localObject == null) {
        return "[-]";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        str1 = null;
      }
      String str2 = str1.getSSID();
      int i = WifiManager.calculateSignalLevel(str1.getRssi(), 5);
      String str1 = String.valueOf(str1.getLinkSpeed()) + " " + "Mbps";
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append('[').append(String.valueOf(i)).append(", ").append(str2).append(", ").append(str1).append(']');
      return localStringBuffer.toString();
    }
  }
  
  private static Object queryWifiInfo(Object paramObject)
  {
    Object localObject1 = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (localObject1 == null) {}
    for (;;)
    {
      return paramObject;
      try
      {
        localObject1 = ((WifiManager)localObject1).getConnectionInfo();
        if (localObject1 == null) {
          continue;
        }
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
    }
  }
  
  public static String updateBSSID()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = queryWifiInfo("N/A");
        if (localObject1 != "N/A")
        {
          String str = ((WifiInfo)localObject1).getBSSID();
          localObject1 = str;
          if (str == null) {
            localObject1 = "N/A";
          }
          currBSSID = (String)localObject1;
          return localObject1;
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.WiFiDash
 * JD-Core Version:    0.7.0.1
 */