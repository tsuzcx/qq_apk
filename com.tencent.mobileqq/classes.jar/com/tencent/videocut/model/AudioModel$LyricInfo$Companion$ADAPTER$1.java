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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/AudioModel$LyricInfo$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/AudioModel$LyricInfo;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class AudioModel$LyricInfo$Companion$ADAPTER$1
  extends ProtoAdapter<AudioModel.LyricInfo>
{
  AudioModel$LyricInfo$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull AudioModel.LyricInfo paramLyricInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramLyricInfo, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramLyricInfo.strFormat) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramLyricInfo.strLyric) + ProtoAdapter.STRING.encodedSizeWithTag(3, paramLyricInfo.strMatchLyric) + paramLyricInfo.unknownFields().size();
  }
  
  @NotNull
  public AudioModel.LyricInfo a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    long l = paramProtoReader.beginMessage();
    String str3 = "";
    String str2 = "";
    String str1 = str2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new AudioModel.LyricInfo(str3, str2, str1, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            paramProtoReader.readUnknownField(i);
          } else {
            str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
          }
        }
        else {
          str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        }
      }
      else {
        str3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull AudioModel.LyricInfo paramLyricInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramLyricInfo, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramLyricInfo.strFormat);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramLyricInfo.strLyric);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 3, paramLyricInfo.strMatchLyric);
    paramProtoWriter.writeBytes(paramLyricInfo.unknownFields());
  }
  
  @NotNull
  public AudioModel.LyricInfo b(@NotNull AudioModel.LyricInfo paramLyricInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramLyricInfo, "value");
    return AudioModel.LyricInfo.copy$default(paramLyricInfo, null, null, null, ByteString.EMPTY, 7, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.AudioModel.LyricInfo.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */