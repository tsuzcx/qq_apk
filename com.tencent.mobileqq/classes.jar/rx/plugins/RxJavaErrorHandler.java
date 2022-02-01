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
    catch (Throwable localThrowable)
    {
      Exceptions.throwIfFatal(localThrowable);
      break label22;
      Thread.currentThread().interrupt();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramObject.getClass().getName());
      localStringBuilder.append(".errorRendering");
      return localStringBuilder.toString();
    }
    catch (InterruptedException localInterruptedException)
    {
      label16:
      label22:
      break label16;
    }
  }
  
  @Beta
  protected String render(Object paramObject)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.plugins.RxJavaErrorHandler
 * JD-Core Version:    0.7.0.1
 */