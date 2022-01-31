package com.tencent.qapmsdk.dns.model;

import java.net.InetAddress;

public class DnsInfo$DNS
{
  public long dnsTime;
  public boolean hasReport;
  public InetAddress[] inetAddresses;
  
  public DnsInfo$DNS(InetAddress[] paramArrayOfInetAddress, long paramLong)
  {
    this.inetAddresses = paramArrayOfInetAddress;
    this.dnsTime = paramLong;
    this.hasReport = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.model.DnsInfo.DNS
 * JD-Core Version:    0.7.0.1
 */