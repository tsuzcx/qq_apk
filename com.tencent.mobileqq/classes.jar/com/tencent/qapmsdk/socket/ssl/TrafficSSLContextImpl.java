package com.tencent.qapmsdk.socket.ssl;

import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.socket.util.ReflectionHelper;
import com.tencent.qapmsdk.socket.util.ReflectionHelper.Cache;
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
public class TrafficSSLContextImpl
  extends SSLContextSpi
{
  private static final String CLASSNAME_OPEN_SSL_CONTEXT_IMPL = ReflectionHelper.getOpenSSLPackageName() + ".OpenSSLContextImpl";
  private static final Map<Class<?>, Constructor<?>> PROTOCOL_CONSTRUCTOR_CACHE = new ConcurrentHashMap();
  private static final String TAG = "QAPM_Socket_TrafficSSLContextImpl";
  SSLContextSpi openSslContextImpl;
  
  public TrafficSSLContextImpl() {}
  
  TrafficSSLContextImpl(String[] paramArrayOfString)
  {
    this.openSslContextImpl = ((SSLContextSpi)getProtocolConstructor(getClass(), paramArrayOfString).newInstance(new Object[0]));
  }
  
  private static Constructor<?> getProtocolConstructor(Class<?> paramClass, String[] paramArrayOfString)
  {
    Constructor localConstructor = (Constructor)PROTOCOL_CONSTRUCTOR_CACHE.get(paramClass);
    Object localObject = localConstructor;
    int j;
    int i;
    if (localConstructor == null)
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    while (i < j)
    {
      localObject = paramArrayOfString[i];
      try
      {
        localObject = ReflectionHelper.of(CLASSNAME_OPEN_SSL_CONTEXT_IMPL + "$" + (String)localObject).constructor(new Class[0]);
        PROTOCOL_CONSTRUCTOR_CACHE.put(paramClass, localObject);
        return localObject;
      }
      catch (Exception localException)
      {
        i += 1;
      }
    }
    paramArrayOfString = ReflectionHelper.of(CLASSNAME_OPEN_SSL_CONTEXT_IMPL).constructor(new Class[0]);
    PROTOCOL_CONSTRUCTOR_CACHE.put(paramClass, paramArrayOfString);
    return paramArrayOfString;
  }
  
  protected SSLEngine engineCreateSSLEngine()
  {
    try
    {
      SSLEngine localSSLEngine1 = (SSLEngine)ReflectionHelper.of(SSLContextSpi.class).method("engineCreateSSLEngine", new Class[0]).invoke(this.openSslContextImpl, new Object[0]);
      return localSSLEngine1;
    }
    catch (Exception localException)
    {
      ReflectionHelper.processException(localException);
      try
      {
        SSLEngine localSSLEngine2 = SSLContext.getDefault().createSSLEngine();
        return localSSLEngine2;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    }
    return null;
  }
  
  protected SSLEngine engineCreateSSLEngine(String paramString, int paramInt)
  {
    try
    {
      SSLEngine localSSLEngine = (SSLEngine)ReflectionHelper.of(SSLContextSpi.class).method("engineCreateSSLEngine", new Class[] { String.class, Integer.TYPE }).invoke(this.openSslContextImpl, new Object[] { paramString, Integer.valueOf(paramInt) });
      return localSSLEngine;
    }
    catch (Exception localException)
    {
      ReflectionHelper.processException(localException);
      try
      {
        paramString = SSLContext.getDefault().createSSLEngine(paramString, paramInt);
        return paramString;
      }
      catch (NoSuchAlgorithmException paramString) {}
    }
    return null;
  }
  
  protected SSLSessionContext engineGetClientSessionContext()
  {
    try
    {
      SSLSessionContext localSSLSessionContext1 = (SSLSessionContext)ReflectionHelper.of(SSLContextSpi.class).method("engineGetClientSessionContext", new Class[0]).invoke(this.openSslContextImpl, new Object[0]);
      return localSSLSessionContext1;
    }
    catch (Exception localException)
    {
      ReflectionHelper.processException(localException);
      try
      {
        SSLSessionContext localSSLSessionContext2 = SSLContext.getDefault().getClientSessionContext();
        return localSSLSessionContext2;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    }
    return null;
  }
  
  protected SSLParameters engineGetDefaultSSLParameters()
  {
    try
    {
      SSLParameters localSSLParameters = (SSLParameters)ReflectionHelper.of(SSLContextSpi.class).method("engineGetDefaultSSLParameters", new Class[0]).invoke(this.openSslContextImpl, new Object[0]);
      return localSSLParameters;
    }
    catch (Exception localException)
    {
      ReflectionHelper.processException(localException);
    }
    return super.engineGetDefaultSSLParameters();
  }
  
  protected SSLSessionContext engineGetServerSessionContext()
  {
    try
    {
      SSLSessionContext localSSLSessionContext1 = (SSLSessionContext)ReflectionHelper.of(SSLContextSpi.class).method("engineGetServerSessionContext", new Class[0]).invoke(this.openSslContextImpl, new Object[0]);
      return localSSLSessionContext1;
    }
    catch (Exception localException)
    {
      ReflectionHelper.processException(localException);
      try
      {
        SSLSessionContext localSSLSessionContext2 = SSLContext.getDefault().getServerSessionContext();
        return localSSLSessionContext2;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    }
    return null;
  }
  
  protected SSLServerSocketFactory engineGetServerSocketFactory()
  {
    try
    {
      SSLServerSocketFactory localSSLServerSocketFactory = (SSLServerSocketFactory)ReflectionHelper.of(SSLContextSpi.class).method("engineGetServerSocketFactory", new Class[0]).invoke(this.openSslContextImpl, new Object[0]);
      return localSSLServerSocketFactory;
    }
    catch (Exception localException)
    {
      ReflectionHelper.processException(localException);
    }
    return (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
  }
  
  protected SSLSocketFactory engineGetSocketFactory()
  {
    try
    {
      TrafficSSLSocketFactory localTrafficSSLSocketFactory = new TrafficSSLSocketFactory((SSLSocketFactory)ReflectionHelper.of(SSLContextSpi.class).method("engineGetSocketFactory", new Class[0]).invoke(this.openSslContextImpl, new Object[0]));
      return localTrafficSSLSocketFactory;
    }
    catch (Exception localException)
    {
      ReflectionHelper.processException(localException);
    }
    return (SSLSocketFactory)SSLSocketFactory.getDefault();
  }
  
  protected SSLParameters engineGetSupportedSSLParameters()
  {
    try
    {
      SSLParameters localSSLParameters = (SSLParameters)ReflectionHelper.of(SSLContextSpi.class).method("engineGetSupportedSSLParameters", new Class[0]).invoke(this.openSslContextImpl, new Object[0]);
      return localSSLParameters;
    }
    catch (Exception localException)
    {
      ReflectionHelper.processException(localException);
    }
    return super.engineGetSupportedSSLParameters();
  }
  
  protected void engineInit(KeyManager[] paramArrayOfKeyManager, TrustManager[] paramArrayOfTrustManager, SecureRandom paramSecureRandom)
  {
    try
    {
      ReflectionHelper.of(SSLContextSpi.class).method("engineInit", new Class[] { [Ljavax.net.ssl.KeyManager.class, [Ljavax.net.ssl.TrustManager.class, SecureRandom.class }).invoke(this.openSslContextImpl, new Object[] { paramArrayOfKeyManager, paramArrayOfTrustManager, paramSecureRandom });
      return;
    }
    catch (Exception paramArrayOfKeyManager)
    {
      if (((paramArrayOfKeyManager instanceof InvocationTargetException)) && ((paramArrayOfKeyManager.getCause() instanceof KeyManagementException))) {
        throw ((KeyManagementException)paramArrayOfKeyManager.getCause());
      }
      ReflectionHelper.processException(paramArrayOfKeyManager);
      throw new KeyManagementException(paramArrayOfKeyManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.ssl.TrafficSSLContextImpl
 * JD-Core Version:    0.7.0.1
 */