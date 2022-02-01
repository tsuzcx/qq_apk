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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/Script$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/Script;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Script$Companion$ADAPTER$1
  extends ProtoAdapter<Script>
{
  Script$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public Script decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger1 = (Integer)null;
    Boolean localBoolean = (Boolean)null;
    String str1 = (String)null;
    long l = paramProtoReader.beginMessage();
    String str2 = str1;
    Integer localInteger2 = localInteger1;
    Integer localInteger3 = localInteger2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new Script(localInteger1, localBoolean, localInteger2, str1, str2, localInteger3, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 6: 
        localInteger3 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 5: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 4: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 3: 
        localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 2: 
        localBoolean = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 1: 
        localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull Script paramScript)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramScript, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramScript.componentID);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 2, paramScript.enabled);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 3, paramScript.entityId);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramScript.scriptPath);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 5, paramScript.type);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 6, paramScript.version);
    paramProtoWriter.writeBytes(paramScript.unknownFields());
  }
  
  public int encodedSize(@NotNull Script paramScript)
  {
    Intrinsics.checkParameterIsNotNull(paramScript, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramScript.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(2, paramScript.enabled) + ProtoAdapter.INT32.encodedSizeWithTag(3, paramScript.entityId) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramScript.scriptPath) + ProtoAdapter.STRING.encodedSizeWithTag(5, paramScript.type) + ProtoAdapter.INT32.encodedSizeWithTag(6, paramScript.version) + paramScript.unknownFields().size();
  }
  
  @NotNull
  public Script redact(@NotNull Script paramScript)
  {
    Intrinsics.checkParameterIsNotNull(paramScript, "value");
    return Script.copy$default(paramScript, null, null, null, null, null, null, ByteString.EMPTY, 63, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Script.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */