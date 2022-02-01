package com.tencent.mobileqq.mini.entry.desktop;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import asvq;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppGroupInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.DragDeleteListener;
import java.util.List;

public class MiniAppDesktopAdapter$DesktopModuleListViewHolder
  extends RecyclerView.ViewHolder
{
  protected MiniAppDesktopAdapter.DesktopModuleListViewHolder.MiniAppAdapter mAdapter;
  protected DesktopAppGroupInfo mModuleInfo;
  protected DragRecyclerView mRecycleView;
  
  public MiniAppDesktopAdapter$DesktopModuleListViewHolder(MiniAppDesktopAdapter paramMiniAppDesktopAdapter, View paramView, Context paramContext, DragRecyclerView.DragDeleteListener paramDragDeleteListener)
  {
    super(paramView);
    this.mRecycleView = ((DragRecyclerView)paramView.findViewById(2131376423));
    MiniAppDesktopAdapter.access$3100(paramMiniAppDesktopAdapter).addChildDragRecycleView(this.mRecycleView);
    this.mAdapter = new MiniAppDesktopAdapter.DesktopModuleListViewHolder.MiniAppAdapter(this, paramContext, this.mRecycleView);
    this.mAdapter.setParentRecyclerView(MiniAppDesktopAdapter.access$3200(paramMiniAppDesktopAdapter));
    this.mRecycleView.setAdapter(this.mAdapter);
    this.mRecycleView.setDragChangeListener(this.mAdapter);
    this.mRecycleView.setDragDeleteListener(paramDragDeleteListener);
    this.mAdapter.setDragMirrorView(MiniAppDesktopAdapter.access$3300(paramMiniAppDesktopAdapter));
    this.mAdapter.registerAdapterDataObserver(new MiniAppDesktopAdapter.DesktopModuleListViewHolder.1(this, paramMiniAppDesktopAdapter));
    paramView = new asvq(MiniAppDesktopAdapter.access$3500(paramMiniAppDesktopAdapter), 0, false);
    paramView.setAutoMeasureEnabled(true);
    this.mRecycleView.setLayoutManager(paramView);
    this.mRecycleView.addOnScrollListener(new MiniAppDesktopAdapter.DesktopModuleListViewHolder.2(this, paramMiniAppDesktopAdapter));
  }
  
  private void updateOrigDataList()
  {
    if ((this.mAdapter == null) || (this.mAdapter.origList == null)) {}
    for (;;)
    {
      return;
      List localList = this.mAdapter.getData();
      this.mAdapter.origList.clear();
      int i = 0;
      while (i < localList.size())
      {
        DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)localList.get(i);
        if ((localDesktopItemInfo instanceof DesktopAppInfo)) {
          this.mAdapter.origList.add((DesktopAppInfo)localDesktopItemInfo);
        }
        i += 1;
      }
    }
  }
  
  public void bindView(DesktopAppGroupInfo paramDesktopAppGroupInfo, int paramInt)
  {
    if (paramDesktopAppGroupInfo == null) {
      return;
    }
    this.mModuleInfo = paramDesktopAppGroupInfo;
    this.mAdapter.setData(paramDesktopAppGroupInfo.datas);
    if (this.mModuleInfo.getModuleType() == 3)
    {
      this.mRecycleView.setAutoScrollEnable(true);
      return;
    }
    this.mRecycleView.setAutoScrollEnable(false);
  }
  
  public void update() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.DesktopModuleListViewHolder
 * JD-Core Version:    0.7.0.1
 */