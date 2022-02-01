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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/ColorFilterModel$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/ColorFilterModel;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ColorFilterModel$Companion$ADAPTER$1
  extends ProtoAdapter<ColorFilterModel>
{
  ColorFilterModel$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull ColorFilterModel paramColorFilterModel)
  {
    Intrinsics.checkParameterIsNotNull(paramColorFilterModel, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(paramColorFilterModel.sharpness)) + ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(paramColorFilterModel.brightness)) + ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(paramColorFilterModel.contrast)) + ProtoAdapter.INT32.encodedSizeWithTag(4, Integer.valueOf(paramColorFilterModel.hue)) + ProtoAdapter.INT32.encodedSizeWithTag(5, Integer.valueOf(paramColorFilterModel.highlights)) + ProtoAdapter.INT32.encodedSizeWithTag(6, Integer.valueOf(paramColorFilterModel.shadows)) + ProtoAdapter.INT32.encodedSizeWithTag(7, Integer.valueOf(paramColorFilterModel.saturation)) + ProtoAdapter.INT32.encodedSizeWithTag(8, Integer.valueOf(paramColorFilterModel.temperature)) + paramColorFilterModel.unknownFields().size();
  }
  
  @NotNull
  public ColorFilterModel a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger8 = (Integer)null;
    long l = paramProtoReader.beginMessage();
    Integer localInteger1 = localInteger8;
    Integer localInteger2 = localInteger1;
    Integer localInteger3 = localInteger2;
    Integer localInteger4 = localInteger3;
    Integer localInteger5 = localInteger4;
    Integer localInteger6 = localInteger5;
    Integer localInteger7 = localInteger6;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l);
        if (localInteger8 != null) {
          i = localInteger8.intValue();
        } else {
          i = 0;
        }
        int j;
        if (localInteger1 != null) {
          j = localInteger1.intValue();
        } else {
          j = 0;
        }
        int k;
        if (localInteger2 != null) {
          k = localInteger2.intValue();
        } else {
          k = 0;
        }
        int m;
        if (localInteger3 != null) {
          m = localInteger3.intValue();
        } else {
          m = 0;
        }
        int n;
        if (localInteger4 != null) {
          n = localInteger4.intValue();
        } else {
          n = 0;
        }
        int i1;
        if (localInteger5 != null) {
          i1 = localInteger5.intValue();
        } else {
          i1 = 0;
        }
        int i2;
        if (localInteger6 != null) {
          i2 = localInteger6.intValue();
        } else {
          i2 = 0;
        }
        int i3;
        if (localInteger7 != null) {
          i3 = localInteger7.intValue();
        } else {
          i3 = 0;
        }
        return new ColorFilterModel(i, j, k, m, n, i1, i2, i3, paramProtoReader);
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 8: 
        localInteger7 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 7: 
        localInteger6 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 6: 
        localInteger5 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 5: 
        localInteger4 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 4: 
        localInteger3 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 3: 
        localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 2: 
        localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 1: 
        localInteger8 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull ColorFilterModel paramColorFilterModel)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramColorFilterModel, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, Integer.valueOf(paramColorFilterModel.sharpness));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, Integer.valueOf(paramColorFilterModel.brightness));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 3, Integer.valueOf(paramColorFilterModel.contrast));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 4, Integer.valueOf(paramColorFilterModel.hue));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 5, Integer.valueOf(paramColorFilterModel.highlights));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 6, Integer.valueOf(paramColorFilterModel.shadows));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 7, Integer.valueOf(paramColorFilterModel.saturation));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 8, Integer.valueOf(paramColorFilterModel.temperature));
    paramProtoWriter.writeBytes(paramColorFilterModel.unknownFields());
  }
  
  @NotNull
  public ColorFilterModel b(@NotNull ColorFilterModel paramColorFilterModel)
  {
    Intrinsics.checkParameterIsNotNull(paramColorFilterModel, "value");
    return ColorFilterModel.copy$default(paramColorFilterModel, null, null, null, null, null, null, null, null, ByteString.EMPTY, 255, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.ColorFilterModel.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */