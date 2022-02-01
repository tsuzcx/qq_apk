package com.tencent.mobileqq.uftransfer.common;

import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class UFTRunnableQueue
{
  private static long jdField_a_of_type_Long = 1L;
  private final UFTRunnableQueue.IRunnableCallback jdField_a_of_type_ComTencentMobileqqUftransferCommonUFTRunnableQueue$IRunnableCallback = new UFTRunnableQueue.1(this);
  private final LinkedList<Long> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private final Map<Long, UFTRunnableQueue.IUFTRunnable> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final LinkedList<UFTRunnableQueue.IUFTRunnable> b = new LinkedList();
  
  private void a()
  {
    if (this.b.size() >= a()) {
      return;
    }
    while (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      long l = ((Long)this.jdField_a_of_type_JavaUtilLinkedList.remove(0)).longValue();
      UFTRunnableQueue.IUFTRunnable localIUFTRunnable = (UFTRunnableQueue.IUFTRunnable)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(l));
      if (localIUFTRunnable != null) {
        if (a(localIUFTRunnable))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[");
          localStringBuilder.append(localIUFTRunnable.a());
          localStringBuilder.append("] has same runnable. add wd task");
          UFTLog.c("[UFTTransfer] UFTRunnableQueue", 1, localStringBuilder.toString());
        }
        else
        {
          this.b.add(localIUFTRunnable);
          if (localIUFTRunnable.a(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonUFTRunnableQueue$IRunnableCallback)) {
            break;
          }
          this.b.remove(localIUFTRunnable);
        }
      }
    }
  }
  
  private boolean a(long paramLong)
  {
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      UFTRunnableQueue.IUFTRunnable localIUFTRunnable = (UFTRunnableQueue.IUFTRunnable)((Iterator)localObject).next();
      if (paramLong == localIUFTRunnable.a())
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
      this.jdField_a_of_type_JavaUtilLinkedList.remove(Long.valueOf(paramLong));
      if ((UFTRunnableQueue.IUFTRunnable)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong)) != null) {
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
      ((StringBuilder)localObject).append(a());
      UFTLog.b("[UFTTransfer] UFTRunnableQueue", 1, ((StringBuilder)localObject).toString());
    }
    return bool2;
  }
  
  private boolean a(UFTRunnableQueue.IUFTRunnable paramIUFTRunnable)
  {
    if (paramIUFTRunnable == null) {
      return false;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (paramIUFTRunnable.a((UFTRunnableQueue.IUFTRunnable)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  protected int a()
  {
    return 4;
  }
  
  public long a(UFTRunnableQueue.IUFTRunnable paramIUFTRunnable)
  {
    long l2 = jdField_a_of_type_Long;
    jdField_a_of_type_Long = l2 + 1L;
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = jdField_a_of_type_Long;
      jdField_a_of_type_Long = 1L + l1;
    }
    paramIUFTRunnable.b(l1);
    UFTLogicThread.a().a(new UFTRunnableQueue.2(this, l1, paramIUFTRunnable));
    return l1;
  }
  
  protected String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ws:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilMap.size());
    localStringBuilder.append(" qs:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilLinkedList.size());
    localStringBuilder.append(" rs:");
    localStringBuilder.append(this.b.size());
    return localStringBuilder.toString();
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt, UFTRunnableQueue.IUFTRunnable paramIUFTRunnable)
  {
    this.b.remove(paramIUFTRunnable);
    paramIUFTRunnable = new StringBuilder();
    paramIUFTRunnable.append("[");
    paramIUFTRunnable.append(paramLong);
    paramIUFTRunnable.append("] on runnable done. ");
    paramIUFTRunnable.append(a());
    UFTLog.b("[UFTTransfer] UFTRunnableQueue", 1, paramIUFTRunnable.toString());
    a();
  }
  
  public void b(long paramLong)
  {
    UFTLogicThread.a().a(new UFTRunnableQueue.3(this, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.UFTRunnableQueue
 * JD-Core Version:    0.7.0.1
 */