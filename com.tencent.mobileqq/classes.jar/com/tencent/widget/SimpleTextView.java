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
  private int mCurTextColor;
  private int mGravity = 17;
  private boolean mNeedCompute;
  private CharSequence mText = "";
  private Rect mTextBounds;
  private ColorStateList mTextColor;
  private final TextPaint mTextPaint;
  private float mX;
  private float mY;
  
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
    this.mTextPaint = new TextPaint(1);
    this.mTextPaint.density = paramContext.getDisplayMetrics().density;
    this.mTextBounds = new Rect();
    this.mNeedCompute = true;
    this.mTextPaint.setTypeface(Typeface.SANS_SERIF);
  }
  
  private void setRawTextSize(float paramFloat)
  {
    if (paramFloat != this.mTextPaint.getTextSize())
    {
      this.mTextPaint.setTextSize(paramFloat);
      this.mNeedCompute = true;
      invalidate();
    }
  }
  
  private void updateTextColors()
  {
    int i = this.mTextColor.getColorForState(getDrawableState(), 0);
    if (i != this.mCurTextColor)
    {
      this.mCurTextColor = i;
      invalidate();
    }
  }
  
  public Paint getPaint()
  {
    return this.mTextPaint;
  }
  
  public final CharSequence getText()
  {
    return this.mText;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    String str = this.mText.toString();
    int i = this.mCurTextColor;
    this.mTextPaint.setColor(i);
    this.mTextPaint.drawableState = getDrawableState();
    paramCanvas.save();
    paramCanvas.translate(getScrollX(), getScrollY());
    if (this.mNeedCompute)
    {
      this.mTextPaint.getTextBounds(str, 0, str.length(), this.mTextBounds);
      float f = Layout.getDesiredWidth(str, this.mTextPaint);
      int m = getPaddingLeft();
      int n = getPaddingRight();
      i = getPaddingTop();
      int j = getPaddingBottom();
      int i1 = getWidth();
      int k = getHeight();
      int i2 = this.mGravity & 0x7;
      this.mX = m;
      if (i2 == 1) {
        this.mX += (i1 - m - n - f) / 2.0F;
      } else if (i2 == 5) {
        this.mX += i1 - m - n - f;
      }
      m = this.mGravity & 0x70;
      Paint.FontMetricsInt localFontMetricsInt = this.mTextPaint.getFontMetricsInt();
      n = localFontMetricsInt.descent - localFontMetricsInt.ascent;
      this.mY = (n - localFontMetricsInt.descent + i);
      if (m == 16) {
        this.mY += (k - j - i - n) / 2;
      } else if (m == 80) {
        this.mY += k - j - i - n;
      }
      this.mNeedCompute = false;
    }
    paramCanvas.drawText(str, this.mX, this.mY, this.mTextPaint);
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
      i = (int)Math.ceil(Layout.getDesiredWidth(this.mText, this.mTextPaint)) + (getPaddingLeft() + getPaddingRight());
      if (n == -2147483648) {
        paramInt1 = Math.min(paramInt1, i);
      } else {
        paramInt1 = i;
      }
    }
    if (m != 1073741824)
    {
      i = this.mTextPaint.getFontMetricsInt(null) + (getPaddingTop() + getPaddingBottom());
      if (m == -2147483648) {
        paramInt2 = Math.min(paramInt2, i);
      } else {
        paramInt2 = i;
      }
    }
    setMeasuredDimension(paramInt1, paramInt2);
    if ((k != paramInt2) || (j != paramInt1)) {
      this.mNeedCompute = true;
    }
  }
  
  public void setGravity(int paramInt)
  {
    if (this.mGravity != paramInt)
    {
      this.mGravity = paramInt;
      this.mNeedCompute = true;
      invalidate();
    }
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    CharSequence localCharSequence = this.mText;
    if (localCharSequence != paramCharSequence)
    {
      if ((paramCharSequence == null) && ("".equals(localCharSequence))) {
        return;
      }
      this.mText = paramCharSequence;
      if (this.mText == null) {
        this.mText = "";
      }
      requestLayout();
      invalidate();
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextColor = ColorStateList.valueOf(paramInt);
    updateTextColors();
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
 * Qualified Name:     com.tencent.widget.SimpleTextView
 * JD-Core Version:    0.7.0.1
 */