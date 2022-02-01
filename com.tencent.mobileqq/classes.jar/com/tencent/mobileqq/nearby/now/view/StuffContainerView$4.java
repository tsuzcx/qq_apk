package com.tencent.mobileqq.nearby.now.view;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.nearby.now.IStoryPlayController;
import com.tencent.qphone.base.util.QLog;

class StuffContainerView$4
  implements View.OnLayoutChangeListener
{
  StuffContainerView$4(StuffContainerView paramStuffContainerView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    long l1 = System.currentTimeMillis();
    long l2 = StuffContainerView.a(this.a);
    if ((StuffContainerView.a(this.a) > 0L) && (l1 - l2 < 500L)) {
      return;
    }
    StuffContainerView.a(this.a, l1);
    if (QLog.isColorLevel()) {
      QLog.d("StuffContainerView", 2, "VideoInfoListenerImpl onLayoutChange");
    }
    if (this.a.i != null) {
      this.a.i.handleDeviceNavChange();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.StuffContainerView.4
 * JD-Core Version:    0.7.0.1
 */