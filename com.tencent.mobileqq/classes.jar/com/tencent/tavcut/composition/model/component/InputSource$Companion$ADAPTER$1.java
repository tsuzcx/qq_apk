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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/InputSource$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class InputSource$Companion$ADAPTER$1
  extends ProtoAdapter<InputSource>
{
  InputSource$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public InputSource decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    String str1 = (String)null;
    TimeRange localTimeRange = (TimeRange)null;
    Integer localInteger1 = (Integer)null;
    InputSource.Event localEvent = (InputSource.Event)null;
    long l = paramProtoReader.beginMessage();
    String str2 = str1;
    String str3 = str2;
    String str4 = str3;
    String str5 = str4;
    Integer localInteger2 = localInteger1;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new InputSource(str1, str2, str3, str4, localTimeRange, localInteger1, localEvent, str5, localInteger2, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 9: 
        localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 8: 
        str5 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 7: 
        localEvent = (InputSource.Event)InputSource.Event.ADAPTER.decode(paramProtoReader);
        break;
      case 6: 
        localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 5: 
        localTimeRange = (TimeRange)TimeRange.ADAPTER.decode(paramProtoReader);
        break;
      case 4: 
        str4 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 3: 
        str3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 2: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 1: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull InputSource paramInputSource)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramInputSource, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramInputSource.key);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramInputSource.type);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 3, paramInputSource.path);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramInputSource.label);
    TimeRange.ADAPTER.encodeWithTag(paramProtoWriter, 5, paramInputSource.timeRange);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 6, paramInputSource.loopCount);
    InputSource.Event.ADAPTER.encodeWithTag(paramProtoWriter, 7, paramInputSource.events);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 8, paramInputSource.inputKey);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 9, paramInputSource.timeStretchMode);
    paramProtoWriter.writeBytes(paramInputSource.unknownFields());
  }
  
  public int encodedSize(@NotNull InputSource paramInputSource)
  {
    Intrinsics.checkParameterIsNotNull(paramInputSource, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramInputSource.key) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramInputSource.type) + ProtoAdapter.STRING.encodedSizeWithTag(3, paramInputSource.path) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramInputSource.label) + TimeRange.ADAPTER.encodedSizeWithTag(5, paramInputSource.timeRange) + ProtoAdapter.INT32.encodedSizeWithTag(6, paramInputSource.loopCount) + InputSource.Event.ADAPTER.encodedSizeWithTag(7, paramInputSource.events) + ProtoAdapter.STRING.encodedSizeWithTag(8, paramInputSource.inputKey) + ProtoAdapter.INT32.encodedSizeWithTag(9, paramInputSource.timeStretchMode) + paramInputSource.unknownFields().size();
  }
  
  @NotNull
  public InputSource redact(@NotNull InputSource paramInputSource)
  {
    Intrinsics.checkParameterIsNotNull(paramInputSource, "value");
    TimeRange localTimeRange = paramInputSource.timeRange;
    if (localTimeRange != null) {
      localTimeRange = (TimeRange)TimeRange.ADAPTER.redact(localTimeRange);
    } else {
      localTimeRange = null;
    }
    InputSource.Event localEvent = paramInputSource.events;
    if (localEvent != null) {
      localEvent = (InputSource.Event)InputSource.Event.ADAPTER.redact(localEvent);
    } else {
      localEvent = null;
    }
    return InputSource.copy$default(paramInputSource, null, null, null, null, localTimeRange, null, localEvent, null, null, ByteString.EMPTY, 431, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.InputSource.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */