package com.tencent.mtt.hippy.modules.nativemodules;

import android.text.TextUtils;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.annotation.HippyNativeModule.Thread;
import com.tencent.mtt.hippy.common.Provider;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class HippyNativeModuleInfo
{
  private final Class mClass;
  private boolean mInit = false;
  private HippyNativeModuleBase mInstance;
  private Map<String, HippyNativeModuleInfo.HippyNativeMethod> mMethods;
  private final String mName;
  private final Provider<? extends HippyNativeModuleBase> mProvider;
  private final HippyNativeModule.Thread mThread;
  
  public HippyNativeModuleInfo(Class paramClass, Provider<? extends HippyNativeModuleBase> paramProvider)
  {
    HippyNativeModule localHippyNativeModule = (HippyNativeModule)paramClass.getAnnotation(HippyNativeModule.class);
    this.mName = localHippyNativeModule.name();
    this.mClass = paramClass;
    this.mThread = localHippyNativeModule.thread();
    this.mProvider = paramProvider;
    initImmediately(localHippyNativeModule);
  }
  
  private void initImmediately(HippyNativeModule paramHippyNativeModule)
  {
    if (paramHippyNativeModule.init()) {}
    try
    {
      initialize();
      return;
    }
    catch (Throwable paramHippyNativeModule)
    {
      paramHippyNativeModule.printStackTrace();
    }
  }
  
  public void destroy()
  {
    if (this.mInstance != null) {
      this.mInstance.destroy();
    }
  }
  
  public HippyNativeModuleInfo.HippyNativeMethod findMethod(String paramString)
  {
    if (this.mMethods == null) {
      return null;
    }
    return (HippyNativeModuleInfo.HippyNativeMethod)this.mMethods.get(paramString);
  }
  
  public HippyNativeModuleBase getInstance()
  {
    return this.mInstance;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public HippyNativeModule.Thread getThread()
  {
    return this.mThread;
  }
  
  public void initialize()
  {
    if (this.mInit) {
      return;
    }
    this.mMethods = new HashMap();
    Method[] arrayOfMethod = this.mClass.getMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      Object localObject = (HippyMethod)localMethod.getAnnotation(HippyMethod.class);
      if (localObject != null)
      {
        String str = ((HippyMethod)localObject).name();
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = localMethod.getName();
        }
        if (this.mMethods.containsKey(localObject)) {
          throw new RuntimeException("Java Module " + this.mName + " method name already registered: " + (String)localObject);
        }
        this.mMethods.put(localObject, new HippyNativeModuleInfo.HippyNativeMethod(this, localMethod));
      }
      i += 1;
    }
    this.mInstance = ((HippyNativeModuleBase)this.mProvider.get());
    this.mInstance.initialize();
    this.mInit = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleInfo
 * JD-Core Version:    0.7.0.1
 */