package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Adapter;
import avoq;
import avor;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ItemLoader<Params, Result>
{
  Handler jdField_a_of_type_AndroidOsHandler;
  Map<View, avor<Params>> jdField_a_of_type_JavaUtilMap;
  ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  Map<String, avoq<Params, Result>> b;
  
  static String a(int paramInt1, int paramInt2)
  {
    return String.valueOf(paramInt1) + String.valueOf(paramInt2);
  }
  
  public int a(Adapter paramAdapter, int paramInt)
  {
    return 1;
  }
  
  avor<Params> a(View paramView)
  {
    avor localavor2 = (avor)this.jdField_a_of_type_JavaUtilMap.get(paramView);
    avor localavor1 = localavor2;
    if (localavor2 == null)
    {
      localavor1 = new avor();
      localavor1.jdField_a_of_type_JavaLangObject = null;
      localavor1.jdField_a_of_type_Boolean = false;
      localavor1.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaUtilMap.put(paramView, localavor1);
    }
    return localavor1;
  }
  
  public abstract Params a(Adapter paramAdapter, int paramInt);
  
  public abstract Result a(Params paramParams, int paramInt);
  
  void a(int paramInt1, int paramInt2)
  {
    String str = a(paramInt1, paramInt2);
    avoq localavoq = (avoq)this.b.get(str);
    if (localavoq == null) {}
    do
    {
      return;
      this.b.remove(str);
    } while (localavoq.jdField_a_of_type_JavaUtilConcurrentFuture == null);
    localavoq.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("Null itemContainer in cancelRequestsForContainer");
    }
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      avoq localavoq = (avoq)localIterator.next();
      if ((View)localavoq.jdField_a_of_type_JavaLangRefSoftReference.get() == paramView)
      {
        if (localavoq.jdField_a_of_type_JavaUtilConcurrentFuture != null) {
          localavoq.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
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
      avor localavor = a(paramView2);
      localavor.jdField_a_of_type_JavaLangObject = localObject;
      localavor.jdField_a_of_type_Int = paramInt;
      localavor.jdField_a_of_type_Boolean = true;
      int i = a(paramAdapter, paramInt);
      paramInt = 0;
      while (paramInt < i)
      {
        if ((paramBoolean) || (a(localObject, paramInt))) {
          a(paramView1, paramView2, localavor, paramInt, SystemClock.uptimeMillis());
        }
        paramInt += 1;
      }
    }
  }
  
  void a(View paramView1, View paramView2, avor<Params> paramavor, int paramInt, long paramLong)
  {
    int i = paramavor.jdField_a_of_type_Int;
    Object localObject = paramavor.jdField_a_of_type_JavaLangObject;
    String str = a(i, paramInt);
    avoq localavoq = (avoq)this.b.get(str);
    if (localavoq == null)
    {
      paramView1 = new avoq(str, paramView1, paramView2, localObject, i, paramInt, paramLong);
      this.b.put(str, paramView1);
    }
    for (;;)
    {
      paramavor.jdField_a_of_type_Boolean = false;
      paramView2 = b(localObject, paramInt);
      if (paramView2 == null) {
        break;
      }
      a(i, paramInt);
      paramView1.c = new SoftReference(paramView2);
      this.jdField_a_of_type_AndroidOsHandler.post(new ItemLoader.DisplayItemRunnable(this, paramView1, true));
      return;
      localavoq.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
      localavoq.b = new SoftReference(paramView2);
      paramView1 = localavoq;
    }
    paramView1.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(new ItemLoader.LoadItemRunnable(this, paramView1));
  }
  
  public abstract void a(View paramView, Result paramResult, int paramInt, boolean paramBoolean);
  
  boolean a(avoq<Params, Result> paramavoq)
  {
    if (paramavoq.b == null) {
      return false;
    }
    View localView = (View)paramavoq.b.get();
    if (localView == null) {
      return true;
    }
    int i = a(localView).jdField_a_of_type_Int;
    return (i == -1) || (paramavoq.jdField_a_of_type_Int != i);
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