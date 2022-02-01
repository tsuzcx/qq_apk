package com.tencent.mobileqq.msf.core.net.utils;

import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.params.HttpParams;

public class f
  implements LayeredSocketFactory
{
  static final HostnameVerifier a = new StrictHostnameVerifier();
  private static final String c = "SNISocketFactory";
  SSLCertificateSocketFactory b = (SSLCertificateSocketFactory)SSLCertificateSocketFactory.getInsecure(0, null);
  private String d;
  
  public f(String paramString)
  {
    this.d = paramString;
  }
  
  public Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams)
  {
    paramSocket.connect(new InetSocketAddress(paramString, paramInt1));
    return paramSocket;
  }
  
  public Socket createSocket()
  {
    return new Socket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createSocket ");
      ((StringBuilder)localObject).append(paramSocket.toString());
      ((StringBuilder)localObject).append(" host:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" port:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" autoClose:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("SNISocketFactory", 2, ((StringBuilder)localObject).toString());
    }
    paramSocket = (SSLSocket)this.b.createSocket(paramSocket, paramString, paramInt, paramBoolean);
    paramSocket.setEnabledProtocols(paramSocket.getSupportedProtocols());
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SNISocketFactory", 2, "Setting SNI hostname");
      }
      this.b.setHostname(paramSocket, paramString);
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("SNISocketFactory", 2, "No documented SNI support on Android <4.2, trying with reflection");
    }
    try
    {
      paramSocket.getClass().getMethod("setHostname", new Class[] { String.class }).invoke(paramSocket, new Object[] { paramString });
    }
    catch (Exception localException)
    {
      label196:
      break label196;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SNISocketFactory", 2, "SNI not useable");
    }
    Object localObject = paramSocket.getSession();
    if (a.verify(paramString, (SSLSession)localObject))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("Established ");
        paramString.append(((SSLSession)localObject).getProtocol());
        paramString.append(" connection with ");
        paramString.append(((SSLSession)localObject).getPeerHost());
        paramString.append(" using ");
        paramString.append(((SSLSession)localObject).getCipherSuite());
        QLog.i("SNISocketFactory", 2, paramString.toString());
      }
      return paramSocket;
    }
    paramSocket = new StringBuilder();
    paramSocket.append("Cannot verify hostname: ");
    paramSocket.append(paramString);
    throw new SSLPeerUnverifiedException(paramSocket.toString());
  }
  
  public boolean isSecure(Socket paramSocket)
  {
    if ((paramSocket instanceof SSLSocket)) {
      return ((SSLSocket)paramSocket).isConnected();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.f
 * JD-Core Version:    0.7.0.1
 */