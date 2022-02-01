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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/PipModel$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/PipModel;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class PipModel$Companion$ADAPTER$1
  extends ProtoAdapter<PipModel>
{
  PipModel$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull PipModel paramPipModel)
  {
    Intrinsics.checkParameterIsNotNull(paramPipModel, "value");
    return MediaClip.ADAPTER.encodedSizeWithTag(1, paramPipModel.mediaClip) + ProtoAdapter.INT64.encodedSizeWithTag(2, Long.valueOf(paramPipModel.startOffset)) + ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(paramPipModel.timelineIndex)) + paramPipModel.unknownFields().size();
  }
  
  @NotNull
  public PipModel a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    MediaClip localMediaClip = (MediaClip)null;
    Integer localInteger = (Integer)null;
    long l2 = paramProtoReader.beginMessage();
    long l1 = 0L;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l2);
        if (localInteger != null) {
          i = localInteger.intValue();
        } else {
          i = 0;
        }
        return new PipModel(localMediaClip, l1, i, paramProtoReader);
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            paramProtoReader.readUnknownField(i);
          } else {
            localInteger = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
          }
        }
        else {
          l1 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        }
      }
      else {
        localMediaClip = (MediaClip)MediaClip.ADAPTER.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull PipModel paramPipModel)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramPipModel, "value");
    MediaClip.ADAPTER.encodeWithTag(paramProtoWriter, 1, paramPipModel.mediaClip);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 2, Long.valueOf(paramPipModel.startOffset));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 3, Integer.valueOf(paramPipModel.timelineIndex));
    paramProtoWriter.writeBytes(paramPipModel.unknownFields());
  }
  
  @NotNull
  public PipModel b(@NotNull PipModel paramPipModel)
  {
    Intrinsics.checkParameterIsNotNull(paramPipModel, "value");
    MediaClip localMediaClip = paramPipModel.mediaClip;
    if (localMediaClip != null) {
      localMediaClip = (MediaClip)MediaClip.ADAPTER.redact(localMediaClip);
    } else {
      localMediaClip = null;
    }
    return PipModel.copy$default(paramPipModel, localMediaClip, null, null, ByteString.EMPTY, 6, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.PipModel.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */