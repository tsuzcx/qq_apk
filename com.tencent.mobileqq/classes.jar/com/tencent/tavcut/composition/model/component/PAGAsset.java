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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/PAGAsset;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Builder;", "entityId", "", "componentID", "enabled", "", "type", "", "musicID", "src", "usage", "version", "replacement", "", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", "scaleMode", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/PAGAsset;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "PagScaleMode", "Replacement", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class PAGAsset
  extends AndroidMessage<PAGAsset, PAGAsset.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<PAGAsset> ADAPTER = (ProtoAdapter)new PAGAsset.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PAGAsset.class), "type.googleapis.com/publisher.PAGAsset");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<PAGAsset> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final PAGAsset.Companion Companion = new PAGAsset.Companion(null);
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
  public final String musicID;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.PAGAsset$Replacement#ADAPTER", label=WireField.Label.REPEATED, tag=9)
  @JvmField
  @NotNull
  public final List<PAGAsset.Replacement> replacement;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=10)
  @JvmField
  @Nullable
  public final Integer scaleMode;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=6)
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
  public final Integer usage;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=8)
  @JvmField
  @Nullable
  public final Integer version;
  
  public PAGAsset()
  {
    this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
  }
  
  public PAGAsset(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable Integer paramInteger3, @Nullable Integer paramInteger4, @NotNull List<PAGAsset.Replacement> paramList, @Nullable Integer paramInteger5, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.entityId = paramInteger1;
    this.componentID = paramInteger2;
    this.enabled = paramBoolean;
    this.type = paramString1;
    this.musicID = paramString2;
    this.src = paramString3;
    this.usage = paramInteger3;
    this.version = paramInteger4;
    this.replacement = paramList;
    this.scaleMode = paramInteger5;
  }
  
  @NotNull
  public final PAGAsset copy(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable Integer paramInteger3, @Nullable Integer paramInteger4, @NotNull List<PAGAsset.Replacement> paramList, @Nullable Integer paramInteger5, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "replacement");
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new PAGAsset(paramInteger1, paramInteger2, paramBoolean, paramString1, paramString2, paramString3, paramInteger3, paramInteger4, paramList, paramInteger5, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (PAGAsset)this) {
      return true;
    }
    if (!(paramObject instanceof PAGAsset)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (PAGAsset)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.entityId, paramObject.entityId)) && (Intrinsics.areEqual(this.componentID, paramObject.componentID)) && (Intrinsics.areEqual(this.enabled, paramObject.enabled)) && (Intrinsics.areEqual(this.type, paramObject.type)) && (Intrinsics.areEqual(this.musicID, paramObject.musicID)) && (Intrinsics.areEqual(this.src, paramObject.src)) && (Intrinsics.areEqual(this.usage, paramObject.usage)) && (Intrinsics.areEqual(this.version, paramObject.version)) && (Intrinsics.areEqual(this.replacement, paramObject.replacement)) && (Intrinsics.areEqual(this.scaleMode, paramObject.scaleMode));
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
      localObject = this.musicID;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.src;
      int i1;
      if (localObject != null) {
        i1 = localObject.hashCode();
      } else {
        i1 = 0;
      }
      localObject = this.usage;
      int i2;
      if (localObject != null) {
        i2 = localObject.hashCode();
      } else {
        i2 = 0;
      }
      localObject = this.version;
      int i3;
      if (localObject != null) {
        i3 = localObject.hashCode();
      } else {
        i3 = 0;
      }
      int i6 = this.replacement.hashCode();
      localObject = this.scaleMode;
      if (localObject != null) {
        i4 = localObject.hashCode();
      }
      i = (((((((((i5 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n) * 37 + i1) * 37 + i2) * 37 + i3) * 37 + i6) * 37 + i4;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public PAGAsset.Builder newBuilder()
  {
    PAGAsset.Builder localBuilder = new PAGAsset.Builder();
    localBuilder.entityId = this.entityId;
    localBuilder.componentID = this.componentID;
    localBuilder.enabled = this.enabled;
    localBuilder.type = this.type;
    localBuilder.musicID = this.musicID;
    localBuilder.src = this.src;
    localBuilder.usage = this.usage;
    localBuilder.version = this.version;
    localBuilder.replacement = this.replacement;
    localBuilder.scaleMode = this.scaleMode;
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
    if (this.musicID != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("musicID=");
      localStringBuilder.append(Internal.sanitize(this.musicID));
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
    if (this.usage != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("usage=");
      localStringBuilder.append(this.usage);
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
    if ((((Collection)this.replacement).isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("replacement=");
      localStringBuilder.append(this.replacement);
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
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"PAGAsset{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.PAGAsset
 * JD-Core Version:    0.7.0.1
 */