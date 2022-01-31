package org.junit.rules;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

class TestWatchman$1
  extends Statement
{
  TestWatchman$1(TestWatchman paramTestWatchman, FrameworkMethod paramFrameworkMethod, Statement paramStatement) {}
  
  /* Error */
  public void evaluate()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	org/junit/rules/TestWatchman$1:this$0	Lorg/junit/rules/TestWatchman;
    //   4: aload_0
    //   5: getfield 16	org/junit/rules/TestWatchman$1:val$method	Lorg/junit/runners/model/FrameworkMethod;
    //   8: invokevirtual 33	org/junit/rules/TestWatchman:starting	(Lorg/junit/runners/model/FrameworkMethod;)V
    //   11: aload_0
    //   12: getfield 18	org/junit/rules/TestWatchman$1:val$base	Lorg/junit/runners/model/Statement;
    //   15: invokevirtual 35	org/junit/runners/model/Statement:evaluate	()V
    //   18: aload_0
    //   19: getfield 14	org/junit/rules/TestWatchman$1:this$0	Lorg/junit/rules/TestWatchman;
    //   22: aload_0
    //   23: getfield 16	org/junit/rules/TestWatchman$1:val$method	Lorg/junit/runners/model/FrameworkMethod;
    //   26: invokevirtual 38	org/junit/rules/TestWatchman:succeeded	(Lorg/junit/runners/model/FrameworkMethod;)V
    //   29: aload_0
    //   30: getfield 14	org/junit/rules/TestWatchman$1:this$0	Lorg/junit/rules/TestWatchman;
    //   33: aload_0
    //   34: getfield 16	org/junit/rules/TestWatchman$1:val$method	Lorg/junit/runners/model/FrameworkMethod;
    //   37: invokevirtual 41	org/junit/rules/TestWatchman:finished	(Lorg/junit/runners/model/FrameworkMethod;)V
    //   40: return
    //   41: astore_1
    //   42: aload_1
    //   43: athrow
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 14	org/junit/rules/TestWatchman$1:this$0	Lorg/junit/rules/TestWatchman;
    //   49: aload_0
    //   50: getfield 16	org/junit/rules/TestWatchman$1:val$method	Lorg/junit/runners/model/FrameworkMethod;
    //   53: invokevirtual 41	org/junit/rules/TestWatchman:finished	(Lorg/junit/runners/model/FrameworkMethod;)V
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: aload_0
    //   60: getfield 14	org/junit/rules/TestWatchman$1:this$0	Lorg/junit/rules/TestWatchman;
    //   63: aload_1
    //   64: aload_0
    //   65: getfield 16	org/junit/rules/TestWatchman$1:val$method	Lorg/junit/runners/model/FrameworkMethod;
    //   68: invokevirtual 45	org/junit/rules/TestWatchman:failed	(Ljava/lang/Throwable;Lorg/junit/runners/model/FrameworkMethod;)V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	1
    //   41	2	1	localAssumptionViolatedException	org.junit.internal.AssumptionViolatedException
    //   44	13	1	localObject	java.lang.Object
    //   58	14	1	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   11	29	41	org/junit/internal/AssumptionViolatedException
    //   11	29	44	finally
    //   42	44	44	finally
    //   59	73	44	finally
    //   11	29	58	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.rules.TestWatchman.1
 * JD-Core Version:    0.7.0.1
 */