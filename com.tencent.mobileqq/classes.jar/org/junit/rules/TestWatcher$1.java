package org.junit.rules;

import java.util.ArrayList;
import java.util.List;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;

class TestWatcher$1
  extends Statement
{
  TestWatcher$1(TestWatcher paramTestWatcher, Description paramDescription, Statement paramStatement) {}
  
  public void evaluate()
  {
    localArrayList = new ArrayList();
    TestWatcher.access$000(this.this$0, this.val$description, localArrayList);
    try
    {
      this.val$base.evaluate();
      TestWatcher.access$100(this.this$0, this.val$description, localArrayList);
    }
    catch (AssumptionViolatedException localAssumptionViolatedException)
    {
      for (;;)
      {
        localArrayList.add(localAssumptionViolatedException);
        TestWatcher.access$200(this.this$0, localAssumptionViolatedException, this.val$description, localArrayList);
        TestWatcher.access$400(this.this$0, this.val$description, localArrayList);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localArrayList.add(localThrowable);
        TestWatcher.access$300(this.this$0, localThrowable, this.val$description, localArrayList);
        TestWatcher.access$400(this.this$0, this.val$description, localArrayList);
      }
    }
    finally
    {
      TestWatcher.access$400(this.this$0, this.val$description, localArrayList);
    }
    MultipleFailureException.assertEmpty(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.rules.TestWatcher.1
 * JD-Core Version:    0.7.0.1
 */