package com.tencent.mtt.hippy.modules.javascriptmodules;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.bridge.a;
import com.tencent.mtt.hippy.utils.ArgumentUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HippyJavaScriptModuleInvocationHandler
  implements InvocationHandler
{
  private final HippyEngineContext mHippyContext;
  private final String mName;
  
  public HippyJavaScriptModuleInvocationHandler(HippyEngineContext paramHippyEngineContext, String paramString)
  {
    this.mHippyContext = paramHippyEngineContext;
    this.mName = paramString;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if ((paramObject instanceof HippyJavaScriptModule))
    {
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 1)) {
        paramObject = paramArrayOfObject[0];
      } else {
        paramObject = ArgumentUtils.fromJavaArgs(paramArrayOfObject);
      }
      paramArrayOfObject = this.mHippyContext;
      if ((paramArrayOfObject != null) && (paramArrayOfObject.getBridgeManager() != null)) {
        this.mHippyContext.getBridgeManager().a(this.mName, paramMethod.getName(), paramObject);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModuleInvocationHandler
 * JD-Core Version:    0.7.0.1
 */