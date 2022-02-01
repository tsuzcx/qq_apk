package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.animation;

import android.animation.TypeEvaluator;

public class CropHomingEvaluator
  implements TypeEvaluator<CropHomeing>
{
  private CropHomeing a;
  
  public CropHomeing a(float paramFloat, CropHomeing paramCropHomeing1, CropHomeing paramCropHomeing2)
  {
    float f1 = paramCropHomeing1.a + (paramCropHomeing2.a - paramCropHomeing1.a) * paramFloat;
    float f2 = paramCropHomeing1.b + (paramCropHomeing2.b - paramCropHomeing1.b) * paramFloat;
    float f3 = paramCropHomeing1.c + (paramCropHomeing2.c - paramCropHomeing1.c) * paramFloat;
    paramFloat = paramCropHomeing1.d + (paramCropHomeing2.d - paramCropHomeing1.d) * paramFloat;
    if (this.a == null) {
      this.a = new CropHomeing(f1, f2, f3, paramFloat);
    }
    for (;;)
    {
      return this.a;
      this.a.a(f1, f2, f3, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.animation.CropHomingEvaluator
 * JD-Core Version:    0.7.0.1
 */