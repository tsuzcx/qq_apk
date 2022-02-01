package com.tencent.mtt.hippy.modules.javascriptmodules;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.bridge.a;
import com.tencent.mtt.hippy.utils.ArgumentUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HippyJavaScriptModuleInvocationHandler
  implements InvocationHandler
{
  private HippyEngineContext mHippyContext;
  private String mName;
  
  public HippyJavaScriptModuleInvocationHandler(HippyEngineContext paramHippyEngineContext, String paramString)
  {
    this.mHippyContext = paramHippyEngineContext;
    this.mName = paramString;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if ((paramObject instanceof HippyJavaScriptModule)) {
      if ((paramArrayOfObject == null) || (paramArrayOfObject.length != 1)) {
        break label65;
      }
    }
    label65:
    for (paramObject = paramArrayOfObject[0];; paramObject = ArgumentUtils.fromJavaArgs(paramArrayOfObject))
    {
      if ((this.mHippyContext != null) && (this.mHippyContext.getBridgeManager() != null)) {
        this.mHippyContext.getBridgeManager().a(this.mName, paramMethod.getName(), paramObject);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModuleInvocationHandler
 * JD-Core Version:    0.7.0.1
 */