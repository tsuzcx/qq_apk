package com.tencent.mtt.hippy.modules.nativemodules.deviceevent;

import com.tencent.mtt.hippy.HippyEngine.BackPressHandler;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.UIThreadUtils;

@HippyNativeModule(init=true, name="DeviceEventModule")
public class DeviceEventModule
  extends HippyNativeModuleBase
{
  HippyEngine.BackPressHandler a = null;
  private boolean b = false;
  
  public DeviceEventModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  public void destroy()
  {
    super.destroy();
    this.a = null;
  }
  
  @HippyMethod(name="invokeDefaultBackPressHandler")
  public void invokeDefaultBackPressHandler()
  {
    UIThreadUtils.runOnUiThread(new DeviceEventModule.1(this));
  }
  
  public boolean onBackPressed(HippyEngine.BackPressHandler paramBackPressHandler)
  {
    if (this.b)
    {
      this.a = paramBackPressHandler;
      if ((this.mContext != null) && (this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class) != null))
      {
        ((EventDispatcher)this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("hardwareBackPress", null);
        return true;
      }
    }
    return false;
  }
  
  @HippyMethod(name="setListenBackPress")
  public void setListenBackPress(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.deviceevent.DeviceEventModule
 * JD-Core Version:    0.7.0.1
 */