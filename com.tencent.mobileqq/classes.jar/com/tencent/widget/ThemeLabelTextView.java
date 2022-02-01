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
  ThemeImageWrapper themeImageWrapper;
  
  public ThemeLabelTextView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ThemeLabelTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ThemeLabelTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public void draw(Canvas paramCanvas)
  {
    ThemeImageWrapper localThemeImageWrapper = this.themeImageWrapper;
    if (localThemeImageWrapper != null)
    {
      localThemeImageWrapper.onDraw(paramCanvas, this);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void init()
  {
    setSupportMaskView(false);
  }
  
  public void setMaskShape(int paramInt)
  {
    ThemeImageWrapper localThemeImageWrapper = this.themeImageWrapper;
    if (localThemeImageWrapper != null) {
      localThemeImageWrapper.setMaskShape(paramInt);
    }
  }
  
  public void setSupportMaskView(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.themeImageWrapper == null) {
        this.themeImageWrapper = new ThemeImageWrapper();
      }
      this.themeImageWrapper.setSupportMaskView(true);
      setMaskShape(ThemeImageWrapper.MODE_OTHER);
      return;
    }
    ThemeImageWrapper localThemeImageWrapper = this.themeImageWrapper;
    if (localThemeImageWrapper != null) {
      localThemeImageWrapper.setSupportMaskView(false);
    }
  }
  
  public void superOnDraw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ThemeLabelTextView
 * JD-Core Version:    0.7.0.1
 */