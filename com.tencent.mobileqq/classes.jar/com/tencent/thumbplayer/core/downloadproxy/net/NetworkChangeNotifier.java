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
  private static final int DISCONNECT_CALLBACK_DELAY = 1000;
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
    if (this.mAutoDetector != null)
    {
      this.mAutoDetector.destroy();
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
    if (getInstance().mAutoDetector == null) {}
    for (long[] arrayOfLong = new long[0];; arrayOfLong = getInstance().mAutoDetector.getNetworksAndTypes())
    {
      TPDLProxyLog.d("NetworkChangeNotifier.java", 0, "tpdlnative", "getCurrentNetworksAndTypes : " + Arrays.toString(arrayOfLong));
      return arrayOfLong;
    }
  }
  
  public static NetworkChangeNotifier getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new NetworkChangeNotifier();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static String getWifiSSID()
  {
    Object localObject;
    if (checkAppContext()) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      localObject = getAppContext().registerReceiver(null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
      if (localObject == null) {
        break;
      }
      localObject = (WifiInfo)((Intent)localObject).getParcelableExtra("wifiInfo");
      if (localObject == null) {
        break;
      }
      str = ((WifiInfo)localObject).getSSID();
      if (str == null) {
        break;
      }
      localObject = str;
    } while (!str.equals("<unknown ssid>"));
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
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    try
    {
      nativeNotifyConnectionTypeChanged(paramInt, paramLong);
      Iterator localIterator = this.mConnectionTypeObservers.iterator();
      while (localIterator.hasNext()) {
        ((NetworkChangeNotifier.ConnectionTypeObserver)localIterator.next()).onConnectionTypeChanged(paramInt);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TPDLProxyLog.e("NetworkChangeNotifier.java", 0, "tpdlnative", "nativeNotifyConnectionTypeChanged failed, error:" + localThrowable.toString());
      }
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
    TPDLProxyLog.d("NetworkChangeNotifier.java", 0, "tpdlnative", "setAutoDetectConnectivityStateInternal, shouldAutoDetect:" + paramBoolean);
    if (paramBoolean)
    {
      if (this.mAutoDetector == null)
      {
        this.mAutoDetector = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifier.2(this), this.mHandler.getLooper(), paramRegistrationPolicy);
        paramRegistrationPolicy = this.mAutoDetector.getCurrentNetworkState();
        updateCurrentConnectionType(paramRegistrationPolicy.getConnectionType());
        notifyObserversOfConnectionSubtypeChange(paramRegistrationPolicy.getConnectionSubtype());
      }
      return;
    }
    destroyAutoDetector();
  }
  
  private void updateCurrentConnectionType(int paramInt)
  {
    TPDLProxyLog.d("NetworkChangeNotifier.java", 232, "tpdlnative", "updateCurrentConnectionType, newConnectionType:" + paramInt);
    this.mCurrentConnectionType = paramInt;
    notifyObserversOfConnectionTypeChange(paramInt);
  }
  
  void notifyObserversOfConnectionSubtypeChange(int paramInt)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    try
    {
      nativeNotifyMaxBandwidthChanged(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("NetworkChangeNotifier.java", 0, "tpdlnative", "nativeNotifyMaxBandwidthChanged failed, error:" + localThrowable.toString());
    }
  }
  
  void notifyObserversOfConnectionTypeChange(int paramInt)
  {
    notifyObserversOfConnectionTypeChange(paramInt, getCurrentDefaultNetId());
  }
  
  void notifyObserversOfNetworkConnect(long paramLong, int paramInt)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    try
    {
      nativeNotifyOfNetworkConnect(paramLong, paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("NetworkChangeNotifier.java", 0, "tpdlnative", "nativeNotifyOfNetworkConnect failed, error:" + localThrowable.toString());
    }
  }
  
  void notifyObserversOfNetworkDisconnect(long paramLong)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    try
    {
      nativeNotifyOfNetworkDisconnect(paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("NetworkChangeNotifier.java", 0, "tpdlnative", "nativeNotifyOfNetworkDisconnect failed, error:" + localThrowable.toString());
    }
  }
  
  void notifyObserversOfNetworkSoonToDisconnect(long paramLong)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    try
    {
      nativeNotifyOfNetworkSoonToDisconnect(paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("NetworkChangeNotifier.java", 0, "tpdlnative", "nativeNotifyOfNetworkSoonToDisconnect failed, error:" + localThrowable.toString());
    }
  }
  
  void notifyObserversToPurgeActiveNetworkList(long[] paramArrayOfLong)
  {
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    try
    {
      nativeNotifyPurgeActiveNetworkList(paramArrayOfLong);
      return;
    }
    catch (Throwable paramArrayOfLong)
    {
      TPDLProxyLog.e("NetworkChangeNotifier.java", 0, "tpdlnative", "nativeNotifyPurgeActiveNetworkList failed, error:" + paramArrayOfLong.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifier
 * JD-Core Version:    0.7.0.1
 */