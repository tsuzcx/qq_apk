package com.tencent.mobileqq.nearby.smooth;

import afqd;
import afqe;
import afqf;
import afqg;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Adapter;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ItemLoader
{
  public Handler a;
  Map jdField_a_of_type_JavaUtilMap;
  ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  public Map b;
  
  static String a(int paramInt1, int paramInt2)
  {
    return String.valueOf(paramInt1) + String.valueOf(paramInt2);
  }
  
  public int a(Adapter paramAdapter, int paramInt)
  {
    return 1;
  }
  
  afqf a(View paramView)
  {
    afqf localafqf2 = (afqf)this.jdField_a_of_type_JavaUtilMap.get(paramView);
    afqf localafqf1 = localafqf2;
    if (localafqf2 == null)
    {
      localafqf1 = new afqf();
      localafqf1.jdField_a_of_type_JavaLangObject = null;
      localafqf1.jdField_a_of_type_Boolean = false;
      localafqf1.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaUtilMap.put(paramView, localafqf1);
    }
    return localafqf1;
  }
  
  public abstract Object a(Adapter paramAdapter, int paramInt);
  
  public abstract Object a(Object paramObject, int paramInt);
  
  void a(int paramInt1, int paramInt2)
  {
    String str = a(paramInt1, paramInt2);
    afqe localafqe = (afqe)this.b.get(str);
    if (localafqe == null) {}
    do
    {
      return;
      this.b.remove(str);
    } while (localafqe.jdField_a_of_type_JavaUtilConcurrentFuture == null);
    localafqe.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
  }
  
  void a(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("Null itemContainer in cancelRequestsForContainer");
    }
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      afqe localafqe = (afqe)localIterator.next();
      if ((View)localafqe.jdField_a_of_type_JavaLangRefSoftReference.get() == paramView)
      {
        if (localafqe.jdField_a_of_type_JavaUtilConcurrentFuture != null) {
          localafqe.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
        }
        localIterator.remove();
      }
    }
  }
  
  void a(View paramView1, View paramView2, afqf paramafqf, int paramInt, long paramLong)
  {
    int i = paramafqf.jdField_a_of_type_Int;
    Object localObject = paramafqf.jdField_a_of_type_JavaLangObject;
    String str = a(i, paramInt);
    afqe localafqe = (afqe)this.b.get(str);
    if (localafqe == null)
    {
      paramView1 = new afqe(str, paramView1, paramView2, localObject, i, paramInt, paramLong);
      this.b.put(str, paramView1);
    }
    for (;;)
    {
      paramafqf.jdField_a_of_type_Boolean = false;
      paramView2 = b(localObject, paramInt);
      if (paramView2 == null) {
        break;
      }
      a(i, paramInt);
      paramView1.c = new SoftReference(paramView2);
      this.jdField_a_of_type_AndroidOsHandler.post(new afqd(this, paramView1, true));
      return;
      localafqe.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
      localafqe.b = new SoftReference(paramView2);
      paramView1 = localafqe;
    }
    paramView1.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(new afqg(this, paramView1));
  }
  
  void a(View paramView1, View paramView2, Adapter paramAdapter, int paramInt, boolean paramBoolean)
  {
    Object localObject = a(paramAdapter, paramInt);
    if (localObject == null) {}
    for (;;)
    {
      return;
      afqf localafqf = a(paramView2);
      localafqf.jdField_a_of_type_JavaLangObject = localObject;
      localafqf.jdField_a_of_type_Int = paramInt;
      localafqf.jdField_a_of_type_Boolean = true;
      int i = a(paramAdapter, paramInt);
      paramInt = 0;
      while (paramInt < i)
      {
        if ((paramBoolean) || (a(localObject, paramInt))) {
          a(paramView1, paramView2, localafqf, paramInt, SystemClock.uptimeMillis());
        }
        paramInt += 1;
      }
    }
  }
  
  public abstract void a(View paramView, Object paramObject, int paramInt, boolean paramBoolean);
  
  public boolean a(afqe paramafqe)
  {
    if (paramafqe.b == null) {
      return false;
    }
    View localView = (View)paramafqe.b.get();
    if (localView == null) {
      return true;
    }
    int i = a(localView).jdField_a_of_type_Int;
    return (i == -1) || (paramafqe.jdField_a_of_type_Int != i);
  }
  
  boolean a(Object paramObject, int paramInt)
  {
    return b(paramObject, paramInt) != null;
  }
  
  public abstract Object b(Object paramObject, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader
 * JD-Core Version:    0.7.0.1
 */