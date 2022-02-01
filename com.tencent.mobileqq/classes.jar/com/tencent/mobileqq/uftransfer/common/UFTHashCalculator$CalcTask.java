package com.tencent.mobileqq.uftransfer.common;

import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi.FileMediaInfo;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.io.File;
import java.util.Timer;

class UFTHashCalculator$CalcTask
  implements UFTRunnableQueue.IUFTRunnable
{
  long a;
  final long b;
  long c = 0L;
  final String d;
  final UFTHashCalculator.IHashCalcPrg e;
  UFTRunnableQueue.IRunnableCallback f;
  int g = 0;
  final UFTHashCalculator.HashCalcResult h = new UFTHashCalculator.HashCalcResult(this.this$0, null);
  boolean i = true;
  Timer j;
  
  UFTHashCalculator$CalcTask(UFTHashCalculator paramUFTHashCalculator, String paramString, long paramLong, UFTHashCalculator.IHashCalcPrg paramIHashCalcPrg)
  {
    this.d = paramString;
    this.b = paramLong;
    this.e = paramIHashCalcPrg;
  }
  
  private void a(int paramInt)
  {
    if (this.i) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("] calc hash fail. errCode:");
    ((StringBuilder)localObject).append(paramInt);
    UFTLog.b("[UFTTransfer] UFTHashCalculator", 1, ((StringBuilder)localObject).toString());
    g();
    this.i = true;
    this.g = paramInt;
    this.e.a(this.a, this.g, this.h);
    localObject = this.f;
    if (localObject != null) {
      ((UFTRunnableQueue.IRunnableCallback)localObject).a(this.a, false, this.g, this);
    }
  }
  
  private boolean c(long paramLong)
  {
    return (paramLong & this.c) != 0L;
  }
  
  private void d(long paramLong)
  {
    try
    {
      g();
      this.j = new Timer();
      this.j.schedule(new UFTHashCalculator.CalcTask.1(this), paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void f()
  {
    if (this.i) {
      return;
    }
    g();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("] calc hash suc.");
    ((StringBuilder)localObject).append(this.h.toString());
    UFTLog.b("[UFTTransfer] UFTHashCalculator", 1, ((StringBuilder)localObject).toString());
    this.g = 0;
    this.i = true;
    this.e.a(this.a, this.g, this.h);
    localObject = this.f;
    if (localObject != null) {
      ((UFTRunnableQueue.IRunnableCallback)localObject).a(this.a, true, this.g, this);
    }
  }
  
  private void g()
  {
    try
    {
      if (this.j != null)
      {
        this.j.cancel();
        this.j = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("] stop");
    UFTLog.b("[UFTTransfer] UFTHashCalculator", 1, localStringBuilder.toString());
    g();
    this.i = true;
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  /* Error */
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifne +8 -> 9
    //   4: iload_2
    //   5: ifne +4 -> 9
    //   8: return
    //   9: ldc 134
    //   11: invokestatic 140	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   14: astore 8
    //   16: ldc 142
    //   18: invokestatic 140	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   21: astore 9
    //   23: new 144	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: getfield 48	com/tencent/mobileqq/uftransfer/common/UFTHashCalculator$CalcTask:d	Ljava/lang/String;
    //   31: invokespecial 147	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   34: astore 7
    //   36: lconst_0
    //   37: lstore 5
    //   39: ldc 148
    //   41: newarray byte
    //   43: astore 10
    //   45: aload 7
    //   47: aload 10
    //   49: invokevirtual 152	java/io/FileInputStream:read	([B)I
    //   52: istore_3
    //   53: iload_3
    //   54: ifge +51 -> 105
    //   57: aload 7
    //   59: invokevirtual 155	java/io/FileInputStream:close	()V
    //   62: goto +10 -> 72
    //   65: astore 7
    //   67: aload 7
    //   69: invokevirtual 158	java/io/IOException:printStackTrace	()V
    //   72: iload_1
    //   73: ifeq +15 -> 88
    //   76: aload_0
    //   77: getfield 44	com/tencent/mobileqq/uftransfer/common/UFTHashCalculator$CalcTask:h	Lcom/tencent/mobileqq/uftransfer/common/UFTHashCalculator$HashCalcResult;
    //   80: aload 8
    //   82: invokevirtual 162	java/security/MessageDigest:digest	()[B
    //   85: putfield 165	com/tencent/mobileqq/uftransfer/common/UFTHashCalculator$HashCalcResult:b	[B
    //   88: iload_2
    //   89: ifeq +15 -> 104
    //   92: aload_0
    //   93: getfield 44	com/tencent/mobileqq/uftransfer/common/UFTHashCalculator$CalcTask:h	Lcom/tencent/mobileqq/uftransfer/common/UFTHashCalculator$HashCalcResult;
    //   96: aload 9
    //   98: invokevirtual 162	java/security/MessageDigest:digest	()[B
    //   101: putfield 167	com/tencent/mobileqq/uftransfer/common/UFTHashCalculator$HashCalcResult:c	[B
    //   104: return
    //   105: iload_1
    //   106: ifeq +12 -> 118
    //   109: aload 8
    //   111: aload 10
    //   113: iconst_0
    //   114: iload_3
    //   115: invokevirtual 171	java/security/MessageDigest:update	([BII)V
    //   118: iload_2
    //   119: ifeq +12 -> 131
    //   122: aload 9
    //   124: aload 10
    //   126: iconst_0
    //   127: iload_3
    //   128: invokevirtual 171	java/security/MessageDigest:update	([BII)V
    //   131: lload 5
    //   133: iload_3
    //   134: i2l
    //   135: ladd
    //   136: lstore 5
    //   138: aload_0
    //   139: getfield 52	com/tencent/mobileqq/uftransfer/common/UFTHashCalculator$CalcTask:e	Lcom/tencent/mobileqq/uftransfer/common/UFTHashCalculator$IHashCalcPrg;
    //   142: aload_0
    //   143: getfield 65	com/tencent/mobileqq/uftransfer/common/UFTHashCalculator$CalcTask:a	J
    //   146: lload 5
    //   148: aload_0
    //   149: getfield 44	com/tencent/mobileqq/uftransfer/common/UFTHashCalculator$CalcTask:h	Lcom/tencent/mobileqq/uftransfer/common/UFTHashCalculator$HashCalcResult;
    //   152: getfield 173	com/tencent/mobileqq/uftransfer/common/UFTHashCalculator$HashCalcResult:h	J
    //   155: invokeinterface 176 7 0
    //   160: aload_0
    //   161: getfield 46	com/tencent/mobileqq/uftransfer/common/UFTHashCalculator$CalcTask:i	Z
    //   164: istore 4
    //   166: iload 4
    //   168: ifeq -123 -> 45
    //   171: aload 7
    //   173: invokevirtual 155	java/io/FileInputStream:close	()V
    //   176: return
    //   177: astore 7
    //   179: aload 7
    //   181: invokevirtual 158	java/io/IOException:printStackTrace	()V
    //   184: return
    //   185: astore 8
    //   187: goto +22 -> 209
    //   190: aload_0
    //   191: iconst_3
    //   192: invokespecial 101	com/tencent/mobileqq/uftransfer/common/UFTHashCalculator$CalcTask:a	(I)V
    //   195: aload 7
    //   197: invokevirtual 155	java/io/FileInputStream:close	()V
    //   200: return
    //   201: astore 7
    //   203: aload 7
    //   205: invokevirtual 158	java/io/IOException:printStackTrace	()V
    //   208: return
    //   209: aload 7
    //   211: invokevirtual 155	java/io/FileInputStream:close	()V
    //   214: goto +10 -> 224
    //   217: astore 7
    //   219: aload 7
    //   221: invokevirtual 158	java/io/IOException:printStackTrace	()V
    //   224: aload 8
    //   226: athrow
    //   227: aload_0
    //   228: iconst_1
    //   229: invokespecial 101	com/tencent/mobileqq/uftransfer/common/UFTHashCalculator$CalcTask:a	(I)V
    //   232: return
    //   233: aload_0
    //   234: iconst_2
    //   235: invokespecial 101	com/tencent/mobileqq/uftransfer/common/UFTHashCalculator$CalcTask:a	(I)V
    //   238: return
    //   239: astore 7
    //   241: goto -8 -> 233
    //   244: astore 7
    //   246: goto -19 -> 227
    //   249: astore 8
    //   251: goto -61 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	CalcTask
    //   0	254	1	paramBoolean1	boolean
    //   0	254	2	paramBoolean2	boolean
    //   52	82	3	k	int
    //   164	3	4	bool	boolean
    //   37	110	5	l	long
    //   34	24	7	localFileInputStream	java.io.FileInputStream
    //   65	107	7	localIOException1	java.io.IOException
    //   177	19	7	localIOException2	java.io.IOException
    //   201	9	7	localIOException3	java.io.IOException
    //   217	3	7	localIOException4	java.io.IOException
    //   239	1	7	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   244	1	7	localFileNotFoundException	java.io.FileNotFoundException
    //   14	96	8	localMessageDigest1	java.security.MessageDigest
    //   185	40	8	localObject	Object
    //   249	1	8	localIOException5	java.io.IOException
    //   21	102	9	localMessageDigest2	java.security.MessageDigest
    //   43	82	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   57	62	65	java/io/IOException
    //   171	176	177	java/io/IOException
    //   39	45	185	finally
    //   45	53	185	finally
    //   109	118	185	finally
    //   122	131	185	finally
    //   138	166	185	finally
    //   190	195	185	finally
    //   195	200	201	java/io/IOException
    //   209	214	217	java/io/IOException
    //   9	23	239	java/security/NoSuchAlgorithmException
    //   23	36	244	java/io/FileNotFoundException
    //   39	45	249	java/io/IOException
    //   45	53	249	java/io/IOException
    //   109	118	249	java/io/IOException
    //   122	131	249	java/io/IOException
    //   138	166	249	java/io/IOException
  }
  
  public boolean a(UFTRunnableQueue.IRunnableCallback paramIRunnableCallback)
  {
    this.f = paramIRunnableCallback;
    this.i = false;
    d(90000L);
    paramIRunnableCallback = new StringBuilder();
    paramIRunnableCallback.append("[");
    paramIRunnableCallback.append(this.a);
    paramIRunnableCallback.append("] start");
    UFTLog.b("[UFTTransfer] UFTHashCalculator", 1, paramIRunnableCallback.toString());
    UFTDependFeatureApi.a(this, 5, true);
    return true;
  }
  
  public boolean a(UFTRunnableQueue.IUFTRunnable paramIUFTRunnable)
  {
    if (paramIUFTRunnable != null)
    {
      if (!(paramIUFTRunnable instanceof CalcTask)) {
        return false;
      }
      paramIUFTRunnable = ((CalcTask)paramIUFTRunnable).d;
      if ((paramIUFTRunnable != null) && (paramIUFTRunnable.equals(this.d))) {
        return true;
      }
    }
    return false;
  }
  
  void b()
  {
    this.h.a = UFTDependFeatureApi.c(this.d);
    if ((this.h.a == null) && (!c(1L))) {
      a(3);
    }
  }
  
  public void b(long paramLong)
  {
    this.a = paramLong;
  }
  
  void c()
  {
    this.h.d = UFTDependFeatureApi.d(this.d);
    if ((this.h.d == null) && (!c(4L))) {
      a(3);
    }
  }
  
  void d()
  {
    UFTDependFeatureApi.FileMediaInfo localFileMediaInfo = UFTDependFeatureApi.h(this.d);
    if (localFileMediaInfo != null)
    {
      this.h.e = localFileMediaInfo.a;
      this.h.f = localFileMediaInfo.b;
      this.h.g = localFileMediaInfo.c;
    }
  }
  
  public long e()
  {
    return this.a;
  }
  
  public void run()
  {
    if (this.i) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("] run calc hash.");
    UFTLog.b("[UFTTransfer] UFTHashCalculator", 1, ((StringBuilder)localObject).toString());
    long l = this.b;
    boolean bool2 = false;
    if (l == 0L)
    {
      this.e.a(this.a, 0L);
      this.g = 0;
      f();
      return;
    }
    localObject = new File(this.d);
    if ((((File)localObject).exists()) && ((((File)localObject).isFile()) || (((File)localObject).length() >= 0L)))
    {
      this.h.h = ((File)localObject).length();
      this.e.a(this.a, this.h.h);
      if ((this.b & 1L) != 0L)
      {
        b();
        if (this.i) {
          return;
        }
      }
      if ((this.b & 0x4) != 0L)
      {
        c();
        if (this.i) {
          return;
        }
      }
      if ((this.b & 0x10) != 0L)
      {
        d();
        if (this.i) {
          return;
        }
      }
      boolean bool1;
      if ((this.b & 0x2) != 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((this.b & 0x8) != 0L) {
        bool2 = true;
      }
      if ((bool1) || (bool2))
      {
        a(bool1, bool2);
        if (this.i) {
          return;
        }
      }
      f();
      return;
    }
    this.e.a(this.a, 0L);
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.UFTHashCalculator.CalcTask
 * JD-Core Version:    0.7.0.1
 */