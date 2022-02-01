package okhttp3;

import javax.annotation.Nullable;

public class Response$Builder
{
  @Nullable
  ResponseBody body;
  @Nullable
  Response cacheResponse;
  int code = -1;
  @Nullable
  Handshake handshake;
  Headers.Builder headers;
  String message;
  @Nullable
  Response networkResponse;
  @Nullable
  Response priorResponse;
  @Nullable
  Protocol protocol;
  long receivedResponseAtMillis;
  @Nullable
  Request request;
  long sentRequestAtMillis;
  
  public Response$Builder()
  {
    this.headers = new Headers.Builder();
  }
  
  Response$Builder(Response paramResponse)
  {
    this.request = paramResponse.request;
    this.protocol = paramResponse.protocol;
    this.code = paramResponse.code;
    this.message = paramResponse.message;
    this.handshake = paramResponse.handshake;
    this.headers = paramResponse.headers.newBuilder();
    this.body = paramResponse.body;
    this.networkResponse = paramResponse.networkResponse;
    this.cacheResponse = paramResponse.cacheResponse;
    this.priorResponse = paramResponse.priorResponse;
    this.sentRequestAtMillis = paramResponse.sentRequestAtMillis;
    this.receivedResponseAtMillis = paramResponse.receivedResponseAtMillis;
  }
  
  private void checkPriorResponse(Response paramResponse)
  {
    if (paramResponse.body != null) {
      throw new IllegalArgumentException("priorResponse.body != null");
    }
  }
  
  private void checkSupportResponse(String paramString, Response paramResponse)
  {
    if (paramResponse.body != null) {
      throw new IllegalArgumentException(paramString + ".body != null");
    }
    if (paramResponse.networkResponse != null) {
      throw new IllegalArgumentException(paramString + ".networkResponse != null");
    }
    if (paramResponse.cacheResponse != null) {
      throw new IllegalArgumentException(paramString + ".cacheResponse != null");
    }
    if (paramResponse.priorResponse != null) {
      throw new IllegalArgumentException(paramString + ".priorResponse != null");
    }
  }
  
  public Builder addHeader(String paramString1, String paramString2)
  {
    this.headers.add(paramString1, paramString2);
    return this;
  }
  
  public Builder body(@Nullable ResponseBody paramResponseBody)
  {
    this.body = paramResponseBody;
    return this;
  }
  
  public Response build()
  {
    if (this.request == null) {
      throw new IllegalStateException("request == null");
    }
    if (this.protocol == null) {
      throw new IllegalStateException("protocol == null");
    }
    if (this.code < 0) {
      throw new IllegalStateException("code < 0: " + this.code);
    }
    if (this.message == null) {
      throw new IllegalStateException("message == null");
    }
    return new Response(this);
  }
  
  public Builder cacheResponse(@Nullable Response paramResponse)
  {
    if (paramResponse != null) {
      checkSupportResponse("cacheResponse", paramResponse);
    }
    this.cacheResponse = paramResponse;
    return this;
  }
  
  public Builder code(int paramInt)
  {
    this.code = paramInt;
    return this;
  }
  
  public Builder handshake(@Nullable Handshake paramHandshake)
  {
    this.handshake = paramHandshake;
    return this;
  }
  
  public Builder header(String paramString1, String paramString2)
  {
    this.headers.set(paramString1, paramString2);
    return this;
  }
  
  public Builder headers(Headers paramHeaders)
  {
    this.headers = paramHeaders.newBuilder();
    return this;
  }
  
  public Builder message(String paramString)
  {
    this.message = paramString;
    return this;
  }
  
  public Builder networkResponse(@Nullable Response paramResponse)
  {
    if (paramResponse != null) {
      checkSupportResponse("networkResponse", paramResponse);
    }
    this.networkResponse = paramResponse;
    return this;
  }
  
  public Builder priorResponse(@Nullable Response paramResponse)
  {
    if (paramResponse != null) {
      checkPriorResponse(paramResponse);
    }
    this.priorResponse = paramResponse;
    return this;
  }
  
  public Builder protocol(Protocol paramProtocol)
  {
    this.protocol = paramProtocol;
    return this;
  }
  
  public Builder receivedResponseAtMillis(long paramLong)
  {
    this.receivedResponseAtMillis = paramLong;
    return this;
  }
  
  public Builder removeHeader(String paramString)
  {
    this.headers.removeAll(paramString);
    return this;
  }
  
  public Builder request(Request paramRequest)
  {
    this.request = paramRequest;
    return this;
  }
  
  public Builder sentRequestAtMillis(long paramLong)
  {
    this.sentRequestAtMillis = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.Response.Builder
 * JD-Core Version:    0.7.0.1
 */