package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.impl.b.b;
import com.tencent.qapmsdk.impl.instrumentation.h;
import com.tencent.qapmsdk.impl.instrumentation.i;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class d
  extends i
{
  public static void a(h paramh, Request paramRequest)
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
      paramh.f((String)localObject2);
      paramh.b((String)localObject1);
      paramh.a((String)localObject1);
      paramh.e(paramRequest.method());
      i.a(paramh, paramRequest.method());
      paramh.c(NetworkWatcher.INSTANCE.activeNetworkCarrier());
      paramh.a(b.d);
      if (localObject2 != null) {
        b(paramh, paramRequest);
      }
      return;
    }
  }
  
  public static void a(h paramh, Response paramResponse)
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
      a(paramh, str, (int)paramResponse.body().contentLength(), i);
      b(paramh, paramResponse);
      return;
    }
    catch (Exception paramh) {}
  }
  
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
  
  private static void b(h paramh, Request paramRequest)
  {
    i.b(paramh, paramh.b());
    paramRequest = new d.1(paramRequest);
    i.a(paramh.d(), paramRequest, paramh);
  }
  
  private static void b(h paramh, Response paramResponse)
  {
    try
    {
      paramh.g(com.tencent.qapmsdk.impl.g.a.a(paramResponse.header("Content-Type")));
      com.tencent.qapmsdk.impl.a.a.a locala = paramh.j();
      if (locala != null)
      {
        if (paramh.g() < 400L) {
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
      if (paramh.k() != null) {
        paramResponse = paramh.k();
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