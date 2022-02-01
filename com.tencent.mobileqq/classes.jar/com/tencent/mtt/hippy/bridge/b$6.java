package com.tencent.mtt.hippy.bridge;

import com.tencent.mtt.hippy.HippyEngine.ModuleListener;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadStatus;
import com.tencent.mtt.hippy.HippyRootView;

class b$6
  implements Runnable
{
  b$6(b paramb, HippyEngine.ModuleLoadStatus paramModuleLoadStatus, String paramString, HippyRootView paramHippyRootView) {}
  
  public void run()
  {
    if (this.d.i != null) {
      this.d.i.onLoadCompleted(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.b.6
 * JD-Core Version:    0.7.0.1
 */