package com.tencent.widget.pull2refresh;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class HeaderAndFooterAdapter<M, VH extends BaseViewHolder<M>>
  extends RecyclerView.Adapter<BaseViewHolder<M>>
{
  private static final String TAG = "HeaderAndFooterAdapter";
  public static final int VIEW_TYPE_FOOTER = 1025;
  public static final int VIEW_TYPE_HEADER = 1024;
  protected Context context;
  protected View footerView;
  protected View headerView;
  protected BaseAdapter.OnItemClickListener mOnItemClickListener;
  protected BaseAdapter.OnItemLongClickListener mOnItemLongClickListener;
  
  public HeaderAndFooterAdapter(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void addFooterView(View paramView)
  {
    if (paramView == null)
    {
      Log.w("HeaderAndFooterAdapter", "add the footer view is null");
      return;
    }
    this.footerView = paramView;
    notifyDataSetChanged();
  }
  
  public void addHeaderView(View paramView)
  {
    if (paramView == null)
    {
      Log.w("HeaderAndFooterAdapter", "add the header view is null");
      return;
    }
    this.headerView = paramView;
    notifyDataSetChanged();
  }
  
  public int getExtraViewCount()
  {
    int i;
    if (this.headerView != null) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i;
    if (this.footerView != null) {
      j = i + 1;
    }
    return j;
  }
  
  public int getFooterExtraViewCount()
  {
    if (this.footerView == null) {
      return 0;
    }
    return 1;
  }
  
  public int getHeaderExtraViewCount()
  {
    if (this.headerView == null) {
      return 0;
    }
    return 1;
  }
  
  public abstract long getItemId(int paramInt);
  
  public abstract void onBindCustomViewHolder(VH paramVH, int paramInt);
  
  public final void onBindViewHolder(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    int i = paramBaseViewHolder.getItemViewType();
    if ((i != 1024) && (i != 1025)) {
      onBindCustomViewHolder(paramBaseViewHolder, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramBaseViewHolder, paramInt, getItemId(paramInt));
  }
  
  public abstract VH onCreateCustomViewHolder(ViewGroup paramViewGroup, int paramInt);
  
  public final BaseViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new BaseViewHolder(this.headerView);
    } else if (paramInt == 1025) {
      paramViewGroup = new BaseViewHolder(this.footerView);
    } else {
      paramViewGroup = onCreateCustomViewHolder(paramViewGroup, paramInt);
    }
    if (this.mOnItemClickListener != null) {
      paramViewGroup.itemView.setOnClickListener(new HeaderAndFooterAdapter.1(this, paramViewGroup));
    }
    if (this.mOnItemLongClickListener != null) {
      paramViewGroup.itemView.setOnLongClickListener(new HeaderAndFooterAdapter.2(this, paramViewGroup));
    }
    return paramViewGroup;
  }
  
  public void removeFooterView()
  {
    if (this.footerView != null)
    {
      this.footerView = null;
      notifyDataSetChanged();
    }
  }
  
  public void removeHeaderView()
  {
    if (this.headerView != null)
    {
      this.headerView = null;
      notifyDataSetChanged();
    }
  }
  
  public void setOnItemClickListener(BaseAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.mOnItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(BaseAdapter.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.mOnItemLongClickListener = paramOnItemLongClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
 * JD-Core Version:    0.7.0.1
 */