package com.tencent.tkd.topicsdk.widget.videocapture;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tkd.R.string;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/widget/videocapture/CaptureOperateTouchLayout$setup$1", "Lcom/tencent/tkd/topicsdk/widget/videocapture/CaptureOperateTouchLayout$IndicatorLongPressCallback;", "onLongPressJudgeCancel", "", "onLongPressStart", "onShortLongPressStart", "onTouchUp", "isFromLongPress", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CaptureOperateTouchLayout$setup$1
  implements CaptureOperateTouchLayout.IndicatorLongPressCallback
{
  CaptureOperateTouchLayout$setup$1(TextView paramTextView, VideoMeasureScaleView paramVideoMeasureScaleView, ImageView paramImageView) {}
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(R.string.Z);
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureVideoMeasureScaleView.setVisibility(4);
    int i = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout.a();
    CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout, this.jdField_a_of_type_AndroidWidgetImageView.getX() / CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout));
    CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout, i);
    CaptureOperateTouchLayout.OnCaptureOperateCallback localOnCaptureOperateCallback = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout.a();
    if (localOnCaptureOperateCallback != null)
    {
      CaptureOperateTouchLayout localCaptureOperateTouchLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout;
      localOnCaptureOperateCallback.a(i, CaptureOperateTouchLayout.a(localCaptureOperateTouchLayout, CaptureOperateTouchLayout.b(localCaptureOperateTouchLayout)));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    CaptureOperateTouchLayout.OnCaptureOperateCallback localOnCaptureOperateCallback = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout.a();
    if (localOnCaptureOperateCallback != null) {
      localOnCaptureOperateCallback.a();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(R.string.s);
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureVideoMeasureScaleView.setVisibility(4);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(R.string.ac);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureVideoMeasureScaleView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocapture.CaptureOperateTouchLayout.setup.1
 * JD-Core Version:    0.7.0.1
 */