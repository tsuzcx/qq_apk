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
import com.tencent.mobileqq.dinifly.LottieProperty;
import com.tencent.mobileqq.dinifly.animation.LPaint;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.animation.keyframe.ColorKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.KeyPath;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.content.ShapeFill;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class FillContent
  implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener
{
  private final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
  @Nullable
  private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
  private final boolean hidden;
  private final BaseLayer layer;
  private final LottieDrawable lottieDrawable;
  private final String name;
  private final BaseKeyframeAnimation<Integer, Integer> opacityAnimation;
  private final Paint paint = new LPaint(1);
  private final Path path = new Path();
  private final List<PathContent> paths = new ArrayList();
  
  public FillContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, ShapeFill paramShapeFill)
  {
    this.layer = paramBaseLayer;
    this.name = paramShapeFill.getName();
    this.hidden = paramShapeFill.isHidden();
    this.lottieDrawable = paramLottieDrawable;
    if ((paramShapeFill.getColor() != null) && (paramShapeFill.getOpacity() != null))
    {
      this.path.setFillType(paramShapeFill.getFillType());
      this.colorAnimation = paramShapeFill.getColor().createAnimation();
      this.colorAnimation.addUpdateListener(this);
      paramBaseLayer.addAnimation(this.colorAnimation);
      this.opacityAnimation = paramShapeFill.getOpacity().createAnimation();
      this.opacityAnimation.addUpdateListener(this);
      paramBaseLayer.addAnimation(this.opacityAnimation);
      return;
    }
    this.colorAnimation = null;
    this.opacityAnimation = null;
  }
  
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    if (paramT == LottieProperty.COLOR)
    {
      this.colorAnimation.setValueCallback(paramLottieValueCallback);
      return;
    }
    if (paramT == LottieProperty.OPACITY)
    {
      this.opacityAnimation.setValueCallback(paramLottieValueCallback);
      return;
    }
    if (paramT == LottieProperty.COLOR_FILTER)
    {
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
    if (this.hidden) {
      return;
    }
    L.beginSection("FillContent#draw");
    this.paint.setColor(((ColorKeyframeAnimation)this.colorAnimation).getIntValue());
    int i = (int)(paramInt / 255.0F * ((Integer)this.opacityAnimation.getValue()).intValue() / 100.0F * 255.0F);
    Object localObject = this.paint;
    paramInt = 0;
    ((Paint)localObject).setAlpha(MiscUtils.clamp(i, 0, 255));
    localObject = this.colorFilterAnimation;
    if (localObject != null) {
      this.paint.setColorFilter((ColorFilter)((BaseKeyframeAnimation)localObject).getValue());
    }
    this.path.reset();
    while (paramInt < this.paths.size())
    {
      this.path.addPath(((PathContent)this.paths.get(paramInt)).getPath(), paramMatrix);
      paramInt += 1;
    }
    paramCanvas.drawPath(this.path, this.paint);
    L.endSection("FillContent#draw");
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
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
  
  public void resolveKeyPath(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2)
  {
    MiscUtils.resolveKeyPath(paramKeyPath1, paramInt, paramList, paramKeyPath2, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.FillContent
 * JD-Core Version:    0.7.0.1
 */