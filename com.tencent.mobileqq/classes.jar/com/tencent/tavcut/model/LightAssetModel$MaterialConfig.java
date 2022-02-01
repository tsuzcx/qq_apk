package com.tencent.tavcut.model;

import .r8.java8methods.utility.Integer.hashCode.II;
import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.squareup.wire.WireField.Label;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/LightAssetModel$MaterialConfig;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/LightAssetModel$MaterialConfig$Builder;", "type", "Lcom/tencent/tavcut/model/LightAssetModel$MediaType;", "minAssetCount", "", "maxAssetCount", "minVideoDuration", "minImageDuration", "maxImageDuration", "unknownFields", "Lokio/ByteString;", "(Lcom/tencent/tavcut/model/LightAssetModel$MediaType;IIIIILokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LightAssetModel$MaterialConfig
  extends AndroidMessage<MaterialConfig, LightAssetModel.MaterialConfig.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<MaterialConfig> ADAPTER = (ProtoAdapter)new LightAssetModel.MaterialConfig.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MaterialConfig.class), "type.googleapis.com/publisher.LightAssetModel.MaterialConfig");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<MaterialConfig> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final LightAssetModel.MaterialConfig.Companion Companion = new LightAssetModel.MaterialConfig.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REQUIRED, tag=3)
  @JvmField
  public final int maxAssetCount;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REQUIRED, tag=6)
  @JvmField
  public final int maxImageDuration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REQUIRED, tag=2)
  @JvmField
  public final int minAssetCount;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REQUIRED, tag=5)
  @JvmField
  public final int minImageDuration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REQUIRED, tag=4)
  @JvmField
  public final int minVideoDuration;
  @WireField(adapter="com.tencent.tavcut.model.LightAssetModel$MediaType#ADAPTER", tag=1)
  @JvmField
  @Nullable
  public final LightAssetModel.MediaType type;
  
  public LightAssetModel$MaterialConfig(@Nullable LightAssetModel.MediaType paramMediaType, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.type = paramMediaType;
    this.minAssetCount = paramInt1;
    this.maxAssetCount = paramInt2;
    this.minVideoDuration = paramInt3;
    this.minImageDuration = paramInt4;
    this.maxImageDuration = paramInt5;
  }
  
  @NotNull
  public final MaterialConfig copy(@Nullable LightAssetModel.MediaType paramMediaType, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new MaterialConfig(paramMediaType, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (MaterialConfig)this) {
      return true;
    }
    if (!(paramObject instanceof MaterialConfig)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (MaterialConfig)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (this.type == paramObject.type) && (this.minAssetCount == paramObject.minAssetCount) && (this.maxAssetCount == paramObject.maxAssetCount) && (this.minVideoDuration == paramObject.minVideoDuration) && (this.minImageDuration == paramObject.minImageDuration) && (this.maxImageDuration == paramObject.maxImageDuration);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      j = unknownFields().hashCode();
      LightAssetModel.MediaType localMediaType = this.type;
      if (localMediaType != null) {
        i = localMediaType.hashCode();
      } else {
        i = 0;
      }
      i = (((((j * 37 + i) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.minAssetCount)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.maxAssetCount)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.minVideoDuration)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.minImageDuration)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.maxImageDuration);
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public LightAssetModel.MaterialConfig.Builder newBuilder()
  {
    LightAssetModel.MaterialConfig.Builder localBuilder = new LightAssetModel.MaterialConfig.Builder();
    localBuilder.type = this.type;
    localBuilder.minAssetCount = Integer.valueOf(this.minAssetCount);
    localBuilder.maxAssetCount = Integer.valueOf(this.maxAssetCount);
    localBuilder.minVideoDuration = Integer.valueOf(this.minVideoDuration);
    localBuilder.minImageDuration = Integer.valueOf(this.minImageDuration);
    localBuilder.maxImageDuration = Integer.valueOf(this.maxImageDuration);
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
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
    localStringBuilder.append("minAssetCount=");
    localStringBuilder.append(this.minAssetCount);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("maxAssetCount=");
    localStringBuilder.append(this.maxAssetCount);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("minVideoDuration=");
    localStringBuilder.append(this.minVideoDuration);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("minImageDuration=");
    localStringBuilder.append(this.minImageDuration);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("maxImageDuration=");
    localStringBuilder.append(this.maxImageDuration);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"MaterialConfig{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.LightAssetModel.MaterialConfig
 * JD-Core Version:    0.7.0.1
 */