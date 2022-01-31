package com.tencent.qapmsdk.socket.ssl;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.socket.util.ReflectionHelper;
import com.tencent.qapmsdk.socket.util.ReflectionHelper.Cache;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class TrafficSSLContextImpl$Default
  extends TrafficSSLContextImpl
{
  private static final String[] PROTOCOLS = { "TLSv12", "TLSv11", "TLSv1", "SSLv3" };
  
  public TrafficSSLContextImpl$Default()
  {
    try
    {
      this.openSslContextImpl = ((SSLContextSpi)ReflectionHelper.of(ReflectionHelper.getOpenSSLPackageName() + ".DefaultSSLContextImpl").constructor(new Class[0]).newInstance(new Object[0]));
      return;
    }
    catch (Exception localException1)
    {
      Logger.INSTANCE.exception("QAPM_Socket_TrafficSSLContextImpl", "new DefaultSSLContextImpl failed, try OpenSSLContextImpl!", localException1);
      this.openSslContextImpl = ((SSLContextSpi)TrafficSSLContextImpl.access$000(getClass(), PROTOCOLS).newInstance(new Object[0]));
      try
      {
        TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        localTrustManagerFactory.init((KeyStore)null);
        ReflectionHelper.of(SSLContextSpi.class).method("engineInit", new Class[] { [Ljavax.net.ssl.KeyManager.class, [Ljavax.net.ssl.TrustManager.class, SecureRandom.class }).invoke(this.openSslContextImpl, new Object[] { null, localTrustManagerFactory.getTrustManagers(), new SecureRandom() });
        return;
      }
      catch (Exception localException2)
      {
        Logger.INSTANCE.exception("QAPM_Socket_TrafficSSLContextImpl", "init OpenSSLContextImpl failed", localException2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.ssl.TrafficSSLContextImpl.Default
 * JD-Core Version:    0.7.0.1
 */