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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/model/TextLayerData$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/model/TextLayerData;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class TextLayerData$Companion$ADAPTER$1
  extends ProtoAdapter<TextLayerData>
{
  TextLayerData$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public TextLayerData decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger7 = (Integer)null;
    String str1 = (String)null;
    List localList = (List)new ArrayList();
    Boolean localBoolean1 = (Boolean)null;
    Float localFloat1 = (Float)null;
    long l = paramProtoReader.beginMessage();
    Float localFloat2 = localFloat1;
    Float localFloat3 = localFloat2;
    Float localFloat4 = localFloat3;
    Float localFloat5 = localFloat4;
    Float localFloat6 = localFloat5;
    Integer localInteger1 = localInteger7;
    Integer localInteger2 = localInteger1;
    Integer localInteger3 = localInteger2;
    Integer localInteger4 = localInteger3;
    Integer localInteger5 = localInteger4;
    Integer localInteger6 = localInteger5;
    String str2 = str1;
    String str3 = str2;
    String str4 = str3;
    Boolean localBoolean2 = localBoolean1;
    Boolean localBoolean3 = localBoolean2;
    Boolean localBoolean4 = localBoolean3;
    Boolean localBoolean5 = localBoolean4;
    Boolean localBoolean6 = localBoolean5;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new TextLayerData(localInteger7, str1, localInteger1, str2, localInteger2, str3, str4, localList, localBoolean1, localBoolean2, localFloat1, localBoolean3, localFloat2, localBoolean4, localBoolean5, localFloat3, localInteger3, localBoolean6, localFloat4, localInteger4, localFloat5, localFloat6, localInteger5, localInteger6, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 24: 
        localInteger6 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 23: 
        localInteger5 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 22: 
        localFloat6 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 21: 
        localFloat5 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 20: 
        localInteger4 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 19: 
        localFloat4 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 18: 
        localBoolean6 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 17: 
        localInteger3 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 16: 
        localFloat3 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 15: 
        localBoolean5 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 14: 
        localBoolean4 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 13: 
        localFloat2 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 12: 
        localBoolean3 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 11: 
        localFloat1 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 10: 
        localBoolean2 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 9: 
        localBoolean1 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 8: 
        localList.add(LayerMarkData.ADAPTER.decode(paramProtoReader));
        break;
      case 7: 
        str4 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 6: 
        str3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 5: 
        localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 4: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 3: 
        localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 2: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 1: 
        localInteger7 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull TextLayerData paramTextLayerData)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramTextLayerData, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramTextLayerData.layerIndex);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramTextLayerData.layerName);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 3, paramTextLayerData.layerType);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramTextLayerData.defaultText);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 5, paramTextLayerData.textColor);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 6, paramTextLayerData.fontFamily);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 7, paramTextLayerData.fontStyle);
    LayerMarkData.ADAPTER.asRepeated().encodeWithTag(paramProtoWriter, 8, paramTextLayerData.layerMarkList);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 9, paramTextLayerData.applyFill);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 10, paramTextLayerData.applyStroke);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 11, paramTextLayerData.baselineShift);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 12, paramTextLayerData.boxText);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 13, paramTextLayerData.firstBaseLine);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 14, paramTextLayerData.fauxBold);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 15, paramTextLayerData.fauxItalic);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 16, paramTextLayerData.fontSize);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 17, paramTextLayerData.strokeColor);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 18, paramTextLayerData.strokeOverFill);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 19, paramTextLayerData.stokeWidth);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 20, paramTextLayerData.justification);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 21, paramTextLayerData.leading);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 22, paramTextLayerData.tracking);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 23, paramTextLayerData.backgroundColor);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 24, paramTextLayerData.backgroundAlpha);
    paramProtoWriter.writeBytes(paramTextLayerData.unknownFields());
  }
  
  public int encodedSize(@NotNull TextLayerData paramTextLayerData)
  {
    Intrinsics.checkParameterIsNotNull(paramTextLayerData, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramTextLayerData.layerIndex) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramTextLayerData.layerName) + ProtoAdapter.INT32.encodedSizeWithTag(3, paramTextLayerData.layerType) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramTextLayerData.defaultText) + ProtoAdapter.INT32.encodedSizeWithTag(5, paramTextLayerData.textColor) + ProtoAdapter.STRING.encodedSizeWithTag(6, paramTextLayerData.fontFamily) + ProtoAdapter.STRING.encodedSizeWithTag(7, paramTextLayerData.fontStyle) + LayerMarkData.ADAPTER.asRepeated().encodedSizeWithTag(8, paramTextLayerData.layerMarkList) + ProtoAdapter.BOOL.encodedSizeWithTag(9, paramTextLayerData.applyFill) + ProtoAdapter.BOOL.encodedSizeWithTag(10, paramTextLayerData.applyStroke) + ProtoAdapter.FLOAT.encodedSizeWithTag(11, paramTextLayerData.baselineShift) + ProtoAdapter.BOOL.encodedSizeWithTag(12, paramTextLayerData.boxText) + ProtoAdapter.FLOAT.encodedSizeWithTag(13, paramTextLayerData.firstBaseLine) + ProtoAdapter.BOOL.encodedSizeWithTag(14, paramTextLayerData.fauxBold) + ProtoAdapter.BOOL.encodedSizeWithTag(15, paramTextLayerData.fauxItalic) + ProtoAdapter.FLOAT.encodedSizeWithTag(16, paramTextLayerData.fontSize) + ProtoAdapter.INT32.encodedSizeWithTag(17, paramTextLayerData.strokeColor) + ProtoAdapter.BOOL.encodedSizeWithTag(18, paramTextLayerData.strokeOverFill) + ProtoAdapter.FLOAT.encodedSizeWithTag(19, paramTextLayerData.stokeWidth) + ProtoAdapter.INT32.encodedSizeWithTag(20, paramTextLayerData.justification) + ProtoAdapter.FLOAT.encodedSizeWithTag(21, paramTextLayerData.leading) + ProtoAdapter.FLOAT.encodedSizeWithTag(22, paramTextLayerData.tracking) + ProtoAdapter.INT32.encodedSizeWithTag(23, paramTextLayerData.backgroundColor) + ProtoAdapter.INT32.encodedSizeWithTag(24, paramTextLayerData.backgroundAlpha) + paramTextLayerData.unknownFields().size();
  }
  
  @NotNull
  public TextLayerData redact(@NotNull TextLayerData paramTextLayerData)
  {
    Intrinsics.checkParameterIsNotNull(paramTextLayerData, "value");
    return TextLayerData.copy$default(paramTextLayerData, null, null, null, null, null, null, null, Internal.-redactElements(paramTextLayerData.layerMarkList, LayerMarkData.ADAPTER), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ByteString.EMPTY, 16777087, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.TextLayerData.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */