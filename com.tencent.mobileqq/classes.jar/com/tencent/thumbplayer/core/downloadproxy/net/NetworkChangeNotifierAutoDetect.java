package com.tencent.thumbplayer.core.downloadproxy.net;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
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
    if (paramLooper == null)
    {
      this.mLooper = Looper.getMainLooper();
      this.mHandler = new Handler(this.mLooper);
      this.mObserver = paramObserver;
      this.mConnectivityManagerDelegate = new ConnectivityManagerDelegate(NetworkChangeNotifier.getAppContext());
      if (Build.VERSION.SDK_INT < 23) {
        this.mWifiManagerDelegate = new WifiManagerDelegate(NetworkChangeNotifier.getAppContext());
      }
      if (Build.VERSION.SDK_INT < 21) {
        break label195;
      }
      this.mNetworkCallback = new NetworkChangeNotifierAutoDetect.MyNetworkCallback(this, null);
      this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
      label116:
      if (Build.VERSION.SDK_INT < 28) {
        break label208;
      }
    }
    label195:
    label208:
    for (paramObserver = new NetworkChangeNotifierAutoDetect.DefaultNetworkCallback(this, null);; paramObserver = null)
    {
      this.mDefaultNetworkCallback = paramObserver;
      this.mNetworkState = getCurrentNetworkState();
      this.mIntentFilter = new NetworkChangeNotifierAutoDetect.NetworkConnectivityIntentFilter();
      this.mIgnoreNextBroadcast = false;
      this.mShouldSignalObserver = false;
      this.mRegistrationPolicy = paramRegistrationPolicy;
      this.mRegistrationPolicy.init(this);
      this.mShouldSignalObserver = true;
      return;
      this.mLooper = paramLooper;
      break;
      this.mNetworkCallback = null;
      this.mNetworkRequest = null;
      break label116;
    }
  }
  
  private void assertOnThread()
  {
    if (!onThread()) {
      throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
    }
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
    if (Build.VERSION.SDK_INT < 21) {}
    Network localNetwork;
    do
    {
      return -1L;
      localNetwork = this.mConnectivityManagerDelegate.getDefaultNetwork();
    } while (localNetwork == null);
    return NetworkUtil.networkToNetId(localNetwork);
  }
  
  public long[] getNetworksAndTypes()
  {
    int i = 0;
    Object localObject;
    if (Build.VERSION.SDK_INT < 21)
    {
      localObject = new long[0];
      return localObject;
    }
    Network[] arrayOfNetwork = NetworkUtil.getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
    long[] arrayOfLong = new long[arrayOfNetwork.length * 2];
    int k = arrayOfNetwork.length;
    int j = 0;
    for (;;)
    {
      localObject = arrayOfLong;
      if (i >= k) {
        break;
      }
      localObject = arrayOfNetwork[i];
      int m = j + 1;
      arrayOfLong[j] = NetworkUtil.networkToNetId((Network)localObject);
      j = m + 1;
      arrayOfLong[m] = this.mConnectivityManagerDelegate.getConnectionType((Network)localObject);
      i += 1;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    runOnThread(new NetworkChangeNotifierAutoDetect.1(this));
  }
  
  public void register()
  {
    int i = 0;
    assertOnThread();
    if (!NetworkChangeNotifier.checkAppContext()) {}
    for (;;)
    {
      return;
      if (this.mRegistered)
      {
        connectionTypeChanged();
        return;
      }
      if (this.mShouldSignalObserver) {
        connectionTypeChanged();
      }
      if (this.mDefaultNetworkCallback != null) {}
      try
      {
        this.mConnectivityManagerDelegate.registerDefaultNetworkCallback(this.mDefaultNetworkCallback, this.mHandler);
        if (this.mDefaultNetworkCallback == null)
        {
          if (NetworkChangeNotifier.getAppContext().registerReceiver(this, this.mIntentFilter) != null)
          {
            bool = true;
            this.mIgnoreNextBroadcast = bool;
          }
        }
        else
        {
          this.mRegistered = true;
          if (this.mNetworkCallback == null) {
            continue;
          }
          this.mNetworkCallback.initializeVpnInPlace();
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        try
        {
          for (;;)
          {
            this.mConnectivityManagerDelegate.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback, this.mHandler);
            if ((this.mRegisterNetworkCallbackFailed) || (!this.mShouldSignalObserver)) {
              break;
            }
            Network[] arrayOfNetwork = NetworkUtil.getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
            arrayOfLong = new long[arrayOfNetwork.length];
            while (i < arrayOfNetwork.length)
            {
              arrayOfLong[i] = NetworkUtil.networkToNetId(arrayOfNetwork[i]);
              i += 1;
            }
            localRuntimeException = localRuntimeException;
            this.mDefaultNetworkCallback = null;
          }
          boolean bool = false;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          long[] arrayOfLong;
          for (;;)
          {
            this.mRegisterNetworkCallbackFailed = true;
            this.mNetworkCallback = null;
          }
          this.mObserver.purgeActiveNetworkList(arrayOfLong);
        }
      }
    }
  }
  
  public void unregister()
  {
    if (!this.mRegistered) {}
    do
    {
      return;
      this.mRegistered = false;
      if (this.mNetworkCallback != null) {
        this.mConnectivityManagerDelegate.unregisterNetworkCallback(this.mNetworkCallback);
      }
      if (this.mDefaultNetworkCallback != null)
      {
        this.mConnectivityManagerDelegate.unregisterNetworkCallback(this.mDefaultNetworkCallback);
        return;
      }
    } while (!NetworkChangeNotifier.checkAppContext());
    NetworkChangeNotifier.getAppContext().unregisterReceiver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkChangeNotifierAutoDetect
 * JD-Core Version:    0.7.0.1
 */