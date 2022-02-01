package rx.plugins;

import rx.annotations.Beta;
import rx.exceptions.Exceptions;

public abstract class RxJavaErrorHandler
{
  protected static final String ERROR_IN_RENDERING_SUFFIX = ".errorRendering";
  
  public void handleError(Throwable paramThrowable) {}
  
  @Beta
  public final String handleOnNextValueRendering(Object paramObject)
  {
    try
    {
      String str = render(paramObject);
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      return paramObject.getClass().getName() + ".errorRendering";
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Exceptions.throwIfFatal(localThrowable);
      }
    }
  }
  
  @Beta
  protected String render(Object paramObject)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.plugins.RxJavaErrorHandler
 * JD-Core Version:    0.7.0.1
 */