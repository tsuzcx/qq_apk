import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class kzi
  implements X509TrustManager
{
  X509TrustManager a;
  
  kzi()
  {
    for (;;)
    {
      int i;
      try
      {
        localObject1 = KeyStore.getInstance("JKS");
        if (localObject1 == null) {}
      }
      catch (Exception localException1)
      {
        try
        {
          localObject5 = new FileInputStream("trustedCerts");
          ((KeyStore)localObject1).load((InputStream)localObject5, "passphrase".toCharArray());
          localObject4 = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
          ((TrustManagerFactory)localObject4).init((KeyStore)localObject1);
          localObject4 = ((TrustManagerFactory)localObject4).getTrustManagers();
          Object localObject1 = localObject5;
          if (localObject1 != null) {
            ((FileInputStream)localObject1).close();
          }
          i = 0;
          if (i >= localObject4.length) {
            break;
          }
          if (!(localObject4[i] instanceof X509TrustManager)) {
            break label133;
          }
          this.a = ((X509TrustManager)localObject4[i]);
          return;
        }
        catch (Exception localException2)
        {
          Object localObject2;
          throw localException2;
        }
        localException1 = localException1;
        localObject2 = null;
        continue;
      }
      Object localObject3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject3).init((KeyStore)null);
      Object localObject5 = ((TrustManagerFactory)localObject3).getTrustManagers();
      localObject3 = localObject4;
      localObject4 = localObject5;
      continue;
      label133:
      i += 1;
    }
    throw new Exception("Couldn't initialize");
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return this.a.getAcceptedIssuers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     kzi
 * JD-Core Version:    0.7.0.1
 */