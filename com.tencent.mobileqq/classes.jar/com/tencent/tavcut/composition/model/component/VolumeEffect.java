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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/VolumeEffect$Builder;", "startOffset", "", "endOffset", "duration", "start", "", "end", "interpolationType", "", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Lokio/ByteString;)V", "Ljava/lang/Long;", "Ljava/lang/Float;", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class VolumeEffect
  extends AndroidMessage<VolumeEffect, VolumeEffect.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<VolumeEffect> ADAPTER = (ProtoAdapter)new VolumeEffect.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(VolumeEffect.class), "type.googleapis.com/publisher.VolumeEffect");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<VolumeEffect> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final VolumeEffect.Companion Companion = new VolumeEffect.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=3)
  @JvmField
  @Nullable
  public final Long duration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=5)
  @JvmField
  @Nullable
  public final Float end;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=2)
  @JvmField
  @Nullable
  public final Long endOffset;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=6)
  @JvmField
  @Nullable
  public final String interpolationType;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=4)
  @JvmField
  @Nullable
  public final Float start;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=1)
  @JvmField
  @Nullable
  public final Long startOffset;
  
  public VolumeEffect()
  {
    this(null, null, null, null, null, null, null, 127, null);
  }
  
  public VolumeEffect(@Nullable Long paramLong1, @Nullable Long paramLong2, @Nullable Long paramLong3, @Nullable Float paramFloat1, @Nullable Float paramFloat2, @Nullable String paramString, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.startOffset = paramLong1;
    this.endOffset = paramLong2;
    this.duration = paramLong3;
    this.start = paramFloat1;
    this.end = paramFloat2;
    this.interpolationType = paramString;
  }
  
  @NotNull
  public final VolumeEffect copy(@Nullable Long paramLong1, @Nullable Long paramLong2, @Nullable Long paramLong3, @Nullable Float paramFloat1, @Nullable Float paramFloat2, @Nullable String paramString, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new VolumeEffect(paramLong1, paramLong2, paramLong3, paramFloat1, paramFloat2, paramString, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (VolumeEffect)this) {
      return true;
    }
    if (!(paramObject instanceof VolumeEffect)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (VolumeEffect)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.startOffset, paramObject.startOffset)) && (Intrinsics.areEqual(this.endOffset, paramObject.endOffset)) && (Intrinsics.areEqual(this.duration, paramObject.duration)) && (Intrinsics.areEqual(this.start, paramObject.start)) && (Intrinsics.areEqual(this.end, paramObject.end)) && (Intrinsics.areEqual(this.interpolationType, paramObject.interpolationType));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i2 = unknownFields().hashCode();
      Object localObject = this.startOffset;
      int i1 = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.endOffset;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.duration;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      localObject = this.start;
      int m;
      if (localObject != null) {
        m = localObject.hashCode();
      } else {
        m = 0;
      }
      localObject = this.end;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.interpolationType;
      if (localObject != null) {
        i1 = localObject.hashCode();
      }
      i = (((((i2 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n) * 37 + i1;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public VolumeEffect.Builder newBuilder()
  {
    VolumeEffect.Builder localBuilder = new VolumeEffect.Builder();
    localBuilder.startOffset = this.startOffset;
    localBuilder.endOffset = this.endOffset;
    localBuilder.duration = this.duration;
    localBuilder.start = this.start;
    localBuilder.end = this.end;
    localBuilder.interpolationType = this.interpolationType;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.startOffset != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startOffset=");
      localStringBuilder.append(this.startOffset);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.endOffset != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("endOffset=");
      localStringBuilder.append(this.endOffset);
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
    if (this.start != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("start=");
      localStringBuilder.append(this.start);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.end != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("end=");
      localStringBuilder.append(this.end);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.interpolationType != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("interpolationType=");
      localStringBuilder.append(Internal.sanitize(this.interpolationType));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"VolumeEffect{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.VolumeEffect
 * JD-Core Version:    0.7.0.1
 */