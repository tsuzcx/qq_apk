package org.junit.experimental.theories;

import org.junit.experimental.theories.internal.Assignments;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.model.Statement;

class Theories$TheoryAnchor$1$1
  extends Statement
{
  Theories$TheoryAnchor$1$1(Theories.TheoryAnchor.1 param1, Statement paramStatement) {}
  
  public void evaluate()
  {
    try
    {
      this.val$statement.evaluate();
      this.this$1.this$0.handleDataPointSuccess();
      return;
    }
    catch (AssumptionViolatedException localAssumptionViolatedException)
    {
      this.this$1.this$0.handleAssumptionViolation(localAssumptionViolatedException);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.this$1.this$0.reportParameterizedError(localThrowable, this.this$1.val$complete.getArgumentStrings(Theories.TheoryAnchor.access$000(this.this$1.this$0)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.experimental.theories.Theories.TheoryAnchor.1.1
 * JD-Core Version:    0.7.0.1
 */