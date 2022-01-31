package com.tencent.mobileqq.dinifly.model.layer;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.CallSuper;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.PerformanceTracker;
import com.tencent.mobileqq.dinifly.animation.LPaint;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.DrawingContent;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.animation.keyframe.FloatKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.MaskKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.TransformKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.KeyPath;
import com.tencent.mobileqq.dinifly.model.KeyPathElement;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform;
import com.tencent.mobileqq.dinifly.model.content.Mask;
import com.tencent.mobileqq.dinifly.model.content.ShapeData;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class BaseLayer
  implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement
{
  private static final int CLIP_SAVE_FLAG = 2;
  private static final int CLIP_TO_LAYER_SAVE_FLAG = 16;
  private static final int MATRIX_SAVE_FLAG = 1;
  private static final int SAVE_FLAGS = 19;
  private final List<BaseKeyframeAnimation<?, ?>> animations = new ArrayList();
  final Matrix boundsMatrix = new Matrix();
  private final Paint clearPaint = new LPaint(PorterDuff.Mode.CLEAR);
  private final Paint contentPaint = new LPaint(1);
  private final String drawTraceName;
  private final Paint dstInPaint = new LPaint(1, PorterDuff.Mode.DST_IN);
  private final Paint dstOutPaint = new LPaint(1, PorterDuff.Mode.DST_OUT);
  int layerCount = 1;
  final Layer layerModel;
  final LottieDrawable lottieDrawable;
  @Nullable
  private MaskKeyframeAnimation mask;
  private final RectF maskBoundsRect = new RectF();
  private final Matrix matrix = new Matrix();
  private final RectF matteBoundsRect = new RectF();
  @Nullable
  private BaseLayer matteLayer;
  private final Paint mattePaint = new LPaint(1);
  CompositionLayer parentComposition;
  @Nullable
  private BaseLayer parentLayer;
  private List<BaseLayer> parentLayers;
  private final Path path = new Path();
  private final RectF rect = new RectF();
  private final RectF tempMaskBoundsRect = new RectF();
  final TransformKeyframeAnimation transform;
  private boolean visible = true;
  
  BaseLayer(LottieDrawable paramLottieDrawable, Layer paramLayer)
  {
    this.lottieDrawable = paramLottieDrawable;
    this.layerModel = paramLayer;
    this.drawTraceName = (paramLayer.getName() + "#draw");
    if (paramLayer.getMatteType() == Layer.MatteType.INVERT) {
      this.mattePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }
    for (;;)
    {
      this.transform = paramLayer.getTransform().createAnimation();
      this.transform.addListener(this);
      if ((paramLayer.getMasks() == null) || (paramLayer.getMasks().isEmpty())) {
        break label391;
      }
      this.mask = new MaskKeyframeAnimation(paramLayer.getMasks());
      paramLottieDrawable = this.mask.getMaskAnimations().iterator();
      while (paramLottieDrawable.hasNext()) {
        ((BaseKeyframeAnimation)paramLottieDrawable.next()).addUpdateListener(this);
      }
      this.mattePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }
    paramLottieDrawable = this.mask.getOpacityAnimations().iterator();
    while (paramLottieDrawable.hasNext())
    {
      paramLayer = (BaseKeyframeAnimation)paramLottieDrawable.next();
      addAnimation(paramLayer);
      paramLayer.addUpdateListener(this);
    }
    label391:
    setupInOutAnimations();
  }
  
  private void applyAddMask(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, BaseKeyframeAnimation<ShapeData, Path> paramBaseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> paramBaseKeyframeAnimation1)
  {
    paramMask = (Path)paramBaseKeyframeAnimation.getValue();
    this.path.set(paramMask);
    this.path.transform(paramMatrix);
    this.contentPaint.setAlpha((int)(((Integer)paramBaseKeyframeAnimation1.getValue()).intValue() * 2.55F));
    paramCanvas.drawPath(this.path, this.contentPaint);
  }
  
  private void applyIntersectMask(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, BaseKeyframeAnimation<ShapeData, Path> paramBaseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> paramBaseKeyframeAnimation1)
  {
    saveLayerCompat(paramCanvas, this.rect, this.dstInPaint, true);
    paramMask = (Path)paramBaseKeyframeAnimation.getValue();
    this.path.set(paramMask);
    this.path.transform(paramMatrix);
    this.contentPaint.setAlpha((int)(((Integer)paramBaseKeyframeAnimation1.getValue()).intValue() * 2.55F));
    paramCanvas.drawPath(this.path, this.contentPaint);
    paramCanvas.restore();
  }
  
  private void applyInvertedAddMask(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, BaseKeyframeAnimation<ShapeData, Path> paramBaseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> paramBaseKeyframeAnimation1)
  {
    saveLayerCompat(paramCanvas, this.rect, this.contentPaint, true);
    paramCanvas.drawRect(this.rect, this.contentPaint);
    paramMask = (Path)paramBaseKeyframeAnimation.getValue();
    this.path.set(paramMask);
    this.path.transform(paramMatrix);
    this.contentPaint.setAlpha((int)(((Integer)paramBaseKeyframeAnimation1.getValue()).intValue() * 2.55F));
    paramCanvas.drawPath(this.path, this.dstOutPaint);
    paramCanvas.restore();
  }
  
  private void applyInvertedIntersectMask(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, BaseKeyframeAnimation<ShapeData, Path> paramBaseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> paramBaseKeyframeAnimation1)
  {
    saveLayerCompat(paramCanvas, this.rect, this.dstInPaint, true);
    paramCanvas.drawRect(this.rect, this.contentPaint);
    this.dstOutPaint.setAlpha((int)(((Integer)paramBaseKeyframeAnimation1.getValue()).intValue() * 2.55F));
    paramMask = (Path)paramBaseKeyframeAnimation.getValue();
    this.path.set(paramMask);
    this.path.transform(paramMatrix);
    paramCanvas.drawPath(this.path, this.dstOutPaint);
    paramCanvas.restore();
  }
  
  private void applyInvertedSubtractMask(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, BaseKeyframeAnimation<ShapeData, Path> paramBaseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> paramBaseKeyframeAnimation1)
  {
    saveLayerCompat(paramCanvas, this.rect, this.dstOutPaint, true);
    paramCanvas.drawRect(this.rect, this.contentPaint);
    this.dstOutPaint.setAlpha((int)(((Integer)paramBaseKeyframeAnimation1.getValue()).intValue() * 2.55F));
    paramMask = (Path)paramBaseKeyframeAnimation.getValue();
    this.path.set(paramMask);
    this.path.transform(paramMatrix);
    paramCanvas.drawPath(this.path, this.dstOutPaint);
    paramCanvas.restore();
  }
  
  private void applyMasks(Canvas paramCanvas, Matrix paramMatrix)
  {
    L.beginSection("Layer#saveLayer");
    saveLayerCompat(paramCanvas, this.rect, this.dstInPaint, false);
    L.endSection("Layer#saveLayer");
    int i = 0;
    if (i < this.mask.getMasks().size())
    {
      Mask localMask = (Mask)this.mask.getMasks().get(i);
      BaseKeyframeAnimation localBaseKeyframeAnimation1 = (BaseKeyframeAnimation)this.mask.getMaskAnimations().get(i);
      BaseKeyframeAnimation localBaseKeyframeAnimation2 = (BaseKeyframeAnimation)this.mask.getOpacityAnimations().get(i);
      switch (BaseLayer.2.$SwitchMap$com$tencent$mobileqq$dinifly$model$content$Mask$MaskMode[localMask.getMaskMode().ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (localMask.isInverted())
        {
          applyInvertedAddMask(paramCanvas, paramMatrix, localMask, localBaseKeyframeAnimation1, localBaseKeyframeAnimation2);
        }
        else
        {
          applyAddMask(paramCanvas, paramMatrix, localMask, localBaseKeyframeAnimation1, localBaseKeyframeAnimation2);
          continue;
          if (i == 0)
          {
            Paint localPaint = new Paint();
            localPaint.setColor(-16777216);
            paramCanvas.drawRect(this.rect, localPaint);
          }
          if (localMask.isInverted())
          {
            applyInvertedSubtractMask(paramCanvas, paramMatrix, localMask, localBaseKeyframeAnimation1, localBaseKeyframeAnimation2);
          }
          else
          {
            applySubtractMask(paramCanvas, paramMatrix, localMask, localBaseKeyframeAnimation1, localBaseKeyframeAnimation2);
            continue;
            if (localMask.isInverted()) {
              applyInvertedIntersectMask(paramCanvas, paramMatrix, localMask, localBaseKeyframeAnimation1, localBaseKeyframeAnimation2);
            } else {
              applyIntersectMask(paramCanvas, paramMatrix, localMask, localBaseKeyframeAnimation1, localBaseKeyframeAnimation2);
            }
          }
        }
      }
    }
    L.beginSection("Layer#restoreLayer");
    paramCanvas.restore();
    L.endSection("Layer#restoreLayer");
  }
  
  private void applySubtractMask(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, BaseKeyframeAnimation<ShapeData, Path> paramBaseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> paramBaseKeyframeAnimation1)
  {
    paramMask = (Path)paramBaseKeyframeAnimation.getValue();
    this.path.set(paramMask);
    this.path.transform(paramMatrix);
    paramCanvas.drawPath(this.path, this.dstOutPaint);
  }
  
  private void buildParentLayerListIfNeeded()
  {
    if (this.parentLayers != null) {}
    for (;;)
    {
      return;
      if (this.parentLayer == null)
      {
        this.parentLayers = Collections.emptyList();
        return;
      }
      this.parentLayers = new ArrayList();
      for (BaseLayer localBaseLayer = this.parentLayer; localBaseLayer != null; localBaseLayer = localBaseLayer.parentLayer) {
        this.parentLayers.add(localBaseLayer);
      }
    }
  }
  
  private void clearCanvas(Canvas paramCanvas)
  {
    L.beginSection("Layer#clearLayer");
    paramCanvas.drawRect(this.rect.left - 1.0F, this.rect.top - 1.0F, this.rect.right + 1.0F, 1.0F + this.rect.bottom, this.clearPaint);
    L.endSection("Layer#clearLayer");
  }
  
  @Nullable
  static BaseLayer forModel(Layer paramLayer, LottieDrawable paramLottieDrawable, LottieComposition paramLottieComposition)
  {
    switch (BaseLayer.2.$SwitchMap$com$tencent$mobileqq$dinifly$model$layer$Layer$LayerType[paramLayer.getLayerType().ordinal()])
    {
    default: 
      L.warn("Unknown layer type " + paramLayer.getLayerType());
      return null;
    case 1: 
      return new ShapeLayer(paramLottieDrawable, paramLayer);
    case 2: 
      return new CompositionLayer(paramLottieDrawable, paramLayer, paramLottieComposition.getPrecomps(paramLayer.getRefId()), paramLottieComposition);
    case 3: 
      return new SolidLayer(paramLottieDrawable, paramLayer);
    case 4: 
      return new ImageLayer(paramLottieDrawable, paramLayer);
    case 5: 
      return new NullLayer(paramLottieDrawable, paramLayer);
    }
    return new TextLayer(paramLottieDrawable, paramLayer);
  }
  
  private void intersectBoundsWithMask(RectF paramRectF, Matrix paramMatrix)
  {
    this.maskBoundsRect.set(0.0F, 0.0F, 0.0F, 0.0F);
    if (!hasMasksOnThisLayer()) {}
    label140:
    do
    {
      return;
      int j = this.mask.getMasks().size();
      int i = 0;
      if (i < j)
      {
        Mask localMask = (Mask)this.mask.getMasks().get(i);
        Path localPath = (Path)((BaseKeyframeAnimation)this.mask.getMaskAnimations().get(i)).getValue();
        this.path.set(localPath);
        this.path.transform(paramMatrix);
        switch (BaseLayer.2.$SwitchMap$com$tencent$mobileqq$dinifly$model$content$Mask$MaskMode[localMask.getMaskMode().ordinal()])
        {
        case 1: 
        default: 
          this.path.computeBounds(this.tempMaskBoundsRect, false);
          if (i == 0) {
            this.maskBoundsRect.set(this.tempMaskBoundsRect);
          }
          break;
        }
        for (;;)
        {
          i += 1;
          break;
          if (!localMask.isInverted()) {
            break label140;
          }
          return;
          this.maskBoundsRect.set(Math.min(this.maskBoundsRect.left, this.tempMaskBoundsRect.left), Math.min(this.maskBoundsRect.top, this.tempMaskBoundsRect.top), Math.max(this.maskBoundsRect.right, this.tempMaskBoundsRect.right), Math.max(this.maskBoundsRect.bottom, this.tempMaskBoundsRect.bottom));
        }
      }
    } while (paramRectF.intersect(this.maskBoundsRect));
    paramRectF.set(0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  private void intersectBoundsWithMatte(RectF paramRectF, Matrix paramMatrix)
  {
    if (!hasMatteOnThisLayer()) {}
    do
    {
      do
      {
        return;
      } while (this.layerModel.getMatteType() == Layer.MatteType.INVERT);
      this.matteBoundsRect.set(0.0F, 0.0F, 0.0F, 0.0F);
      this.matteLayer.getBounds(this.matteBoundsRect, paramMatrix, true);
    } while (paramRectF.intersect(this.matteBoundsRect));
    paramRectF.set(0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  private void invalidateSelf()
  {
    this.lottieDrawable.invalidateSelf();
  }
  
  private void recordRenderTime(float paramFloat)
  {
    this.lottieDrawable.getComposition().getPerformanceTracker().recordRenderTime(this.layerModel.getName(), paramFloat);
  }
  
  @SuppressLint({"WrongConstant"})
  private void saveLayerCompat(Canvas paramCanvas, RectF paramRectF, Paint paramPaint, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      if (paramBoolean) {}
      for (int i = 31;; i = 19)
      {
        paramCanvas.saveLayer(paramRectF, paramPaint, i);
        return;
      }
    }
    paramCanvas.saveLayer(paramRectF, paramPaint);
  }
  
  private void setVisible(boolean paramBoolean)
  {
    if (paramBoolean != this.visible)
    {
      this.visible = paramBoolean;
      invalidateSelf();
    }
  }
  
  private void setupInOutAnimations()
  {
    if (!this.layerModel.getInOutKeyframes().isEmpty())
    {
      FloatKeyframeAnimation localFloatKeyframeAnimation = new FloatKeyframeAnimation(this.layerModel.getInOutKeyframes());
      localFloatKeyframeAnimation.setIsDiscrete();
      localFloatKeyframeAnimation.addUpdateListener(new BaseLayer.1(this, localFloatKeyframeAnimation));
      if (((Float)localFloatKeyframeAnimation.getValue()).floatValue() == 1.0F) {}
      for (boolean bool = true;; bool = false)
      {
        setVisible(bool);
        addAnimation(localFloatKeyframeAnimation);
        return;
      }
    }
    setVisible(true);
  }
  
  public void addAnimation(@Nullable BaseKeyframeAnimation<?, ?> paramBaseKeyframeAnimation)
  {
    if (paramBaseKeyframeAnimation == null) {
      return;
    }
    this.animations.add(paramBaseKeyframeAnimation);
  }
  
  @CallSuper
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    this.transform.applyValueCallback(paramT, paramLottieValueCallback);
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    L.beginSection(this.drawTraceName);
    if ((!this.visible) || (this.layerModel.isHidden()))
    {
      L.endSection(this.drawTraceName);
      return;
    }
    buildParentLayerListIfNeeded();
    L.beginSection("Layer#parentMatrix");
    this.matrix.reset();
    this.matrix.set(paramMatrix);
    int i = this.parentLayers.size() - 1;
    while (i >= 0)
    {
      this.matrix.preConcat(((BaseLayer)this.parentLayers.get(i)).transform.getMatrix());
      i -= 1;
    }
    L.endSection("Layer#parentMatrix");
    if (this.transform.getOpacity() == null) {}
    for (i = 100;; i = ((Integer)this.transform.getOpacity().getValue()).intValue())
    {
      float f = paramInt / 255.0F;
      paramInt = (int)(i * f / 100.0F * 255.0F);
      if ((hasMatteOnThisLayer()) || (hasMasksOnThisLayer())) {
        break;
      }
      this.matrix.preConcat(this.transform.getMatrix());
      L.beginSection("Layer#drawLayer");
      drawLayer(paramCanvas, this.matrix, paramInt);
      L.endSection("Layer#drawLayer");
      recordRenderTime(L.endSection(this.drawTraceName));
      return;
    }
    L.beginSection("Layer#computeBounds");
    getBounds(this.rect, this.matrix, false);
    intersectBoundsWithMatte(this.rect, paramMatrix);
    this.matrix.preConcat(this.transform.getMatrix());
    intersectBoundsWithMask(this.rect, this.matrix);
    L.endSection("Layer#computeBounds");
    if (!this.rect.isEmpty())
    {
      L.beginSection("Layer#saveLayer");
      saveLayerCompat(paramCanvas, this.rect, this.contentPaint, true);
      L.endSection("Layer#saveLayer");
      clearCanvas(paramCanvas);
      L.beginSection("Layer#drawLayer");
      drawLayer(paramCanvas, this.matrix, paramInt);
      L.endSection("Layer#drawLayer");
      if (hasMasksOnThisLayer()) {
        applyMasks(paramCanvas, this.matrix);
      }
      if (hasMatteOnThisLayer())
      {
        L.beginSection("Layer#drawMatte");
        L.beginSection("Layer#saveLayer");
        saveLayerCompat(paramCanvas, this.rect, this.mattePaint, false);
        L.endSection("Layer#saveLayer");
        clearCanvas(paramCanvas);
        this.matteLayer.draw(paramCanvas, paramMatrix, paramInt);
        L.beginSection("Layer#restoreLayer");
        paramCanvas.restore();
        L.endSection("Layer#restoreLayer");
        L.endSection("Layer#drawMatte");
      }
      L.beginSection("Layer#restoreLayer");
      paramCanvas.restore();
      L.endSection("Layer#restoreLayer");
    }
    recordRenderTime(L.endSection(this.drawTraceName));
  }
  
  abstract void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt);
  
  @CallSuper
  public void getBounds(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    this.rect.set(0.0F, 0.0F, 0.0F, 0.0F);
    buildParentLayerListIfNeeded();
    this.boundsMatrix.set(paramMatrix);
    if (paramBoolean)
    {
      if (this.parentLayers != null)
      {
        int i = this.parentLayers.size() - 1;
        while (i >= 0)
        {
          this.boundsMatrix.preConcat(((BaseLayer)this.parentLayers.get(i)).transform.getMatrix());
          i -= 1;
        }
      }
      if (this.parentLayer != null) {
        this.boundsMatrix.preConcat(this.parentLayer.transform.getMatrix());
      }
    }
    this.boundsMatrix.preConcat(this.transform.getMatrix());
  }
  
  Layer getLayerModel()
  {
    return this.layerModel;
  }
  
  public String getName()
  {
    return this.layerModel.getName();
  }
  
  boolean hasMasksOnThisLayer()
  {
    return (this.mask != null) && (!this.mask.getMaskAnimations().isEmpty());
  }
  
  boolean hasMatteOnThisLayer()
  {
    return this.matteLayer != null;
  }
  
  public void onValueChanged()
  {
    invalidateSelf();
  }
  
  public void removeAnimation(BaseKeyframeAnimation<?, ?> paramBaseKeyframeAnimation)
  {
    this.animations.remove(paramBaseKeyframeAnimation);
  }
  
  void resolveChildKeyPath(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2) {}
  
  public void resolveKeyPath(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2)
  {
    if (!paramKeyPath1.matches(getName(), paramInt)) {}
    KeyPath localKeyPath;
    do
    {
      return;
      localKeyPath = paramKeyPath2;
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
    } while (!paramKeyPath1.propagateToChildren(getName(), paramInt));
    resolveChildKeyPath(paramKeyPath1, paramKeyPath1.incrementDepthBy(getName(), paramInt) + paramInt, paramList, localKeyPath);
  }
  
  public void setContents(List<Content> paramList1, List<Content> paramList2) {}
  
  void setMatteLayer(@Nullable BaseLayer paramBaseLayer)
  {
    this.matteLayer = paramBaseLayer;
  }
  
  void setParentLayer(@Nullable BaseLayer paramBaseLayer)
  {
    this.parentLayer = paramBaseLayer;
  }
  
  void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    int j = 0;
    this.transform.setProgress(paramFloat);
    if (this.mask != null)
    {
      i = 0;
      while (i < this.mask.getMaskAnimations().size())
      {
        ((BaseKeyframeAnimation)this.mask.getMaskAnimations().get(i)).setProgress(paramFloat);
        i += 1;
      }
    }
    float f = paramFloat;
    if (this.layerModel.getTimeStretch() != 0.0F) {
      f = paramFloat / this.layerModel.getTimeStretch();
    }
    int i = j;
    if (this.matteLayer != null)
    {
      paramFloat = this.matteLayer.layerModel.getTimeStretch();
      this.matteLayer.setProgress(paramFloat * f);
      i = j;
    }
    while (i < this.animations.size())
    {
      ((BaseKeyframeAnimation)this.animations.get(i)).setProgress(f);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.layer.BaseLayer
 * JD-Core Version:    0.7.0.1
 */