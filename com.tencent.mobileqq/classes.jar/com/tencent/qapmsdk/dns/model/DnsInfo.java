package com.tencent.qapmsdk.dns.model;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DnsInfo
{
  private static final ConcurrentHashMap<String, DnsInfo.DNS> dnsMap = new ConcurrentHashMap();
  
  public static void clear()
  {
    dnsMap.clear();
  }
  
  public static long getDnsElapse(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (dnsMap.get(paramString) == null)) {
      return 0L;
    }
    DnsInfo.DNS localDNS = (DnsInfo.DNS)dnsMap.get(paramString);
    if (!localDNS.hasReport)
    {
      localDNS.hasReport = true;
      dnsMap.put(paramString, localDNS);
      return localDNS.dnsTime;
    }
    return 0L;
  }
  
  public static String getHostFromIp(String paramString)
  {
    Iterator localIterator = dnsMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      InetAddress[] arrayOfInetAddress = ((DnsInfo.DNS)dnsMap.get(str)).inetAddresses;
      int j = arrayOfInetAddress.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(arrayOfInetAddress[i].getHostAddress())) {
          return str;
        }
        i += 1;
      }
    }
    return paramString;
  }
  
  public static void remove(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (dnsMap.get(paramString) != null)) {
      dnsMap.remove(paramString);
    }
  }
  
  public static void setDns(String paramString, InetAddress[] paramArrayOfInetAddress, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramLong >= 0L) && (dnsMap.get(paramString) == null)) {
      dnsMap.put(paramString, new DnsInfo.DNS(paramArrayOfInetAddress, paramLong));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.model.DnsInfo
 * JD-Core Version:    0.7.0.1
 */