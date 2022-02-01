package com.tencent.mobileqq.msf.core.net;

import android.os.Handler;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ak;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.qphone.base.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

class n$b
{
  public int a = 0;
  public int[] b = new int[2];
  public n.b.a[] c = new n.b.a[2];
  
  public n$b(n paramn)
  {
    int i = 0;
    while (i < this.b.length)
    {
      this.b[i] = 0;
      this.c[i] = new n.b.a(this, i);
      i += 1;
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    a(paramInt);
    n.c(this.d).postDelayed(this.c[paramInt], paramLong);
  }
  
  private String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt)
    {
    default: 
      localStringBuilder.append("Socket unknown");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("idle");
      continue;
      localStringBuilder.append("checking");
      continue;
      localStringBuilder.append("success");
      continue;
      localStringBuilder.append("error");
    }
  }
  
  /* Error */
  private void b(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 73
    //   2: iconst_1
    //   3: new 49	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   10: ldc 75
    //   12: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: iload_1
    //   16: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: iconst_0
    //   26: istore_3
    //   27: iload_3
    //   28: aload_0
    //   29: getfield 23	com/tencent/mobileqq/msf/core/net/n$b:b	[I
    //   32: arraylength
    //   33: if_icmpge +15 -> 48
    //   36: aload_0
    //   37: iload_3
    //   38: invokevirtual 35	com/tencent/mobileqq/msf/core/net/n$b:a	(I)V
    //   41: iload_3
    //   42: iconst_1
    //   43: iadd
    //   44: istore_3
    //   45: goto -18 -> 27
    //   48: aload_0
    //   49: monitorenter
    //   50: aload_0
    //   51: getfield 16	com/tencent/mobileqq/msf/core/net/n$b:d	Lcom/tencent/mobileqq/msf/core/net/n;
    //   54: invokevirtual 86	com/tencent/mobileqq/msf/core/net/n:a	()I
    //   57: iload_2
    //   58: if_icmpeq +36 -> 94
    //   61: ldc 73
    //   63: iconst_1
    //   64: new 49	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   71: ldc 88
    //   73: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: iload_2
    //   77: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: aload_0
    //   87: getfield 16	com/tencent/mobileqq/msf/core/net/n$b:d	Lcom/tencent/mobileqq/msf/core/net/n;
    //   90: iload_2
    //   91: invokevirtual 89	com/tencent/mobileqq/msf/core/net/n:a	(I)V
    //   94: aload_0
    //   95: iload_1
    //   96: putfield 21	com/tencent/mobileqq/msf/core/net/n$b:a	I
    //   99: iconst_0
    //   100: putstatic 95	com/tencent/mobileqq/msf/core/ac:P	Z
    //   103: aload_0
    //   104: invokevirtual 98	java/lang/Object:notifyAll	()V
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_0
    //   110: getfield 16	com/tencent/mobileqq/msf/core/net/n$b:d	Lcom/tencent/mobileqq/msf/core/net/n;
    //   113: iconst_0
    //   114: invokestatic 101	com/tencent/mobileqq/msf/core/net/n:d	(Lcom/tencent/mobileqq/msf/core/net/n;Z)V
    //   117: aload_0
    //   118: iload_1
    //   119: iload_2
    //   120: invokespecial 103	com/tencent/mobileqq/msf/core/net/n$b:c	(II)V
    //   123: return
    //   124: astore 4
    //   126: aload_0
    //   127: monitorexit
    //   128: aload 4
    //   130: athrow
    //   131: astore 4
    //   133: goto -26 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	b
    //   0	136	1	paramInt1	int
    //   0	136	2	paramInt2	int
    //   26	19	3	i	int
    //   124	5	4	localObject	Object
    //   131	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   50	94	124	finally
    //   94	99	124	finally
    //   99	107	124	finally
    //   107	109	124	finally
    //   126	128	124	finally
    //   99	107	131	java/lang/Exception
  }
  
  private void b(CopyOnWriteArrayList paramCopyOnWriteArrayList1, CopyOnWriteArrayList paramCopyOnWriteArrayList2, CopyOnWriteArrayList paramCopyOnWriteArrayList3, CopyOnWriteArrayList paramCopyOnWriteArrayList4, ArrayList paramArrayList)
  {
    ak.a(String.format("开始竞速: delay %d..", new Object[] { Long.valueOf(this.d.f.delayIpRace.get()) }));
    com.tencent.mobileqq.msf.core.ac.P = true;
    ArrayList localArrayList = new ArrayList();
    n.b(this.d, paramCopyOnWriteArrayList3, paramCopyOnWriteArrayList4, localArrayList, 1);
    n.b(this.d, paramCopyOnWriteArrayList1, paramCopyOnWriteArrayList2, paramArrayList, 0);
  }
  
  private String c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt)
    {
    default: 
      localStringBuilder.append("Socket unknown");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("Socket error");
      continue;
      localStringBuilder.append("Socket idle");
      continue;
      localStringBuilder.append("Socket connecting");
      continue;
      localStringBuilder.append("Socket pinging");
      continue;
      localStringBuilder.append("Socket success");
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    boolean bool3 = false;
    int i;
    int k;
    int j;
    if (paramInt2 == 0)
    {
      i = 1;
      k = i;
      j = paramInt2;
    }
    for (;;)
    {
      try
      {
        if (this.d.d(paramInt2).j() == 1)
        {
          j = i;
          k = paramInt2;
        }
        long l1 = this.d.b(k);
        long l2 = this.d.b(j);
        if (this.b[k] != 3) {
          continue;
        }
        bool1 = true;
        if (this.b[j] != 3) {
          continue;
        }
        bool2 = true;
        String str = this.d.l().d.c();
        if (this.d.f.getStatReporter() != null)
        {
          j localj = this.d.f.getStatReporter();
          if (paramInt1 == 2) {
            bool3 = true;
          }
          localj.a(bool3, l1, bool1, l2, bool2, str);
        }
        return;
      }
      catch (Exception localException)
      {
        boolean bool1;
        boolean bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("DualConnContext", 1, "reportDualEvent fail!", localException);
      }
      i = 0;
      break;
      bool1 = false;
      continue;
      bool2 = false;
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    QLog.d("DualConnContext", 1, "removeConnectionChecker: remove connId = " + paramInt);
    n.c(this.d).removeCallbacks(this.c[paramInt]);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, 10000L);
  }
  
  public boolean a(int paramInt1, int paramInt2, long paramLong)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    for (;;)
    {
      label92:
      int i;
      try
      {
        j = this.b[paramInt2];
        QLog.d("DualConnContext", 1, "onNextState connId = " + paramInt2 + ", connState = " + c(paramInt1) + ", preState = " + c(j) + ", remainTime = " + paramLong);
        if (j != paramInt1) {
          break label296;
        }
        bool2 = bool1;
        return bool2;
      }
      finally {}
      int j = this.b[i];
      if ((paramInt1 == 3) && (j == -1))
      {
        b(2, paramInt2);
        bool2 = bool1;
      }
      else
      {
        label296:
        while (paramInt2 != 0)
        {
          i = 0;
          break label303;
          this.b[paramInt2] = paramInt1;
          bool1 = bool2;
          break label92;
          this.b[paramInt2] = paramInt1;
          a(paramInt2, paramLong);
          bool1 = bool2;
          break label92;
          bool1 = bool2;
          if (j != 2) {
            break label92;
          }
          this.b[paramInt2] = paramInt1;
          a(i, paramLong);
          bool1 = bool2;
          break label92;
          a(paramInt2);
          this.d.a(a.F, paramInt2);
          this.b[paramInt2] = paramInt1;
          bool1 = bool2;
          break label92;
          if ((j == 3) && (paramInt1 == -1))
          {
            b(2, i);
            bool2 = bool1;
            break;
          }
          bool2 = bool1;
          if (j != -1) {
            break;
          }
          bool2 = bool1;
          if (paramInt1 != -1) {
            break;
          }
          b(-1, this.d.a());
          bool2 = bool1;
          break;
        }
        i = 1;
        label303:
        switch (paramInt1)
        {
        }
        bool1 = false;
      }
    }
  }
  
  public boolean a(CopyOnWriteArrayList paramCopyOnWriteArrayList1, CopyOnWriteArrayList paramCopyOnWriteArrayList2, CopyOnWriteArrayList paramCopyOnWriteArrayList3, CopyOnWriteArrayList paramCopyOnWriteArrayList4, ArrayList paramArrayList)
  {
    for (;;)
    {
      try
      {
        QLog.d("DualConnContext", 1, "ensureDualConn start, mDualConnState = " + b(this.a));
        if ((this.a == 0) || (this.a == -1))
        {
          a(false);
          this.a = 1;
        }
        int i = this.a;
        if (i == 1) {}
        try
        {
          b(paramCopyOnWriteArrayList1, paramCopyOnWriteArrayList2, paramCopyOnWriteArrayList3, paramCopyOnWriteArrayList4, paramArrayList);
          wait();
          if (2 == this.a)
          {
            bool = true;
            return bool;
          }
        }
        catch (Exception paramCopyOnWriteArrayList1)
        {
          QLog.d("DualConnContext", 1, "ensureDualConn wait fail", paramCopyOnWriteArrayList1);
          continue;
        }
        boolean bool = false;
      }
      finally {}
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    int k = 0;
    for (;;)
    {
      int j;
      try
      {
        QLog.d("DualConnContext", 1, " reset");
        this.a = 0;
        int i = 0;
        j = k;
        if (i < this.b.length)
        {
          this.b[i] = 0;
          i += 1;
          continue;
        }
        if (j < this.b.length) {
          if (this.c[j] != null) {
            a(j);
          } else {
            this.c[j] = new n.b.a(this, j);
          }
        }
      }
      finally {}
      if (paramBoolean) {
        notifyAll();
      }
      return true;
      j += 1;
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: ldc 73
    //   2: iconst_1
    //   3: ldc 255
    //   5: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 21	com/tencent/mobileqq/msf/core/net/n$b:a	I
    //   14: istore_1
    //   15: iload_1
    //   16: iconst_1
    //   17: if_icmpne +16 -> 33
    //   20: ldc 73
    //   22: iconst_1
    //   23: ldc_w 257
    //   26: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: aload_0
    //   30: invokevirtual 247	java/lang/Object:wait	()V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    //   41: astore_2
    //   42: goto -9 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	b
    //   14	4	1	i	int
    //   36	4	2	localObject	Object
    //   41	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   10	15	36	finally
    //   20	33	36	finally
    //   33	35	36	finally
    //   37	39	36	finally
    //   20	33	41	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.n.b
 * JD-Core Version:    0.7.0.1
 */