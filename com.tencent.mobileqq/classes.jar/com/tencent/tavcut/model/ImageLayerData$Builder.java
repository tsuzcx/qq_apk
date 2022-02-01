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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/ImageLayerData$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/ImageLayerData;", "()V", "layerIndex", "", "Ljava/lang/Integer;", "layerMarkList", "", "Lcom/tencent/tavcut/model/LayerMarkData;", "layerName", "", "layerType", "build", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class ImageLayerData$Builder
  extends Message.Builder<ImageLayerData, Builder>
{
  @JvmField
  @Nullable
  public Integer layerIndex;
  @JvmField
  @NotNull
  public List<LayerMarkData> layerMarkList = CollectionsKt.emptyList();
  @JvmField
  @Nullable
  public String layerName;
  @JvmField
  @Nullable
  public Integer layerType;
  
  @NotNull
  public ImageLayerData build()
  {
    Object localObject = this.layerIndex;
    if (localObject != null)
    {
      int i = ((Integer)localObject).intValue();
      localObject = this.layerName;
      Integer localInteger = this.layerType;
      if (localInteger != null) {
        return new ImageLayerData(i, (String)localObject, localInteger.intValue(), this.layerMarkList, buildUnknownFields());
      }
      throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger, "layerType" }));
    }
    throw ((Throwable)Internal.missingRequiredFields(new Object[] { localObject, "layerIndex" }));
  }
  
  @NotNull
  public final Builder layerIndex(int paramInt)
  {
    this.layerIndex = Integer.valueOf(paramInt);
    return this;
  }
  
  @NotNull
  public final Builder layerMarkList(@NotNull List<LayerMarkData> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "layerMarkList");
    Internal.checkElementsNotNull(paramList);
    this.layerMarkList = paramList;
    return this;
  }
  
  @NotNull
  public final Builder layerName(@Nullable String paramString)
  {
    this.layerName = paramString;
    return this;
  }
  
  @NotNull
  public final Builder layerType(int paramInt)
  {
    this.layerType = Integer.valueOf(paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.ImageLayerData.Builder
 * JD-Core Version:    0.7.0.1
 */