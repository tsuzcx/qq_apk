package com.tencent.qapmsdk.dropframe;

public class DropFrameRunnable
  implements Runnable
{
  public void run()
  {
    DropFrameMonitor.dropFrameMonitor = DropFrameMonitor.getInstance();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dropframe.DropFrameRunnable
 * JD-Core Version:    0.7.0.1
 */