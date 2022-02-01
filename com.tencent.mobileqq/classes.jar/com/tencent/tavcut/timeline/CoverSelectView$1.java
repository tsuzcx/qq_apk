package com.tencent.tavcut.timeline;

class CoverSelectView$1
  implements Runnable
{
  CoverSelectView$1(CoverSelectView paramCoverSelectView) {}
  
  public void run()
  {
    int i = this.this$0.timelineView.getRecyclerViewPaddingLeft();
    int j = this.this$0.timelineView.getRecyclerViewPaddingRight();
    this.this$0.coverPreviewBar.initCoverSlider(i, j, this.this$0.timelineView.getWidth() - i - j, CoverSelectView.access$300(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.timeline.CoverSelectView.1
 * JD-Core Version:    0.7.0.1
 */