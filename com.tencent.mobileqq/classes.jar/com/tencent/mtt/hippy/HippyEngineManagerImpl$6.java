package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.dom.DomManager;

class HippyEngineManagerImpl$6
  implements Runnable
{
  HippyEngineManagerImpl$6(HippyEngineManagerImpl paramHippyEngineManagerImpl, HippyRootView paramHippyRootView, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if ((this.this$0.mEngineContext != null) && (this.this$0.mEngineContext.getDomManager() != null)) {
      this.this$0.mEngineContext.getDomManager().updateNodeSize(this.val$rootView.getId(), this.val$width, this.val$height);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManagerImpl.6
 * JD-Core Version:    0.7.0.1
 */