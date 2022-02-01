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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/TimeOffset$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/TimeOffset;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class TimeOffset$Companion$ADAPTER$1
  extends ProtoAdapter<TimeOffset>
{
  TimeOffset$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public TimeOffset decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger1 = (Integer)null;
    Boolean localBoolean = (Boolean)null;
    String str = (String)null;
    Long localLong1 = (Long)null;
    long l = paramProtoReader.beginMessage();
    Long localLong2 = localLong1;
    Integer localInteger2 = localInteger1;
    Integer localInteger3 = localInteger2;
    Integer localInteger4 = localInteger3;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new TimeOffset(localInteger1, localInteger2, localBoolean, str, localLong1, localLong2, localInteger3, localInteger4, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      case 5: 
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 9: 
        localInteger4 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 8: 
        localInteger3 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 7: 
        localLong2 = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
        break;
      case 6: 
        localLong1 = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
        break;
      case 4: 
        str = (String)ProtoAdapter.STRING.decode(paramProtoReader);
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
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull TimeOffset paramTimeOffset)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramTimeOffset, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramTimeOffset.entityId);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, paramTimeOffset.componentID);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 3, paramTimeOffset.enabled);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramTimeOffset.type);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 6, paramTimeOffset.startOffset);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 7, paramTimeOffset.duration);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 8, paramTimeOffset.loopCount);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 9, paramTimeOffset.version);
    paramProtoWriter.writeBytes(paramTimeOffset.unknownFields());
  }
  
  public int encodedSize(@NotNull TimeOffset paramTimeOffset)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeOffset, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramTimeOffset.entityId) + ProtoAdapter.INT32.encodedSizeWithTag(2, paramTimeOffset.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, paramTimeOffset.enabled) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramTimeOffset.type) + ProtoAdapter.INT64.encodedSizeWithTag(6, paramTimeOffset.startOffset) + ProtoAdapter.INT64.encodedSizeWithTag(7, paramTimeOffset.duration) + ProtoAdapter.INT32.encodedSizeWithTag(8, paramTimeOffset.loopCount) + ProtoAdapter.INT32.encodedSizeWithTag(9, paramTimeOffset.version) + paramTimeOffset.unknownFields().size();
  }
  
  @NotNull
  public TimeOffset redact(@NotNull TimeOffset paramTimeOffset)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeOffset, "value");
    return TimeOffset.copy$default(paramTimeOffset, null, null, null, null, null, null, null, null, ByteString.EMPTY, 255, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.TimeOffset.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */