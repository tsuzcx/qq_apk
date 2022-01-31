package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.content.ShapeFill;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class FillContent
  implements DrawingContent, BaseKeyframeAnimation.AnimationListener
{
  private final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
  private final LottieDrawable lottieDrawable;
  private final String name;
  private final BaseKeyframeAnimation<Integer, Integer> opacityAnimation;
  private final Paint paint = new Paint(1);
  private final Path path = new Path();
  private final List<PathContent> paths = new ArrayList();
  
  public FillContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, ShapeFill paramShapeFill)
  {
    this.name = paramShapeFill.getName();
    this.lottieDrawable = paramLottieDrawable;
    if ((paramShapeFill.getColor() == null) || (paramShapeFill.getOpacity() == null))
    {
      this.colorAnimation = null;
      this.opacityAnimation = null;
      return;
    }
    this.path.setFillType(paramShapeFill.getFillType());
    this.colorAnimation = paramShapeFill.getColor().createAnimation();
    this.colorAnimation.addUpdateListener(this);
    paramBaseLayer.addAnimation(this.colorAnimation);
    this.opacityAnimation = paramShapeFill.getOpacity().createAnimation();
    this.opacityAnimation.addUpdateListener(this);
    paramBaseLayer.addAnimation(this.opacityAnimation);
  }
  
  public void addColorFilter(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    this.paint.setColorFilter(paramColorFilter);
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    L.beginSection("FillContent#draw");
    this.paint.setColor(((Integer)this.colorAnimation.getValue()).intValue());
    float f = paramInt / 255.0F;
    paramInt = (int)(((Integer)this.opacityAnimation.getValue()).intValue() * f / 100.0F * 255.0F);
    this.paint.setAlpha(paramInt);
    this.path.reset();
    paramInt = 0;
    while (paramInt < this.paths.size())
    {
      this.path.addPath(((PathContent)this.paths.get(paramInt)).getPath(), paramMatrix);
      paramInt += 1;
    }
    paramCanvas.drawPath(this.path, this.paint);
    L.endSection("FillContent#draw");
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
  {
    this.path.reset();
    int i = 0;
    while (i < this.paths.size())
    {
      this.path.addPath(((PathContent)this.paths.get(i)).getPath(), paramMatrix);
      i += 1;
    }
    this.path.computeBounds(paramRectF, false);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void onValueChanged()
  {
    this.lottieDrawable.invalidateSelf();
  }
  
  public void setContents(List<Content> paramList1, List<Content> paramList2)
  {
    int i = 0;
    while (i < paramList2.size())
    {
      paramList1 = (Content)paramList2.get(i);
      if ((paramList1 instanceof PathContent)) {
        this.paths.add((PathContent)paramList1);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.FillContent
 * JD-Core Version:    0.7.0.1
 */