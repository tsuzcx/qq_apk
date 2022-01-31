import com.rookery.asyncHttpClient.AsyncHttpClient;
import com.tencent.qphone.base.util.QLog;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class jci
  implements X509HostnameVerifier
{
  private X509HostnameVerifier jdField_a_of_type_OrgApacheHttpConnSslX509HostnameVerifier = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
  
  public jci(AsyncHttpClient paramAsyncHttpClient) {}
  
  public void verify(String paramString, X509Certificate paramX509Certificate)
  {
    String str = paramString;
    if (paramString.equalsIgnoreCase("datamarket.accesscontrol.windows.net")) {
      str = "accesscontrol.windows.net";
    }
    this.jdField_a_of_type_OrgApacheHttpConnSslX509HostnameVerifier.verify(str, paramX509Certificate);
  }
  
  public void verify(String paramString, SSLSocket paramSSLSocket)
  {
    String str = paramString;
    if (paramString.equalsIgnoreCase("datamarket.accesscontrol.windows.net")) {
      str = "accesscontrol.windows.net";
    }
    this.jdField_a_of_type_OrgApacheHttpConnSslX509HostnameVerifier.verify(str, paramSSLSocket);
  }
  
  public void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    String str = paramString;
    if (paramString.equalsIgnoreCase("datamarket.accesscontrol.windows.net")) {
      str = "accesscontrol.windows.net";
    }
    this.jdField_a_of_type_OrgApacheHttpConnSslX509HostnameVerifier.verify(str, paramArrayOfString1, paramArrayOfString2);
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Translator", 2, "[AsyncHttpClient] host:" + paramString);
    }
    String str = paramString;
    if (paramString.equalsIgnoreCase("datamarket.accesscontrol.windows.net")) {
      str = "accesscontrol.windows.net";
    }
    return this.jdField_a_of_type_OrgApacheHttpConnSslX509HostnameVerifier.verify(str, paramSSLSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     jci
 * JD-Core Version:    0.7.0.1
 */