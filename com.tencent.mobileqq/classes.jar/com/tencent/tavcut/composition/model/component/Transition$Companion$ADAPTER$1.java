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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/Transition$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/Transition;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Transition$Companion$ADAPTER$1
  extends ProtoAdapter<Transition>
{
  Transition$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public Transition decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger1 = (Integer)null;
    Boolean localBoolean = (Boolean)null;
    String str1 = (String)null;
    Long localLong = (Long)null;
    long l = paramProtoReader.beginMessage();
    Integer localInteger2 = localInteger1;
    Integer localInteger3 = localInteger2;
    Integer localInteger4 = localInteger3;
    Integer localInteger5 = localInteger4;
    String str2 = str1;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new Transition(localInteger1, localInteger2, localBoolean, str1, localInteger3, localInteger4, str2, localLong, localInteger5, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 9: 
        localInteger5 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 8: 
        localLong = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
        break;
      case 7: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 6: 
        localInteger4 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 5: 
        localInteger3 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
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
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull Transition paramTransition)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramTransition, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramTransition.entityId);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, paramTransition.componentID);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 3, paramTransition.enabled);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramTransition.type);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 5, paramTransition.firstIndex);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 6, paramTransition.lastIndex);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 7, paramTransition.src);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 8, paramTransition.duration);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 9, paramTransition.version);
    paramProtoWriter.writeBytes(paramTransition.unknownFields());
  }
  
  public int encodedSize(@NotNull Transition paramTransition)
  {
    Intrinsics.checkParameterIsNotNull(paramTransition, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramTransition.entityId) + ProtoAdapter.INT32.encodedSizeWithTag(2, paramTransition.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, paramTransition.enabled) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramTransition.type) + ProtoAdapter.INT32.encodedSizeWithTag(5, paramTransition.firstIndex) + ProtoAdapter.INT32.encodedSizeWithTag(6, paramTransition.lastIndex) + ProtoAdapter.STRING.encodedSizeWithTag(7, paramTransition.src) + ProtoAdapter.INT64.encodedSizeWithTag(8, paramTransition.duration) + ProtoAdapter.INT32.encodedSizeWithTag(9, paramTransition.version) + paramTransition.unknownFields().size();
  }
  
  @NotNull
  public Transition redact(@NotNull Transition paramTransition)
  {
    Intrinsics.checkParameterIsNotNull(paramTransition, "value");
    return Transition.copy$default(paramTransition, null, null, null, null, null, null, null, null, null, ByteString.EMPTY, 511, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Transition.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */