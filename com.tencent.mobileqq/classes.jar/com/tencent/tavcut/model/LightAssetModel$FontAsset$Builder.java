package com.tencent.tavcut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/LightAssetModel$FontAsset$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/LightAssetModel$FontAsset;", "()V", "fontFamily", "", "fontStyle", "build", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LightAssetModel$FontAsset$Builder
  extends Message.Builder<LightAssetModel.FontAsset, Builder>
{
  @JvmField
  @Nullable
  public String fontFamily;
  @JvmField
  @Nullable
  public String fontStyle;
  
  @NotNull
  public LightAssetModel.FontAsset build()
  {
    return new LightAssetModel.FontAsset(this.fontFamily, this.fontStyle, buildUnknownFields());
  }
  
  @NotNull
  public final Builder fontFamily(@Nullable String paramString)
  {
    this.fontFamily = paramString;
    return this;
  }
  
  @NotNull
  public final Builder fontStyle(@Nullable String paramString)
  {
    this.fontStyle = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.LightAssetModel.FontAsset.Builder
 * JD-Core Version:    0.7.0.1
 */