package com.tencent.mobileqq.microapp.apkg;

import java.util.List;

public final class k
  implements Cloneable
{
  public int a;
  public int b;
  public int c;
  public String d;
  public String e;
  public List f;
  
  /* Error */
  public k a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 27	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	com/tencent/mobileqq/microapp/apkg/k
    //   7: astore_1
    //   8: aload_1
    //   9: new 29	java/util/LinkedList
    //   12: dup
    //   13: invokespecial 30	java/util/LinkedList:<init>	()V
    //   16: putfield 32	com/tencent/mobileqq/microapp/apkg/k:f	Ljava/util/List;
    //   19: aload_0
    //   20: getfield 32	com/tencent/mobileqq/microapp/apkg/k:f	Ljava/util/List;
    //   23: invokeinterface 38 1 0
    //   28: astore_3
    //   29: aload_1
    //   30: astore_2
    //   31: aload_3
    //   32: invokeinterface 44 1 0
    //   37: ifeq +43 -> 80
    //   40: aload_3
    //   41: invokeinterface 47 1 0
    //   46: checkcast 49	com/tencent/mobileqq/microapp/apkg/k$a
    //   49: astore_2
    //   50: aload_1
    //   51: getfield 32	com/tencent/mobileqq/microapp/apkg/k:f	Ljava/util/List;
    //   54: aload_2
    //   55: invokevirtual 52	com/tencent/mobileqq/microapp/apkg/k$a:a	()Lcom/tencent/mobileqq/microapp/apkg/k$a;
    //   58: invokeinterface 56 2 0
    //   63: pop
    //   64: goto -35 -> 29
    //   67: astore_2
    //   68: goto +6 -> 74
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_2
    //   75: invokevirtual 59	java/lang/Throwable:printStackTrace	()V
    //   78: aload_1
    //   79: astore_2
    //   80: aload_2
    //   81: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	k
    //   7	72	1	localk1	k
    //   30	25	2	localObject	Object
    //   67	1	2	localThrowable1	java.lang.Throwable
    //   71	4	2	localThrowable2	java.lang.Throwable
    //   79	2	2	localk2	k
    //   28	13	3	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   8	29	67	java/lang/Throwable
    //   31	64	67	java/lang/Throwable
    //   0	8	71	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.k
 * JD-Core Version:    0.7.0.1
 */