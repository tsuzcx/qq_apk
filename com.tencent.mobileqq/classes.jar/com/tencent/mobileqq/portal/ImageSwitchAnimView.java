package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import azuc;

public class ImageSwitchAnimView
  extends View
{
  private azuc a = new azuc(getContext(), 0, 0, 0, 0, 0, 0, 0, 0);
  
  public ImageSwitchAnimView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ImageSwitchAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.a != null) {
      this.a.a(paramBitmap);
    }
    if (this.a != null) {
      this.a.a();
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    boolean bool = false;
    super.onDraw(paramCanvas);
    int j;
    int k;
    if ((this.a != null) && (this.a.a() == 0))
    {
      j = getWidth();
      k = getHeight();
      if (j >= k) {
        break label109;
      }
    }
    label109:
    for (int i = (int)(j / 1.35F);; i = (int)(k / 1.35F))
    {
      int m = (j - i) / 2;
      int n = (k - i) / 2;
      this.a.a(j, k, 0, 0, m, n, i, i);
      if (this.a != null) {
        bool = this.a.a(paramCanvas);
      }
      if (bool) {
        invalidate();
      }
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i;
    if ((getWidth() > 0) && (this.a != null))
    {
      paramInt2 = getWidth();
      i = getHeight();
      if (paramInt2 >= i) {
        break label74;
      }
    }
    label74:
    for (paramInt1 = (int)(paramInt2 / 1.35F);; paramInt1 = (int)(i / 1.35F))
    {
      int j = (paramInt2 - paramInt1) / 2;
      int k = (i - paramInt1) / 2;
      this.a.a(paramInt2, i, 0, 0, j, k, paramInt1, paramInt1);
      return;
    }
  }
  
  public void setLogo(Bitmap paramBitmap)
  {
    if (this.a != null) {
      this.a.b(paramBitmap);
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageSwitchAnimView
 * JD-Core Version:    0.7.0.1
 */