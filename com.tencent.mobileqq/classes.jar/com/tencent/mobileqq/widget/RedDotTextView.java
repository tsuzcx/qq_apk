package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class RedDotTextView
  extends TextView
{
  private static String a = "RedDotTextView";
  private boolean b;
  private Drawable c;
  private Rect d = new Rect();
  private float e = getResources().getDisplayMetrics().density;
  private int f;
  private boolean g = true;
  
  public RedDotTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedDotTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    double d1 = this.e * 9.0F;
    Double.isNaN(d1);
    this.f = ((int)(d1 + 0.5D));
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.b)
    {
      if (this.c == null) {
        this.c = getResources().getDrawable(2130852588);
      }
      Object localObject = getText().toString();
      TextPaint localTextPaint = getPaint();
      localTextPaint.getTextBounds((String)localObject, 0, ((String)localObject).length(), this.d);
      float f3 = this.d.height();
      float f1 = Layout.getDesiredWidth((CharSequence)localObject, localTextPaint);
      int i = getWidth();
      int j = getHeight();
      float f4 = i / 2;
      float f5 = f1 / 2.0F;
      boolean bool = this.g;
      float f2 = 0.0F;
      if (bool) {
        f1 = this.e * 2.0F;
      } else {
        f1 = 0.0F;
      }
      i = (int)(f4 + f5 - f1);
      f4 = j / 2;
      f3 /= 2.0F;
      f5 = this.f;
      f1 = f2;
      if (this.g) {
        f1 = this.e * 2.0F;
      }
      j = (int)(f4 - f3 - f5 + f1);
      localObject = this.c;
      int k = this.f;
      ((Drawable)localObject).setBounds(i, j, i + k, k + j);
      this.c.draw(paramCanvas);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    invalidate();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.g = paramBoolean2;
    a(paramBoolean1);
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.translate(getScrollX(), getScrollY());
    a(paramCanvas);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RedDotTextView
 * JD-Core Version:    0.7.0.1
 */