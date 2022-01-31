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
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform;
import com.tencent.mobileqq.dinifly.model.content.ContentModel;
import com.tencent.mobileqq.dinifly.model.content.ShapeGroup;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class ContentGroup
  implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener
{
  private final List<Content> contents;
  private final LottieDrawable lottieDrawable;
  private final Matrix matrix = new Matrix();
  private final String name;
  private final Path path = new Path();
  @Nullable
  private List<PathContent> pathContents;
  private final RectF rect = new RectF();
  @Nullable
  private TransformKeyframeAnimation transformAnimation;
  
  public ContentGroup(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, ShapeGroup paramShapeGroup)
  {
    this(paramLottieDrawable, paramBaseLayer, paramShapeGroup.getName(), contentsFromModels(paramLottieDrawable, paramBaseLayer, paramShapeGroup.getItems()), findTransform(paramShapeGroup.getItems()));
  }
  
  ContentGroup(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, String paramString, List<Content> paramList, @Nullable AnimatableTransform paramAnimatableTransform)
  {
    this.name = paramString;
    this.lottieDrawable = paramLottieDrawable;
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
  
  public void addColorFilter(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    int i = 0;
    if (i < this.contents.size())
    {
      Content localContent = (Content)this.contents.get(i);
      DrawingContent localDrawingContent;
      if ((localContent instanceof DrawingContent))
      {
        localDrawingContent = (DrawingContent)localContent;
        if ((paramString2 != null) && (!paramString2.equals(localContent.getName()))) {
          break label85;
        }
        localDrawingContent.addColorFilter(paramString1, null, paramColorFilter);
      }
      for (;;)
      {
        i += 1;
        break;
        label85:
        localDrawingContent.addColorFilter(paramString1, paramString2, paramColorFilter);
      }
    }
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.matrix.set(paramMatrix);
    if (this.transformAnimation != null)
    {
      this.matrix.preConcat(this.transformAnimation.getMatrix());
      paramInt = (int)(((Integer)this.transformAnimation.getOpacity().getValue()).intValue() / 100.0F * paramInt / 255.0F * 255.0F);
    }
    for (;;)
    {
      int i = this.contents.size() - 1;
      while (i >= 0)
      {
        paramMatrix = this.contents.get(i);
        if ((paramMatrix instanceof DrawingContent)) {
          ((DrawingContent)paramMatrix).draw(paramCanvas, this.matrix, paramInt);
        }
        i -= 1;
      }
    }
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
  {
    this.matrix.set(paramMatrix);
    if (this.transformAnimation != null) {
      this.matrix.preConcat(this.transformAnimation.getMatrix());
    }
    this.rect.set(0.0F, 0.0F, 0.0F, 0.0F);
    int i = this.contents.size() - 1;
    if (i >= 0)
    {
      paramMatrix = (Content)this.contents.get(i);
      if ((paramMatrix instanceof DrawingContent))
      {
        ((DrawingContent)paramMatrix).getBounds(this.rect, this.matrix);
        if (!paramRectF.isEmpty()) {
          break label117;
        }
        paramRectF.set(this.rect);
      }
      for (;;)
      {
        i -= 1;
        break;
        label117:
        paramRectF.set(Math.min(paramRectF.left, this.rect.left), Math.min(paramRectF.top, this.rect.top), Math.max(paramRectF.right, this.rect.right), Math.max(paramRectF.bottom, this.rect.bottom));
      }
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Path getPath()
  {
    this.matrix.reset();
    if (this.transformAnimation != null) {
      this.matrix.set(this.transformAnimation.getMatrix());
    }
    this.path.reset();
    int i = this.contents.size() - 1;
    while (i >= 0)
    {
      Content localContent = (Content)this.contents.get(i);
      if ((localContent instanceof PathContent)) {
        this.path.addPath(((PathContent)localContent).getPath(), this.matrix);
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
    if (this.transformAnimation != null) {
      return this.transformAnimation.getMatrix();
    }
    this.matrix.reset();
    return this.matrix;
  }
  
  public void onValueChanged()
  {
    this.lottieDrawable.invalidateSelf();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.ContentGroup
 * JD-Core Version:    0.7.0.1
 */