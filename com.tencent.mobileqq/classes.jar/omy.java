import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import org.jetbrains.annotations.NotNull;

class omy
  extends ReplacementSpan
{
  private omy(omt paramomt) {}
  
  private float a(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return paramPaint.measureText(paramCharSequence, paramInt1, paramInt2);
  }
  
  private TextPaint a(Paint paramPaint)
  {
    paramPaint = new TextPaint(paramPaint);
    paramPaint.setTextSize(bdoo.d(9.0F));
    return paramPaint;
  }
  
  public void draw(@NotNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NotNull Paint paramPaint)
  {
    paramPaint.setColor(Color.parseColor("#376099"));
    paramPaint.setTextSize(bdoo.b(9.0F));
    Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
    int i = localFontMetricsInt.bottom - localFontMetricsInt.top;
    Math.abs(localFontMetricsInt.leading);
    Math.abs(localFontMetricsInt.ascent);
    Math.abs(localFontMetricsInt.descent);
    paramPaint.setAntiAlias(true);
    RectF localRectF = new RectF();
    localRectF.left = ((int)paramFloat);
    int j = (paramInt5 - paramInt3 - localFontMetricsInt.descent + localFontMetricsInt.top) / 2;
    localRectF.top = (paramInt3 + j);
    localRectF.bottom = (paramInt5 - j);
    localRectF.right = (localRectF.left + (int)paramPaint.measureText(paramCharSequence, paramInt1, paramInt2));
    paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt4 - localFontMetricsInt.descent, paramPaint);
    omt.a(paramCanvas, paramPaint, (int)a(paramPaint, paramCharSequence, paramInt1, paramInt2), i, bdoo.b(1.0F), bdoo.b(1.0F), bdoo.b(1.0F), bdoo.b(1.0F), bdoo.b(1.0F), paramFloat, paramInt4 - i);
  }
  
  public int getSize(@NotNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
    return (int)a(paramPaint).measureText(paramCharSequence.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     omy
 * JD-Core Version:    0.7.0.1
 */