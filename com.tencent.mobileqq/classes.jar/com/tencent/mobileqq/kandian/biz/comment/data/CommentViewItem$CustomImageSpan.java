package com.tencent.mobileqq.kandian.biz.comment.data;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

class CommentViewItem$CustomImageSpan
  extends ImageSpan
{
  private int b;
  private int c;
  
  public CommentViewItem$CustomImageSpan(CommentViewItem paramCommentViewItem, Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramContext.getApplicationContext(), paramInt1, paramInt2);
    this.c = paramInt4;
    this.b = paramInt3;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    if ((this.b > 0) && (this.c > 0))
    {
      Rect localRect = new Rect();
      localRect.left = 0;
      localRect.right = this.b;
      localRect.top = 0;
      localRect.bottom = this.c;
      paramCharSequence.setBounds(localRect);
    }
    paramCanvas.save();
    paramPaint = paramPaint.getFontMetricsInt();
    paramInt1 = paramInt5 - paramCharSequence.getBounds().bottom;
    if (this.mVerticalAlignment == 1) {
      paramInt1 -= paramPaint.descent;
    } else if (this.mVerticalAlignment == 2) {
      paramInt1 = (paramPaint.descent + paramInt4 + (paramInt4 + paramPaint.ascent)) / 2 - paramCharSequence.getBounds().bottom / 2;
    }
    paramCanvas.translate(paramFloat, paramInt1);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = getDrawable().getBounds();
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
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem.CustomImageSpan
 * JD-Core Version:    0.7.0.1
 */