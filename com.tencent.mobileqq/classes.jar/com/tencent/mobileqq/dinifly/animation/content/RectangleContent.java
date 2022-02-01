package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieProperty;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.animation.keyframe.FloatKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.KeyPath;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.content.RectangleShape;
import com.tencent.mobileqq.dinifly.model.content.ShapeTrimPath.Type;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.List;

public class RectangleContent
  implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener
{
  private final BaseKeyframeAnimation<?, Float> cornerRadiusAnimation;
  private final boolean hidden;
  private boolean isPathValid;
  private final LottieDrawable lottieDrawable;
  private final String name;
  private final Path path = new Path();
  private final BaseKeyframeAnimation<?, PointF> positionAnimation;
  private final RectF rect = new RectF();
  private final BaseKeyframeAnimation<?, PointF> sizeAnimation;
  private CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();
  
  public RectangleContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, RectangleShape paramRectangleShape)
  {
    this.name = paramRectangleShape.getName();
    this.hidden = paramRectangleShape.isHidden();
    this.lottieDrawable = paramLottieDrawable;
    this.positionAnimation = paramRectangleShape.getPosition().createAnimation();
    this.sizeAnimation = paramRectangleShape.getSize().createAnimation();
    this.cornerRadiusAnimation = paramRectangleShape.getCornerRadius().createAnimation();
    paramBaseLayer.addAnimation(this.positionAnimation);
    paramBaseLayer.addAnimation(this.sizeAnimation);
    paramBaseLayer.addAnimation(this.cornerRadiusAnimation);
    this.positionAnimation.addUpdateListener(this);
    this.sizeAnimation.addUpdateListener(this);
    this.cornerRadiusAnimation.addUpdateListener(this);
  }
  
  private void invalidate()
  {
    this.isPathValid = false;
    this.lottieDrawable.invalidateSelf();
  }
  
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    if (paramT == LottieProperty.RECTANGLE_SIZE)
    {
      this.sizeAnimation.setValueCallback(paramLottieValueCallback);
      return;
    }
    if (paramT == LottieProperty.POSITION)
    {
      this.positionAnimation.setValueCallback(paramLottieValueCallback);
      return;
    }
    if (paramT == LottieProperty.CORNER_RADIUS) {
      this.cornerRadiusAnimation.setValueCallback(paramLottieValueCallback);
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Path getPath()
  {
    if (this.isPathValid) {
      return this.path;
    }
    this.path.reset();
    if (this.hidden)
    {
      this.isPathValid = true;
      return this.path;
    }
    Object localObject = (PointF)this.sizeAnimation.getValue();
    float f4 = ((PointF)localObject).x / 2.0F;
    float f5 = ((PointF)localObject).y / 2.0F;
    localObject = this.cornerRadiusAnimation;
    float f1;
    if (localObject == null) {
      f1 = 0.0F;
    } else {
      f1 = ((FloatKeyframeAnimation)localObject).getFloatValue();
    }
    float f3 = Math.min(f4, f5);
    float f2 = f1;
    if (f1 > f3) {
      f2 = f3;
    }
    localObject = (PointF)this.positionAnimation.getValue();
    this.path.moveTo(((PointF)localObject).x + f4, ((PointF)localObject).y - f5 + f2);
    this.path.lineTo(((PointF)localObject).x + f4, ((PointF)localObject).y + f5 - f2);
    RectF localRectF;
    if (f2 > 0.0F)
    {
      localRectF = this.rect;
      f1 = ((PointF)localObject).x;
      f3 = f2 * 2.0F;
      localRectF.set(f1 + f4 - f3, ((PointF)localObject).y + f5 - f3, ((PointF)localObject).x + f4, ((PointF)localObject).y + f5);
      this.path.arcTo(this.rect, 0.0F, 90.0F, false);
    }
    this.path.lineTo(((PointF)localObject).x - f4 + f2, ((PointF)localObject).y + f5);
    float f6;
    if (f2 > 0.0F)
    {
      localRectF = this.rect;
      f1 = ((PointF)localObject).x;
      f3 = ((PointF)localObject).y;
      f6 = f2 * 2.0F;
      localRectF.set(f1 - f4, f3 + f5 - f6, ((PointF)localObject).x - f4 + f6, ((PointF)localObject).y + f5);
      this.path.arcTo(this.rect, 90.0F, 90.0F, false);
    }
    this.path.lineTo(((PointF)localObject).x - f4, ((PointF)localObject).y - f5 + f2);
    if (f2 > 0.0F)
    {
      localRectF = this.rect;
      f1 = ((PointF)localObject).x;
      f3 = ((PointF)localObject).y;
      f6 = ((PointF)localObject).x;
      float f7 = f2 * 2.0F;
      localRectF.set(f1 - f4, f3 - f5, f6 - f4 + f7, ((PointF)localObject).y - f5 + f7);
      this.path.arcTo(this.rect, 180.0F, 90.0F, false);
    }
    this.path.lineTo(((PointF)localObject).x + f4 - f2, ((PointF)localObject).y - f5);
    if (f2 > 0.0F)
    {
      localRectF = this.rect;
      f1 = ((PointF)localObject).x;
      f2 *= 2.0F;
      localRectF.set(f1 + f4 - f2, ((PointF)localObject).y - f5, ((PointF)localObject).x + f4, ((PointF)localObject).y - f5 + f2);
      this.path.arcTo(this.rect, 270.0F, 90.0F, false);
    }
    this.path.close();
    this.trimPaths.apply(this.path);
    this.isPathValid = true;
    return this.path;
  }
  
  public void onValueChanged()
  {
    invalidate();
  }
  
  public void resolveKeyPath(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2)
  {
    MiscUtils.resolveKeyPath(paramKeyPath1, paramInt, paramList, paramKeyPath2, this);
  }
  
  public void setContents(List<Content> paramList1, List<Content> paramList2)
  {
    int i = 0;
    while (i < paramList1.size())
    {
      paramList2 = (Content)paramList1.get(i);
      if ((paramList2 instanceof TrimPathContent))
      {
        paramList2 = (TrimPathContent)paramList2;
        if (paramList2.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY)
        {
          this.trimPaths.addTrimPath(paramList2);
          paramList2.addListener(this);
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.RectangleContent
 * JD-Core Version:    0.7.0.1
 */