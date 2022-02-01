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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/ExportSettingModel$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/ExportSettingModel;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ExportSettingModel$Companion$ADAPTER$1
  extends ProtoAdapter<ExportSettingModel>
{
  ExportSettingModel$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull ExportSettingModel paramExportSettingModel)
  {
    Intrinsics.checkParameterIsNotNull(paramExportSettingModel, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramExportSettingModel.resolutionLevel) + ProtoAdapter.INT32.encodedSizeWithTag(2, paramExportSettingModel.fpsValue) + paramExportSettingModel.unknownFields().size();
  }
  
  @NotNull
  public ExportSettingModel a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger2 = (Integer)null;
    long l = paramProtoReader.beginMessage();
    Integer localInteger1 = localInteger2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new ExportSettingModel(localInteger2, localInteger1, paramProtoReader.endMessageAndGetUnknownFields(l));
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
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull ExportSettingModel paramExportSettingModel)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramExportSettingModel, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramExportSettingModel.resolutionLevel);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, paramExportSettingModel.fpsValue);
    paramProtoWriter.writeBytes(paramExportSettingModel.unknownFields());
  }
  
  @NotNull
  public ExportSettingModel b(@NotNull ExportSettingModel paramExportSettingModel)
  {
    Intrinsics.checkParameterIsNotNull(paramExportSettingModel, "value");
    return ExportSettingModel.copy$default(paramExportSettingModel, null, null, ByteString.EMPTY, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.ExportSettingModel.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */