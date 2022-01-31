package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.animation.keyframe.TransformKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform;
import com.tencent.mobileqq.dinifly.model.content.Repeater;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class RepeaterContent
  implements DrawingContent, PathContent, GreedyContent, BaseKeyframeAnimation.AnimationListener
{
  private ContentGroup contentGroup;
  private final BaseKeyframeAnimation<Float, Float> copies;
  private final BaseLayer layer;
  private final LottieDrawable lottieDrawable;
  private final Matrix matrix = new Matrix();
  private final String name;
  private final BaseKeyframeAnimation<Float, Float> offset;
  private final Path path = new Path();
  private final TransformKeyframeAnimation transform;
  
  public RepeaterContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, Repeater paramRepeater)
  {
    this.lottieDrawable = paramLottieDrawable;
    this.layer = paramBaseLayer;
    this.name = paramRepeater.getName();
    this.copies = paramRepeater.getCopies().createAnimation();
    paramBaseLayer.addAnimation(this.copies);
    this.copies.addUpdateListener(this);
    this.offset = paramRepeater.getOffset().createAnimation();
    paramBaseLayer.addAnimation(this.offset);
    this.offset.addUpdateListener(this);
    this.transform = paramRepeater.getTransform().createAnimation();
    this.transform.addAnimationsToLayer(paramBaseLayer);
    this.transform.addListener(this);
  }
  
  public void absorbContent(ListIterator<Content> paramListIterator)
  {
    if (this.contentGroup != null) {
      return;
    }
    while ((paramListIterator.hasPrevious()) && (paramListIterator.previous() != this)) {}
    ArrayList localArrayList = new ArrayList();
    while (paramListIterator.hasPrevious())
    {
      localArrayList.add(paramListIterator.previous());
      paramListIterator.remove();
    }
    Collections.reverse(localArrayList);
    this.contentGroup = new ContentGroup(this.lottieDrawable, this.layer, "Repeater", localArrayList, null);
  }
  
  public void addColorFilter(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    this.contentGroup.addColorFilter(paramString1, paramString2, paramColorFilter);
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    float f1 = ((Float)this.copies.getValue()).floatValue();
    float f2 = ((Float)this.offset.getValue()).floatValue();
    float f3 = ((Float)this.transform.getStartOpacity().getValue()).floatValue() / 100.0F;
    float f4 = ((Float)this.transform.getEndOpacity().getValue()).floatValue() / 100.0F;
    int i = (int)f1 - 1;
    while (i >= 0)
    {
      this.matrix.set(paramMatrix);
      this.matrix.preConcat(this.transform.getMatrixForRepeater(i + f2));
      float f5 = paramInt;
      float f6 = MiscUtils.lerp(f3, f4, i / f1);
      this.contentGroup.draw(paramCanvas, this.matrix, (int)(f5 * f6));
      i -= 1;
    }
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
  {
    this.contentGroup.getBounds(paramRectF, paramMatrix);
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Path getPath()
  {
    Path localPath = this.contentGroup.getPath();
    this.path.reset();
    float f1 = ((Float)this.copies.getValue()).floatValue();
    float f2 = ((Float)this.offset.getValue()).floatValue();
    int i = (int)f1 - 1;
    while (i >= 0)
    {
      this.matrix.set(this.transform.getMatrixForRepeater(i + f2));
      this.path.addPath(localPath, this.matrix);
      i -= 1;
    }
    return this.path;
  }
  
  public void onValueChanged()
  {
    this.lottieDrawable.invalidateSelf();
  }
  
  public void setContents(List<Content> paramList1, List<Content> paramList2)
  {
    this.contentGroup.setContents(paramList1, paramList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.RepeaterContent
 * JD-Core Version:    0.7.0.1
 */