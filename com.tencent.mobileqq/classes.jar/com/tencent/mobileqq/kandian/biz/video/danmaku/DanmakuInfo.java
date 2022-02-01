package com.tencent.mobileqq.kandian.biz.video.danmaku;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "content", "", "time", "", "(Ljava/lang/String;J)V", "id", "type", "", "source", "rowkey", "(Ljava/lang/String;IILjava/lang/String;JLjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getId", "getRowkey", "getSource", "()I", "getTime", "()J", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DanmakuInfo
  implements Parcelable
{
  public static final DanmakuInfo.CREATOR CREATOR = new DanmakuInfo.CREATOR(null);
  @NotNull
  private final String a;
  private final int b;
  private final int c;
  @NotNull
  private final String d;
  private final long e;
  @Nullable
  private final String f;
  
  public DanmakuInfo(@NotNull Parcel paramParcel)
  {
    this(str1, i, j, str2, paramParcel.readLong(), paramParcel.readString());
  }
  
  public DanmakuInfo(@NotNull String paramString1, int paramInt1, int paramInt2, @NotNull String paramString2, long paramLong, @Nullable String paramString3)
  {
    this.a = paramString1;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramString2;
    this.e = paramLong;
    this.f = paramString3;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  @NotNull
  public final String d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final long e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DanmakuInfo))
      {
        paramObject = (DanmakuInfo)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b) && (this.c == paramObject.c) && (Intrinsics.areEqual(this.d, paramObject.d)) && (this.e == paramObject.e) && (Intrinsics.areEqual(this.f, paramObject.f))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  public final String f()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    String str = this.a;
    int k = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    int m = this.b;
    int n = this.c;
    str = this.d;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    long l = this.e;
    int i1 = (int)(l ^ l >>> 32);
    str = this.f;
    if (str != null) {
      k = str.hashCode();
    }
    return ((((i * 31 + m) * 31 + n) * 31 + j) * 31 + i1) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DanmakuInfo(id='");
    localStringBuilder.append(this.a);
    localStringBuilder.append("', content='");
    localStringBuilder.append(this.d);
    localStringBuilder.append("', time=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", rowkey=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeString(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuInfo
 * JD-Core Version:    0.7.0.1
 */