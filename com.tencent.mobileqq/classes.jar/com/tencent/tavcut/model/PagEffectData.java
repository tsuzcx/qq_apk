package com.tencent.tavcut.model;

import .r8.java8methods.utility.Integer.hashCode.II;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/PagEffectData;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/PagEffectData$Builder;", "filePath", "", "width", "", "height", "durationUs", "", "textLayerList", "", "Lcom/tencent/tavcut/model/TextLayerData;", "imageLayerList", "Lcom/tencent/tavcut/model/ImageLayerData;", "timeStretchMode", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;IIJLjava/util/List;Ljava/util/List;ILokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class PagEffectData
  extends AndroidMessage<PagEffectData, PagEffectData.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<PagEffectData> ADAPTER = (ProtoAdapter)new PagEffectData.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PagEffectData.class), "type.googleapis.com/publisher.PagEffectData");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<PagEffectData> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final PagEffectData.Companion Companion = new PagEffectData.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", label=WireField.Label.REQUIRED, tag=4)
  @JvmField
  public final long durationUs;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @Nullable
  public final String filePath;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REQUIRED, tag=3)
  @JvmField
  public final int height;
  @WireField(adapter="com.tencent.tavcut.model.ImageLayerData#ADAPTER", label=WireField.Label.REPEATED, tag=6)
  @JvmField
  @NotNull
  public final List<ImageLayerData> imageLayerList;
  @WireField(adapter="com.tencent.tavcut.model.TextLayerData#ADAPTER", label=WireField.Label.REPEATED, tag=5)
  @JvmField
  @NotNull
  public final List<TextLayerData> textLayerList;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REQUIRED, tag=7)
  @JvmField
  public final int timeStretchMode;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REQUIRED, tag=2)
  @JvmField
  public final int width;
  
  public PagEffectData(@Nullable String paramString, int paramInt1, int paramInt2, long paramLong, @NotNull List<TextLayerData> paramList, @NotNull List<ImageLayerData> paramList1, int paramInt3, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.filePath = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.durationUs = paramLong;
    this.textLayerList = paramList;
    this.imageLayerList = paramList1;
    this.timeStretchMode = paramInt3;
  }
  
  @NotNull
  public final PagEffectData copy(@Nullable String paramString, int paramInt1, int paramInt2, long paramLong, @NotNull List<TextLayerData> paramList, @NotNull List<ImageLayerData> paramList1, int paramInt3, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "textLayerList");
    Intrinsics.checkParameterIsNotNull(paramList1, "imageLayerList");
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new PagEffectData(paramString, paramInt1, paramInt2, paramLong, paramList, paramList1, paramInt3, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (PagEffectData)this) {
      return true;
    }
    if (!(paramObject instanceof PagEffectData)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (PagEffectData)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.filePath, paramObject.filePath)) && (this.width == paramObject.width) && (this.height == paramObject.height) && (this.durationUs == paramObject.durationUs) && (Intrinsics.areEqual(this.textLayerList, paramObject.textLayerList)) && (Intrinsics.areEqual(this.imageLayerList, paramObject.imageLayerList)) && (this.timeStretchMode == paramObject.timeStretchMode);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      j = unknownFields().hashCode();
      String str = this.filePath;
      if (str != null) {
        i = str.hashCode();
      } else {
        i = 0;
      }
      i = ((((((j * 37 + i) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.width)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.height)) * 37 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.durationUs)) * 37 + this.textLayerList.hashCode()) * 37 + this.imageLayerList.hashCode()) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.timeStretchMode);
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public PagEffectData.Builder newBuilder()
  {
    PagEffectData.Builder localBuilder = new PagEffectData.Builder();
    localBuilder.filePath = this.filePath;
    localBuilder.width = Integer.valueOf(this.width);
    localBuilder.height = Integer.valueOf(this.height);
    localBuilder.durationUs = Long.valueOf(this.durationUs);
    localBuilder.textLayerList = this.textLayerList;
    localBuilder.imageLayerList = this.imageLayerList;
    localBuilder.timeStretchMode = Integer.valueOf(this.timeStretchMode);
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    if (this.filePath != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("filePath=");
      localStringBuilder.append(Internal.sanitize(this.filePath));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("width=");
    localStringBuilder.append(this.width);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("height=");
    localStringBuilder.append(this.height);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("durationUs=");
    localStringBuilder.append(this.durationUs);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if ((((Collection)this.textLayerList).isEmpty() ^ true))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("textLayerList=");
      localStringBuilder.append(this.textLayerList);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((((Collection)this.imageLayerList).isEmpty() ^ true))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("imageLayerList=");
      localStringBuilder.append(this.imageLayerList);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("timeStretchMode=");
    localStringBuilder.append(this.timeStretchMode);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"PagEffectData{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.PagEffectData
 * JD-Core Version:    0.7.0.1
 */