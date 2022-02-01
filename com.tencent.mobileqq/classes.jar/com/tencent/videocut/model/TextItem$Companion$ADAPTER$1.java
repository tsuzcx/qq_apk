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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/TextItem$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/TextItem;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TextItem$Companion$ADAPTER$1
  extends ProtoAdapter<TextItem>
{
  TextItem$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull TextItem paramTextItem)
  {
    Intrinsics.checkParameterIsNotNull(paramTextItem, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramTextItem.text) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramTextItem.textColor) + ProtoAdapter.STRING.encodedSizeWithTag(3, paramTextItem.fontPath) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramTextItem.strokeColor) + ProtoAdapter.FLOAT.encodedSizeWithTag(5, Float.valueOf(paramTextItem.strokeWidth)) + ProtoAdapter.STRING.encodedSizeWithTag(6, paramTextItem.shadowColor) + ProtoAdapter.FLOAT.encodedSizeWithTag(7, paramTextItem.shadowOpacity) + ProtoAdapter.FLOAT.encodedSizeWithTag(8, paramTextItem.opacity) + ProtoAdapter.INT32.encodedSizeWithTag(9, Integer.valueOf(paramTextItem.index)) + ProtoAdapter.BOOL.encodedSizeWithTag(10, paramTextItem.fauxBold) + ProtoAdapter.BOOL.encodedSizeWithTag(11, paramTextItem.fauxItalic) + ProtoAdapter.STRING.encodedSizeWithTag(12, paramTextItem.fontFamily) + ProtoAdapter.BOOL.encodedSizeWithTag(13, paramTextItem.applyStroke) + ProtoAdapter.FLOAT.encodedSizeWithTag(14, paramTextItem.leading) + ProtoAdapter.FLOAT.encodedSizeWithTag(15, paramTextItem.tracking) + ProtoAdapter.STRING.encodedSizeWithTag(16, paramTextItem.backgroundColor) + ProtoAdapter.INT32.encodedSizeWithTag(17, Integer.valueOf(paramTextItem.backgroundAlpha)) + Size.ADAPTER.encodedSizeWithTag(18, paramTextItem.layerSize) + ProtoAdapter.STRING.encodedSizeWithTag(19, paramTextItem.fontStyle) + paramTextItem.unknownFields().size();
  }
  
  @NotNull
  public TextItem a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Float localFloat1 = (Float)null;
    Boolean localBoolean1 = (Boolean)null;
    Size localSize = (Size)null;
    long l = paramProtoReader.beginMessage();
    Float localFloat2 = localFloat1;
    Float localFloat3 = localFloat2;
    Float localFloat4 = localFloat3;
    Boolean localBoolean2 = localBoolean1;
    Boolean localBoolean3 = localBoolean2;
    String str8 = "";
    String str1 = str8;
    String str2 = str1;
    String str3 = str2;
    String str4 = str3;
    String str5 = str4;
    String str6 = str5;
    String str7 = str6;
    float f = 0.0F;
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k = paramProtoReader.nextTag();
      if (k == -1) {
        return new TextItem(str8, str1, str2, str3, f, str4, localFloat1, localFloat2, j, localBoolean1, localBoolean2, str5, localBoolean3, localFloat3, localFloat4, str6, i, localSize, str7, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (k)
      {
      default: 
        paramProtoReader.readUnknownField(k);
        break;
      case 19: 
        str7 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 18: 
        localSize = (Size)Size.ADAPTER.decode(paramProtoReader);
        break;
      case 17: 
        i = ((Number)ProtoAdapter.INT32.decode(paramProtoReader)).intValue();
        break;
      case 16: 
        str6 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 15: 
        localFloat4 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 14: 
        localFloat3 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 13: 
        localBoolean3 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 12: 
        str5 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 11: 
        localBoolean2 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 10: 
        localBoolean1 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 9: 
        j = ((Number)ProtoAdapter.INT32.decode(paramProtoReader)).intValue();
        break;
      case 8: 
        localFloat2 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 7: 
        localFloat1 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 6: 
        str4 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 5: 
        f = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
        break;
      case 4: 
        str3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 3: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 2: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 1: 
        str8 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull TextItem paramTextItem)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramTextItem, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramTextItem.text);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramTextItem.textColor);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 3, paramTextItem.fontPath);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramTextItem.strokeColor);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 5, Float.valueOf(paramTextItem.strokeWidth));
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 6, paramTextItem.shadowColor);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 7, paramTextItem.shadowOpacity);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 8, paramTextItem.opacity);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 9, Integer.valueOf(paramTextItem.index));
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 10, paramTextItem.fauxBold);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 11, paramTextItem.fauxItalic);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 12, paramTextItem.fontFamily);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 13, paramTextItem.applyStroke);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 14, paramTextItem.leading);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 15, paramTextItem.tracking);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 16, paramTextItem.backgroundColor);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 17, Integer.valueOf(paramTextItem.backgroundAlpha));
    Size.ADAPTER.encodeWithTag(paramProtoWriter, 18, paramTextItem.layerSize);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 19, paramTextItem.fontStyle);
    paramProtoWriter.writeBytes(paramTextItem.unknownFields());
  }
  
  @NotNull
  public TextItem b(@NotNull TextItem paramTextItem)
  {
    Intrinsics.checkParameterIsNotNull(paramTextItem, "value");
    Size localSize = paramTextItem.layerSize;
    if (localSize != null) {
      localSize = (Size)Size.ADAPTER.redact(localSize);
    } else {
      localSize = null;
    }
    return TextItem.copy$default(paramTextItem, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, localSize, null, ByteString.EMPTY, 393215, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.TextItem.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */