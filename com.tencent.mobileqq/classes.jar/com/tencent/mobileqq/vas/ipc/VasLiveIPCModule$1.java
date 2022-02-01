package com.tencent.mobileqq.vas.ipc;

import com.tencent.mobileqq.app.FrameHelperActivity;

class VasLiveIPCModule$1
  implements Runnable
{
  VasLiveIPCModule$1(VasLiveIPCModule paramVasLiveIPCModule) {}
  
  public void run()
  {
    if (FrameHelperActivity.b())
    {
      FrameHelperActivity.c(true);
      FrameHelperActivity.w();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.VasLiveIPCModule.1
 * JD-Core Version:    0.7.0.1
 */