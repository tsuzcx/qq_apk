package com.tencent.qapmsdk.impl.c;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.impl.instrumentation.h;
import com.tencent.qapmsdk.impl.instrumentation.i;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class a
  implements b
{
  private volatile boolean a = true;
  
  public static void a(h paramh, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString != null) && (!"".equals(paramString))) {
      paramh.d(paramString);
    }
    paramh.c(paramInt2);
    if (paramInt1 >= 0)
    {
      paramh.d(paramInt1);
      return;
    }
    paramh.d(0L);
  }
  
  private static void a(h paramh, Request paramRequest)
  {
    i.b(paramh, paramh.b());
    paramRequest = new a.1(paramRequest);
    i.a(paramh.d(), paramRequest, paramh);
  }
  
  private static void a(h paramh, Response paramResponse)
  {
    com.tencent.qapmsdk.impl.a.a.a locala = paramh.j();
    if (locala != null)
    {
      if (paramh.g() >= 400L)
      {
        TreeMap localTreeMap = new TreeMap();
        paramResponse = paramResponse.headers();
        if ((paramResponse != null) && (paramResponse.size() > 0))
        {
          Iterator localIterator = paramResponse.names().iterator();
          while (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            String str2 = paramResponse.get(str1);
            if (str2 != null) {
              localTreeMap.put(str1, str2);
            }
          }
        }
        if (paramh.k() != null) {
          paramh = paramh.k();
        } else {
          paramh = "";
        }
        com.tencent.qapmsdk.impl.d.a.a(locala, localTreeMap, paramh);
        return;
      }
      com.tencent.qapmsdk.impl.d.a.a(locala);
    }
  }
  
  public void a(h paramh, IOException paramIOException)
  {
    if (b())
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_HttpDataCollect", "okhttp3.0 ->httpError" });
      i.a(paramh, paramIOException);
      if (!paramh.f())
      {
        paramIOException = paramh.j();
        if (paramIOException == null) {
          return;
        }
        paramIOException.a(com.tencent.qapmsdk.impl.b.b.d);
        if (paramh.h())
        {
          if (paramh.k() != null) {
            paramh = paramh.k();
          } else {
            paramh = "";
          }
          Logger localLogger = Logger.INSTANCE;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("okhttp3.0 ->error message:");
          localStringBuilder.append(paramh);
          localLogger.d(new String[] { "QAPM_Impl_HttpDataCollect", localStringBuilder.toString() });
          com.tencent.qapmsdk.impl.d.a.a(paramIOException, paramh);
          return;
        }
        com.tencent.qapmsdk.impl.d.a.a(paramIOException);
      }
    }
  }
  
  public void a(Request paramRequest, h paramh)
  {
    if (b())
    {
      String str2 = paramRequest.url().toString();
      Object localObject2 = null;
      String str1 = str2;
      Object localObject1 = localObject2;
      if (str2 != null)
      {
        str1 = str2;
        localObject1 = localObject2;
        if (str2.contains("?"))
        {
          int i = str2.indexOf("?");
          str1 = str2.substring(0, i);
          localObject1 = str2.substring(i + 1);
        }
      }
      paramh.f(str1);
      paramh.b((String)localObject1);
      paramh.a((String)localObject1);
      paramh.e(paramRequest.method());
      i.a(paramh, paramRequest.method());
      paramh.c(NetworkWatcher.INSTANCE.activeNetworkCarrier());
      paramh.a(com.tencent.qapmsdk.impl.b.b.d);
      if (str1 != null) {
        a(paramh, paramRequest);
      }
    }
  }
  
  public void a(Response paramResponse, h paramh)
  {
    if (b())
    {
      if (paramResponse == null)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_HttpDataCollect", "okhttp3.0 ->CallBack.onResponse(response) response is null " });
        return;
      }
      int i = paramResponse.code();
      ResponseBody localResponseBody = paramResponse.body();
      long l;
      if (localResponseBody == null) {
        l = 0L;
      } else {
        l = localResponseBody.contentLength();
      }
      a(paramh, "", (int)l, i);
      a(paramh, paramResponse);
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return com.tencent.qapmsdk.impl.g.b.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.c.a
 * JD-Core Version:    0.7.0.1
 */