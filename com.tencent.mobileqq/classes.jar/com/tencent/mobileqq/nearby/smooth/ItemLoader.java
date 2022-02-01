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
  Handler a;
  Map<View, ItemLoader.ItemState<Params>> b;
  Map<String, ItemLoader.ItemRequest<Params, Result>> c;
  ThreadPoolExecutor d;
  
  static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramInt1));
    localStringBuilder.append(String.valueOf(paramInt2));
    return localStringBuilder.toString();
  }
  
  public int a(Adapter paramAdapter, int paramInt)
  {
    return 1;
  }
  
  void a(long paramLong)
  {
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext())
    {
      ItemLoader.ItemRequest localItemRequest = (ItemLoader.ItemRequest)localIterator.next();
      if (localItemRequest.e.longValue() < paramLong)
      {
        if (localItemRequest.d != null) {
          localItemRequest.d.cancel(true);
        }
        localIterator.remove();
      }
    }
    this.d.purge();
  }
  
  void a(View paramView)
  {
    if (paramView != null)
    {
      Iterator localIterator = this.c.values().iterator();
      while (localIterator.hasNext())
      {
        ItemLoader.ItemRequest localItemRequest = (ItemLoader.ItemRequest)localIterator.next();
        if ((View)localItemRequest.a.get() == paramView)
        {
          if (localItemRequest.d != null) {
            localItemRequest.d.cancel(true);
          }
          localIterator.remove();
        }
      }
      return;
    }
    paramView = new IllegalArgumentException("Null itemContainer in cancelRequestsForContainer");
    for (;;)
    {
      throw paramView;
    }
  }
  
  void a(View paramView1, View paramView2, Adapter paramAdapter, int paramInt, boolean paramBoolean)
  {
    Object localObject = b(paramAdapter, paramInt);
    if (localObject == null) {
      return;
    }
    ItemLoader.ItemState localItemState = b(paramView2);
    localItemState.b = localObject;
    localItemState.c = paramInt;
    localItemState.a = true;
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
  
  void a(View paramView1, View paramView2, ItemLoader.ItemState<Params> paramItemState, int paramInt, long paramLong)
  {
    int i = paramItemState.c;
    Object localObject = paramItemState.b;
    String str = a(i, paramInt);
    ItemLoader.ItemRequest localItemRequest = (ItemLoader.ItemRequest)this.c.get(str);
    if (localItemRequest == null)
    {
      paramView1 = new ItemLoader.ItemRequest(str, paramView1, paramView2, localObject, i, paramInt, paramLong);
      this.c.put(str, paramView1);
    }
    else
    {
      localItemRequest.e = Long.valueOf(paramLong);
      localItemRequest.b = new SoftReference(paramView2);
      paramView1 = localItemRequest;
    }
    paramItemState.a = false;
    paramView2 = c(localObject, paramInt);
    if (paramView2 != null)
    {
      b(i, paramInt);
      paramView1.c = new SoftReference(paramView2);
      this.a.post(new ItemLoader.DisplayItemRunnable(this, paramView1, true));
      return;
    }
    paramView1.d = this.d.submit(new ItemLoader.LoadItemRunnable(this, paramView1));
  }
  
  void a(View paramView, Adapter paramAdapter, int paramInt, long paramLong)
  {
    Object localObject = b(paramAdapter, paramInt);
    if (localObject == null) {
      return;
    }
    int j = a(paramAdapter, paramInt);
    int i = 0;
    while (i < j)
    {
      if (a(paramAdapter, paramInt, i)) {
        a(paramView, localObject, paramAdapter, paramInt, i, SystemClock.uptimeMillis());
      }
      i += 1;
    }
  }
  
  void a(View paramView1, Adapter paramAdapter, View paramView2, long paramLong)
  {
    ItemLoader.ItemState localItemState = b(paramView2);
    if (!localItemState.a) {
      return;
    }
    if (localItemState.b == null) {
      return;
    }
    int i = localItemState.c;
    if (i == -1) {
      return;
    }
    int j = a(paramAdapter, i);
    i = 0;
    while (i < j)
    {
      a(paramView1, paramView2, localItemState, i, paramLong);
      i += 1;
    }
  }
  
  public abstract void a(View paramView, Result paramResult, int paramInt, boolean paramBoolean);
  
  void a(View paramView, Params paramParams, Adapter paramAdapter, int paramInt1, int paramInt2, long paramLong)
  {
    if (a(paramParams, paramInt2))
    {
      b(paramInt1, paramInt2);
      return;
    }
    paramAdapter = a(paramInt1, paramInt2);
    ItemLoader.ItemRequest localItemRequest = (ItemLoader.ItemRequest)this.c.get(paramAdapter);
    if (localItemRequest == null)
    {
      paramView = new ItemLoader.ItemRequest(paramAdapter, paramView, paramParams, paramInt1, paramInt2, paramLong);
      this.c.put(paramAdapter, paramView);
      paramView.d = this.d.submit(new ItemLoader.LoadItemRunnable(this, paramView));
      return;
    }
    localItemRequest.e = Long.valueOf(paramLong);
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
    int i = b(localView).c;
    if (i != -1) {
      return paramItemRequest.h != i;
    }
    return true;
  }
  
  boolean a(Params paramParams, int paramInt)
  {
    return c(paramParams, paramInt) != null;
  }
  
  ItemLoader.ItemState<Params> b(View paramView)
  {
    ItemLoader.ItemState localItemState2 = (ItemLoader.ItemState)this.b.get(paramView);
    ItemLoader.ItemState localItemState1 = localItemState2;
    if (localItemState2 == null)
    {
      localItemState1 = new ItemLoader.ItemState();
      localItemState1.b = null;
      localItemState1.a = false;
      localItemState1.c = -1;
      this.b.put(paramView, localItemState1);
    }
    return localItemState1;
  }
  
  public abstract Params b(Adapter paramAdapter, int paramInt);
  
  public abstract Result b(Params paramParams, int paramInt);
  
  void b(int paramInt1, int paramInt2)
  {
    String str = a(paramInt1, paramInt2);
    ItemLoader.ItemRequest localItemRequest = (ItemLoader.ItemRequest)this.c.get(str);
    if (localItemRequest == null) {
      return;
    }
    this.c.remove(str);
    if (localItemRequest.d != null) {
      localItemRequest.d.cancel(true);
    }
  }
  
  public abstract Result c(Params paramParams, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader
 * JD-Core Version:    0.7.0.1
 */