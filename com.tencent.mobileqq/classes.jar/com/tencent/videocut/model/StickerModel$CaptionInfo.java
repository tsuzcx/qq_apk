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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/StickerModel$CaptionInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/StickerModel$CaptionInfo$Builder;", "source", "Lcom/tencent/videocut/model/StickerModel$CaptionSource;", "unknownFields", "Lokio/ByteString;", "(Lcom/tencent/videocut/model/StickerModel$CaptionSource;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class StickerModel$CaptionInfo
  extends AndroidMessage<CaptionInfo, StickerModel.CaptionInfo.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<CaptionInfo> ADAPTER = (ProtoAdapter)new StickerModel.CaptionInfo.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CaptionInfo.class), "type.googleapis.com/publisher.StickerModel.CaptionInfo");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<CaptionInfo> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final StickerModel.CaptionInfo.Companion Companion = new StickerModel.CaptionInfo.Companion(null);
  @WireField(adapter="com.tencent.videocut.model.StickerModel$CaptionSource#ADAPTER", tag=1)
  @JvmField
  @Nullable
  public final StickerModel.CaptionSource source;
  
  public StickerModel$CaptionInfo()
  {
    this(null, null, 3, null);
  }
  
  public StickerModel$CaptionInfo(@Nullable StickerModel.CaptionSource paramCaptionSource, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.source = paramCaptionSource;
  }
  
  @NotNull
  public final CaptionInfo copy(@Nullable StickerModel.CaptionSource paramCaptionSource, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new CaptionInfo(paramCaptionSource, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (CaptionInfo)this) {
      return true;
    }
    if (!(paramObject instanceof CaptionInfo)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (CaptionInfo)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (this.source == paramObject.source);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      j = unknownFields().hashCode();
      StickerModel.CaptionSource localCaptionSource = this.source;
      if (localCaptionSource != null) {
        i = localCaptionSource.hashCode();
      } else {
        i = 0;
      }
      i = j * 37 + i;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public StickerModel.CaptionInfo.Builder newBuilder()
  {
    StickerModel.CaptionInfo.Builder localBuilder = new StickerModel.CaptionInfo.Builder();
    localBuilder.a = this.source;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    if (this.source != null)
    {
      localObject2 = (Collection)localObject1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("source=");
      localStringBuilder.append(this.source);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"CaptionInfo{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.StickerModel.CaptionInfo
 * JD-Core Version:    0.7.0.1
 */