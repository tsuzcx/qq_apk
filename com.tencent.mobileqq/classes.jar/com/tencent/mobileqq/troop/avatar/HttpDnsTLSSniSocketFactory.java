package com.tencent.mobileqq.troop.avatar;

import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.security.cert.X509Certificate;

public class HttpDnsTLSSniSocketFactory
  extends SSLSocketFactory
{
  HostnameVerifier a = HttpsURLConnection.getDefaultHostnameVerifier();
  private final String b = HttpDnsTLSSniSocketFactory.class.getSimpleName();
  private HttpsURLConnection c;
  
  public HttpDnsTLSSniSocketFactory(HttpsURLConnection paramHttpsURLConnection)
  {
    this.c = paramHttpsURLConnection;
  }
  
  private void a(SSLSession paramSSLSession)
  {
    try
    {
      QLog.e("httpsSSLProcess,HostnameVerifier", 1, "httpsSSLProcess,PeerCertificates ---------------------");
      Certificate[] arrayOfCertificate = paramSSLSession.getPeerCertificates();
      int j = 0;
      int k;
      int i;
      if (arrayOfCertificate != null)
      {
        k = arrayOfCertificate.length;
        i = 0;
        while (i < k)
        {
          QLog.e("httpsSSLProcess,HostnameVerifier", 1, arrayOfCertificate[i].toString());
          i += 1;
        }
      }
      QLog.e("httpsSSLProcess,HostnameVerifier", 1, "httpsSSLProcess,LocalCertificates ---------------------");
      arrayOfCertificate = paramSSLSession.getLocalCertificates();
      if (arrayOfCertificate != null)
      {
        k = arrayOfCertificate.length;
        i = 0;
        while (i < k)
        {
          QLog.e("httpsSSLProcess,HostnameVerifier", 1, arrayOfCertificate[i].toString());
          i += 1;
        }
      }
      QLog.e("httpsSSLProcess,HostnameVerifier", 1, "httpsSSLProcess,PeerCertificateChain ---------------------");
      paramSSLSession = paramSSLSession.getPeerCertificateChain();
      if (paramSSLSession != null)
      {
        k = paramSSLSession.length;
        i = j;
        while (i < k)
        {
          QLog.e("httpsSSLProcess,HostnameVerifier", 1, paramSSLSession[i].toString());
          i += 1;
        }
      }
      QLog.e("httpsSSLProcess,HostnameVerifier", 1, "--------------------- end ---------------------");
      return;
    }
    catch (SSLPeerUnverifiedException paramSSLSession)
    {
      paramSSLSession.printStackTrace();
    }
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
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = this.c.getRequestProperty("Host");
    if (localObject1 != null) {
      paramString = (String)localObject1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = this.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("customized createSocket. host: ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = paramSocket.getInetAddress();
    if (paramBoolean) {
      paramSocket.close();
    }
    Object localObject2 = (SSLCertificateSocketFactory)SSLCertificateSocketFactory.getDefault(0);
    paramSocket = (SSLSocket)((SSLCertificateSocketFactory)localObject2).createSocket((InetAddress)localObject1, paramInt);
    paramSocket.setEnabledProtocols(paramSocket.getSupportedProtocols());
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.b, 2, "Setting SNI hostname");
      }
      ((SSLCertificateSocketFactory)localObject2).setHostname(paramSocket, paramString);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.b, 2, "No documented SNI support on Android <4.2, trying with reflection");
      }
      try
      {
        paramSocket.getClass().getMethod("setHostname", new Class[] { String.class }).invoke(paramSocket, new Object[] { paramString });
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    SSLSession localSSLSession = paramSocket.getSession();
    if (!this.a.verify(paramString, localSSLSession))
    {
      if (localSSLSession == null) {
        QLog.e("httpsSSLProcess,HostnameVerifier", 1, "!!!session null!!!");
      } else {
        a(localSSLSession);
      }
      paramSocket.close();
      paramSocket = new StringBuilder();
      paramSocket.append("Cannot verify hostname: ");
      paramSocket.append(paramString);
      throw new SSLPeerUnverifiedException(paramSocket.toString());
    }
    if (QLog.isColorLevel())
    {
      paramString = this.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Established ");
      ((StringBuilder)localObject2).append(localSSLSession.getProtocol());
      ((StringBuilder)localObject2).append(" connection with ");
      ((StringBuilder)localObject2).append(localSSLSession.getPeerHost());
      ((StringBuilder)localObject2).append(" using ");
      ((StringBuilder)localObject2).append(localSSLSession.getCipherSuite());
      QLog.d(paramString, 2, ((StringBuilder)localObject2).toString());
    }
    return paramSocket;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.HttpDnsTLSSniSocketFactory
 * JD-Core Version:    0.7.0.1
 */