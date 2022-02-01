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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/RectF$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/RectF;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class RectF$Companion$ADAPTER$1
  extends ProtoAdapter<RectF>
{
  RectF$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull RectF paramRectF)
  {
    Intrinsics.checkParameterIsNotNull(paramRectF, "value");
    return ProtoAdapter.FLOAT.encodedSizeWithTag(1, Float.valueOf(paramRectF.left)) + ProtoAdapter.FLOAT.encodedSizeWithTag(2, Float.valueOf(paramRectF.top)) + ProtoAdapter.FLOAT.encodedSizeWithTag(3, Float.valueOf(paramRectF.right)) + ProtoAdapter.FLOAT.encodedSizeWithTag(4, Float.valueOf(paramRectF.bottom)) + paramRectF.unknownFields().size();
  }
  
  @NotNull
  public RectF a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    long l = paramProtoReader.beginMessage();
    float f4 = 0.0F;
    float f3 = 0.0F;
    float f2 = 0.0F;
    float f1 = 0.0F;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new RectF(f4, f3, f2, f1, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              paramProtoReader.readUnknownField(i);
            } else {
              f1 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
            }
          }
          else {
            f2 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
          }
        }
        else {
          f3 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
        }
      }
      else {
        f4 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull RectF paramRectF)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramRectF, "value");
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 1, Float.valueOf(paramRectF.left));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 2, Float.valueOf(paramRectF.top));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 3, Float.valueOf(paramRectF.right));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 4, Float.valueOf(paramRectF.bottom));
    paramProtoWriter.writeBytes(paramRectF.unknownFields());
  }
  
  @NotNull
  public RectF b(@NotNull RectF paramRectF)
  {
    Intrinsics.checkParameterIsNotNull(paramRectF, "value");
    return RectF.copy$default(paramRectF, null, null, null, null, ByteString.EMPTY, 15, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.RectF.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */