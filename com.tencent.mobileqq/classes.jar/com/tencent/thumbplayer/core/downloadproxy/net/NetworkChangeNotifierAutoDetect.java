package com.tencent.thumbplayer.core.downloadproxy.net;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;

public class NetworkChangeNotifierAutoDetect
  extends BroadcastReceiver
{
  private static final String FILE_NAME = "NetworkChangeNotifierAutoDetect.java";
  private static final int UNKNOWN_LINK_SPEED = -1;
  private ConnectivityManagerDelegate mConnectivityManagerDelegate;
  private NetworkChangeNotifierAutoDetect.DefaultNetworkCallback mDefaultNetworkCallback;
  private final Handler mHandler;
  private boolean mIgnoreNextBroadcast;
  private final NetworkChangeNotifierAutoDetect.NetworkConnectivityIntentFilter mIntentFilter;
  private final Looper mLooper;
  private NetworkChangeNotifierAutoDetect.MyNetworkCallback mNetworkCallback;
  private NetworkRequest mNetworkRequest;
  private NetworkState mNetworkState;
  private final NetworkChangeNotifierAutoDetect.Observer mObserver;
  private boolean mRegisterNetworkCallbackFailed;
  private boolean mRegistered;
  private final RegistrationPolicy mRegistrationPolicy;
  private boolean mShouldSignalObserver;
  private WifiManagerDelegate mWifiManagerDelegate;
  
  @TargetApi(21)
  public NetworkChangeNotifierAutoDetect(NetworkChangeNotifierAutoDetect.Observer paramObserver, Looper paramLooper, RegistrationPolicy paramRegistrationPolicy)
  {
    if (paramLooper == null) {
      this.mLooper = Looper.getMainLooper();
    } else {
      this.mLooper = paramLooper;
    }
    this.mHandler = new Handler(this.mLooper);
    this.mObserver = paramObserver;
    this.mConnectivityManagerDelegate = new ConnectivityManagerDelegate(NetworkChangeNotifier.getAppContext());
    if (Build.VERSION.SDK_INT < 23) {
      this.mWifiManagerDelegate = new WifiManagerDelegate(NetworkChangeNotifier.getAppContext());
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.mNetworkCallback = new NetworkChangeNotifierAutoDetect.MyNetworkCallback(this, null);
      this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
    }
    else
    {
      this.mNetworkCallback = null;
      this.mNetworkRequest = null;
    }
    if (Build.VERSION.SDK_INT >= 28) {
      paramObserver = new NetworkChangeNotifierAutoDetect.DefaultNetworkCallback(this, null);
    } else {
      paramObserver = null;
    }
    this.mDefaultNetworkCallback = paramObserver;
    this.mNetworkState = getCurrentNetworkState();
    this.mIntentFilter = new NetworkChangeNotifierAutoDetect.NetworkConnectivityIntentFilter();
    this.mIgnoreNextBroadcast = false;
    this.mShouldSignalObserver = false;
    this.mRegistrationPolicy = paramRegistrationPolicy;
    this.mRegistrationPolicy.init(this);
    this.mShouldSignalObserver = true;
  }
  
  private void assertOnThread()
  {
    if (onThread()) {
      return;
    }
    throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
  }
  
  private void connectionTypeChanged()
  {
    NetworkState localNetworkState = getCurrentNetworkState();
    if ((localNetworkState.getConnectionType() != this.mNetworkState.getConnectionType()) || (!localNetworkState.getNetworkIdentifier().equals(this.mNetworkState.getNetworkIdentifier())) || (localNetworkState.isPrivateDnsActive() != this.mNetworkState.isPrivateDnsActive()) || (!localNetworkState.getPrivateDnsServerName().equals(this.mNetworkState.getPrivateDnsServerName()))) {
      this.mObserver.onConnectionTypeChanged(localNetworkState.getConnectionType());
    }
    if ((localNetworkState.getConnectionType() != this.mNetworkState.getConnectionType()) || (localNetworkState.getConnectionSubtype() != this.mNetworkState.getConnectionSubtype())) {
      this.mObserver.onConnectionSubtypeChanged(localNetworkState.getConnectionSubtype());
    }
    this.mNetworkState = localNetworkState;
  }
  
  private boolean onThread()
  {
    return this.mLooper == Looper.myLooper();
  }
  
  private void runOnThread(Runnable paramRunnable)
  {
    if (onThread())
    {
      paramRunnable.run();
      return;
    }
    this.mHandler.post(paramRunnable);
  }
  
  public void destroy()
  {
    this.mRegistrationPolicy.destroy();
    unregister();
  }
  
  public NetworkState getCurrentNetworkState()
  {
    return this.mConnectivityManagerDelegate.getNetworkState(this.mWifiManagerDelegate);
  }
  
  public long getDefaultNetId()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return -1L;
    }
    Network localNetwork = this.mConnectivityManagerDelegate.getDefaultNetwork();
    if (localNetwork == null) {
      return -1L;
    }
    return NetworkUtil.networkToNetId(localNetwork);
  }
  
  public long[] getNetworksAndTypes()
  {
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    if (j < 21) {
      return new long[0];
    }
    Network[] arrayOfNetwork = NetworkUtil.getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
    long[] arrayOfLong = new long[arrayOfNetwork.length * 2];
    int k = arrayOfNetwork.length;
    j = 0;
    while (i < k)
    {
      Network localNetwork = arrayOfNetwork[i];
      int m = j + 1;
      arrayOfLong[j] = NetworkUtil.networkToNetId(localNetwork);
      j = m + 1;
      arrayOfLong[m] = this.mConnectivityManagerDelegate.getConnectionType(localNetwork);
      i += 1;
    }
    return arrayOfLong;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    runOnThread(new NetworkChangeNotifierAutoDetect.1(this));
  }
  
  public void register()
  {
    assertOnThread();
    if (!NetworkChangeNotifier.checkAppContext()) {
      return;
    }
    if (this.mRegistered)
    {
      connectionTypeChanged();
      return;
    }
    if (this.mShouldSignalObserver) {
      connectionTypeChanged();
    }
    Object localObject = this.mDefaultNetworkCallback;
    if (localObject != null) {}
    try
    {
      this.mConnectivityManagerDelegate.registerDefaultNetworkCallback((ConnectivityManager.NetworkCallback)localObject, this.mHandler);
    }
    catch (RuntimeException localRuntimeException)
    {
      label58:
      int i;
      boolean bool;
      break label58;
    }
    this.mDefaultNetworkCallback = null;
    localObject = this.mDefaultNetworkCallback;
    i = 0;
    if (localObject == null)
    {
      if (NetworkChangeNotifier.getAppContext().registerReceiver(this, this.mIntentFilter) != null) {
        bool = true;
      } else {
        bool = false;
      }
      this.mIgnoreNextBroadcast = bool;
    }
    this.mRegistered = true;
    localObject = this.mNetworkCallback;
    if (localObject != null) {
      ((NetworkChangeNotifierAutoDetect.MyNetworkCallback)localObject).initializeVpnInPlace();
    }
    try
    {
      this.mConnectivityManagerDelegate.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback, this.mHandler);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      long[] arrayOfLong;
      break label153;
    }
    catch (Exception localException)
    {
      label140:
      break label140;
    }
    this.mRegisterNetworkCallbackFailed = true;
    this.mNetworkCallback = null;
    break label163;
    label153:
    this.mRegisterNetworkCallbackFailed = true;
    this.mNetworkCallback = null;
    label163:
    if ((!this.mRegisterNetworkCallbackFailed) && (this.mShouldSignalObserver))
    {
      localObject = NetworkUtil.getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
      arrayOfLong = new long[localObject.length];
      while (i < localObject.length)
      {
        arrayOfLong[i] = NetworkUtil.networkToNetId(localObject[i]);
        i += 1;
      }
      this.mObserver.purgeActiveNetworkList(arrayOfLong);
    }
  }
  
  public void unregister()
  {
    if (!this.mRegistered) {
      return;
    }
    this.mRegistered = false;
    Object localObject = this.mNetworkCallback;
    if (localObject != null) {
      this.mConnectivityManagerDelegate.unregisterNetworkCallback((ConnectivityManager.NetworkCallback)localObject);
    }
    localObject = this.mDefaultNetworkCallback;
    if (localObject != null)
    {
      this.mConnectivityManagerDelegate.unregisterNetworkCallback((ConnectivityManager.NetworkCallback)localObject);
      return;
    }
    if (!NetworkChangeNotifier.checkAppContext()) {
      return;
    }
    NetworkChangeNotifier.getAppContext().unregisterReceiver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifierAutoDetect
 * JD-Core Version:    0.7.0.1
 */