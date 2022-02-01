package com.tencent.mtt.hippy.modules.nativemodules.exception;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

@HippyNativeModule(name="ExceptionModule")
public class ExceptionModule
  extends HippyNativeModuleBase
{
  public static final String HIPPY_CLASS = "ExceptionModule";
  
  public ExceptionModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="handleBackgroundTracing")
  public void handleBackgroundTracing(String paramString)
  {
    if ((this.mContext != null) && (this.mContext.getGlobalConfigs() != null)) {
      this.mContext.getGlobalConfigs().getExceptionHandler().handleBackgroundTracing(paramString);
    }
  }
  
  @HippyMethod(name="handleException")
  public void handleException(String paramString1, String paramString2, int paramInt)
  {
    if (this.mContext != null) {
      this.mContext.handleException(new HippyJsException(paramString1, paramString2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.exception.ExceptionModule
 * JD-Core Version:    0.7.0.1
 */