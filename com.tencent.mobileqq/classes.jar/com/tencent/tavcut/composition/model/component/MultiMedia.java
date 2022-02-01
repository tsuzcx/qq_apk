package com.tencent.tavcut.composition.model.component;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/MultiMedia;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/MultiMedia$Builder;", "entityId", "", "componentID", "enabled", "", "type", "", "fillScale", "", "imageDurations", "Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration;", "imageEffect", "key", "maxSourceCount", "minDuration", "minSourceCount", "scaleMode", "size", "Lcom/tencent/tavcut/composition/model/component/Size;", "speed", "src", "version", "volume", "backgroundColor", "backgroundFillMode", "volumeEffects", "", "Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "backgroundPagPath", "resLoopCount", "visibleWhileOverTime", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/tavcut/composition/model/component/Size;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "Ljava/lang/Float;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/tavcut/composition/model/component/Size;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/MultiMedia;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "ImageDuration", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class MultiMedia
  extends AndroidMessage<MultiMedia, MultiMedia.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<MultiMedia> ADAPTER = (ProtoAdapter)new MultiMedia.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MultiMedia.class), "type.googleapis.com/publisher.MultiMedia");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<MultiMedia> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final MultiMedia.Companion Companion = new MultiMedia.Companion(null);
  public static final int DEFAULT_BACKGROUNDFILLMODE = 1;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=18)
  @JvmField
  @Nullable
  public final String backgroundColor;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=19)
  @JvmField
  @Nullable
  public final Integer backgroundFillMode;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=21)
  @JvmField
  @Nullable
  public final String backgroundPagPath;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=2)
  @JvmField
  @Nullable
  public final Integer componentID;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=3)
  @JvmField
  @Nullable
  public final Boolean enabled;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=1)
  @JvmField
  @Nullable
  public final Integer entityId;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=5)
  @JvmField
  @Nullable
  public final Float fillScale;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.MultiMedia$ImageDuration#ADAPTER", tag=6)
  @JvmField
  @Nullable
  public final MultiMedia.ImageDuration imageDurations;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=7)
  @JvmField
  @Nullable
  public final Boolean imageEffect;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=8)
  @JvmField
  @Nullable
  public final String key;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=9)
  @JvmField
  @Nullable
  public final Integer maxSourceCount;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=10)
  @JvmField
  @Nullable
  public final Integer minDuration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=11)
  @JvmField
  @Nullable
  public final Integer minSourceCount;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=22)
  @JvmField
  @Nullable
  public final Integer resLoopCount;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=12)
  @JvmField
  @Nullable
  public final Integer scaleMode;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.Size#ADAPTER", tag=13)
  @JvmField
  @Nullable
  public final Size size;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=14)
  @JvmField
  @Nullable
  public final Float speed;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=15)
  @JvmField
  @Nullable
  public final String src;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=4)
  @JvmField
  @Nullable
  public final String type;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=16)
  @JvmField
  @Nullable
  public final Integer version;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=23)
  @JvmField
  @Nullable
  public final Boolean visibleWhileOverTime;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=17)
  @JvmField
  @Nullable
  public final Float volume;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.VolumeEffect#ADAPTER", label=WireField.Label.REPEATED, tag=20)
  @JvmField
  @NotNull
  public final List<VolumeEffect> volumeEffects;
  
  public MultiMedia()
  {
    this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777215, null);
  }
  
  public MultiMedia(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Boolean paramBoolean1, @Nullable String paramString1, @Nullable Float paramFloat1, @Nullable MultiMedia.ImageDuration paramImageDuration, @Nullable Boolean paramBoolean2, @Nullable String paramString2, @Nullable Integer paramInteger3, @Nullable Integer paramInteger4, @Nullable Integer paramInteger5, @Nullable Integer paramInteger6, @Nullable Size paramSize, @Nullable Float paramFloat2, @Nullable String paramString3, @Nullable Integer paramInteger7, @Nullable Float paramFloat3, @Nullable String paramString4, @Nullable Integer paramInteger8, @NotNull List<VolumeEffect> paramList, @Nullable String paramString5, @Nullable Integer paramInteger9, @Nullable Boolean paramBoolean3, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.entityId = paramInteger1;
    this.componentID = paramInteger2;
    this.enabled = paramBoolean1;
    this.type = paramString1;
    this.fillScale = paramFloat1;
    this.imageDurations = paramImageDuration;
    this.imageEffect = paramBoolean2;
    this.key = paramString2;
    this.maxSourceCount = paramInteger3;
    this.minDuration = paramInteger4;
    this.minSourceCount = paramInteger5;
    this.scaleMode = paramInteger6;
    this.size = paramSize;
    this.speed = paramFloat2;
    this.src = paramString3;
    this.version = paramInteger7;
    this.volume = paramFloat3;
    this.backgroundColor = paramString4;
    this.backgroundFillMode = paramInteger8;
    this.volumeEffects = paramList;
    this.backgroundPagPath = paramString5;
    this.resLoopCount = paramInteger9;
    this.visibleWhileOverTime = paramBoolean3;
  }
  
  @NotNull
  public final MultiMedia copy(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Boolean paramBoolean1, @Nullable String paramString1, @Nullable Float paramFloat1, @Nullable MultiMedia.ImageDuration paramImageDuration, @Nullable Boolean paramBoolean2, @Nullable String paramString2, @Nullable Integer paramInteger3, @Nullable Integer paramInteger4, @Nullable Integer paramInteger5, @Nullable Integer paramInteger6, @Nullable Size paramSize, @Nullable Float paramFloat2, @Nullable String paramString3, @Nullable Integer paramInteger7, @Nullable Float paramFloat3, @Nullable String paramString4, @Nullable Integer paramInteger8, @NotNull List<VolumeEffect> paramList, @Nullable String paramString5, @Nullable Integer paramInteger9, @Nullable Boolean paramBoolean3, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "volumeEffects");
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new MultiMedia(paramInteger1, paramInteger2, paramBoolean1, paramString1, paramFloat1, paramImageDuration, paramBoolean2, paramString2, paramInteger3, paramInteger4, paramInteger5, paramInteger6, paramSize, paramFloat2, paramString3, paramInteger7, paramFloat3, paramString4, paramInteger8, paramList, paramString5, paramInteger9, paramBoolean3, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (MultiMedia)this) {
      return true;
    }
    if (!(paramObject instanceof MultiMedia)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (MultiMedia)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.entityId, paramObject.entityId)) && (Intrinsics.areEqual(this.componentID, paramObject.componentID)) && (Intrinsics.areEqual(this.enabled, paramObject.enabled)) && (Intrinsics.areEqual(this.type, paramObject.type)) && (Intrinsics.areEqual(this.fillScale, paramObject.fillScale)) && (Intrinsics.areEqual(this.imageDurations, paramObject.imageDurations)) && (Intrinsics.areEqual(this.imageEffect, paramObject.imageEffect)) && (Intrinsics.areEqual(this.key, paramObject.key)) && (Intrinsics.areEqual(this.maxSourceCount, paramObject.maxSourceCount)) && (Intrinsics.areEqual(this.minDuration, paramObject.minDuration)) && (Intrinsics.areEqual(this.minSourceCount, paramObject.minSourceCount)) && (Intrinsics.areEqual(this.scaleMode, paramObject.scaleMode)) && (Intrinsics.areEqual(this.size, paramObject.size)) && (Intrinsics.areEqual(this.speed, paramObject.speed)) && (Intrinsics.areEqual(this.src, paramObject.src)) && (Intrinsics.areEqual(this.version, paramObject.version)) && (Intrinsics.areEqual(this.volume, paramObject.volume)) && (Intrinsics.areEqual(this.backgroundColor, paramObject.backgroundColor)) && (Intrinsics.areEqual(this.backgroundFillMode, paramObject.backgroundFillMode)) && (Intrinsics.areEqual(this.volumeEffects, paramObject.volumeEffects)) && (Intrinsics.areEqual(this.backgroundPagPath, paramObject.backgroundPagPath)) && (Intrinsics.areEqual(this.resLoopCount, paramObject.resLoopCount)) && (Intrinsics.areEqual(this.visibleWhileOverTime, paramObject.visibleWhileOverTime));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i18 = unknownFields().hashCode();
      Object localObject = this.entityId;
      int i17 = 0;
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
      localObject = this.fillScale;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.imageDurations;
      int i1;
      if (localObject != null) {
        i1 = localObject.hashCode();
      } else {
        i1 = 0;
      }
      localObject = this.imageEffect;
      int i2;
      if (localObject != null) {
        i2 = localObject.hashCode();
      } else {
        i2 = 0;
      }
      localObject = this.key;
      int i3;
      if (localObject != null) {
        i3 = localObject.hashCode();
      } else {
        i3 = 0;
      }
      localObject = this.maxSourceCount;
      int i4;
      if (localObject != null) {
        i4 = localObject.hashCode();
      } else {
        i4 = 0;
      }
      localObject = this.minDuration;
      int i5;
      if (localObject != null) {
        i5 = localObject.hashCode();
      } else {
        i5 = 0;
      }
      localObject = this.minSourceCount;
      int i6;
      if (localObject != null) {
        i6 = localObject.hashCode();
      } else {
        i6 = 0;
      }
      localObject = this.scaleMode;
      int i7;
      if (localObject != null) {
        i7 = localObject.hashCode();
      } else {
        i7 = 0;
      }
      localObject = this.size;
      int i8;
      if (localObject != null) {
        i8 = localObject.hashCode();
      } else {
        i8 = 0;
      }
      localObject = this.speed;
      int i9;
      if (localObject != null) {
        i9 = localObject.hashCode();
      } else {
        i9 = 0;
      }
      localObject = this.src;
      int i10;
      if (localObject != null) {
        i10 = localObject.hashCode();
      } else {
        i10 = 0;
      }
      localObject = this.version;
      int i11;
      if (localObject != null) {
        i11 = localObject.hashCode();
      } else {
        i11 = 0;
      }
      localObject = this.volume;
      int i12;
      if (localObject != null) {
        i12 = localObject.hashCode();
      } else {
        i12 = 0;
      }
      localObject = this.backgroundColor;
      int i13;
      if (localObject != null) {
        i13 = localObject.hashCode();
      } else {
        i13 = 0;
      }
      localObject = this.backgroundFillMode;
      int i14;
      if (localObject != null) {
        i14 = localObject.hashCode();
      } else {
        i14 = 0;
      }
      int i19 = this.volumeEffects.hashCode();
      localObject = this.backgroundPagPath;
      int i15;
      if (localObject != null) {
        i15 = localObject.hashCode();
      } else {
        i15 = 0;
      }
      localObject = this.resLoopCount;
      int i16;
      if (localObject != null) {
        i16 = localObject.hashCode();
      } else {
        i16 = 0;
      }
      localObject = this.visibleWhileOverTime;
      if (localObject != null) {
        i17 = localObject.hashCode();
      }
      i = ((((((((((((((((((((((i18 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n) * 37 + i1) * 37 + i2) * 37 + i3) * 37 + i4) * 37 + i5) * 37 + i6) * 37 + i7) * 37 + i8) * 37 + i9) * 37 + i10) * 37 + i11) * 37 + i12) * 37 + i13) * 37 + i14) * 37 + i19) * 37 + i15) * 37 + i16) * 37 + i17;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public MultiMedia.Builder newBuilder()
  {
    MultiMedia.Builder localBuilder = new MultiMedia.Builder();
    localBuilder.entityId = this.entityId;
    localBuilder.componentID = this.componentID;
    localBuilder.enabled = this.enabled;
    localBuilder.type = this.type;
    localBuilder.fillScale = this.fillScale;
    localBuilder.imageDurations = this.imageDurations;
    localBuilder.imageEffect = this.imageEffect;
    localBuilder.key = this.key;
    localBuilder.maxSourceCount = this.maxSourceCount;
    localBuilder.minDuration = this.minDuration;
    localBuilder.minSourceCount = this.minSourceCount;
    localBuilder.scaleMode = this.scaleMode;
    localBuilder.size = this.size;
    localBuilder.speed = this.speed;
    localBuilder.src = this.src;
    localBuilder.version = this.version;
    localBuilder.volume = this.volume;
    localBuilder.backgroundColor = this.backgroundColor;
    localBuilder.backgroundFillMode = this.backgroundFillMode;
    localBuilder.volumeEffects = this.volumeEffects;
    localBuilder.backgroundPagPath = this.backgroundPagPath;
    localBuilder.resLoopCount = this.resLoopCount;
    localBuilder.visibleWhileOverTime = this.visibleWhileOverTime;
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
    if (this.fillScale != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fillScale=");
      localStringBuilder.append(this.fillScale);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.imageDurations != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("imageDurations=");
      localStringBuilder.append(this.imageDurations);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.imageEffect != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("imageEffect=");
      localStringBuilder.append(this.imageEffect);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.key != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key=");
      localStringBuilder.append(Internal.sanitize(this.key));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.maxSourceCount != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("maxSourceCount=");
      localStringBuilder.append(this.maxSourceCount);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.minDuration != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("minDuration=");
      localStringBuilder.append(this.minDuration);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.minSourceCount != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("minSourceCount=");
      localStringBuilder.append(this.minSourceCount);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.scaleMode != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("scaleMode=");
      localStringBuilder.append(this.scaleMode);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.size != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("size=");
      localStringBuilder.append(this.size);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.speed != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("speed=");
      localStringBuilder.append(this.speed);
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
    if (this.version != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("version=");
      localStringBuilder.append(this.version);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.volume != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("volume=");
      localStringBuilder.append(this.volume);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.backgroundColor != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("backgroundColor=");
      localStringBuilder.append(Internal.sanitize(this.backgroundColor));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.backgroundFillMode != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("backgroundFillMode=");
      localStringBuilder.append(this.backgroundFillMode);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((((Collection)this.volumeEffects).isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("volumeEffects=");
      localStringBuilder.append(this.volumeEffects);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.backgroundPagPath != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("backgroundPagPath=");
      localStringBuilder.append(Internal.sanitize(this.backgroundPagPath));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.resLoopCount != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("resLoopCount=");
      localStringBuilder.append(this.resLoopCount);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.visibleWhileOverTime != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("visibleWhileOverTime=");
      localStringBuilder.append(this.visibleWhileOverTime);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"MultiMedia{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.MultiMedia
 * JD-Core Version:    0.7.0.1
 */