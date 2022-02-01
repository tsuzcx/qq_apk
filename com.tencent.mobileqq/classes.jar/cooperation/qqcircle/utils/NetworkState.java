package cooperation.qqcircle.utils;

import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.PlatformInfor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

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
  private static List<NetworkState.NetworkStateListener> observers;
  private static String providerName;
  public static long uin = -1L;
  
  static
  {
    providerName = null;
    observers = new ArrayList();
    netEventHandler = new NetworkState.1();
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
    localStringBuffer.append(paramInt & 0xFF);
    localStringBuffer.append(".");
    localStringBuffer.append(paramInt >> 8 & 0xFF);
    localStringBuffer.append(".");
    localStringBuffer.append(paramInt >> 16 & 0xFF);
    localStringBuffer.append(".");
    localStringBuffer.append(paramInt >> 24 & 0xFF);
    return localStringBuffer.toString();
  }
  
  public static void addListener(NetworkState.NetworkStateListener paramNetworkStateListener)
  {
    if (paramNetworkStateListener == null) {
      return;
    }
    synchronized (observers)
    {
      if (!observers.contains(paramNetworkStateListener)) {
        observers.add(paramNetworkStateListener);
      }
      return;
    }
  }
  
  public static void clearConfigCache()
  {
    Map localMap = map;
    if (localMap != null) {
      localMap.clear();
    }
  }
  
  @Deprecated
  public static void forceNotifyNetworkChangeForDebugVersion()
  {
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion())
    {
      boolean bool = isNetSupport();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("forceNotifyNetworkChangeForDebugVersion 强制通知网络状态有变化，仅debug版本可用 hasNet=");
      localStringBuilder.append(bool);
      QLog.i("NetworkState", 4, localStringBuilder.toString());
      netEventHandler.onNetChangeEvent(bool);
    }
  }
  
  public static String getAPN()
  {
    if (AppNetConnInfo.isWifiConn()) {
      return "wifi";
    }
    String str2 = AppNetConnInfo.getCurrentAPN();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "unknown";
    }
    return str1;
  }
  
  public static int getApnValue()
  {
    if (!AppNetConnInfo.isNetSupport()) {
      return 0;
    }
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo == null) {
      return 0;
    }
    if (!localNetworkInfo.isConnectedOrConnecting()) {
      return 0;
    }
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
      return 0;
    case 8: 
    case 9: 
    case 12: 
      return 3;
    case 7: 
      return 4;
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 11: 
      return 2;
    }
    return 1;
  }
  
  public static boolean getConfigIsForceWifiTo4g()
  {
    uin = MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
    if (map.get(Long.valueOf(uin)) != null) {
      return ((Boolean)map.get(Long.valueOf(uin))).booleanValue();
    }
    int i = LocalMultiProcConfig.getInt4Uin("key_force_wifi_to_4g", 0, uin);
    boolean bool = true;
    if (1 != i) {
      bool = false;
    }
    map.put(Long.valueOf(uin), Boolean.valueOf(bool));
    return bool;
  }
  
  private static boolean getIsMobileForDebugVersion()
  {
    try
    {
      if (!isNetSupport()) {
        return false;
      }
      if (!AppNetConnInfo.isWifiConn()) {
        return true;
      }
      boolean bool = getConfigIsForceWifiTo4g();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("NetworkState", 1, "getIsMobileForDebugVersion error", localException);
    }
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean getIsUnicomNetWork()
  {
    String str = getAPN();
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return (str.equalsIgnoreCase("UNIWAP")) || (str.equalsIgnoreCase("UNINET")) || (str.equalsIgnoreCase("3GWAP")) || (str.equalsIgnoreCase("3GNET")) || (str.equalsIgnoreCase("WONET"));
  }
  
  private static boolean getIsWifiForDebugVersion()
  {
    if (!isNetSupport()) {
      return false;
    }
    return !getIsMobileForDebugVersion();
  }
  
  public static int getNetworkType()
  {
    boolean bool = AppNetConnInfo.isWifiConn();
    int i = 4;
    if (bool) {
      return 1;
    }
    if (AppNetConnInfo.isMobileConn())
    {
      int j = AppNetConnInfo.getMobileInfo();
      if (j != 1)
      {
        if (j != 2)
        {
          if (j == 3) {
            return i;
          }
          if (j == 4) {
            return 5;
          }
        }
        else
        {
          return 3;
        }
      }
      else {
        return 2;
      }
    }
    i = 0;
    return i;
  }
  
  public static String getProviderName()
  {
    if (TextUtils.isEmpty(providerName))
    {
      String str = PlatformInfor.g().getIMSI();
      if ((str != null) && (!"".equals(str)))
      {
        if ((!str.startsWith("46000")) && (!str.startsWith("46002")))
        {
          if (str.startsWith("46001")) {
            providerName = "ChinaUnicom";
          } else if (str.startsWith("46003")) {
            providerName = "ChinaTelecom";
          } else {
            providerName = "unknown";
          }
        }
        else {
          providerName = "ChinaMobile";
        }
      }
      else {
        providerName = "unknown";
      }
    }
    return providerName;
  }
  
  public static boolean isMobile()
  {
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
      return getIsMobileForDebugVersion();
    }
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
      int i = 5;
      try
      {
        int j = ((Integer)mApnMap.get(AppNetConnInfo.getCurrentAPN())).intValue();
        i = j;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      switch (i)
      {
      default: 
        return false;
      case 2: 
      case 4: 
      case 6: 
      case 8: 
        return true;
      }
    }
    return false;
  }
  
  public static boolean isWifiConn()
  {
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
      return getIsWifiForDebugVersion();
    }
    return AppNetConnInfo.isWifiConn();
  }
  
  private static void notifyObservers(boolean paramBoolean)
  {
    synchronized (observers)
    {
      NetworkState.NetworkStateListener[] arrayOfNetworkStateListener = new NetworkState.NetworkStateListener[observers.size()];
      observers.toArray(arrayOfNetworkStateListener);
      int j = arrayOfNetworkStateListener.length;
      int i = 0;
      while (i < j)
      {
        arrayOfNetworkStateListener[i].onNetworkConnect(paramBoolean);
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw localObject;
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
  
  public static void removeListener(NetworkState.NetworkStateListener paramNetworkStateListener)
  {
    synchronized (observers)
    {
      observers.remove(paramNetworkStateListener);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.utils.NetworkState
 * JD-Core Version:    0.7.0.1
 */