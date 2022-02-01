package com.tencent.tavcut.model;

import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.composition.model.component.VolumeEffect;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/AudioAsset$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/AudioAsset;", "()V", "assetId", "", "path", "speed", "", "Ljava/lang/Float;", "startOffset", "", "Ljava/lang/Long;", "timeRange", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "type", "", "Ljava/lang/Integer;", "volume", "volumeEffects", "", "Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "build", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class AudioAsset$Builder
  extends Message.Builder<AudioAsset, Builder>
{
  @JvmField
  @Nullable
  public String assetId;
  @JvmField
  @Nullable
  public String path;
  @JvmField
  @Nullable
  public Float speed;
  @JvmField
  @Nullable
  public Long startOffset;
  @JvmField
  @Nullable
  public TimeRange timeRange;
  @JvmField
  @Nullable
  public Integer type;
  @JvmField
  @Nullable
  public Float volume;
  @JvmField
  @NotNull
  public List<VolumeEffect> volumeEffects = CollectionsKt.emptyList();
  
  @NotNull
  public final Builder assetId(@Nullable String paramString)
  {
    this.assetId = paramString;
    return this;
  }
  
  @NotNull
  public AudioAsset build()
  {
    String str1 = this.assetId;
    String str2 = this.path;
    TimeRange localTimeRange = this.timeRange;
    Object localObject = this.speed;
    if (localObject != null)
    {
      float f1 = ((Float)localObject).floatValue();
      localObject = this.volume;
      if (localObject != null)
      {
        float f2 = ((Float)localObject).floatValue();
        localObject = this.startOffset;
        if (localObject != null)
        {
          long l = ((Long)localObject).longValue();
          localObject = this.volumeEffects;
          Integer localInteger = this.type;
          if (localInteger != null) {
            return new AudioAsset(str1, str2, localTimeRange, f1, f2, l, (List)localObject, localInteger.intValue(), buildUnknownFields());
          }
          throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger, "type" }));
        }
        throw ((Throwable)Internal.missingRequiredFields(new Object[] { localObject, "startOffset" }));
      }
      throw ((Throwable)Internal.missingRequiredFields(new Object[] { localObject, "volume" }));
    }
    throw ((Throwable)Internal.missingRequiredFields(new Object[] { localObject, "speed" }));
  }
  
  @NotNull
  public final Builder path(@Nullable String paramString)
  {
    this.path = paramString;
    return this;
  }
  
  @NotNull
  public final Builder speed(float paramFloat)
  {
    this.speed = Float.valueOf(paramFloat);
    return this;
  }
  
  @NotNull
  public final Builder startOffset(long paramLong)
  {
    this.startOffset = Long.valueOf(paramLong);
    return this;
  }
  
  @NotNull
  public final Builder timeRange(@Nullable TimeRange paramTimeRange)
  {
    this.timeRange = paramTimeRange;
    return this;
  }
  
  @NotNull
  public final Builder type(int paramInt)
  {
    this.type = Integer.valueOf(paramInt);
    return this;
  }
  
  @NotNull
  public final Builder volume(float paramFloat)
  {
    this.volume = Float.valueOf(paramFloat);
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
 * Qualified Name:     com.tencent.tavcut.model.AudioAsset.Builder
 * JD-Core Version:    0.7.0.1
 */