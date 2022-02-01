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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/InputSource;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/InputSource$Builder;", "key", "", "type", "path", "label", "timeRange", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "loopCount", "", "events", "Lcom/tencent/tavcut/composition/model/component/InputSource$Event;", "inputKey", "timeStretchMode", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/TimeRange;Ljava/lang/Integer;Lcom/tencent/tavcut/composition/model/component/InputSource$Event;Ljava/lang/String;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/TimeRange;Ljava/lang/Integer;Lcom/tencent/tavcut/composition/model/component/InputSource$Event;Ljava/lang/String;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/InputSource;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "Event", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class InputSource
  extends AndroidMessage<InputSource, InputSource.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<InputSource> ADAPTER = (ProtoAdapter)new InputSource.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(InputSource.class), "type.googleapis.com/publisher.InputSource");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<InputSource> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final InputSource.Companion Companion = new InputSource.Companion(null);
  @NotNull
  public static final String DEFAULT_KEY = "";
  public static final int DEFAULT_LOOPCOUNT = 0;
  @NotNull
  public static final String DEFAULT_PATH = "";
  public static final int DEFAULT_TIMESTRETCHMODE = 0;
  @NotNull
  public static final String DEFAULT_TYPE = "";
  @WireField(adapter="com.tencent.tavcut.composition.model.component.InputSource$Event#ADAPTER", tag=7)
  @JvmField
  @Nullable
  public final InputSource.Event events;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=8)
  @JvmField
  @Nullable
  public final String inputKey;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @Nullable
  public final String key;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=4)
  @JvmField
  @Nullable
  public final String label;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=6)
  @JvmField
  @Nullable
  public final Integer loopCount;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=3)
  @JvmField
  @Nullable
  public final String path;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.TimeRange#ADAPTER", tag=5)
  @JvmField
  @Nullable
  public final TimeRange timeRange;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=9)
  @JvmField
  @Nullable
  public final Integer timeStretchMode;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @Nullable
  public final String type;
  
  public InputSource()
  {
    this(null, null, null, null, null, null, null, null, null, null, 1023, null);
  }
  
  public InputSource(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable TimeRange paramTimeRange, @Nullable Integer paramInteger1, @Nullable InputSource.Event paramEvent, @Nullable String paramString5, @Nullable Integer paramInteger2, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.key = paramString1;
    this.type = paramString2;
    this.path = paramString3;
    this.label = paramString4;
    this.timeRange = paramTimeRange;
    this.loopCount = paramInteger1;
    this.events = paramEvent;
    this.inputKey = paramString5;
    this.timeStretchMode = paramInteger2;
  }
  
  @NotNull
  public final InputSource copy(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable TimeRange paramTimeRange, @Nullable Integer paramInteger1, @Nullable InputSource.Event paramEvent, @Nullable String paramString5, @Nullable Integer paramInteger2, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new InputSource(paramString1, paramString2, paramString3, paramString4, paramTimeRange, paramInteger1, paramEvent, paramString5, paramInteger2, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (InputSource)this) {
      return true;
    }
    if (!(paramObject instanceof InputSource)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (InputSource)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.key, paramObject.key)) && (Intrinsics.areEqual(this.type, paramObject.type)) && (Intrinsics.areEqual(this.path, paramObject.path)) && (Intrinsics.areEqual(this.label, paramObject.label)) && (Intrinsics.areEqual(this.timeRange, paramObject.timeRange)) && (Intrinsics.areEqual(this.loopCount, paramObject.loopCount)) && (Intrinsics.areEqual(this.events, paramObject.events)) && (Intrinsics.areEqual(this.inputKey, paramObject.inputKey)) && (Intrinsics.areEqual(this.timeStretchMode, paramObject.timeStretchMode));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i5 = unknownFields().hashCode();
      Object localObject = this.key;
      int i4 = 0;
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
      localObject = this.path;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      localObject = this.label;
      int m;
      if (localObject != null) {
        m = localObject.hashCode();
      } else {
        m = 0;
      }
      localObject = this.timeRange;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.loopCount;
      int i1;
      if (localObject != null) {
        i1 = localObject.hashCode();
      } else {
        i1 = 0;
      }
      localObject = this.events;
      int i2;
      if (localObject != null) {
        i2 = localObject.hashCode();
      } else {
        i2 = 0;
      }
      localObject = this.inputKey;
      int i3;
      if (localObject != null) {
        i3 = localObject.hashCode();
      } else {
        i3 = 0;
      }
      localObject = this.timeStretchMode;
      if (localObject != null) {
        i4 = localObject.hashCode();
      }
      i = ((((((((i5 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n) * 37 + i1) * 37 + i2) * 37 + i3) * 37 + i4;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public InputSource.Builder newBuilder()
  {
    InputSource.Builder localBuilder = new InputSource.Builder();
    localBuilder.key = this.key;
    localBuilder.type = this.type;
    localBuilder.path = this.path;
    localBuilder.label = this.label;
    localBuilder.timeRange = this.timeRange;
    localBuilder.loopCount = this.loopCount;
    localBuilder.events = this.events;
    localBuilder.inputKey = this.inputKey;
    localBuilder.timeStretchMode = this.timeStretchMode;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.key != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key=");
      localStringBuilder.append(Internal.sanitize(this.key));
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
    if (this.path != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("path=");
      localStringBuilder.append(Internal.sanitize(this.path));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.label != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("label=");
      localStringBuilder.append(Internal.sanitize(this.label));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.timeRange != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("timeRange=");
      localStringBuilder.append(this.timeRange);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.loopCount != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loopCount=");
      localStringBuilder.append(this.loopCount);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.events != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("events=");
      localStringBuilder.append(this.events);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.inputKey != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("inputKey=");
      localStringBuilder.append(Internal.sanitize(this.inputKey));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.timeStretchMode != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("timeStretchMode=");
      localStringBuilder.append(this.timeStretchMode);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"InputSource{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.InputSource
 * JD-Core Version:    0.7.0.1
 */