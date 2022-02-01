package com.tencent.mobileqq.magicface.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;

public class PngFrameDrawable
  extends Drawable
  implements IRedrawNotify
{
  private int a;
  private PngFrameDrawable.PngFrameState b;
  private PngGifEngine c;
  private Bitmap d;
  
  private PngFrameDrawable(PngFrameDrawable.PngFrameState paramPngFrameState, Resources paramResources)
  {
    this.b = paramPngFrameState;
    if (paramResources != null) {
      this.a = paramResources.getDisplayMetrics().densityDpi;
    } else {
      this.a = paramPngFrameState.j;
    }
    c();
  }
  
  public PngFrameDrawable(PngPlayParam paramPngPlayParam, Resources paramResources)
  {
    this(new PngFrameDrawable.PngFrameState(paramPngPlayParam), paramResources);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameDrawable", 2, "func initGifEngine");
    }
    PngGifEngine.PngGifTaskParam localPngGifTaskParam = new PngGifEngine.PngGifTaskParam();
    localPngGifTaskParam.e = this;
    localPngGifTaskParam.a = this.b.d;
    localPngGifTaskParam.b = this.b.c;
    if (!this.b.f) {
      localPngGifTaskParam.c = null;
    } else {
      localPngGifTaskParam.c = this.b.a;
    }
    this.c = new PngGifEngine();
    this.c.a(localPngGifTaskParam);
  }
  
  public void a(int paramInt)
  {
    if (this.c == null) {
      return;
    }
    if ((this.b.b != null) && (paramInt >= 0) && (paramInt < this.b.b.length)) {
      this.c.a(this.b.b[paramInt]);
    }
    this.c.a();
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func onBitmapReady,bitmap:");
      ((StringBuilder)localObject).append(paramBitmap);
      QLog.d("PngFrameDrawable", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBitmap == null) {
      return;
    }
    Object localObject = this.d;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      this.d.recycle();
    }
    this.d = paramBitmap;
    invalidateSelf();
  }
  
  public boolean a()
  {
    Bitmap localBitmap = this.d;
    return (localBitmap != null) && (!localBitmap.isRecycled());
  }
  
  public Bitmap b()
  {
    return this.d;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func draw,bitmap:");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("PngFrameDrawable", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.d;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      paramCanvas.drawBitmap(this.d, null, getBounds(), this.b.g);
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.b;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.b.g.getAlpha())
    {
      this.b.g.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.g.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameDrawable
 * JD-Core Version:    0.7.0.1
 */