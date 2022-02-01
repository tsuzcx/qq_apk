package dov.com.qq.im.aeeditor.module.clip.image;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;

class AEImageCropperView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AEImageCropperView$1(AEImageCropperView paramAEImageCropperView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Matrix localMatrix = this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.getImageMatrix();
    localMatrix.reset();
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    float f1 = (this.jdField_a_of_type_Float - this.b) * paramValueAnimator.intValue() / 20.0F + this.b;
    localMatrix.postScale(f1, f1);
    f1 = (this.c - this.d) * paramValueAnimator.intValue() / 20.0F;
    float f2 = this.d;
    float f3 = this.e;
    float f4 = this.f;
    localMatrix.postTranslate(f1 + f2, paramValueAnimator.intValue() * (f3 - f4) / 20.0F + this.f);
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.setImageMatrix(localMatrix);
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.image.AEImageCropperView.1
 * JD-Core Version:    0.7.0.1
 */