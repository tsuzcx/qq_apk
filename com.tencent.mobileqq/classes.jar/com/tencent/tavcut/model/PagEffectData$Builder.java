package com.tencent.tavcut.model;

import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/PagEffectData$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/PagEffectData;", "()V", "durationUs", "", "Ljava/lang/Long;", "filePath", "", "height", "", "Ljava/lang/Integer;", "imageLayerList", "", "Lcom/tencent/tavcut/model/ImageLayerData;", "textLayerList", "Lcom/tencent/tavcut/model/TextLayerData;", "timeStretchMode", "width", "build", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class PagEffectData$Builder
  extends Message.Builder<PagEffectData, Builder>
{
  @JvmField
  @Nullable
  public Long durationUs;
  @JvmField
  @Nullable
  public String filePath;
  @JvmField
  @Nullable
  public Integer height;
  @JvmField
  @NotNull
  public List<ImageLayerData> imageLayerList = CollectionsKt.emptyList();
  @JvmField
  @NotNull
  public List<TextLayerData> textLayerList = CollectionsKt.emptyList();
  @JvmField
  @Nullable
  public Integer timeStretchMode;
  @JvmField
  @Nullable
  public Integer width;
  
  @NotNull
  public PagEffectData build()
  {
    String str = this.filePath;
    Object localObject = this.width;
    if (localObject != null)
    {
      int i = ((Integer)localObject).intValue();
      localObject = this.height;
      if (localObject != null)
      {
        int j = ((Integer)localObject).intValue();
        localObject = this.durationUs;
        if (localObject != null)
        {
          long l = ((Long)localObject).longValue();
          localObject = this.textLayerList;
          List localList = this.imageLayerList;
          Integer localInteger = this.timeStretchMode;
          if (localInteger != null) {
            return new PagEffectData(str, i, j, l, (List)localObject, localList, localInteger.intValue(), buildUnknownFields());
          }
          throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger, "timeStretchMode" }));
        }
        throw ((Throwable)Internal.missingRequiredFields(new Object[] { localObject, "durationUs" }));
      }
      throw ((Throwable)Internal.missingRequiredFields(new Object[] { localObject, "height" }));
    }
    throw ((Throwable)Internal.missingRequiredFields(new Object[] { localObject, "width" }));
  }
  
  @NotNull
  public final Builder durationUs(long paramLong)
  {
    this.durationUs = Long.valueOf(paramLong);
    return this;
  }
  
  @NotNull
  public final Builder filePath(@Nullable String paramString)
  {
    this.filePath = paramString;
    return this;
  }
  
  @NotNull
  public final Builder height(int paramInt)
  {
    this.height = Integer.valueOf(paramInt);
    return this;
  }
  
  @NotNull
  public final Builder imageLayerList(@NotNull List<ImageLayerData> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "imageLayerList");
    Internal.checkElementsNotNull(paramList);
    this.imageLayerList = paramList;
    return this;
  }
  
  @NotNull
  public final Builder textLayerList(@NotNull List<TextLayerData> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "textLayerList");
    Internal.checkElementsNotNull(paramList);
    this.textLayerList = paramList;
    return this;
  }
  
  @NotNull
  public final Builder timeStretchMode(int paramInt)
  {
    this.timeStretchMode = Integer.valueOf(paramInt);
    return this;
  }
  
  @NotNull
  public final Builder width(int paramInt)
  {
    this.width = Integer.valueOf(paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.PagEffectData.Builder
 * JD-Core Version:    0.7.0.1
 */