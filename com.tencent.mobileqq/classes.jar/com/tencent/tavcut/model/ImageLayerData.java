package com.tencent.tavcut.model;

import .r8.java8methods.utility.Integer.hashCode.II;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/ImageLayerData;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/ImageLayerData$Builder;", "layerIndex", "", "layerName", "", "layerType", "layerMarkList", "", "Lcom/tencent/tavcut/model/LayerMarkData;", "unknownFields", "Lokio/ByteString;", "(ILjava/lang/String;ILjava/util/List;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class ImageLayerData
  extends AndroidMessage<ImageLayerData, ImageLayerData.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<ImageLayerData> ADAPTER = (ProtoAdapter)new ImageLayerData.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ImageLayerData.class), "type.googleapis.com/publisher.ImageLayerData");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<ImageLayerData> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final ImageLayerData.Companion Companion = new ImageLayerData.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REQUIRED, tag=1)
  @JvmField
  public final int layerIndex;
  @WireField(adapter="com.tencent.tavcut.model.LayerMarkData#ADAPTER", label=WireField.Label.REPEATED, tag=4)
  @JvmField
  @NotNull
  public final List<LayerMarkData> layerMarkList;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @Nullable
  public final String layerName;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REQUIRED, tag=3)
  @JvmField
  public final int layerType;
  
  public ImageLayerData(int paramInt1, @Nullable String paramString, int paramInt2, @NotNull List<LayerMarkData> paramList, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.layerIndex = paramInt1;
    this.layerName = paramString;
    this.layerType = paramInt2;
    this.layerMarkList = paramList;
  }
  
  @NotNull
  public final ImageLayerData copy(int paramInt1, @Nullable String paramString, int paramInt2, @NotNull List<LayerMarkData> paramList, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "layerMarkList");
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new ImageLayerData(paramInt1, paramString, paramInt2, paramList, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (ImageLayerData)this) {
      return true;
    }
    if (!(paramObject instanceof ImageLayerData)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (ImageLayerData)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (this.layerIndex == paramObject.layerIndex) && (Intrinsics.areEqual(this.layerName, paramObject.layerName)) && (this.layerType == paramObject.layerType) && (Intrinsics.areEqual(this.layerMarkList, paramObject.layerMarkList));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      j = unknownFields().hashCode();
      int k = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.layerIndex);
      String str = this.layerName;
      if (str != null) {
        i = str.hashCode();
      } else {
        i = 0;
      }
      i = (((j * 37 + k) * 37 + i) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.layerType)) * 37 + this.layerMarkList.hashCode();
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public ImageLayerData.Builder newBuilder()
  {
    ImageLayerData.Builder localBuilder = new ImageLayerData.Builder();
    localBuilder.layerIndex = Integer.valueOf(this.layerIndex);
    localBuilder.layerName = this.layerName;
    localBuilder.layerType = Integer.valueOf(this.layerType);
    localBuilder.layerMarkList = this.layerMarkList;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("layerIndex=");
    localStringBuilder.append(this.layerIndex);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if (this.layerName != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("layerName=");
      localStringBuilder.append(Internal.sanitize(this.layerName));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("layerType=");
    localStringBuilder.append(this.layerType);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if ((((Collection)this.layerMarkList).isEmpty() ^ true))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("layerMarkList=");
      localStringBuilder.append(this.layerMarkList);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"ImageLayerData{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.ImageLayerData
 * JD-Core Version:    0.7.0.1
 */