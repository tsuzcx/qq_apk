package com.tencent.mtt.hippy.modules.nativemodules.network;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter.HttpTaskCallback;
import com.tencent.mtt.hippy.adapter.http.HippyHttpRequest;
import com.tencent.mtt.hippy.adapter.http.HippyHttpResponse;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

class NetworkModule$a
  implements HippyHttpAdapter.HttpTaskCallback
{
  private Promise a;
  
  public NetworkModule$a(Promise paramPromise)
  {
    this.a = paramPromise;
  }
  
  public void onTaskFailed(HippyHttpRequest paramHippyHttpRequest, Throwable paramThrowable)
  {
    if (paramThrowable != null) {
      this.a.resolve(paramThrowable.getMessage());
    }
  }
  
  public void onTaskSuccess(HippyHttpRequest paramHippyHttpRequest, HippyHttpResponse paramHippyHttpResponse)
  {
    Object localObject1;
    if (paramHippyHttpResponse.getInputStream() != null)
    {
      localObject2 = paramHippyHttpResponse.getInputStream();
      localObject1 = localObject2;
      if (NetworkModule.a(paramHippyHttpRequest)) {
        localObject1 = new GZIPInputStream((InputStream)localObject2);
      }
      localObject2 = new StringBuilder();
      localObject1 = new BufferedReader(new InputStreamReader((InputStream)localObject1, "UTF-8"));
      for (;;)
      {
        localObject3 = ((BufferedReader)localObject1).readLine();
        if (localObject3 == null) {
          break;
        }
        ((StringBuilder)localObject2).append((String)localObject3);
        ((StringBuilder)localObject2).append("\r\n");
      }
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = new HippyMap();
    ((HippyMap)localObject2).pushInt("statusCode", paramHippyHttpResponse.getStatusCode().intValue());
    ((HippyMap)localObject2).pushString("statusLine", paramHippyHttpResponse.getResponseMessage());
    Object localObject3 = new HippyMap();
    if ((paramHippyHttpResponse.getRspHeaderMaps() != null) && (!paramHippyHttpResponse.getRspHeaderMaps().isEmpty()))
    {
      Iterator localIterator = paramHippyHttpResponse.getRspHeaderMaps().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        List localList = (List)paramHippyHttpResponse.getRspHeaderMaps().get(str1);
        HippyArray localHippyArray = new HippyArray();
        if ((localList != null) && (!localList.isEmpty()))
        {
          int i = 0;
          int j = 0;
          while (i < localList.size())
          {
            String str2 = (String)localList.get(i);
            localHippyArray.pushString(str2);
            if ("Set-Cookie".equalsIgnoreCase(str1))
            {
              NetworkModule.a().setCookie(paramHippyHttpRequest.getUrl(), str2);
              j = 1;
            }
            i += 1;
          }
          if (j != 0) {
            NetworkModule.a.sync();
          }
        }
        ((HippyMap)localObject3).pushArray(str1, localHippyArray);
      }
    }
    ((HippyMap)localObject2).pushMap("respHeaders", (HippyMap)localObject3);
    paramHippyHttpRequest = (HippyHttpRequest)localObject1;
    if (localObject1 == null) {
      paramHippyHttpRequest = "";
    }
    ((HippyMap)localObject2).pushString("respBody", paramHippyHttpRequest);
    this.a.resolve(localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.network.NetworkModule.a
 * JD-Core Version:    0.7.0.1
 */