package com.tencent.mobileqq.dinifly.model.layer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.LayerInfo;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositionLayer
  extends BaseLayer
{
  @Nullable
  private Boolean hasMasks;
  @Nullable
  private Boolean hasMatte;
  private BaseLayer layer;
  private final List<BaseLayer> layers = new ArrayList();
  private final RectF newClipRect = new RectF();
  private final RectF rect = new RectF();
  @Nullable
  private final BaseKeyframeAnimation<Float, Float> timeRemapping;
  
  public CompositionLayer(LottieDrawable paramLottieDrawable, Layer paramLayer, List<Layer> paramList, LottieComposition paramLottieComposition)
  {
    super(paramLottieDrawable, paramLayer);
    paramLayer = paramLayer.getTimeRemapping();
    LongSparseArray localLongSparseArray;
    label103:
    Layer localLayer;
    if (paramLayer != null)
    {
      this.timeRemapping = paramLayer.createAnimation();
      addAnimation(this.timeRemapping);
      this.timeRemapping.addUpdateListener(this);
      localLongSparseArray = new LongSparseArray(paramLottieComposition.getLayers().size());
      paramLayer = null;
      i = paramList.size() - 1;
      if (i < 0) {
        break label271;
      }
      localLayer = (Layer)paramList.get(i);
      this.layer = BaseLayer.forModel(localLayer, paramLottieDrawable, paramLottieComposition);
      if (this.layer != null) {
        break label157;
      }
    }
    for (;;)
    {
      i -= 1;
      break label103;
      this.timeRemapping = null;
      break;
      label157:
      localLongSparseArray.put(this.layer.getLayerModel().getId(), this.layer);
      if (paramLayer != null)
      {
        paramLayer.setMatteLayer(this.layer);
        paramLayer = null;
      }
      else
      {
        this.layer.parentComposition = this;
        this.layerCount += this.layer.layerCount;
        this.layers.add(0, this.layer);
        switch (localLayer.getMatteType())
        {
        default: 
          break;
        case 1: 
        case 2: 
          paramLayer = this.layer;
        }
      }
    }
    label271:
    int i = 0;
    while (i < localLongSparseArray.size())
    {
      paramLottieDrawable = (BaseLayer)localLongSparseArray.get(localLongSparseArray.keyAt(i));
      paramLayer = (BaseLayer)localLongSparseArray.get(paramLottieDrawable.getLayerModel().getParentId());
      if (paramLayer != null) {
        paramLottieDrawable.setParentLayer(paramLayer);
      }
      i += 1;
    }
  }
  
  private void collectLayers(LayerInfo paramLayerInfo, int paramInt)
  {
    if (paramInt > paramLayerInfo.maxDepth)
    {
      paramLayerInfo.maxDepth = paramInt;
      paramLayerInfo.deepestLayer = this;
    }
    Iterator localIterator = this.layers.iterator();
    while (localIterator.hasNext())
    {
      BaseLayer localBaseLayer = (BaseLayer)localIterator.next();
      if ((localBaseLayer instanceof CompositionLayer)) {
        ((CompositionLayer)localBaseLayer).collectLayers(paramLayerInfo, paramInt + 1);
      }
    }
  }
  
  public void addColorFilter(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    int i = 0;
    if (i < this.layers.size())
    {
      BaseLayer localBaseLayer = (BaseLayer)this.layers.get(i);
      String str = localBaseLayer.getLayerModel().getName();
      if (paramString1 == null) {
        localBaseLayer.addColorFilter(null, null, paramColorFilter);
      }
      for (;;)
      {
        i += 1;
        break;
        if (str.equals(paramString1)) {
          localBaseLayer.addColorFilter(paramString1, paramString2, paramColorFilter);
        }
      }
    }
  }
  
  public void collectLayers(LayerInfo paramLayerInfo)
  {
    paramLayerInfo.maxDepth = -1;
    collectLayers(paramLayerInfo, 0);
    ArrayDeque localArrayDeque = new ArrayDeque(paramLayerInfo.maxDepth);
    for (Object localObject = paramLayerInfo.deepestLayer; ((CompositionLayer)localObject).parentComposition != null; localObject = ((CompositionLayer)localObject).parentComposition) {
      localArrayDeque.push(((CompositionLayer)localObject).layerModel.getRefId());
    }
    localObject = new StringBuilder("root");
    while (!localArrayDeque.isEmpty())
    {
      ((StringBuilder)localObject).append("->");
      ((StringBuilder)localObject).append((String)localArrayDeque.pop());
    }
    paramLayerInfo.layerCount = this.layerCount;
    paramLayerInfo.longestPath = ((StringBuilder)localObject).toString();
  }
  
  void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    L.beginSection("CompositionLayer#draw");
    paramCanvas.save();
    this.newClipRect.set(0.0F, 0.0F, this.layerModel.getPreCompWidth(), this.layerModel.getPreCompHeight());
    paramMatrix.mapRect(this.newClipRect);
    int i = this.layers.size() - 1;
    while (i >= 0)
    {
      boolean bool = true;
      if (!this.newClipRect.isEmpty()) {
        bool = paramCanvas.clipRect(this.newClipRect);
      }
      if (bool) {
        ((BaseLayer)this.layers.get(i)).draw(paramCanvas, paramMatrix, paramInt);
      }
      i -= 1;
    }
    paramCanvas.restore();
    L.endSection("CompositionLayer#draw");
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
  {
    super.getBounds(paramRectF, paramMatrix);
    this.rect.set(0.0F, 0.0F, 0.0F, 0.0F);
    int i = this.layers.size() - 1;
    if (i >= 0)
    {
      ((BaseLayer)this.layers.get(i)).getBounds(this.rect, this.boundsMatrix);
      if (paramRectF.isEmpty()) {
        paramRectF.set(this.rect);
      }
      for (;;)
      {
        i -= 1;
        break;
        paramRectF.set(Math.min(paramRectF.left, this.rect.left), Math.min(paramRectF.top, this.rect.top), Math.max(paramRectF.right, this.rect.right), Math.max(paramRectF.bottom, this.rect.bottom));
      }
    }
  }
  
  public BaseLayer getLayer()
  {
    return this.layer;
  }
  
  public boolean hasMasks()
  {
    if (this.hasMasks == null)
    {
      int i = this.layers.size() - 1;
      while (i >= 0)
      {
        BaseLayer localBaseLayer = (BaseLayer)this.layers.get(i);
        if ((localBaseLayer instanceof ShapeLayer))
        {
          if (localBaseLayer.hasMasksOnThisLayer())
          {
            this.hasMasks = Boolean.valueOf(true);
            return true;
          }
        }
        else if (((localBaseLayer instanceof CompositionLayer)) && (((CompositionLayer)localBaseLayer).hasMasks()))
        {
          this.hasMasks = Boolean.valueOf(true);
          return true;
        }
        i -= 1;
      }
      this.hasMasks = Boolean.valueOf(false);
    }
    return this.hasMasks.booleanValue();
  }
  
  public boolean hasMatte()
  {
    if (this.hasMatte == null)
    {
      if (hasMatteOnThisLayer())
      {
        this.hasMatte = Boolean.valueOf(true);
        return true;
      }
      int i = this.layers.size() - 1;
      while (i >= 0)
      {
        if (((BaseLayer)this.layers.get(i)).hasMatteOnThisLayer())
        {
          this.hasMatte = Boolean.valueOf(true);
          return true;
        }
        i -= 1;
      }
      this.hasMatte = Boolean.valueOf(false);
    }
    return this.hasMatte.booleanValue();
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    super.setProgress(paramFloat);
    if (this.timeRemapping != null)
    {
      long l = this.lottieDrawable.getComposition().getDuration();
      paramFloat = (float)(((Float)this.timeRemapping.getValue()).floatValue() * 1000.0F) / (float)l;
    }
    float f = paramFloat;
    if (this.layerModel.getTimeStretch() != 0.0F) {
      f = paramFloat / this.layerModel.getTimeStretch();
    }
    paramFloat = this.layerModel.getStartProgress();
    int i = this.layers.size() - 1;
    while (i >= 0)
    {
      ((BaseLayer)this.layers.get(i)).setProgress(f - paramFloat);
      i -= 1;
    }
  }
  
  public String toString()
  {
    return "CompositionLayer{refId=" + this.layerModel.getRefId() + ", layerCount=" + this.layerCount + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.layer.CompositionLayer
 * JD-Core Version:    0.7.0.1
 */