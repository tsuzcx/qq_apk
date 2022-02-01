package org.junit.experimental.theories;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.junit.experimental.theories.internal.Assignments;
import org.junit.experimental.theories.internal.ParameterizedAssertionError;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;

public class Theories$TheoryAnchor
  extends Statement
{
  private List<AssumptionViolatedException> fInvalidParameters = new ArrayList();
  private int successes = 0;
  private final TestClass testClass;
  private final FrameworkMethod testMethod;
  
  public Theories$TheoryAnchor(FrameworkMethod paramFrameworkMethod, TestClass paramTestClass)
  {
    this.testMethod = paramFrameworkMethod;
    this.testClass = paramTestClass;
  }
  
  private TestClass getTestClass()
  {
    return this.testClass;
  }
  
  private Statement methodCompletesWithParameters(FrameworkMethod paramFrameworkMethod, Assignments paramAssignments, Object paramObject)
  {
    return new Theories.TheoryAnchor.2(this, paramAssignments, paramFrameworkMethod, paramObject);
  }
  
  private boolean nullsOk()
  {
    Theory localTheory = (Theory)this.testMethod.getMethod().getAnnotation(Theory.class);
    if (localTheory == null) {
      return false;
    }
    return localTheory.nullsAccepted();
  }
  
  public void evaluate()
  {
    runWithAssignment(Assignments.allUnassigned(this.testMethod.getMethod(), getTestClass()));
    if (this.testMethod.getAnnotation(Theory.class) != null) {}
    for (int i = 1;; i = 0)
    {
      if ((this.successes == 0) && (i != 0)) {
        Assert.fail("Never found parameters that satisfied method assumptions.  Violated assumptions: " + this.fInvalidParameters);
      }
      return;
    }
  }
  
  protected void handleAssumptionViolation(AssumptionViolatedException paramAssumptionViolatedException)
  {
    this.fInvalidParameters.add(paramAssumptionViolatedException);
  }
  
  protected void handleDataPointSuccess()
  {
    this.successes += 1;
  }
  
  protected void reportParameterizedError(Throwable paramThrowable, Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      throw paramThrowable;
    }
    throw new ParameterizedAssertionError(paramThrowable, this.testMethod.getName(), paramVarArgs);
  }
  
  protected void runWithAssignment(Assignments paramAssignments)
  {
    if (!paramAssignments.isComplete())
    {
      runWithIncompleteAssignment(paramAssignments);
      return;
    }
    runWithCompleteAssignment(paramAssignments);
  }
  
  protected void runWithCompleteAssignment(Assignments paramAssignments)
  {
    new Theories.TheoryAnchor.1(this, getTestClass().getJavaClass(), paramAssignments).methodBlock(this.testMethod).evaluate();
  }
  
  protected void runWithIncompleteAssignment(Assignments paramAssignments)
  {
    Iterator localIterator = paramAssignments.potentialsForNextUnassigned().iterator();
    while (localIterator.hasNext()) {
      runWithAssignment(paramAssignments.assignNext((PotentialAssignment)localIterator.next()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.experimental.theories.Theories.TheoryAnchor
 * JD-Core Version:    0.7.0.1
 */