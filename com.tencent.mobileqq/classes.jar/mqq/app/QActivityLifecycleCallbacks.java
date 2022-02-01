package mqq.app;

import android.app.Application.ActivityLifecycleCallbacks;

public abstract interface QActivityLifecycleCallbacks
  extends Application.ActivityLifecycleCallbacks
{
  public abstract void onProcessBackground();
  
  public abstract void onProcessForeground();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.QActivityLifecycleCallbacks
 * JD-Core Version:    0.7.0.1
 */