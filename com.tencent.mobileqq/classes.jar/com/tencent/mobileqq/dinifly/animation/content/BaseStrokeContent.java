package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieProperty;
import com.tencent.mobileqq.dinifly.animation.LPaint;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.animation.keyframe.FloatKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.IntegerKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.KeyPath;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.content.ShapeTrimPath.Type;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import com.tencent.mobileqq.dinifly.utils.Utils;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseStrokeContent
  implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener
{
  @Nullable
  private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
  private final List<BaseKeyframeAnimation<?, Float>> dashPatternAnimations;
  @Nullable
  private final BaseKeyframeAnimation<?, Float> dashPatternOffsetAnimation;
  private final float[] dashPatternValues;
  protected final BaseLayer layer;
  private final LottieDrawable lottieDrawable;
  private final BaseKeyframeAnimation<?, Integer> opacityAnimation;
  final Paint paint = new LPaint(1);
  private final Path path = new Path();
  private final List<BaseStrokeContent.PathGroup> pathGroups = new ArrayList();
  private final PathMeasure pm = new PathMeasure();
  private final RectF rect = new RectF();
  private final Path trimPathPath = new Path();
  private final BaseKeyframeAnimation<?, Float> widthAnimation;
  
  BaseStrokeContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, Paint.Cap paramCap, Paint.Join paramJoin, float paramFloat, AnimatableIntegerValue paramAnimatableIntegerValue, AnimatableFloatValue paramAnimatableFloatValue1, List<AnimatableFloatValue> paramList, AnimatableFloatValue paramAnimatableFloatValue2)
  {
    this.lottieDrawable = paramLottieDrawable;
    this.layer = paramBaseLayer;
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setStrokeCap(paramCap);
    this.paint.setStrokeJoin(paramJoin);
    this.paint.setStrokeMiter(paramFloat);
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
    i = j;
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
  
  private void applyTrimPath(Canvas paramCanvas, BaseStrokeContent.PathGroup paramPathGroup, Matrix paramMatrix)
  {
    L.beginSection("StrokeContent#applyTrimPath");
    if (BaseStrokeContent.PathGroup.access$200(paramPathGroup) == null)
    {
      L.endSection("StrokeContent#applyTrimPath");
      return;
    }
    this.path.reset();
    int i = BaseStrokeContent.PathGroup.access$100(paramPathGroup).size() - 1;
    while (i >= 0)
    {
      this.path.addPath(((PathContent)BaseStrokeContent.PathGroup.access$100(paramPathGroup).get(i)).getPath(), paramMatrix);
      i -= 1;
    }
    this.pm.setPath(this.path, false);
    for (float f1 = this.pm.getLength(); this.pm.nextContour(); f1 = this.pm.getLength() + f1) {}
    float f2 = ((Float)BaseStrokeContent.PathGroup.access$200(paramPathGroup).getOffset().getValue()).floatValue() * f1 / 360.0F;
    float f5 = ((Float)BaseStrokeContent.PathGroup.access$200(paramPathGroup).getStart().getValue()).floatValue() * f1 / 100.0F + f2;
    float f6 = ((Float)BaseStrokeContent.PathGroup.access$200(paramPathGroup).getEnd().getValue()).floatValue() * f1 / 100.0F + f2;
    i = BaseStrokeContent.PathGroup.access$100(paramPathGroup).size() - 1;
    f2 = 0.0F;
    if (i >= 0)
    {
      this.trimPathPath.set(((PathContent)BaseStrokeContent.PathGroup.access$100(paramPathGroup).get(i)).getPath());
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
        i -= 1;
        f2 += f7;
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
  
  @CallSuper
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    if (paramT == LottieProperty.OPACITY) {
      this.opacityAnimation.setValueCallback(paramLottieValueCallback);
    }
    do
    {
      return;
      if (paramT == LottieProperty.STROKE_WIDTH)
      {
        this.widthAnimation.setValueCallback(paramLottieValueCallback);
        return;
      }
    } while (paramT != LottieProperty.COLOR_FILTER);
    if (paramLottieValueCallback == null)
    {
      this.colorFilterAnimation = null;
      return;
    }
    this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
    this.colorFilterAnimation.addUpdateListener(this);
    this.layer.addAnimation(this.colorFilterAnimation);
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    L.beginSection("StrokeContent#draw");
    if (Utils.hasZeroScaleAxis(paramMatrix))
    {
      L.endSection("StrokeContent#draw");
      return;
    }
    float f = paramInt / 255.0F;
    paramInt = (int)(((IntegerKeyframeAnimation)this.opacityAnimation).getIntValue() * f / 100.0F * 255.0F);
    this.paint.setAlpha(MiscUtils.clamp(paramInt, 0, 255));
    this.paint.setStrokeWidth(((FloatKeyframeAnimation)this.widthAnimation).getFloatValue() * Utils.getScale(paramMatrix));
    if (this.paint.getStrokeWidth() <= 0.0F)
    {
      L.endSection("StrokeContent#draw");
      return;
    }
    applyDashPatternIfNeeded(paramMatrix);
    if (this.colorFilterAnimation != null) {
      this.paint.setColorFilter((ColorFilter)this.colorFilterAnimation.getValue());
    }
    paramInt = 0;
    if (paramInt < this.pathGroups.size())
    {
      BaseStrokeContent.PathGroup localPathGroup = (BaseStrokeContent.PathGroup)this.pathGroups.get(paramInt);
      if (BaseStrokeContent.PathGroup.access$200(localPathGroup) != null) {
        applyTrimPath(paramCanvas, localPathGroup, paramMatrix);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        L.beginSection("StrokeContent#buildPath");
        this.path.reset();
        int i = BaseStrokeContent.PathGroup.access$100(localPathGroup).size() - 1;
        while (i >= 0)
        {
          this.path.addPath(((PathContent)BaseStrokeContent.PathGroup.access$100(localPathGroup).get(i)).getPath(), paramMatrix);
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
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    L.beginSection("StrokeContent#getBounds");
    this.path.reset();
    int i = 0;
    while (i < this.pathGroups.size())
    {
      BaseStrokeContent.PathGroup localPathGroup = (BaseStrokeContent.PathGroup)this.pathGroups.get(i);
      int j = 0;
      while (j < BaseStrokeContent.PathGroup.access$100(localPathGroup).size())
      {
        this.path.addPath(((PathContent)BaseStrokeContent.PathGroup.access$100(localPathGroup).get(j)).getPath(), paramMatrix);
        j += 1;
      }
      i += 1;
    }
    this.path.computeBounds(this.rect, false);
    float f1 = ((FloatKeyframeAnimation)this.widthAnimation).getFloatValue();
    paramMatrix = this.rect;
    float f2 = this.rect.left;
    float f3 = f1 / 2.0F;
    float f4 = this.rect.top;
    float f5 = f1 / 2.0F;
    float f6 = this.rect.right;
    float f7 = f1 / 2.0F;
    float f8 = this.rect.bottom;
    paramMatrix.set(f2 - f3, f4 - f5, f6 + f7, f1 / 2.0F + f8);
    paramRectF.set(this.rect);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
    L.endSection("StrokeContent#getBounds");
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
    int i = paramList1.size() - 1;
    TrimPathContent localTrimPathContent = null;
    Content localContent;
    if (i >= 0)
    {
      localContent = (Content)paramList1.get(i);
      if ((!(localContent instanceof TrimPathContent)) || (((TrimPathContent)localContent).getType() != ShapeTrimPath.Type.INDIVIDUALLY)) {
        break label232;
      }
      localTrimPathContent = (TrimPathContent)localContent;
    }
    label232:
    for (;;)
    {
      i -= 1;
      break;
      if (localTrimPathContent != null) {
        localTrimPathContent.addListener(this);
      }
      i = paramList2.size() - 1;
      paramList1 = null;
      if (i >= 0)
      {
        localContent = (Content)paramList2.get(i);
        if (((localContent instanceof TrimPathContent)) && (((TrimPathContent)localContent).getType() == ShapeTrimPath.Type.INDIVIDUALLY))
        {
          if (paramList1 != null) {
            this.pathGroups.add(paramList1);
          }
          paramList1 = new BaseStrokeContent.PathGroup((TrimPathContent)localContent, null);
          ((TrimPathContent)localContent).addListener(this);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        if ((localContent instanceof PathContent))
        {
          if (paramList1 == null) {
            paramList1 = new BaseStrokeContent.PathGroup(localTrimPathContent, null);
          }
          for (;;)
          {
            BaseStrokeContent.PathGroup.access$100(paramList1).add((PathContent)localContent);
            break;
            if (paramList1 != null) {
              this.pathGroups.add(paramList1);
            }
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.BaseStrokeContent
 * JD-Core Version:    0.7.0.1
 */