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
      if (l.a() == null) {
        break;
      }
      try
      {
        l.a().onAvailable(paramNetwork);
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
    if (l.a() != null) {}
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
  
  public void onLinkPropertiesChanged(Network paramNetwork, LinkProperties paramLinkProperties)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NetworkChannelManager", 2, "onLinkPropertiesChanged " + paramNetwork.toString() + " " + paramLinkProperties.toString());
    }
    if (l.a() != null) {}
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
  
  public void onLosing(Network paramNetwork, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NetworkChannelManager", 2, "onLosing " + paramNetwork.toString() + " " + paramInt);
    }
    if (l.a() != null) {}
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
  
  public void onLost(Network paramNetwork)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NetworkChannelManager", 2, "onLost " + paramNetwork.toString());
    }
    if (l.a() != null) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.l.a
 * JD-Core Version:    0.7.0.1
 */