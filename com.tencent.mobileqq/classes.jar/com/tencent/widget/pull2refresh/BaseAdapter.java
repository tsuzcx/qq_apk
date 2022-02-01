package com.tencent.widget.pull2refresh;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<M, VH extends BaseViewHolder<M>>
  extends HeaderAndFooterAdapter<M, VH>
{
  private List<M> dataList = new ArrayList();
  
  public BaseAdapter(Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseAdapter(Context paramContext, List<M> paramList)
  {
    super(paramContext);
    this.dataList.addAll(paramList);
  }
  
  public boolean appendItem(M paramM)
  {
    boolean bool = this.dataList.add(paramM);
    if (bool)
    {
      if (getHeaderExtraViewCount() == 0)
      {
        notifyItemInserted(this.dataList.size() - 1);
        return bool;
      }
      notifyItemInserted(this.dataList.size());
    }
    return bool;
  }
  
  public boolean appendList(List<M> paramList)
  {
    boolean bool = this.dataList.addAll(paramList);
    if (bool) {
      notifyItemRangeInserted(this.dataList.size() - paramList.size(), paramList.size());
    }
    return bool;
  }
  
  public void clearList()
  {
    this.dataList.clear();
    notifyDataSetChanged();
  }
  
  public boolean fillList(List<M> paramList)
  {
    boolean bool = this.dataList.isEmpty();
    this.dataList.clear();
    bool = this.dataList.addAll(paramList) | bool ^ true;
    if (bool) {
      notifyDataSetChanged();
    }
    return bool;
  }
  
  public int getCustomItemCount()
  {
    return this.dataList.size();
  }
  
  public abstract int getCustomItemViewType(int paramInt);
  
  public List<M> getDataList()
  {
    return this.dataList;
  }
  
  public M getItem(int paramInt)
  {
    if (((this.headerView != null) && (paramInt == 0)) || (paramInt >= this.dataList.size() + getHeaderExtraViewCount())) {
      return null;
    }
    List localList;
    if (this.headerView == null)
    {
      localList = this.dataList;
    }
    else
    {
      localList = this.dataList;
      paramInt -= 1;
    }
    return localList.get(paramInt);
  }
  
  public M getItem(VH paramVH)
  {
    return getItem(paramVH.getPosition());
  }
  
  public int getItemCount()
  {
    return this.dataList.size() + getExtraViewCount();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if ((this.headerView != null) && (paramInt == 0)) {
      return 1024;
    }
    if ((this.footerView != null) && (paramInt == this.dataList.size() + getHeaderExtraViewCount())) {
      return 1025;
    }
    return getCustomItemViewType(paramInt);
  }
  
  public void insertOrReplaceItem(M paramM, int paramInt)
  {
    int i = this.dataList.indexOf(paramM);
    if (i != -1) {
      this.dataList.remove(i);
    }
    this.dataList.add(paramInt, paramM);
    if (i != -1)
    {
      if (this.headerView == null)
      {
        notifyItemMoved(i, paramInt);
        notifyItemChanged(paramInt);
        return;
      }
      paramInt += 1;
      notifyItemMoved(i + 1, paramInt);
      notifyItemChanged(paramInt);
      return;
    }
    if (this.headerView == null)
    {
      notifyItemInserted(paramInt);
      return;
    }
    notifyItemInserted(paramInt + 1);
  }
  
  public boolean isEmpty()
  {
    List localList = this.dataList;
    return (localList == null) || (localList.isEmpty());
  }
  
  public void prependItem(M paramM)
  {
    this.dataList.add(0, paramM);
    if (getHeaderExtraViewCount() == 0)
    {
      notifyItemInserted(0);
      return;
    }
    notifyItemInserted(getHeaderExtraViewCount());
  }
  
  public void prependList(List<M> paramList)
  {
    this.dataList.addAll(0, paramList);
    notifyDataSetChanged();
  }
  
  public void removeItem(int paramInt)
  {
    this.dataList.remove(paramInt);
    if (this.headerView != null) {
      paramInt += 1;
    }
    notifyItemRemoved(paramInt);
  }
  
  public void removeItem(M paramM)
  {
    int i = this.dataList.indexOf(paramM);
    if (i < 0) {
      return;
    }
    this.dataList.remove(i);
    if (this.headerView == null)
    {
      notifyItemRemoved(i);
      return;
    }
    notifyItemRemoved(i + 1);
  }
  
  public int updateItem(M paramM)
  {
    int i = this.dataList.indexOf(paramM);
    if (i < 0) {
      return i;
    }
    this.dataList.set(i, paramM);
    if (this.headerView == null)
    {
      notifyItemChanged(i);
      return i;
    }
    notifyItemChanged(i + 1);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.BaseAdapter
 * JD-Core Version:    0.7.0.1
 */