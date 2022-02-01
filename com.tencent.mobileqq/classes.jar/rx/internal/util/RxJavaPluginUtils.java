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
    PrintStream localPrintStream = System.err;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RxJavaErrorHandler threw an Exception. It shouldn't. => ");
    localStringBuilder.append(paramThrowable.getMessage());
    localPrintStream.println(localStringBuilder.toString());
    paramThrowable.printStackTrace();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.util.RxJavaPluginUtils
 * JD-Core Version:    0.7.0.1
 */