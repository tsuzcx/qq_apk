package com.tencent.pts.ui.view;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeSwiper;
import com.tencent.pts.utils.PTSLog;

class PTSSwiperView$3
  implements Runnable
{
  PTSSwiperView$3(PTSSwiperView paramPTSSwiperView) {}
  
  public void run()
  {
    if (PTSSwiperView.access$100(this.this$0) != null)
    {
      if (PTSSwiperView.access$600(this.this$0) == null) {
        return;
      }
      if (!PTSSwiperView.access$700(this.this$0)) {
        return;
      }
      PTSNodeSwiper localPTSNodeSwiper = PTSSwiperView.access$800(this.this$0);
      if ((localPTSNodeSwiper != null) && (localPTSNodeSwiper.getAppInstance() != null) && (localPTSNodeSwiper.getAppInstance().getContext() == null))
      {
        PTSLog.i("PTSSwiperView", "mAutoPlayRunnable [run] context is null, stop scroll.");
        return;
      }
      PTSSwiperView.access$100(this.this$0).snapToNextPosition();
      PTSSwiperView.access$600(this.this$0).removeCallbacks(PTSSwiperView.access$900(this.this$0));
      PTSSwiperView.access$600(this.this$0).postDelayed(PTSSwiperView.access$900(this.this$0), PTSSwiperView.access$1000(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSSwiperView.3
 * JD-Core Version:    0.7.0.1
 */