package com.tencent.tavcut.composition.model.component;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/PAGAsset$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/PAGAsset;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class PAGAsset$Companion$ADAPTER$1
  extends ProtoAdapter<PAGAsset>
{
  PAGAsset$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public PAGAsset decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger1 = (Integer)null;
    Boolean localBoolean = (Boolean)null;
    String str1 = (String)null;
    List localList = (List)new ArrayList();
    long l = paramProtoReader.beginMessage();
    String str2 = str1;
    String str3 = str2;
    Integer localInteger2 = localInteger1;
    Integer localInteger3 = localInteger2;
    Integer localInteger4 = localInteger3;
    Integer localInteger5 = localInteger4;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new PAGAsset(localInteger1, localInteger2, localBoolean, str1, str2, str3, localInteger3, localInteger4, localList, localInteger5, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 10: 
        localInteger5 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 9: 
        localList.add(PAGAsset.Replacement.ADAPTER.decode(paramProtoReader));
        break;
      case 8: 
        localInteger4 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 7: 
        localInteger3 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 6: 
        str3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 5: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 4: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 3: 
        localBoolean = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 2: 
        localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 1: 
        localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull PAGAsset paramPAGAsset)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramPAGAsset, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramPAGAsset.entityId);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, paramPAGAsset.componentID);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 3, paramPAGAsset.enabled);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramPAGAsset.type);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 5, paramPAGAsset.musicID);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 6, paramPAGAsset.src);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 7, paramPAGAsset.usage);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 8, paramPAGAsset.version);
    PAGAsset.Replacement.ADAPTER.asRepeated().encodeWithTag(paramProtoWriter, 9, paramPAGAsset.replacement);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 10, paramPAGAsset.scaleMode);
    paramProtoWriter.writeBytes(paramPAGAsset.unknownFields());
  }
  
  public int encodedSize(@NotNull PAGAsset paramPAGAsset)
  {
    Intrinsics.checkParameterIsNotNull(paramPAGAsset, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramPAGAsset.entityId) + ProtoAdapter.INT32.encodedSizeWithTag(2, paramPAGAsset.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, paramPAGAsset.enabled) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramPAGAsset.type) + ProtoAdapter.STRING.encodedSizeWithTag(5, paramPAGAsset.musicID) + ProtoAdapter.STRING.encodedSizeWithTag(6, paramPAGAsset.src) + ProtoAdapter.INT32.encodedSizeWithTag(7, paramPAGAsset.usage) + ProtoAdapter.INT32.encodedSizeWithTag(8, paramPAGAsset.version) + PAGAsset.Replacement.ADAPTER.asRepeated().encodedSizeWithTag(9, paramPAGAsset.replacement) + ProtoAdapter.INT32.encodedSizeWithTag(10, paramPAGAsset.scaleMode) + paramPAGAsset.unknownFields().size();
  }
  
  @NotNull
  public PAGAsset redact(@NotNull PAGAsset paramPAGAsset)
  {
    Intrinsics.checkParameterIsNotNull(paramPAGAsset, "value");
    return PAGAsset.copy$default(paramPAGAsset, null, null, null, null, null, null, null, null, Internal.-redactElements(paramPAGAsset.replacement, PAGAsset.Replacement.ADAPTER), null, ByteString.EMPTY, 767, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.PAGAsset.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */