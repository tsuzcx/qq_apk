package com.tencent.videocut.model;

import .r8.java8methods.utility.Float.hashCode.IF;
import .r8.java8methods.utility.Long.hashCode.IJ;
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
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/ResourceModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/ResourceModel$Builder;", "id", "", "path", "scaleDuration", "", "sourceStart", "sourceDuration", "selectStart", "selectDuration", "type", "Lcom/tencent/videocut/model/MediaType;", "size", "Lcom/tencent/videocut/model/SizeF;", "volume", "", "extras", "", "picClipRect", "Lcom/tencent/videocut/model/RectF;", "reversePath", "normalPath", "isReverseMode", "", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;JJJJJLcom/tencent/videocut/model/MediaType;Lcom/tencent/videocut/model/SizeF;FLjava/util/Map;Lcom/tencent/videocut/model/RectF;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lokio/ByteString;)V", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/tencent/videocut/model/MediaType;Lcom/tencent/videocut/model/SizeF;Ljava/lang/Float;Ljava/util/Map;Lcom/tencent/videocut/model/RectF;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lokio/ByteString;)Lcom/tencent/videocut/model/ResourceModel;", "equals", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ResourceModel
  extends AndroidMessage<ResourceModel, ResourceModel.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<ResourceModel> ADAPTER = (ProtoAdapter)new ResourceModel.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ResourceModel.class), "type.googleapis.com/publisher.ResourceModel");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<ResourceModel> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final ResourceModel.Companion Companion = new ResourceModel.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", keyAdapter="com.squareup.wire.ProtoAdapter#STRING", tag=12)
  @JvmField
  @NotNull
  public final Map<String, String> extras;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @NotNull
  public final String id;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=16)
  @JvmField
  @Nullable
  public final Boolean isReverseMode;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=15)
  @JvmField
  @NotNull
  public final String normalPath;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @NotNull
  public final String path;
  @WireField(adapter="com.tencent.videocut.model.RectF#ADAPTER", tag=13)
  @JvmField
  @Nullable
  public final RectF picClipRect;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=14)
  @JvmField
  @NotNull
  public final String reversePath;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=3)
  @JvmField
  public final long scaleDuration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=7)
  @JvmField
  public final long selectDuration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=6)
  @JvmField
  public final long selectStart;
  @WireField(adapter="com.tencent.videocut.model.SizeF#ADAPTER", tag=9)
  @JvmField
  @Nullable
  public final SizeF size;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=5)
  @JvmField
  public final long sourceDuration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=4)
  @JvmField
  public final long sourceStart;
  @WireField(adapter="com.tencent.videocut.model.MediaType#ADAPTER", tag=8)
  @JvmField
  @Nullable
  public final MediaType type;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=11)
  @JvmField
  public final float volume;
  
  public ResourceModel()
  {
    this(null, null, 0L, 0L, 0L, 0L, 0L, null, null, 0.0F, null, null, null, null, null, null, 65535, null);
  }
  
  public ResourceModel(@NotNull String paramString1, @NotNull String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, @Nullable MediaType paramMediaType, @Nullable SizeF paramSizeF, float paramFloat, @NotNull Map<String, String> paramMap, @Nullable RectF paramRectF, @NotNull String paramString3, @NotNull String paramString4, @Nullable Boolean paramBoolean, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.id = paramString1;
    this.path = paramString2;
    this.scaleDuration = paramLong1;
    this.sourceStart = paramLong2;
    this.sourceDuration = paramLong3;
    this.selectStart = paramLong4;
    this.selectDuration = paramLong5;
    this.type = paramMediaType;
    this.size = paramSizeF;
    this.volume = paramFloat;
    this.extras = paramMap;
    this.picClipRect = paramRectF;
    this.reversePath = paramString3;
    this.normalPath = paramString4;
    this.isReverseMode = paramBoolean;
  }
  
  @NotNull
  public final ResourceModel copy(@Nullable String paramString1, @Nullable String paramString2, @Nullable Long paramLong1, @Nullable Long paramLong2, @Nullable Long paramLong3, @Nullable Long paramLong4, @Nullable Long paramLong5, @Nullable MediaType paramMediaType, @Nullable SizeF paramSizeF, @Nullable Float paramFloat, @NotNull Map<String, String> paramMap, @Nullable RectF paramRectF, @Nullable String paramString3, @Nullable String paramString4, @Nullable Boolean paramBoolean, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "extras");
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    if (paramString1 == null) {
      paramString1 = "";
    }
    if (paramString2 == null) {
      paramString2 = "";
    }
    long l5 = 0L;
    long l1;
    if (paramLong1 != null) {
      l1 = paramLong1.longValue();
    } else {
      l1 = 0L;
    }
    long l2;
    if (paramLong2 != null) {
      l2 = paramLong2.longValue();
    } else {
      l2 = 0L;
    }
    long l3;
    if (paramLong3 != null) {
      l3 = paramLong3.longValue();
    } else {
      l3 = 0L;
    }
    long l4;
    if (paramLong4 != null) {
      l4 = paramLong4.longValue();
    } else {
      l4 = 0L;
    }
    if (paramLong5 != null) {
      l5 = paramLong5.longValue();
    }
    float f;
    if (paramFloat != null) {
      f = paramFloat.floatValue();
    } else {
      f = 0.0F;
    }
    if (paramString3 != null) {
      paramLong1 = paramString3;
    } else {
      paramLong1 = "";
    }
    if (paramString4 == null) {
      paramString4 = "";
    }
    return new ResourceModel(paramString1, paramString2, l1, l2, l3, l4, l5, paramMediaType, paramSizeF, f, paramMap, paramRectF, paramLong1, paramString4, paramBoolean, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (ResourceModel)this) {
      return true;
    }
    if (!(paramObject instanceof ResourceModel)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (ResourceModel)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.id, paramObject.id)) && (Intrinsics.areEqual(this.path, paramObject.path)) && (this.scaleDuration == paramObject.scaleDuration) && (this.sourceStart == paramObject.sourceStart) && (this.sourceDuration == paramObject.sourceDuration) && (this.selectStart == paramObject.selectStart) && (this.selectDuration == paramObject.selectDuration) && (this.type == paramObject.type) && (Intrinsics.areEqual(this.size, paramObject.size)) && (this.volume == paramObject.volume) && (Intrinsics.areEqual(this.extras, paramObject.extras)) && (Intrinsics.areEqual(this.picClipRect, paramObject.picClipRect)) && (Intrinsics.areEqual(this.reversePath, paramObject.reversePath)) && (Intrinsics.areEqual(this.normalPath, paramObject.normalPath)) && (Intrinsics.areEqual(this.isReverseMode, paramObject.isReverseMode));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int n = unknownFields().hashCode();
      int i1 = this.id.hashCode();
      int i2 = this.path.hashCode();
      int i3 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.scaleDuration);
      int i4 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.sourceStart);
      int i5 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.sourceDuration);
      int i6 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.selectStart);
      int i7 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.selectDuration);
      Object localObject = this.type;
      int m = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.size;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      int i8 = .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.volume);
      int i9 = this.extras.hashCode();
      localObject = this.picClipRect;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      int i10 = this.reversePath.hashCode();
      int i11 = this.normalPath.hashCode();
      localObject = this.isReverseMode;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      i = ((((((((((((((n * 37 + i1) * 37 + i2) * 37 + i3) * 37 + i4) * 37 + i5) * 37 + i6) * 37 + i7) * 37 + i) * 37 + j) * 37 + i8) * 37 + i9) * 37 + k) * 37 + i10) * 37 + i11) * 37 + m;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public ResourceModel.Builder newBuilder()
  {
    ResourceModel.Builder localBuilder = new ResourceModel.Builder();
    localBuilder.a = this.id;
    localBuilder.b = this.path;
    localBuilder.c = this.scaleDuration;
    localBuilder.d = this.sourceStart;
    localBuilder.e = this.sourceDuration;
    localBuilder.f = this.selectStart;
    localBuilder.g = this.selectDuration;
    localBuilder.h = this.type;
    localBuilder.i = this.size;
    localBuilder.j = Float.valueOf(this.volume);
    localBuilder.k = this.extras;
    localBuilder.l = this.picClipRect;
    localBuilder.m = this.reversePath;
    localBuilder.n = this.normalPath;
    localBuilder.o = this.isReverseMode;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    if (this.id != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("id=");
      localStringBuilder.append(Internal.sanitize(this.id));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.path != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("path=");
      localStringBuilder.append(Internal.sanitize(this.path));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    long l = this.scaleDuration;
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scaleDuration=");
    localStringBuilder.append(this.scaleDuration);
    ((Collection)localObject2).add(localStringBuilder.toString());
    l = this.sourceStart;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("sourceStart=");
    localStringBuilder.append(this.sourceStart);
    ((Collection)localObject2).add(localStringBuilder.toString());
    l = this.sourceDuration;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("sourceDuration=");
    localStringBuilder.append(this.sourceDuration);
    ((Collection)localObject2).add(localStringBuilder.toString());
    l = this.selectStart;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("selectStart=");
    localStringBuilder.append(this.selectStart);
    ((Collection)localObject2).add(localStringBuilder.toString());
    l = this.selectDuration;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("selectDuration=");
    localStringBuilder.append(this.selectDuration);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if (this.type != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("type=");
      localStringBuilder.append(this.type);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.size != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("size=");
      localStringBuilder.append(this.size);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    float f = this.volume;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("volume=");
    localStringBuilder.append(this.volume);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if ((this.extras.isEmpty() ^ true))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("extras=");
      localStringBuilder.append(this.extras);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.picClipRect != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("picClipRect=");
      localStringBuilder.append(this.picClipRect);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.reversePath != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reversePath=");
      localStringBuilder.append(Internal.sanitize(this.reversePath));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.normalPath != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("normalPath=");
      localStringBuilder.append(Internal.sanitize(this.normalPath));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.isReverseMode != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isReverseMode=");
      localStringBuilder.append(this.isReverseMode);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"ResourceModel{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.ResourceModel
 * JD-Core Version:    0.7.0.1
 */