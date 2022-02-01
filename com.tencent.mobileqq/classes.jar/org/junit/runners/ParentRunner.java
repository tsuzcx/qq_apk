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
    if (this.filteredChildren == null) {
      synchronized (this.childrenLock)
      {
        if (this.filteredChildren == null) {
          this.filteredChildren = Collections.unmodifiableCollection(getChildren());
        }
      }
    }
    return this.filteredChildren;
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
      localRunnerScheduler.finished();
      return;
    }
    finally
    {
      localRunnerScheduler.finished();
    }
    for (;;)
    {
      throw paramRunNotifier;
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
    if (localArrayList.isEmpty()) {
      return;
    }
    throw new InitializationError(localArrayList);
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
    synchronized (this.childrenLock)
    {
      ArrayList localArrayList = new ArrayList(getFilteredChildren());
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        boolean bool = shouldRun(paramFilter, localObject2);
        if (bool) {}
        try
        {
          paramFilter.apply(localObject2);
        }
        catch (NoTestsRemainException localNoTestsRemainException)
        {
          label69:
          break label69;
        }
        localIterator.remove();
        continue;
        localIterator.remove();
      }
      this.filteredChildren = Collections.unmodifiableCollection(localArrayList);
      if (!this.filteredChildren.isEmpty()) {
        return;
      }
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
    catch (Throwable paramRunNotifier)
    {
      localEachTestNotifier.addFailure(paramRunNotifier);
      return;
    }
    catch (StoppedByUserException paramRunNotifier)
    {
      throw paramRunNotifier;
    }
    catch (AssumptionViolatedException paramRunNotifier)
    {
      localEachTestNotifier.addFailedAssumption(paramRunNotifier);
    }
  }
  
  protected abstract void runChild(T paramT, RunNotifier paramRunNotifier);
  
  /* Error */
  protected final void runLeaf(Statement paramStatement, Description paramDescription, RunNotifier paramRunNotifier)
  {
    // Byte code:
    //   0: new 305	org/junit/internal/runners/model/EachTestNotifier
    //   3: dup
    //   4: aload_3
    //   5: aload_2
    //   6: invokespecial 308	org/junit/internal/runners/model/EachTestNotifier:<init>	(Lorg/junit/runner/notification/RunNotifier;Lorg/junit/runner/Description;)V
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 330	org/junit/internal/runners/model/EachTestNotifier:fireTestStarted	()V
    //   14: aload_1
    //   15: invokevirtual 315	org/junit/runners/model/Statement:evaluate	()V
    //   18: aload_2
    //   19: invokevirtual 333	org/junit/internal/runners/model/EachTestNotifier:fireTestFinished	()V
    //   22: return
    //   23: astore_1
    //   24: goto +21 -> 45
    //   27: astore_1
    //   28: aload_2
    //   29: aload_1
    //   30: invokevirtual 319	org/junit/internal/runners/model/EachTestNotifier:addFailure	(Ljava/lang/Throwable;)V
    //   33: goto -15 -> 18
    //   36: astore_1
    //   37: aload_2
    //   38: aload_1
    //   39: invokevirtual 323	org/junit/internal/runners/model/EachTestNotifier:addFailedAssumption	(Lorg/junit/internal/AssumptionViolatedException;)V
    //   42: goto -24 -> 18
    //   45: aload_2
    //   46: invokevirtual 333	org/junit/internal/runners/model/EachTestNotifier:fireTestFinished	()V
    //   49: goto +5 -> 54
    //   52: aload_1
    //   53: athrow
    //   54: goto -2 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	ParentRunner
    //   0	57	1	paramStatement	Statement
    //   0	57	2	paramDescription	Description
    //   0	57	3	paramRunNotifier	RunNotifier
    // Exception table:
    //   from	to	target	type
    //   14	18	23	finally
    //   28	33	23	finally
    //   37	42	23	finally
    //   14	18	27	java/lang/Throwable
    //   14	18	36	org/junit/internal/AssumptionViolatedException
  }
  
  public void setScheduler(RunnerScheduler paramRunnerScheduler)
  {
    this.scheduler = paramRunnerScheduler;
  }
  
  public void sort(Sorter paramSorter)
  {
    synchronized (this.childrenLock)
    {
      Object localObject2 = getFilteredChildren().iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramSorter.apply(((Iterator)localObject2).next());
      }
      localObject2 = new ArrayList(getFilteredChildren());
      Collections.sort((List)localObject2, comparator(paramSorter));
      this.filteredChildren = Collections.unmodifiableCollection((Collection)localObject2);
      return;
    }
    for (;;)
    {
      throw paramSorter;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.runners.ParentRunner
 * JD-Core Version:    0.7.0.1
 */