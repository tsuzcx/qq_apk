package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.qcircle.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.tavsticker.model.TAVSticker;

public class WsStickerUtil
{
  private static final int CLICK_MARGIN = 35;
  
  public static PointF[] computeRectanglePoints(Matrix paramMatrix, float paramFloat1, float paramFloat2)
  {
    PointF[] arrayOfPointF = new PointF[4];
    arrayOfPointF[0] = new PointF();
    arrayOfPointF[1] = new PointF();
    arrayOfPointF[2] = new PointF();
    arrayOfPointF[3] = new PointF();
    paramMatrix = new Matrix(paramMatrix);
    paramMatrix.preTranslate(-35.0F, -35.0F);
    float f1 = paramFloat1 + 70.0F;
    paramFloat1 = paramFloat2 + 70.0F;
    if ((f1 > 0.0F) && (paramFloat1 > 0.0F))
    {
      float[] arrayOfFloat = new float[9];
      paramMatrix.getValues(arrayOfFloat);
      paramFloat2 = arrayOfFloat[2];
      float f2 = arrayOfFloat[5];
      arrayOfPointF[0].set(paramFloat2, f2);
      paramFloat2 = arrayOfFloat[0];
      f2 = arrayOfFloat[2];
      float f3 = arrayOfFloat[3];
      float f4 = arrayOfFloat[5];
      arrayOfPointF[1].set(paramFloat2 * f1 + f2, f3 * f1 + f4);
      paramFloat2 = arrayOfFloat[0];
      f2 = arrayOfFloat[1];
      f3 = arrayOfFloat[2];
      f4 = arrayOfFloat[3];
      float f5 = arrayOfFloat[4];
      float f6 = arrayOfFloat[5];
      arrayOfPointF[2].set(paramFloat2 * f1 + f2 * paramFloat1 + f3, f4 * f1 + f5 * paramFloat1 + f6);
      paramFloat2 = arrayOfFloat[1];
      f1 = arrayOfFloat[2];
      f2 = arrayOfFloat[4];
      f3 = arrayOfFloat[5];
      arrayOfPointF[3].set(paramFloat2 * paramFloat1 + f1, f2 * paramFloat1 + f3);
    }
    return arrayOfPointF;
  }
  
  public static PointF[] computeRectanglePointsForBlurSticker(Matrix paramMatrix, float paramFloat1, float paramFloat2)
  {
    PointF[] arrayOfPointF = new PointF[4];
    arrayOfPointF[0] = new PointF();
    arrayOfPointF[1] = new PointF();
    arrayOfPointF[2] = new PointF();
    arrayOfPointF[3] = new PointF();
    if ((paramMatrix != null) && (paramFloat1 > 0.0F) && (paramFloat2 > 0.0F))
    {
      float[] arrayOfFloat = new float[9];
      paramMatrix.getValues(arrayOfFloat);
      float f1 = arrayOfFloat[2];
      float f2 = arrayOfFloat[5];
      arrayOfPointF[0].set(f1 - 35.0F, f2 - 35.0F);
      f1 = arrayOfFloat[0];
      f2 = arrayOfFloat[2];
      float f3 = arrayOfFloat[3];
      float f4 = arrayOfFloat[5];
      arrayOfPointF[1].set(f1 * paramFloat1 + f2 + 35.0F, f3 * paramFloat1 + f4 - 35.0F);
      f1 = arrayOfFloat[0];
      f2 = arrayOfFloat[1];
      f3 = arrayOfFloat[2];
      f4 = arrayOfFloat[3];
      float f5 = arrayOfFloat[4];
      float f6 = arrayOfFloat[5];
      arrayOfPointF[2].set(f1 * paramFloat1 + f2 * paramFloat2 + f3 + 35.0F, f4 * paramFloat1 + f5 * paramFloat2 + f6 + 35.0F);
      paramFloat1 = arrayOfFloat[1];
      f1 = arrayOfFloat[2];
      f2 = arrayOfFloat[4];
      f3 = arrayOfFloat[5];
      arrayOfPointF[3].set(paramFloat1 * paramFloat2 + f1 - 35.0F, f2 * paramFloat2 + f3 + 35.0F);
    }
    return arrayOfPointF;
  }
  
  public static Matrix getRatioChangeMatrix(TAVSticker paramTAVSticker, int paramInt1, int paramInt2)
  {
    Matrix localMatrix = new Matrix();
    if (paramTAVSticker != null)
    {
      RectF localRectF = getStickerRect(paramTAVSticker, paramInt1, paramInt2, TAVStickerExKt.getStickerScaleX(paramTAVSticker), TAVStickerExKt.getStickerScaleY(paramTAVSticker));
      if (localRectF != null)
      {
        paramInt1 = paramTAVSticker.getWidth();
        paramInt2 = paramTAVSticker.getHeight();
        localMatrix.setTranslate(-paramInt1 * 0.5F, -paramInt2 * 0.5F);
        float f3 = localRectF.right - localRectF.left;
        float f2 = localRectF.bottom - localRectF.top;
        if ((paramInt1 != 0) && (paramInt2 != 0)) {
          localMatrix.postScale(f3 * 1.0F / paramInt1, 1.0F * f2 / paramInt2);
        }
        localMatrix.postRotate(paramTAVSticker.getRotate());
        float f1 = localRectF.left;
        f3 /= 2.0F;
        float f4 = localRectF.top;
        f2 /= 2.0F;
        localMatrix.postTranslate((float)Math.ceil(f1 + f3), (float)Math.ceil(f4 + f2));
      }
    }
    return localMatrix;
  }
  
  public static RectF getStickerRect(TAVSticker paramTAVSticker, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if ((paramTAVSticker != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      int i = paramInt1;
      if (paramInt1 % 2 != 0) {
        i = paramInt1 + 1;
      }
      paramInt1 = paramInt2;
      if (paramInt2 % 2 != 0) {
        paramInt1 = paramInt2 + 1;
      }
      RectF localRectF = new RectF();
      paramInt2 = paramTAVSticker.getWidth();
      int j = paramTAVSticker.getHeight();
      float f3 = i;
      float f1 = paramFloat1 * f3;
      float f2 = j * f1 * 1.0F * paramFloat2 / (paramFloat1 * paramInt2);
      paramFloat2 = f2;
      paramFloat1 = f1;
      if (paramTAVSticker.getScaleMode() == 1)
      {
        paramFloat2 = Math.max(f3 * 1.0F / f1, paramInt1 * 1.0F / f2);
        paramFloat1 = f1 * paramFloat2;
        paramFloat2 = f2 * paramFloat2;
      }
      f1 = paramTAVSticker.getCenterX() * f3 - paramFloat1 / 2.0F;
      f2 = paramTAVSticker.getCenterY() * paramInt1 - paramFloat2 / 2.0F;
      localRectF.left = ((float)Math.floor(f1));
      localRectF.top = ((float)Math.floor(f2));
      localRectF.bottom = ((float)Math.ceil(f2 + paramFloat2));
      localRectF.right = ((float)Math.ceil(f1 + paramFloat1));
      return localRectF;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.WsStickerUtil
 * JD-Core Version:    0.7.0.1
 */