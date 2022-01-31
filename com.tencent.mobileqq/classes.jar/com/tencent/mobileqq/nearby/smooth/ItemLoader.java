package com.tencent.mobileqq.nearby.smooth;

import afme;
import afmf;
import afmg;
import afmh;
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
  
  afmg a(View paramView)
  {
    afmg localafmg2 = (afmg)this.jdField_a_of_type_JavaUtilMap.get(paramView);
    afmg localafmg1 = localafmg2;
    if (localafmg2 == null)
    {
      localafmg1 = new afmg();
      localafmg1.jdField_a_of_type_JavaLangObject = null;
      localafmg1.jdField_a_of_type_Boolean = false;
      localafmg1.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaUtilMap.put(paramView, localafmg1);
    }
    return localafmg1;
  }
  
  public abstract Object a(Adapter paramAdapter, int paramInt);
  
  public abstract Object a(Object paramObject, int paramInt);
  
  void a(int paramInt1, int paramInt2)
  {
    String str = a(paramInt1, paramInt2);
    afmf localafmf = (afmf)this.b.get(str);
    if (localafmf == null) {}
    do
    {
      return;
      this.b.remove(str);
    } while (localafmf.jdField_a_of_type_JavaUtilConcurrentFuture == null);
    localafmf.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
  }
  
  void a(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("Null itemContainer in cancelRequestsForContainer");
    }
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      afmf localafmf = (afmf)localIterator.next();
      if ((View)localafmf.jdField_a_of_type_JavaLangRefSoftReference.get() == paramView)
      {
        if (localafmf.jdField_a_of_type_JavaUtilConcurrentFuture != null) {
          localafmf.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
        }
        localIterator.remove();
      }
    }
  }
  
  void a(View paramView1, View paramView2, afmg paramafmg, int paramInt, long paramLong)
  {
    int i = paramafmg.jdField_a_of_type_Int;
    Object localObject = paramafmg.jdField_a_of_type_JavaLangObject;
    String str = a(i, paramInt);
    afmf localafmf = (afmf)this.b.get(str);
    if (localafmf == null)
    {
      paramView1 = new afmf(str, paramView1, paramView2, localObject, i, paramInt, paramLong);
      this.b.put(str, paramView1);
    }
    for (;;)
    {
      paramafmg.jdField_a_of_type_Boolean = false;
      paramView2 = b(localObject, paramInt);
      if (paramView2 == null) {
        break;
      }
      a(i, paramInt);
      paramView1.c = new SoftReference(paramView2);
      this.jdField_a_of_type_AndroidOsHandler.post(new afme(this, paramView1, true));
      return;
      localafmf.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
      localafmf.b = new SoftReference(paramView2);
      paramView1 = localafmf;
    }
    paramView1.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(new afmh(this, paramView1));
  }
  
  void a(View paramView1, View paramView2, Adapter paramAdapter, int paramInt, boolean paramBoolean)
  {
    Object localObject = a(paramAdapter, paramInt);
    if (localObject == null) {}
    for (;;)
    {
      return;
      afmg localafmg = a(paramView2);
      localafmg.jdField_a_of_type_JavaLangObject = localObject;
      localafmg.jdField_a_of_type_Int = paramInt;
      localafmg.jdField_a_of_type_Boolean = true;
      int i = a(paramAdapter, paramInt);
      paramInt = 0;
      while (paramInt < i)
      {
        if ((paramBoolean) || (a(localObject, paramInt))) {
          a(paramView1, paramView2, localafmg, paramInt, SystemClock.uptimeMillis());
        }
        paramInt += 1;
      }
    }
  }
  
  public abstract void a(View paramView, Object paramObject, int paramInt, boolean paramBoolean);
  
  public boolean a(afmf paramafmf)
  {
    if (paramafmf.b == null) {
      return false;
    }
    View localView = (View)paramafmf.b.get();
    if (localView == null) {
      return true;
    }
    int i = a(localView).jdField_a_of_type_Int;
    return (i == -1) || (paramafmf.jdField_a_of_type_Int != i);
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