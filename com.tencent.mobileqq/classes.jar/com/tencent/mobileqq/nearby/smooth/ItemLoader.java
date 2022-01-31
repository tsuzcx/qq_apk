package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Adapter;
import atxk;
import atxl;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ItemLoader<Params, Result>
{
  Handler jdField_a_of_type_AndroidOsHandler;
  Map<View, atxl<Params>> jdField_a_of_type_JavaUtilMap;
  ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  Map<String, atxk<Params, Result>> b;
  
  static String a(int paramInt1, int paramInt2)
  {
    return String.valueOf(paramInt1) + String.valueOf(paramInt2);
  }
  
  public int a(Adapter paramAdapter, int paramInt)
  {
    return 1;
  }
  
  atxl<Params> a(View paramView)
  {
    atxl localatxl2 = (atxl)this.jdField_a_of_type_JavaUtilMap.get(paramView);
    atxl localatxl1 = localatxl2;
    if (localatxl2 == null)
    {
      localatxl1 = new atxl();
      localatxl1.jdField_a_of_type_JavaLangObject = null;
      localatxl1.jdField_a_of_type_Boolean = false;
      localatxl1.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaUtilMap.put(paramView, localatxl1);
    }
    return localatxl1;
  }
  
  public abstract Params a(Adapter paramAdapter, int paramInt);
  
  public abstract Result a(Params paramParams, int paramInt);
  
  void a(int paramInt1, int paramInt2)
  {
    String str = a(paramInt1, paramInt2);
    atxk localatxk = (atxk)this.b.get(str);
    if (localatxk == null) {}
    do
    {
      return;
      this.b.remove(str);
    } while (localatxk.jdField_a_of_type_JavaUtilConcurrentFuture == null);
    localatxk.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("Null itemContainer in cancelRequestsForContainer");
    }
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      atxk localatxk = (atxk)localIterator.next();
      if ((View)localatxk.jdField_a_of_type_JavaLangRefSoftReference.get() == paramView)
      {
        if (localatxk.jdField_a_of_type_JavaUtilConcurrentFuture != null) {
          localatxk.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
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
      atxl localatxl = a(paramView2);
      localatxl.jdField_a_of_type_JavaLangObject = localObject;
      localatxl.jdField_a_of_type_Int = paramInt;
      localatxl.jdField_a_of_type_Boolean = true;
      int i = a(paramAdapter, paramInt);
      paramInt = 0;
      while (paramInt < i)
      {
        if ((paramBoolean) || (a(localObject, paramInt))) {
          a(paramView1, paramView2, localatxl, paramInt, SystemClock.uptimeMillis());
        }
        paramInt += 1;
      }
    }
  }
  
  void a(View paramView1, View paramView2, atxl<Params> paramatxl, int paramInt, long paramLong)
  {
    int i = paramatxl.jdField_a_of_type_Int;
    Object localObject = paramatxl.jdField_a_of_type_JavaLangObject;
    String str = a(i, paramInt);
    atxk localatxk = (atxk)this.b.get(str);
    if (localatxk == null)
    {
      paramView1 = new atxk(str, paramView1, paramView2, localObject, i, paramInt, paramLong);
      this.b.put(str, paramView1);
    }
    for (;;)
    {
      paramatxl.jdField_a_of_type_Boolean = false;
      paramView2 = b(localObject, paramInt);
      if (paramView2 == null) {
        break;
      }
      a(i, paramInt);
      paramView1.c = new SoftReference(paramView2);
      this.jdField_a_of_type_AndroidOsHandler.post(new ItemLoader.DisplayItemRunnable(this, paramView1, true));
      return;
      localatxk.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
      localatxk.b = new SoftReference(paramView2);
      paramView1 = localatxk;
    }
    paramView1.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(new ItemLoader.LoadItemRunnable(this, paramView1));
  }
  
  public abstract void a(View paramView, Result paramResult, int paramInt, boolean paramBoolean);
  
  boolean a(atxk<Params, Result> paramatxk)
  {
    if (paramatxk.b == null) {
      return false;
    }
    View localView = (View)paramatxk.b.get();
    if (localView == null) {
      return true;
    }
    int i = a(localView).jdField_a_of_type_Int;
    return (i == -1) || (paramatxk.jdField_a_of_type_Int != i);
  }
  
  boolean a(Params paramParams, int paramInt)
  {
    return b(paramParams, paramInt) != null;
  }
  
  public abstract Result b(Params paramParams, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader
 * JD-Core Version:    0.7.0.1
 */