package com.tencent.mtt.hippy.bridge;

import com.tencent.mtt.hippy.a.b.a;
import com.tencent.mtt.hippy.utils.LogUtils;

class HippyBridgeImpl$1
  implements b.a
{
  HippyBridgeImpl$1(HippyBridgeImpl paramHippyBridgeImpl, int paramInt) {}
  
  public void a(String paramString)
  {
    LogUtils.e("hippyCore", "js debug socket connect success");
    HippyBridgeImpl.access$000(this.b, this.a);
  }
  
  public void a(Throwable paramThrowable)
  {
    LogUtils.e("hippyCore", "js debug socket connect failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.HippyBridgeImpl.1
 * JD-Core Version:    0.7.0.1
 */