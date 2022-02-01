package com.tencent.mtt.hippy.modules.nativemodules.utils;

import android.content.Context;
import android.os.Vibrator;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

@HippyNativeModule(name="UtilsModule")
public class UtilsModule
  extends HippyNativeModuleBase
{
  private Vibrator a;
  
  public UtilsModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="cancel")
  public void cancel()
  {
    if (this.a == null) {
      this.a = ((Vibrator)this.mContext.getGlobalConfigs().getContext().getSystemService("vibrator"));
    }
    if (this.a != null) {
      this.a.cancel();
    }
  }
  
  @HippyMethod(name="vibrate")
  public void vibrate(HippyArray paramHippyArray, int paramInt)
  {
    if (this.a == null) {
      this.a = ((Vibrator)this.mContext.getGlobalConfigs().getContext().getSystemService("vibrator"));
    }
    Object localObject1;
    int i;
    if (this.a != null)
    {
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramHippyArray != null)
      {
        localObject1 = localObject2;
        if (paramHippyArray.size() > 0)
        {
          localObject1 = new long[paramHippyArray.size()];
          i = 0;
        }
      }
    }
    try
    {
      while (i < paramHippyArray.size())
      {
        localObject1[i] = ((Integer)paramHippyArray.get(i)).intValue();
        i += 1;
      }
    }
    catch (Exception paramHippyArray)
    {
      label101:
      break label101;
    }
    if (localObject1 != null)
    {
      paramHippyArray = (HippyArray)localObject1;
      if (localObject1.length != 0) {}
    }
    else
    {
      paramHippyArray = new long[1];
      paramHippyArray[0] = 1000L;
    }
    this.a.vibrate(paramHippyArray, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.utils.UtilsModule
 * JD-Core Version:    0.7.0.1
 */