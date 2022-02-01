package com.tencent.tavcut.timeline;

class TimelineView$2
  implements SliderChangeListener
{
  TimelineView$2(TimelineView paramTimelineView) {}
  
  public void onIndicatorMove(float paramFloat)
  {
    TimelineView.access$1100(this.this$0, paramFloat);
  }
  
  public void onIndicatorMove(long paramLong) {}
  
  public void onIndicatorPress()
  {
    TimelineView.access$1000(this.this$0);
  }
  
  public void onIndicatorRelease()
  {
    TimelineView.access$1200(this.this$0);
  }
  
  public void onSelectionChange(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void onSliderBarMove(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.this$0.hasEditStartAndEnd = true;
    TimelineView.access$400(this.this$0);
    TimelineView.access$500(this.this$0, paramFloat1, paramFloat2);
    TimelineView.access$600(this.this$0, paramBoolean, paramFloat1, paramFloat2);
    TimelineView.access$700(this.this$0, false);
  }
  
  public void onSliderBarRelease(boolean paramBoolean)
  {
    this.this$0.hasEditStartAndEnd = true;
    TimelineView.access$400(this.this$0);
    TimelineView.access$800(this.this$0);
    TimelineView.access$900(this.this$0, paramBoolean);
    TimelineView.access$700(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.timeline.TimelineView.2
 * JD-Core Version:    0.7.0.1
 */