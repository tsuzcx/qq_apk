import com.tencent.qphone.base.util.QLog;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

final class ndg
  implements HostnameVerifier
{
  ndg(String paramString) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, paramSSLSession);
    QLog.d("Q.share.sdk", 1, new Object[] { "uploadImageWithHttps|verify hostname=", paramString, ", host=", this.a, ", verify=", Boolean.valueOf(bool) });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ndg
 * JD-Core Version:    0.7.0.1
 */