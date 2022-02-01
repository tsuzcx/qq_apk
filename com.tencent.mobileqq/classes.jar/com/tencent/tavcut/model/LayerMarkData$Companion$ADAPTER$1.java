package com.tencent.tavcut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/model/LayerMarkData$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/model/LayerMarkData;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LayerMarkData$Companion$ADAPTER$1
  extends ProtoAdapter<LayerMarkData>
{
  LayerMarkData$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public LayerMarkData decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Long localLong1 = (Long)null;
    String str = (String)null;
    long l = paramProtoReader.beginMessage();
    Long localLong2 = localLong1;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l);
        if (localLong1 != null)
        {
          l = localLong1.longValue();
          if (localLong2 != null) {
            return new LayerMarkData(l, localLong2.longValue(), str, paramProtoReader);
          }
          throw ((Throwable)Internal.missingRequiredFields(new Object[] { localLong2, "durationUs" }));
        }
        throw ((Throwable)Internal.missingRequiredFields(new Object[] { localLong1, "startTimeUs" }));
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            paramProtoReader.readUnknownField(i);
          } else {
            str = (String)ProtoAdapter.STRING.decode(paramProtoReader);
          }
        }
        else {
          localLong2 = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
        }
      }
      else {
        localLong1 = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull LayerMarkData paramLayerMarkData)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramLayerMarkData, "value");
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 1, Long.valueOf(paramLayerMarkData.startTimeUs));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 2, Long.valueOf(paramLayerMarkData.durationUs));
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 3, paramLayerMarkData.desc);
    paramProtoWriter.writeBytes(paramLayerMarkData.unknownFields());
  }
  
  public int encodedSize(@NotNull LayerMarkData paramLayerMarkData)
  {
    Intrinsics.checkParameterIsNotNull(paramLayerMarkData, "value");
    return ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(paramLayerMarkData.startTimeUs)) + ProtoAdapter.INT64.encodedSizeWithTag(2, Long.valueOf(paramLayerMarkData.durationUs)) + ProtoAdapter.STRING.encodedSizeWithTag(3, paramLayerMarkData.desc) + paramLayerMarkData.unknownFields().size();
  }
  
  @NotNull
  public LayerMarkData redact(@NotNull LayerMarkData paramLayerMarkData)
  {
    Intrinsics.checkParameterIsNotNull(paramLayerMarkData, "value");
    return LayerMarkData.copy$default(paramLayerMarkData, 0L, 0L, null, ByteString.EMPTY, 7, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.LayerMarkData.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */