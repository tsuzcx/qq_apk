package com.tencent.widget;

class HorizontalListView$WindowRunnnable
{
  private int mOriginalAttachCount;
  
  private HorizontalListView$WindowRunnnable(HorizontalListView paramHorizontalListView) {}
  
  public void rememberWindowAttachCount()
  {
    this.mOriginalAttachCount = HorizontalListView.access$900(this.this$0);
  }
  
  public boolean sameWindow()
  {
    return (this.this$0.hasWindowFocus()) && (HorizontalListView.access$1000(this.this$0) == this.mOriginalAttachCount);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView.WindowRunnnable
 * JD-Core Version:    0.7.0.1
 */