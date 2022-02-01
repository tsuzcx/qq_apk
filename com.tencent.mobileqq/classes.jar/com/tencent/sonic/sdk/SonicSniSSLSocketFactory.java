package com.tencent.sonic.sdk;

import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

class SonicSniSSLSocketFactory
  extends SSLSocketFactory
{
  private static final String TAG = "sonic_SonicSniSSLSocketFactory";
  private final SSLCertificateSocketFactory sslSocketFactory;
  private final String targetHostName;
  
  SonicSniSSLSocketFactory(Context paramContext, String paramString)
  {
    this.targetHostName = paramString;
    this.sslSocketFactory = ((SSLCertificateSocketFactory)SSLCertificateSocketFactory.getDefault(0, new SSLSessionCache(paramContext)));
  }
  
  public static void verifyHostname(Socket paramSocket, String paramString)
  {
    if (!(paramSocket instanceof SSLSocket)) {
      throw new IllegalArgumentException("Attempt to verify non-SSL socket");
    }
    paramSocket = (SSLSocket)paramSocket;
    paramSocket.startHandshake();
    paramSocket = paramSocket.getSession();
    if (paramSocket == null) {
      throw new SSLException("Cannot verify SSL socket without session");
    }
    if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(paramString, paramSocket))
    {
      SonicUtils.log("sonic_SonicSniSSLSocketFactory", 6, "sonic SSL error:Cannot verify hostname" + paramString + ")!");
      throw new SSLPeerUnverifiedException("Cannot verify hostname: " + paramString);
    }
  }
  
  public Socket createSocket()
  {
    return this.sslSocketFactory.createSocket();
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    Socket localSocket = createSocket();
    localSocket.connect(new InetSocketAddress(paramString, paramInt));
    verifyHostname(localSocket, this.targetHostName);
    return localSocket;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    Socket localSocket = createSocket();
    localSocket.bind(new InetSocketAddress(paramInetAddress, paramInt2));
    localSocket.connect(new InetSocketAddress(paramString, paramInt1));
    verifyHostname(localSocket, this.targetHostName);
    return localSocket;
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return this.sslSocketFactory.createSocket(paramInetAddress, paramInt);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return this.sslSocketFactory.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return this.sslSocketFactory.createSocket(paramSocket, this.targetHostName, paramInt, paramBoolean);
  }
  
  public String[] getDefaultCipherSuites()
  {
    return this.sslSocketFactory.getDefaultCipherSuites();
  }
  
  public String[] getSupportedCipherSuites()
  {
    return this.sslSocketFactory.getDefaultCipherSuites();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSniSSLSocketFactory
 * JD-Core Version:    0.7.0.1
 */