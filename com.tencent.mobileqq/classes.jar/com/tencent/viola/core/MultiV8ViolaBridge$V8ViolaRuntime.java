package com.tencent.viola.core;

import androidx.collection.ArrayMap;
import com.tencent.viola.commons.JSParam;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class MultiV8ViolaBridge$V8ViolaRuntime
  implements IViolaBridge
{
  private Map<String, List<String>> pendingUpdateInstanceMap;
  public List<String> runningInstance = new ArrayList();
  public String runtimeName;
  public V8ViolaBridge v8ViolaBridge = new V8ViolaBridge();
  
  private void lazyUpdateInstance(String paramString1, String paramString2)
  {
    if (this.pendingUpdateInstanceMap == null) {
      this.pendingUpdateInstanceMap = new ArrayMap();
    }
    List localList = (List)this.pendingUpdateInstanceMap.get(paramString1);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(paramString2);
    this.pendingUpdateInstanceMap.put(paramString1, localObject);
    paramString1 = new StringBuilder();
    paramString1.append("pending update: ");
    paramString1.append(paramString2);
    ViolaLogUtils.e("MultiV8ViolaBridge", paramString1.toString());
  }
  
  private void tryRunPendingUpdateInstance(String paramString)
  {
    Object localObject = this.pendingUpdateInstanceMap;
    if (localObject != null)
    {
      localObject = (List)((Map)localObject).remove(paramString);
      if (localObject == null) {
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        updateInstance(paramString, (String)((Iterator)localObject).next());
      }
    }
  }
  
  public void addGlobalVar(String paramString, JSONObject paramJSONObject)
  {
    this.v8ViolaBridge.addGlobalVar(paramString, paramJSONObject);
  }
  
  public int callJS(String paramString1, String paramString2)
  {
    return this.v8ViolaBridge.callJS(paramString1, paramString2);
  }
  
  public int createInstance(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.runningInstance.add(paramString1);
    int i = this.v8ViolaBridge.createInstance(paramString1, paramString2, paramString3, paramString4);
    tryRunPendingUpdateInstance(paramString1);
    return i;
  }
  
  public int destroy()
  {
    return this.v8ViolaBridge.destroy();
  }
  
  public int destroyInstance(String paramString)
  {
    int i = this.v8ViolaBridge.destroyInstance(paramString);
    this.runningInstance.remove(paramString);
    if (this.runningInstance.isEmpty())
    {
      this.v8ViolaBridge.releaseAllV8Objects();
      this.v8ViolaBridge.destroy();
    }
    return i;
  }
  
  public int execJSFunc(String paramString1, String paramString2)
  {
    return this.v8ViolaBridge.execJSFunc(paramString1, paramString2);
  }
  
  public JSParam execJSFuncWithResult(String paramString, List<JSParam> paramList)
  {
    return this.v8ViolaBridge.execJSFuncWithResult(paramString, paramList);
  }
  
  public JSONObject getGlobalVar(String paramString)
  {
    return this.v8ViolaBridge.getGlobalVar(paramString);
  }
  
  public int init()
  {
    int i = this.v8ViolaBridge.init();
    this.v8ViolaBridge.initV8RefHandler();
    return i;
  }
  
  public int initJsFramework(String paramString1, String paramString2)
  {
    return this.v8ViolaBridge.initJsFramework(paramString1, paramString2);
  }
  
  public boolean lastRunningInstance(String paramString)
  {
    return (this.runningInstance.contains(paramString)) && (this.runningInstance.size() == 1);
  }
  
  public void preloadTest(String paramString1, String paramString2) {}
  
  public int updateInstance(String paramString1, String paramString2)
  {
    if (!this.runningInstance.contains(paramString1))
    {
      lazyUpdateInstance(paramString1, paramString2);
      return 1;
    }
    return this.v8ViolaBridge.updateInstance(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.MultiV8ViolaBridge.V8ViolaRuntime
 * JD-Core Version:    0.7.0.1
 */