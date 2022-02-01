package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/TextReplaceItem$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/TextReplaceItem;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class TextReplaceItem$Companion$ADAPTER$1
  extends ProtoAdapter<TextReplaceItem>
{
  TextReplaceItem$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public TextReplaceItem decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Boolean localBoolean1 = (Boolean)null;
    String str1 = (String)null;
    Float localFloat1 = (Float)null;
    Integer localInteger = (Integer)null;
    long l = paramProtoReader.beginMessage();
    Boolean localBoolean2 = localBoolean1;
    Boolean localBoolean3 = localBoolean2;
    String str2 = str1;
    String str3 = str2;
    String str4 = str3;
    String str5 = str4;
    Float localFloat2 = localFloat1;
    Float localFloat3 = localFloat2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new TextReplaceItem(localBoolean1, localBoolean2, str1, str2, localBoolean3, str3, localFloat1, localFloat2, localFloat3, str4, localInteger, str5, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 17: 
        str5 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 16: 
        localInteger = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 15: 
        str4 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 14: 
        localFloat3 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 13: 
        localFloat2 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 12: 
        localFloat1 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 11: 
        str3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 10: 
        localBoolean3 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 9: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 8: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 7: 
        localBoolean2 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 6: 
        localBoolean1 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull TextReplaceItem paramTextReplaceItem)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramTextReplaceItem, "value");
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 6, paramTextReplaceItem.fauxBold);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 7, paramTextReplaceItem.fauxItalic);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 8, paramTextReplaceItem.fontFamily);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 9, paramTextReplaceItem.fontPath);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 10, paramTextReplaceItem.applyStroke);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 11, paramTextReplaceItem.strokeColor);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 12, paramTextReplaceItem.strokeWidth);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 13, paramTextReplaceItem.leading);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 14, paramTextReplaceItem.tracking);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 15, paramTextReplaceItem.backgroundColor);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 16, paramTextReplaceItem.backgroundAlpha);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 17, paramTextReplaceItem.textColor);
    paramProtoWriter.writeBytes(paramTextReplaceItem.unknownFields());
  }
  
  public int encodedSize(@NotNull TextReplaceItem paramTextReplaceItem)
  {
    Intrinsics.checkParameterIsNotNull(paramTextReplaceItem, "value");
    return ProtoAdapter.BOOL.encodedSizeWithTag(6, paramTextReplaceItem.fauxBold) + ProtoAdapter.BOOL.encodedSizeWithTag(7, paramTextReplaceItem.fauxItalic) + ProtoAdapter.STRING.encodedSizeWithTag(8, paramTextReplaceItem.fontFamily) + ProtoAdapter.STRING.encodedSizeWithTag(9, paramTextReplaceItem.fontPath) + ProtoAdapter.BOOL.encodedSizeWithTag(10, paramTextReplaceItem.applyStroke) + ProtoAdapter.STRING.encodedSizeWithTag(11, paramTextReplaceItem.strokeColor) + ProtoAdapter.FLOAT.encodedSizeWithTag(12, paramTextReplaceItem.strokeWidth) + ProtoAdapter.FLOAT.encodedSizeWithTag(13, paramTextReplaceItem.leading) + ProtoAdapter.FLOAT.encodedSizeWithTag(14, paramTextReplaceItem.tracking) + ProtoAdapter.STRING.encodedSizeWithTag(15, paramTextReplaceItem.backgroundColor) + ProtoAdapter.INT32.encodedSizeWithTag(16, paramTextReplaceItem.backgroundAlpha) + ProtoAdapter.STRING.encodedSizeWithTag(17, paramTextReplaceItem.textColor) + paramTextReplaceItem.unknownFields().size();
  }
  
  @NotNull
  public TextReplaceItem redact(@NotNull TextReplaceItem paramTextReplaceItem)
  {
    Intrinsics.checkParameterIsNotNull(paramTextReplaceItem, "value");
    return TextReplaceItem.copy$default(paramTextReplaceItem, null, null, null, null, null, null, null, null, null, null, null, null, ByteString.EMPTY, 4095, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.TextReplaceItem.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */