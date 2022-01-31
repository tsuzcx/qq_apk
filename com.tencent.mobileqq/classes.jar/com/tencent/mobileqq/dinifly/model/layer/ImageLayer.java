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
import com.tencent.mobileqq.dinifly.LottieProperty;
import com.tencent.mobileqq.dinifly.animation.LPaint;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.TransformKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.tencent.mobileqq.dinifly.utils.Utils;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;

public class ImageLayer
  extends BaseLayer
{
  @Nullable
  private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
  private final Rect dst = new Rect();
  private final Paint paint = new LPaint(3);
  private final Rect src = new Rect();
  private Matrix viewMatirx = new Matrix();
  
  ImageLayer(LottieDrawable paramLottieDrawable, Layer paramLayer)
  {
    super(paramLottieDrawable, paramLayer);
  }
  
  @Nullable
  private Bitmap getBitmap()
  {
    String str = this.layerModel.getRefId();
    return this.lottieDrawable.getImageAsset(str);
  }
  
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    super.addValueCallback(paramT, paramLottieValueCallback);
    if (paramT == LottieProperty.COLOR_FILTER)
    {
      if (paramLottieValueCallback == null) {
        this.colorFilterAnimation = null;
      }
    }
    else {
      return;
    }
    this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
  }
  
  public void drawLayer(@NonNull Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    Bitmap localBitmap = getBitmap();
    if ((localBitmap == null) || (localBitmap.isRecycled())) {
      return;
    }
    float f = Utils.dpScale();
    this.paint.setAlpha(paramInt);
    if (this.colorFilterAnimation != null) {
      this.paint.setColorFilter((ColorFilter)this.colorFilterAnimation.getValue());
    }
    paramCanvas.save();
    paramCanvas.concat(paramMatrix);
    this.src.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
    this.dst.set(0, 0, (int)(localBitmap.getWidth() * f), (int)(f * localBitmap.getHeight()));
    paramCanvas.drawBitmap(localBitmap, this.src, this.dst, this.paint);
    paramCanvas.restore();
    this.viewMatirx = this.transform.getMatrix();
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    super.getBounds(paramRectF, paramMatrix, paramBoolean);
    paramMatrix = getBitmap();
    if (paramMatrix != null)
    {
      paramRectF.set(0.0F, 0.0F, paramMatrix.getWidth() * Utils.dpScale(), paramMatrix.getHeight() * Utils.dpScale());
      this.boundsMatrix.mapRect(paramRectF);
    }
  }
  
  public Matrix getMatrix()
  {
    return this.viewMatirx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.layer.ImageLayer
 * JD-Core Version:    0.7.0.1
 */