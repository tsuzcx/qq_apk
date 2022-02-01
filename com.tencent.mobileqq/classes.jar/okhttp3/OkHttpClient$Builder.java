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
    if (paramInterceptor == null) {
      throw new IllegalArgumentException("interceptor == null");
    }
    this.interceptors.add(paramInterceptor);
    return this;
  }
  
  public Builder addNetworkInterceptor(Interceptor paramInterceptor)
  {
    if (paramInterceptor == null) {
      throw new IllegalArgumentException("interceptor == null");
    }
    this.networkInterceptors.add(paramInterceptor);
    return this;
  }
  
  public Builder authenticator(Authenticator paramAuthenticator)
  {
    if (paramAuthenticator == null) {
      throw new NullPointerException("authenticator == null");
    }
    this.authenticator = paramAuthenticator;
    return this;
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
    if (paramCertificatePinner == null) {
      throw new NullPointerException("certificatePinner == null");
    }
    this.certificatePinner = paramCertificatePinner;
    return this;
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
    if (paramConnectionPool == null) {
      throw new NullPointerException("connectionPool == null");
    }
    this.connectionPool = paramConnectionPool;
    return this;
  }
  
  public Builder connectionSpecs(List<ConnectionSpec> paramList)
  {
    this.connectionSpecs = Util.immutableList(paramList);
    return this;
  }
  
  public Builder cookieJar(CookieJar paramCookieJar)
  {
    if (paramCookieJar == null) {
      throw new NullPointerException("cookieJar == null");
    }
    this.cookieJar = paramCookieJar;
    return this;
  }
  
  public Builder dispatcher(Dispatcher paramDispatcher)
  {
    if (paramDispatcher == null) {
      throw new IllegalArgumentException("dispatcher == null");
    }
    this.dispatcher = paramDispatcher;
    return this;
  }
  
  public Builder dns(Dns paramDns)
  {
    if (paramDns == null) {
      throw new NullPointerException("dns == null");
    }
    this.dns = paramDns;
    return this;
  }
  
  public Builder eventListener(EventListener paramEventListener)
  {
    if (paramEventListener == null) {
      throw new NullPointerException("eventListener == null");
    }
    this.eventListenerFactory = EventListener.factory(paramEventListener);
    return this;
  }
  
  public Builder eventListenerFactory(EventListener.Factory paramFactory)
  {
    if (paramFactory == null) {
      throw new NullPointerException("eventListenerFactory == null");
    }
    this.eventListenerFactory = paramFactory;
    return this;
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
    if (paramHostnameVerifier == null) {
      throw new NullPointerException("hostnameVerifier == null");
    }
    this.hostnameVerifier = paramHostnameVerifier;
    return this;
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
    if ((!paramList.contains(Protocol.H2_PRIOR_KNOWLEDGE)) && (!paramList.contains(Protocol.HTTP_1_1))) {
      throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + paramList);
    }
    if ((paramList.contains(Protocol.H2_PRIOR_KNOWLEDGE)) && (paramList.size() > 1)) {
      throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + paramList);
    }
    if (paramList.contains(Protocol.HTTP_1_0)) {
      throw new IllegalArgumentException("protocols must not contain http/1.0: " + paramList);
    }
    if (paramList.contains(null)) {
      throw new IllegalArgumentException("protocols must not contain null");
    }
    paramList.remove(Protocol.SPDY_3);
    this.protocols = Collections.unmodifiableList(paramList);
    return this;
  }
  
  public Builder proxy(@Nullable Proxy paramProxy)
  {
    this.proxy = paramProxy;
    return this;
  }
  
  public Builder proxyAuthenticator(Authenticator paramAuthenticator)
  {
    if (paramAuthenticator == null) {
      throw new NullPointerException("proxyAuthenticator == null");
    }
    this.proxyAuthenticator = paramAuthenticator;
    return this;
  }
  
  public Builder proxySelector(ProxySelector paramProxySelector)
  {
    if (paramProxySelector == null) {
      throw new NullPointerException("proxySelector == null");
    }
    this.proxySelector = paramProxySelector;
    return this;
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
    if (paramSocketFactory == null) {
      throw new NullPointerException("socketFactory == null");
    }
    this.socketFactory = paramSocketFactory;
    return this;
  }
  
  public Builder sslSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    if (paramSSLSocketFactory == null) {
      throw new NullPointerException("sslSocketFactory == null");
    }
    this.sslSocketFactory = paramSSLSocketFactory;
    this.certificateChainCleaner = Platform.get().buildCertificateChainCleaner(paramSSLSocketFactory);
    return this;
  }
  
  public Builder sslSocketFactory(SSLSocketFactory paramSSLSocketFactory, X509TrustManager paramX509TrustManager)
  {
    if (paramSSLSocketFactory == null) {
      throw new NullPointerException("sslSocketFactory == null");
    }
    if (paramX509TrustManager == null) {
      throw new NullPointerException("trustManager == null");
    }
    this.sslSocketFactory = paramSSLSocketFactory;
    this.certificateChainCleaner = CertificateChainCleaner.get(paramX509TrustManager);
    return this;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.OkHttpClient.Builder
 * JD-Core Version:    0.7.0.1
 */