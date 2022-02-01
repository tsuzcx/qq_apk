package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;
import blfw;
import blfx;

public class ThemeLabelTextView
  extends TextView
  implements blfx
{
  blfw a;
  
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
  
  public void a(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      this.a.a(paramCanvas, this);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void setMaskShape(int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramInt);
    }
  }
  
  public void setSupportMaskView(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a == null) {
        this.a = new blfw();
      }
      this.a.a(true);
      setMaskShape(blfw.c);
    }
    while (this.a == null) {
      return;
    }
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.ThemeLabelTextView
 * JD-Core Version:    0.7.0.1
 */