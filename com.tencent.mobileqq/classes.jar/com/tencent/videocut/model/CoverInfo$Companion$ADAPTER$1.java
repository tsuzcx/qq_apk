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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/CoverInfo$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/CoverInfo;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class CoverInfo$Companion$ADAPTER$1
  extends ProtoAdapter<CoverInfo>
{
  CoverInfo$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull CoverInfo paramCoverInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramCoverInfo, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramCoverInfo.path) + ProtoAdapter.INT64.encodedSizeWithTag(2, paramCoverInfo.timeAt) + paramCoverInfo.unknownFields().size();
  }
  
  @NotNull
  public CoverInfo a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    String str = (String)null;
    Long localLong = (Long)null;
    long l = paramProtoReader.beginMessage();
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new CoverInfo(str, localLong, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      if (i != 1)
      {
        if (i != 2) {
          paramProtoReader.readUnknownField(i);
        } else {
          localLong = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
        }
      }
      else {
        str = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull CoverInfo paramCoverInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramCoverInfo, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramCoverInfo.path);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 2, paramCoverInfo.timeAt);
    paramProtoWriter.writeBytes(paramCoverInfo.unknownFields());
  }
  
  @NotNull
  public CoverInfo b(@NotNull CoverInfo paramCoverInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramCoverInfo, "value");
    return CoverInfo.copy$default(paramCoverInfo, null, null, ByteString.EMPTY, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.CoverInfo.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */