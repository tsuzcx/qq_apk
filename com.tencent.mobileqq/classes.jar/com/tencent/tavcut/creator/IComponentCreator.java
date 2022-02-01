package com.tencent.tavcut.creator;

import com.tencent.tavcut.composition.model.component.AudioSource;
import com.tencent.tavcut.composition.model.component.Camera;
import com.tencent.tavcut.composition.model.component.EntityIdentifier;
import com.tencent.tavcut.composition.model.component.Image;
import com.tencent.tavcut.composition.model.component.LUTFilter;
import com.tencent.tavcut.composition.model.component.PAGAsset;
import com.tencent.tavcut.composition.model.component.PAGAsset.PagScaleMode;
import com.tencent.tavcut.composition.model.component.PAGAsset.Replacement;
import com.tencent.tavcut.composition.model.component.PostEffect;
import com.tencent.tavcut.composition.model.component.Priority;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.SingleMedia;
import com.tencent.tavcut.composition.model.component.TimeOffset;
import com.tencent.tavcut.composition.model.component.Transition;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/creator/IComponentCreator;", "", "createAdjustPostEffect", "Lcom/tencent/tavcut/composition/model/component/PostEffect;", "sharpness", "", "brightness", "contrast", "hue", "highlights", "shadows", "saturation", "temperature", "createAudioEffect", "Lcom/tencent/tavcut/composition/model/component/AudioEffect;", "preset", "", "createAudioSource", "Lcom/tencent/tavcut/composition/model/component/AudioSource;", "resourceId", "volume", "", "speed", "createCamera", "Lcom/tencent/tavcut/composition/model/component/Camera;", "renderTargetKey", "createCustomGraph", "Lcom/tencent/tavcut/composition/model/component/CustomGraph;", "createEffectPAGAsset", "Lcom/tencent/tavcut/composition/model/component/PAGAsset;", "usage", "scaleMode", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$PagScaleMode;", "replaceIndex", "createEntityIdentifier", "Lcom/tencent/tavcut/composition/model/component/EntityIdentifier;", "name", "createImage", "Lcom/tencent/tavcut/composition/model/component/Image;", "durationUs", "", "createLutFilter", "Lcom/tencent/tavcut/composition/model/component/LUTFilter;", "strength", "createPAGAsset", "replacement", "", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", "createPriority", "Lcom/tencent/tavcut/composition/model/component/Priority;", "priority", "createScreenTransform", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "scale", "anchorPointX", "anchorPointY", "width", "height", "rotate", "createScreenTransformPinToEdge", "anchor", "Lcom/tencent/tavcut/composition/model/component/Rect;", "createScript", "Lcom/tencent/tavcut/composition/model/component/Script;", "createSingleMedia", "Lcom/tencent/tavcut/composition/model/component/SingleMedia;", "index", "createTimeOffset", "Lcom/tencent/tavcut/composition/model/component/TimeOffset;", "startOffsetUs", "createTransition", "Lcom/tencent/tavcut/composition/model/component/Transition;", "firstLayerIndex", "lastLayerIndex", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface IComponentCreator
{
  @NotNull
  public abstract AudioSource a(@NotNull String paramString, float paramFloat1, float paramFloat2);
  
  @NotNull
  public abstract EntityIdentifier a(@NotNull String paramString);
  
  @NotNull
  public abstract Image a(@NotNull String paramString, long paramLong, @NotNull PAGAsset.PagScaleMode paramPagScaleMode);
  
  @NotNull
  public abstract LUTFilter a(@NotNull String paramString, float paramFloat);
  
  @NotNull
  public abstract PAGAsset a(@NotNull String paramString, int paramInt, @NotNull List<PAGAsset.Replacement> paramList, @NotNull PAGAsset.PagScaleMode paramPagScaleMode);
  
  @NotNull
  public abstract PostEffect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  @NotNull
  public abstract ScreenTransform a();
  
  @NotNull
  public abstract ScreenTransform a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
  
  @NotNull
  public abstract ScreenTransform a(float paramFloat1, float paramFloat2, @NotNull Rect paramRect);
  
  @NotNull
  public abstract SingleMedia a(int paramInt);
  
  @NotNull
  public abstract TimeOffset a(long paramLong1, long paramLong2);
  
  @NotNull
  public abstract Transition a(@NotNull String paramString, long paramLong, int paramInt1, int paramInt2);
  
  @NotNull
  public abstract Camera b(@NotNull String paramString);
  
  @NotNull
  public abstract Priority b(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.creator.IComponentCreator
 * JD-Core Version:    0.7.0.1
 */