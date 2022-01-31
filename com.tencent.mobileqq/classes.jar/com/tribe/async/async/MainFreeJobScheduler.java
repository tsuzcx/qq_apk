package com.tribe.async.async;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public abstract class MainFreeJobScheduler
  implements JobScheduler
{
  private static final int MSG_DISPATCH_JOB_SCHEDULE = 2;
  private static final int MSG_MAIN_THREAD_SCHEDULE = 1;
  private ChoreographerScheduler mChoreographerScheduler;
  private final Handler mDispatchHandler = new DispatchScheduleHandler();
  private final Handler mMainHandler = new MainThreadScheduleHandler();
  
  public MainFreeJobScheduler()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.mChoreographerScheduler = new ChoreographerScheduler();
    }
  }
  
  public abstract void doSchedule();
  
  public void schedule()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.mChoreographerScheduler.schedule();
      return;
    }
    Message.obtain(this.mMainHandler, 1).sendToTarget();
  }
  
  @TargetApi(16)
  private class ChoreographerScheduler
  {
    private Choreographer mChoreographer = Choreographer.getInstance();
    
    public ChoreographerScheduler() {}
    
    public void schedule()
    {
      this.mChoreographer.postFrameCallback(new Choreographer.FrameCallback()
      {
        public void doFrame(long paramAnonymousLong)
        {
          MainFreeJobScheduler.this.mMainHandler.sendEmptyMessageDelayed(1, 3L);
        }
      });
    }
  }
  
  private class DispatchScheduleHandler
    extends Handler
  {
    public DispatchScheduleHandler()
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      MainFreeJobScheduler.this.doSchedule();
    }
  }
  
  private class MainThreadScheduleHandler
    extends Handler
  {
    public MainThreadScheduleHandler()
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      Message.obtain(MainFreeJobScheduler.this.mDispatchHandler, 2).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.async.MainFreeJobScheduler
 * JD-Core Version:    0.7.0.1
 */