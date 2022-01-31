package com.tencent.qapmsdk.socket.ssl;

import android.net.SSLCertificateSocketFactory;
import android.support.annotation.Keep;
import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.socket.util.ReflectionHelper;
import com.tencent.qapmsdk.socket.util.ReflectionHelper.Cache;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.SSLSocketFactory;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class TrafficSSLSocketFactory
  extends SSLSocketFactory
{
  private static final String TAG = "QAPM_Socket_TrafficSSLSocketFactory";
  @Keep
  private Object sslParameters;
  private SSLSocketFactory sslSocketFactory;
  
  @Keep
  public TrafficSSLSocketFactory()
  {
    this((SSLSocketFactory)ReflectionHelper.of(SSLContextSpi.class).method("engineGetSocketFactory", new Class[0]).invoke(new TrafficSSLContextImpl.Default().openSslContextImpl, new Object[0]));
  }
  
  public TrafficSSLSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    this.sslSocketFactory = paramSSLSocketFactory;
    for (;;)
    {
      try
      {
        if ((paramSSLSocketFactory instanceof SSLCertificateSocketFactory))
        {
          paramSSLSocketFactory = (SSLSocketFactory)ReflectionHelper.of(SSLCertificateSocketFactory.class).method("getDelegate", new Class[0]).invoke(paramSSLSocketFactory, new Object[0]);
          this.sslParameters = ReflectionHelper.of(ReflectionHelper.getOpenSSLPackageName() + ".OpenSSLSocketFactoryImpl").field("sslParameters").get(paramSSLSocketFactory);
          return;
        }
      }
      catch (Exception paramSSLSocketFactory)
      {
        Logger.INSTANCE.w(new String[] { "QAPM_Socket_TrafficSSLSocketFactory", "set sslParameters failed: ", paramSSLSocketFactory.toString() });
        return;
      }
    }
  }
  
  public Socket createSocket()
  {
    return new TrafficSSLSocket(this.sslSocketFactory.createSocket(), (String)null, 0);
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    return new TrafficSSLSocket(this.sslSocketFactory.createSocket(paramString, paramInt), paramString, paramInt);
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    return new TrafficSSLSocket(this.sslSocketFactory.createSocket(paramString, paramInt1, paramInetAddress, paramInt2), paramString, paramInt1);
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return new TrafficSSLSocket(this.sslSocketFactory.createSocket(paramInetAddress, paramInt), paramInetAddress, paramInt);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return new TrafficSSLSocket(this.sslSocketFactory.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2), paramInetAddress1, paramInt1);
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return new TrafficSSLSocket(this.sslSocketFactory.createSocket(paramSocket, paramString, paramInt, paramBoolean), paramString, paramInt);
  }
  
  public String[] getDefaultCipherSuites()
  {
    return this.sslSocketFactory.getDefaultCipherSuites();
  }
  
  public String[] getSupportedCipherSuites()
  {
    return this.sslSocketFactory.getSupportedCipherSuites();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.ssl.TrafficSSLSocketFactory
 * JD-Core Version:    0.7.0.1
 */