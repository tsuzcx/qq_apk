package org.junit.runner;

import java.io.PrintStream;
import junit.framework.Test;
import junit.runner.Version;
import org.junit.internal.JUnitSystem;
import org.junit.internal.RealSystem;
import org.junit.internal.TextListener;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

public class JUnitCore
{
  private final RunNotifier notifier = new RunNotifier();
  
  static Computer defaultComputer()
  {
    return new Computer();
  }
  
  public static void main(String... paramVarArgs)
  {
    if (new JUnitCore().runMain(new RealSystem(), paramVarArgs).wasSuccessful()) {}
    for (int i = 0;; i = 1)
    {
      System.exit(i);
      return;
    }
  }
  
  public static Result runClasses(Computer paramComputer, Class<?>... paramVarArgs)
  {
    return new JUnitCore().run(paramComputer, paramVarArgs);
  }
  
  public static Result runClasses(Class<?>... paramVarArgs)
  {
    return runClasses(defaultComputer(), paramVarArgs);
  }
  
  public void addListener(RunListener paramRunListener)
  {
    this.notifier.addListener(paramRunListener);
  }
  
  public String getVersion()
  {
    return Version.id();
  }
  
  public void removeListener(RunListener paramRunListener)
  {
    this.notifier.removeListener(paramRunListener);
  }
  
  public Result run(Test paramTest)
  {
    return run(new JUnit38ClassRunner(paramTest));
  }
  
  public Result run(Computer paramComputer, Class<?>... paramVarArgs)
  {
    return run(Request.classes(paramComputer, paramVarArgs));
  }
  
  public Result run(Request paramRequest)
  {
    return run(paramRequest.getRunner());
  }
  
  public Result run(Runner paramRunner)
  {
    Result localResult = new Result();
    RunListener localRunListener = localResult.createListener();
    this.notifier.addFirstListener(localRunListener);
    try
    {
      this.notifier.fireTestRunStarted(paramRunner.getDescription());
      paramRunner.run(this.notifier);
      this.notifier.fireTestRunFinished(localResult);
      return localResult;
    }
    finally
    {
      removeListener(localRunListener);
    }
  }
  
  public Result run(Class<?>... paramVarArgs)
  {
    return run(defaultComputer(), paramVarArgs);
  }
  
  Result runMain(JUnitSystem paramJUnitSystem, String... paramVarArgs)
  {
    paramJUnitSystem.out().println("JUnit version " + Version.id());
    paramVarArgs = JUnitCommandLineParseResult.parse(paramVarArgs);
    addListener(new TextListener(paramJUnitSystem));
    return run(paramVarArgs.createRequest(defaultComputer()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.runner.JUnitCore
 * JD-Core Version:    0.7.0.1
 */