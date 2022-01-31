package mqq.app;

import android.app.Activity;

public abstract interface Foreground$AppLifeCycleCallback
{
  public abstract void onActivityCreated(Activity paramActivity);
  
  public abstract void onActivityDestroyed(Activity paramActivity);
  
  public abstract void onRunningBackground();
  
  public abstract void onRunningForeground();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.Foreground.AppLifeCycleCallback
 * JD-Core Version:    0.7.0.1
 */