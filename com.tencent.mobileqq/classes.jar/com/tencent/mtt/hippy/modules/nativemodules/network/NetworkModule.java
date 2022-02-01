package com.tencent.mtt.hippy.modules.nativemodules.network;

import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter;
import com.tencent.mtt.hippy.adapter.http.HippyHttpRequest;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@HippyNativeModule(name="network")
public class NetworkModule
  extends HippyNativeModuleBase
{
  static CookieSyncManager a;
  
  public NetworkModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private void a(HippyHttpRequest paramHippyHttpRequest, HippyMap paramHippyMap)
  {
    if (paramHippyHttpRequest != null)
    {
      if (paramHippyMap == null) {
        return;
      }
      Iterator localIterator = paramHippyMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject1 = paramHippyMap.get(str);
        if ((localObject1 instanceof HippyArray))
        {
          HippyArray localHippyArray = (HippyArray)localObject1;
          ArrayList localArrayList = new ArrayList();
          int i = 0;
          while (i < localHippyArray.size())
          {
            Object localObject2 = localHippyArray.get(i);
            if ((localObject2 instanceof Number))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(localObject2);
              ((StringBuilder)localObject1).append("");
            }
            for (localObject1 = ((StringBuilder)localObject1).toString();; localObject1 = (String)localObject2)
            {
              localArrayList.add(localObject1);
              break label191;
              if ((localObject2 instanceof Boolean))
              {
                localObject1 = new StringBuilder();
                break;
              }
              if (!(localObject2 instanceof String)) {
                break label184;
              }
            }
            label184:
            LogUtils.e("hippy_console", "Unsupported Request Header List Type");
            label191:
            i += 1;
          }
          if (!localArrayList.isEmpty()) {
            paramHippyHttpRequest.addHeader(str, localArrayList);
          }
        }
        else
        {
          LogUtils.e("hippy_console", "Unsupported Request Header Type, Header Field Should All be an Array!!!");
        }
      }
    }
  }
  
  private void a(String paramString, HippyArray paramHippyArray)
  {
    if (paramHippyArray != null)
    {
      b();
      int i = 0;
      while (i < paramHippyArray.size())
      {
        a(paramString, (String)paramHippyArray.get(i));
        i += 1;
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      paramString2 = paramString2.replaceAll("\\s+", "").split(";");
      CookieManager localCookieManager = b();
      int j = paramString2.length;
      int i = 0;
      while (i < j)
      {
        localCookieManager.setCookie(paramString1, paramString2[i]);
        i += 1;
      }
    }
  }
  
  private static CookieManager b()
  {
    if (a == null)
    {
      a = CookieSyncManager.createInstance(ContextHolder.getAppContext());
      CookieManager localCookieManager = CookieManager.getInstance();
      localCookieManager.setAcceptCookie(true);
      localCookieManager.removeSessionCookie();
    }
    return CookieManager.getInstance();
  }
  
  private static boolean b(HippyHttpRequest paramHippyHttpRequest)
  {
    if (paramHippyHttpRequest == null) {
      return false;
    }
    paramHippyHttpRequest = paramHippyHttpRequest.getHeaders();
    if (paramHippyHttpRequest != null)
    {
      String str;
      do
      {
        paramHippyHttpRequest = paramHippyHttpRequest.entrySet().iterator();
        Object localObject;
        while (!((Iterator)localObject).hasNext())
        {
          do
          {
            do
            {
              if (!paramHippyHttpRequest.hasNext()) {
                break;
              }
              localObject = (Map.Entry)paramHippyHttpRequest.next();
              str = (String)((Map.Entry)localObject).getKey();
            } while ((str == null) || (!str.equalsIgnoreCase("Accept-Encoding")));
            localObject = ((Map.Entry)localObject).getValue();
          } while (!(localObject instanceof ArrayList));
          localObject = ((ArrayList)localObject).iterator();
        }
        str = (String)((Iterator)localObject).next();
      } while ((!str.equalsIgnoreCase("gzip")) && (!str.equalsIgnoreCase("deflate")));
      return true;
    }
    return false;
  }
  
  @HippyMethod(name="fetch")
  public void fetch(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap == null) {}
    for (paramHippyMap = "invalid request param";; paramHippyMap = "no valid url for request")
    {
      paramPromise.reject(paramHippyMap);
      return;
      Object localObject1 = paramHippyMap.getString("url");
      Object localObject2 = paramHippyMap.getString("method");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        HippyHttpRequest localHippyHttpRequest = new HippyHttpRequest();
        localHippyHttpRequest.setConnectTimeout(10000);
        localHippyHttpRequest.setReadTimeout(10000);
        String str = paramHippyMap.getString("redirect");
        boolean bool;
        if ((!TextUtils.isEmpty(str)) && (TextUtils.equals("follow", str))) {
          bool = true;
        } else {
          bool = false;
        }
        localHippyHttpRequest.setInstanceFollowRedirects(bool);
        localHippyHttpRequest.setUseCaches(false);
        localHippyHttpRequest.setMethod((String)localObject2);
        localHippyHttpRequest.setUrl((String)localObject1);
        localObject2 = paramHippyMap.getMap("headers");
        if (localObject2 != null)
        {
          a((String)localObject1, ((HippyMap)localObject2).getArray("Cookie"));
          a(localHippyHttpRequest, (HippyMap)localObject2);
        }
        localHippyHttpRequest.setBody(paramHippyMap.getString("body"));
        paramHippyMap = b().getCookie((String)localObject1);
        if (!TextUtils.isEmpty(paramHippyMap)) {
          localHippyHttpRequest.addHeader("Cookie", paramHippyMap);
        }
        localObject1 = this.mContext.getGlobalConfigs();
        paramHippyMap = null;
        if (localObject1 != null) {
          paramHippyMap = ((HippyGlobalConfigs)localObject1).getHttpAdapter();
        }
        if (paramHippyMap != null) {
          paramHippyMap.sendRequest(localHippyHttpRequest, new NetworkModule.a(paramPromise));
        }
        return;
      }
    }
  }
  
  @HippyMethod(name="getCookie")
  public void getCookie(String paramString, Promise paramPromise)
  {
    paramPromise.resolve(b().getCookie(paramString));
  }
  
  @HippyMethod(name="setCookie")
  public void setCookie(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!TextUtils.isEmpty(paramString3))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append(";expires=");
        localStringBuilder.append(paramString3);
        paramString2 = localStringBuilder.toString();
        b().setCookie(paramString1, paramString2);
      }
      else
      {
        a(paramString1, paramString2);
      }
      a.sync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.network.NetworkModule
 * JD-Core Version:    0.7.0.1
 */