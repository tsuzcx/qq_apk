package okhttp3.internal.http1;

import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http1Codec
  implements HttpCodec
{
  private static final int HEADER_LIMIT = 262144;
  private static final int STATE_CLOSED = 6;
  private static final int STATE_IDLE = 0;
  private static final int STATE_OPEN_REQUEST_BODY = 1;
  private static final int STATE_OPEN_RESPONSE_BODY = 4;
  private static final int STATE_READING_RESPONSE_BODY = 5;
  private static final int STATE_READ_RESPONSE_HEADERS = 3;
  private static final int STATE_WRITING_REQUEST_BODY = 2;
  final OkHttpClient client;
  private long headerLimit = 262144L;
  final BufferedSink sink;
  final BufferedSource source;
  int state = 0;
  final StreamAllocation streamAllocation;
  
  public Http1Codec(OkHttpClient paramOkHttpClient, StreamAllocation paramStreamAllocation, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
  {
    this.client = paramOkHttpClient;
    this.streamAllocation = paramStreamAllocation;
    this.source = paramBufferedSource;
    this.sink = paramBufferedSink;
  }
  
  private String readHeaderLine()
  {
    String str = this.source.readUtf8LineStrict(this.headerLimit);
    this.headerLimit -= str.length();
    return str;
  }
  
  public void cancel()
  {
    RealConnection localRealConnection = this.streamAllocation.connection();
    if (localRealConnection != null) {
      localRealConnection.cancel();
    }
  }
  
  public Sink createRequestBody(Request paramRequest, long paramLong)
  {
    if ("chunked".equalsIgnoreCase(paramRequest.header("Transfer-Encoding"))) {
      return newChunkedSink();
    }
    if (paramLong != -1L) {
      return newFixedLengthSink(paramLong);
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  void detachTimeout(ForwardingTimeout paramForwardingTimeout)
  {
    Timeout localTimeout = paramForwardingTimeout.delegate();
    paramForwardingTimeout.setDelegate(Timeout.NONE);
    localTimeout.clearDeadline();
    localTimeout.clearTimeout();
  }
  
  public void finishRequest()
  {
    this.sink.flush();
  }
  
  public void flushRequest()
  {
    this.sink.flush();
  }
  
  public boolean isClosed()
  {
    return this.state == 6;
  }
  
  public Sink newChunkedSink()
  {
    if (this.state != 1) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 2;
    return new Http1Codec.ChunkedSink(this);
  }
  
  public Source newChunkedSource(HttpUrl paramHttpUrl)
  {
    if (this.state != 4) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 5;
    return new Http1Codec.ChunkedSource(this, paramHttpUrl);
  }
  
  public Sink newFixedLengthSink(long paramLong)
  {
    if (this.state != 1) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 2;
    return new Http1Codec.FixedLengthSink(this, paramLong);
  }
  
  public Source newFixedLengthSource(long paramLong)
  {
    if (this.state != 4) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 5;
    return new Http1Codec.FixedLengthSource(this, paramLong);
  }
  
  public Source newUnknownLengthSource()
  {
    if (this.state != 4) {
      throw new IllegalStateException("state: " + this.state);
    }
    if (this.streamAllocation == null) {
      throw new IllegalStateException("streamAllocation == null");
    }
    this.state = 5;
    this.streamAllocation.noNewStreams();
    return new Http1Codec.UnknownLengthSource(this);
  }
  
  public ResponseBody openResponseBody(Response paramResponse)
  {
    this.streamAllocation.eventListener.responseBodyStart(this.streamAllocation.call);
    String str = paramResponse.header("Content-Type");
    if (!HttpHeaders.hasBody(paramResponse)) {
      return new RealResponseBody(str, 0L, Okio.buffer(newFixedLengthSource(0L)));
    }
    if ("chunked".equalsIgnoreCase(paramResponse.header("Transfer-Encoding"))) {
      return new RealResponseBody(str, -1L, Okio.buffer(newChunkedSource(paramResponse.request().url())));
    }
    long l = HttpHeaders.contentLength(paramResponse);
    if (l != -1L) {
      return new RealResponseBody(str, l, Okio.buffer(newFixedLengthSource(l)));
    }
    return new RealResponseBody(str, -1L, Okio.buffer(newUnknownLengthSource()));
  }
  
  public Headers readHeaders()
  {
    Headers.Builder localBuilder = new Headers.Builder();
    for (;;)
    {
      String str = readHeaderLine();
      if (str.length() == 0) {
        break;
      }
      Internal.instance.addLenient(localBuilder, str);
    }
    return localBuilder.build();
  }
  
  public Response.Builder readResponseHeaders(boolean paramBoolean)
  {
    if ((this.state != 1) && (this.state != 3)) {
      throw new IllegalStateException("state: " + this.state);
    }
    Object localObject;
    try
    {
      StatusLine localStatusLine = StatusLine.parse(readHeaderLine());
      localObject = new Response.Builder().protocol(localStatusLine.protocol).code(localStatusLine.code).message(localStatusLine.message).headers(readHeaders());
      if ((paramBoolean) && (localStatusLine.code == 100)) {
        return null;
      }
      if (localStatusLine.code == 100)
      {
        this.state = 3;
        return localObject;
      }
    }
    catch (EOFException localEOFException)
    {
      localObject = new IOException("unexpected end of stream on " + this.streamAllocation);
      ((IOException)localObject).initCause(localEOFException);
      throw ((Throwable)localObject);
    }
    this.state = 4;
    return localObject;
  }
  
  public void writeRequest(Headers paramHeaders, String paramString)
  {
    if (this.state != 0) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.sink.writeUtf8(paramString).writeUtf8("\r\n");
    int i = 0;
    int j = paramHeaders.size();
    while (i < j)
    {
      this.sink.writeUtf8(paramHeaders.name(i)).writeUtf8(": ").writeUtf8(paramHeaders.value(i)).writeUtf8("\r\n");
      i += 1;
    }
    this.sink.writeUtf8("\r\n");
    this.state = 1;
  }
  
  public void writeRequestHeaders(Request paramRequest)
  {
    String str = RequestLine.get(paramRequest, this.streamAllocation.connection().route().proxy().type());
    writeRequest(paramRequest.headers(), str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.internal.http1.Http1Codec
 * JD-Core Version:    0.7.0.1
 */