package com.tencent.mtt.hippy.modules.nativemodules.network;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.b.a;
import com.tencent.mtt.hippy.b.d;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@HippyNativeModule(name="websocket")
public class WebSocketModule
  extends HippyNativeModuleBase
{
  private static AtomicInteger a = new AtomicInteger(0);
  private SparseArray<d> b = new SparseArray();
  
  public WebSocketModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private List<a> a(HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {
      return null;
    }
    Object localObject1 = paramHippyMap.keySet();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Set)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (String)localIterator.next();
      Object localObject2 = paramHippyMap.get((String)localObject1);
      StringBuilder localStringBuilder;
      if ((localObject2 instanceof Number))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localObject2);
        localStringBuilder.append("");
        localObject1 = new a((String)localObject1, localStringBuilder.toString());
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        break;
        if ((localObject2 instanceof Boolean))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localObject2);
          localStringBuilder.append("");
          localObject1 = new a((String)localObject1, localStringBuilder.toString());
        }
        else
        {
          if (!(localObject2 instanceof String)) {
            break label213;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localObject2);
          localStringBuilder.append("");
          localObject1 = new a((String)localObject1, localStringBuilder.toString());
        }
      }
      label213:
      LogUtils.e("WebSocketModule", "Unsupported Request Header List Type");
    }
    return localArrayList;
  }
  
  protected void a(int paramInt)
  {
    this.b.remove(paramInt);
  }
  
  @HippyMethod(name="close")
  public void close(HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {
      paramHippyMap = "close: ERROR: request is null";
    }
    for (;;)
    {
      LogUtils.d("WebSocketModule", paramHippyMap);
      return;
      if (!paramHippyMap.containsKey("id"))
      {
        paramHippyMap = "close: ERROR: no socket id specified";
      }
      else
      {
        int i = paramHippyMap.getInt("id");
        d locald = (d)this.b.get(i, null);
        if ((locald != null) && (locald.c()))
        {
          i = 0;
          if (paramHippyMap.containsKey("code")) {
            i = paramHippyMap.getInt("code");
          }
          if (paramHippyMap.containsKey("reason")) {
            paramHippyMap = paramHippyMap.getString("reason");
          } else {
            paramHippyMap = "";
          }
          Object localObject = paramHippyMap;
          if (paramHippyMap == null) {
            localObject = "";
          }
          locald.a(i, (String)localObject);
          return;
        }
        paramHippyMap = "send: ERROR: specified socket not found, or not connected yet";
      }
    }
  }
  
  @HippyMethod(name="connect")
  public void connect(HippyMap paramHippyMap, Promise paramPromise)
  {
    HippyMap localHippyMap = new HippyMap();
    if (paramHippyMap == null)
    {
      localHippyMap.pushInt("code", -1);
      paramHippyMap = "invalid connect param";
      localHippyMap.pushString("reason", paramHippyMap);
    }
    for (;;)
    {
      paramPromise.resolve(localHippyMap);
      return;
      String str = paramHippyMap.getString("url");
      if (TextUtils.isEmpty(str))
      {
        localHippyMap.pushInt("code", -1);
        paramHippyMap = "no valid url for websocket";
        break;
      }
      paramHippyMap = paramHippyMap.getMap("headers");
      int i = a.addAndGet(1);
      paramHippyMap = new d(URI.create(str), new WebSocketModule.a(i, this.mContext, this), a(paramHippyMap));
      this.b.put(i, paramHippyMap);
      paramHippyMap.a();
      localHippyMap.pushInt("code", 0);
      localHippyMap.pushString("reason", "");
      localHippyMap.pushInt("id", i);
    }
  }
  
  public void destroy()
  {
    int j = this.b.size();
    if (j == 0) {
      return;
    }
    int i = 0;
    while (i < j)
    {
      int k = this.b.keyAt(i);
      d locald = (d)this.b.get(k);
      if ((locald != null) && (locald.c())) {
        locald.b();
      }
      i += 1;
    }
    this.b.clear();
  }
  
  @HippyMethod(name="send")
  public void send(HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {
      paramHippyMap = "send: ERROR: request is null";
    }
    for (;;)
    {
      LogUtils.d("WebSocketModule", paramHippyMap);
      return;
      if (!paramHippyMap.containsKey("id"))
      {
        paramHippyMap = "send: ERROR: no socket id specified";
      }
      else
      {
        int i = paramHippyMap.getInt("id");
        Object localObject = (d)this.b.get(i, null);
        if ((localObject != null) && (((d)localObject).c()))
        {
          paramHippyMap = paramHippyMap.getString("data");
          if (paramHippyMap == null)
          {
            paramHippyMap = "send: ERROR: no data specified to be sent";
            continue;
          }
          try
          {
            ((d)localObject).a(paramHippyMap);
            return;
          }
          catch (Throwable paramHippyMap)
          {
            paramHippyMap.printStackTrace();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("send: ERROR: error occured in sending [");
            ((StringBuilder)localObject).append(paramHippyMap.getMessage());
            ((StringBuilder)localObject).append("]");
            LogUtils.d("WebSocketModule", ((StringBuilder)localObject).toString());
            return;
          }
        }
        paramHippyMap = "send: ERROR: specified socket not found, or not connected yet";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.network.WebSocketModule
 * JD-Core Version:    0.7.0.1
 */