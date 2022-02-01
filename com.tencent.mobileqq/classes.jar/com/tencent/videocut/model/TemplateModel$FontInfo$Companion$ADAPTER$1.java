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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/TemplateModel$FontInfo$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/TemplateModel$FontInfo;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TemplateModel$FontInfo$Companion$ADAPTER$1
  extends ProtoAdapter<TemplateModel.FontInfo>
{
  TemplateModel$FontInfo$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull TemplateModel.FontInfo paramFontInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramFontInfo, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramFontInfo.name) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramFontInfo.style) + ProtoAdapter.STRING.encodedSizeWithTag(3, paramFontInfo.path) + paramFontInfo.unknownFields().size();
  }
  
  @NotNull
  public TemplateModel.FontInfo a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    String str3 = (String)null;
    long l = paramProtoReader.beginMessage();
    String str1 = str3;
    String str2 = str1;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new TemplateModel.FontInfo(str3, str1, str2, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            paramProtoReader.readUnknownField(i);
          } else {
            str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
          }
        }
        else {
          str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        }
      }
      else {
        str3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull TemplateModel.FontInfo paramFontInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramFontInfo, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramFontInfo.name);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramFontInfo.style);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 3, paramFontInfo.path);
    paramProtoWriter.writeBytes(paramFontInfo.unknownFields());
  }
  
  @NotNull
  public TemplateModel.FontInfo b(@NotNull TemplateModel.FontInfo paramFontInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramFontInfo, "value");
    return TemplateModel.FontInfo.copy$default(paramFontInfo, null, null, null, ByteString.EMPTY, 7, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.TemplateModel.FontInfo.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */