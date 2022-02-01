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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/EntityIdentifier;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/EntityIdentifier$Builder;", "type", "", "name", "id", "", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/EntityIdentifier;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class EntityIdentifier
  extends AndroidMessage<EntityIdentifier, EntityIdentifier.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<EntityIdentifier> ADAPTER = (ProtoAdapter)new EntityIdentifier.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(EntityIdentifier.class), "type.googleapis.com/publisher.EntityIdentifier");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<EntityIdentifier> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final EntityIdentifier.Companion Companion = new EntityIdentifier.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=3)
  @JvmField
  @Nullable
  public final Integer id;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @Nullable
  public final String name;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @Nullable
  public final String type;
  
  public EntityIdentifier()
  {
    this(null, null, null, null, 15, null);
  }
  
  public EntityIdentifier(@Nullable String paramString1, @Nullable String paramString2, @Nullable Integer paramInteger, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.type = paramString1;
    this.name = paramString2;
    this.id = paramInteger;
  }
  
  @NotNull
  public final EntityIdentifier copy(@Nullable String paramString1, @Nullable String paramString2, @Nullable Integer paramInteger, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new EntityIdentifier(paramString1, paramString2, paramInteger, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (EntityIdentifier)this) {
      return true;
    }
    if (!(paramObject instanceof EntityIdentifier)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (EntityIdentifier)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.type, paramObject.type)) && (Intrinsics.areEqual(this.name, paramObject.name)) && (Intrinsics.areEqual(this.id, paramObject.id));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int m = unknownFields().hashCode();
      Object localObject = this.type;
      int k = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.name;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.id;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      i = ((m * 37 + i) * 37 + j) * 37 + k;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public EntityIdentifier.Builder newBuilder()
  {
    EntityIdentifier.Builder localBuilder = new EntityIdentifier.Builder();
    localBuilder.type = this.type;
    localBuilder.name = this.name;
    localBuilder.id = this.id;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
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
    if (this.id != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("id=");
      localStringBuilder.append(this.id);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"EntityIdentifier{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.EntityIdentifier
 * JD-Core Version:    0.7.0.1
 */