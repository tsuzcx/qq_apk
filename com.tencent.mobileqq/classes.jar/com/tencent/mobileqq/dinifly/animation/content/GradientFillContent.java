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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
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
    float f2 = ((PointF)localObject1).x;
    float f3 = ((PointF)localObject1).y;
    float f1 = localPointF.x;
    float f4 = localPointF.y;
    f1 = (float)Math.hypot(f1 - f2, f4 - f3);
    if (f1 <= 0.0F) {
      f1 = 0.001F;
    }
    localObject1 = new RadialGradient(f2, f3, f1, arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
    this.radialGradientCache.put(l, localObject1);
    return localObject1;
  }
  
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    if (paramT == LottieProperty.OPACITY)
    {
      this.opacityAnimation.setValueCallback(paramLottieValueCallback);
      return;
    }
    if (paramT == LottieProperty.COLOR_FILTER)
    {
      paramT = this.colorFilterAnimation;
      if (paramT != null) {
        this.layer.removeAnimation(paramT);
      }
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
    if (paramT == LottieProperty.GRADIENT_COLOR)
    {
      paramT = this.colorCallbackAnimation;
      if (paramT != null) {
        this.layer.removeAnimation(paramT);
      }
      if (paramLottieValueCallback == null)
      {
        this.colorCallbackAnimation = null;
        return;
      }
      this.linearGradientCache.clear();
      this.radialGradientCache.clear();
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
    L.beginSection("GradientFillContent#draw");
    this.path.reset();
    int i = 0;
    while (i < this.paths.size())
    {
      this.path.addPath(((PathContent)this.paths.get(i)).getPath(), paramMatrix);
      i += 1;
    }
    this.path.computeBounds(this.boundsRect, false);
    Object localObject;
    if (this.type == GradientType.LINEAR) {
      localObject = getLinearGradient();
    } else {
      localObject = getRadialGradient();
    }
    ((Shader)localObject).setLocalMatrix(paramMatrix);
    this.paint.setShader((Shader)localObject);
    paramMatrix = this.colorFilterAnimation;
    if (paramMatrix != null) {
      this.paint.setColorFilter((ColorFilter)paramMatrix.getValue());
    }
    paramInt = (int)(paramInt / 255.0F * ((Integer)this.opacityAnimation.getValue()).intValue() / 100.0F * 255.0F);
    this.paint.setAlpha(MiscUtils.clamp(paramInt, 0, 255));
    paramCanvas.drawPath(this.path, this.paint);
    L.endSection("GradientFillContent#draw");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.GradientFillContent
 * JD-Core Version:    0.7.0.1
 */