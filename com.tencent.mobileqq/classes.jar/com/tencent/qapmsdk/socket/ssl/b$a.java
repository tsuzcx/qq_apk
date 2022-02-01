package com.tencent.qapmsdk.socket.ssl;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.socket.d.d;
import com.tencent.qapmsdk.socket.d.d.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class b$a
  extends b
{
  private static final String[] b = { "TLSv12", "TLSv11", "TLSv1", "SSLv3" };
  
  public b$a()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(d.a());
      localStringBuilder.append(".DefaultSSLContextImpl");
      this.a = ((SSLContextSpi)d.a(localStringBuilder.toString()).a(new Class[0]).newInstance(new Object[0]));
      return;
    }
    catch (Exception localException1)
    {
      Logger.INSTANCE.exception("QAPM_Socket_TrafficSSLContextImpl", "new DefaultSSLContextImpl failed, try OpenSSLContextImpl!", localException1);
      this.a = ((SSLContextSpi)b.a(getClass(), b).newInstance(new Object[0]));
      try
      {
        TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        localTrustManagerFactory.init((KeyStore)null);
        d.a(SSLContextSpi.class).a("engineInit", new Class[] { [Ljavax.net.ssl.KeyManager.class, [Ljavax.net.ssl.TrustManager.class, SecureRandom.class }).invoke(this.a, new Object[] { null, localTrustManagerFactory.getTrustManagers(), new SecureRandom() });
        return;
      }
      catch (Exception localException2)
      {
        Logger.INSTANCE.exception("QAPM_Socket_TrafficSSLContextImpl", "init OpenSSLContextImpl failed", localException2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.ssl.b.a
 * JD-Core Version:    0.7.0.1
 */