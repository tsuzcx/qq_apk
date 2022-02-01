package dov.com.qq.im.capture.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QIMSlidingTabView$1
  implements View.OnClickListener
{
  QIMSlidingTabView$1(QIMSlidingTabView paramQIMSlidingTabView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMSlidingTabView.1
 * JD-Core Version:    0.7.0.1
 */