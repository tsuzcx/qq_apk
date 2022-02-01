package com.tencent.widget;

class AbsListView$2
  implements Runnable
{
  AbsListView$2(AbsListView paramAbsListView) {}
  
  public void run()
  {
    if (this.this$0.mCachingStarted)
    {
      AbsListView localAbsListView = this.this$0;
      localAbsListView.mCachingActive = false;
      localAbsListView.mCachingStarted = false;
      AbsListView.access$2500(localAbsListView, false);
      if ((this.this$0.getQQPersistentDrawingCache() & 0x2) == 0) {
        AbsListView.access$2600(this.this$0, false);
      }
      if (!this.this$0.isAlwaysDrawnWithCacheEnabled()) {
        this.this$0.invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.AbsListView.2
 * JD-Core Version:    0.7.0.1
 */