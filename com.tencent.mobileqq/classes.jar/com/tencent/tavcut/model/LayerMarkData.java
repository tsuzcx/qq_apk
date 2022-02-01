package com.tencent.tavcut.model;

import .r8.java8methods.utility.Long.hashCode.IJ;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/LayerMarkData;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/LayerMarkData$Builder;", "startTimeUs", "", "durationUs", "desc", "", "unknownFields", "Lokio/ByteString;", "(JJLjava/lang/String;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LayerMarkData
  extends AndroidMessage<LayerMarkData, LayerMarkData.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<LayerMarkData> ADAPTER = (ProtoAdapter)new LayerMarkData.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LayerMarkData.class), "type.googleapis.com/publisher.LayerMarkData");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<LayerMarkData> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final LayerMarkData.Companion Companion = new LayerMarkData.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=3)
  @JvmField
  @Nullable
  public final String desc;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", label=WireField.Label.REQUIRED, tag=2)
  @JvmField
  public final long durationUs;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", label=WireField.Label.REQUIRED, tag=1)
  @JvmField
  public final long startTimeUs;
  
  public LayerMarkData(long paramLong1, long paramLong2, @Nullable String paramString, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.startTimeUs = paramLong1;
    this.durationUs = paramLong2;
    this.desc = paramString;
  }
  
  @NotNull
  public final LayerMarkData copy(long paramLong1, long paramLong2, @Nullable String paramString, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new LayerMarkData(paramLong1, paramLong2, paramString, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (LayerMarkData)this) {
      return true;
    }
    if (!(paramObject instanceof LayerMarkData)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (LayerMarkData)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (this.startTimeUs == paramObject.startTimeUs) && (this.durationUs == paramObject.durationUs) && (Intrinsics.areEqual(this.desc, paramObject.desc));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      j = unknownFields().hashCode();
      int k = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.startTimeUs);
      int m = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.durationUs);
      String str = this.desc;
      if (str != null) {
        i = str.hashCode();
      } else {
        i = 0;
      }
      i = ((j * 37 + k) * 37 + m) * 37 + i;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public LayerMarkData.Builder newBuilder()
  {
    LayerMarkData.Builder localBuilder = new LayerMarkData.Builder();
    localBuilder.startTimeUs = Long.valueOf(this.startTimeUs);
    localBuilder.durationUs = Long.valueOf(this.durationUs);
    localBuilder.desc = this.desc;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startTimeUs=");
    localStringBuilder.append(this.startTimeUs);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("durationUs=");
    localStringBuilder.append(this.durationUs);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if (this.desc != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("desc=");
      localStringBuilder.append(Internal.sanitize(this.desc));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"LayerMarkData{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.LayerMarkData
 * JD-Core Version:    0.7.0.1
 */