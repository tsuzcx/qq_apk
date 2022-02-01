package com.tencent.mobileqq.flashshow.view.refresh;

class PullRefreshLayout$5
  implements Runnable
{
  PullRefreshLayout$5(PullRefreshLayout paramPullRefreshLayout) {}
  
  public void run()
  {
    if (PullRefreshLayout.i(this.this$0) == null) {
      return;
    }
    if (PullRefreshLayout.h(this.this$0) == 3)
    {
      PullRefreshLayout.g(this.this$0).a(this.this$0);
      PullRefreshLayout.a(this.this$0, 1);
    }
    PullRefreshLayout localPullRefreshLayout = this.this$0;
    PullRefreshLayout.a(localPullRefreshLayout, 0.0F, PullRefreshLayout.f(localPullRefreshLayout), new PullRefreshLayout.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.refresh.PullRefreshLayout.5
 * JD-Core Version:    0.7.0.1
 */