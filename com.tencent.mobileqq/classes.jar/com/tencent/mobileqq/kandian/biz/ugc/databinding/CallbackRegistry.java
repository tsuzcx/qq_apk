package com.tencent.mobileqq.kandian.biz.ugc.databinding;

import java.util.ArrayList;
import java.util.List;

public class CallbackRegistry<C, T, A>
  implements Cloneable
{
  private List<C> a = new ArrayList();
  private long b = 0L;
  private long[] c;
  private int d;
  private final CallbackRegistry.NotifierCallback<C, T, A> e;
  
  public CallbackRegistry(CallbackRegistry.NotifierCallback<C, T, A> paramNotifierCallback)
  {
    this.e = paramNotifierCallback;
  }
  
  private void a(int paramInt, long paramLong)
  {
    int i = paramInt + 64 - 1;
    long l = -9223372036854775808L;
    while (i >= paramInt)
    {
      if ((paramLong & l) != 0L) {
        this.a.remove(i);
      }
      l >>>= 1;
      i -= 1;
    }
  }
  
  private void a(T paramT, int paramInt1, A paramA, int paramInt2)
  {
    if (paramInt2 < 0)
    {
      b(paramT, paramInt1, paramA);
      return;
    }
    long l = this.c[paramInt2];
    int i = (paramInt2 + 1) * 64;
    int j = Math.min(this.a.size(), i + 64);
    a(paramT, paramInt1, paramA, paramInt2 - 1);
    a(paramT, paramInt1, paramA, i, j, l);
  }
  
  private void a(T paramT, int paramInt1, A paramA, int paramInt2, int paramInt3, long paramLong)
  {
    long l = 1L;
    while (paramInt2 < paramInt3)
    {
      if ((paramLong & l) == 0L) {
        this.e.a(this.a.get(paramInt2), paramT, paramInt1, paramA);
      }
      l <<= 1;
      paramInt2 += 1;
    }
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt < 64) {
      return (1L << paramInt & this.b) != 0L;
    }
    long[] arrayOfLong = this.c;
    if (arrayOfLong == null) {
      return false;
    }
    int i = paramInt / 64 - 1;
    if (i >= arrayOfLong.length) {
      return false;
    }
    return (1L << paramInt % 64 & arrayOfLong[i]) != 0L;
  }
  
  private void b(int paramInt)
  {
    if (paramInt < 64)
    {
      this.b = (1L << paramInt | this.b);
      return;
    }
    int i = paramInt / 64 - 1;
    long[] arrayOfLong1 = this.c;
    if (arrayOfLong1 == null)
    {
      this.c = new long[this.a.size() / 64];
    }
    else if (arrayOfLong1.length < i)
    {
      arrayOfLong1 = new long[this.a.size() / 64];
      long[] arrayOfLong2 = this.c;
      System.arraycopy(arrayOfLong2, 0, arrayOfLong1, 0, arrayOfLong2.length);
      this.c = arrayOfLong1;
    }
    arrayOfLong1 = this.c;
    arrayOfLong1[i] = (1L << paramInt % 64 | arrayOfLong1[i]);
  }
  
  private void b(T paramT, int paramInt, A paramA)
  {
    a(paramT, paramInt, paramA, 0, Math.min(64, this.a.size()), this.b);
  }
  
  private void c(T paramT, int paramInt, A paramA)
  {
    int j = this.a.size();
    long[] arrayOfLong = this.c;
    int i;
    if (arrayOfLong == null) {
      i = -1;
    } else {
      i = arrayOfLong.length - 1;
    }
    a(paramT, paramInt, paramA, i);
    a(paramT, paramInt, paramA, (i + 2) * 64, j, 0L);
  }
  
  /* Error */
  public CallbackRegistry<C, T, A> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 92	java/lang/Object:clone	()Ljava/lang/Object;
    //   6: checkcast 2	com/tencent/mobileqq/kandian/biz/ugc/databinding/CallbackRegistry
    //   9: astore_3
    //   10: aload_3
    //   11: lconst_0
    //   12: putfield 31	com/tencent/mobileqq/kandian/biz/ugc/databinding/CallbackRegistry:b	J
    //   15: aload_3
    //   16: aconst_null
    //   17: putfield 51	com/tencent/mobileqq/kandian/biz/ugc/databinding/CallbackRegistry:c	[J
    //   20: iconst_0
    //   21: istore_1
    //   22: aload_3
    //   23: iconst_0
    //   24: putfield 94	com/tencent/mobileqq/kandian/biz/ugc/databinding/CallbackRegistry:d	I
    //   27: aload_3
    //   28: new 26	java/util/ArrayList
    //   31: dup
    //   32: invokespecial 27	java/util/ArrayList:<init>	()V
    //   35: putfield 29	com/tencent/mobileqq/kandian/biz/ugc/databinding/CallbackRegistry:a	Ljava/util/List;
    //   38: aload_0
    //   39: getfield 29	com/tencent/mobileqq/kandian/biz/ugc/databinding/CallbackRegistry:a	Ljava/util/List;
    //   42: invokeinterface 55 1 0
    //   47: istore_2
    //   48: aload_3
    //   49: astore 4
    //   51: iload_1
    //   52: iload_2
    //   53: if_icmpge +59 -> 112
    //   56: aload_0
    //   57: iload_1
    //   58: invokespecial 96	com/tencent/mobileqq/kandian/biz/ugc/databinding/CallbackRegistry:a	(I)Z
    //   61: ifne +23 -> 84
    //   64: aload_3
    //   65: getfield 29	com/tencent/mobileqq/kandian/biz/ugc/databinding/CallbackRegistry:a	Ljava/util/List;
    //   68: aload_0
    //   69: getfield 29	com/tencent/mobileqq/kandian/biz/ugc/databinding/CallbackRegistry:a	Ljava/util/List;
    //   72: iload_1
    //   73: invokeinterface 70 2 0
    //   78: invokeinterface 100 2 0
    //   83: pop
    //   84: iload_1
    //   85: iconst_1
    //   86: iadd
    //   87: istore_1
    //   88: goto -40 -> 48
    //   91: astore 4
    //   93: goto +11 -> 104
    //   96: astore_3
    //   97: goto +20 -> 117
    //   100: astore 4
    //   102: aconst_null
    //   103: astore_3
    //   104: aload 4
    //   106: invokevirtual 103	java/lang/CloneNotSupportedException:printStackTrace	()V
    //   109: aload_3
    //   110: astore 4
    //   112: aload_0
    //   113: monitorexit
    //   114: aload 4
    //   116: areturn
    //   117: aload_0
    //   118: monitorexit
    //   119: goto +5 -> 124
    //   122: aload_3
    //   123: athrow
    //   124: goto -2 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	CallbackRegistry
    //   21	67	1	i	int
    //   47	7	2	j	int
    //   9	56	3	localCallbackRegistry1	CallbackRegistry
    //   96	1	3	localObject1	Object
    //   103	20	3	localObject2	Object
    //   49	1	4	localCallbackRegistry2	CallbackRegistry
    //   91	1	4	localCloneNotSupportedException1	java.lang.CloneNotSupportedException
    //   100	5	4	localCloneNotSupportedException2	java.lang.CloneNotSupportedException
    //   110	5	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   10	20	91	java/lang/CloneNotSupportedException
    //   22	48	91	java/lang/CloneNotSupportedException
    //   56	84	91	java/lang/CloneNotSupportedException
    //   2	10	96	finally
    //   10	20	96	finally
    //   22	48	96	finally
    //   56	84	96	finally
    //   104	109	96	finally
    //   2	10	100	java/lang/CloneNotSupportedException
  }
  
  public void a(C paramC)
  {
    if (paramC != null) {
      try
      {
        int i = this.a.lastIndexOf(paramC);
        if ((i < 0) || (a(i))) {
          this.a.add(paramC);
        }
        return;
      }
      finally
      {
        break label57;
      }
    }
    throw new IllegalArgumentException("callback cannot be null");
    label57:
    throw paramC;
  }
  
  public void a(T paramT, int paramInt, A paramA)
  {
    try
    {
      this.d += 1;
      c(paramT, paramInt, paramA);
      this.d -= 1;
      if (this.d == 0)
      {
        if (this.c != null)
        {
          paramInt = this.c.length - 1;
          if (paramInt >= 0)
          {
            long l = this.c[paramInt];
            if (l == 0L) {
              break label129;
            }
            a((paramInt + 1) * 64, l);
            this.c[paramInt] = 0L;
            break label129;
          }
        }
        if (this.b != 0L)
        {
          a(0, this.b);
          this.b = 0L;
        }
      }
      return;
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          throw paramT;
        }
        label129:
        paramInt -= 1;
      }
    }
  }
  
  public void b(C paramC)
  {
    try
    {
      if (this.d == 0)
      {
        this.a.remove(paramC);
      }
      else
      {
        int i = this.a.lastIndexOf(paramC);
        if (i >= 0) {
          b(i);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.databinding.CallbackRegistry
 * JD-Core Version:    0.7.0.1
 */