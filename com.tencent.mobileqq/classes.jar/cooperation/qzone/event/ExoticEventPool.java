package cooperation.qzone.event;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qzonehub.api.IQzoneEventApi.ExoticEventInterface;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ExoticEventPool
{
  private static final int MAX_QUEUE_SIZE = 20;
  private static final String TAG = "ExoticEventPool";
  private final BlockingQueue<IQzoneEventApi.ExoticEventInterface> mQueue = new LinkedBlockingDeque(20);
  
  @NonNull
  public static ExoticEventPool getInstance()
  {
    return ExoticEventPool.ExoticEventPoolHolder.access$100();
  }
  
  public boolean onEventReceived(@Nullable IQzoneEventApi.ExoticEventInterface paramExoticEventInterface)
  {
    if (QZoneApiProxy.isInQZoneEnvironment()) {
      return false;
    }
    if (paramExoticEventInterface == null) {
      return true;
    }
    try
    {
      boolean bool = this.mQueue.add(paramExoticEventInterface);
      return bool;
    }
    catch (Throwable paramExoticEventInterface)
    {
      QZLog.w("ExoticEventPool", "onEventReceived: failed to add event", paramExoticEventInterface);
    }
    return false;
  }
  
  @Nullable
  public IQzoneEventApi.ExoticEventInterface pollEvent()
  {
    try
    {
      IQzoneEventApi.ExoticEventInterface localExoticEventInterface = (IQzoneEventApi.ExoticEventInterface)this.mQueue.take();
      return localExoticEventInterface;
    }
    catch (Throwable localThrowable)
    {
      QZLog.w("ExoticEventPool", "pollEvent: failed to poll event", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.event.ExoticEventPool
 * JD-Core Version:    0.7.0.1
 */