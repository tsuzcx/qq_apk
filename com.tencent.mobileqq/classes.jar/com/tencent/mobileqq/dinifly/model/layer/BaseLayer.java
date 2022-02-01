package com.tencent.mobileqq.dinifly.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
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
import com.tencent.mobileqq.dinifly.model.content.Mask.MaskMode;
import com.tencent.mobileqq.dinifly.model.content.ShapeData;
import com.tencent.mobileqq.dinifly.utils.Logger;
import com.tencent.mobileqq.dinifly.utils.Utils;
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
  @Nullable
  private FloatKeyframeAnimation inOutAnimation;
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
  private boolean outlineMasksAndMattes;
  @Nullable
  private Paint outlineMasksAndMattesPaint;
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
    paramLottieDrawable = new StringBuilder();
    paramLottieDrawable.append(paramLayer.getName());
    paramLottieDrawable.append("#draw");
    this.drawTraceName = paramLottieDrawable.toString();
    if (paramLayer.getMatteType() == Layer.MatteType.INVERT) {
      this.mattePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    } else {
      this.mattePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }
    this.transform = paramLayer.getTransform().createAnimation();
    this.transform.addListener(this);
    if ((paramLayer.getMasks() != null) && (!paramLayer.getMasks().isEmpty()))
    {
      this.mask = new MaskKeyframeAnimation(paramLayer.getMasks());
      paramLottieDrawable = this.mask.getMaskAnimations().iterator();
      while (paramLottieDrawable.hasNext()) {
        ((BaseKeyframeAnimation)paramLottieDrawable.next()).addUpdateListener(this);
      }
      paramLottieDrawable = this.mask.getOpacityAnimations().iterator();
      while (paramLottieDrawable.hasNext())
      {
        paramLayer = (BaseKeyframeAnimation)paramLottieDrawable.next();
        addAnimation(paramLayer);
        paramLayer.addUpdateListener(this);
      }
    }
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
    Utils.saveLayerCompat(paramCanvas, this.rect, this.dstInPaint);
    paramMask = (Path)paramBaseKeyframeAnimation.getValue();
    this.path.set(paramMask);
    this.path.transform(paramMatrix);
    this.contentPaint.setAlpha((int)(((Integer)paramBaseKeyframeAnimation1.getValue()).intValue() * 2.55F));
    paramCanvas.drawPath(this.path, this.contentPaint);
    paramCanvas.restore();
  }
  
  private void applyInvertedAddMask(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, BaseKeyframeAnimation<ShapeData, Path> paramBaseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> paramBaseKeyframeAnimation1)
  {
    Utils.saveLayerCompat(paramCanvas, this.rect, this.contentPaint);
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
    Utils.saveLayerCompat(paramCanvas, this.rect, this.dstInPaint);
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
    Utils.saveLayerCompat(paramCanvas, this.rect, this.dstOutPaint);
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
    Utils.saveLayerCompat(paramCanvas, this.rect, this.dstInPaint, 19);
    if (Build.VERSION.SDK_INT < 28) {
      clearCanvas(paramCanvas);
    }
    L.endSection("Layer#saveLayer");
    int i = 0;
    while (i < this.mask.getMasks().size())
    {
      Mask localMask = (Mask)this.mask.getMasks().get(i);
      BaseKeyframeAnimation localBaseKeyframeAnimation1 = (BaseKeyframeAnimation)this.mask.getMaskAnimations().get(i);
      BaseKeyframeAnimation localBaseKeyframeAnimation2 = (BaseKeyframeAnimation)this.mask.getOpacityAnimations().get(i);
      int j = BaseLayer.2.$SwitchMap$com$tencent$mobileqq$dinifly$model$content$Mask$MaskMode[localMask.getMaskMode().ordinal()];
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j == 4) {
              if (localMask.isInverted()) {
                applyInvertedAddMask(paramCanvas, paramMatrix, localMask, localBaseKeyframeAnimation1, localBaseKeyframeAnimation2);
              } else {
                applyAddMask(paramCanvas, paramMatrix, localMask, localBaseKeyframeAnimation1, localBaseKeyframeAnimation2);
              }
            }
          }
          else if (localMask.isInverted()) {
            applyInvertedIntersectMask(paramCanvas, paramMatrix, localMask, localBaseKeyframeAnimation1, localBaseKeyframeAnimation2);
          } else {
            applyIntersectMask(paramCanvas, paramMatrix, localMask, localBaseKeyframeAnimation1, localBaseKeyframeAnimation2);
          }
        }
        else
        {
          if (i == 0)
          {
            this.contentPaint.setColor(-16777216);
            this.contentPaint.setAlpha(255);
            paramCanvas.drawRect(this.rect, this.contentPaint);
          }
          if (localMask.isInverted()) {
            applyInvertedSubtractMask(paramCanvas, paramMatrix, localMask, localBaseKeyframeAnimation1, localBaseKeyframeAnimation2);
          } else {
            applySubtractMask(paramCanvas, paramMatrix, localMask, localBaseKeyframeAnimation1, localBaseKeyframeAnimation2);
          }
        }
      }
      else if (areAllMasksNone())
      {
        this.contentPaint.setAlpha(255);
        paramCanvas.drawRect(this.rect, this.contentPaint);
      }
      i += 1;
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
  
  private boolean areAllMasksNone()
  {
    if (this.mask.getMaskAnimations().isEmpty()) {
      return false;
    }
    int i = 0;
    while (i < this.mask.getMasks().size())
    {
      if (((Mask)this.mask.getMasks().get(i)).getMaskMode() != Mask.MaskMode.MASK_MODE_NONE) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void buildParentLayerListIfNeeded()
  {
    if (this.parentLayers != null) {
      return;
    }
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
  
  private void clearCanvas(Canvas paramCanvas)
  {
    L.beginSection("Layer#clearLayer");
    paramCanvas.drawRect(this.rect.left - 1.0F, this.rect.top - 1.0F, this.rect.right + 1.0F, this.rect.bottom + 1.0F, this.clearPaint);
    L.endSection("Layer#clearLayer");
  }
  
  @Nullable
  static BaseLayer forModel(Layer paramLayer, LottieDrawable paramLottieDrawable, LottieComposition paramLottieComposition)
  {
    switch (BaseLayer.2.$SwitchMap$com$tencent$mobileqq$dinifly$model$layer$Layer$LayerType[paramLayer.getLayerType().ordinal()])
    {
    default: 
      paramLottieDrawable = new StringBuilder();
      paramLottieDrawable.append("Unknown layer type ");
      paramLottieDrawable.append(paramLayer.getLayerType());
      Logger.warning(paramLottieDrawable.toString());
      return null;
    case 6: 
      return new TextLayer(paramLottieDrawable, paramLayer);
    case 5: 
      return new NullLayer(paramLottieDrawable, paramLayer);
    case 4: 
      return new ImageLayer(paramLottieDrawable, paramLayer);
    case 3: 
      return new SolidLayer(paramLottieDrawable, paramLayer);
    case 2: 
      return new CompositionLayer(paramLottieDrawable, paramLayer, paramLottieComposition.getPrecomps(paramLayer.getRefId()), paramLottieComposition);
    }
    return new ShapeLayer(paramLottieDrawable, paramLayer);
  }
  
  private void intersectBoundsWithMask(RectF paramRectF, Matrix paramMatrix)
  {
    this.maskBoundsRect.set(0.0F, 0.0F, 0.0F, 0.0F);
    if (!hasMasksOnThisLayer()) {
      return;
    }
    int j = this.mask.getMasks().size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (Mask)this.mask.getMasks().get(i);
      Path localPath = (Path)((BaseKeyframeAnimation)this.mask.getMaskAnimations().get(i)).getValue();
      this.path.set(localPath);
      this.path.transform(paramMatrix);
      int k = BaseLayer.2.$SwitchMap$com$tencent$mobileqq$dinifly$model$content$Mask$MaskMode[localObject.getMaskMode().ordinal()];
      if ((k != 1) && (k != 2))
      {
        if (((k == 3) || (k == 4)) && (((Mask)localObject).isInverted())) {
          return;
        }
        this.path.computeBounds(this.tempMaskBoundsRect, false);
        if (i == 0)
        {
          this.maskBoundsRect.set(this.tempMaskBoundsRect);
        }
        else
        {
          localObject = this.maskBoundsRect;
          ((RectF)localObject).set(Math.min(((RectF)localObject).left, this.tempMaskBoundsRect.left), Math.min(this.maskBoundsRect.top, this.tempMaskBoundsRect.top), Math.max(this.maskBoundsRect.right, this.tempMaskBoundsRect.right), Math.max(this.maskBoundsRect.bottom, this.tempMaskBoundsRect.bottom));
        }
        i += 1;
      }
      else
      {
        return;
      }
    }
    if (!paramRectF.intersect(this.maskBoundsRect)) {
      paramRectF.set(0.0F, 0.0F, 0.0F, 0.0F);
    }
  }
  
  private void intersectBoundsWithMatte(RectF paramRectF, Matrix paramMatrix)
  {
    if (!hasMatteOnThisLayer()) {
      return;
    }
    if (this.layerModel.getMatteType() == Layer.MatteType.INVERT) {
      return;
    }
    this.matteBoundsRect.set(0.0F, 0.0F, 0.0F, 0.0F);
    this.matteLayer.getBounds(this.matteBoundsRect, paramMatrix, true);
    if (!paramRectF.intersect(this.matteBoundsRect)) {
      paramRectF.set(0.0F, 0.0F, 0.0F, 0.0F);
    }
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
      invalidateSelf();
    }
  }
  
  private void setupInOutAnimations()
  {
    boolean bool2 = this.layerModel.getInOutKeyframes().isEmpty();
    boolean bool1 = true;
    if (!bool2)
    {
      this.inOutAnimation = new FloatKeyframeAnimation(this.layerModel.getInOutKeyframes());
      this.inOutAnimation.setIsDiscrete();
      this.inOutAnimation.addUpdateListener(new BaseLayer.1(this));
      if (((Float)this.inOutAnimation.getValue()).floatValue() != 1.0F) {
        bool1 = false;
      }
      setVisible(bool1);
      addAnimation(this.inOutAnimation);
      return;
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
    if ((this.visible) && (!this.layerModel.isHidden()))
    {
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
      if (this.transform.getOpacity() == null) {
        i = 100;
      } else {
        i = ((Integer)this.transform.getOpacity().getValue()).intValue();
      }
      paramInt = (int)(paramInt / 255.0F * i / 100.0F * 255.0F);
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
      getBounds(this.rect, this.matrix, false);
      intersectBoundsWithMatte(this.rect, paramMatrix);
      this.matrix.preConcat(this.transform.getMatrix());
      intersectBoundsWithMask(this.rect, this.matrix);
      if (!this.rect.intersect(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight())) {
        this.rect.set(0.0F, 0.0F, 0.0F, 0.0F);
      }
      L.endSection("Layer#computeBounds");
      if ((this.rect.width() >= 1.0F) && (this.rect.height() >= 1.0F))
      {
        L.beginSection("Layer#saveLayer");
        this.contentPaint.setAlpha(255);
        Utils.saveLayerCompat(paramCanvas, this.rect, this.contentPaint);
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
          Utils.saveLayerCompat(paramCanvas, this.rect, this.mattePaint, 19);
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
      if (this.outlineMasksAndMattes)
      {
        paramMatrix = this.outlineMasksAndMattesPaint;
        if (paramMatrix != null)
        {
          paramMatrix.setStyle(Paint.Style.STROKE);
          this.outlineMasksAndMattesPaint.setColor(-251901);
          this.outlineMasksAndMattesPaint.setStrokeWidth(4.0F);
          paramCanvas.drawRect(this.rect, this.outlineMasksAndMattesPaint);
          this.outlineMasksAndMattesPaint.setStyle(Paint.Style.FILL);
          this.outlineMasksAndMattesPaint.setColor(1357638635);
          paramCanvas.drawRect(this.rect, this.outlineMasksAndMattesPaint);
        }
      }
      recordRenderTime(L.endSection(this.drawTraceName));
      return;
    }
    L.endSection(this.drawTraceName);
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
      paramRectF = this.parentLayers;
      if (paramRectF != null)
      {
        int i = paramRectF.size() - 1;
        while (i >= 0)
        {
          this.boundsMatrix.preConcat(((BaseLayer)this.parentLayers.get(i)).transform.getMatrix());
          i -= 1;
        }
      }
      paramRectF = this.parentLayer;
      if (paramRectF != null) {
        this.boundsMatrix.preConcat(paramRectF.transform.getMatrix());
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
    MaskKeyframeAnimation localMaskKeyframeAnimation = this.mask;
    return (localMaskKeyframeAnimation != null) && (!localMaskKeyframeAnimation.getMaskAnimations().isEmpty());
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
    Object localObject = this.matteLayer;
    if (localObject != null)
    {
      localObject = paramKeyPath2.addKey(((BaseLayer)localObject).getName());
      if (paramKeyPath1.fullyResolvesTo(this.matteLayer.getName(), paramInt)) {
        paramList.add(((KeyPath)localObject).resolve(this.matteLayer));
      }
      if (paramKeyPath1.propagateToChildren(getName(), paramInt))
      {
        int i = paramKeyPath1.incrementDepthBy(this.matteLayer.getName(), paramInt);
        this.matteLayer.resolveChildKeyPath(paramKeyPath1, i + paramInt, paramList, (KeyPath)localObject);
      }
    }
    if (!paramKeyPath1.matches(getName(), paramInt)) {
      return;
    }
    localObject = paramKeyPath2;
    if (!"__container".equals(getName()))
    {
      paramKeyPath2 = paramKeyPath2.addKey(getName());
      localObject = paramKeyPath2;
      if (paramKeyPath1.fullyResolvesTo(getName(), paramInt))
      {
        paramList.add(paramKeyPath2.resolve(this));
        localObject = paramKeyPath2;
      }
    }
    if (paramKeyPath1.propagateToChildren(getName(), paramInt)) {
      resolveChildKeyPath(paramKeyPath1, paramInt + paramKeyPath1.incrementDepthBy(getName(), paramInt), paramList, (KeyPath)localObject);
    }
  }
  
  public void setContents(List<Content> paramList1, List<Content> paramList2) {}
  
  void setMatteLayer(@Nullable BaseLayer paramBaseLayer)
  {
    this.matteLayer = paramBaseLayer;
  }
  
  void setOutlineMasksAndMattes(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.outlineMasksAndMattesPaint == null)) {
      this.outlineMasksAndMattesPaint = new LPaint();
    }
    this.outlineMasksAndMattes = paramBoolean;
  }
  
  void setParentLayer(@Nullable BaseLayer paramBaseLayer)
  {
    this.parentLayer = paramBaseLayer;
  }
  
  void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.transform.setProgress(paramFloat);
    Object localObject = this.mask;
    int j = 0;
    if (localObject != null)
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
    localObject = this.inOutAnimation;
    if (localObject != null) {
      ((FloatKeyframeAnimation)localObject).setProgress(f / this.layerModel.getTimeStretch());
    }
    localObject = this.matteLayer;
    int i = j;
    if (localObject != null)
    {
      paramFloat = ((BaseLayer)localObject).layerModel.getTimeStretch();
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