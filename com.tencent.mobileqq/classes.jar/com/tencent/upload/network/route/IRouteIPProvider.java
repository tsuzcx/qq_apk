package com.tencent.upload.network.route;

public abstract interface IRouteIPProvider
{
  public abstract String getBakIps();
  
  public abstract String getHostUrl();
  
  public abstract String getOptIps();
  
  public abstract String getV6HostUrl();
  
  public abstract String getV6OptIps();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.network.route.IRouteIPProvider
 * JD-Core Version:    0.7.0.1
 */