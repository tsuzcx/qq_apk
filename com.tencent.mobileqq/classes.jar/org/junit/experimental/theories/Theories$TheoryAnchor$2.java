package org.junit.experimental.theories;

import org.junit.Assume;
import org.junit.experimental.theories.internal.Assignments;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

class Theories$TheoryAnchor$2
  extends Statement
{
  Theories$TheoryAnchor$2(Theories.TheoryAnchor paramTheoryAnchor, Assignments paramAssignments, FrameworkMethod paramFrameworkMethod, Object paramObject) {}
  
  public void evaluate()
  {
    Object[] arrayOfObject = this.val$complete.getMethodArguments();
    if (!Theories.TheoryAnchor.access$000(this.this$0)) {
      Assume.assumeNotNull(arrayOfObject);
    }
    this.val$method.invokeExplosively(this.val$freshInstance, arrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.experimental.theories.Theories.TheoryAnchor.2
 * JD-Core Version:    0.7.0.1
 */