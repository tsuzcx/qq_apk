package com.tencent.qapmsdk.impl.c;

import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.g.b;
import java.lang.reflect.Field;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class c
  implements Call
{
  private Call a;
  
  public c(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    this.a = paramOkHttpClient.newCall(paramRequest);
  }
  
  private Request a(Request paramRequest, long paramLong)
  {
    Request localRequest = paramRequest;
    Object localObject;
    try
    {
      if (!b.c()) {
        return paramRequest;
      }
      localRequest = paramRequest;
      localObject = paramRequest;
      if (TextUtils.isEmpty(paramRequest.header("X-QAPM-Qt")))
      {
        localRequest = paramRequest;
        localObject = this.a.getClass().getDeclaredField("originalRequest");
        localRequest = paramRequest;
        ((Field)localObject).setAccessible(true);
        localRequest = paramRequest;
        paramRequest = ((Request)((Field)localObject).get(this.a)).newBuilder().addHeader("X-QAPM-Qt", String.valueOf(paramLong)).build();
        localRequest = paramRequest;
        ((Field)localObject).set(this.a, paramRequest);
        return paramRequest;
      }
    }
    catch (Exception paramRequest)
    {
      Logger.INSTANCE.exception("QAPM_Impl_Call", "error ok3 addHeaderRequest e:", paramRequest);
      localObject = localRequest;
    }
    return localObject;
  }
  
  public void cancel()
  {
    this.a.cancel();
  }
  
  public Call clone()
  {
    return this.a.clone();
  }
  
  public void enqueue(Callback paramCallback)
  {
    try
    {
      a(this.a.request(), System.currentTimeMillis());
      this.a.enqueue(paramCallback);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_Call", "addHeaderRequest error:" });
      }
    }
  }
  
  public Response execute()
  {
    return this.a.execute();
  }
  
  public boolean isCanceled()
  {
    return this.a.isCanceled();
  }
  
  public boolean isExecuted()
  {
    return this.a.isExecuted();
  }
  
  public Request request()
  {
    return this.a.request();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.c.c
 * JD-Core Version:    0.7.0.1
 */