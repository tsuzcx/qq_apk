package com.tencent.mobileqq.mini.entry.desktop;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class MiniAppDesktopAdapter$DesktopModuleListViewHolder$MiniAppAdapter
  extends DragAdapter
{
  private DragAdapter mMoveTargetAdapter;
  public List<DesktopAppInfo> origList;
  
  public MiniAppDesktopAdapter$DesktopModuleListViewHolder$MiniAppAdapter(MiniAppDesktopAdapter.DesktopModuleListViewHolder paramDesktopModuleListViewHolder, Context paramContext, DragRecyclerView paramDragRecyclerView)
  {
    super(paramContext, paramDragRecyclerView);
  }
  
  protected void doDragMove(int paramInt1, int paramInt2)
  {
    super.doDragMove(paramInt1, paramInt2 - this.mRecyclerView.getTop());
  }
  
  protected int getDragParentLeft(RecyclerView.ViewHolder paramViewHolder)
  {
    return ((View)paramViewHolder.itemView.getParent()).getLeft() + ((View)paramViewHolder.itemView.getParent().getParent()).getLeft();
  }
  
  protected int getDragParentTop(RecyclerView.ViewHolder paramViewHolder)
  {
    return ((View)paramViewHolder.itemView.getParent()).getTop() + ((View)paramViewHolder.itemView.getParent().getParent()).getTop();
  }
  
  public int getItemCount()
  {
    return this.mData.size();
  }
  
  public boolean isItemDeleteable(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mData.size())) {
      return ((DesktopItemInfo)this.mData.get(paramInt)).deleteEnable;
    }
    return false;
  }
  
  public boolean isItemDragable(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mData.size())) {
      return ((DesktopItemInfo)this.mData.get(paramInt)).dragEnable;
    }
    return false;
  }
  
  public boolean isItemDropable(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mData.size())) {
      return ((DesktopItemInfo)this.mData.get(paramInt)).dropEnable;
    }
    return false;
  }
  
  public boolean isMoveToDeleteArea(int paramInt1, int paramInt2)
  {
    return paramInt2 + this.this$1.mRecycleView.getTop() >= MiniAppDesktopAdapter.access$3700(this.this$1.this$0).getBottom() - ViewUtils.a(125.0F);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    updateHolder((MiniAppDesktopAdapter.MicroAppViewHolder)paramViewHolder, (DesktopAppInfo)this.mData.get(paramInt), paramInt);
  }
  
  public MiniAppDesktopAdapter.MicroAppViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new MiniAppDesktopAdapter.MicroAppViewHolder(LayoutInflater.from(MiniAppDesktopAdapter.access$3500(this.this$1.this$0)).inflate(2131562378, paramViewGroup, false));
  }
  
  public void onDragFinish(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    boolean bool;
    if ((!isDragCancel()) && (this.mDeleteTarget < 0)) {
      bool = false;
    } else {
      bool = true;
    }
    this.this$1.this$0.setOutsideDragCancel(bool);
    this.this$1.this$0.onDragFinish(paramViewHolder, paramInt);
    DragAdapter localDragAdapter = this.mMoveTargetAdapter;
    if (localDragAdapter != null)
    {
      localDragAdapter.setOutsideDragCancel(bool);
      this.mMoveTargetAdapter.onDragFinish(paramViewHolder, paramInt);
      this.mMoveTargetAdapter = null;
    }
    super.onDragFinish(paramViewHolder, paramInt);
  }
  
  public void onDragMove(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0) {}
    try
    {
      if (paramInt2 <= this.mRecyclerView.getBottom() - this.mRecyclerView.getTop())
      {
        if (this.mMoveTargetAdapter != null) {
          this.mMoveTargetAdapter.setOutsideDragCancel(true);
        }
        this.this$1.this$0.setDragAppInfo(-1, -1, -1, -1, 0, null);
        super.onDragMove(paramInt1, paramInt2);
        return;
      }
      this.mRecyclerView.stopAutoScroll();
      int i;
      if (paramInt1 > 0) {
        i = paramInt1;
      } else {
        i = ViewUtils.a(30.0F) + paramInt1;
      }
      Object localObject2 = MiniAppDesktopAdapter.access$3800(this.this$1.this$0).findChildViewUnder(i, this.this$1.mRecycleView.getTop() + paramInt2);
      DesktopAppInfo localDesktopAppInfo = null;
      Object localObject1 = localDesktopAppInfo;
      if (localObject2 != null)
      {
        localObject1 = localDesktopAppInfo;
        if ((localObject2 instanceof DragRecyclerView))
        {
          localObject2 = MiniAppDesktopAdapter.access$3900(this.this$1.this$0).getChildViewHolder((View)localObject2);
          localObject1 = localDesktopAppInfo;
          if ((localObject2 instanceof MiniAppDesktopAdapter.DesktopModuleListViewHolder)) {
            localObject1 = ((MiniAppDesktopAdapter.DesktopModuleListViewHolder)localObject2).mAdapter;
          }
        }
      }
      if ((localObject1 != null) && (((MiniAppAdapter)localObject1).isDropable()))
      {
        if (this.mMoveTargetAdapter != null) {
          this.mMoveTargetAdapter.setDragAppInfo(-1, -1, -1, -1, 0, null);
        }
        this.mMoveTargetAdapter = ((DragAdapter)localObject1);
        this.mMoveTargetAdapter.setOutsideDragCancel(false);
        localDesktopAppInfo = (DesktopAppInfo)this.mData.get(this.mDragIndex);
        i = ((MiniAppAdapter)localObject1).mRecyclerView.getTop();
        int j = this.mRecyclerView.getTop();
        ((MiniAppAdapter)localObject1).setDragAppInfo(this.startDragX, this.startDragY, this.moveStartX, this.moveStartY, i - j, localDesktopAppInfo);
        ((MiniAppAdapter)localObject1).onDragMove(paramInt1, paramInt2 + this.mRecyclerView.getTop() - ((MiniAppAdapter)localObject1).mRecyclerView.getTop());
        return;
      }
      localObject1 = (DesktopAppInfo)this.mData.get(this.mDragIndex);
      this.this$1.this$0.setDragAppInfo(this.startDragX, this.startDragY, this.moveStartX, this.moveStartY, 0, (DesktopAppInfo)localObject1);
      this.this$1.this$0.onDragMove(paramInt1, paramInt2);
      if (this.mMoveTargetAdapter != null)
      {
        this.mMoveTargetAdapter.setOutsideDragCancel(true);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppDesktopAdapter", 1, "onDragMove exception!", localThrowable);
    }
  }
  
  public void onItemDelete(int paramInt)
  {
    this.this$1.this$0.setOutsideDragCancel(true);
    Object localObject = this.mMoveTargetAdapter;
    if (localObject != null) {
      ((DragAdapter)localObject).setOutsideDragCancel(true);
    }
    localObject = (DesktopAppInfo)this.mData.get(paramInt);
    this.mDeleteTarget = paramInt;
    super.onItemDelete(paramInt);
    ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).onItemDeleted((DesktopAppInfo)localObject);
  }
  
  public void setData(List<DesktopAppInfo> paramList)
  {
    if (paramList != null)
    {
      this.mData.clear();
      this.mData.addAll(paramList);
      this.origList = paramList;
      notifyDataSetChanged();
    }
  }
  
  protected void updateHolder(MiniAppDesktopAdapter.MicroAppViewHolder paramMicroAppViewHolder, DesktopAppInfo paramDesktopAppInfo, int paramInt)
  {
    this.this$1.this$0.doUpdateHolder(paramMicroAppViewHolder, paramDesktopAppInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.DesktopModuleListViewHolder.MiniAppAdapter
 * JD-Core Version:    0.7.0.1
 */