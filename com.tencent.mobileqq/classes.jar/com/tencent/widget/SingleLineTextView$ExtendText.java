package com.tencent.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import bcdb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableColorStateList;
import java.lang.reflect.Method;
import java.util.Arrays;

class SingleLineTextView$ExtendText
{
  private static boolean mColorStateListErrorReported;
  int mCurTextColor;
  int mDesiredTextHeight;
  int mDesiredTextWidth;
  boolean mEmpty;
  private Paint.FontMetrics mFM;
  private Method mGetColorStateListMethod;
  int mPadding;
  String mText;
  ColorStateList mTextColor;
  final TextPaint mTextPaint = new TextPaint(1);
  float mTextSize;
  
  SingleLineTextView$ExtendText(Resources paramResources)
  {
    this.mTextPaint.setTypeface(Typeface.SANS_SERIF);
    this.mTextPaint.density = paramResources.getDisplayMetrics().density;
    this.mPadding = 0;
    this.mTextColor = ColorStateList.valueOf(-7829368);
    this.mCurTextColor = this.mTextColor.getDefaultColor();
    reset();
  }
  
  public void draw(Canvas paramCanvas, int[] paramArrayOfInt, float paramFloat1, float paramFloat2)
  {
    if (paramCanvas != null)
    {
      this.mTextPaint.setColor(this.mCurTextColor);
      this.mTextPaint.drawableState = paramArrayOfInt;
      paramCanvas.drawText(this.mText, paramFloat1, paramFloat2, this.mTextPaint);
    }
  }
  
  public int getDesiredHeight()
  {
    if (this.mEmpty) {
      return 0;
    }
    if (this.mDesiredTextHeight < 0) {
      this.mDesiredTextHeight = Math.round(this.mTextPaint.getFontMetricsInt(null));
    }
    return this.mDesiredTextHeight;
  }
  
  public int getDesiredWith()
  {
    if (this.mEmpty) {
      return 0;
    }
    if (this.mDesiredTextWidth < 0) {
      this.mDesiredTextWidth = ((int)Math.ceil(Layout.getDesiredWidth(this.mText, this.mTextPaint)));
    }
    return this.mDesiredTextWidth;
  }
  
  public Paint.FontMetrics getFontMetrics()
  {
    if (this.mFM == null) {
      this.mFM = this.mTextPaint.getFontMetrics();
    }
    return this.mFM;
  }
  
  public void reset()
  {
    this.mEmpty = true;
    this.mText = "";
    this.mDesiredTextWidth = 0;
    this.mPadding = 0;
  }
  
  public boolean setTextColor(ColorStateList paramColorStateList, int[] paramArrayOfInt)
  {
    if (paramColorStateList == null) {
      return false;
    }
    this.mTextColor = paramColorStateList;
    return updateTextColors(paramArrayOfInt);
  }
  
  public boolean setTextSize(float paramFloat, Context paramContext)
  {
    if (Math.abs(this.mTextSize - paramFloat) > 0.01F)
    {
      this.mTextSize = paramFloat;
      if (paramContext == null) {}
      for (paramContext = Resources.getSystem();; paramContext = paramContext.getResources())
      {
        paramFloat = TypedValue.applyDimension(1, paramFloat, paramContext.getDisplayMetrics());
        if (paramFloat == this.mTextPaint.getTextSize()) {
          break;
        }
        this.mTextPaint.setTextSize(paramFloat);
        this.mDesiredTextWidth = -1;
        this.mDesiredTextHeight = -1;
        this.mFM = null;
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    if (this.mText == null) {
      return "";
    }
    return this.mText;
  }
  
  public boolean updateTextColors(int[] paramArrayOfInt)
  {
    int j = this.mTextColor.getColorForState(paramArrayOfInt, 0);
    int i;
    if (j == 0) {
      if (this.mGetColorStateListMethod == null)
      {
        try
        {
          this.mGetColorStateListMethod = SkinnableColorStateList.class.getMethod("getColorForState", new Class[] { [I.class, Integer.TYPE });
          i = 0;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          for (;;)
          {
            label94:
            String str;
            localNoSuchMethodException.printStackTrace();
            i = 1;
          }
        }
        try
        {
          k = ((Integer)this.mGetColorStateListMethod.invoke(this.mTextColor, new Object[] { paramArrayOfInt, Integer.valueOf(0) })).intValue();
          j = k;
          k = i;
          i = j;
          j = k;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          k = 1;
          i = j;
          j = k;
          break label94;
        }
        k = i;
        if (!mColorStateListErrorReported)
        {
          k = i;
          if (j != 0)
          {
            str = "get color from state list fail, state is " + Arrays.toString(paramArrayOfInt) + " but the state list is " + this.mTextColor + " curTs: " + SystemClock.uptimeMillis();
            str = str + " colorFromReflect: " + i;
            QLog.e("SingleLineTextView", 1, str);
            bcdb.a(new IllegalStateException(str), str);
            mColorStateListErrorReported = true;
          }
        }
      }
    }
    for (int k = i;; k = j)
    {
      if ((this.mTextColor instanceof SkinnableColorStateList)) {
        ((SkinnableColorStateList)this.mTextColor).reset();
      }
      if (k != this.mCurTextColor)
      {
        this.mCurTextColor = k;
        this.mTextPaint.setColor(this.mCurTextColor);
        this.mTextPaint.drawableState = paramArrayOfInt;
        return true;
      }
      return false;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.SingleLineTextView.ExtendText
 * JD-Core Version:    0.7.0.1
 */