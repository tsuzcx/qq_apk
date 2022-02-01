package com.tencent.mtt.hippy;

class HippyEngineManagerImpl$4
  implements Runnable
{
  HippyEngineManagerImpl$4(HippyEngineManagerImpl paramHippyEngineManagerImpl, HippyEngine.ModuleLoadStatus paramModuleLoadStatus, String paramString, HippyRootView paramHippyRootView) {}
  
  public void run()
  {
    if (this.this$0.mModuleListener != null)
    {
      this.this$0.mModuleListener.onLoadCompleted(this.val$statusCode, this.val$msg, this.val$hippyRootView);
      this.this$0.mModuleListener = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */