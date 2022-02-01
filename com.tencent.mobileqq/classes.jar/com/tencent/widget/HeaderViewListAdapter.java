package com.tencent.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class HeaderViewListAdapter
  implements Filterable, WrapperListAdapter
{
  static final ArrayList<ListView.FixedViewInfo> EMPTY_INFO_LIST = new ArrayList();
  private final ListAdapter mAdapter;
  boolean mAreAllFixedViewsSelectable;
  ArrayList<ListView.FixedViewInfo> mFooterViewInfos;
  ArrayList<ListView.FixedViewInfo> mHeaderViewInfos;
  private final boolean mIsFilterable;
  
  public HeaderViewListAdapter(ArrayList<ListView.FixedViewInfo> paramArrayList1, ArrayList<ListView.FixedViewInfo> paramArrayList2, ListAdapter paramListAdapter)
  {
    this.mAdapter = paramListAdapter;
    this.mIsFilterable = (paramListAdapter instanceof Filterable);
    if (paramArrayList1 == null) {
      this.mHeaderViewInfos = EMPTY_INFO_LIST;
    } else {
      this.mHeaderViewInfos = paramArrayList1;
    }
    if (paramArrayList2 == null) {
      this.mFooterViewInfos = EMPTY_INFO_LIST;
    } else {
      this.mFooterViewInfos = paramArrayList2;
    }
    boolean bool;
    if ((areAllListInfosSelectable(this.mHeaderViewInfos)) && (areAllListInfosSelectable(this.mFooterViewInfos))) {
      bool = true;
    } else {
      bool = false;
    }
    this.mAreAllFixedViewsSelectable = bool;
  }
  
  private boolean areAllListInfosSelectable(ArrayList<ListView.FixedViewInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (!((ListView.FixedViewInfo)paramArrayList.next()).isSelectable) {
          return false;
        }
      }
    }
    return true;
  }
  
  public boolean areAllItemsEnabled()
  {
    ListAdapter localListAdapter = this.mAdapter;
    boolean bool = true;
    if (localListAdapter != null)
    {
      if ((this.mAreAllFixedViewsSelectable) && (localListAdapter.areAllItemsEnabled())) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public int getCount()
  {
    int i;
    if (this.mAdapter != null) {
      i = getFootersCount() + getHeadersCount();
    }
    for (int j = this.mAdapter.getCount();; j = getHeadersCount())
    {
      return i + j;
      i = getFootersCount();
    }
  }
  
  public Filter getFilter()
  {
    if (this.mIsFilterable) {
      return ((Filterable)this.mAdapter).getFilter();
    }
    return null;
  }
  
  public int getFootersCount()
  {
    return this.mFooterViewInfos.size();
  }
  
  public int getHeadersCount()
  {
    return this.mHeaderViewInfos.size();
  }
  
  public Object getItem(int paramInt)
  {
    int i = getHeadersCount();
    if (paramInt < i) {
      return ((ListView.FixedViewInfo)this.mHeaderViewInfos.get(paramInt)).data;
    }
    int j = paramInt - i;
    paramInt = 0;
    ListAdapter localListAdapter = this.mAdapter;
    if (localListAdapter != null)
    {
      i = localListAdapter.getCount();
      paramInt = i;
      if (j < i) {
        return this.mAdapter.getItem(j);
      }
    }
    return ((ListView.FixedViewInfo)this.mFooterViewInfos.get(j - paramInt)).data;
  }
  
  public long getItemId(int paramInt)
  {
    int i = getHeadersCount();
    ListAdapter localListAdapter = this.mAdapter;
    if ((localListAdapter != null) && (paramInt >= i))
    {
      paramInt -= i;
      if (paramInt < localListAdapter.getCount()) {
        return this.mAdapter.getItemId(paramInt);
      }
    }
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = getHeadersCount();
    ListAdapter localListAdapter = this.mAdapter;
    if ((localListAdapter != null) && (paramInt >= i))
    {
      paramInt -= i;
      if (paramInt < localListAdapter.getCount()) {
        return this.mAdapter.getItemViewType(paramInt);
      }
    }
    return -2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int k = getHeadersCount();
    Object localObject;
    int m;
    int i;
    if (paramInt < k)
    {
      localObject = ((ListView.FixedViewInfo)this.mHeaderViewInfos.get(paramInt)).view;
    }
    else
    {
      m = paramInt - k;
      i = 0;
      localObject = this.mAdapter;
      if (localObject != null)
      {
        int j = ((ListAdapter)localObject).getCount();
        i = j;
        if (m < j)
        {
          localObject = this.mAdapter.getView(m, paramView, paramViewGroup);
          break label109;
        }
      }
    }
    try
    {
      localObject = ((ListView.FixedViewInfo)this.mFooterViewInfos.get(m - i)).view;
      label109:
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    catch (Exception paramView)
    {
      label126:
      break label126;
    }
    paramView = new StringBuilder();
    paramView.append("adapter index out of bound. adapter count: ");
    paramView.append(i);
    paramView.append(", footCount: ");
    paramView.append(this.mFooterViewInfos.size());
    paramView.append(", numHeaders:");
    paramView.append(k);
    paramView.append(" , position: ");
    paramView.append(m);
    paramView.append(", Adapter: ");
    paramView.append(this.mAdapter);
    throw new RuntimeException(paramView.toString());
  }
  
  public int getViewTypeCount()
  {
    ListAdapter localListAdapter = this.mAdapter;
    if (localListAdapter != null) {
      return localListAdapter.getViewTypeCount();
    }
    return 1;
  }
  
  public ListAdapter getWrappedAdapter()
  {
    return this.mAdapter;
  }
  
  public boolean hasStableIds()
  {
    ListAdapter localListAdapter = this.mAdapter;
    if (localListAdapter != null) {
      return localListAdapter.hasStableIds();
    }
    return false;
  }
  
  public boolean isEmpty()
  {
    ListAdapter localListAdapter = this.mAdapter;
    return (localListAdapter == null) || (localListAdapter.isEmpty());
  }
  
  public boolean isEnabled(int paramInt)
  {
    int k = getHeadersCount();
    if (paramInt < k) {
      return ((ListView.FixedViewInfo)this.mHeaderViewInfos.get(paramInt)).isSelectable;
    }
    int m = paramInt - k;
    Object localObject = this.mAdapter;
    int j;
    int i;
    if (localObject != null)
    {
      j = ((ListAdapter)localObject).getCount();
      i = j;
      if (m < j) {
        return this.mAdapter.isEnabled(m);
      }
    }
    else
    {
      i = 0;
    }
    try
    {
      j = this.mFooterViewInfos.size();
      int n = m - i;
      if (j <= n)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("adapter index out of bound. adapter count: ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", footCount: ");
        ((StringBuilder)localObject).append(this.mFooterViewInfos.size());
        ((StringBuilder)localObject).append(" , adjPosition: ");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(", Adapter: ");
        ((StringBuilder)localObject).append(this.mAdapter);
        ((StringBuilder)localObject).append("position=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("numHeaders=");
        ((StringBuilder)localObject).append(k);
        QLog.e("HeaderViewListAdapter", 1, ((StringBuilder)localObject).toString());
        return false;
      }
      boolean bool = ((ListView.FixedViewInfo)this.mFooterViewInfos.get(n)).isSelectable;
      return bool;
    }
    catch (Exception localException)
    {
      label237:
      break label237;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("adapter index out of bound. adapter count: ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", footCount: ");
    ((StringBuilder)localObject).append(this.mFooterViewInfos.size());
    ((StringBuilder)localObject).append(" , position: ");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append(", Adapter: ");
    ((StringBuilder)localObject).append(this.mAdapter);
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    ListAdapter localListAdapter = this.mAdapter;
    if ((localListAdapter != null) && (paramDataSetObserver != null)) {
      localListAdapter.registerDataSetObserver(paramDataSetObserver);
    }
  }
  
  public boolean removeFooter(View paramView)
  {
    boolean bool2 = false;
    int i = 0;
    while (i < this.mFooterViewInfos.size())
    {
      if (((ListView.FixedViewInfo)this.mFooterViewInfos.get(i)).view == paramView)
      {
        this.mFooterViewInfos.remove(i);
        boolean bool1 = bool2;
        if (areAllListInfosSelectable(this.mHeaderViewInfos))
        {
          bool1 = bool2;
          if (areAllListInfosSelectable(this.mFooterViewInfos)) {
            bool1 = true;
          }
        }
        this.mAreAllFixedViewsSelectable = bool1;
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean removeHeader(View paramView)
  {
    boolean bool2 = false;
    int i = 0;
    while (i < this.mHeaderViewInfos.size())
    {
      if (((ListView.FixedViewInfo)this.mHeaderViewInfos.get(i)).view == paramView)
      {
        this.mHeaderViewInfos.remove(i);
        boolean bool1 = bool2;
        if (areAllListInfosSelectable(this.mHeaderViewInfos))
        {
          bool1 = bool2;
          if (areAllListInfosSelectable(this.mFooterViewInfos)) {
            bool1 = true;
          }
        }
        this.mAreAllFixedViewsSelectable = bool1;
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    ListAdapter localListAdapter = this.mAdapter;
    if ((localListAdapter != null) && (paramDataSetObserver != null)) {
      localListAdapter.unregisterDataSetObserver(paramDataSetObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.HeaderViewListAdapter
 * JD-Core Version:    0.7.0.1
 */