package com.tencent.videocut.model;

import .r8.java8methods.utility.Float.hashCode.IF;
import .r8.java8methods.utility.Long.hashCode.IJ;
import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.squareup.wire.WireField.Label;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/AudioModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/AudioModel$Builder;", "id", "", "path", "sourceStartTime", "", "sourceDuration", "startTimeInTimeline", "volume", "", "speed", "volumeEffects", "", "Lcom/tencent/videocut/model/AudioModel$VolumeEffect;", "name", "timelineTrackIndex", "", "selectStartTime", "selectDuration", "fadeInDuration", "fadeOutDuration", "lyricInfo", "Lcom/tencent/videocut/model/AudioModel$LyricInfo;", "type", "Lcom/tencent/videocut/model/AudioModel$Type;", "waveSampleData", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;JJJFFLjava/util/List;Ljava/lang/String;Ljava/lang/Integer;JJJJLcom/tencent/videocut/model/AudioModel$LyricInfo;Lcom/tencent/videocut/model/AudioModel$Type;Ljava/util/List;Lokio/ByteString;)V", "Ljava/lang/Integer;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Float;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/tencent/videocut/model/AudioModel$LyricInfo;Lcom/tencent/videocut/model/AudioModel$Type;Ljava/util/List;Lokio/ByteString;)Lcom/tencent/videocut/model/AudioModel;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "LyricInfo", "Type", "VolumeEffect", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class AudioModel
  extends AndroidMessage<AudioModel, AudioModel.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<AudioModel> ADAPTER = (ProtoAdapter)new AudioModel.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AudioModel.class), "type.googleapis.com/publisher.AudioModel");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<AudioModel> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final AudioModel.Companion Companion = new AudioModel.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=13)
  @JvmField
  public final long fadeInDuration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=14)
  @JvmField
  public final long fadeOutDuration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @NotNull
  public final String id;
  @WireField(adapter="com.tencent.videocut.model.AudioModel$LyricInfo#ADAPTER", tag=15)
  @JvmField
  @Nullable
  public final AudioModel.LyricInfo lyricInfo;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=9)
  @JvmField
  @NotNull
  public final String name;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @NotNull
  public final String path;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=12)
  @JvmField
  public final long selectDuration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=11)
  @JvmField
  public final long selectStartTime;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=4)
  @JvmField
  public final long sourceDuration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=3)
  @JvmField
  public final long sourceStartTime;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=7)
  @JvmField
  public final float speed;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=5)
  @JvmField
  public final long startTimeInTimeline;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=10)
  @JvmField
  @Nullable
  public final Integer timelineTrackIndex;
  @WireField(adapter="com.tencent.videocut.model.AudioModel$Type#ADAPTER", tag=16)
  @JvmField
  @Nullable
  public final AudioModel.Type type;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=6)
  @JvmField
  public final float volume;
  @WireField(adapter="com.tencent.videocut.model.AudioModel$VolumeEffect#ADAPTER", label=WireField.Label.REPEATED, tag=8)
  @JvmField
  @NotNull
  public final List<AudioModel.VolumeEffect> volumeEffects;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REPEATED, tag=17)
  @JvmField
  @NotNull
  public final List<Integer> waveSampleData;
  
  public AudioModel()
  {
    this(null, null, 0L, 0L, 0L, 0.0F, 0.0F, null, null, null, 0L, 0L, 0L, 0L, null, null, null, null, 262143, null);
  }
  
  public AudioModel(@NotNull String paramString1, @NotNull String paramString2, long paramLong1, long paramLong2, long paramLong3, float paramFloat1, float paramFloat2, @NotNull List<AudioModel.VolumeEffect> paramList, @NotNull String paramString3, @Nullable Integer paramInteger, long paramLong4, long paramLong5, long paramLong6, long paramLong7, @Nullable AudioModel.LyricInfo paramLyricInfo, @Nullable AudioModel.Type paramType, @NotNull List<Integer> paramList1, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.id = paramString1;
    this.path = paramString2;
    this.sourceStartTime = paramLong1;
    this.sourceDuration = paramLong2;
    this.startTimeInTimeline = paramLong3;
    this.volume = paramFloat1;
    this.speed = paramFloat2;
    this.volumeEffects = paramList;
    this.name = paramString3;
    this.timelineTrackIndex = paramInteger;
    this.selectStartTime = paramLong4;
    this.selectDuration = paramLong5;
    this.fadeInDuration = paramLong6;
    this.fadeOutDuration = paramLong7;
    this.lyricInfo = paramLyricInfo;
    this.type = paramType;
    this.waveSampleData = paramList1;
  }
  
  @NotNull
  public final AudioModel copy(@Nullable String paramString1, @Nullable String paramString2, @Nullable Long paramLong1, @Nullable Long paramLong2, @Nullable Long paramLong3, @Nullable Float paramFloat1, @Nullable Float paramFloat2, @NotNull List<AudioModel.VolumeEffect> paramList, @Nullable String paramString3, @Nullable Integer paramInteger, @Nullable Long paramLong4, @Nullable Long paramLong5, @Nullable Long paramLong6, @Nullable Long paramLong7, @Nullable AudioModel.LyricInfo paramLyricInfo, @Nullable AudioModel.Type paramType, @NotNull List<Integer> paramList1, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "volumeEffects");
    Intrinsics.checkParameterIsNotNull(paramList1, "waveSampleData");
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    if (paramString1 == null) {
      paramString1 = "";
    }
    if (paramString2 == null) {
      paramString2 = "";
    }
    long l7 = 0L;
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
    long l3;
    if (paramLong3 != null) {
      l3 = paramLong3.longValue();
    } else {
      l3 = 0L;
    }
    float f2 = 0.0F;
    float f1;
    if (paramFloat1 != null) {
      f1 = paramFloat1.floatValue();
    } else {
      f1 = 0.0F;
    }
    if (paramFloat2 != null) {
      f2 = paramFloat2.floatValue();
    }
    if (paramString3 == null) {
      paramString3 = "";
    }
    long l4;
    if (paramLong4 != null) {
      l4 = paramLong4.longValue();
    } else {
      l4 = 0L;
    }
    long l5;
    if (paramLong5 != null) {
      l5 = paramLong5.longValue();
    } else {
      l5 = 0L;
    }
    long l6;
    if (paramLong6 != null) {
      l6 = paramLong6.longValue();
    } else {
      l6 = 0L;
    }
    if (paramLong7 != null) {
      l7 = paramLong7.longValue();
    }
    return new AudioModel(paramString1, paramString2, l1, l2, l3, f1, f2, paramList, paramString3, paramInteger, l4, l5, l6, l7, paramLyricInfo, paramType, paramList1, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (AudioModel)this) {
      return true;
    }
    if (!(paramObject instanceof AudioModel)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (AudioModel)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.id, paramObject.id)) && (Intrinsics.areEqual(this.path, paramObject.path)) && (this.sourceStartTime == paramObject.sourceStartTime) && (this.sourceDuration == paramObject.sourceDuration) && (this.startTimeInTimeline == paramObject.startTimeInTimeline) && (this.volume == paramObject.volume) && (this.speed == paramObject.speed) && (Intrinsics.areEqual(this.volumeEffects, paramObject.volumeEffects)) && (Intrinsics.areEqual(this.name, paramObject.name)) && (Intrinsics.areEqual(this.timelineTrackIndex, paramObject.timelineTrackIndex)) && (this.selectStartTime == paramObject.selectStartTime) && (this.selectDuration == paramObject.selectDuration) && (this.fadeInDuration == paramObject.fadeInDuration) && (this.fadeOutDuration == paramObject.fadeOutDuration) && (Intrinsics.areEqual(this.lyricInfo, paramObject.lyricInfo)) && (this.type == paramObject.type) && (Intrinsics.areEqual(this.waveSampleData, paramObject.waveSampleData));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int m = unknownFields().hashCode();
      int n = this.id.hashCode();
      int i1 = this.path.hashCode();
      int i2 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.sourceStartTime);
      int i3 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.sourceDuration);
      int i4 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.startTimeInTimeline);
      int i5 = .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.volume);
      int i6 = .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.speed);
      int i7 = this.volumeEffects.hashCode();
      int i8 = this.name.hashCode();
      Object localObject = this.timelineTrackIndex;
      int k = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      int i9 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.selectStartTime);
      int i10 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.selectDuration);
      int i11 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.fadeInDuration);
      int i12 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.fadeOutDuration);
      localObject = this.lyricInfo;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.type;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      i = ((((((((((((((((m * 37 + n) * 37 + i1) * 37 + i2) * 37 + i3) * 37 + i4) * 37 + i5) * 37 + i6) * 37 + i7) * 37 + i8) * 37 + i) * 37 + i9) * 37 + i10) * 37 + i11) * 37 + i12) * 37 + j) * 37 + k) * 37 + this.waveSampleData.hashCode();
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public AudioModel.Builder newBuilder()
  {
    AudioModel.Builder localBuilder = new AudioModel.Builder();
    localBuilder.a = this.id;
    localBuilder.b = this.path;
    localBuilder.c = this.sourceStartTime;
    localBuilder.d = this.sourceDuration;
    localBuilder.e = this.startTimeInTimeline;
    localBuilder.f = this.volume;
    localBuilder.g = this.speed;
    localBuilder.h = this.volumeEffects;
    localBuilder.i = this.name;
    localBuilder.j = this.timelineTrackIndex;
    localBuilder.k = this.selectStartTime;
    localBuilder.l = this.selectDuration;
    localBuilder.m = this.fadeInDuration;
    localBuilder.n = this.fadeOutDuration;
    localBuilder.o = this.lyricInfo;
    localBuilder.p = this.type;
    localBuilder.q = this.waveSampleData;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    if (this.id != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("id=");
      localStringBuilder.append(Internal.sanitize(this.id));
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
    long l = this.sourceStartTime;
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sourceStartTime=");
    localStringBuilder.append(this.sourceStartTime);
    ((Collection)localObject2).add(localStringBuilder.toString());
    l = this.sourceDuration;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("sourceDuration=");
    localStringBuilder.append(this.sourceDuration);
    ((Collection)localObject2).add(localStringBuilder.toString());
    l = this.startTimeInTimeline;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("startTimeInTimeline=");
    localStringBuilder.append(this.startTimeInTimeline);
    ((Collection)localObject2).add(localStringBuilder.toString());
    float f = this.volume;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("volume=");
    localStringBuilder.append(this.volume);
    ((Collection)localObject2).add(localStringBuilder.toString());
    f = this.speed;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("speed=");
    localStringBuilder.append(this.speed);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if ((((Collection)this.volumeEffects).isEmpty() ^ true))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("volumeEffects=");
      localStringBuilder.append(this.volumeEffects);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.name != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("name=");
      localStringBuilder.append(Internal.sanitize(this.name));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.timelineTrackIndex != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("timelineTrackIndex=");
      localStringBuilder.append(this.timelineTrackIndex);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    l = this.selectStartTime;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("selectStartTime=");
    localStringBuilder.append(this.selectStartTime);
    ((Collection)localObject2).add(localStringBuilder.toString());
    l = this.selectDuration;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("selectDuration=");
    localStringBuilder.append(this.selectDuration);
    ((Collection)localObject2).add(localStringBuilder.toString());
    l = this.fadeInDuration;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("fadeInDuration=");
    localStringBuilder.append(this.fadeInDuration);
    ((Collection)localObject2).add(localStringBuilder.toString());
    l = this.fadeOutDuration;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("fadeOutDuration=");
    localStringBuilder.append(this.fadeOutDuration);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if (this.lyricInfo != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("lyricInfo=");
      localStringBuilder.append(this.lyricInfo);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.type != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("type=");
      localStringBuilder.append(this.type);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((((Collection)this.waveSampleData).isEmpty() ^ true))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("waveSampleData=");
      localStringBuilder.append(this.waveSampleData);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"AudioModel{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.AudioModel
 * JD-Core Version:    0.7.0.1
 */