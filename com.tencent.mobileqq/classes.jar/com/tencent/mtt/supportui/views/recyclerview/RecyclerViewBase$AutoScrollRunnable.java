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
    if (this.dir > 0) {}
    for (boolean bool = this.this$0.mDownOverScrollEnabled;; bool = this.this$0.mUpOverScrollEnabled)
    {
      this.this$0.setOverScrollEnabled(false);
      this.this$0.scrollBy(0, this.this$0.getAutoScrollVelocity() * this.dir);
      if (!this.cancel) {
        this.this$0.postDelayed(this, 16L);
      }
      this.this$0.setOverScrollEnabled(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.AutoScrollRunnable
 * JD-Core Version:    0.7.0.1
 */