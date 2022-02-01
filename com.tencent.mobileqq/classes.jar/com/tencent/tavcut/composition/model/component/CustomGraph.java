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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/CustomGraph;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/CustomGraph$Builder;", "componentID", "", "enabled", "", "entityId", "resourcePath", "", "type", "version", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/CustomGraph;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class CustomGraph
  extends AndroidMessage<CustomGraph, CustomGraph.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<CustomGraph> ADAPTER = (ProtoAdapter)new CustomGraph.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CustomGraph.class), "type.googleapis.com/publisher.CustomGraph");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<CustomGraph> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final CustomGraph.Companion Companion = new CustomGraph.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=1)
  @JvmField
  @Nullable
  public final Integer componentID;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=2)
  @JvmField
  @Nullable
  public final Boolean enabled;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=3)
  @JvmField
  @Nullable
  public final Integer entityId;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=4)
  @JvmField
  @Nullable
  public final String resourcePath;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=5)
  @JvmField
  @Nullable
  public final String type;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=6)
  @JvmField
  @Nullable
  public final Integer version;
  
  public CustomGraph()
  {
    this(null, null, null, null, null, null, null, 127, null);
  }
  
  public CustomGraph(@Nullable Integer paramInteger1, @Nullable Boolean paramBoolean, @Nullable Integer paramInteger2, @Nullable String paramString1, @Nullable String paramString2, @Nullable Integer paramInteger3, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.componentID = paramInteger1;
    this.enabled = paramBoolean;
    this.entityId = paramInteger2;
    this.resourcePath = paramString1;
    this.type = paramString2;
    this.version = paramInteger3;
  }
  
  @NotNull
  public final CustomGraph copy(@Nullable Integer paramInteger1, @Nullable Boolean paramBoolean, @Nullable Integer paramInteger2, @Nullable String paramString1, @Nullable String paramString2, @Nullable Integer paramInteger3, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new CustomGraph(paramInteger1, paramBoolean, paramInteger2, paramString1, paramString2, paramInteger3, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (CustomGraph)this) {
      return true;
    }
    if (!(paramObject instanceof CustomGraph)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (CustomGraph)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.componentID, paramObject.componentID)) && (Intrinsics.areEqual(this.enabled, paramObject.enabled)) && (Intrinsics.areEqual(this.entityId, paramObject.entityId)) && (Intrinsics.areEqual(this.resourcePath, paramObject.resourcePath)) && (Intrinsics.areEqual(this.type, paramObject.type)) && (Intrinsics.areEqual(this.version, paramObject.version));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i2 = unknownFields().hashCode();
      Object localObject = this.componentID;
      int i1 = 0;
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
      localObject = this.resourcePath;
      int m;
      if (localObject != null) {
        m = localObject.hashCode();
      } else {
        m = 0;
      }
      localObject = this.type;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.version;
      if (localObject != null) {
        i1 = localObject.hashCode();
      }
      i = (((((i2 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n) * 37 + i1;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public CustomGraph.Builder newBuilder()
  {
    CustomGraph.Builder localBuilder = new CustomGraph.Builder();
    localBuilder.componentID = this.componentID;
    localBuilder.enabled = this.enabled;
    localBuilder.entityId = this.entityId;
    localBuilder.resourcePath = this.resourcePath;
    localBuilder.type = this.type;
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
    if (this.resourcePath != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("resourcePath=");
      localStringBuilder.append(Internal.sanitize(this.resourcePath));
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
    if (this.version != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("version=");
      localStringBuilder.append(this.version);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"CustomGraph{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.CustomGraph
 * JD-Core Version:    0.7.0.1
 */