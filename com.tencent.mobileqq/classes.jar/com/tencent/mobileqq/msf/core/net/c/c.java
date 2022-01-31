package com.tencent.mobileqq.msf.core.net.c;

import com.tencent.qphone.base.util.QLog;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

final class c
  implements X509TrustManager
{
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.QualityTestManager", 2, "checkClientTrusted");
    }
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.QualityTestManager", 2, "checkServerTrusted");
    }
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return new X509Certificate[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.c
 * JD-Core Version:    0.7.0.1
 */