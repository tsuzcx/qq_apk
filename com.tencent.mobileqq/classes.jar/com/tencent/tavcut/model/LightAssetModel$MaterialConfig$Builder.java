package com.tencent.tavcut.model;

import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/LightAssetModel$MaterialConfig$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/LightAssetModel$MaterialConfig;", "()V", "maxAssetCount", "", "Ljava/lang/Integer;", "maxImageDuration", "minAssetCount", "minImageDuration", "minVideoDuration", "type", "Lcom/tencent/tavcut/model/LightAssetModel$MediaType;", "build", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LightAssetModel$MaterialConfig$Builder
  extends Message.Builder<LightAssetModel.MaterialConfig, Builder>
{
  @JvmField
  @Nullable
  public Integer maxAssetCount;
  @JvmField
  @Nullable
  public Integer maxImageDuration;
  @JvmField
  @Nullable
  public Integer minAssetCount;
  @JvmField
  @Nullable
  public Integer minImageDuration;
  @JvmField
  @Nullable
  public Integer minVideoDuration;
  @JvmField
  @Nullable
  public LightAssetModel.MediaType type;
  
  @NotNull
  public LightAssetModel.MaterialConfig build()
  {
    LightAssetModel.MediaType localMediaType = this.type;
    Integer localInteger = this.minAssetCount;
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      localInteger = this.maxAssetCount;
      if (localInteger != null)
      {
        int j = localInteger.intValue();
        localInteger = this.minVideoDuration;
        if (localInteger != null)
        {
          int k = localInteger.intValue();
          localInteger = this.minImageDuration;
          if (localInteger != null)
          {
            int m = localInteger.intValue();
            localInteger = this.maxImageDuration;
            if (localInteger != null) {
              return new LightAssetModel.MaterialConfig(localMediaType, i, j, k, m, localInteger.intValue(), buildUnknownFields());
            }
            throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger, "maxImageDuration" }));
          }
          throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger, "minImageDuration" }));
        }
        throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger, "minVideoDuration" }));
      }
      throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger, "maxAssetCount" }));
    }
    throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger, "minAssetCount" }));
  }
  
  @NotNull
  public final Builder maxAssetCount(int paramInt)
  {
    this.maxAssetCount = Integer.valueOf(paramInt);
    return this;
  }
  
  @NotNull
  public final Builder maxImageDuration(int paramInt)
  {
    this.maxImageDuration = Integer.valueOf(paramInt);
    return this;
  }
  
  @NotNull
  public final Builder minAssetCount(int paramInt)
  {
    this.minAssetCount = Integer.valueOf(paramInt);
    return this;
  }
  
  @NotNull
  public final Builder minImageDuration(int paramInt)
  {
    this.minImageDuration = Integer.valueOf(paramInt);
    return this;
  }
  
  @NotNull
  public final Builder minVideoDuration(int paramInt)
  {
    this.minVideoDuration = Integer.valueOf(paramInt);
    return this;
  }
  
  @NotNull
  public final Builder type(@Nullable LightAssetModel.MediaType paramMediaType)
  {
    this.type = paramMediaType;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.LightAssetModel.MaterialConfig.Builder
 * JD-Core Version:    0.7.0.1
 */