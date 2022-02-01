package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import biqb;
import biqc;

public class CommonImageView
  extends ImageView
  implements biqc
{
  private biqb a;
  
  public CommonImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CommonImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void b(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void c(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      this.a.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      this.a.b(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setMosaicEffect(biqb parambiqb)
  {
    biqb localbiqb = this.a;
    if (localbiqb != null) {
      localbiqb.a(null);
    }
    this.a = parambiqb;
    if (parambiqb != null) {
      parambiqb.a(this);
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CommonImageView
 * JD-Core Version:    0.7.0.1
 */