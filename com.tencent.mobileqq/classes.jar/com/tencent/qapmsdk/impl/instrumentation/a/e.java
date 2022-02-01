package com.tencent.qapmsdk.impl.instrumentation.a;

import com.tencent.qapmsdk.impl.instrumentation.b;
import com.tencent.qapmsdk.impl.instrumentation.g;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

public class e<T>
  implements ResponseHandler<T>
{
  private final ResponseHandler<T> a;
  private final g b;
  
  private e(ResponseHandler<T> paramResponseHandler, g paramg)
  {
    this.a = paramResponseHandler;
    this.b = paramg;
  }
  
  public static <T> ResponseHandler<? extends T> a(ResponseHandler<? extends T> paramResponseHandler, g paramg)
  {
    return new e(paramResponseHandler, paramg);
  }
  
  public T handleResponse(HttpResponse paramHttpResponse)
  {
    b.a(this.b, paramHttpResponse);
    return this.a.handleResponse(paramHttpResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.a.e
 * JD-Core Version:    0.7.0.1
 */