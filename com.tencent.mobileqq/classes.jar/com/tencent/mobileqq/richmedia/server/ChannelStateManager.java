package com.tencent.mobileqq.richmedia.server;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ChannelStateManager
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private CopyOnWriteArrayList<Integer> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(10);
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public void a()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(10);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public void b(int paramInt)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public int c()
  {
    ??? = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if ((??? != null) && (!((CopyOnWriteArrayList)???).isEmpty())) {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        int i = ((Integer)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(0)).intValue();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          Object localObject3 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            int j = ((Integer)((Iterator)localObject3).next()).intValue();
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(j);
            localStringBuilder2.append(",");
            localStringBuilder1.append(localStringBuilder2.toString());
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getRecentTopEvent lastevent = ");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append("， eventlist = ");
          ((StringBuilder)localObject3).append(localStringBuilder1.toString());
          QLog.d("PeakAudioTransHandler ChannelStateManager", 2, ((StringBuilder)localObject3).toString());
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        return i;
      }
    }
    return -1;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, Integer.valueOf(paramInt));
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0;
  }
  
  public boolean d()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 12;
  }
  
  public boolean e()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 11;
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 10;
  }
  
  public boolean g()
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    int j = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    boolean bool2 = false;
    boolean bool1;
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            bool1 = bool2;
            break label203;
          }
          bool1 = bool2;
        }
      }
    }
    switch (j)
    {
    default: 
      bool1 = bool2;
      break;
      switch (j)
      {
      default: 
        bool1 = bool2;
        break label203;
        bool1 = bool2;
        switch (j)
        {
        default: 
          bool1 = bool2;
        }
        break;
      }
      break;
    case 10: 
      bool1 = true;
      break;
      bool1 = bool2;
      switch (j)
      {
      case 10: 
      default: 
        bool1 = bool2;
      }
      break;
    }
    label203:
    if ((!bool1) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isLegalState , currentSessionState = ");
      localStringBuilder.append(i);
      localStringBuilder.append(" currentTCPState = ");
      localStringBuilder.append(j);
      QLog.e("PeakAudioTransHandler ChannelStateManager", 2, localStringBuilder.toString());
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.server.ChannelStateManager
 * JD-Core Version:    0.7.0.1
 */