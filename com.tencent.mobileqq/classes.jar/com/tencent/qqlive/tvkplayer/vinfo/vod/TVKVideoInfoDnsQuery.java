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
    for (;;)
    {
      long l1;
      int i;
      try
      {
        l1 = System.currentTimeMillis();
        System.out.println("dns:" + this.hostName + " begin");
        InetAddress[] arrayOfInetAddress = InetAddress.getAllByName(this.hostName);
        i = 0;
        if (i < arrayOfInetAddress.length)
        {
          System.out.println("dns:" + this.hostName + " result:" + arrayOfInetAddress[i].getHostAddress() + " byte[] length:" + arrayOfInetAddress[i].getAddress().length);
          if (arrayOfInetAddress[i].getAddress().length == 16) {
            addIPv6(arrayOfInetAddress[i].getHostAddress());
          } else {
            addIPv4(arrayOfInetAddress[i].getHostAddress());
          }
        }
      }
      catch (Exception localException)
      {
        System.out.println("Could not find getvinfo host");
        return;
      }
      long l2 = System.currentTimeMillis();
      System.out.println("dns:" + this.hostName + " elaspe:" + (l2 - l1));
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVideoInfoDnsQuery
 * JD-Core Version:    0.7.0.1
 */