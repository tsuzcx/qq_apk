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
    Object localObject = paramRequest.urlString();
    String str1;
    if ((localObject != null) && (((String)localObject).contains("?")))
    {
      int i = ((String)localObject).indexOf("?");
      String str2 = ((String)localObject).substring(0, i);
      str1 = ((String)localObject).substring(i + 1);
      localObject = str2;
    }
    else
    {
      str1 = null;
    }
    paramh.f((String)localObject);
    paramh.b(str1);
    paramh.a(str1);
    paramh.e(paramRequest.method());
    i.a(paramh, paramRequest.method());
    paramh.c(NetworkWatcher.INSTANCE.activeNetworkCarrier());
    paramh.a(b.d);
    if (localObject != null) {
      b(paramh, paramRequest);
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
    }
    catch (Exception localException)
    {
      label16:
      com.tencent.qapmsdk.impl.a.a.a locala;
      TreeMap localTreeMap;
      Iterator localIterator;
      break label16;
    }
    Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMOkHttp2TransactionStateUtil", "QAPMOkHttp2TransactionStateUtil content-type has an error " });
    locala = paramh.j();
    if (locala != null)
    {
      if (paramh.g() >= 400L)
      {
        localTreeMap = new TreeMap();
        paramResponse = paramResponse.headers();
        if ((paramResponse != null) && (paramResponse.size() > 0))
        {
          localIterator = paramResponse.names().iterator();
          while (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            String str2 = paramResponse.get(str1);
            if ((!str1.startsWith("X-QAPM-Qt")) && (str2 != null)) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.d
 * JD-Core Version:    0.7.0.1
 */