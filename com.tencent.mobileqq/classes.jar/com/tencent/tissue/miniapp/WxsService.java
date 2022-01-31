package com.tencent.tissue.miniapp;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tissue.v8rt.engine.Engine;
import com.tencent.tissue.v8rt.engine.Logger;
import com.tencent.tissue.v8rt.engine.V8JsContext;
import com.tencent.tissue.v8rt.engine.V8JsRuntime;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class WxsService
  implements IJsService
{
  public static final String LOG_TAG = "WxsService";
  private Engine engine;
  private ConcurrentHashMap<String, V8JsRuntime> wxsJsRuntimeMap = new ConcurrentHashMap();
  
  public Object executeScriptWithReturn(String paramString1, String paramString2)
  {
    V8JsRuntime localV8JsRuntime = (V8JsRuntime)this.wxsJsRuntimeMap.get(paramString1);
    if ((localV8JsRuntime != null) && (!TextUtils.isEmpty(paramString2))) {
      return localV8JsRuntime.getDefaultContext().evaluateJsWithReturnSync(paramString2);
    }
    Logger.e("WxsService", "can execute wxs script jsruntime is null origin " + paramString1);
    return null;
  }
  
  public long executeScriptWithReturnPtr(String paramString1, String paramString2)
  {
    V8JsRuntime localV8JsRuntime = (V8JsRuntime)this.wxsJsRuntimeMap.get(paramString1);
    if ((localV8JsRuntime != null) && (!TextUtils.isEmpty(paramString2))) {
      return localV8JsRuntime.getDefaultContext().evaluateJsWithReturnPtrSync(paramString2);
    }
    Logger.e("WxsService", "can execute wxs script jsruntime is null origin " + paramString1);
    return 0L;
  }
  
  public V8JsRuntime getRuntime(String paramString)
  {
    V8JsRuntime localV8JsRuntime = (V8JsRuntime)this.wxsJsRuntimeMap.get(paramString);
    if (localV8JsRuntime == null) {
      Logger.w("WxsService", "can execute wxs script jsruntime is null origin " + paramString);
    }
    return localV8JsRuntime;
  }
  
  public int getStatus()
  {
    return this.engine.getStatus();
  }
  
  public boolean init(Context paramContext)
  {
    Logger.i("WxsService", "init");
    this.engine = Engine.getInstance().initEngine(paramContext);
    if (this.engine.getStatus() == 0)
    {
      Logger.i("TV8ENG", "WxsService init V8Engine success");
      return true;
    }
    Logger.e("TV8ENG", "WxsService init V8Engine failed, engine status:" + this.engine.getStatus());
    return false;
  }
  
  public void loadScript(String paramString1, String paramString2)
  {
    V8JsRuntime localV8JsRuntime = (V8JsRuntime)this.wxsJsRuntimeMap.get(paramString1);
    if (localV8JsRuntime == null)
    {
      if (this.engine.getStatus() == 0)
      {
        localV8JsRuntime = this.engine.createJsRuntime();
        this.wxsJsRuntimeMap.put(paramString1, localV8JsRuntime);
        if (!TextUtils.isEmpty(paramString2)) {
          localV8JsRuntime.getDefaultContext().evaluateJsSync(paramString2);
        }
        return;
      }
      Logger.e("WxsService", "loadWxsScript not supported origin " + paramString1);
      return;
    }
    localV8JsRuntime.getDefaultContext().evaluateJsSync(paramString2);
  }
  
  public void release()
  {
    Iterator localIterator = this.wxsJsRuntimeMap.values().iterator();
    while (localIterator.hasNext()) {
      ((V8JsRuntime)localIterator.next()).release();
    }
    this.wxsJsRuntimeMap.clear();
  }
  
  public void release(String paramString)
  {
    V8JsRuntime localV8JsRuntime = (V8JsRuntime)this.wxsJsRuntimeMap.get(paramString);
    if (localV8JsRuntime != null)
    {
      localV8JsRuntime.release();
      this.wxsJsRuntimeMap.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.miniapp.WxsService
 * JD-Core Version:    0.7.0.1
 */