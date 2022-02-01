package com.tencent.mobileqq.nearby.smooth;

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

public abstract class ItemLoader<Params, Result>
{
  Handler jdField_a_of_type_AndroidOsHandler;
  Map<View, ItemLoader.ItemState<Params>> jdField_a_of_type_JavaUtilMap;
  ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  Map<String, ItemLoader.ItemRequest<Params, Result>> b;
  
  static String a(int paramInt1, int paramInt2)
  {
    return String.valueOf(paramInt1) + String.valueOf(paramInt2);
  }
  
  public int a(Adapter paramAdapter, int paramInt)
  {
    return 1;
  }
  
  ItemLoader.ItemState<Params> a(View paramView)
  {
    ItemLoader.ItemState localItemState2 = (ItemLoader.ItemState)this.jdField_a_of_type_JavaUtilMap.get(paramView);
    ItemLoader.ItemState localItemState1 = localItemState2;
    if (localItemState2 == null)
    {
      localItemState1 = new ItemLoader.ItemState();
      localItemState1.jdField_a_of_type_JavaLangObject = null;
      localItemState1.jdField_a_of_type_Boolean = false;
      localItemState1.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaUtilMap.put(paramView, localItemState1);
    }
    return localItemState1;
  }
  
  public abstract Params a(Adapter paramAdapter, int paramInt);
  
  public abstract Result a(Params paramParams, int paramInt);
  
  void a(int paramInt1, int paramInt2)
  {
    String str = a(paramInt1, paramInt2);
    ItemLoader.ItemRequest localItemRequest = (ItemLoader.ItemRequest)this.b.get(str);
    if (localItemRequest == null) {}
    do
    {
      return;
      this.b.remove(str);
    } while (localItemRequest.jdField_a_of_type_JavaUtilConcurrentFuture == null);
    localItemRequest.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
  }
  
  void a(long paramLong)
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      ItemLoader.ItemRequest localItemRequest = (ItemLoader.ItemRequest)localIterator.next();
      if (localItemRequest.jdField_a_of_type_JavaLangLong.longValue() < paramLong)
      {
        if (localItemRequest.jdField_a_of_type_JavaUtilConcurrentFuture != null) {
          localItemRequest.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
        }
        localIterator.remove();
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.purge();
  }
  
  void a(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("Null itemContainer in cancelRequestsForContainer");
    }
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      ItemLoader.ItemRequest localItemRequest = (ItemLoader.ItemRequest)localIterator.next();
      if ((View)localItemRequest.jdField_a_of_type_JavaLangRefSoftReference.get() == paramView)
      {
        if (localItemRequest.jdField_a_of_type_JavaUtilConcurrentFuture != null) {
          localItemRequest.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
        }
        localIterator.remove();
      }
    }
  }
  
  void a(View paramView1, View paramView2, Adapter paramAdapter, int paramInt, boolean paramBoolean)
  {
    Object localObject = a(paramAdapter, paramInt);
    if (localObject == null) {}
    for (;;)
    {
      return;
      ItemLoader.ItemState localItemState = a(paramView2);
      localItemState.jdField_a_of_type_JavaLangObject = localObject;
      localItemState.jdField_a_of_type_Int = paramInt;
      localItemState.jdField_a_of_type_Boolean = true;
      int i = a(paramAdapter, paramInt);
      paramInt = 0;
      while (paramInt < i)
      {
        if ((paramBoolean) || (a(localObject, paramInt))) {
          a(paramView1, paramView2, localItemState, paramInt, SystemClock.uptimeMillis());
        }
        paramInt += 1;
      }
    }
  }
  
  void a(View paramView1, View paramView2, ItemLoader.ItemState<Params> paramItemState, int paramInt, long paramLong)
  {
    int i = paramItemState.jdField_a_of_type_Int;
    Object localObject = paramItemState.jdField_a_of_type_JavaLangObject;
    String str = a(i, paramInt);
    ItemLoader.ItemRequest localItemRequest = (ItemLoader.ItemRequest)this.b.get(str);
    if (localItemRequest == null)
    {
      paramView1 = new ItemLoader.ItemRequest(str, paramView1, paramView2, localObject, i, paramInt, paramLong);
      this.b.put(str, paramView1);
    }
    for (;;)
    {
      paramItemState.jdField_a_of_type_Boolean = false;
      paramView2 = b(localObject, paramInt);
      if (paramView2 == null) {
        break;
      }
      a(i, paramInt);
      paramView1.c = new SoftReference(paramView2);
      this.jdField_a_of_type_AndroidOsHandler.post(new ItemLoader.DisplayItemRunnable(this, paramView1, true));
      return;
      localItemRequest.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
      localItemRequest.b = new SoftReference(paramView2);
      paramView1 = localItemRequest;
    }
    paramView1.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(new ItemLoader.LoadItemRunnable(this, paramView1));
  }
  
  void a(View paramView, Adapter paramAdapter, int paramInt, long paramLong)
  {
    Object localObject = a(paramAdapter, paramInt);
    if (localObject == null) {
      return;
    }
    int j = a(paramAdapter, paramInt);
    int i = 0;
    label25:
    if (i < j) {
      if (a(paramAdapter, paramInt, i)) {
        break label52;
      }
    }
    for (;;)
    {
      i += 1;
      break label25;
      break;
      label52:
      a(paramView, localObject, paramAdapter, paramInt, i, SystemClock.uptimeMillis());
    }
  }
  
  void a(View paramView1, Adapter paramAdapter, View paramView2, long paramLong)
  {
    ItemLoader.ItemState localItemState = a(paramView2);
    if (!localItemState.jdField_a_of_type_Boolean) {
      break label15;
    }
    for (;;)
    {
      label15:
      return;
      if (localItemState.jdField_a_of_type_JavaLangObject != null)
      {
        int i = localItemState.jdField_a_of_type_Int;
        if (i == -1) {
          break;
        }
        int j = a(paramAdapter, i);
        i = 0;
        while (i < j)
        {
          a(paramView1, paramView2, localItemState, i, paramLong);
          i += 1;
        }
      }
    }
  }
  
  public abstract void a(View paramView, Result paramResult, int paramInt, boolean paramBoolean);
  
  void a(View paramView, Params paramParams, Adapter paramAdapter, int paramInt1, int paramInt2, long paramLong)
  {
    if (a(paramParams, paramInt2))
    {
      a(paramInt1, paramInt2);
      return;
    }
    paramAdapter = a(paramInt1, paramInt2);
    ItemLoader.ItemRequest localItemRequest = (ItemLoader.ItemRequest)this.b.get(paramAdapter);
    if (localItemRequest == null)
    {
      paramView = new ItemLoader.ItemRequest(paramAdapter, paramView, paramParams, paramInt1, paramInt2, paramLong);
      this.b.put(paramAdapter, paramView);
      paramView.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(new ItemLoader.LoadItemRunnable(this, paramView));
      return;
    }
    localItemRequest.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
    localItemRequest.b = null;
  }
  
  public boolean a(Adapter paramAdapter, int paramInt1, int paramInt2)
  {
    return true;
  }
  
  boolean a(ItemLoader.ItemRequest<Params, Result> paramItemRequest)
  {
    if (paramItemRequest.b == null) {
      return false;
    }
    View localView = (View)paramItemRequest.b.get();
    if (localView == null) {
      return true;
    }
    int i = a(localView).jdField_a_of_type_Int;
    return (i == -1) || (paramItemRequest.jdField_a_of_type_Int != i);
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