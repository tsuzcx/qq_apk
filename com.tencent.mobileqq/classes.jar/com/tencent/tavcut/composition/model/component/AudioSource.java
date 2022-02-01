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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/AudioSource;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/AudioSource$Builder;", "entityId", "", "componentID", "enabled", "", "type", "", "key", "speed", "", "version", "volume", "volumeEffects", "", "Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "audioSourceType", "src", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "Ljava/lang/Float;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/AudioSource;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class AudioSource
  extends AndroidMessage<AudioSource, AudioSource.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<AudioSource> ADAPTER = (ProtoAdapter)new AudioSource.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AudioSource.class), "type.googleapis.com/publisher.AudioSource");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<AudioSource> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final AudioSource.Companion Companion = new AudioSource.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=10)
  @JvmField
  @Nullable
  public final Integer audioSourceType;
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
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=5)
  @JvmField
  @Nullable
  public final String key;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=6)
  @JvmField
  @Nullable
  public final Float speed;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=11)
  @JvmField
  @Nullable
  public final String src;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=4)
  @JvmField
  @Nullable
  public final String type;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=7)
  @JvmField
  @Nullable
  public final Integer version;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=8)
  @JvmField
  @Nullable
  public final Float volume;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.VolumeEffect#ADAPTER", label=WireField.Label.REPEATED, tag=9)
  @JvmField
  @NotNull
  public final List<VolumeEffect> volumeEffects;
  
  public AudioSource()
  {
    this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
  }
  
  public AudioSource(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, @Nullable Float paramFloat1, @Nullable Integer paramInteger3, @Nullable Float paramFloat2, @NotNull List<VolumeEffect> paramList, @Nullable Integer paramInteger4, @Nullable String paramString3, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.entityId = paramInteger1;
    this.componentID = paramInteger2;
    this.enabled = paramBoolean;
    this.type = paramString1;
    this.key = paramString2;
    this.speed = paramFloat1;
    this.version = paramInteger3;
    this.volume = paramFloat2;
    this.volumeEffects = paramList;
    this.audioSourceType = paramInteger4;
    this.src = paramString3;
  }
  
  @NotNull
  public final AudioSource copy(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, @Nullable Float paramFloat1, @Nullable Integer paramInteger3, @Nullable Float paramFloat2, @NotNull List<VolumeEffect> paramList, @Nullable Integer paramInteger4, @Nullable String paramString3, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "volumeEffects");
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new AudioSource(paramInteger1, paramInteger2, paramBoolean, paramString1, paramString2, paramFloat1, paramInteger3, paramFloat2, paramList, paramInteger4, paramString3, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (AudioSource)this) {
      return true;
    }
    if (!(paramObject instanceof AudioSource)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (AudioSource)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.entityId, paramObject.entityId)) && (Intrinsics.areEqual(this.componentID, paramObject.componentID)) && (Intrinsics.areEqual(this.enabled, paramObject.enabled)) && (Intrinsics.areEqual(this.type, paramObject.type)) && (Intrinsics.areEqual(this.key, paramObject.key)) && (Intrinsics.areEqual(this.speed, paramObject.speed)) && (Intrinsics.areEqual(this.version, paramObject.version)) && (Intrinsics.areEqual(this.volume, paramObject.volume)) && (Intrinsics.areEqual(this.volumeEffects, paramObject.volumeEffects)) && (Intrinsics.areEqual(this.audioSourceType, paramObject.audioSourceType)) && (Intrinsics.areEqual(this.src, paramObject.src));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i6 = unknownFields().hashCode();
      Object localObject = this.entityId;
      int i5 = 0;
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
      localObject = this.key;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.speed;
      int i1;
      if (localObject != null) {
        i1 = localObject.hashCode();
      } else {
        i1 = 0;
      }
      localObject = this.version;
      int i2;
      if (localObject != null) {
        i2 = localObject.hashCode();
      } else {
        i2 = 0;
      }
      localObject = this.volume;
      int i3;
      if (localObject != null) {
        i3 = localObject.hashCode();
      } else {
        i3 = 0;
      }
      int i7 = this.volumeEffects.hashCode();
      localObject = this.audioSourceType;
      int i4;
      if (localObject != null) {
        i4 = localObject.hashCode();
      } else {
        i4 = 0;
      }
      localObject = this.src;
      if (localObject != null) {
        i5 = localObject.hashCode();
      }
      i = ((((((((((i6 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n) * 37 + i1) * 37 + i2) * 37 + i3) * 37 + i7) * 37 + i4) * 37 + i5;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public AudioSource.Builder newBuilder()
  {
    AudioSource.Builder localBuilder = new AudioSource.Builder();
    localBuilder.entityId = this.entityId;
    localBuilder.componentID = this.componentID;
    localBuilder.enabled = this.enabled;
    localBuilder.type = this.type;
    localBuilder.key = this.key;
    localBuilder.speed = this.speed;
    localBuilder.version = this.version;
    localBuilder.volume = this.volume;
    localBuilder.volumeEffects = this.volumeEffects;
    localBuilder.audioSourceType = this.audioSourceType;
    localBuilder.src = this.src;
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
    if (this.key != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key=");
      localStringBuilder.append(Internal.sanitize(this.key));
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
    if ((((Collection)this.volumeEffects).isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("volumeEffects=");
      localStringBuilder.append(this.volumeEffects);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.audioSourceType != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("audioSourceType=");
      localStringBuilder.append(this.audioSourceType);
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
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"AudioSource{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.AudioSource
 * JD-Core Version:    0.7.0.1
 */