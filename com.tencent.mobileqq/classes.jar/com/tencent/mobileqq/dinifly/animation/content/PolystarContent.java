package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.content.PolystarShape;
import com.tencent.mobileqq.dinifly.model.content.PolystarShape.Type;
import com.tencent.mobileqq.dinifly.model.content.ShapeTrimPath.Type;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import com.tencent.mobileqq.dinifly.utils.Utils;
import java.util.List;

public class PolystarContent
  implements PathContent, BaseKeyframeAnimation.AnimationListener
{
  private static final float POLYGON_MAGIC_NUMBER = 0.25F;
  private static final float POLYSTAR_MAGIC_NUMBER = 0.47829F;
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
  @Nullable
  private TrimPathContent trimPath;
  private final PolystarShape.Type type;
  
  public PolystarContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, PolystarShape paramPolystarShape)
  {
    this.lottieDrawable = paramLottieDrawable;
    this.name = paramPolystarShape.getName();
    this.type = paramPolystarShape.getType();
    this.pointsAnimation = paramPolystarShape.getPoints().createAnimation();
    this.positionAnimation = paramPolystarShape.getPosition().createAnimation();
    this.rotationAnimation = paramPolystarShape.getRotation().createAnimation();
    this.outerRadiusAnimation = paramPolystarShape.getOuterRadius().createAnimation();
    this.outerRoundednessAnimation = paramPolystarShape.getOuterRoundedness().createAnimation();
    if (this.type == PolystarShape.Type.Star) {
      this.innerRadiusAnimation = paramPolystarShape.getInnerRadius().createAnimation();
    }
    for (this.innerRoundednessAnimation = paramPolystarShape.getInnerRoundedness().createAnimation();; this.innerRoundednessAnimation = null)
    {
      paramBaseLayer.addAnimation(this.pointsAnimation);
      paramBaseLayer.addAnimation(this.positionAnimation);
      paramBaseLayer.addAnimation(this.rotationAnimation);
      paramBaseLayer.addAnimation(this.outerRadiusAnimation);
      paramBaseLayer.addAnimation(this.outerRoundednessAnimation);
      if (this.type == PolystarShape.Type.Star)
      {
        paramBaseLayer.addAnimation(this.innerRadiusAnimation);
        paramBaseLayer.addAnimation(this.innerRoundednessAnimation);
      }
      this.pointsAnimation.addUpdateListener(this);
      this.positionAnimation.addUpdateListener(this);
      this.rotationAnimation.addUpdateListener(this);
      this.outerRadiusAnimation.addUpdateListener(this);
      this.outerRoundednessAnimation.addUpdateListener(this);
      if (this.type == PolystarShape.Type.Star)
      {
        this.outerRadiusAnimation.addUpdateListener(this);
        this.outerRoundednessAnimation.addUpdateListener(this);
      }
      return;
      this.innerRadiusAnimation = null;
    }
  }
  
  private void createPolygonPath()
  {
    int i = (int)Math.floor(((Float)this.pointsAnimation.getValue()).floatValue());
    double d1;
    float f5;
    float f1;
    float f2;
    label130:
    float f4;
    float f3;
    if (this.rotationAnimation == null)
    {
      d1 = 0.0D;
      d1 = Math.toRadians(d1 - 90.0D);
      f5 = (float)(6.283185307179586D / i);
      float f6 = ((Float)this.outerRoundednessAnimation.getValue()).floatValue() / 100.0F;
      float f7 = ((Float)this.outerRadiusAnimation.getValue()).floatValue();
      f1 = (float)(f7 * Math.cos(d1));
      f2 = (float)(f7 * Math.sin(d1));
      this.path.moveTo(f1, f2);
      d1 += f5;
      double d2 = Math.ceil(i);
      i = 0;
      if (i >= d2) {
        break label357;
      }
      f4 = (float)(f7 * Math.cos(d1));
      f3 = (float)(f7 * Math.sin(d1));
      if (f6 == 0.0F) {
        break label343;
      }
      float f9 = (float)(Math.atan2(f2, f1) - 1.570796326794897D);
      float f8 = (float)Math.cos(f9);
      f9 = (float)Math.sin(f9);
      float f11 = (float)(Math.atan2(f3, f4) - 1.570796326794897D);
      float f10 = (float)Math.cos(f11);
      f11 = (float)Math.sin(f11);
      this.path.cubicTo(f1 - f7 * f6 * 0.25F * f8, f2 - f7 * f6 * 0.25F * f9, f4 + f7 * f6 * 0.25F * f10, f3 + f7 * f6 * 0.25F * f11, f4, f3);
    }
    for (;;)
    {
      d1 += f5;
      i += 1;
      f1 = f4;
      f2 = f3;
      break label130;
      d1 = ((Float)this.rotationAnimation.getValue()).floatValue();
      break;
      label343:
      this.path.lineTo(f4, f3);
    }
    label357:
    PointF localPointF = (PointF)this.positionAnimation.getValue();
    this.path.offset(localPointF.x, localPointF.y);
    this.path.close();
  }
  
  private void createStarPath()
  {
    float f8 = ((Float)this.pointsAnimation.getValue()).floatValue();
    double d1;
    double d2;
    float f11;
    float f21;
    float f3;
    float f4;
    float f1;
    float f2;
    float f6;
    float f7;
    label231:
    int j;
    label248:
    float f12;
    float f13;
    label273:
    float f14;
    float f15;
    if (this.rotationAnimation == null)
    {
      d1 = 0.0D;
      d2 = Math.toRadians(d1 - 90.0D);
      float f20 = (float)(6.283185307179586D / f8);
      f11 = f20 / 2.0F;
      f21 = f8 - (int)f8;
      d1 = d2;
      if (f21 != 0.0F) {
        d1 = d2 + (1.0F - f21) * f11;
      }
      f3 = ((Float)this.outerRadiusAnimation.getValue()).floatValue();
      f4 = ((Float)this.innerRadiusAnimation.getValue()).floatValue();
      f1 = 0.0F;
      if (this.innerRoundednessAnimation != null) {
        f1 = ((Float)this.innerRoundednessAnimation.getValue()).floatValue() / 100.0F;
      }
      f2 = 0.0F;
      if (this.outerRoundednessAnimation != null) {
        f2 = ((Float)this.outerRoundednessAnimation.getValue()).floatValue() / 100.0F;
      }
      float f5 = 0.0F;
      if (f21 == 0.0F) {
        break label438;
      }
      f5 = f4 + (f3 - f4) * f21;
      f6 = (float)(f5 * Math.cos(d1));
      f7 = (float)(f5 * Math.sin(d1));
      this.path.moveTo(f6, f7);
      d1 += f20 * f21 / 2.0F;
      i = 0;
      d2 = Math.ceil(f8) * 2.0D;
      j = 0;
      f12 = f7;
      f13 = f6;
      if (j >= d2) {
        break label812;
      }
      if (i == 0) {
        break label480;
      }
      f6 = f3;
      f8 = f11;
      f7 = f8;
      if (f5 != 0.0F)
      {
        f7 = f8;
        if (j == d2 - 2.0D) {
          f7 = f20 * f21 / 2.0F;
        }
      }
      f8 = f6;
      if (f5 != 0.0F)
      {
        f8 = f6;
        if (j == d2 - 1.0D) {
          f8 = f5;
        }
      }
      f14 = (float)(f8 * Math.cos(d1));
      f15 = (float)(f8 * Math.sin(d1));
      if ((f1 != 0.0F) || (f2 != 0.0F)) {
        break label487;
      }
      this.path.lineTo(f14, f15);
      d1 += f7;
      if (i != 0) {
        break label806;
      }
    }
    label806:
    for (int i = 1;; i = 0)
    {
      j += 1;
      f6 = f14;
      f7 = f15;
      break label248;
      d1 = ((Float)this.rotationAnimation.getValue()).floatValue();
      break;
      label438:
      f6 = (float)(f3 * Math.cos(d1));
      f7 = (float)(f3 * Math.sin(d1));
      this.path.moveTo(f6, f7);
      d1 += f11;
      break label231;
      label480:
      f6 = f4;
      break label273;
      label487:
      f6 = (float)(Math.atan2(f12, f13) - 1.570796326794897D);
      float f16 = (float)Math.cos(f6);
      float f17 = (float)Math.sin(f6);
      f6 = (float)(Math.atan2(f15, f14) - 1.570796326794897D);
      float f18 = (float)Math.cos(f6);
      float f19 = (float)Math.sin(f6);
      label564:
      label573:
      float f9;
      label582:
      float f10;
      if (i != 0)
      {
        f6 = f1;
        if (i == 0) {
          break label734;
        }
        f8 = f2;
        if (i == 0) {
          break label741;
        }
        f9 = f4;
        if (i == 0) {
          break label748;
        }
        f10 = f3;
        label591:
        f16 = f9 * f6 * 0.47829F * f16;
        f17 = f9 * f6 * 0.47829F * f17;
        f18 = f10 * f8 * 0.47829F * f18;
        f19 = f10 * f8 * 0.47829F * f19;
        f9 = f16;
        f6 = f17;
        f8 = f18;
        f10 = f19;
        if (f21 != 0.0F)
        {
          if (j != 0) {
            break label755;
          }
          f9 = f16 * f21;
          f6 = f17 * f21;
          f10 = f19;
          f8 = f18;
        }
      }
      for (;;)
      {
        this.path.cubicTo(f13 - f9, f12 - f6, f14 + f8, f15 + f10, f14, f15);
        break;
        f6 = f2;
        break label564;
        label734:
        f8 = f1;
        break label573;
        label741:
        f9 = f3;
        break label582;
        label748:
        f10 = f4;
        break label591;
        label755:
        f9 = f16;
        f6 = f17;
        f8 = f18;
        f10 = f19;
        if (j == d2 - 1.0D)
        {
          f8 = f18 * f21;
          f10 = f19 * f21;
          f9 = f16;
          f6 = f17;
        }
      }
    }
    label812:
    PointF localPointF = (PointF)this.positionAnimation.getValue();
    this.path.offset(localPointF.x, localPointF.y);
    this.path.close();
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
    switch (1.$SwitchMap$com$tencent$mobileqq$dinifly$model$content$PolystarShape$Type[this.type.ordinal()])
    {
    }
    for (;;)
    {
      this.path.close();
      Utils.applyTrimPathIfNeeded(this.path, this.trimPath);
      this.isPathValid = true;
      return this.path;
      createStarPath();
      continue;
      createPolygonPath();
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
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.PolystarContent
 * JD-Core Version:    0.7.0.1
 */