package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.cache.DiskLruCache.Editor;
import okhttp3.internal.cache.DiskLruCache.Snapshot;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

final class Cache$Entry
{
  private static final String RECEIVED_MILLIS;
  private static final String SENT_MILLIS;
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
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Platform.get().getPrefix());
    localStringBuilder.append("-Sent-Millis");
    SENT_MILLIS = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Platform.get().getPrefix());
    localStringBuilder.append("-Received-Millis");
    RECEIVED_MILLIS = localStringBuilder.toString();
  }
  
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
    try
    {
      localObject1 = Okio.buffer(paramSource);
      this.url = ((BufferedSource)localObject1).readUtf8LineStrict();
      this.requestMethod = ((BufferedSource)localObject1).readUtf8LineStrict();
      localObject3 = new Headers.Builder();
      int k = Cache.readInt((BufferedSource)localObject1);
      int j = 0;
      int i = 0;
      while (i < k)
      {
        ((Headers.Builder)localObject3).addLenient(((BufferedSource)localObject1).readUtf8LineStrict());
        i += 1;
      }
      this.varyHeaders = ((Headers.Builder)localObject3).build();
      localObject3 = StatusLine.parse(((BufferedSource)localObject1).readUtf8LineStrict());
      this.protocol = ((StatusLine)localObject3).protocol;
      this.code = ((StatusLine)localObject3).code;
      this.message = ((StatusLine)localObject3).message;
      localObject3 = new Headers.Builder();
      k = Cache.readInt((BufferedSource)localObject1);
      i = j;
      while (i < k)
      {
        ((Headers.Builder)localObject3).addLenient(((BufferedSource)localObject1).readUtf8LineStrict());
        i += 1;
      }
      localObject4 = ((Headers.Builder)localObject3).get(SENT_MILLIS);
      localObject5 = ((Headers.Builder)localObject3).get(RECEIVED_MILLIS);
      ((Headers.Builder)localObject3).removeAll(SENT_MILLIS);
      ((Headers.Builder)localObject3).removeAll(RECEIVED_MILLIS);
      l2 = 0L;
      if (localObject4 == null) {
        break label438;
      }
      l1 = Long.parseLong((String)localObject4);
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        long l2;
        paramSource.close();
        for (;;)
        {
          throw localObject2;
        }
        long l1 = 0L;
      }
    }
    this.sentRequestMillis = l1;
    l1 = l2;
    if (localObject5 != null) {
      l1 = Long.parseLong((String)localObject5);
    }
    this.receivedResponseMillis = l1;
    this.responseHeaders = ((Headers.Builder)localObject3).build();
    if (isHttps())
    {
      localObject3 = ((BufferedSource)localObject1).readUtf8LineStrict();
      if (((String)localObject3).length() <= 0)
      {
        localObject3 = CipherSuite.forJavaName(((BufferedSource)localObject1).readUtf8LineStrict());
        localObject4 = readCertificateList((BufferedSource)localObject1);
        localObject5 = readCertificateList((BufferedSource)localObject1);
        if (!((BufferedSource)localObject1).exhausted()) {
          localObject1 = TlsVersion.forJavaName(((BufferedSource)localObject1).readUtf8LineStrict());
        } else {
          localObject1 = TlsVersion.SSL_3_0;
        }
        this.handshake = Handshake.get((TlsVersion)localObject1, (CipherSuite)localObject3, (List)localObject4, (List)localObject5);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("expected \"\" but was \"");
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append("\"");
        throw new IOException(((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      this.handshake = null;
    }
    paramSource.close();
  }
  
  private boolean isHttps()
  {
    return this.url.startsWith("https://");
  }
  
  private List<Certificate> readCertificateList(BufferedSource paramBufferedSource)
  {
    int j = Cache.readInt(paramBufferedSource);
    if (j == -1) {
      return Collections.emptyList();
    }
    try
    {
      CertificateFactory localCertificateFactory = CertificateFactory.getInstance("X.509");
      ArrayList localArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        String str = paramBufferedSource.readUtf8LineStrict();
        Buffer localBuffer = new Buffer();
        localBuffer.write(ByteString.decodeBase64(str));
        localArrayList.add(localCertificateFactory.generateCertificate(localBuffer.inputStream()));
        i += 1;
      }
      return localArrayList;
    }
    catch (CertificateException paramBufferedSource)
    {
      paramBufferedSource = new IOException(paramBufferedSource.getMessage());
    }
    for (;;)
    {
      throw paramBufferedSource;
    }
  }
  
  private void writeCertList(BufferedSink paramBufferedSink, List<Certificate> paramList)
  {
    try
    {
      paramBufferedSink.writeDecimalLong(paramList.size()).writeByte(10);
      int i = 0;
      int j = paramList.size();
      while (i < j)
      {
        paramBufferedSink.writeUtf8(ByteString.of(((Certificate)paramList.get(i)).getEncoded()).base64()).writeByte(10);
        i += 1;
      }
      return;
    }
    catch (CertificateEncodingException paramBufferedSink)
    {
      paramBufferedSink = new IOException(paramBufferedSink.getMessage());
    }
    for (;;)
    {
      throw paramBufferedSink;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.Cache.Entry
 * JD-Core Version:    0.7.0.1
 */