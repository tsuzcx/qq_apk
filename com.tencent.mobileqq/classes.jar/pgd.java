import com.tencent.component.media.gif.NewGifDrawable;

public abstract class pgd
  implements Runnable
{
  public final NewGifDrawable b;
  
  pgd(NewGifDrawable paramNewGifDrawable)
  {
    this.b = paramNewGifDrawable;
  }
  
  public abstract void doWork();
  
  public final void run()
  {
    try
    {
      if (!this.b.isRecycled()) {
        doWork();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Thread.UncaughtExceptionHandler localUncaughtExceptionHandler;
      do
      {
        localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
      } while (localUncaughtExceptionHandler == null);
      localUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pgd
 * JD-Core Version:    0.7.0.1
 */