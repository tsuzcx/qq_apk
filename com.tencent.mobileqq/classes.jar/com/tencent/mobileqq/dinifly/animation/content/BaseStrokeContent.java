package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.content.ShapeTrimPath.Type;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import com.tencent.mobileqq.dinifly.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.dinifly.animation.content.Content;>;

public abstract class BaseStrokeContent
  implements DrawingContent, BaseKeyframeAnimation.AnimationListener
{
  private final List<BaseKeyframeAnimation<?, Float>> dashPatternAnimations;
  @Nullable
  private final BaseKeyframeAnimation<?, Float> dashPatternOffsetAnimation;
  private final float[] dashPatternValues;
  private final LottieDrawable lottieDrawable;
  private final BaseKeyframeAnimation<?, Integer> opacityAnimation;
  final Paint paint = new Paint(1);
  private final Path path = new Path();
  private final List<PathGroup> pathGroups = new ArrayList();
  private final PathMeasure pm = new PathMeasure();
  private final RectF rect = new RectF();
  private final Path trimPathPath = new Path();
  private final BaseKeyframeAnimation<?, Float> widthAnimation;
  
  BaseStrokeContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, Paint.Cap paramCap, Paint.Join paramJoin, AnimatableIntegerValue paramAnimatableIntegerValue, AnimatableFloatValue paramAnimatableFloatValue1, List<AnimatableFloatValue> paramList, AnimatableFloatValue paramAnimatableFloatValue2)
  {
    this.lottieDrawable = paramLottieDrawable;
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setStrokeCap(paramCap);
    this.paint.setStrokeJoin(paramJoin);
    this.opacityAnimation = paramAnimatableIntegerValue.createAnimation();
    this.widthAnimation = paramAnimatableFloatValue1.createAnimation();
    if (paramAnimatableFloatValue2 == null) {}
    for (this.dashPatternOffsetAnimation = null;; this.dashPatternOffsetAnimation = paramAnimatableFloatValue2.createAnimation())
    {
      this.dashPatternAnimations = new ArrayList(paramList.size());
      this.dashPatternValues = new float[paramList.size()];
      i = 0;
      while (i < paramList.size())
      {
        this.dashPatternAnimations.add(((AnimatableFloatValue)paramList.get(i)).createAnimation());
        i += 1;
      }
    }
    paramBaseLayer.addAnimation(this.opacityAnimation);
    paramBaseLayer.addAnimation(this.widthAnimation);
    int i = 0;
    while (i < this.dashPatternAnimations.size())
    {
      paramBaseLayer.addAnimation((BaseKeyframeAnimation)this.dashPatternAnimations.get(i));
      i += 1;
    }
    if (this.dashPatternOffsetAnimation != null) {
      paramBaseLayer.addAnimation(this.dashPatternOffsetAnimation);
    }
    this.opacityAnimation.addUpdateListener(this);
    this.widthAnimation.addUpdateListener(this);
    i = 0;
    while (i < paramList.size())
    {
      ((BaseKeyframeAnimation)this.dashPatternAnimations.get(i)).addUpdateListener(this);
      i += 1;
    }
    if (this.dashPatternOffsetAnimation != null) {
      this.dashPatternOffsetAnimation.addUpdateListener(this);
    }
  }
  
  private void applyDashPatternIfNeeded(Matrix paramMatrix)
  {
    L.beginSection("StrokeContent#applyDashPattern");
    if (this.dashPatternAnimations.isEmpty())
    {
      L.endSection("StrokeContent#applyDashPattern");
      return;
    }
    float f = Utils.getScale(paramMatrix);
    int i = 0;
    if (i < this.dashPatternAnimations.size())
    {
      this.dashPatternValues[i] = ((Float)((BaseKeyframeAnimation)this.dashPatternAnimations.get(i)).getValue()).floatValue();
      if (i % 2 == 0) {
        if (this.dashPatternValues[i] < 1.0F) {
          this.dashPatternValues[i] = 1.0F;
        }
      }
      for (;;)
      {
        paramMatrix = this.dashPatternValues;
        paramMatrix[i] *= f;
        i += 1;
        break;
        if (this.dashPatternValues[i] < 0.1F) {
          this.dashPatternValues[i] = 0.1F;
        }
      }
    }
    if (this.dashPatternOffsetAnimation == null) {}
    for (f = 0.0F;; f = ((Float)this.dashPatternOffsetAnimation.getValue()).floatValue())
    {
      this.paint.setPathEffect(new DashPathEffect(this.dashPatternValues, f));
      L.endSection("StrokeContent#applyDashPattern");
      return;
    }
  }
  
  private void applyTrimPath(Canvas paramCanvas, PathGroup paramPathGroup, Matrix paramMatrix)
  {
    L.beginSection("StrokeContent#applyTrimPath");
    if (paramPathGroup.trimPath == null)
    {
      L.endSection("StrokeContent#applyTrimPath");
      return;
    }
    this.path.reset();
    int i = paramPathGroup.paths.size() - 1;
    while (i >= 0)
    {
      this.path.addPath(((PathContent)paramPathGroup.paths.get(i)).getPath(), paramMatrix);
      i -= 1;
    }
    this.pm.setPath(this.path, false);
    for (float f1 = this.pm.getLength(); this.pm.nextContour(); f1 += this.pm.getLength()) {}
    float f2 = ((Float)paramPathGroup.trimPath.getOffset().getValue()).floatValue() * f1 / 360.0F;
    float f5 = ((Float)paramPathGroup.trimPath.getStart().getValue()).floatValue() * f1 / 100.0F + f2;
    float f6 = ((Float)paramPathGroup.trimPath.getEnd().getValue()).floatValue() * f1 / 100.0F + f2;
    f2 = 0.0F;
    i = paramPathGroup.paths.size() - 1;
    if (i >= 0)
    {
      this.trimPathPath.set(((PathContent)paramPathGroup.paths.get(i)).getPath());
      this.trimPathPath.transform(paramMatrix);
      this.pm.setPath(this.trimPathPath, false);
      float f7 = this.pm.getLength();
      float f3;
      if ((f6 > f1) && (f6 - f1 < f2 + f7) && (f2 < f6 - f1)) {
        if (f5 > f1)
        {
          f3 = (f5 - f1) / f7;
          label331:
          f4 = Math.min((f6 - f1) / f7, 1.0F);
          Utils.applyTrimPathIfNeeded(this.trimPathPath, f3, f4, 0.0F);
          paramCanvas.drawPath(this.trimPathPath, this.paint);
        }
      }
      for (;;)
      {
        f2 += f7;
        i -= 1;
        break;
        f3 = 0.0F;
        break label331;
        if ((f2 + f7 >= f5) && (f2 <= f6))
        {
          if ((f2 + f7 > f6) || (f5 >= f2)) {
            break label444;
          }
          paramCanvas.drawPath(this.trimPathPath, this.paint);
        }
      }
      label444:
      if (f5 < f2)
      {
        f3 = 0.0F;
        label455:
        if (f6 <= f2 + f7) {
          break label509;
        }
      }
      label509:
      for (float f4 = 1.0F;; f4 = (f6 - f2) / f7)
      {
        Utils.applyTrimPathIfNeeded(this.trimPathPath, f3, f4, 0.0F);
        paramCanvas.drawPath(this.trimPathPath, this.paint);
        break;
        f3 = (f5 - f2) / f7;
        break label455;
      }
    }
    L.endSection("StrokeContent#applyTrimPath");
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    L.beginSection("StrokeContent#draw");
    float f = paramInt / 255.0F;
    paramInt = (int)(((Integer)this.opacityAnimation.getValue()).intValue() * f / 100.0F * 255.0F);
    this.paint.setAlpha(paramInt);
    this.paint.setStrokeWidth(((Float)this.widthAnimation.getValue()).floatValue() * Utils.getScale(paramMatrix));
    if (this.paint.getStrokeWidth() <= 0.0F)
    {
      L.endSection("StrokeContent#draw");
      return;
    }
    applyDashPatternIfNeeded(paramMatrix);
    paramInt = 0;
    if (paramInt < this.pathGroups.size())
    {
      PathGroup localPathGroup = (PathGroup)this.pathGroups.get(paramInt);
      if (localPathGroup.trimPath != null) {
        applyTrimPath(paramCanvas, localPathGroup, paramMatrix);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        L.beginSection("StrokeContent#buildPath");
        this.path.reset();
        int i = localPathGroup.paths.size() - 1;
        while (i >= 0)
        {
          this.path.addPath(((PathContent)localPathGroup.paths.get(i)).getPath(), paramMatrix);
          i -= 1;
        }
        L.endSection("StrokeContent#buildPath");
        L.beginSection("StrokeContent#drawPath");
        paramCanvas.drawPath(this.path, this.paint);
        L.endSection("StrokeContent#drawPath");
      }
    }
    L.endSection("StrokeContent#draw");
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
  {
    L.beginSection("StrokeContent#getBounds");
    this.path.reset();
    int i = 0;
    while (i < this.pathGroups.size())
    {
      PathGroup localPathGroup = (PathGroup)this.pathGroups.get(i);
      int j = 0;
      while (j < localPathGroup.paths.size())
      {
        this.path.addPath(((PathContent)localPathGroup.paths.get(j)).getPath(), paramMatrix);
        j += 1;
      }
      i += 1;
    }
    this.path.computeBounds(this.rect, false);
    float f = ((Float)this.widthAnimation.getValue()).floatValue();
    this.rect.set(this.rect.left - f / 2.0F, this.rect.top - f / 2.0F, this.rect.right + f / 2.0F, this.rect.bottom + f / 2.0F);
    paramRectF.set(this.rect);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
    L.endSection("StrokeContent#getBounds");
  }
  
  public void onValueChanged()
  {
    this.lottieDrawable.invalidateSelf();
  }
  
  public void setContents(List<Content> paramList1, List<Content> paramList2)
  {
    Object localObject2 = null;
    int i = paramList1.size() - 1;
    Content localContent;
    Object localObject1;
    while (i >= 0)
    {
      localContent = (Content)paramList1.get(i);
      localObject1 = localObject2;
      if ((localContent instanceof TrimPathContent))
      {
        localObject1 = localObject2;
        if (((TrimPathContent)localContent).getType() == ShapeTrimPath.Type.Individually) {
          localObject1 = (TrimPathContent)localContent;
        }
      }
      i -= 1;
      localObject2 = localObject1;
    }
    if (localObject2 != null) {
      localObject2.addListener(this);
    }
    paramList1 = null;
    i = paramList2.size() - 1;
    if (i >= 0)
    {
      localContent = (Content)paramList2.get(i);
      if (((localContent instanceof TrimPathContent)) && (((TrimPathContent)localContent).getType() == ShapeTrimPath.Type.Individually))
      {
        if (paramList1 != null) {
          this.pathGroups.add(paramList1);
        }
        localObject1 = new PathGroup((TrimPathContent)localContent, null);
        ((TrimPathContent)localContent).addListener(this);
      }
      for (;;)
      {
        i -= 1;
        paramList1 = (List<Content>)localObject1;
        break;
        localObject1 = paramList1;
        if ((localContent instanceof PathContent))
        {
          localObject1 = paramList1;
          if (paramList1 == null) {
            localObject1 = new PathGroup(localObject2, null);
          }
          ((PathGroup)localObject1).paths.add((PathContent)localContent);
        }
      }
    }
    if (paramList1 != null) {
      this.pathGroups.add(paramList1);
    }
  }
  
  private static final class PathGroup
  {
    private final List<PathContent> paths = new ArrayList();
    @Nullable
    private final TrimPathContent trimPath;
    
    private PathGroup(@Nullable TrimPathContent paramTrimPathContent)
    {
      this.trimPath = paramTrimPathContent;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.BaseStrokeContent
 * JD-Core Version:    0.7.0.1
 */