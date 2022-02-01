package com.tencent.mobileqq.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.QLog;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class IPUtils
{
  public static String a()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkMonitor.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if (!((Enumeration)localObject).hasMoreElements()) {
            break;
          }
          localEnumeration = ((NetworkInterface)((Enumeration)localObject).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
      Object localObject = localInetAddress.getHostAddress();
      return localObject;
    }
    catch (SocketException localSocketException)
    {
      label66:
      break label66;
    }
    return "0.0.0.0";
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      Object localObject = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
      {
        int i = ((NetworkInfo)localObject).getType();
        if (i == 0)
        {
          try
          {
            InetAddress localInetAddress;
            do
            {
              paramContext = NetworkMonitor.getNetworkInterfaces();
              while (!((Enumeration)localObject).hasMoreElements())
              {
                if (!paramContext.hasMoreElements()) {
                  break;
                }
                localObject = ((NetworkInterface)paramContext.nextElement()).getInetAddresses();
              }
              localInetAddress = (InetAddress)((Enumeration)localObject).nextElement();
            } while ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
            paramContext = localInetAddress.getHostAddress();
            return paramContext;
          }
          catch (SocketException paramContext)
          {
            paramContext.printStackTrace();
          }
        }
        else
        {
          if (((NetworkInfo)localObject).getType() == 1) {
            return a(NetworkMonitor.getConnectionInfo((WifiManager)paramContext.getSystemService("wifi")).getIpAddress());
          }
          if (((NetworkInfo)localObject).getType() == 9)
          {
            paramContext = a();
            return paramContext;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      QLog.d("IPUtils", 1, paramContext.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.IPUtils
 * JD-Core Version:    0.7.0.1
 */