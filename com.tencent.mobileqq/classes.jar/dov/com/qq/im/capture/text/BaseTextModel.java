package dov.com.qq.im.capture.text;

import android.graphics.RectF;
import android.text.TextPaint;

public abstract class BaseTextModel
{
  protected int a;
  protected RectF a;
  protected TextPaint a;
  protected int b;
  
  public BaseTextModel(int paramInt1, int paramInt2, TextPaint paramTextPaint, RectF paramRectF)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidTextTextPaint = paramTextPaint;
    this.jdField_a_of_type_AndroidGraphicsRectF = paramRectF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.BaseTextModel
 * JD-Core Version:    0.7.0.1
 */