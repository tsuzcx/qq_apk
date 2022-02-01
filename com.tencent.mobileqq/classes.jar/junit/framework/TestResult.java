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
      return;
    }
    finally {}
    for (;;)
    {
      throw paramTest;
    }
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
      return;
    }
    finally {}
    for (;;)
    {
      throw paramTest;
    }
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
    catch (Throwable paramProtectable)
    {
      addError(paramTest, paramProtectable);
      return;
    }
    catch (ThreadDeath paramTest)
    {
      throw paramTest;
    }
    catch (AssertionFailedError paramProtectable)
    {
      addFailure(paramTest, paramProtectable);
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
      this.fRunTests += i;
      Iterator localIterator = cloneListeners().iterator();
      while (localIterator.hasNext()) {
        ((TestListener)localIterator.next()).startTest(paramTest);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramTest;
    }
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
  
  public boolean wasSuccessful()
  {
    try
    {
      if (failureCount() == 0)
      {
        int i = errorCount();
        if (i == 0)
        {
          bool = true;
          break label25;
        }
      }
      boolean bool = false;
      label25:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     junit.framework.TestResult
 * JD-Core Version:    0.7.0.1
 */