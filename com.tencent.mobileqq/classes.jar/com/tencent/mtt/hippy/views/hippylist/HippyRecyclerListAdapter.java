package com.tencent.mtt.hippy.views.hippylist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.HippyItemTypeHelper;
import androidx.recyclerview.widget.IItemLayoutParams;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.tencent.mtt.a.a.a.c.c;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.DiffUtils;
import com.tencent.mtt.hippy.uimanager.ListItemRenderNode;
import com.tencent.mtt.hippy.uimanager.RenderManager;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.uimanager.i;
import com.tencent.mtt.hippy.views.list.IRecycleItemTypeChange;
import com.tencent.mtt.hippy.views.refresh.HippyPullHeaderView;
import java.util.List;

public class HippyRecyclerListAdapter<HRCV extends HippyRecyclerView>
  extends RecyclerView.Adapter<HippyRecyclerViewHolder>
  implements IItemLayoutParams, c, IRecycleItemTypeChange
{
  protected PullFooterEventHelper footerEventHelper;
  protected PullHeaderEventHelper headerEventHelper;
  protected final HippyItemTypeHelper hippyItemTypeHelper;
  protected final HRCV hippyRecyclerView;
  protected final HippyEngineContext hpContext;
  protected int positionToCreateHolder;
  protected PreloadHelper preloadHelper;
  
  public HippyRecyclerListAdapter(HRCV paramHRCV, HippyEngineContext paramHippyEngineContext)
  {
    this.hpContext = paramHippyEngineContext;
    this.hippyRecyclerView = paramHRCV;
    this.hippyItemTypeHelper = new HippyItemTypeHelper(paramHRCV);
    this.preloadHelper = new PreloadHelper(paramHRCV);
  }
  
  private void enablePullFooter(int paramInt, View paramView)
  {
    if (paramInt == getItemCount() - 1)
    {
      if (getChildNodeByAdapterPosition(paramInt).b())
      {
        if (this.footerEventHelper == null) {
          this.footerEventHelper = new PullFooterEventHelper(this.hippyRecyclerView);
        }
        this.footerEventHelper.enableFooter(paramView);
        return;
      }
      paramView = this.footerEventHelper;
      if (paramView != null) {
        paramView.disableFooter();
      }
    }
  }
  
  private int getHippyListViewId()
  {
    return ((View)this.hippyRecyclerView.getParent()).getId();
  }
  
  private FrameLayout getStickyContainer(ViewGroup paramViewGroup, View paramView)
  {
    paramViewGroup = new FrameLayout(paramViewGroup.getContext());
    if (paramView != null) {
      paramViewGroup.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    }
    return paramViewGroup;
  }
  
  private void initPullHeadEventHelper(i parami, View paramView)
  {
    if (this.headerEventHelper == null) {
      this.headerEventHelper = new PullHeaderEventHelper(this.hippyRecyclerView, parami);
    }
    this.headerEventHelper.setRenderNodeView(paramView);
  }
  
  private boolean isPullHeader(int paramInt)
  {
    if (paramInt == 0) {
      return getChildNodeByAdapterPosition(0).c();
    }
    return false;
  }
  
  protected View createRenderView(ListItemRenderNode paramListItemRenderNode)
  {
    if ((paramListItemRenderNode.d()) && (!paramListItemRenderNode.shouldSticky())) {
      deleteExistRenderView(paramListItemRenderNode);
    }
    paramListItemRenderNode.setLazy(false);
    View localView = paramListItemRenderNode.createViewRecursive();
    paramListItemRenderNode.updateViewRecursive();
    return localView;
  }
  
  public void deleteExistRenderView(ListItemRenderNode paramListItemRenderNode)
  {
    paramListItemRenderNode.setLazy(true);
    RenderNode localRenderNode = getParentNode();
    if (localRenderNode != null) {
      this.hpContext.getRenderManager().getControllerManager().deleteChild(localRenderNode.getId(), paramListItemRenderNode.getId());
    }
    paramListItemRenderNode.a(null);
  }
  
  String getAttachedIds()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int j = this.hippyRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.hippyRecyclerView.getChildAt(i);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("|p_");
      localStringBuilder2.append(this.hippyRecyclerView.getChildAdapterPosition(localView));
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("_i_");
      localStringBuilder2.append(localView.getId());
      localStringBuilder1.append(localStringBuilder2.toString());
      i += 1;
    }
    return localStringBuilder1.toString();
  }
  
  public ListItemRenderNode getChildNode(int paramInt)
  {
    RenderNode localRenderNode = getParentNode();
    if ((localRenderNode != null) && (paramInt < localRenderNode.getChildCount()) && (paramInt >= 0)) {
      return (ListItemRenderNode)localRenderNode.getChildAt(paramInt);
    }
    return null;
  }
  
  public ListItemRenderNode getChildNodeByAdapterPosition(int paramInt)
  {
    return getChildNode(this.hippyRecyclerView.getNodePositionHelper().getRenderNodePosition(paramInt));
  }
  
  public PullHeaderEventHelper getHeaderEventHelper()
  {
    return this.headerEventHelper;
  }
  
  public int getItemCount()
  {
    return getRenderNodeCount();
  }
  
  public int getItemHeight(int paramInt)
  {
    return getRenderNodeHeight(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return getChildNodeByAdapterPosition(paramInt).getId();
  }
  
  public void getItemLayoutParams(int paramInt, RecyclerView.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams == null) {
      return;
    }
    paramLayoutParams.height = getRenderNodeHeight(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    setPositionToCreate(paramInt);
    return getChildNodeByAdapterPosition(paramInt).a();
  }
  
  public int getItemWidth(int paramInt)
  {
    Integer localInteger = Integer.valueOf(getRenderNodeWidth(paramInt));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  protected RecyclerView.LayoutParams getLayoutParams(View paramView)
  {
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof RecyclerView.LayoutParams)) {
      paramView = (RecyclerView.LayoutParams)paramView;
    } else {
      paramView = null;
    }
    Object localObject = paramView;
    if (paramView == null) {
      localObject = new RecyclerView.LayoutParams(-1, 0);
    }
    return localObject;
  }
  
  protected RenderNode getParentNode()
  {
    return this.hpContext.getRenderManager().getRenderNode(getHippyListViewId());
  }
  
  public PreloadHelper getPreloadHelper()
  {
    return this.preloadHelper;
  }
  
  public int getRenderNodeCount()
  {
    RenderNode localRenderNode = getParentNode();
    if (localRenderNode != null) {
      return localRenderNode.getChildCount();
    }
    return 0;
  }
  
  public int getRenderNodeHeight(int paramInt)
  {
    ListItemRenderNode localListItemRenderNode = getChildNode(paramInt);
    if (localListItemRenderNode != null)
    {
      if (localListItemRenderNode.c()) {
        return 0;
      }
      return localListItemRenderNode.getHeight();
    }
    return 0;
  }
  
  public int getRenderNodeTotalHeight()
  {
    int k = getRenderNodeCount();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += getRenderNodeHeight(i);
      i += 1;
    }
    return j;
  }
  
  public int getRenderNodeWidth(int paramInt)
  {
    ListItemRenderNode localListItemRenderNode = getChildNode(paramInt);
    if (localListItemRenderNode != null) {
      return localListItemRenderNode.getWidth();
    }
    return 0;
  }
  
  public boolean isStickyPosition(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount())) {
      return getChildNodeByAdapterPosition(paramInt).shouldSticky();
    }
    return false;
  }
  
  public void onBindViewHolder(HippyRecyclerViewHolder paramHippyRecyclerViewHolder, int paramInt)
  {
    setLayoutParams(paramHippyRecyclerViewHolder.itemView, paramInt);
    Object localObject = paramHippyRecyclerViewHolder.bindNode;
    ListItemRenderNode localListItemRenderNode = getChildNodeByAdapterPosition(paramInt);
    ((RenderNode)localObject).setLazy(true);
    localListItemRenderNode.setLazy(false);
    if (localObject != localListItemRenderNode)
    {
      localObject = DiffUtils.diff((RenderNode)localObject, localListItemRenderNode);
      DiffUtils.deleteViews(this.hpContext.getRenderManager().getControllerManager(), (List)localObject);
      DiffUtils.replaceIds(this.hpContext.getRenderManager().getControllerManager(), (List)localObject);
      DiffUtils.createView((List)localObject);
      DiffUtils.doPatch(this.hpContext.getRenderManager().getControllerManager(), (List)localObject);
    }
    localListItemRenderNode.a(this);
    paramHippyRecyclerViewHolder.bindNode = localListItemRenderNode;
    enablePullFooter(paramInt, paramHippyRecyclerViewHolder.itemView);
  }
  
  @NonNull
  public HippyRecyclerViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    ListItemRenderNode localListItemRenderNode = getChildNodeByAdapterPosition(this.positionToCreateHolder);
    boolean bool1 = localListItemRenderNode.e();
    boolean bool2 = localListItemRenderNode.d();
    View localView = createRenderView(localListItemRenderNode);
    if (isPullHeader(this.positionToCreateHolder))
    {
      ((HippyPullHeaderView)localView).setParentView(this.hippyRecyclerView);
      initPullHeadEventHelper((i)localListItemRenderNode, localView);
      return new HippyRecyclerViewHolder(this.headerEventHelper.getView(), localListItemRenderNode);
    }
    if (isStickyPosition(this.positionToCreateHolder)) {
      return new HippyRecyclerViewHolder(getStickyContainer(paramViewGroup, localView), localListItemRenderNode);
    }
    if (localView == null)
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("createRenderView error!,isDelete:");
      paramViewGroup.append(localListItemRenderNode.isDelete());
      paramViewGroup.append(",isViewExist:");
      paramViewGroup.append(bool1);
      paramViewGroup.append(",needsDelete:");
      paramViewGroup.append(bool2);
      paramViewGroup.append(",className:");
      paramViewGroup.append(localListItemRenderNode.getClassName());
      paramViewGroup.append(",isLazy :");
      paramViewGroup.append(localListItemRenderNode.isIsLazyLoad());
      paramViewGroup.append(",itemCount :");
      paramViewGroup.append(getItemCount());
      paramViewGroup.append(",getNodeCount:");
      paramViewGroup.append(getRenderNodeCount());
      paramViewGroup.append(",notifyCount:");
      paramViewGroup.append(this.hippyRecyclerView.renderNodeCount);
      paramViewGroup.append("curPos:");
      paramViewGroup.append(this.positionToCreateHolder);
      paramViewGroup.append(",rootView:");
      paramViewGroup.append(localListItemRenderNode.f());
      paramViewGroup.append(",parentNode:");
      if (localListItemRenderNode.getParent() != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramViewGroup.append(bool1);
      paramViewGroup.append(",offset:");
      paramViewGroup.append(this.hippyRecyclerView.computeVerticalScrollOffset());
      paramViewGroup.append(",range:");
      paramViewGroup.append(this.hippyRecyclerView.computeVerticalScrollRange());
      paramViewGroup.append(",extent:");
      paramViewGroup.append(this.hippyRecyclerView.computeVerticalScrollExtent());
      paramViewGroup.append(",viewType:");
      paramViewGroup.append(paramInt);
      paramViewGroup.append(",id:");
      paramViewGroup.append(localListItemRenderNode.getId());
      paramViewGroup.append(",attachedIds:");
      paramViewGroup.append(getAttachedIds());
      paramViewGroup.append(",nodeOffset:");
      paramViewGroup.append(this.hippyRecyclerView.getNodePositionHelper().getNodeOffset());
      paramViewGroup.append(",view:");
      paramViewGroup.append(this.hippyRecyclerView);
      throw new IllegalArgumentException(paramViewGroup.toString());
    }
    return new HippyRecyclerViewHolder(localView, localListItemRenderNode);
  }
  
  public void onRecycleItemTypeChanged(int paramInt1, int paramInt2, ListItemRenderNode paramListItemRenderNode)
  {
    this.hippyItemTypeHelper.updateItemType(paramInt1, paramInt2, paramListItemRenderNode);
  }
  
  protected void setLayoutParams(View paramView, int paramInt)
  {
    RecyclerView.LayoutParams localLayoutParams = getLayoutParams(paramView);
    ListItemRenderNode localListItemRenderNode = getChildNodeByAdapterPosition(paramInt);
    localLayoutParams.height = getRenderNodeHeight(paramInt);
    localLayoutParams.width = localListItemRenderNode.getWidth();
    paramView.setLayoutParams(localLayoutParams);
  }
  
  protected void setPositionToCreate(int paramInt)
  {
    this.positionToCreateHolder = paramInt;
  }
  
  public void setPreloadItemNumber(int paramInt)
  {
    this.preloadHelper.setPreloadItemNumber(paramInt);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HippyRecyclerAdapter: itemCount:");
    localStringBuilder.append(getItemCount());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.hippylist.HippyRecyclerListAdapter
 * JD-Core Version:    0.7.0.1
 */