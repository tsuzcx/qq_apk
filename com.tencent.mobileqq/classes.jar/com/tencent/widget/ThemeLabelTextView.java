package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class ThemeLabelTextView
  extends TextView
  implements ThemeImageWrapper.DrawInterface
{
  ThemeImageWrapper a;
  
  public ThemeLabelTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ThemeLabelTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ThemeLabelTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  protected void a()
  {
    setSupportMaskView(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      this.a.onDraw(paramCanvas, this);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void setMaskShape(int paramInt)
  {
    if (this.a != null) {
      this.a.setMaskShape(paramInt);
    }
  }
  
  public void setSupportMaskView(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a == null) {
        this.a = new ThemeImageWrapper();
      }
      this.a.setSupportMaskView(true);
      setMaskShape(ThemeImageWrapper.MODE_OTHER);
    }
    while (this.a == null) {
      return;
    }
    this.a.setSupportMaskView(false);
  }
  
  public void superOnDraw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.ThemeLabelTextView
 * JD-Core Version:    0.7.0.1
 */