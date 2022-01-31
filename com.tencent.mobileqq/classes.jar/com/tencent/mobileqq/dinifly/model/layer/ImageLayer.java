package com.tencent.mobileqq.dinifly.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.keyframe.TransformKeyframeAnimation;

public class ImageLayer
  extends BaseLayer
{
  private final float density;
  private final Rect dst = new Rect();
  private final Paint paint = new Paint(3);
  private final Rect src = new Rect();
  private Matrix viewMatirx;
  
  ImageLayer(LottieDrawable paramLottieDrawable, Layer paramLayer, float paramFloat)
  {
    super(paramLottieDrawable, paramLayer);
    this.density = paramFloat;
    this.viewMatirx = new Matrix();
  }
  
  @Nullable
  private Bitmap getBitmap()
  {
    String str = this.layerModel.getRefId();
    return this.lottieDrawable.getImageAsset(str);
  }
  
  public void addColorFilter(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    this.paint.setColorFilter(paramColorFilter);
  }
  
  public void drawLayer(@NonNull Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    Bitmap localBitmap = getBitmap();
    if (localBitmap == null) {
      return;
    }
    this.paint.setAlpha(paramInt);
    paramCanvas.save();
    paramCanvas.concat(paramMatrix);
    this.src.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
    this.dst.set(0, 0, (int)(localBitmap.getWidth() * this.density), (int)(localBitmap.getHeight() * this.density));
    paramCanvas.drawBitmap(localBitmap, this.src, this.dst, this.paint);
    paramCanvas.restore();
    this.viewMatirx = this.transform.getMatrix();
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
  {
    super.getBounds(paramRectF, paramMatrix);
    paramMatrix = getBitmap();
    if (paramMatrix != null)
    {
      paramRectF.set(paramRectF.left, paramRectF.top, Math.min(paramRectF.right, paramMatrix.getWidth()), Math.min(paramRectF.bottom, paramMatrix.getHeight()));
      this.boundsMatrix.mapRect(paramRectF);
    }
  }
  
  public Matrix getMatrix()
  {
    return this.viewMatirx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.layer.ImageLayer
 * JD-Core Version:    0.7.0.1
 */