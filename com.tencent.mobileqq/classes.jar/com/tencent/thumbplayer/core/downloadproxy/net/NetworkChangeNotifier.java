package com.tencent.thumbplayer.core.downloadproxy.net;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class NetworkChangeNotifier
{
  private static final String FILE_NAME = "NetworkChangeNotifier.java";
  private static NetworkChangeNotifier sInstance;
  private NetworkChangeNotifierAutoDetect mAutoDetector;
  private ArrayList<NetworkChangeNotifier.ConnectionTypeObserver> mConnectionTypeObservers;
  private ConnectivityManager mConnectivityManager;
  @NetworkConstants.ConnectionType
  private int mCurrentConnectionType = 0;
  private Handler mHandler;
  private HandlerThread mHandlerThread;
  
  protected NetworkChangeNotifier()
  {
    if (getAppContext() == null)
    {
      TPDLProxyLog.e("NetworkChangeNotifier.java", 0, "tpdlnative", "create NetworkChangeNotifier failed, app context null!!!");
      return;
    }
    this.mConnectionTypeObservers = new ArrayList();
    this.mConnectivityManager = ((ConnectivityManager)getAppContext().getSystemService("connectivity"));
    initHandlerThread();
  }
  
  public static boolean checkAppContext()
  {
    if (getAppContext() == null)
    {
      TPDLProxyLog.e("NetworkChangeNotifier.java", 0, "tpdlnative", "checkAppContext fail, app context == null");
      return false;
    }
    return true;
  }
  
  private void destroyAutoDetector()
  {
    NetworkChangeNotifierAutoDetect localNetworkChangeNotifierAutoDetect = this.mAutoDetector;
    if (localNetworkChangeNotifierAutoDetect != null)
    {
      localNetworkChangeNotifierAutoDetect.destroy();
      this.mAutoDetector = null;
    }
  }
  
  public static Context getAppContext()
  {
    return TPDownloadProxyNative.getInstance().getAppContext();
  }
  
  public static int getCurrentConnectionSubtype()
  {
    if (getInstance().mAutoDetector == null) {
      return 0;
    }
    return getInstance().mAutoDetector.getCurrentNetworkState().getConnectionSubtype();
  }
  
  public static int getCurrentConnectionType()
  {
    return getInstance().mCurrentConnectionType;
  }
  
  public static long getCurrentDefaultNetId()
  {
    if (getInstance().mAutoDetector == null) {
      return -1L;
    }
    return getInstance().mAutoDetector.getDefaultNetId();
  }
  
  public static long[] getCurrentNetworksAndTypes()
  {
    long[] arrayOfLong;
    if (getInstance().mAutoDetector == null) {
      arrayOfLong = new long[0];
    } else {
      arrayOfLong = getInstance().mAutoDetector.getNetworksAndTypes();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCurrentNetworksAndTypes : ");
    localStringBuilder.append(Arrays.toString(arrayOfLong));
    TPDLProxyLog.d("NetworkChangeNotifier.java", 0, "tpdlnative", localStringBuilder.toString());
    return arrayOfLong;
  }
  
  public static NetworkChangeNotifier getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new NetworkChangeNotifier();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public static String getWifiSSID()
  {
    if (checkAppContext()) {
      return "";
    }
    Object localObject = getAppContext().registerReceiver(null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
    if (localObject != null)
    {
      localObject = (WifiInfo)((Intent)localObject).getParcelableExtra("wifiInfo");
      if (localObject != null)
      {
        localObject = ((WifiInfo)localObject).getSSID();
        if ((localObject != null) && (!((String)localObject).equals("<unknown ssid>"))) {
          return localObject;
        }
      }
    }
    return "";
  }
  
  private void initHandlerThread()
  {
    if (this.mHandlerThread == null)
    {
      this.mHandlerThread = new HandlerThread("TP-NetworkChangeNotifier");
      this.mHandlerThread.start();
      this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }
  }
  
  private native void nativeNotifyConnectionTypeChanged(int paramInt, long paramLong);
  
  private native void nativeNotifyMaxBandwidthChanged(int paramInt);
  
  private native void nativeNotifyOfNetworkConnect(long paramLong, int paramInt);
  
  private native void nativeNotifyOfNetworkDisconnect(long paramLong);
  
  private native void nativeNotifyOfNetworkSoonToDisconnect(long paramLong);
  
  private native void nativeNotifyPurgeActiveNetworkList(long[] paramArrayOfLong);
  
  private void notifyObserversOfConnectionTypeChange(int paramInt, long paramLong)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        nativeNotifyConnectionTypeChanged(paramInt, paramLong);
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("nativeNotifyConnectionTypeChanged failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("NetworkChangeNotifier.java", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
    Iterator localIterator = this.mConnectionTypeObservers.iterator();
    while (localIterator.hasNext()) {
      ((NetworkChangeNotifier.ConnectionTypeObserver)localIterator.next()).onConnectionTypeChanged(paramInt);
    }
  }
  
  public static void registerToReceiveNotificationsAlways()
  {
    getInstance().setAutoDetectConnectivityState(true, new RegistrationPolicyAlwaysRegister());
  }
  
  private void setAutoDetectConnectivityState(boolean paramBoolean, RegistrationPolicy paramRegistrationPolicy)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      TPDLProxyLog.e("NetworkChangeNotifier.java", 0, "tpdlnative", "Android API level < LOLLIPOP, monitor network change not support!");
      return;
    }
    this.mHandler.post(new NetworkChangeNotifier.1(this, paramBoolean, paramRegistrationPolicy));
  }
  
  private void setAutoDetectConnectivityStateInternal(boolean paramBoolean, RegistrationPolicy paramRegistrationPolicy)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAutoDetectConnectivityStateInternal, shouldAutoDetect:");
    localStringBuilder.append(paramBoolean);
    TPDLProxyLog.d("NetworkChangeNotifier.java", 0, "tpdlnative", localStringBuilder.toString());
    if (paramBoolean)
    {
      if (this.mAutoDetector == null)
      {
        this.mAutoDetector = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifier.2(this), this.mHandler.getLooper(), paramRegistrationPolicy);
        paramRegistrationPolicy = this.mAutoDetector.getCurrentNetworkState();
        updateCurrentConnectionType(paramRegistrationPolicy.getConnectionType());
        notifyObserversOfConnectionSubtypeChange(paramRegistrationPolicy.getConnectionSubtype());
      }
    }
    else {
      destroyAutoDetector();
    }
  }
  
  private void updateCurrentConnectionType(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateCurrentConnectionType, newConnectionType:");
    localStringBuilder.append(paramInt);
    TPDLProxyLog.d("NetworkChangeNotifier.java", 232, "tpdlnative", localStringBuilder.toString());
    this.mCurrentConnectionType = paramInt;
    notifyObserversOfConnectionTypeChange(paramInt);
  }
  
  void notifyObserversOfConnectionSubtypeChange(int paramInt)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        nativeNotifyMaxBandwidthChanged(paramInt);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("nativeNotifyMaxBandwidthChanged failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("NetworkChangeNotifier.java", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
  }
  
  void notifyObserversOfConnectionTypeChange(int paramInt)
  {
    notifyObserversOfConnectionTypeChange(paramInt, getCurrentDefaultNetId());
  }
  
  void notifyObserversOfNetworkConnect(long paramLong, int paramInt)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        nativeNotifyOfNetworkConnect(paramLong, paramInt);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("nativeNotifyOfNetworkConnect failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("NetworkChangeNotifier.java", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
  }
  
  void notifyObserversOfNetworkDisconnect(long paramLong)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        nativeNotifyOfNetworkDisconnect(paramLong);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("nativeNotifyOfNetworkDisconnect failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("NetworkChangeNotifier.java", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
  }
  
  void notifyObserversOfNetworkSoonToDisconnect(long paramLong)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        nativeNotifyOfNetworkSoonToDisconnect(paramLong);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("nativeNotifyOfNetworkSoonToDisconnect failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("NetworkChangeNotifier.java", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
  }
  
  void notifyObserversToPurgeActiveNetworkList(long[] paramArrayOfLong)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        nativeNotifyPurgeActiveNetworkList(paramArrayOfLong);
        return;
      }
      catch (Throwable paramArrayOfLong)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("nativeNotifyPurgeActiveNetworkList failed, error:");
        localStringBuilder.append(paramArrayOfLong.toString());
        TPDLProxyLog.e("NetworkChangeNotifier.java", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifier
 * JD-Core Version:    0.7.0.1
 */