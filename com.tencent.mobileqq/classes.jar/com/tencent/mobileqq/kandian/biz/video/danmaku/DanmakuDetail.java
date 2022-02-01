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
  private final DanmakuInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuDanmakuInfo;
  @NotNull
  private final UserInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuUserInfo;
  
  public DanmakuDetail(@NotNull Parcel paramParcel)
  {
    this((DanmakuInfo)localObject, (UserInfo)paramParcel);
  }
  
  public DanmakuDetail(@NotNull DanmakuInfo paramDanmakuInfo, @NotNull UserInfo paramUserInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuDanmakuInfo = paramDanmakuInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuUserInfo = paramUserInfo;
  }
  
  @NotNull
  public final DanmakuInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuDanmakuInfo;
  }
  
  @NotNull
  public final UserInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuUserInfo;
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
        if ((Intrinsics.areEqual(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuDanmakuInfo, paramObject.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuDanmakuInfo)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuUserInfo, paramObject.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuUserInfo))) {}
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuDanmakuInfo;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuUserInfo;
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
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuDanmakuInfo);
    localStringBuilder.append(", userInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuUserInfo);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeParcelable((Parcelable)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuDanmakuInfo, paramInt);
    paramParcel.writeParcelable((Parcelable)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuUserInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuDetail
 * JD-Core Version:    0.7.0.1
 */