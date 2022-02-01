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
  private boolean mIsDestroyed = false;
  private Map<String, HippyNativeModuleInfo.HippyNativeMethod> mMethods;
  private final String mName;
  private final String[] mNames;
  private final Provider<? extends HippyNativeModuleBase> mProvider;
  private final HippyNativeModule.Thread mThread;
  
  public HippyNativeModuleInfo(Class paramClass, Provider<? extends HippyNativeModuleBase> paramProvider)
  {
    HippyNativeModule localHippyNativeModule = (HippyNativeModule)paramClass.getAnnotation(HippyNativeModule.class);
    this.mName = localHippyNativeModule.name();
    this.mNames = localHippyNativeModule.names();
    this.mClass = paramClass;
    this.mThread = localHippyNativeModule.thread();
    this.mProvider = paramProvider;
    initImmediately(localHippyNativeModule);
  }
  
  private void initImmediately(HippyNativeModule paramHippyNativeModule)
  {
    if (paramHippyNativeModule.init()) {
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
  }
  
  public void destroy()
  {
    HippyNativeModuleBase localHippyNativeModuleBase = this.mInstance;
    if (localHippyNativeModuleBase != null) {
      localHippyNativeModuleBase.destroy();
    }
  }
  
  public HippyNativeModuleInfo.HippyNativeMethod findMethod(String paramString)
  {
    Map localMap = this.mMethods;
    if (localMap == null) {
      return null;
    }
    return (HippyNativeModuleInfo.HippyNativeMethod)localMap.get(paramString);
  }
  
  public HippyNativeModuleBase getInstance()
  {
    return this.mInstance;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String[] getNames()
  {
    return this.mNames;
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
      Object localObject1 = (HippyMethod)localMethod.getAnnotation(HippyMethod.class);
      if (localObject1 != null)
      {
        Object localObject2 = ((HippyMethod)localObject1).name();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = localMethod.getName();
        }
        if (!this.mMethods.containsKey(localObject1))
        {
          this.mMethods.put(localObject1, new HippyNativeModuleInfo.HippyNativeMethod(this, localMethod));
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Java Module ");
          ((StringBuilder)localObject2).append(this.mName);
          ((StringBuilder)localObject2).append(" method name already registered: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          throw new RuntimeException(((StringBuilder)localObject2).toString());
        }
      }
      i += 1;
    }
    this.mInstance = ((HippyNativeModuleBase)this.mProvider.get());
    this.mInstance.initialize();
    this.mInit = true;
  }
  
  public void onDestroy()
  {
    this.mIsDestroyed = true;
  }
  
  public boolean shouldDestroy()
  {
    return this.mIsDestroyed ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleInfo
 * JD-Core Version:    0.7.0.1
 */