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
        paramResponse = "";
        if (paramh.k() != null) {
          paramResponse = paramh.k();
        }
        com.tencent.qapmsdk.impl.d.a.a(locala, localTreeMap, paramResponse);
      }
    }
    else {
      return;
    }
    com.tencent.qapmsdk.impl.d.a.a(locala);
  }
  
  public void a(h paramh, IOException paramIOException)
  {
    com.tencent.qapmsdk.impl.a.a.a locala;
    if (b())
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_HttpDataCollect", "okhttp3.0 ->httpError" });
      i.a(paramh, paramIOException);
      if (!paramh.f())
      {
        locala = paramh.j();
        if (locala != null) {
          break label49;
        }
      }
    }
    return;
    label49:
    locala.a(com.tencent.qapmsdk.impl.b.b.d);
    if (paramh.h())
    {
      paramIOException = "";
      if (paramh.k() != null) {
        paramIOException = paramh.k();
      }
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_HttpDataCollect", "okhttp3.0 ->error message:" + paramIOException });
      com.tencent.qapmsdk.impl.d.a.a(locala, paramIOException);
      return;
    }
    com.tencent.qapmsdk.impl.d.a.a(locala);
  }
  
  public void a(Request paramRequest, h paramh)
  {
    Object localObject2;
    Object localObject1;
    if (b())
    {
      localObject2 = paramRequest.url().toString();
      localObject1 = null;
      if ((localObject2 == null) || (!((String)localObject2).contains("?"))) {
        break label131;
      }
      int i = ((String)localObject2).indexOf("?");
      localObject1 = ((String)localObject2).substring(0, i);
      String str = ((String)localObject2).substring(i + 1);
      localObject2 = localObject1;
      localObject1 = str;
    }
    label131:
    for (;;)
    {
      paramh.f((String)localObject2);
      paramh.b((String)localObject1);
      paramh.a((String)localObject1);
      paramh.e(paramRequest.method());
      i.a(paramh, paramRequest.method());
      paramh.c(NetworkWatcher.INSTANCE.activeNetworkCarrier());
      paramh.a(com.tencent.qapmsdk.impl.b.b.d);
      if (localObject2 != null) {
        a(paramh, paramRequest);
      }
      return;
    }
  }
  
  public void a(Response paramResponse, h paramh)
  {
    if (b())
    {
      if (paramResponse == null) {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_HttpDataCollect", "okhttp3.0 ->CallBack.onResponse(response) response is null " });
      }
    }
    else {
      return;
    }
    int i = paramResponse.code();
    ResponseBody localResponseBody = paramResponse.body();
    if (localResponseBody == null) {}
    for (long l = 0L;; l = localResponseBody.contentLength())
    {
      a(paramh, "", (int)l, i);
      a(paramh, paramResponse);
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.c.a
 * JD-Core Version:    0.7.0.1
 */