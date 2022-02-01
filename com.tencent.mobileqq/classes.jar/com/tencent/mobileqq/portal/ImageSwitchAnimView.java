package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class ImageSwitchAnimView
  extends View
{
  private ImageSwitchAnim a = null;
  
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
    ImageSwitchAnim localImageSwitchAnim = this.a;
    if (localImageSwitchAnim != null) {
      localImageSwitchAnim.a(paramBitmap);
    }
    paramBitmap = this.a;
    if (paramBitmap != null) {
      paramBitmap.b();
    }
    invalidate();
  }
  
  public Bitmap getNowImage()
  {
    ImageSwitchAnim localImageSwitchAnim = this.a;
    if (localImageSwitchAnim != null) {
      return localImageSwitchAnim.d();
    }
    return null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    ImageSwitchAnim localImageSwitchAnim = this.a;
    if ((localImageSwitchAnim != null) && (localImageSwitchAnim.a() == 0))
    {
      int i = getWidth();
      int j = getHeight();
      float f;
      if (i < j) {
        f = i;
      } else {
        f = j;
      }
      int k = (int)(f / 1.35F);
      int m = (i - k) / 2;
      int n = (j - k) / 2;
      this.a.a(i, j, 0, 0, m, n, k, k);
    }
    boolean bool = false;
    localImageSwitchAnim = this.a;
    if (localImageSwitchAnim != null) {
      bool = localImageSwitchAnim.a(paramCanvas);
    }
    if (bool) {
      invalidate();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((getWidth() > 0) && (this.a != null))
    {
      paramInt1 = getWidth();
      paramInt2 = getHeight();
      float f;
      if (paramInt1 < paramInt2) {
        f = paramInt1;
      } else {
        f = paramInt2;
      }
      int i = (int)(f / 1.35F);
      int j = (paramInt1 - i) / 2;
      int k = (paramInt2 - i) / 2;
      this.a.a(paramInt1, paramInt2, 0, 0, j, k, i, i);
    }
  }
  
  public void setLogo(Bitmap paramBitmap)
  {
    ImageSwitchAnim localImageSwitchAnim = this.a;
    if (localImageSwitchAnim != null) {
      localImageSwitchAnim.b(paramBitmap);
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageSwitchAnimView
 * JD-Core Version:    0.7.0.1
 */