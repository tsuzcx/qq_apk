package com.tencent.xweb.skia_canvas;

import android.view.Choreographer.FrameCallback;

class VSyncWaiter$2
  implements Choreographer.FrameCallback
{
  VSyncWaiter$2(VSyncWaiter paramVSyncWaiter, VSyncWaiter.VSyncWaiterCallback paramVSyncWaiterCallback) {}
  
  public void doFrame(long paramLong)
  {
    this.val$callback.doFrame(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.VSyncWaiter.2
 * JD-Core Version:    0.7.0.1
 */