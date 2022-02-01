package com.tencent.mobileqq.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class MessageForQQWalletTips$CenterImageSpan
  extends ImageSpan
{
  private int size = 0;
  
  public MessageForQQWalletTips$CenterImageSpan(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public MessageForQQWalletTips$CenterImageSpan(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1);
    this.size = paramInt2;
  }
  
  public MessageForQQWalletTips$CenterImageSpan(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext, paramBitmap);
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    paramInt1 = this.size;
    if (paramInt1 > 0) {
      paramCharSequence.setBounds(0, 0, paramInt1, paramInt1);
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat, (paramInt5 - paramInt3 - paramCharSequence.getBounds().bottom) / 2 + paramInt3);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    Drawable localDrawable = getDrawable();
    paramCharSequence = localDrawable.getBounds();
    paramInt1 = this.size;
    if (paramInt1 > 0)
    {
      localDrawable.setBounds(0, 0, paramInt1, paramInt1);
      paramCharSequence = localDrawable.getBounds();
    }
    if (paramFontMetricsInt != null)
    {
      paramPaint = paramPaint.getFontMetricsInt();
      paramInt2 = paramPaint.bottom;
      int i = paramPaint.top;
      paramInt1 = (paramCharSequence.bottom - paramCharSequence.top) / 2;
      i = (paramInt2 - i) / 4;
      paramInt2 = paramInt1 - i;
      paramInt1 = -(paramInt1 + i);
      paramFontMetricsInt.ascent = paramInt1;
      paramFontMetricsInt.top = paramInt1;
      paramFontMetricsInt.bottom = paramInt2;
      paramFontMetricsInt.descent = paramInt2;
    }
    return paramCharSequence.right;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletTips.CenterImageSpan
 * JD-Core Version:    0.7.0.1
 */