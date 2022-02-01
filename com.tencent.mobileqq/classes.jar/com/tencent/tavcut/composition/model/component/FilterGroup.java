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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/FilterGroup;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/FilterGroup$Builder;", "entityId", "", "componentID", "enabled", "", "type", "", "name", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/FilterGroup;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class FilterGroup
  extends AndroidMessage<FilterGroup, FilterGroup.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<FilterGroup> ADAPTER = (ProtoAdapter)new FilterGroup.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FilterGroup.class), "type.googleapis.com/publisher.FilterGroup");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<FilterGroup> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final FilterGroup.Companion Companion = new FilterGroup.Companion(null);
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
  public final String name;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=4)
  @JvmField
  @Nullable
  public final String type;
  
  public FilterGroup()
  {
    this(null, null, null, null, null, null, 63, null);
  }
  
  public FilterGroup(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.entityId = paramInteger1;
    this.componentID = paramInteger2;
    this.enabled = paramBoolean;
    this.type = paramString1;
    this.name = paramString2;
  }
  
  @NotNull
  public final FilterGroup copy(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new FilterGroup(paramInteger1, paramInteger2, paramBoolean, paramString1, paramString2, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (FilterGroup)this) {
      return true;
    }
    if (!(paramObject instanceof FilterGroup)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (FilterGroup)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.entityId, paramObject.entityId)) && (Intrinsics.areEqual(this.componentID, paramObject.componentID)) && (Intrinsics.areEqual(this.enabled, paramObject.enabled)) && (Intrinsics.areEqual(this.type, paramObject.type)) && (Intrinsics.areEqual(this.name, paramObject.name));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i1 = unknownFields().hashCode();
      Object localObject = this.entityId;
      int n = 0;
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
      localObject = this.name;
      if (localObject != null) {
        n = localObject.hashCode();
      }
      i = ((((i1 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public FilterGroup.Builder newBuilder()
  {
    FilterGroup.Builder localBuilder = new FilterGroup.Builder();
    localBuilder.entityId = this.entityId;
    localBuilder.componentID = this.componentID;
    localBuilder.enabled = this.enabled;
    localBuilder.type = this.type;
    localBuilder.name = this.name;
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
    if (this.name != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("name=");
      localStringBuilder.append(Internal.sanitize(this.name));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"FilterGroup{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.FilterGroup
 * JD-Core Version:    0.7.0.1
 */