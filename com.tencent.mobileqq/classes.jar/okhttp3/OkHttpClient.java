package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.Util;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.ws.RealWebSocket;

public class OkHttpClient
  implements Cloneable, Call.Factory, WebSocket.Factory
{
  static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS;
  static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList(new Protocol[] { Protocol.HTTP_2, Protocol.HTTP_1_1 });
  final Authenticator authenticator;
  @Nullable
  final Cache cache;
  final int callTimeout;
  final CertificateChainCleaner certificateChainCleaner;
  final CertificatePinner certificatePinner;
  final int connectTimeout;
  final ConnectionPool connectionPool;
  final List<ConnectionSpec> connectionSpecs;
  final CookieJar cookieJar;
  final Dispatcher dispatcher;
  final Dns dns;
  final EventListener.Factory eventListenerFactory;
  final boolean followRedirects;
  final boolean followSslRedirects;
  final HostnameVerifier hostnameVerifier;
  final List<Interceptor> interceptors;
  @Nullable
  final InternalCache internalCache;
  final List<Interceptor> networkInterceptors;
  final int pingInterval;
  final List<Protocol> protocols;
  @Nullable
  final Proxy proxy;
  final Authenticator proxyAuthenticator;
  final ProxySelector proxySelector;
  final int readTimeout;
  final boolean retryOnConnectionFailure;
  final SocketFactory socketFactory;
  final SSLSocketFactory sslSocketFactory;
  final int writeTimeout;
  
  static
  {
    DEFAULT_CONNECTION_SPECS = Util.immutableList(new ConnectionSpec[] { ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT });
    okhttp3.internal.Internal.instance = new OkHttpClient.1();
  }
  
  public OkHttpClient()
  {
    this(new OkHttpClient.Builder());
  }
  
  OkHttpClient(OkHttpClient.Builder paramBuilder)
  {
    this.dispatcher = paramBuilder.dispatcher;
    this.proxy = paramBuilder.proxy;
    this.protocols = paramBuilder.protocols;
    this.connectionSpecs = paramBuilder.connectionSpecs;
    this.interceptors = Util.immutableList(paramBuilder.interceptors);
    this.networkInterceptors = Util.immutableList(paramBuilder.networkInterceptors);
    this.eventListenerFactory = paramBuilder.eventListenerFactory;
    this.proxySelector = paramBuilder.proxySelector;
    this.cookieJar = paramBuilder.cookieJar;
    this.cache = paramBuilder.cache;
    this.internalCache = paramBuilder.internalCache;
    this.socketFactory = paramBuilder.socketFactory;
    Object localObject = this.connectionSpecs.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      ConnectionSpec localConnectionSpec = (ConnectionSpec)((Iterator)localObject).next();
      if ((i != 0) || (localConnectionSpec.isTls())) {}
      for (i = 1;; i = 0) {
        break;
      }
    }
    if ((paramBuilder.sslSocketFactory != null) || (i == 0)) {
      this.sslSocketFactory = paramBuilder.sslSocketFactory;
    }
    for (this.certificateChainCleaner = paramBuilder.certificateChainCleaner;; this.certificateChainCleaner = CertificateChainCleaner.get((X509TrustManager)localObject))
    {
      if (this.sslSocketFactory != null) {
        Platform.get().configureSslSocketFactory(this.sslSocketFactory);
      }
      this.hostnameVerifier = paramBuilder.hostnameVerifier;
      this.certificatePinner = paramBuilder.certificatePinner.withCertificateChainCleaner(this.certificateChainCleaner);
      this.proxyAuthenticator = paramBuilder.proxyAuthenticator;
      this.authenticator = paramBuilder.authenticator;
      this.connectionPool = paramBuilder.connectionPool;
      this.dns = paramBuilder.dns;
      this.followSslRedirects = paramBuilder.followSslRedirects;
      this.followRedirects = paramBuilder.followRedirects;
      this.retryOnConnectionFailure = paramBuilder.retryOnConnectionFailure;
      this.callTimeout = paramBuilder.callTimeout;
      this.connectTimeout = paramBuilder.connectTimeout;
      this.readTimeout = paramBuilder.readTimeout;
      this.writeTimeout = paramBuilder.writeTimeout;
      this.pingInterval = paramBuilder.pingInterval;
      if (!this.interceptors.contains(null)) {
        break;
      }
      throw new IllegalStateException("Null interceptor: " + this.interceptors);
      localObject = Util.platformTrustManager();
      this.sslSocketFactory = newSslSocketFactory((X509TrustManager)localObject);
    }
    if (this.networkInterceptors.contains(null)) {
      throw new IllegalStateException("Null network interceptor: " + this.networkInterceptors);
    }
  }
  
  private static SSLSocketFactory newSslSocketFactory(X509TrustManager paramX509TrustManager)
  {
    try
    {
      SSLContext localSSLContext = Platform.get().getSSLContext();
      localSSLContext.init(null, new TrustManager[] { paramX509TrustManager }, null);
      paramX509TrustManager = localSSLContext.getSocketFactory();
      return paramX509TrustManager;
    }
    catch (GeneralSecurityException paramX509TrustManager)
    {
      throw Util.assertionError("No System TLS", paramX509TrustManager);
    }
  }
  
  public Authenticator authenticator()
  {
    return this.authenticator;
  }
  
  @Nullable
  public Cache cache()
  {
    return this.cache;
  }
  
  public int callTimeoutMillis()
  {
    return this.callTimeout;
  }
  
  public CertificatePinner certificatePinner()
  {
    return this.certificatePinner;
  }
  
  public int connectTimeoutMillis()
  {
    return this.connectTimeout;
  }
  
  public ConnectionPool connectionPool()
  {
    return this.connectionPool;
  }
  
  public List<ConnectionSpec> connectionSpecs()
  {
    return this.connectionSpecs;
  }
  
  public CookieJar cookieJar()
  {
    return this.cookieJar;
  }
  
  public Dispatcher dispatcher()
  {
    return this.dispatcher;
  }
  
  public Dns dns()
  {
    return this.dns;
  }
  
  public EventListener.Factory eventListenerFactory()
  {
    return this.eventListenerFactory;
  }
  
  public boolean followRedirects()
  {
    return this.followRedirects;
  }
  
  public boolean followSslRedirects()
  {
    return this.followSslRedirects;
  }
  
  public HostnameVerifier hostnameVerifier()
  {
    return this.hostnameVerifier;
  }
  
  public List<Interceptor> interceptors()
  {
    return this.interceptors;
  }
  
  InternalCache internalCache()
  {
    if (this.cache != null) {
      return this.cache.internalCache;
    }
    return this.internalCache;
  }
  
  public List<Interceptor> networkInterceptors()
  {
    return this.networkInterceptors;
  }
  
  public OkHttpClient.Builder newBuilder()
  {
    return new OkHttpClient.Builder(this);
  }
  
  public Call newCall(Request paramRequest)
  {
    return RealCall.newRealCall(this, paramRequest, false);
  }
  
  public WebSocket newWebSocket(Request paramRequest, WebSocketListener paramWebSocketListener)
  {
    paramRequest = new RealWebSocket(paramRequest, paramWebSocketListener, new Random(), this.pingInterval);
    paramRequest.connect(this);
    return paramRequest;
  }
  
  public int pingIntervalMillis()
  {
    return this.pingInterval;
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
  
  public int readTimeoutMillis()
  {
    return this.readTimeout;
  }
  
  public boolean retryOnConnectionFailure()
  {
    return this.retryOnConnectionFailure;
  }
  
  public SocketFactory socketFactory()
  {
    return this.socketFactory;
  }
  
  public SSLSocketFactory sslSocketFactory()
  {
    return this.sslSocketFactory;
  }
  
  public int writeTimeoutMillis()
  {
    return this.writeTimeout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.OkHttpClient
 * JD-Core Version:    0.7.0.1
 */