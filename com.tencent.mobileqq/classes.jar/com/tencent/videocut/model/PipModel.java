package com.tencent.videocut.model;

import .r8.java8methods.utility.Integer.hashCode.II;
import .r8.java8methods.utility.Long.hashCode.IJ;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/PipModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/PipModel$Builder;", "mediaClip", "Lcom/tencent/videocut/model/MediaClip;", "startOffset", "", "timelineIndex", "", "unknownFields", "Lokio/ByteString;", "(Lcom/tencent/videocut/model/MediaClip;JILokio/ByteString;)V", "copy", "(Lcom/tencent/videocut/model/MediaClip;Ljava/lang/Long;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/videocut/model/PipModel;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class PipModel
  extends AndroidMessage<PipModel, PipModel.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<PipModel> ADAPTER = (ProtoAdapter)new PipModel.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PipModel.class), "type.googleapis.com/publisher.PipModel");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<PipModel> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final PipModel.Companion Companion = new PipModel.Companion(null);
  @WireField(adapter="com.tencent.videocut.model.MediaClip#ADAPTER", tag=1)
  @JvmField
  @Nullable
  public final MediaClip mediaClip;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=2)
  @JvmField
  public final long startOffset;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=3)
  @JvmField
  public final int timelineIndex;
  
  public PipModel()
  {
    this(null, 0L, 0, null, 15, null);
  }
  
  public PipModel(@Nullable MediaClip paramMediaClip, long paramLong, int paramInt, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.mediaClip = paramMediaClip;
    this.startOffset = paramLong;
    this.timelineIndex = paramInt;
  }
  
  @NotNull
  public final PipModel copy(@Nullable MediaClip paramMediaClip, @Nullable Long paramLong, @Nullable Integer paramInteger, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    long l;
    if (paramLong != null) {
      l = paramLong.longValue();
    } else {
      l = 0L;
    }
    int i;
    if (paramInteger != null) {
      i = paramInteger.intValue();
    } else {
      i = 0;
    }
    return new PipModel(paramMediaClip, l, i, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (PipModel)this) {
      return true;
    }
    if (!(paramObject instanceof PipModel)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (PipModel)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.mediaClip, paramObject.mediaClip)) && (this.startOffset == paramObject.startOffset) && (this.timelineIndex == paramObject.timelineIndex);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      j = unknownFields().hashCode();
      MediaClip localMediaClip = this.mediaClip;
      if (localMediaClip != null) {
        i = localMediaClip.hashCode();
      } else {
        i = 0;
      }
      i = ((j * 37 + i) * 37 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.startOffset)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.timelineIndex);
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public PipModel.Builder newBuilder()
  {
    PipModel.Builder localBuilder = new PipModel.Builder();
    localBuilder.a = this.mediaClip;
    localBuilder.b = this.startOffset;
    localBuilder.c = Integer.valueOf(this.timelineIndex);
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    if (this.mediaClip != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mediaClip=");
      localStringBuilder.append(this.mediaClip);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    long l = this.startOffset;
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startOffset=");
    localStringBuilder.append(this.startOffset);
    ((Collection)localObject2).add(localStringBuilder.toString());
    int i = this.timelineIndex;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("timelineIndex=");
    localStringBuilder.append(this.timelineIndex);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"PipModel{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.PipModel
 * JD-Core Version:    0.7.0.1
 */