import com.tencent.component.media.image.ImageManager;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class pll
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "Qzone_ImageManager_decode_ThreadPool_" + ImageManager.a().getAndIncrement());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pll
 * JD-Core Version:    0.7.0.1
 */