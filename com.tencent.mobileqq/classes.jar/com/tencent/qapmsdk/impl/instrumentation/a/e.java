package com.tencent.qapmsdk.impl.instrumentation.a;

import com.tencent.qapmsdk.impl.instrumentation.c;
import com.tencent.qapmsdk.impl.instrumentation.h;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

public class e<T>
  implements ResponseHandler<T>
{
  private final ResponseHandler<T> a;
  private final h b;
  
  private e(ResponseHandler<T> paramResponseHandler, h paramh)
  {
    this.a = paramResponseHandler;
    this.b = paramh;
  }
  
  public static <T> ResponseHandler<? extends T> a(ResponseHandler<? extends T> paramResponseHandler, h paramh)
  {
    return new e(paramResponseHandler, paramh);
  }
  
  public T handleResponse(HttpResponse paramHttpResponse)
  {
    c.a(this.b, paramHttpResponse);
    return this.a.handleResponse(paramHttpResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.a.e
 * JD-Core Version:    0.7.0.1
 */