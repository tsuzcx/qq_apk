package com.tencent.mobileqq.uftransfer.common;

import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class UFTRunnableQueue
{
  private static long a = 1L;
  private final Map<Long, UFTRunnableQueue.IUFTRunnable> b = new HashMap();
  private final LinkedList<Long> c = new LinkedList();
  private final LinkedList<UFTRunnableQueue.IUFTRunnable> d = new LinkedList();
  private final UFTRunnableQueue.IRunnableCallback e = new UFTRunnableQueue.1(this);
  
  private void a()
  {
    if (this.d.size() >= b()) {
      return;
    }
    while (this.c.size() > 0)
    {
      long l = ((Long)this.c.remove(0)).longValue();
      UFTRunnableQueue.IUFTRunnable localIUFTRunnable = (UFTRunnableQueue.IUFTRunnable)this.b.remove(Long.valueOf(l));
      if (localIUFTRunnable != null) {
        if (b(localIUFTRunnable))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[");
          localStringBuilder.append(localIUFTRunnable.e());
          localStringBuilder.append("] has same runnable. add wd task");
          UFTLog.c("[UFTTransfer] UFTRunnableQueue", 1, localStringBuilder.toString());
        }
        else
        {
          this.d.add(localIUFTRunnable);
          if (localIUFTRunnable.a(this.e)) {
            break;
          }
          this.d.remove(localIUFTRunnable);
        }
      }
    }
  }
  
  private boolean a(long paramLong)
  {
    Object localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext())
    {
      UFTRunnableQueue.IUFTRunnable localIUFTRunnable = (UFTRunnableQueue.IUFTRunnable)((Iterator)localObject).next();
      if (paramLong == localIUFTRunnable.e())
      {
        localIUFTRunnable.a();
        ((Iterator)localObject).remove();
        bool1 = true;
        break label64;
      }
    }
    boolean bool1 = false;
    label64:
    boolean bool2 = bool1;
    if (!bool1)
    {
      this.c.remove(Long.valueOf(paramLong));
      if ((UFTRunnableQueue.IUFTRunnable)this.b.remove(Long.valueOf(paramLong)) != null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
    }
    if (bool2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("] stop Runnable.");
      ((StringBuilder)localObject).append(c());
      UFTLog.b("[UFTTransfer] UFTRunnableQueue", 1, ((StringBuilder)localObject).toString());
    }
    return bool2;
  }
  
  private boolean b(UFTRunnableQueue.IUFTRunnable paramIUFTRunnable)
  {
    if (paramIUFTRunnable == null) {
      return false;
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      if (paramIUFTRunnable.a((UFTRunnableQueue.IUFTRunnable)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public long a(UFTRunnableQueue.IUFTRunnable paramIUFTRunnable)
  {
    long l2 = a;
    a = l2 + 1L;
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = a;
      a = 1L + l1;
    }
    paramIUFTRunnable.b(l1);
    UFTLogicThread.a().a(new UFTRunnableQueue.2(this, l1, paramIUFTRunnable));
    return l1;
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt, UFTRunnableQueue.IUFTRunnable paramIUFTRunnable)
  {
    this.d.remove(paramIUFTRunnable);
    paramIUFTRunnable = new StringBuilder();
    paramIUFTRunnable.append("[");
    paramIUFTRunnable.append(paramLong);
    paramIUFTRunnable.append("] on runnable done. ");
    paramIUFTRunnable.append(c());
    UFTLog.b("[UFTTransfer] UFTRunnableQueue", 1, paramIUFTRunnable.toString());
    a();
  }
  
  protected int b()
  {
    return 4;
  }
  
  public void b(long paramLong)
  {
    UFTLogicThread.a().a(new UFTRunnableQueue.3(this, paramLong));
  }
  
  protected String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ws:");
    localStringBuilder.append(this.b.size());
    localStringBuilder.append(" qs:");
    localStringBuilder.append(this.c.size());
    localStringBuilder.append(" rs:");
    localStringBuilder.append(this.d.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.UFTRunnableQueue
 * JD-Core Version:    0.7.0.1
 */