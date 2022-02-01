package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieProperty;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.model.KeyPath;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.content.PolystarShape;
import com.tencent.mobileqq.dinifly.model.content.PolystarShape.Type;
import com.tencent.mobileqq.dinifly.model.content.ShapeTrimPath.Type;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.List;

public class PolystarContent
  implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener
{
  private static final float POLYGON_MAGIC_NUMBER = 0.25F;
  private static final float POLYSTAR_MAGIC_NUMBER = 0.47829F;
  private final boolean hidden;
  @Nullable
  private final BaseKeyframeAnimation<?, Float> innerRadiusAnimation;
  @Nullable
  private final BaseKeyframeAnimation<?, Float> innerRoundednessAnimation;
  private boolean isPathValid;
  private final LottieDrawable lottieDrawable;
  private final String name;
  private final BaseKeyframeAnimation<?, Float> outerRadiusAnimation;
  private final BaseKeyframeAnimation<?, Float> outerRoundednessAnimation;
  private final Path path = new Path();
  private final BaseKeyframeAnimation<?, Float> pointsAnimation;
  private final BaseKeyframeAnimation<?, PointF> positionAnimation;
  private final BaseKeyframeAnimation<?, Float> rotationAnimation;
  private CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();
  private final PolystarShape.Type type;
  
  public PolystarContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, PolystarShape paramPolystarShape)
  {
    this.lottieDrawable = paramLottieDrawable;
    this.name = paramPolystarShape.getName();
    this.type = paramPolystarShape.getType();
    this.hidden = paramPolystarShape.isHidden();
    this.pointsAnimation = paramPolystarShape.getPoints().createAnimation();
    this.positionAnimation = paramPolystarShape.getPosition().createAnimation();
    this.rotationAnimation = paramPolystarShape.getRotation().createAnimation();
    this.outerRadiusAnimation = paramPolystarShape.getOuterRadius().createAnimation();
    this.outerRoundednessAnimation = paramPolystarShape.getOuterRoundedness().createAnimation();
    if (this.type == PolystarShape.Type.STAR)
    {
      this.innerRadiusAnimation = paramPolystarShape.getInnerRadius().createAnimation();
      this.innerRoundednessAnimation = paramPolystarShape.getInnerRoundedness().createAnimation();
    }
    else
    {
      this.innerRadiusAnimation = null;
      this.innerRoundednessAnimation = null;
    }
    paramBaseLayer.addAnimation(this.pointsAnimation);
    paramBaseLayer.addAnimation(this.positionAnimation);
    paramBaseLayer.addAnimation(this.rotationAnimation);
    paramBaseLayer.addAnimation(this.outerRadiusAnimation);
    paramBaseLayer.addAnimation(this.outerRoundednessAnimation);
    if (this.type == PolystarShape.Type.STAR)
    {
      paramBaseLayer.addAnimation(this.innerRadiusAnimation);
      paramBaseLayer.addAnimation(this.innerRoundednessAnimation);
    }
    this.pointsAnimation.addUpdateListener(this);
    this.positionAnimation.addUpdateListener(this);
    this.rotationAnimation.addUpdateListener(this);
    this.outerRadiusAnimation.addUpdateListener(this);
    this.outerRoundednessAnimation.addUpdateListener(this);
    if (this.type == PolystarShape.Type.STAR)
    {
      this.innerRadiusAnimation.addUpdateListener(this);
      this.innerRoundednessAnimation.addUpdateListener(this);
    }
  }
  
  private void createPolygonPath()
  {
    int i = (int)Math.floor(((Float)this.pointsAnimation.getValue()).floatValue());
    Object localObject = this.rotationAnimation;
    if (localObject == null) {
      d1 = 0.0D;
    } else {
      d1 = ((Float)((BaseKeyframeAnimation)localObject).getValue()).floatValue();
    }
    double d4 = Math.toRadians(d1 - 90.0D);
    double d3 = i;
    Double.isNaN(d3);
    float f3 = (float)(6.283185307179586D / d3);
    float f5 = ((Float)this.outerRoundednessAnimation.getValue()).floatValue() / 100.0F;
    float f6 = ((Float)this.outerRadiusAnimation.getValue()).floatValue();
    double d2 = f6;
    double d1 = Math.cos(d4);
    Double.isNaN(d2);
    float f1 = (float)(d1 * d2);
    d1 = Math.sin(d4);
    Double.isNaN(d2);
    float f2 = (float)(d1 * d2);
    this.path.moveTo(f1, f2);
    d1 = f3;
    Double.isNaN(d1);
    d4 += d1;
    d3 = Math.ceil(d3);
    i = 0;
    while (i < d3)
    {
      double d5 = Math.cos(d4);
      Double.isNaN(d2);
      f3 = (float)(d5 * d2);
      d5 = Math.sin(d4);
      Double.isNaN(d2);
      float f4 = (float)(d2 * d5);
      if (f5 != 0.0F)
      {
        d5 = (float)(Math.atan2(f2, f1) - 1.570796326794897D);
        float f7 = (float)Math.cos(d5);
        float f8 = (float)Math.sin(d5);
        d5 = (float)(Math.atan2(f4, f3) - 1.570796326794897D);
        float f9 = (float)Math.cos(d5);
        float f10 = (float)Math.sin(d5);
        float f11 = f6 * f5 * 0.25F;
        this.path.cubicTo(f1 - f7 * f11, f2 - f8 * f11, f3 + f9 * f11, f4 + f11 * f10, f3, f4);
      }
      else
      {
        this.path.lineTo(f3, f4);
      }
      Double.isNaN(d1);
      d4 += d1;
      i += 1;
      f2 = f4;
      f1 = f3;
    }
    localObject = (PointF)this.positionAnimation.getValue();
    this.path.offset(((PointF)localObject).x, ((PointF)localObject).y);
    this.path.close();
  }
  
  private void createStarPath()
  {
    float f1 = ((Float)this.pointsAnimation.getValue()).floatValue();
    Object localObject = this.rotationAnimation;
    if (localObject == null) {
      d1 = 0.0D;
    } else {
      d1 = ((Float)((BaseKeyframeAnimation)localObject).getValue()).floatValue();
    }
    double d2 = Math.toRadians(d1 - 90.0D);
    double d3 = f1;
    Double.isNaN(d3);
    float f10 = (float)(6.283185307179586D / d3);
    float f8 = f10 / 2.0F;
    float f23 = f1 - (int)f1;
    double d1 = d2;
    if (f23 != 0.0F)
    {
      d1 = (1.0F - f23) * f8;
      Double.isNaN(d1);
      d1 = d2 + d1;
    }
    float f7 = ((Float)this.outerRadiusAnimation.getValue()).floatValue();
    f1 = ((Float)this.innerRadiusAnimation.getValue()).floatValue();
    localObject = this.innerRoundednessAnimation;
    float f3;
    if (localObject != null) {
      f3 = ((Float)((BaseKeyframeAnimation)localObject).getValue()).floatValue() / 100.0F;
    } else {
      f3 = 0.0F;
    }
    localObject = this.outerRoundednessAnimation;
    float f6;
    if (localObject != null) {
      f6 = ((Float)((BaseKeyframeAnimation)localObject).getValue()).floatValue() / 100.0F;
    } else {
      f6 = 0.0F;
    }
    float f4;
    double d4;
    if (f23 != 0.0F)
    {
      f4 = (f7 - f1) * f23 + f1;
      d2 = f4;
      d4 = Math.cos(d1);
      Double.isNaN(d2);
      f2 = (float)(d2 * d4);
      d4 = Math.sin(d1);
      Double.isNaN(d2);
      f5 = (float)(d2 * d4);
      this.path.moveTo(f2, f5);
      d2 = f10 * f23 / 2.0F;
      Double.isNaN(d2);
      d1 += d2;
    }
    else
    {
      d2 = f7;
      d4 = Math.cos(d1);
      Double.isNaN(d2);
      f2 = (float)(d2 * d4);
      d4 = Math.sin(d1);
      Double.isNaN(d2);
      f5 = (float)(d2 * d4);
      this.path.moveTo(f2, f5);
      d2 = f8;
      Double.isNaN(d2);
      d1 += d2;
      f4 = 0.0F;
    }
    d2 = Math.ceil(d3) * 2.0D;
    int i = 0;
    int j = 0;
    float f12 = f5;
    float f11 = f2;
    float f5 = f8;
    float f2 = f7;
    for (;;)
    {
      d3 = i;
      if (d3 >= d2) {
        break;
      }
      if (j != 0) {
        f7 = f2;
      } else {
        f7 = f1;
      }
      float f14;
      if ((f4 != 0.0F) && (d3 == d2 - 2.0D)) {
        f14 = f10 * f23 / 2.0F;
      } else {
        f14 = f5;
      }
      if ((f4 != 0.0F) && (d3 == d2 - 1.0D)) {
        f7 = f4;
      }
      d4 = f7;
      double d5 = Math.cos(d1);
      Double.isNaN(d4);
      float f15 = (float)(d4 * d5);
      d5 = Math.sin(d1);
      Double.isNaN(d4);
      float f13 = (float)(d4 * d5);
      if ((f3 == 0.0F) && (f6 == 0.0F))
      {
        this.path.lineTo(f15, f13);
      }
      else
      {
        float f17 = f15;
        d4 = f12;
        f7 = f1;
        f8 = f3;
        d4 = (float)(Math.atan2(d4, f11) - 1.570796326794897D);
        float f19 = (float)Math.cos(d4);
        float f20 = (float)Math.sin(d4);
        float f9 = f6;
        d4 = f13;
        float f18 = f13;
        d4 = (float)(Math.atan2(d4, f17) - 1.570796326794897D);
        float f21 = (float)Math.cos(d4);
        float f22 = (float)Math.sin(d4);
        if (j != 0) {
          f16 = f8;
        } else {
          f16 = f9;
        }
        if (j != 0) {
          f8 = f9;
        }
        if (j != 0) {
          f9 = f7;
        } else {
          f9 = f2;
        }
        if (j != 0) {
          f7 = f2;
        }
        f9 = f9 * f16 * 0.47829F;
        f19 *= f9;
        f20 = f9 * f20;
        f7 = f7 * f8 * 0.47829F;
        f21 *= f7;
        f22 = f7 * f22;
        f7 = f19;
        f8 = f21;
        f9 = f20;
        float f16 = f22;
        if (f23 != 0.0F) {
          if (i == 0)
          {
            f7 = f19 * f23;
            f9 = f20 * f23;
            f8 = f21;
            f16 = f22;
          }
          else
          {
            f7 = f19;
            f8 = f21;
            f9 = f20;
            f16 = f22;
            if (d3 == d2 - 1.0D)
            {
              f8 = f21 * f23;
              f16 = f22 * f23;
              f9 = f20;
              f7 = f19;
            }
          }
        }
        this.path.cubicTo(f11 - f7, f12 - f9, f17 + f8, f18 + f16, f17, f18);
      }
      d3 = f14;
      Double.isNaN(d3);
      d1 += d3;
      j ^= 0x1;
      i += 1;
      f11 = f15;
      f12 = f13;
    }
    localObject = (PointF)this.positionAnimation.getValue();
    this.path.offset(((PointF)localObject).x, ((PointF)localObject).y);
    this.path.close();
  }
  
  private void invalidate()
  {
    this.isPathValid = false;
    this.lottieDrawable.invalidateSelf();
  }
  
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    if (paramT == LottieProperty.POLYSTAR_POINTS)
    {
      this.pointsAnimation.setValueCallback(paramLottieValueCallback);
      return;
    }
    if (paramT == LottieProperty.POLYSTAR_ROTATION)
    {
      this.rotationAnimation.setValueCallback(paramLottieValueCallback);
      return;
    }
    if (paramT == LottieProperty.POSITION)
    {
      this.positionAnimation.setValueCallback(paramLottieValueCallback);
      return;
    }
    BaseKeyframeAnimation localBaseKeyframeAnimation;
    if (paramT == LottieProperty.POLYSTAR_INNER_RADIUS)
    {
      localBaseKeyframeAnimation = this.innerRadiusAnimation;
      if (localBaseKeyframeAnimation != null)
      {
        localBaseKeyframeAnimation.setValueCallback(paramLottieValueCallback);
        return;
      }
    }
    if (paramT == LottieProperty.POLYSTAR_OUTER_RADIUS)
    {
      this.outerRadiusAnimation.setValueCallback(paramLottieValueCallback);
      return;
    }
    if (paramT == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS)
    {
      localBaseKeyframeAnimation = this.innerRoundednessAnimation;
      if (localBaseKeyframeAnimation != null)
      {
        localBaseKeyframeAnimation.setValueCallback(paramLottieValueCallback);
        return;
      }
    }
    if (paramT == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
      this.outerRoundednessAnimation.setValueCallback(paramLottieValueCallback);
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
    int i = PolystarContent.1.$SwitchMap$com$tencent$mobileqq$dinifly$model$content$PolystarShape$Type[this.type.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        createPolygonPath();
      }
    }
    else {
      createStarPath();
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
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.PolystarContent
 * JD-Core Version:    0.7.0.1
 */