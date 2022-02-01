package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.Clip;

import android.graphics.Matrix;
import android.graphics.RectF;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.animation.CropHomeing;

public class ClipUtils
{
  private static final Matrix a = new Matrix();
  
  public static CropHomeing a(RectF paramRectF1, RectF paramRectF2)
  {
    CropHomeing localCropHomeing = new CropHomeing(0.0F, 0.0F, 1.0F, 0.0F);
    if (paramRectF1.equals(paramRectF2)) {
      return localCropHomeing;
    }
    localCropHomeing.c = Math.max(paramRectF1.width() / paramRectF2.width(), paramRectF1.height() / paramRectF2.height());
    RectF localRectF = new RectF();
    a.setScale(localCropHomeing.c, localCropHomeing.c, paramRectF2.centerX(), paramRectF2.centerY());
    a.mapRect(localRectF, paramRectF2);
    localCropHomeing.a += paramRectF1.centerX() - localRectF.centerX();
    float f = localCropHomeing.b;
    localCropHomeing.b = (paramRectF1.centerY() - localRectF.centerY() + f);
    return localCropHomeing;
  }
  
  public static CropHomeing a(RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2)
  {
    CropHomeing localCropHomeing = new CropHomeing(0.0F, 0.0F, 1.0F, 0.0F);
    if (paramRectF2.contains(paramRectF1)) {}
    RectF localRectF;
    do
    {
      return localCropHomeing;
      if ((paramRectF2.width() < paramRectF1.width()) && (paramRectF2.height() < paramRectF1.height())) {
        localCropHomeing.c = Math.min(paramRectF1.width() / paramRectF2.width(), paramRectF1.height() / paramRectF2.height());
      }
      localRectF = new RectF();
      a.setScale(localCropHomeing.c, localCropHomeing.c, paramFloat1, paramFloat2);
      a.mapRect(localRectF, paramRectF2);
      if (localRectF.width() < paramRectF1.width()) {
        localCropHomeing.a += paramRectF1.centerX() - localRectF.centerX();
      }
      while (localRectF.height() < paramRectF1.height())
      {
        paramFloat1 = localCropHomeing.b;
        localCropHomeing.b = (paramRectF1.centerY() - localRectF.centerY() + paramFloat1);
        return localCropHomeing;
        if (localRectF.left > paramRectF1.left) {
          localCropHomeing.a += paramRectF1.left - localRectF.left;
        } else if (localRectF.right < paramRectF1.right) {
          localCropHomeing.a += paramRectF1.right - localRectF.right;
        }
      }
      if (localRectF.top > paramRectF1.top)
      {
        paramFloat1 = localCropHomeing.b;
        localCropHomeing.b = (paramRectF1.top - localRectF.top + paramFloat1);
        return localCropHomeing;
      }
    } while (localRectF.bottom >= paramRectF1.bottom);
    paramFloat1 = localCropHomeing.b;
    localCropHomeing.b = (paramRectF1.bottom - localRectF.bottom + paramFloat1);
    return localCropHomeing;
  }
  
  public static void a(RectF paramRectF1, RectF paramRectF2)
  {
    paramRectF2.offset(paramRectF1.centerX() - paramRectF2.centerX(), paramRectF1.centerY() - paramRectF2.centerY());
  }
  
  public static void a(RectF paramRectF1, RectF paramRectF2, float paramFloat)
  {
    a(paramRectF1, paramRectF2, paramFloat, paramFloat, paramFloat, paramFloat);
  }
  
  public static void a(RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramRectF1.isEmpty()) || (paramRectF2.isEmpty())) {
      return;
    }
    float f2 = paramFloat1;
    float f1 = paramFloat3;
    if (paramRectF1.width() < paramFloat1 + paramFloat3)
    {
      f1 = 0.0F;
      f2 = 0.0F;
    }
    paramFloat3 = paramFloat2;
    paramFloat1 = paramFloat4;
    if (paramRectF1.height() < paramFloat2 + paramFloat4)
    {
      paramFloat1 = 0.0F;
      paramFloat3 = 0.0F;
    }
    paramFloat2 = paramRectF1.width();
    paramFloat4 = paramRectF1.height();
    paramFloat2 = Math.min((paramFloat2 - f2 - f1) / paramRectF2.width(), (paramFloat4 - paramFloat3 - paramFloat1) / paramRectF2.height());
    paramRectF2.set(0.0F, 0.0F, paramRectF2.width() * paramFloat2, paramFloat2 * paramRectF2.height());
    paramRectF2.offset(paramRectF1.centerX() + (f2 - f1) / 2.0F - paramRectF2.centerX(), paramRectF1.centerY() + (paramFloat3 - paramFloat1) / 2.0F - paramRectF2.centerY());
  }
  
  public static CropHomeing b(RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2)
  {
    CropHomeing localCropHomeing = new CropHomeing(0.0F, 0.0F, 1.0F, 0.0F);
    if (paramRectF2.contains(paramRectF1)) {}
    RectF localRectF;
    do
    {
      return localCropHomeing;
      if ((paramRectF2.width() < paramRectF1.width()) || (paramRectF2.height() < paramRectF1.height())) {
        localCropHomeing.c = Math.max(paramRectF1.width() / paramRectF2.width(), paramRectF1.height() / paramRectF2.height());
      }
      localRectF = new RectF();
      a.setScale(localCropHomeing.c, localCropHomeing.c, paramFloat1, paramFloat2);
      a.mapRect(localRectF, paramRectF2);
      if (localRectF.left > paramRectF1.left) {
        localCropHomeing.a += paramRectF1.left - localRectF.left;
      }
      while (localRectF.top > paramRectF1.top)
      {
        paramFloat1 = localCropHomeing.b;
        localCropHomeing.b = (paramRectF1.top - localRectF.top + paramFloat1);
        return localCropHomeing;
        if (localRectF.right < paramRectF1.right) {
          localCropHomeing.a += paramRectF1.right - localRectF.right;
        }
      }
    } while (localRectF.bottom >= paramRectF1.bottom);
    paramFloat1 = localCropHomeing.b;
    localCropHomeing.b = (paramRectF1.bottom - localRectF.bottom + paramFloat1);
    return localCropHomeing;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.Clip.ClipUtils
 * JD-Core Version:    0.7.0.1
 */