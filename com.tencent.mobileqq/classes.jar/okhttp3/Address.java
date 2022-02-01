package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.Util;

public final class Address
{
  @Nullable
  final CertificatePinner certificatePinner;
  final List<ConnectionSpec> connectionSpecs;
  final Dns dns;
  @Nullable
  final HostnameVerifier hostnameVerifier;
  final List<Protocol> protocols;
  @Nullable
  final Proxy proxy;
  final Authenticator proxyAuthenticator;
  final ProxySelector proxySelector;
  final SocketFactory socketFactory;
  @Nullable
  final SSLSocketFactory sslSocketFactory;
  final HttpUrl url;
  
  public Address(String paramString, int paramInt, Dns paramDns, SocketFactory paramSocketFactory, @Nullable SSLSocketFactory paramSSLSocketFactory, @Nullable HostnameVerifier paramHostnameVerifier, @Nullable CertificatePinner paramCertificatePinner, Authenticator paramAuthenticator, @Nullable Proxy paramProxy, List<Protocol> paramList, List<ConnectionSpec> paramList1, ProxySelector paramProxySelector)
  {
    HttpUrl.Builder localBuilder = new HttpUrl.Builder();
    String str;
    if (paramSSLSocketFactory != null) {
      str = "https";
    } else {
      str = "http";
    }
    this.url = localBuilder.scheme(str).host(paramString).port(paramInt).build();
    if (paramDns != null)
    {
      this.dns = paramDns;
      if (paramSocketFactory != null)
      {
        this.socketFactory = paramSocketFactory;
        if (paramAuthenticator != null)
        {
          this.proxyAuthenticator = paramAuthenticator;
          if (paramList != null)
          {
            this.protocols = Util.immutableList(paramList);
            if (paramList1 != null)
            {
              this.connectionSpecs = Util.immutableList(paramList1);
              if (paramProxySelector != null)
              {
                this.proxySelector = paramProxySelector;
                this.proxy = paramProxy;
                this.sslSocketFactory = paramSSLSocketFactory;
                this.hostnameVerifier = paramHostnameVerifier;
                this.certificatePinner = paramCertificatePinner;
                return;
              }
              throw new NullPointerException("proxySelector == null");
            }
            throw new NullPointerException("connectionSpecs == null");
          }
          throw new NullPointerException("protocols == null");
        }
        throw new NullPointerException("proxyAuthenticator == null");
      }
      throw new NullPointerException("socketFactory == null");
    }
    throw new NullPointerException("dns == null");
  }
  
  @Nullable
  public CertificatePinner certificatePinner()
  {
    return this.certificatePinner;
  }
  
  public List<ConnectionSpec> connectionSpecs()
  {
    return this.connectionSpecs;
  }
  
  public Dns dns()
  {
    return this.dns;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Address))
    {
      HttpUrl localHttpUrl = this.url;
      paramObject = (Address)paramObject;
      if ((localHttpUrl.equals(paramObject.url)) && (equalsNonHost(paramObject))) {
        return true;
      }
    }
    return false;
  }
  
  boolean equalsNonHost(Address paramAddress)
  {
    return (this.dns.equals(paramAddress.dns)) && (this.proxyAuthenticator.equals(paramAddress.proxyAuthenticator)) && (this.protocols.equals(paramAddress.protocols)) && (this.connectionSpecs.equals(paramAddress.connectionSpecs)) && (this.proxySelector.equals(paramAddress.proxySelector)) && (Util.equal(this.proxy, paramAddress.proxy)) && (Util.equal(this.sslSocketFactory, paramAddress.sslSocketFactory)) && (Util.equal(this.hostnameVerifier, paramAddress.hostnameVerifier)) && (Util.equal(this.certificatePinner, paramAddress.certificatePinner)) && (url().port() == paramAddress.url().port());
  }
  
  public int hashCode()
  {
    int n = this.url.hashCode();
    int i1 = this.dns.hashCode();
    int i2 = this.proxyAuthenticator.hashCode();
    int i3 = this.protocols.hashCode();
    int i4 = this.connectionSpecs.hashCode();
    int i5 = this.proxySelector.hashCode();
    Object localObject = this.proxy;
    int m = 0;
    int i;
    if (localObject != null) {
      i = ((Proxy)localObject).hashCode();
    } else {
      i = 0;
    }
    localObject = this.sslSocketFactory;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.hostnameVerifier;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.certificatePinner;
    if (localObject != null) {
      m = ((CertificatePinner)localObject).hashCode();
    }
    return (((((((((527 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i) * 31 + j) * 31 + k) * 31 + m;
  }
  
  @Nullable
  public HostnameVerifier hostnameVerifier()
  {
    return this.hostnameVerifier;
  }
  
  public List<Protocol> protocols()
  {
    return this.protocols;
  }
  
  @Nullable
  public Proxy proxy()
  {
    return this.proxy;
  }
  
  public Authenticator proxyAuthenticator()
  {
    return this.proxyAuthenticator;
  }
  
  public ProxySelector proxySelector()
  {
    return this.proxySelector;
  }
  
  public SocketFactory socketFactory()
  {
    return this.socketFactory;
  }
  
  @Nullable
  public SSLSocketFactory sslSocketFactory()
  {
    return this.sslSocketFactory;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Address{");
    localStringBuilder.append(this.url.host());
    localStringBuilder.append(":");
    localStringBuilder.append(this.url.port());
    if (this.proxy != null)
    {
      localStringBuilder.append(", proxy=");
      localStringBuilder.append(this.proxy);
    }
    else
    {
      localStringBuilder.append(", proxySelector=");
      localStringBuilder.append(this.proxySelector);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public HttpUrl url()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.Address
 * JD-Core Version:    0.7.0.1
 */