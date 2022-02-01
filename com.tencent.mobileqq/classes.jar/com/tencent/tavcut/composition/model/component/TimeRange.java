package com.tencent.tavcut.composition.model.component;

import .r8.java8methods.utility.Long.hashCode.IJ;
import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.squareup.wire.WireField.Label;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/TimeRange;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/TimeRange$Builder;", "startTime", "", "duration", "unknownFields", "Lokio/ByteString;", "(JJLokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class TimeRange
  extends AndroidMessage<TimeRange, TimeRange.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<TimeRange> ADAPTER = (ProtoAdapter)new TimeRange.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TimeRange.class), "type.googleapis.com/publisher.TimeRange");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<TimeRange> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final TimeRange.Companion Companion = new TimeRange.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", label=WireField.Label.REQUIRED, tag=2)
  @JvmField
  public final long duration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", label=WireField.Label.REQUIRED, tag=1)
  @JvmField
  public final long startTime;
  
  public TimeRange(long paramLong1, long paramLong2, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.startTime = paramLong1;
    this.duration = paramLong2;
  }
  
  @NotNull
  public final TimeRange copy(long paramLong1, long paramLong2, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new TimeRange(paramLong1, paramLong2, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (TimeRange)this) {
      return true;
    }
    if (!(paramObject instanceof TimeRange)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (TimeRange)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (this.startTime == paramObject.startTime) && (this.duration == paramObject.duration);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      i = (unknownFields().hashCode() * 37 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.startTime)) * 37 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.duration);
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public TimeRange.Builder newBuilder()
  {
    TimeRange.Builder localBuilder = new TimeRange.Builder();
    localBuilder.startTime = Long.valueOf(this.startTime);
    localBuilder.duration = Long.valueOf(this.duration);
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startTime=");
    localStringBuilder.append(this.startTime);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("duration=");
    localStringBuilder.append(this.duration);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"TimeRange{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.TimeRange
 * JD-Core Version:    0.7.0.1
 */