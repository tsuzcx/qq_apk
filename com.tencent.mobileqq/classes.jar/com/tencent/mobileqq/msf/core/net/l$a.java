package com.tencent.mobileqq.msf.core.net;

import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class l$a
  extends ConnectivityManager.NetworkCallback
{
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRequestNetwork ");
      localStringBuilder.append(paramInt);
      QLog.d("NetworkChannelManager", 2, localStringBuilder.toString());
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUnregisterNetwork ");
      localStringBuilder.append(paramInt);
      QLog.d("NetworkChannelManager", 2, localStringBuilder.toString());
    }
  }
  
  public void onAvailable(Network paramNetwork)
  {
    Object localObject = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    if (localObject == null) {
      return;
    }
    localObject = ((ConnectivityManager)localObject).getNetworkInfo(paramNetwork);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAvailable network: ");
      localStringBuilder.append(paramNetwork.toString());
      localStringBuilder.append(" ");
      if (localObject != null) {
        localObject = ((NetworkInfo)localObject).toString();
      } else {
        localObject = "netInfo is null";
      }
      localStringBuilder.append((String)localObject);
      QLog.d("NetworkChannelManager", 2, localStringBuilder.toString());
    }
    if (l.a() != null) {
      try
      {
        l.a().onAvailable(paramNetwork);
        return;
      }
      catch (Exception paramNetwork)
      {
        QLog.w("NetworkChannelManager", 1, paramNetwork.getMessage(), paramNetwork);
      }
    }
  }
  
  public void onCapabilitiesChanged(Network paramNetwork, NetworkCapabilities paramNetworkCapabilities)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCapabilitiesChanged ");
      localStringBuilder.append(paramNetwork.toString());
      localStringBuilder.append(" ");
      localStringBuilder.append(paramNetworkCapabilities.toString());
      QLog.d("NetworkChannelManager", 2, localStringBuilder.toString());
    }
    if (l.a() != null) {
      try
      {
        l.a().onCapabilitiesChanged(paramNetwork, paramNetworkCapabilities);
        return;
      }
      catch (Exception paramNetwork)
      {
        QLog.w("NetworkChannelManager", 1, paramNetwork.getMessage(), paramNetwork);
      }
    }
  }
  
  public void onLinkPropertiesChanged(Network paramNetwork, LinkProperties paramLinkProperties)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLinkPropertiesChanged ");
      localStringBuilder.append(paramNetwork.toString());
      localStringBuilder.append(" ");
      localStringBuilder.append(paramLinkProperties.toString());
      QLog.d("NetworkChannelManager", 2, localStringBuilder.toString());
    }
    if (l.a() != null) {
      try
      {
        l.a().onLinkPropertiesChanged(paramNetwork, paramLinkProperties);
        return;
      }
      catch (Exception paramNetwork)
      {
        QLog.w("NetworkChannelManager", 1, paramNetwork.getMessage(), paramNetwork);
      }
    }
  }
  
  public void onLosing(Network paramNetwork, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLosing ");
      localStringBuilder.append(paramNetwork.toString());
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt);
      QLog.d("NetworkChannelManager", 2, localStringBuilder.toString());
    }
    if (l.a() != null) {
      try
      {
        l.a().onLosing(paramNetwork, paramInt);
        return;
      }
      catch (Exception paramNetwork)
      {
        QLog.w("NetworkChannelManager", 1, paramNetwork.getMessage(), paramNetwork);
      }
    }
  }
  
  public void onLost(Network paramNetwork)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLost ");
      localStringBuilder.append(paramNetwork.toString());
      QLog.d("NetworkChannelManager", 2, localStringBuilder.toString());
    }
    if (l.a() != null) {
      try
      {
        l.a().onLost(paramNetwork);
        return;
      }
      catch (Exception paramNetwork)
      {
        QLog.w("NetworkChannelManager", 1, paramNetwork.getMessage(), paramNetwork);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.l.a
 * JD-Core Version:    0.7.0.1
 */