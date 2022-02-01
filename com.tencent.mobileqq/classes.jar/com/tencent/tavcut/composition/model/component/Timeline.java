package com.tencent.tavcut.composition.model.component;

import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/Timeline;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/Timeline$Builder;", "entityID", "", "type", "", "range", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "time", "", "event", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/TimeRange;Ljava/lang/Long;Ljava/lang/String;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Long;", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/TimeRange;Ljava/lang/Long;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/Timeline;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Timeline
  extends AndroidMessage<Timeline, Timeline.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<Timeline> ADAPTER = (ProtoAdapter)new Timeline.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Timeline.class), "type.googleapis.com/publisher.Timeline");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<Timeline> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final Timeline.Companion Companion = new Timeline.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=1)
  @JvmField
  @Nullable
  public final Integer entityID;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=5)
  @JvmField
  @Nullable
  public final String event;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.TimeRange#ADAPTER", tag=3)
  @JvmField
  @Nullable
  public final TimeRange range;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=4)
  @JvmField
  @Nullable
  public final Long time;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @Nullable
  public final String type;
  
  public Timeline()
  {
    this(null, null, null, null, null, null, 63, null);
  }
  
  public Timeline(@Nullable Integer paramInteger, @Nullable String paramString1, @Nullable TimeRange paramTimeRange, @Nullable Long paramLong, @Nullable String paramString2, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.entityID = paramInteger;
    this.type = paramString1;
    this.range = paramTimeRange;
    this.time = paramLong;
    this.event = paramString2;
  }
  
  @NotNull
  public final Timeline copy(@Nullable Integer paramInteger, @Nullable String paramString1, @Nullable TimeRange paramTimeRange, @Nullable Long paramLong, @Nullable String paramString2, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new Timeline(paramInteger, paramString1, paramTimeRange, paramLong, paramString2, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (Timeline)this) {
      return true;
    }
    if (!(paramObject instanceof Timeline)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (Timeline)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.entityID, paramObject.entityID)) && (Intrinsics.areEqual(this.type, paramObject.type)) && (Intrinsics.areEqual(this.range, paramObject.range)) && (Intrinsics.areEqual(this.time, paramObject.time)) && (Intrinsics.areEqual(this.event, paramObject.event));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i1 = unknownFields().hashCode();
      Object localObject = this.entityID;
      int n = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.type;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.range;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      localObject = this.time;
      int m;
      if (localObject != null) {
        m = localObject.hashCode();
      } else {
        m = 0;
      }
      localObject = this.event;
      if (localObject != null) {
        n = localObject.hashCode();
      }
      i = ((((i1 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public Timeline.Builder newBuilder()
  {
    Timeline.Builder localBuilder = new Timeline.Builder();
    localBuilder.entityID = this.entityID;
    localBuilder.type = this.type;
    localBuilder.range = this.range;
    localBuilder.time = this.time;
    localBuilder.event = this.event;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.entityID != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("entityID=");
      localStringBuilder.append(this.entityID);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.type != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("type=");
      localStringBuilder.append(Internal.sanitize(this.type));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.range != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("range=");
      localStringBuilder.append(this.range);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.time != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("time=");
      localStringBuilder.append(this.time);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.event != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("event=");
      localStringBuilder.append(Internal.sanitize(this.event));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"Timeline{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Timeline
 * JD-Core Version:    0.7.0.1
 */