package com.tencent.mobileqq.rely;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.theme.ISkinTypeface;

public class SimpleTextView
  extends View
  implements ISkinTypeface
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private final TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 17;
  
  public SimpleTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SimpleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SimpleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getResources();
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
    this.jdField_a_of_type_AndroidTextTextPaint.density = paramContext.getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.SANS_SERIF);
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(getDrawableState(), 0);
    if (i != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = i;
      invalidate();
    }
  }
  
  private void a(float paramFloat)
  {
    if (paramFloat != this.jdField_a_of_type_AndroidTextTextPaint.getTextSize())
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
      this.jdField_a_of_type_Boolean = true;
      invalidate();
    }
  }
  
  public Paint getPaint()
  {
    return this.jdField_a_of_type_AndroidTextTextPaint;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    String str = this.jdField_a_of_type_JavaLangCharSequence.toString();
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(i);
    this.jdField_a_of_type_AndroidTextTextPaint.drawableState = getDrawableState();
    paramCanvas.save();
    paramCanvas.translate(getScrollX(), getScrollY());
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.getTextBounds(str, 0, str.length(), this.jdField_a_of_type_AndroidGraphicsRect);
      float f = Layout.getDesiredWidth(str, this.jdField_a_of_type_AndroidTextTextPaint);
      int m = getPaddingLeft();
      int n = getPaddingRight();
      i = getPaddingTop();
      int j = getPaddingBottom();
      int i1 = getWidth();
      int k = getHeight();
      int i2 = this.jdField_b_of_type_Int & 0x7;
      this.jdField_a_of_type_Float = m;
      if (i2 == 1) {
        this.jdField_a_of_type_Float += (i1 - m - n - f) / 2.0F;
      } else if (i2 == 5) {
        this.jdField_a_of_type_Float += i1 - m - n - f;
      }
      m = this.jdField_b_of_type_Int & 0x70;
      Paint.FontMetricsInt localFontMetricsInt = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt();
      n = localFontMetricsInt.descent - localFontMetricsInt.ascent;
      this.jdField_b_of_type_Float = (n - localFontMetricsInt.descent + i);
      if (m == 16) {
        this.jdField_b_of_type_Float += (k - j - i - n) / 2;
      } else if (m == 80) {
        this.jdField_b_of_type_Float += k - j - i - n;
      }
      this.jdField_a_of_type_Boolean = false;
    }
    paramCanvas.drawText(str, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidTextTextPaint);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getMeasuredWidth();
    int k = getMeasuredHeight();
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int i;
    if (n != 1073741824)
    {
      i = (int)Math.ceil(Layout.getDesiredWidth(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint)) + (getPaddingLeft() + getPaddingRight());
      if (n == -2147483648) {
        paramInt1 = Math.min(paramInt1, i);
      } else {
        paramInt1 = i;
      }
    }
    if (m != 1073741824)
    {
      i = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt(null) + (getPaddingTop() + getPaddingBottom());
      if (m == -2147483648) {
        paramInt2 = Math.min(paramInt2, i);
      } else {
        paramInt2 = i;
      }
    }
    setMeasuredDimension(paramInt1, paramInt2);
    if ((k != paramInt2) || (j != paramInt1)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void setGravity(int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt)
    {
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_Boolean = true;
      invalidate();
    }
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    CharSequence localCharSequence = this.jdField_a_of_type_JavaLangCharSequence;
    if (localCharSequence != paramCharSequence)
    {
      if ((paramCharSequence == null) && ("".equals(localCharSequence))) {
        return;
      }
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
      if (this.jdField_a_of_type_JavaLangCharSequence == null) {
        this.jdField_a_of_type_JavaLangCharSequence = "";
      }
      requestLayout();
      invalidate();
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(paramInt);
    a();
  }
  
  public void setTextSize(float paramFloat)
  {
    setTextSize(2, paramFloat);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {
      localObject = Resources.getSystem();
    } else {
      localObject = ((Context)localObject).getResources();
    }
    a(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.rely.SimpleTextView
 * JD-Core Version:    0.7.0.1
 */