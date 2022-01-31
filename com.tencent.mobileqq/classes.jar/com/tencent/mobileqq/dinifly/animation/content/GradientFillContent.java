package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.LongSparseArray;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieProperty;
import com.tencent.mobileqq.dinifly.animation.LPaint;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.KeyPath;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.content.GradientColor;
import com.tencent.mobileqq.dinifly.model.content.GradientFill;
import com.tencent.mobileqq.dinifly.model.content.GradientType;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class GradientFillContent
  implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener
{
  private static final int CACHE_STEPS_MS = 32;
  private final RectF boundsRect = new RectF();
  private final int cacheSteps;
  private final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
  @Nullable
  private ValueCallbackKeyframeAnimation colorCallbackAnimation;
  @Nullable
  private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
  private final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
  private final boolean hidden;
  private final BaseLayer layer;
  private final LongSparseArray<LinearGradient> linearGradientCache = new LongSparseArray();
  private final LottieDrawable lottieDrawable;
  @NonNull
  private final String name;
  private final BaseKeyframeAnimation<Integer, Integer> opacityAnimation;
  private final Paint paint = new LPaint(1);
  private final Path path = new Path();
  private final List<PathContent> paths = new ArrayList();
  private final LongSparseArray<RadialGradient> radialGradientCache = new LongSparseArray();
  private final Matrix shaderMatrix = new Matrix();
  private final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
  private final GradientType type;
  
  public GradientFillContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, GradientFill paramGradientFill)
  {
    this.layer = paramBaseLayer;
    this.name = paramGradientFill.getName();
    this.hidden = paramGradientFill.isHidden();
    this.lottieDrawable = paramLottieDrawable;
    this.type = paramGradientFill.getGradientType();
    this.path.setFillType(paramGradientFill.getFillType());
    this.cacheSteps = ((int)(paramLottieDrawable.getComposition().getDuration() / 32L));
    this.colorAnimation = paramGradientFill.getGradientColor().createAnimation();
    this.colorAnimation.addUpdateListener(this);
    paramBaseLayer.addAnimation(this.colorAnimation);
    this.opacityAnimation = paramGradientFill.getOpacity().createAnimation();
    this.opacityAnimation.addUpdateListener(this);
    paramBaseLayer.addAnimation(this.opacityAnimation);
    this.startPointAnimation = paramGradientFill.getStartPoint().createAnimation();
    this.startPointAnimation.addUpdateListener(this);
    paramBaseLayer.addAnimation(this.startPointAnimation);
    this.endPointAnimation = paramGradientFill.getEndPoint().createAnimation();
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
    localObject1 = new LinearGradient(((PointF)localObject1).x, ((PointF)localObject1).y, localPointF.x, localPointF.y, arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
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
    float f3 = ((PointF)localObject1).x;
    float f4 = ((PointF)localObject1).y;
    float f1 = localPointF.x;
    float f2 = localPointF.y;
    f2 = (float)Math.hypot(f1 - f3, f2 - f4);
    f1 = f2;
    if (f2 <= 0.0F) {
      f1 = 0.001F;
    }
    localObject1 = new RadialGradient(f3, f4, f1, arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
    this.radialGradientCache.put(i, localObject1);
    return localObject1;
  }
  
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    if (paramT == LottieProperty.OPACITY) {
      this.opacityAnimation.setValueCallback(paramLottieValueCallback);
    }
    do
    {
      return;
      if (paramT == LottieProperty.COLOR_FILTER)
      {
        if (paramLottieValueCallback == null)
        {
          this.colorFilterAnimation = null;
          return;
        }
        this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
        this.colorFilterAnimation.addUpdateListener(this);
        this.layer.addAnimation(this.colorFilterAnimation);
        return;
      }
    } while (paramT != LottieProperty.GRADIENT_COLOR);
    if (paramLottieValueCallback == null)
    {
      if (this.colorCallbackAnimation != null) {
        this.layer.removeAnimation(this.colorCallbackAnimation);
      }
      this.colorCallbackAnimation = null;
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
    L.beginSection("GradientFillContent#draw");
    this.path.reset();
    int i = 0;
    while (i < this.paths.size())
    {
      this.path.addPath(((PathContent)this.paths.get(i)).getPath(), paramMatrix);
      i += 1;
    }
    this.path.computeBounds(this.boundsRect, false);
    if (this.type == GradientType.LINEAR) {}
    for (Object localObject = getLinearGradient();; localObject = getRadialGradient())
    {
      this.shaderMatrix.set(paramMatrix);
      ((Shader)localObject).setLocalMatrix(this.shaderMatrix);
      this.paint.setShader((Shader)localObject);
      if (this.colorFilterAnimation != null) {
        this.paint.setColorFilter((ColorFilter)this.colorFilterAnimation.getValue());
      }
      float f = paramInt / 255.0F;
      paramInt = (int)(((Integer)this.opacityAnimation.getValue()).intValue() * f / 100.0F * 255.0F);
      this.paint.setAlpha(MiscUtils.clamp(paramInt, 0, 255));
      paramCanvas.drawPath(this.path, this.paint);
      L.endSection("GradientFillContent#draw");
      return;
    }
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    this.path.reset();
    int i = 0;
    while (i < this.paths.size())
    {
      this.path.addPath(((PathContent)this.paths.get(i)).getPath(), paramMatrix);
      i += 1;
    }
    this.path.computeBounds(paramRectF, false);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void onValueChanged()
  {
    this.lottieDrawable.invalidateSelf();
  }
  
  public void resolveKeyPath(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2)
  {
    MiscUtils.resolveKeyPath(paramKeyPath1, paramInt, paramList, paramKeyPath2, this);
  }
  
  public void setContents(List<Content> paramList1, List<Content> paramList2)
  {
    int i = 0;
    while (i < paramList2.size())
    {
      paramList1 = (Content)paramList2.get(i);
      if ((paramList1 instanceof PathContent)) {
        this.paths.add((PathContent)paramList1);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.GradientFillContent
 * JD-Core Version:    0.7.0.1
 */