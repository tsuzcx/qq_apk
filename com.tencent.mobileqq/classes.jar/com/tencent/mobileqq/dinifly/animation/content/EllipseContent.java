package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
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
    if (paramT == LottieProperty.ELLIPSE_SIZE) {
      this.sizeAnimation.setValueCallback(paramLottieValueCallback);
    }
    while (paramT != LottieProperty.POSITION) {
      return;
    }
    this.positionAnimation.setValueCallback(paramLottieValueCallback);
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
    PointF localPointF = (PointF)this.sizeAnimation.getValue();
    float f1 = localPointF.x / 2.0F;
    float f2 = localPointF.y / 2.0F;
    float f3 = f1 * 0.55228F;
    float f4 = f2 * 0.55228F;
    this.path.reset();
    if (this.circleShape.isReversed())
    {
      this.path.moveTo(0.0F, -f2);
      this.path.cubicTo(0.0F - f3, -f2, -f1, 0.0F - f4, -f1, 0.0F);
      this.path.cubicTo(-f1, 0.0F + f4, 0.0F - f3, f2, 0.0F, f2);
      this.path.cubicTo(0.0F + f3, f2, f1, 0.0F + f4, f1, 0.0F);
      this.path.cubicTo(f1, 0.0F - f4, 0.0F + f3, -f2, 0.0F, -f2);
    }
    for (;;)
    {
      localPointF = (PointF)this.positionAnimation.getValue();
      this.path.offset(localPointF.x, localPointF.y);
      this.path.close();
      this.trimPaths.apply(this.path);
      this.isPathValid = true;
      return this.path;
      this.path.moveTo(0.0F, -f2);
      this.path.cubicTo(0.0F + f3, -f2, f1, 0.0F - f4, f1, 0.0F);
      this.path.cubicTo(f1, 0.0F + f4, 0.0F + f3, f2, 0.0F, f2);
      this.path.cubicTo(0.0F - f3, f2, -f1, 0.0F + f4, -f1, 0.0F);
      this.path.cubicTo(-f1, 0.0F - f4, 0.0F - f3, -f2, 0.0F, -f2);
    }
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
      if (((paramList2 instanceof TrimPathContent)) && (((TrimPathContent)paramList2).getType() == ShapeTrimPath.Type.SIMULTANEOUSLY))
      {
        paramList2 = (TrimPathContent)paramList2;
        this.trimPaths.addTrimPath(paramList2);
        paramList2.addListener(this);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.EllipseContent
 * JD-Core Version:    0.7.0.1
 */