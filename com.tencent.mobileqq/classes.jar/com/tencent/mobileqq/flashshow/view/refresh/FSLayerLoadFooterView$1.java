package com.tencent.mobileqq.flashshow.view.refresh;

class FSLayerLoadFooterView$1
  implements Runnable
{
  FSLayerLoadFooterView$1(FSLayerLoadFooterView paramFSLayerLoadFooterView, PullRefreshLayout paramPullRefreshLayout) {}
  
  public void run()
  {
    if (FSLayerLoadFooterView.a(this.this$0, this.a)) {
      return;
    }
    FSLayerLoadFooterView.a(this.this$0).b();
    FSLayerLoadFooterView.a(this.this$0).setVisibility(8);
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.refresh.FSLayerLoadFooterView.1
 * JD-Core Version:    0.7.0.1
 */