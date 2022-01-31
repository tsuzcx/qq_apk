package com.tencent.mobileqq.msf.core.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest.Builder;
import com.tencent.mobileqq.msf.core.quicksend.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class k
{
  public static final String a = "NetworkChannelManager";
  public static final int b = 0;
  public static final int c = 1;
  private static AtomicInteger d = new AtomicInteger(0);
  private static a e;
  private static final a f = new a();
  
  public static Network a(Context paramContext, int paramInt)
  {
    if (!b.f()) {
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
    if (!b.f()) {
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
    if (!b.f()) {}
    for (;;)
    {
      return;
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null) {
        try
        {
          if (d.compareAndSet(0, 1))
          {
            NetworkRequest.Builder localBuilder = new NetworkRequest.Builder();
            localBuilder.addCapability(12);
            localBuilder.addTransportType(0);
            paramContext.requestNetwork(localBuilder.build(), f);
            if (QLog.isColorLevel()) {
              QLog.d("NetworkChannelManager", 2, "requestMobileNetworkIfNot refCount=" + d.get() + " mobileCallbackObj=" + Integer.toHexString(f.hashCode()));
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
    }
  }
  
  public static void a(a parama)
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
    if (!b.f()) {
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
    if (!b.f()) {
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
        if (QLog.isColorLevel()) {
          QLog.i("NetworkChannelManager", 2, "unregisterMobileNetworkCallback refCount=" + d.get() + " mobileCallbackObj=" + Integer.toHexString(f.hashCode()));
        }
      }
      return;
    }
    catch (Throwable paramContext)
    {
      d.set(0);
      QLog.i("NetworkChannelManager", 1, paramContext.getMessage(), paramContext);
      paramContext.printStackTrace();
    }
  }
  
  public static class a
    extends ConnectivityManager.NetworkCallback
  {
    public void a(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NetworkChannelManager", 2, "onRequestNetwork " + paramInt);
      }
    }
    
    public void b(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NetworkChannelManager", 2, "onUnregisterNetwork " + paramInt);
      }
    }
    
    public void onAvailable(Network paramNetwork)
    {
      Object localObject = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
      if (localObject == null) {
        return;
      }
      localObject = ((ConnectivityManager)localObject).getNetworkInfo(paramNetwork);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onAvailable network: ").append(paramNetwork.toString()).append(" ");
        if (localObject == null) {
          break label104;
        }
      }
      label104:
      for (localObject = ((NetworkInfo)localObject).toString();; localObject = "netInfo is null")
      {
        QLog.d("NetworkChannelManager", 2, (String)localObject);
        if (k.a() == null) {
          break;
        }
        try
        {
          k.a().onAvailable(paramNetwork);
          return;
        }
        catch (Exception paramNetwork)
        {
          QLog.w("NetworkChannelManager", 1, paramNetwork.getMessage(), paramNetwork);
          return;
        }
      }
    }
    
    public void onCapabilitiesChanged(Network paramNetwork, NetworkCapabilities paramNetworkCapabilities)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NetworkChannelManager", 2, "onCapabilitiesChanged " + paramNetwork.toString() + " " + paramNetworkCapabilities.toString());
      }
      if (k.a() != null) {}
      try
      {
        k.a().onCapabilitiesChanged(paramNetwork, paramNetworkCapabilities);
        return;
      }
      catch (Exception paramNetwork)
      {
        QLog.w("NetworkChannelManager", 1, paramNetwork.getMessage(), paramNetwork);
      }
    }
    
    public void onLinkPropertiesChanged(Network paramNetwork, LinkProperties paramLinkProperties)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NetworkChannelManager", 2, "onLinkPropertiesChanged " + paramNetwork.toString() + " " + paramLinkProperties.toString());
      }
      if (k.a() != null) {}
      try
      {
        k.a().onLinkPropertiesChanged(paramNetwork, paramLinkProperties);
        return;
      }
      catch (Exception paramNetwork)
      {
        QLog.w("NetworkChannelManager", 1, paramNetwork.getMessage(), paramNetwork);
      }
    }
    
    public void onLosing(Network paramNetwork, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NetworkChannelManager", 2, "onLosing " + paramNetwork.toString() + " " + paramInt);
      }
      if (k.a() != null) {}
      try
      {
        k.a().onLosing(paramNetwork, paramInt);
        return;
      }
      catch (Exception paramNetwork)
      {
        QLog.w("NetworkChannelManager", 1, paramNetwork.getMessage(), paramNetwork);
      }
    }
    
    public void onLost(Network paramNetwork)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NetworkChannelManager", 2, "onLost " + paramNetwork.toString());
      }
      if (k.a() != null) {}
      try
      {
        k.a().onLost(paramNetwork);
        return;
      }
      catch (Exception paramNetwork)
      {
        QLog.w("NetworkChannelManager", 1, paramNetwork.getMessage(), paramNetwork);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.k
 * JD-Core Version:    0.7.0.1
 */