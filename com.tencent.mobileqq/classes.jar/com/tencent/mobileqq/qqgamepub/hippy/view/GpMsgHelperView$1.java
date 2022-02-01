package com.tencent.mobileqq.qqgamepub.hippy.view;

import android.view.View.MeasureSpec;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;
import com.tencent.mobileqq.qqgamepub.view.GameSessionView;
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
    GpMsgHelperView.a(this.this$0).measure(i, j);
    float f = UIUtils.a(GpMsgHelperView.a(this.this$0).getMeasuredHeight(), this.this$0.getResources());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshGameContentView111 heightDp = ");
    ((StringBuilder)localObject).append(f);
    QLog.d("QQGamePub_GpMsgHelperView", 1, ((StringBuilder)localObject).toString());
    localObject = new HippyMap();
    ((HippyMap)localObject).pushInt("action", 5);
    ((HippyMap)localObject).pushInt("height", (int)f);
    GpMsgHelperView.a(this.this$0, "onGameFeedsEvent", (HippyMap)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.view.GpMsgHelperView.1
 * JD-Core Version:    0.7.0.1
 */