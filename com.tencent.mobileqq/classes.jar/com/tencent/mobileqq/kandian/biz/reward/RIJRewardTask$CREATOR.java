package com.tencent.mobileqq.kandian.biz.reward;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTask;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTask;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTask$CREATOR
  implements Parcelable.Creator<RIJRewardTask>
{
  @NotNull
  public RIJRewardTask a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new RIJRewardTask(paramParcel);
  }
  
  @NotNull
  public RIJRewardTask[] a(int paramInt)
  {
    return new RIJRewardTask[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTask.CREATOR
 * JD-Core Version:    0.7.0.1
 */