package com.tencent.mobileqq.search.rich;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class RichNodeController
{
  private static String a = "RichNodeController";
  private static final Set<WeakReference<IRichNode>> h = Collections.synchronizedSet(new HashSet());
  private Map<Integer, RichNodeController.NodeInfo> b = new ConcurrentHashMap();
  private int c = 0;
  private int d;
  private int e;
  private Runnable f;
  private Handler g = null;
  
  public static void a()
  {
    synchronized (h)
    {
      Iterator localIterator = h.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "onDestroy.(item == null");
          }
          localIterator.remove();
        }
        else
        {
          localObject2 = (IRichNode)((WeakReference)localObject2).get();
          if (localObject2 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(a, 2, "onDestroy.(node == null");
            }
            localIterator.remove();
          }
          else
          {
            a((IRichNode)localObject2);
            ((IRichNode)localObject2).g();
          }
        }
      }
      h.clear();
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  private static void a(IRichNode paramIRichNode) {}
  
  private void a(boolean paramBoolean)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("pauseAll, puase:");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(" startPos:");
      ((StringBuilder)localObject2).append(this.d);
      ((StringBuilder)localObject2).append(" endPos:");
      ((StringBuilder)localObject2).append(this.e);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (this.b.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "pauseAll, map is empty");
      }
      return;
    }
    Object localObject1 = this.b.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RichNodeController.NodeInfo)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = ((RichNodeController.NodeInfo)localObject2).b;
        if (localObject2 != null)
        {
          localObject2 = (IRichNode)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            if (paramBoolean) {
              ((IRichNode)localObject2).e();
            } else {
              ((IRichNode)localObject2).f();
            }
          }
        }
      }
    }
  }
  
  public static void b()
  {
    synchronized (h)
    {
      Iterator localIterator = h.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "onPause item == null");
          }
          localIterator.remove();
        }
        else
        {
          localObject2 = (IRichNode)((WeakReference)localObject2).get();
          if (localObject2 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(a, 2, "onPause node == null");
            }
            localIterator.remove();
          }
          else
          {
            ((IRichNode)localObject2).e();
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("restartPlayTimer:");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.g == null) {
      this.g = new Handler(Looper.getMainLooper());
    }
    if (this.f != null) {
      this.g.removeCallbacksAndMessages(null);
    }
    if (paramInt < 0) {
      return;
    }
    if (this.f == null) {
      this.f = new RichNodeController.1(this);
    }
    this.g.postDelayed(this.f, paramInt);
  }
  
  public static void c() {}
  
  public static void d() {}
  
  private void e()
  {
    if (this.b.size() == 0) {
      return;
    }
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      Object localObject2 = (RichNodeController.NodeInfo)((Map.Entry)localObject1).getValue();
      if (localObject2 == null)
      {
        localIterator.remove();
      }
      else if (((RichNodeController.NodeInfo)localObject2).b == null)
      {
        localIterator.remove();
      }
      else
      {
        localObject2 = (IRichNode)((RichNodeController.NodeInfo)localObject2).b.get();
        if (localObject2 == null)
        {
          localIterator.remove();
        }
        else
        {
          localObject1 = (Integer)((Map.Entry)localObject1).getKey();
          if (localObject1 == null)
          {
            ((IRichNode)localObject2).e();
            localIterator.remove();
          }
          else if ((((Integer)localObject1).intValue() < this.d) || (((Integer)localObject1).intValue() > this.e))
          {
            ((IRichNode)localObject2).e();
            localIterator.remove();
          }
        }
      }
    }
  }
  
  private static void f()
  {
    synchronized (h)
    {
      Iterator localIterator = h.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "onPause item == null");
          }
          localIterator.remove();
        }
        else
        {
          localObject2 = (IRichNode)((WeakReference)localObject2).get();
          if (localObject2 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(a, 2, "onPause node == null");
            }
            localIterator.remove();
          }
          else
          {
            ((IRichNode)localObject2).f();
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
    if (this.c == 0)
    {
      b(100);
      return;
    }
    b(-1);
    b();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == this.d) && (this.e == paramInt1 + paramInt2)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setScorllData, mStartPos:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" endPos:");
      localStringBuilder.append(this.e);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.d = paramInt1;
    this.e = (paramInt1 + paramInt2);
    e();
  }
  
  public void a(int paramInt, IRichNode paramIRichNode)
  {
    if (paramIRichNode == null) {
      return;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("registerNode, nPos:");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    this.b.put(Integer.valueOf(paramInt), new RichNodeController.NodeInfo(paramInt, paramIRichNode));
    if (this.c != 0) {
      paramIRichNode.e();
    } else {
      paramIRichNode.f();
    }
    Object localObject1 = h;
    boolean bool2 = false;
    try
    {
      localObject2 = h.iterator();
      Object localObject3;
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (WeakReference)((Iterator)localObject2).next();
      } while ((localObject3 == null) || (((WeakReference)localObject3).get() != paramIRichNode));
      boolean bool1 = true;
      if (QLog.isColorLevel())
      {
        localObject2 = a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("find in list:");
        ((StringBuilder)localObject3).append(bool1);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      if (!bool1) {
        h.add(new WeakReference(paramIRichNode));
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramIRichNode;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.RichNodeController
 * JD-Core Version:    0.7.0.1
 */