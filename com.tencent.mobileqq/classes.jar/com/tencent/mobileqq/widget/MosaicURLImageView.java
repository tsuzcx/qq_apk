package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import bizh;
import bizi;
import com.tencent.image.URLImageView;

public class MosaicURLImageView
  extends URLImageView
  implements bizi
{
  private bizh a;
  
  public MosaicURLImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MosaicURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MosaicURLImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void b(Canvas paramCanvas)
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
  
  public void setMosaicEffect(bizh parambizh)
  {
    if (this.a != null) {
      this.a.a(null);
    }
    this.a = parambizh;
    if (this.a != null) {
      this.a.a(this);
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MosaicURLImageView
 * JD-Core Version:    0.7.0.1
 */