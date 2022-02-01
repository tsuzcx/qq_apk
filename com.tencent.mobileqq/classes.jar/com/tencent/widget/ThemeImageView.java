package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ThemeImageView
  extends ImageView
  implements ThemeImageWrapper.DrawInterface
{
  public ThemeImageWrapper themeImageWrapper;
  
  public ThemeImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ThemeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ThemeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  protected void init()
  {
    setSupportMaskView(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    ThemeImageWrapper localThemeImageWrapper = this.themeImageWrapper;
    if (localThemeImageWrapper != null)
    {
      localThemeImageWrapper.onDraw(paramCanvas, this);
      return;
    }
    super.onDraw(paramCanvas);
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
      return;
    }
    ThemeImageWrapper localThemeImageWrapper = this.themeImageWrapper;
    if (localThemeImageWrapper != null) {
      localThemeImageWrapper.setSupportMaskView(false);
    }
  }
  
  public void superOnDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ThemeImageView
 * JD-Core Version:    0.7.0.1
 */