package com.tencent.mtt.supportui.views.recyclerview;

public class RecyclerViewBase$AutoScrollRunnable
  implements Runnable
{
  public boolean cancel;
  public int dir = -1;
  
  public RecyclerViewBase$AutoScrollRunnable(RecyclerViewBase paramRecyclerViewBase) {}
  
  public void cancelPost(boolean paramBoolean)
  {
    this.cancel = paramBoolean;
  }
  
  public void run()
  {
    boolean bool;
    if (this.dir > 0) {
      bool = this.this$0.mDownOverScrollEnabled;
    } else {
      bool = this.this$0.mUpOverScrollEnabled;
    }
    this.this$0.setOverScrollEnabled(false);
    RecyclerViewBase localRecyclerViewBase = this.this$0;
    localRecyclerViewBase.scrollBy(0, localRecyclerViewBase.getAutoScrollVelocity() * this.dir);
    if (!this.cancel) {
      this.this$0.postDelayed(this, 16L);
    }
    this.this$0.setOverScrollEnabled(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.AutoScrollRunnable
 * JD-Core Version:    0.7.0.1
 */