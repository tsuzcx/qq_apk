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
    if (this.type == PolystarShape.Type.STAR) {
      this.innerRadiusAnimation = paramPolystarShape.getInnerRadius().createAnimation();
    }
    for (this.innerRoundednessAnimation = paramPolystarShape.getInnerRoundedness().createAnimation();; this.innerRoundednessAnimation = null)
    {
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
    double d3;
    label134:
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
      d3 = f5;
      double d2 = Math.ceil(i);
      i = 0;
      d1 += d3;
      if (i >= d2) {
        break label365;
      }
      f4 = (float)(f7 * Math.cos(d1));
      f3 = (float)(f7 * Math.sin(d1));
      if (f6 == 0.0F) {
        break label351;
      }
      float f9 = (float)(Math.atan2(f2, f1) - 1.570796326794897D);
      float f8 = (float)Math.cos(f9);
      f9 = (float)Math.sin(f9);
      float f11 = (float)(Math.atan2(f3, f4) - 1.570796326794897D);
      float f10 = (float)Math.cos(f11);
      f11 = (float)Math.sin(f11);
      this.path.cubicTo(f1 - f8 * (f7 * f6 * 0.25F), f2 - f7 * f6 * 0.25F * f9, f4 + f10 * (f7 * f6 * 0.25F), f11 * (f7 * f6 * 0.25F) + f3, f4, f3);
    }
    for (;;)
    {
      d3 = f5;
      i += 1;
      f1 = f4;
      d1 += d3;
      f2 = f3;
      break label134;
      d1 = ((Float)this.rotationAnimation.getValue()).floatValue();
      break;
      label351:
      this.path.lineTo(f4, f3);
    }
    label365:
    PointF localPointF = (PointF)this.positionAnimation.getValue();
    this.path.offset(localPointF.x, localPointF.y);
    this.path.close();
  }
  
  private void createStarPath()
  {
    float f8 = ((Float)this.pointsAnimation.getValue()).floatValue();
    double d1;
    float f17;
    float f14;
    float f18;
    if (this.rotationAnimation == null)
    {
      d1 = 0.0D;
      d1 = Math.toRadians(d1 - 90.0D);
      f17 = (float)(6.283185307179586D / f8);
      f14 = f17 / 2.0F;
      f18 = f8 - (int)f8;
      if (f18 == 0.0F) {
        break label840;
      }
      d1 += (1.0F - f18) * f14;
    }
    label265:
    label551:
    label560:
    label569:
    label578:
    label709:
    label840:
    for (;;)
    {
      float f3 = ((Float)this.outerRadiusAnimation.getValue()).floatValue();
      float f4 = ((Float)this.innerRadiusAnimation.getValue()).floatValue();
      if (this.innerRoundednessAnimation != null) {}
      for (float f1 = ((Float)this.innerRoundednessAnimation.getValue()).floatValue() / 100.0F;; f1 = 0.0F)
      {
        float f2 = 0.0F;
        if (this.outerRoundednessAnimation != null) {
          f2 = ((Float)this.outerRoundednessAnimation.getValue()).floatValue() / 100.0F;
        }
        float f5;
        float f6;
        float f7;
        label223:
        double d2;
        int j;
        int i;
        float f10;
        float f9;
        if (f18 != 0.0F)
        {
          f5 = (f3 - f4) * f18 + f4;
          f6 = (float)(f5 * Math.cos(d1));
          f7 = (float)(f5 * Math.sin(d1));
          this.path.moveTo(f6, f7);
          d1 += f17 * f18 / 2.0F;
          d2 = Math.ceil(f8) * 2.0D;
          j = 0;
          i = 0;
          f10 = f6;
          f9 = f7;
          label248:
          if (j >= d2) {
            break label771;
          }
          if (i == 0) {
            break label467;
          }
          f6 = f3;
          if ((f5 == 0.0F) || (j != d2 - 2.0D)) {
            break label827;
          }
        }
        for (float f11 = f17 * f18 / 2.0F;; f11 = f14)
        {
          f7 = f6;
          if (f5 != 0.0F)
          {
            f7 = f6;
            if (j == d2 - 1.0D) {
              f7 = f5;
            }
          }
          float f15 = (float)(f7 * Math.cos(d1));
          float f16 = (float)(f7 * Math.sin(d1));
          if ((f1 == 0.0F) && (f2 == 0.0F))
          {
            this.path.lineTo(f15, f16);
            double d3 = f11;
            if (i != 0) {
              break label765;
            }
            i = 1;
            label382:
            j += 1;
            f9 = f16;
            f10 = f15;
            d1 += d3;
            break label248;
            d1 = ((Float)this.rotationAnimation.getValue()).floatValue();
            break;
            f6 = (float)(f3 * Math.cos(d1));
            f7 = (float)(f3 * Math.sin(d1));
            this.path.moveTo(f6, f7);
            d1 += f14;
            f5 = 0.0F;
            break label223;
            label467:
            f6 = f4;
            break label265;
          }
          f6 = (float)(Math.atan2(f9, f10) - 1.570796326794897D);
          f8 = (float)Math.cos(f6);
          float f21 = (float)Math.sin(f6);
          f6 = (float)(Math.atan2(f16, f15) - 1.570796326794897D);
          float f19 = (float)Math.cos(f6);
          float f20 = (float)Math.sin(f6);
          float f12;
          float f13;
          if (i != 0)
          {
            f6 = f1;
            if (i == 0) {
              break label709;
            }
            f7 = f2;
            if (i == 0) {
              break label716;
            }
            f12 = f4;
            if (i == 0) {
              break label723;
            }
            f13 = f3;
            f8 *= f12 * f6 * 0.47829F;
            f12 = f12 * f6 * 0.47829F * f21;
            f6 = f13 * f7 * 0.47829F * f19;
            f7 = f13 * f7 * 0.47829F * f20;
            if (f18 == 0.0F) {
              break label808;
            }
            if (j != 0) {
              break label730;
            }
            f12 *= f18;
            f13 = f8 * f18;
            f8 = f7;
            f7 = f6;
            f6 = f13;
          }
          for (;;)
          {
            this.path.cubicTo(f10 - f6, f9 - f12, f7 + f15, f8 + f16, f15, f16);
            break;
            f6 = f2;
            break label551;
            f7 = f1;
            break label560;
            label716:
            f12 = f3;
            break label569;
            label723:
            f13 = f4;
            break label578;
            label730:
            if (j == d2 - 1.0D)
            {
              f13 = f7 * f18;
              f7 = f6 * f18;
              f6 = f8;
              f8 = f13;
              continue;
              label765:
              i = 0;
              break label382;
              PointF localPointF = (PointF)this.positionAnimation.getValue();
              this.path.offset(localPointF.x, localPointF.y);
              this.path.close();
              return;
            }
            f13 = f7;
            f7 = f6;
            f6 = f8;
            f8 = f13;
          }
        }
      }
    }
  }
  
  private void invalidate()
  {
    this.isPathValid = false;
    this.lottieDrawable.invalidateSelf();
  }
  
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    if (paramT == LottieProperty.POLYSTAR_POINTS) {
      this.pointsAnimation.setValueCallback(paramLottieValueCallback);
    }
    do
    {
      return;
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
      if ((paramT == LottieProperty.POLYSTAR_INNER_RADIUS) && (this.innerRadiusAnimation != null))
      {
        this.innerRadiusAnimation.setValueCallback(paramLottieValueCallback);
        return;
      }
      if (paramT == LottieProperty.POLYSTAR_OUTER_RADIUS)
      {
        this.outerRadiusAnimation.setValueCallback(paramLottieValueCallback);
        return;
      }
      if ((paramT == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS) && (this.innerRoundednessAnimation != null))
      {
        this.innerRoundednessAnimation.setValueCallback(paramLottieValueCallback);
        return;
      }
    } while (paramT != LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS);
    this.outerRoundednessAnimation.setValueCallback(paramLottieValueCallback);
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
    switch (PolystarContent.1.$SwitchMap$com$tencent$mobileqq$dinifly$model$content$PolystarShape$Type[this.type.ordinal()])
    {
    }
    for (;;)
    {
      this.path.close();
      this.trimPaths.apply(this.path);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.PolystarContent
 * JD-Core Version:    0.7.0.1
 */