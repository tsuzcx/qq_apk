package com.tencent.mobileqq.nearby.smooth;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.ListView;

class ItemManaged
{
  final AbsListView a;
  ListAdapter b;
  ItemManager c;
  boolean d;
  AbsListView.OnScrollListener e;
  View.OnTouchListener f;
  AdapterView.OnItemSelectedListener g;
  
  ItemManaged(AbsListView paramAbsListView)
  {
    this.a = paramAbsListView;
    this.b = null;
    this.c = null;
    this.d = false;
    this.e = null;
    this.f = null;
    this.g = null;
  }
  
  ListAdapter a(ListAdapter paramListAdapter)
  {
    return a(this.c, paramListAdapter);
  }
  
  ListAdapter a(ItemManager paramItemManager, ListAdapter paramListAdapter)
  {
    this.b = paramListAdapter;
    Object localObject = paramListAdapter;
    if (paramItemManager != null)
    {
      localObject = paramListAdapter;
      if (paramListAdapter != null) {
        localObject = new AsyncBaseAdapter(paramItemManager, (BaseAdapter)paramListAdapter);
      }
    }
    return localObject;
  }
  
  void a(View.OnTouchListener paramOnTouchListener)
  {
    if (this.d) {
      return;
    }
    this.f = paramOnTouchListener;
  }
  
  void a(ItemManager paramItemManager)
  {
    ItemManager localItemManager = this.c;
    if (localItemManager != null)
    {
      localItemManager.a(null);
      this.c = null;
    }
    this.d = true;
    if (paramItemManager != null)
    {
      paramItemManager.a(this);
      b(a(paramItemManager, this.b));
    }
    else
    {
      this.a.setOnScrollListener(this.e);
      this.a.setOnTouchListener(this.f);
      this.a.setOnItemSelectedListener(this.g);
      b(this.b);
    }
    this.c = paramItemManager;
    this.d = false;
    h();
  }
  
  void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if (this.d) {
      return;
    }
    this.e = paramOnScrollListener;
  }
  
  void a(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    if (this.d) {
      return;
    }
    this.g = paramOnItemSelectedListener;
  }
  
  boolean a()
  {
    return this.c != null;
  }
  
  AbsListView b()
  {
    return this.a;
  }
  
  @TargetApi(11)
  void b(ListAdapter paramListAdapter)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.a.setAdapter(paramListAdapter);
      return;
    }
    AbsListView localAbsListView = this.a;
    if ((localAbsListView instanceof ListView)) {
      ((ListView)localAbsListView).setAdapter(paramListAdapter);
    }
  }
  
  AbsListView.OnScrollListener c()
  {
    return this.e;
  }
  
  View.OnTouchListener d()
  {
    return this.f;
  }
  
  AdapterView.OnItemSelectedListener e()
  {
    return this.g;
  }
  
  void f()
  {
    ItemManager localItemManager = this.c;
    if (localItemManager != null) {
      localItemManager.c();
    }
  }
  
  ListAdapter g()
  {
    ListAdapter localListAdapter2 = (ListAdapter)this.a.getAdapter();
    ListAdapter localListAdapter1 = localListAdapter2;
    if ((localListAdapter2 instanceof WrapperListAdapter)) {
      localListAdapter1 = ((WrapperListAdapter)localListAdapter2).getWrappedAdapter();
    }
    return localListAdapter1;
  }
  
  void h()
  {
    if ((a()) && (this.b != null)) {
      this.c.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemManaged
 * JD-Core Version:    0.7.0.1
 */