import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

class pbd
  extends ImageSpan
{
  private int jdField_a_of_type_Int = 2;
  private int b;
  private int c;
  
  public pbd(pay parampay, Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramContext, paramInt1, paramInt2);
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
    }
    for (;;)
    {
      paramCanvas.translate(paramFloat, paramInt1);
      paramCharSequence.draw(paramCanvas);
      paramCanvas.restore();
      return;
      if (this.mVerticalAlignment == this.jdField_a_of_type_Int) {
        paramInt1 = (paramPaint.descent + paramInt4 + (paramPaint.ascent + paramInt4)) / 2 - paramCharSequence.getBounds().bottom / 2;
      }
    }
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = getDrawable().getBounds();
    if (paramFontMetricsInt != null)
    {
      paramPaint = paramPaint.getFontMetricsInt();
      paramInt2 = paramPaint.bottom - paramPaint.top;
      int i = paramCharSequence.bottom - paramCharSequence.top;
      paramInt1 = i / 2 - paramInt2 / 4;
      paramInt2 = i / 2 + paramInt2 / 4;
      paramFontMetricsInt.ascent = (-paramInt2);
      paramFontMetricsInt.top = (-paramInt2);
      paramFontMetricsInt.bottom = paramInt1;
      paramFontMetricsInt.descent = paramInt1;
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pbd
 * JD-Core Version:    0.7.0.1
 */