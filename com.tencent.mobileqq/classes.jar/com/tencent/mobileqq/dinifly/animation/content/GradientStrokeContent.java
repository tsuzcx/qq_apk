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
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
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
    Object localObject = this.colorCallbackAnimation;
    int[] arrayOfInt = paramArrayOfInt;
    if (localObject != null)
    {
      localObject = (Integer[])((ValueCallbackKeyframeAnimation)localObject).getValue();
      int k = paramArrayOfInt.length;
      int m = localObject.length;
      int j = 0;
      int i = 0;
      if (k == m) {
        for (;;)
        {
          arrayOfInt = paramArrayOfInt;
          if (i >= paramArrayOfInt.length) {
            break;
          }
          paramArrayOfInt[i] = localObject[i].intValue();
          i += 1;
        }
      }
      paramArrayOfInt = new int[localObject.length];
      i = j;
      for (;;)
      {
        arrayOfInt = paramArrayOfInt;
        if (i >= localObject.length) {
          break;
        }
        paramArrayOfInt[i] = localObject[i].intValue();
        i += 1;
      }
    }
    return arrayOfInt;
  }
  
  private int getGradientHash()
  {
    int i = Math.round(this.startPointAnimation.getProgress() * this.cacheSteps);
    int m = Math.round(this.endPointAnimation.getProgress() * this.cacheSteps);
    int k = Math.round(this.colorAnimation.getProgress() * this.cacheSteps);
    if (i != 0) {
      j = 527 * i;
    } else {
      j = 17;
    }
    i = j;
    if (m != 0) {
      i = j * 31 * m;
    }
    int j = i;
    if (k != 0) {
      j = i * 31 * k;
    }
    return j;
  }
  
  private LinearGradient getLinearGradient()
  {
    int i = getGradientHash();
    Object localObject1 = this.linearGradientCache;
    long l = i;
    localObject1 = (LinearGradient)((LongSparseArray)localObject1).get(l);
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = (PointF)this.startPointAnimation.getValue();
    PointF localPointF = (PointF)this.endPointAnimation.getValue();
    Object localObject2 = (GradientColor)this.colorAnimation.getValue();
    int[] arrayOfInt = applyDynamicColorsIfNeeded(((GradientColor)localObject2).getColors());
    localObject2 = ((GradientColor)localObject2).getPositions();
    localObject1 = new LinearGradient(((PointF)localObject1).x, ((PointF)localObject1).y, localPointF.x, localPointF.y, arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
    this.linearGradientCache.put(l, localObject1);
    return localObject1;
  }
  
  private RadialGradient getRadialGradient()
  {
    int i = getGradientHash();
    Object localObject1 = this.radialGradientCache;
    long l = i;
    localObject1 = (RadialGradient)((LongSparseArray)localObject1).get(l);
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = (PointF)this.startPointAnimation.getValue();
    PointF localPointF = (PointF)this.endPointAnimation.getValue();
    Object localObject2 = (GradientColor)this.colorAnimation.getValue();
    int[] arrayOfInt = applyDynamicColorsIfNeeded(((GradientColor)localObject2).getColors());
    localObject2 = ((GradientColor)localObject2).getPositions();
    float f1 = ((PointF)localObject1).x;
    float f2 = ((PointF)localObject1).y;
    float f3 = localPointF.x;
    float f4 = localPointF.y;
    localObject1 = new RadialGradient(f1, f2, (float)Math.hypot(f3 - f1, f4 - f2), arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
    this.radialGradientCache.put(l, localObject1);
    return localObject1;
  }
  
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    super.addValueCallback(paramT, paramLottieValueCallback);
    if (paramT == LottieProperty.GRADIENT_COLOR)
    {
      if (this.colorCallbackAnimation != null) {
        this.layer.removeAnimation(this.colorCallbackAnimation);
      }
      if (paramLottieValueCallback == null)
      {
        this.colorCallbackAnimation = null;
        return;
      }
      this.colorCallbackAnimation = new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
      this.colorCallbackAnimation.addUpdateListener(this);
      this.layer.addAnimation(this.colorCallbackAnimation);
    }
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    if (this.hidden) {
      return;
    }
    getBounds(this.boundsRect, paramMatrix, false);
    Object localObject;
    if (this.type == GradientType.LINEAR) {
      localObject = getLinearGradient();
    } else {
      localObject = getRadialGradient();
    }
    ((Shader)localObject).setLocalMatrix(paramMatrix);
    this.paint.setShader((Shader)localObject);
    super.draw(paramCanvas, paramMatrix, paramInt);
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.GradientStrokeContent
 * JD-Core Version:    0.7.0.1
 */