import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.text.TextPaint;

public class ljr
  extends lji
{
  TextPaint a;
  
  public ljr(lhc paramlhc, boolean paramBoolean)
  {
    super(paramlhc, paramBoolean);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setStrokeWidth(4.0F);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int * 16;
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int k = this.jdField_a_of_type_Int - 8;
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(k);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFlags(1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(k);
    this.jdField_a_of_type_AndroidTextTextPaint.setFlags(1);
    lcg.c("ARZimuTask_SpitZimuItemTask", "onDraw width = " + paramInt1);
    float f = -this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics().ascent;
    String str2 = this.jdField_a_of_type_Lhc.a.toString();
    String str1 = str2;
    if (str2.length() > 10) {
      str1 = str2.substring(str2.length() - 10);
    }
    str2 = ljo.a(str1);
    int j = str1.length();
    str1 = str1 + str2;
    lcg.c("ARZimuTask_SpitZimuItemTask", "onDraw showText = " + str1);
    paramInt2 = str1.length();
    paramInt1 = paramInt2;
    if (paramInt2 > 13) {
      paramInt1 = 13;
    }
    int i = 2;
    k -= 6;
    paramInt2 = 0;
    while (paramInt2 < paramInt1)
    {
      if (paramInt2 >= j)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(k);
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(k);
      }
      str2 = str1.substring(paramInt2, paramInt2 + 1);
      ljo.a(this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidTextTextPaint);
      paramCanvas.drawText(str2, i, f, this.jdField_a_of_type_AndroidTextTextPaint);
      paramCanvas.drawText(str2, i, f, this.jdField_a_of_type_AndroidGraphicsPaint);
      i += this.jdField_a_of_type_Int;
      paramInt2 += 1;
    }
    lcg.c("ARZimuTask_SpitZimuItemTask", "onDraw offsetX = " + i);
  }
  
  public void a(Typeface paramTypeface, int paramInt, mnw parammnw)
  {
    super.a(paramTypeface, paramInt, parammnw);
    if (paramTypeface != null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ljr
 * JD-Core Version:    0.7.0.1
 */