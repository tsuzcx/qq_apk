package com.tencent.mobileqq.wink.utils;

import android.graphics.PointF;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;

public class QQWinkEditorUtils
{
  public static float a(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1 != null) && (paramPointF2 != null))
    {
      float f1 = paramPointF1.x - paramPointF2.x;
      float f2 = paramPointF1.y - paramPointF2.y;
      return (float)Math.sqrt(f1 * f1 + f2 * f2);
    }
    return 0.0F;
  }
  
  public static StickerBorder a(WinkStickerModel paramWinkStickerModel, int paramInt1, int paramInt2)
  {
    if (paramWinkStickerModel == null) {
      return null;
    }
    float f5 = paramWinkStickerModel.width;
    float f6 = paramWinkStickerModel.scale / paramWinkStickerModel.getInitStickerScale();
    float f3 = paramWinkStickerModel.height;
    float f4 = paramWinkStickerModel.scale / paramWinkStickerModel.getInitStickerScale();
    float f1 = (paramWinkStickerModel.centerX + 1.0F) / 2.0F * paramInt1;
    float f2 = (-paramWinkStickerModel.centerY + 1.0F) / 2.0F * paramInt2;
    f5 = f5 * f6 / 2.0F;
    f3 = f3 * f4 / 2.0F;
    return new StickerBorder(f1 - f5, f1 + f5, f2 - f3, f2 + f3);
  }
  
  public static boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8)
  {
    double d4 = paramDouble2 - paramDouble4;
    double d3 = paramDouble3 - paramDouble1;
    double d1 = d4 * paramDouble5;
    double d2 = d3 * paramDouble6;
    double d5 = d4 * paramDouble7;
    d3 *= paramDouble8;
    d4 = d5 + d3;
    d5 += d2;
    double d6 = paramDouble1 * paramDouble4 - paramDouble3 * paramDouble2;
    d2 = d1 + d2 + d6;
    if (((d2 < 0.0D) || (d4 + d6 > 0.0D)) && ((d2 > 0.0D) || (d4 + d6 < 0.0D)))
    {
      d1 = d1 + d3 + d6;
      if (((d1 < 0.0D) || (d5 + d6 > 0.0D)) && ((d1 > 0.0D) || (d5 + d6 < 0.0D))) {}
    }
    else
    {
      if (paramDouble5 > paramDouble7)
      {
        d1 = paramDouble5;
        paramDouble5 = paramDouble7;
        paramDouble7 = d1;
      }
      if (paramDouble6 < paramDouble8)
      {
        d1 = paramDouble6;
      }
      else
      {
        d1 = paramDouble8;
        paramDouble8 = paramDouble6;
      }
      return ((paramDouble1 >= paramDouble5) || (paramDouble3 >= paramDouble5)) && ((paramDouble1 <= paramDouble7) || (paramDouble3 <= paramDouble7)) && ((paramDouble2 <= paramDouble8) || (paramDouble4 <= paramDouble8)) && ((paramDouble2 >= d1) || (paramDouble4 >= d1));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.utils.QQWinkEditorUtils
 * JD-Core Version:    0.7.0.1
 */