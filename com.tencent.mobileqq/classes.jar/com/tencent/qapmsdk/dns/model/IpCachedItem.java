package com.tencent.qapmsdk.dns.model;

public class IpCachedItem
{
  public double avgElapse;
  public int hitTime;
  public String ip;
  
  public IpCachedItem(String paramString)
  {
    this.ip = paramString;
  }
  
  public String toString()
  {
    return "IpCachedItem{ip='" + this.ip + '\'' + ", hitTime=" + this.hitTime + ", avgElapse=" + this.avgElapse + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.model.IpCachedItem
 * JD-Core Version:    0.7.0.1
 */