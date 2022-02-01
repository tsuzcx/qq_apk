package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Adapter;
import ayti;
import aytj;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ItemLoader<Params, Result>
{
  Handler jdField_a_of_type_AndroidOsHandler;
  Map<View, aytj<Params>> jdField_a_of_type_JavaUtilMap;
  ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  Map<String, ayti<Params, Result>> b;
  
  static String a(int paramInt1, int paramInt2)
  {
    return String.valueOf(paramInt1) + String.valueOf(paramInt2);
  }
  
  public int a(Adapter paramAdapter, int paramInt)
  {
    return 1;
  }
  
  aytj<Params> a(View paramView)
  {
    aytj localaytj2 = (aytj)this.jdField_a_of_type_JavaUtilMap.get(paramView);
    aytj localaytj1 = localaytj2;
    if (localaytj2 == null)
    {
      localaytj1 = new aytj();
      localaytj1.jdField_a_of_type_JavaLangObject = null;
      localaytj1.jdField_a_of_type_Boolean = false;
      localaytj1.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaUtilMap.put(paramView, localaytj1);
    }
    return localaytj1;
  }
  
  public abstract Params a(Adapter paramAdapter, int paramInt);
  
  public abstract Result a(Params paramParams, int paramInt);
  
  void a(int paramInt1, int paramInt2)
  {
    String str = a(paramInt1, paramInt2);
    ayti localayti = (ayti)this.b.get(str);
    if (localayti == null) {}
    do
    {
      return;
      this.b.remove(str);
    } while (localayti.jdField_a_of_type_JavaUtilConcurrentFuture == null);
    localayti.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("Null itemContainer in cancelRequestsForContainer");
    }
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      ayti localayti = (ayti)localIterator.next();
      if ((View)localayti.jdField_a_of_type_JavaLangRefSoftReference.get() == paramView)
      {
        if (localayti.jdField_a_of_type_JavaUtilConcurrentFuture != null) {
          localayti.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
        }
        localIterator.remove();
      }
    }
  }
  
  public void a(View paramView1, View paramView2, Adapter paramAdapter, int paramInt, boolean paramBoolean)
  {
    Object localObject = a(paramAdapter, paramInt);
    if (localObject == null) {}
    for (;;)
    {
      return;
      aytj localaytj = a(paramView2);
      localaytj.jdField_a_of_type_JavaLangObject = localObject;
      localaytj.jdField_a_of_type_Int = paramInt;
      localaytj.jdField_a_of_type_Boolean = true;
      int i = a(paramAdapter, paramInt);
      paramInt = 0;
      while (paramInt < i)
      {
        if ((paramBoolean) || (a(localObject, paramInt))) {
          a(paramView1, paramView2, localaytj, paramInt, SystemClock.uptimeMillis());
        }
        paramInt += 1;
      }
    }
  }
  
  void a(View paramView1, View paramView2, aytj<Params> paramaytj, int paramInt, long paramLong)
  {
    int i = paramaytj.jdField_a_of_type_Int;
    Object localObject = paramaytj.jdField_a_of_type_JavaLangObject;
    String str = a(i, paramInt);
    ayti localayti = (ayti)this.b.get(str);
    if (localayti == null)
    {
      paramView1 = new ayti(str, paramView1, paramView2, localObject, i, paramInt, paramLong);
      this.b.put(str, paramView1);
    }
    for (;;)
    {
      paramaytj.jdField_a_of_type_Boolean = false;
      paramView2 = b(localObject, paramInt);
      if (paramView2 == null) {
        break;
      }
      a(i, paramInt);
      paramView1.c = new SoftReference(paramView2);
      this.jdField_a_of_type_AndroidOsHandler.post(new ItemLoader.DisplayItemRunnable(this, paramView1, true));
      return;
      localayti.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
      localayti.b = new SoftReference(paramView2);
      paramView1 = localayti;
    }
    paramView1.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(new ItemLoader.LoadItemRunnable(this, paramView1));
  }
  
  public abstract void a(View paramView, Result paramResult, int paramInt, boolean paramBoolean);
  
  boolean a(ayti<Params, Result> paramayti)
  {
    if (paramayti.b == null) {
      return false;
    }
    View localView = (View)paramayti.b.get();
    if (localView == null) {
      return true;
    }
    int i = a(localView).jdField_a_of_type_Int;
    return (i == -1) || (paramayti.jdField_a_of_type_Int != i);
  }
  
  boolean a(Params paramParams, int paramInt)
  {
    return b(paramParams, paramInt) != null;
  }
  
  public abstract Result b(Params paramParams, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader
 * JD-Core Version:    0.7.0.1
 */