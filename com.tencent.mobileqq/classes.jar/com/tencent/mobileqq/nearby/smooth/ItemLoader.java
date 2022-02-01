package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Adapter;
import aymv;
import aymw;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ItemLoader<Params, Result>
{
  Handler jdField_a_of_type_AndroidOsHandler;
  Map<View, aymw<Params>> jdField_a_of_type_JavaUtilMap;
  ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  Map<String, aymv<Params, Result>> b;
  
  static String a(int paramInt1, int paramInt2)
  {
    return String.valueOf(paramInt1) + String.valueOf(paramInt2);
  }
  
  public int a(Adapter paramAdapter, int paramInt)
  {
    return 1;
  }
  
  aymw<Params> a(View paramView)
  {
    aymw localaymw2 = (aymw)this.jdField_a_of_type_JavaUtilMap.get(paramView);
    aymw localaymw1 = localaymw2;
    if (localaymw2 == null)
    {
      localaymw1 = new aymw();
      localaymw1.jdField_a_of_type_JavaLangObject = null;
      localaymw1.jdField_a_of_type_Boolean = false;
      localaymw1.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaUtilMap.put(paramView, localaymw1);
    }
    return localaymw1;
  }
  
  public abstract Params a(Adapter paramAdapter, int paramInt);
  
  public abstract Result a(Params paramParams, int paramInt);
  
  void a(int paramInt1, int paramInt2)
  {
    String str = a(paramInt1, paramInt2);
    aymv localaymv = (aymv)this.b.get(str);
    if (localaymv == null) {}
    do
    {
      return;
      this.b.remove(str);
    } while (localaymv.jdField_a_of_type_JavaUtilConcurrentFuture == null);
    localaymv.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("Null itemContainer in cancelRequestsForContainer");
    }
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      aymv localaymv = (aymv)localIterator.next();
      if ((View)localaymv.jdField_a_of_type_JavaLangRefSoftReference.get() == paramView)
      {
        if (localaymv.jdField_a_of_type_JavaUtilConcurrentFuture != null) {
          localaymv.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
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
      aymw localaymw = a(paramView2);
      localaymw.jdField_a_of_type_JavaLangObject = localObject;
      localaymw.jdField_a_of_type_Int = paramInt;
      localaymw.jdField_a_of_type_Boolean = true;
      int i = a(paramAdapter, paramInt);
      paramInt = 0;
      while (paramInt < i)
      {
        if ((paramBoolean) || (a(localObject, paramInt))) {
          a(paramView1, paramView2, localaymw, paramInt, SystemClock.uptimeMillis());
        }
        paramInt += 1;
      }
    }
  }
  
  void a(View paramView1, View paramView2, aymw<Params> paramaymw, int paramInt, long paramLong)
  {
    int i = paramaymw.jdField_a_of_type_Int;
    Object localObject = paramaymw.jdField_a_of_type_JavaLangObject;
    String str = a(i, paramInt);
    aymv localaymv = (aymv)this.b.get(str);
    if (localaymv == null)
    {
      paramView1 = new aymv(str, paramView1, paramView2, localObject, i, paramInt, paramLong);
      this.b.put(str, paramView1);
    }
    for (;;)
    {
      paramaymw.jdField_a_of_type_Boolean = false;
      paramView2 = b(localObject, paramInt);
      if (paramView2 == null) {
        break;
      }
      a(i, paramInt);
      paramView1.c = new SoftReference(paramView2);
      this.jdField_a_of_type_AndroidOsHandler.post(new ItemLoader.DisplayItemRunnable(this, paramView1, true));
      return;
      localaymv.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
      localaymv.b = new SoftReference(paramView2);
      paramView1 = localaymv;
    }
    paramView1.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(new ItemLoader.LoadItemRunnable(this, paramView1));
  }
  
  public abstract void a(View paramView, Result paramResult, int paramInt, boolean paramBoolean);
  
  boolean a(aymv<Params, Result> paramaymv)
  {
    if (paramaymv.b == null) {
      return false;
    }
    View localView = (View)paramaymv.b.get();
    if (localView == null) {
      return true;
    }
    int i = a(localView).jdField_a_of_type_Int;
    return (i == -1) || (paramaymv.jdField_a_of_type_Int != i);
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