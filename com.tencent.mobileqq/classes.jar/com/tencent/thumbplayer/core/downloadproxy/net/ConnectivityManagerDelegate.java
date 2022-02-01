package com.tencent.thumbplayer.core.downloadproxy.net;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.NetworkRequest;
import android.os.Build.VERSION;
import android.os.Handler;

public class ConnectivityManagerDelegate
{
  private final ConnectivityManager mConnectivityManager;
  
  static
  {
    if (!ConnectivityManagerDelegate.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  ConnectivityManagerDelegate(Context paramContext)
  {
    this.mConnectivityManager = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
  }
  
  private NetworkInfo getNetworkInfo(Network paramNetwork)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    try
    {
      if (Build.VERSION.SDK_INT >= 21) {
        localObject1 = this.mConnectivityManager.getNetworkInfo(paramNetwork);
      }
      return localObject1;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
        try
        {
          if (Build.VERSION.SDK_INT >= 21)
          {
            paramNetwork = this.mConnectivityManager.getNetworkInfo(paramNetwork);
            return paramNetwork;
          }
        }
        catch (NullPointerException paramNetwork) {}
      }
    }
    return null;
  }
  
  @TargetApi(21)
  private NetworkInfo processActiveNetworkInfo(NetworkInfo paramNetworkInfo)
  {
    NetworkInfo localNetworkInfo;
    if (paramNetworkInfo == null) {
      localNetworkInfo = null;
    }
    do
    {
      do
      {
        return localNetworkInfo;
        localNetworkInfo = paramNetworkInfo;
      } while (paramNetworkInfo.isConnected());
      if (Build.VERSION.SDK_INT < 21) {
        return null;
      }
      localNetworkInfo = paramNetworkInfo;
    } while (paramNetworkInfo.getDetailedState() == NetworkInfo.DetailedState.BLOCKED);
    return null;
  }
  
  @TargetApi(21)
  protected Network[] getAllNetworksUnfiltered()
  {
    Network[] arrayOfNetwork2 = this.mConnectivityManager.getAllNetworks();
    Network[] arrayOfNetwork1 = arrayOfNetwork2;
    if (arrayOfNetwork2 == null) {
      arrayOfNetwork1 = new Network[0];
    }
    return arrayOfNetwork1;
  }
  
  @TargetApi(21)
  @NetworkConstants.ConnectionType
  int getConnectionType(Network paramNetwork)
  {
    NetworkInfo localNetworkInfo = getNetworkInfo(paramNetwork);
    paramNetwork = localNetworkInfo;
    if (localNetworkInfo != null)
    {
      paramNetwork = localNetworkInfo;
      if (localNetworkInfo.getType() == 17) {
        paramNetwork = this.mConnectivityManager.getActiveNetworkInfo();
      }
    }
    if ((paramNetwork != null) && (paramNetwork.isConnected())) {
      return NetworkState.convertToConnectionType(paramNetwork.getType(), paramNetwork.getSubtype());
    }
    return 6;
  }
  
  @TargetApi(21)
  Network getDefaultNetwork()
  {
    Object localObject2;
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject2 = this.mConnectivityManager.getActiveNetwork();
      localObject1 = localObject2;
      if (localObject2 != null) {
        return localObject2;
      }
    }
    else
    {
      localObject1 = null;
    }
    NetworkInfo localNetworkInfo1 = this.mConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo1 == null) {
      return null;
    }
    Network[] arrayOfNetwork = NetworkUtil.getAllNetworksFiltered(this, null);
    int j = arrayOfNetwork.length;
    int i = 0;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= j) {
        break;
      }
      Network localNetwork = arrayOfNetwork[i];
      NetworkInfo localNetworkInfo2 = getNetworkInfo(localNetwork);
      localObject2 = localObject1;
      if (localNetworkInfo2 != null) {
        if (localNetworkInfo2.getType() != localNetworkInfo1.getType())
        {
          localObject2 = localObject1;
          if (localNetworkInfo2.getType() != 17) {}
        }
        else
        {
          assert (localObject1 == null);
          localObject2 = localNetwork;
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
  }
  
  @TargetApi(21)
  protected NetworkCapabilities getNetworkCapabilities(Network paramNetwork)
  {
    return this.mConnectivityManager.getNetworkCapabilities(paramNetwork);
  }
  
  NetworkState getNetworkState(WifiManagerDelegate paramWifiManagerDelegate)
  {
    Network localNetwork;
    NetworkInfo localNetworkInfo;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localNetwork = getDefaultNetwork();
      localNetworkInfo = this.mConnectivityManager.getNetworkInfo(localNetwork);
    }
    for (;;)
    {
      localNetworkInfo = processActiveNetworkInfo(localNetworkInfo);
      if (localNetworkInfo != null) {
        break;
      }
      return new NetworkState(false, -1, -1, null, false, "");
      localNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
      localNetwork = null;
    }
    if (localNetwork != null) {
      return new NetworkState(true, localNetworkInfo.getType(), localNetworkInfo.getSubtype(), String.valueOf(NetworkUtil.networkToNetId(localNetwork)), false, "");
    }
    assert (Build.VERSION.SDK_INT < 23);
    if (localNetworkInfo.getType() == 1)
    {
      if ((localNetworkInfo.getExtraInfo() != null) && (!"".equals(localNetworkInfo.getExtraInfo()))) {
        return new NetworkState(true, localNetworkInfo.getType(), localNetworkInfo.getSubtype(), localNetworkInfo.getExtraInfo(), false, "");
      }
      return new NetworkState(true, localNetworkInfo.getType(), localNetworkInfo.getSubtype(), paramWifiManagerDelegate.getWifiSsid(), false, "");
    }
    return new NetworkState(true, localNetworkInfo.getType(), localNetworkInfo.getSubtype(), null, false, "");
  }
  
  @TargetApi(26)
  void registerDefaultNetworkCallback(ConnectivityManager.NetworkCallback paramNetworkCallback, Handler paramHandler)
  {
    this.mConnectivityManager.registerDefaultNetworkCallback(paramNetworkCallback, paramHandler);
  }
  
  @TargetApi(21)
  void registerNetworkCallback(NetworkRequest paramNetworkRequest, ConnectivityManager.NetworkCallback paramNetworkCallback, Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mConnectivityManager.registerNetworkCallback(paramNetworkRequest, paramNetworkCallback, paramHandler);
      return;
    }
    this.mConnectivityManager.registerNetworkCallback(paramNetworkRequest, paramNetworkCallback);
  }
  
  @TargetApi(21)
  void unregisterNetworkCallback(ConnectivityManager.NetworkCallback paramNetworkCallback)
  {
    this.mConnectivityManager.unregisterNetworkCallback(paramNetworkCallback);
  }
  
  /* Error */
  @TargetApi(21)
  protected boolean vpnAccessible(Network paramNetwork)
  {
    // Byte code:
    //   0: new 170	java/net/Socket
    //   3: dup
    //   4: invokespecial 171	java/net/Socket:<init>	()V
    //   7: astore_2
    //   8: aload_1
    //   9: aload_2
    //   10: invokevirtual 175	android/net/Network:bindSocket	(Ljava/net/Socket;)V
    //   13: aload_2
    //   14: invokevirtual 178	java/net/Socket:close	()V
    //   17: iconst_1
    //   18: ireturn
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 178	java/net/Socket:close	()V
    //   24: iconst_0
    //   25: ireturn
    //   26: astore_1
    //   27: iconst_0
    //   28: ireturn
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 178	java/net/Socket:close	()V
    //   34: aload_1
    //   35: athrow
    //   36: astore_1
    //   37: goto -20 -> 17
    //   40: astore_2
    //   41: goto -7 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	ConnectivityManagerDelegate
    //   0	44	1	paramNetwork	Network
    //   7	24	2	localSocket	java.net.Socket
    //   40	1	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   8	13	19	java/io/IOException
    //   20	24	26	java/io/IOException
    //   8	13	29	finally
    //   13	17	36	java/io/IOException
    //   30	34	40	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.ConnectivityManagerDelegate
 * JD-Core Version:    0.7.0.1
 */