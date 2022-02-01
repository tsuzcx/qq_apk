package com.tencent.thumbplayer.utils;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class TPNetworkChangeMonitor
  extends BroadcastReceiver
{
  private static final String DETAIL_WIFI_NETTYPE = "wifi";
  public static final int NETSTATUS_INAVAILABLE = 1;
  public static final int NETSTATUS_MOBILE = 3;
  public static final int NETSTATUS_NONE = 0;
  public static final int NETSTATUS_WIFI = 2;
  public static final int NETWORK_SUBTYPE_2G = 2;
  public static final int NETWORK_SUBTYPE_3G = 3;
  public static final int NETWORK_SUBTYPE_4G = 4;
  public static final int NETWORK_SUBTYPE_UNKNOWN = 0;
  public static final int NETWORK_SUBTYPE_WIFI = 1;
  private static final String TAG = "TPNetworkChangeMonitor";
  private static final String UNKNOWN_STR = "unknown";
  private static int lastNetStatus = mNetStatus;
  private static String mDetailNetworkType;
  private static String mLastDetailNetType;
  private static int mNetStatus = 0;
  private static int mobileNetSubType;
  private ArrayList<TPNetworkChangeMonitor.OnNetStatusChangeListener> mListeners = null;
  private HandlerThread mNetworkChangeInformThread;
  
  static
  {
    mDetailNetworkType = "unknown";
    mobileNetSubType = 0;
  }
  
  private TPNetworkChangeMonitor()
  {
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
  }
  
  private void dumpNetworkInfo()
  {
    TPLogUtil.d("TPNetworkChangeMonitor", "-->updateNetStatus(), mNetStatus=" + mNetStatus + "[wifi: " + 2 + ", mobile: " + 3 + "], lastNetStatus=" + lastNetStatus + ", mDetailNetworkType=" + mDetailNetworkType + ", mobileNetSubType=" + mobileNetSubType + "[2G:" + 2 + " 3G:" + 3 + " 4G:" + 4 + "], currentDetailNetType=" + mDetailNetworkType + ", lastDetailNetType=" + mLastDetailNetType);
  }
  
  public static int getDetailNetSubType()
  {
    return mobileNetSubType;
  }
  
  public static String getDetailNetworkType()
  {
    return mDetailNetworkType;
  }
  
  private String getDetailNetworkType(NetworkInfo paramNetworkInfo)
  {
    Object localObject = null;
    if (paramNetworkInfo != null) {}
    for (String str = paramNetworkInfo.getTypeName();; str = null)
    {
      TPLogUtil.d("TPNetworkChangeMonitor", "getDetailNetworkType, typeName: " + str);
      if (str == null) {
        break label247;
      }
      if (str.toLowerCase(Locale.getDefault()).equals("wifi")) {
        break label244;
      }
      str = paramNetworkInfo.getExtraInfo();
      paramNetworkInfo = localObject;
      if (str != null) {
        paramNetworkInfo = str.toLowerCase(Locale.getDefault());
      }
      if (paramNetworkInfo == null) {
        break label247;
      }
      if (!paramNetworkInfo.startsWith("cmwap")) {
        break;
      }
      return "cmwap";
    }
    if ((paramNetworkInfo.startsWith("cmnet")) || (paramNetworkInfo.startsWith("epc.tmobile.com"))) {
      return "cmnet";
    }
    if (paramNetworkInfo.startsWith("uniwap")) {
      return "uniwap";
    }
    if (paramNetworkInfo.startsWith("uninet")) {
      return "uninet";
    }
    if (paramNetworkInfo.startsWith("wap")) {
      return "wap";
    }
    if (paramNetworkInfo.startsWith("net")) {
      return "net";
    }
    if (paramNetworkInfo.startsWith("ctwap")) {
      return "ctwap";
    }
    if (paramNetworkInfo.startsWith("ctnet")) {
      return "ctnet";
    }
    if (paramNetworkInfo.startsWith("3gwap")) {
      return "3gwap";
    }
    if (paramNetworkInfo.startsWith("3gnet")) {
      return "3gnet";
    }
    if (paramNetworkInfo.startsWith("#777"))
    {
      paramNetworkInfo = Proxy.getDefaultHost();
      if ((paramNetworkInfo != null) && (paramNetworkInfo.length() > 0)) {
        return "ctwap";
      }
      return "ctnet";
    }
    return "unknown";
    label244:
    return "wifi";
    label247:
    return "unknown";
  }
  
  public static TPNetworkChangeMonitor getInstance()
  {
    return TPNetworkChangeMonitor.InstanceHolder.access$100();
  }
  
  @RequiresApi(api=3)
  private static int getMobileNetworkSubType(NetworkInfo paramNetworkInfo)
  {
    int j = 0;
    int i = j;
    if (paramNetworkInfo != null) {
      i = j;
    }
    switch (paramNetworkInfo.getSubtype())
    {
    default: 
      i = 3;
    case 0: 
      return i;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return 2;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return 3;
    }
    return 4;
  }
  
  public static int getNetworkStatus()
  {
    return mNetStatus;
  }
  
  public static String getSimpleNetTypeDesc()
  {
    String str2 = "unknown";
    String str1 = str2;
    if (!TextUtils.isEmpty(mDetailNetworkType))
    {
      if (!TextUtils.equals(mDetailNetworkType, "wifi")) {
        break label30;
      }
      str1 = "wifi";
    }
    label30:
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while ("unknown".equals(mDetailNetworkType));
      if (mobileNetSubType == 2) {
        return "2G";
      }
      if (mobileNetSubType == 3) {
        return "3G";
      }
      str1 = str2;
    } while (mobileNetSubType != 4);
    return "4G";
  }
  
  private static boolean isMainThread()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public static boolean isMobileNetwork()
  {
    return mNetStatus == 3;
  }
  
  public static boolean isNetStatusInited()
  {
    return mNetStatus != 0;
  }
  
  private boolean isNetworkActive(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo != null) && ((paramNetworkInfo.isConnected()) || (paramNetworkInfo.isConnectedOrConnecting()));
  }
  
  public static boolean isNetworkAvailable()
  {
    return mNetStatus != 1;
  }
  
  public static boolean isNetworkNoneStatus(int paramInt)
  {
    return paramInt == 0;
  }
  
  private boolean isTheSameNet(NetworkInfo paramNetworkInfo1, NetworkInfo paramNetworkInfo2)
  {
    return (paramNetworkInfo1 != null) && (paramNetworkInfo2 != null) && ((paramNetworkInfo1 == paramNetworkInfo2) || (((paramNetworkInfo1.isConnected()) || (paramNetworkInfo1.isConnectedOrConnecting())) && ((paramNetworkInfo2.isConnected()) || (paramNetworkInfo2.isConnectedOrConnecting()))));
  }
  
  public static boolean isWifiNetwork()
  {
    return mNetStatus == 2;
  }
  
  private void notifyIfNetChanged()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if ((mNetStatus != lastNetStatus) || (!TextUtils.equals(mDetailNetworkType, mLastDetailNetType))) {
          break label180;
        }
        TPLogUtil.i("TPNetworkChangeMonitor", "notifyIfNetChanged, isNetChanged: " + bool + ",  mListeners:  " + this.mListeners);
        TPLogUtil.i("TPNetworkChangeMonitor", "onNetworkStatusChanged oldNetStatus: " + lastNetStatus + ", netStatus: " + mNetStatus + ", mobileNetSubType" + mobileNetSubType);
        if (!bool) {
          break label177;
        }
        Iterator localIterator = this.mListeners.iterator();
        if (localIterator.hasNext())
        {
          ((TPNetworkChangeMonitor.OnNetStatusChangeListener)localIterator.next()).onStatusChanged(lastNetStatus, mNetStatus, 0, mobileNetSubType);
          continue;
        }
        lastNetStatus = mNetStatus;
      }
      finally {}
      mLastDetailNetType = mDetailNetworkType;
      label177:
      return;
      label180:
      bool = true;
    }
  }
  
  private void registerReceiver(Context paramContext, Handler paramHandler)
  {
    if (paramContext != null) {}
    try
    {
      paramContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, paramHandler);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private void unregisterReceiver(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      paramContext.unregisterReceiver(this);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        TPLogUtil.e("TPNetworkChangeMonitor", "unregister receiver may throw illegal state exception ...");
      }
    }
    finally {}
  }
  
  @SuppressLint({"MissingPermission"})
  @RequiresApi(api=3)
  private void updateNetStatus(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        NetworkInfo localNetworkInfo1 = paramContext.getNetworkInfo(0);
        NetworkInfo localNetworkInfo2 = paramContext.getNetworkInfo(1);
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext == null)
        {
          if (isNetworkActive(localNetworkInfo1))
          {
            mNetStatus = 3;
            paramContext = localNetworkInfo1;
          }
          for (;;)
          {
            switch (mNetStatus)
            {
            case 1: 
              label55:
              label84:
              mDetailNetworkType = getDetailNetworkType(paramContext);
              if (lastNetStatus == 0)
              {
                lastNetStatus = mNetStatus;
                mLastDetailNetType = mDetailNetworkType;
              }
              dumpNetworkInfo();
              notifyIfNetChanged();
              return;
              if (isNetworkActive(localNetworkInfo2))
              {
                mNetStatus = 2;
                paramContext = localNetworkInfo2;
              }
              else
              {
                mNetStatus = 1;
              }
              break;
            }
          }
        }
        if (isNetworkActive(paramContext)) {
          if (!isNetworkActive(localNetworkInfo1)) {
            break label210;
          }
        }
      }
      label210:
      for (int i = 3;; i = 2)
      {
        mNetStatus = i;
        break label55;
        mNetStatus = 1;
        break label55;
        mobileNetSubType = 0;
        break label84;
        mobileNetSubType = 1;
        break label84;
        mobileNetSubType = getMobileNetworkSubType(paramContext);
        break label84;
        break label84;
        return;
        paramContext = null;
        break;
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void addOnNetStatusChangeListener(TPNetworkChangeMonitor.OnNetStatusChangeListener paramOnNetStatusChangeListener)
  {
    try
    {
      if ((this.mListeners != null) && (!this.mListeners.contains(paramOnNetStatusChangeListener)))
      {
        this.mListeners.add(paramOnNetStatusChangeListener);
        TPLogUtil.d("TPNetworkChangeMonitor", "add onNetStatus change listener: " + paramOnNetStatusChangeListener + ", mListeners: " + this.mListeners.size());
      }
      return;
    }
    finally
    {
      paramOnNetStatusChangeListener = finally;
      throw paramOnNetStatusChangeListener;
    }
  }
  
  public void init(Context paramContext)
  {
    try
    {
      TPCommonUtils.requireNotNull(paramContext, "context can not be null!");
      if (this.mNetworkChangeInformThread == null)
      {
        this.mNetworkChangeInformThread = new HandlerThread("TP_NetInform");
        this.mNetworkChangeInformThread.start();
      }
      registerReceiver(paramContext, new Handler(this.mNetworkChangeInformThread.getLooper()));
      updateNetStatus(paramContext);
      return;
    }
    finally {}
  }
  
  public boolean isCurrentUnicomWap()
  {
    return ("3gwap".equals(mDetailNetworkType)) || ("uniwap".equals(mDetailNetworkType));
  }
  
  public boolean isNonUnicomMobileNetwork()
  {
    return ("cmnet".equals(mDetailNetworkType)) || ("cmwap".equals(mDetailNetworkType)) || ("ctnet".equals(mDetailNetworkType)) || ("ctwap".equals(mDetailNetworkType));
  }
  
  public boolean isUnicomMobileNetwork()
  {
    return ("3gnet".equals(mDetailNetworkType)) || ("cmnet".equals(mDetailNetworkType));
  }
  
  @RequiresApi(api=3)
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onReceive broadcast action and update net status,onReceive broadcast in ");
    if (isMainThread()) {}
    for (paramIntent = "main";; paramIntent = "work")
    {
      TPLogUtil.d("TPNetworkChangeMonitor", paramIntent + " thread.");
      updateNetStatus(paramContext);
      return;
    }
  }
  
  public void release(Context paramContext)
  {
    try
    {
      TPCommonUtils.requireNotNull(paramContext, "context can not be null!");
      unregisterReceiver(paramContext);
      if (this.mNetworkChangeInformThread != null)
      {
        this.mNetworkChangeInformThread.quit();
        this.mNetworkChangeInformThread = null;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void removeOnNetStatusChangeListener(TPNetworkChangeMonitor.OnNetStatusChangeListener paramOnNetStatusChangeListener)
  {
    try
    {
      if (this.mListeners != null)
      {
        this.mListeners.remove(paramOnNetStatusChangeListener);
        TPLogUtil.d("TPNetworkChangeMonitor", "remove netStatusChangeListener, listener: " + paramOnNetStatusChangeListener + ", mListeners: " + this.mListeners.size());
      }
      return;
    }
    finally
    {
      paramOnNetStatusChangeListener = finally;
      throw paramOnNetStatusChangeListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPNetworkChangeMonitor
 * JD-Core Version:    0.7.0.1
 */