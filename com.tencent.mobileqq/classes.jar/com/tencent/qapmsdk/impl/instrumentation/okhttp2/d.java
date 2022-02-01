package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.impl.b.b;
import com.tencent.qapmsdk.impl.instrumentation.g;
import com.tencent.qapmsdk.impl.instrumentation.h;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class d
  extends h
{
  public static void a(g paramg, Request paramRequest)
  {
    Object localObject2 = paramRequest.urlString();
    Object localObject1 = null;
    if ((localObject2 != null) && (((String)localObject2).contains("?")))
    {
      int i = ((String)localObject2).indexOf("?");
      localObject1 = ((String)localObject2).substring(0, i);
      String str = ((String)localObject2).substring(i + 1);
      localObject2 = localObject1;
      localObject1 = str;
    }
    for (;;)
    {
      paramg.f((String)localObject2);
      paramg.b((String)localObject1);
      paramg.a((String)localObject1);
      paramg.e(paramRequest.method());
      h.a(paramg, paramRequest.method());
      paramg.c(NetworkWatcher.INSTANCE.activeNetworkCarrier());
      paramg.a(b.d);
      if (localObject2 != null) {
        b(paramg, paramRequest);
      }
      return;
    }
  }
  
  public static void a(g paramg, Response paramResponse)
  {
    if (paramResponse == null)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMOkHttp2TransactionStateUtil", "okhttp2.0 ->CallBack.onResponse(response) response is null " });
      return;
    }
    String str = paramResponse.header("X-QAPM-Tx-Data");
    int i = paramResponse.code();
    try
    {
      a(paramg, str, (int)paramResponse.body().contentLength(), i);
      b(paramg, paramResponse);
      return;
    }
    catch (Exception paramg) {}
  }
  
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
  
  private static void b(g paramg, Request paramRequest)
  {
    h.b(paramg, paramg.b());
    paramRequest = new d.1(paramRequest);
    h.a(paramg.d(), paramRequest, paramg);
  }
  
  private static void b(g paramg, Response paramResponse)
  {
    try
    {
      paramg.g(com.tencent.qapmsdk.impl.g.a.a(paramResponse.header("Content-Type")));
      com.tencent.qapmsdk.impl.a.a.a locala = paramg.j();
      if (locala != null)
      {
        if (paramg.g() < 400L) {
          break label172;
        }
        localTreeMap = new TreeMap();
        paramResponse = paramResponse.headers();
        if ((paramResponse != null) && (paramResponse.size() > 0))
        {
          Iterator localIterator = paramResponse.names().iterator();
          while (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            String str2 = paramResponse.get(str1);
            if ((!str1.startsWith("X-QAPM-Qt")) && (str2 != null)) {
              localTreeMap.put(str1, str2);
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      TreeMap localTreeMap;
      for (;;)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMOkHttp2TransactionStateUtil", "QAPMOkHttp2TransactionStateUtil content-type has an error " });
      }
      paramResponse = "";
      if (paramg.k() != null) {
        paramResponse = paramg.k();
      }
      com.tencent.qapmsdk.impl.d.a.a(localException, localTreeMap, paramResponse);
    }
    return;
    label172:
    com.tencent.qapmsdk.impl.d.a.a(localException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.d
 * JD-Core Version:    0.7.0.1
 */