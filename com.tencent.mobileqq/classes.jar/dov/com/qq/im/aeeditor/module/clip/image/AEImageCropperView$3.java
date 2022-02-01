package dov.com.qq.im.aeeditor.module.clip.image;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;

class AEImageCropperView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  AEImageCropperView$3(AEImageCropperView paramAEImageCropperView, Matrix paramMatrix, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.getImageMatrix();
    float f2 = AEImageCropperView.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView, this.jdField_a_of_type_AndroidGraphicsMatrix, 2);
    float f3 = AEImageCropperView.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView, this.jdField_a_of_type_AndroidGraphicsMatrix, 5);
    paramValueAnimator.postTranslate(this.jdField_a_of_type_Float * f1 - (f2 - this.b), f1 * this.c - (f3 - this.d));
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.setImageMatrix(paramValueAnimator);
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.image.AEImageCropperView.3
 * JD-Core Version:    0.7.0.1
 */