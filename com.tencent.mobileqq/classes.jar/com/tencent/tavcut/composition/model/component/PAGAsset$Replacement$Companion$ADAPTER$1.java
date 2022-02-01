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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/PAGAsset$Replacement$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class PAGAsset$Replacement$Companion$ADAPTER$1
  extends ProtoAdapter<PAGAsset.Replacement>
{
  PAGAsset$Replacement$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public PAGAsset.Replacement decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger1 = (Integer)null;
    String str = (String)null;
    Boolean localBoolean = (Boolean)null;
    TextReplaceItem localTextReplaceItem = (TextReplaceItem)null;
    long l = paramProtoReader.beginMessage();
    Integer localInteger2 = localInteger1;
    Integer localInteger3 = localInteger2;
    Integer localInteger4 = localInteger3;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new PAGAsset.Replacement(localInteger1, str, localInteger2, localInteger3, localInteger4, localBoolean, localTextReplaceItem, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 7: 
        localTextReplaceItem = (TextReplaceItem)TextReplaceItem.ADAPTER.decode(paramProtoReader);
        break;
      case 6: 
        localBoolean = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 5: 
        localInteger4 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 4: 
        localInteger3 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 3: 
        localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 2: 
        str = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 1: 
        localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull PAGAsset.Replacement paramReplacement)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramReplacement, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramReplacement.index);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramReplacement.src);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 3, paramReplacement.replaceType);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 4, paramReplacement.sourceIndex);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 5, paramReplacement.scaleMode);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 6, paramReplacement.interactive);
    TextReplaceItem.ADAPTER.encodeWithTag(paramProtoWriter, 7, paramReplacement.textReplaceItem);
    paramProtoWriter.writeBytes(paramReplacement.unknownFields());
  }
  
  public int encodedSize(@NotNull PAGAsset.Replacement paramReplacement)
  {
    Intrinsics.checkParameterIsNotNull(paramReplacement, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramReplacement.index) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramReplacement.src) + ProtoAdapter.INT32.encodedSizeWithTag(3, paramReplacement.replaceType) + ProtoAdapter.INT32.encodedSizeWithTag(4, paramReplacement.sourceIndex) + ProtoAdapter.INT32.encodedSizeWithTag(5, paramReplacement.scaleMode) + ProtoAdapter.BOOL.encodedSizeWithTag(6, paramReplacement.interactive) + TextReplaceItem.ADAPTER.encodedSizeWithTag(7, paramReplacement.textReplaceItem) + paramReplacement.unknownFields().size();
  }
  
  @NotNull
  public PAGAsset.Replacement redact(@NotNull PAGAsset.Replacement paramReplacement)
  {
    Intrinsics.checkParameterIsNotNull(paramReplacement, "value");
    TextReplaceItem localTextReplaceItem = paramReplacement.textReplaceItem;
    if (localTextReplaceItem != null) {
      localTextReplaceItem = (TextReplaceItem)TextReplaceItem.ADAPTER.redact(localTextReplaceItem);
    } else {
      localTextReplaceItem = null;
    }
    return PAGAsset.Replacement.copy$default(paramReplacement, null, null, null, null, null, null, localTextReplaceItem, ByteString.EMPTY, 63, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.PAGAsset.Replacement.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */