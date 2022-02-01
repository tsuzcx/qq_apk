package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.common.Callback;
import com.tencent.mtt.hippy.utils.UIThreadUtils;

class HippyEngineManagerImpl$2
  implements Callback<Boolean>
{
  HippyEngineManagerImpl$2(HippyEngineManagerImpl paramHippyEngineManagerImpl) {}
  
  public void callback(Boolean paramBoolean, Throwable paramThrowable)
  {
    UIThreadUtils.runOnUiThread(new HippyEngineManagerImpl.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */