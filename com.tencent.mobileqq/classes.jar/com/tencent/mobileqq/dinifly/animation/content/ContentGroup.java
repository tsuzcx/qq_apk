package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.LPaint;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.animation.keyframe.TransformKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.KeyPath;
import com.tencent.mobileqq.dinifly.model.KeyPathElement;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform;
import com.tencent.mobileqq.dinifly.model.content.ContentModel;
import com.tencent.mobileqq.dinifly.model.content.ShapeGroup;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import com.tencent.mobileqq.dinifly.utils.Utils;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class ContentGroup
  implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement
{
  private final List<Content> contents;
  private final boolean hidden;
  private final LottieDrawable lottieDrawable;
  private final Matrix matrix = new Matrix();
  private final String name;
  private Paint offScreenPaint = new LPaint();
  private RectF offScreenRectF = new RectF();
  private final Path path = new Path();
  @Nullable
  private List<PathContent> pathContents;
  private final RectF rect = new RectF();
  @Nullable
  private TransformKeyframeAnimation transformAnimation;
  
  public ContentGroup(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, ShapeGroup paramShapeGroup)
  {
    this(paramLottieDrawable, paramBaseLayer, paramShapeGroup.getName(), paramShapeGroup.isHidden(), contentsFromModels(paramLottieDrawable, paramBaseLayer, paramShapeGroup.getItems()), findTransform(paramShapeGroup.getItems()));
  }
  
  ContentGroup(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, String paramString, boolean paramBoolean, List<Content> paramList, @Nullable AnimatableTransform paramAnimatableTransform)
  {
    this.name = paramString;
    this.lottieDrawable = paramLottieDrawable;
    this.hidden = paramBoolean;
    this.contents = paramList;
    if (paramAnimatableTransform != null)
    {
      this.transformAnimation = paramAnimatableTransform.createAnimation();
      this.transformAnimation.addAnimationsToLayer(paramBaseLayer);
      this.transformAnimation.addListener(this);
    }
    paramLottieDrawable = new ArrayList();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      paramBaseLayer = (Content)paramList.get(i);
      if ((paramBaseLayer instanceof GreedyContent)) {
        paramLottieDrawable.add((GreedyContent)paramBaseLayer);
      }
      i -= 1;
    }
    i = paramLottieDrawable.size() - 1;
    while (i >= 0)
    {
      ((GreedyContent)paramLottieDrawable.get(i)).absorbContent(paramList.listIterator(paramList.size()));
      i -= 1;
    }
  }
  
  private static List<Content> contentsFromModels(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, List<ContentModel> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      Content localContent = ((ContentModel)paramList.get(i)).toContent(paramLottieDrawable, paramBaseLayer);
      if (localContent != null) {
        localArrayList.add(localContent);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  @Nullable
  static AnimatableTransform findTransform(List<ContentModel> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      ContentModel localContentModel = (ContentModel)paramList.get(i);
      if ((localContentModel instanceof AnimatableTransform)) {
        return (AnimatableTransform)localContentModel;
      }
      i += 1;
    }
    return null;
  }
  
  private boolean hasTwoOrMoreDrawableContent()
  {
    int j = 0;
    int i;
    for (int k = 0; j < this.contents.size(); k = i)
    {
      i = k;
      if ((this.contents.get(j) instanceof DrawingContent))
      {
        k += 1;
        i = k;
        if (k >= 2) {
          return true;
        }
      }
      j += 1;
    }
    return false;
  }
  
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    TransformKeyframeAnimation localTransformKeyframeAnimation = this.transformAnimation;
    if (localTransformKeyframeAnimation != null) {
      localTransformKeyframeAnimation.applyValueCallback(paramT, paramLottieValueCallback);
    }
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    if (this.hidden) {
      return;
    }
    this.matrix.set(paramMatrix);
    paramMatrix = this.transformAnimation;
    int i = paramInt;
    if (paramMatrix != null)
    {
      this.matrix.preConcat(paramMatrix.getMatrix());
      if (this.transformAnimation.getOpacity() == null) {
        i = 100;
      } else {
        i = ((Integer)this.transformAnimation.getOpacity().getValue()).intValue();
      }
      i = (int)(i / 100.0F * paramInt / 255.0F * 255.0F);
    }
    if ((this.lottieDrawable.isApplyingOpacityToLayersEnabled()) && (hasTwoOrMoreDrawableContent()) && (i != 255)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      this.offScreenRectF.set(0.0F, 0.0F, 0.0F, 0.0F);
      getBounds(this.offScreenRectF, this.matrix, true);
      this.offScreenPaint.setAlpha(i);
      Utils.saveLayerCompat(paramCanvas, this.offScreenRectF, this.offScreenPaint);
    }
    if (paramInt != 0) {
      i = 255;
    }
    int j = this.contents.size() - 1;
    while (j >= 0)
    {
      paramMatrix = this.contents.get(j);
      if ((paramMatrix instanceof DrawingContent)) {
        ((DrawingContent)paramMatrix).draw(paramCanvas, this.matrix, i);
      }
      j -= 1;
    }
    if (paramInt != 0) {
      paramCanvas.restore();
    }
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    this.matrix.set(paramMatrix);
    paramMatrix = this.transformAnimation;
    if (paramMatrix != null) {
      this.matrix.preConcat(paramMatrix.getMatrix());
    }
    this.rect.set(0.0F, 0.0F, 0.0F, 0.0F);
    int i = this.contents.size() - 1;
    while (i >= 0)
    {
      paramMatrix = (Content)this.contents.get(i);
      if ((paramMatrix instanceof DrawingContent))
      {
        ((DrawingContent)paramMatrix).getBounds(this.rect, this.matrix, paramBoolean);
        paramRectF.union(this.rect);
      }
      i -= 1;
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Path getPath()
  {
    this.matrix.reset();
    Object localObject = this.transformAnimation;
    if (localObject != null) {
      this.matrix.set(((TransformKeyframeAnimation)localObject).getMatrix());
    }
    this.path.reset();
    if (this.hidden) {
      return this.path;
    }
    int i = this.contents.size() - 1;
    while (i >= 0)
    {
      localObject = (Content)this.contents.get(i);
      if ((localObject instanceof PathContent)) {
        this.path.addPath(((PathContent)localObject).getPath(), this.matrix);
      }
      i -= 1;
    }
    return this.path;
  }
  
  List<PathContent> getPathList()
  {
    if (this.pathContents == null)
    {
      this.pathContents = new ArrayList();
      int i = 0;
      while (i < this.contents.size())
      {
        Content localContent = (Content)this.contents.get(i);
        if ((localContent instanceof PathContent)) {
          this.pathContents.add((PathContent)localContent);
        }
        i += 1;
      }
    }
    return this.pathContents;
  }
  
  Matrix getTransformationMatrix()
  {
    TransformKeyframeAnimation localTransformKeyframeAnimation = this.transformAnimation;
    if (localTransformKeyframeAnimation != null) {
      return localTransformKeyframeAnimation.getMatrix();
    }
    this.matrix.reset();
    return this.matrix;
  }
  
  public void onValueChanged()
  {
    this.lottieDrawable.invalidateSelf();
  }
  
  public void resolveKeyPath(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2)
  {
    if ((!paramKeyPath1.matches(getName(), paramInt)) && (!"__container".equals(getName()))) {
      return;
    }
    KeyPath localKeyPath = paramKeyPath2;
    if (!"__container".equals(getName()))
    {
      paramKeyPath2 = paramKeyPath2.addKey(getName());
      localKeyPath = paramKeyPath2;
      if (paramKeyPath1.fullyResolvesTo(getName(), paramInt))
      {
        paramList.add(paramKeyPath2.resolve(this));
        localKeyPath = paramKeyPath2;
      }
    }
    if (paramKeyPath1.propagateToChildren(getName(), paramInt))
    {
      int j = paramKeyPath1.incrementDepthBy(getName(), paramInt);
      int i = 0;
      while (i < this.contents.size())
      {
        paramKeyPath2 = (Content)this.contents.get(i);
        if ((paramKeyPath2 instanceof KeyPathElement)) {
          ((KeyPathElement)paramKeyPath2).resolveKeyPath(paramKeyPath1, paramInt + j, paramList, localKeyPath);
        }
        i += 1;
      }
    }
  }
  
  public void setContents(List<Content> paramList1, List<Content> paramList2)
  {
    paramList2 = new ArrayList(paramList1.size() + this.contents.size());
    paramList2.addAll(paramList1);
    int i = this.contents.size() - 1;
    while (i >= 0)
    {
      paramList1 = (Content)this.contents.get(i);
      paramList1.setContents(paramList2, this.contents.subList(0, i));
      paramList2.add(paramList1);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.ContentGroup
 * JD-Core Version:    0.7.0.1
 */