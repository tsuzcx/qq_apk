package org.junit.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

class TestWatcher$1
  extends Statement
{
  TestWatcher$1(TestWatcher paramTestWatcher, Description paramDescription, Statement paramStatement) {}
  
  /* Error */
  public void evaluate()
  {
    // Byte code:
    //   0: new 29	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 30	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 14	org/junit/rules/TestWatcher$1:this$0	Lorg/junit/rules/TestWatcher;
    //   12: aload_0
    //   13: getfield 16	org/junit/rules/TestWatcher$1:val$description	Lorg/junit/runner/Description;
    //   16: aload_1
    //   17: invokestatic 36	org/junit/rules/TestWatcher:access$000	(Lorg/junit/rules/TestWatcher;Lorg/junit/runner/Description;Ljava/util/List;)V
    //   20: aload_0
    //   21: getfield 18	org/junit/rules/TestWatcher$1:val$base	Lorg/junit/runners/model/Statement;
    //   24: invokevirtual 38	org/junit/runners/model/Statement:evaluate	()V
    //   27: aload_0
    //   28: getfield 14	org/junit/rules/TestWatcher$1:this$0	Lorg/junit/rules/TestWatcher;
    //   31: aload_0
    //   32: getfield 16	org/junit/rules/TestWatcher$1:val$description	Lorg/junit/runner/Description;
    //   35: aload_1
    //   36: invokestatic 41	org/junit/rules/TestWatcher:access$100	(Lorg/junit/rules/TestWatcher;Lorg/junit/runner/Description;Ljava/util/List;)V
    //   39: aload_0
    //   40: getfield 14	org/junit/rules/TestWatcher$1:this$0	Lorg/junit/rules/TestWatcher;
    //   43: aload_0
    //   44: getfield 16	org/junit/rules/TestWatcher$1:val$description	Lorg/junit/runner/Description;
    //   47: aload_1
    //   48: invokestatic 44	org/junit/rules/TestWatcher:access$400	(Lorg/junit/rules/TestWatcher;Lorg/junit/runner/Description;Ljava/util/List;)V
    //   51: goto +57 -> 108
    //   54: astore_2
    //   55: goto +58 -> 113
    //   58: astore_2
    //   59: aload_1
    //   60: aload_2
    //   61: invokeinterface 50 2 0
    //   66: pop
    //   67: aload_0
    //   68: getfield 14	org/junit/rules/TestWatcher$1:this$0	Lorg/junit/rules/TestWatcher;
    //   71: aload_2
    //   72: aload_0
    //   73: getfield 16	org/junit/rules/TestWatcher$1:val$description	Lorg/junit/runner/Description;
    //   76: aload_1
    //   77: invokestatic 54	org/junit/rules/TestWatcher:access$300	(Lorg/junit/rules/TestWatcher;Ljava/lang/Throwable;Lorg/junit/runner/Description;Ljava/util/List;)V
    //   80: goto -41 -> 39
    //   83: astore_2
    //   84: aload_1
    //   85: aload_2
    //   86: invokeinterface 50 2 0
    //   91: pop
    //   92: aload_0
    //   93: getfield 14	org/junit/rules/TestWatcher$1:this$0	Lorg/junit/rules/TestWatcher;
    //   96: aload_2
    //   97: aload_0
    //   98: getfield 16	org/junit/rules/TestWatcher$1:val$description	Lorg/junit/runner/Description;
    //   101: aload_1
    //   102: invokestatic 58	org/junit/rules/TestWatcher:access$200	(Lorg/junit/rules/TestWatcher;Lorg/junit/internal/AssumptionViolatedException;Lorg/junit/runner/Description;Ljava/util/List;)V
    //   105: goto -66 -> 39
    //   108: aload_1
    //   109: invokestatic 64	org/junit/runners/model/MultipleFailureException:assertEmpty	(Ljava/util/List;)V
    //   112: return
    //   113: aload_0
    //   114: getfield 14	org/junit/rules/TestWatcher$1:this$0	Lorg/junit/rules/TestWatcher;
    //   117: aload_0
    //   118: getfield 16	org/junit/rules/TestWatcher$1:val$description	Lorg/junit/runner/Description;
    //   121: aload_1
    //   122: invokestatic 44	org/junit/rules/TestWatcher:access$400	(Lorg/junit/rules/TestWatcher;Lorg/junit/runner/Description;Ljava/util/List;)V
    //   125: goto +5 -> 130
    //   128: aload_2
    //   129: athrow
    //   130: goto -2 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	1
    //   7	115	1	localArrayList	java.util.ArrayList
    //   54	1	2	localObject	java.lang.Object
    //   58	14	2	localThrowable	java.lang.Throwable
    //   83	46	2	localAssumptionViolatedException	org.junit.internal.AssumptionViolatedException
    // Exception table:
    //   from	to	target	type
    //   20	39	54	finally
    //   59	80	54	finally
    //   84	105	54	finally
    //   20	39	58	java/lang/Throwable
    //   20	39	83	org/junit/internal/AssumptionViolatedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.rules.TestWatcher.1
 * JD-Core Version:    0.7.0.1
 */