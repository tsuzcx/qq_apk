package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Adapter;
import avsz;
import avta;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ItemLoader<Params, Result>
{
  Handler jdField_a_of_type_AndroidOsHandler;
  Map<View, avta<Params>> jdField_a_of_type_JavaUtilMap;
  ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  Map<String, avsz<Params, Result>> b;
  
  static String a(int paramInt1, int paramInt2)
  {
    return String.valueOf(paramInt1) + String.valueOf(paramInt2);
  }
  
  public int a(Adapter paramAdapter, int paramInt)
  {
    return 1;
  }
  
  avta<Params> a(View paramView)
  {
    avta localavta2 = (avta)this.jdField_a_of_type_JavaUtilMap.get(paramView);
    avta localavta1 = localavta2;
    if (localavta2 == null)
    {
      localavta1 = new avta();
      localavta1.jdField_a_of_type_JavaLangObject = null;
      localavta1.jdField_a_of_type_Boolean = false;
      localavta1.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaUtilMap.put(paramView, localavta1);
    }
    return localavta1;
  }
  
  public abstract Params a(Adapter paramAdapter, int paramInt);
  
  public abstract Result a(Params paramParams, int paramInt);
  
  void a(int paramInt1, int paramInt2)
  {
    String str = a(paramInt1, paramInt2);
    avsz localavsz = (avsz)this.b.get(str);
    if (localavsz == null) {}
    do
    {
      return;
      this.b.remove(str);
    } while (localavsz.jdField_a_of_type_JavaUtilConcurrentFuture == null);
    localavsz.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("Null itemContainer in cancelRequestsForContainer");
    }
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      avsz localavsz = (avsz)localIterator.next();
      if ((View)localavsz.jdField_a_of_type_JavaLangRefSoftReference.get() == paramView)
      {
        if (localavsz.jdField_a_of_type_JavaUtilConcurrentFuture != null) {
          localavsz.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
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
      avta localavta = a(paramView2);
      localavta.jdField_a_of_type_JavaLangObject = localObject;
      localavta.jdField_a_of_type_Int = paramInt;
      localavta.jdField_a_of_type_Boolean = true;
      int i = a(paramAdapter, paramInt);
      paramInt = 0;
      while (paramInt < i)
      {
        if ((paramBoolean) || (a(localObject, paramInt))) {
          a(paramView1, paramView2, localavta, paramInt, SystemClock.uptimeMillis());
        }
        paramInt += 1;
      }
    }
  }
  
  void a(View paramView1, View paramView2, avta<Params> paramavta, int paramInt, long paramLong)
  {
    int i = paramavta.jdField_a_of_type_Int;
    Object localObject = paramavta.jdField_a_of_type_JavaLangObject;
    String str = a(i, paramInt);
    avsz localavsz = (avsz)this.b.get(str);
    if (localavsz == null)
    {
      paramView1 = new avsz(str, paramView1, paramView2, localObject, i, paramInt, paramLong);
      this.b.put(str, paramView1);
    }
    for (;;)
    {
      paramavta.jdField_a_of_type_Boolean = false;
      paramView2 = b(localObject, paramInt);
      if (paramView2 == null) {
        break;
      }
      a(i, paramInt);
      paramView1.c = new SoftReference(paramView2);
      this.jdField_a_of_type_AndroidOsHandler.post(new ItemLoader.DisplayItemRunnable(this, paramView1, true));
      return;
      localavsz.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
      localavsz.b = new SoftReference(paramView2);
      paramView1 = localavsz;
    }
    paramView1.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(new ItemLoader.LoadItemRunnable(this, paramView1));
  }
  
  public abstract void a(View paramView, Result paramResult, int paramInt, boolean paramBoolean);
  
  boolean a(avsz<Params, Result> paramavsz)
  {
    if (paramavsz.b == null) {
      return false;
    }
    View localView = (View)paramavsz.b.get();
    if (localView == null) {
      return true;
    }
    int i = a(localView).jdField_a_of_type_Int;
    return (i == -1) || (paramavsz.jdField_a_of_type_Int != i);
  }
  
  boolean a(Params paramParams, int paramInt)
  {
    return b(paramParams, paramInt) != null;
  }
  
  public abstract Result b(Params paramParams, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader
 * JD-Core Version:    0.7.0.1
 */