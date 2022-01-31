package com.tencent.mobileqq.dinifly.model.layer;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextFrame;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextProperties;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform;
import com.tencent.mobileqq.dinifly.model.content.ContentModel;
import com.tencent.mobileqq.dinifly.model.content.Mask;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Layer
{
  private final LottieComposition composition;
  private final boolean hidden;
  private final List<Keyframe<Float>> inOutKeyframes;
  private final long layerId;
  private final String layerName;
  private final Layer.LayerType layerType;
  private final List<Mask> masks;
  private final Layer.MatteType matteType;
  private final long parentId;
  private final int preCompHeight;
  private final int preCompWidth;
  @Nullable
  private final String refId;
  private final List<ContentModel> shapes;
  private final int solidColor;
  private final int solidHeight;
  private final int solidWidth;
  private final float startFrame;
  @Nullable
  private final AnimatableTextFrame text;
  @Nullable
  private final AnimatableTextProperties textProperties;
  @Nullable
  private final AnimatableFloatValue timeRemapping;
  private final float timeStretch;
  private final AnimatableTransform transform;
  
  public Layer(List<ContentModel> paramList, LottieComposition paramLottieComposition, String paramString1, long paramLong1, Layer.LayerType paramLayerType, long paramLong2, @Nullable String paramString2, List<Mask> paramList1, AnimatableTransform paramAnimatableTransform, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4, int paramInt5, @Nullable AnimatableTextFrame paramAnimatableTextFrame, @Nullable AnimatableTextProperties paramAnimatableTextProperties, List<Keyframe<Float>> paramList2, Layer.MatteType paramMatteType, @Nullable AnimatableFloatValue paramAnimatableFloatValue, boolean paramBoolean)
  {
    this.shapes = paramList;
    this.composition = paramLottieComposition;
    this.layerName = paramString1;
    this.layerId = paramLong1;
    this.layerType = paramLayerType;
    this.parentId = paramLong2;
    this.refId = paramString2;
    this.masks = paramList1;
    this.transform = paramAnimatableTransform;
    this.solidWidth = paramInt1;
    this.solidHeight = paramInt2;
    this.solidColor = paramInt3;
    this.timeStretch = paramFloat1;
    this.startFrame = paramFloat2;
    this.preCompWidth = paramInt4;
    this.preCompHeight = paramInt5;
    this.text = paramAnimatableTextFrame;
    this.textProperties = paramAnimatableTextProperties;
    this.inOutKeyframes = paramList2;
    this.matteType = paramMatteType;
    this.timeRemapping = paramAnimatableFloatValue;
    this.hidden = paramBoolean;
  }
  
  LottieComposition getComposition()
  {
    return this.composition;
  }
  
  public long getId()
  {
    return this.layerId;
  }
  
  List<Keyframe<Float>> getInOutKeyframes()
  {
    return this.inOutKeyframes;
  }
  
  public Layer.LayerType getLayerType()
  {
    return this.layerType;
  }
  
  List<Mask> getMasks()
  {
    return this.masks;
  }
  
  Layer.MatteType getMatteType()
  {
    return this.matteType;
  }
  
  String getName()
  {
    return this.layerName;
  }
  
  long getParentId()
  {
    return this.parentId;
  }
  
  int getPreCompHeight()
  {
    return this.preCompHeight;
  }
  
  int getPreCompWidth()
  {
    return this.preCompWidth;
  }
  
  @Nullable
  String getRefId()
  {
    return this.refId;
  }
  
  List<ContentModel> getShapes()
  {
    return this.shapes;
  }
  
  int getSolidColor()
  {
    return this.solidColor;
  }
  
  int getSolidHeight()
  {
    return this.solidHeight;
  }
  
  int getSolidWidth()
  {
    return this.solidWidth;
  }
  
  float getStartProgress()
  {
    return this.startFrame / this.composition.getDurationFrames();
  }
  
  @Nullable
  AnimatableTextFrame getText()
  {
    return this.text;
  }
  
  @Nullable
  AnimatableTextProperties getTextProperties()
  {
    return this.textProperties;
  }
  
  @Nullable
  AnimatableFloatValue getTimeRemapping()
  {
    return this.timeRemapping;
  }
  
  float getTimeStretch()
  {
    return this.timeStretch;
  }
  
  AnimatableTransform getTransform()
  {
    return this.transform;
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
  
  public String toString()
  {
    return toString("");
  }
  
  public String toString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append(getName()).append("\n");
    Object localObject1 = this.composition.layerModelForId(getParentId());
    if (localObject1 != null)
    {
      localStringBuilder.append("\t\tParents: ").append(((Layer)localObject1).getName());
      for (localObject1 = this.composition.layerModelForId(((Layer)localObject1).getParentId()); localObject1 != null; localObject1 = this.composition.layerModelForId(((Layer)localObject1).getParentId())) {
        localStringBuilder.append("->").append(((Layer)localObject1).getName());
      }
      localStringBuilder.append(paramString).append("\n");
    }
    if (!getMasks().isEmpty()) {
      localStringBuilder.append(paramString).append("\tMasks: ").append(getMasks().size()).append("\n");
    }
    if ((getSolidWidth() != 0) && (getSolidHeight() != 0)) {
      localStringBuilder.append(paramString).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", new Object[] { Integer.valueOf(getSolidWidth()), Integer.valueOf(getSolidHeight()), Integer.valueOf(getSolidColor()) }));
    }
    if (!this.shapes.isEmpty())
    {
      localStringBuilder.append(paramString).append("\tShapes:\n");
      localObject1 = this.shapes.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        localStringBuilder.append(paramString).append("\t\t").append(localObject2).append("\n");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.layer.Layer
 * JD-Core Version:    0.7.0.1
 */