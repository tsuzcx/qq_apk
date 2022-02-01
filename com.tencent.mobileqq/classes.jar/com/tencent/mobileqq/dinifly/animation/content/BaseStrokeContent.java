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
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
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
import java.util.List<Lcom.tencent.mobileqq.dinifly.animation.content.Content;>;

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
    if (paramAnimatableFloatValue2 == null) {
      this.dashPatternOffsetAnimation = null;
    } else {
      this.dashPatternOffsetAnimation = paramAnimatableFloatValue2.createAnimation();
    }
    this.dashPatternAnimations = new ArrayList(paramList.size());
    this.dashPatternValues = new float[paramList.size()];
    int j = 0;
    int i = 0;
    while (i < paramList.size())
    {
      this.dashPatternAnimations.add(((AnimatableFloatValue)paramList.get(i)).createAnimation());
      i += 1;
    }
    paramBaseLayer.addAnimation(this.opacityAnimation);
    paramBaseLayer.addAnimation(this.widthAnimation);
    i = 0;
    while (i < this.dashPatternAnimations.size())
    {
      paramBaseLayer.addAnimation((BaseKeyframeAnimation)this.dashPatternAnimations.get(i));
      i += 1;
    }
    paramLottieDrawable = this.dashPatternOffsetAnimation;
    if (paramLottieDrawable != null) {
      paramBaseLayer.addAnimation(paramLottieDrawable);
    }
    this.opacityAnimation.addUpdateListener(this);
    this.widthAnimation.addUpdateListener(this);
    i = j;
    while (i < paramList.size())
    {
      ((BaseKeyframeAnimation)this.dashPatternAnimations.get(i)).addUpdateListener(this);
      i += 1;
    }
    paramLottieDrawable = this.dashPatternOffsetAnimation;
    if (paramLottieDrawable != null) {
      paramLottieDrawable.addUpdateListener(this);
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
    while (i < this.dashPatternAnimations.size())
    {
      this.dashPatternValues[i] = ((Float)((BaseKeyframeAnimation)this.dashPatternAnimations.get(i)).getValue()).floatValue();
      if (i % 2 == 0)
      {
        paramMatrix = this.dashPatternValues;
        if (paramMatrix[i] < 1.0F) {
          paramMatrix[i] = 1.0F;
        }
      }
      else
      {
        paramMatrix = this.dashPatternValues;
        if (paramMatrix[i] < 0.1F) {
          paramMatrix[i] = 0.1F;
        }
      }
      paramMatrix = this.dashPatternValues;
      paramMatrix[i] *= f;
      i += 1;
    }
    paramMatrix = this.dashPatternOffsetAnimation;
    if (paramMatrix == null) {
      f = 0.0F;
    } else {
      f *= ((Float)paramMatrix.getValue()).floatValue();
    }
    this.paint.setPathEffect(new DashPathEffect(this.dashPatternValues, f));
    L.endSection("StrokeContent#applyDashPattern");
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
    for (float f1 = this.pm.getLength(); this.pm.nextContour(); f1 += this.pm.getLength()) {}
    float f2 = ((Float)BaseStrokeContent.PathGroup.access$200(paramPathGroup).getOffset().getValue()).floatValue() * f1 / 360.0F;
    float f5 = ((Float)BaseStrokeContent.PathGroup.access$200(paramPathGroup).getStart().getValue()).floatValue() * f1 / 100.0F + f2;
    float f6 = ((Float)BaseStrokeContent.PathGroup.access$200(paramPathGroup).getEnd().getValue()).floatValue() * f1 / 100.0F + f2;
    i = BaseStrokeContent.PathGroup.access$100(paramPathGroup).size() - 1;
    f2 = 0.0F;
    while (i >= 0)
    {
      this.trimPathPath.set(((PathContent)BaseStrokeContent.PathGroup.access$100(paramPathGroup).get(i)).getPath());
      this.trimPathPath.transform(paramMatrix);
      this.pm.setPath(this.trimPathPath, false);
      float f7 = this.pm.getLength();
      float f4 = 1.0F;
      float f3;
      if (f6 > f1)
      {
        f8 = f6 - f1;
        if ((f8 < f2 + f7) && (f2 < f8))
        {
          if (f5 > f1) {
            f3 = (f5 - f1) / f7;
          } else {
            f3 = 0.0F;
          }
          f4 = Math.min(f8 / f7, 1.0F);
          Utils.applyTrimPathIfNeeded(this.trimPathPath, f3, f4, 0.0F);
          paramCanvas.drawPath(this.trimPathPath, this.paint);
          break label505;
        }
      }
      float f8 = f2 + f7;
      if ((f8 >= f5) && (f2 <= f6)) {
        if ((f8 <= f6) && (f5 < f2))
        {
          paramCanvas.drawPath(this.trimPathPath, this.paint);
        }
        else
        {
          if (f5 < f2) {
            f3 = 0.0F;
          } else {
            f3 = (f5 - f2) / f7;
          }
          if (f6 <= f8) {
            f4 = (f6 - f2) / f7;
          }
          Utils.applyTrimPathIfNeeded(this.trimPathPath, f3, f4, 0.0F);
          paramCanvas.drawPath(this.trimPathPath, this.paint);
        }
      }
      label505:
      f2 += f7;
      i -= 1;
    }
    L.endSection("StrokeContent#applyTrimPath");
  }
  
  @CallSuper
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    if (paramT == LottieProperty.OPACITY)
    {
      this.opacityAnimation.setValueCallback(paramLottieValueCallback);
      return;
    }
    if (paramT == LottieProperty.STROKE_WIDTH)
    {
      this.widthAnimation.setValueCallback(paramLottieValueCallback);
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
    }
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    L.beginSection("StrokeContent#draw");
    if (Utils.hasZeroScaleAxis(paramMatrix))
    {
      L.endSection("StrokeContent#draw");
      return;
    }
    paramInt = (int)(paramInt / 255.0F * ((IntegerKeyframeAnimation)this.opacityAnimation).getIntValue() / 100.0F * 255.0F);
    Object localObject = this.paint;
    int i = 0;
    ((Paint)localObject).setAlpha(MiscUtils.clamp(paramInt, 0, 255));
    this.paint.setStrokeWidth(((FloatKeyframeAnimation)this.widthAnimation).getFloatValue() * Utils.getScale(paramMatrix));
    if (this.paint.getStrokeWidth() <= 0.0F)
    {
      L.endSection("StrokeContent#draw");
      return;
    }
    applyDashPatternIfNeeded(paramMatrix);
    localObject = this.colorFilterAnimation;
    paramInt = i;
    if (localObject != null)
    {
      this.paint.setColorFilter((ColorFilter)((BaseKeyframeAnimation)localObject).getValue());
      paramInt = i;
    }
    while (paramInt < this.pathGroups.size())
    {
      localObject = (BaseStrokeContent.PathGroup)this.pathGroups.get(paramInt);
      if (BaseStrokeContent.PathGroup.access$200((BaseStrokeContent.PathGroup)localObject) != null)
      {
        applyTrimPath(paramCanvas, (BaseStrokeContent.PathGroup)localObject, paramMatrix);
      }
      else
      {
        L.beginSection("StrokeContent#buildPath");
        this.path.reset();
        i = BaseStrokeContent.PathGroup.access$100((BaseStrokeContent.PathGroup)localObject).size() - 1;
        while (i >= 0)
        {
          this.path.addPath(((PathContent)BaseStrokeContent.PathGroup.access$100((BaseStrokeContent.PathGroup)localObject).get(i)).getPath(), paramMatrix);
          i -= 1;
        }
        L.endSection("StrokeContent#buildPath");
        L.beginSection("StrokeContent#drawPath");
        paramCanvas.drawPath(this.path, this.paint);
        L.endSection("StrokeContent#drawPath");
      }
      paramInt += 1;
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
    float f2 = ((FloatKeyframeAnimation)this.widthAnimation).getFloatValue();
    paramMatrix = this.rect;
    float f1 = paramMatrix.left;
    f2 /= 2.0F;
    paramMatrix.set(f1 - f2, this.rect.top - f2, this.rect.right + f2, this.rect.bottom + f2);
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
    Object localObject3;
    Object localObject1;
    for (Object localObject2 = null; i >= 0; localObject2 = localObject1)
    {
      localObject3 = (Content)paramList1.get(i);
      localObject1 = localObject2;
      if ((localObject3 instanceof TrimPathContent))
      {
        localObject3 = (TrimPathContent)localObject3;
        localObject1 = localObject2;
        if (((TrimPathContent)localObject3).getType() == ShapeTrimPath.Type.INDIVIDUALLY) {
          localObject1 = localObject3;
        }
      }
      i -= 1;
    }
    if (localObject2 != null) {
      localObject2.addListener(this);
    }
    i = paramList2.size() - 1;
    for (paramList1 = null; i >= 0; paramList1 = (List<Content>)localObject1)
    {
      localObject3 = (Content)paramList2.get(i);
      if ((localObject3 instanceof TrimPathContent))
      {
        TrimPathContent localTrimPathContent = (TrimPathContent)localObject3;
        if (localTrimPathContent.getType() == ShapeTrimPath.Type.INDIVIDUALLY)
        {
          if (paramList1 != null) {
            this.pathGroups.add(paramList1);
          }
          localObject1 = new BaseStrokeContent.PathGroup(localTrimPathContent, null);
          localTrimPathContent.addListener(this);
          break label223;
        }
      }
      localObject1 = paramList1;
      if ((localObject3 instanceof PathContent))
      {
        localObject1 = paramList1;
        if (paramList1 == null) {
          localObject1 = new BaseStrokeContent.PathGroup(localObject2, null);
        }
        BaseStrokeContent.PathGroup.access$100((BaseStrokeContent.PathGroup)localObject1).add((PathContent)localObject3);
      }
      label223:
      i -= 1;
    }
    if (paramList1 != null) {
      this.pathGroups.add(paramList1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.BaseStrokeContent
 * JD-Core Version:    0.7.0.1
 */