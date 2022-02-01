package com.tencent.thumbplayer.core.downloadproxy.net;

import android.annotation.TargetApi;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build.VERSION;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.Arrays;

public class NetworkUtil
{
  private static final String FILE_NAME = "NetworkUtil.java";
  
  @TargetApi(21)
  public static Network[] getAllNetworksFiltered(ConnectivityManagerDelegate paramConnectivityManagerDelegate, Network paramNetwork)
  {
    Network[] arrayOfNetwork = paramConnectivityManagerDelegate.getAllNetworksUnfiltered();
    int m = arrayOfNetwork.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Network localNetwork = arrayOfNetwork[i];
      if (localNetwork.equals(paramNetwork))
      {
        k = j;
      }
      else
      {
        NetworkCapabilities localNetworkCapabilities = paramConnectivityManagerDelegate.getNetworkCapabilities(localNetwork);
        k = j;
        if (localNetworkCapabilities != null) {
          if (!localNetworkCapabilities.hasCapability(12))
          {
            k = j;
          }
          else if (localNetworkCapabilities.hasTransport(4))
          {
            k = j;
            if (paramConnectivityManagerDelegate.vpnAccessible(localNetwork)) {
              return new Network[] { localNetwork };
            }
          }
          else
          {
            arrayOfNetwork[j] = localNetwork;
            k = j + 1;
          }
        }
      }
      i += 1;
    }
    return (Network[])Arrays.copyOf(arrayOfNetwork, j);
  }
  
  @TargetApi(21)
  public static long networkToNetId(Network paramNetwork)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramNetwork.getNetworkHandle();
    }
    try
    {
      int i = Integer.parseInt(paramNetwork.toString());
      return i;
    }
    catch (Throwable paramNetwork)
    {
      TPDLProxyLog.e("NetworkUtil.java", 0, "tpdlnative", paramNetwork.toString());
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */