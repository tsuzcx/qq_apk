package com.tencent.mobileqq.qwallet.preload.impl;

import java.lang.ref.WeakReference;

class PreloadResourceImpl$1
  extends PreloadResourceImpl.PreloadTimerTask
{
  PreloadResourceImpl$1(PreloadResourceImpl paramPreloadResourceImpl, WeakReference paramWeakReference, PreloadModuleImpl paramPreloadModuleImpl) {}
  
  public void a()
  {
    PreloadServiceImpl localPreloadServiceImpl = (PreloadServiceImpl)this.a.get();
    if ((PreloadServiceImpl.isManagerValid(localPreloadServiceImpl)) && (localPreloadServiceImpl.isResInConfig(this.this$0))) {
      localPreloadServiceImpl.addResToFlowControlCheck(new PreloadServiceImpl.FlowControlDownloadStruct(this.this$0, this.b, null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadResourceImpl.1
 * JD-Core Version:    0.7.0.1
 */