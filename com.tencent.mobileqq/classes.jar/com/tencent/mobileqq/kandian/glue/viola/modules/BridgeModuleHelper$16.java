package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.biz.common.offline.AsyncBack;

final class BridgeModuleHelper$16
  implements AsyncBack
{
  BridgeModuleHelper$16(BridgeModule paramBridgeModule, String paramString) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.invokeCallJS(this.b, null);
      return;
    }
    this.a.invokeErrorCallJS(this.b, paramString);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.16
 * JD-Core Version:    0.7.0.1
 */