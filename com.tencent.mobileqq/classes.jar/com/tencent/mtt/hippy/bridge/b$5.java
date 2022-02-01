package com.tencent.mtt.hippy.bridge;

import com.tencent.mtt.hippy.HippyEngine.ModuleListener;
import com.tencent.mtt.hippy.HippyRootView;

class b$5
  implements Runnable
{
  b$5(b paramb, int paramInt, String paramString, HippyRootView paramHippyRootView) {}
  
  public void run()
  {
    if (this.d.i != null) {
      this.d.i.onInitialized(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.b.5
 * JD-Core Version:    0.7.0.1
 */