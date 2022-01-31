package com.tencent.mobileqq.dinifly.model.layer;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Looper;
import android.support.annotation.CallSuper;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.PerformanceTracker;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.DrawingContent;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.animation.keyframe.FloatKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.MaskKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.StaticKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.TransformKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform;
import com.tencent.mobileqq.dinifly.model.content.Mask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class BaseLayer
  implements DrawingContent, BaseKeyframeAnimation.AnimationListener
{
  private static final int SAVE_FLAGS = 19;
  private final List<BaseKeyframeAnimation<?, ?>> animations = new ArrayList();
  final Matrix boundsMatrix = new Matrix();
  private final Paint clearPaint = new Paint();
  private final Paint contentPaint = new Paint(1);
  private final String drawTraceName;
  int layerCount = 1;
  final Layer layerModel;
  final LottieDrawable lottieDrawable;
  @Nullable
  private MaskKeyframeAnimation mask;
  private final RectF maskBoundsRect = new RectF();
  private final Paint maskPaint = new Paint(1);
  private final Matrix matrix = new Matrix();
  private final RectF matteBoundsRect = new RectF();
  @Nullable
  private BaseLayer matteLayer;
  private final Paint mattePaint = new Paint(1);
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
    this.clearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    if (paramLayer.getMatteType() == 2) {
      this.mattePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }
    for (;;)
    {
      this.transform = paramLayer.getTransform().createAnimation();
      this.transform.addListener(this);
      this.transform.addAnimationsToLayer(this);
      if ((paramLayer.getMasks() == null) || (paramLayer.getMasks().isEmpty())) {
        break label419;
      }
      this.mask = new MaskKeyframeAnimation(paramLayer.getMasks());
      paramLottieDrawable = this.mask.getMaskAnimations().iterator();
      while (paramLottieDrawable.hasNext())
      {
        paramLayer = (BaseKeyframeAnimation)paramLottieDrawable.next();
        addAnimation(paramLayer);
        paramLayer.addUpdateListener(this);
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
    label419:
    setupInOutAnimations();
  }
  
  @SuppressLint({"WrongConstant"})
  private void applyMasks(Canvas paramCanvas, Matrix paramMatrix)
  {
    L.beginSection("Layer#drawMask");
    L.beginSection("Layer#saveLayer");
    paramCanvas.saveLayer(this.rect, this.maskPaint, 19);
    L.endSection("Layer#saveLayer");
    clearCanvas(paramCanvas);
    int j = this.mask.getMasks().size();
    int i = 0;
    if (i < j)
    {
      Object localObject = (Mask)this.mask.getMasks().get(i);
      Path localPath = (Path)((BaseKeyframeAnimation)this.mask.getMaskAnimations().get(i)).getValue();
      this.path.set(localPath);
      this.path.transform(paramMatrix);
      switch (2.$SwitchMap$com$tencent$mobileqq$dinifly$model$content$Mask$MaskMode[localObject.getMaskMode().ordinal()])
      {
      default: 
        this.path.setFillType(Path.FillType.WINDING);
      }
      for (;;)
      {
        localObject = (BaseKeyframeAnimation)this.mask.getOpacityAnimations().get(i);
        int k = this.contentPaint.getAlpha();
        this.contentPaint.setAlpha((int)(((Integer)((BaseKeyframeAnimation)localObject).getValue()).intValue() * 2.55F));
        paramCanvas.drawPath(this.path, this.contentPaint);
        this.contentPaint.setAlpha(k);
        i += 1;
        break;
        this.path.setFillType(Path.FillType.INVERSE_WINDING);
      }
    }
    L.beginSection("Layer#restoreLayer");
    paramCanvas.restore();
    L.endSection("Layer#restoreLayer");
    L.endSection("Layer#drawMask");
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
    switch (paramLayer.getLayerType())
    {
    default: 
      Log.w("LOTTIE", "Unknown layer type " + paramLayer.getLayerType());
      return null;
    case 4: 
      return new ShapeLayer(paramLottieDrawable, paramLayer);
    case 0: 
      return new CompositionLayer(paramLottieDrawable, paramLayer, paramLottieComposition.getPrecomps(paramLayer.getRefId()), paramLottieComposition);
    case 1: 
      return new SolidLayer(paramLottieDrawable, paramLayer);
    case 2: 
      return new ImageLayer(paramLottieDrawable, paramLayer, paramLottieComposition.getDpScale());
    case 3: 
      return new NullLayer(paramLottieDrawable, paramLayer);
    }
    return new TextLayer(paramLottieDrawable, paramLayer);
  }
  
  private void intersectBoundsWithMask(RectF paramRectF, Matrix paramMatrix)
  {
    this.maskBoundsRect.set(0.0F, 0.0F, 0.0F, 0.0F);
    if (!hasMasksOnThisLayer()) {
      return;
    }
    int j = this.mask.getMasks().size();
    int i = 0;
    if (i < j)
    {
      Mask localMask = (Mask)this.mask.getMasks().get(i);
      Path localPath = (Path)((BaseKeyframeAnimation)this.mask.getMaskAnimations().get(i)).getValue();
      this.path.set(localPath);
      this.path.transform(paramMatrix);
      switch (2.$SwitchMap$com$tencent$mobileqq$dinifly$model$content$Mask$MaskMode[localMask.getMaskMode().ordinal()])
      {
      }
      this.path.computeBounds(this.tempMaskBoundsRect, false);
      if (i == 0) {
        this.maskBoundsRect.set(this.tempMaskBoundsRect);
      }
      for (;;)
      {
        i += 1;
        break;
        this.maskBoundsRect.set(Math.min(this.maskBoundsRect.left, this.tempMaskBoundsRect.left), Math.min(this.maskBoundsRect.top, this.tempMaskBoundsRect.top), Math.max(this.maskBoundsRect.right, this.tempMaskBoundsRect.right), Math.max(this.maskBoundsRect.bottom, this.tempMaskBoundsRect.bottom));
      }
    }
    paramRectF.set(Math.max(paramRectF.left, this.maskBoundsRect.left), Math.max(paramRectF.top, this.maskBoundsRect.top), Math.min(paramRectF.right, this.maskBoundsRect.right), Math.min(paramRectF.bottom, this.maskBoundsRect.bottom));
  }
  
  private void intersectBoundsWithMatte(RectF paramRectF, Matrix paramMatrix)
  {
    if (!hasMatteOnThisLayer()) {}
    while (this.layerModel.getMatteType() == 2) {
      return;
    }
    this.matteLayer.getBounds(this.matteBoundsRect, paramMatrix);
    paramRectF.set(Math.max(paramRectF.left, this.matteBoundsRect.left), Math.max(paramRectF.top, this.matteBoundsRect.top), Math.min(paramRectF.right, this.matteBoundsRect.right), Math.min(paramRectF.bottom, this.matteBoundsRect.bottom));
  }
  
  private void invalidateSelf()
  {
    this.lottieDrawable.invalidateSelf();
  }
  
  private void recordRenderTime(float paramFloat)
  {
    this.lottieDrawable.getComposition().getPerformanceTracker().recordRenderTime(this.layerModel.getName(), paramFloat);
  }
  
  private void setVisible(boolean paramBoolean)
  {
    if (paramBoolean != this.visible)
    {
      this.visible = paramBoolean;
      if (Looper.myLooper() == Looper.getMainLooper()) {
        invalidateSelf();
      }
    }
  }
  
  private void setupInOutAnimations()
  {
    if (!this.layerModel.getInOutKeyframes().isEmpty())
    {
      final FloatKeyframeAnimation localFloatKeyframeAnimation = new FloatKeyframeAnimation(this.layerModel.getInOutKeyframes());
      localFloatKeyframeAnimation.setIsDiscrete();
      localFloatKeyframeAnimation.addUpdateListener(new BaseKeyframeAnimation.AnimationListener()
      {
        public void onValueChanged()
        {
          BaseLayer localBaseLayer = BaseLayer.this;
          if (((Float)localFloatKeyframeAnimation.getValue()).floatValue() == 1.0F) {}
          for (boolean bool = true;; bool = false)
          {
            localBaseLayer.setVisible(bool);
            return;
          }
        }
      });
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
  
  public void addAnimation(BaseKeyframeAnimation<?, ?> paramBaseKeyframeAnimation)
  {
    if (!(paramBaseKeyframeAnimation instanceof StaticKeyframeAnimation)) {
      this.animations.add(paramBaseKeyframeAnimation);
    }
  }
  
  public void addColorFilter(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter) {}
  
  @SuppressLint({"WrongConstant"})
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    L.beginSection(this.drawTraceName);
    if (!this.visible)
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
    float f = paramInt / 255.0F;
    paramInt = (int)(((Integer)this.transform.getOpacity().getValue()).intValue() * f / 100.0F * 255.0F);
    if ((!hasMatteOnThisLayer()) && (!hasMasksOnThisLayer()))
    {
      this.matrix.preConcat(this.transform.getMatrix());
      L.beginSection("Layer#drawLayer");
      drawLayer(paramCanvas, this.matrix, paramInt);
      L.endSection("Layer#drawLayer");
      recordRenderTime(L.endSection(this.drawTraceName));
      return;
    }
    L.beginSection("Layer#computeBounds");
    this.rect.set(0.0F, 0.0F, 0.0F, 0.0F);
    getBounds(this.rect, this.matrix);
    intersectBoundsWithMatte(this.rect, this.matrix);
    this.matrix.preConcat(this.transform.getMatrix());
    intersectBoundsWithMask(this.rect, this.matrix);
    this.rect.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
    L.endSection("Layer#computeBounds");
    L.beginSection("Layer#saveLayer");
    paramCanvas.saveLayer(this.rect, this.contentPaint, 31);
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
      paramCanvas.saveLayer(this.rect, this.mattePaint, 19);
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
    recordRenderTime(L.endSection(this.drawTraceName));
  }
  
  abstract void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt);
  
  @CallSuper
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
  {
    this.boundsMatrix.set(paramMatrix);
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
    float f = paramFloat;
    if (this.layerModel.getTimeStretch() != 0.0F) {
      f = paramFloat / this.layerModel.getTimeStretch();
    }
    if (this.matteLayer != null) {
      this.matteLayer.setProgress(f);
    }
    int i = 0;
    while (i < this.animations.size())
    {
      ((BaseKeyframeAnimation)this.animations.get(i)).setProgress(f);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.layer.BaseLayer
 * JD-Core Version:    0.7.0.1
 */