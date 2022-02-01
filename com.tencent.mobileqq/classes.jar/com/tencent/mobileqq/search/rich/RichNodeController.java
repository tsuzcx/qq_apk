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
  private static String jdField_a_of_type_JavaLangString = "RichNodeController";
  private static final Set<WeakReference<IRichNode>> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private Map<Integer, RichNodeController.NodeInfo> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private int b;
  private int c;
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaUtilSet)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy.(item == null");
          }
          localIterator.remove();
        }
        else
        {
          localObject2 = (IRichNode)((WeakReference)localObject2).get();
          if (localObject2 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy.(node == null");
            }
            localIterator.remove();
          }
          else
          {
            a((IRichNode)localObject2);
            ((IRichNode)localObject2).d();
          }
        }
      }
      jdField_a_of_type_JavaUtilSet.clear();
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
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("pauseAll, puase:");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(" startPos:");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(" endPos:");
      ((StringBuilder)localObject2).append(this.c);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (this.jdField_a_of_type_JavaUtilMap.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "pauseAll, map is empty");
      }
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RichNodeController.NodeInfo)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = ((RichNodeController.NodeInfo)localObject2).a;
        if (localObject2 != null)
        {
          localObject2 = (IRichNode)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            if (paramBoolean) {
              ((IRichNode)localObject2).b();
            } else {
              ((IRichNode)localObject2).c();
            }
          }
        }
      }
    }
  }
  
  public static void b()
  {
    synchronized (jdField_a_of_type_JavaUtilSet)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onPause item == null");
          }
          localIterator.remove();
        }
        else
        {
          localObject2 = (IRichNode)((WeakReference)localObject2).get();
          if (localObject2 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onPause node == null");
            }
            localIterator.remove();
          }
          else
          {
            ((IRichNode)localObject2).b();
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
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("restartPlayTimer:");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (paramInt < 0) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new RichNodeController.1(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt);
  }
  
  public static void c() {}
  
  public static void d() {}
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 0) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      Object localObject2 = (RichNodeController.NodeInfo)((Map.Entry)localObject1).getValue();
      if (localObject2 == null)
      {
        localIterator.remove();
      }
      else if (((RichNodeController.NodeInfo)localObject2).a == null)
      {
        localIterator.remove();
      }
      else
      {
        localObject2 = (IRichNode)((RichNodeController.NodeInfo)localObject2).a.get();
        if (localObject2 == null)
        {
          localIterator.remove();
        }
        else
        {
          localObject1 = (Integer)((Map.Entry)localObject1).getKey();
          if (localObject1 == null)
          {
            ((IRichNode)localObject2).b();
            localIterator.remove();
          }
          else if ((((Integer)localObject1).intValue() < this.b) || (((Integer)localObject1).intValue() > this.c))
          {
            ((IRichNode)localObject2).b();
            localIterator.remove();
          }
        }
      }
    }
  }
  
  private static void f()
  {
    synchronized (jdField_a_of_type_JavaUtilSet)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onPause item == null");
          }
          localIterator.remove();
        }
        else
        {
          localObject2 = (IRichNode)((WeakReference)localObject2).get();
          if (localObject2 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onPause node == null");
            }
            localIterator.remove();
          }
          else
          {
            ((IRichNode)localObject2).c();
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
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 0)
    {
      b(100);
      return;
    }
    b(-1);
    b();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == this.b) && (this.c == paramInt1 + paramInt2)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setScorllData, mStartPos:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" endPos:");
      localStringBuilder.append(this.c);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.b = paramInt1;
    this.c = (paramInt1 + paramInt2);
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
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("registerNode, nPos:");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), new RichNodeController.NodeInfo(paramInt, paramIRichNode));
    if (this.jdField_a_of_type_Int != 0) {
      paramIRichNode.b();
    } else {
      paramIRichNode.c();
    }
    Object localObject1 = jdField_a_of_type_JavaUtilSet;
    boolean bool2 = false;
    try
    {
      localObject2 = jdField_a_of_type_JavaUtilSet.iterator();
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
        localObject2 = jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("find in list:");
        ((StringBuilder)localObject3).append(bool1);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      if (!bool1) {
        jdField_a_of_type_JavaUtilSet.add(new WeakReference(paramIRichNode));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.RichNodeController
 * JD-Core Version:    0.7.0.1
 */