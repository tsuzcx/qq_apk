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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/AudioSource$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/AudioSource;", "()V", "audioSourceType", "", "Ljava/lang/Integer;", "componentID", "enabled", "", "Ljava/lang/Boolean;", "entityId", "key", "", "speed", "", "Ljava/lang/Float;", "src", "type", "version", "volume", "volumeEffects", "", "Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/AudioSource$Builder;", "build", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/AudioSource$Builder;", "(Ljava/lang/Float;)Lcom/tencent/tavcut/composition/model/component/AudioSource$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class AudioSource$Builder
  extends Message.Builder<AudioSource, Builder>
{
  @JvmField
  @Nullable
  public Integer audioSourceType;
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
  public String key;
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
  public Float volume;
  @JvmField
  @NotNull
  public List<VolumeEffect> volumeEffects = CollectionsKt.emptyList();
  
  @NotNull
  public final Builder audioSourceType(@Nullable Integer paramInteger)
  {
    this.audioSourceType = paramInteger;
    return this;
  }
  
  @NotNull
  public AudioSource build()
  {
    return new AudioSource(this.entityId, this.componentID, this.enabled, this.type, this.key, this.speed, this.version, this.volume, this.volumeEffects, this.audioSourceType, this.src, buildUnknownFields());
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
  public final Builder key(@Nullable String paramString)
  {
    this.key = paramString;
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
 * Qualified Name:     com.tencent.tavcut.composition.model.component.AudioSource.Builder
 * JD-Core Version:    0.7.0.1
 */