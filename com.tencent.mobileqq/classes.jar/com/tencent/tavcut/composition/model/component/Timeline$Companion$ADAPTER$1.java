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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/Timeline$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Timeline$Companion$ADAPTER$1
  extends ProtoAdapter<Timeline>
{
  Timeline$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public Timeline decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger = (Integer)null;
    String str1 = (String)null;
    TimeRange localTimeRange = (TimeRange)null;
    Long localLong = (Long)null;
    long l = paramProtoReader.beginMessage();
    String str2 = str1;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new Timeline(localInteger, str1, localTimeRange, localLong, str2, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                paramProtoReader.readUnknownField(i);
              } else {
                str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
              }
            }
            else {
              localLong = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
            }
          }
          else {
            localTimeRange = (TimeRange)TimeRange.ADAPTER.decode(paramProtoReader);
          }
        }
        else {
          str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        }
      }
      else {
        localInteger = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull Timeline paramTimeline)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramTimeline, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramTimeline.entityID);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramTimeline.type);
    TimeRange.ADAPTER.encodeWithTag(paramProtoWriter, 3, paramTimeline.range);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 4, paramTimeline.time);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 5, paramTimeline.event);
    paramProtoWriter.writeBytes(paramTimeline.unknownFields());
  }
  
  public int encodedSize(@NotNull Timeline paramTimeline)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeline, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramTimeline.entityID) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramTimeline.type) + TimeRange.ADAPTER.encodedSizeWithTag(3, paramTimeline.range) + ProtoAdapter.INT64.encodedSizeWithTag(4, paramTimeline.time) + ProtoAdapter.STRING.encodedSizeWithTag(5, paramTimeline.event) + paramTimeline.unknownFields().size();
  }
  
  @NotNull
  public Timeline redact(@NotNull Timeline paramTimeline)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeline, "value");
    TimeRange localTimeRange = paramTimeline.range;
    if (localTimeRange != null) {
      localTimeRange = (TimeRange)TimeRange.ADAPTER.redact(localTimeRange);
    } else {
      localTimeRange = null;
    }
    return Timeline.copy$default(paramTimeline, null, null, localTimeRange, null, null, ByteString.EMPTY, 27, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Timeline.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */