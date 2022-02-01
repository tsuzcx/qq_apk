package com.tencent.widget.pull2refresh;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecyclerViewWithHeaderFooter
  extends RecyclerViewCompat
{
  private RecyclerViewHeaderViewAdapter.ContentDataObserver contentDataObserver;
  private final List<View> mFooters = new ArrayList();
  private final List<View> mHeaders = new ArrayList();
  public boolean mInterceptTouchEvent = false;
  private RecyclerViewHeaderViewAdapter.OnBindHeaderObserver onBindHeaderObserver;
  
  public RecyclerViewWithHeaderFooter(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecyclerViewWithHeaderFooter(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecyclerViewWithHeaderFooter(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void addFooterView(View paramView)
  {
    this.mFooters.add(paramView);
  }
  
  public void addHeaderView(View paramView)
  {
    this.mHeaders.add(paramView);
  }
  
  public RecyclerViewHeaderViewAdapter.ContentDataObserver getContentDataObserver()
  {
    return this.contentDataObserver;
  }
  
  public int getFooterViewsCount()
  {
    List localList = this.mFooters;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getHeaderViewsCount()
  {
    List localList = this.mHeaders;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public boolean hasHeader(View paramView)
  {
    return this.mHeaders.contains(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mInterceptTouchEvent)
    {
      super.onInterceptTouchEvent(paramMotionEvent);
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mInterceptTouchEvent)
    {
      if (paramMotionEvent.getAction() == 1) {
        this.mInterceptTouchEvent = false;
      }
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void removeFooterView(View paramView)
  {
    this.mFooters.remove(paramView);
  }
  
  public void removeHeaderView(View paramView)
  {
    this.mHeaders.remove(paramView);
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    Object localObject;
    if (this.mHeaders.size() <= 0)
    {
      localObject = paramAdapter;
      if (this.mFooters.size() <= 0) {}
    }
    else
    {
      localObject = new RecyclerViewHeaderViewAdapter(paramAdapter);
      Iterator localIterator = this.mHeaders.iterator();
      while (localIterator.hasNext()) {
        ((RecyclerViewHeaderViewAdapter)localObject).addHeader((View)localIterator.next());
      }
      localIterator = this.mFooters.iterator();
      while (localIterator.hasNext()) {
        ((RecyclerViewHeaderViewAdapter)localObject).addFooter((View)localIterator.next());
      }
      ((RecyclerViewHeaderViewAdapter)localObject).setHasStableIds(paramAdapter.hasStableIds());
      if ((getLayoutManager() instanceof GridLayoutManager))
      {
        paramAdapter = (GridLayoutManager)getLayoutManager();
        paramAdapter.setSpanSizeLookup(new HeaderSpanSizeLookup((RecyclerViewHeaderViewAdapter)localObject, paramAdapter));
      }
      paramAdapter = this.contentDataObserver;
      if (paramAdapter != null) {
        ((RecyclerViewHeaderViewAdapter)localObject).setContentDataObserver(paramAdapter);
      }
      paramAdapter = this.onBindHeaderObserver;
      if (paramAdapter != null) {
        ((RecyclerViewHeaderViewAdapter)localObject).setOnBindHeaderObserver(paramAdapter);
      }
    }
    super.setAdapter((RecyclerView.Adapter)localObject);
  }
  
  public RecyclerViewWithHeaderFooter setContentDataObserver(RecyclerViewHeaderViewAdapter.ContentDataObserver paramContentDataObserver)
  {
    this.contentDataObserver = paramContentDataObserver;
    RecyclerView.Adapter localAdapter = getAdapter();
    if ((localAdapter != null) && ((localAdapter instanceof RecyclerViewHeaderViewAdapter))) {
      ((RecyclerViewHeaderViewAdapter)localAdapter).setContentDataObserver(paramContentDataObserver);
    }
    return this;
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    super.setLayoutManager(paramLayoutManager);
    if ((getAdapter() != null) && ((getAdapter() instanceof RecyclerViewHeaderViewAdapter)))
    {
      Object localObject = (RecyclerViewHeaderViewAdapter)getAdapter();
      if ((getLayoutManager() instanceof GridLayoutManager))
      {
        paramLayoutManager = (GridLayoutManager)getLayoutManager();
        localObject = new HeaderSpanSizeLookup((RecyclerViewHeaderViewAdapter)localObject, paramLayoutManager);
        ((HeaderSpanSizeLookup)localObject).setSpanSizeLookup(paramLayoutManager.getSpanSizeLookup());
        paramLayoutManager.setSpanSizeLookup((GridLayoutManager.SpanSizeLookup)localObject);
      }
    }
  }
  
  public void setOnBindHeaderObserver(RecyclerViewHeaderViewAdapter.OnBindHeaderObserver paramOnBindHeaderObserver)
  {
    this.onBindHeaderObserver = paramOnBindHeaderObserver;
    if ((getAdapter() instanceof RecyclerViewHeaderViewAdapter)) {
      ((RecyclerViewHeaderViewAdapter)getAdapter()).setOnBindHeaderObserver(paramOnBindHeaderObserver);
    }
  }
  
  public void setRecycledViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    super.setRecycledViewPool(new RecyclerViewWithHeaderFooter.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter
 * JD-Core Version:    0.7.0.1
 */