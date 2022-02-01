package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.kandian.biz.comment.helper.RIJPerformanceReporter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener;

class FlingExitLayout$1
  implements RecyclerView.OnListScrollListener
{
  FlingExitLayout$1(FlingExitLayout paramFlingExitLayout) {}
  
  public void onDragEnd() {}
  
  public void onScroll(int paramInt1, int paramInt2) {}
  
  public void onScrollEnd()
  {
    RIJPerformanceReporter.a().a(1);
  }
  
  public void onStartDrag()
  {
    RIJPerformanceReporter.a().a();
  }
  
  public void onStartFling() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.FlingExitLayout.1
 * JD-Core Version:    0.7.0.1
 */