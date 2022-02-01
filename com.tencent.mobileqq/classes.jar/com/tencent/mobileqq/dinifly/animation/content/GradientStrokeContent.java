package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.annotation.Nullable;
import android.util.LongSparseArray;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieProperty;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.content.GradientColor;
import com.tencent.mobileqq.dinifly.model.content.GradientStroke;
import com.tencent.mobileqq.dinifly.model.content.GradientType;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineCapType;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineJoinType;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;

public class GradientStrokeContent
  extends BaseStrokeContent
{
  private static final int CACHE_STEPS_MS = 32;
  private final RectF boundsRect = new RectF();
  private final int cacheSteps;
  private final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
  @Nullable
  private ValueCallbackKeyframeAnimation colorCallbackAnimation;
  private final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
  private final boolean hidden;
  private final LongSparseArray<LinearGradient> linearGradientCache = new LongSparseArray();
  private final String name;
  private final LongSparseArray<RadialGradient> radialGradientCache = new LongSparseArray();
  private final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
  private final GradientType type;
  
  public GradientStrokeContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, GradientStroke paramGradientStroke)
  {
    super(paramLottieDrawable, paramBaseLayer, paramGradientStroke.getCapType().toPaintCap(), paramGradientStroke.getJoinType().toPaintJoin(), paramGradientStroke.getMiterLimit(), paramGradientStroke.getOpacity(), paramGradientStroke.getWidth(), paramGradientStroke.getLineDashPattern(), paramGradientStroke.getDashOffset());
    this.name = paramGradientStroke.getName();
    this.type = paramGradientStroke.getGradientType();
    this.hidden = paramGradientStroke.isHidden();
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
  
  private int[] applyDynamicColorsIfNeeded(int[] paramArrayOfInt)
  {
    int j = 0;
    int i = 0;
    int[] arrayOfInt = paramArrayOfInt;
    if (this.colorCallbackAnimation != null)
    {
      Integer[] arrayOfInteger = (Integer[])this.colorCallbackAnimation.getValue();
      if (paramArrayOfInt.length == arrayOfInteger.length) {
        for (;;)
        {
          arrayOfInt = paramArrayOfInt;
          if (i >= paramArrayOfInt.length) {
            break;
          }
          paramArrayOfInt[i] = arrayOfInteger[i].intValue();
          i += 1;
        }
      }
      paramArrayOfInt = new int[arrayOfInteger.length];
      i = j;
      for (;;)
      {
        arrayOfInt = paramArrayOfInt;
        if (i >= arrayOfInteger.length) {
          break;
        }
        paramArrayOfInt[i] = arrayOfInteger[i].intValue();
        i += 1;
      }
    }
    return arrayOfInt;
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
    int[] arrayOfInt = applyDynamicColorsIfNeeded(((GradientColor)localObject2).getColors());
    localObject2 = ((GradientColor)localObject2).getPositions();
    int j = (int)(this.boundsRect.left + this.boundsRect.width() / 2.0F + ((PointF)localObject1).x);
    float f1 = this.boundsRect.top;
    float f2 = this.boundsRect.height() / 2.0F;
    int k = (int)(((PointF)localObject1).y + (f1 + f2));
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
    int[] arrayOfInt = applyDynamicColorsIfNeeded(((GradientColor)localObject2).getColors());
    localObject2 = ((GradientColor)localObject2).getPositions();
    int j = (int)(this.boundsRect.left + this.boundsRect.width() / 2.0F + ((PointF)localObject1).x);
    float f1 = this.boundsRect.top;
    float f2 = this.boundsRect.height() / 2.0F;
    int k = (int)(((PointF)localObject1).y + (f1 + f2));
    int m = (int)(this.boundsRect.left + this.boundsRect.width() / 2.0F + localPointF.x);
    f1 = this.boundsRect.top;
    f2 = this.boundsRect.height() / 2.0F;
    int n = (int)(localPointF.y + (f1 + f2));
    f1 = (float)Math.hypot(m - j, n - k);
    localObject1 = new RadialGradient(j, k, f1, arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
    this.radialGradientCache.put(i, localObject1);
    return localObject1;
  }
  
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    super.addValueCallback(paramT, paramLottieValueCallback);
    if (paramT == LottieProperty.GRADIENT_COLOR)
    {
      if (paramLottieValueCallback == null)
      {
        if (this.colorCallbackAnimation != null) {
          this.layer.removeAnimation(this.colorCallbackAnimation);
        }
        this.colorCallbackAnimation = null;
      }
    }
    else {
      return;
    }
    this.colorCallbackAnimation = new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
    this.colorCallbackAnimation.addUpdateListener(this);
    this.layer.addAnimation(this.colorCallbackAnimation);
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    if (this.hidden) {
      return;
    }
    getBounds(this.boundsRect, paramMatrix, false);
    if (this.type == GradientType.LINEAR) {}
    for (Object localObject = getLinearGradient();; localObject = getRadialGradient())
    {
      this.paint.setShader((Shader)localObject);
      super.draw(paramCanvas, paramMatrix, paramInt);
      return;
    }
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.GradientStrokeContent
 * JD-Core Version:    0.7.0.1
 */