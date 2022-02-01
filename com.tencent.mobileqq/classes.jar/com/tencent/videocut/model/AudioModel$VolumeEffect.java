package com.tencent.videocut.model;

import .r8.java8methods.utility.Float.hashCode.IF;
import .r8.java8methods.utility.Long.hashCode.IJ;
import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/AudioModel$VolumeEffect;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/AudioModel$VolumeEffect$Builder;", "durationUs", "", "startOffsetUs", "endOffsetUs", "startVolume", "", "endVolume", "unknownFields", "Lokio/ByteString;", "(JJJFFLokio/ByteString;)V", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Float;Lokio/ByteString;)Lcom/tencent/videocut/model/AudioModel$VolumeEffect;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class AudioModel$VolumeEffect
  extends AndroidMessage<VolumeEffect, AudioModel.VolumeEffect.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<VolumeEffect> ADAPTER = (ProtoAdapter)new AudioModel.VolumeEffect.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(VolumeEffect.class), "type.googleapis.com/publisher.AudioModel.VolumeEffect");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<VolumeEffect> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final AudioModel.VolumeEffect.Companion Companion = new AudioModel.VolumeEffect.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=1)
  @JvmField
  public final long durationUs;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=3)
  @JvmField
  public final long endOffsetUs;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=5)
  @JvmField
  public final float endVolume;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=2)
  @JvmField
  public final long startOffsetUs;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=4)
  @JvmField
  public final float startVolume;
  
  public AudioModel$VolumeEffect()
  {
    this(0L, 0L, 0L, 0.0F, 0.0F, null, 63, null);
  }
  
  public AudioModel$VolumeEffect(long paramLong1, long paramLong2, long paramLong3, float paramFloat1, float paramFloat2, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.durationUs = paramLong1;
    this.startOffsetUs = paramLong2;
    this.endOffsetUs = paramLong3;
    this.startVolume = paramFloat1;
    this.endVolume = paramFloat2;
  }
  
  @NotNull
  public final VolumeEffect copy(@Nullable Long paramLong1, @Nullable Long paramLong2, @Nullable Long paramLong3, @Nullable Float paramFloat1, @Nullable Float paramFloat2, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    long l3 = 0L;
    long l1;
    if (paramLong1 != null) {
      l1 = paramLong1.longValue();
    } else {
      l1 = 0L;
    }
    long l2;
    if (paramLong2 != null) {
      l2 = paramLong2.longValue();
    } else {
      l2 = 0L;
    }
    if (paramLong3 != null) {
      l3 = paramLong3.longValue();
    }
    float f1;
    if (paramFloat1 != null) {
      f1 = paramFloat1.floatValue();
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (paramFloat2 != null) {
      f2 = paramFloat2.floatValue();
    } else {
      f2 = 0.0F;
    }
    return new VolumeEffect(l1, l2, l3, f1, f2, paramByteString);
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
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (this.durationUs == paramObject.durationUs) && (this.startOffsetUs == paramObject.startOffsetUs) && (this.endOffsetUs == paramObject.endOffsetUs) && (this.startVolume == paramObject.startVolume) && (this.endVolume == paramObject.endVolume);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      i = ((((unknownFields().hashCode() * 37 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.durationUs)) * 37 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.startOffsetUs)) * 37 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.endOffsetUs)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.startVolume)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.endVolume);
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public AudioModel.VolumeEffect.Builder newBuilder()
  {
    AudioModel.VolumeEffect.Builder localBuilder = new AudioModel.VolumeEffect.Builder();
    localBuilder.a = this.durationUs;
    localBuilder.b = this.startOffsetUs;
    localBuilder.c = this.endOffsetUs;
    localBuilder.d = this.startVolume;
    localBuilder.e = this.endVolume;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    long l = this.durationUs;
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("durationUs=");
    localStringBuilder.append(this.durationUs);
    ((Collection)localObject2).add(localStringBuilder.toString());
    l = this.startOffsetUs;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("startOffsetUs=");
    localStringBuilder.append(this.startOffsetUs);
    ((Collection)localObject2).add(localStringBuilder.toString());
    l = this.endOffsetUs;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("endOffsetUs=");
    localStringBuilder.append(this.endOffsetUs);
    ((Collection)localObject2).add(localStringBuilder.toString());
    float f = this.startVolume;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("startVolume=");
    localStringBuilder.append(this.startVolume);
    ((Collection)localObject2).add(localStringBuilder.toString());
    f = this.endVolume;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("endVolume=");
    localStringBuilder.append(this.endVolume);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"VolumeEffect{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.AudioModel.VolumeEffect
 * JD-Core Version:    0.7.0.1
 */