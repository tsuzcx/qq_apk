package com.tencent.mtt.supportui.views.recyclerview;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mtt.supportui.utils.struct.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RecyclerViewBase$Recycler
{
  static final int DEFAULT_CACHE_SIZE = 2;
  public final ArrayList<RecyclerViewBase.ViewHolder> mAttachedScrap = new ArrayList();
  public final ArrayList<RecyclerViewBase.ViewHolder> mCachedViews = new ArrayList();
  public RecyclerViewBase.RecycledViewPool mRecyclerPool;
  final List<RecyclerViewBase.ViewHolder> mUnmodifiableAttachedScrap = Collections.unmodifiableList(this.mAttachedScrap);
  int mViewCacheMax = 2;
  
  public RecyclerViewBase$Recycler(RecyclerViewBase paramRecyclerViewBase) {}
  
  private void dispatchViewStateChange(View paramView, int paramInt)
  {
    if ((paramView instanceof IViewRecycleStateListener)) {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          ((IViewRecycleStateListener)paramView).onRecycle();
        }
      }
      else {
        ((IViewRecycleStateListener)paramView).onUse();
      }
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        dispatchViewStateChange(paramView.getChildAt(i), paramInt);
        i += 1;
      }
    }
  }
  
  protected boolean checkShouldValidateViewHolder()
  {
    return true;
  }
  
  public void clear()
  {
    this.mAttachedScrap.clear();
    recycleCachedViews();
  }
  
  void clearOldPositions()
  {
    int j = this.mCachedViews.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerViewBase.ViewHolder)this.mCachedViews.get(i)).clearOldPosition();
      i += 1;
    }
  }
  
  void clearScrap()
  {
    this.mAttachedScrap.clear();
  }
  
  public void dispatchViewRecycled(RecyclerViewBase.ViewHolder paramViewHolder)
  {
    if (this.this$0.mAdapter != null) {
      this.this$0.mAdapter.onViewRecycled(paramViewHolder);
    }
    dispatchViewStateChange(paramViewHolder.mContentHolder.mContentView, 2);
  }
  
  public String dump()
  {
    return "";
  }
  
  RecyclerViewBase.ViewHolder findViewHolderForItemId(long paramLong)
  {
    if (!this.this$0.mAdapter.hasStableIds()) {
      return null;
    }
    int j = this.mCachedViews.size();
    int i = 0;
    while (i < j)
    {
      RecyclerViewBase.ViewHolder localViewHolder = (RecyclerViewBase.ViewHolder)this.mCachedViews.get(i);
      if ((localViewHolder != null) && (localViewHolder.getItemId() == paramLong))
      {
        this.mCachedViews.remove(i);
        return localViewHolder;
      }
      i += 1;
    }
    return null;
  }
  
  RecyclerViewBase.ViewHolder findViewHolderForPosition(int paramInt)
  {
    int j = this.mCachedViews.size();
    int i = 0;
    while (i < j)
    {
      RecyclerViewBase.ViewHolder localViewHolder = (RecyclerViewBase.ViewHolder)this.mCachedViews.get(i);
      if ((localViewHolder != null) && (localViewHolder.getPosition() == paramInt))
      {
        this.mCachedViews.remove(i);
        return localViewHolder;
      }
      i += 1;
    }
    return null;
  }
  
  public View getFooterForPosition(int paramInt)
  {
    View localView = getScrapFooterView(paramInt - 1);
    if (localView != null) {
      return localView;
    }
    return this.this$0.mAdapter.getFooterView(paramInt);
  }
  
  public View getHeaderForPosition(int paramInt)
  {
    return this.this$0.mAdapter.getHeaderView(paramInt);
  }
  
  public RecyclerViewBase.RecycledViewPool getRecycledViewPool()
  {
    if (this.mRecyclerPool == null) {
      this.mRecyclerPool = new RecyclerViewBase.RecycledViewPool();
    }
    return this.mRecyclerPool;
  }
  
  int getScrapCount()
  {
    return this.mAttachedScrap.size();
  }
  
  public View getScrapFooterView(int paramInt)
  {
    int j = this.mAttachedScrap.size();
    int i = 0;
    while (i < j)
    {
      RecyclerViewBase.ViewHolder localViewHolder = (RecyclerViewBase.ViewHolder)this.mAttachedScrap.get(i);
      if ((localViewHolder != null) && (localViewHolder.mPosition == paramInt) && ((localViewHolder.itemView instanceof IRecyclerViewFooter)))
      {
        this.mAttachedScrap.remove(i);
        return localViewHolder.itemView;
      }
      i += 1;
    }
    return null;
  }
  
  public List<RecyclerViewBase.ViewHolder> getScrapList()
  {
    return this.mUnmodifiableAttachedScrap;
  }
  
  View getScrapViewAt(int paramInt)
  {
    return ((RecyclerViewBase.ViewHolder)this.mAttachedScrap.get(paramInt)).itemView;
  }
  
  RecyclerViewBase.ViewHolder getScrapViewForId(long paramLong, int paramInt)
  {
    int k = this.mAttachedScrap.size();
    int j = 0;
    int i = 0;
    RecyclerViewBase.ViewHolder localViewHolder;
    while (i < k)
    {
      localViewHolder = (RecyclerViewBase.ViewHolder)this.mAttachedScrap.get(i);
      if (localViewHolder.getItemId() == paramLong)
      {
        if (paramInt != localViewHolder.getItemViewType()) {
          break;
        }
        this.mAttachedScrap.remove(i);
        localViewHolder.setScrapContainer(null);
        return localViewHolder;
      }
      i += 1;
    }
    k = this.mCachedViews.size();
    i = j;
    while (i < k)
    {
      localViewHolder = (RecyclerViewBase.ViewHolder)this.mCachedViews.get(i);
      if (localViewHolder.getItemId() == paramLong)
      {
        this.mCachedViews.remove(i);
        return localViewHolder;
      }
      i += 1;
    }
    return getRecycledViewPool().getRecycledView(paramInt, null);
  }
  
  RecyclerViewBase.ViewHolder getScrapViewForPosition(int paramInt1, int paramInt2)
  {
    int k = this.mAttachedScrap.size();
    int j = 0;
    int i = 0;
    RecyclerViewBase.ViewHolder localViewHolder;
    while (i < k)
    {
      localViewHolder = (RecyclerViewBase.ViewHolder)this.mAttachedScrap.get(i);
      if ((localViewHolder.getPosition() == paramInt1) && (!localViewHolder.isInvalid()) && ((this.this$0.mInPreLayout) || (!localViewHolder.isRemoved())))
      {
        if ((paramInt2 != -1) && (localViewHolder.getItemViewType() != paramInt2)) {
          break;
        }
        this.mAttachedScrap.remove(i);
        localViewHolder.setScrapContainer(null);
        return localViewHolder;
      }
      i += 1;
    }
    if (this.this$0.mNumAnimatingViews != 0) {
      handleAnimatingViewInGetScrapView(this.this$0.getAnimatingView(paramInt1, paramInt2));
    }
    k = this.mCachedViews.size();
    i = j;
    while (i < k)
    {
      localViewHolder = (RecyclerViewBase.ViewHolder)this.mCachedViews.get(i);
      if (localViewHolder.getPosition() == paramInt1)
      {
        this.mCachedViews.remove(i);
        if ((!localViewHolder.isInvalid()) && ((paramInt2 == -1) || (localViewHolder.getItemViewType() == paramInt2))) {
          return localViewHolder;
        }
        dispatchViewRecycled(localViewHolder);
        if (!localViewHolder.isRecyclable()) {
          break;
        }
        getRecycledViewPool().putRecycledView(localViewHolder, this.this$0.mAdapter);
        break;
      }
      i += 1;
    }
    if (paramInt2 == -1) {
      return null;
    }
    return getRecycledViewPool().getRecycledView(paramInt2, this.this$0.mAdapter.getViewHolderReUseKey(paramInt1));
  }
  
  public View getSuspendViewForPosition(int paramInt)
  {
    if (this.this$0.mAdapter == null) {
      return null;
    }
    paramInt = this.this$0.findPositionOffset(paramInt);
    Object localObject1;
    if (this.this$0.mAdapter.hasCustomRecycler()) {
      localObject1 = this.this$0.mAdapter.findSuspendHolderForPosition(paramInt, this);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      if (paramInt >= 0)
      {
        if (paramInt >= this.this$0.mAdapter.getItemCount()) {
          return null;
        }
        localObject1 = this.this$0.mAdapter;
        localObject2 = this.this$0;
        localObject2 = ((RecyclerViewBase.Adapter)localObject1).createSuspendViewHolderWithPos((RecyclerViewBase)localObject2, paramInt, ((RecyclerViewBase)localObject2).mAdapter.getItemViewType(paramInt));
      }
      else
      {
        return null;
      }
    }
    if (localObject2 != null)
    {
      if ((((RecyclerViewBase.ViewHolder)localObject2).mBindNextTime) || (((RecyclerViewBase.ViewHolder)localObject2).mForceBind) || ((!((RecyclerViewBase.ViewHolder)localObject2).isRemoved()) && ((!((RecyclerViewBase.ViewHolder)localObject2).isBound()) || (((RecyclerViewBase.ViewHolder)localObject2).needsUpdate()))))
      {
        ((RecyclerViewBase.ViewHolder)localObject2).mBindNextTime = false;
        this.this$0.mAdapter.bindViewHolder((RecyclerViewBase.ViewHolder)localObject2, paramInt, ((RecyclerViewBase.ViewHolder)localObject2).isBound() ^ true, this.this$0.mLayoutType, this.this$0.mAdapter.getCardItemViewType(paramInt));
      }
      ViewGroup.LayoutParams localLayoutParams = ((RecyclerViewBase.ViewHolder)localObject2).itemView.getLayoutParams();
      if (localLayoutParams == null) {}
      for (localObject1 = this.this$0.generateDefaultLayoutParams();; localObject1 = this.this$0.generateLayoutParams(localLayoutParams))
      {
        ((RecyclerViewBase.ViewHolder)localObject2).itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break;
        localObject1 = localLayoutParams;
        if (this.this$0.checkLayoutParams(localLayoutParams)) {
          break;
        }
      }
      ((RecyclerViewBase.LayoutParams)localObject1).mViewHolder = ((RecyclerViewBase.ViewHolder)localObject2);
      if (((RecyclerViewBase.ViewHolder)localObject2).mContentHolder != null) {
        dispatchViewStateChange(((RecyclerViewBase.ViewHolder)localObject2).mContentHolder.mContentView, 1);
      }
      return ((RecyclerViewBase.ViewHolder)localObject2).itemView;
    }
    return null;
  }
  
  public View getViewForPosition(int paramInt)
  {
    if (this.this$0.mAdapter == null) {
      return null;
    }
    paramInt = this.this$0.findPositionOffset(paramInt);
    if (((this.this$0.getLayoutManager() instanceof BaseLayoutManager)) && (!this.this$0.isRepeatableSuspensionMode()))
    {
      localObject1 = ((BaseLayoutManager)this.this$0.getLayoutManager()).getCurrentSuspentionView();
      if ((localObject1 != null) && (paramInt == ((BaseLayoutManager)this.this$0.getLayoutManager()).getCurrentSuspentionPosition()))
      {
        if (localObject1 != null)
        {
          localObject1 = this.this$0.getChildViewHolder((View)localObject1);
          if (localObject1 != null) {
            ((RecyclerViewBase.ViewHolder)localObject1).setIsRecyclable(true);
          }
        }
        ((BaseLayoutManager)this.this$0.getLayoutManager()).removeSuspentions();
      }
    }
    if (this.this$0.mAdapter.hasCustomRecycler()) {
      localObject1 = this.this$0.mAdapter.findBestHolderForPosition(paramInt, this);
    } else {
      localObject1 = getViewHolderForPosition(paramInt);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      if (paramInt >= 0)
      {
        if (paramInt >= this.this$0.mAdapter.getItemCount()) {
          return null;
        }
        localObject1 = this.this$0.mAdapter;
        localObject2 = this.this$0;
        localObject2 = ((RecyclerViewBase.Adapter)localObject1).createViewHolderWithPos((RecyclerViewBase)localObject2, paramInt, ((RecyclerViewBase)localObject2).mAdapter.getItemViewType(paramInt));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = this.this$0.mAdapter;
          localObject2 = this.this$0;
          localObject1 = ((RecyclerViewBase.Adapter)localObject1).createViewHolder((RecyclerViewBase)localObject2, ((RecyclerViewBase)localObject2).mAdapter.getItemViewType(paramInt));
        }
        if (localObject1 != null)
        {
          ((RecyclerViewBase.ViewHolder)localObject1).mHolderReuseKey = this.this$0.mAdapter.getViewHolderReUseKey(paramInt);
          localObject2 = localObject1;
        }
        else
        {
          throw new RuntimeException("Must implement onCreateContentView or onCreateContentViewWithPos in your adapter");
        }
      }
      else
      {
        return null;
      }
    }
    handleBindViewHolderInGetView((RecyclerViewBase.ViewHolder)localObject2, paramInt);
    ViewGroup.LayoutParams localLayoutParams = ((RecyclerViewBase.ViewHolder)localObject2).itemView.getLayoutParams();
    if (localLayoutParams == null) {}
    for (Object localObject1 = this.this$0.generateDefaultLayoutParams();; localObject1 = this.this$0.generateLayoutParams(localLayoutParams))
    {
      ((RecyclerViewBase.ViewHolder)localObject2).itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break;
      localObject1 = localLayoutParams;
      if (this.this$0.checkLayoutParams(localLayoutParams)) {
        break;
      }
    }
    ((RecyclerViewBase.LayoutParams)localObject1).mViewHolder = ((RecyclerViewBase.ViewHolder)localObject2);
    if (((RecyclerViewBase.ViewHolder)localObject2).mContentHolder != null) {
      dispatchViewStateChange(((RecyclerViewBase.ViewHolder)localObject2).mContentHolder.mContentView, 1);
    }
    return ((RecyclerViewBase.ViewHolder)localObject2).itemView;
  }
  
  public RecyclerViewBase.ViewHolder getViewHolderForPosition(int paramInt)
  {
    RecyclerViewBase.ViewHolder localViewHolder2 = getScrapViewForPosition(paramInt, -1);
    RecyclerViewBase.ViewHolder localViewHolder1;
    if (localViewHolder2 != null)
    {
      localViewHolder1 = localViewHolder2;
      if (checkShouldValidateViewHolder())
      {
        localViewHolder1 = localViewHolder2;
        if (!validateViewHolderForOffsetPosition(localViewHolder2, paramInt))
        {
          RecyclerViewBase.access$200(this.this$0, localViewHolder2.itemView, false);
          quickRecycleScrapView(localViewHolder2.itemView);
          int i = this.this$0.mAdapter.getItemViewType(paramInt);
          if (this.this$0.mAdapter.hasStableIds()) {
            localViewHolder1 = getScrapViewForId(this.this$0.mAdapter.getItemId(paramInt), i);
          } else {
            localViewHolder1 = getScrapViewForPosition(paramInt, i);
          }
          return localViewHolder1;
        }
      }
    }
    else
    {
      localViewHolder1 = getRecycledViewPool().getRecycledView(this.this$0.mAdapter.getItemViewType(paramInt), this.this$0.mAdapter.getViewHolderReUseKey(paramInt));
    }
    return localViewHolder1;
  }
  
  protected void handleAnimatingViewInGetScrapView(View paramView) {}
  
  protected void handleBindViewHolderInGetView(RecyclerViewBase.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder.mBindNextTime) || (paramViewHolder.mForceBind) || ((!paramViewHolder.isRemoved()) && ((!paramViewHolder.isBound()) || (paramViewHolder.needsUpdate()))))
    {
      paramViewHolder.mBindNextTime = false;
      this.this$0.mAdapter.bindViewHolder(paramViewHolder, paramInt, true, this.this$0.mLayoutType, this.this$0.mAdapter.getCardItemViewType(paramInt));
    }
  }
  
  void markKnownViewsInvalid()
  {
    int j = this.mCachedViews.size();
    int i = 0;
    while (i < j)
    {
      RecyclerViewBase.ViewHolder localViewHolder = (RecyclerViewBase.ViewHolder)this.mCachedViews.get(i);
      if (localViewHolder != null) {
        localViewHolder.addFlags(6);
      }
      i += 1;
    }
    recycleCachedViews();
  }
  
  public void notifyLastFooterAppeared()
  {
    if (this.this$0.mAdapter != null) {
      this.this$0.mAdapter.notifyLastFooterAppeared();
    }
  }
  
  protected void offsetPositionRecordsForInsert(int paramInt1, int paramInt2)
  {
    int j = this.mCachedViews.size();
    int i = 0;
    while (i < j)
    {
      RecyclerViewBase.ViewHolder localViewHolder = (RecyclerViewBase.ViewHolder)this.mCachedViews.get(i);
      if ((localViewHolder != null) && (localViewHolder.getPosition() >= paramInt1)) {
        localViewHolder.offsetPosition(paramInt2);
      }
      i += 1;
    }
  }
  
  protected void offsetPositionRecordsForRemove(int paramInt1, int paramInt2)
  {
    int i = this.mCachedViews.size() - 1;
    while (i >= 0)
    {
      RecyclerViewBase.ViewHolder localViewHolder = (RecyclerViewBase.ViewHolder)this.mCachedViews.get(i);
      if (localViewHolder != null) {
        if (localViewHolder.getPosition() >= paramInt1 + paramInt2)
        {
          localViewHolder.offsetPosition(-paramInt2);
        }
        else if (localViewHolder.getPosition() >= paramInt1)
        {
          this.mCachedViews.remove(i);
          dispatchViewRecycled(localViewHolder);
          getRecycledViewPool().putRecycledView(localViewHolder, this.this$0.mAdapter);
        }
      }
      i -= 1;
    }
  }
  
  void onAdapterChanged(RecyclerViewBase.Adapter paramAdapter1, RecyclerViewBase.Adapter paramAdapter2)
  {
    clear();
    getRecycledViewPool().onAdapterChanged(paramAdapter1, paramAdapter2);
  }
  
  void quickRecycleScrapView(View paramView)
  {
    paramView = RecyclerViewBase.getChildViewHolderInt(paramView);
    paramView.mScrapContainer = null;
    recycleViewHolder(paramView);
  }
  
  void recycleCachedViews()
  {
    int i = this.mCachedViews.size() - 1;
    while (i >= 0)
    {
      RecyclerViewBase.ViewHolder localViewHolder = (RecyclerViewBase.ViewHolder)this.mCachedViews.get(i);
      if (localViewHolder.isRecyclable())
      {
        dispatchViewRecycled(localViewHolder);
        getRecycledViewPool().putRecycledView(localViewHolder, this.this$0.mAdapter);
      }
      this.mCachedViews.remove(i);
      i -= 1;
    }
  }
  
  public void recycleView(View paramView)
  {
    recycleViewHolder(RecyclerViewBase.getChildViewHolderInt(paramView));
  }
  
  void recycleViewHolder(RecyclerViewBase.ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null) {
      return;
    }
    if (paramViewHolder.mViewType != 3) {
      return;
    }
    if ((!paramViewHolder.isScrap()) && (paramViewHolder.itemView.getParent() == null))
    {
      boolean bool = paramViewHolder.isInvalid();
      int j = 0;
      int i = j;
      if (!bool) {
        if (!this.this$0.mInPreLayout)
        {
          i = j;
          if (paramViewHolder.isRemoved()) {}
        }
        else
        {
          if ((this.mCachedViews.size() == this.mViewCacheMax) && (!this.mCachedViews.isEmpty()))
          {
            i = 0;
            while (i < this.mCachedViews.size())
            {
              RecyclerViewBase.ViewHolder localViewHolder = (RecyclerViewBase.ViewHolder)this.mCachedViews.get(i);
              if (localViewHolder.isRecyclable())
              {
                this.mCachedViews.remove(i);
                dispatchViewRecycled(localViewHolder);
                getRecycledViewPool().putRecycledView(localViewHolder, this.this$0.mAdapter);
                break;
              }
              i += 1;
            }
          }
          i = j;
          if (this.mCachedViews.size() < this.mViewCacheMax)
          {
            this.mCachedViews.add(paramViewHolder);
            i = 1;
          }
        }
      }
      if ((i == 0) && (paramViewHolder.isRecyclable()))
      {
        dispatchViewRecycled(paramViewHolder);
        getRecycledViewPool().putRecycledView(paramViewHolder, this.this$0.mAdapter);
      }
      this.this$0.mState.mPreLayoutHolderMap.remove(paramViewHolder);
      this.this$0.mState.mPostLayoutHolderMap.remove(paramViewHolder);
      return;
    }
    paramViewHolder = new IllegalArgumentException("Scrapped or attached views may not be recycled.");
    for (;;)
    {
      throw paramViewHolder;
    }
  }
  
  void scrapView(View paramView)
  {
    paramView = RecyclerViewBase.getChildViewHolderInt(paramView);
    if (paramView != null)
    {
      paramView.setScrapContainer(this);
      this.mAttachedScrap.add(paramView);
    }
  }
  
  void setRecycledViewPool(RecyclerViewBase.RecycledViewPool paramRecycledViewPool)
  {
    RecyclerViewBase.RecycledViewPool localRecycledViewPool = this.mRecyclerPool;
    if (localRecycledViewPool != null) {
      localRecycledViewPool.detach();
    }
    this.mRecyclerPool = paramRecycledViewPool;
    if (paramRecycledViewPool != null) {
      this.mRecyclerPool.attach(this.this$0.getAdapter());
    }
  }
  
  public void setViewCacheSize(int paramInt)
  {
    this.mViewCacheMax = paramInt;
    while (this.mCachedViews.size() > paramInt)
    {
      ArrayList localArrayList = this.mCachedViews;
      localArrayList.remove(localArrayList.size() - 1);
    }
  }
  
  void unscrapView(RecyclerViewBase.ViewHolder paramViewHolder)
  {
    this.mAttachedScrap.remove(paramViewHolder);
    paramViewHolder.mScrapContainer = null;
  }
  
  public void updateHolderPositionWhenDelete(int paramInt)
  {
    if (paramInt >= 0)
    {
      int k = this.mCachedViews.size();
      int j = 0;
      int i = 0;
      while (i < k)
      {
        localObject = (RecyclerViewBase.ViewHolder)this.mCachedViews.get(i);
        if (((RecyclerViewBase.ViewHolder)localObject).mPosition > paramInt) {
          ((RecyclerViewBase.ViewHolder)localObject).mPosition -= 1;
        }
        i += 1;
      }
      k = this.mAttachedScrap.size();
      i = j;
      while (i < k)
      {
        localObject = (RecyclerViewBase.ViewHolder)this.mAttachedScrap.get(i);
        if (((RecyclerViewBase.ViewHolder)localObject).mPosition > paramInt) {
          ((RecyclerViewBase.ViewHolder)localObject).mPosition -= 1;
        }
        i += 1;
      }
      i = this.this$0.getAdapter().getItemViewType(paramInt);
      Object localObject = (ArrayList)getRecycledViewPool().mScrap.get(i);
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          RecyclerViewBase.ViewHolder localViewHolder = (RecyclerViewBase.ViewHolder)((Iterator)localObject).next();
          if ((localViewHolder.getItemViewType() == i) && (localViewHolder.mPosition > paramInt)) {
            localViewHolder.mPosition -= 1;
          }
        }
      }
    }
  }
  
  boolean validateViewHolderForOffsetPosition(RecyclerViewBase.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder.isRemoved()) {
      return true;
    }
    boolean bool = false;
    if (paramInt >= 0)
    {
      if (paramInt >= this.this$0.mAdapter.getItemCount()) {
        return false;
      }
      if (this.this$0.mAdapter.getItemViewType(paramInt) != paramViewHolder.getItemViewType()) {
        return false;
      }
      if (this.this$0.mAdapter.hasStableIds())
      {
        if (paramViewHolder.getItemId() == this.this$0.mAdapter.getItemId(paramInt)) {
          bool = true;
        }
        return bool;
      }
      return true;
    }
    return false;
  }
  
  void viewRangeUpdate(int paramInt1, int paramInt2)
  {
    int j = this.mCachedViews.size();
    int i = 0;
    while (i < j)
    {
      RecyclerViewBase.ViewHolder localViewHolder = (RecyclerViewBase.ViewHolder)this.mCachedViews.get(i);
      if (localViewHolder != null)
      {
        int k = localViewHolder.getPosition();
        if ((k >= paramInt1) && (k < paramInt2 + paramInt1)) {
          localViewHolder.addFlags(2);
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Recycler
 * JD-Core Version:    0.7.0.1
 */