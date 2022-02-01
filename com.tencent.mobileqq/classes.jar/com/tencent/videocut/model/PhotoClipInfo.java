package com.tencent.videocut.model;

import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/PhotoClipInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/PhotoClipInfo$Builder;", "imageFrameRect", "Lcom/tencent/videocut/model/RectF;", "clipFrameRect", "picClipRect", "Lcom/tencent/videocut/model/Rect;", "rotate", "", "unknownFields", "Lokio/ByteString;", "(Lcom/tencent/videocut/model/RectF;Lcom/tencent/videocut/model/RectF;Lcom/tencent/videocut/model/Rect;Ljava/lang/Float;Lokio/ByteString;)V", "Ljava/lang/Float;", "copy", "(Lcom/tencent/videocut/model/RectF;Lcom/tencent/videocut/model/RectF;Lcom/tencent/videocut/model/Rect;Ljava/lang/Float;Lokio/ByteString;)Lcom/tencent/videocut/model/PhotoClipInfo;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class PhotoClipInfo
  extends AndroidMessage<PhotoClipInfo, PhotoClipInfo.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<PhotoClipInfo> ADAPTER = (ProtoAdapter)new PhotoClipInfo.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PhotoClipInfo.class), "type.googleapis.com/publisher.PhotoClipInfo");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<PhotoClipInfo> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final PhotoClipInfo.Companion Companion = new PhotoClipInfo.Companion(null);
  @WireField(adapter="com.tencent.videocut.model.RectF#ADAPTER", tag=2)
  @JvmField
  @Nullable
  public final RectF clipFrameRect;
  @WireField(adapter="com.tencent.videocut.model.RectF#ADAPTER", tag=1)
  @JvmField
  @Nullable
  public final RectF imageFrameRect;
  @WireField(adapter="com.tencent.videocut.model.Rect#ADAPTER", tag=3)
  @JvmField
  @Nullable
  public final Rect picClipRect;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=4)
  @JvmField
  @Nullable
  public final Float rotate;
  
  public PhotoClipInfo()
  {
    this(null, null, null, null, null, 31, null);
  }
  
  public PhotoClipInfo(@Nullable RectF paramRectF1, @Nullable RectF paramRectF2, @Nullable Rect paramRect, @Nullable Float paramFloat, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.imageFrameRect = paramRectF1;
    this.clipFrameRect = paramRectF2;
    this.picClipRect = paramRect;
    this.rotate = paramFloat;
  }
  
  @NotNull
  public final PhotoClipInfo copy(@Nullable RectF paramRectF1, @Nullable RectF paramRectF2, @Nullable Rect paramRect, @Nullable Float paramFloat, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new PhotoClipInfo(paramRectF1, paramRectF2, paramRect, paramFloat, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (PhotoClipInfo)this) {
      return true;
    }
    if (!(paramObject instanceof PhotoClipInfo)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (PhotoClipInfo)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.imageFrameRect, paramObject.imageFrameRect)) && (Intrinsics.areEqual(this.clipFrameRect, paramObject.clipFrameRect)) && (Intrinsics.areEqual(this.picClipRect, paramObject.picClipRect)) && (Intrinsics.areEqual(this.rotate, paramObject.rotate));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int n = unknownFields().hashCode();
      Object localObject = this.imageFrameRect;
      int m = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.clipFrameRect;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.picClipRect;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      localObject = this.rotate;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      i = (((n * 37 + i) * 37 + j) * 37 + k) * 37 + m;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public PhotoClipInfo.Builder newBuilder()
  {
    PhotoClipInfo.Builder localBuilder = new PhotoClipInfo.Builder();
    localBuilder.a = this.imageFrameRect;
    localBuilder.b = this.clipFrameRect;
    localBuilder.c = this.picClipRect;
    localBuilder.d = this.rotate;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.imageFrameRect != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("imageFrameRect=");
      localStringBuilder.append(this.imageFrameRect);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.clipFrameRect != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("clipFrameRect=");
      localStringBuilder.append(this.clipFrameRect);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.picClipRect != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("picClipRect=");
      localStringBuilder.append(this.picClipRect);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.rotate != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("rotate=");
      localStringBuilder.append(this.rotate);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"PhotoClipInfo{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.PhotoClipInfo
 * JD-Core Version:    0.7.0.1
 */