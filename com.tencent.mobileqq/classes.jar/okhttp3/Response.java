package okhttp3;

import java.io.Closeable;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;

public final class Response
  implements Closeable
{
  @Nullable
  final ResponseBody body;
  @Nullable
  private volatile CacheControl cacheControl;
  @Nullable
  final Response cacheResponse;
  final int code;
  @Nullable
  final Handshake handshake;
  final Headers headers;
  final String message;
  @Nullable
  final Response networkResponse;
  @Nullable
  final Response priorResponse;
  final Protocol protocol;
  final long receivedResponseAtMillis;
  final Request request;
  final long sentRequestAtMillis;
  
  Response(Response.Builder paramBuilder)
  {
    this.request = paramBuilder.request;
    this.protocol = paramBuilder.protocol;
    this.code = paramBuilder.code;
    this.message = paramBuilder.message;
    this.handshake = paramBuilder.handshake;
    this.headers = paramBuilder.headers.build();
    this.body = paramBuilder.body;
    this.networkResponse = paramBuilder.networkResponse;
    this.cacheResponse = paramBuilder.cacheResponse;
    this.priorResponse = paramBuilder.priorResponse;
    this.sentRequestAtMillis = paramBuilder.sentRequestAtMillis;
    this.receivedResponseAtMillis = paramBuilder.receivedResponseAtMillis;
  }
  
  @Nullable
  public ResponseBody body()
  {
    return this.body;
  }
  
  public CacheControl cacheControl()
  {
    CacheControl localCacheControl = this.cacheControl;
    if (localCacheControl != null) {
      return localCacheControl;
    }
    localCacheControl = CacheControl.parse(this.headers);
    this.cacheControl = localCacheControl;
    return localCacheControl;
  }
  
  @Nullable
  public Response cacheResponse()
  {
    return this.cacheResponse;
  }
  
  public List<Challenge> challenges()
  {
    if (this.code == 401) {}
    for (String str = "WWW-Authenticate";; str = "Proxy-Authenticate")
    {
      return HttpHeaders.parseChallenges(headers(), str);
      if (this.code != 407) {
        break;
      }
    }
    return Collections.emptyList();
  }
  
  public void close()
  {
    if (this.body == null) {
      throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }
    this.body.close();
  }
  
  public int code()
  {
    return this.code;
  }
  
  @Nullable
  public Handshake handshake()
  {
    return this.handshake;
  }
  
  @Nullable
  public String header(String paramString)
  {
    return header(paramString, null);
  }
  
  @Nullable
  public String header(String paramString1, @Nullable String paramString2)
  {
    paramString1 = this.headers.get(paramString1);
    if (paramString1 != null) {
      paramString2 = paramString1;
    }
    return paramString2;
  }
  
  public List<String> headers(String paramString)
  {
    return this.headers.values(paramString);
  }
  
  public Headers headers()
  {
    return this.headers;
  }
  
  public boolean isRedirect()
  {
    switch (this.code)
    {
    case 304: 
    case 305: 
    case 306: 
    default: 
      return false;
    }
    return true;
  }
  
  public boolean isSuccessful()
  {
    return (this.code >= 200) && (this.code < 300);
  }
  
  public String message()
  {
    return this.message;
  }
  
  @Nullable
  public Response networkResponse()
  {
    return this.networkResponse;
  }
  
  public Response.Builder newBuilder()
  {
    return new Response.Builder(this);
  }
  
  public ResponseBody peekBody(long paramLong)
  {
    Object localObject = this.body.source();
    ((BufferedSource)localObject).request(paramLong);
    localObject = ((BufferedSource)localObject).buffer().clone();
    if (((Buffer)localObject).size() > paramLong)
    {
      Buffer localBuffer = new Buffer();
      localBuffer.write((Buffer)localObject, paramLong);
      ((Buffer)localObject).clear();
      localObject = localBuffer;
    }
    for (;;)
    {
      return ResponseBody.create(this.body.contentType(), ((Buffer)localObject).size(), (BufferedSource)localObject);
    }
  }
  
  @Nullable
  public Response priorResponse()
  {
    return this.priorResponse;
  }
  
  public Protocol protocol()
  {
    return this.protocol;
  }
  
  public long receivedResponseAtMillis()
  {
    return this.receivedResponseAtMillis;
  }
  
  public Request request()
  {
    return this.request;
  }
  
  public long sentRequestAtMillis()
  {
    return this.sentRequestAtMillis;
  }
  
  public String toString()
  {
    return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.Response
 * JD-Core Version:    0.7.0.1
 */