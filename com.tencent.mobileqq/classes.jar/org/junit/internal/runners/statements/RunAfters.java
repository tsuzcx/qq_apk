package org.junit.internal.runners.statements;

import java.util.List;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class RunAfters
  extends Statement
{
  private final List<FrameworkMethod> afters;
  private final Statement next;
  private final Object target;
  
  public RunAfters(Statement paramStatement, List<FrameworkMethod> paramList, Object paramObject)
  {
    this.next = paramStatement;
    this.afters = paramList;
    this.target = paramObject;
  }
  
  /* Error */
  public void evaluate()
  {
    // Byte code:
    //   0: new 30	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 31	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 18	org/junit/internal/runners/statements/RunAfters:next	Lorg/junit/runners/model/Statement;
    //   12: invokevirtual 33	org/junit/runners/model/Statement:evaluate	()V
    //   15: aload_0
    //   16: getfield 20	org/junit/internal/runners/statements/RunAfters:afters	Ljava/util/List;
    //   19: invokeinterface 39 1 0
    //   24: astore_2
    //   25: aload_2
    //   26: invokeinterface 45 1 0
    //   31: ifeq +111 -> 142
    //   34: aload_2
    //   35: invokeinterface 48 1 0
    //   40: checkcast 50	org/junit/runners/model/FrameworkMethod
    //   43: astore_3
    //   44: aload_3
    //   45: aload_0
    //   46: getfield 22	org/junit/internal/runners/statements/RunAfters:target	Ljava/lang/Object;
    //   49: iconst_0
    //   50: anewarray 52	java/lang/Object
    //   53: invokevirtual 56	org/junit/runners/model/FrameworkMethod:invokeExplosively	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   56: pop
    //   57: goto -32 -> 25
    //   60: astore_3
    //   61: aload_1
    //   62: aload_3
    //   63: invokeinterface 60 2 0
    //   68: pop
    //   69: goto -44 -> 25
    //   72: astore_2
    //   73: goto +74 -> 147
    //   76: astore_2
    //   77: aload_1
    //   78: aload_2
    //   79: invokeinterface 60 2 0
    //   84: pop
    //   85: aload_0
    //   86: getfield 20	org/junit/internal/runners/statements/RunAfters:afters	Ljava/util/List;
    //   89: invokeinterface 39 1 0
    //   94: astore_2
    //   95: aload_2
    //   96: invokeinterface 45 1 0
    //   101: ifeq +41 -> 142
    //   104: aload_2
    //   105: invokeinterface 48 1 0
    //   110: checkcast 50	org/junit/runners/model/FrameworkMethod
    //   113: astore_3
    //   114: aload_3
    //   115: aload_0
    //   116: getfield 22	org/junit/internal/runners/statements/RunAfters:target	Ljava/lang/Object;
    //   119: iconst_0
    //   120: anewarray 52	java/lang/Object
    //   123: invokevirtual 56	org/junit/runners/model/FrameworkMethod:invokeExplosively	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   126: pop
    //   127: goto -32 -> 95
    //   130: astore_3
    //   131: aload_1
    //   132: aload_3
    //   133: invokeinterface 60 2 0
    //   138: pop
    //   139: goto -44 -> 95
    //   142: aload_1
    //   143: invokestatic 66	org/junit/runners/model/MultipleFailureException:assertEmpty	(Ljava/util/List;)V
    //   146: return
    //   147: aload_0
    //   148: getfield 20	org/junit/internal/runners/statements/RunAfters:afters	Ljava/util/List;
    //   151: invokeinterface 39 1 0
    //   156: astore_3
    //   157: aload_3
    //   158: invokeinterface 45 1 0
    //   163: ifeq +45 -> 208
    //   166: aload_3
    //   167: invokeinterface 48 1 0
    //   172: checkcast 50	org/junit/runners/model/FrameworkMethod
    //   175: astore 4
    //   177: aload 4
    //   179: aload_0
    //   180: getfield 22	org/junit/internal/runners/statements/RunAfters:target	Ljava/lang/Object;
    //   183: iconst_0
    //   184: anewarray 52	java/lang/Object
    //   187: invokevirtual 56	org/junit/runners/model/FrameworkMethod:invokeExplosively	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   190: pop
    //   191: goto -34 -> 157
    //   194: astore 4
    //   196: aload_1
    //   197: aload 4
    //   199: invokeinterface 60 2 0
    //   204: pop
    //   205: goto -48 -> 157
    //   208: goto +5 -> 213
    //   211: aload_2
    //   212: athrow
    //   213: goto -2 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	RunAfters
    //   7	190	1	localArrayList	java.util.ArrayList
    //   24	11	2	localIterator1	java.util.Iterator
    //   72	1	2	localObject	Object
    //   76	3	2	localThrowable1	java.lang.Throwable
    //   94	118	2	localIterator2	java.util.Iterator
    //   43	2	3	localFrameworkMethod1	FrameworkMethod
    //   60	3	3	localThrowable2	java.lang.Throwable
    //   113	2	3	localFrameworkMethod2	FrameworkMethod
    //   130	3	3	localThrowable3	java.lang.Throwable
    //   156	11	3	localIterator3	java.util.Iterator
    //   175	3	4	localFrameworkMethod3	FrameworkMethod
    //   194	4	4	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   44	57	60	java/lang/Throwable
    //   8	15	72	finally
    //   77	85	72	finally
    //   8	15	76	java/lang/Throwable
    //   114	127	130	java/lang/Throwable
    //   177	191	194	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.internal.runners.statements.RunAfters
 * JD-Core Version:    0.7.0.1
 */