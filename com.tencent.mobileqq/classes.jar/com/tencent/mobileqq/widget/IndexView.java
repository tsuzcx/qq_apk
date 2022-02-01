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
  private String[] a;
  private int[] b;
  private int[] c;
  private IndexView.OnIndexChangedListener d = null;
  private IndexView.OnIndexChangedListener2 e = null;
  private TextPaint f = new TextPaint();
  private boolean g = false;
  private boolean h;
  private Drawable i;
  private Rect j;
  private Drawable k;
  private Rect l;
  private boolean m = false;
  private boolean n = false;
  
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
    int i3 = getPaddingTop();
    int i4 = getPaddingBottom();
    paramInt1 = 1;
    int i1 = 100;
    int i2 = 50;
    while (paramInt1 < i1)
    {
      i2 = (paramInt1 + i1) / 2;
      if (b(i2) <= paramInt2 - (i3 + i4)) {
        paramInt1 = i2 + 1;
      } else {
        i1 = i2 - 1;
      }
    }
    return c(i2) + getPaddingLeft() + getPaddingRight();
  }
  
  private static int a(int[] paramArrayOfInt)
  {
    int i1 = 0;
    int i2 = 0;
    if (paramArrayOfInt != null)
    {
      int i3 = paramArrayOfInt.length;
      i1 = 0;
      while (i2 < i3)
      {
        i1 += paramArrayOfInt[i2];
        i2 += 1;
      }
    }
    return i1;
  }
  
  private void a()
  {
    int i2 = this.a.length;
    Rect localRect = new Rect();
    int i1 = 0;
    while (i1 < i2)
    {
      TextPaint localTextPaint = this.f;
      String[] arrayOfString = this.a;
      localTextPaint.getTextBounds(arrayOfString[i1], 0, arrayOfString[i1].length(), localRect);
      this.c[i1] = (localRect.right - localRect.left);
      this.b[i1] = (localRect.bottom - localRect.top);
      i1 += 1;
    }
  }
  
  private int b(int paramInt)
  {
    int i2 = this.a.length;
    TextPaint localTextPaint = this.f;
    localTextPaint.setTextSize(paramInt);
    localTextPaint.setAntiAlias(true);
    Rect localRect = new Rect();
    paramInt = 0;
    int i1 = 0;
    while (paramInt < i2)
    {
      String[] arrayOfString = this.a;
      localTextPaint.getTextBounds(arrayOfString[paramInt], 0, arrayOfString[paramInt].length(), localRect);
      int i3 = localRect.bottom - localRect.top;
      i1 = i1 + i3 + (int)(i3 * 0.8F);
      paramInt += 1;
    }
    return i1;
  }
  
  private int c(int paramInt)
  {
    int i2 = this.a.length;
    TextPaint localTextPaint = this.f;
    localTextPaint.setTextSize(paramInt);
    localTextPaint.setAntiAlias(true);
    Rect localRect = new Rect();
    paramInt = 0;
    int i1 = 0;
    while (paramInt < i2)
    {
      String[] arrayOfString = this.a;
      localTextPaint.getTextBounds(arrayOfString[paramInt], 0, arrayOfString[paramInt].length(), localRect);
      i1 = Math.max(i1, localRect.right - localRect.left);
      paramInt += 1;
    }
    return i1;
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
    int i2 = a(paramInt2);
    paramInt2 = a(paramInt1, i2);
    int i3 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    if (i3 == -2147483648)
    {
      paramInt1 = Math.min(paramInt2, i1);
    }
    else
    {
      paramInt1 = paramInt2;
      if (i3 == 1073741824) {
        paramInt1 = i1;
      }
    }
    setMeasuredDimension(paramInt1, i2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i3 = paramMotionEvent.getAction();
    int[] arrayOfInt;
    Drawable localDrawable;
    if (i3 == 0)
    {
      this.g = true;
      arrayOfInt = new int[1];
      arrayOfInt[0] = 16842919;
      localDrawable = this.i;
      if (localDrawable != null)
      {
        localDrawable.setState(arrayOfInt);
        this.i.invalidateSelf();
      }
      localDrawable = this.k;
      if (localDrawable != null)
      {
        localDrawable.setState(arrayOfInt);
        this.k.invalidateSelf();
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
    else if ((i3 == 3) || (i3 == 1))
    {
      this.g = false;
      arrayOfInt = new int[0];
      localDrawable = this.i;
      if (localDrawable != null)
      {
        localDrawable.setState(arrayOfInt);
        this.i.invalidateSelf();
      }
      localDrawable = this.k;
      if (localDrawable != null)
      {
        localDrawable.setState(arrayOfInt);
        this.k.invalidateSelf();
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
    if ((i3 != 0) && (i3 != 2) && (i3 != 1)) {
      return i3 == 3;
    }
    float f2 = paramMotionEvent.getY();
    if ((this.d != null) && (f2 >= 0.0F))
    {
      int i1 = getHeight() - getPaddingTop() - getPaddingBottom();
      int i2 = a(this.b);
      float f1;
      if (i1 > i2) {
        f1 = (i1 - i2) * 1.0F / (this.a.length - 1);
      } else {
        f1 = 0.0F;
      }
      i2 = -1;
      for (;;)
      {
        i1 = i2;
        if (f2 < 0.0F) {
          break;
        }
        i2 += 1;
        paramMotionEvent = this.b;
        i1 = i2;
        if (i2 >= paramMotionEvent.length) {
          break;
        }
        f2 -= paramMotionEvent[i2] + f1;
      }
      paramMotionEvent = this.b;
      i2 = i1;
      if (i1 >= paramMotionEvent.length) {
        i2 = paramMotionEvent.length - 1;
      }
      this.d.onIndexChanged(this.a[i2]);
      paramMotionEvent = this.e;
      if (paramMotionEvent != null) {
        paramMotionEvent.onIndexChanged(this.a[i2], i3);
      }
    }
    return true;
  }
  
  public void setIndex(String[] paramArrayOfString)
  {
    if ("$".equals(paramArrayOfString[0]))
    {
      this.h = true;
      this.i = getResources().getDrawable(2130841262);
      this.j = new Rect();
    }
    if (this.m)
    {
      this.k = getResources().getDrawable(2130841261);
      this.l = new Rect();
    }
    this.a = paramArrayOfString;
    this.b = new int[paramArrayOfString.length];
    this.c = new int[paramArrayOfString.length];
  }
  
  public void setIndex(String[] paramArrayOfString, boolean paramBoolean)
  {
    String[] arrayOfString = paramArrayOfString;
    if (paramBoolean)
    {
      arrayOfString = new String[paramArrayOfString.length + 1];
      int i1 = 0;
      arrayOfString[0] = "$";
      while (i1 < paramArrayOfString.length)
      {
        int i2 = i1 + 1;
        arrayOfString[i2] = paramArrayOfString[i1];
        i1 = i2;
      }
    }
    setIndex(arrayOfString);
  }
  
  public void setIndex(String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    String[] arrayOfString = paramArrayOfString;
    if (paramBoolean1)
    {
      this.m = paramBoolean2;
      this.n = paramBoolean3;
      int i2 = 0;
      int i3 = 0;
      int i1 = 0;
      if ((paramBoolean2) && (paramBoolean3))
      {
        arrayOfString = new String[paramArrayOfString.length + 3];
        arrayOfString[0] = "$";
        while (i1 < paramArrayOfString.length)
        {
          i2 = i1 + 1;
          arrayOfString[i2] = paramArrayOfString[i1];
          i1 = i2;
        }
        arrayOfString[(i1 + 1)] = "&";
        arrayOfString[(i1 + 2)] = "+";
      }
      else if ((!paramBoolean2) && (!paramBoolean3))
      {
        arrayOfString = new String[paramArrayOfString.length + 1];
        arrayOfString[0] = "$";
        for (i1 = i2; i1 < paramArrayOfString.length; i1 = i2)
        {
          i2 = i1 + 1;
          arrayOfString[i2] = paramArrayOfString[i1];
        }
      }
      else
      {
        arrayOfString = new String[paramArrayOfString.length + 2];
        arrayOfString[0] = "$";
        for (i1 = i3; i1 < paramArrayOfString.length; i1 = i2)
        {
          i2 = i1 + 1;
          arrayOfString[i2] = paramArrayOfString[i1];
        }
        if (paramBoolean2) {
          arrayOfString[(i1 + 1)] = "&";
        } else {
          arrayOfString[(i1 + 1)] = "+";
        }
      }
    }
    setIndex(arrayOfString);
  }
  
  public void setOnIndexChangedListener(IndexView.OnIndexChangedListener paramOnIndexChangedListener)
  {
    this.d = paramOnIndexChangedListener;
  }
  
  public void setOnIndexChangedListener2(IndexView.OnIndexChangedListener2 paramOnIndexChangedListener2)
  {
    this.e = paramOnIndexChangedListener2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.IndexView
 * JD-Core Version:    0.7.0.1
 */