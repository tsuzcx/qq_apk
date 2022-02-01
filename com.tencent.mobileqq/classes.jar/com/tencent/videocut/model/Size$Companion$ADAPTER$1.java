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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/Size$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/Size;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class Size$Companion$ADAPTER$1
  extends ProtoAdapter<Size>
{
  Size$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull Size paramSize)
  {
    Intrinsics.checkParameterIsNotNull(paramSize, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramSize.width) + ProtoAdapter.INT32.encodedSizeWithTag(2, paramSize.height) + paramSize.unknownFields().size();
  }
  
  @NotNull
  public Size a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger2 = (Integer)null;
    long l = paramProtoReader.beginMessage();
    Integer localInteger1 = localInteger2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new Size(localInteger2, localInteger1, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      if (i != 1)
      {
        if (i != 2) {
          paramProtoReader.readUnknownField(i);
        } else {
          localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        }
      }
      else {
        localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull Size paramSize)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramSize, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramSize.width);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, paramSize.height);
    paramProtoWriter.writeBytes(paramSize.unknownFields());
  }
  
  @NotNull
  public Size b(@NotNull Size paramSize)
  {
    Intrinsics.checkParameterIsNotNull(paramSize, "value");
    return Size.copy$default(paramSize, null, null, ByteString.EMPTY, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.Size.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */