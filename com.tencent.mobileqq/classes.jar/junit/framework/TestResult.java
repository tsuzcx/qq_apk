package junit.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class TestResult
{
  protected List<TestFailure> fErrors = new ArrayList();
  protected List<TestFailure> fFailures = new ArrayList();
  protected List<TestListener> fListeners = new ArrayList();
  protected int fRunTests = 0;
  private boolean fStop = false;
  
  private List<TestListener> cloneListeners()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.fListeners);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void addError(Test paramTest, Throwable paramThrowable)
  {
    try
    {
      this.fErrors.add(new TestFailure(paramTest, paramThrowable));
      Iterator localIterator = cloneListeners().iterator();
      while (localIterator.hasNext()) {
        ((TestListener)localIterator.next()).addError(paramTest, paramThrowable);
      }
    }
    finally {}
  }
  
  public void addFailure(Test paramTest, AssertionFailedError paramAssertionFailedError)
  {
    try
    {
      this.fFailures.add(new TestFailure(paramTest, paramAssertionFailedError));
      Iterator localIterator = cloneListeners().iterator();
      while (localIterator.hasNext()) {
        ((TestListener)localIterator.next()).addFailure(paramTest, paramAssertionFailedError);
      }
    }
    finally {}
  }
  
  public void addListener(TestListener paramTestListener)
  {
    try
    {
      this.fListeners.add(paramTestListener);
      return;
    }
    finally
    {
      paramTestListener = finally;
      throw paramTestListener;
    }
  }
  
  public void endTest(Test paramTest)
  {
    Iterator localIterator = cloneListeners().iterator();
    while (localIterator.hasNext()) {
      ((TestListener)localIterator.next()).endTest(paramTest);
    }
  }
  
  public int errorCount()
  {
    try
    {
      int i = this.fErrors.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Enumeration<TestFailure> errors()
  {
    try
    {
      Enumeration localEnumeration = Collections.enumeration(this.fErrors);
      return localEnumeration;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int failureCount()
  {
    try
    {
      int i = this.fFailures.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Enumeration<TestFailure> failures()
  {
    try
    {
      Enumeration localEnumeration = Collections.enumeration(this.fFailures);
      return localEnumeration;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void removeListener(TestListener paramTestListener)
  {
    try
    {
      this.fListeners.remove(paramTestListener);
      return;
    }
    finally
    {
      paramTestListener = finally;
      throw paramTestListener;
    }
  }
  
  protected void run(TestCase paramTestCase)
  {
    startTest(paramTestCase);
    runProtected(paramTestCase, new TestResult.1(this, paramTestCase));
    endTest(paramTestCase);
  }
  
  public int runCount()
  {
    try
    {
      int i = this.fRunTests;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void runProtected(Test paramTest, Protectable paramProtectable)
  {
    try
    {
      paramProtectable.protect();
      return;
    }
    catch (AssertionFailedError paramProtectable)
    {
      addFailure(paramTest, paramProtectable);
      return;
    }
    catch (ThreadDeath paramTest)
    {
      throw paramTest;
    }
    catch (Throwable paramProtectable)
    {
      addError(paramTest, paramProtectable);
    }
  }
  
  public boolean shouldStop()
  {
    try
    {
      boolean bool = this.fStop;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void startTest(Test paramTest)
  {
    int i = paramTest.countTestCases();
    try
    {
      this.fRunTests = (i + this.fRunTests);
      Iterator localIterator = cloneListeners().iterator();
      while (localIterator.hasNext()) {
        ((TestListener)localIterator.next()).startTest(paramTest);
      }
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    try
    {
      this.fStop = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean wasSuccessful()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 142	junit/framework/TestResult:failureCount	()I
    //   6: ifne +18 -> 24
    //   9: aload_0
    //   10: invokevirtual 144	junit/framework/TestResult:errorCount	()I
    //   13: istore_1
    //   14: iload_1
    //   15: ifne +9 -> 24
    //   18: iconst_1
    //   19: istore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_2
    //   23: ireturn
    //   24: iconst_0
    //   25: istore_2
    //   26: goto -6 -> 20
    //   29: astore_3
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_3
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	TestResult
    //   13	2	1	i	int
    //   19	7	2	bool	boolean
    //   29	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     junit.framework.TestResult
 * JD-Core Version:    0.7.0.1
 */