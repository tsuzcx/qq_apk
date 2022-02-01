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
    for (;;)
    {
      paramn = this.b;
      if (i >= paramn.length) {
        break;
      }
      paramn[i] = 0;
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
    if (paramInt != -1)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            localStringBuilder.append("Socket unknown");
          } else {
            localStringBuilder.append("success");
          }
        }
        else {
          localStringBuilder.append("checking");
        }
      }
      else {
        localStringBuilder.append("idle");
      }
    }
    else {
      localStringBuilder.append("error");
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  private void b(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 49	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: ldc 73
    //   13: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 4
    //   19: iload_1
    //   20: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: ldc 78
    //   26: iconst_1
    //   27: aload 4
    //   29: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: iconst_0
    //   36: istore_3
    //   37: iload_3
    //   38: aload_0
    //   39: getfield 23	com/tencent/mobileqq/msf/core/net/n$b:b	[I
    //   42: arraylength
    //   43: if_icmpge +15 -> 58
    //   46: aload_0
    //   47: iload_3
    //   48: invokevirtual 35	com/tencent/mobileqq/msf/core/net/n$b:a	(I)V
    //   51: iload_3
    //   52: iconst_1
    //   53: iadd
    //   54: istore_3
    //   55: goto -18 -> 37
    //   58: aload_0
    //   59: monitorenter
    //   60: aload_0
    //   61: getfield 16	com/tencent/mobileqq/msf/core/net/n$b:d	Lcom/tencent/mobileqq/msf/core/net/n;
    //   64: invokevirtual 86	com/tencent/mobileqq/msf/core/net/n:a	()I
    //   67: iload_2
    //   68: if_icmpeq +46 -> 114
    //   71: new 49	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   78: astore 4
    //   80: aload 4
    //   82: ldc 88
    //   84: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 4
    //   90: iload_2
    //   91: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: ldc 78
    //   97: iconst_1
    //   98: aload 4
    //   100: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload_0
    //   107: getfield 16	com/tencent/mobileqq/msf/core/net/n$b:d	Lcom/tencent/mobileqq/msf/core/net/n;
    //   110: iload_2
    //   111: invokevirtual 89	com/tencent/mobileqq/msf/core/net/n:a	(I)V
    //   114: aload_0
    //   115: iload_1
    //   116: putfield 21	com/tencent/mobileqq/msf/core/net/n$b:a	I
    //   119: iconst_0
    //   120: putstatic 95	com/tencent/mobileqq/msf/core/ac:P	Z
    //   123: aload_0
    //   124: invokevirtual 98	java/lang/Object:notifyAll	()V
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_0
    //   130: getfield 16	com/tencent/mobileqq/msf/core/net/n$b:d	Lcom/tencent/mobileqq/msf/core/net/n;
    //   133: iconst_0
    //   134: invokestatic 101	com/tencent/mobileqq/msf/core/net/n:d	(Lcom/tencent/mobileqq/msf/core/net/n;Z)V
    //   137: aload_0
    //   138: iload_1
    //   139: iload_2
    //   140: invokespecial 103	com/tencent/mobileqq/msf/core/net/n$b:c	(II)V
    //   143: return
    //   144: astore 4
    //   146: aload_0
    //   147: monitorexit
    //   148: goto +6 -> 154
    //   151: aload 4
    //   153: athrow
    //   154: goto -3 -> 151
    //   157: astore 4
    //   159: goto -32 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	b
    //   0	162	1	paramInt1	int
    //   0	162	2	paramInt2	int
    //   36	19	3	i	int
    //   7	92	4	localStringBuilder	StringBuilder
    //   144	8	4	localObject	Object
    //   157	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   60	114	144	finally
    //   114	119	144	finally
    //   119	127	144	finally
    //   127	129	144	finally
    //   146	148	144	finally
    //   119	127	157	java/lang/Exception
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
    if (paramInt != -1)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              localStringBuilder.append("Socket unknown");
            } else {
              localStringBuilder.append("Socket success");
            }
          }
          else {
            localStringBuilder.append("Socket pinging");
          }
        }
        else {
          localStringBuilder.append("Socket connecting");
        }
      }
      else {
        localStringBuilder.append("Socket idle");
      }
    }
    else {
      localStringBuilder.append("Socket error");
    }
    return localStringBuilder.toString();
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (i == 0) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    for (;;)
    {
      try
      {
        if (this.d.d(i).j() != 1) {
          break label171;
        }
        long l1 = this.d.b(i);
        long l2 = this.d.b(paramInt2);
        if (this.b[i] != 3) {
          break label182;
        }
        bool1 = true;
        if (this.b[paramInt2] != 3) {
          break label188;
        }
        bool2 = true;
        String str = this.d.l().d.c();
        if (this.d.f.getStatReporter() != null)
        {
          j localj = this.d.f.getStatReporter();
          if (paramInt1 != 2) {
            break label194;
          }
          bool3 = true;
          localj.a(bool3, l1, bool1, l2, bool2, str);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DualConnContext", 1, "reportDualEvent fail!", localException);
        }
      }
      return;
      label171:
      int j = i;
      i = paramInt2;
      paramInt2 = j;
      continue;
      label182:
      boolean bool1 = false;
      continue;
      label188:
      boolean bool2 = false;
      continue;
      label194:
      boolean bool3 = false;
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeConnectionChecker: remove connId = ");
    localStringBuilder.append(paramInt);
    QLog.d("DualConnContext", 1, localStringBuilder.toString());
    n.c(this.d).removeCallbacks(this.c[paramInt]);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, 10000L);
  }
  
  public boolean a(int paramInt1, int paramInt2, long paramLong)
  {
    for (;;)
    {
      boolean bool1;
      int i;
      try
      {
        int j = this.b[paramInt2];
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onNextState connId = ");
        ((StringBuilder)localObject1).append(paramInt2);
        ((StringBuilder)localObject1).append(", connState = ");
        ((StringBuilder)localObject1).append(c(paramInt1));
        ((StringBuilder)localObject1).append(", preState = ");
        ((StringBuilder)localObject1).append(c(j));
        ((StringBuilder)localObject1).append(", remainTime = ");
        ((StringBuilder)localObject1).append(paramLong);
        localObject1 = ((StringBuilder)localObject1).toString();
        bool1 = true;
        boolean bool2 = true;
        QLog.d("DualConnContext", 1, (String)localObject1);
        if (j == paramInt1)
        {
          bool2 = bool1;
          continue;
          bool1 = bool2;
          if (j == 2)
          {
            this.b[paramInt2] = paramInt1;
            a(i, paramLong);
            bool1 = bool2;
            continue;
            this.b[paramInt2] = paramInt1;
            a(paramInt2, paramLong);
            bool1 = bool2;
            continue;
            this.b[paramInt2] = paramInt1;
            bool1 = bool2;
            continue;
            a(paramInt2);
            this.d.a(a.F, paramInt2);
            this.b[paramInt2] = paramInt1;
            bool1 = bool2;
          }
          j = this.b[i];
          if ((paramInt1 == 3) && (j == -1))
          {
            b(2, paramInt2);
            bool2 = bool1;
          }
          else if ((j == 3) && (paramInt1 == -1))
          {
            b(2, i);
            bool2 = bool1;
          }
          else
          {
            bool2 = bool1;
            if (j == -1)
            {
              bool2 = bool1;
              if (paramInt1 == -1)
              {
                b(-1, this.d.a());
                bool2 = bool1;
              }
            }
          }
          return bool2;
        }
      }
      finally {}
      if (paramInt2 == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramInt1 != -1) {
        if (paramInt1 != 1) {
          if (paramInt1 != 2) {
            if (paramInt1 != 3) {
              bool1 = false;
            }
          }
        }
      }
    }
  }
  
  public boolean a(CopyOnWriteArrayList paramCopyOnWriteArrayList1, CopyOnWriteArrayList paramCopyOnWriteArrayList2, CopyOnWriteArrayList paramCopyOnWriteArrayList3, CopyOnWriteArrayList paramCopyOnWriteArrayList4, ArrayList paramArrayList)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ensureDualConn start, mDualConnState = ");
      localStringBuilder.append(b(this.a));
      QLog.d("DualConnContext", 1, localStringBuilder.toString());
      int i = this.a;
      boolean bool = false;
      if ((i == 0) || (this.a == -1))
      {
        a(false);
        this.a = 1;
      }
      i = this.a;
      if (i == 1) {
        try
        {
          b(paramCopyOnWriteArrayList1, paramCopyOnWriteArrayList2, paramCopyOnWriteArrayList3, paramCopyOnWriteArrayList4, paramArrayList);
          wait();
        }
        catch (Exception paramCopyOnWriteArrayList1)
        {
          QLog.d("DualConnContext", 1, "ensureDualConn wait fail", paramCopyOnWriteArrayList1);
        }
      }
      if (2 == this.a) {
        bool = true;
      }
      return bool;
    }
    finally {}
  }
  
  public boolean a(boolean paramBoolean)
  {
    try
    {
      QLog.d("DualConnContext", 1, " reset");
      int k = 0;
      this.a = 0;
      int i = 0;
      for (;;)
      {
        j = k;
        if (i >= this.b.length) {
          break;
        }
        this.b[i] = 0;
        i += 1;
      }
    }
    finally
    {
      for (;;)
      {
        int j;
        for (;;)
        {
          throw localObject;
        }
        j += 1;
      }
    }
    if (j < this.b.length)
    {
      if (this.c[j] != null) {
        a(j);
      } else {
        this.c[j] = new n.b.a(this, j);
      }
    }
    else
    {
      if (paramBoolean) {
        notifyAll();
      }
      return true;
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: ldc 78
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
    //   20: ldc 78
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.n.b
 * JD-Core Version:    0.7.0.1
 */