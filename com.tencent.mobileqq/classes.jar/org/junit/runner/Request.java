package org.junit.runner;

import java.util.Comparator;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.internal.requests.ClassRequest;
import org.junit.internal.requests.FilterRequest;
import org.junit.internal.requests.SortingRequest;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.manipulation.Filter;
import org.junit.runners.model.InitializationError;

public abstract class Request
{
  public static Request aClass(Class<?> paramClass)
  {
    return new ClassRequest(paramClass);
  }
  
  public static Request classWithoutSuiteMethod(Class<?> paramClass)
  {
    return new ClassRequest(paramClass, false);
  }
  
  public static Request classes(Computer paramComputer, Class<?>... paramVarArgs)
  {
    try
    {
      paramComputer = runner(paramComputer.getSuite(new AllDefaultPossibilitiesBuilder(true), paramVarArgs));
      return paramComputer;
    }
    catch (InitializationError paramComputer)
    {
      label19:
      break label19;
    }
    throw new RuntimeException("Bug in saff's brain: Suite constructor, called as above, should always complete");
  }
  
  public static Request classes(Class<?>... paramVarArgs)
  {
    return classes(JUnitCore.defaultComputer(), paramVarArgs);
  }
  
  public static Request errorReport(Class<?> paramClass, Throwable paramThrowable)
  {
    return runner(new ErrorReportingRunner(paramClass, paramThrowable));
  }
  
  public static Request method(Class<?> paramClass, String paramString)
  {
    paramString = Description.createTestDescription(paramClass, paramString);
    return aClass(paramClass).filterWith(paramString);
  }
  
  public static Request runner(Runner paramRunner)
  {
    return new Request.1(paramRunner);
  }
  
  public Request filterWith(Description paramDescription)
  {
    return filterWith(Filter.matchMethodDescription(paramDescription));
  }
  
  public Request filterWith(Filter paramFilter)
  {
    return new FilterRequest(this, paramFilter);
  }
  
  public abstract Runner getRunner();
  
  public Request sortWith(Comparator<Description> paramComparator)
  {
    return new SortingRequest(this, paramComparator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.runner.Request
 * JD-Core Version:    0.7.0.1
 */