package cooperation.qzone.util;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class WiFiDash
{
  public static final String EMPTY = "";
  public static final String NOT_AVALIBLE = "N/A";
  static volatile String currBSSID;
  
  public static String getBSSID()
  {
    if (currBSSID == null) {
      try
      {
        if (currBSSID == null) {
          updateBSSID();
        }
      }
      finally {}
    }
    if ((!"N/A".equals(currBSSID)) && (!"00:00:00:00:00:00".equals(currBSSID)) && (!"FF:FF:FF:FF:FF:FF".equalsIgnoreCase(currBSSID))) {
      return currBSSID;
    }
    return null;
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
    Object localObject1 = (WifiManager)MobileQQ.getContext().getSystemService("wifi");
    if (localObject1 == null) {
      return "[-]";
    }
    try
    {
      localObject1 = NetworkMonitor.getConnectionInfo((WifiManager)localObject1);
    }
    catch (Exception localException)
    {
      label27:
      String str;
      int i;
      Object localObject2;
      break label27;
    }
    localObject1 = null;
    if (localObject1 == null) {
      return "[-]";
    }
    str = ((WifiInfo)localObject1).getSSID();
    i = WifiManager.calculateSignalLevel(((WifiInfo)localObject1).getRssi(), 5);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(String.valueOf(((WifiInfo)localObject1).getLinkSpeed()));
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append("Mbps");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append('[');
    ((StringBuffer)localObject2).append(String.valueOf(i));
    ((StringBuffer)localObject2).append(", ");
    ((StringBuffer)localObject2).append(str);
    ((StringBuffer)localObject2).append(", ");
    ((StringBuffer)localObject2).append((String)localObject1);
    ((StringBuffer)localObject2).append(']');
    return ((StringBuffer)localObject2).toString();
  }
  
  private static Object queryWifiInfo(Object paramObject)
  {
    Object localObject = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (localObject == null) {
      return paramObject;
    }
    try
    {
      localObject = NetworkMonitor.getConnectionInfo((WifiManager)localObject);
    }
    catch (Exception localException)
    {
      label26:
      break label26;
    }
    localObject = null;
    if (localObject == null) {
      return paramObject;
    }
    return localObject;
  }
  
  public static String updateBSSID()
  {
    try
    {
      Object localObject3 = queryWifiInfo("N/A");
      Object localObject1 = null;
      if (localObject3 != "N/A")
      {
        localObject3 = ((WifiInfo)localObject3).getBSSID();
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "N/A";
        }
      }
      currBSSID = (String)localObject1;
      return localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.WiFiDash
 * JD-Core Version:    0.7.0.1
 */