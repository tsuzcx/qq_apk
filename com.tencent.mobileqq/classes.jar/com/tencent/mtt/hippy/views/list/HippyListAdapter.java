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
import com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager;
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
import java.util.List;

public class HippyListAdapter
  extends RecyclerAdapter
  implements IRecycleItemTypeChange
{
  private static final String TAG = "HippyListAdapter";
  protected HippyEngineContext mHippyContext;
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
    int j = 0;
    int k = this.mParentRecyclerView.getChildCount();
    int i = 0;
    Object localObject;
    if (i < k)
    {
      localObject = this.mParentRecyclerView.getChildViewHolder(this.mParentRecyclerView.getChildAt(i));
      if ((((RecyclerViewBase.ViewHolder)localObject).getItemViewType() == paramInt1) && ((((RecyclerViewBase.ViewHolder)localObject).mContentHolder instanceof NodeHolder)) && (((NodeHolder)((RecyclerViewBase.ViewHolder)localObject).mContentHolder).mBindNode == paramListItemRenderNode)) {
        ((RecyclerViewBase.ViewHolder)localObject).setItemViewType(paramInt2);
      }
    }
    RecyclerViewBase.ViewHolder localViewHolder;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        do
        {
          do
          {
            i += 1;
            break;
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
          } while (this.mRecycler.getRecycledViewPool() == null);
          localObject = (ArrayList)this.mRecycler.getRecycledViewPool().mScrap.get(paramInt1);
        } while ((localObject == null) || (((ArrayList)localObject).isEmpty()));
        localIterator = ((ArrayList)localObject).iterator();
      }
      localViewHolder = (RecyclerViewBase.ViewHolder)localIterator.next();
    } while ((localViewHolder.getItemViewType() != paramInt1) || (!(localViewHolder.mContentHolder instanceof NodeHolder)) || (((NodeHolder)localViewHolder.mContentHolder).mBindNode != paramListItemRenderNode));
    localViewHolder.setItemViewType(paramInt2);
    ((ArrayList)localObject).remove(localViewHolder);
    this.mRecycler.getRecycledViewPool().getScrapHeapForType(paramInt2).add(localViewHolder);
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
    if ((this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()) == null) || (this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildCount() <= paramInt1)) {
      return null;
    }
    int j = paramRecycler.mAttachedScrap.size();
    int i = 0;
    RecyclerViewBase.ViewHolder localViewHolder;
    while (i < j)
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
    j = paramRecycler.mCachedViews.size();
    i = 0;
    while (i < j)
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
  
  public RecyclerViewBase.ViewHolder findBestHolderForPosition(int paramInt, RecyclerViewBase.Recycler paramRecycler)
  {
    LogUtils.d("HippyListView", "findBestHolderForPosition start : " + paramInt);
    this.mRecycler = paramRecycler;
    paramRecycler = findBestHolderRecursive(paramInt, getItemViewType(paramInt), paramRecycler);
    LogUtils.d("HippyListView", "findBestHolderForPosition end : " + paramInt);
    return paramRecycler;
  }
  
  RecyclerViewBase.ViewHolder findBestHolderRecursive(int paramInt1, int paramInt2, RecyclerViewBase.Recycler paramRecycler)
  {
    RecyclerViewBase.ViewHolder localViewHolder2 = getScrapViewForPositionInner(paramInt1, paramInt2, paramRecycler);
    RecyclerViewBase.ViewHolder localViewHolder1 = localViewHolder2;
    if (localViewHolder2 == null) {
      localViewHolder1 = paramRecycler.getViewHolderForPosition(paramInt1);
    }
    if ((localViewHolder1 != null) && (((NodeHolder)localViewHolder1.mContentHolder).mBindNode.isDelete())) {
      return findBestHolderRecursive(paramInt1, paramInt2, paramRecycler);
    }
    return localViewHolder1;
  }
  
  public RecyclerViewBase.ViewHolder findSuspendHolderForPosition(int paramInt, RecyclerViewBase.Recycler paramRecycler)
  {
    this.mRecycler = paramRecycler;
    paramRecycler = getScrapViewForPositionInner(paramInt, getItemViewType(paramInt), paramRecycler);
    if ((paramRecycler != null) && (((NodeHolder)paramRecycler.mContentHolder).mBindNode.isDelete())) {
      return null;
    }
    return paramRecycler;
  }
  
  public int getCustomFooterViewHeight()
  {
    RenderNode localRenderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
    if ((localRenderNode != null) && (localRenderNode.getChildCount() > 0))
    {
      localRenderNode = localRenderNode.getChildAt(localRenderNode.getChildCount() - 1);
      if ((localRenderNode != null) && ((localRenderNode instanceof h))) {
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
      if ((localRenderNode != null) && ((localRenderNode instanceof h))) {
        return localRenderNode.getWidth();
      }
    }
    return 0;
  }
  
  public int getCustomHeaderViewHeight()
  {
    int j = 0;
    RenderNode localRenderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
    int i = j;
    if (localRenderNode != null)
    {
      i = j;
      if (localRenderNode.getChildCount() > 0)
      {
        localRenderNode = localRenderNode.getChildAt(0);
        i = j;
        if (localRenderNode != null)
        {
          i = j;
          if ((localRenderNode instanceof i)) {
            i = localRenderNode.getHeight();
          }
        }
      }
    }
    return i;
  }
  
  public int getCustomHeaderViewWidth()
  {
    int j = 0;
    RenderNode localRenderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
    int i = j;
    if (localRenderNode != null)
    {
      i = j;
      if (localRenderNode.getChildCount() > 0)
      {
        localRenderNode = localRenderNode.getChildAt(0);
        i = j;
        if (localRenderNode != null)
        {
          i = j;
          if ((localRenderNode instanceof i)) {
            i = localRenderNode.getWidth();
          }
        }
      }
    }
    return i;
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
          if (((HippyMap)localObject).get("itemViewType") != null) {
            return ((HippyMap)localObject).getInt("itemViewType");
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
    if (this.mContentHeight == -1)
    {
      int j = getItemCount();
      this.mContentHeight = 0;
      if (this.mParentRecyclerView.mLayoutType == 1)
      {
        i = 0;
        if (i < j)
        {
          if (this.mParentRecyclerView.mLayout.canScrollHorizontally())
          {
            this.mContentHeight += getItemWidth(i);
            this.mContentHeight += getItemMaigin(0, i);
          }
          for (this.mContentHeight += getItemMaigin(2, i);; this.mContentHeight += getItemMaigin(3, i))
          {
            i += 1;
            break;
            this.mContentHeight += getItemHeight(i);
            this.mContentHeight += getItemMaigin(1, i);
          }
        }
      }
    }
    if (this.mParentRecyclerView.mLayout.canScrollHorizontally()) {}
    for (int i = getCustomFooterViewWidth();; i = getCustomFooterViewHeight()) {
      return this.mContentHeight - i;
    }
  }
  
  public String getViewHolderReUseKey(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > getItemCount())) {
      return null;
    }
    return String.valueOf(paramInt);
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
    for (;;)
    {
      if ((localNodeHolder.mBindNode instanceof ListItemRenderNode)) {
        ((ListItemRenderNode)localNodeHolder.mBindNode).a(this);
      }
      label91:
      do
      {
        return;
        localNodeHolder.mBindNode.setLazy(true);
        paramContentHolder = null;
        try
        {
          localObject = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(paramInt1);
          paramContentHolder = (ContentHolder)localObject;
        }
        catch (Throwable localThrowable)
        {
          Object localObject;
          break label91;
        }
      } while (paramContentHolder == null);
      paramContentHolder.setLazy(false);
      localObject = DiffUtils.diff(localNodeHolder.mBindNode, paramContentHolder);
      DiffUtils.deleteViews(this.mHippyContext.getRenderManager().getControllerManager(), (List)localObject);
      DiffUtils.replaceIds(this.mHippyContext.getRenderManager().getControllerManager(), (List)localObject);
      DiffUtils.createView(this.mHippyContext.getRenderManager().getControllerManager(), (List)localObject);
      DiffUtils.doPatch(this.mHippyContext.getRenderManager().getControllerManager(), (List)localObject);
      localNodeHolder.mBindNode = paramContentHolder;
    }
  }
  
  public ContentHolder onCreateContentViewWithPos(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    paramViewGroup = new NodeHolder();
    RenderNode localRenderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(paramInt1);
    localRenderNode.setLazy(false);
    View localView = localRenderNode.createViewRecursive();
    paramViewGroup.mContentView = localView;
    if ((localView != null) && ((localView instanceof HippyPullHeaderView))) {
      ((HippyPullHeaderView)localView).setParentView(this.mParentRecyclerView);
    }
    if ((localView != null) && ((localView instanceof HippyPullFooterView))) {
      ((HippyPullFooterView)localView).setParentView(this.mParentRecyclerView);
    }
    paramViewGroup.mBindNode = localRenderNode;
    paramViewGroup.isCreated = true;
    return paramViewGroup;
  }
  
  public RecyclerView.ViewHolderWrapper onCreateSuspendViewHolderWithPos(RecyclerViewBase paramRecyclerViewBase, int paramInt1, int paramInt2)
  {
    int i = this.mParentRecyclerView.getChildCount();
    paramRecyclerViewBase = ((BaseLayoutManager)this.mParentRecyclerView.getLayoutManager()).getCurrentSuspentionView();
    if (paramRecyclerViewBase == null) {
      return null;
    }
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      RecyclerViewBase.ViewHolder localViewHolder = this.mParentRecyclerView.getChildViewHolder(paramRecyclerViewBase);
      if ((localViewHolder != null) && ((localViewHolder.mContentHolder instanceof NodeHolder)) && (((NodeHolder)localViewHolder.mContentHolder).mBindNode == this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(paramInt1)) && ((localViewHolder instanceof RecyclerView.ViewHolderWrapper))) {
        return (RecyclerView.ViewHolderWrapper)localViewHolder;
      }
      paramInt2 += 1;
    }
    return null;
  }
  
  public void onRecycleItemTypeChanged(int paramInt1, int paramInt2, ListItemRenderNode paramListItemRenderNode)
  {
    checkHolderType(paramInt1, paramInt2, paramListItemRenderNode);
  }
  
  public void onViewAbandon(RecyclerView.ViewHolderWrapper paramViewHolderWrapper)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.list.HippyListAdapter
 * JD-Core Version:    0.7.0.1
 */