package com.tencent.mobileqq.mini.entry.desktop;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import aolr;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppGroupInfo;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.DragDeleteListener;

public class MiniAppDesktopAdapter$DesktopModuleListViewHolder
  extends RecyclerView.ViewHolder
{
  protected MiniAppDesktopAdapter.DesktopModuleListViewHolder.MiniAppAdapter mAdapter;
  protected DesktopAppGroupInfo mModuleInfo;
  protected DragRecyclerView mRecycleView;
  
  public MiniAppDesktopAdapter$DesktopModuleListViewHolder(MiniAppDesktopAdapter paramMiniAppDesktopAdapter, View paramView, Context paramContext, DragRecyclerView.DragDeleteListener paramDragDeleteListener)
  {
    super(paramView);
    this.mRecycleView = ((DragRecyclerView)paramView.findViewById(2131375022));
    MiniAppDesktopAdapter.access$3000(paramMiniAppDesktopAdapter).addChildDragRecycleView(this.mRecycleView);
    this.mAdapter = new MiniAppDesktopAdapter.DesktopModuleListViewHolder.MiniAppAdapter(this, paramContext, this.mRecycleView);
    this.mAdapter.setParentRecyclerView(MiniAppDesktopAdapter.access$3100(paramMiniAppDesktopAdapter));
    this.mRecycleView.setAdapter(this.mAdapter);
    this.mRecycleView.setDragChangeListener(this.mAdapter);
    this.mRecycleView.setDragDeleteListener(paramDragDeleteListener);
    this.mAdapter.setDragMirrorView(MiniAppDesktopAdapter.access$3200(paramMiniAppDesktopAdapter));
    this.mAdapter.registerAdapterDataObserver(new MiniAppDesktopAdapter.DesktopModuleListViewHolder.1(this, paramMiniAppDesktopAdapter));
    paramView = new aolr(MiniAppDesktopAdapter.access$3300(paramMiniAppDesktopAdapter), 0, false);
    paramView.setAutoMeasureEnabled(true);
    this.mRecycleView.setLayoutManager(paramView);
    this.mRecycleView.addOnScrollListener(new MiniAppDesktopAdapter.DesktopModuleListViewHolder.2(this, paramMiniAppDesktopAdapter));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.DesktopModuleListViewHolder
 * JD-Core Version:    0.7.0.1
 */