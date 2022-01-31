package com.tencent.qapmsdk.impl.socket;

public enum UrlBuilder$Scheme
{
  HTTP("http", 80),  HTTPS("https", 443);
  
  private String name;
  private int port;
  
  private UrlBuilder$Scheme(String paramString, int paramInt)
  {
    this.name = paramString;
    this.port = paramInt;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getPort()
  {
    return this.port;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.socket.UrlBuilder.Scheme
 * JD-Core Version:    0.7.0.1
 */