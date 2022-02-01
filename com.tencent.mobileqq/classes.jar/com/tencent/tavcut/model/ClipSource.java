package com.tencent.tavcut.model;

import .r8.java8methods.utility.Long.hashCode.IJ;
import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.squareup.wire.WireField.Label;
import com.squareup.wire.internal.Internal;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/ClipSource;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/ClipSource$Builder;", "sourceId", "", "path", "type", "Lcom/tencent/tavcut/model/ClipSource$ClipType;", "duration", "", "speed", "", "volume", "startOffset", "matrix", "", "photoEffectPath", "transform", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "clipRect", "Lcom/tencent/tavcut/composition/model/component/Rect;", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/tavcut/model/ClipSource$ClipType;JLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/ScreenTransform;Lcom/tencent/tavcut/composition/model/component/Rect;Lokio/ByteString;)V", "matrix$annotations", "()V", "Ljava/lang/Float;", "Ljava/lang/Long;", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/tavcut/model/ClipSource$ClipType;JLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/ScreenTransform;Lcom/tencent/tavcut/composition/model/component/Rect;Lokio/ByteString;)Lcom/tencent/tavcut/model/ClipSource;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "ClipType", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class ClipSource
  extends AndroidMessage<ClipSource, ClipSource.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<ClipSource> ADAPTER = (ProtoAdapter)new ClipSource.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ClipSource.class), "type.googleapis.com/publisher.ClipSource");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<ClipSource> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final ClipSource.Companion Companion = new ClipSource.Companion(null);
  public static final float DEFAULT_SPEED = 1.0F;
  public static final float DEFAULT_VOLUME = 1.0F;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.Rect#ADAPTER", tag=11)
  @JvmField
  @Nullable
  public final Rect clipRect;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", label=WireField.Label.REQUIRED, tag=4)
  @JvmField
  public final long duration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REPEATED, tag=8)
  @JvmField
  @NotNull
  public final List<Float> matrix;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @Nullable
  public final String path;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=9)
  @JvmField
  @Nullable
  public final String photoEffectPath;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @Nullable
  public final String sourceId;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=5)
  @JvmField
  @Nullable
  public final Float speed;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=7)
  @JvmField
  @Nullable
  public final Long startOffset;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.ScreenTransform#ADAPTER", tag=10)
  @JvmField
  @Nullable
  public final ScreenTransform transform;
  @WireField(adapter="com.tencent.tavcut.model.ClipSource$ClipType#ADAPTER", tag=3)
  @JvmField
  @Nullable
  public final ClipSource.ClipType type;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=6)
  @JvmField
  @Nullable
  public final Float volume;
  
  public ClipSource(@Nullable String paramString1, @Nullable String paramString2, @Nullable ClipSource.ClipType paramClipType, long paramLong, @Nullable Float paramFloat1, @Nullable Float paramFloat2, @Nullable Long paramLong1, @NotNull List<Float> paramList, @Nullable String paramString3, @Nullable ScreenTransform paramScreenTransform, @Nullable Rect paramRect, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.sourceId = paramString1;
    this.path = paramString2;
    this.type = paramClipType;
    this.duration = paramLong;
    this.speed = paramFloat1;
    this.volume = paramFloat2;
    this.startOffset = paramLong1;
    this.matrix = paramList;
    this.photoEffectPath = paramString3;
    this.transform = paramScreenTransform;
    this.clipRect = paramRect;
  }
  
  @NotNull
  public final ClipSource copy(@Nullable String paramString1, @Nullable String paramString2, @Nullable ClipSource.ClipType paramClipType, long paramLong, @Nullable Float paramFloat1, @Nullable Float paramFloat2, @Nullable Long paramLong1, @NotNull List<Float> paramList, @Nullable String paramString3, @Nullable ScreenTransform paramScreenTransform, @Nullable Rect paramRect, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "matrix");
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new ClipSource(paramString1, paramString2, paramClipType, paramLong, paramFloat1, paramFloat2, paramLong1, paramList, paramString3, paramScreenTransform, paramRect, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (ClipSource)this) {
      return true;
    }
    if (!(paramObject instanceof ClipSource)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (ClipSource)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.sourceId, paramObject.sourceId)) && (Intrinsics.areEqual(this.path, paramObject.path)) && (this.type == paramObject.type) && (this.duration == paramObject.duration) && (Intrinsics.areEqual(this.speed, paramObject.speed)) && (Intrinsics.areEqual(this.volume, paramObject.volume)) && (Intrinsics.areEqual(this.startOffset, paramObject.startOffset)) && (Intrinsics.areEqual(this.matrix, paramObject.matrix)) && (Intrinsics.areEqual(this.photoEffectPath, paramObject.photoEffectPath)) && (Intrinsics.areEqual(this.transform, paramObject.transform)) && (Intrinsics.areEqual(this.clipRect, paramObject.clipRect));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i5 = unknownFields().hashCode();
      Object localObject = this.sourceId;
      int i4 = 0;
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
      localObject = this.type;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      int i6 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.duration);
      localObject = this.speed;
      int m;
      if (localObject != null) {
        m = localObject.hashCode();
      } else {
        m = 0;
      }
      localObject = this.volume;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.startOffset;
      int i1;
      if (localObject != null) {
        i1 = localObject.hashCode();
      } else {
        i1 = 0;
      }
      int i7 = this.matrix.hashCode();
      localObject = this.photoEffectPath;
      int i2;
      if (localObject != null) {
        i2 = localObject.hashCode();
      } else {
        i2 = 0;
      }
      localObject = this.transform;
      int i3;
      if (localObject != null) {
        i3 = localObject.hashCode();
      } else {
        i3 = 0;
      }
      localObject = this.clipRect;
      if (localObject != null) {
        i4 = localObject.hashCode();
      }
      i = ((((((((((i5 * 37 + i) * 37 + j) * 37 + k) * 37 + i6) * 37 + m) * 37 + n) * 37 + i1) * 37 + i7) * 37 + i2) * 37 + i3) * 37 + i4;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public ClipSource.Builder newBuilder()
  {
    ClipSource.Builder localBuilder = new ClipSource.Builder();
    localBuilder.sourceId = this.sourceId;
    localBuilder.path = this.path;
    localBuilder.type = this.type;
    localBuilder.duration = Long.valueOf(this.duration);
    localBuilder.speed = this.speed;
    localBuilder.volume = this.volume;
    localBuilder.startOffset = this.startOffset;
    localBuilder.matrix = this.matrix;
    localBuilder.photoEffectPath = this.photoEffectPath;
    localBuilder.transform = this.transform;
    localBuilder.clipRect = this.clipRect;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    if (this.sourceId != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sourceId=");
      localStringBuilder.append(Internal.sanitize(this.sourceId));
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
    if (this.type != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("type=");
      localStringBuilder.append(this.type);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("duration=");
    localStringBuilder.append(this.duration);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if (this.speed != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("speed=");
      localStringBuilder.append(this.speed);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.volume != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("volume=");
      localStringBuilder.append(this.volume);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.startOffset != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startOffset=");
      localStringBuilder.append(this.startOffset);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((((Collection)this.matrix).isEmpty() ^ true))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("matrix=");
      localStringBuilder.append(this.matrix);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.photoEffectPath != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("photoEffectPath=");
      localStringBuilder.append(Internal.sanitize(this.photoEffectPath));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.transform != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("transform=");
      localStringBuilder.append(this.transform);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.clipRect != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("clipRect=");
      localStringBuilder.append(this.clipRect);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"ClipSource{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.ClipSource
 * JD-Core Version:    0.7.0.1
 */