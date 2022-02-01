package com.tencent.mobileqq.mini.entry.desktop;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppGroupInfo;

class MiniAppDesktopAdapter$DesktopModuleListViewHolder$2
  extends RecyclerView.OnScrollListener
{
  MiniAppDesktopAdapter$DesktopModuleListViewHolder$2(MiniAppDesktopAdapter.DesktopModuleListViewHolder paramDesktopModuleListViewHolder, MiniAppDesktopAdapter paramMiniAppDesktopAdapter) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      MiniAppUtils.updateMiniAppList(12);
      if ((this.this$1.mModuleInfo != null) && (this.this$1.mModuleInfo.getModuleType() == 2)) {
        MiniAppDesktopAdapter.access$3500(this.this$1.this$0);
      }
    }
    while (paramInt != 1) {
      return;
    }
    MiniAppUtils.updateMiniAppList(13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.DesktopModuleListViewHolder.2
 * JD-Core Version:    0.7.0.1
 */