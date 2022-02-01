package com.tencent.mobileqq.msf.core.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest.Builder;
import com.tencent.mobileqq.msf.core.quicksend.b;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class l
{
  public static final String a = "NetworkChannelManager";
  public static final int b = 0;
  public static final int c = 1;
  private static AtomicInteger d = new AtomicInteger(0);
  private static l.a e = null;
  private static final l.a f = new l.a();
  
  public static Network a(Context paramContext, int paramInt)
  {
    if (!b.g()) {
      return null;
    }
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager != null)
      {
        Network[] arrayOfNetwork = localConnectivityManager.getAllNetworks();
        if (arrayOfNetwork != null)
        {
          int j = arrayOfNetwork.length;
          int i = 0;
          while (i < j)
          {
            Network localNetwork = arrayOfNetwork[i];
            NetworkInfo localNetworkInfo = localConnectivityManager.getNetworkInfo(localNetwork);
            if (a(paramContext, localNetwork, paramInt))
            {
              boolean bool = localNetworkInfo.isConnected();
              if (bool) {
                return localNetwork;
              }
            }
            i += 1;
          }
        }
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static NetworkInfo a(Context paramContext, Network paramNetwork)
  {
    if (!b.g()) {
      return null;
    }
    if (paramNetwork == null) {
      return null;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getNetworkInfo(paramNetwork);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void a(Context paramContext)
  {
    if (!b.g()) {
      return;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return;
    }
    try
    {
      if (d.compareAndSet(0, 1))
      {
        NetworkRequest.Builder localBuilder = new NetworkRequest.Builder();
        localBuilder.addCapability(12);
        localBuilder.addTransportType(0);
        paramContext.requestNetwork(localBuilder.build(), f);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("requestMobileNetworkIfNot refCount=");
          paramContext.append(d.get());
          paramContext.append(" mobileCallbackObj=");
          paramContext.append(Integer.toHexString(f.hashCode()));
          QLog.d("NetworkChannelManager", 2, paramContext.toString());
        }
        if (e != null)
        {
          e.a(0);
          return;
        }
      }
    }
    catch (Throwable paramContext)
    {
      d.set(0);
      QLog.i("NetworkChannelManager", 1, paramContext.getMessage(), paramContext);
      paramContext.printStackTrace();
    }
  }
  
  public static void a(l.a parama)
  {
    e = parama;
  }
  
  public static boolean a(Context paramContext, Network paramNetwork, int paramInt)
  {
    if (paramNetwork == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getNetworkCapabilities(paramNetwork);
    if (paramContext == null) {
      return false;
    }
    return paramContext.hasTransport(paramInt);
  }
  
  public static Network b(Context paramContext)
  {
    if (!b.g()) {
      return null;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getAllNetworks();
        if ((paramContext != null) && (paramContext.length > 0))
        {
          paramContext = paramContext[0];
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static NetworkInfo b(Context paramContext, int paramInt)
  {
    if (!b.g()) {
      return null;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        Network[] arrayOfNetwork = paramContext.getAllNetworks();
        if (arrayOfNetwork != null)
        {
          int j = arrayOfNetwork.length;
          int i = 0;
          while (i < j)
          {
            Network localNetwork = arrayOfNetwork[i];
            NetworkCapabilities localNetworkCapabilities = paramContext.getNetworkCapabilities(localNetwork);
            if ((localNetworkCapabilities != null) && (localNetworkCapabilities.hasTransport(paramInt)))
            {
              paramContext = paramContext.getNetworkInfo(localNetwork);
              return paramContext;
            }
            i += 1;
          }
        }
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void c(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (d.compareAndSet(1, 0))
      {
        paramContext.unregisterNetworkCallback(f);
        if (e != null) {
          e.b(0);
        }
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("unregisterMobileNetworkCallback refCount=");
          paramContext.append(d.get());
          paramContext.append(" mobileCallbackObj=");
          paramContext.append(Integer.toHexString(f.hashCode()));
          QLog.i("NetworkChannelManager", 2, paramContext.toString());
          return;
        }
      }
    }
    catch (Throwable paramContext)
    {
      d.set(0);
      QLog.i("NetworkChannelManager", 1, paramContext.getMessage(), paramContext);
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.l
 * JD-Core Version:    0.7.0.1
 */