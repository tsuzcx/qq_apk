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
    //   42: goto +21 -> 63
    //   45: astore_1
    //   46: aload_0
    //   47: getfield 14	org/junit/rules/TestWatchman$1:this$0	Lorg/junit/rules/TestWatchman;
    //   50: aload_1
    //   51: aload_0
    //   52: getfield 16	org/junit/rules/TestWatchman$1:val$method	Lorg/junit/runners/model/FrameworkMethod;
    //   55: invokevirtual 45	org/junit/rules/TestWatchman:failed	(Ljava/lang/Throwable;Lorg/junit/runners/model/FrameworkMethod;)V
    //   58: aload_1
    //   59: athrow
    //   60: astore_1
    //   61: aload_1
    //   62: athrow
    //   63: aload_0
    //   64: getfield 14	org/junit/rules/TestWatchman$1:this$0	Lorg/junit/rules/TestWatchman;
    //   67: aload_0
    //   68: getfield 16	org/junit/rules/TestWatchman$1:val$method	Lorg/junit/runners/model/FrameworkMethod;
    //   71: invokevirtual 41	org/junit/rules/TestWatchman:finished	(Lorg/junit/runners/model/FrameworkMethod;)V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	1
    //   41	1	1	localObject	java.lang.Object
    //   45	14	1	localThrowable	java.lang.Throwable
    //   60	15	1	localAssumptionViolatedException	org.junit.internal.AssumptionViolatedException
    // Exception table:
    //   from	to	target	type
    //   11	29	41	finally
    //   46	60	41	finally
    //   61	63	41	finally
    //   11	29	45	java/lang/Throwable
    //   11	29	60	org/junit/internal/AssumptionViolatedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.rules.TestWatchman.1
 * JD-Core Version:    0.7.0.1
 */