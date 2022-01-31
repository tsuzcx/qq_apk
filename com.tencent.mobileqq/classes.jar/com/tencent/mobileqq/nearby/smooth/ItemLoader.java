package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Adapter;
import atxm;
import atxn;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ItemLoader<Params, Result>
{
  Handler jdField_a_of_type_AndroidOsHandler;
  Map<View, atxn<Params>> jdField_a_of_type_JavaUtilMap;
  ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  Map<String, atxm<Params, Result>> b;
  
  static String a(int paramInt1, int paramInt2)
  {
    return String.valueOf(paramInt1) + String.valueOf(paramInt2);
  }
  
  public int a(Adapter paramAdapter, int paramInt)
  {
    return 1;
  }
  
  atxn<Params> a(View paramView)
  {
    atxn localatxn2 = (atxn)this.jdField_a_of_type_JavaUtilMap.get(paramView);
    atxn localatxn1 = localatxn2;
    if (localatxn2 == null)
    {
      localatxn1 = new atxn();
      localatxn1.jdField_a_of_type_JavaLangObject = null;
      localatxn1.jdField_a_of_type_Boolean = false;
      localatxn1.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaUtilMap.put(paramView, localatxn1);
    }
    return localatxn1;
  }
  
  public abstract Params a(Adapter paramAdapter, int paramInt);
  
  public abstract Result a(Params paramParams, int paramInt);
  
  void a(int paramInt1, int paramInt2)
  {
    String str = a(paramInt1, paramInt2);
    atxm localatxm = (atxm)this.b.get(str);
    if (localatxm == null) {}
    do
    {
      return;
      this.b.remove(str);
    } while (localatxm.jdField_a_of_type_JavaUtilConcurrentFuture == null);
    localatxm.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("Null itemContainer in cancelRequestsForContainer");
    }
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      atxm localatxm = (atxm)localIterator.next();
      if ((View)localatxm.jdField_a_of_type_JavaLangRefSoftReference.get() == paramView)
      {
        if (localatxm.jdField_a_of_type_JavaUtilConcurrentFuture != null) {
          localatxm.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
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
      atxn localatxn = a(paramView2);
      localatxn.jdField_a_of_type_JavaLangObject = localObject;
      localatxn.jdField_a_of_type_Int = paramInt;
      localatxn.jdField_a_of_type_Boolean = true;
      int i = a(paramAdapter, paramInt);
      paramInt = 0;
      while (paramInt < i)
      {
        if ((paramBoolean) || (a(localObject, paramInt))) {
          a(paramView1, paramView2, localatxn, paramInt, SystemClock.uptimeMillis());
        }
        paramInt += 1;
      }
    }
  }
  
  void a(View paramView1, View paramView2, atxn<Params> paramatxn, int paramInt, long paramLong)
  {
    int i = paramatxn.jdField_a_of_type_Int;
    Object localObject = paramatxn.jdField_a_of_type_JavaLangObject;
    String str = a(i, paramInt);
    atxm localatxm = (atxm)this.b.get(str);
    if (localatxm == null)
    {
      paramView1 = new atxm(str, paramView1, paramView2, localObject, i, paramInt, paramLong);
      this.b.put(str, paramView1);
    }
    for (;;)
    {
      paramatxn.jdField_a_of_type_Boolean = false;
      paramView2 = b(localObject, paramInt);
      if (paramView2 == null) {
        break;
      }
      a(i, paramInt);
      paramView1.c = new SoftReference(paramView2);
      this.jdField_a_of_type_AndroidOsHandler.post(new ItemLoader.DisplayItemRunnable(this, paramView1, true));
      return;
      localatxm.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
      localatxm.b = new SoftReference(paramView2);
      paramView1 = localatxm;
    }
    paramView1.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(new ItemLoader.LoadItemRunnable(this, paramView1));
  }
  
  public abstract void a(View paramView, Result paramResult, int paramInt, boolean paramBoolean);
  
  boolean a(atxm<Params, Result> paramatxm)
  {
    if (paramatxm.b == null) {
      return false;
    }
    View localView = (View)paramatxm.b.get();
    if (localView == null) {
      return true;
    }
    int i = a(localView).jdField_a_of_type_Int;
    return (i == -1) || (paramatxm.jdField_a_of_type_Int != i);
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