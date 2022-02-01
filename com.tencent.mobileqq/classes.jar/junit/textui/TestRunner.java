package junit.textui;

import java.io.InputStream;
import java.io.PrintStream;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.runner.BaseTestRunner;
import junit.runner.Version;

public class TestRunner
  extends BaseTestRunner
{
  public static final int EXCEPTION_EXIT = 2;
  public static final int FAILURE_EXIT = 1;
  public static final int SUCCESS_EXIT = 0;
  private ResultPrinter fPrinter;
  
  public TestRunner()
  {
    this(System.out);
  }
  
  public TestRunner(PrintStream paramPrintStream)
  {
    this(new ResultPrinter(paramPrintStream));
  }
  
  public TestRunner(ResultPrinter paramResultPrinter)
  {
    this.fPrinter = paramResultPrinter;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    TestRunner localTestRunner = new TestRunner();
    try
    {
      if (!localTestRunner.start(paramArrayOfString).wasSuccessful()) {
        System.exit(1);
      }
      System.exit(0);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      System.err.println(paramArrayOfString.getMessage());
      System.exit(2);
    }
  }
  
  public static TestResult run(Test paramTest)
  {
    return new TestRunner().doRun(paramTest);
  }
  
  public static void run(Class<? extends TestCase> paramClass)
  {
    run(new TestSuite(paramClass));
  }
  
  public static void runAndWait(Test paramTest)
  {
    new TestRunner().doRun(paramTest, true);
  }
  
  protected TestResult createTestResult()
  {
    return new TestResult();
  }
  
  public TestResult doRun(Test paramTest)
  {
    return doRun(paramTest, false);
  }
  
  public TestResult doRun(Test paramTest, boolean paramBoolean)
  {
    TestResult localTestResult = createTestResult();
    localTestResult.addListener(this.fPrinter);
    long l1 = System.currentTimeMillis();
    paramTest.run(localTestResult);
    long l2 = System.currentTimeMillis();
    this.fPrinter.print(localTestResult, l2 - l1);
    pause(paramBoolean);
    return localTestResult;
  }
  
  protected void pause(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.fPrinter.printWaitPrompt();
    try
    {
      System.in.read();
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void runFailed(String paramString)
  {
    System.err.println(paramString);
    System.exit(1);
  }
  
  protected TestResult runSingleMethod(String paramString1, String paramString2, boolean paramBoolean)
  {
    return doRun(TestSuite.createTest(loadSuiteClass(paramString1).asSubclass(TestCase.class), paramString2), paramBoolean);
  }
  
  public void setPrinter(ResultPrinter paramResultPrinter)
  {
    this.fPrinter = paramResultPrinter;
  }
  
  public TestResult start(String[] paramArrayOfString)
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    int i = 0;
    boolean bool = false;
    while (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i].equals("-wait"))
      {
        bool = true;
      }
      else if (paramArrayOfString[i].equals("-c"))
      {
        i += 1;
        localObject1 = extractClassName(paramArrayOfString[i]);
      }
      else if (paramArrayOfString[i].equals("-m"))
      {
        i += 1;
        localObject2 = paramArrayOfString[i];
        int j = ((String)localObject2).lastIndexOf('.');
        localObject1 = ((String)localObject2).substring(0, j);
        localObject2 = ((String)localObject2).substring(j + 1);
      }
      else if (paramArrayOfString[i].equals("-v"))
      {
        PrintStream localPrintStream = System.err;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("JUnit ");
        localStringBuilder.append(Version.id());
        localStringBuilder.append(" by Kent Beck and Erich Gamma");
        localPrintStream.println(localStringBuilder.toString());
      }
      else
      {
        localObject1 = paramArrayOfString[i];
      }
      i += 1;
    }
    if (!((String)localObject1).equals("")) {
      try
      {
        if (!((String)localObject2).equals("")) {
          return runSingleMethod((String)localObject1, (String)localObject2, bool);
        }
        paramArrayOfString = doRun(getTest((String)localObject1), bool);
        return paramArrayOfString;
      }
      catch (Exception paramArrayOfString)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Could not create and run test suite: ");
        ((StringBuilder)localObject1).append(paramArrayOfString);
        throw new Exception(((StringBuilder)localObject1).toString());
      }
    }
    paramArrayOfString = new Exception("Usage: TestRunner [-wait] testCaseName, where name is the name of the TestCase class");
    for (;;)
    {
      throw paramArrayOfString;
    }
  }
  
  public void testEnded(String paramString) {}
  
  public void testFailed(int paramInt, Test paramTest, Throwable paramThrowable) {}
  
  public void testStarted(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     junit.textui.TestRunner
 * JD-Core Version:    0.7.0.1
 */