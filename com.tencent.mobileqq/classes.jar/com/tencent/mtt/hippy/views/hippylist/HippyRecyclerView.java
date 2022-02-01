package com.tencent.mtt.hippy.views.hippylist;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.HippyRecyclerViewBase;
import androidx.recyclerview.widget.IHippyViewAboundListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mtt.a.a.a.c.a;
import com.tencent.mtt.a.a.a.c.b;
import com.tencent.mtt.a.a.a.c.d;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.uimanager.ListItemRenderNode;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;

public class HippyRecyclerView<ADP extends HippyRecyclerListAdapter>
  extends HippyRecyclerViewBase
  implements IHippyViewAboundListener, a
{
  protected b headerHost;
  protected HippyEngineContext hippyEngineContext;
  protected boolean isEnableScroll = true;
  protected RecyclerView.LayoutManager layoutManager;
  protected ADP listAdapter;
  private NodePositionHelper nodePositionHelper;
  protected RecyclerViewEventHelper recyclerViewEventHelper;
  protected int renderNodeCount = 0;
  protected d stickyHeaderHelper;
  
  public HippyRecyclerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HippyRecyclerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HippyRecyclerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean canScrollToContentOffset()
  {
    return this.renderNodeCount == getAdapter().getRenderNodeCount();
  }
  
  private void doSmoothScrollY(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if ((paramInt2 == 0) || (didStructureChange())) {
        return;
      }
      smoothScrollBy(0, paramInt2, null, paramInt1);
    }
    else
    {
      smoothScrollBy(0, paramInt2);
    }
    postDispatchLayout();
  }
  
  private boolean fillContentView(View paramView, RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder != null) && ((paramViewHolder.itemView instanceof ViewGroup)))
    {
      paramViewHolder = (ViewGroup)paramViewHolder.itemView;
      if (paramViewHolder.getChildCount() <= 0) {
        paramViewHolder.addView(paramView);
      }
    }
    return false;
  }
  
  private Rect getViewVisibleRect(View paramView)
  {
    Rect localRect = new Rect();
    if (paramView != null) {
      paramView.getLocalVisibleRect(localRect);
    }
    return localRect;
  }
  
  private RecyclerViewEventHelper intEventHelper()
  {
    if (this.recyclerViewEventHelper == null) {
      this.recyclerViewEventHelper = createEventHelper();
    }
    return this.recyclerViewEventHelper;
  }
  
  private boolean isTheSameRenderNode(HippyRecyclerViewHolder paramHippyRecyclerViewHolder1, HippyRecyclerViewHolder paramHippyRecyclerViewHolder2)
  {
    ListItemRenderNode localListItemRenderNode = paramHippyRecyclerViewHolder2.bindNode;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localListItemRenderNode != null)
    {
      bool1 = bool2;
      if (paramHippyRecyclerViewHolder1.bindNode != null)
      {
        bool1 = bool2;
        if (paramHippyRecyclerViewHolder2.bindNode.getId() == paramHippyRecyclerViewHolder1.bindNode.getId()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void postDispatchLayout()
  {
    post(new HippyRecyclerView.1(this));
  }
  
  protected RecyclerViewEventHelper createEventHelper()
  {
    return new RecyclerViewEventHelper(this);
  }
  
  public ADP getAdapter()
  {
    return this.listAdapter;
  }
  
  public int getContentOffsetX()
  {
    int i = getFirstChildPosition();
    return getTotalWithBefore(i) + (this.listAdapter.getItemWidth(i) - getVisibleWidth(getChildAt(0)));
  }
  
  public int getContentOffsetY()
  {
    return computeVerticalScrollOffset();
  }
  
  public NodePositionHelper getNodePositionHelper()
  {
    if (this.nodePositionHelper == null) {
      this.nodePositionHelper = new NodePositionHelper();
    }
    return this.nodePositionHelper;
  }
  
  public int getNodePositionInAdapter(int paramInt)
  {
    return paramInt;
  }
  
  public RecyclerViewEventHelper getRecyclerViewEventHelper()
  {
    return intEventHelper();
  }
  
  public int getRenderNodeHeightBefore(int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      j += this.listAdapter.getRenderNodeHeight(i);
      i += 1;
    }
    return j;
  }
  
  public int getTotalHeightBefore(int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      j += this.listAdapter.getItemHeight(i);
      i += 1;
    }
    return j;
  }
  
  public int getTotalWithBefore(int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      j += this.listAdapter.getItemWidth(i);
      i += 1;
    }
    return j;
  }
  
  protected int getVisibleHeight(View paramView)
  {
    return getViewVisibleRect(paramView).height();
  }
  
  protected int getVisibleWidth(View paramView)
  {
    return getViewVisibleRect(paramView).width();
  }
  
  public void initRecyclerView()
  {
    setAdapter(new HippyRecyclerListAdapter(this, this.hippyEngineContext));
    intEventHelper();
  }
  
  public void onHeaderDetached(RecyclerView.ViewHolder paramViewHolder, View paramView)
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= getChildCountWithCaches()) {
        break;
      }
      RecyclerView.ViewHolder localViewHolder = getChildViewHolder(getChildAtWithCaches(i));
      if (isTheSameRenderNode((HippyRecyclerViewHolder)paramViewHolder, (HippyRecyclerViewHolder)localViewHolder))
      {
        fillContentView(paramView, localViewHolder);
        j = 1;
        break;
      }
      i += 1;
    }
    if (j == 0) {
      onViewAbound((HippyRecyclerViewHolder)paramViewHolder);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.isEnableScroll) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onViewAbound(HippyRecyclerViewHolder paramHippyRecyclerViewHolder)
  {
    if ((paramHippyRecyclerViewHolder.bindNode != null) && (!paramHippyRecyclerViewHolder.bindNode.isDelete())) {
      getAdapter().deleteExistRenderView(paramHippyRecyclerViewHolder.bindNode);
    }
  }
  
  public void scrollToContentOffset(double paramDouble1, double paramDouble2, boolean paramBoolean, int paramInt)
  {
    if (!canScrollToContentOffset()) {
      return;
    }
    int i = (int)PixelUtil.dp2px(paramDouble2) - getContentOffsetY();
    if (paramBoolean)
    {
      doSmoothScrollY(paramInt, i);
      return;
    }
    scrollBy(0, i);
  }
  
  public void scrollToIndex(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    paramInt1 = getNodePositionInAdapter(paramInt2);
    if (paramBoolean)
    {
      doSmoothScrollY(paramInt3, getTotalHeightBefore(paramInt1) - getContentOffsetY());
      postDispatchLayout();
      return;
    }
    scrollToPositionWithOffset(paramInt1, 0);
    dispatchLayout();
  }
  
  public void scrollToTop()
  {
    if (getLayoutManager().canScrollHorizontally()) {
      smoothScrollBy(-getContentOffsetX(), 0);
    } else {
      smoothScrollBy(0, -getContentOffsetY());
    }
    postDispatchLayout();
  }
  
  public void setAdapter(@Nullable RecyclerView.Adapter paramAdapter)
  {
    this.listAdapter = ((HippyRecyclerListAdapter)paramAdapter);
    super.setAdapter(paramAdapter);
  }
  
  public void setHeaderHost(b paramb)
  {
    this.headerHost = paramb;
  }
  
  public void setHippyEngineContext(HippyEngineContext paramHippyEngineContext)
  {
    this.hippyEngineContext = paramHippyEngineContext;
  }
  
  public void setListData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("itemCount =");
    localStringBuilder.append(this.listAdapter.getItemCount());
    LogUtils.d("HippyRecyclerView", localStringBuilder.toString());
    this.listAdapter.notifyDataSetChanged();
    this.renderNodeCount = getAdapter().getRenderNodeCount();
    dispatchLayout();
  }
  
  public void setNodePositionHelper(NodePositionHelper paramNodePositionHelper)
  {
    this.nodePositionHelper = paramNodePositionHelper;
  }
  
  public void setOrientation(LinearLayoutManager paramLinearLayoutManager)
  {
    this.layoutManager = paramLinearLayoutManager;
  }
  
  public void setRowShouldSticky(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.stickyHeaderHelper == null)
      {
        this.stickyHeaderHelper = new d(this, this.listAdapter, this, this.headerHost);
        addOnScrollListener(this.stickyHeaderHelper);
      }
    }
    else
    {
      d locald = this.stickyHeaderHelper;
      if (locald != null) {
        removeOnScrollListener(locald);
      }
    }
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.isEnableScroll = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("{renderNodeCount:");
    localStringBuilder.append(this.renderNodeCount);
    localStringBuilder.append(",state:");
    localStringBuilder.append(getStateInfo());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView
 * JD-Core Version:    0.7.0.1
 */