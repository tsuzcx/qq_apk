package com.tencent.tavcut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/model/TextPlaceInfo$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/model/TextPlaceInfo;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class TextPlaceInfo$Companion$ADAPTER$1
  extends ProtoAdapter<TextPlaceInfo>
{
  TextPlaceInfo$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public TextPlaceInfo decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    String str1 = (String)null;
    Integer localInteger3 = (Integer)null;
    Float localFloat1 = (Float)null;
    long l = paramProtoReader.beginMessage();
    String str2 = str1;
    Integer localInteger1 = localInteger3;
    Integer localInteger2 = localInteger1;
    Float localFloat2 = localFloat1;
    Integer localInteger4 = localInteger2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l);
        if (localInteger3 != null)
        {
          i = localInteger3.intValue();
          if (localInteger4 != null)
          {
            int j = localInteger4.intValue();
            if (localFloat2 != null)
            {
              float f1 = localFloat2.floatValue();
              if (localFloat1 != null)
              {
                float f2 = localFloat1.floatValue();
                if (localInteger1 != null)
                {
                  int k = localInteger1.intValue();
                  if (localInteger2 != null) {
                    return new TextPlaceInfo(str1, str2, i, j, f1, f2, k, localInteger2.intValue(), paramProtoReader);
                  }
                  throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger2, "entityId" }));
                }
                throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger1, "replaceIndex" }));
              }
              throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat1, "layerHeight" }));
            }
            throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat2, "layerWidth" }));
          }
          throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger4, "maxLength" }));
        }
        throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger3, "fillColor" }));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 8: 
        localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 7: 
        localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 6: 
        localFloat1 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 5: 
        localFloat2 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 4: 
        localInteger4 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 3: 
        localInteger3 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 2: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 1: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull TextPlaceInfo paramTextPlaceInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramTextPlaceInfo, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramTextPlaceInfo.key);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramTextPlaceInfo.text);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 3, Integer.valueOf(paramTextPlaceInfo.fillColor));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 4, Integer.valueOf(paramTextPlaceInfo.maxLength));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 5, Float.valueOf(paramTextPlaceInfo.layerWidth));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 6, Float.valueOf(paramTextPlaceInfo.layerHeight));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 7, Integer.valueOf(paramTextPlaceInfo.replaceIndex));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 8, Integer.valueOf(paramTextPlaceInfo.entityId));
    paramProtoWriter.writeBytes(paramTextPlaceInfo.unknownFields());
  }
  
  public int encodedSize(@NotNull TextPlaceInfo paramTextPlaceInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTextPlaceInfo, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramTextPlaceInfo.key) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramTextPlaceInfo.text) + ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(paramTextPlaceInfo.fillColor)) + ProtoAdapter.INT32.encodedSizeWithTag(4, Integer.valueOf(paramTextPlaceInfo.maxLength)) + ProtoAdapter.FLOAT.encodedSizeWithTag(5, Float.valueOf(paramTextPlaceInfo.layerWidth)) + ProtoAdapter.FLOAT.encodedSizeWithTag(6, Float.valueOf(paramTextPlaceInfo.layerHeight)) + ProtoAdapter.INT32.encodedSizeWithTag(7, Integer.valueOf(paramTextPlaceInfo.replaceIndex)) + ProtoAdapter.INT32.encodedSizeWithTag(8, Integer.valueOf(paramTextPlaceInfo.entityId)) + paramTextPlaceInfo.unknownFields().size();
  }
  
  @NotNull
  public TextPlaceInfo redact(@NotNull TextPlaceInfo paramTextPlaceInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTextPlaceInfo, "value");
    return TextPlaceInfo.copy$default(paramTextPlaceInfo, null, null, 0, 0, 0.0F, 0.0F, 0, 0, ByteString.EMPTY, 255, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.TextPlaceInfo.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */