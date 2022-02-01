package com.tencent.viola.ui.view;

class VScrollView$1
  implements Runnable
{
  VScrollView$1(VScrollView paramVScrollView) {}
  
  public void run()
  {
    if ((VScrollView.access$000(this.this$0) == this.this$0.getScrollY()) && (!VScrollView.access$100(this.this$0)))
    {
      VScrollView.OnScrollListener localOnScrollListener = VScrollView.access$300(this.this$0);
      VScrollView localVScrollView = this.this$0;
      localOnScrollListener.onScrollStateChanged(localVScrollView, 0, VScrollView.access$200(localVScrollView));
      if (VScrollView.access$400(this.this$0) != null)
      {
        localOnScrollListener = VScrollView.access$400(this.this$0);
        localVScrollView = this.this$0;
        localOnScrollListener.onScrollStateChanged(localVScrollView, 0, VScrollView.access$200(localVScrollView));
      }
      VScrollView.access$500(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.VScrollView.1
 * JD-Core Version:    0.7.0.1
 */