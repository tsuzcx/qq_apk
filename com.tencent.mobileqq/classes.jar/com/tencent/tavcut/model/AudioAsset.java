package com.tencent.tavcut.model;

import .r8.java8methods.utility.Float.hashCode.IF;
import .r8.java8methods.utility.Integer.hashCode.II;
import .r8.java8methods.utility.Long.hashCode.IJ;
import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.squareup.wire.WireField.Label;
import com.squareup.wire.internal.Internal;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.composition.model.component.VolumeEffect;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/AudioAsset;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/AudioAsset$Builder;", "assetId", "", "path", "timeRange", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "speed", "", "volume", "startOffset", "", "volumeEffects", "", "Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "type", "", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/TimeRange;FFJLjava/util/List;ILokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class AudioAsset
  extends AndroidMessage<AudioAsset, AudioAsset.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<AudioAsset> ADAPTER = (ProtoAdapter)new AudioAsset.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AudioAsset.class), "type.googleapis.com/publisher.AudioAsset");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<AudioAsset> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final AudioAsset.Companion Companion = new AudioAsset.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @Nullable
  public final String assetId;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @Nullable
  public final String path;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REQUIRED, tag=4)
  @JvmField
  public final float speed;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", label=WireField.Label.REQUIRED, tag=6)
  @JvmField
  public final long startOffset;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.TimeRange#ADAPTER", tag=3)
  @JvmField
  @Nullable
  public final TimeRange timeRange;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REQUIRED, tag=8)
  @JvmField
  public final int type;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REQUIRED, tag=5)
  @JvmField
  public final float volume;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.VolumeEffect#ADAPTER", label=WireField.Label.REPEATED, tag=7)
  @JvmField
  @NotNull
  public final List<VolumeEffect> volumeEffects;
  
  public AudioAsset(@Nullable String paramString1, @Nullable String paramString2, @Nullable TimeRange paramTimeRange, float paramFloat1, float paramFloat2, long paramLong, @NotNull List<VolumeEffect> paramList, int paramInt, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.assetId = paramString1;
    this.path = paramString2;
    this.timeRange = paramTimeRange;
    this.speed = paramFloat1;
    this.volume = paramFloat2;
    this.startOffset = paramLong;
    this.volumeEffects = paramList;
    this.type = paramInt;
  }
  
  @NotNull
  public final AudioAsset copy(@Nullable String paramString1, @Nullable String paramString2, @Nullable TimeRange paramTimeRange, float paramFloat1, float paramFloat2, long paramLong, @NotNull List<VolumeEffect> paramList, int paramInt, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "volumeEffects");
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new AudioAsset(paramString1, paramString2, paramTimeRange, paramFloat1, paramFloat2, paramLong, paramList, paramInt, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (AudioAsset)this) {
      return true;
    }
    if (!(paramObject instanceof AudioAsset)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (AudioAsset)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.assetId, paramObject.assetId)) && (Intrinsics.areEqual(this.path, paramObject.path)) && (Intrinsics.areEqual(this.timeRange, paramObject.timeRange)) && (this.speed == paramObject.speed) && (this.volume == paramObject.volume) && (this.startOffset == paramObject.startOffset) && (Intrinsics.areEqual(this.volumeEffects, paramObject.volumeEffects)) && (this.type == paramObject.type);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int m = unknownFields().hashCode();
      Object localObject = this.assetId;
      int k = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.path;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.timeRange;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      i = (((((((m * 37 + i) * 37 + j) * 37 + k) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.speed)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.volume)) * 37 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.startOffset)) * 37 + this.volumeEffects.hashCode()) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.type);
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public AudioAsset.Builder newBuilder()
  {
    AudioAsset.Builder localBuilder = new AudioAsset.Builder();
    localBuilder.assetId = this.assetId;
    localBuilder.path = this.path;
    localBuilder.timeRange = this.timeRange;
    localBuilder.speed = Float.valueOf(this.speed);
    localBuilder.volume = Float.valueOf(this.volume);
    localBuilder.startOffset = Long.valueOf(this.startOffset);
    localBuilder.volumeEffects = this.volumeEffects;
    localBuilder.type = Integer.valueOf(this.type);
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    if (this.assetId != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("assetId=");
      localStringBuilder.append(Internal.sanitize(this.assetId));
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
    if (this.timeRange != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("timeRange=");
      localStringBuilder.append(this.timeRange);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("speed=");
    localStringBuilder.append(this.speed);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("volume=");
    localStringBuilder.append(this.volume);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("startOffset=");
    localStringBuilder.append(this.startOffset);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if ((((Collection)this.volumeEffects).isEmpty() ^ true))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("volumeEffects=");
      localStringBuilder.append(this.volumeEffects);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("type=");
    localStringBuilder.append(this.type);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"AudioAsset{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.AudioAsset
 * JD-Core Version:    0.7.0.1
 */