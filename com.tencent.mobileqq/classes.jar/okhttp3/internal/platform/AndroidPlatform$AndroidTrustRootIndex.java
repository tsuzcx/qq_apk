package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.Util;
import okhttp3.internal.tls.TrustRootIndex;

final class AndroidPlatform$AndroidTrustRootIndex
  implements TrustRootIndex
{
  private final Method findByIssuerAndSignatureMethod;
  private final X509TrustManager trustManager;
  
  AndroidPlatform$AndroidTrustRootIndex(X509TrustManager paramX509TrustManager, Method paramMethod)
  {
    this.findByIssuerAndSignatureMethod = paramMethod;
    this.trustManager = paramX509TrustManager;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof AndroidTrustRootIndex)) {
      return false;
    }
    paramObject = (AndroidTrustRootIndex)paramObject;
    return (this.trustManager.equals(paramObject.trustManager)) && (this.findByIssuerAndSignatureMethod.equals(paramObject.findByIssuerAndSignatureMethod));
  }
  
  public X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate)
  {
    Object localObject = null;
    try
    {
      TrustAnchor localTrustAnchor = (TrustAnchor)this.findByIssuerAndSignatureMethod.invoke(this.trustManager, new Object[] { paramX509Certificate });
      paramX509Certificate = localObject;
      if (localTrustAnchor != null) {
        paramX509Certificate = localTrustAnchor.getTrustedCert();
      }
      return paramX509Certificate;
    }
    catch (IllegalAccessException paramX509Certificate)
    {
      throw Util.assertionError("unable to get issues and signature", paramX509Certificate);
    }
    catch (InvocationTargetException paramX509Certificate) {}
    return null;
  }
  
  public int hashCode()
  {
    return this.trustManager.hashCode() + this.findByIssuerAndSignatureMethod.hashCode() * 31;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.platform.AndroidPlatform.AndroidTrustRootIndex
 * JD-Core Version:    0.7.0.1
 */