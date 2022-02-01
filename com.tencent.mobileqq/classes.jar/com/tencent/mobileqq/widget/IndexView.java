package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.qphone.base.util.QLog;

public class IndexView
  extends View
{
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private IndexView.OnIndexChangedListener2 jdField_a_of_type_ComTencentMobileqqWidgetIndexView$OnIndexChangedListener2 = null;
  private IndexView.OnIndexChangedListener jdField_a_of_type_ComTencentMobileqqWidgetIndexView$OnIndexChangedListener = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt;
  private boolean c = false;
  private boolean d = false;
  
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
    int k = getPaddingTop();
    int m = getPaddingBottom();
    paramInt1 = 1;
    int i = 100;
    int j = 50;
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
    int i = 0;
    int j = 0;
    if (paramArrayOfInt != null)
    {
      int k = paramArrayOfInt.length;
      i = 0;
      while (j < k)
      {
        i += paramArrayOfInt[j];
        j += 1;
      }
    }
    return i;
  }
  
  private void a()
  {
    int j = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    Rect localRect = new Rect();
    int i = 0;
    while (i < j)
    {
      TextPaint localTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
      String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      localTextPaint.getTextBounds(arrayOfString[i], 0, arrayOfString[i].length(), localRect);
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
      String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      localTextPaint.getTextBounds(arrayOfString[paramInt], 0, arrayOfString[paramInt].length(), localRect);
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
      String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      localTextPaint.getTextBounds(arrayOfString[paramInt], 0, arrayOfString[paramInt].length(), localRect);
      i = Math.max(i, localRect.right - localRect.left);
      paramInt += 1;
    }
    return i;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int j = a(paramInt2);
    paramInt2 = a(paramInt1, j);
    int k = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    if (k == -2147483648)
    {
      paramInt1 = Math.min(paramInt2, i);
    }
    else
    {
      paramInt1 = paramInt2;
      if (k == 1073741824) {
        paramInt1 = i;
      }
    }
    setMeasuredDimension(paramInt1, j);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    int[] arrayOfInt;
    Drawable localDrawable;
    if (k == 0)
    {
      this.jdField_a_of_type_Boolean = true;
      arrayOfInt = new int[1];
      arrayOfInt[0] = 16842919;
      localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localDrawable != null)
      {
        localDrawable.setState(arrayOfInt);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.invalidateSelf();
      }
      localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      if (localDrawable != null)
      {
        localDrawable.setState(arrayOfInt);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.invalidateSelf();
      }
      localDrawable = getBackground();
      if (localDrawable != null)
      {
        localDrawable.setState(arrayOfInt);
        localDrawable.invalidateSelf();
      }
      else
      {
        QLog.e("IndexView", 1, "getBackground: failed. ");
      }
    }
    else if ((k == 3) || (k == 1))
    {
      this.jdField_a_of_type_Boolean = false;
      arrayOfInt = new int[0];
      localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localDrawable != null)
      {
        localDrawable.setState(arrayOfInt);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.invalidateSelf();
      }
      localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      if (localDrawable != null)
      {
        localDrawable.setState(arrayOfInt);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.invalidateSelf();
      }
      localDrawable = getBackground();
      if (localDrawable != null)
      {
        localDrawable.setState(arrayOfInt);
        localDrawable.invalidateSelf();
      }
      else
      {
        QLog.e("IndexView", 1, "getBackground: failed. ");
      }
    }
    if ((k != 0) && (k != 2) && (k != 1)) {
      return k == 3;
    }
    float f2 = paramMotionEvent.getY();
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView$OnIndexChangedListener != null) && (f2 >= 0.0F))
    {
      int i = getHeight() - getPaddingTop() - getPaddingBottom();
      int j = a(this.jdField_a_of_type_ArrayOfInt);
      float f1;
      if (i > j) {
        f1 = (i - j) * 1.0F / (this.jdField_a_of_type_ArrayOfJavaLangString.length - 1);
      } else {
        f1 = 0.0F;
      }
      j = -1;
      for (;;)
      {
        i = j;
        if (f2 < 0.0F) {
          break;
        }
        j += 1;
        paramMotionEvent = this.jdField_a_of_type_ArrayOfInt;
        i = j;
        if (j >= paramMotionEvent.length) {
          break;
        }
        f2 -= paramMotionEvent[j] + f1;
      }
      paramMotionEvent = this.jdField_a_of_type_ArrayOfInt;
      j = i;
      if (i >= paramMotionEvent.length) {
        j = paramMotionEvent.length - 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView$OnIndexChangedListener.onIndexChanged(this.jdField_a_of_type_ArrayOfJavaLangString[j]);
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView$OnIndexChangedListener2;
      if (paramMotionEvent != null) {
        paramMotionEvent.onIndexChanged(this.jdField_a_of_type_ArrayOfJavaLangString[j], k);
      }
    }
    return true;
  }
  
  public void setIndex(String[] paramArrayOfString)
  {
    if ("$".equals(paramArrayOfString[0]))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840500);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    if (this.c)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840499);
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_ArrayOfInt = new int[paramArrayOfString.length];
    this.jdField_b_of_type_ArrayOfInt = new int[paramArrayOfString.length];
  }
  
  public void setIndex(String[] paramArrayOfString, boolean paramBoolean)
  {
    String[] arrayOfString = paramArrayOfString;
    if (paramBoolean)
    {
      arrayOfString = new String[paramArrayOfString.length + 1];
      int i = 0;
      arrayOfString[0] = "$";
      while (i < paramArrayOfString.length)
      {
        int j = i + 1;
        arrayOfString[j] = paramArrayOfString[i];
        i = j;
      }
    }
    setIndex(arrayOfString);
  }
  
  public void setIndex(String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    String[] arrayOfString = paramArrayOfString;
    if (paramBoolean1)
    {
      this.c = paramBoolean2;
      this.d = paramBoolean3;
      int j = 0;
      int k = 0;
      int i = 0;
      if ((paramBoolean2) && (paramBoolean3))
      {
        arrayOfString = new String[paramArrayOfString.length + 3];
        arrayOfString[0] = "$";
        while (i < paramArrayOfString.length)
        {
          j = i + 1;
          arrayOfString[j] = paramArrayOfString[i];
          i = j;
        }
        arrayOfString[(i + 1)] = "&";
        arrayOfString[(i + 2)] = "+";
      }
      else if ((!paramBoolean2) && (!paramBoolean3))
      {
        arrayOfString = new String[paramArrayOfString.length + 1];
        arrayOfString[0] = "$";
        for (i = j; i < paramArrayOfString.length; i = j)
        {
          j = i + 1;
          arrayOfString[j] = paramArrayOfString[i];
        }
      }
      else
      {
        arrayOfString = new String[paramArrayOfString.length + 2];
        arrayOfString[0] = "$";
        for (i = k; i < paramArrayOfString.length; i = j)
        {
          j = i + 1;
          arrayOfString[j] = paramArrayOfString[i];
        }
        if (paramBoolean2) {
          arrayOfString[(i + 1)] = "&";
        } else {
          arrayOfString[(i + 1)] = "+";
        }
      }
    }
    setIndex(arrayOfString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.IndexView
 * JD-Core Version:    0.7.0.1
 */