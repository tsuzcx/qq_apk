package com.tencent.mtt.hippy.modules.nativemodules.utils;

import android.content.Context;
import android.os.Vibrator;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.LogUtils;

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
    Vibrator localVibrator = this.a;
    if (localVibrator != null) {
      localVibrator.cancel();
    }
  }
  
  @HippyMethod(name="vibrate")
  public void vibrate(HippyArray paramHippyArray, int paramInt)
  {
    if (this.a == null) {
      this.a = ((Vibrator)this.mContext.getGlobalConfigs().getContext().getSystemService("vibrator"));
    }
    if (this.a != null)
    {
      long[] arrayOfLong = null;
      Object localObject = arrayOfLong;
      if (paramHippyArray != null)
      {
        localObject = arrayOfLong;
        if (paramHippyArray.size() > 0)
        {
          arrayOfLong = new long[paramHippyArray.size()];
          int i = 0;
          for (;;)
          {
            localObject = arrayOfLong;
            try
            {
              if (i < paramHippyArray.size())
              {
                arrayOfLong[i] = ((Integer)paramHippyArray.get(i)).intValue();
                i += 1;
              }
            }
            catch (Exception paramHippyArray)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("vibrate: ");
              ((StringBuilder)localObject).append(paramHippyArray.getMessage());
              LogUtils.d("UtilsModule", ((StringBuilder)localObject).toString());
              localObject = arrayOfLong;
            }
          }
        }
      }
      if (localObject != null)
      {
        paramHippyArray = (HippyArray)localObject;
        if (localObject.length != 0) {}
      }
      else
      {
        paramHippyArray = new long[1];
        paramHippyArray[0] = 1000L;
      }
      this.a.vibrate(paramHippyArray, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.utils.UtilsModule
 * JD-Core Version:    0.7.0.1
 */