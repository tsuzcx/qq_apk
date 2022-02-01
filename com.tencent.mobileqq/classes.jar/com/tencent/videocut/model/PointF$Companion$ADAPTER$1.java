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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/PointF$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/PointF;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class PointF$Companion$ADAPTER$1
  extends ProtoAdapter<PointF>
{
  PointF$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull PointF paramPointF)
  {
    Intrinsics.checkParameterIsNotNull(paramPointF, "value");
    return ProtoAdapter.FLOAT.encodedSizeWithTag(1, Float.valueOf(paramPointF.x)) + ProtoAdapter.FLOAT.encodedSizeWithTag(2, Float.valueOf(paramPointF.y)) + paramPointF.unknownFields().size();
  }
  
  @NotNull
  public PointF a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    long l = paramProtoReader.beginMessage();
    float f2 = 0.0F;
    float f1 = 0.0F;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new PointF(f2, f1, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      if (i != 1)
      {
        if (i != 2) {
          paramProtoReader.readUnknownField(i);
        } else {
          f1 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
        }
      }
      else {
        f2 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull PointF paramPointF)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramPointF, "value");
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 1, Float.valueOf(paramPointF.x));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 2, Float.valueOf(paramPointF.y));
    paramProtoWriter.writeBytes(paramPointF.unknownFields());
  }
  
  @NotNull
  public PointF b(@NotNull PointF paramPointF)
  {
    Intrinsics.checkParameterIsNotNull(paramPointF, "value");
    return PointF.copy$default(paramPointF, null, null, ByteString.EMPTY, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.PointF.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */