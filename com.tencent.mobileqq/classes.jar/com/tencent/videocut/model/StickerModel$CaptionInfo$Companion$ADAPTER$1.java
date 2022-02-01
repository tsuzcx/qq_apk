package com.tencent.videocut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoAdapter.EnumConstantNotFoundException;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/StickerModel$CaptionInfo$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/StickerModel$CaptionInfo;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class StickerModel$CaptionInfo$Companion$ADAPTER$1
  extends ProtoAdapter<StickerModel.CaptionInfo>
{
  StickerModel$CaptionInfo$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull StickerModel.CaptionInfo paramCaptionInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptionInfo, "value");
    return StickerModel.CaptionSource.ADAPTER.encodedSizeWithTag(1, paramCaptionInfo.source) + paramCaptionInfo.unknownFields().size();
  }
  
  @NotNull
  public StickerModel.CaptionInfo a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Object localObject = (StickerModel.CaptionSource)null;
    long l = paramProtoReader.beginMessage();
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new StickerModel.CaptionInfo((StickerModel.CaptionSource)localObject, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      if (i != 1) {
        paramProtoReader.readUnknownField(i);
      } else {
        try
        {
          StickerModel.CaptionSource localCaptionSource = (StickerModel.CaptionSource)StickerModel.CaptionSource.ADAPTER.decode(paramProtoReader);
          localObject = localCaptionSource;
        }
        catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException)
        {
          paramProtoReader.addUnknownField(i, FieldEncoding.VARINT, Long.valueOf(localEnumConstantNotFoundException.value));
        }
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull StickerModel.CaptionInfo paramCaptionInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramCaptionInfo, "value");
    StickerModel.CaptionSource.ADAPTER.encodeWithTag(paramProtoWriter, 1, paramCaptionInfo.source);
    paramProtoWriter.writeBytes(paramCaptionInfo.unknownFields());
  }
  
  @NotNull
  public StickerModel.CaptionInfo b(@NotNull StickerModel.CaptionInfo paramCaptionInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptionInfo, "value");
    return StickerModel.CaptionInfo.copy$default(paramCaptionInfo, null, ByteString.EMPTY, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.StickerModel.CaptionInfo.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */