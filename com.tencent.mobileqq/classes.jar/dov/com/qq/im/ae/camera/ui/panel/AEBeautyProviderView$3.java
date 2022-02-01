package dov.com.qq.im.ae.camera.ui.panel;

import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

class AEBeautyProviderView$3
  implements ValueAnimation.AnimationUpdateListener<Float>
{
  AEBeautyProviderView$3(AEBeautyProviderView paramAEBeautyProviderView, AEProviderContainerView paramAEProviderContainerView, View paramView) {}
  
  @TargetApi(11)
  public void a(ValueAnimation<Float> paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    paramFloat = paramFloat1.floatValue();
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView.setBackGroundAlpha(paramFloat);
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setAlpha(paramFloat);
    }
    AEBeautyProviderView.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView.3
 * JD-Core Version:    0.7.0.1
 */