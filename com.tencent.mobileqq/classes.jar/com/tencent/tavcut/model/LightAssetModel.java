package com.tencent.tavcut.model;

import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.squareup.wire.WireField.Label;
import com.squareup.wire.internal.Internal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/LightAssetModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/LightAssetModel$Builder;", "fontAssets", "", "Lcom/tencent/tavcut/model/LightAssetModel$FontAsset;", "musicIds", "", "materialConfig", "Lcom/tencent/tavcut/model/LightAssetModel$MaterialConfig;", "unknownFields", "Lokio/ByteString;", "(Ljava/util/List;Ljava/util/List;Lcom/tencent/tavcut/model/LightAssetModel$MaterialConfig;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "FontAsset", "MaterialConfig", "MediaType", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LightAssetModel
  extends AndroidMessage<LightAssetModel, LightAssetModel.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<LightAssetModel> ADAPTER = (ProtoAdapter)new LightAssetModel.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LightAssetModel.class), "type.googleapis.com/publisher.LightAssetModel");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<LightAssetModel> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final LightAssetModel.Companion Companion = new LightAssetModel.Companion(null);
  @WireField(adapter="com.tencent.tavcut.model.LightAssetModel$FontAsset#ADAPTER", label=WireField.Label.REPEATED, tag=1)
  @JvmField
  @NotNull
  public final List<LightAssetModel.FontAsset> fontAssets;
  @WireField(adapter="com.tencent.tavcut.model.LightAssetModel$MaterialConfig#ADAPTER", tag=4)
  @JvmField
  @Nullable
  public final LightAssetModel.MaterialConfig materialConfig;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", label=WireField.Label.REPEATED, tag=2)
  @JvmField
  @NotNull
  public final List<String> musicIds;
  
  public LightAssetModel()
  {
    this(null, null, null, null, 15, null);
  }
  
  public LightAssetModel(@NotNull List<LightAssetModel.FontAsset> paramList, @NotNull List<String> paramList1, @Nullable LightAssetModel.MaterialConfig paramMaterialConfig, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.fontAssets = paramList;
    this.musicIds = paramList1;
    this.materialConfig = paramMaterialConfig;
  }
  
  @NotNull
  public final LightAssetModel copy(@NotNull List<LightAssetModel.FontAsset> paramList, @NotNull List<String> paramList1, @Nullable LightAssetModel.MaterialConfig paramMaterialConfig, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "fontAssets");
    Intrinsics.checkParameterIsNotNull(paramList1, "musicIds");
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new LightAssetModel(paramList, paramList1, paramMaterialConfig, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (LightAssetModel)this) {
      return true;
    }
    if (!(paramObject instanceof LightAssetModel)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (LightAssetModel)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.fontAssets, paramObject.fontAssets)) && (Intrinsics.areEqual(this.musicIds, paramObject.musicIds)) && (Intrinsics.areEqual(this.materialConfig, paramObject.materialConfig));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      j = unknownFields().hashCode();
      int k = this.fontAssets.hashCode();
      int m = this.musicIds.hashCode();
      LightAssetModel.MaterialConfig localMaterialConfig = this.materialConfig;
      if (localMaterialConfig != null) {
        i = localMaterialConfig.hashCode();
      } else {
        i = 0;
      }
      i = ((j * 37 + k) * 37 + m) * 37 + i;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public LightAssetModel.Builder newBuilder()
  {
    LightAssetModel.Builder localBuilder = new LightAssetModel.Builder();
    localBuilder.fontAssets = this.fontAssets;
    localBuilder.musicIds = this.musicIds;
    localBuilder.materialConfig = this.materialConfig;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if ((((Collection)this.fontAssets).isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fontAssets=");
      localStringBuilder.append(this.fontAssets);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((((Collection)this.musicIds).isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("musicIds=");
      localStringBuilder.append(Internal.sanitize(this.musicIds));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.materialConfig != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("materialConfig=");
      localStringBuilder.append(this.materialConfig);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"LightAssetModel{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.LightAssetModel
 * JD-Core Version:    0.7.0.1
 */