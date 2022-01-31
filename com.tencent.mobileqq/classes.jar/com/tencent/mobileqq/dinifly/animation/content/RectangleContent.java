package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.content.RectangleShape;
import com.tencent.mobileqq.dinifly.model.content.ShapeTrimPath.Type;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import com.tencent.mobileqq.dinifly.utils.Utils;
import java.util.List;

public class RectangleContent
  implements PathContent, BaseKeyframeAnimation.AnimationListener
{
  private final BaseKeyframeAnimation<?, Float> cornerRadiusAnimation;
  private boolean isPathValid;
  private final LottieDrawable lottieDrawable;
  private final String name;
  private final Path path = new Path();
  private final BaseKeyframeAnimation<?, PointF> positionAnimation;
  private final RectF rect = new RectF();
  private final BaseKeyframeAnimation<?, PointF> sizeAnimation;
  @Nullable
  private TrimPathContent trimPath;
  
  public RectangleContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, RectangleShape paramRectangleShape)
  {
    this.name = paramRectangleShape.getName();
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
    PointF localPointF = (PointF)this.sizeAnimation.getValue();
    float f4 = localPointF.x / 2.0F;
    float f5 = localPointF.y / 2.0F;
    if (this.cornerRadiusAnimation == null) {}
    for (float f1 = 0.0F;; f1 = ((Float)this.cornerRadiusAnimation.getValue()).floatValue())
    {
      float f3 = Math.min(f4, f5);
      float f2 = f1;
      if (f1 > f3) {
        f2 = f3;
      }
      localPointF = (PointF)this.positionAnimation.getValue();
      this.path.moveTo(localPointF.x + f4, localPointF.y - f5 + f2);
      this.path.lineTo(localPointF.x + f4, localPointF.y + f5 - f2);
      if (f2 > 0.0F)
      {
        this.rect.set(localPointF.x + f4 - 2.0F * f2, localPointF.y + f5 - 2.0F * f2, localPointF.x + f4, localPointF.y + f5);
        this.path.arcTo(this.rect, 0.0F, 90.0F, false);
      }
      this.path.lineTo(localPointF.x - f4 + f2, localPointF.y + f5);
      if (f2 > 0.0F)
      {
        this.rect.set(localPointF.x - f4, localPointF.y + f5 - 2.0F * f2, localPointF.x - f4 + 2.0F * f2, localPointF.y + f5);
        this.path.arcTo(this.rect, 90.0F, 90.0F, false);
      }
      this.path.lineTo(localPointF.x - f4, localPointF.y - f5 + f2);
      if (f2 > 0.0F)
      {
        this.rect.set(localPointF.x - f4, localPointF.y - f5, localPointF.x - f4 + 2.0F * f2, localPointF.y - f5 + 2.0F * f2);
        this.path.arcTo(this.rect, 180.0F, 90.0F, false);
      }
      this.path.lineTo(localPointF.x + f4 - f2, localPointF.y - f5);
      if (f2 > 0.0F)
      {
        this.rect.set(localPointF.x + f4 - 2.0F * f2, localPointF.y - f5, localPointF.x + f4, localPointF.y - f5 + 2.0F * f2);
        this.path.arcTo(this.rect, 270.0F, 90.0F, false);
      }
      this.path.close();
      Utils.applyTrimPathIfNeeded(this.path, this.trimPath);
      this.isPathValid = true;
      return this.path;
    }
  }
  
  public void onValueChanged()
  {
    invalidate();
  }
  
  public void setContents(List<Content> paramList1, List<Content> paramList2)
  {
    int i = 0;
    while (i < paramList1.size())
    {
      paramList2 = (Content)paramList1.get(i);
      if (((paramList2 instanceof TrimPathContent)) && (((TrimPathContent)paramList2).getType() == ShapeTrimPath.Type.Simultaneously))
      {
        this.trimPath = ((TrimPathContent)paramList2);
        this.trimPath.addListener(this);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.RectangleContent
 * JD-Core Version:    0.7.0.1
 */