package org.junit.runners;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.internal.runners.rules.RuleMemberValidator;
import org.junit.internal.runners.statements.RunAfters;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.rules.RunRules;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerScheduler;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;
import org.junit.validator.AnnotationsValidator;
import org.junit.validator.PublicClassValidator;
import org.junit.validator.TestClassValidator;

public abstract class ParentRunner<T>
  extends Runner
  implements Filterable, Sortable
{
  private static final List<TestClassValidator> VALIDATORS = Arrays.asList(new TestClassValidator[] { new AnnotationsValidator(), new PublicClassValidator() });
  private final Object childrenLock = new Object();
  private volatile Collection<T> filteredChildren = null;
  private volatile RunnerScheduler scheduler = new ParentRunner.1(this);
  private final TestClass testClass = createTestClass(paramClass);
  
  protected ParentRunner(Class<?> paramClass)
  {
    validate();
  }
  
  private void applyValidators(List<Throwable> paramList)
  {
    if (getTestClass().getJavaClass() != null)
    {
      Iterator localIterator = VALIDATORS.iterator();
      while (localIterator.hasNext()) {
        paramList.addAll(((TestClassValidator)localIterator.next()).validateTestClass(getTestClass()));
      }
    }
  }
  
  private boolean areAllChildrenIgnored()
  {
    Iterator localIterator = getFilteredChildren().iterator();
    while (localIterator.hasNext()) {
      if (!isIgnored(localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  private Comparator<? super T> comparator(Sorter paramSorter)
  {
    return new ParentRunner.4(this, paramSorter);
  }
  
  private Collection<T> getFilteredChildren()
  {
    if (this.filteredChildren == null) {}
    synchronized (this.childrenLock)
    {
      if (this.filteredChildren == null) {
        this.filteredChildren = Collections.unmodifiableCollection(getChildren());
      }
      return this.filteredChildren;
    }
  }
  
  private void runChildren(RunNotifier paramRunNotifier)
  {
    RunnerScheduler localRunnerScheduler = this.scheduler;
    try
    {
      Iterator localIterator = getFilteredChildren().iterator();
      while (localIterator.hasNext()) {
        localRunnerScheduler.schedule(new ParentRunner.3(this, localIterator.next(), paramRunNotifier));
      }
    }
    finally
    {
      localRunnerScheduler.finished();
    }
  }
  
  private boolean shouldRun(Filter paramFilter, T paramT)
  {
    return paramFilter.shouldRun(describeChild(paramT));
  }
  
  private void validate()
  {
    ArrayList localArrayList = new ArrayList();
    collectInitializationErrors(localArrayList);
    if (!localArrayList.isEmpty()) {
      throw new InitializationError(localArrayList);
    }
  }
  
  private void validateClassRules(List<Throwable> paramList)
  {
    RuleMemberValidator.CLASS_RULE_VALIDATOR.validate(getTestClass(), paramList);
    RuleMemberValidator.CLASS_RULE_METHOD_VALIDATOR.validate(getTestClass(), paramList);
  }
  
  private Statement withClassRules(Statement paramStatement)
  {
    List localList = classRules();
    if (localList.isEmpty()) {
      return paramStatement;
    }
    return new RunRules(paramStatement, localList, getDescription());
  }
  
  protected Statement childrenInvoker(RunNotifier paramRunNotifier)
  {
    return new ParentRunner.2(this, paramRunNotifier);
  }
  
  protected Statement classBlock(RunNotifier paramRunNotifier)
  {
    Statement localStatement = childrenInvoker(paramRunNotifier);
    paramRunNotifier = localStatement;
    if (!areAllChildrenIgnored()) {
      paramRunNotifier = withClassRules(withAfterClasses(withBeforeClasses(localStatement)));
    }
    return paramRunNotifier;
  }
  
  protected List<TestRule> classRules()
  {
    List localList = this.testClass.getAnnotatedMethodValues(null, ClassRule.class, TestRule.class);
    localList.addAll(this.testClass.getAnnotatedFieldValues(null, ClassRule.class, TestRule.class));
    return localList;
  }
  
  protected void collectInitializationErrors(List<Throwable> paramList)
  {
    validatePublicVoidNoArgMethods(BeforeClass.class, true, paramList);
    validatePublicVoidNoArgMethods(AfterClass.class, true, paramList);
    validateClassRules(paramList);
    applyValidators(paramList);
  }
  
  protected TestClass createTestClass(Class<?> paramClass)
  {
    return new TestClass(paramClass);
  }
  
  protected abstract Description describeChild(T paramT);
  
  public void filter(Filter paramFilter)
  {
    ArrayList localArrayList;
    for (;;)
    {
      Iterator localIterator;
      synchronized (this.childrenLock)
      {
        localArrayList = new ArrayList(getFilteredChildren());
        localIterator = localArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = localIterator.next();
        boolean bool = shouldRun(paramFilter, localObject2);
        if (bool) {
          try
          {
            paramFilter.apply(localObject2);
          }
          catch (NoTestsRemainException localNoTestsRemainException)
          {
            localIterator.remove();
          }
        }
      }
      localIterator.remove();
    }
    this.filteredChildren = Collections.unmodifiableCollection(localArrayList);
    if (this.filteredChildren.isEmpty()) {
      throw new NoTestsRemainException();
    }
  }
  
  protected abstract List<T> getChildren();
  
  public Description getDescription()
  {
    Description localDescription = Description.createSuiteDescription(getName(), getRunnerAnnotations());
    Iterator localIterator = getFilteredChildren().iterator();
    while (localIterator.hasNext()) {
      localDescription.addChild(describeChild(localIterator.next()));
    }
    return localDescription;
  }
  
  protected String getName()
  {
    return this.testClass.getName();
  }
  
  protected Annotation[] getRunnerAnnotations()
  {
    return this.testClass.getAnnotations();
  }
  
  public final TestClass getTestClass()
  {
    return this.testClass;
  }
  
  protected boolean isIgnored(T paramT)
  {
    return false;
  }
  
  public void run(RunNotifier paramRunNotifier)
  {
    EachTestNotifier localEachTestNotifier = new EachTestNotifier(paramRunNotifier, getDescription());
    try
    {
      classBlock(paramRunNotifier).evaluate();
      return;
    }
    catch (AssumptionViolatedException paramRunNotifier)
    {
      localEachTestNotifier.addFailedAssumption(paramRunNotifier);
      return;
    }
    catch (StoppedByUserException paramRunNotifier)
    {
      throw paramRunNotifier;
    }
    catch (Throwable paramRunNotifier)
    {
      localEachTestNotifier.addFailure(paramRunNotifier);
    }
  }
  
  protected abstract void runChild(T paramT, RunNotifier paramRunNotifier);
  
  protected final void runLeaf(Statement paramStatement, Description paramDescription, RunNotifier paramRunNotifier)
  {
    paramDescription = new EachTestNotifier(paramRunNotifier, paramDescription);
    paramDescription.fireTestStarted();
    try
    {
      paramStatement.evaluate();
      return;
    }
    catch (AssumptionViolatedException paramStatement)
    {
      paramDescription.addFailedAssumption(paramStatement);
      return;
    }
    catch (Throwable paramStatement)
    {
      paramDescription.addFailure(paramStatement);
      return;
    }
    finally
    {
      paramDescription.fireTestFinished();
    }
  }
  
  public void setScheduler(RunnerScheduler paramRunnerScheduler)
  {
    this.scheduler = paramRunnerScheduler;
  }
  
  public void sort(Sorter paramSorter)
  {
    synchronized (this.childrenLock)
    {
      localObject2 = getFilteredChildren().iterator();
      if (((Iterator)localObject2).hasNext()) {
        paramSorter.apply(((Iterator)localObject2).next());
      }
    }
    Object localObject2 = new ArrayList(getFilteredChildren());
    Collections.sort((List)localObject2, comparator(paramSorter));
    this.filteredChildren = Collections.unmodifiableCollection((Collection)localObject2);
  }
  
  protected void validatePublicVoidNoArgMethods(Class<? extends Annotation> paramClass, boolean paramBoolean, List<Throwable> paramList)
  {
    paramClass = getTestClass().getAnnotatedMethods(paramClass).iterator();
    while (paramClass.hasNext()) {
      ((FrameworkMethod)paramClass.next()).validatePublicVoidNoArg(paramBoolean, paramList);
    }
  }
  
  protected Statement withAfterClasses(Statement paramStatement)
  {
    List localList = this.testClass.getAnnotatedMethods(AfterClass.class);
    if (localList.isEmpty()) {
      return paramStatement;
    }
    return new RunAfters(paramStatement, localList, null);
  }
  
  protected Statement withBeforeClasses(Statement paramStatement)
  {
    List localList = this.testClass.getAnnotatedMethods(BeforeClass.class);
    if (localList.isEmpty()) {
      return paramStatement;
    }
    return new RunBefores(paramStatement, localList, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.runners.ParentRunner
 * JD-Core Version:    0.7.0.1
 */