package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.widget.AbsListView;

public final class ItemManager
{
  ItemManaged a;
  final ItemLoader<?, ?> b;
  final Handler c;
  final boolean d;
  final int e;
  long f;
  int g;
  boolean h;
  boolean i;
  
  void a()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ((ItemManaged)localObject).b();
    ListAdapter localListAdapter = this.a.g();
    this.h = false;
    if (localListAdapter == null) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    int k = ((AbsListView)localObject).getChildCount();
    int j = 0;
    while (j < k)
    {
      View localView = ((AbsListView)localObject).getChildAt(j);
      this.b.a((View)localObject, localListAdapter, localView, l1);
      j += 1;
      l1 = 1L + l1;
    }
    long l3 = l1;
    if (this.d)
    {
      k = ((AbsListView)localObject).getLastVisiblePosition() + 1;
      long l2 = l1;
      if (k > 0)
      {
        int m = localListAdapter.getCount();
        j = k;
        for (;;)
        {
          l2 = l1;
          if (j >= this.e + k) {
            break;
          }
          l2 = l1;
          if (j >= m) {
            break;
          }
          this.b.a((View)localObject, localListAdapter, j, l1);
          j += 1;
          l1 += 1L;
        }
      }
      k = ((AbsListView)localObject).getFirstVisiblePosition();
      l3 = l2;
      if (k >= this.e)
      {
        j = k - 1;
        for (;;)
        {
          l3 = l2;
          if (j < k - this.e) {
            break;
          }
          this.b.a((View)localObject, localListAdapter, j, l2);
          j -= 1;
          l2 += 1L;
        }
      }
    }
    this.b.a(this.f);
    this.f = l3;
    ((AbsListView)localObject).invalidate();
  }
  
  void a(View paramView1, View paramView2, int paramInt)
  {
    this.a.b();
    ListAdapter localListAdapter = this.a.g();
    boolean bool;
    if ((this.g != 2) && (!this.h)) {
      bool = true;
    } else {
      bool = false;
    }
    this.b.a(paramView1, paramView2, localListAdapter, paramInt, bool);
  }
  
  void a(ItemManaged paramItemManaged)
  {
    this.a = paramItemManaged;
    paramItemManaged = this.a;
    if (paramItemManaged != null)
    {
      paramItemManaged = paramItemManaged.b();
      paramItemManaged.setOnScrollListener(new ItemManager.ScrollManager(this, null));
      paramItemManaged.setOnTouchListener(new ItemManager.FingerTracker(this, null));
      paramItemManaged.setOnItemSelectedListener(new ItemManager.SelectionTracker(this, null));
    }
  }
  
  void b()
  {
    Message localMessage = this.c.obtainMessage(1, this);
    this.c.removeMessages(1);
    this.h = true;
    this.c.sendMessage(localMessage);
  }
  
  void c()
  {
    ItemManaged localItemManaged = this.a;
    if (localItemManaged != null)
    {
      this.b.a(localItemManaged.b());
      return;
    }
    throw new IllegalStateException("Cannot cancel requests with no managed view");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemManager
 * JD-Core Version:    0.7.0.1
 */