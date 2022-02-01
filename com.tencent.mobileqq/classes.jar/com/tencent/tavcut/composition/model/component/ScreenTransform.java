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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform$Builder;", "entityId", "", "componentID", "enabled", "", "type", "", "anchor", "Lcom/tencent/tavcut/composition/model/component/Rect;", "offset", "pivot", "Lcom/tencent/tavcut/composition/model/component/Vec2;", "ePinToEdge", "eFixSize", "eEditingMode", "eKeepRatio", "position", "Lcom/tencent/tavcut/composition/model/component/Vec3;", "rotation", "Lcom/tencent/tavcut/composition/model/component/Quat;", "scale", "euler", "objectEnabled", "version", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/Rect;Lcom/tencent/tavcut/composition/model/component/Rect;Lcom/tencent/tavcut/composition/model/component/Vec2;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/tencent/tavcut/composition/model/component/Vec3;Lcom/tencent/tavcut/composition/model/component/Quat;Lcom/tencent/tavcut/composition/model/component/Vec3;Lcom/tencent/tavcut/composition/model/component/Vec3;Ljava/lang/Boolean;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/Rect;Lcom/tencent/tavcut/composition/model/component/Rect;Lcom/tencent/tavcut/composition/model/component/Vec2;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/tencent/tavcut/composition/model/component/Vec3;Lcom/tencent/tavcut/composition/model/component/Quat;Lcom/tencent/tavcut/composition/model/component/Vec3;Lcom/tencent/tavcut/composition/model/component/Vec3;Ljava/lang/Boolean;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class ScreenTransform
  extends AndroidMessage<ScreenTransform, ScreenTransform.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<ScreenTransform> ADAPTER = (ProtoAdapter)new ScreenTransform.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ScreenTransform.class), "type.googleapis.com/publisher.ScreenTransform");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<ScreenTransform> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final ScreenTransform.Companion Companion = new ScreenTransform.Companion(null);
  public static final int DEFAULT_COMPONENTID = 0;
  public static final int DEFAULT_ENTITYID = 0;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.Rect#ADAPTER", tag=5)
  @JvmField
  @Nullable
  public final Rect anchor;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=2)
  @JvmField
  @Nullable
  public final Integer componentID;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=10)
  @JvmField
  @Nullable
  public final Integer eEditingMode;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=9)
  @JvmField
  @Nullable
  public final Integer eFixSize;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=11)
  @JvmField
  @Nullable
  public final Boolean eKeepRatio;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=8)
  @JvmField
  @Nullable
  public final Integer ePinToEdge;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=3)
  @JvmField
  @Nullable
  public final Boolean enabled;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=1)
  @JvmField
  @Nullable
  public final Integer entityId;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.Vec3#ADAPTER", tag=15)
  @JvmField
  @Nullable
  public final Vec3 euler;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=16)
  @JvmField
  @Nullable
  public final Boolean objectEnabled;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.Rect#ADAPTER", tag=6)
  @JvmField
  @Nullable
  public final Rect offset;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.Vec2#ADAPTER", tag=7)
  @JvmField
  @Nullable
  public final Vec2 pivot;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.Vec3#ADAPTER", tag=12)
  @JvmField
  @Nullable
  public final Vec3 position;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.Quat#ADAPTER", tag=13)
  @JvmField
  @Nullable
  public final Quat rotation;
  @WireField(adapter="com.tencent.tavcut.composition.model.component.Vec3#ADAPTER", tag=14)
  @JvmField
  @Nullable
  public final Vec3 scale;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=4)
  @JvmField
  @Nullable
  public final String type;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=17)
  @JvmField
  @Nullable
  public final Integer version;
  
  public ScreenTransform()
  {
    this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
  }
  
  public ScreenTransform(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Boolean paramBoolean1, @Nullable String paramString, @Nullable Rect paramRect1, @Nullable Rect paramRect2, @Nullable Vec2 paramVec2, @Nullable Integer paramInteger3, @Nullable Integer paramInteger4, @Nullable Integer paramInteger5, @Nullable Boolean paramBoolean2, @Nullable Vec3 paramVec31, @Nullable Quat paramQuat, @Nullable Vec3 paramVec32, @Nullable Vec3 paramVec33, @Nullable Boolean paramBoolean3, @Nullable Integer paramInteger6, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.entityId = paramInteger1;
    this.componentID = paramInteger2;
    this.enabled = paramBoolean1;
    this.type = paramString;
    this.anchor = paramRect1;
    this.offset = paramRect2;
    this.pivot = paramVec2;
    this.ePinToEdge = paramInteger3;
    this.eFixSize = paramInteger4;
    this.eEditingMode = paramInteger5;
    this.eKeepRatio = paramBoolean2;
    this.position = paramVec31;
    this.rotation = paramQuat;
    this.scale = paramVec32;
    this.euler = paramVec33;
    this.objectEnabled = paramBoolean3;
    this.version = paramInteger6;
  }
  
  @NotNull
  public final ScreenTransform copy(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Boolean paramBoolean1, @Nullable String paramString, @Nullable Rect paramRect1, @Nullable Rect paramRect2, @Nullable Vec2 paramVec2, @Nullable Integer paramInteger3, @Nullable Integer paramInteger4, @Nullable Integer paramInteger5, @Nullable Boolean paramBoolean2, @Nullable Vec3 paramVec31, @Nullable Quat paramQuat, @Nullable Vec3 paramVec32, @Nullable Vec3 paramVec33, @Nullable Boolean paramBoolean3, @Nullable Integer paramInteger6, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new ScreenTransform(paramInteger1, paramInteger2, paramBoolean1, paramString, paramRect1, paramRect2, paramVec2, paramInteger3, paramInteger4, paramInteger5, paramBoolean2, paramVec31, paramQuat, paramVec32, paramVec33, paramBoolean3, paramInteger6, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (ScreenTransform)this) {
      return true;
    }
    if (!(paramObject instanceof ScreenTransform)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (ScreenTransform)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.entityId, paramObject.entityId)) && (Intrinsics.areEqual(this.componentID, paramObject.componentID)) && (Intrinsics.areEqual(this.enabled, paramObject.enabled)) && (Intrinsics.areEqual(this.type, paramObject.type)) && (Intrinsics.areEqual(this.anchor, paramObject.anchor)) && (Intrinsics.areEqual(this.offset, paramObject.offset)) && (Intrinsics.areEqual(this.pivot, paramObject.pivot)) && (Intrinsics.areEqual(this.ePinToEdge, paramObject.ePinToEdge)) && (Intrinsics.areEqual(this.eFixSize, paramObject.eFixSize)) && (Intrinsics.areEqual(this.eEditingMode, paramObject.eEditingMode)) && (Intrinsics.areEqual(this.eKeepRatio, paramObject.eKeepRatio)) && (Intrinsics.areEqual(this.position, paramObject.position)) && (Intrinsics.areEqual(this.rotation, paramObject.rotation)) && (Intrinsics.areEqual(this.scale, paramObject.scale)) && (Intrinsics.areEqual(this.euler, paramObject.euler)) && (Intrinsics.areEqual(this.objectEnabled, paramObject.objectEnabled)) && (Intrinsics.areEqual(this.version, paramObject.version));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i13 = unknownFields().hashCode();
      Object localObject = this.entityId;
      int i12 = 0;
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
      localObject = this.anchor;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.offset;
      int i1;
      if (localObject != null) {
        i1 = localObject.hashCode();
      } else {
        i1 = 0;
      }
      localObject = this.pivot;
      int i2;
      if (localObject != null) {
        i2 = localObject.hashCode();
      } else {
        i2 = 0;
      }
      localObject = this.ePinToEdge;
      int i3;
      if (localObject != null) {
        i3 = localObject.hashCode();
      } else {
        i3 = 0;
      }
      localObject = this.eFixSize;
      int i4;
      if (localObject != null) {
        i4 = localObject.hashCode();
      } else {
        i4 = 0;
      }
      localObject = this.eEditingMode;
      int i5;
      if (localObject != null) {
        i5 = localObject.hashCode();
      } else {
        i5 = 0;
      }
      localObject = this.eKeepRatio;
      int i6;
      if (localObject != null) {
        i6 = localObject.hashCode();
      } else {
        i6 = 0;
      }
      localObject = this.position;
      int i7;
      if (localObject != null) {
        i7 = localObject.hashCode();
      } else {
        i7 = 0;
      }
      localObject = this.rotation;
      int i8;
      if (localObject != null) {
        i8 = localObject.hashCode();
      } else {
        i8 = 0;
      }
      localObject = this.scale;
      int i9;
      if (localObject != null) {
        i9 = localObject.hashCode();
      } else {
        i9 = 0;
      }
      localObject = this.euler;
      int i10;
      if (localObject != null) {
        i10 = localObject.hashCode();
      } else {
        i10 = 0;
      }
      localObject = this.objectEnabled;
      int i11;
      if (localObject != null) {
        i11 = localObject.hashCode();
      } else {
        i11 = 0;
      }
      localObject = this.version;
      if (localObject != null) {
        i12 = localObject.hashCode();
      }
      i = ((((((((((((((((i13 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n) * 37 + i1) * 37 + i2) * 37 + i3) * 37 + i4) * 37 + i5) * 37 + i6) * 37 + i7) * 37 + i8) * 37 + i9) * 37 + i10) * 37 + i11) * 37 + i12;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public ScreenTransform.Builder newBuilder()
  {
    ScreenTransform.Builder localBuilder = new ScreenTransform.Builder();
    localBuilder.entityId = this.entityId;
    localBuilder.componentID = this.componentID;
    localBuilder.enabled = this.enabled;
    localBuilder.type = this.type;
    localBuilder.anchor = this.anchor;
    localBuilder.offset = this.offset;
    localBuilder.pivot = this.pivot;
    localBuilder.ePinToEdge = this.ePinToEdge;
    localBuilder.eFixSize = this.eFixSize;
    localBuilder.eEditingMode = this.eEditingMode;
    localBuilder.eKeepRatio = this.eKeepRatio;
    localBuilder.position = this.position;
    localBuilder.rotation = this.rotation;
    localBuilder.scale = this.scale;
    localBuilder.euler = this.euler;
    localBuilder.objectEnabled = this.objectEnabled;
    localBuilder.version = this.version;
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
    if (this.anchor != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("anchor=");
      localStringBuilder.append(this.anchor);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.offset != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("offset=");
      localStringBuilder.append(this.offset);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.pivot != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pivot=");
      localStringBuilder.append(this.pivot);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.ePinToEdge != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ePinToEdge=");
      localStringBuilder.append(this.ePinToEdge);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.eFixSize != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("eFixSize=");
      localStringBuilder.append(this.eFixSize);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.eEditingMode != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("eEditingMode=");
      localStringBuilder.append(this.eEditingMode);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.eKeepRatio != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("eKeepRatio=");
      localStringBuilder.append(this.eKeepRatio);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.position != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("position=");
      localStringBuilder.append(this.position);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.rotation != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("rotation=");
      localStringBuilder.append(this.rotation);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.scale != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("scale=");
      localStringBuilder.append(this.scale);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.euler != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("euler=");
      localStringBuilder.append(this.euler);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.objectEnabled != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("objectEnabled=");
      localStringBuilder.append(this.objectEnabled);
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
    Object localObject2 = (CharSequence)"ScreenTransform{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.ScreenTransform
 * JD-Core Version:    0.7.0.1
 */