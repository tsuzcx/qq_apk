package com.tencent.mtt.supportui.views.recyclerview;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class RecyclerAdapter
  extends RecyclerViewBase.Adapter<RecyclerView.ViewHolderWrapper>
  implements View.OnClickListener
{
  static final String TAG = "RecyclerAdapter";
  protected int mContentHeight = -1;
  ArrayList<RecyclerAdapter.DataHolder> mDataList = new ArrayList();
  public View mDefaultLoadingView;
  public ArrayList<Integer> mItemWidthList = null;
  public int mLoadingStatus = 0;
  SparseIntArray mOffsetMap = null;
  public RecyclerView mParentRecyclerView;
  protected RecyclerAdapter.RecyclerViewItemListener mRecyclerViewItemListener;
  RecyclerAdapter.DataHolder mRoot;
  List<Integer> mSuspentedPos;
  
  public RecyclerAdapter(RecyclerView paramRecyclerView)
  {
    this.mParentRecyclerView = paramRecyclerView;
  }
  
  public final void addData(RecyclerAdapter.DataHolder paramDataHolder)
  {
    if (paramDataHolder != null)
    {
      this.mDataList.add(paramDataHolder);
      this.mContentHeight = -1;
    }
  }
  
  public void addSuspentedPos(int paramInt)
  {
    if (!this.mParentRecyclerView.hasSuspentedItem()) {}
    do
    {
      return;
      if (this.mSuspentedPos == null) {
        this.mSuspentedPos = new ArrayList();
      }
    } while (this.mSuspentedPos.contains(Integer.valueOf(paramInt)));
    this.mSuspentedPos.add(Integer.valueOf(paramInt));
  }
  
  public final void appendData(ArrayList<RecyclerAdapter.DataHolder> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.mDataList.addAll(paramArrayList);
      this.mContentHeight = -1;
    }
  }
  
  int binarySearch(SparseIntArray paramSparseIntArray, int paramInt)
  {
    if ((paramSparseIntArray == null) || (paramSparseIntArray.size() == 0)) {
      return -1;
    }
    int i = paramSparseIntArray.keyAt(0);
    int j = paramSparseIntArray.keyAt(paramSparseIntArray.size() - 1);
    while (i <= j)
    {
      int k = (j - i >> 1) + i;
      int m = itemRangeCompare(k, paramSparseIntArray.valueAt(k), paramInt);
      if (m == 0) {
        return k;
      }
      if (m > 0) {
        j = k - 1;
      } else {
        i = k + 1;
      }
    }
    return -1;
  }
  
  void calculateOffsetMapIfNeed()
  {
    if (this.mOffsetMap == null) {
      this.mOffsetMap = new SparseIntArray();
    }
    if (this.mDataChanged)
    {
      this.mOffsetMap.clear();
      getItemCount();
      int k = getHeaderViewCount();
      int i = 1;
      int j = 0;
      while (i <= k)
      {
        j += getHeaderViewHeight(i);
        i += 1;
      }
      this.mParentRecyclerView.mLayout.calculateOffsetMap(this.mOffsetMap, j);
      this.mDataChanged = false;
    }
  }
  
  public void clearData()
  {
    this.mDataList.clear();
    this.mContentHeight = -1;
  }
  
  public void dataChanged()
  {
    super.dataChanged();
  }
  
  public void deSelecteItem(int paramInt)
  {
    View localView = this.mParentRecyclerView.findViewByPosition(paramInt);
    if (localView != null) {
      localView.setSelected(false);
    }
  }
  
  public void deleteItem(int paramInt)
  {
    onItemDeleted(paramInt);
    if ((this.mParentRecyclerView != null) && (doDeleteItem())) {
      this.mParentRecyclerView.postAdapterUpdate(this.mParentRecyclerView.obtainUpdateOp(1, paramInt, 1));
    }
  }
  
  void fillSuspentedPos()
  {
    int j = getItemCount();
    int i = 0;
    while (i < j)
    {
      if (isSuspentedItem(i)) {
        addSuspentedPos(i);
      }
      i += 1;
    }
    Collections.sort(this.mSuspentedPos);
  }
  
  public int findNextSuspentedPos(int paramInt)
  {
    if ((this.mSuspentedPos == null) || (this.mSuspentedPos.isEmpty())) {}
    int i;
    do
    {
      return -1;
      paramInt = findPrevSuspentedPos(paramInt);
      i = this.mSuspentedPos.indexOf(Integer.valueOf(paramInt));
    } while ((paramInt == -1) || (i + 1 >= this.mSuspentedPos.size()));
    return ((Integer)this.mSuspentedPos.get(i + 1)).intValue();
  }
  
  public int findPrevSuspentedPos(int paramInt)
  {
    initSuspentedPosIfNeed();
    if ((this.mSuspentedPos == null) || (this.mSuspentedPos.isEmpty())) {
      return -1;
    }
    int j = this.mSuspentedPos.size();
    int i = 0;
    while (i < j)
    {
      int k = ((Integer)this.mSuspentedPos.get(i)).intValue();
      if (((Integer)this.mSuspentedPos.get(i)).intValue() >= paramInt)
      {
        if (k == paramInt) {
          return k;
        }
        if (i == 0) {
          return -1;
        }
        return ((Integer)this.mSuspentedPos.get(i - 1)).intValue();
      }
      i += 1;
    }
    return ((Integer)this.mSuspentedPos.get(j - 1)).intValue();
  }
  
  public void forceUpdateOffsetMap()
  {
    this.mDataChanged = true;
    calculateOffsetMapIfNeed();
  }
  
  public int[] getBeginPositionWithOffset(int paramInt)
  {
    int k = 1;
    int[] arrayOfInt = new int[2];
    int m = getItemCount() + getFooterViewCount();
    int n = getHeaderViewCount();
    int i1 = this.mParentRecyclerView.getCachedTotalHeight();
    int j = 0;
    int i = 1;
    while (i <= n)
    {
      j += getHeaderViewHeight(i);
      i += 1;
    }
    if (paramInt >= i1)
    {
      arrayOfInt[0] = m;
      arrayOfInt[1] = (i1 - getItemHeight(m) - paramInt);
    }
    label304:
    label432:
    label440:
    label443:
    for (;;)
    {
      return arrayOfInt;
      if (paramInt < 0)
      {
        arrayOfInt[0] = (-n);
        arrayOfInt[1] = (-j - paramInt);
      }
      else
      {
        if (paramInt < j)
        {
          i = -n;
          j = 0;
          label122:
          if (i >= 0) {
            break label440;
          }
          j += getHeaderViewHeight(-i);
          if (j > paramInt)
          {
            arrayOfInt[0] = i;
            arrayOfInt[1] = (j - getHeaderViewHeight(-i) - paramInt);
          }
        }
        for (paramInt = k;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label443;
          }
          break;
          i += 1;
          break label122;
          calculateOffsetMapIfNeed();
          n = this.mOffsetMap.size() - 1;
          i = this.mOffsetMap.get(n) + getItemRange(n);
          if (paramInt > i)
          {
            k = getFooterViewCount();
            if (k > 0)
            {
              j = 1;
              label226:
              if (j > k) {
                break label432;
              }
              i += getFooterViewHeight(j);
              if (i <= paramInt) {
                break label304;
              }
              arrayOfInt[0] = (n + j);
              arrayOfInt[1] = (i - getFooterViewHeight(j) - paramInt);
              m = 1;
              k = i;
            }
          }
          for (i = m;; i = 0)
          {
            if (i == 0)
            {
              arrayOfInt[0] = (n + j);
              arrayOfInt[1] = (k - getFooterViewHeight(j) - paramInt);
            }
            return arrayOfInt;
            j += 1;
            break label226;
            i = binarySearch(this.mOffsetMap, paramInt);
            if (paramInt == 0) {
              i = 0;
            }
            if (i == -1) {
              break;
            }
            k = this.mOffsetMap.get(i);
            if (this.mParentRecyclerView.mLayoutType == 2)
            {
              do
              {
                j = i - 1;
                if (j < 0) {
                  break;
                }
                i = j;
              } while (this.mOffsetMap.get(j) == k);
              arrayOfInt[0] = (j + 1);
            }
            for (;;)
            {
              arrayOfInt[1] = (k - paramInt);
              break;
              if (this.mParentRecyclerView.mLayoutType == 1) {
                arrayOfInt[0] = i;
              } else if (this.mParentRecyclerView.mLayoutType == 3) {
                arrayOfInt[0] = i;
              }
            }
            k = i;
          }
        }
      }
    }
  }
  
  public int getCardItemViewType(int paramInt)
  {
    try
    {
      if ((this.mDataList.size() > paramInt) && (paramInt >= 0)) {
        return ((RecyclerAdapter.DataHolder)this.mDataList.get(paramInt)).mItemViewStyle;
      }
      paramInt = super.getCardItemViewType(paramInt);
      return paramInt;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public View getCustomFooterView(int paramInt)
  {
    return null;
  }
  
  public int getCustomFooterViewCount()
  {
    return 0;
  }
  
  public int getCustomFooterViewHeight()
  {
    return 0;
  }
  
  public int getCustomFooterViewHeight(int paramInt)
  {
    return 0;
  }
  
  public int getCustomFooterViewWidth()
  {
    return 0;
  }
  
  public int getCustomHeaderViewHeight()
  {
    return 0;
  }
  
  public int getCustomHeaderViewWidth()
  {
    return 0;
  }
  
  public final RecyclerAdapter.DataHolder getDataHolder(int paramInt)
  {
    try
    {
      if ((this.mDataList.size() > paramInt) && (paramInt >= 0))
      {
        RecyclerAdapter.DataHolder localDataHolder = (RecyclerAdapter.DataHolder)this.mDataList.get(paramInt);
        return localDataHolder;
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public ArrayList<RecyclerAdapter.DataHolder> getDataHolderList()
  {
    return new ArrayList(this.mDataList);
  }
  
  public int getDefaultFooterHeight()
  {
    return 108;
  }
  
  public View getFooterView(int paramInt)
  {
    if (this.mLoadingStatus != 0)
    {
      if (paramInt == getFooterViewCount())
      {
        if (this.mDefaultLoadingView == null) {
          this.mDefaultLoadingView = this.mParentRecyclerView.createFooterView(this.mParentRecyclerView.getContext());
        }
        if (this.mDefaultLoadingView != null) {
          this.mDefaultLoadingView.setOnClickListener(this);
        }
        if ((this.mDefaultLoadingView != null) && ((this.mDefaultLoadingView instanceof IRecyclerViewFooter))) {
          ((IRecyclerViewFooter)this.mDefaultLoadingView).setLoadingStatus(this.mLoadingStatus);
        }
        return this.mDefaultLoadingView;
      }
      return getCustomFooterView(paramInt);
    }
    return getCustomFooterView(paramInt);
  }
  
  public int getFooterViewCount()
  {
    if (this.mLoadingStatus != 0) {
      return getCustomFooterViewCount() + 1;
    }
    return getCustomFooterViewCount();
  }
  
  public int getFooterViewHeight(int paramInt)
  {
    if (this.mLoadingStatus != 0)
    {
      if (paramInt == getFooterViewCount()) {
        return getDefaultFooterHeight();
      }
      return getCustomFooterViewHeight(paramInt);
    }
    return getCustomFooterViewHeight(paramInt);
  }
  
  public boolean getFooterViewInBottomMode()
  {
    return false;
  }
  
  public View getHeaderView(int paramInt)
  {
    return null;
  }
  
  public int getHeaderViewCount()
  {
    return 0;
  }
  
  public int getHeaderViewHeight(int paramInt)
  {
    return 0;
  }
  
  public int getHeightBefore(int paramInt)
  {
    int i = getHeaderViewCount();
    if (paramInt < -i) {
      throw new IllegalStateException("pos less than header count,should not happened");
    }
    int k;
    if (paramInt >= 0)
    {
      calculateOffsetMapIfNeed();
      k = this.mOffsetMap.get(paramInt);
      return k;
    }
    int j = -i;
    for (i = 0;; i = k + i)
    {
      k = i;
      if (j >= paramInt) {
        break;
      }
      k = getHeaderViewHeight(-j);
      j += 1;
    }
  }
  
  public RecyclerAdapter.RecyclerViewItemListener getItemClickListener()
  {
    return this.mRecyclerViewItemListener;
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public int getItemHeight(int paramInt)
  {
    try
    {
      if ((this.mDataList.size() > paramInt) && (paramInt >= 0))
      {
        paramInt = ((RecyclerAdapter.DataHolder)this.mDataList.get(paramInt)).mItemHeight;
        return paramInt;
      }
      return 0;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public int getItemMaigin(int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = j;
    if (paramInt2 < this.mDataList.size())
    {
      i = j;
      if (paramInt2 >= 0)
      {
        try
        {
          localDataHolder = (RecyclerAdapter.DataHolder)this.mDataList.get(paramInt2);
          switch (paramInt1)
          {
          case 0: 
            paramInt1 = localDataHolder.mLeftMargin;
          }
        }
        catch (Exception localException)
        {
          RecyclerAdapter.DataHolder localDataHolder;
          return 0;
        }
        paramInt1 = localDataHolder.mTopMargin;
        break label110;
        paramInt1 = localDataHolder.mRightMargin;
        break label110;
        paramInt1 = localDataHolder.mBottomMargin;
        break label110;
        paramInt1 = 0;
        label110:
        i = paramInt1;
      }
    }
    return i;
  }
  
  public int getItemOffset(int paramInt)
  {
    if (this.mOffsetMap != null) {
      return this.mOffsetMap.get(paramInt);
    }
    return -1;
  }
  
  protected int getItemRange(int paramInt)
  {
    return 0 + (getItemHeight(paramInt) + getItemMaigin(1, paramInt) + getItemMaigin(3, paramInt));
  }
  
  public int getItemViewType(int paramInt)
  {
    try
    {
      if ((this.mDataList.size() > paramInt) && (paramInt >= 0)) {
        return ((RecyclerAdapter.DataHolder)this.mDataList.get(paramInt)).mItemViewType;
      }
      paramInt = super.getItemViewType(paramInt);
      return paramInt;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public int getItemWidth(int paramInt)
  {
    try
    {
      if ((isAutoCalculateItemHeight()) && (this.mItemWidthList != null) && (this.mItemWidthList.size() > paramInt) && (paramInt >= 0))
      {
        paramInt = ((Integer)this.mItemWidthList.get(paramInt)).intValue();
        return paramInt;
      }
      return 0;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public int getListTotalHeight()
  {
    return super.getListTotalHeight() + this.mParentRecyclerView.getPaddingTop() + this.mParentRecyclerView.getPaddingBottom();
  }
  
  public int getTotalHeight()
  {
    int i = 0;
    if (isAutoCalculateItemHeight()) {
      this.mContentHeight = -1;
    }
    if (this.mContentHeight == -1)
    {
      int j = getItemCount();
      this.mContentHeight = 0;
      if (this.mParentRecyclerView.mLayoutType == 1) {
        while (i < j)
        {
          this.mContentHeight += getItemHeight(i);
          this.mContentHeight += getItemMaigin(1, i);
          this.mContentHeight += getItemMaigin(3, i);
          i += 1;
        }
      }
      if (this.mParentRecyclerView.mLayoutType != 3) {}
    }
    return this.mContentHeight;
  }
  
  protected RecyclerViewItem getViewItem(RecyclerViewBase paramRecyclerViewBase)
  {
    return this.mParentRecyclerView.createViewItem();
  }
  
  protected RecyclerViewItem getViewItemWithPos(RecyclerViewBase paramRecyclerViewBase, int paramInt)
  {
    return getViewItem(paramRecyclerViewBase);
  }
  
  public final boolean hasData()
  {
    return !this.mDataList.isEmpty();
  }
  
  public int indexOf(RecyclerAdapter.DataHolder paramDataHolder)
  {
    return this.mDataList.indexOf(paramDataHolder);
  }
  
  void initSuspentedPosIfNeed()
  {
    if (this.mSuspentedPos == null)
    {
      this.mSuspentedPos = new ArrayList();
      fillSuspentedPos();
    }
    if (this.mSuspentionDataChanged)
    {
      this.mSuspentedPos.clear();
      fillSuspentedPos();
      this.mSuspentionDataChanged = false;
    }
  }
  
  public final void insertData(RecyclerAdapter.DataHolder paramDataHolder, int paramInt)
  {
    if ((paramInt >= 0) && (paramDataHolder != null) && (this.mDataList.size() >= paramInt))
    {
      this.mDataList.add(paramInt, paramDataHolder);
      this.mContentHeight = -1;
    }
  }
  
  public final void insertData(ArrayList<RecyclerAdapter.DataHolder> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 > 0) && (paramArrayList != null) && (!paramArrayList.isEmpty()) && (this.mDataList.size() >= paramInt1))
    {
      ArrayList localArrayList = this.mDataList;
      this.mDataList = new ArrayList();
      this.mDataList.addAll(localArrayList.subList(0, paramInt1));
      this.mDataList.addAll(paramArrayList);
      this.mDataList.addAll(localArrayList.subList(paramInt1, localArrayList.size()));
      this.mContentHeight = -1;
    }
  }
  
  public boolean isAutoCalculateItemHeight()
  {
    return false;
  }
  
  int itemRangeCompare(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = getItemRange(paramInt1);
    if (paramInt2 > paramInt3) {
      return 1;
    }
    if (paramInt1 + paramInt2 < paramInt3) {
      return -1;
    }
    return 0;
  }
  
  public void notifyDataSetChanged()
  {
    this.mContentHeight = -1;
    super.notifyDataSetChanged();
  }
  
  public void notifyItemChanged(int paramInt)
  {
    this.mContentHeight = -1;
    super.notifyItemChanged(paramInt);
  }
  
  public void notifyItemInserted(int paramInt)
  {
    this.mContentHeight = -1;
    super.notifyItemInserted(paramInt);
  }
  
  public void notifyItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.mContentHeight = -1;
    super.notifyItemRangeChanged(paramInt1, paramInt2);
  }
  
  public void notifyItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.mContentHeight = -1;
    super.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public void notifyItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.mContentHeight = -1;
    super.notifyItemRangeRemoved(paramInt1, paramInt2);
  }
  
  public void notifyItemRemoved(int paramInt)
  {
    this.mContentHeight = -1;
    super.notifyItemRemoved(paramInt);
  }
  
  public void notifyItemsRemoved(ArrayList<Integer> paramArrayList)
  {
    this.mContentHeight = -1;
    super.notifyItemsRemoved(paramArrayList);
  }
  
  public void notifyLastFooterAppeared()
  {
    super.notifyLastFooterAppeared();
  }
  
  public boolean notifyOrderChanged(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void onBindContentView(ContentHolder paramContentHolder, int paramInt1, int paramInt2) {}
  
  public void onBindCustomerView(RecyclerView.ViewHolderWrapper paramViewHolderWrapper, int paramInt1, int paramInt2) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolderWrapper paramViewHolderWrapper, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramViewHolderWrapper == null) || (paramViewHolderWrapper.itemView == null) || (paramViewHolderWrapper.mContentHolder == null)) {
      return;
    }
    paramViewHolderWrapper.itemView.setPressed(false);
    paramViewHolderWrapper.itemView.setSelected(false);
    onBindContentView(paramViewHolderWrapper.mContentHolder, paramInt1, paramInt2);
    positionContentView(paramViewHolderWrapper.mContentHolder, paramInt1, paramInt2, false);
    onBindCustomerView(paramViewHolderWrapper, paramInt1, paramInt2);
    RecyclerViewBase.LayoutParams localLayoutParams;
    if (this.mParentRecyclerView.mLayoutType == 3) {
      localLayoutParams = this.mParentRecyclerView.mLayout.onCreateItemLayoutParams(paramViewHolderWrapper, paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      localLayoutParams.mViewHolder = paramViewHolderWrapper;
      localLayoutParams.topMargin = getItemMaigin(1, paramInt1);
      localLayoutParams.bottomMargin = getItemMaigin(3, paramInt1);
      localLayoutParams.leftMargin = getItemMaigin(0, paramInt1);
      localLayoutParams.rightMargin = getItemMaigin(2, paramInt1);
      paramViewHolderWrapper.itemView.setLayoutParams(localLayoutParams);
      ((RecyclerViewItem)paramViewHolderWrapper.itemView).mHolder = paramViewHolderWrapper;
      paramViewHolderWrapper.mForceBind = paramViewHolderWrapper.mContentHolder.mForceBind;
      paramViewHolderWrapper.itemView.setFocusable(paramViewHolderWrapper.mContentHolder.mFocusable);
      paramViewHolderWrapper.itemView.setOnClickListener(new RecyclerAdapter.1(this, paramViewHolderWrapper));
      return;
      if (this.mParentRecyclerView.mLayout.canScrollHorizontally()) {
        localLayoutParams = new RecyclerViewBase.LayoutParams(getItemWidth(paramInt1), -1);
      } else {
        localLayoutParams = new RecyclerViewBase.LayoutParams(-1, getItemHeight(paramInt1));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.mLoadingStatus == 4) || (this.mLoadingStatus == 9) || (this.mLoadingStatus == 10)) {
      onClickRetry();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.mLoadingStatus == 6) {
        onClickBackward();
      }
    }
  }
  
  protected void onClickBackward()
  {
    this.mParentRecyclerView.smoothScrollBy(0, -this.mParentRecyclerView.mOffsetY);
  }
  
  protected void onClickRetry() {}
  
  public ContentHolder onCreateContentView(ViewGroup paramViewGroup, int paramInt)
  {
    return null;
  }
  
  public ContentHolder onCreateContentViewWithPos(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public View onCreateCustomerView(ViewGroup paramViewGroup, int paramInt)
  {
    return null;
  }
  
  public RecyclerView.ViewHolderWrapper onCreateSuspendViewHolderWithPos(RecyclerViewBase paramRecyclerViewBase, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public RecyclerView.ViewHolderWrapper onCreateViewHolder(RecyclerViewBase paramRecyclerViewBase, int paramInt)
  {
    RecyclerViewItem localRecyclerViewItem = getViewItem(paramRecyclerViewBase);
    ContentHolder localContentHolder = onCreateContentView(localRecyclerViewItem, paramInt);
    if (localContentHolder == null) {
      return null;
    }
    if (localRecyclerViewItem != null)
    {
      localRecyclerViewItem.addContentView(localContentHolder.mContentView, false);
      localRecyclerViewItem.setPadding(localContentHolder.mItemPaddingLeft, 0, localContentHolder.mItemPaddingRight, 0);
    }
    paramRecyclerViewBase = new RecyclerView.ViewHolderWrapper(localRecyclerViewItem, paramRecyclerViewBase);
    paramRecyclerViewBase.setContentHolder(localContentHolder);
    localContentHolder.mParentViewHolder = paramRecyclerViewBase;
    return paramRecyclerViewBase;
  }
  
  public RecyclerView.ViewHolderWrapper onCreateViewHolderWithPos(RecyclerViewBase paramRecyclerViewBase, int paramInt1, int paramInt2)
  {
    RecyclerViewItem localRecyclerViewItem = getViewItemWithPos(paramRecyclerViewBase, paramInt1);
    ContentHolder localContentHolder = onCreateContentViewWithPos(localRecyclerViewItem, paramInt1, paramInt2);
    if (localContentHolder == null) {
      return null;
    }
    if (localRecyclerViewItem != null)
    {
      localRecyclerViewItem.addContentView(localContentHolder.mContentView, false);
      localRecyclerViewItem.setPadding(localContentHolder.mItemPaddingLeft, 0, localContentHolder.mItemPaddingRight, 0);
    }
    paramRecyclerViewBase = new RecyclerView.ViewHolderWrapper(localRecyclerViewItem, paramRecyclerViewBase);
    paramRecyclerViewBase.setContentHolder(localContentHolder);
    return paramRecyclerViewBase;
  }
  
  public void onEnterModeStart(int paramInt) {}
  
  protected void onShowContextMenu(float paramFloat1, float paramFloat2, int paramInt) {}
  
  protected void onViewAbandon(RecyclerView.ViewHolderWrapper paramViewHolderWrapper) {}
  
  protected void onViewAttached()
  {
    super.onViewAttached();
  }
  
  protected void onViewDetached()
  {
    super.onViewDetached();
  }
  
  public void onViewRecycled(ContentHolder paramContentHolder, int paramInt) {}
  
  protected void onViewRecycled(RecyclerView.ViewHolderWrapper paramViewHolderWrapper)
  {
    onViewRecycled(paramViewHolderWrapper.mContentHolder, paramViewHolderWrapper.mPosition);
  }
  
  public void positionContentView(ContentHolder paramContentHolder, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt2 == 2) || (paramInt2 == 3)) {}
    while ((paramInt2 != 1) || (paramContentHolder == null) || (paramContentHolder.mContentView == null)) {
      return;
    }
    paramContentHolder = (FrameLayout.LayoutParams)paramContentHolder.mContentView.getLayoutParams();
    paramContentHolder.gravity = 5;
    paramContentHolder.leftMargin = 0;
    paramContentHolder.rightMargin = 0;
  }
  
  public void removeData(int paramInt1, int paramInt2)
  {
    if ((this.mDataList.size() >= paramInt1 + paramInt2) && (paramInt1 >= 0) && (paramInt2 > 0))
    {
      this.mDataList.subList(paramInt1, paramInt1 + paramInt2).clear();
      this.mContentHeight = -1;
    }
  }
  
  public void removeDatas(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext())
    {
      RecyclerAdapter.DataHolder localDataHolder = (RecyclerAdapter.DataHolder)localIterator.next();
      if (localDataHolder.mItemViewType == paramInt) {
        localArrayList.add(localDataHolder);
      }
    }
    this.mDataList.removeAll(localArrayList);
    this.mContentHeight = -1;
  }
  
  public void reset()
  {
    this.mContentHeight = -1;
    dataChanged();
  }
  
  public void setItemClickListener(RecyclerAdapter.RecyclerViewItemListener paramRecyclerViewItemListener)
  {
    this.mRecyclerViewItemListener = paramRecyclerViewItemListener;
  }
  
  public void setItemOffset(int paramInt1, int paramInt2)
  {
    if (this.mOffsetMap != null) {
      this.mOffsetMap.put(paramInt1, paramInt2);
    }
  }
  
  public void setLoadingStatus(int paramInt)
  {
    setLoadingStatus(paramInt, -1);
  }
  
  public void setLoadingStatus(int paramInt1, int paramInt2)
  {
    this.mLoadingStatus = paramInt1;
    if ((this.mDefaultLoadingView != null) && ((this.mDefaultLoadingView instanceof IRecyclerViewFooter))) {
      ((IRecyclerViewFooter)this.mDefaultLoadingView).setLoadingStatus(paramInt1);
    }
  }
  
  public void setParentRecyclerView(RecyclerView paramRecyclerView)
  {
    this.mParentRecyclerView = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter
 * JD-Core Version:    0.7.0.1
 */