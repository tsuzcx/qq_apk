package com.tencent.tavcut.model;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/model/PagEffectData$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/model/PagEffectData;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class PagEffectData$Companion$ADAPTER$1
  extends ProtoAdapter<PagEffectData>
{
  PagEffectData$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public PagEffectData decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    String str = (String)null;
    Integer localInteger2 = (Integer)null;
    Long localLong = (Long)null;
    List localList1 = (List)new ArrayList();
    List localList2 = (List)new ArrayList();
    long l = paramProtoReader.beginMessage();
    Integer localInteger1 = localInteger2;
    Integer localInteger3 = localInteger1;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l);
        if (localInteger2 != null)
        {
          i = localInteger2.intValue();
          if (localInteger3 != null)
          {
            int j = localInteger3.intValue();
            if (localLong != null)
            {
              l = localLong.longValue();
              if (localInteger1 != null) {
                return new PagEffectData(str, i, j, l, localList1, localList2, localInteger1.intValue(), paramProtoReader);
              }
              throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger1, "timeStretchMode" }));
            }
            throw ((Throwable)Internal.missingRequiredFields(new Object[] { localLong, "durationUs" }));
          }
          throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger3, "height" }));
        }
        throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger2, "width" }));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 7: 
        localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 6: 
        localList2.add(ImageLayerData.ADAPTER.decode(paramProtoReader));
        break;
      case 5: 
        localList1.add(TextLayerData.ADAPTER.decode(paramProtoReader));
        break;
      case 4: 
        localLong = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
        break;
      case 3: 
        localInteger3 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 2: 
        localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 1: 
        str = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull PagEffectData paramPagEffectData)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramPagEffectData, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramPagEffectData.filePath);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, Integer.valueOf(paramPagEffectData.width));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 3, Integer.valueOf(paramPagEffectData.height));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 4, Long.valueOf(paramPagEffectData.durationUs));
    TextLayerData.ADAPTER.asRepeated().encodeWithTag(paramProtoWriter, 5, paramPagEffectData.textLayerList);
    ImageLayerData.ADAPTER.asRepeated().encodeWithTag(paramProtoWriter, 6, paramPagEffectData.imageLayerList);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 7, Integer.valueOf(paramPagEffectData.timeStretchMode));
    paramProtoWriter.writeBytes(paramPagEffectData.unknownFields());
  }
  
  public int encodedSize(@NotNull PagEffectData paramPagEffectData)
  {
    Intrinsics.checkParameterIsNotNull(paramPagEffectData, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramPagEffectData.filePath) + ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(paramPagEffectData.width)) + ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(paramPagEffectData.height)) + ProtoAdapter.INT64.encodedSizeWithTag(4, Long.valueOf(paramPagEffectData.durationUs)) + TextLayerData.ADAPTER.asRepeated().encodedSizeWithTag(5, paramPagEffectData.textLayerList) + ImageLayerData.ADAPTER.asRepeated().encodedSizeWithTag(6, paramPagEffectData.imageLayerList) + ProtoAdapter.INT32.encodedSizeWithTag(7, Integer.valueOf(paramPagEffectData.timeStretchMode)) + paramPagEffectData.unknownFields().size();
  }
  
  @NotNull
  public PagEffectData redact(@NotNull PagEffectData paramPagEffectData)
  {
    Intrinsics.checkParameterIsNotNull(paramPagEffectData, "value");
    return PagEffectData.copy$default(paramPagEffectData, null, 0, 0, 0L, Internal.-redactElements(paramPagEffectData.textLayerList, TextLayerData.ADAPTER), Internal.-redactElements(paramPagEffectData.imageLayerList, ImageLayerData.ADAPTER), 0, ByteString.EMPTY, 79, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.PagEffectData.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */