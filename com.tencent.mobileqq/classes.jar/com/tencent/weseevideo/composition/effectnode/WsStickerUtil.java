package com.tencent.weseevideo.composition.effectnode;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.editor.sticker.model.TAVStickerExKt;

public class WsStickerUtil
{
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
          localMatrix.postScale(f3 * 1.0F / paramInt1, f2 * 1.0F / paramInt2);
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
    if ((paramTAVSticker == null) || (paramInt1 <= 0) || (paramInt2 <= 0)) {
      return null;
    }
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
    float f1 = i * paramFloat1;
    float f2 = j * f1 * 1.0F * paramFloat2 / (paramInt2 * paramFloat1);
    paramFloat2 = f2;
    paramFloat1 = f1;
    if (paramTAVSticker.getScaleMode() == 1)
    {
      paramFloat2 = Math.max(i * 1.0F / f1, paramInt1 * 1.0F / f2);
      paramFloat1 = f1 * paramFloat2;
      paramFloat2 = f2 * paramFloat2;
    }
    f1 = paramTAVSticker.getCenterX() * i - paramFloat1 / 2.0F;
    f2 = paramTAVSticker.getCenterY() * paramInt1 - paramFloat2 / 2.0F;
    localRectF.left = ((float)Math.floor(f1));
    localRectF.top = ((float)Math.floor(f2));
    localRectF.bottom = ((float)Math.ceil(paramFloat2 + f2));
    localRectF.right = ((float)Math.ceil(f1 + paramFloat1));
    return localRectF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.WsStickerUtil
 * JD-Core Version:    0.7.0.1
 */