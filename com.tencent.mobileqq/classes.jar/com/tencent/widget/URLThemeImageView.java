package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import bhxo;
import bhxp;
import com.tencent.image.URLImageView;

public class URLThemeImageView
  extends URLImageView
  implements bhxp
{
  public bhxo a;
  
  public URLThemeImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public URLThemeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public URLThemeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  public void a_(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void b()
  {
    setSupportMaskView(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      this.a.a(paramCanvas, this);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setSupportMaskView(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a == null) {
        this.a = new bhxo();
      }
      this.a.a(true);
    }
    while (this.a == null) {
      return;
    }
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.URLThemeImageView
 * JD-Core Version:    0.7.0.1
 */