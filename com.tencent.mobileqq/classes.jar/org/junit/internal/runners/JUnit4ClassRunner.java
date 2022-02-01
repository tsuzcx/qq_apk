package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

@Deprecated
public class JUnit4ClassRunner
  extends Runner
  implements Filterable, Sortable
{
  private TestClass testClass;
  private final List<Method> testMethods;
  
  public JUnit4ClassRunner(Class<?> paramClass)
  {
    this.testClass = new TestClass(paramClass);
    this.testMethods = getTestMethods();
    validate();
  }
  
  private void testAborted(RunNotifier paramRunNotifier, Description paramDescription, Throwable paramThrowable)
  {
    paramRunNotifier.fireTestStarted(paramDescription);
    paramRunNotifier.fireTestFailure(new Failure(paramDescription, paramThrowable));
    paramRunNotifier.fireTestFinished(paramDescription);
  }
  
  protected Annotation[] classAnnotations()
  {
    return this.testClass.getJavaClass().getAnnotations();
  }
  
  protected Object createTest()
  {
    return getTestClass().getConstructor().newInstance(new Object[0]);
  }
  
  public void filter(Filter paramFilter)
  {
    Iterator localIterator = this.testMethods.iterator();
    while (localIterator.hasNext()) {
      if (!paramFilter.shouldRun(methodDescription((Method)localIterator.next()))) {
        localIterator.remove();
      }
    }
    if (!this.testMethods.isEmpty()) {
      return;
    }
    paramFilter = new NoTestsRemainException();
    for (;;)
    {
      throw paramFilter;
    }
  }
  
  public Description getDescription()
  {
    Description localDescription = Description.createSuiteDescription(getName(), classAnnotations());
    Iterator localIterator = this.testMethods.iterator();
    while (localIterator.hasNext()) {
      localDescription.addChild(methodDescription((Method)localIterator.next()));
    }
    return localDescription;
  }
  
  protected String getName()
  {
    return getTestClass().getName();
  }
  
  protected TestClass getTestClass()
  {
    return this.testClass;
  }
  
  protected List<Method> getTestMethods()
  {
    return this.testClass.getTestMethods();
  }
  
  protected void invokeTestMethod(Method paramMethod, RunNotifier paramRunNotifier)
  {
    Description localDescription = methodDescription(paramMethod);
    try
    {
      Object localObject = createTest();
      new MethodRoadie(localObject, wrapMethod(paramMethod), paramRunNotifier, localDescription).run();
      return;
    }
    catch (Exception paramMethod)
    {
      testAborted(paramRunNotifier, localDescription, paramMethod);
      return;
    }
    catch (InvocationTargetException paramMethod)
    {
      testAborted(paramRunNotifier, localDescription, paramMethod.getCause());
    }
  }
  
  protected Description methodDescription(Method paramMethod)
  {
    return Description.createTestDescription(getTestClass().getJavaClass(), testName(paramMethod), testAnnotations(paramMethod));
  }
  
  public void run(RunNotifier paramRunNotifier)
  {
    new ClassRoadie(paramRunNotifier, this.testClass, getDescription(), new JUnit4ClassRunner.1(this, paramRunNotifier)).runProtected();
  }
  
  protected void runMethods(RunNotifier paramRunNotifier)
  {
    Iterator localIterator = this.testMethods.iterator();
    while (localIterator.hasNext()) {
      invokeTestMethod((Method)localIterator.next(), paramRunNotifier);
    }
  }
  
  public void sort(Sorter paramSorter)
  {
    Collections.sort(this.testMethods, new JUnit4ClassRunner.2(this, paramSorter));
  }
  
  protected Annotation[] testAnnotations(Method paramMethod)
  {
    return paramMethod.getAnnotations();
  }
  
  protected String testName(Method paramMethod)
  {
    return paramMethod.getName();
  }
  
  protected void validate()
  {
    MethodValidator localMethodValidator = new MethodValidator(this.testClass);
    localMethodValidator.validateMethodsForDefaultRunner();
    localMethodValidator.assertValid();
  }
  
  protected TestMethod wrapMethod(Method paramMethod)
  {
    return new TestMethod(paramMethod, this.testClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.internal.runners.JUnit4ClassRunner
 * JD-Core Version:    0.7.0.1
 */