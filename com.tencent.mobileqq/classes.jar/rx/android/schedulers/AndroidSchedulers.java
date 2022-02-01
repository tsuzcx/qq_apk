package rx.android.schedulers;

import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;

public final class AndroidSchedulers
{
  private AndroidSchedulers()
  {
    throw new AssertionError("No instances");
  }
  
  public static Scheduler mainThread()
  {
    Scheduler localScheduler = RxAndroidPlugins.getInstance().getSchedulersHook().getMainThreadScheduler();
    if (localScheduler != null) {
      return localScheduler;
    }
    return AndroidSchedulers.MainThreadSchedulerHolder.MAIN_THREAD_SCHEDULER;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.android.schedulers.AndroidSchedulers
 * JD-Core Version:    0.7.0.1
 */