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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/LUTFilter$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/LUTFilter;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LUTFilter$Companion$ADAPTER$1
  extends ProtoAdapter<LUTFilter>
{
  LUTFilter$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public LUTFilter decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger1 = (Integer)null;
    Boolean localBoolean = (Boolean)null;
    String str1 = (String)null;
    Float localFloat1 = (Float)null;
    long l = paramProtoReader.beginMessage();
    Float localFloat2 = localFloat1;
    Integer localInteger2 = localInteger1;
    Integer localInteger3 = localInteger2;
    String str2 = str1;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new LUTFilter(localInteger1, localInteger2, localBoolean, str1, str2, localFloat1, localInteger3, localFloat2, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 8: 
        localFloat2 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 7: 
        localInteger3 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 6: 
        localFloat1 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
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
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull LUTFilter paramLUTFilter)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramLUTFilter, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramLUTFilter.entityId);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, paramLUTFilter.componentID);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 3, paramLUTFilter.enabled);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramLUTFilter.type);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 5, paramLUTFilter.src);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 6, paramLUTFilter.strength);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 7, paramLUTFilter.version);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 8, paramLUTFilter.intensity);
    paramProtoWriter.writeBytes(paramLUTFilter.unknownFields());
  }
  
  public int encodedSize(@NotNull LUTFilter paramLUTFilter)
  {
    Intrinsics.checkParameterIsNotNull(paramLUTFilter, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramLUTFilter.entityId) + ProtoAdapter.INT32.encodedSizeWithTag(2, paramLUTFilter.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, paramLUTFilter.enabled) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramLUTFilter.type) + ProtoAdapter.STRING.encodedSizeWithTag(5, paramLUTFilter.src) + ProtoAdapter.FLOAT.encodedSizeWithTag(6, paramLUTFilter.strength) + ProtoAdapter.INT32.encodedSizeWithTag(7, paramLUTFilter.version) + ProtoAdapter.FLOAT.encodedSizeWithTag(8, paramLUTFilter.intensity) + paramLUTFilter.unknownFields().size();
  }
  
  @NotNull
  public LUTFilter redact(@NotNull LUTFilter paramLUTFilter)
  {
    Intrinsics.checkParameterIsNotNull(paramLUTFilter, "value");
    return LUTFilter.copy$default(paramLUTFilter, null, null, null, null, null, null, null, null, ByteString.EMPTY, 255, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.LUTFilter.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */