package com.tencent.qqmini.miniapp.core.page.swipe;

class SwipeBackLayout$3
  implements Runnable
{
  SwipeBackLayout$3(SwipeBackLayout paramSwipeBackLayout) {}
  
  public void run()
  {
    if ((SwipeBackLayout.access$800(this.this$0) != null) && (SwipeBackLayout.access$700(this.this$0) != null)) {
      SwipeBackLayout.access$800(this.this$0).settleCapturedViewImmediately(SwipeBackLayout.access$700(this.this$0), 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.swipe.SwipeBackLayout.3
 * JD-Core Version:    0.7.0.1
 */