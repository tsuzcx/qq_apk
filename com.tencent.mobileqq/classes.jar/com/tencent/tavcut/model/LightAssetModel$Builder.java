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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/LightAssetModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/LightAssetModel;", "()V", "fontAssets", "", "Lcom/tencent/tavcut/model/LightAssetModel$FontAsset;", "materialConfig", "Lcom/tencent/tavcut/model/LightAssetModel$MaterialConfig;", "musicIds", "", "build", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LightAssetModel$Builder
  extends Message.Builder<LightAssetModel, Builder>
{
  @JvmField
  @NotNull
  public List<LightAssetModel.FontAsset> fontAssets = CollectionsKt.emptyList();
  @JvmField
  @Nullable
  public LightAssetModel.MaterialConfig materialConfig;
  @JvmField
  @NotNull
  public List<String> musicIds = CollectionsKt.emptyList();
  
  @NotNull
  public LightAssetModel build()
  {
    return new LightAssetModel(this.fontAssets, this.musicIds, this.materialConfig, buildUnknownFields());
  }
  
  @NotNull
  public final Builder fontAssets(@NotNull List<LightAssetModel.FontAsset> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "fontAssets");
    Internal.checkElementsNotNull(paramList);
    this.fontAssets = paramList;
    return this;
  }
  
  @NotNull
  public final Builder materialConfig(@Nullable LightAssetModel.MaterialConfig paramMaterialConfig)
  {
    this.materialConfig = paramMaterialConfig;
    return this;
  }
  
  @NotNull
  public final Builder musicIds(@NotNull List<String> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "musicIds");
    Internal.checkElementsNotNull(paramList);
    this.musicIds = paramList;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.LightAssetModel.Builder
 * JD-Core Version:    0.7.0.1
 */