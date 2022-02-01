import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class kzf
  implements X509TrustManager
{
  X509TrustManager a;
  
  kzf()
  {
    try
    {
      Object localObject1 = KeyStore.getInstance("JKS");
      if (localObject1 != null)
      {
        localObject4 = new FileInputStream("trustedCerts");
        ((KeyStore)localObject1).load((InputStream)localObject4, "passphrase".toCharArray());
        localObject3 = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
        ((TrustManagerFactory)localObject3).init((KeyStore)localObject1);
        localObject3 = ((TrustManagerFactory)localObject3).getTrustManagers();
        localObject1 = localObject4;
        if (localObject1 != null) {
          ((FileInputStream)localObject1).close();
        }
        i = 0;
        if (i >= localObject3.length) {
          break label137;
        }
        if (!(localObject3[i] instanceof X509TrustManager)) {
          break label130;
        }
        this.a = ((X509TrustManager)localObject3[i]);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        Object localObject2 = null;
        continue;
        localObject2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        ((TrustManagerFactory)localObject2).init((KeyStore)null);
        Object localObject4 = ((TrustManagerFactory)localObject2).getTrustManagers();
        localObject2 = localObject3;
        localObject3 = localObject4;
        continue;
        label130:
        i += 1;
      }
      label137:
      throw new Exception("Couldn't initialize");
    }
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
 * Qualified Name:     kzf
 * JD-Core Version:    0.7.0.1
 */