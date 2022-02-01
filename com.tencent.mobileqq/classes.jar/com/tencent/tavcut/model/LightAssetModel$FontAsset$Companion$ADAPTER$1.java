package com.tencent.tavcut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/model/LightAssetModel$FontAsset$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/model/LightAssetModel$FontAsset;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LightAssetModel$FontAsset$Companion$ADAPTER$1
  extends ProtoAdapter<LightAssetModel.FontAsset>
{
  LightAssetModel$FontAsset$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public LightAssetModel.FontAsset decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    String str2 = (String)null;
    long l = paramProtoReader.beginMessage();
    String str1 = str2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new LightAssetModel.FontAsset(str2, str1, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      if (i != 1)
      {
        if (i != 2) {
          paramProtoReader.readUnknownField(i);
        } else {
          str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        }
      }
      else {
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull LightAssetModel.FontAsset paramFontAsset)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramFontAsset, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramFontAsset.fontFamily);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramFontAsset.fontStyle);
    paramProtoWriter.writeBytes(paramFontAsset.unknownFields());
  }
  
  public int encodedSize(@NotNull LightAssetModel.FontAsset paramFontAsset)
  {
    Intrinsics.checkParameterIsNotNull(paramFontAsset, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramFontAsset.fontFamily) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramFontAsset.fontStyle) + paramFontAsset.unknownFields().size();
  }
  
  @NotNull
  public LightAssetModel.FontAsset redact(@NotNull LightAssetModel.FontAsset paramFontAsset)
  {
    Intrinsics.checkParameterIsNotNull(paramFontAsset, "value");
    return LightAssetModel.FontAsset.copy$default(paramFontAsset, null, null, ByteString.EMPTY, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.LightAssetModel.FontAsset.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */