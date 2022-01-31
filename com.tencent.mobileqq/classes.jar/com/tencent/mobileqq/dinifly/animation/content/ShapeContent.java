package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Path;
import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableShapeValue;
import com.tencent.mobileqq.dinifly.model.content.ShapePath;
import com.tencent.mobileqq.dinifly.model.content.ShapeTrimPath.Type;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import com.tencent.mobileqq.dinifly.utils.Utils;
import java.util.List;

public class ShapeContent
  implements PathContent, BaseKeyframeAnimation.AnimationListener
{
  private boolean isPathValid;
  private final LottieDrawable lottieDrawable;
  private final String name;
  private final Path path = new Path();
  private final BaseKeyframeAnimation<?, Path> shapeAnimation;
  @Nullable
  private TrimPathContent trimPath;
  
  public ShapeContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, ShapePath paramShapePath)
  {
    this.name = paramShapePath.getName();
    this.lottieDrawable = paramLottieDrawable;
    this.shapeAnimation = paramShapePath.getShapePath().createAnimation();
    paramBaseLayer.addAnimation(this.shapeAnimation);
    this.shapeAnimation.addUpdateListener(this);
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
    this.path.set((Path)this.shapeAnimation.getValue());
    this.path.setFillType(Path.FillType.EVEN_ODD);
    Utils.applyTrimPathIfNeeded(this.path, this.trimPath);
    this.isPathValid = true;
    return this.path;
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
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.ShapeContent
 * JD-Core Version:    0.7.0.1
 */