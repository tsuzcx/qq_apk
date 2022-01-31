package com.tencent.mobileqq.mini.entry.desktop;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import bbkx;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class MiniAppDesktopAdapter$DesktopModuleListViewHolder$MiniAppAdapter
  extends DragAdapter
{
  private DragAdapter mMoveTargetAdapter;
  
  public MiniAppDesktopAdapter$DesktopModuleListViewHolder$MiniAppAdapter(MiniAppDesktopAdapter.DesktopModuleListViewHolder paramDesktopModuleListViewHolder, Context paramContext, DragRecyclerView paramDragRecyclerView)
  {
    super(paramContext, paramDragRecyclerView);
  }
  
  public void doDragMove(int paramInt1, int paramInt2)
  {
    super.doDragMove(paramInt1, paramInt2 - this.mRecyclerView.getTop());
  }
  
  public int getDragParentLeft(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = ((View)paramViewHolder.itemView.getParent()).getLeft();
    return ((View)paramViewHolder.itemView.getParent().getParent()).getLeft() + i;
  }
  
  public int getDragParentTop(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = ((View)paramViewHolder.itemView.getParent()).getTop();
    return ((View)paramViewHolder.itemView.getParent().getParent()).getTop() + i;
  }
  
  public int getItemCount()
  {
    return this.mData.size();
  }
  
  public boolean isItemDeleteable(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mData.size())) {
      return false;
    }
    return ((DesktopItemInfo)this.mData.get(paramInt)).deleteEnable;
  }
  
  public boolean isItemDragable(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mData.size())) {
      return false;
    }
    return ((DesktopItemInfo)this.mData.get(paramInt)).dragEnable;
  }
  
  public boolean isItemDropable(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mData.size())) {
      return false;
    }
    return ((DesktopItemInfo)this.mData.get(paramInt)).dropEnable;
  }
  
  public boolean isMoveToDeleteArea(int paramInt1, int paramInt2)
  {
    return this.this$1.mRecycleView.getTop() + paramInt2 >= MiniAppDesktopAdapter.access$3500(this.this$1.this$0).getBottom() - bbkx.a(60.0F);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    updateHolder((MiniAppDesktopAdapter.MicroAppViewHolder)paramViewHolder, (DesktopAppInfo)this.mData.get(paramInt), paramInt);
  }
  
  public MiniAppDesktopAdapter.MicroAppViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new MiniAppDesktopAdapter.MicroAppViewHolder(LayoutInflater.from(MiniAppDesktopAdapter.access$3300(this.this$1.this$0)).inflate(2131561975, paramViewGroup, false));
  }
  
  public void onDragFinish(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((isDragCancel()) || (this.mDeleteTarget >= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.this$1.this$0.setOutsideDragCancel(bool);
      this.this$1.this$0.onDragFinish(paramViewHolder, paramInt);
      if (this.mMoveTargetAdapter != null)
      {
        this.mMoveTargetAdapter.setOutsideDragCancel(bool);
        this.mMoveTargetAdapter.onDragFinish(paramViewHolder, paramInt);
        this.mMoveTargetAdapter = null;
      }
      super.onDragFinish(paramViewHolder, paramInt);
      return;
    }
  }
  
  public void onDragMove(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0) {}
    for (;;)
    {
      try
      {
        if (paramInt2 > this.mRecyclerView.getBottom() - this.mRecyclerView.getTop())
        {
          this.mRecyclerView.stopAutoScroll();
          int i;
          if (paramInt1 > 0)
          {
            i = paramInt1;
            localObject1 = MiniAppDesktopAdapter.access$3600(this.this$1.this$0).findChildViewUnder(i, this.this$1.mRecycleView.getTop() + paramInt2);
            if ((localObject1 == null) || (!(localObject1 instanceof DragRecyclerView))) {
              break label386;
            }
            localObject1 = MiniAppDesktopAdapter.access$3700(this.this$1.this$0).getChildViewHolder((View)localObject1);
            if (!(localObject1 instanceof MiniAppDesktopAdapter.DesktopModuleListViewHolder)) {
              break label386;
            }
            localObject1 = ((MiniAppDesktopAdapter.DesktopModuleListViewHolder)localObject1).mAdapter;
            if ((localObject1 != null) && (((MiniAppAdapter)localObject1).isDropable()))
            {
              if (this.mMoveTargetAdapter != null) {
                this.mMoveTargetAdapter.setDragAppInfo(-1, -1, -1, -1, 0, null);
              }
              this.mMoveTargetAdapter = ((DragAdapter)localObject1);
              this.mMoveTargetAdapter.setOutsideDragCancel(false);
              DesktopAppInfo localDesktopAppInfo = (DesktopAppInfo)this.mData.get(this.mDragIndex);
              i = ((MiniAppAdapter)localObject1).mRecyclerView.getTop();
              int j = this.mRecyclerView.getTop();
              ((MiniAppAdapter)localObject1).setDragAppInfo(this.startDragX, this.startDragY, this.moveStartX, this.moveStartY, i - j, localDesktopAppInfo);
              ((MiniAppAdapter)localObject1).onDragMove(paramInt1, this.mRecyclerView.getTop() + paramInt2 - ((MiniAppAdapter)localObject1).mRecyclerView.getTop());
            }
          }
          else
          {
            i = bbkx.a(30.0F) + paramInt1;
            continue;
          }
          Object localObject1 = (DesktopAppInfo)this.mData.get(this.mDragIndex);
          this.this$1.this$0.setDragAppInfo(this.startDragX, this.startDragY, this.moveStartX, this.moveStartY, 0, (DesktopAppInfo)localObject1);
          this.this$1.this$0.onDragMove(paramInt1, paramInt2);
          if (this.mMoveTargetAdapter == null) {
            break;
          }
          this.mMoveTargetAdapter.setOutsideDragCancel(true);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniAppDesktopAdapter", 1, "onDragMove exception!", localThrowable);
        return;
      }
      if (this.mMoveTargetAdapter != null) {
        this.mMoveTargetAdapter.setOutsideDragCancel(true);
      }
      this.this$1.this$0.setDragAppInfo(-1, -1, -1, -1, 0, null);
      super.onDragMove(paramInt1, paramInt2);
      return;
      label386:
      Object localObject2 = null;
    }
  }
  
  public void onItemDelete(int paramInt)
  {
    this.this$1.this$0.setOutsideDragCancel(true);
    if (this.mMoveTargetAdapter != null) {
      this.mMoveTargetAdapter.setOutsideDragCancel(true);
    }
    DesktopAppInfo localDesktopAppInfo = (DesktopAppInfo)this.mData.get(paramInt);
    this.mDeleteTarget = paramInt;
    super.onItemDelete(paramInt);
    ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(336)).onItemDeleted(localDesktopAppInfo);
  }
  
  public void setData(List<DesktopAppInfo> paramList)
  {
    if (paramList != null)
    {
      this.mData.clear();
      this.mData.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public void updateHolder(MiniAppDesktopAdapter.MicroAppViewHolder paramMicroAppViewHolder, DesktopAppInfo paramDesktopAppInfo, int paramInt)
  {
    this.this$1.this$0.doUpdateHolder(paramMicroAppViewHolder, paramDesktopAppInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.DesktopModuleListViewHolder.MiniAppAdapter
 * JD-Core Version:    0.7.0.1
 */