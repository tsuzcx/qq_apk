package com.tencent.mtt.hippy.views.list;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.DiffUtils;
import com.tencent.mtt.hippy.uimanager.ListItemRenderNode;
import com.tencent.mtt.hippy.uimanager.RenderManager;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.uimanager.h;
import com.tencent.mtt.hippy.uimanager.i;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.refresh.HippyPullFooterView;
import com.tencent.mtt.hippy.views.refresh.HippyPullHeaderView;
import com.tencent.mtt.supportui.views.recyclerview.ContentHolder;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.ViewHolderWrapper;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.RecycledViewPool;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Recycler;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HippyListAdapter
  extends RecyclerAdapter
  implements IRecycleItemTypeChange
{
  private static final String TAG = "HippyListAdapter";
  protected final HippyEngineContext mHippyContext;
  ArrayList<RecyclerViewBase.ViewHolder> mListViewHolder;
  private HippyListAdapter.OnEndReachedEvent mOnEndReachedEvent;
  private int mPreloadItemNum = 0;
  private RecyclerViewBase.Recycler mRecycler;
  
  public HippyListAdapter(RecyclerView paramRecyclerView, HippyEngineContext paramHippyEngineContext)
  {
    super(paramRecyclerView);
    this.mHippyContext = paramHippyEngineContext;
  }
  
  private void checkHolderType(int paramInt1, int paramInt2, ListItemRenderNode paramListItemRenderNode)
  {
    int k = this.mParentRecyclerView.getChildCount();
    int j = 0;
    int i = 0;
    Object localObject;
    while (i < k)
    {
      localObject = this.mParentRecyclerView.getChildViewHolder(this.mParentRecyclerView.getChildAt(i));
      if ((((RecyclerViewBase.ViewHolder)localObject).getItemViewType() == paramInt1) && ((((RecyclerViewBase.ViewHolder)localObject).mContentHolder instanceof NodeHolder)) && (((NodeHolder)((RecyclerViewBase.ViewHolder)localObject).mContentHolder).mBindNode == paramListItemRenderNode))
      {
        ((RecyclerViewBase.ViewHolder)localObject).setItemViewType(paramInt2);
        return;
      }
      i += 1;
    }
    k = this.mRecycler.mAttachedScrap.size();
    i = 0;
    while (i < k)
    {
      localObject = (RecyclerViewBase.ViewHolder)this.mRecycler.mAttachedScrap.get(i);
      if ((((RecyclerViewBase.ViewHolder)localObject).getItemViewType() == paramInt1) && ((((RecyclerViewBase.ViewHolder)localObject).mContentHolder instanceof NodeHolder)) && (((NodeHolder)((RecyclerViewBase.ViewHolder)localObject).mContentHolder).mBindNode == paramListItemRenderNode))
      {
        ((RecyclerViewBase.ViewHolder)localObject).setItemViewType(paramInt2);
        return;
      }
      i += 1;
    }
    k = this.mRecycler.mCachedViews.size();
    i = j;
    while (i < k)
    {
      localObject = (RecyclerViewBase.ViewHolder)this.mRecycler.mCachedViews.get(i);
      if ((((RecyclerViewBase.ViewHolder)localObject).getItemViewType() == paramInt1) && ((((RecyclerViewBase.ViewHolder)localObject).mContentHolder instanceof NodeHolder)) && (((NodeHolder)((RecyclerViewBase.ViewHolder)localObject).mContentHolder).mBindNode == paramListItemRenderNode))
      {
        ((RecyclerViewBase.ViewHolder)localObject).setItemViewType(paramInt2);
        return;
      }
      i += 1;
    }
    if (this.mRecycler.getRecycledViewPool() != null)
    {
      localObject = (ArrayList)this.mRecycler.getRecycledViewPool().mScrap.get(paramInt1);
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        Iterator localIterator = ((ArrayList)localObject).iterator();
        while (localIterator.hasNext())
        {
          RecyclerViewBase.ViewHolder localViewHolder = (RecyclerViewBase.ViewHolder)localIterator.next();
          if ((localViewHolder.getItemViewType() == paramInt1) && ((localViewHolder.mContentHolder instanceof NodeHolder)) && (((NodeHolder)localViewHolder.mContentHolder).mBindNode == paramListItemRenderNode))
          {
            localViewHolder.setItemViewType(paramInt2);
            ((ArrayList)localObject).remove(localViewHolder);
            this.mRecycler.getRecycledViewPool().getScrapHeapForType(paramInt2).add(localViewHolder);
          }
        }
      }
    }
  }
  
  private RecyclerViewBase.ViewHolder getRecycledViewFromPoolInner(RecyclerViewBase.RecycledViewPool paramRecycledViewPool, int paramInt1, int paramInt2)
  {
    if (paramRecycledViewPool != null)
    {
      paramRecycledViewPool = (ArrayList)paramRecycledViewPool.mScrap.get(paramInt1);
      if ((paramRecycledViewPool != null) && (!paramRecycledViewPool.isEmpty()))
      {
        Iterator localIterator = paramRecycledViewPool.iterator();
        while (localIterator.hasNext())
        {
          RecyclerViewBase.ViewHolder localViewHolder = (RecyclerViewBase.ViewHolder)localIterator.next();
          if ((localViewHolder.getItemViewType() == paramInt1) && ((localViewHolder.mContentHolder instanceof NodeHolder)) && (((NodeHolder)localViewHolder.mContentHolder).mBindNode == this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(paramInt2)))
          {
            paramRecycledViewPool.remove(localViewHolder);
            return localViewHolder;
          }
        }
      }
    }
    return null;
  }
  
  private RecyclerViewBase.ViewHolder getScrapViewForPositionInner(int paramInt1, int paramInt2, RecyclerViewBase.Recycler paramRecycler)
  {
    if (this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()) != null)
    {
      if (this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildCount() <= paramInt1) {
        return null;
      }
      int k = paramRecycler.mAttachedScrap.size();
      int j = 0;
      int i = 0;
      RecyclerViewBase.ViewHolder localViewHolder;
      while (i < k)
      {
        localViewHolder = (RecyclerViewBase.ViewHolder)paramRecycler.mAttachedScrap.get(i);
        if ((localViewHolder.getPosition() == paramInt1) && (!localViewHolder.isInvalid()) && (!localViewHolder.isRemoved()) && (localViewHolder.getItemViewType() == paramInt2) && ((localViewHolder.mContentHolder instanceof NodeHolder)) && (((NodeHolder)localViewHolder.mContentHolder).mBindNode == this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(paramInt1)))
        {
          paramRecycler.mAttachedScrap.remove(i);
          localViewHolder.setScrapContainer(null);
          return localViewHolder;
        }
        i += 1;
      }
      k = paramRecycler.mCachedViews.size();
      i = j;
      while (i < k)
      {
        localViewHolder = (RecyclerViewBase.ViewHolder)paramRecycler.mCachedViews.get(i);
        if ((localViewHolder.getPosition() == paramInt1) && (localViewHolder.getItemViewType() == paramInt2) && (!localViewHolder.isInvalid()) && ((localViewHolder.mContentHolder instanceof NodeHolder)) && (((NodeHolder)localViewHolder.mContentHolder).mBindNode == this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(paramInt1)))
        {
          paramRecycler.mCachedViews.remove(i);
          return localViewHolder;
        }
        i += 1;
      }
      return getRecycledViewFromPoolInner(paramRecycler.getRecycledViewPool(), paramInt2, paramInt1);
    }
    return null;
  }
  
  public RecyclerViewBase.ViewHolder findBestHolderForPosition(int paramInt, RecyclerViewBase.Recycler paramRecycler)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("findBestHolderForPosition start : ");
    localStringBuilder.append(paramInt);
    LogUtils.d("HippyListView", localStringBuilder.toString());
    this.mRecycler = paramRecycler;
    paramRecycler = findBestHolderRecursive(paramInt, getItemViewType(paramInt), paramRecycler);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("findBestHolderForPosition end : ");
    localStringBuilder.append(paramInt);
    LogUtils.d("HippyListView", localStringBuilder.toString());
    return paramRecycler;
  }
  
  RecyclerViewBase.ViewHolder findBestHolderRecursive(int paramInt1, int paramInt2, RecyclerViewBase.Recycler paramRecycler)
  {
    Object localObject2 = getScrapViewForPositionInner(paramInt1, paramInt2, paramRecycler);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramRecycler.getViewHolderForPosition(paramInt1);
    }
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((NodeHolder)((RecyclerViewBase.ViewHolder)localObject1).mContentHolder).mBindNode.isDelete()) {
        localObject2 = findBestHolderRecursive(paramInt1, paramInt2, paramRecycler);
      }
    }
    return localObject2;
  }
  
  public RecyclerViewBase.ViewHolder findSuspendHolderForPosition(int paramInt, RecyclerViewBase.Recycler paramRecycler)
  {
    this.mRecycler = paramRecycler;
    RecyclerViewBase.ViewHolder localViewHolder = getScrapViewForPositionInner(paramInt, getItemViewType(paramInt), paramRecycler);
    paramRecycler = localViewHolder;
    if (localViewHolder != null)
    {
      paramRecycler = localViewHolder;
      if (((NodeHolder)localViewHolder.mContentHolder).mBindNode.isDelete()) {
        paramRecycler = null;
      }
    }
    return paramRecycler;
  }
  
  public int getCustomFooterViewHeight()
  {
    RenderNode localRenderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
    if ((localRenderNode != null) && (localRenderNode.getChildCount() > 0))
    {
      localRenderNode = localRenderNode.getChildAt(localRenderNode.getChildCount() - 1);
      if ((localRenderNode instanceof h)) {
        return localRenderNode.getHeight();
      }
    }
    return 0;
  }
  
  public int getCustomFooterViewWidth()
  {
    RenderNode localRenderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
    if ((localRenderNode != null) && (localRenderNode.getChildCount() > 0))
    {
      localRenderNode = localRenderNode.getChildAt(localRenderNode.getChildCount() - 1);
      if ((localRenderNode instanceof h)) {
        return localRenderNode.getWidth();
      }
    }
    return 0;
  }
  
  public int getCustomHeaderViewHeight()
  {
    RenderNode localRenderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
    if ((localRenderNode != null) && (localRenderNode.getChildCount() > 0))
    {
      localRenderNode = localRenderNode.getChildAt(0);
      if ((localRenderNode instanceof i)) {
        return localRenderNode.getHeight();
      }
    }
    return 0;
  }
  
  public int getCustomHeaderViewWidth()
  {
    RenderNode localRenderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
    if ((localRenderNode != null) && (localRenderNode.getChildCount() > 0))
    {
      localRenderNode = localRenderNode.getChildAt(0);
      if ((localRenderNode instanceof i)) {
        return localRenderNode.getWidth();
      }
    }
    return 0;
  }
  
  public int getItemCount()
  {
    RenderNode localRenderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
    if (localRenderNode != null) {
      return localRenderNode.getChildCount();
    }
    return super.getItemCount();
  }
  
  public int getItemHeight(int paramInt)
  {
    RenderNode localRenderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
    if ((localRenderNode != null) && (localRenderNode.getChildCount() > paramInt) && (paramInt >= 0))
    {
      localRenderNode = localRenderNode.getChildAt(paramInt);
      if (localRenderNode != null) {
        return localRenderNode.getHeight();
      }
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
    if ((localObject != null) && (((RenderNode)localObject).getChildCount() > paramInt))
    {
      localObject = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(paramInt);
      if (localObject != null)
      {
        if ((localObject instanceof h)) {
          return 5;
        }
        if ((localObject instanceof i)) {
          return 4;
        }
        if (((RenderNode)localObject).getProps() != null)
        {
          localObject = ((RenderNode)localObject).getProps();
          if (((HippyMap)localObject).get("type") != null) {
            return ((HippyMap)localObject).getInt("type");
          }
        }
      }
    }
    return super.getItemViewType(paramInt);
  }
  
  public int getItemWidth(int paramInt)
  {
    RenderNode localRenderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
    if ((localRenderNode != null) && (localRenderNode.getChildCount() > paramInt) && (paramInt >= 0))
    {
      localRenderNode = localRenderNode.getChildAt(paramInt);
      if (localRenderNode != null) {
        return localRenderNode.getWidth();
      }
    }
    return 0;
  }
  
  protected HippyListAdapter.OnEndReachedEvent getOnEndReachedEvent()
  {
    if (this.mOnEndReachedEvent == null) {
      this.mOnEndReachedEvent = new HippyListAdapter.OnEndReachedEvent(this, "onLoadMore");
    }
    return this.mOnEndReachedEvent;
  }
  
  public int getPreloadThresholdInItemNumber()
  {
    return this.mPreloadItemNum;
  }
  
  public int getRecyclerItemCount()
  {
    this.mListViewHolder = new ArrayList();
    RecyclerViewBase.Recycler localRecycler = this.mParentRecyclerView.getRecycler();
    this.mListViewHolder.addAll(localRecycler.mAttachedScrap);
    this.mListViewHolder.addAll(localRecycler.mCachedViews);
    int i = 0;
    while (i < localRecycler.getRecycledViewPool().mScrap.size())
    {
      this.mListViewHolder.addAll((Collection)localRecycler.getRecycledViewPool().mScrap.valueAt(i));
      i += 1;
    }
    return this.mListViewHolder.size() + this.mParentRecyclerView.getChildCount();
  }
  
  View getRecyclerItemView(int paramInt)
  {
    if (paramInt < this.mListViewHolder.size()) {
      return ((RecyclerViewBase.ViewHolder)this.mListViewHolder.get(paramInt)).mContent;
    }
    return this.mParentRecyclerView.getChildAt(paramInt - this.mListViewHolder.size());
  }
  
  public int getTotalHeight()
  {
    if (isAutoCalculateItemHeight()) {
      this.mContentHeight = -1;
    }
    int i;
    if (this.mContentHeight == -1)
    {
      int m = getItemCount();
      this.mContentHeight = 0;
      if (this.mParentRecyclerView.mLayoutType == 1)
      {
        i = 0;
        while (i < m)
        {
          int j;
          int k;
          if (this.mParentRecyclerView.mLayout.canScrollHorizontally())
          {
            this.mContentHeight += getItemWidth(i);
            this.mContentHeight += getItemMaigin(0, i);
            j = this.mContentHeight;
            k = 2;
          }
          else
          {
            this.mContentHeight += getItemHeight(i);
            this.mContentHeight += getItemMaigin(1, i);
            j = this.mContentHeight;
            k = 3;
          }
          this.mContentHeight = (j + getItemMaigin(k, i));
          i += 1;
        }
      }
    }
    if (this.mParentRecyclerView.mLayout.canScrollHorizontally()) {
      i = getCustomFooterViewWidth();
    } else {
      i = getCustomFooterViewHeight();
    }
    return this.mContentHeight - i;
  }
  
  public String getViewHolderReUseKey(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= getItemCount())) {
      return String.valueOf(paramInt);
    }
    return null;
  }
  
  public boolean hasCustomRecycler()
  {
    return true;
  }
  
  public boolean isAutoCalculateItemHeight()
  {
    return true;
  }
  
  public boolean isSuspentedItem(int paramInt)
  {
    RenderNode localRenderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
    if ((localRenderNode != null) && (localRenderNode.getChildCount() > paramInt))
    {
      localRenderNode = localRenderNode.getChildAt(paramInt);
      if ((localRenderNode instanceof ListItemRenderNode)) {
        return ((ListItemRenderNode)localRenderNode).shouldSticky();
      }
    }
    return super.isSuspentedItem(paramInt);
  }
  
  public void notifyEndReached()
  {
    getOnEndReachedEvent().send(this.mParentRecyclerView, null);
  }
  
  public void onBindContentView(ContentHolder paramContentHolder, int paramInt1, int paramInt2)
  {
    NodeHolder localNodeHolder = (NodeHolder)paramContentHolder;
    if (localNodeHolder.isCreated)
    {
      localNodeHolder.mBindNode.updateViewRecursive();
      localNodeHolder.isCreated = false;
    }
    else
    {
      localNodeHolder.mBindNode.setLazy(true);
      paramContentHolder = null;
      try
      {
        RenderNode localRenderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(paramInt1);
        paramContentHolder = localRenderNode;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onBindContentView: ");
        localStringBuilder.append(localThrowable.getMessage());
        LogUtils.d("HippyListAdapter", localStringBuilder.toString());
      }
      if (paramContentHolder == null) {
        return;
      }
      paramContentHolder.setLazy(false);
      ArrayList localArrayList = DiffUtils.diff(localNodeHolder.mBindNode, paramContentHolder);
      DiffUtils.deleteViews(this.mHippyContext.getRenderManager().getControllerManager(), localArrayList);
      DiffUtils.replaceIds(this.mHippyContext.getRenderManager().getControllerManager(), localArrayList);
      DiffUtils.createView(localArrayList);
      DiffUtils.doPatch(this.mHippyContext.getRenderManager().getControllerManager(), localArrayList);
      localNodeHolder.mBindNode = paramContentHolder;
    }
    if ((localNodeHolder.mBindNode instanceof ListItemRenderNode)) {
      ((ListItemRenderNode)localNodeHolder.mBindNode).a(this);
    }
  }
  
  public ContentHolder onCreateContentViewWithPos(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    paramViewGroup = new NodeHolder();
    RenderNode localRenderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(paramInt1);
    localRenderNode.setLazy(false);
    View localView = localRenderNode.createViewRecursive();
    paramViewGroup.mContentView = localView;
    if ((localView instanceof HippyPullHeaderView)) {
      ((HippyPullHeaderView)localView).setParentView(this.mParentRecyclerView);
    }
    if ((localView instanceof HippyPullFooterView)) {
      ((HippyPullFooterView)localView).setParentView(this.mParentRecyclerView);
    }
    paramViewGroup.mBindNode = localRenderNode;
    paramViewGroup.isCreated = true;
    return paramViewGroup;
  }
  
  public RecyclerView.ViewHolderWrapper onCreateSuspendViewHolderWithPos(RecyclerViewBase paramRecyclerViewBase, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public void onPreload()
  {
    getOnEndReachedEvent().send(this.mParentRecyclerView, null);
  }
  
  public void onRecycleItemTypeChanged(int paramInt1, int paramInt2, ListItemRenderNode paramListItemRenderNode)
  {
    checkHolderType(paramInt1, paramInt2, paramListItemRenderNode);
  }
  
  protected void onViewAbandon(RecyclerView.ViewHolderWrapper paramViewHolderWrapper)
  {
    NodeHolder localNodeHolder = (NodeHolder)paramViewHolderWrapper.mContentHolder;
    if ((localNodeHolder.mBindNode != null) && (!localNodeHolder.mBindNode.isDelete()))
    {
      localNodeHolder.mBindNode.setLazy(true);
      RenderNode localRenderNode = localNodeHolder.mBindNode.getParent();
      if (localRenderNode != null) {
        this.mHippyContext.getRenderManager().getControllerManager().deleteChild(localRenderNode.getId(), localNodeHolder.mBindNode.getId());
      }
    }
    if ((localNodeHolder.mBindNode instanceof ListItemRenderNode)) {
      ((ListItemRenderNode)localNodeHolder.mBindNode).a(null);
    }
    super.onViewAbandon(paramViewHolderWrapper);
  }
  
  protected void setPreloadItemNumber(int paramInt)
  {
    this.mPreloadItemNum = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.list.HippyListAdapter
 * JD-Core Version:    0.7.0.1
 */