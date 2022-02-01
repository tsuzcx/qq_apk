package com.tencent.videocut.model;

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
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/FilterModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/FilterModel$Builder;", "id", "", "lut", "Lcom/tencent/videocut/model/LutFilterModel;", "color", "Lcom/tencent/videocut/model/ColorFilterModel;", "startTimeUs", "", "durationUs", "timeLineIndex", "", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Lcom/tencent/videocut/model/LutFilterModel;Lcom/tencent/videocut/model/ColorFilterModel;JJLjava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "copy", "(Ljava/lang/String;Lcom/tencent/videocut/model/LutFilterModel;Lcom/tencent/videocut/model/ColorFilterModel;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/videocut/model/FilterModel;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class FilterModel
  extends AndroidMessage<FilterModel, FilterModel.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<FilterModel> ADAPTER = (ProtoAdapter)new FilterModel.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FilterModel.class), "type.googleapis.com/publisher.FilterModel");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<FilterModel> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final FilterModel.Companion Companion = new FilterModel.Companion(null);
  @WireField(adapter="com.tencent.videocut.model.ColorFilterModel#ADAPTER", tag=3)
  @JvmField
  @Nullable
  public final ColorFilterModel color;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=5)
  @JvmField
  public final long durationUs;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @NotNull
  public final String id;
  @WireField(adapter="com.tencent.videocut.model.LutFilterModel#ADAPTER", tag=2)
  @JvmField
  @Nullable
  public final LutFilterModel lut;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=4)
  @JvmField
  public final long startTimeUs;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=6)
  @JvmField
  @Nullable
  public final Integer timeLineIndex;
  
  public FilterModel()
  {
    this(null, null, null, 0L, 0L, null, null, 127, null);
  }
  
  public FilterModel(@NotNull String paramString, @Nullable LutFilterModel paramLutFilterModel, @Nullable ColorFilterModel paramColorFilterModel, long paramLong1, long paramLong2, @Nullable Integer paramInteger, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.id = paramString;
    this.lut = paramLutFilterModel;
    this.color = paramColorFilterModel;
    this.startTimeUs = paramLong1;
    this.durationUs = paramLong2;
    this.timeLineIndex = paramInteger;
  }
  
  @NotNull
  public final FilterModel copy(@Nullable String paramString, @Nullable LutFilterModel paramLutFilterModel, @Nullable ColorFilterModel paramColorFilterModel, @Nullable Long paramLong1, @Nullable Long paramLong2, @Nullable Integer paramInteger, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    if (paramString == null) {
      paramString = "";
    }
    long l2 = 0L;
    long l1;
    if (paramLong1 != null) {
      l1 = paramLong1.longValue();
    } else {
      l1 = 0L;
    }
    if (paramLong2 != null) {
      l2 = paramLong2.longValue();
    }
    return new FilterModel(paramString, paramLutFilterModel, paramColorFilterModel, l1, l2, paramInteger, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (FilterModel)this) {
      return true;
    }
    if (!(paramObject instanceof FilterModel)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (FilterModel)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.id, paramObject.id)) && (Intrinsics.areEqual(this.lut, paramObject.lut)) && (Intrinsics.areEqual(this.color, paramObject.color)) && (this.startTimeUs == paramObject.startTimeUs) && (this.durationUs == paramObject.durationUs) && (Intrinsics.areEqual(this.timeLineIndex, paramObject.timeLineIndex));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int m = unknownFields().hashCode();
      int n = this.id.hashCode();
      Object localObject = this.lut;
      int k = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.color;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      int i1 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.startTimeUs);
      int i2 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.durationUs);
      localObject = this.timeLineIndex;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      i = (((((m * 37 + n) * 37 + i) * 37 + j) * 37 + i1) * 37 + i2) * 37 + k;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public FilterModel.Builder newBuilder()
  {
    FilterModel.Builder localBuilder = new FilterModel.Builder();
    localBuilder.a = this.id;
    localBuilder.b = this.lut;
    localBuilder.c = this.color;
    localBuilder.d = this.startTimeUs;
    localBuilder.e = this.durationUs;
    localBuilder.f = this.timeLineIndex;
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
    if (this.lut != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("lut=");
      localStringBuilder.append(this.lut);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.color != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("color=");
      localStringBuilder.append(this.color);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    long l = this.startTimeUs;
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startTimeUs=");
    localStringBuilder.append(this.startTimeUs);
    ((Collection)localObject2).add(localStringBuilder.toString());
    l = this.durationUs;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("durationUs=");
    localStringBuilder.append(this.durationUs);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if (this.timeLineIndex != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("timeLineIndex=");
      localStringBuilder.append(this.timeLineIndex);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"FilterModel{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.FilterModel
 * JD-Core Version:    0.7.0.1
 */