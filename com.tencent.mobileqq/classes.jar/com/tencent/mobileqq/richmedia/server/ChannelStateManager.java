package com.tencent.mobileqq.richmedia.server;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ChannelStateManager
{
  private AtomicInteger a = new AtomicInteger(0);
  private AtomicInteger b = new AtomicInteger(10);
  private final Object c = new Object();
  private final Object d = new Object();
  private CopyOnWriteArrayList<Integer> e = new CopyOnWriteArrayList();
  
  public int a()
  {
    return this.a.get();
  }
  
  public void a(int paramInt)
  {
    synchronized (this.d)
    {
      this.a.set(paramInt);
      return;
    }
  }
  
  public int b()
  {
    return this.b.get();
  }
  
  public void b(int paramInt)
  {
    synchronized (this.d)
    {
      this.b.set(paramInt);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    this.e.add(0, Integer.valueOf(paramInt));
  }
  
  public boolean c()
  {
    return this.a.get() == 2;
  }
  
  public boolean d()
  {
    return this.a.get() == 1;
  }
  
  public boolean e()
  {
    return this.a.get() == 0;
  }
  
  public int f()
  {
    ??? = this.e;
    if ((??? != null) && (!((CopyOnWriteArrayList)???).isEmpty())) {
      synchronized (this.d)
      {
        int i = ((Integer)this.e.get(0)).intValue();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          Object localObject3 = this.e.iterator();
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
        this.e.clear();
        return i;
      }
    }
    return -1;
  }
  
  public boolean g()
  {
    return this.b.get() == 12;
  }
  
  public boolean h()
  {
    return this.b.get() == 11;
  }
  
  public boolean i()
  {
    return this.b.get() == 10;
  }
  
  public void j()
  {
    synchronized (this.d)
    {
      if (this.e != null) {
        this.e.clear();
      }
      this.a.set(0);
      this.b.set(10);
      return;
    }
  }
  
  public boolean k()
  {
    int i = this.a.get();
    int j = this.b.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.server.ChannelStateManager
 * JD-Core Version:    0.7.0.1
 */