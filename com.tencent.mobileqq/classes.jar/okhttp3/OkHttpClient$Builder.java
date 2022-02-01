package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.Util;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class OkHttpClient$Builder
{
  Authenticator authenticator;
  @Nullable
  Cache cache;
  int callTimeout;
  @Nullable
  CertificateChainCleaner certificateChainCleaner;
  CertificatePinner certificatePinner;
  int connectTimeout;
  ConnectionPool connectionPool;
  List<ConnectionSpec> connectionSpecs;
  CookieJar cookieJar;
  Dispatcher dispatcher;
  Dns dns;
  EventListener.Factory eventListenerFactory;
  boolean followRedirects;
  boolean followSslRedirects;
  HostnameVerifier hostnameVerifier;
  final List<Interceptor> interceptors = new ArrayList();
  @Nullable
  InternalCache internalCache;
  final List<Interceptor> networkInterceptors = new ArrayList();
  int pingInterval;
  List<Protocol> protocols;
  @Nullable
  Proxy proxy;
  Authenticator proxyAuthenticator;
  ProxySelector proxySelector;
  int readTimeout;
  boolean retryOnConnectionFailure;
  SocketFactory socketFactory;
  @Nullable
  SSLSocketFactory sslSocketFactory;
  int writeTimeout;
  
  public OkHttpClient$Builder()
  {
    this.dispatcher = new Dispatcher();
    this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
    this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
    this.eventListenerFactory = EventListener.factory(EventListener.NONE);
    this.proxySelector = ProxySelector.getDefault();
    if (this.proxySelector == null) {
      this.proxySelector = new NullProxySelector();
    }
    this.cookieJar = CookieJar.NO_COOKIES;
    this.socketFactory = SocketFactory.getDefault();
    this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
    this.certificatePinner = CertificatePinner.DEFAULT;
    this.proxyAuthenticator = Authenticator.NONE;
    this.authenticator = Authenticator.NONE;
    this.connectionPool = new ConnectionPool();
    this.dns = Dns.SYSTEM;
    this.followSslRedirects = true;
    this.followRedirects = true;
    this.retryOnConnectionFailure = true;
    this.callTimeout = 0;
    this.connectTimeout = 10000;
    this.readTimeout = 10000;
    this.writeTimeout = 10000;
    this.pingInterval = 0;
  }
  
  OkHttpClient$Builder(OkHttpClient paramOkHttpClient)
  {
    this.dispatcher = paramOkHttpClient.dispatcher;
    this.proxy = paramOkHttpClient.proxy;
    this.protocols = paramOkHttpClient.protocols;
    this.connectionSpecs = paramOkHttpClient.connectionSpecs;
    this.interceptors.addAll(paramOkHttpClient.interceptors);
    this.networkInterceptors.addAll(paramOkHttpClient.networkInterceptors);
    this.eventListenerFactory = paramOkHttpClient.eventListenerFactory;
    this.proxySelector = paramOkHttpClient.proxySelector;
    this.cookieJar = paramOkHttpClient.cookieJar;
    this.internalCache = paramOkHttpClient.internalCache;
    this.cache = paramOkHttpClient.cache;
    this.socketFactory = paramOkHttpClient.socketFactory;
    this.sslSocketFactory = paramOkHttpClient.sslSocketFactory;
    this.certificateChainCleaner = paramOkHttpClient.certificateChainCleaner;
    this.hostnameVerifier = paramOkHttpClient.hostnameVerifier;
    this.certificatePinner = paramOkHttpClient.certificatePinner;
    this.proxyAuthenticator = paramOkHttpClient.proxyAuthenticator;
    this.authenticator = paramOkHttpClient.authenticator;
    this.connectionPool = paramOkHttpClient.connectionPool;
    this.dns = paramOkHttpClient.dns;
    this.followSslRedirects = paramOkHttpClient.followSslRedirects;
    this.followRedirects = paramOkHttpClient.followRedirects;
    this.retryOnConnectionFailure = paramOkHttpClient.retryOnConnectionFailure;
    this.callTimeout = paramOkHttpClient.callTimeout;
    this.connectTimeout = paramOkHttpClient.connectTimeout;
    this.readTimeout = paramOkHttpClient.readTimeout;
    this.writeTimeout = paramOkHttpClient.writeTimeout;
    this.pingInterval = paramOkHttpClient.pingInterval;
  }
  
  public Builder addInterceptor(Interceptor paramInterceptor)
  {
    if (paramInterceptor != null)
    {
      this.interceptors.add(paramInterceptor);
      return this;
    }
    throw new IllegalArgumentException("interceptor == null");
  }
  
  public Builder addNetworkInterceptor(Interceptor paramInterceptor)
  {
    if (paramInterceptor != null)
    {
      this.networkInterceptors.add(paramInterceptor);
      return this;
    }
    throw new IllegalArgumentException("interceptor == null");
  }
  
  public Builder authenticator(Authenticator paramAuthenticator)
  {
    if (paramAuthenticator != null)
    {
      this.authenticator = paramAuthenticator;
      return this;
    }
    throw new NullPointerException("authenticator == null");
  }
  
  public OkHttpClient build()
  {
    return new OkHttpClient(this);
  }
  
  public Builder cache(@Nullable Cache paramCache)
  {
    this.cache = paramCache;
    this.internalCache = null;
    return this;
  }
  
  public Builder callTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    this.callTimeout = Util.checkDuration("timeout", paramLong, paramTimeUnit);
    return this;
  }
  
  @IgnoreJRERequirement
  public Builder callTimeout(Duration paramDuration)
  {
    this.callTimeout = Util.checkDuration("timeout", paramDuration.toMillis(), TimeUnit.MILLISECONDS);
    return this;
  }
  
  public Builder certificatePinner(CertificatePinner paramCertificatePinner)
  {
    if (paramCertificatePinner != null)
    {
      this.certificatePinner = paramCertificatePinner;
      return this;
    }
    throw new NullPointerException("certificatePinner == null");
  }
  
  public Builder connectTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    this.connectTimeout = Util.checkDuration("timeout", paramLong, paramTimeUnit);
    return this;
  }
  
  @IgnoreJRERequirement
  public Builder connectTimeout(Duration paramDuration)
  {
    this.connectTimeout = Util.checkDuration("timeout", paramDuration.toMillis(), TimeUnit.MILLISECONDS);
    return this;
  }
  
  public Builder connectionPool(ConnectionPool paramConnectionPool)
  {
    if (paramConnectionPool != null)
    {
      this.connectionPool = paramConnectionPool;
      return this;
    }
    throw new NullPointerException("connectionPool == null");
  }
  
  public Builder connectionSpecs(List<ConnectionSpec> paramList)
  {
    this.connectionSpecs = Util.immutableList(paramList);
    return this;
  }
  
  public Builder cookieJar(CookieJar paramCookieJar)
  {
    if (paramCookieJar != null)
    {
      this.cookieJar = paramCookieJar;
      return this;
    }
    throw new NullPointerException("cookieJar == null");
  }
  
  public Builder dispatcher(Dispatcher paramDispatcher)
  {
    if (paramDispatcher != null)
    {
      this.dispatcher = paramDispatcher;
      return this;
    }
    throw new IllegalArgumentException("dispatcher == null");
  }
  
  public Builder dns(Dns paramDns)
  {
    if (paramDns != null)
    {
      this.dns = paramDns;
      return this;
    }
    throw new NullPointerException("dns == null");
  }
  
  public Builder eventListener(EventListener paramEventListener)
  {
    if (paramEventListener != null)
    {
      this.eventListenerFactory = EventListener.factory(paramEventListener);
      return this;
    }
    throw new NullPointerException("eventListener == null");
  }
  
  public Builder eventListenerFactory(EventListener.Factory paramFactory)
  {
    if (paramFactory != null)
    {
      this.eventListenerFactory = paramFactory;
      return this;
    }
    throw new NullPointerException("eventListenerFactory == null");
  }
  
  public Builder followRedirects(boolean paramBoolean)
  {
    this.followRedirects = paramBoolean;
    return this;
  }
  
  public Builder followSslRedirects(boolean paramBoolean)
  {
    this.followSslRedirects = paramBoolean;
    return this;
  }
  
  public Builder hostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    if (paramHostnameVerifier != null)
    {
      this.hostnameVerifier = paramHostnameVerifier;
      return this;
    }
    throw new NullPointerException("hostnameVerifier == null");
  }
  
  public List<Interceptor> interceptors()
  {
    return this.interceptors;
  }
  
  public List<Interceptor> networkInterceptors()
  {
    return this.networkInterceptors;
  }
  
  public Builder pingInterval(long paramLong, TimeUnit paramTimeUnit)
  {
    this.pingInterval = Util.checkDuration("interval", paramLong, paramTimeUnit);
    return this;
  }
  
  @IgnoreJRERequirement
  public Builder pingInterval(Duration paramDuration)
  {
    this.pingInterval = Util.checkDuration("timeout", paramDuration.toMillis(), TimeUnit.MILLISECONDS);
    return this;
  }
  
  public Builder protocols(List<Protocol> paramList)
  {
    paramList = new ArrayList(paramList);
    if ((!paramList.contains(Protocol.H2_PRIOR_KNOWLEDGE)) && (!paramList.contains(Protocol.HTTP_1_1)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("protocols must contain h2_prior_knowledge or http/1.1: ");
      localStringBuilder.append(paramList);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    if ((paramList.contains(Protocol.H2_PRIOR_KNOWLEDGE)) && (paramList.size() > 1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("protocols containing h2_prior_knowledge cannot use other protocols: ");
      localStringBuilder.append(paramList);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    if (!paramList.contains(Protocol.HTTP_1_0))
    {
      if (!paramList.contains(null))
      {
        paramList.remove(Protocol.SPDY_3);
        this.protocols = Collections.unmodifiableList(paramList);
        return this;
      }
      throw new IllegalArgumentException("protocols must not contain null");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("protocols must not contain http/1.0: ");
    localStringBuilder.append(paramList);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public Builder proxy(@Nullable Proxy paramProxy)
  {
    this.proxy = paramProxy;
    return this;
  }
  
  public Builder proxyAuthenticator(Authenticator paramAuthenticator)
  {
    if (paramAuthenticator != null)
    {
      this.proxyAuthenticator = paramAuthenticator;
      return this;
    }
    throw new NullPointerException("proxyAuthenticator == null");
  }
  
  public Builder proxySelector(ProxySelector paramProxySelector)
  {
    if (paramProxySelector != null)
    {
      this.proxySelector = paramProxySelector;
      return this;
    }
    throw new NullPointerException("proxySelector == null");
  }
  
  public Builder readTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    this.readTimeout = Util.checkDuration("timeout", paramLong, paramTimeUnit);
    return this;
  }
  
  @IgnoreJRERequirement
  public Builder readTimeout(Duration paramDuration)
  {
    this.readTimeout = Util.checkDuration("timeout", paramDuration.toMillis(), TimeUnit.MILLISECONDS);
    return this;
  }
  
  public Builder retryOnConnectionFailure(boolean paramBoolean)
  {
    this.retryOnConnectionFailure = paramBoolean;
    return this;
  }
  
  void setInternalCache(@Nullable InternalCache paramInternalCache)
  {
    this.internalCache = paramInternalCache;
    this.cache = null;
  }
  
  public Builder socketFactory(SocketFactory paramSocketFactory)
  {
    if (paramSocketFactory != null)
    {
      this.socketFactory = paramSocketFactory;
      return this;
    }
    throw new NullPointerException("socketFactory == null");
  }
  
  public Builder sslSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    if (paramSSLSocketFactory != null)
    {
      this.sslSocketFactory = paramSSLSocketFactory;
      this.certificateChainCleaner = Platform.get().buildCertificateChainCleaner(paramSSLSocketFactory);
      return this;
    }
    throw new NullPointerException("sslSocketFactory == null");
  }
  
  public Builder sslSocketFactory(SSLSocketFactory paramSSLSocketFactory, X509TrustManager paramX509TrustManager)
  {
    if (paramSSLSocketFactory != null)
    {
      if (paramX509TrustManager != null)
      {
        this.sslSocketFactory = paramSSLSocketFactory;
        this.certificateChainCleaner = CertificateChainCleaner.get(paramX509TrustManager);
        return this;
      }
      throw new NullPointerException("trustManager == null");
    }
    throw new NullPointerException("sslSocketFactory == null");
  }
  
  public Builder writeTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    this.writeTimeout = Util.checkDuration("timeout", paramLong, paramTimeUnit);
    return this;
  }
  
  @IgnoreJRERequirement
  public Builder writeTimeout(Duration paramDuration)
  {
    this.writeTimeout = Util.checkDuration("timeout", paramDuration.toMillis(), TimeUnit.MILLISECONDS);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.OkHttpClient.Builder
 * JD-Core Version:    0.7.0.1
 */