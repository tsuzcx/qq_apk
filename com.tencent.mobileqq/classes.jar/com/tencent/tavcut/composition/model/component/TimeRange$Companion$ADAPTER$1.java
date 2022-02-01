package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/TimeRange$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class TimeRange$Companion$ADAPTER$1
  extends ProtoAdapter<TimeRange>
{
  TimeRange$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public TimeRange decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Long localLong2 = (Long)null;
    long l = paramProtoReader.beginMessage();
    Long localLong1 = localLong2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l);
        if (localLong2 != null)
        {
          l = localLong2.longValue();
          if (localLong1 != null) {
            return new TimeRange(l, localLong1.longValue(), paramProtoReader);
          }
          throw ((Throwable)Internal.missingRequiredFields(new Object[] { localLong1, "duration" }));
        }
        throw ((Throwable)Internal.missingRequiredFields(new Object[] { localLong2, "startTime" }));
      }
      if (i != 1)
      {
        if (i != 2) {
          paramProtoReader.readUnknownField(i);
        } else {
          localLong1 = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
        }
      }
      else {
        localLong2 = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull TimeRange paramTimeRange)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramTimeRange, "value");
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 1, Long.valueOf(paramTimeRange.startTime));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 2, Long.valueOf(paramTimeRange.duration));
    paramProtoWriter.writeBytes(paramTimeRange.unknownFields());
  }
  
  public int encodedSize(@NotNull TimeRange paramTimeRange)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeRange, "value");
    return ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(paramTimeRange.startTime)) + ProtoAdapter.INT64.encodedSizeWithTag(2, Long.valueOf(paramTimeRange.duration)) + paramTimeRange.unknownFields().size();
  }
  
  @NotNull
  public TimeRange redact(@NotNull TimeRange paramTimeRange)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeRange, "value");
    return TimeRange.copy$default(paramTimeRange, 0L, 0L, ByteString.EMPTY, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.TimeRange.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */