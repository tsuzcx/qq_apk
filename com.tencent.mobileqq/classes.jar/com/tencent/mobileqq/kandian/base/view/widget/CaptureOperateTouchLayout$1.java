package com.tencent.mobileqq.kandian.base.view.widget;

import android.widget.ImageView;
import android.widget.TextView;

class CaptureOperateTouchLayout$1
  implements CaptureOperateTouchLayout.IndicatorLongPressCallback
{
  CaptureOperateTouchLayout$1(CaptureOperateTouchLayout paramCaptureOperateTouchLayout, TextView paramTextView, VideoMeasureScaleView paramVideoMeasureScaleView, ImageView paramImageView) {}
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718008);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoMeasureScaleView.setVisibility(0);
    int i = CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout);
    CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout, this.jdField_a_of_type_AndroidWidgetImageView.getX() / CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout));
    CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout, i);
    if (CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout) != null)
    {
      CaptureOperateTouchLayout.OnCaptureOperateCallback localOnCaptureOperateCallback = CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout);
      CaptureOperateTouchLayout localCaptureOperateTouchLayout = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout;
      localOnCaptureOperateCallback.a(i, CaptureOperateTouchLayout.a(localCaptureOperateTouchLayout, CaptureOperateTouchLayout.b(localCaptureOperateTouchLayout)));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout) != null) {
      CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout).a();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717894);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoMeasureScaleView.setVisibility(4);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718046);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoMeasureScaleView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.CaptureOperateTouchLayout.1
 * JD-Core Version:    0.7.0.1
 */