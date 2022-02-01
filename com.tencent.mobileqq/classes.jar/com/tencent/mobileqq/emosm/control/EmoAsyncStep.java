package com.tencent.mobileqq.emosm.control;

import com.tencent.qphone.base.util.QLog;

public class EmoAsyncStep
  implements Runnable
{
  private Object a = new Object();
  private long b = 0L;
  public IEmoResultListener c;
  protected volatile int d = 1;
  protected long e = 30000L;
  public EmoAutomator f;
  public int g = -1;
  public String h;
  protected int i = 0;
  public Object[] j;
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(this.h);
      ((StringBuilder)???).append(" setResult ");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(", when ");
      ((StringBuilder)???).append(this.d);
      QLog.d("EmoAutomator", 2, ((StringBuilder)???).toString());
    }
    if (paramInt == 6)
    {
      ??? = this.f;
      ((EmoAutomator)???).b += 1;
    }
    synchronized (this.a)
    {
      if ((paramInt > this.d) && (paramInt != 4)) {
        this.d = paramInt;
      }
      this.a.notifyAll();
      return;
    }
  }
  
  protected int b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.h);
      localStringBuilder.append(" EmoAsyncStep.doStep()");
      QLog.e("EmoAutomator", 2, localStringBuilder.toString());
    }
    return 7;
  }
  
  protected boolean g()
  {
    synchronized (this.a)
    {
      int k;
      Object localObject2;
      for (;;)
      {
        k = this.d;
        if (k == 2) {
          try
          {
            this.a.wait(this.e);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.h);
          ((StringBuilder)localObject2).append(" waitResult ");
          ((StringBuilder)localObject2).append(this.d);
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(this.i);
          QLog.d("EmoAutomator", 2, ((StringBuilder)localObject2).toString());
        }
        if (this.d != 3) {
          break;
        }
        this.d = 2;
      }
      if (this.d == 2)
      {
        this.d = 5;
        localObject2 = this.f;
        ((EmoAutomator)localObject2).b += 1;
      }
      if ((this.d == 6) || (this.d == 5))
      {
        k = this.i;
        this.i = (k - 1);
        if (k > 0)
        {
          this.d = 1;
          return true;
        }
      }
      return false;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public void h() {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/tencent/mobileqq/emosm/control/EmoAsyncStep:d	I
    //   4: iconst_1
    //   5: if_icmpne +316 -> 321
    //   8: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +46 -> 57
    //   14: new 51	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   21: astore_1
    //   22: aload_1
    //   23: aload_0
    //   24: getfield 54	com/tencent/mobileqq/emosm/control/EmoAsyncStep:h	Ljava/lang/String;
    //   27: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_1
    //   32: ldc 106
    //   34: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_1
    //   39: aload_0
    //   40: getfield 29	com/tencent/mobileqq/emosm/control/EmoAsyncStep:d	I
    //   43: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: ldc 67
    //   49: iconst_1
    //   50: aload_1
    //   51: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: invokestatic 112	android/os/SystemClock:uptimeMillis	()J
    //   61: putfield 41	com/tencent/mobileqq/emosm/control/EmoAsyncStep:b	J
    //   64: aload_0
    //   65: invokevirtual 114	com/tencent/mobileqq/emosm/control/EmoAsyncStep:a	()V
    //   68: aload_0
    //   69: aload_0
    //   70: invokevirtual 116	com/tencent/mobileqq/emosm/control/EmoAsyncStep:b	()I
    //   73: invokevirtual 118	com/tencent/mobileqq/emosm/control/EmoAsyncStep:a	(I)V
    //   76: aload_0
    //   77: invokevirtual 120	com/tencent/mobileqq/emosm/control/EmoAsyncStep:g	()Z
    //   80: ifne -12 -> 68
    //   83: aload_0
    //   84: invokevirtual 122	com/tencent/mobileqq/emosm/control/EmoAsyncStep:h	()V
    //   87: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +50 -> 140
    //   93: new 51	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   100: astore_1
    //   101: aload_1
    //   102: aload_0
    //   103: getfield 54	com/tencent/mobileqq/emosm/control/EmoAsyncStep:h	Ljava/lang/String;
    //   106: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_1
    //   111: ldc 124
    //   113: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_1
    //   118: invokestatic 112	android/os/SystemClock:uptimeMillis	()J
    //   121: aload_0
    //   122: getfield 41	com/tencent/mobileqq/emosm/control/EmoAsyncStep:b	J
    //   125: lsub
    //   126: invokevirtual 127	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: ldc 67
    //   132: iconst_1
    //   133: aload_1
    //   134: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload_0
    //   141: getfield 129	com/tencent/mobileqq/emosm/control/EmoAsyncStep:c	Lcom/tencent/mobileqq/emosm/control/IEmoResultListener;
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull +175 -> 321
    //   149: goto +85 -> 234
    //   152: astore_1
    //   153: goto +93 -> 246
    //   156: astore_1
    //   157: ldc 67
    //   159: iconst_1
    //   160: ldc 131
    //   162: aload_1
    //   163: invokestatic 134	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   166: aload_0
    //   167: bipush 8
    //   169: invokevirtual 118	com/tencent/mobileqq/emosm/control/EmoAsyncStep:a	(I)V
    //   172: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +50 -> 225
    //   178: new 51	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   185: astore_1
    //   186: aload_1
    //   187: aload_0
    //   188: getfield 54	com/tencent/mobileqq/emosm/control/EmoAsyncStep:h	Ljava/lang/String;
    //   191: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_1
    //   196: ldc 124
    //   198: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_1
    //   203: invokestatic 112	android/os/SystemClock:uptimeMillis	()J
    //   206: aload_0
    //   207: getfield 41	com/tencent/mobileqq/emosm/control/EmoAsyncStep:b	J
    //   210: lsub
    //   211: invokevirtual 127	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: ldc 67
    //   217: iconst_1
    //   218: aload_1
    //   219: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload_0
    //   226: getfield 129	com/tencent/mobileqq/emosm/control/EmoAsyncStep:c	Lcom/tencent/mobileqq/emosm/control/IEmoResultListener;
    //   229: astore_1
    //   230: aload_1
    //   231: ifnull +90 -> 321
    //   234: aload_1
    //   235: aload_0
    //   236: aload_0
    //   237: getfield 29	com/tencent/mobileqq/emosm/control/EmoAsyncStep:d	I
    //   240: invokeinterface 139 3 0
    //   245: return
    //   246: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq +50 -> 299
    //   252: new 51	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   259: astore_2
    //   260: aload_2
    //   261: aload_0
    //   262: getfield 54	com/tencent/mobileqq/emosm/control/EmoAsyncStep:h	Ljava/lang/String;
    //   265: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_2
    //   270: ldc 124
    //   272: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_2
    //   277: invokestatic 112	android/os/SystemClock:uptimeMillis	()J
    //   280: aload_0
    //   281: getfield 41	com/tencent/mobileqq/emosm/control/EmoAsyncStep:b	J
    //   284: lsub
    //   285: invokevirtual 127	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: ldc 67
    //   291: iconst_1
    //   292: aload_2
    //   293: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload_0
    //   300: getfield 129	com/tencent/mobileqq/emosm/control/EmoAsyncStep:c	Lcom/tencent/mobileqq/emosm/control/IEmoResultListener;
    //   303: astore_2
    //   304: aload_2
    //   305: ifnull +14 -> 319
    //   308: aload_2
    //   309: aload_0
    //   310: aload_0
    //   311: getfield 29	com/tencent/mobileqq/emosm/control/EmoAsyncStep:d	I
    //   314: invokeinterface 139 3 0
    //   319: aload_1
    //   320: athrow
    //   321: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	EmoAsyncStep
    //   21	125	1	localObject1	Object
    //   152	1	1	localObject2	Object
    //   156	7	1	localThrowable	java.lang.Throwable
    //   185	135	1	localObject3	Object
    //   259	50	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   64	68	152	finally
    //   68	87	152	finally
    //   157	172	152	finally
    //   64	68	156	java/lang/Throwable
    //   68	87	156	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.control.EmoAsyncStep
 * JD-Core Version:    0.7.0.1
 */