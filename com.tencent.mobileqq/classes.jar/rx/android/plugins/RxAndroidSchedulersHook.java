package rx.android.plugins;

import rx.Scheduler;
import rx.functions.Action0;

public class RxAndroidSchedulersHook
{
  private static final RxAndroidSchedulersHook DEFAULT_INSTANCE = new RxAndroidSchedulersHook();
  
  public static RxAndroidSchedulersHook getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public Scheduler getMainThreadScheduler()
  {
    return null;
  }
  
  public Action0 onSchedule(Action0 paramAction0)
  {
    return paramAction0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.android.plugins.RxAndroidSchedulersHook
 * JD-Core Version:    0.7.0.1
 */