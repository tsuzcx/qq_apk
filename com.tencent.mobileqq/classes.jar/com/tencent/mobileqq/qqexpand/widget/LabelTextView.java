package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.widget.ThemeImageWrapper;
import com.tencent.widget.ThemeImageWrapper.DrawInterface;

public class LabelTextView
  extends TextView
  implements ThemeImageWrapper.DrawInterface
{
  protected ThemeImageWrapper a;
  private int b = 2147483647;
  private boolean c = false;
  private boolean d = false;
  
  public LabelTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LabelTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public LabelTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setMaxLines(1);
    setGravity(17);
    setSingleLine();
    setEllipsize(TextUtils.TruncateAt.END);
    b();
  }
  
  private void b()
  {
    this.a = new ThemeImageWrapper();
    this.a.setSupportMaskView(true);
    this.a.setMaskShape(ThemeImageWrapper.MODE_OTHER);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.d)
    {
      ThemeImageWrapper localThemeImageWrapper = this.a;
      if (localThemeImageWrapper != null)
      {
        localThemeImageWrapper.onDraw(paramCanvas, this);
        return;
      }
    }
    super.draw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.c) {
      if (getMeasuredWidth() < this.b)
      {
        if (getVisibility() == 0) {
          setVisibility(8);
        }
      }
      else if (getVisibility() != 0) {
        setVisibility(0);
      }
    }
  }
  
  public void setMinWidthCheck(int paramInt)
  {
    this.b = paramInt;
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.c = bool;
  }
  
  public void setParam(int paramInt1, int paramInt2, float paramFloat)
  {
    setTextColor(paramInt2);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt1);
    localGradientDrawable.setCornerRadius(paramFloat);
    setBackgroundDrawable(localGradientDrawable);
  }
  
  public void superOnDraw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.LabelTextView
 * JD-Core Version:    0.7.0.1
 */