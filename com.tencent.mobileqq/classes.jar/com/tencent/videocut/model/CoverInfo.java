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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/CoverInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/CoverInfo$Builder;", "path", "", "timeAt", "", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/Long;Lokio/ByteString;)V", "Ljava/lang/Long;", "copy", "(Ljava/lang/String;Ljava/lang/Long;Lokio/ByteString;)Lcom/tencent/videocut/model/CoverInfo;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class CoverInfo
  extends AndroidMessage<CoverInfo, CoverInfo.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<CoverInfo> ADAPTER = (ProtoAdapter)new CoverInfo.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CoverInfo.class), "type.googleapis.com/publisher.CoverInfo");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<CoverInfo> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final CoverInfo.Companion Companion = new CoverInfo.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @Nullable
  public final String path;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=2)
  @JvmField
  @Nullable
  public final Long timeAt;
  
  public CoverInfo()
  {
    this(null, null, null, 7, null);
  }
  
  public CoverInfo(@Nullable String paramString, @Nullable Long paramLong, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.path = paramString;
    this.timeAt = paramLong;
  }
  
  @NotNull
  public final CoverInfo copy(@Nullable String paramString, @Nullable Long paramLong, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new CoverInfo(paramString, paramLong, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (CoverInfo)this) {
      return true;
    }
    if (!(paramObject instanceof CoverInfo)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (CoverInfo)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.path, paramObject.path)) && (Intrinsics.areEqual(this.timeAt, paramObject.timeAt));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int k = unknownFields().hashCode();
      Object localObject = this.path;
      j = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.timeAt;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      i = (k * 37 + i) * 37 + j;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public CoverInfo.Builder newBuilder()
  {
    CoverInfo.Builder localBuilder = new CoverInfo.Builder();
    localBuilder.a = this.path;
    localBuilder.b = this.timeAt;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.path != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("path=");
      localStringBuilder.append(Internal.sanitize(this.path));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.timeAt != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("timeAt=");
      localStringBuilder.append(this.timeAt);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"CoverInfo{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.CoverInfo
 * JD-Core Version:    0.7.0.1
 */