package dov.com.qq.im.capture.view;

import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

class AdvancedProviderView$5
  implements ValueAnimation.AnimationUpdateListener<Float>
{
  AdvancedProviderView$5(AdvancedProviderView paramAdvancedProviderView, QIMProviderContainerView paramQIMProviderContainerView, View paramView) {}
  
  @TargetApi(11)
  public void a(ValueAnimation<Float> paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    paramFloat = paramFloat1.floatValue();
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setBackGroundAlpha(paramFloat);
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setAlpha(paramFloat);
    }
    AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.AdvancedProviderView.5
 * JD-Core Version:    0.7.0.1
 */