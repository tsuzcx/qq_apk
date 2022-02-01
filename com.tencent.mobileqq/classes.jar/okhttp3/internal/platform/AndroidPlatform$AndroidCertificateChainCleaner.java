package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.tls.CertificateChainCleaner;

final class AndroidPlatform$AndroidCertificateChainCleaner
  extends CertificateChainCleaner
{
  private final Method checkServerTrusted;
  private final Object x509TrustManagerExtensions;
  
  AndroidPlatform$AndroidCertificateChainCleaner(Object paramObject, Method paramMethod)
  {
    this.x509TrustManagerExtensions = paramObject;
    this.checkServerTrusted = paramMethod;
  }
  
  public List<Certificate> clean(List<Certificate> paramList, String paramString)
  {
    try
    {
      paramList = (X509Certificate[])paramList.toArray(new X509Certificate[paramList.size()]);
      paramList = (List)this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, new Object[] { paramList, "RSA", paramString });
      return paramList;
    }
    catch (IllegalAccessException paramList)
    {
      throw new AssertionError(paramList);
    }
    catch (InvocationTargetException paramList)
    {
      paramString = new SSLPeerUnverifiedException(paramList.getMessage());
      paramString.initCause(paramList);
      throw paramString;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject instanceof AndroidCertificateChainCleaner;
  }
  
  public int hashCode()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.platform.AndroidPlatform.AndroidCertificateChainCleaner
 * JD-Core Version:    0.7.0.1
 */