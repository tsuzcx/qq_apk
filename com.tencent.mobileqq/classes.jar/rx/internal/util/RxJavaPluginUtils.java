package rx.internal.util;

import java.io.PrintStream;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

public final class RxJavaPluginUtils
{
  public static void handleException(Throwable paramThrowable)
  {
    try
    {
      RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
      return;
    }
    catch (Throwable paramThrowable)
    {
      handlePluginException(paramThrowable);
    }
  }
  
  private static void handlePluginException(Throwable paramThrowable)
  {
    System.err.println("RxJavaErrorHandler threw an Exception. It shouldn't. => " + paramThrowable.getMessage());
    paramThrowable.printStackTrace();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.util.RxJavaPluginUtils
 * JD-Core Version:    0.7.0.1
 */