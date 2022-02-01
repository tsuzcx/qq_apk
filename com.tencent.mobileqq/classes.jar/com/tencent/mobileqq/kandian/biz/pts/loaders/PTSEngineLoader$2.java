package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.mobileqq.kandian.biz.pts.util.PTSSwitchManager;

class PTSEngineLoader$2
  implements Runnable
{
  PTSEngineLoader$2(PTSEngineLoader paramPTSEngineLoader) {}
  
  public void run()
  {
    if (!PTSSwitchManager.a.c()) {
      return;
    }
    PTSEngineLoader.a(this.this$0);
    PTSEngineLoader.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSEngineLoader.2
 * JD-Core Version:    0.7.0.1
 */