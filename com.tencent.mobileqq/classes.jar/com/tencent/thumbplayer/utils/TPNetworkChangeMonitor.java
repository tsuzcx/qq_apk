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
  private static String mDetailNetworkType = "unknown";
  private static String mLastDetailNetType;
  private static int mNetStatus;
  private static int mobileNetSubType;
  private ArrayList<TPNetworkChangeMonitor.OnNetStatusChangeListener> mListeners = null;
  private HandlerThread mNetworkChangeInformThread;
  
  private TPNetworkChangeMonitor()
  {
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
  }
  
  private void dumpNetworkInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-->updateNetStatus(), mNetStatus=");
    localStringBuilder.append(mNetStatus);
    localStringBuilder.append("[wifi: ");
    localStringBuilder.append(2);
    localStringBuilder.append(", mobile: ");
    localStringBuilder.append(3);
    localStringBuilder.append("], lastNetStatus=");
    localStringBuilder.append(lastNetStatus);
    localStringBuilder.append(", mDetailNetworkType=");
    localStringBuilder.append(mDetailNetworkType);
    localStringBuilder.append(", mobileNetSubType=");
    localStringBuilder.append(mobileNetSubType);
    localStringBuilder.append("[2G:");
    localStringBuilder.append(2);
    localStringBuilder.append(" 3G:");
    localStringBuilder.append(3);
    localStringBuilder.append(" 4G:");
    localStringBuilder.append(4);
    localStringBuilder.append("], currentDetailNetType=");
    localStringBuilder.append(mDetailNetworkType);
    localStringBuilder.append(", lastDetailNetType=");
    localStringBuilder.append(mLastDetailNetType);
    TPLogUtil.d("TPNetworkChangeMonitor", localStringBuilder.toString());
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
    Object localObject2 = null;
    String str;
    if (paramNetworkInfo != null) {
      str = paramNetworkInfo.getTypeName();
    } else {
      str = null;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getDetailNetworkType, typeName: ");
    ((StringBuilder)localObject1).append(str);
    TPLogUtil.d("TPNetworkChangeMonitor", ((StringBuilder)localObject1).toString());
    localObject1 = "wifi";
    if (str != null)
    {
      if (str.toLowerCase(Locale.getDefault()).equals("wifi")) {
        return localObject1;
      }
      str = paramNetworkInfo.getExtraInfo();
      paramNetworkInfo = localObject2;
      if (str != null) {
        paramNetworkInfo = str.toLowerCase(Locale.getDefault());
      }
      str = "ctnet";
      if (paramNetworkInfo != null)
      {
        if (paramNetworkInfo.startsWith("cmwap")) {
          return "cmwap";
        }
        if ((!paramNetworkInfo.startsWith("cmnet")) && (!paramNetworkInfo.startsWith("epc.tmobile.com")))
        {
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
            paramNetworkInfo = str;
          }
          for (;;)
          {
            return paramNetworkInfo;
            if (paramNetworkInfo.startsWith("3gwap")) {
              return "3gwap";
            }
            if (paramNetworkInfo.startsWith("3gnet")) {
              return "3gnet";
            }
            if (!paramNetworkInfo.startsWith("#777")) {
              break;
            }
            localObject1 = Proxy.getDefaultHost();
            paramNetworkInfo = str;
            if (localObject1 != null)
            {
              paramNetworkInfo = str;
              if (((String)localObject1).length() > 0) {
                paramNetworkInfo = "ctwap";
              }
            }
          }
        }
        return "cmnet";
      }
    }
    localObject1 = "unknown";
    return localObject1;
  }
  
  public static TPNetworkChangeMonitor getInstance()
  {
    return TPNetworkChangeMonitor.InstanceHolder.access$100();
  }
  
  @RequiresApi(api=3)
  private static int getMobileNetworkSubType(NetworkInfo paramNetworkInfo)
  {
    int i = 3;
    if (paramNetworkInfo != null) {}
    switch (paramNetworkInfo.getSubtype())
    {
    default: 
      return 3;
    case 13: 
      return 4;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return 2;
    case 0: 
      i = 0;
    }
    return i;
  }
  
  public static int getNetworkStatus()
  {
    return mNetStatus;
  }
  
  public static String getSimpleNetTypeDesc()
  {
    if (!TextUtils.isEmpty(mDetailNetworkType))
    {
      if (TextUtils.equals(mDetailNetworkType, "wifi")) {
        return "wifi";
      }
      if (!"unknown".equals(mDetailNetworkType))
      {
        int i = mobileNetSubType;
        if (i == 2) {
          return "2G";
        }
        if (i == 3) {
          return "3G";
        }
        if (i == 4) {
          return "4G";
        }
      }
    }
    return "unknown";
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
    try
    {
      if (mNetStatus != lastNetStatus) {
        break label213;
      }
      if (TextUtils.equals(mDetailNetworkType, mLastDetailNetType)) {
        break label208;
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        for (;;)
        {
          throw localObject2;
        }
        label208:
        boolean bool = false;
        continue;
        label213:
        bool = true;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("notifyIfNetChanged, isNetChanged: ");
    ((StringBuilder)localObject1).append(bool);
    ((StringBuilder)localObject1).append(",  mListeners:  ");
    ((StringBuilder)localObject1).append(this.mListeners);
    TPLogUtil.i("TPNetworkChangeMonitor", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onNetworkStatusChanged oldNetStatus: ");
    ((StringBuilder)localObject1).append(lastNetStatus);
    ((StringBuilder)localObject1).append(", netStatus: ");
    ((StringBuilder)localObject1).append(mNetStatus);
    ((StringBuilder)localObject1).append(", mobileNetSubType");
    ((StringBuilder)localObject1).append(mobileNetSubType);
    TPLogUtil.i("TPNetworkChangeMonitor", ((StringBuilder)localObject1).toString());
    if (bool)
    {
      localObject1 = this.mListeners.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((TPNetworkChangeMonitor.OnNetStatusChangeListener)((Iterator)localObject1).next()).onStatusChanged(lastNetStatus, mNetStatus, 0, mobileNetSubType);
      }
      lastNetStatus = mNetStatus;
      mLastDetailNetType = mDetailNetworkType;
    }
  }
  
  private void registerReceiver(Context paramContext, Handler paramHandler)
  {
    if (paramContext != null) {}
    try
    {
      paramContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, paramHandler);
    }
    finally {}
  }
  
  private void unregisterReceiver(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      try
      {
        paramContext.unregisterReceiver(this);
      }
      finally
      {
        break label29;
      }
    }
    catch (Exception paramContext)
    {
      label18:
      break label18;
    }
    TPLogUtil.e("TPNetworkChangeMonitor", "unregister receiver may throw illegal state exception ...");
    break label33;
    label29:
    throw paramContext;
    label33:
  }
  
  @SuppressLint({"MissingPermission"})
  @RequiresApi(api=3)
  private void updateNetStatus(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
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
            else if (isNetworkActive(localNetworkInfo2))
            {
              mNetStatus = 2;
              paramContext = localNetworkInfo2;
            }
            else
            {
              mNetStatus = 1;
            }
          }
          else if (isNetworkActive(paramContext))
          {
            if (!isNetworkActive(localNetworkInfo1)) {
              break label204;
            }
            i = 3;
            mNetStatus = i;
          }
          else
          {
            mNetStatus = 1;
          }
          i = mNetStatus;
          if (i != 1)
          {
            if (i != 2)
            {
              if (i == 3) {
                mobileNetSubType = getMobileNetworkSubType(paramContext);
              }
            }
            else {
              mobileNetSubType = 1;
            }
          }
          else {
            mobileNetSubType = 0;
          }
          mDetailNetworkType = getDetailNetworkType(paramContext);
          if (lastNetStatus == 0)
          {
            lastNetStatus = mNetStatus;
            mLastDetailNetType = mDetailNetworkType;
          }
          dumpNetworkInfo();
          notifyIfNetChanged();
        }
        return;
      }
      catch (Exception paramContext)
      {
        return;
      }
      paramContext = null;
      continue;
      label204:
      int i = 2;
    }
  }
  
  public void addOnNetStatusChangeListener(TPNetworkChangeMonitor.OnNetStatusChangeListener paramOnNetStatusChangeListener)
  {
    try
    {
      if ((this.mListeners != null) && (!this.mListeners.contains(paramOnNetStatusChangeListener)))
      {
        this.mListeners.add(paramOnNetStatusChangeListener);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("add onNetStatus change listener: ");
        localStringBuilder.append(paramOnNetStatusChangeListener);
        localStringBuilder.append(", mListeners: ");
        localStringBuilder.append(this.mListeners.size());
        TPLogUtil.d("TPNetworkChangeMonitor", localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceive broadcast action and update net status,onReceive broadcast in ");
    if (isMainThread()) {
      paramIntent = "main";
    } else {
      paramIntent = "work";
    }
    localStringBuilder.append(paramIntent);
    localStringBuilder.append(" thread.");
    TPLogUtil.d("TPNetworkChangeMonitor", localStringBuilder.toString());
    updateNetStatus(paramContext);
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("remove netStatusChangeListener, listener: ");
        localStringBuilder.append(paramOnNetStatusChangeListener);
        localStringBuilder.append(", mListeners: ");
        localStringBuilder.append(this.mListeners.size());
        TPLogUtil.d("TPNetworkChangeMonitor", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPNetworkChangeMonitor
 * JD-Core Version:    0.7.0.1
 */