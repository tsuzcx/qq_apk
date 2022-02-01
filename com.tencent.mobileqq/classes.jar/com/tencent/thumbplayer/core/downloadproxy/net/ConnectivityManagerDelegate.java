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
  
  ConnectivityManagerDelegate(Context paramContext)
  {
    this.mConnectivityManager = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
  }
  
  private NetworkInfo getNetworkInfo(Network paramNetwork)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        NetworkInfo localNetworkInfo = this.mConnectivityManager.getNetworkInfo(paramNetwork);
        return localNetworkInfo;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        try
        {
          if (Build.VERSION.SDK_INT >= 21)
          {
            paramNetwork = this.mConnectivityManager.getNetworkInfo(paramNetwork);
            return paramNetwork;
          }
          return null;
        }
        catch (NullPointerException paramNetwork) {}
        localNullPointerException = localNullPointerException;
      }
    }
    return null;
  }
  
  @TargetApi(21)
  private NetworkInfo processActiveNetworkInfo(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {
      return null;
    }
    if (paramNetworkInfo.isConnected()) {
      return paramNetworkInfo;
    }
    if (Build.VERSION.SDK_INT < 21) {
      return null;
    }
    if (paramNetworkInfo.getDetailedState() != NetworkInfo.DetailedState.BLOCKED) {
      return null;
    }
    return paramNetworkInfo;
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
    while (i < j)
    {
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
          localObject2 = localNetwork;
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  @TargetApi(21)
  protected NetworkCapabilities getNetworkCapabilities(Network paramNetwork)
  {
    try
    {
      paramNetwork = this.mConnectivityManager.getNetworkCapabilities(paramNetwork);
      return paramNetwork;
    }
    catch (SecurityException paramNetwork)
    {
      label11:
      break label11;
    }
    return null;
  }
  
  NetworkState getNetworkState(WifiManagerDelegate paramWifiManagerDelegate)
  {
    Network localNetwork;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localNetwork = getDefaultNetwork();
      localNetworkInfo = this.mConnectivityManager.getNetworkInfo(localNetwork);
    }
    else
    {
      localNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
      localNetwork = null;
    }
    NetworkInfo localNetworkInfo = processActiveNetworkInfo(localNetworkInfo);
    if (localNetworkInfo == null) {
      return new NetworkState(false, -1, -1, null, false, "");
    }
    if (localNetwork != null) {
      return new NetworkState(true, localNetworkInfo.getType(), localNetworkInfo.getSubtype(), String.valueOf(NetworkUtil.networkToNetId(localNetwork)), false, "");
    }
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
    //   0: new 163	java/net/Socket
    //   3: dup
    //   4: invokespecial 164	java/net/Socket:<init>	()V
    //   7: astore_2
    //   8: aload_1
    //   9: aload_2
    //   10: invokevirtual 168	android/net/Network:bindSocket	(Ljava/net/Socket;)V
    //   13: aload_2
    //   14: invokevirtual 171	java/net/Socket:close	()V
    //   17: iconst_1
    //   18: ireturn
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 171	java/net/Socket:close	()V
    //   24: aload_1
    //   25: athrow
    //   26: aload_2
    //   27: invokevirtual 171	java/net/Socket:close	()V
    //   30: iconst_0
    //   31: ireturn
    //   32: astore_1
    //   33: goto -7 -> 26
    //   36: astore_1
    //   37: goto -20 -> 17
    //   40: astore_2
    //   41: goto -17 -> 24
    //   44: astore_1
    //   45: iconst_0
    //   46: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	ConnectivityManagerDelegate
    //   0	47	1	paramNetwork	Network
    //   7	20	2	localSocket	java.net.Socket
    //   40	1	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   8	13	19	finally
    //   8	13	32	java/io/IOException
    //   13	17	36	java/io/IOException
    //   20	24	40	java/io/IOException
    //   26	30	44	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.ConnectivityManagerDelegate
 * JD-Core Version:    0.7.0.1
 */