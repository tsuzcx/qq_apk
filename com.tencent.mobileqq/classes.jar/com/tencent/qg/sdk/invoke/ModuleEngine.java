package com.tencent.qg.sdk.invoke;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ModuleEngine
{
  public static final String TAG = "QG.ModuleEngine";
  private HashMap<String, BaseJsModule> mJsModules = new HashMap();
  
  public ModuleEngine()
  {
    initEngine();
  }
  
  private void initEngine() {}
  
  public void destroyEngine()
  {
    Iterator localIterator = this.mJsModules.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((BaseJsModule)this.mJsModules.get(str)).onDestroy();
    }
    this.mJsModules.clear();
  }
  
  public BaseJsModule getJsModule(String paramString)
  {
    return (BaseJsModule)this.mJsModules.get(paramString);
  }
  
  public void registerJsModule(BaseJsModule paramBaseJsModule)
  {
    this.mJsModules.put(paramBaseJsModule.getModuleName(), paramBaseJsModule);
  }
  
  public void unRegisterJsModule(BaseJsModule paramBaseJsModule)
  {
    if (paramBaseJsModule == null) {}
    BaseJsModule localBaseJsModule;
    do
    {
      return;
      localBaseJsModule = (BaseJsModule)this.mJsModules.remove(paramBaseJsModule.getModuleName());
      if (localBaseJsModule != null) {
        localBaseJsModule.onDestroy();
      }
    } while (paramBaseJsModule == localBaseJsModule);
    paramBaseJsModule.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qg.sdk.invoke.ModuleEngine
 * JD-Core Version:    0.7.0.1
 */