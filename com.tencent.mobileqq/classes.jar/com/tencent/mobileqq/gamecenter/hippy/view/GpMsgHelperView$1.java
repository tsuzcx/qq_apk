package com.tencent.mobileqq.gamecenter.hippy.view;

import android.view.View.MeasureSpec;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;

class GpMsgHelperView$1
  implements Runnable
{
  GpMsgHelperView$1(GpMsgHelperView paramGpMsgHelperView) {}
  
  public void run()
  {
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    GpMsgHelperView.access$000(this.this$0).measure(i, j);
    float f = AIOUtils.a(GpMsgHelperView.access$000(this.this$0).getMeasuredHeight(), this.this$0.getResources());
    QLog.d("GpMsgHelperView", 1, "refreshGameContentView111 heightDp = " + f);
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("action", 5);
    localHippyMap.pushInt("height", (int)f);
    GpMsgHelperView.access$100(this.this$0, "onGameFeedsEvent", localHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.view.GpMsgHelperView.1
 * JD-Core Version:    0.7.0.1
 */