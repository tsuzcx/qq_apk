package com.tencent.mobileqq.utils.httputils;

import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SniSSLSocketFactory
  extends SSLSocketFactory
{
  private static final String TAG = "SniSSLSocketFactory";
  private HttpsURLConnection conn;
  HostnameVerifier mHostnameVerifier;
  private String mReqHost;
  
  public SniSSLSocketFactory(String paramString, HostnameVerifier paramHostnameVerifier)
  {
    this.mReqHost = paramString;
    this.mHostnameVerifier = paramHostnameVerifier;
  }
  
  public Socket createSocket()
  {
    return null;
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
  
  @TargetApi(17)
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    paramString = paramSocket.getInetAddress();
    if (paramBoolean) {
      paramSocket.close();
    }
    SSLCertificateSocketFactory localSSLCertificateSocketFactory = (SSLCertificateSocketFactory)SSLCertificateSocketFactory.getDefault(0);
    paramSocket = (SSLSocket)localSSLCertificateSocketFactory.createSocket(paramString, paramInt);
    paramSocket.setEnabledProtocols(paramSocket.getSupportedProtocols());
    if (Build.VERSION.SDK_INT >= 17) {
      localSSLCertificateSocketFactory.setHostname(paramSocket, this.mReqHost);
    }
    try
    {
      paramSocket.getClass().getMethod("setHostname", new Class[] { String.class }).invoke(paramSocket, new Object[] { this.mReqHost });
    }
    catch (Exception paramString)
    {
      label100:
      break label100;
    }
    paramString = paramSocket.getSession();
    if (this.mHostnameVerifier == null) {
      this.mHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
    }
    if (this.mHostnameVerifier.verify(this.mReqHost, paramString)) {
      return paramSocket;
    }
    paramSocket = new StringBuilder();
    paramSocket.append("Cannot verify hostname: ");
    paramSocket.append(this.mReqHost);
    throw new SSLPeerUnverifiedException(paramSocket.toString());
  }
  
  public String[] getDefaultCipherSuites()
  {
    return new String[0];
  }
  
  public String[] getSupportedCipherSuites()
  {
    return new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.SniSSLSocketFactory
 * JD-Core Version:    0.7.0.1
 */