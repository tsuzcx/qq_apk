package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import junit.extensions.TestDecorator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.runner.Describable;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.RunNotifier;

public class JUnit38ClassRunner
  extends Runner
  implements Filterable, Sortable
{
  private volatile Test test;
  
  public JUnit38ClassRunner(Class<?> paramClass)
  {
    this(new TestSuite(paramClass.asSubclass(TestCase.class)));
  }
  
  public JUnit38ClassRunner(Test paramTest)
  {
    setTest(paramTest);
  }
  
  private static String createSuiteDescription(TestSuite paramTestSuite)
  {
    int i = paramTestSuite.countTestCases();
    if (i == 0) {
      paramTestSuite = "";
    } else {
      paramTestSuite = String.format(" [example: %s]", new Object[] { paramTestSuite.testAt(0) });
    }
    return String.format("TestSuite with %s tests%s", new Object[] { Integer.valueOf(i), paramTestSuite });
  }
  
  private static Annotation[] getAnnotations(TestCase paramTestCase)
  {
    try
    {
      paramTestCase = paramTestCase.getClass().getMethod(paramTestCase.getName(), new Class[0]).getDeclaredAnnotations();
      return paramTestCase;
    }
    catch (SecurityException|NoSuchMethodException paramTestCase)
    {
      label21:
      break label21;
    }
    return new Annotation[0];
  }
  
  private Test getTest()
  {
    return this.test;
  }
  
  private static Description makeDescription(Test paramTest)
  {
    if ((paramTest instanceof TestCase))
    {
      paramTest = (TestCase)paramTest;
      return Description.createTestDescription(paramTest.getClass(), paramTest.getName(), getAnnotations(paramTest));
    }
    if ((paramTest instanceof TestSuite))
    {
      TestSuite localTestSuite = (TestSuite)paramTest;
      if (localTestSuite.getName() == null) {
        paramTest = createSuiteDescription(localTestSuite);
      } else {
        paramTest = localTestSuite.getName();
      }
      int i = 0;
      paramTest = Description.createSuiteDescription(paramTest, new Annotation[0]);
      int j = localTestSuite.testCount();
      while (i < j)
      {
        paramTest.addChild(makeDescription(localTestSuite.testAt(i)));
        i += 1;
      }
      return paramTest;
    }
    if ((paramTest instanceof Describable)) {
      return ((Describable)paramTest).getDescription();
    }
    if ((paramTest instanceof TestDecorator)) {
      return makeDescription(((TestDecorator)paramTest).getTest());
    }
    return Description.createSuiteDescription(paramTest.getClass());
  }
  
  private void setTest(Test paramTest)
  {
    this.test = paramTest;
  }
  
  public TestListener createAdaptingListener(RunNotifier paramRunNotifier)
  {
    return new JUnit38ClassRunner.OldTestClassAdaptingListener(paramRunNotifier, null);
  }
  
  public void filter(Filter paramFilter)
  {
    if ((getTest() instanceof Filterable))
    {
      ((Filterable)getTest()).filter(paramFilter);
      return;
    }
    if ((getTest() instanceof TestSuite))
    {
      TestSuite localTestSuite1 = (TestSuite)getTest();
      TestSuite localTestSuite2 = new TestSuite(localTestSuite1.getName());
      int j = localTestSuite1.testCount();
      int i = 0;
      while (i < j)
      {
        Test localTest = localTestSuite1.testAt(i);
        if (paramFilter.shouldRun(makeDescription(localTest))) {
          localTestSuite2.addTest(localTest);
        }
        i += 1;
      }
      setTest(localTestSuite2);
      if (localTestSuite2.testCount() != 0) {
        return;
      }
      throw new NoTestsRemainException();
    }
  }
  
  public Description getDescription()
  {
    return makeDescription(getTest());
  }
  
  public void run(RunNotifier paramRunNotifier)
  {
    TestResult localTestResult = new TestResult();
    localTestResult.addListener(createAdaptingListener(paramRunNotifier));
    getTest().run(localTestResult);
  }
  
  public void sort(Sorter paramSorter)
  {
    if ((getTest() instanceof Sortable)) {
      ((Sortable)getTest()).sort(paramSorter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.internal.runners.JUnit38ClassRunner
 * JD-Core Version:    0.7.0.1
 */