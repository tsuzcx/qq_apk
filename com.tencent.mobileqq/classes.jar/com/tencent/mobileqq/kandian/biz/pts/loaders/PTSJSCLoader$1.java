package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.mobileqq.kandian.biz.pts.util.PTSSwitchManager;
import com.tencent.qphone.base.util.QLog;

class PTSJSCLoader$1
  implements Runnable
{
  PTSJSCLoader$1(PTSJSCLoader paramPTSJSCLoader) {}
  
  public void run()
  {
    if (!PTSSwitchManager.a.b())
    {
      QLog.i("PTSJSCLoader", 1, "[init], ptsJSCEnabled is false.");
      return;
    }
    PTSJSCLoader.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSJSCLoader.1
 * JD-Core Version:    0.7.0.1
 */