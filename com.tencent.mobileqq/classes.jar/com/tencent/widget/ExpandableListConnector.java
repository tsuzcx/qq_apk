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
    int i1 = 0;
    ArrayList localArrayList = this.mExpGroupMetadataList;
    int i = localArrayList.size();
    this.mTotalExpChildrenCount = 0;
    int j = i;
    int n;
    int k;
    ExpandableListConnector.GroupMetadata localGroupMetadata;
    int m;
    if (paramBoolean2)
    {
      n = i - 1;
      k = 0;
      if (n >= 0)
      {
        localGroupMetadata = (ExpandableListConnector.GroupMetadata)localArrayList.get(n);
        int i2 = findGroupPosition(localGroupMetadata.gId, localGroupMetadata.gPos);
        m = i;
        if (i2 == localGroupMetadata.gPos) {
          break label289;
        }
        j = i;
        if (i2 == -1)
        {
          localArrayList.remove(n);
          j = i - 1;
        }
        localGroupMetadata.gPos = i2;
        m = j;
        if (k != 0) {
          break label289;
        }
        k = 1;
        i = j;
        j = k;
      }
    }
    for (;;)
    {
      n -= 1;
      k = j;
      break;
      j = i;
      if (k != 0)
      {
        Collections.sort(localArrayList);
        j = i;
      }
      k = 0;
      m = 0;
      i = i1;
      if (i < j)
      {
        localGroupMetadata = (ExpandableListConnector.GroupMetadata)localArrayList.get(i);
        if ((localGroupMetadata.lastChildFlPos == -1) || (paramBoolean1)) {}
        for (n = this.mExpandableListAdapter.getChildrenCount(localGroupMetadata.gPos);; n = localGroupMetadata.lastChildFlPos - localGroupMetadata.flPos)
        {
          this.mTotalExpChildrenCount += n;
          m += localGroupMetadata.gPos - k;
          k = localGroupMetadata.gPos;
          localGroupMetadata.flPos = m;
          m = n + m;
          localGroupMetadata.lastChildFlPos = m;
          i += 1;
          break;
        }
      }
      return;
      label289:
      j = k;
      i = m;
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
    if (paramPositionMetadata.position.groupPos < 0) {
      throw new RuntimeException("Need group");
    }
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
  
  int findGroupPosition(long paramLong, int paramInt)
  {
    int i1 = this.mExpandableListAdapter.getGroupCount();
    int m;
    if (i1 == 0)
    {
      m = -1;
      return m;
    }
    if (paramLong == -9223372036854775808L) {
      return -1;
    }
    paramInt = Math.min(i1 - 1, Math.max(0, paramInt));
    long l = SystemClock.uptimeMillis();
    int i = 0;
    ExpandableListAdapter localExpandableListAdapter = getAdapter();
    label66:
    int n;
    int j;
    if (localExpandableListAdapter == null)
    {
      return -1;
      if ((n != 0) || ((i != 0) && (m == 0)))
      {
        j += 1;
        i = 0;
        paramInt = j;
      }
    }
    for (;;)
    {
      int k;
      if (SystemClock.uptimeMillis() <= l + 100L)
      {
        m = paramInt;
        if (localExpandableListAdapter.getGroupId(paramInt) == paramLong) {
          break;
        }
        if (j != i1 - 1) {
          break label154;
        }
        m = 1;
        if (k != 0) {
          break label160;
        }
      }
      label154:
      label160:
      for (n = 1;; n = 0)
      {
        if ((m == 0) || (n == 0)) {
          break label164;
        }
        return -1;
        m = 0;
        break;
      }
      label164:
      break label66;
      if ((m != 0) || ((i == 0) && (n == 0)))
      {
        k -= 1;
        i = 1;
        paramInt = k;
        continue;
        k = paramInt;
        m = paramInt;
        j = paramInt;
        paramInt = m;
      }
    }
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
    int j = 0;
    Object localObject2 = null;
    ArrayList localArrayList = this.mExpGroupMetadataList;
    int i = localArrayList.size();
    Object localObject1;
    if (i == 0)
    {
      localObject1 = ExpandableListConnector.PositionMetadata.obtain(paramExpandableListPosition.groupPos, paramExpandableListPosition.type, paramExpandableListPosition.groupPos, paramExpandableListPosition.childPos, null, 0);
      return localObject1;
    }
    for (;;)
    {
      if (k <= i)
      {
        int m = (i - k) / 2 + k;
        ExpandableListConnector.GroupMetadata localGroupMetadata = (ExpandableListConnector.GroupMetadata)localArrayList.get(m);
        if (paramExpandableListPosition.groupPos > localGroupMetadata.gPos)
        {
          k = m + 1;
          j = m;
          continue;
        }
        if (paramExpandableListPosition.groupPos < localGroupMetadata.gPos)
        {
          i = m - 1;
          j = m;
          continue;
        }
        j = m;
        if (paramExpandableListPosition.groupPos != localGroupMetadata.gPos) {
          continue;
        }
        if (paramExpandableListPosition.type == 2) {
          return ExpandableListConnector.PositionMetadata.obtain(localGroupMetadata.flPos, paramExpandableListPosition.type, paramExpandableListPosition.groupPos, paramExpandableListPosition.childPos, localGroupMetadata, m);
        }
        localObject1 = localObject2;
        if (paramExpandableListPosition.type != 1) {
          break;
        }
        return ExpandableListConnector.PositionMetadata.obtain(localGroupMetadata.flPos + paramExpandableListPosition.childPos + 1, paramExpandableListPosition.type, paramExpandableListPosition.groupPos, paramExpandableListPosition.childPos, localGroupMetadata, m);
      }
      localObject1 = localObject2;
      if (paramExpandableListPosition.type != 2) {
        break;
      }
      if (k > j)
      {
        localObject1 = (ExpandableListConnector.GroupMetadata)localArrayList.get(k - 1);
        i = ((ExpandableListConnector.GroupMetadata)localObject1).lastChildFlPos;
        return ExpandableListConnector.PositionMetadata.obtain(paramExpandableListPosition.groupPos - ((ExpandableListConnector.GroupMetadata)localObject1).gPos + i, paramExpandableListPosition.type, paramExpandableListPosition.groupPos, paramExpandableListPosition.childPos, null, k);
      }
      localObject1 = localObject2;
      if (i >= j) {
        break;
      }
      i += 1;
      localObject1 = (ExpandableListConnector.GroupMetadata)localArrayList.get(i);
      return ExpandableListConnector.PositionMetadata.obtain(((ExpandableListConnector.GroupMetadata)localObject1).flPos - (((ExpandableListConnector.GroupMetadata)localObject1).gPos - paramExpandableListPosition.groupPos), paramExpandableListPosition.type, paramExpandableListPosition.groupPos, paramExpandableListPosition.childPos, null, i);
      i -= 1;
      int k = 0;
    }
  }
  
  public Object getItem(int paramInt)
  {
    ExpandableListConnector.PositionMetadata localPositionMetadata = getUnflattenedPos(paramInt);
    if (localPositionMetadata.position.type == 2) {}
    for (Object localObject = this.mExpandableListAdapter.getGroup(localPositionMetadata.position.groupPos);; localObject = this.mExpandableListAdapter.getChild(localPositionMetadata.position.groupPos, localPositionMetadata.position.childPos))
    {
      localPositionMetadata.recycle();
      return localObject;
      if (localPositionMetadata.position.type != 1) {
        break;
      }
    }
    throw new RuntimeException("Flat list position is of unknown type");
  }
  
  public long getItemId(int paramInt)
  {
    ExpandableListConnector.PositionMetadata localPositionMetadata = getUnflattenedPos(paramInt);
    long l1 = this.mExpandableListAdapter.getGroupId(localPositionMetadata.position.groupPos);
    if (localPositionMetadata.position.type == 2) {}
    long l2;
    for (l1 = this.mExpandableListAdapter.getCombinedGroupId(l1);; l1 = this.mExpandableListAdapter.getCombinedChildId(l1, l2))
    {
      localPositionMetadata.recycle();
      return l1;
      if (localPositionMetadata.position.type != 1) {
        break;
      }
      l2 = this.mExpandableListAdapter.getChildId(localPositionMetadata.position.groupPos, localPositionMetadata.position.childPos);
    }
    throw new RuntimeException("Flat list position is of unknown type");
  }
  
  @TargetApi(8)
  public int getItemViewType(int paramInt)
  {
    ExpandableListPosition localExpandableListPosition = getUnflattenedPos(paramInt).position;
    HeterogeneousExpandableList localHeterogeneousExpandableList;
    if ((VersionUtils.b()) && ((this.mExpandableListAdapter instanceof HeterogeneousExpandableList)))
    {
      localHeterogeneousExpandableList = (HeterogeneousExpandableList)this.mExpandableListAdapter;
      if (localExpandableListPosition.type == 2) {
        paramInt = localHeterogeneousExpandableList.getGroupType(localExpandableListPosition.groupPos);
      }
    }
    for (;;)
    {
      localExpandableListPosition.recycle();
      return paramInt;
      paramInt = localHeterogeneousExpandableList.getChildType(localExpandableListPosition.groupPos, localExpandableListPosition.childPos);
      paramInt = localHeterogeneousExpandableList.getGroupTypeCount() + paramInt;
      continue;
      if (localExpandableListPosition.type == 2) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
    }
  }
  
  ExpandableListConnector.PositionMetadata getUnflattenedPos(int paramInt)
  {
    int k = 0;
    Object localObject = this.mExpGroupMetadataList;
    int i = ((ArrayList)localObject).size();
    if (i == 0) {
      return ExpandableListConnector.PositionMetadata.obtain(paramInt, 2, paramInt, -1, null, 0);
    }
    for (;;)
    {
      int j;
      if (i <= j)
      {
        int m = (j - i) / 2 + i;
        ExpandableListConnector.GroupMetadata localGroupMetadata = (ExpandableListConnector.GroupMetadata)((ArrayList)localObject).get(m);
        if (paramInt > localGroupMetadata.lastChildFlPos)
        {
          i = m + 1;
          k = m;
        }
        else if (paramInt < localGroupMetadata.flPos)
        {
          j = m - 1;
          k = m;
        }
        else
        {
          if (paramInt == localGroupMetadata.flPos) {
            return ExpandableListConnector.PositionMetadata.obtain(paramInt, 2, localGroupMetadata.gPos, -1, localGroupMetadata, m);
          }
          k = m;
          if (paramInt <= localGroupMetadata.lastChildFlPos)
          {
            i = localGroupMetadata.flPos;
            return ExpandableListConnector.PositionMetadata.obtain(paramInt, 1, localGroupMetadata.gPos, paramInt - (i + 1), localGroupMetadata, m);
          }
        }
      }
      else
      {
        if (i > k)
        {
          localObject = (ExpandableListConnector.GroupMetadata)((ArrayList)localObject).get(i - 1);
          k = paramInt - ((ExpandableListConnector.GroupMetadata)localObject).lastChildFlPos + ((ExpandableListConnector.GroupMetadata)localObject).gPos;
          j = i;
        }
        for (i = k;; i = ((ExpandableListConnector.GroupMetadata)localObject).gPos - (((ExpandableListConnector.GroupMetadata)localObject).flPos - paramInt))
        {
          return ExpandableListConnector.PositionMetadata.obtain(paramInt, 2, i, -1, null, j);
          if (j >= k) {
            break;
          }
          j += 1;
          localObject = (ExpandableListConnector.GroupMetadata)((ArrayList)localObject).get(j);
        }
        throw new RuntimeException("Unknown state");
        j = i - 1;
        i = 0;
      }
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    ExpandableListConnector.PositionMetadata localPositionMetadata = getUnflattenedPos(paramInt);
    View localView;
    if (localPositionMetadata.position.type == 2)
    {
      localView = this.mExpandableListAdapter.getGroupView(localPositionMetadata.position.groupPos, localPositionMetadata.isExpanded(), paramView, paramViewGroup);
      localPositionMetadata.recycle();
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
    }
    if (localPositionMetadata.position.type == 1)
    {
      if (localPositionMetadata.groupMetadata.lastChildFlPos == paramInt) {}
      for (;;)
      {
        localView = this.mExpandableListAdapter.getChildView(localPositionMetadata.position.groupPos, localPositionMetadata.position.childPos, bool, paramView, paramViewGroup);
        break;
        bool = false;
      }
    }
    throw new RuntimeException("Flat list position is of unknown type");
  }
  
  @TargetApi(8)
  public int getViewTypeCount()
  {
    if ((VersionUtils.b()) && ((this.mExpandableListAdapter instanceof HeterogeneousExpandableList)))
    {
      HeterogeneousExpandableList localHeterogeneousExpandableList = (HeterogeneousExpandableList)this.mExpandableListAdapter;
      int i = localHeterogeneousExpandableList.getGroupTypeCount();
      return localHeterogeneousExpandableList.getChildTypeCount() + i;
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
    boolean bool = true;
    ExpandableListPosition localExpandableListPosition = getUnflattenedPos(paramInt).position;
    if (localExpandableListPosition.type == 1) {
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
    if (this.mExpandableListAdapter != null) {
      this.mExpandableListAdapter.unregisterDataSetObserver(this.mDataSetObserver);
    }
    this.mExpandableListAdapter = paramExpandableListAdapter;
    paramExpandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
  }
  
  void setExpandedGroupMetadataList(ArrayList<ExpandableListConnector.GroupMetadata> paramArrayList)
  {
    if ((paramArrayList == null) || (this.mExpandableListAdapter == null)) {
      return;
    }
    int j = this.mExpandableListAdapter.getGroupCount();
    int i = paramArrayList.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label55;
      }
      if (((ExpandableListConnector.GroupMetadata)paramArrayList.get(i)).gPos >= j) {
        break;
      }
      i -= 1;
    }
    label55:
    this.mExpGroupMetadataList = paramArrayList;
    refreshExpGroupMetadataList(true, false);
  }
  
  public void setMaxExpGroupCount(int paramInt)
  {
    this.mMaxExpGroupCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.ExpandableListConnector
 * JD-Core Version:    0.7.0.1
 */