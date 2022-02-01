package com.tencent.tmassistantbase.network;

import javax.net.ssl.SSLContext;

public class d
{
  public static SSLContext a()
  {
    SSLContext localSSLContext = SSLContext.getInstance("SSL");
    localSSLContext.init(null, null, null);
    return localSSLContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.network.d
 * JD-Core Version:    0.7.0.1
 */