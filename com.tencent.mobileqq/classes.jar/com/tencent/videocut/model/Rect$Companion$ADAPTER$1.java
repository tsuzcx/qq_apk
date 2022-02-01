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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/Rect$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/Rect;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class Rect$Companion$ADAPTER$1
  extends ProtoAdapter<Rect>
{
  Rect$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull Rect paramRect)
  {
    Intrinsics.checkParameterIsNotNull(paramRect, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(paramRect.left)) + ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(paramRect.top)) + ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(paramRect.right)) + ProtoAdapter.INT32.encodedSizeWithTag(4, Integer.valueOf(paramRect.bottom)) + paramRect.unknownFields().size();
  }
  
  @NotNull
  public Rect a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    long l = paramProtoReader.beginMessage();
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    for (;;)
    {
      int n = paramProtoReader.nextTag();
      if (n == -1) {
        return new Rect(m, k, j, i, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      if (n != 1)
      {
        if (n != 2)
        {
          if (n != 3)
          {
            if (n != 4) {
              paramProtoReader.readUnknownField(n);
            } else {
              i = ((Number)ProtoAdapter.INT32.decode(paramProtoReader)).intValue();
            }
          }
          else {
            j = ((Number)ProtoAdapter.INT32.decode(paramProtoReader)).intValue();
          }
        }
        else {
          k = ((Number)ProtoAdapter.INT32.decode(paramProtoReader)).intValue();
        }
      }
      else {
        m = ((Number)ProtoAdapter.INT32.decode(paramProtoReader)).intValue();
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull Rect paramRect)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramRect, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, Integer.valueOf(paramRect.left));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, Integer.valueOf(paramRect.top));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 3, Integer.valueOf(paramRect.right));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 4, Integer.valueOf(paramRect.bottom));
    paramProtoWriter.writeBytes(paramRect.unknownFields());
  }
  
  @NotNull
  public Rect b(@NotNull Rect paramRect)
  {
    Intrinsics.checkParameterIsNotNull(paramRect, "value");
    return Rect.copy$default(paramRect, null, null, null, null, ByteString.EMPTY, 15, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.Rect.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */