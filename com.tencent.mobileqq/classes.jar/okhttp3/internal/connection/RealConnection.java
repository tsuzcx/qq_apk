package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.Http1Codec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Connection.Builder;
import okhttp3.internal.http2.Http2Connection.Listener;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket.Streams;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

public final class RealConnection
  extends Http2Connection.Listener
  implements Connection
{
  private static final int MAX_TUNNEL_ATTEMPTS = 21;
  private static final String NPE_THROW_WITH_NULL = "throw with null exception";
  public int allocationLimit = 1;
  public final List<Reference<StreamAllocation>> allocations = new ArrayList();
  private final ConnectionPool connectionPool;
  private Handshake handshake;
  private Http2Connection http2Connection;
  public long idleAtNanos = 9223372036854775807L;
  public boolean noNewStreams;
  private Protocol protocol;
  private Socket rawSocket;
  private final Route route;
  private BufferedSink sink;
  private Socket socket;
  private BufferedSource source;
  public int successCount;
  
  public RealConnection(ConnectionPool paramConnectionPool, Route paramRoute)
  {
    this.connectionPool = paramConnectionPool;
    this.route = paramRoute;
  }
  
  /* Error */
  private void connectSocket(int paramInt1, int paramInt2, Call paramCall, EventListener paramEventListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   4: invokevirtual 72	okhttp3/Route:proxy	()Ljava/net/Proxy;
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   13: invokevirtual 76	okhttp3/Route:address	()Lokhttp3/Address;
    //   16: astore 5
    //   18: aload 6
    //   20: invokevirtual 82	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   23: getstatic 88	java/net/Proxy$Type:DIRECT	Ljava/net/Proxy$Type;
    //   26: if_acmpeq +14 -> 40
    //   29: aload 6
    //   31: invokevirtual 82	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   34: getstatic 91	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   37: if_acmpne +89 -> 126
    //   40: aload 5
    //   42: invokevirtual 97	okhttp3/Address:socketFactory	()Ljavax/net/SocketFactory;
    //   45: invokevirtual 103	javax/net/SocketFactory:createSocket	()Ljava/net/Socket;
    //   48: astore 5
    //   50: aload_0
    //   51: aload 5
    //   53: putfield 105	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   56: aload 4
    //   58: aload_3
    //   59: aload_0
    //   60: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   63: invokevirtual 109	okhttp3/Route:socketAddress	()Ljava/net/InetSocketAddress;
    //   66: aload 6
    //   68: invokevirtual 115	okhttp3/EventListener:connectStart	(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V
    //   71: aload_0
    //   72: getfield 105	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   75: iload_2
    //   76: invokevirtual 121	java/net/Socket:setSoTimeout	(I)V
    //   79: invokestatic 127	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   82: aload_0
    //   83: getfield 105	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   86: aload_0
    //   87: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   90: invokevirtual 109	okhttp3/Route:socketAddress	()Ljava/net/InetSocketAddress;
    //   93: iload_1
    //   94: invokevirtual 130	okhttp3/internal/platform/Platform:connectSocket	(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V
    //   97: aload_0
    //   98: aload_0
    //   99: getfield 105	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   102: invokestatic 135	okio/Okio:source	(Ljava/net/Socket;)Lokio/Source;
    //   105: invokestatic 139	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   108: putfield 141	okhttp3/internal/connection/RealConnection:source	Lokio/BufferedSource;
    //   111: aload_0
    //   112: aload_0
    //   113: getfield 105	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   116: invokestatic 144	okio/Okio:sink	(Ljava/net/Socket;)Lokio/Sink;
    //   119: invokestatic 147	okio/Okio:buffer	(Lokio/Sink;)Lokio/BufferedSink;
    //   122: putfield 149	okhttp3/internal/connection/RealConnection:sink	Lokio/BufferedSink;
    //   125: return
    //   126: new 117	java/net/Socket
    //   129: dup
    //   130: aload 6
    //   132: invokespecial 152	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   135: astore 5
    //   137: goto -87 -> 50
    //   140: astore_3
    //   141: new 64	java/net/ConnectException
    //   144: dup
    //   145: new 154	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   152: ldc 157
    //   154: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_0
    //   158: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   161: invokevirtual 109	okhttp3/Route:socketAddress	()Ljava/net/InetSocketAddress;
    //   164: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokespecial 171	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   173: astore 4
    //   175: aload 4
    //   177: aload_3
    //   178: invokevirtual 175	java/net/ConnectException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   181: pop
    //   182: aload 4
    //   184: athrow
    //   185: astore_3
    //   186: ldc 13
    //   188: aload_3
    //   189: invokevirtual 178	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   192: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   195: ifeq -70 -> 125
    //   198: new 186	java/io/IOException
    //   201: dup
    //   202: aload_3
    //   203: invokespecial 189	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	RealConnection
    //   0	207	1	paramInt1	int
    //   0	207	2	paramInt2	int
    //   0	207	3	paramCall	Call
    //   0	207	4	paramEventListener	EventListener
    //   16	120	5	localObject	Object
    //   7	124	6	localProxy	Proxy
    // Exception table:
    //   from	to	target	type
    //   79	97	140	java/net/ConnectException
    //   97	125	185	java/lang/NullPointerException
  }
  
  /* Error */
  private void connectTls(ConnectionSpecSelector paramConnectionSpecSelector)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: aload_0
    //   9: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   12: invokevirtual 76	okhttp3/Route:address	()Lokhttp3/Address;
    //   15: astore 6
    //   17: aload 6
    //   19: invokevirtual 197	okhttp3/Address:sslSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   22: astore_3
    //   23: aload_3
    //   24: aload_0
    //   25: getfield 105	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   28: aload 6
    //   30: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   33: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   36: aload 6
    //   38: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   41: invokevirtual 210	okhttp3/HttpUrl:port	()I
    //   44: iconst_1
    //   45: invokevirtual 215	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   48: checkcast 217	javax/net/ssl/SSLSocket
    //   51: astore_3
    //   52: aload_1
    //   53: aload_3
    //   54: invokevirtual 223	okhttp3/internal/connection/ConnectionSpecSelector:configureSecureSocket	(Ljavax/net/ssl/SSLSocket;)Lokhttp3/ConnectionSpec;
    //   57: astore 5
    //   59: aload 5
    //   61: invokevirtual 229	okhttp3/ConnectionSpec:supportsTlsExtensions	()Z
    //   64: ifeq +23 -> 87
    //   67: invokestatic 127	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   70: aload_3
    //   71: aload 6
    //   73: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   76: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   79: aload 6
    //   81: invokevirtual 233	okhttp3/Address:protocols	()Ljava/util/List;
    //   84: invokevirtual 237	okhttp3/internal/platform/Platform:configureTlsExtensions	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   87: aload_3
    //   88: invokevirtual 240	javax/net/ssl/SSLSocket:startHandshake	()V
    //   91: aload_3
    //   92: invokevirtual 244	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   95: astore_1
    //   96: aload_1
    //   97: invokestatic 249	okhttp3/Handshake:get	(Ljavax/net/ssl/SSLSession;)Lokhttp3/Handshake;
    //   100: astore_2
    //   101: aload 6
    //   103: invokevirtual 253	okhttp3/Address:hostnameVerifier	()Ljavax/net/ssl/HostnameVerifier;
    //   106: aload 6
    //   108: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   111: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   114: aload_1
    //   115: invokeinterface 259 3 0
    //   120: ifne +191 -> 311
    //   123: aload_2
    //   124: invokevirtual 262	okhttp3/Handshake:peerCertificates	()Ljava/util/List;
    //   127: astore_1
    //   128: aload_1
    //   129: invokeinterface 267 1 0
    //   134: ifne +136 -> 270
    //   137: aload_1
    //   138: iconst_0
    //   139: invokeinterface 270 2 0
    //   144: checkcast 272	java/security/cert/X509Certificate
    //   147: astore_1
    //   148: new 274	javax/net/ssl/SSLPeerUnverifiedException
    //   151: dup
    //   152: new 154	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   159: ldc_w 276
    //   162: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 6
    //   167: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   170: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   173: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc_w 278
    //   179: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_1
    //   183: invokestatic 284	okhttp3/CertificatePinner:pin	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   186: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc_w 286
    //   192: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_1
    //   196: invokevirtual 290	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   199: invokeinterface 295 1 0
    //   204: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc_w 297
    //   210: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_1
    //   214: invokestatic 303	okhttp3/internal/tls/OkHostnameVerifier:allSubjectAltNames	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   217: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokespecial 304	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   226: athrow
    //   227: astore_2
    //   228: aload_3
    //   229: astore_1
    //   230: aload_2
    //   231: astore_3
    //   232: aload_1
    //   233: astore_2
    //   234: aload_3
    //   235: invokestatic 310	okhttp3/internal/Util:isAndroidGetsocknameError	(Ljava/lang/AssertionError;)Z
    //   238: ifeq +183 -> 421
    //   241: aload_1
    //   242: astore_2
    //   243: new 186	java/io/IOException
    //   246: dup
    //   247: aload_3
    //   248: invokespecial 189	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   251: athrow
    //   252: astore_1
    //   253: aload_2
    //   254: ifnull +10 -> 264
    //   257: invokestatic 127	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   260: aload_2
    //   261: invokevirtual 314	okhttp3/internal/platform/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   264: aload_2
    //   265: invokestatic 318	okhttp3/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   268: aload_1
    //   269: athrow
    //   270: new 274	javax/net/ssl/SSLPeerUnverifiedException
    //   273: dup
    //   274: new 154	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 276
    //   284: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 6
    //   289: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   292: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   295: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: ldc_w 320
    //   301: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokespecial 304	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   310: athrow
    //   311: aload 6
    //   313: invokevirtual 324	okhttp3/Address:certificatePinner	()Lokhttp3/CertificatePinner;
    //   316: aload 6
    //   318: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   321: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   324: aload_2
    //   325: invokevirtual 262	okhttp3/Handshake:peerCertificates	()Ljava/util/List;
    //   328: invokevirtual 328	okhttp3/CertificatePinner:check	(Ljava/lang/String;Ljava/util/List;)V
    //   331: aload 4
    //   333: astore_1
    //   334: aload 5
    //   336: invokevirtual 229	okhttp3/ConnectionSpec:supportsTlsExtensions	()Z
    //   339: ifeq +11 -> 350
    //   342: invokestatic 127	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   345: aload_3
    //   346: invokevirtual 332	okhttp3/internal/platform/Platform:getSelectedProtocol	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   349: astore_1
    //   350: aload_0
    //   351: aload_3
    //   352: putfield 334	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   355: aload_0
    //   356: aload_0
    //   357: getfield 334	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   360: invokestatic 135	okio/Okio:source	(Ljava/net/Socket;)Lokio/Source;
    //   363: invokestatic 139	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   366: putfield 141	okhttp3/internal/connection/RealConnection:source	Lokio/BufferedSource;
    //   369: aload_0
    //   370: aload_0
    //   371: getfield 334	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   374: invokestatic 144	okio/Okio:sink	(Ljava/net/Socket;)Lokio/Sink;
    //   377: invokestatic 147	okio/Okio:buffer	(Lokio/Sink;)Lokio/BufferedSink;
    //   380: putfield 149	okhttp3/internal/connection/RealConnection:sink	Lokio/BufferedSink;
    //   383: aload_0
    //   384: aload_2
    //   385: putfield 336	okhttp3/internal/connection/RealConnection:handshake	Lokhttp3/Handshake;
    //   388: aload_1
    //   389: ifnull +25 -> 414
    //   392: aload_1
    //   393: invokestatic 341	okhttp3/Protocol:get	(Ljava/lang/String;)Lokhttp3/Protocol;
    //   396: astore_1
    //   397: aload_0
    //   398: aload_1
    //   399: putfield 343	okhttp3/internal/connection/RealConnection:protocol	Lokhttp3/Protocol;
    //   402: aload_3
    //   403: ifnull +10 -> 413
    //   406: invokestatic 127	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   409: aload_3
    //   410: invokevirtual 314	okhttp3/internal/platform/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   413: return
    //   414: getstatic 346	okhttp3/Protocol:HTTP_1_1	Lokhttp3/Protocol;
    //   417: astore_1
    //   418: goto -21 -> 397
    //   421: aload_1
    //   422: astore_2
    //   423: aload_3
    //   424: athrow
    //   425: astore_3
    //   426: aload 5
    //   428: astore_1
    //   429: goto -197 -> 232
    //   432: astore_1
    //   433: aload_3
    //   434: astore_2
    //   435: goto -182 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	this	RealConnection
    //   0	438	1	paramConnectionSpecSelector	ConnectionSpecSelector
    //   1	123	2	localHandshake	Handshake
    //   227	4	2	localAssertionError1	java.lang.AssertionError
    //   233	202	2	localObject1	Object
    //   22	402	3	localObject2	Object
    //   425	9	3	localAssertionError2	java.lang.AssertionError
    //   3	329	4	localObject3	Object
    //   6	421	5	localConnectionSpec	ConnectionSpec
    //   15	302	6	localAddress	Address
    // Exception table:
    //   from	to	target	type
    //   52	87	227	java/lang/AssertionError
    //   87	227	227	java/lang/AssertionError
    //   270	311	227	java/lang/AssertionError
    //   311	331	227	java/lang/AssertionError
    //   334	350	227	java/lang/AssertionError
    //   350	388	227	java/lang/AssertionError
    //   392	397	227	java/lang/AssertionError
    //   397	402	227	java/lang/AssertionError
    //   414	418	227	java/lang/AssertionError
    //   23	52	252	finally
    //   234	241	252	finally
    //   243	252	252	finally
    //   423	425	252	finally
    //   23	52	425	java/lang/AssertionError
    //   52	87	432	finally
    //   87	227	432	finally
    //   270	311	432	finally
    //   311	331	432	finally
    //   334	350	432	finally
    //   350	388	432	finally
    //   392	397	432	finally
    //   397	402	432	finally
    //   414	418	432	finally
  }
  
  private void connectTunnel(int paramInt1, int paramInt2, int paramInt3, Call paramCall, EventListener paramEventListener)
  {
    Request localRequest = createTunnelRequest();
    HttpUrl localHttpUrl = localRequest.url();
    int i = 0;
    for (;;)
    {
      if (i < 21)
      {
        connectSocket(paramInt1, paramInt2, paramCall, paramEventListener);
        localRequest = createTunnel(paramInt2, paramInt3, localRequest, localHttpUrl);
        if (localRequest != null) {}
      }
      else
      {
        return;
      }
      Util.closeQuietly(this.rawSocket);
      this.rawSocket = null;
      this.sink = null;
      this.source = null;
      paramEventListener.connectEnd(paramCall, this.route.socketAddress(), this.route.proxy(), null);
      i += 1;
    }
  }
  
  private Request createTunnel(int paramInt1, int paramInt2, Request paramRequest, HttpUrl paramHttpUrl)
  {
    String str = "CONNECT " + Util.hostHeader(paramHttpUrl, true) + " HTTP/1.1";
    Response localResponse;
    do
    {
      paramHttpUrl = new Http1Codec(null, null, this.source, this.sink);
      this.source.timeout().timeout(paramInt1, TimeUnit.MILLISECONDS);
      this.sink.timeout().timeout(paramInt2, TimeUnit.MILLISECONDS);
      paramHttpUrl.writeRequest(paramRequest.headers(), str);
      paramHttpUrl.finishRequest();
      localResponse = paramHttpUrl.readResponseHeaders(false).request(paramRequest).build();
      long l2 = HttpHeaders.contentLength(localResponse);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      paramRequest = paramHttpUrl.newFixedLengthSource(l1);
      Util.skipAll(paramRequest, 2147483647, TimeUnit.MILLISECONDS);
      paramRequest.close();
      switch (localResponse.code())
      {
      default: 
        throw new IOException("Unexpected response code for CONNECT: " + localResponse.code());
      case 200: 
        if ((!this.source.buffer().exhausted()) || (!this.sink.buffer().exhausted())) {
          throw new IOException("TLS tunnel buffered too many bytes!");
        }
        return null;
      }
      paramHttpUrl = this.route.address().proxyAuthenticator().authenticate(this.route, localResponse);
      if (paramHttpUrl == null) {
        throw new IOException("Failed to authenticate with proxy");
      }
      paramRequest = paramHttpUrl;
    } while (!"close".equalsIgnoreCase(localResponse.header("Connection")));
    return paramHttpUrl;
  }
  
  private Request createTunnelRequest()
  {
    Request localRequest = new Request.Builder().url(this.route.address().url()).method("CONNECT", null).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
    Object localObject = new Response.Builder().request(localRequest).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header("Proxy-Authenticate", "OkHttp-Preemptive").build();
    localObject = this.route.address().proxyAuthenticator().authenticate(this.route, (Response)localObject);
    if (localObject != null) {
      return localObject;
    }
    return localRequest;
  }
  
  private void establishProtocol(ConnectionSpecSelector paramConnectionSpecSelector, int paramInt, Call paramCall, EventListener paramEventListener)
  {
    if (this.route.address().sslSocketFactory() == null) {
      if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE))
      {
        this.socket = this.rawSocket;
        this.protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        startHttp2(paramInt);
      }
    }
    do
    {
      return;
      this.socket = this.rawSocket;
      this.protocol = Protocol.HTTP_1_1;
      return;
      paramEventListener.secureConnectStart(paramCall);
      connectTls(paramConnectionSpecSelector);
      paramEventListener.secureConnectEnd(paramCall, this.handshake);
    } while (this.protocol != Protocol.HTTP_2);
    startHttp2(paramInt);
  }
  
  private void startHttp2(int paramInt)
  {
    this.socket.setSoTimeout(0);
    this.http2Connection = new Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(paramInt).build();
    this.http2Connection.start();
  }
  
  public static RealConnection testConnection(ConnectionPool paramConnectionPool, Route paramRoute, Socket paramSocket, long paramLong)
  {
    paramConnectionPool = new RealConnection(paramConnectionPool, paramRoute);
    paramConnectionPool.socket = paramSocket;
    paramConnectionPool.idleAtNanos = paramLong;
    return paramConnectionPool;
  }
  
  public void cancel()
  {
    Util.closeQuietly(this.rawSocket);
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Call arg6, EventListener paramEventListener)
  {
    if (this.protocol != null) {
      throw new IllegalStateException("already connected");
    }
    Object localObject = this.route.address().connectionSpecs();
    ConnectionSpecSelector localConnectionSpecSelector = new ConnectionSpecSelector((List)localObject);
    if (this.route.address().sslSocketFactory() == null)
    {
      if (!((List)localObject).contains(ConnectionSpec.CLEARTEXT)) {
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
      }
      localObject = this.route.address().url().host();
      if (!Platform.get().isCleartextTrafficPermitted((String)localObject)) {
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + (String)localObject + " not permitted by network security policy"));
      }
    }
    label272:
    label473:
    for (localObject = null;; localObject = null)
    {
      try
      {
        for (;;)
        {
          if (this.route.requiresTunnel())
          {
            connectTunnel(paramInt1, paramInt2, paramInt3, ???, paramEventListener);
            Socket localSocket = this.rawSocket;
            if (localSocket != null) {
              break label272;
            }
          }
          while ((this.route.requiresTunnel()) && (this.rawSocket == null))
          {
            throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
            if (!this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
              break label473;
            }
            throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
            connectSocket(paramInt1, paramInt2, ???, paramEventListener);
            establishProtocol(localConnectionSpecSelector, paramInt4, ???, paramEventListener);
            paramEventListener.connectEnd(???, this.route.socketAddress(), this.route.proxy(), this.protocol);
          }
        }
      }
      catch (IOException localIOException)
      {
        Util.closeQuietly(this.socket);
        Util.closeQuietly(this.rawSocket);
        this.socket = null;
        this.rawSocket = null;
        this.source = null;
        this.sink = null;
        this.handshake = null;
        this.protocol = null;
        this.http2Connection = null;
        paramEventListener.connectFailed(???, this.route.socketAddress(), this.route.proxy(), null, localIOException);
        if (localObject == null) {
          localObject = new RouteException(localIOException);
        }
        while ((!paramBoolean) || (!localConnectionSpecSelector.connectionFailed(localIOException)))
        {
          throw ((Throwable)localObject);
          ((RouteException)localObject).addConnectException(localIOException);
        }
      }
      if (this.http2Connection == null) {
        break;
      }
      synchronized (this.connectionPool)
      {
        this.allocationLimit = this.http2Connection.maxConcurrentStreams();
        return;
      }
    }
  }
  
  public Handshake handshake()
  {
    return this.handshake;
  }
  
  public boolean isEligible(Address paramAddress, @Nullable Route paramRoute)
  {
    if ((this.allocations.size() >= this.allocationLimit) || (this.noNewStreams)) {}
    do
    {
      do
      {
        return false;
      } while (!Internal.instance.equalsNonHost(this.route.address(), paramAddress));
      if (paramAddress.url().host().equals(route().address().url().host())) {
        return true;
      }
    } while ((this.http2Connection == null) || (paramRoute == null) || (paramRoute.proxy().type() != Proxy.Type.DIRECT) || (this.route.proxy().type() != Proxy.Type.DIRECT) || (!this.route.socketAddress().equals(paramRoute.socketAddress())) || (paramRoute.address().hostnameVerifier() != OkHostnameVerifier.INSTANCE) || (!supportsUrl(paramAddress.url())));
    try
    {
      paramAddress.certificatePinner().check(paramAddress.url().host(), handshake().peerCertificates());
      return true;
    }
    catch (SSLPeerUnverifiedException paramAddress) {}
    return false;
  }
  
  public boolean isHealthy(boolean paramBoolean)
  {
    if ((this.socket.isClosed()) || (this.socket.isInputShutdown()) || (this.socket.isOutputShutdown())) {
      return false;
    }
    if (this.http2Connection != null) {
      return this.http2Connection.isHealthy(System.nanoTime());
    }
    if (paramBoolean) {
      try
      {
        int i = this.socket.getSoTimeout();
        try
        {
          this.socket.setSoTimeout(1);
          paramBoolean = this.source.exhausted();
          return !paramBoolean;
        }
        finally
        {
          this.socket.setSoTimeout(i);
        }
        return true;
      }
      catch (IOException localIOException)
      {
        return false;
      }
      catch (SocketTimeoutException localSocketTimeoutException) {}
    }
  }
  
  public boolean isMultiplexed()
  {
    return this.http2Connection != null;
  }
  
  public HttpCodec newCodec(OkHttpClient paramOkHttpClient, Interceptor.Chain paramChain, StreamAllocation paramStreamAllocation)
  {
    if (this.http2Connection != null) {
      return new Http2Codec(paramOkHttpClient, paramChain, paramStreamAllocation, this.http2Connection);
    }
    this.socket.setSoTimeout(paramChain.readTimeoutMillis());
    this.source.timeout().timeout(paramChain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
    this.sink.timeout().timeout(paramChain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
    return new Http1Codec(paramOkHttpClient, paramStreamAllocation, this.source, this.sink);
  }
  
  public RealWebSocket.Streams newWebSocketStreams(StreamAllocation paramStreamAllocation)
  {
    return new RealConnection.1(this, true, this.source, this.sink, paramStreamAllocation);
  }
  
  public void onSettings(Http2Connection paramHttp2Connection)
  {
    synchronized (this.connectionPool)
    {
      this.allocationLimit = paramHttp2Connection.maxConcurrentStreams();
      return;
    }
  }
  
  public void onStream(Http2Stream paramHttp2Stream)
  {
    paramHttp2Stream.close(ErrorCode.REFUSED_STREAM);
  }
  
  public Protocol protocol()
  {
    return this.protocol;
  }
  
  public Route route()
  {
    return this.route;
  }
  
  public Socket socket()
  {
    return this.socket;
  }
  
  public boolean supportsUrl(HttpUrl paramHttpUrl)
  {
    if (paramHttpUrl.port() != this.route.address().url().port()) {
      return false;
    }
    if (!paramHttpUrl.host().equals(this.route.address().url().host()))
    {
      if ((this.handshake != null) && (OkHostnameVerifier.INSTANCE.verify(paramHttpUrl.host(), (X509Certificate)this.handshake.peerCertificates().get(0)))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Connection{").append(this.route.address().url().host()).append(":").append(this.route.address().url().port()).append(", proxy=").append(this.route.proxy()).append(" hostAddress=").append(this.route.socketAddress()).append(" cipherSuite=");
    if (this.handshake != null) {}
    for (Object localObject = this.handshake.cipherSuite();; localObject = "none") {
      return localObject + " protocol=" + this.protocol + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.connection.RealConnection
 * JD-Core Version:    0.7.0.1
 */