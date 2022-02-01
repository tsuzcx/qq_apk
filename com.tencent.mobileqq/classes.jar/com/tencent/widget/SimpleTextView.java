package com.tencent.widget;

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
  
  public final CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
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
    float f1;
    int m;
    int n;
    int j;
    int i1;
    int k;
    int i2;
    float f2;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.getTextBounds(str, 0, str.length(), this.jdField_a_of_type_AndroidGraphicsRect);
      f1 = Layout.getDesiredWidth(str, this.jdField_a_of_type_AndroidTextTextPaint);
      m = getPaddingLeft();
      n = getPaddingRight();
      i = getPaddingTop();
      j = getPaddingBottom();
      i1 = getWidth();
      k = getHeight();
      i2 = this.jdField_b_of_type_Int & 0x7;
      this.jdField_a_of_type_Float = m;
      if (i2 != 1) {
        break label284;
      }
      f2 = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_Float = ((i1 - m - n - f1) / 2.0F + f2);
      m = this.jdField_b_of_type_Int & 0x70;
      Paint.FontMetricsInt localFontMetricsInt = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt();
      n = localFontMetricsInt.descent - localFontMetricsInt.ascent;
      this.jdField_b_of_type_Float = (n - localFontMetricsInt.descent + i);
      if (m != 16) {
        break label315;
      }
      this.jdField_b_of_type_Float += (k - j - i - n) / 2;
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      paramCanvas.drawText(str, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidTextTextPaint);
      paramCanvas.restore();
      return;
      label284:
      if (i2 != 5) {
        break;
      }
      f2 = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_Float = (i1 - m - n - f1 + f2);
      break;
      label315:
      if (m == 80) {
        this.jdField_b_of_type_Float += k - j - i - n;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = getMeasuredWidth();
    int m = getMeasuredHeight();
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i1 == 1073741824)
    {
      paramInt1 = i;
      if (n != 1073741824) {
        break label122;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      if ((m != paramInt2) || (k != paramInt1)) {
        this.jdField_a_of_type_Boolean = true;
      }
      return;
      int j = (int)Math.ceil(Layout.getDesiredWidth(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint)) + (getPaddingLeft() + getPaddingRight());
      paramInt1 = j;
      if (i1 != -2147483648) {
        break;
      }
      paramInt1 = Math.min(i, j);
      break;
      label122:
      i = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt(null) + (getPaddingTop() + getPaddingBottom());
      if (n == -2147483648) {
        paramInt2 = Math.min(paramInt2, i);
      } else {
        paramInt2 = i;
      }
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
    if ((this.jdField_a_of_type_JavaLangCharSequence == paramCharSequence) || ((paramCharSequence == null) && ("".equals(this.jdField_a_of_type_JavaLangCharSequence)))) {
      return;
    }
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    if (this.jdField_a_of_type_JavaLangCharSequence == null) {
      this.jdField_a_of_type_JavaLangCharSequence = "";
    }
    requestLayout();
    invalidate();
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
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      a(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.SimpleTextView
 * JD-Core Version:    0.7.0.1
 */