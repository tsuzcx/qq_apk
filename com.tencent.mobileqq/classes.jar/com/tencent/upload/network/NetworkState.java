package com.tencent.upload.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.base.ConnectionImpl;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.utils.UploadLog;
import java.util.ArrayList;
import java.util.List;

public class NetworkState
  extends BroadcastReceiver
{
  public static final int IP_STACK_DUAL = 3;
  public static final int IP_STACK_IPV4 = 1;
  public static final int IP_STACK_IPV6 = 2;
  public static final int IP_STACK_NONE = 0;
  public static final int NETWORK_TYPE_2G = 3;
  public static final int NETWORK_TYPE_3G = 2;
  public static final int NETWORK_TYPE_4G = 6;
  public static final int NETWORK_TYPE_UNKNOWN = 0;
  public static final int NETWORK_TYPE_WIFI = 1;
  private static final String TAG = "NetworkState";
  private static NetworkState instance;
  private static int networkType;
  private String apn = "none";
  private Context context = null;
  private boolean loadProviderName = false;
  private List<NetworkState.NetworkStateListener> observers = new ArrayList();
  private String providerName = null;
  
  public static NetworkState getInstance()
  {
    if (instance == null) {
      instance = new NetworkState();
    }
    return instance;
  }
  
  public static int getNetworkStackType()
  {
    if (!ConnectionImpl.isLibraryPrepared()) {
      return 1;
    }
    return ConnectionImpl.getIpStack();
  }
  
  public static int getNetworkStackTypeInner()
  {
    if (UploadGlobalConfig.getConfig() == null) {
      return 1;
    }
    if (!UploadGlobalConfig.getConfig().enableV6Route()) {
      return 1;
    }
    return getNetworkStackType();
  }
  
  private static int getNetworkType(NetworkInfo paramNetworkInfo)
  {
    int i = paramNetworkInfo.getType();
    if (i != 0)
    {
      if (i != 1) {
        networkType = 0;
      } else {
        networkType = 1;
      }
    }
    else {
      switch (paramNetworkInfo.getSubtype())
      {
      default: 
        break;
      case 13: 
        networkType = 6;
        break;
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 14: 
      case 15: 
        networkType = 2;
        break;
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        networkType = 3;
      }
    }
    return networkType;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    Object localObject = null;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      paramContext = localObject;
      if (localConnectivityManager != null) {
        paramContext = localConnectivityManager.getActiveNetworkInfo();
      }
      if (paramContext != null)
      {
        boolean bool = paramContext.isConnected();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramContext) {}
    return true;
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    for (;;)
    {
      int j;
      int i;
      NetworkInfo localNetworkInfo;
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext == null) {
          return false;
        }
        paramContext = paramContext.getAllNetworkInfo();
        if (paramContext != null)
        {
          j = paramContext.length;
          i = 0;
          break label68;
          if (localNetworkInfo.isConnectedOrConnecting())
          {
            getNetworkType(localNetworkInfo);
            return true;
          }
          i += 1;
        }
        else
        {
          return false;
        }
      }
      catch (SecurityException paramContext)
      {
        return true;
      }
      catch (Throwable paramContext)
      {
        return false;
      }
      label68:
      if (i < j)
      {
        localNetworkInfo = paramContext[i];
        if (localNetworkInfo != null) {}
      }
    }
  }
  
  private void notifyApnChanged(boolean paramBoolean)
  {
    synchronized (this.observers)
    {
      NetworkState.NetworkStateListener[] arrayOfNetworkStateListener = new NetworkState.NetworkStateListener[this.observers.size()];
      this.observers.toArray(arrayOfNetworkStateListener);
      int j = arrayOfNetworkStateListener.length;
      int i = 0;
      while (i < j)
      {
        arrayOfNetworkStateListener[i].onNetworkApnChanged(paramBoolean);
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void notifyObservers(boolean paramBoolean)
  {
    synchronized (this.observers)
    {
      NetworkState.NetworkStateListener[] arrayOfNetworkStateListener = new NetworkState.NetworkStateListener[this.observers.size()];
      this.observers.toArray(arrayOfNetworkStateListener);
      int j = arrayOfNetworkStateListener.length;
      int i = 0;
      while (i < j)
      {
        arrayOfNetworkStateListener[i].onNetworkConnected(paramBoolean);
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void addListener(NetworkState.NetworkStateListener paramNetworkStateListener)
  {
    if (paramNetworkStateListener == null) {
      return;
    }
    synchronized (this.observers)
    {
      if (!this.observers.contains(paramNetworkStateListener)) {
        this.observers.add(paramNetworkStateListener);
      }
      return;
    }
  }
  
  public String getApnName()
  {
    return this.apn;
  }
  
  public String getApnValue()
  {
    String str = "unknown";
    Object localObject = this.context;
    if (localObject == null) {
      return "none";
    }
    NetworkInfo localNetworkInfo = null;
    try
    {
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if (localObject != null) {
        localNetworkInfo = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      }
      if (localNetworkInfo != null)
      {
        if (!localNetworkInfo.isConnected()) {
          return "none";
        }
        if (1 == localNetworkInfo.getType()) {
          return "wifi";
        }
        if (localNetworkInfo.getExtraInfo() != null) {
          str = localNetworkInfo.getExtraInfo().toLowerCase();
        }
        return str;
      }
      return "none";
    }
    catch (Throwable localThrowable) {}
    return "unknown";
  }
  
  public int getNetworkType()
  {
    return networkType;
  }
  
  public String getProviderName()
  {
    Object localObject2;
    Object localObject1;
    if (!this.loadProviderName)
    {
      this.loadProviderName = true;
      localObject2 = (TelephonyManager)this.context.getSystemService("phone");
      localObject1 = null;
    }
    try
    {
      localObject2 = ((TelephonyManager)localObject2).getSubscriberId();
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      label34:
      break label34;
    }
    if ((localObject1 != null) && (!"".equals(localObject1)))
    {
      if ((!localObject1.startsWith("46000")) && (!localObject1.startsWith("46002")))
      {
        if (localObject1.startsWith("46001")) {
          this.providerName = "ChinaUnicom";
        } else if (localObject1.startsWith("46003")) {
          this.providerName = "ChinaTelecom";
        } else {
          this.providerName = "unknown";
        }
      }
      else {
        this.providerName = "ChinaMobile";
      }
    }
    else {
      this.providerName = "unknown";
    }
    return this.providerName;
  }
  
  public boolean isNetworkAvailable()
  {
    Object localObject2 = this.context;
    if (localObject2 == null) {
      return true;
    }
    Object localObject1 = null;
    try
    {
      localObject2 = ((ConnectivityManager)((Context)localObject2).getSystemService("connectivity")).getActiveNetworkInfo();
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      UploadLog.e("NetworkState", "fail to get active network info", localThrowable);
    }
    if (localObject1 == null) {
      return false;
    }
    boolean bool = localObject1.isConnected();
    if (bool) {
      return bool;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isNetworkEnable() : FALSE with TYPE = ");
    localStringBuilder.append(localObject1.getType());
    UploadLog.e("NetworkState", localStringBuilder.toString());
    return bool;
  }
  
  public boolean isNetworkConnected()
  {
    Context localContext = this.context;
    if (localContext == null) {
      return true;
    }
    return isNetworkConnected(localContext);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = getApnValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetworkStateReceiver ====== ");
    localStringBuilder.append(paramIntent.getAction());
    localStringBuilder.append(" apn:");
    localStringBuilder.append(this.apn);
    localStringBuilder.append(" -> ");
    localStringBuilder.append(str);
    localStringBuilder.append(" Available:");
    localStringBuilder.append(isNetworkAvailable(paramContext));
    UploadLog.d("NetworkState", localStringBuilder.toString());
    if (paramIntent.getAction() == null) {
      return;
    }
    if (paramIntent.getAction().compareTo("android.net.conn.CONNECTIVITY_CHANGE") == 0) {
      notifyObservers(isNetworkConnected(paramContext));
    }
    if ((str != null) && (!str.equalsIgnoreCase(this.apn))) {
      notifyApnChanged(true);
    }
  }
  
  public void removeListener(NetworkState.NetworkStateListener paramNetworkStateListener)
  {
    synchronized (this.observers)
    {
      this.observers.remove(paramNetworkStateListener);
      return;
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.context = paramContext;
    paramContext.registerReceiver(this, new IntentFilter(new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")));
    isNetworkConnected(paramContext);
  }
  
  public void unregisterReceiver()
  {
    this.context.unregisterReceiver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.NetworkState
 * JD-Core Version:    0.7.0.1
 */