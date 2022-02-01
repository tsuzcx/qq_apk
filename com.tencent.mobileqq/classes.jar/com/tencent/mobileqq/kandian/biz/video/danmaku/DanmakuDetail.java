package com.tencent.mobileqq.kandian.biz.video.danmaku;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuDetail;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "danmakuInfo", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuInfo;", "userInfo", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/UserInfo;", "(Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuInfo;Lcom/tencent/mobileqq/kandian/biz/video/danmaku/UserInfo;)V", "getDanmakuInfo", "()Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuInfo;", "getUserInfo", "()Lcom/tencent/mobileqq/kandian/biz/video/danmaku/UserInfo;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "flags", "CREATOR", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DanmakuDetail
  implements Parcelable
{
  public static final DanmakuDetail.CREATOR CREATOR = new DanmakuDetail.CREATOR(null);
  @NotNull
  private final DanmakuInfo a;
  @NotNull
  private final UserInfo b;
  
  public DanmakuDetail(@NotNull Parcel paramParcel)
  {
    this((DanmakuInfo)localObject, (UserInfo)paramParcel);
  }
  
  public DanmakuDetail(@NotNull DanmakuInfo paramDanmakuInfo, @NotNull UserInfo paramUserInfo)
  {
    this.a = paramDanmakuInfo;
    this.b = paramUserInfo;
  }
  
  @NotNull
  public final DanmakuInfo a()
  {
    return this.a;
  }
  
  @NotNull
  public final UserInfo b()
  {
    return this.b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DanmakuDetail))
      {
        paramObject = (DanmakuDetail)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b))) {}
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
    Object localObject = this.a;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DanmakuDetail(danmakuInfo=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", userInfo=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeParcelable((Parcelable)this.a, paramInt);
    paramParcel.writeParcelable((Parcelable)this.b, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuDetail
 * JD-Core Version:    0.7.0.1
 */