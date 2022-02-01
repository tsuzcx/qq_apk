package com.tencent.tavcut.model;

import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/ClipSource$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/ClipSource;", "()V", "clipRect", "Lcom/tencent/tavcut/composition/model/component/Rect;", "duration", "", "Ljava/lang/Long;", "matrix", "", "", "path", "", "photoEffectPath", "sourceId", "speed", "Ljava/lang/Float;", "startOffset", "transform", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "type", "Lcom/tencent/tavcut/model/ClipSource$ClipType;", "volume", "build", "(Ljava/lang/Float;)Lcom/tencent/tavcut/model/ClipSource$Builder;", "(Ljava/lang/Long;)Lcom/tencent/tavcut/model/ClipSource$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class ClipSource$Builder
  extends Message.Builder<ClipSource, Builder>
{
  @JvmField
  @Nullable
  public Rect clipRect;
  @JvmField
  @Nullable
  public Long duration;
  @JvmField
  @NotNull
  public List<Float> matrix = CollectionsKt.emptyList();
  @JvmField
  @Nullable
  public String path;
  @JvmField
  @Nullable
  public String photoEffectPath;
  @JvmField
  @Nullable
  public String sourceId;
  @JvmField
  @Nullable
  public Float speed;
  @JvmField
  @Nullable
  public Long startOffset;
  @JvmField
  @Nullable
  public ScreenTransform transform;
  @JvmField
  @Nullable
  public ClipSource.ClipType type;
  @JvmField
  @Nullable
  public Float volume;
  
  @NotNull
  public ClipSource build()
  {
    String str1 = this.sourceId;
    String str2 = this.path;
    ClipSource.ClipType localClipType = this.type;
    Long localLong = this.duration;
    if (localLong != null) {
      return new ClipSource(str1, str2, localClipType, localLong.longValue(), this.speed, this.volume, this.startOffset, this.matrix, this.photoEffectPath, this.transform, this.clipRect, buildUnknownFields());
    }
    throw ((Throwable)Internal.missingRequiredFields(new Object[] { localLong, "duration" }));
  }
  
  @NotNull
  public final Builder clipRect(@Nullable Rect paramRect)
  {
    this.clipRect = paramRect;
    return this;
  }
  
  @NotNull
  public final Builder duration(long paramLong)
  {
    this.duration = Long.valueOf(paramLong);
    return this;
  }
  
  @Deprecated(message="matrix is deprecated")
  @NotNull
  public final Builder matrix(@NotNull List<Float> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "matrix");
    Internal.checkElementsNotNull(paramList);
    this.matrix = paramList;
    return this;
  }
  
  @NotNull
  public final Builder path(@Nullable String paramString)
  {
    this.path = paramString;
    return this;
  }
  
  @NotNull
  public final Builder photoEffectPath(@Nullable String paramString)
  {
    this.photoEffectPath = paramString;
    return this;
  }
  
  @NotNull
  public final Builder sourceId(@Nullable String paramString)
  {
    this.sourceId = paramString;
    return this;
  }
  
  @NotNull
  public final Builder speed(@Nullable Float paramFloat)
  {
    this.speed = paramFloat;
    return this;
  }
  
  @NotNull
  public final Builder startOffset(@Nullable Long paramLong)
  {
    this.startOffset = paramLong;
    return this;
  }
  
  @NotNull
  public final Builder transform(@Nullable ScreenTransform paramScreenTransform)
  {
    this.transform = paramScreenTransform;
    return this;
  }
  
  @NotNull
  public final Builder type(@Nullable ClipSource.ClipType paramClipType)
  {
    this.type = paramClipType;
    return this;
  }
  
  @NotNull
  public final Builder volume(@Nullable Float paramFloat)
  {
    this.volume = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.ClipSource.Builder
 * JD-Core Version:    0.7.0.1
 */