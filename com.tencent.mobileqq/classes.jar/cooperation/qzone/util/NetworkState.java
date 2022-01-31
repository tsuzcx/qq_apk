package cooperation.qzone.util;

import android.net.NetworkInfo;
import android.text.TextUtils;
import bize;
import bjqd;
import bjqe;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class NetworkState
{
  public static final int NET_TYPE_2G = 2;
  public static final int NET_TYPE_3G = 3;
  public static final int NET_TYPE_4G = 4;
  public static final int NET_TYPE_5G = 5;
  public static final int NET_TYPE_UNKNOWN = 0;
  public static final int NET_TYPE_WIFI = 1;
  public static final String SP_KEY_FLAG_FORCE_WIFI_TO_4G = "key_force_wifi_to_4g";
  private static final String TAG = "NetworkState";
  public static final int VALUE_FLAG_FORCE_WIFI_TO_4G_DEFAULT = 0;
  public static final int VALUE_FLAG_FORCE_WIFI_TO_4G_NO = 0;
  public static final int VALUE_FLAG_FORCE_WIFI_TO_4G_YES = 1;
  private static Map<String, Integer> mApnMap = new HashMap();
  private static Map<Long, Boolean> map = new HashMap();
  private static INetEventHandler netEventHandler;
  private static List<bjqe> observers;
  private static String providerName;
  public static long uin = -1L;
  
  static
  {
    observers = new ArrayList();
    netEventHandler = new bjqd();
    mApnMap.put("unknown", Integer.valueOf(0));
    mApnMap.put("cmnet", Integer.valueOf(1));
    mApnMap.put("cmwap", Integer.valueOf(2));
    mApnMap.put("3gnet", Integer.valueOf(3));
    mApnMap.put("3gwap", Integer.valueOf(4));
    mApnMap.put("uninet", Integer.valueOf(5));
    mApnMap.put("uniwap", Integer.valueOf(6));
    mApnMap.put("wifi", Integer.valueOf(7));
    mApnMap.put("ctwap", Integer.valueOf(8));
    mApnMap.put("ctnet", Integer.valueOf(9));
    mApnMap.put("cmcc", Integer.valueOf(10));
    mApnMap.put("unicom", Integer.valueOf(11));
    mApnMap.put("cmct", Integer.valueOf(12));
    registerReceiver();
  }
  
  public static String IntAddr2Ip(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt & 0xFF).append(".").append(paramInt >> 8 & 0xFF).append(".").append(paramInt >> 16 & 0xFF).append(".").append(paramInt >> 24 & 0xFF);
    return localStringBuffer.toString();
  }
  
  public static void addListener(bjqe parambjqe)
  {
    if (parambjqe == null) {
      return;
    }
    synchronized (observers)
    {
      if (!observers.contains(parambjqe)) {
        observers.add(parambjqe);
      }
      return;
    }
  }
  
  public static void clearConfigCache()
  {
    if (map != null) {
      map.clear();
    }
  }
  
  @Deprecated
  public static void forceNotifyNetworkChangeForDebugVersion() {}
  
  public static String getAPN()
  {
    Object localObject;
    if (AppNetConnInfo.isWifiConn()) {
      localObject = "wifi";
    }
    String str;
    do
    {
      return localObject;
      str = AppNetConnInfo.getCurrentAPN();
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return "unknown";
  }
  
  public static int getApnValue()
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    NetworkInfo localNetworkInfo;
    do
    {
      return 0;
      localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    } while ((localNetworkInfo == null) || (!localNetworkInfo.isConnectedOrConnecting()));
    if (1 == localNetworkInfo.getType()) {
      return 4;
    }
    int i = 5;
    if (mApnMap.get(localNetworkInfo.getExtraInfo()) != null) {
      i = ((Integer)mApnMap.get(localNetworkInfo.getExtraInfo())).intValue();
    }
    switch (i)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      return i;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
  
  public static boolean getConfigIsForceWifiTo4g()
  {
    boolean bool = true;
    uin = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    if (map.get(Long.valueOf(uin)) != null) {
      return ((Boolean)map.get(Long.valueOf(uin))).booleanValue();
    }
    if (1 == LocalMultiProcConfig.getInt4Uin("key_force_wifi_to_4g", 0, uin)) {}
    for (;;)
    {
      map.put(Long.valueOf(uin), Boolean.valueOf(bool));
      return bool;
      bool = false;
    }
  }
  
  private static boolean getIsMobileForDebugVersion()
  {
    boolean bool1 = false;
    try
    {
      if (!isNetSupport()) {
        return false;
      }
      if (!AppNetConnInfo.isWifiConn()) {
        return true;
      }
      boolean bool2 = getConfigIsForceWifiTo4g();
      if (bool2) {
        return true;
      }
    }
    catch (Exception localException)
    {
      QZLog.e("NetworkState", "getIsMobileForDebugVersion error", localException);
      bool1 = AppNetConnInfo.isMobileConn();
    }
    return bool1;
  }
  
  public static boolean getIsUnicomNetWork()
  {
    String str = getAPN();
    if (TextUtils.isEmpty(str)) {}
    while ((!str.equalsIgnoreCase("UNIWAP")) && (!str.equalsIgnoreCase("UNINET")) && (!str.equalsIgnoreCase("3GWAP")) && (!str.equalsIgnoreCase("3GNET")) && (!str.equalsIgnoreCase("WONET"))) {
      return false;
    }
    return true;
  }
  
  private static boolean getIsWifiForDebugVersion()
  {
    if (!isNetSupport()) {}
    while (getIsMobileForDebugVersion()) {
      return false;
    }
    return true;
  }
  
  public static int getNetworkType()
  {
    int i = 0;
    if (AppNetConnInfo.isWifiConn()) {
      i = 1;
    }
    while (!AppNetConnInfo.isMobileConn()) {
      return i;
    }
    switch (AppNetConnInfo.getMobileInfo())
    {
    default: 
      return 0;
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    }
    return 5;
  }
  
  public static String getProviderName()
  {
    String str;
    if (TextUtils.isEmpty(providerName))
    {
      str = bize.a().b();
      if ((str != null) && (!"".equals(str))) {
        break label39;
      }
      providerName = "unknown";
    }
    for (;;)
    {
      return providerName;
      label39:
      if ((str.startsWith("46000")) || (str.startsWith("46002"))) {
        providerName = "ChinaMobile";
      } else if (str.startsWith("46001")) {
        providerName = "ChinaUnicom";
      } else if (str.startsWith("46003")) {
        providerName = "ChinaTelecom";
      } else {
        providerName = "unknown";
      }
    }
  }
  
  public static boolean isMobile()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean isNetSupport()
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public static boolean isWap()
  {
    if (AppNetConnInfo.isMobileConn())
    {
      try
      {
        i = ((Integer)mApnMap.get(AppNetConnInfo.getCurrentAPN())).intValue();
        switch (i)
        {
        default: 
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          int i = 5;
        }
        return true;
      }
      return false;
    }
    return false;
  }
  
  public static boolean isWifiConn()
  {
    return AppNetConnInfo.isWifiConn();
  }
  
  private static void notifyObservers(boolean paramBoolean)
  {
    synchronized (observers)
    {
      bjqe[] arrayOfbjqe = new bjqe[observers.size()];
      observers.toArray(arrayOfbjqe);
      if (arrayOfbjqe != null)
      {
        int j = arrayOfbjqe.length;
        int i = 0;
        if (i < j)
        {
          arrayOfbjqe[i].onNetworkConnect(paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  public static void registerReceiver()
  {
    try
    {
      AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), netEventHandler);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void removeListener(bjqe parambjqe)
  {
    synchronized (observers)
    {
      observers.remove(parambjqe);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qzone.util.NetworkState
 * JD-Core Version:    0.7.0.1
 */