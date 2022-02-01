package com.tencent.qapmsdk.socket.ssl;

import javax.net.ssl.SSLException;
import javax.net.ssl.X509TrustManager;

public abstract class c
  implements Cloneable, X509TrustManager
{
  private String a;
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public abstract void a(String paramString, SSLException paramSSLException);
  
  final void a(SSLException paramSSLException)
  {
    a(this.a, paramSSLException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.ssl.c
 * JD-Core Version:    0.7.0.1
 */