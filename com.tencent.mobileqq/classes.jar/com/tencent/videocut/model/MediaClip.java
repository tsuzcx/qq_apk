package com.tencent.videocut.model;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/MediaClip;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/MediaClip$Builder;", "resource", "Lcom/tencent/videocut/model/ResourceModel;", "transform", "Lcom/tencent/videocut/model/Transform;", "filter", "Lcom/tencent/videocut/model/FilterModel;", "voiceKindName", "", "photoClip", "Lcom/tencent/videocut/model/PhotoClipInfo;", "unknownFields", "Lokio/ByteString;", "(Lcom/tencent/videocut/model/ResourceModel;Lcom/tencent/videocut/model/Transform;Lcom/tencent/videocut/model/FilterModel;Ljava/lang/String;Lcom/tencent/videocut/model/PhotoClipInfo;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MediaClip
  extends AndroidMessage<MediaClip, MediaClip.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<MediaClip> ADAPTER = (ProtoAdapter)new MediaClip.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MediaClip.class), "type.googleapis.com/publisher.MediaClip");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<MediaClip> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final MediaClip.Companion Companion = new MediaClip.Companion(null);
  @WireField(adapter="com.tencent.videocut.model.FilterModel#ADAPTER", tag=3)
  @JvmField
  @Nullable
  public final FilterModel filter;
  @WireField(adapter="com.tencent.videocut.model.PhotoClipInfo#ADAPTER", tag=5)
  @JvmField
  @Nullable
  public final PhotoClipInfo photoClip;
  @WireField(adapter="com.tencent.videocut.model.ResourceModel#ADAPTER", tag=1)
  @JvmField
  @Nullable
  public final ResourceModel resource;
  @WireField(adapter="com.tencent.videocut.model.Transform#ADAPTER", tag=2)
  @JvmField
  @Nullable
  public final Transform transform;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=4)
  @JvmField
  @NotNull
  public final String voiceKindName;
  
  public MediaClip()
  {
    this(null, null, null, null, null, null, 63, null);
  }
  
  public MediaClip(@Nullable ResourceModel paramResourceModel, @Nullable Transform paramTransform, @Nullable FilterModel paramFilterModel, @NotNull String paramString, @Nullable PhotoClipInfo paramPhotoClipInfo, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.resource = paramResourceModel;
    this.transform = paramTransform;
    this.filter = paramFilterModel;
    this.voiceKindName = paramString;
    this.photoClip = paramPhotoClipInfo;
  }
  
  @NotNull
  public final MediaClip copy(@Nullable ResourceModel paramResourceModel, @Nullable Transform paramTransform, @Nullable FilterModel paramFilterModel, @Nullable String paramString, @Nullable PhotoClipInfo paramPhotoClipInfo, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    if (paramString == null) {
      paramString = "";
    }
    return new MediaClip(paramResourceModel, paramTransform, paramFilterModel, paramString, paramPhotoClipInfo, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (MediaClip)this) {
      return true;
    }
    if (!(paramObject instanceof MediaClip)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (MediaClip)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.resource, paramObject.resource)) && (Intrinsics.areEqual(this.transform, paramObject.transform)) && (Intrinsics.areEqual(this.filter, paramObject.filter)) && (Intrinsics.areEqual(this.voiceKindName, paramObject.voiceKindName)) && (Intrinsics.areEqual(this.photoClip, paramObject.photoClip));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int n = unknownFields().hashCode();
      Object localObject = this.resource;
      int m = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.transform;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.filter;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      int i1 = this.voiceKindName.hashCode();
      localObject = this.photoClip;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      i = ((((n * 37 + i) * 37 + j) * 37 + k) * 37 + i1) * 37 + m;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public MediaClip.Builder newBuilder()
  {
    MediaClip.Builder localBuilder = new MediaClip.Builder();
    localBuilder.a = this.resource;
    localBuilder.b = this.transform;
    localBuilder.c = this.filter;
    localBuilder.d = this.voiceKindName;
    localBuilder.e = this.photoClip;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.resource != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("resource=");
      localStringBuilder.append(this.resource);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.transform != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("transform=");
      localStringBuilder.append(this.transform);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.filter != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("filter=");
      localStringBuilder.append(this.filter);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.voiceKindName != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("voiceKindName=");
      localStringBuilder.append(Internal.sanitize(this.voiceKindName));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.photoClip != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("photoClip=");
      localStringBuilder.append(this.photoClip);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"MediaClip{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.MediaClip
 * JD-Core Version:    0.7.0.1
 */