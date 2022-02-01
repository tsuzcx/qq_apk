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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/TemplateModel$AiInfo$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/TemplateModel$AiInfo;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TemplateModel$AiInfo$Companion$ADAPTER$1
  extends ProtoAdapter<TemplateModel.AiInfo>
{
  TemplateModel$AiInfo$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull TemplateModel.AiInfo paramAiInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAiInfo, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramAiInfo.path) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramAiInfo.agent) + paramAiInfo.unknownFields().size();
  }
  
  @NotNull
  public TemplateModel.AiInfo a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    long l = paramProtoReader.beginMessage();
    String str2 = "";
    String str1 = "";
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new TemplateModel.AiInfo(str2, str1, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      if (i != 1)
      {
        if (i != 2) {
          paramProtoReader.readUnknownField(i);
        } else {
          str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        }
      }
      else {
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull TemplateModel.AiInfo paramAiInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramAiInfo, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramAiInfo.path);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramAiInfo.agent);
    paramProtoWriter.writeBytes(paramAiInfo.unknownFields());
  }
  
  @NotNull
  public TemplateModel.AiInfo b(@NotNull TemplateModel.AiInfo paramAiInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAiInfo, "value");
    return TemplateModel.AiInfo.copy$default(paramAiInfo, null, null, ByteString.EMPTY, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.TemplateModel.AiInfo.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */