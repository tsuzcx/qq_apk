package com.tencent.mobileqq.kandian.base.imagecrop;

import com.tencent.mobileqq.kandian.base.imagecrop.util.CubicEasing;
import java.lang.ref.WeakReference;

class CropImageView$ZoomImageToPosition
  implements Runnable
{
  private final float jdField_a_of_type_Float;
  private final long jdField_a_of_type_Long;
  private final WeakReference<CropImageView> jdField_a_of_type_JavaLangRefWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  private final float jdField_b_of_type_Float;
  private final long jdField_b_of_type_Long;
  private final float c;
  private final float d;
  
  public CropImageView$ZoomImageToPosition(CropImageView paramCropImageView, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCropImageView);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    CropImageView localCropImageView = (CropImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localCropImageView == null) {
      return;
    }
    long l = System.currentTimeMillis();
    float f2 = (float)Math.min(this.jdField_a_of_type_Long, l - this.jdField_b_of_type_Long);
    float f1;
    if (this.jdField_a_of_type_Boolean) {
      f1 = CubicEasing.a(f2, 0.0F, this.jdField_b_of_type_Float, (float)this.jdField_a_of_type_Long);
    } else {
      f1 = CubicEasing.b(f2, 0.0F, this.jdField_b_of_type_Float, (float)this.jdField_a_of_type_Long);
    }
    if (f2 < (float)this.jdField_a_of_type_Long)
    {
      if (!this.jdField_a_of_type_Boolean) {
        localCropImageView.b(this.jdField_a_of_type_Float + f1, this.c, this.d);
      } else {
        localCropImageView.a(this.jdField_a_of_type_Float + f1, this.c, this.d);
      }
      localCropImageView.post(this);
      return;
    }
    localCropImageView.setImageToWrapCropBounds();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.CropImageView.ZoomImageToPosition
 * JD-Core Version:    0.7.0.1
 */