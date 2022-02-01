package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/MultiMedia$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/MultiMedia;", "()V", "backgroundColor", "", "backgroundFillMode", "", "Ljava/lang/Integer;", "backgroundPagPath", "componentID", "enabled", "", "Ljava/lang/Boolean;", "entityId", "fillScale", "", "Ljava/lang/Float;", "imageDurations", "Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration;", "imageEffect", "key", "maxSourceCount", "minDuration", "minSourceCount", "resLoopCount", "scaleMode", "size", "Lcom/tencent/tavcut/composition/model/component/Size;", "speed", "src", "type", "version", "visibleWhileOverTime", "volume", "volumeEffects", "", "Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/MultiMedia$Builder;", "build", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/MultiMedia$Builder;", "(Ljava/lang/Float;)Lcom/tencent/tavcut/composition/model/component/MultiMedia$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class MultiMedia$Builder
  extends Message.Builder<MultiMedia, Builder>
{
  @JvmField
  @Nullable
  public String backgroundColor;
  @JvmField
  @Nullable
  public Integer backgroundFillMode;
  @JvmField
  @Nullable
  public String backgroundPagPath;
  @JvmField
  @Nullable
  public Integer componentID;
  @JvmField
  @Nullable
  public Boolean enabled;
  @JvmField
  @Nullable
  public Integer entityId;
  @JvmField
  @Nullable
  public Float fillScale;
  @JvmField
  @Nullable
  public MultiMedia.ImageDuration imageDurations;
  @JvmField
  @Nullable
  public Boolean imageEffect;
  @JvmField
  @Nullable
  public String key;
  @JvmField
  @Nullable
  public Integer maxSourceCount;
  @JvmField
  @Nullable
  public Integer minDuration;
  @JvmField
  @Nullable
  public Integer minSourceCount;
  @JvmField
  @Nullable
  public Integer resLoopCount;
  @JvmField
  @Nullable
  public Integer scaleMode;
  @JvmField
  @Nullable
  public Size size;
  @JvmField
  @Nullable
  public Float speed;
  @JvmField
  @Nullable
  public String src;
  @JvmField
  @Nullable
  public String type;
  @JvmField
  @Nullable
  public Integer version;
  @JvmField
  @Nullable
  public Boolean visibleWhileOverTime;
  @JvmField
  @Nullable
  public Float volume;
  @JvmField
  @NotNull
  public List<VolumeEffect> volumeEffects = CollectionsKt.emptyList();
  
  @NotNull
  public final Builder backgroundColor(@Nullable String paramString)
  {
    this.backgroundColor = paramString;
    return this;
  }
  
  @NotNull
  public final Builder backgroundFillMode(@Nullable Integer paramInteger)
  {
    this.backgroundFillMode = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder backgroundPagPath(@Nullable String paramString)
  {
    this.backgroundPagPath = paramString;
    return this;
  }
  
  @NotNull
  public MultiMedia build()
  {
    return new MultiMedia(this.entityId, this.componentID, this.enabled, this.type, this.fillScale, this.imageDurations, this.imageEffect, this.key, this.maxSourceCount, this.minDuration, this.minSourceCount, this.scaleMode, this.size, this.speed, this.src, this.version, this.volume, this.backgroundColor, this.backgroundFillMode, this.volumeEffects, this.backgroundPagPath, this.resLoopCount, this.visibleWhileOverTime, buildUnknownFields());
  }
  
  @NotNull
  public final Builder componentID(@Nullable Integer paramInteger)
  {
    this.componentID = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder enabled(@Nullable Boolean paramBoolean)
  {
    this.enabled = paramBoolean;
    return this;
  }
  
  @NotNull
  public final Builder entityId(@Nullable Integer paramInteger)
  {
    this.entityId = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder fillScale(@Nullable Float paramFloat)
  {
    this.fillScale = paramFloat;
    return this;
  }
  
  @NotNull
  public final Builder imageDurations(@Nullable MultiMedia.ImageDuration paramImageDuration)
  {
    this.imageDurations = paramImageDuration;
    return this;
  }
  
  @NotNull
  public final Builder imageEffect(@Nullable Boolean paramBoolean)
  {
    this.imageEffect = paramBoolean;
    return this;
  }
  
  @NotNull
  public final Builder key(@Nullable String paramString)
  {
    this.key = paramString;
    return this;
  }
  
  @NotNull
  public final Builder maxSourceCount(@Nullable Integer paramInteger)
  {
    this.maxSourceCount = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder minDuration(@Nullable Integer paramInteger)
  {
    this.minDuration = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder minSourceCount(@Nullable Integer paramInteger)
  {
    this.minSourceCount = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder resLoopCount(@Nullable Integer paramInteger)
  {
    this.resLoopCount = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder scaleMode(@Nullable Integer paramInteger)
  {
    this.scaleMode = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder size(@Nullable Size paramSize)
  {
    this.size = paramSize;
    return this;
  }
  
  @NotNull
  public final Builder speed(@Nullable Float paramFloat)
  {
    this.speed = paramFloat;
    return this;
  }
  
  @NotNull
  public final Builder src(@Nullable String paramString)
  {
    this.src = paramString;
    return this;
  }
  
  @NotNull
  public final Builder type(@Nullable String paramString)
  {
    this.type = paramString;
    return this;
  }
  
  @NotNull
  public final Builder version(@Nullable Integer paramInteger)
  {
    this.version = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder visibleWhileOverTime(@Nullable Boolean paramBoolean)
  {
    this.visibleWhileOverTime = paramBoolean;
    return this;
  }
  
  @NotNull
  public final Builder volume(@Nullable Float paramFloat)
  {
    this.volume = paramFloat;
    return this;
  }
  
  @NotNull
  public final Builder volumeEffects(@NotNull List<VolumeEffect> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "volumeEffects");
    Internal.checkElementsNotNull(paramList);
    this.volumeEffects = paramList;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.MultiMedia.Builder
 * JD-Core Version:    0.7.0.1
 */