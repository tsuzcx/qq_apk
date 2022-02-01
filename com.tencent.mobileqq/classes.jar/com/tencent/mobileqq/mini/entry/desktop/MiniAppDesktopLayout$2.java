package com.tencent.mobileqq.mini.entry.desktop;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class MiniAppDesktopLayout$2
  extends RecyclerView.OnScrollListener
{
  MiniAppDesktopLayout$2(MiniAppDesktopLayout paramMiniAppDesktopLayout) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      this.this$0.startSwitchIconAnimation();
    }
    while (paramInt != 1) {
      return;
    }
    this.this$0.stopSwitchIconAnimation();
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout.2
 * JD-Core Version:    0.7.0.1
 */