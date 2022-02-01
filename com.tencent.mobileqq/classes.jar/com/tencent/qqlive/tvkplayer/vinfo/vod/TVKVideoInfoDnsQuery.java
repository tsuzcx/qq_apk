package com.tencent.qqlive.tvkplayer.vinfo.vod;

import java.io.PrintStream;
import java.net.InetAddress;
import java.util.ArrayList;

public class TVKVideoInfoDnsQuery
  extends Thread
{
  String hostName = "";
  ArrayList<String> ipv4 = new ArrayList();
  ArrayList<String> ipv6 = new ArrayList();
  
  public TVKVideoInfoDnsQuery(String paramString)
  {
    this.hostName = paramString;
  }
  
  private void addIPv4(String paramString)
  {
    try
    {
      this.ipv4.add(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void addIPv6(String paramString)
  {
    try
    {
      this.ipv6.add(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public ArrayList<String> getDnsIpv4()
  {
    try
    {
      ArrayList localArrayList = this.ipv4;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ArrayList<String> getDnsIpv6()
  {
    try
    {
      ArrayList localArrayList = this.ipv6;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void run()
  {
    try
    {
      l1 = System.currentTimeMillis();
      localObject1 = System.out;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("dns:");
      ((StringBuilder)localObject2).append(this.hostName);
      ((StringBuilder)localObject2).append(" begin");
      ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
      localObject1 = InetAddress.getAllByName(this.hostName);
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1;
        Object localObject1;
        Object localObject2;
        int i;
        StringBuilder localStringBuilder;
        long l2;
        continue;
        i += 1;
      }
    }
    if (i < localObject1.length)
    {
      localObject2 = System.out;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dns:");
      localStringBuilder.append(this.hostName);
      localStringBuilder.append(" result:");
      localStringBuilder.append(localObject1[i].getHostAddress());
      localStringBuilder.append(" byte[] length:");
      localStringBuilder.append(localObject1[i].getAddress().length);
      ((PrintStream)localObject2).println(localStringBuilder.toString());
      if (localObject1[i].getAddress().length == 16) {
        addIPv6(localObject1[i].getHostAddress());
      } else {
        addIPv4(localObject1[i].getHostAddress());
      }
    }
    else
    {
      l2 = System.currentTimeMillis();
      localObject1 = System.out;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("dns:");
      ((StringBuilder)localObject2).append(this.hostName);
      ((StringBuilder)localObject2).append(" elaspe:");
      ((StringBuilder)localObject2).append(l2 - l1);
      ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
      return;
      System.out.println("Could not find getvinfo host");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVideoInfoDnsQuery
 * JD-Core Version:    0.7.0.1
 */