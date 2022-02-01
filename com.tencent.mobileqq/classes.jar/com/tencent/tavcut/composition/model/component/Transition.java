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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/Transition;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/Transition$Builder;", "entityId", "", "componentID", "enabled", "", "type", "", "firstIndex", "lastIndex", "src", "duration", "", "version", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Long;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/Transition;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Transition
  extends AndroidMessage<Transition, Transition.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<Transition> ADAPTER = (ProtoAdapter)new Transition.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Transition.class), "type.googleapis.com/publisher.Transition");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<Transition> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final Transition.Companion Companion = new Transition.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=2)
  @JvmField
  @Nullable
  public final Integer componentID;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=8)
  @JvmField
  @Nullable
  public final Long duration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=3)
  @JvmField
  @Nullable
  public final Boolean enabled;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=1)
  @JvmField
  @Nullable
  public final Integer entityId;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=5)
  @JvmField
  @Nullable
  public final Integer firstIndex;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=6)
  @JvmField
  @Nullable
  public final Integer lastIndex;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=7)
  @JvmField
  @Nullable
  public final String src;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=4)
  @JvmField
  @Nullable
  public final String type;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=9)
  @JvmField
  @Nullable
  public final Integer version;
  
  public Transition()
  {
    this(null, null, null, null, null, null, null, null, null, null, 1023, null);
  }
  
  public Transition(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Boolean paramBoolean, @Nullable String paramString1, @Nullable Integer paramInteger3, @Nullable Integer paramInteger4, @Nullable String paramString2, @Nullable Long paramLong, @Nullable Integer paramInteger5, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.entityId = paramInteger1;
    this.componentID = paramInteger2;
    this.enabled = paramBoolean;
    this.type = paramString1;
    this.firstIndex = paramInteger3;
    this.lastIndex = paramInteger4;
    this.src = paramString2;
    this.duration = paramLong;
    this.version = paramInteger5;
  }
  
  @NotNull
  public final Transition copy(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Boolean paramBoolean, @Nullable String paramString1, @Nullable Integer paramInteger3, @Nullable Integer paramInteger4, @Nullable String paramString2, @Nullable Long paramLong, @Nullable Integer paramInteger5, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new Transition(paramInteger1, paramInteger2, paramBoolean, paramString1, paramInteger3, paramInteger4, paramString2, paramLong, paramInteger5, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (Transition)this) {
      return true;
    }
    if (!(paramObject instanceof Transition)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (Transition)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.entityId, paramObject.entityId)) && (Intrinsics.areEqual(this.componentID, paramObject.componentID)) && (Intrinsics.areEqual(this.enabled, paramObject.enabled)) && (Intrinsics.areEqual(this.type, paramObject.type)) && (Intrinsics.areEqual(this.firstIndex, paramObject.firstIndex)) && (Intrinsics.areEqual(this.lastIndex, paramObject.lastIndex)) && (Intrinsics.areEqual(this.src, paramObject.src)) && (Intrinsics.areEqual(this.duration, paramObject.duration)) && (Intrinsics.areEqual(this.version, paramObject.version));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i5 = unknownFields().hashCode();
      Object localObject = this.entityId;
      int i4 = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.componentID;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.enabled;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      localObject = this.type;
      int m;
      if (localObject != null) {
        m = localObject.hashCode();
      } else {
        m = 0;
      }
      localObject = this.firstIndex;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.lastIndex;
      int i1;
      if (localObject != null) {
        i1 = localObject.hashCode();
      } else {
        i1 = 0;
      }
      localObject = this.src;
      int i2;
      if (localObject != null) {
        i2 = localObject.hashCode();
      } else {
        i2 = 0;
      }
      localObject = this.duration;
      int i3;
      if (localObject != null) {
        i3 = localObject.hashCode();
      } else {
        i3 = 0;
      }
      localObject = this.version;
      if (localObject != null) {
        i4 = localObject.hashCode();
      }
      i = ((((((((i5 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n) * 37 + i1) * 37 + i2) * 37 + i3) * 37 + i4;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public Transition.Builder newBuilder()
  {
    Transition.Builder localBuilder = new Transition.Builder();
    localBuilder.entityId = this.entityId;
    localBuilder.componentID = this.componentID;
    localBuilder.enabled = this.enabled;
    localBuilder.type = this.type;
    localBuilder.firstIndex = this.firstIndex;
    localBuilder.lastIndex = this.lastIndex;
    localBuilder.src = this.src;
    localBuilder.duration = this.duration;
    localBuilder.version = this.version;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.entityId != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("entityId=");
      localStringBuilder.append(this.entityId);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.componentID != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("componentID=");
      localStringBuilder.append(this.componentID);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.enabled != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("enabled=");
      localStringBuilder.append(this.enabled);
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
    if (this.firstIndex != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("firstIndex=");
      localStringBuilder.append(this.firstIndex);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.lastIndex != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("lastIndex=");
      localStringBuilder.append(this.lastIndex);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.src != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("src=");
      localStringBuilder.append(Internal.sanitize(this.src));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.duration != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("duration=");
      localStringBuilder.append(this.duration);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.version != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("version=");
      localStringBuilder.append(this.version);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"Transition{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Transition
 * JD-Core Version:    0.7.0.1
 */