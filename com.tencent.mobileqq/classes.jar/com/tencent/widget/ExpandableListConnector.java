package com.tencent.widget;

import android.annotation.TargetApi;
import android.database.DataSetObserver;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.HeterogeneousExpandableList;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Collections;

class ExpandableListConnector
  extends BaseAdapter
  implements Filterable
{
  private final DataSetObserver mDataSetObserver = new ExpandableListConnector.MyDataSetObserver(this);
  private ArrayList<ExpandableListConnector.GroupMetadata> mExpGroupMetadataList = new ArrayList();
  private ExpandableListAdapter mExpandableListAdapter;
  private int mMaxExpGroupCount = 2147483647;
  private int mTotalExpChildrenCount;
  
  public ExpandableListConnector(ExpandableListAdapter paramExpandableListAdapter)
  {
    setExpandableListAdapter(paramExpandableListAdapter);
  }
  
  private void refreshExpGroupMetadataList(boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = this.mExpGroupMetadataList;
    int j = localArrayList.size();
    int i2 = 0;
    this.mTotalExpChildrenCount = 0;
    int i = j;
    ExpandableListConnector.GroupMetadata localGroupMetadata;
    int n;
    if (paramBoolean2)
    {
      k = j - 1;
      i = j;
      m = 0;
      while (k >= 0)
      {
        localGroupMetadata = (ExpandableListConnector.GroupMetadata)localArrayList.get(k);
        int i3 = findGroupPosition(localGroupMetadata.gId, localGroupMetadata.gPos);
        int i1 = m;
        n = i;
        if (i3 != localGroupMetadata.gPos)
        {
          j = i;
          if (i3 == -1)
          {
            localArrayList.remove(k);
            j = i - 1;
          }
          localGroupMetadata.gPos = i3;
          i1 = m;
          n = j;
          if (m == 0)
          {
            i1 = 1;
            n = j;
          }
        }
        k -= 1;
        m = i1;
        i = n;
      }
      if (m != 0) {
        Collections.sort(localArrayList);
      }
    }
    int m = 0;
    int k = 0;
    j = i2;
    while (j < i)
    {
      localGroupMetadata = (ExpandableListConnector.GroupMetadata)localArrayList.get(j);
      if ((localGroupMetadata.lastChildFlPos != -1) && (!paramBoolean1)) {
        n = localGroupMetadata.lastChildFlPos - localGroupMetadata.flPos;
      } else {
        n = this.mExpandableListAdapter.getChildrenCount(localGroupMetadata.gPos);
      }
      this.mTotalExpChildrenCount += n;
      k += localGroupMetadata.gPos - m;
      m = localGroupMetadata.gPos;
      localGroupMetadata.flPos = k;
      k += n;
      localGroupMetadata.lastChildFlPos = k;
      j += 1;
    }
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.mExpandableListAdapter.areAllItemsEnabled();
  }
  
  boolean collapseGroup(int paramInt)
  {
    ExpandableListConnector.PositionMetadata localPositionMetadata = getFlattenedPos(ExpandableListPosition.obtain(2, paramInt, -1, -1));
    if (localPositionMetadata == null) {
      return false;
    }
    boolean bool = collapseGroup(localPositionMetadata);
    localPositionMetadata.recycle();
    return bool;
  }
  
  boolean collapseGroup(ExpandableListConnector.PositionMetadata paramPositionMetadata)
  {
    if (paramPositionMetadata.groupMetadata == null) {
      return false;
    }
    this.mExpGroupMetadataList.remove(paramPositionMetadata.groupMetadata);
    refreshExpGroupMetadataList(false, false);
    notifyDataSetChanged();
    this.mExpandableListAdapter.onGroupCollapsed(paramPositionMetadata.groupMetadata.gPos);
    return true;
  }
  
  boolean expandGroup(int paramInt)
  {
    ExpandableListConnector.PositionMetadata localPositionMetadata = getFlattenedPos(ExpandableListPosition.obtain(2, paramInt, -1, -1));
    boolean bool = expandGroup(localPositionMetadata);
    localPositionMetadata.recycle();
    return bool;
  }
  
  boolean expandGroup(ExpandableListConnector.PositionMetadata paramPositionMetadata)
  {
    if (paramPositionMetadata.position.groupPos >= 0)
    {
      if (this.mMaxExpGroupCount == 0) {
        return false;
      }
      if (paramPositionMetadata.groupMetadata != null) {
        return false;
      }
      if (this.mExpGroupMetadataList.size() >= this.mMaxExpGroupCount)
      {
        localGroupMetadata = (ExpandableListConnector.GroupMetadata)this.mExpGroupMetadataList.get(0);
        int i = this.mExpGroupMetadataList.indexOf(localGroupMetadata);
        collapseGroup(localGroupMetadata.gPos);
        if (paramPositionMetadata.groupInsertIndex > i) {
          paramPositionMetadata.groupInsertIndex -= 1;
        }
      }
      ExpandableListConnector.GroupMetadata localGroupMetadata = ExpandableListConnector.GroupMetadata.obtain(-1, -1, paramPositionMetadata.position.groupPos, this.mExpandableListAdapter.getGroupId(paramPositionMetadata.position.groupPos));
      this.mExpGroupMetadataList.add(paramPositionMetadata.groupInsertIndex, localGroupMetadata);
      refreshExpGroupMetadataList(false, false);
      notifyDataSetChanged();
      this.mExpandableListAdapter.onGroupExpanded(localGroupMetadata.gPos);
      return true;
    }
    throw new RuntimeException("Need group");
  }
  
  int findGroupPosition(long paramLong, int paramInt)
  {
    int i = this.mExpandableListAdapter.getGroupCount();
    if (i == 0) {
      return -1;
    }
    if (paramLong == -9223372036854775808L) {
      return -1;
    }
    paramInt = Math.max(0, paramInt);
    int i1 = i - 1;
    int k = Math.min(i1, paramInt);
    long l = SystemClock.uptimeMillis();
    ExpandableListAdapter localExpandableListAdapter = getAdapter();
    if (localExpandableListAdapter == null) {
      return -1;
    }
    paramInt = k;
    int j = paramInt;
    i = paramInt;
    for (paramInt = k;; paramInt = i)
    {
      for (k = 0;; k = 1)
      {
        int m;
        int n;
        do
        {
          if (SystemClock.uptimeMillis() > l + 100L) {
            break label211;
          }
          if (localExpandableListAdapter.getGroupId(paramInt) == paramLong) {
            return paramInt;
          }
          if (i == i1) {
            m = 1;
          } else {
            m = 0;
          }
          if (j == 0) {
            n = 1;
          } else {
            n = 0;
          }
          if ((m != 0) && (n != 0)) {
            return -1;
          }
          if ((n != 0) || ((k != 0) && (m == 0))) {
            break;
          }
        } while ((m == 0) && ((k != 0) || (n != 0)));
        j -= 1;
        paramInt = j;
      }
      i += 1;
    }
    label211:
    return -1;
  }
  
  ExpandableListAdapter getAdapter()
  {
    return this.mExpandableListAdapter;
  }
  
  public int getCount()
  {
    return this.mExpandableListAdapter.getGroupCount() + this.mTotalExpChildrenCount;
  }
  
  ArrayList<ExpandableListConnector.GroupMetadata> getExpandedGroupMetadataList()
  {
    return this.mExpGroupMetadataList;
  }
  
  public Filter getFilter()
  {
    ExpandableListAdapter localExpandableListAdapter = getAdapter();
    if ((localExpandableListAdapter instanceof Filterable)) {
      return ((Filterable)localExpandableListAdapter).getFilter();
    }
    return null;
  }
  
  ExpandableListConnector.PositionMetadata getFlattenedPos(ExpandableListPosition paramExpandableListPosition)
  {
    Object localObject = this.mExpGroupMetadataList;
    int i = ((ArrayList)localObject).size();
    int k = i - 1;
    if (i == 0) {
      return ExpandableListConnector.PositionMetadata.obtain(paramExpandableListPosition.groupPos, paramExpandableListPosition.type, paramExpandableListPosition.groupPos, paramExpandableListPosition.childPos, null, 0);
    }
    int j = 0;
    i = 0;
    while (i <= k)
    {
      int m = (k - i) / 2 + i;
      ExpandableListConnector.GroupMetadata localGroupMetadata = (ExpandableListConnector.GroupMetadata)((ArrayList)localObject).get(m);
      if (paramExpandableListPosition.groupPos > localGroupMetadata.gPos)
      {
        i = m + 1;
        j = m;
      }
      else if (paramExpandableListPosition.groupPos < localGroupMetadata.gPos)
      {
        k = m - 1;
        j = m;
      }
      else
      {
        j = m;
        if (paramExpandableListPosition.groupPos == localGroupMetadata.gPos)
        {
          if (paramExpandableListPosition.type == 2) {
            return ExpandableListConnector.PositionMetadata.obtain(localGroupMetadata.flPos, paramExpandableListPosition.type, paramExpandableListPosition.groupPos, paramExpandableListPosition.childPos, localGroupMetadata, m);
          }
          if (paramExpandableListPosition.type == 1) {
            return ExpandableListConnector.PositionMetadata.obtain(localGroupMetadata.flPos + paramExpandableListPosition.childPos + 1, paramExpandableListPosition.type, paramExpandableListPosition.groupPos, paramExpandableListPosition.childPos, localGroupMetadata, m);
          }
          return null;
        }
      }
    }
    if (paramExpandableListPosition.type != 2) {
      return null;
    }
    if (i > j)
    {
      localObject = (ExpandableListConnector.GroupMetadata)((ArrayList)localObject).get(i - 1);
      return ExpandableListConnector.PositionMetadata.obtain(((ExpandableListConnector.GroupMetadata)localObject).lastChildFlPos + (paramExpandableListPosition.groupPos - ((ExpandableListConnector.GroupMetadata)localObject).gPos), paramExpandableListPosition.type, paramExpandableListPosition.groupPos, paramExpandableListPosition.childPos, null, i);
    }
    if (k < j)
    {
      i = 1 + k;
      localObject = (ExpandableListConnector.GroupMetadata)((ArrayList)localObject).get(i);
      return ExpandableListConnector.PositionMetadata.obtain(((ExpandableListConnector.GroupMetadata)localObject).flPos - (((ExpandableListConnector.GroupMetadata)localObject).gPos - paramExpandableListPosition.groupPos), paramExpandableListPosition.type, paramExpandableListPosition.groupPos, paramExpandableListPosition.childPos, null, i);
    }
    return null;
  }
  
  public Object getItem(int paramInt)
  {
    ExpandableListConnector.PositionMetadata localPositionMetadata = getUnflattenedPos(paramInt);
    Object localObject;
    if (localPositionMetadata.position.type == 2)
    {
      localObject = this.mExpandableListAdapter.getGroup(localPositionMetadata.position.groupPos);
    }
    else
    {
      if (localPositionMetadata.position.type != 1) {
        break label78;
      }
      localObject = this.mExpandableListAdapter.getChild(localPositionMetadata.position.groupPos, localPositionMetadata.position.childPos);
    }
    localPositionMetadata.recycle();
    return localObject;
    label78:
    throw new RuntimeException("Flat list position is of unknown type");
  }
  
  public long getItemId(int paramInt)
  {
    ExpandableListConnector.PositionMetadata localPositionMetadata = getUnflattenedPos(paramInt);
    long l1 = this.mExpandableListAdapter.getGroupId(localPositionMetadata.position.groupPos);
    if (localPositionMetadata.position.type == 2)
    {
      l1 = this.mExpandableListAdapter.getCombinedGroupId(l1);
    }
    else
    {
      if (localPositionMetadata.position.type != 1) {
        break label110;
      }
      long l2 = this.mExpandableListAdapter.getChildId(localPositionMetadata.position.groupPos, localPositionMetadata.position.childPos);
      l1 = this.mExpandableListAdapter.getCombinedChildId(l1, l2);
    }
    localPositionMetadata.recycle();
    return l1;
    label110:
    throw new RuntimeException("Flat list position is of unknown type");
  }
  
  @TargetApi(8)
  public int getItemViewType(int paramInt)
  {
    ExpandableListPosition localExpandableListPosition = getUnflattenedPos(paramInt).position;
    if (VersionUtils.b())
    {
      Object localObject = this.mExpandableListAdapter;
      if ((localObject instanceof HeterogeneousExpandableList))
      {
        localObject = (HeterogeneousExpandableList)localObject;
        if (localExpandableListPosition.type == 2)
        {
          paramInt = ((HeterogeneousExpandableList)localObject).getGroupType(localExpandableListPosition.groupPos);
          break label96;
        }
        paramInt = ((HeterogeneousExpandableList)localObject).getChildType(localExpandableListPosition.groupPos, localExpandableListPosition.childPos);
        paramInt = ((HeterogeneousExpandableList)localObject).getGroupTypeCount() + paramInt;
        break label96;
      }
    }
    if (localExpandableListPosition.type == 2) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    label96:
    localExpandableListPosition.recycle();
    return paramInt;
  }
  
  ExpandableListConnector.PositionMetadata getUnflattenedPos(int paramInt)
  {
    Object localObject = this.mExpGroupMetadataList;
    int i = ((ArrayList)localObject).size();
    int j = i - 1;
    if (i == 0) {
      return ExpandableListConnector.PositionMetadata.obtain(paramInt, 2, paramInt, -1, null, 0);
    }
    i = 0;
    int k = 0;
    if (i <= j)
    {
      k = (j - i) / 2 + i;
      ExpandableListConnector.GroupMetadata localGroupMetadata = (ExpandableListConnector.GroupMetadata)((ArrayList)localObject).get(k);
      if (paramInt > localGroupMetadata.lastChildFlPos) {
        i = k + 1;
      }
      label95:
      do
      {
        for (;;)
        {
          break;
          if (paramInt >= localGroupMetadata.flPos) {
            break label95;
          }
          j = k - 1;
        }
        if (paramInt == localGroupMetadata.flPos) {
          return ExpandableListConnector.PositionMetadata.obtain(paramInt, 2, localGroupMetadata.gPos, -1, localGroupMetadata, k);
        }
      } while (paramInt > localGroupMetadata.lastChildFlPos);
      i = localGroupMetadata.flPos;
      return ExpandableListConnector.PositionMetadata.obtain(paramInt, 1, localGroupMetadata.gPos, paramInt - (i + 1), localGroupMetadata, k);
    }
    if (i > k) {
      localObject = (ExpandableListConnector.GroupMetadata)((ArrayList)localObject).get(i - 1);
    }
    for (j = paramInt - ((ExpandableListConnector.GroupMetadata)localObject).lastChildFlPos + ((ExpandableListConnector.GroupMetadata)localObject).gPos;; j = ((ExpandableListConnector.GroupMetadata)localObject).gPos - (((ExpandableListConnector.GroupMetadata)localObject).flPos - paramInt))
    {
      break;
      if (j >= k) {
        break label239;
      }
      i = j + 1;
      localObject = (ExpandableListConnector.GroupMetadata)((ArrayList)localObject).get(i);
    }
    return ExpandableListConnector.PositionMetadata.obtain(paramInt, 2, j, -1, null, i);
    label239:
    localObject = new RuntimeException("Unknown state");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ExpandableListConnector.PositionMetadata localPositionMetadata = getUnflattenedPos(paramInt);
    View localView;
    if (localPositionMetadata.position.type == 2)
    {
      localView = this.mExpandableListAdapter.getGroupView(localPositionMetadata.position.groupPos, localPositionMetadata.isExpanded(), paramView, paramViewGroup);
    }
    else
    {
      if (localPositionMetadata.position.type != 1) {
        break label134;
      }
      boolean bool;
      if (localPositionMetadata.groupMetadata.lastChildFlPos == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      localView = this.mExpandableListAdapter.getChildView(localPositionMetadata.position.groupPos, localPositionMetadata.position.childPos, bool, paramView, paramViewGroup);
    }
    localPositionMetadata.recycle();
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
    label134:
    throw new RuntimeException("Flat list position is of unknown type");
  }
  
  @TargetApi(8)
  public int getViewTypeCount()
  {
    if (VersionUtils.b())
    {
      Object localObject = this.mExpandableListAdapter;
      if ((localObject instanceof HeterogeneousExpandableList))
      {
        localObject = (HeterogeneousExpandableList)localObject;
        return ((HeterogeneousExpandableList)localObject).getGroupTypeCount() + ((HeterogeneousExpandableList)localObject).getChildTypeCount();
      }
    }
    return 2;
  }
  
  public boolean hasStableIds()
  {
    return this.mExpandableListAdapter.hasStableIds();
  }
  
  public boolean isEmpty()
  {
    ExpandableListAdapter localExpandableListAdapter = getAdapter();
    if (localExpandableListAdapter != null) {
      return localExpandableListAdapter.isEmpty();
    }
    return true;
  }
  
  public boolean isEnabled(int paramInt)
  {
    ExpandableListPosition localExpandableListPosition = getUnflattenedPos(paramInt).position;
    paramInt = localExpandableListPosition.type;
    boolean bool = true;
    if (paramInt == 1) {
      bool = this.mExpandableListAdapter.isChildSelectable(localExpandableListPosition.groupPos, localExpandableListPosition.childPos);
    }
    localExpandableListPosition.recycle();
    return bool;
  }
  
  public boolean isGroupExpanded(int paramInt)
  {
    int i = this.mExpGroupMetadataList.size() - 1;
    while (i >= 0)
    {
      if (((ExpandableListConnector.GroupMetadata)this.mExpGroupMetadataList.get(i)).gPos == paramInt) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public void setExpandableListAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    ExpandableListAdapter localExpandableListAdapter = this.mExpandableListAdapter;
    if (localExpandableListAdapter != null) {
      localExpandableListAdapter.unregisterDataSetObserver(this.mDataSetObserver);
    }
    this.mExpandableListAdapter = paramExpandableListAdapter;
    paramExpandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
  }
  
  void setExpandedGroupMetadataList(ArrayList<ExpandableListConnector.GroupMetadata> paramArrayList)
  {
    if (paramArrayList != null)
    {
      ExpandableListAdapter localExpandableListAdapter = this.mExpandableListAdapter;
      if (localExpandableListAdapter == null) {
        return;
      }
      int j = localExpandableListAdapter.getGroupCount();
      int i = paramArrayList.size() - 1;
      while (i >= 0)
      {
        if (((ExpandableListConnector.GroupMetadata)paramArrayList.get(i)).gPos >= j) {
          return;
        }
        i -= 1;
      }
      this.mExpGroupMetadataList = paramArrayList;
      refreshExpGroupMetadataList(true, false);
    }
  }
  
  public void setMaxExpGroupCount(int paramInt)
  {
    this.mMaxExpGroupCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ExpandableListConnector
 * JD-Core Version:    0.7.0.1
 */