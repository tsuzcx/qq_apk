package com.tribe.async.async;

import android.os.Handler;
import android.view.Choreographer.FrameCallback;

class MainFreeJobScheduler$ChoreographerScheduler$1
  implements Choreographer.FrameCallback
{
  MainFreeJobScheduler$ChoreographerScheduler$1(MainFreeJobScheduler.ChoreographerScheduler paramChoreographerScheduler) {}
  
  public void doFrame(long paramLong)
  {
    MainFreeJobScheduler.access$000(this.this$1.this$0).sendEmptyMessageDelayed(1, 3L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.async.MainFreeJobScheduler.ChoreographerScheduler.1
 * JD-Core Version:    0.7.0.1
 */