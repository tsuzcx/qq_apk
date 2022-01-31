package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.content.GradientColor;
import com.tencent.mobileqq.dinifly.model.content.GradientStroke;
import com.tencent.mobileqq.dinifly.model.content.GradientType;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineCapType;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineJoinType;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;

public class GradientStrokeContent
  extends BaseStrokeContent
{
  private static final int CACHE_STEPS_MS = 32;
  private final RectF boundsRect = new RectF();
  private final int cacheSteps;
  private final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
  private final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
  private final LongSparseArray<LinearGradient> linearGradientCache = new LongSparseArray();
  private final String name;
  private final LongSparseArray<RadialGradient> radialGradientCache = new LongSparseArray();
  private final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
  private final GradientType type;
  
  public GradientStrokeContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, GradientStroke paramGradientStroke)
  {
    super(paramLottieDrawable, paramBaseLayer, paramGradientStroke.getCapType().toPaintCap(), paramGradientStroke.getJoinType().toPaintJoin(), paramGradientStroke.getOpacity(), paramGradientStroke.getWidth(), paramGradientStroke.getLineDashPattern(), paramGradientStroke.getDashOffset());
    this.name = paramGradientStroke.getName();
    this.type = paramGradientStroke.getGradientType();
    this.cacheSteps = ((int)(paramLottieDrawable.getComposition().getDuration() / 32L));
    this.colorAnimation = paramGradientStroke.getGradientColor().createAnimation();
    this.colorAnimation.addUpdateListener(this);
    paramBaseLayer.addAnimation(this.colorAnimation);
    this.startPointAnimation = paramGradientStroke.getStartPoint().createAnimation();
    this.startPointAnimation.addUpdateListener(this);
    paramBaseLayer.addAnimation(this.startPointAnimation);
    this.endPointAnimation = paramGradientStroke.getEndPoint().createAnimation();
    this.endPointAnimation.addUpdateListener(this);
    paramBaseLayer.addAnimation(this.endPointAnimation);
  }
  
  private int getGradientHash()
  {
    int j = Math.round(this.startPointAnimation.getProgress() * this.cacheSteps);
    int m = Math.round(this.endPointAnimation.getProgress() * this.cacheSteps);
    int k = Math.round(this.colorAnimation.getProgress() * this.cacheSteps);
    int i = 17;
    if (j != 0) {
      i = j * 527;
    }
    j = i;
    if (m != 0) {
      j = i * 31 * m;
    }
    i = j;
    if (k != 0) {
      i = j * 31 * k;
    }
    return i;
  }
  
  private LinearGradient getLinearGradient()
  {
    int i = getGradientHash();
    Object localObject1 = (LinearGradient)this.linearGradientCache.get(i);
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = (PointF)this.startPointAnimation.getValue();
    PointF localPointF = (PointF)this.endPointAnimation.getValue();
    Object localObject2 = (GradientColor)this.colorAnimation.getValue();
    int[] arrayOfInt = ((GradientColor)localObject2).getColors();
    localObject2 = ((GradientColor)localObject2).getPositions();
    int j = (int)(this.boundsRect.left + this.boundsRect.width() / 2.0F + ((PointF)localObject1).x);
    int k = (int)(this.boundsRect.top + this.boundsRect.height() / 2.0F + ((PointF)localObject1).y);
    int m = (int)(this.boundsRect.left + this.boundsRect.width() / 2.0F + localPointF.x);
    int n = (int)(this.boundsRect.top + this.boundsRect.height() / 2.0F + localPointF.y);
    localObject1 = new LinearGradient(j, k, m, n, arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
    this.linearGradientCache.put(i, localObject1);
    return localObject1;
  }
  
  private RadialGradient getRadialGradient()
  {
    int i = getGradientHash();
    Object localObject1 = (RadialGradient)this.radialGradientCache.get(i);
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = (PointF)this.startPointAnimation.getValue();
    PointF localPointF = (PointF)this.endPointAnimation.getValue();
    Object localObject2 = (GradientColor)this.colorAnimation.getValue();
    int[] arrayOfInt = ((GradientColor)localObject2).getColors();
    localObject2 = ((GradientColor)localObject2).getPositions();
    int j = (int)(this.boundsRect.left + this.boundsRect.width() / 2.0F + ((PointF)localObject1).x);
    int k = (int)(this.boundsRect.top + this.boundsRect.height() / 2.0F + ((PointF)localObject1).y);
    int m = (int)(this.boundsRect.left + this.boundsRect.width() / 2.0F + localPointF.x);
    int n = (int)(this.boundsRect.top + this.boundsRect.height() / 2.0F + localPointF.y);
    float f = (float)Math.hypot(m - j, n - k);
    localObject1 = new RadialGradient(j, k, f, arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
    this.radialGradientCache.put(i, localObject1);
    return localObject1;
  }
  
  public void addColorFilter(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter) {}
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    getBounds(this.boundsRect, paramMatrix);
    if (this.type == GradientType.Linear) {
      this.paint.setShader(getLinearGradient());
    }
    for (;;)
    {
      super.draw(paramCanvas, paramMatrix, paramInt);
      return;
      this.paint.setShader(getRadialGradient());
    }
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.GradientStrokeContent
 * JD-Core Version:    0.7.0.1
 */