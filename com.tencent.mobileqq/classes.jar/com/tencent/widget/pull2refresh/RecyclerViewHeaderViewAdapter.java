package com.tencent.widget.pull2refresh;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecyclerViewHeaderViewAdapter<T extends RecyclerView.Adapter>
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private static final int FOOTER_VIEW_TYPE = -2000;
  private static final int HEADER_VIEW_TYPE = -1000;
  private RecyclerViewHeaderViewAdapter.ContentDataObserver contentDataObserver;
  private final T mBase;
  private final List<View> mFooters = new ArrayList();
  private final List<View> mHeaders = new ArrayList();
  private RecyclerViewHeaderViewAdapter.OnBindHeaderObserver mOnBindHeaderObserver;
  
  public RecyclerViewHeaderViewAdapter(T paramT)
  {
    this.mBase = paramT;
    this.mBase.registerAdapterDataObserver(new RecyclerViewHeaderViewAdapter.1(this));
  }
  
  public void addFooter(@NonNull View paramView)
  {
    this.mFooters.add(paramView);
  }
  
  public void addHeader(@NonNull View paramView)
  {
    this.mHeaders.add(paramView);
  }
  
  public RecyclerViewHeaderViewAdapter.ContentDataObserver getContentDataObserver()
  {
    return this.contentDataObserver;
  }
  
  public View getFooter(int paramInt)
  {
    if (paramInt < this.mFooters.size()) {
      return (View)this.mFooters.get(paramInt);
    }
    return null;
  }
  
  public int getFooterCount()
  {
    return this.mFooters.size();
  }
  
  public View getHeader(int paramInt)
  {
    if (paramInt < this.mHeaders.size()) {
      return (View)this.mHeaders.get(paramInt);
    }
    return null;
  }
  
  public int getHeaderCount()
  {
    return this.mHeaders.size();
  }
  
  public int getItemCount()
  {
    return this.mHeaders.size() + this.mBase.getItemCount() + this.mFooters.size();
  }
  
  public long getItemId(int paramInt)
  {
    if (paramInt < this.mHeaders.size()) {
      return ((View)this.mHeaders.get(paramInt)).hashCode();
    }
    if (paramInt < this.mHeaders.size() + this.mBase.getItemCount()) {
      return this.mBase.getItemId(paramInt - this.mHeaders.size());
    }
    return ((View)this.mFooters.get(paramInt - this.mHeaders.size() - this.mBase.getItemCount())).hashCode();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.mHeaders.size()) {
      return paramInt - 1000;
    }
    if (paramInt < this.mHeaders.size() + this.mBase.getItemCount()) {
      return this.mBase.getItemViewType(paramInt - this.mHeaders.size());
    }
    return paramInt - 2000 - this.mHeaders.size() - this.mBase.getItemCount();
  }
  
  public T getWrappedAdapter()
  {
    return this.mBase;
  }
  
  public boolean hasHeader(View paramView)
  {
    return this.mHeaders.contains(paramView);
  }
  
  public boolean isFooter(int paramInt)
  {
    return (paramInt >= -2000) && (paramInt < this.mFooters.size() - 2000);
  }
  
  public boolean isFooterPosition(int paramInt)
  {
    return paramInt >= getItemCount() - this.mFooters.size();
  }
  
  public boolean isHeader(int paramInt)
  {
    return (paramInt >= -1000) && (paramInt < this.mHeaders.size() - 1000);
  }
  
  public boolean isHeaderPosition(int paramInt)
  {
    return paramInt < this.mHeaders.size();
  }
  
  protected void onBindHeader(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    RecyclerViewHeaderViewAdapter.OnBindHeaderObserver localOnBindHeaderObserver = this.mOnBindHeaderObserver;
    if (localOnBindHeaderObserver != null) {
      localOnBindHeaderObserver.onBindHeader(paramViewHolder, paramInt);
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = this.mHeaders.size();
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramInt < i)
    {
      if (StaggeredGridLayoutManager.LayoutParams.class.isInstance(paramViewHolder.itemView.getLayoutParams())) {
        localObject1 = (StaggeredGridLayoutManager.LayoutParams)paramViewHolder.itemView.getLayoutParams();
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
        paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      ((StaggeredGridLayoutManager.LayoutParams)localObject2).setFullSpan(true);
      onBindHeader(paramViewHolder, paramInt);
    }
    else if (paramInt < this.mHeaders.size() + this.mBase.getItemCount())
    {
      this.mBase.onBindViewHolder(paramViewHolder, paramInt - this.mHeaders.size());
    }
    else
    {
      localObject1 = localObject2;
      if (StaggeredGridLayoutManager.LayoutParams.class.isInstance(paramViewHolder.itemView.getLayoutParams())) {
        localObject1 = (StaggeredGridLayoutManager.LayoutParams)paramViewHolder.itemView.getLayoutParams();
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
        paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      ((StaggeredGridLayoutManager.LayoutParams)localObject2).setFullSpan(true);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt, List<Object> paramList)
  {
    if (paramInt < this.mHeaders.size()) {
      super.onBindViewHolder(paramViewHolder, paramInt, paramList);
    } else if (paramInt < this.mHeaders.size() + this.mBase.getItemCount()) {
      this.mBase.onBindViewHolder(paramViewHolder, paramInt - this.mHeaders.size(), paramList);
    } else {
      super.onBindViewHolder(paramViewHolder, paramInt, paramList);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, paramList, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (isHeader(paramInt))
    {
      paramInt = Math.abs(paramInt + 1000);
      return new RecyclerViewHeaderViewAdapter.2(this, (View)this.mHeaders.get(paramInt));
    }
    if (isFooter(paramInt))
    {
      paramInt = Math.abs(paramInt + 2000);
      return new RecyclerViewHeaderViewAdapter.3(this, (View)this.mFooters.get(paramInt));
    }
    return this.mBase.onCreateViewHolder(paramViewGroup, paramInt);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    RecyclerView.Adapter localAdapter = this.mBase;
    if ((localAdapter != null) && ((paramViewHolder instanceof BaseViewHolder))) {
      localAdapter.onViewAttachedToWindow(paramViewHolder);
    }
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    RecyclerView.Adapter localAdapter = this.mBase;
    if ((localAdapter != null) && ((paramViewHolder instanceof BaseViewHolder))) {
      localAdapter.onViewDetachedFromWindow(paramViewHolder);
    }
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
    RecyclerView.Adapter localAdapter = this.mBase;
    if ((localAdapter != null) && ((paramViewHolder instanceof BaseViewHolder))) {
      localAdapter.onViewRecycled(paramViewHolder);
    }
  }
  
  public void removeHeader(@NonNull View paramView)
  {
    this.mHeaders.remove(paramView);
  }
  
  public RecyclerViewHeaderViewAdapter setContentDataObserver(RecyclerViewHeaderViewAdapter.ContentDataObserver paramContentDataObserver)
  {
    this.contentDataObserver = paramContentDataObserver;
    return this;
  }
  
  public void setFooterVisibility(boolean paramBoolean)
  {
    Iterator localIterator = this.mFooters.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
  }
  
  public void setHeaderVisibility(boolean paramBoolean)
  {
    Iterator localIterator = this.mHeaders.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
  }
  
  public void setOnBindHeaderObserver(RecyclerViewHeaderViewAdapter.OnBindHeaderObserver paramOnBindHeaderObserver)
  {
    this.mOnBindHeaderObserver = paramOnBindHeaderObserver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter
 * JD-Core Version:    0.7.0.1
 */