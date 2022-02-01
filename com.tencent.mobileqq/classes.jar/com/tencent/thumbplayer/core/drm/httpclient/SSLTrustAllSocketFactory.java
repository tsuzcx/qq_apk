package com.tencent.thumbplayer.core.drm.httpclient;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class SSLTrustAllSocketFactory
  extends SSLSocketFactory
{
  private static final String TAG = "SSLTrustAllSocketFactory";
  private SSLContext mCtx;
  
  public SSLTrustAllSocketFactory()
  {
    try
    {
      this.mCtx = SSLContext.getInstance("TLS");
      this.mCtx.init(null, new TrustManager[] { new SSLTrustAllSocketFactory.SSLTrustAllManager(this) }, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public Socket createSocket()
  {
    return this.mCtx.getSocketFactory().createSocket();
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    return null;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    return null;
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return null;
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return null;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return this.mCtx.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
  
  public String[] getDefaultCipherSuites()
  {
    return null;
  }
  
  public String[] getSupportedCipherSuites()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.SSLTrustAllSocketFactory
 * JD-Core Version:    0.7.0.1
 */