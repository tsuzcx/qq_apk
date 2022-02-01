package com.tencent.mobileqq.kandian.biz.video.danmaku;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DanmakuInfo$CREATOR
  implements Parcelable.Creator<DanmakuInfo>
{
  @NotNull
  public DanmakuInfo a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new DanmakuInfo(paramParcel);
  }
  
  @NotNull
  public DanmakuInfo[] a(int paramInt)
  {
    return new DanmakuInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuInfo.CREATOR
 * JD-Core Version:    0.7.0.1
 */