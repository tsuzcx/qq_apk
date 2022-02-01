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
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = paramHippyMap.get(str);
      if ((localObject2 instanceof Number)) {
        localArrayList.add(new a(str, localObject2 + ""));
      } else if ((localObject2 instanceof Boolean)) {
        localArrayList.add(new a(str, localObject2 + ""));
      } else if ((localObject2 instanceof String)) {
        localArrayList.add(new a(str, localObject2 + ""));
      } else {
        LogUtils.e("WebSocketModule", "Unsupported Request Header List Type");
      }
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
    if (paramHippyMap == null)
    {
      LogUtils.d("WebSocketModule", "close: ERROR: request is null");
      return;
    }
    if (!paramHippyMap.containsKey("id"))
    {
      LogUtils.d("WebSocketModule", "close: ERROR: no socket id specified");
      return;
    }
    int i = paramHippyMap.getInt("id");
    d locald = (d)this.b.get(i, null);
    if ((locald == null) || (!locald.c()))
    {
      LogUtils.d("WebSocketModule", "send: ERROR: specified socket not found, or not connected yet");
      return;
    }
    i = 0;
    String str = "";
    if (paramHippyMap.containsKey("code")) {
      i = paramHippyMap.getInt("code");
    }
    if (paramHippyMap.containsKey("reason")) {
      str = paramHippyMap.getString("reason");
    }
    paramHippyMap = str;
    if (str == null) {
      paramHippyMap = "";
    }
    locald.a(i, paramHippyMap);
  }
  
  @HippyMethod(name="connect")
  public void connect(HippyMap paramHippyMap, Promise paramPromise)
  {
    HippyMap localHippyMap = new HippyMap();
    if (paramHippyMap == null)
    {
      localHippyMap.pushInt("code", -1);
      localHippyMap.pushString("reason", "invalid connect param");
      paramPromise.resolve(localHippyMap);
      return;
    }
    String str = paramHippyMap.getString("url");
    if (TextUtils.isEmpty(str))
    {
      localHippyMap.pushInt("code", -1);
      localHippyMap.pushString("reason", "no valid url for websocket");
      paramPromise.resolve(localHippyMap);
      return;
    }
    paramHippyMap = paramHippyMap.getMap("headers");
    int i = a.addAndGet(1);
    paramHippyMap = new d(URI.create(str), new WebSocketModule.a(i, this.mContext, this), a(paramHippyMap));
    this.b.put(i, paramHippyMap);
    paramHippyMap.a();
    localHippyMap.pushInt("code", 0);
    localHippyMap.pushString("reason", "");
    localHippyMap.pushInt("id", i);
    paramPromise.resolve(localHippyMap);
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
    if (paramHippyMap == null)
    {
      LogUtils.d("WebSocketModule", "send: ERROR: request is null");
      return;
    }
    if (!paramHippyMap.containsKey("id"))
    {
      LogUtils.d("WebSocketModule", "send: ERROR: no socket id specified");
      return;
    }
    int i = paramHippyMap.getInt("id");
    d locald = (d)this.b.get(i, null);
    if ((locald == null) || (!locald.c()))
    {
      LogUtils.d("WebSocketModule", "send: ERROR: specified socket not found, or not connected yet");
      return;
    }
    paramHippyMap = paramHippyMap.getString("data");
    if (paramHippyMap == null)
    {
      LogUtils.d("WebSocketModule", "send: ERROR: no data specified to be sent");
      return;
    }
    try
    {
      locald.a(paramHippyMap);
      return;
    }
    catch (Throwable paramHippyMap)
    {
      paramHippyMap.printStackTrace();
      LogUtils.d("WebSocketModule", "send: ERROR: error occured in sending [" + paramHippyMap.getMessage() + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.network.WebSocketModule
 * JD-Core Version:    0.7.0.1
 */