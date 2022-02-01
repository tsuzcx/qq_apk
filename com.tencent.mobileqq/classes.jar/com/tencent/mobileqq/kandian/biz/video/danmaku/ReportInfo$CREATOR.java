package com.tencent.mobileqq.kandian.biz.video.danmaku;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/ReportInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/ReportInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/kandian/biz/video/danmaku/ReportInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReportInfo$CREATOR
  implements Parcelable.Creator<ReportInfo>
{
  @NotNull
  public ReportInfo a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new ReportInfo(paramParcel);
  }
  
  @NotNull
  public ReportInfo[] a(int paramInt)
  {
    return new ReportInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.ReportInfo.CREATOR
 * JD-Core Version:    0.7.0.1
 */