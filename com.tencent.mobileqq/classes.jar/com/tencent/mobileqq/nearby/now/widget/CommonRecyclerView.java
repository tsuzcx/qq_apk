package com.tencent.mobileqq.nearby.now.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommonRecyclerView
  extends RecyclerView
{
  private List<View> a = new ArrayList();
  private List<View> b = new ArrayList();
  private int c = -1;
  
  public CommonRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CommonRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommonRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getFooterItemCount()
  {
    if (getAdapter() == null) {
      return 0;
    }
    return ((AdapterWrapper)getAdapter()).c();
  }
  
  public int getHeaderItemCount()
  {
    if (getAdapter() == null) {
      return 0;
    }
    return ((AdapterWrapper)getAdapter()).b();
  }
  
  @Nullable
  public CommonAdapter getInnerAdapter()
  {
    if (getAdapter() == null) {
      return null;
    }
    if ((((AdapterWrapper)getAdapter()).a() instanceof CommonAdapter)) {
      return (CommonAdapter)((AdapterWrapper)getAdapter()).a();
    }
    return null;
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    if (paramAdapter == null)
    {
      super.setAdapter(null);
      return;
    }
    if ((getInnerAdapter() != null) && (paramAdapter == getInnerAdapter())) {
      return;
    }
    if ((paramAdapter instanceof CommonAdapter))
    {
      super.setAdapter(new AdapterWrapper(paramAdapter));
      View localView;
      if (this.a.size() > 0)
      {
        paramAdapter = this.a.iterator();
        while (paramAdapter.hasNext())
        {
          localView = (View)paramAdapter.next();
          ((AdapterWrapper)getAdapter()).a(localView);
        }
      }
      if (this.b.size() > 0)
      {
        paramAdapter = this.b.iterator();
        while (paramAdapter.hasNext())
        {
          localView = (View)paramAdapter.next();
          ((AdapterWrapper)getAdapter()).b(localView);
        }
      }
      return;
    }
    paramAdapter = new IllegalArgumentException("adapter must extends CommonAdapter");
    for (;;)
    {
      throw paramAdapter;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.widget.CommonRecyclerView
 * JD-Core Version:    0.7.0.1
 */