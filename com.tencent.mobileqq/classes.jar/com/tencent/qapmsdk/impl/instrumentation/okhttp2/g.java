package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.tencent.qapmsdk.common.logger.Logger;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;

public class g
  extends Response.Builder
{
  private Response.Builder a;
  
  public g(Response.Builder paramBuilder)
  {
    this.a = paramBuilder;
  }
  
  public Response.Builder addHeader(String paramString1, String paramString2)
  {
    return this.a.addHeader(paramString1, paramString2);
  }
  
  public Response.Builder body(ResponseBody paramResponseBody)
  {
    if (paramResponseBody != null) {}
    try
    {
      Object localObject = paramResponseBody.source();
      if (localObject != null)
      {
        Buffer localBuffer = new Buffer();
        ((BufferedSource)localObject).readAll(localBuffer);
        localObject = this.a.body(new e(paramResponseBody, localBuffer));
        return localObject;
      }
    }
    catch (IOException localIOException)
    {
      Logger.INSTANCE.exception("QAPM_Impl_ResponseBuilderExtension", "IOException reading from source: ", localIOException);
      return this.a.body(paramResponseBody);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Logger.INSTANCE.exception("QAPM_Impl_ResponseBuilderExtension", "IllegalStateException reading from source: ", localIllegalStateException);
      }
    }
  }
  
  public Response build()
  {
    return this.a.build();
  }
  
  public Response.Builder cacheResponse(Response paramResponse)
  {
    return this.a.cacheResponse(paramResponse);
  }
  
  public Response.Builder code(int paramInt)
  {
    return this.a.code(paramInt);
  }
  
  public Response.Builder handshake(Handshake paramHandshake)
  {
    return this.a.handshake(paramHandshake);
  }
  
  public Response.Builder header(String paramString1, String paramString2)
  {
    return this.a.header(paramString1, paramString2);
  }
  
  public Response.Builder headers(Headers paramHeaders)
  {
    return this.a.headers(paramHeaders);
  }
  
  public Response.Builder message(String paramString)
  {
    return this.a.message(paramString);
  }
  
  public Response.Builder networkResponse(Response paramResponse)
  {
    return this.a.networkResponse(paramResponse);
  }
  
  public Response.Builder priorResponse(Response paramResponse)
  {
    return this.a.priorResponse(paramResponse);
  }
  
  public Response.Builder protocol(Protocol paramProtocol)
  {
    return this.a.protocol(paramProtocol);
  }
  
  public Response.Builder removeHeader(String paramString)
  {
    return this.a.removeHeader(paramString);
  }
  
  public Response.Builder request(Request paramRequest)
  {
    return this.a.request(paramRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.g
 * JD-Core Version:    0.7.0.1
 */