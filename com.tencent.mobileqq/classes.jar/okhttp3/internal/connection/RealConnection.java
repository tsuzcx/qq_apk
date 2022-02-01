package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
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
    //   26: if_acmpeq +31 -> 57
    //   29: aload 6
    //   31: invokevirtual 82	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   34: getstatic 91	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   37: if_acmpne +6 -> 43
    //   40: goto +17 -> 57
    //   43: new 93	java/net/Socket
    //   46: dup
    //   47: aload 6
    //   49: invokespecial 96	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   52: astore 5
    //   54: goto +13 -> 67
    //   57: aload 5
    //   59: invokevirtual 102	okhttp3/Address:socketFactory	()Ljavax/net/SocketFactory;
    //   62: invokevirtual 108	javax/net/SocketFactory:createSocket	()Ljava/net/Socket;
    //   65: astore 5
    //   67: aload_0
    //   68: aload 5
    //   70: putfield 110	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   73: aload 4
    //   75: aload_3
    //   76: aload_0
    //   77: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   80: invokevirtual 114	okhttp3/Route:socketAddress	()Ljava/net/InetSocketAddress;
    //   83: aload 6
    //   85: invokevirtual 120	okhttp3/EventListener:connectStart	(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V
    //   88: aload_0
    //   89: getfield 110	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   92: iload_2
    //   93: invokevirtual 124	java/net/Socket:setSoTimeout	(I)V
    //   96: invokestatic 130	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   99: aload_0
    //   100: getfield 110	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   103: aload_0
    //   104: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   107: invokevirtual 114	okhttp3/Route:socketAddress	()Ljava/net/InetSocketAddress;
    //   110: iload_1
    //   111: invokevirtual 133	okhttp3/internal/platform/Platform:connectSocket	(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 110	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   119: invokestatic 138	okio/Okio:source	(Ljava/net/Socket;)Lokio/Source;
    //   122: invokestatic 142	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   125: putfield 144	okhttp3/internal/connection/RealConnection:source	Lokio/BufferedSource;
    //   128: aload_0
    //   129: aload_0
    //   130: getfield 110	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   133: invokestatic 147	okio/Okio:sink	(Ljava/net/Socket;)Lokio/Sink;
    //   136: invokestatic 150	okio/Okio:buffer	(Lokio/Sink;)Lokio/BufferedSink;
    //   139: putfield 152	okhttp3/internal/connection/RealConnection:sink	Lokio/BufferedSink;
    //   142: return
    //   143: astore_3
    //   144: ldc 13
    //   146: aload_3
    //   147: invokevirtual 156	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   150: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   153: ifne +4 -> 157
    //   156: return
    //   157: new 164	java/io/IOException
    //   160: dup
    //   161: aload_3
    //   162: invokespecial 167	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   165: athrow
    //   166: astore_3
    //   167: new 169	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   174: astore 4
    //   176: aload 4
    //   178: ldc 172
    //   180: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 4
    //   186: aload_0
    //   187: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   190: invokevirtual 114	okhttp3/Route:socketAddress	()Ljava/net/InetSocketAddress;
    //   193: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: new 64	java/net/ConnectException
    //   200: dup
    //   201: aload 4
    //   203: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokespecial 185	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   209: astore 4
    //   211: aload 4
    //   213: aload_3
    //   214: invokevirtual 189	java/net/ConnectException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   217: pop
    //   218: aload 4
    //   220: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	RealConnection
    //   0	221	1	paramInt1	int
    //   0	221	2	paramInt2	int
    //   0	221	3	paramCall	Call
    //   0	221	4	paramEventListener	EventListener
    //   16	53	5	localObject	Object
    //   7	77	6	localProxy	Proxy
    // Exception table:
    //   from	to	target	type
    //   114	142	143	java/lang/NullPointerException
    //   96	114	166	java/net/ConnectException
  }
  
  /* Error */
  private void connectTls(ConnectionSpecSelector paramConnectionSpecSelector)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   4: invokevirtual 76	okhttp3/Route:address	()Lokhttp3/Address;
    //   7: astore 7
    //   9: aload 7
    //   11: invokevirtual 197	okhttp3/Address:sslSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   14: astore 4
    //   16: aconst_null
    //   17: astore_3
    //   18: aconst_null
    //   19: astore 6
    //   21: aconst_null
    //   22: astore 5
    //   24: aload 4
    //   26: aload_0
    //   27: getfield 110	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   30: aload 7
    //   32: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   35: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   38: aload 7
    //   40: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   43: invokevirtual 210	okhttp3/HttpUrl:port	()I
    //   46: iconst_1
    //   47: invokevirtual 215	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   50: checkcast 217	javax/net/ssl/SSLSocket
    //   53: astore 4
    //   55: aload_1
    //   56: aload 4
    //   58: invokevirtual 223	okhttp3/internal/connection/ConnectionSpecSelector:configureSecureSocket	(Ljavax/net/ssl/SSLSocket;)Lokhttp3/ConnectionSpec;
    //   61: astore 6
    //   63: aload 6
    //   65: invokevirtual 229	okhttp3/ConnectionSpec:supportsTlsExtensions	()Z
    //   68: ifeq +24 -> 92
    //   71: invokestatic 130	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   74: aload 4
    //   76: aload 7
    //   78: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   81: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   84: aload 7
    //   86: invokevirtual 233	okhttp3/Address:protocols	()Ljava/util/List;
    //   89: invokevirtual 237	okhttp3/internal/platform/Platform:configureTlsExtensions	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   92: aload 4
    //   94: invokevirtual 240	javax/net/ssl/SSLSocket:startHandshake	()V
    //   97: aload 4
    //   99: invokevirtual 244	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   102: astore_1
    //   103: aload_1
    //   104: invokestatic 249	okhttp3/Handshake:get	(Ljavax/net/ssl/SSLSession;)Lokhttp3/Handshake;
    //   107: astore_3
    //   108: aload 7
    //   110: invokevirtual 253	okhttp3/Address:hostnameVerifier	()Ljavax/net/ssl/HostnameVerifier;
    //   113: aload 7
    //   115: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   118: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   121: aload_1
    //   122: invokeinterface 259 3 0
    //   127: ifne +176 -> 303
    //   130: aload_3
    //   131: invokevirtual 262	okhttp3/Handshake:peerCertificates	()Ljava/util/List;
    //   134: astore_1
    //   135: aload_1
    //   136: invokeinterface 267 1 0
    //   141: istore_2
    //   142: iload_2
    //   143: ifne +111 -> 254
    //   146: aload_1
    //   147: iconst_0
    //   148: invokeinterface 270 2 0
    //   153: checkcast 272	java/security/cert/X509Certificate
    //   156: astore_1
    //   157: new 169	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   164: astore_3
    //   165: aload_3
    //   166: ldc_w 274
    //   169: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_3
    //   174: aload 7
    //   176: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   179: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   182: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload_3
    //   187: ldc_w 276
    //   190: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_3
    //   195: aload_1
    //   196: invokestatic 282	okhttp3/CertificatePinner:pin	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   199: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_3
    //   204: ldc_w 284
    //   207: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_3
    //   212: aload_1
    //   213: invokevirtual 288	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   216: invokeinterface 293 1 0
    //   221: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_3
    //   226: ldc_w 295
    //   229: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_3
    //   234: aload_1
    //   235: invokestatic 301	okhttp3/internal/tls/OkHostnameVerifier:allSubjectAltNames	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   238: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: new 303	javax/net/ssl/SSLPeerUnverifiedException
    //   245: dup
    //   246: aload_3
    //   247: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokespecial 304	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   253: athrow
    //   254: new 169	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   261: astore_1
    //   262: aload_1
    //   263: ldc_w 274
    //   266: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload_1
    //   271: aload 7
    //   273: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   276: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   279: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload_1
    //   284: ldc_w 306
    //   287: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: new 303	javax/net/ssl/SSLPeerUnverifiedException
    //   294: dup
    //   295: aload_1
    //   296: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokespecial 304	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   302: athrow
    //   303: aload 7
    //   305: invokevirtual 310	okhttp3/Address:certificatePinner	()Lokhttp3/CertificatePinner;
    //   308: aload 7
    //   310: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   313: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   316: aload_3
    //   317: invokevirtual 262	okhttp3/Handshake:peerCertificates	()Ljava/util/List;
    //   320: invokevirtual 314	okhttp3/CertificatePinner:check	(Ljava/lang/String;Ljava/util/List;)V
    //   323: aload 5
    //   325: astore_1
    //   326: aload 6
    //   328: invokevirtual 229	okhttp3/ConnectionSpec:supportsTlsExtensions	()Z
    //   331: ifeq +12 -> 343
    //   334: invokestatic 130	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   337: aload 4
    //   339: invokevirtual 318	okhttp3/internal/platform/Platform:getSelectedProtocol	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   342: astore_1
    //   343: aload_0
    //   344: aload 4
    //   346: putfield 320	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   349: aload_0
    //   350: aload_0
    //   351: getfield 320	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   354: invokestatic 138	okio/Okio:source	(Ljava/net/Socket;)Lokio/Source;
    //   357: invokestatic 142	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   360: putfield 144	okhttp3/internal/connection/RealConnection:source	Lokio/BufferedSource;
    //   363: aload_0
    //   364: aload_0
    //   365: getfield 320	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   368: invokestatic 147	okio/Okio:sink	(Ljava/net/Socket;)Lokio/Sink;
    //   371: invokestatic 150	okio/Okio:buffer	(Lokio/Sink;)Lokio/BufferedSink;
    //   374: putfield 152	okhttp3/internal/connection/RealConnection:sink	Lokio/BufferedSink;
    //   377: aload_0
    //   378: aload_3
    //   379: putfield 322	okhttp3/internal/connection/RealConnection:handshake	Lokhttp3/Handshake;
    //   382: aload_1
    //   383: ifnull +11 -> 394
    //   386: aload_1
    //   387: invokestatic 327	okhttp3/Protocol:get	(Ljava/lang/String;)Lokhttp3/Protocol;
    //   390: astore_1
    //   391: goto +7 -> 398
    //   394: getstatic 330	okhttp3/Protocol:HTTP_1_1	Lokhttp3/Protocol;
    //   397: astore_1
    //   398: aload_0
    //   399: aload_1
    //   400: putfield 332	okhttp3/internal/connection/RealConnection:protocol	Lokhttp3/Protocol;
    //   403: aload 4
    //   405: ifnull +11 -> 416
    //   408: invokestatic 130	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   411: aload 4
    //   413: invokevirtual 336	okhttp3/internal/platform/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   416: return
    //   417: astore_1
    //   418: goto +52 -> 470
    //   421: astore_3
    //   422: aload 4
    //   424: astore_1
    //   425: aload_3
    //   426: astore 4
    //   428: goto +15 -> 443
    //   431: astore_1
    //   432: aload_3
    //   433: astore 4
    //   435: goto +35 -> 470
    //   438: astore 4
    //   440: aload 6
    //   442: astore_1
    //   443: aload_1
    //   444: astore_3
    //   445: aload 4
    //   447: invokestatic 342	okhttp3/internal/Util:isAndroidGetsocknameError	(Ljava/lang/AssertionError;)Z
    //   450: ifeq +15 -> 465
    //   453: aload_1
    //   454: astore_3
    //   455: new 164	java/io/IOException
    //   458: dup
    //   459: aload 4
    //   461: invokespecial 167	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   464: athrow
    //   465: aload_1
    //   466: astore_3
    //   467: aload 4
    //   469: athrow
    //   470: aload 4
    //   472: ifnull +11 -> 483
    //   475: invokestatic 130	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   478: aload 4
    //   480: invokevirtual 336	okhttp3/internal/platform/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   483: aload 4
    //   485: invokestatic 346	okhttp3/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   488: aload_1
    //   489: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	this	RealConnection
    //   0	490	1	paramConnectionSpecSelector	ConnectionSpecSelector
    //   141	2	2	bool	boolean
    //   17	362	3	localObject1	Object
    //   421	12	3	localAssertionError1	java.lang.AssertionError
    //   444	23	3	localConnectionSpecSelector	ConnectionSpecSelector
    //   14	420	4	localObject2	Object
    //   438	46	4	localAssertionError2	java.lang.AssertionError
    //   22	302	5	localObject3	Object
    //   19	422	6	localConnectionSpec	okhttp3.ConnectionSpec
    //   7	302	7	localAddress	Address
    // Exception table:
    //   from	to	target	type
    //   55	92	417	finally
    //   92	142	417	finally
    //   146	254	417	finally
    //   254	303	417	finally
    //   303	323	417	finally
    //   326	343	417	finally
    //   343	382	417	finally
    //   386	391	417	finally
    //   394	398	417	finally
    //   398	403	417	finally
    //   55	92	421	java/lang/AssertionError
    //   92	142	421	java/lang/AssertionError
    //   146	254	421	java/lang/AssertionError
    //   254	303	421	java/lang/AssertionError
    //   303	323	421	java/lang/AssertionError
    //   326	343	421	java/lang/AssertionError
    //   343	382	421	java/lang/AssertionError
    //   386	391	421	java/lang/AssertionError
    //   394	398	421	java/lang/AssertionError
    //   398	403	421	java/lang/AssertionError
    //   24	55	431	finally
    //   445	453	431	finally
    //   455	465	431	finally
    //   467	470	431	finally
    //   24	55	438	java/lang/AssertionError
  }
  
  private void connectTunnel(int paramInt1, int paramInt2, int paramInt3, Call paramCall, EventListener paramEventListener)
  {
    Request localRequest = createTunnelRequest();
    HttpUrl localHttpUrl = localRequest.url();
    int i = 0;
    while (i < 21)
    {
      connectSocket(paramInt1, paramInt2, paramCall, paramEventListener);
      localRequest = createTunnel(paramInt2, paramInt3, localRequest, localHttpUrl);
      if (localRequest == null) {
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CONNECT ");
    ((StringBuilder)localObject).append(Util.hostHeader(paramHttpUrl, true));
    ((StringBuilder)localObject).append(" HTTP/1.1");
    paramHttpUrl = ((StringBuilder)localObject).toString();
    for (;;)
    {
      Http1Codec localHttp1Codec = new Http1Codec(null, null, this.source, this.sink);
      this.source.timeout().timeout(paramInt1, TimeUnit.MILLISECONDS);
      this.sink.timeout().timeout(paramInt2, TimeUnit.MILLISECONDS);
      localHttp1Codec.writeRequest(paramRequest.headers(), paramHttpUrl);
      localHttp1Codec.finishRequest();
      localObject = localHttp1Codec.readResponseHeaders(false).request(paramRequest).build();
      long l2 = HttpHeaders.contentLength((Response)localObject);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      paramRequest = localHttp1Codec.newFixedLengthSource(l1);
      Util.skipAll(paramRequest, 2147483647, TimeUnit.MILLISECONDS);
      paramRequest.close();
      int i = ((Response)localObject).code();
      if (i == 200) {
        break label300;
      }
      if (i != 407) {
        break label262;
      }
      paramRequest = this.route.address().proxyAuthenticator().authenticate(this.route, (Response)localObject);
      if (paramRequest == null) {
        break;
      }
      if ("close".equalsIgnoreCase(((Response)localObject).header("Connection"))) {
        return paramRequest;
      }
    }
    throw new IOException("Failed to authenticate with proxy");
    label262:
    paramRequest = new StringBuilder();
    paramRequest.append("Unexpected response code for CONNECT: ");
    paramRequest.append(((Response)localObject).code());
    throw new IOException(paramRequest.toString());
    label300:
    if ((this.source.buffer().exhausted()) && (this.sink.buffer().exhausted())) {
      return null;
    }
    paramRequest = new IOException("TLS tunnel buffered too many bytes!");
    for (;;)
    {
      throw paramRequest;
    }
  }
  
  private Request createTunnelRequest()
  {
    Object localObject1 = new Request.Builder().url(this.route.address().url()).method("CONNECT", null).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
    Object localObject2 = new Response.Builder().request((Request)localObject1).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header("Proxy-Authenticate", "OkHttp-Preemptive").build();
    localObject2 = this.route.address().proxyAuthenticator().authenticate(this.route, (Response)localObject2);
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  private void establishProtocol(ConnectionSpecSelector paramConnectionSpecSelector, int paramInt, Call paramCall, EventListener paramEventListener)
  {
    if (this.route.address().sslSocketFactory() == null)
    {
      if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE))
      {
        this.socket = this.rawSocket;
        this.protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        startHttp2(paramInt);
        return;
      }
      this.socket = this.rawSocket;
      this.protocol = Protocol.HTTP_1_1;
      return;
    }
    paramEventListener.secureConnectStart(paramCall);
    connectTls(paramConnectionSpecSelector);
    paramEventListener.secureConnectEnd(paramCall, this.handshake);
    if (this.protocol == Protocol.HTTP_2) {
      startHttp2(paramInt);
    }
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
  
  /* Error */
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Call arg6, EventListener paramEventListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 332	okhttp3/internal/connection/RealConnection:protocol	Lokhttp3/Protocol;
    //   4: ifnonnull +491 -> 495
    //   7: aload_0
    //   8: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   11: invokevirtual 76	okhttp3/Route:address	()Lokhttp3/Address;
    //   14: invokevirtual 615	okhttp3/Address:connectionSpecs	()Ljava/util/List;
    //   17: astore 8
    //   19: new 219	okhttp3/internal/connection/ConnectionSpecSelector
    //   22: dup
    //   23: aload 8
    //   25: invokespecial 618	okhttp3/internal/connection/ConnectionSpecSelector:<init>	(Ljava/util/List;)V
    //   28: astore 10
    //   30: aload_0
    //   31: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   34: invokevirtual 76	okhttp3/Route:address	()Lokhttp3/Address;
    //   37: invokevirtual 197	okhttp3/Address:sslSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   40: ifnonnull +118 -> 158
    //   43: aload 8
    //   45: getstatic 622	okhttp3/ConnectionSpec:CLEARTEXT	Lokhttp3/ConnectionSpec;
    //   48: invokeinterface 563 2 0
    //   53: ifeq +87 -> 140
    //   56: aload_0
    //   57: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   60: invokevirtual 76	okhttp3/Route:address	()Lokhttp3/Address;
    //   63: invokevirtual 201	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   66: invokevirtual 206	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   69: astore 8
    //   71: invokestatic 130	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   74: aload 8
    //   76: invokevirtual 625	okhttp3/internal/platform/Platform:isCleartextTrafficPermitted	(Ljava/lang/String;)Z
    //   79: ifeq +6 -> 85
    //   82: goto +97 -> 179
    //   85: new 169	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   92: astore 6
    //   94: aload 6
    //   96: ldc_w 627
    //   99: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 6
    //   105: aload 8
    //   107: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 6
    //   113: ldc_w 629
    //   116: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: new 631	okhttp3/internal/connection/RouteException
    //   123: dup
    //   124: new 633	java/net/UnknownServiceException
    //   127: dup
    //   128: aload 6
    //   130: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokespecial 634	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   136: invokespecial 637	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   139: athrow
    //   140: new 631	okhttp3/internal/connection/RouteException
    //   143: dup
    //   144: new 633	java/net/UnknownServiceException
    //   147: dup
    //   148: ldc_w 639
    //   151: invokespecial 634	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   154: invokespecial 637	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   157: athrow
    //   158: aload_0
    //   159: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   162: invokevirtual 76	okhttp3/Route:address	()Lokhttp3/Address;
    //   165: invokevirtual 233	okhttp3/Address:protocols	()Ljava/util/List;
    //   168: getstatic 560	okhttp3/Protocol:H2_PRIOR_KNOWLEDGE	Lokhttp3/Protocol;
    //   171: invokeinterface 563 2 0
    //   176: ifne +301 -> 477
    //   179: aconst_null
    //   180: astore 9
    //   182: aload_0
    //   183: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   186: invokevirtual 642	okhttp3/Route:requiresTunnel	()Z
    //   189: ifeq +31 -> 220
    //   192: aload_0
    //   193: iload_1
    //   194: iload_2
    //   195: iload_3
    //   196: aload 6
    //   198: aload 7
    //   200: invokespecial 644	okhttp3/internal/connection/RealConnection:connectTunnel	(IIILokhttp3/Call;Lokhttp3/EventListener;)V
    //   203: aload_0
    //   204: getfield 110	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   207: astore 8
    //   209: aload 8
    //   211: ifnonnull +6 -> 217
    //   214: goto +53 -> 267
    //   217: goto +13 -> 230
    //   220: aload_0
    //   221: iload_1
    //   222: iload_2
    //   223: aload 6
    //   225: aload 7
    //   227: invokespecial 357	okhttp3/internal/connection/RealConnection:connectSocket	(IILokhttp3/Call;Lokhttp3/EventListener;)V
    //   230: aload_0
    //   231: aload 10
    //   233: iload 4
    //   235: aload 6
    //   237: aload 7
    //   239: invokespecial 646	okhttp3/internal/connection/RealConnection:establishProtocol	(Lokhttp3/internal/connection/ConnectionSpecSelector;ILokhttp3/Call;Lokhttp3/EventListener;)V
    //   242: aload 7
    //   244: aload 6
    //   246: aload_0
    //   247: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   250: invokevirtual 114	okhttp3/Route:socketAddress	()Ljava/net/InetSocketAddress;
    //   253: aload_0
    //   254: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   257: invokevirtual 72	okhttp3/Route:proxy	()Ljava/net/Proxy;
    //   260: aload_0
    //   261: getfield 332	okhttp3/internal/connection/RealConnection:protocol	Lokhttp3/Protocol;
    //   264: invokevirtual 365	okhttp3/EventListener:connectEnd	(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;)V
    //   267: aload_0
    //   268: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   271: invokevirtual 642	okhttp3/Route:requiresTunnel	()Z
    //   274: ifeq +31 -> 305
    //   277: aload_0
    //   278: getfield 110	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   281: ifnull +6 -> 287
    //   284: goto +21 -> 305
    //   287: new 631	okhttp3/internal/connection/RouteException
    //   290: dup
    //   291: new 648	java/net/ProtocolException
    //   294: dup
    //   295: ldc_w 650
    //   298: invokespecial 651	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   301: invokespecial 637	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   304: athrow
    //   305: aload_0
    //   306: getfield 600	okhttp3/internal/connection/RealConnection:http2Connection	Lokhttp3/internal/http2/Http2Connection;
    //   309: ifnull +35 -> 344
    //   312: aload_0
    //   313: getfield 57	okhttp3/internal/connection/RealConnection:connectionPool	Lokhttp3/ConnectionPool;
    //   316: astore 6
    //   318: aload 6
    //   320: monitorenter
    //   321: aload_0
    //   322: aload_0
    //   323: getfield 600	okhttp3/internal/connection/RealConnection:http2Connection	Lokhttp3/internal/http2/Http2Connection;
    //   326: invokevirtual 654	okhttp3/internal/http2/Http2Connection:maxConcurrentStreams	()I
    //   329: putfield 46	okhttp3/internal/connection/RealConnection:allocationLimit	I
    //   332: aload 6
    //   334: monitorexit
    //   335: return
    //   336: astore 7
    //   338: aload 6
    //   340: monitorexit
    //   341: aload 7
    //   343: athrow
    //   344: return
    //   345: astore 8
    //   347: goto +10 -> 357
    //   350: astore 8
    //   352: goto +5 -> 357
    //   355: astore 8
    //   357: aload_0
    //   358: getfield 320	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   361: invokestatic 346	okhttp3/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   364: aload_0
    //   365: getfield 110	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   368: invokestatic 346	okhttp3/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   371: aload_0
    //   372: aconst_null
    //   373: putfield 320	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   376: aload_0
    //   377: aconst_null
    //   378: putfield 110	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   381: aload_0
    //   382: aconst_null
    //   383: putfield 144	okhttp3/internal/connection/RealConnection:source	Lokio/BufferedSource;
    //   386: aload_0
    //   387: aconst_null
    //   388: putfield 152	okhttp3/internal/connection/RealConnection:sink	Lokio/BufferedSink;
    //   391: aload_0
    //   392: aconst_null
    //   393: putfield 322	okhttp3/internal/connection/RealConnection:handshake	Lokhttp3/Handshake;
    //   396: aload_0
    //   397: aconst_null
    //   398: putfield 332	okhttp3/internal/connection/RealConnection:protocol	Lokhttp3/Protocol;
    //   401: aload_0
    //   402: aconst_null
    //   403: putfield 600	okhttp3/internal/connection/RealConnection:http2Connection	Lokhttp3/internal/http2/Http2Connection;
    //   406: aload 7
    //   408: aload 6
    //   410: aload_0
    //   411: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   414: invokevirtual 114	okhttp3/Route:socketAddress	()Ljava/net/InetSocketAddress;
    //   417: aload_0
    //   418: getfield 59	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   421: invokevirtual 72	okhttp3/Route:proxy	()Ljava/net/Proxy;
    //   424: aconst_null
    //   425: aload 8
    //   427: invokevirtual 658	okhttp3/EventListener:connectFailed	(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;Ljava/io/IOException;)V
    //   430: aload 9
    //   432: ifnonnull +17 -> 449
    //   435: new 631	okhttp3/internal/connection/RouteException
    //   438: dup
    //   439: aload 8
    //   441: invokespecial 637	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   444: astore 9
    //   446: goto +10 -> 456
    //   449: aload 9
    //   451: aload 8
    //   453: invokevirtual 661	okhttp3/internal/connection/RouteException:addConnectException	(Ljava/io/IOException;)V
    //   456: iload 5
    //   458: ifeq +16 -> 474
    //   461: aload 10
    //   463: aload 8
    //   465: invokevirtual 665	okhttp3/internal/connection/ConnectionSpecSelector:connectionFailed	(Ljava/io/IOException;)Z
    //   468: ifeq +6 -> 474
    //   471: goto -289 -> 182
    //   474: aload 9
    //   476: athrow
    //   477: new 631	okhttp3/internal/connection/RouteException
    //   480: dup
    //   481: new 633	java/net/UnknownServiceException
    //   484: dup
    //   485: ldc_w 667
    //   488: invokespecial 634	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   491: invokespecial 637	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   494: athrow
    //   495: new 669	java/lang/IllegalStateException
    //   498: dup
    //   499: ldc_w 671
    //   502: invokespecial 672	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   505: astore 6
    //   507: goto +6 -> 513
    //   510: aload 6
    //   512: athrow
    //   513: goto -3 -> 510
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	516	0	this	RealConnection
    //   0	516	1	paramInt1	int
    //   0	516	2	paramInt2	int
    //   0	516	3	paramInt3	int
    //   0	516	4	paramInt4	int
    //   0	516	5	paramBoolean	boolean
    //   0	516	7	paramEventListener	EventListener
    //   17	193	8	localObject	Object
    //   345	1	8	localIOException1	IOException
    //   350	1	8	localIOException2	IOException
    //   355	109	8	localIOException3	IOException
    //   180	295	9	localRouteException	RouteException
    //   28	434	10	localConnectionSpecSelector	ConnectionSpecSelector
    // Exception table:
    //   from	to	target	type
    //   321	335	336	finally
    //   338	341	336	finally
    //   230	267	345	java/io/IOException
    //   220	230	350	java/io/IOException
    //   182	209	355	java/io/IOException
  }
  
  public Handshake handshake()
  {
    return this.handshake;
  }
  
  public boolean isEligible(Address paramAddress, @Nullable Route paramRoute)
  {
    if (this.allocations.size() < this.allocationLimit)
    {
      if (this.noNewStreams) {
        return false;
      }
      if (!Internal.instance.equalsNonHost(this.route.address(), paramAddress)) {
        return false;
      }
      if (paramAddress.url().host().equals(route().address().url().host())) {
        return true;
      }
      if (this.http2Connection == null) {
        return false;
      }
      if (paramRoute == null) {
        return false;
      }
      if (paramRoute.proxy().type() != Proxy.Type.DIRECT) {
        return false;
      }
      if (this.route.proxy().type() != Proxy.Type.DIRECT) {
        return false;
      }
      if (!this.route.socketAddress().equals(paramRoute.socketAddress())) {
        return false;
      }
      if (paramRoute.address().hostnameVerifier() != OkHostnameVerifier.INSTANCE) {
        return false;
      }
      if (!supportsUrl(paramAddress.url())) {
        return false;
      }
    }
    try
    {
      paramAddress.certificatePinner().check(paramAddress.url().host(), handshake().peerCertificates());
      return true;
    }
    catch (SSLPeerUnverifiedException paramAddress) {}
    return false;
    return false;
  }
  
  public boolean isHealthy(boolean paramBoolean)
  {
    if ((!this.socket.isClosed()) && (!this.socket.isInputShutdown()))
    {
      if (this.socket.isOutputShutdown()) {
        return false;
      }
      Http2Connection localHttp2Connection = this.http2Connection;
      if (localHttp2Connection != null) {
        return localHttp2Connection.isHealthy(System.nanoTime());
      }
      if (!paramBoolean) {}
    }
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
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      return true;
    }
    catch (IOException localIOException) {}
    return false;
    return false;
  }
  
  public boolean isMultiplexed()
  {
    return this.http2Connection != null;
  }
  
  public HttpCodec newCodec(OkHttpClient paramOkHttpClient, Interceptor.Chain paramChain, StreamAllocation paramStreamAllocation)
  {
    Http2Connection localHttp2Connection = this.http2Connection;
    if (localHttp2Connection != null) {
      return new Http2Codec(paramOkHttpClient, paramChain, paramStreamAllocation, localHttp2Connection);
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
    boolean bool2 = paramHttpUrl.host().equals(this.route.address().url().host());
    boolean bool1 = true;
    if (!bool2)
    {
      if ((this.handshake != null) && (OkHostnameVerifier.INSTANCE.verify(paramHttpUrl.host(), (X509Certificate)this.handshake.peerCertificates().get(0)))) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Connection{");
    localStringBuilder.append(this.route.address().url().host());
    localStringBuilder.append(":");
    localStringBuilder.append(this.route.address().url().port());
    localStringBuilder.append(", proxy=");
    localStringBuilder.append(this.route.proxy());
    localStringBuilder.append(" hostAddress=");
    localStringBuilder.append(this.route.socketAddress());
    localStringBuilder.append(" cipherSuite=");
    Object localObject = this.handshake;
    if (localObject != null) {
      localObject = ((Handshake)localObject).cipherSuite();
    } else {
      localObject = "none";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(" protocol=");
    localStringBuilder.append(this.protocol);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.connection.RealConnection
 * JD-Core Version:    0.7.0.1
 */