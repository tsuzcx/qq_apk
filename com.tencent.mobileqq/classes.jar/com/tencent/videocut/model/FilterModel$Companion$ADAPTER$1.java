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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/FilterModel$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/FilterModel;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class FilterModel$Companion$ADAPTER$1
  extends ProtoAdapter<FilterModel>
{
  FilterModel$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull FilterModel paramFilterModel)
  {
    Intrinsics.checkParameterIsNotNull(paramFilterModel, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramFilterModel.id) + LutFilterModel.ADAPTER.encodedSizeWithTag(2, paramFilterModel.lut) + ColorFilterModel.ADAPTER.encodedSizeWithTag(3, paramFilterModel.color) + ProtoAdapter.INT64.encodedSizeWithTag(4, Long.valueOf(paramFilterModel.startTimeUs)) + ProtoAdapter.INT64.encodedSizeWithTag(5, Long.valueOf(paramFilterModel.durationUs)) + ProtoAdapter.INT32.encodedSizeWithTag(6, paramFilterModel.timeLineIndex) + paramFilterModel.unknownFields().size();
  }
  
  @NotNull
  public FilterModel a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    String str = (String)null;
    LutFilterModel localLutFilterModel = (LutFilterModel)null;
    ColorFilterModel localColorFilterModel = (ColorFilterModel)null;
    Integer localInteger = (Integer)null;
    long l3 = paramProtoReader.beginMessage();
    long l2 = 0L;
    long l1 = l2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l3);
        if (str == null) {
          str = "";
        }
        return new FilterModel(str, localLutFilterModel, localColorFilterModel, l2, l1, localInteger, paramProtoReader);
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 6: 
        localInteger = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 5: 
        l1 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        break;
      case 4: 
        l2 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        break;
      case 3: 
        localColorFilterModel = (ColorFilterModel)ColorFilterModel.ADAPTER.decode(paramProtoReader);
        break;
      case 2: 
        localLutFilterModel = (LutFilterModel)LutFilterModel.ADAPTER.decode(paramProtoReader);
        break;
      case 1: 
        str = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull FilterModel paramFilterModel)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramFilterModel, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramFilterModel.id);
    LutFilterModel.ADAPTER.encodeWithTag(paramProtoWriter, 2, paramFilterModel.lut);
    ColorFilterModel.ADAPTER.encodeWithTag(paramProtoWriter, 3, paramFilterModel.color);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 4, Long.valueOf(paramFilterModel.startTimeUs));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 5, Long.valueOf(paramFilterModel.durationUs));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 6, paramFilterModel.timeLineIndex);
    paramProtoWriter.writeBytes(paramFilterModel.unknownFields());
  }
  
  @NotNull
  public FilterModel b(@NotNull FilterModel paramFilterModel)
  {
    Intrinsics.checkParameterIsNotNull(paramFilterModel, "value");
    LutFilterModel localLutFilterModel = paramFilterModel.lut;
    ColorFilterModel localColorFilterModel1 = null;
    if (localLutFilterModel != null) {
      localLutFilterModel = (LutFilterModel)LutFilterModel.ADAPTER.redact(localLutFilterModel);
    } else {
      localLutFilterModel = null;
    }
    ColorFilterModel localColorFilterModel2 = paramFilterModel.color;
    if (localColorFilterModel2 != null) {
      localColorFilterModel1 = (ColorFilterModel)ColorFilterModel.ADAPTER.redact(localColorFilterModel2);
    }
    return FilterModel.copy$default(paramFilterModel, null, localLutFilterModel, localColorFilterModel1, null, null, null, ByteString.EMPTY, 57, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.FilterModel.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */