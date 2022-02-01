package com.tencent.videocut.model;

import .r8.java8methods.utility.Boolean.hashCode.IZ;
import .r8.java8methods.utility.Integer.hashCode.II;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/TransitionModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/TransitionModel$Builder;", "id", "", "path", "position", "", "duration", "", "landscapePagPath", "pagPath", "isLandscape", "", "resId", "relatedClipId", "categoryId", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/videocut/model/TransitionModel;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TransitionModel
  extends AndroidMessage<TransitionModel, TransitionModel.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<TransitionModel> ADAPTER = (ProtoAdapter)new TransitionModel.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TransitionModel.class), "type.googleapis.com/publisher.TransitionModel");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<TransitionModel> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final TransitionModel.Companion Companion = new TransitionModel.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=10)
  @JvmField
  @NotNull
  public final String categoryId;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=4)
  @JvmField
  public final long duration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @NotNull
  public final String id;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=7)
  @JvmField
  public final boolean isLandscape;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=5)
  @JvmField
  @NotNull
  public final String landscapePagPath;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=6)
  @JvmField
  @NotNull
  public final String pagPath;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @NotNull
  public final String path;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=3)
  @JvmField
  public final int position;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=9)
  @JvmField
  @NotNull
  public final String relatedClipId;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=8)
  @JvmField
  @NotNull
  public final String resId;
  
  public TransitionModel()
  {
    this(null, null, 0, 0L, null, null, false, null, null, null, null, 2047, null);
  }
  
  public TransitionModel(@NotNull String paramString1, @NotNull String paramString2, int paramInt, long paramLong, @NotNull String paramString3, @NotNull String paramString4, boolean paramBoolean, @NotNull String paramString5, @NotNull String paramString6, @NotNull String paramString7, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.id = paramString1;
    this.path = paramString2;
    this.position = paramInt;
    this.duration = paramLong;
    this.landscapePagPath = paramString3;
    this.pagPath = paramString4;
    this.isLandscape = paramBoolean;
    this.resId = paramString5;
    this.relatedClipId = paramString6;
    this.categoryId = paramString7;
  }
  
  @NotNull
  public final TransitionModel copy(@Nullable String paramString1, @Nullable String paramString2, @Nullable Integer paramInteger, @Nullable Long paramLong, @Nullable String paramString3, @Nullable String paramString4, @Nullable Boolean paramBoolean, @Nullable String paramString5, @Nullable String paramString6, @Nullable String paramString7, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    if (paramString1 == null) {
      paramString1 = "";
    }
    if (paramString2 == null) {
      paramString2 = "";
    }
    int i;
    if (paramInteger != null) {
      i = paramInteger.intValue();
    } else {
      i = 0;
    }
    long l;
    if (paramLong != null) {
      l = paramLong.longValue();
    } else {
      l = 0L;
    }
    if (paramString3 != null) {
      paramInteger = paramString3;
    } else {
      paramInteger = "";
    }
    if (paramString4 != null) {
      paramLong = paramString4;
    } else {
      paramLong = "";
    }
    boolean bool;
    if (paramBoolean != null) {
      bool = paramBoolean.booleanValue();
    } else {
      bool = false;
    }
    if (paramString5 != null) {
      paramString3 = paramString5;
    } else {
      paramString3 = "";
    }
    if (paramString6 != null) {
      paramString4 = paramString6;
    } else {
      paramString4 = "";
    }
    if (paramString7 == null) {
      paramString7 = "";
    }
    return new TransitionModel(paramString1, paramString2, i, l, paramInteger, paramLong, bool, paramString3, paramString4, paramString7, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (TransitionModel)this) {
      return true;
    }
    if (!(paramObject instanceof TransitionModel)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (TransitionModel)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.id, paramObject.id)) && (Intrinsics.areEqual(this.path, paramObject.path)) && (this.position == paramObject.position) && (this.duration == paramObject.duration) && (Intrinsics.areEqual(this.landscapePagPath, paramObject.landscapePagPath)) && (Intrinsics.areEqual(this.pagPath, paramObject.pagPath)) && (this.isLandscape == paramObject.isLandscape) && (Intrinsics.areEqual(this.resId, paramObject.resId)) && (Intrinsics.areEqual(this.relatedClipId, paramObject.relatedClipId)) && (Intrinsics.areEqual(this.categoryId, paramObject.categoryId));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      i = (((((((((unknownFields().hashCode() * 37 + this.id.hashCode()) * 37 + this.path.hashCode()) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.position)) * 37 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.duration)) * 37 + this.landscapePagPath.hashCode()) * 37 + this.pagPath.hashCode()) * 37 + .r8.java8methods.utility.Boolean.hashCode.IZ.hashCode(this.isLandscape)) * 37 + this.resId.hashCode()) * 37 + this.relatedClipId.hashCode()) * 37 + this.categoryId.hashCode();
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public TransitionModel.Builder newBuilder()
  {
    TransitionModel.Builder localBuilder = new TransitionModel.Builder();
    localBuilder.a = this.id;
    localBuilder.b = this.path;
    localBuilder.c = this.position;
    localBuilder.d = this.duration;
    localBuilder.e = this.landscapePagPath;
    localBuilder.f = this.pagPath;
    localBuilder.g = Boolean.valueOf(this.isLandscape);
    localBuilder.h = this.resId;
    localBuilder.i = this.relatedClipId;
    localBuilder.j = this.categoryId;
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
    int i = this.position;
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("position=");
    localStringBuilder.append(this.position);
    ((Collection)localObject2).add(localStringBuilder.toString());
    long l = this.duration;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("duration=");
    localStringBuilder.append(this.duration);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if (this.landscapePagPath != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("landscapePagPath=");
      localStringBuilder.append(Internal.sanitize(this.landscapePagPath));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.pagPath != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pagPath=");
      localStringBuilder.append(Internal.sanitize(this.pagPath));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    boolean bool = this.isLandscape;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("isLandscape=");
    localStringBuilder.append(this.isLandscape);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if (this.resId != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("resId=");
      localStringBuilder.append(Internal.sanitize(this.resId));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.relatedClipId != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("relatedClipId=");
      localStringBuilder.append(Internal.sanitize(this.relatedClipId));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.categoryId != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("categoryId=");
      localStringBuilder.append(Internal.sanitize(this.categoryId));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"TransitionModel{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.TransitionModel
 * JD-Core Version:    0.7.0.1
 */