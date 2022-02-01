package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.platform.Platform;

public abstract class CertificateChainCleaner
{
  public static CertificateChainCleaner get(X509TrustManager paramX509TrustManager)
  {
    return Platform.get().buildCertificateChainCleaner(paramX509TrustManager);
  }
  
  public static CertificateChainCleaner get(X509Certificate... paramVarArgs)
  {
    return new BasicCertificateChainCleaner(new BasicTrustRootIndex(paramVarArgs));
  }
  
  public abstract List<Certificate> clean(List<Certificate> paramList, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.tls.CertificateChainCleaner
 * JD-Core Version:    0.7.0.1
 */