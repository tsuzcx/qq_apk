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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/Image;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/Image$Builder;", "componentID", "", "enabled", "", "entityId", "scaleMode", "src", "", "type", "duration", "", "version", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Long;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/Image;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Image
  extends AndroidMessage<Image, Image.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<Image> ADAPTER = (ProtoAdapter)new Image.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Image.class), "type.googleapis.com/publisher.Image");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<Image> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final Image.Companion Companion = new Image.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=1)
  @JvmField
  @Nullable
  public final Integer componentID;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=7)
  @JvmField
  @Nullable
  public final Long duration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=2)
  @JvmField
  @Nullable
  public final Boolean enabled;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=3)
  @JvmField
  @Nullable
  public final Integer entityId;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=4)
  @JvmField
  @Nullable
  public final Integer scaleMode;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=5)
  @JvmField
  @Nullable
  public final String src;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=6)
  @JvmField
  @Nullable
  public final String type;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=8)
  @JvmField
  @Nullable
  public final Integer version;
  
  public Image()
  {
    this(null, null, null, null, null, null, null, null, null, 511, null);
  }
  
  public Image(@Nullable Integer paramInteger1, @Nullable Boolean paramBoolean, @Nullable Integer paramInteger2, @Nullable Integer paramInteger3, @Nullable String paramString1, @Nullable String paramString2, @Nullable Long paramLong, @Nullable Integer paramInteger4, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.componentID = paramInteger1;
    this.enabled = paramBoolean;
    this.entityId = paramInteger2;
    this.scaleMode = paramInteger3;
    this.src = paramString1;
    this.type = paramString2;
    this.duration = paramLong;
    this.version = paramInteger4;
  }
  
  @NotNull
  public final Image copy(@Nullable Integer paramInteger1, @Nullable Boolean paramBoolean, @Nullable Integer paramInteger2, @Nullable Integer paramInteger3, @Nullable String paramString1, @Nullable String paramString2, @Nullable Long paramLong, @Nullable Integer paramInteger4, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new Image(paramInteger1, paramBoolean, paramInteger2, paramInteger3, paramString1, paramString2, paramLong, paramInteger4, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (Image)this) {
      return true;
    }
    if (!(paramObject instanceof Image)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (Image)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.componentID, paramObject.componentID)) && (Intrinsics.areEqual(this.enabled, paramObject.enabled)) && (Intrinsics.areEqual(this.entityId, paramObject.entityId)) && (Intrinsics.areEqual(this.scaleMode, paramObject.scaleMode)) && (Intrinsics.areEqual(this.src, paramObject.src)) && (Intrinsics.areEqual(this.type, paramObject.type)) && (Intrinsics.areEqual(this.duration, paramObject.duration)) && (Intrinsics.areEqual(this.version, paramObject.version));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i4 = unknownFields().hashCode();
      Object localObject = this.componentID;
      int i3 = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.enabled;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.entityId;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      localObject = this.scaleMode;
      int m;
      if (localObject != null) {
        m = localObject.hashCode();
      } else {
        m = 0;
      }
      localObject = this.src;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.type;
      int i1;
      if (localObject != null) {
        i1 = localObject.hashCode();
      } else {
        i1 = 0;
      }
      localObject = this.duration;
      int i2;
      if (localObject != null) {
        i2 = localObject.hashCode();
      } else {
        i2 = 0;
      }
      localObject = this.version;
      if (localObject != null) {
        i3 = localObject.hashCode();
      }
      i = (((((((i4 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n) * 37 + i1) * 37 + i2) * 37 + i3;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public Image.Builder newBuilder()
  {
    Image.Builder localBuilder = new Image.Builder();
    localBuilder.componentID = this.componentID;
    localBuilder.enabled = this.enabled;
    localBuilder.entityId = this.entityId;
    localBuilder.scaleMode = this.scaleMode;
    localBuilder.src = this.src;
    localBuilder.type = this.type;
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
    if (this.entityId != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("entityId=");
      localStringBuilder.append(this.entityId);
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
    if (this.src != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("src=");
      localStringBuilder.append(Internal.sanitize(this.src));
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
    Object localObject2 = (CharSequence)"Image{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Image
 * JD-Core Version:    0.7.0.1
 */