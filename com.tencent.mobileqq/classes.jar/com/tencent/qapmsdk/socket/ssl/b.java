package com.tencent.qapmsdk.socket.ssl;

import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.socket.d.d;
import com.tencent.qapmsdk.socket.d.d.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class b
  extends SSLContextSpi
{
  private static final String b;
  private static final Map<Class<?>, Constructor<?>> c = new ConcurrentHashMap();
  SSLContextSpi a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d.a());
    localStringBuilder.append(".OpenSSLContextImpl");
    b = localStringBuilder.toString();
  }
  
  public b() {}
  
  b(String[] paramArrayOfString)
  {
    this.a = ((SSLContextSpi)b(getClass(), paramArrayOfString).newInstance(new Object[0]));
  }
  
  private static Constructor<?> b(Class<?> paramClass, String[] paramArrayOfString)
  {
    Object localObject = (Constructor)c.get(paramClass);
    if (localObject == null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localObject = paramArrayOfString[i];
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(b);
          localStringBuilder.append("$");
          localStringBuilder.append((String)localObject);
          localObject = d.a(localStringBuilder.toString()).a(new Class[0]);
          c.put(paramClass, localObject);
          return localObject;
        }
        catch (Exception localException)
        {
          label100:
          break label100;
        }
        i += 1;
      }
      paramArrayOfString = d.a(b).a(new Class[0]);
      c.put(paramClass, paramArrayOfString);
      return paramArrayOfString;
    }
    else
    {
      return localObject;
    }
  }
  
  protected SSLEngine engineCreateSSLEngine()
  {
    try
    {
      SSLEngine localSSLEngine1 = (SSLEngine)d.a(SSLContextSpi.class).a("engineCreateSSLEngine", new Class[0]).invoke(this.a, new Object[0]);
      return localSSLEngine1;
    }
    catch (Exception localException)
    {
      d.a(localException);
    }
    try
    {
      SSLEngine localSSLEngine2 = SSLContext.getDefault().createSSLEngine();
      return localSSLEngine2;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      label45:
      break label45;
    }
    return null;
  }
  
  protected SSLEngine engineCreateSSLEngine(String paramString, int paramInt)
  {
    try
    {
      SSLEngine localSSLEngine = (SSLEngine)d.a(SSLContextSpi.class).a("engineCreateSSLEngine", new Class[] { String.class, Integer.TYPE }).invoke(this.a, new Object[] { paramString, Integer.valueOf(paramInt) });
      return localSSLEngine;
    }
    catch (Exception localException)
    {
      d.a(localException);
    }
    try
    {
      paramString = SSLContext.getDefault().createSSLEngine(paramString, paramInt);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      label69:
      break label69;
    }
    return null;
  }
  
  protected SSLSessionContext engineGetClientSessionContext()
  {
    try
    {
      SSLSessionContext localSSLSessionContext1 = (SSLSessionContext)d.a(SSLContextSpi.class).a("engineGetClientSessionContext", new Class[0]).invoke(this.a, new Object[0]);
      return localSSLSessionContext1;
    }
    catch (Exception localException)
    {
      d.a(localException);
    }
    try
    {
      SSLSessionContext localSSLSessionContext2 = SSLContext.getDefault().getClientSessionContext();
      return localSSLSessionContext2;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      label45:
      break label45;
    }
    return null;
  }
  
  protected SSLParameters engineGetDefaultSSLParameters()
  {
    try
    {
      SSLParameters localSSLParameters = (SSLParameters)d.a(SSLContextSpi.class).a("engineGetDefaultSSLParameters", new Class[0]).invoke(this.a, new Object[0]);
      return localSSLParameters;
    }
    catch (Exception localException)
    {
      d.a(localException);
    }
    return super.engineGetDefaultSSLParameters();
  }
  
  protected SSLSessionContext engineGetServerSessionContext()
  {
    try
    {
      SSLSessionContext localSSLSessionContext1 = (SSLSessionContext)d.a(SSLContextSpi.class).a("engineGetServerSessionContext", new Class[0]).invoke(this.a, new Object[0]);
      return localSSLSessionContext1;
    }
    catch (Exception localException)
    {
      d.a(localException);
    }
    try
    {
      SSLSessionContext localSSLSessionContext2 = SSLContext.getDefault().getServerSessionContext();
      return localSSLSessionContext2;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      label45:
      break label45;
    }
    return null;
  }
  
  protected SSLServerSocketFactory engineGetServerSocketFactory()
  {
    try
    {
      SSLServerSocketFactory localSSLServerSocketFactory = (SSLServerSocketFactory)d.a(SSLContextSpi.class).a("engineGetServerSocketFactory", new Class[0]).invoke(this.a, new Object[0]);
      return localSSLServerSocketFactory;
    }
    catch (Exception localException)
    {
      d.a(localException);
    }
    return (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
  }
  
  protected SSLSocketFactory engineGetSocketFactory()
  {
    try
    {
      TrafficSSLSocketFactory localTrafficSSLSocketFactory = new TrafficSSLSocketFactory((SSLSocketFactory)d.a(SSLContextSpi.class).a("engineGetSocketFactory", new Class[0]).invoke(this.a, new Object[0]));
      return localTrafficSSLSocketFactory;
    }
    catch (Exception localException)
    {
      d.a(localException);
    }
    return (SSLSocketFactory)SSLSocketFactory.getDefault();
  }
  
  protected SSLParameters engineGetSupportedSSLParameters()
  {
    try
    {
      SSLParameters localSSLParameters = (SSLParameters)d.a(SSLContextSpi.class).a("engineGetSupportedSSLParameters", new Class[0]).invoke(this.a, new Object[0]);
      return localSSLParameters;
    }
    catch (Exception localException)
    {
      d.a(localException);
    }
    return super.engineGetSupportedSSLParameters();
  }
  
  protected void engineInit(KeyManager[] paramArrayOfKeyManager, TrustManager[] paramArrayOfTrustManager, SecureRandom paramSecureRandom)
  {
    try
    {
      d.a(SSLContextSpi.class).a("engineInit", new Class[] { [Ljavax.net.ssl.KeyManager.class, [Ljavax.net.ssl.TrustManager.class, SecureRandom.class }).invoke(this.a, new Object[] { paramArrayOfKeyManager, paramArrayOfTrustManager, paramSecureRandom });
      return;
    }
    catch (Exception paramArrayOfKeyManager)
    {
      if (((paramArrayOfKeyManager instanceof InvocationTargetException)) && ((paramArrayOfKeyManager.getCause() instanceof KeyManagementException))) {
        throw ((KeyManagementException)paramArrayOfKeyManager.getCause());
      }
      d.a(paramArrayOfKeyManager);
      throw new KeyManagementException(paramArrayOfKeyManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.ssl.b
 * JD-Core Version:    0.7.0.1
 */