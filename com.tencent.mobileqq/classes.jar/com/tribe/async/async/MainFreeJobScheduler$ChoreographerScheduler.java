package com.tribe.async.async;

import android.annotation.TargetApi;
import android.view.Choreographer;

@TargetApi(16)
class MainFreeJobScheduler$ChoreographerScheduler
{
  private Choreographer mChoreographer = Choreographer.getInstance();
  
  public MainFreeJobScheduler$ChoreographerScheduler(MainFreeJobScheduler paramMainFreeJobScheduler) {}
  
  public void schedule()
  {
    this.mChoreographer.postFrameCallback(new MainFreeJobScheduler.ChoreographerScheduler.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tribe.async.async.MainFreeJobScheduler.ChoreographerScheduler
 * JD-Core Version:    0.7.0.1
 */