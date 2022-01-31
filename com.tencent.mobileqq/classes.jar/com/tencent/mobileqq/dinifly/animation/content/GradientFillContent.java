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
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.content.GradientColor;
import com.tencent.mobileqq.dinifly.model.content.GradientFill;
import com.tencent.mobileqq.dinifly.model.content.GradientType;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class GradientFillContent
  implements DrawingContent, BaseKeyframeAnimation.AnimationListener
{
  private static final int CACHE_STEPS_MS = 32;
  private final RectF boundsRect = new RectF();
  private final int cacheSteps;
  private final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
  private final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
  private final LongSparseArray<LinearGradient> linearGradientCache = new LongSparseArray();
  private final LottieDrawable lottieDrawable;
  private final String name;
  private final BaseKeyframeAnimation<Integer, Integer> opacityAnimation;
  private final Paint paint = new Paint(1);
  private final Path path = new Path();
  private final List<PathContent> paths = new ArrayList();
  private final LongSparseArray<RadialGradient> radialGradientCache = new LongSparseArray();
  private final Matrix shaderMatrix = new Matrix();
  private final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
  private final GradientType type;
  
  public GradientFillContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, GradientFill paramGradientFill)
  {
    this.name = paramGradientFill.getName();
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
    int[] arrayOfInt = ((GradientColor)localObject2).getColors();
    localObject2 = ((GradientColor)localObject2).getPositions();
    float f1 = ((PointF)localObject1).x;
    float f2 = ((PointF)localObject1).y;
    float f3 = localPointF.x;
    float f4 = localPointF.y;
    localObject1 = new RadialGradient(f1, f2, (float)Math.hypot(f3 - f1, f4 - f2), arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
    this.radialGradientCache.put(i, localObject1);
    return localObject1;
  }
  
  public void addColorFilter(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter) {}
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    L.beginSection("GradientFillContent#draw");
    this.path.reset();
    int i = 0;
    while (i < this.paths.size())
    {
      this.path.addPath(((PathContent)this.paths.get(i)).getPath(), paramMatrix);
      i += 1;
    }
    this.path.computeBounds(this.boundsRect, false);
    if (this.type == GradientType.Linear) {}
    for (Object localObject = getLinearGradient();; localObject = getRadialGradient())
    {
      this.shaderMatrix.set(paramMatrix);
      ((Shader)localObject).setLocalMatrix(this.shaderMatrix);
      this.paint.setShader((Shader)localObject);
      float f = paramInt / 255.0F;
      paramInt = (int)(((Integer)this.opacityAnimation.getValue()).intValue() * f / 100.0F * 255.0F);
      this.paint.setAlpha(paramInt);
      paramCanvas.drawPath(this.path, this.paint);
      L.endSection("GradientFillContent#draw");
      return;
    }
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.GradientFillContent
 * JD-Core Version:    0.7.0.1
 */