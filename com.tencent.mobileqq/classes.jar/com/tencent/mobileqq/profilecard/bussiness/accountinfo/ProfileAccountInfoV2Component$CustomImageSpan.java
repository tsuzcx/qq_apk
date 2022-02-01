package com.tencent.mobileqq.profilecard.bussiness.accountinfo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.style.ImageSpan;

class ProfileAccountInfoV2Component$CustomImageSpan
  extends ImageSpan
{
  public static final int ALIGN_CENTER = 2;
  
  public ProfileAccountInfoV2Component$CustomImageSpan(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1, paramInt2);
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    if (this.mVerticalAlignment == 0) {
      paramInt1 = paramInt5 - paramCharSequence.getBounds().bottom;
    }
    for (;;)
    {
      paramCanvas.save();
      paramCanvas.translate(paramFloat, paramInt1);
      paramCharSequence.draw(paramCanvas);
      paramCanvas.restore();
      return;
      if (this.mVerticalAlignment == 1)
      {
        paramInt1 = 0 - paramPaint.getFontMetricsInt().descent;
      }
      else
      {
        paramPaint = paramPaint.getFontMetricsInt();
        paramInt1 = paramPaint.descent;
        paramInt1 = (paramPaint.ascent + (paramInt1 + paramInt4 + paramInt4)) / 2 - paramCharSequence.getBounds().bottom / 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountinfo.ProfileAccountInfoV2Component.CustomImageSpan
 * JD-Core Version:    0.7.0.1
 */