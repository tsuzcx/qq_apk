package com.tencent.mobileqq.msf.core.net.c;

import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class c$a
  implements X509TrustManager
{
  private X509TrustManager a;
  
  c$a()
  {
    Object localObject = KeyStore.getInstance("JKS");
    ((KeyStore)localObject).load(new FileInputStream("trustedCerts"), "passphrase".toCharArray());
    TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
    localTrustManagerFactory.init((KeyStore)localObject);
    localObject = localTrustManagerFactory.getTrustManagers();
    int i = 0;
    while (i < localObject.length)
    {
      if ((localObject[i] instanceof X509TrustManager))
      {
        this.a = ((X509TrustManager)localObject[i]);
        return;
      }
      i += 1;
    }
    localObject = new Exception("Couldn't initialize");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    X509TrustManager localX509TrustManager = this.a;
    if (localX509TrustManager != null) {
      localX509TrustManager.checkClientTrusted(paramArrayOfX509Certificate, paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.QualityTestManager", 2, "checkClientTrusted");
    }
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    X509TrustManager localX509TrustManager = this.a;
    if (localX509TrustManager != null) {
      localX509TrustManager.checkServerTrusted(paramArrayOfX509Certificate, paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.QualityTestManager", 2, "checkServerTrusted");
    }
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    X509TrustManager localX509TrustManager = this.a;
    if (localX509TrustManager != null) {
      return localX509TrustManager.getAcceptedIssuers();
    }
    return new X509Certificate[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.c.a
 * JD-Core Version:    0.7.0.1
 */