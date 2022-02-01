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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/model/ImageLayerData$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/model/ImageLayerData;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class ImageLayerData$Companion$ADAPTER$1
  extends ProtoAdapter<ImageLayerData>
{
  ImageLayerData$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public ImageLayerData decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger1 = (Integer)null;
    String str = (String)null;
    List localList = (List)new ArrayList();
    long l = paramProtoReader.beginMessage();
    Integer localInteger2 = localInteger1;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l);
        if (localInteger1 != null)
        {
          i = localInteger1.intValue();
          if (localInteger2 != null) {
            return new ImageLayerData(i, str, localInteger2.intValue(), localList, paramProtoReader);
          }
          throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger2, "layerType" }));
        }
        throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger1, "layerIndex" }));
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              paramProtoReader.readUnknownField(i);
            } else {
              localList.add(LayerMarkData.ADAPTER.decode(paramProtoReader));
            }
          }
          else {
            localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
          }
        }
        else {
          str = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        }
      }
      else {
        localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull ImageLayerData paramImageLayerData)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramImageLayerData, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, Integer.valueOf(paramImageLayerData.layerIndex));
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramImageLayerData.layerName);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 3, Integer.valueOf(paramImageLayerData.layerType));
    LayerMarkData.ADAPTER.asRepeated().encodeWithTag(paramProtoWriter, 4, paramImageLayerData.layerMarkList);
    paramProtoWriter.writeBytes(paramImageLayerData.unknownFields());
  }
  
  public int encodedSize(@NotNull ImageLayerData paramImageLayerData)
  {
    Intrinsics.checkParameterIsNotNull(paramImageLayerData, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(paramImageLayerData.layerIndex)) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramImageLayerData.layerName) + ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(paramImageLayerData.layerType)) + LayerMarkData.ADAPTER.asRepeated().encodedSizeWithTag(4, paramImageLayerData.layerMarkList) + paramImageLayerData.unknownFields().size();
  }
  
  @NotNull
  public ImageLayerData redact(@NotNull ImageLayerData paramImageLayerData)
  {
    Intrinsics.checkParameterIsNotNull(paramImageLayerData, "value");
    return ImageLayerData.copy$default(paramImageLayerData, 0, null, 0, Internal.-redactElements(paramImageLayerData.layerMarkList, LayerMarkData.ADAPTER), ByteString.EMPTY, 7, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.ImageLayerData.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */