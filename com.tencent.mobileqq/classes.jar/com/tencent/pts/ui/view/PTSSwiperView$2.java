package com.tencent.pts.ui.view;

import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSLog;

class PTSSwiperView$2
  implements Runnable
{
  PTSSwiperView$2(PTSSwiperView paramPTSSwiperView, PTSNodeInfo paramPTSNodeInfo) {}
  
  public void run()
  {
    PTSNodeInfo localPTSNodeInfo1 = PTSSwiperView.access$500(this.this$0);
    PTSNodeInfo localPTSNodeInfo2 = this.val$nodeInfo;
    if (localPTSNodeInfo1 != localPTSNodeInfo2)
    {
      PTSSwiperView.access$502(this.this$0, localPTSNodeInfo2);
      PTSSwiperView.access$600(this.this$0).scrollToPosition(0);
      PTSSwiperView.access$300(this.this$0, 0);
      PTSLog.i("PTSSwiperView", "[onBindNodeInfo], snapToTargetPosition: 0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSSwiperView.2
 * JD-Core Version:    0.7.0.1
 */