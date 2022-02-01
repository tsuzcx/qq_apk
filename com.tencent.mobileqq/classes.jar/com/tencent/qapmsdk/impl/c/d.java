package com.tencent.qapmsdk.impl.c;

import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.instrumentation.h;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class d
  implements Interceptor
{
  private final b a = new a();
  private final AtomicInteger b = new AtomicInteger(0);
  
  public d()
  {
    Logger.INSTANCE.d(new String[] { "QAM_Impl_QAPMHTTPInterceptor", "OkHttpInstrumentation3 - wrapping Instructor" });
  }
  
  /* Error */
  private int a(Request paramRequest, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 48
    //   3: invokevirtual 54	okhttp3/Request:header	(Ljava/lang/String;)Ljava/lang/String;
    //   6: invokestatic 60	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   9: lstore 5
    //   11: lload_2
    //   12: lload 5
    //   14: lsub
    //   15: l2i
    //   16: istore 4
    //   18: aload_1
    //   19: invokevirtual 64	okhttp3/Request:newBuilder	()Lokhttp3/Request$Builder;
    //   22: ldc 48
    //   24: invokevirtual 70	okhttp3/Request$Builder:removeHeader	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   27: pop
    //   28: iload 4
    //   30: ireturn
    //   31: astore_1
    //   32: goto +7 -> 39
    //   35: astore_1
    //   36: iconst_0
    //   37: istore 4
    //   39: getstatic 32	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   42: iconst_3
    //   43: anewarray 34	java/lang/String
    //   46: dup
    //   47: iconst_0
    //   48: ldc 36
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: ldc 72
    //   55: aastore
    //   56: dup
    //   57: iconst_2
    //   58: aload_1
    //   59: invokevirtual 76	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   62: aastore
    //   63: invokevirtual 79	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   66: iload 4
    //   68: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	d
    //   0	69	1	paramRequest	Request
    //   0	69	2	paramLong	long
    //   16	51	4	i	int
    //   9	4	5	l	long
    // Exception table:
    //   from	to	target	type
    //   18	28	31	java/lang/Exception
    //   0	11	35	java/lang/Exception
  }
  
  private Request a(Request paramRequest)
  {
    try
    {
      if (!TextUtils.isEmpty(paramRequest.header("X-QAPM-Qt")))
      {
        Request localRequest = paramRequest.newBuilder().removeHeader("X-QAPM-Qt").build();
        return localRequest;
      }
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAM_Impl_QAPMHTTPInterceptor", "dropQtHeader error:", localException.getMessage() });
    }
    return paramRequest;
  }
  
  private Request a(Request paramRequest, h paramh)
  {
    try
    {
      Request.Builder localBuilder = paramRequest.newBuilder();
      h localh = paramh;
      if (paramh == null) {
        localh = new h();
      }
      localh.a(a(paramRequest, localh.c()));
      paramh = localBuilder.build();
      return paramh;
    }
    catch (Exception paramh)
    {
      Logger.INSTANCE.e(new String[] { "QAM_Impl_QAPMHTTPInterceptor", "QAPMOkHttp3Interceptor_  setCrossProcessHeader---> has an error : ", paramh.toString() });
    }
    return paramRequest;
  }
  
  public Response intercept(Interceptor.Chain paramChain)
  {
    Request localRequest = paramChain.request();
    h localh;
    if ((localRequest != null) && (com.tencent.qapmsdk.impl.g.b.c()))
    {
      localh = new h();
      Object localObject3 = localRequest;
      try
      {
        localh.b(0);
        localObject3 = localRequest;
        localh.a(com.tencent.qapmsdk.impl.b.b.d);
        localObject3 = localRequest;
        boolean bool = this.a.a();
        Object localObject1;
        if (!bool)
        {
          localObject1 = localRequest;
          if (localRequest == null) {}
        }
        else
        {
          localObject1 = localRequest;
          try
          {
            localObject3 = a(localRequest, localh);
            localObject1 = localObject3;
            localObject3 = a((Request)localObject3);
            localObject1 = localObject3;
            this.a.a((Request)localObject3, localh);
            localObject1 = localObject3;
          }
          catch (Exception localException5)
          {
            localObject3 = localObject1;
            Logger.INSTANCE.exception("QAM_Impl_QAPMHTTPInterceptor", "okhttp3.0 -> setCrossProcessHeader occur an error", localException5);
          }
        }
        try
        {
          Object localObject2;
          paramChain = paramChain.proceed(localObject2);
          try
          {
            localh.g(com.tencent.qapmsdk.impl.g.a.a(paramChain.header("Content-Type")));
          }
          catch (Exception localException2)
          {
            Logger.INSTANCE.exception("QAM_Impl_QAPMHTTPInterceptor", "QAPMOkHttp3Interceptor_. getContentType occur an error", localException2);
          }
          if ((this.a.a()) || (paramChain != null)) {
            try
            {
              this.a.a(paramChain, localh);
              return paramChain;
            }
            catch (Exception localException3)
            {
              Logger.INSTANCE.e(new String[] { "QAM_Impl_QAPMHTTPInterceptor", "QAPMOkHttp3Interceptor_  intercept()---> responseFinished  has an error : ", localException3.toString() });
            }
          }
          return paramChain;
        }
        catch (IOException paramChain)
        {
          if (this.a.a()) {
            try
            {
              this.a.a(localh, paramChain);
            }
            catch (Exception localException4)
            {
              Logger.INSTANCE.e(new String[] { "QAM_Impl_QAPMHTTPInterceptor", "QAPMOkHttp3Interceptor_  intercept() --->httpError has an error : ", localException4.toString() });
            }
          }
          throw paramChain;
        }
      }
      catch (Exception localException1)
      {
        Logger.INSTANCE.exception("QAM_Impl_QAPMHTTPInterceptor", "okhttp3 intercept error", localException1);
        localObject2 = localObject3;
      }
    }
    if (localException5 != null) {
      return paramChain.proceed(localException5);
    }
    throw new IOException("request is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.c.d
 * JD-Core Version:    0.7.0.1
 */