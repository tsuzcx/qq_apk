package com.tencent.tkd.topicsdk.ucrop.view;

import android.graphics.RectF;
import com.tencent.tkd.topicsdk.ucrop.util.CubicEasing;
import java.lang.ref.WeakReference;

class CropImageView$WrapCropBoundsRunnable
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
  private final float e;
  private final float f;
  
  public CropImageView$WrapCropBoundsRunnable(CropImageView paramCropImageView, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCropImageView);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
    this.e = paramFloat5;
    this.f = paramFloat6;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    CropImageView localCropImageView = (CropImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localCropImageView == null) {
      return;
    }
    long l = System.currentTimeMillis();
    float f1 = (float)Math.min(this.jdField_a_of_type_Long, l - this.jdField_b_of_type_Long);
    float f2 = CubicEasing.a(f1, 0.0F, this.c, (float)this.jdField_a_of_type_Long);
    float f3 = CubicEasing.a(f1, 0.0F, this.d, (float)this.jdField_a_of_type_Long);
    float f4 = CubicEasing.b(f1, 0.0F, this.f, (float)this.jdField_a_of_type_Long);
    if (f1 < (float)this.jdField_a_of_type_Long)
    {
      localCropImageView.a(f2 - (localCropImageView.b[0] - this.jdField_a_of_type_Float), f3 - (localCropImageView.b[1] - this.jdField_b_of_type_Float));
      if (!this.jdField_a_of_type_Boolean) {
        localCropImageView.a(this.e + f4, CropImageView.a(localCropImageView).centerX(), CropImageView.a(localCropImageView).centerY());
      }
      if (!localCropImageView.a()) {
        localCropImageView.post(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.view.CropImageView.WrapCropBoundsRunnable
 * JD-Core Version:    0.7.0.1
 */