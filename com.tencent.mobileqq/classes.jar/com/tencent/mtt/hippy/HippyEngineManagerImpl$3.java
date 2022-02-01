package com.tencent.mtt.hippy;

class HippyEngineManagerImpl$3
  implements Runnable
{
  HippyEngineManagerImpl$3(HippyEngineManagerImpl paramHippyEngineManagerImpl, int paramInt, String paramString, HippyRootView paramHippyRootView) {}
  
  public void run()
  {
    if (this.this$0.mModuleListener != null)
    {
      this.this$0.mModuleListener.onInitialized(this.val$statusCode, this.val$msg, this.val$hippyRootView);
      this.this$0.mModuleListener = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */