package rx.plugins;

import rx.Scheduler;
import rx.functions.Action0;

public class RxJavaSchedulersHook
{
  private static final RxJavaSchedulersHook DEFAULT_INSTANCE = new RxJavaSchedulersHook();
  
  public static RxJavaSchedulersHook getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public Scheduler getComputationScheduler()
  {
    return null;
  }
  
  public Scheduler getIOScheduler()
  {
    return null;
  }
  
  public Scheduler getNewThreadScheduler()
  {
    return null;
  }
  
  public Action0 onSchedule(Action0 paramAction0)
  {
    return paramAction0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.plugins.RxJavaSchedulersHook
 * JD-Core Version:    0.7.0.1
 */