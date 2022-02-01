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
  private final TextPaint a;
  private CharSequence b = "";
  private ColorStateList c;
  private int d;
  private Rect e;
  private int f = 17;
  private float g;
  private float h;
  private boolean i;
  
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
    this.a = new TextPaint(1);
    this.a.density = paramContext.getDisplayMetrics().density;
    this.e = new Rect();
    this.i = true;
    this.a.setTypeface(Typeface.SANS_SERIF);
  }
  
  private void a()
  {
    int j = this.c.getColorForState(getDrawableState(), 0);
    if (j != this.d)
    {
      this.d = j;
      invalidate();
    }
  }
  
  private void setRawTextSize(float paramFloat)
  {
    if (paramFloat != this.a.getTextSize())
    {
      this.a.setTextSize(paramFloat);
      this.i = true;
      invalidate();
    }
  }
  
  public Paint getPaint()
  {
    return this.a;
  }
  
  public final CharSequence getText()
  {
    return this.b;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    String str = this.b.toString();
    int j = this.d;
    this.a.setColor(j);
    this.a.drawableState = getDrawableState();
    paramCanvas.save();
    paramCanvas.translate(getScrollX(), getScrollY());
    if (this.i)
    {
      this.a.getTextBounds(str, 0, str.length(), this.e);
      float f1 = Layout.getDesiredWidth(str, this.a);
      int n = getPaddingLeft();
      int i1 = getPaddingRight();
      j = getPaddingTop();
      int k = getPaddingBottom();
      int i2 = getWidth();
      int m = getHeight();
      int i3 = this.f & 0x7;
      this.g = n;
      if (i3 == 1) {
        this.g += (i2 - n - i1 - f1) / 2.0F;
      } else if (i3 == 5) {
        this.g += i2 - n - i1 - f1;
      }
      n = this.f & 0x70;
      Paint.FontMetricsInt localFontMetricsInt = this.a.getFontMetricsInt();
      i1 = localFontMetricsInt.descent - localFontMetricsInt.ascent;
      this.h = (i1 - localFontMetricsInt.descent + j);
      if (n == 16) {
        this.h += (m - k - j - i1) / 2;
      } else if (n == 80) {
        this.h += m - k - j - i1;
      }
      this.i = false;
    }
    paramCanvas.drawText(str, this.g, this.h, this.a);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = getMeasuredWidth();
    int m = getMeasuredHeight();
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int j;
    if (i1 != 1073741824)
    {
      j = (int)Math.ceil(Layout.getDesiredWidth(this.b, this.a)) + (getPaddingLeft() + getPaddingRight());
      if (i1 == -2147483648) {
        paramInt1 = Math.min(paramInt1, j);
      } else {
        paramInt1 = j;
      }
    }
    if (n != 1073741824)
    {
      j = this.a.getFontMetricsInt(null) + (getPaddingTop() + getPaddingBottom());
      if (n == -2147483648) {
        paramInt2 = Math.min(paramInt2, j);
      } else {
        paramInt2 = j;
      }
    }
    setMeasuredDimension(paramInt1, paramInt2);
    if ((m != paramInt2) || (k != paramInt1)) {
      this.i = true;
    }
  }
  
  public void setGravity(int paramInt)
  {
    if (this.f != paramInt)
    {
      this.f = paramInt;
      this.i = true;
      invalidate();
    }
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    CharSequence localCharSequence = this.b;
    if (localCharSequence != paramCharSequence)
    {
      if ((paramCharSequence == null) && ("".equals(localCharSequence))) {
        return;
      }
      this.b = paramCharSequence;
      if (this.b == null) {
        this.b = "";
      }
      requestLayout();
      invalidate();
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.c = ColorStateList.valueOf(paramInt);
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
    setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.rely.SimpleTextView
 * JD-Core Version:    0.7.0.1
 */