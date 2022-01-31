import com.tencent.component.network.utils.http.base.SniSSLSocketFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class plf
  implements X509HostnameVerifier
{
  public plf(SniSSLSocketFactory paramSniSSLSocketFactory) {}
  
  public void verify(String paramString, X509Certificate paramX509Certificate) {}
  
  public void verify(String paramString, SSLSocket paramSSLSocket) {}
  
  public void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     plf
 * JD-Core Version:    0.7.0.1
 */