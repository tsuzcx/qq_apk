package okhttp3.internal.platform;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.Conscrypt.ProviderBuilder;

public class ConscryptPlatform
  extends Platform
{
  public static ConscryptPlatform buildIfSupported()
  {
    try
    {
      Class.forName("org.conscrypt.Conscrypt");
      if (!Conscrypt.isAvailable()) {
        return null;
      }
      ConscryptPlatform localConscryptPlatform = new ConscryptPlatform();
      return localConscryptPlatform;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
  
  private Provider getProvider()
  {
    return Conscrypt.newProviderBuilder().provideTrustManager().build();
  }
  
  public void configureSslSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    if (Conscrypt.isConscrypt(paramSSLSocketFactory)) {
      Conscrypt.setUseEngineSocket(paramSSLSocketFactory, true);
    }
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    if (Conscrypt.isConscrypt(paramSSLSocket))
    {
      if (paramString != null)
      {
        Conscrypt.setUseSessionTickets(paramSSLSocket, true);
        Conscrypt.setHostname(paramSSLSocket, paramString);
      }
      Conscrypt.setApplicationProtocols(paramSSLSocket, (String[])Platform.alpnProtocolNames(paramList).toArray(new String[0]));
      return;
    }
    super.configureTlsExtensions(paramSSLSocket, paramString, paramList);
  }
  
  public SSLContext getSSLContext()
  {
    try
    {
      SSLContext localSSLContext1 = SSLContext.getInstance("TLSv1.3", getProvider());
      return localSSLContext1;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException1) {}
    try
    {
      SSLContext localSSLContext2 = SSLContext.getInstance("TLS", getProvider());
      return localSSLContext2;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
    {
      label25:
      break label25;
    }
    throw new IllegalStateException("No TLS provider", localNoSuchAlgorithmException1);
  }
  
  @Nullable
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    if (Conscrypt.isConscrypt(paramSSLSocket)) {
      return Conscrypt.getApplicationProtocol(paramSSLSocket);
    }
    return super.getSelectedProtocol(paramSSLSocket);
  }
  
  @Nullable
  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    if (!Conscrypt.isConscrypt(paramSSLSocketFactory)) {
      return super.trustManager(paramSSLSocketFactory);
    }
    try
    {
      paramSSLSocketFactory = readFieldOrNull(paramSSLSocketFactory, Object.class, "sslParameters");
      if (paramSSLSocketFactory != null)
      {
        paramSSLSocketFactory = (X509TrustManager)readFieldOrNull(paramSSLSocketFactory, X509TrustManager.class, "x509TrustManager");
        return paramSSLSocketFactory;
      }
      return null;
    }
    catch (Exception paramSSLSocketFactory)
    {
      throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", paramSSLSocketFactory);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.platform.ConscryptPlatform
 * JD-Core Version:    0.7.0.1
 */