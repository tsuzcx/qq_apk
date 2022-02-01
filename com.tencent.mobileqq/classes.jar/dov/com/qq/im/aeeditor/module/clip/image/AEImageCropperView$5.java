package dov.com.qq.im.aeeditor.module.clip.image;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;

class AEImageCropperView$5
  implements ValueAnimator.AnimatorUpdateListener
{
  AEImageCropperView$5(AEImageCropperView paramAEImageCropperView, float paramFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.getImageMatrix();
    if (AEImageCropperView.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView, paramValueAnimator) <= AEImageCropperView.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView)) {
      return;
    }
    double d = Math.pow(AEImageCropperView.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView) / this.jdField_a_of_type_Float, 0.0500000007450581D);
    paramValueAnimator.postScale((float)d, (float)d, AEImageCropperView.b(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView), AEImageCropperView.c(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView));
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.setImageMatrix(paramValueAnimator);
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.image.AEImageCropperView.5
 * JD-Core Version:    0.7.0.1
 */