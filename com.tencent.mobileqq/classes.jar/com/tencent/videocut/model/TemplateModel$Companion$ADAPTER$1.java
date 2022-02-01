package com.tencent.videocut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/TemplateModel$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/TemplateModel;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TemplateModel$Companion$ADAPTER$1
  extends ProtoAdapter<TemplateModel>
{
  TemplateModel$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull TemplateModel paramTemplateModel)
  {
    Intrinsics.checkParameterIsNotNull(paramTemplateModel, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramTemplateModel.id) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramTemplateModel.path) + ProtoAdapter.STRING.encodedSizeWithTag(3, paramTemplateModel.name) + AudioModel.ADAPTER.asRepeated().encodedSizeWithTag(4, paramTemplateModel.audioModel) + TemplateModel.FontInfo.ADAPTER.asRepeated().encodedSizeWithTag(5, paramTemplateModel.fontInfo) + TemplateModel.AiInfo.ADAPTER.asRepeated().encodedSizeWithTag(6, paramTemplateModel.aiInfo) + paramTemplateModel.unknownFields().size();
  }
  
  @NotNull
  public TemplateModel a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    String str1 = (String)null;
    List localList1 = (List)new ArrayList();
    List localList2 = (List)new ArrayList();
    List localList3 = (List)new ArrayList();
    long l = paramProtoReader.beginMessage();
    String str2 = str1;
    String str3 = str2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new TemplateModel(str1, str2, str3, localList1, localList2, localList3, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 6: 
        localList3.add(TemplateModel.AiInfo.ADAPTER.decode(paramProtoReader));
        break;
      case 5: 
        localList2.add(TemplateModel.FontInfo.ADAPTER.decode(paramProtoReader));
        break;
      case 4: 
        localList1.add(AudioModel.ADAPTER.decode(paramProtoReader));
        break;
      case 3: 
        str3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 2: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 1: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull TemplateModel paramTemplateModel)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramTemplateModel, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramTemplateModel.id);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramTemplateModel.path);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 3, paramTemplateModel.name);
    AudioModel.ADAPTER.asRepeated().encodeWithTag(paramProtoWriter, 4, paramTemplateModel.audioModel);
    TemplateModel.FontInfo.ADAPTER.asRepeated().encodeWithTag(paramProtoWriter, 5, paramTemplateModel.fontInfo);
    TemplateModel.AiInfo.ADAPTER.asRepeated().encodeWithTag(paramProtoWriter, 6, paramTemplateModel.aiInfo);
    paramProtoWriter.writeBytes(paramTemplateModel.unknownFields());
  }
  
  @NotNull
  public TemplateModel b(@NotNull TemplateModel paramTemplateModel)
  {
    Intrinsics.checkParameterIsNotNull(paramTemplateModel, "value");
    return TemplateModel.copy$default(paramTemplateModel, null, null, null, Internal.-redactElements(paramTemplateModel.audioModel, AudioModel.ADAPTER), Internal.-redactElements(paramTemplateModel.fontInfo, TemplateModel.FontInfo.ADAPTER), Internal.-redactElements(paramTemplateModel.aiInfo, TemplateModel.AiInfo.ADAPTER), ByteString.EMPTY, 7, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.TemplateModel.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */