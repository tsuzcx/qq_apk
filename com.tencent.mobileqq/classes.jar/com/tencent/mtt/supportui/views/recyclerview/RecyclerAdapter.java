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
    if (!this.mParentRecyclerView.hasSuspentedItem()) {
      return;
    }
    if (this.mSuspentedPos == null) {
      this.mSuspentedPos = new ArrayList();
    }
    if (!this.mSuspentedPos.contains(Integer.valueOf(paramInt))) {
      this.mSuspentedPos.add(Integer.valueOf(paramInt));
    }
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
    if (paramSparseIntArray != null)
    {
      if (paramSparseIntArray.size() == 0) {
        return -1;
      }
      int j = paramSparseIntArray.keyAt(0);
      int i = paramSparseIntArray.keyAt(paramSparseIntArray.size() - 1);
      while (j <= i)
      {
        int k = (i - j >> 1) + j;
        int m = itemRangeCompare(k, paramSparseIntArray.valueAt(k), paramInt);
        if (m == 0) {
          return k;
        }
        if (m > 0) {
          i = k - 1;
        } else {
          j = k + 1;
        }
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
    if ((this.mParentRecyclerView != null) && (doDeleteItem()))
    {
      RecyclerView localRecyclerView = this.mParentRecyclerView;
      localRecyclerView.postAdapterUpdate(localRecyclerView.obtainUpdateOp(1, paramInt, 1));
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
    List localList = this.mSuspentedPos;
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return -1;
      }
      paramInt = findPrevSuspentedPos(paramInt);
      int i = this.mSuspentedPos.indexOf(Integer.valueOf(paramInt));
      if (paramInt != -1)
      {
        paramInt = i + 1;
        if (paramInt >= this.mSuspentedPos.size()) {
          return -1;
        }
        return ((Integer)this.mSuspentedPos.get(paramInt)).intValue();
      }
    }
    return -1;
  }
  
  public int findPrevSuspentedPos(int paramInt)
  {
    initSuspentedPosIfNeed();
    Object localObject = this.mSuspentedPos;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return -1;
      }
      int j = this.mSuspentedPos.size();
      int i = 0;
      if (i < j)
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
        }
      }
      for (localObject = this.mSuspentedPos.get(i - 1);; localObject = this.mSuspentedPos.get(j - 1))
      {
        return ((Integer)localObject).intValue();
        i += 1;
        break;
      }
    }
    return -1;
  }
  
  public void forceUpdateOffsetMap()
  {
    this.mDataChanged = true;
    calculateOffsetMapIfNeed();
  }
  
  public int[] getBeginPositionWithOffset(int paramInt)
  {
    int[] arrayOfInt = new int[2];
    int k = getItemCount() + getFooterViewCount();
    int m = getHeaderViewCount();
    int n = this.mParentRecyclerView.getCachedTotalHeight();
    int i = 1;
    int j = 0;
    while (i <= m)
    {
      j += getHeaderViewHeight(i);
      i += 1;
    }
    if (paramInt >= n)
    {
      arrayOfInt[0] = k;
      arrayOfInt[1] = (n - getItemHeight(k) - paramInt);
      return arrayOfInt;
    }
    if (paramInt < 0)
    {
      arrayOfInt[0] = (-m);
      arrayOfInt[1] = (-j - paramInt);
      return arrayOfInt;
    }
    if (paramInt < j)
    {
      i = -m;
      j = 0;
      while (i < 0)
      {
        k = -i;
        j += getHeaderViewHeight(k);
        if (j > paramInt)
        {
          arrayOfInt[0] = i;
          arrayOfInt[1] = (j - getHeaderViewHeight(k) - paramInt);
          return arrayOfInt;
        }
        i += 1;
      }
    }
    calculateOffsetMapIfNeed();
    m = this.mOffsetMap.size() - 1;
    i = this.mOffsetMap.get(m) + getItemRange(m);
    if (paramInt > i)
    {
      k = getFooterViewCount();
      if (k > 0)
      {
        j = 1;
        while (j <= k)
        {
          i += getFooterViewHeight(j);
          if (i > paramInt)
          {
            arrayOfInt[0] = (m + j);
            arrayOfInt[1] = (i - getFooterViewHeight(j) - paramInt);
            k = 1;
            break label276;
          }
          j += 1;
        }
        k = 0;
        label276:
        if (k == 0)
        {
          arrayOfInt[0] = (m + j);
          arrayOfInt[1] = (i - getFooterViewHeight(j) - paramInt);
        }
      }
      return arrayOfInt;
    }
    i = binarySearch(this.mOffsetMap, paramInt);
    if (paramInt == 0) {
      i = 0;
    }
    if (i != -1)
    {
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
      else if (this.mParentRecyclerView.mLayoutType == 1)
      {
        arrayOfInt[0] = i;
      }
      else if (this.mParentRecyclerView.mLayoutType == 3)
      {
        arrayOfInt[0] = i;
      }
      arrayOfInt[1] = (k - paramInt);
    }
    return arrayOfInt;
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
    catch (Exception localException)
    {
      label38:
      break label38;
    }
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
    catch (Exception localException)
    {
      label29:
      break label29;
    }
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
        if (this.mDefaultLoadingView == null)
        {
          localObject = this.mParentRecyclerView;
          this.mDefaultLoadingView = ((RecyclerView)localObject).createFooterView(((RecyclerView)localObject).getContext());
        }
        Object localObject = this.mDefaultLoadingView;
        if (localObject != null) {
          ((View)localObject).setOnClickListener(this);
        }
        localObject = this.mDefaultLoadingView;
        if ((localObject != null) && ((localObject instanceof IRecyclerViewFooter))) {
          ((IRecyclerViewFooter)localObject).setLoadingStatus(this.mLoadingStatus);
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
    int i = -getHeaderViewCount();
    if (paramInt >= i)
    {
      if (paramInt >= 0)
      {
        calculateOffsetMapIfNeed();
        return this.mOffsetMap.get(paramInt);
      }
      int j = 0;
      while (i < paramInt)
      {
        j += getHeaderViewHeight(-i);
        i += 1;
      }
      return j;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("pos less than header count,should not happened");
    for (;;)
    {
      throw localIllegalStateException;
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
    int k = this.mDataList.size();
    int j = 0;
    int i = j;
    if (paramInt2 < k)
    {
      i = j;
      if (paramInt2 < 0) {}
    }
    try
    {
      RecyclerAdapter.DataHolder localDataHolder = (RecyclerAdapter.DataHolder)this.mDataList.get(paramInt2);
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 != 3) {
              return 0;
            }
            paramInt1 = localDataHolder.mBottomMargin;
          }
          else
          {
            paramInt1 = localDataHolder.mRightMargin;
          }
        }
        else {
          paramInt1 = localDataHolder.mTopMargin;
        }
      }
      else {
        paramInt1 = localDataHolder.mLeftMargin;
      }
      i = paramInt1;
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public int getItemOffset(int paramInt)
  {
    SparseIntArray localSparseIntArray = this.mOffsetMap;
    if (localSparseIntArray != null) {
      return localSparseIntArray.get(paramInt);
    }
    return -1;
  }
  
  protected int getItemRange(int paramInt)
  {
    return getItemHeight(paramInt) + getItemMaigin(1, paramInt) + getItemMaigin(3, paramInt) + 0;
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
    catch (Exception localException)
    {
      label38:
      break label38;
    }
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
    if (isAutoCalculateItemHeight()) {
      this.mContentHeight = -1;
    }
    if (this.mContentHeight == -1)
    {
      int j = getItemCount();
      int i = 0;
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
      i = this.mParentRecyclerView.mLayoutType;
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
    return this.mDataList.isEmpty() ^ true;
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
    if (paramInt2 + paramInt1 < paramInt3) {
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
    if ((paramViewHolderWrapper != null) && (paramViewHolderWrapper.itemView != null))
    {
      if (paramViewHolderWrapper.mContentHolder == null) {
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
      } else if (this.mParentRecyclerView.mLayout.canScrollHorizontally()) {
        localLayoutParams = new RecyclerViewBase.LayoutParams(getItemWidth(paramInt1), -1);
      } else {
        localLayoutParams = new RecyclerViewBase.LayoutParams(-1, getItemHeight(paramInt1));
      }
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
    }
  }
  
  public void onClick(View paramView)
  {
    int i = this.mLoadingStatus;
    if ((i != 4) && (i != 9) && (i != 10))
    {
      if (i == 6) {
        onClickBackward();
      }
    }
    else {
      onClickRetry();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onClickBackward()
  {
    RecyclerView localRecyclerView = this.mParentRecyclerView;
    localRecyclerView.smoothScrollBy(0, -localRecyclerView.mOffsetY);
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
    if (paramInt2 != 2)
    {
      if (paramInt2 == 3) {
        return;
      }
      if ((paramInt2 == 1) && (paramContentHolder != null))
      {
        if (paramContentHolder.mContentView == null) {
          return;
        }
        paramContentHolder = (FrameLayout.LayoutParams)paramContentHolder.mContentView.getLayoutParams();
        paramContentHolder.gravity = 5;
        paramContentHolder.leftMargin = 0;
        paramContentHolder.rightMargin = 0;
      }
    }
  }
  
  public void removeData(int paramInt1, int paramInt2)
  {
    int i = this.mDataList.size();
    int j = paramInt1 + paramInt2;
    if ((i >= j) && (paramInt1 >= 0) && (paramInt2 > 0))
    {
      this.mDataList.subList(paramInt1, j).clear();
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
    SparseIntArray localSparseIntArray = this.mOffsetMap;
    if (localSparseIntArray != null) {
      localSparseIntArray.put(paramInt1, paramInt2);
    }
  }
  
  public void setLoadingStatus(int paramInt)
  {
    setLoadingStatus(paramInt, -1);
  }
  
  public void setLoadingStatus(int paramInt1, int paramInt2)
  {
    this.mLoadingStatus = paramInt1;
    View localView = this.mDefaultLoadingView;
    if ((localView != null) && ((localView instanceof IRecyclerViewFooter))) {
      ((IRecyclerViewFooter)localView).setLoadingStatus(paramInt1);
    }
  }
  
  public void setParentRecyclerView(RecyclerView paramRecyclerView)
  {
    this.mParentRecyclerView = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter
 * JD-Core Version:    0.7.0.1
 */