package cooperation.qzone.event;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ExoticEventPool
{
  private static final int MAX_QUEUE_SIZE = 20;
  private static final String TAG = "ExoticEventPool";
  private final BlockingQueue<ExoticEvent> mQueue = new LinkedBlockingDeque(20);
  
  @NonNull
  public static ExoticEventPool getInstance()
  {
    return ExoticEventPool.ExoticEventPoolHolder.access$100();
  }
  
  public boolean onEventReceived(@Nullable ExoticEvent paramExoticEvent)
  {
    if (QZoneApiProxy.isInQZoneEnvironment()) {
      return false;
    }
    if (paramExoticEvent == null) {
      return true;
    }
    try
    {
      boolean bool = this.mQueue.add(paramExoticEvent);
      return bool;
    }
    catch (Throwable paramExoticEvent)
    {
      QZLog.w("ExoticEventPool", "onEventReceived: failed to add event", paramExoticEvent);
    }
    return false;
  }
  
  @Nullable
  public ExoticEvent pollEvent()
  {
    try
    {
      ExoticEvent localExoticEvent = (ExoticEvent)this.mQueue.take();
      return localExoticEvent;
    }
    catch (Throwable localThrowable)
    {
      QZLog.w("ExoticEventPool", "pollEvent: failed to poll event", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.event.ExoticEventPool
 * JD-Core Version:    0.7.0.1
 */