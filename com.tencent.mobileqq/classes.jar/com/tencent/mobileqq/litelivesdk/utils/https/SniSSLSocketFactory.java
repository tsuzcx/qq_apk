package com.tencent.mobileqq.litelivesdk.utils.https;

import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SniSSLSocketFactory
  extends SSLSocketFactory
{
  private String jdField_a_of_type_JavaLangString;
  HostnameVerifier jdField_a_of_type_JavaxNetSslHostnameVerifier;
  
  public Socket createSocket()
  {
    return SSLCertificateSocketFactory.getDefault(0).createSocket();
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    return SSLCertificateSocketFactory.getDefault(0).createSocket(paramString, paramInt);
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    return SSLCertificateSocketFactory.getDefault(0).createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return SSLCertificateSocketFactory.getDefault(0).createSocket(paramInetAddress, paramInt);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return SSLCertificateSocketFactory.getDefault(0).createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
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
      localSSLCertificateSocketFactory.setHostname(paramSocket, this.jdField_a_of_type_JavaLangString);
    }
    try
    {
      paramSocket.getClass().getMethod("setHostname", new Class[] { String.class }).invoke(paramSocket, new Object[] { this.jdField_a_of_type_JavaLangString });
    }
    catch (Exception paramString)
    {
      label100:
      break label100;
    }
    paramString = paramSocket.getSession();
    if (this.jdField_a_of_type_JavaxNetSslHostnameVerifier == null) {
      this.jdField_a_of_type_JavaxNetSslHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
    }
    if (this.jdField_a_of_type_JavaxNetSslHostnameVerifier.verify(this.jdField_a_of_type_JavaLangString, paramString)) {
      return paramSocket;
    }
    paramSocket = new StringBuilder();
    paramSocket.append("Cannot verify hostname: ");
    paramSocket.append(this.jdField_a_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.https.SniSSLSocketFactory
 * JD-Core Version:    0.7.0.1
 */