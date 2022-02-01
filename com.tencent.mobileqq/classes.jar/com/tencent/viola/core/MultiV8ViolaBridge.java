package com.tencent.viola.core;

import com.tencent.viola.adapter.IMultiV8ViolaRuntimeAdapter;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.JSParam;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class MultiV8ViolaBridge
{
  public static final String RUNTIME_ALL = "all";
  private static final String TAG = "MultiV8ViolaBridge";
  private static final String VIOLA_GLOBAL_VAR_KEY = "memoryCache";
  private JSONObject globalVar;
  private Map<String, MultiV8ViolaBridge.V8ViolaRuntime> instanceIdV8Map = new HashMap();
  private String mainJSSource;
  private final IMultiV8ViolaRuntimeAdapter multiV8ViolaRuntimeAdapter;
  private Map<String, MultiV8ViolaBridge.V8ViolaRuntime> v8Map = new HashMap();
  private String violaEnv;
  
  public MultiV8ViolaBridge(IMultiV8ViolaRuntimeAdapter paramIMultiV8ViolaRuntimeAdapter)
  {
    this.multiV8ViolaRuntimeAdapter = paramIMultiV8ViolaRuntimeAdapter;
  }
  
  private MultiV8ViolaBridge.V8ViolaRuntime createRuntime(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject)
  {
    MultiV8ViolaBridge.V8ViolaRuntime localV8ViolaRuntime = new MultiV8ViolaBridge.V8ViolaRuntime();
    localV8ViolaRuntime.runtimeName = paramString1;
    localV8ViolaRuntime.init();
    localV8ViolaRuntime.initJsFramework(paramString2, paramString3);
    if (paramJSONObject != null) {
      localV8ViolaRuntime.addGlobalVar("memoryCache", paramJSONObject);
    }
    this.multiV8ViolaRuntimeAdapter.onViolaRuntimeReady();
    return localV8ViolaRuntime;
  }
  
  private void preloadRuntime(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject)
  {
    paramString1 = createRuntime(paramString1, paramString2, paramString3, paramJSONObject);
    this.v8Map.put(paramString1.runtimeName, paramString1);
  }
  
  public int callJS(String paramString1, String paramString2)
  {
    MultiV8ViolaBridge.V8ViolaRuntime localV8ViolaRuntime = (MultiV8ViolaBridge.V8ViolaRuntime)this.instanceIdV8Map.get(paramString1);
    if (localV8ViolaRuntime == null) {
      return 0;
    }
    return localV8ViolaRuntime.callJS(paramString1, paramString2);
  }
  
  public int createInstance(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("runtimeName: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", instanceId: ");
    ((StringBuilder)localObject).append(paramString2);
    ViolaLogUtils.e("MultiV8ViolaBridge", ((StringBuilder)localObject).toString());
    MultiV8ViolaBridge.V8ViolaRuntime localV8ViolaRuntime = (MultiV8ViolaBridge.V8ViolaRuntime)this.v8Map.get(paramString1);
    localObject = localV8ViolaRuntime;
    if (localV8ViolaRuntime == null)
    {
      localObject = createRuntime(paramString1, this.mainJSSource, this.violaEnv, this.globalVar);
      this.v8Map.put(paramString1, localObject);
    }
    ViolaBridgeManager.getInstance().post(new MultiV8ViolaBridge.1(this, (MultiV8ViolaBridge.V8ViolaRuntime)localObject, paramString2, paramString3, paramString4, paramString5, paramString1));
    this.instanceIdV8Map.put(paramString2, localObject);
    return 1;
  }
  
  public int destroyInstance(String paramString)
  {
    Object localObject = (MultiV8ViolaBridge.V8ViolaRuntime)this.instanceIdV8Map.get(paramString);
    if (localObject == null) {
      return 0;
    }
    if ((this.multiV8ViolaRuntimeAdapter.needKeepGlobalVar(((MultiV8ViolaBridge.V8ViolaRuntime)localObject).runtimeName)) && (((MultiV8ViolaBridge.V8ViolaRuntime)localObject).lastRunningInstance(paramString))) {
      this.globalVar = ((MultiV8ViolaBridge.V8ViolaRuntime)localObject).getGlobalVar("memoryCache");
    }
    ((MultiV8ViolaBridge.V8ViolaRuntime)localObject).destroyInstance(paramString);
    this.instanceIdV8Map.remove(paramString);
    if (((MultiV8ViolaBridge.V8ViolaRuntime)localObject).runningInstance.isEmpty())
    {
      this.v8Map.remove(((MultiV8ViolaBridge.V8ViolaRuntime)localObject).runtimeName);
      if (this.multiV8ViolaRuntimeAdapter.needPreloadRuntime(((MultiV8ViolaBridge.V8ViolaRuntime)localObject).runtimeName)) {
        preloadRuntime(((MultiV8ViolaBridge.V8ViolaRuntime)localObject).runtimeName, this.mainJSSource, this.violaEnv, this.globalVar);
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("destroyInstance: ");
    ((StringBuilder)localObject).append(paramString);
    ViolaLogUtils.e("MultiV8ViolaBridge", ((StringBuilder)localObject).toString());
    return 1;
  }
  
  public int execJSFunc(String paramString1, String paramString2, String paramString3)
  {
    if ("all".equals(paramString1))
    {
      paramString1 = this.v8Map.values().iterator();
      while (paramString1.hasNext()) {
        ((MultiV8ViolaBridge.V8ViolaRuntime)paramString1.next()).execJSFunc(paramString2, paramString3);
      }
      return 1;
    }
    paramString1 = (MultiV8ViolaBridge.V8ViolaRuntime)this.v8Map.get(paramString1);
    if (paramString1 == null) {
      return 0;
    }
    return paramString1.execJSFunc(paramString2, paramString3);
  }
  
  public JSParam execJSFuncWithResult(String paramString1, String paramString2, List<JSParam> paramList)
  {
    paramString1 = (MultiV8ViolaBridge.V8ViolaRuntime)this.v8Map.get(paramString1);
    if (paramString1 == null) {
      return null;
    }
    return paramString1.execJSFuncWithResult(paramString2, paramList);
  }
  
  public int init()
  {
    return 1;
  }
  
  public int initJsFramework(String paramString1, String paramString2)
  {
    this.mainJSSource = paramString1;
    this.violaEnv = paramString2;
    return 1;
  }
  
  public int updateInstance(String paramString1, String paramString2)
  {
    MultiV8ViolaBridge.V8ViolaRuntime localV8ViolaRuntime = (MultiV8ViolaBridge.V8ViolaRuntime)this.instanceIdV8Map.get(paramString1);
    if (localV8ViolaRuntime == null) {
      return 0;
    }
    return localV8ViolaRuntime.updateInstance(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.MultiV8ViolaBridge
 * JD-Core Version:    0.7.0.1
 */