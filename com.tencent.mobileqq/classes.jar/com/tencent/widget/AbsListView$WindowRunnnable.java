package com.tencent.widget;

class AbsListView$WindowRunnnable
{
  private int mOriginalAttachCount;
  
  private AbsListView$WindowRunnnable(AbsListView paramAbsListView) {}
  
  public void rememberWindowAttachCount()
  {
    this.mOriginalAttachCount = AbsListView.access$200(this.this$0);
  }
  
  public boolean sameWindow()
  {
    return (this.this$0.hasWindowFocus()) && (AbsListView.access$300(this.this$0) == this.mOriginalAttachCount);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AbsListView.WindowRunnnable
 * JD-Core Version:    0.7.0.1
 */