package com.tencent.mtt.hippy.modules.nativemodules.console;

import android.util.Log;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

@HippyNativeModule(name="ConsoleModule")
public class ConsoleModule
  extends HippyNativeModuleBase
{
  public ConsoleModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="error")
  public void error(String paramString)
  {
    Log.e("hippy_console", paramString);
  }
  
  @HippyMethod(name="info")
  public void info(String paramString)
  {
    Log.i("hippy_console", paramString);
  }
  
  @HippyMethod(name="log")
  public void log(String paramString)
  {
    Log.d("hippy_console", paramString);
  }
  
  @HippyMethod(name="warn")
  public void warn(String paramString)
  {
    Log.w("hippy_console", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.console.ConsoleModule
 * JD-Core Version:    0.7.0.1
 */