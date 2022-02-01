package com.tencent.qapmsdk.impl.c;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.impl.instrumentation.g;
import com.tencent.qapmsdk.impl.instrumentation.h;
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
  
  public static void a(g paramg, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString != null) && (!"".equals(paramString))) {
      paramg.d(paramString);
    }
    paramg.c(paramInt2);
    if (paramInt1 >= 0)
    {
      paramg.d(paramInt1);
      return;
    }
    paramg.d(0L);
  }
  
  private static void a(g paramg, Request paramRequest)
  {
    h.b(paramg, paramg.b());
    paramRequest = new a.1(paramRequest);
    h.a(paramg.d(), paramRequest, paramg);
  }
  
  private static void a(g paramg, Response paramResponse)
  {
    com.tencent.qapmsdk.impl.a.a.a locala = paramg.j();
    if (locala != null)
    {
      if (paramg.g() >= 400L)
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
        if (paramg.k() != null) {
          paramResponse = paramg.k();
        }
        com.tencent.qapmsdk.impl.d.a.a(locala, localTreeMap, paramResponse);
      }
    }
    else {
      return;
    }
    com.tencent.qapmsdk.impl.d.a.a(locala);
  }
  
  public void a(g paramg, IOException paramIOException)
  {
    com.tencent.qapmsdk.impl.a.a.a locala;
    if (b())
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_HttpDataCollect", "okhttp3.0 ->httpError" });
      h.a(paramg, paramIOException);
      if (!paramg.f())
      {
        locala = paramg.j();
        if (locala != null) {
          break label49;
        }
      }
    }
    return;
    label49:
    locala.a(com.tencent.qapmsdk.impl.b.b.d);
    if (paramg.h())
    {
      paramIOException = "";
      if (paramg.k() != null) {
        paramIOException = paramg.k();
      }
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_HttpDataCollect", "okhttp3.0 ->error message:" + paramIOException });
      com.tencent.qapmsdk.impl.d.a.a(locala, paramIOException);
      return;
    }
    com.tencent.qapmsdk.impl.d.a.a(locala);
  }
  
  public void a(Request paramRequest, g paramg)
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
      paramg.f((String)localObject2);
      paramg.b((String)localObject1);
      paramg.a((String)localObject1);
      paramg.e(paramRequest.method());
      h.a(paramg, paramRequest.method());
      paramg.c(NetworkWatcher.INSTANCE.activeNetworkCarrier());
      paramg.a(com.tencent.qapmsdk.impl.b.b.d);
      if (localObject2 != null) {
        a(paramg, paramRequest);
      }
      return;
    }
  }
  
  public void a(Response paramResponse, g paramg)
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
      a(paramg, "", (int)l, i);
      a(paramg, paramResponse);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.c.a
 * JD-Core Version:    0.7.0.1
 */