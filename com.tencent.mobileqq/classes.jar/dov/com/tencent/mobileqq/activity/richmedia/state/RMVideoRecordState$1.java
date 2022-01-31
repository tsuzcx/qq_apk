package dov.com.tencent.mobileqq.activity.richmedia.state;

import bkrt;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

public class RMVideoRecordState$1
  implements Runnable
{
  public RMVideoRecordState$1(bkrt parambkrt, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.unlockFrameSync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.1
 * JD-Core Version:    0.7.0.1
 */