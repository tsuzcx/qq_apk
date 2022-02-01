package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieProperty;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.model.KeyPath;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.content.CircleShape;
import com.tencent.mobileqq.dinifly.model.content.ShapeTrimPath.Type;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.List;

public class EllipseContent
  implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener
{
  private static final float ELLIPSE_CONTROL_POINT_PERCENTAGE = 0.55228F;
  private final CircleShape circleShape;
  private boolean isPathValid;
  private final LottieDrawable lottieDrawable;
  private final String name;
  private final Path path = new Path();
  private final BaseKeyframeAnimation<?, PointF> positionAnimation;
  private final BaseKeyframeAnimation<?, PointF> sizeAnimation;
  private CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();
  
  public EllipseContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, CircleShape paramCircleShape)
  {
    this.name = paramCircleShape.getName();
    this.lottieDrawable = paramLottieDrawable;
    this.sizeAnimation = paramCircleShape.getSize().createAnimation();
    this.positionAnimation = paramCircleShape.getPosition().createAnimation();
    this.circleShape = paramCircleShape;
    paramBaseLayer.addAnimation(this.sizeAnimation);
    paramBaseLayer.addAnimation(this.positionAnimation);
    this.sizeAnimation.addUpdateListener(this);
    this.positionAnimation.addUpdateListener(this);
  }
  
  private void invalidate()
  {
    this.isPathValid = false;
    this.lottieDrawable.invalidateSelf();
  }
  
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    if (paramT == LottieProperty.ELLIPSE_SIZE)
    {
      this.sizeAnimation.setValueCallback(paramLottieValueCallback);
      return;
    }
    if (paramT == LottieProperty.POSITION) {
      this.positionAnimation.setValueCallback(paramLottieValueCallback);
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
    if (this.circleShape.isHidden())
    {
      this.isPathValid = true;
      return this.path;
    }
    Object localObject = (PointF)this.sizeAnimation.getValue();
    float f2 = ((PointF)localObject).x / 2.0F;
    float f1 = ((PointF)localObject).y / 2.0F;
    float f3 = f2 * 0.55228F;
    float f4 = 0.55228F * f1;
    this.path.reset();
    float f5;
    float f7;
    float f6;
    if (this.circleShape.isReversed())
    {
      localObject = this.path;
      f5 = -f1;
      ((Path)localObject).moveTo(0.0F, f5);
      localObject = this.path;
      f7 = 0.0F - f3;
      float f8 = -f2;
      f6 = 0.0F - f4;
      ((Path)localObject).cubicTo(f7, f5, f8, f6, f8, 0.0F);
      localObject = this.path;
      f4 += 0.0F;
      ((Path)localObject).cubicTo(f8, f4, f7, f1, 0.0F, f1);
      localObject = this.path;
      f3 += 0.0F;
      ((Path)localObject).cubicTo(f3, f1, f2, f4, f2, 0.0F);
      this.path.cubicTo(f2, f6, f3, f5, 0.0F, f5);
    }
    else
    {
      localObject = this.path;
      f5 = -f1;
      ((Path)localObject).moveTo(0.0F, f5);
      localObject = this.path;
      f7 = f3 + 0.0F;
      f6 = 0.0F - f4;
      ((Path)localObject).cubicTo(f7, f5, f2, f6, f2, 0.0F);
      localObject = this.path;
      f4 += 0.0F;
      ((Path)localObject).cubicTo(f2, f4, f7, f1, 0.0F, f1);
      localObject = this.path;
      f3 = 0.0F - f3;
      f2 = -f2;
      ((Path)localObject).cubicTo(f3, f1, f2, f4, f2, 0.0F);
      this.path.cubicTo(f2, f6, f3, f5, 0.0F, f5);
    }
    localObject = (PointF)this.positionAnimation.getValue();
    this.path.offset(((PointF)localObject).x, ((PointF)localObject).y);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.EllipseContent
 * JD-Core Version:    0.7.0.1
 */