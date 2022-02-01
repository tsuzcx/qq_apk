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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/PostEffect;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/PostEffect$Builder;", "entityId", "", "componentID", "enabled", "", "type", "", "effectType", "sharpness", "brightness", "contrast", "hue", "highlights", "shadows", "saturation", "temperature", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/PostEffect;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class PostEffect
  extends AndroidMessage<PostEffect, PostEffect.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<PostEffect> ADAPTER = (ProtoAdapter)new PostEffect.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PostEffect.class), "type.googleapis.com/publisher.PostEffect");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<PostEffect> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final PostEffect.Companion Companion = new PostEffect.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=7)
  @JvmField
  @Nullable
  public final Integer brightness;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=2)
  @JvmField
  @Nullable
  public final Integer componentID;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=8)
  @JvmField
  @Nullable
  public final Integer contrast;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=5)
  @JvmField
  @Nullable
  public final String effectType;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=3)
  @JvmField
  @Nullable
  public final Boolean enabled;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=1)
  @JvmField
  @Nullable
  public final Integer entityId;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=10)
  @JvmField
  @Nullable
  public final Integer highlights;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=9)
  @JvmField
  @Nullable
  public final Integer hue;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=12)
  @JvmField
  @Nullable
  public final Integer saturation;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=11)
  @JvmField
  @Nullable
  public final Integer shadows;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=6)
  @JvmField
  @Nullable
  public final Integer sharpness;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=13)
  @JvmField
  @Nullable
  public final Integer temperature;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=4)
  @JvmField
  @Nullable
  public final String type;
  
  public PostEffect()
  {
    this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
  }
  
  public PostEffect(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, @Nullable Integer paramInteger3, @Nullable Integer paramInteger4, @Nullable Integer paramInteger5, @Nullable Integer paramInteger6, @Nullable Integer paramInteger7, @Nullable Integer paramInteger8, @Nullable Integer paramInteger9, @Nullable Integer paramInteger10, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.entityId = paramInteger1;
    this.componentID = paramInteger2;
    this.enabled = paramBoolean;
    this.type = paramString1;
    this.effectType = paramString2;
    this.sharpness = paramInteger3;
    this.brightness = paramInteger4;
    this.contrast = paramInteger5;
    this.hue = paramInteger6;
    this.highlights = paramInteger7;
    this.shadows = paramInteger8;
    this.saturation = paramInteger9;
    this.temperature = paramInteger10;
  }
  
  @NotNull
  public final PostEffect copy(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, @Nullable Integer paramInteger3, @Nullable Integer paramInteger4, @Nullable Integer paramInteger5, @Nullable Integer paramInteger6, @Nullable Integer paramInteger7, @Nullable Integer paramInteger8, @Nullable Integer paramInteger9, @Nullable Integer paramInteger10, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new PostEffect(paramInteger1, paramInteger2, paramBoolean, paramString1, paramString2, paramInteger3, paramInteger4, paramInteger5, paramInteger6, paramInteger7, paramInteger8, paramInteger9, paramInteger10, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (PostEffect)this) {
      return true;
    }
    if (!(paramObject instanceof PostEffect)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (PostEffect)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.entityId, paramObject.entityId)) && (Intrinsics.areEqual(this.componentID, paramObject.componentID)) && (Intrinsics.areEqual(this.enabled, paramObject.enabled)) && (Intrinsics.areEqual(this.type, paramObject.type)) && (Intrinsics.areEqual(this.effectType, paramObject.effectType)) && (Intrinsics.areEqual(this.sharpness, paramObject.sharpness)) && (Intrinsics.areEqual(this.brightness, paramObject.brightness)) && (Intrinsics.areEqual(this.contrast, paramObject.contrast)) && (Intrinsics.areEqual(this.hue, paramObject.hue)) && (Intrinsics.areEqual(this.highlights, paramObject.highlights)) && (Intrinsics.areEqual(this.shadows, paramObject.shadows)) && (Intrinsics.areEqual(this.saturation, paramObject.saturation)) && (Intrinsics.areEqual(this.temperature, paramObject.temperature));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i9 = unknownFields().hashCode();
      Object localObject = this.entityId;
      int i8 = 0;
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
      localObject = this.effectType;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.sharpness;
      int i1;
      if (localObject != null) {
        i1 = localObject.hashCode();
      } else {
        i1 = 0;
      }
      localObject = this.brightness;
      int i2;
      if (localObject != null) {
        i2 = localObject.hashCode();
      } else {
        i2 = 0;
      }
      localObject = this.contrast;
      int i3;
      if (localObject != null) {
        i3 = localObject.hashCode();
      } else {
        i3 = 0;
      }
      localObject = this.hue;
      int i4;
      if (localObject != null) {
        i4 = localObject.hashCode();
      } else {
        i4 = 0;
      }
      localObject = this.highlights;
      int i5;
      if (localObject != null) {
        i5 = localObject.hashCode();
      } else {
        i5 = 0;
      }
      localObject = this.shadows;
      int i6;
      if (localObject != null) {
        i6 = localObject.hashCode();
      } else {
        i6 = 0;
      }
      localObject = this.saturation;
      int i7;
      if (localObject != null) {
        i7 = localObject.hashCode();
      } else {
        i7 = 0;
      }
      localObject = this.temperature;
      if (localObject != null) {
        i8 = localObject.hashCode();
      }
      i = ((((((((((((i9 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n) * 37 + i1) * 37 + i2) * 37 + i3) * 37 + i4) * 37 + i5) * 37 + i6) * 37 + i7) * 37 + i8;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public PostEffect.Builder newBuilder()
  {
    PostEffect.Builder localBuilder = new PostEffect.Builder();
    localBuilder.entityId = this.entityId;
    localBuilder.componentID = this.componentID;
    localBuilder.enabled = this.enabled;
    localBuilder.type = this.type;
    localBuilder.effectType = this.effectType;
    localBuilder.sharpness = this.sharpness;
    localBuilder.brightness = this.brightness;
    localBuilder.contrast = this.contrast;
    localBuilder.hue = this.hue;
    localBuilder.highlights = this.highlights;
    localBuilder.shadows = this.shadows;
    localBuilder.saturation = this.saturation;
    localBuilder.temperature = this.temperature;
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
    if (this.effectType != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("effectType=");
      localStringBuilder.append(Internal.sanitize(this.effectType));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.sharpness != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sharpness=");
      localStringBuilder.append(this.sharpness);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.brightness != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("brightness=");
      localStringBuilder.append(this.brightness);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.contrast != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("contrast=");
      localStringBuilder.append(this.contrast);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.hue != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("hue=");
      localStringBuilder.append(this.hue);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.highlights != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("highlights=");
      localStringBuilder.append(this.highlights);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.shadows != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("shadows=");
      localStringBuilder.append(this.shadows);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.saturation != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saturation=");
      localStringBuilder.append(this.saturation);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.temperature != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("temperature=");
      localStringBuilder.append(this.temperature);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"PostEffect{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.PostEffect
 * JD-Core Version:    0.7.0.1
 */