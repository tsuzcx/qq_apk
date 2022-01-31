package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;

public class IndexView
  extends View
{
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private IndexView.OnIndexChangedListener2 jdField_a_of_type_ComTencentMobileqqWidgetIndexView$OnIndexChangedListener2;
  private IndexView.OnIndexChangedListener jdField_a_of_type_ComTencentMobileqqWidgetIndexView$OnIndexChangedListener;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt;
  private boolean c;
  private boolean d;
  
  public IndexView(Context paramContext)
  {
    super(paramContext);
  }
  
  public IndexView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public IndexView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(int paramInt)
  {
    return View.MeasureSpec.getSize(paramInt);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    int i = 100;
    int j = 50;
    int k = getPaddingTop();
    int m = getPaddingBottom();
    while (paramInt1 < i)
    {
      j = (paramInt1 + i) / 2;
      if (b(j) <= paramInt2 - (k + m)) {
        paramInt1 = j + 1;
      } else {
        i = j - 1;
      }
    }
    return c(j) + getPaddingLeft() + getPaddingRight();
  }
  
  private static int a(int[] paramArrayOfInt)
  {
    int k = 0;
    int i = 0;
    if (paramArrayOfInt != null)
    {
      int m = paramArrayOfInt.length;
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        k = paramArrayOfInt[j];
        j += 1;
        i = k + i;
      }
    }
    return k;
  }
  
  private void a()
  {
    int j = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    Rect localRect = new Rect();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.getTextBounds(this.jdField_a_of_type_ArrayOfJavaLangString[i], 0, this.jdField_a_of_type_ArrayOfJavaLangString[i].length(), localRect);
      this.jdField_b_of_type_ArrayOfInt[i] = (localRect.right - localRect.left);
      this.jdField_a_of_type_ArrayOfInt[i] = (localRect.bottom - localRect.top);
      i += 1;
    }
  }
  
  private int b(int paramInt)
  {
    int j = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    localTextPaint.setTextSize(paramInt);
    localTextPaint.setAntiAlias(true);
    Rect localRect = new Rect();
    paramInt = 0;
    int i = 0;
    while (paramInt < j)
    {
      localTextPaint.getTextBounds(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt], 0, this.jdField_a_of_type_ArrayOfJavaLangString[paramInt].length(), localRect);
      int k = localRect.bottom - localRect.top;
      i = i + k + (int)(k * 0.8F);
      paramInt += 1;
    }
    return i;
  }
  
  private int c(int paramInt)
  {
    int j = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    localTextPaint.setTextSize(paramInt);
    localTextPaint.setAntiAlias(true);
    Rect localRect = new Rect();
    paramInt = 0;
    int i = 0;
    while (paramInt < j)
    {
      localTextPaint.getTextBounds(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt], 0, this.jdField_a_of_type_ArrayOfJavaLangString[paramInt].length(), localRect);
      i = Math.max(i, localRect.right - localRect.left);
      paramInt += 1;
    }
    return i;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int m = 1;
    super.onDraw(paramCanvas);
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    int j = getWidth() - getPaddingLeft() - getPaddingRight();
    int n = getPaddingLeft();
    int i2 = getPaddingTop();
    int i = getPaddingBottom();
    i = getHeight() - i2 - i;
    int k = a(this.jdField_a_of_type_ArrayOfInt);
    if (i > k) {}
    for (float f2 = (i - k) * 1.0F / (this.jdField_a_of_type_ArrayOfJavaLangString.length - 1);; f2 = 0.0F)
    {
      float f3 = i2;
      int i1 = this.jdField_a_of_type_ArrayOfJavaLangString.length;
      float f1;
      float f4;
      if (!this.jdField_a_of_type_Boolean)
      {
        localTextPaint.setColor(Color.rgb(119, 119, 119));
        f1 = f3;
        if (this.jdField_b_of_type_Boolean)
        {
          f1 = this.jdField_a_of_type_ArrayOfInt[0];
          f4 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() * 1.0F / this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
          if (f4 < j * 1.0F / this.jdField_a_of_type_ArrayOfInt[0]) {
            break label406;
          }
          i = (int)(j / f4);
          k = j;
          label198:
          this.jdField_a_of_type_AndroidGraphicsRect.left = ((j - k) / 2 + n);
          this.jdField_a_of_type_AndroidGraphicsRect.top = (i2 + (this.jdField_a_of_type_ArrayOfInt[0] - i) / 2);
          this.jdField_a_of_type_AndroidGraphicsRect.right = (k + this.jdField_a_of_type_AndroidGraphicsRect.left);
          this.jdField_a_of_type_AndroidGraphicsRect.bottom = (i + this.jdField_a_of_type_AndroidGraphicsRect.top);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
          f1 = f3 + f1 + f2;
        }
        if (!this.c) {
          break label683;
        }
        if (!this.d) {
          break label771;
        }
      }
      label771:
      for (k = i1 - 2;; k = i1 - 1)
      {
        if (this.jdField_b_of_type_Boolean) {
          i = 1;
        }
        String str;
        for (;;)
        {
          if (i >= k) {
            break label432;
          }
          f1 += this.jdField_a_of_type_ArrayOfInt[i];
          str = this.jdField_a_of_type_ArrayOfJavaLangString[i];
          paramCanvas.drawText(str, 0, str.length(), (j - this.jdField_b_of_type_ArrayOfInt[i]) / 2 + n, f1, localTextPaint);
          f1 += f2;
          i += 1;
          continue;
          localTextPaint.setColor(-1);
          break;
          label406:
          i = this.jdField_a_of_type_ArrayOfInt[0];
          k = (int)(f4 * i);
          break label198;
          i = 0;
        }
        label432:
        i1 = (int)f1;
        f3 = this.jdField_a_of_type_ArrayOfInt[k];
        f4 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() * 1.0F / this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
        if (f4 >= j * 1.0F / this.jdField_a_of_type_ArrayOfInt[k])
        {
          i = (int)(j / f4);
          m = j;
          this.jdField_b_of_type_AndroidGraphicsRect.left = ((j - m) / 2 + n);
          this.jdField_b_of_type_AndroidGraphicsRect.top = (i1 + (this.jdField_a_of_type_ArrayOfInt[k] - i) / 2);
          this.jdField_b_of_type_AndroidGraphicsRect.right = (m + this.jdField_b_of_type_AndroidGraphicsRect.left);
          this.jdField_b_of_type_AndroidGraphicsRect.bottom = (i + this.jdField_b_of_type_AndroidGraphicsRect.top);
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_b_of_type_AndroidGraphicsRect);
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
          if (this.d)
          {
            f1 = f1 + f3 + f2 + this.jdField_a_of_type_ArrayOfInt[(k + 1)];
            str = this.jdField_a_of_type_ArrayOfJavaLangString[(k + 1)];
            paramCanvas.drawText(str, 0, str.length(), (j - this.jdField_b_of_type_ArrayOfInt[(k + 1)]) / 2 + n, f1, localTextPaint);
          }
        }
        for (;;)
        {
          return;
          i = this.jdField_a_of_type_ArrayOfInt[k];
          m = (int)(f4 * i);
          break;
          label683:
          if (this.jdField_b_of_type_Boolean) {
            i = m;
          }
          while (i < i1)
          {
            f1 += this.jdField_a_of_type_ArrayOfInt[i];
            str = this.jdField_a_of_type_ArrayOfJavaLangString[i];
            paramCanvas.drawText(str, 0, str.length(), (j - this.jdField_b_of_type_ArrayOfInt[i]) / 2 + n, f1, localTextPaint);
            f1 += f2;
            i += 1;
            continue;
            i = 0;
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = a(paramInt2);
    paramInt2 = a(paramInt1, i);
    int j = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (j == -2147483648) {
      paramInt1 = Math.min(paramInt2, paramInt1);
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, i);
      return;
      if (j != 1073741824) {
        paramInt1 = paramInt2;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int k = paramMotionEvent.getAction();
    int[] arrayOfInt;
    float f2;
    int i;
    int j;
    if (k == 0)
    {
      this.jdField_a_of_type_Boolean = true;
      arrayOfInt = new int[1];
      arrayOfInt[0] = 16842919;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.invalidateSelf();
      }
      if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.invalidateSelf();
      }
      getBackground().setState(arrayOfInt);
      getBackground().invalidateSelf();
      if ((k != 0) && (k != 2) && (k != 1)) {
        break label389;
      }
      f2 = paramMotionEvent.getY();
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView$OnIndexChangedListener == null) || (f2 < 0.0F)) {
        break label383;
      }
      i = getHeight() - getPaddingTop() - getPaddingBottom();
      j = a(this.jdField_a_of_type_ArrayOfInt);
      if (i <= j) {
        break label397;
      }
    }
    label389:
    label397:
    for (float f1 = (i - j) * 1.0F / (this.jdField_a_of_type_ArrayOfJavaLangString.length - 1);; f1 = 0.0F)
    {
      j = -1;
      for (;;)
      {
        i = j;
        if (f2 < 0.0F) {
          break;
        }
        j += 1;
        i = j;
        if (j >= this.jdField_a_of_type_ArrayOfInt.length) {
          break;
        }
        f2 -= this.jdField_a_of_type_ArrayOfInt[j] + f1;
      }
      if ((k != 3) && (k != 1)) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
      arrayOfInt = new int[0];
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.invalidateSelf();
      }
      if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.invalidateSelf();
      }
      getBackground().setState(arrayOfInt);
      getBackground().invalidateSelf();
      break;
      j = i;
      if (i >= this.jdField_a_of_type_ArrayOfInt.length) {
        j = this.jdField_a_of_type_ArrayOfInt.length - 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView$OnIndexChangedListener.b(this.jdField_a_of_type_ArrayOfJavaLangString[j]);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView$OnIndexChangedListener2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView$OnIndexChangedListener2.a(this.jdField_a_of_type_ArrayOfJavaLangString[j], k);
      }
      label383:
      bool = true;
      do
      {
        return bool;
      } while (k != 3);
      return true;
    }
  }
  
  public void setIndex(String[] paramArrayOfString)
  {
    if ("$".equals(paramArrayOfString[0]))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839235);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    if (this.c)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839234);
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_ArrayOfInt = new int[paramArrayOfString.length];
    this.jdField_b_of_type_ArrayOfInt = new int[paramArrayOfString.length];
  }
  
  public void setIndex(String[] paramArrayOfString, boolean paramBoolean)
  {
    int i = 0;
    String[] arrayOfString = paramArrayOfString;
    if (paramBoolean)
    {
      arrayOfString = new String[paramArrayOfString.length + 1];
      arrayOfString[0] = "$";
      while (i < paramArrayOfString.length)
      {
        arrayOfString[(i + 1)] = paramArrayOfString[i];
        i += 1;
      }
    }
    setIndex(arrayOfString);
  }
  
  public void setIndex(String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    String[] arrayOfString = paramArrayOfString;
    if (paramBoolean1)
    {
      this.c = paramBoolean2;
      this.d = paramBoolean3;
      if ((!paramBoolean2) || (!paramBoolean3)) {
        break label103;
      }
      arrayOfString = new String[paramArrayOfString.length + 3];
      arrayOfString[0] = "$";
      while (i < paramArrayOfString.length)
      {
        arrayOfString[(i + 1)] = paramArrayOfString[i];
        i += 1;
      }
      arrayOfString[(i + 1)] = "&";
      arrayOfString[(i + 2)] = "+";
    }
    for (;;)
    {
      setIndex(arrayOfString);
      return;
      label103:
      if ((paramBoolean2) || (paramBoolean3))
      {
        arrayOfString = new String[paramArrayOfString.length + 2];
        arrayOfString[0] = "$";
        i = j;
        while (i < paramArrayOfString.length)
        {
          arrayOfString[(i + 1)] = paramArrayOfString[i];
          i += 1;
        }
        if (paramBoolean2) {
          arrayOfString[(i + 1)] = "&";
        }
        for (;;)
        {
          break;
          arrayOfString[(i + 1)] = "+";
        }
      }
      arrayOfString = new String[paramArrayOfString.length + 1];
      arrayOfString[0] = "$";
      i = k;
      while (i < paramArrayOfString.length)
      {
        arrayOfString[(i + 1)] = paramArrayOfString[i];
        i += 1;
      }
    }
  }
  
  public void setOnIndexChangedListener(IndexView.OnIndexChangedListener paramOnIndexChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView$OnIndexChangedListener = paramOnIndexChangedListener;
  }
  
  public void setOnIndexChangedListener2(IndexView.OnIndexChangedListener2 paramOnIndexChangedListener2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView$OnIndexChangedListener2 = paramOnIndexChangedListener2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.widget.IndexView
 * JD-Core Version:    0.7.0.1
 */