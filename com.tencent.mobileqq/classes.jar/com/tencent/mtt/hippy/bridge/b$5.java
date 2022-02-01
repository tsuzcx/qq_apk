package com.tencent.mtt.hippy.bridge;

import com.tencent.mtt.hippy.HippyEngine.ModuleListener;
import com.tencent.mtt.hippy.common.HippyJsException;

class b$5
  implements Runnable
{
  b$5(b paramb, HippyJsException paramHippyJsException) {}
  
  public void run()
  {
    if ((this.b.i != null) && (this.b.i.onJsException(this.a))) {
      this.b.i = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.b.5
 * JD-Core Version:    0.7.0.1
 */