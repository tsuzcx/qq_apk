package com.tencent.mtt.hippy.modules.nativemodules;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.PromiseImpl;
import com.tencent.mtt.hippy.utils.ArgumentUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class HippyNativeModuleInfo$HippyNativeMethod
{
  private Method mMethod;
  private Type[] mParamTypes;
  
  public HippyNativeModuleInfo$HippyNativeMethod(HippyNativeModuleInfo paramHippyNativeModuleInfo, Method paramMethod)
  {
    this.mMethod = paramMethod;
    this.mParamTypes = paramMethod.getGenericParameterTypes();
  }
  
  private Object[] prepareArguments(HippyEngineContext paramHippyEngineContext, Type[] paramArrayOfType, HippyArray paramHippyArray, PromiseImpl paramPromiseImpl)
  {
    if ((paramArrayOfType == null) || (paramArrayOfType.length <= 0)) {
      return new Object[0];
    }
    paramHippyEngineContext = new Object[paramArrayOfType.length];
    if (paramHippyArray == null) {
      throw new RuntimeException("method argument list not match");
    }
    int i = 0;
    int j = 0;
    if (i < paramArrayOfType.length)
    {
      Type localType = paramArrayOfType[i];
      if (localType == Promise.class)
      {
        paramHippyEngineContext[i] = paramPromiseImpl;
        paramPromiseImpl.setNeedResolveBySelf(false);
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramHippyArray.size() <= j) {
          throw new RuntimeException("method argument list not match");
        }
        paramHippyEngineContext[i] = ArgumentUtils.parseArgument(localType, paramHippyArray, j);
        j += 1;
      }
    }
    return paramHippyEngineContext;
  }
  
  public void invoke(HippyEngineContext paramHippyEngineContext, Object paramObject, HippyArray paramHippyArray, PromiseImpl paramPromiseImpl)
  {
    paramHippyEngineContext = prepareArguments(paramHippyEngineContext, this.mParamTypes, paramHippyArray, paramPromiseImpl);
    this.mMethod.invoke(paramObject, paramHippyEngineContext);
    if (paramPromiseImpl.needResolveBySelf()) {
      paramPromiseImpl.resolve("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleInfo.HippyNativeMethod
 * JD-Core Version:    0.7.0.1
 */