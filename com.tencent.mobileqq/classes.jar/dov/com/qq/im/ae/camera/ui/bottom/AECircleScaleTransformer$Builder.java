package dov.com.qq.im.ae.camera.ui.bottom;

import android.support.annotation.FloatRange;

public class AECircleScaleTransformer$Builder
{
  private float jdField_a_of_type_Float = 1.0F;
  private AECircleScaleTransformer jdField_a_of_type_DovComQqImAeCameraUiBottomAECircleScaleTransformer = new AECircleScaleTransformer();
  
  public Builder a(@FloatRange(from=0.01D) float paramFloat)
  {
    AECircleScaleTransformer.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAECircleScaleTransformer, paramFloat);
    return this;
  }
  
  public AECircleScaleTransformer a()
  {
    AECircleScaleTransformer.b(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAECircleScaleTransformer, this.jdField_a_of_type_Float - AECircleScaleTransformer.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAECircleScaleTransformer));
    return this.jdField_a_of_type_DovComQqImAeCameraUiBottomAECircleScaleTransformer;
  }
  
  public Builder b(@FloatRange(from=0.01D) float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AECircleScaleTransformer.Builder
 * JD-Core Version:    0.7.0.1
 */