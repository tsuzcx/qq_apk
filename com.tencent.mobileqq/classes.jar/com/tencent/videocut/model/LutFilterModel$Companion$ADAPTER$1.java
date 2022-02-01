package com.tencent.videocut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/LutFilterModel$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/LutFilterModel;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class LutFilterModel$Companion$ADAPTER$1
  extends ProtoAdapter<LutFilterModel>
{
  LutFilterModel$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull LutFilterModel paramLutFilterModel)
  {
    Intrinsics.checkParameterIsNotNull(paramLutFilterModel, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramLutFilterModel.name) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramLutFilterModel.filterId) + ProtoAdapter.STRING.encodedSizeWithTag(3, paramLutFilterModel.filePath) + ProtoAdapter.FLOAT.encodedSizeWithTag(4, Float.valueOf(paramLutFilterModel.intensity)) + ProtoAdapter.STRING.encodedSizeWithTag(5, paramLutFilterModel.categoryId) + ProtoAdapter.STRING.encodedSizeWithTag(6, paramLutFilterModel.themeId) + paramLutFilterModel.unknownFields().size();
  }
  
  @NotNull
  public LutFilterModel a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    String str1 = (String)null;
    Float localFloat = (Float)null;
    long l = paramProtoReader.beginMessage();
    String str2 = str1;
    String str3 = str2;
    String str5 = "";
    String str4 = str5;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l);
        float f;
        if (localFloat != null) {
          f = localFloat.floatValue();
        } else {
          f = 0.0F;
        }
        return new LutFilterModel(str1, str5, str4, f, str2, str3, paramProtoReader);
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 6: 
        str3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 5: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 4: 
        localFloat = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 3: 
        str4 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 2: 
        str5 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 1: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull LutFilterModel paramLutFilterModel)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramLutFilterModel, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramLutFilterModel.name);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramLutFilterModel.filterId);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 3, paramLutFilterModel.filePath);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 4, Float.valueOf(paramLutFilterModel.intensity));
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 5, paramLutFilterModel.categoryId);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 6, paramLutFilterModel.themeId);
    paramProtoWriter.writeBytes(paramLutFilterModel.unknownFields());
  }
  
  @NotNull
  public LutFilterModel b(@NotNull LutFilterModel paramLutFilterModel)
  {
    Intrinsics.checkParameterIsNotNull(paramLutFilterModel, "value");
    return LutFilterModel.copy$default(paramLutFilterModel, null, null, null, null, null, null, ByteString.EMPTY, 63, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.LutFilterModel.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */