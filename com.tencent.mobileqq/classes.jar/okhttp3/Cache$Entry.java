package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.cache.DiskLruCache.Editor;
import okhttp3.internal.cache.DiskLruCache.Snapshot;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

final class Cache$Entry
{
  private static final String RECEIVED_MILLIS = Platform.get().getPrefix() + "-Received-Millis";
  private static final String SENT_MILLIS = Platform.get().getPrefix() + "-Sent-Millis";
  private final int code;
  @Nullable
  private final Handshake handshake;
  private final String message;
  private final Protocol protocol;
  private final long receivedResponseMillis;
  private final String requestMethod;
  private final Headers responseHeaders;
  private final long sentRequestMillis;
  private final String url;
  private final Headers varyHeaders;
  
  Cache$Entry(Response paramResponse)
  {
    this.url = paramResponse.request().url().toString();
    this.varyHeaders = HttpHeaders.varyHeaders(paramResponse);
    this.requestMethod = paramResponse.request().method();
    this.protocol = paramResponse.protocol();
    this.code = paramResponse.code();
    this.message = paramResponse.message();
    this.responseHeaders = paramResponse.headers();
    this.handshake = paramResponse.handshake();
    this.sentRequestMillis = paramResponse.sentRequestAtMillis();
    this.receivedResponseMillis = paramResponse.receivedResponseAtMillis();
  }
  
  Cache$Entry(Source paramSource)
  {
    for (;;)
    {
      try
      {
        BufferedSource localBufferedSource1 = Okio.buffer(paramSource);
        this.url = localBufferedSource1.readUtf8LineStrict();
        this.requestMethod = localBufferedSource1.readUtf8LineStrict();
        localObject1 = new Headers.Builder();
        int k = Cache.readInt(localBufferedSource1);
        int i = 0;
        if (i < k)
        {
          ((Headers.Builder)localObject1).addLenient(localBufferedSource1.readUtf8LineStrict());
          i += 1;
          continue;
        }
        this.varyHeaders = ((Headers.Builder)localObject1).build();
        localObject1 = StatusLine.parse(localBufferedSource1.readUtf8LineStrict());
        this.protocol = ((StatusLine)localObject1).protocol;
        this.code = ((StatusLine)localObject1).code;
        this.message = ((StatusLine)localObject1).message;
        localObject1 = new Headers.Builder();
        k = Cache.readInt(localBufferedSource1);
        i = j;
        if (i < k)
        {
          ((Headers.Builder)localObject1).addLenient(localBufferedSource1.readUtf8LineStrict());
          i += 1;
          continue;
        }
        localObject2 = ((Headers.Builder)localObject1).get(SENT_MILLIS);
        localObject3 = ((Headers.Builder)localObject1).get(RECEIVED_MILLIS);
        ((Headers.Builder)localObject1).removeAll(SENT_MILLIS);
        ((Headers.Builder)localObject1).removeAll(RECEIVED_MILLIS);
        if (localObject2 != null)
        {
          l1 = Long.parseLong((String)localObject2);
          this.sentRequestMillis = l1;
          l1 = l2;
          if (localObject3 != null) {
            l1 = Long.parseLong((String)localObject3);
          }
          this.receivedResponseMillis = l1;
          this.responseHeaders = ((Headers.Builder)localObject1).build();
          if (!isHttps()) {
            break label414;
          }
          localObject1 = localBufferedSource1.readUtf8LineStrict();
          if (((String)localObject1).length() <= 0) {
            break;
          }
          throw new IOException("expected \"\" but was \"" + (String)localObject1 + "\"");
        }
      }
      finally
      {
        paramSource.close();
      }
      long l1 = 0L;
    }
    Object localObject1 = CipherSuite.forJavaName(localBufferedSource2.readUtf8LineStrict());
    Object localObject2 = readCertificateList(localBufferedSource2);
    Object localObject3 = readCertificateList(localBufferedSource2);
    TlsVersion localTlsVersion;
    if (!localBufferedSource2.exhausted()) {
      localTlsVersion = TlsVersion.forJavaName(localBufferedSource2.readUtf8LineStrict());
    }
    label414:
    for (this.handshake = Handshake.get(localTlsVersion, (CipherSuite)localObject1, (List)localObject2, (List)localObject3);; this.handshake = null)
    {
      paramSource.close();
      return;
      localTlsVersion = TlsVersion.SSL_3_0;
      break;
    }
  }
  
  private boolean isHttps()
  {
    return this.url.startsWith("https://");
  }
  
  /* Error */
  private List<Certificate> readCertificateList(BufferedSource paramBufferedSource)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 143	okhttp3/Cache:readInt	(Lokio/BufferedSource;)I
    //   4: istore_3
    //   5: iload_3
    //   6: iconst_m1
    //   7: if_icmpne +11 -> 18
    //   10: invokestatic 235	java/util/Collections:emptyList	()Ljava/util/List;
    //   13: astore 4
    //   15: aload 4
    //   17: areturn
    //   18: ldc 237
    //   20: invokestatic 243	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   23: astore 6
    //   25: new 245	java/util/ArrayList
    //   28: dup
    //   29: iload_3
    //   30: invokespecial 248	java/util/ArrayList:<init>	(I)V
    //   33: astore 5
    //   35: iconst_0
    //   36: istore_2
    //   37: aload 5
    //   39: astore 4
    //   41: iload_2
    //   42: iload_3
    //   43: if_icmpge -28 -> 15
    //   46: aload_1
    //   47: invokeinterface 134 1 0
    //   52: astore 4
    //   54: new 250	okio/Buffer
    //   57: dup
    //   58: invokespecial 251	okio/Buffer:<init>	()V
    //   61: astore 7
    //   63: aload 7
    //   65: aload 4
    //   67: invokestatic 257	okio/ByteString:decodeBase64	(Ljava/lang/String;)Lokio/ByteString;
    //   70: invokevirtual 261	okio/Buffer:write	(Lokio/ByteString;)Lokio/Buffer;
    //   73: pop
    //   74: aload 5
    //   76: aload 6
    //   78: aload 7
    //   80: invokevirtual 265	okio/Buffer:inputStream	()Ljava/io/InputStream;
    //   83: invokevirtual 269	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   86: invokeinterface 275 2 0
    //   91: pop
    //   92: iload_2
    //   93: iconst_1
    //   94: iadd
    //   95: istore_2
    //   96: goto -59 -> 37
    //   99: astore_1
    //   100: new 182	java/io/IOException
    //   103: dup
    //   104: aload_1
    //   105: invokevirtual 278	java/security/cert/CertificateException:getMessage	()Ljava/lang/String;
    //   108: invokespecial 189	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	Entry
    //   0	112	1	paramBufferedSource	BufferedSource
    //   36	60	2	i	int
    //   4	40	3	j	int
    //   13	53	4	localObject	Object
    //   33	42	5	localArrayList	java.util.ArrayList
    //   23	54	6	localCertificateFactory	java.security.cert.CertificateFactory
    //   61	18	7	localBuffer	okio.Buffer
    // Exception table:
    //   from	to	target	type
    //   18	35	99	java/security/cert/CertificateException
    //   46	92	99	java/security/cert/CertificateException
  }
  
  private void writeCertList(BufferedSink paramBufferedSink, List<Certificate> paramList)
  {
    try
    {
      paramBufferedSink.writeDecimalLong(paramList.size()).writeByte(10);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        paramBufferedSink.writeUtf8(ByteString.of(((Certificate)paramList.get(i)).getEncoded()).base64()).writeByte(10);
        i += 1;
      }
      return;
    }
    catch (CertificateEncodingException paramBufferedSink)
    {
      throw new IOException(paramBufferedSink.getMessage());
    }
  }
  
  public boolean matches(Request paramRequest, Response paramResponse)
  {
    return (this.url.equals(paramRequest.url().toString())) && (this.requestMethod.equals(paramRequest.method())) && (HttpHeaders.varyMatches(paramResponse, this.varyHeaders, paramRequest));
  }
  
  public Response response(DiskLruCache.Snapshot paramSnapshot)
  {
    String str1 = this.responseHeaders.get("Content-Type");
    String str2 = this.responseHeaders.get("Content-Length");
    Request localRequest = new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build();
    return new Response.Builder().request(localRequest).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new Cache.CacheResponseBody(paramSnapshot, str1, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
  }
  
  public void writeTo(DiskLruCache.Editor paramEditor)
  {
    int j = 0;
    paramEditor = Okio.buffer(paramEditor.newSink(0));
    paramEditor.writeUtf8(this.url).writeByte(10);
    paramEditor.writeUtf8(this.requestMethod).writeByte(10);
    paramEditor.writeDecimalLong(this.varyHeaders.size()).writeByte(10);
    int k = this.varyHeaders.size();
    int i = 0;
    while (i < k)
    {
      paramEditor.writeUtf8(this.varyHeaders.name(i)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(i)).writeByte(10);
      i += 1;
    }
    paramEditor.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
    paramEditor.writeDecimalLong(this.responseHeaders.size() + 2).writeByte(10);
    k = this.responseHeaders.size();
    i = j;
    while (i < k)
    {
      paramEditor.writeUtf8(this.responseHeaders.name(i)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(i)).writeByte(10);
      i += 1;
    }
    paramEditor.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
    paramEditor.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
    if (isHttps())
    {
      paramEditor.writeByte(10);
      paramEditor.writeUtf8(this.handshake.cipherSuite().javaName()).writeByte(10);
      writeCertList(paramEditor, this.handshake.peerCertificates());
      writeCertList(paramEditor, this.handshake.localCertificates());
      paramEditor.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
    }
    paramEditor.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.Cache.Entry
 * JD-Core Version:    0.7.0.1
 */