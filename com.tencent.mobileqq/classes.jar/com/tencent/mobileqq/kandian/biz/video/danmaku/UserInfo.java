package com.tencent.mobileqq.kandian.biz.video.danmaku;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/UserInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "userUin", "", "(Ljava/lang/String;)V", "userSource", "", "userNickName", "userAvator", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getUserAvator", "()Ljava/lang/String;", "getUserNickName", "getUserSource", "()I", "getUserUin", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UserInfo
  implements Parcelable
{
  public static final UserInfo.CREATOR CREATOR = new UserInfo.CREATOR(null);
  @NotNull
  private final String a;
  private final int b;
  @Nullable
  private final String c;
  @Nullable
  private final String d;
  
  public UserInfo(@NotNull Parcel paramParcel)
  {
    this(str, paramParcel.readInt(), paramParcel.readString(), paramParcel.readString());
  }
  
  public UserInfo(@NotNull String paramString)
  {
    this(paramString, 0, "", "");
  }
  
  public UserInfo(@NotNull String paramString1, int paramInt, @Nullable String paramString2, @Nullable String paramString3)
  {
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
    this.d = paramString3;
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
  
  @Nullable
  public final String c()
  {
    return this.c;
  }
  
  @Nullable
  public final String d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof UserInfo))
      {
        paramObject = (UserInfo)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
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
    str = this.c;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.d;
    if (str != null) {
      k = str.hashCode();
    }
    return ((i * 31 + m) * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserInfo(userUin='");
    localStringBuilder.append(this.a);
    localStringBuilder.append("')");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.UserInfo
 * JD-Core Version:    0.7.0.1
 */