package com.tencent.tavcut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/model/LightAssetModel$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/model/LightAssetModel;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LightAssetModel$Companion$ADAPTER$1
  extends ProtoAdapter<LightAssetModel>
{
  LightAssetModel$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public LightAssetModel decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    List localList1 = (List)new ArrayList();
    List localList2 = (List)new ArrayList();
    LightAssetModel.MaterialConfig localMaterialConfig = (LightAssetModel.MaterialConfig)null;
    long l = paramProtoReader.beginMessage();
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new LightAssetModel(localList1, localList2, localMaterialConfig, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 4) {
            paramProtoReader.readUnknownField(i);
          } else {
            localMaterialConfig = (LightAssetModel.MaterialConfig)LightAssetModel.MaterialConfig.ADAPTER.decode(paramProtoReader);
          }
        }
        else {
          localList2.add(ProtoAdapter.STRING.decode(paramProtoReader));
        }
      }
      else {
        localList1.add(LightAssetModel.FontAsset.ADAPTER.decode(paramProtoReader));
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull LightAssetModel paramLightAssetModel)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramLightAssetModel, "value");
    LightAssetModel.FontAsset.ADAPTER.asRepeated().encodeWithTag(paramProtoWriter, 1, paramLightAssetModel.fontAssets);
    ProtoAdapter.STRING.asRepeated().encodeWithTag(paramProtoWriter, 2, paramLightAssetModel.musicIds);
    LightAssetModel.MaterialConfig.ADAPTER.encodeWithTag(paramProtoWriter, 4, paramLightAssetModel.materialConfig);
    paramProtoWriter.writeBytes(paramLightAssetModel.unknownFields());
  }
  
  public int encodedSize(@NotNull LightAssetModel paramLightAssetModel)
  {
    Intrinsics.checkParameterIsNotNull(paramLightAssetModel, "value");
    return LightAssetModel.FontAsset.ADAPTER.asRepeated().encodedSizeWithTag(1, paramLightAssetModel.fontAssets) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, paramLightAssetModel.musicIds) + LightAssetModel.MaterialConfig.ADAPTER.encodedSizeWithTag(4, paramLightAssetModel.materialConfig) + paramLightAssetModel.unknownFields().size();
  }
  
  @NotNull
  public LightAssetModel redact(@NotNull LightAssetModel paramLightAssetModel)
  {
    Intrinsics.checkParameterIsNotNull(paramLightAssetModel, "value");
    List localList = Internal.-redactElements(paramLightAssetModel.fontAssets, LightAssetModel.FontAsset.ADAPTER);
    LightAssetModel.MaterialConfig localMaterialConfig = paramLightAssetModel.materialConfig;
    if (localMaterialConfig != null) {
      localMaterialConfig = (LightAssetModel.MaterialConfig)LightAssetModel.MaterialConfig.ADAPTER.redact(localMaterialConfig);
    } else {
      localMaterialConfig = null;
    }
    return LightAssetModel.copy$default(paramLightAssetModel, localList, null, localMaterialConfig, ByteString.EMPTY, 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.LightAssetModel.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */