package com.tencent.pts.ui.view;

class PTSSwiperView$2
  implements Runnable
{
  PTSSwiperView$2(PTSSwiperView paramPTSSwiperView) {}
  
  public void run()
  {
    if ((PTSSwiperView.access$100(this.this$0) == null) || (PTSSwiperView.access$400(this.this$0) == null)) {}
    while (!PTSSwiperView.access$500(this.this$0)) {
      return;
    }
    PTSSwiperView.access$100(this.this$0).snapToNextPosition();
    PTSSwiperView.access$400(this.this$0).removeCallbacks(PTSSwiperView.access$600(this.this$0));
    PTSSwiperView.access$400(this.this$0).postDelayed(PTSSwiperView.access$600(this.this$0), PTSSwiperView.access$700(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSSwiperView.2
 * JD-Core Version:    0.7.0.1
 */