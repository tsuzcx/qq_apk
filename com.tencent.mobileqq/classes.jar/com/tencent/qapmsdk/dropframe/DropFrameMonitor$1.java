package com.tencent.qapmsdk.dropframe;

import android.view.Choreographer;

class DropFrameMonitor$1
  implements Runnable
{
  DropFrameMonitor$1(DropFrameMonitor paramDropFrameMonitor) {}
  
  public void run()
  {
    DropFrameMonitor.access$002(this.this$0, Choreographer.getInstance());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.dropframe.DropFrameMonitor.1
 * JD-Core Version:    0.7.0.1
 */