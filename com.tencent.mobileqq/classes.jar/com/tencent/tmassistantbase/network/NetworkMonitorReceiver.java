package com.tencent.tmassistantbase.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import java.util.ArrayList;
import java.util.Iterator;

public class NetworkMonitorReceiver
  extends BroadcastReceiver
{
  protected static final int MSG_DELAY_TIME = 3500;
  protected static final int MSG_resumeDownloadTime = 67;
  protected static final String TAG = "NetworkMonitorReceiver";
  protected static NetworkMonitorReceiver mInstance;
  protected static Handler mNetworkChangedHandler;
  protected boolean isRegisterReceiver = false;
  ArrayList<INetworkChangedObserver> mObs = new ArrayList();
  
  public static NetworkMonitorReceiver getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new NetworkMonitorReceiver();
      }
      NetworkMonitorReceiver localNetworkMonitorReceiver = mInstance;
      return localNetworkMonitorReceiver;
    }
    finally {}
  }
  
  public void addNetworkChangedObserver(INetworkChangedObserver paramINetworkChangedObserver)
  {
    if ((!this.mObs.contains(paramINetworkChangedObserver)) && (paramINetworkChangedObserver != null)) {
      this.mObs.add(paramINetworkChangedObserver);
    }
  }
  
  public void notifyNetworkChanged()
  {
    Object localObject = this.mObs;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        INetworkChangedObserver localINetworkChangedObserver = (INetworkChangedObserver)((Iterator)localObject).next();
        if (localINetworkChangedObserver != null) {
          localINetworkChangedObserver.onNetworkChanged();
        }
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ab.c("NetworkMonitorReceiver", "network changed!");
    if (mNetworkChangedHandler == null) {
      mNetworkChangedHandler = new e(this);
    }
    mNetworkChangedHandler.removeMessages(67);
    paramContext = Message.obtain();
    paramContext.what = 67;
    mNetworkChangedHandler.sendMessageDelayed(paramContext, 3500L);
  }
  
  public void registerReceiver()
  {
    ab.c("NetworkMonitorReceiver", "registerReceiver enter");
    Context localContext = GlobalUtil.getInstance().getContext();
    if (localContext == null)
    {
      ab.c("NetworkMonitorReceiver", "registerReceiver context = null");
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      localContext.registerReceiver(this, localIntentFilter);
      this.isRegisterReceiver = true;
      ab.c("NetworkMonitorReceiver", "registerReceiver isRegisterReceiver = true");
    }
    catch (Throwable localThrowable)
    {
      this.isRegisterReceiver = false;
      ab.c("NetworkMonitorReceiver", "registerReceiver isRegisterReceiver = false");
      localThrowable.printStackTrace();
    }
    ab.c("NetworkMonitorReceiver", "registerReceiver exit");
  }
  
  public void removeNetworkChangedObserver(INetworkChangedObserver paramINetworkChangedObserver)
  {
    if (paramINetworkChangedObserver != null) {
      this.mObs.remove(paramINetworkChangedObserver);
    }
  }
  
  public void unregisterReceiver()
  {
    if (mInstance == null) {
      return;
    }
    Context localContext = GlobalUtil.getInstance().getContext();
    if (localContext == null) {
      return;
    }
    try
    {
      if (this.isRegisterReceiver)
      {
        localContext.unregisterReceiver(this);
        this.isRegisterReceiver = false;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantbase.network.NetworkMonitorReceiver
 * JD-Core Version:    0.7.0.1
 */