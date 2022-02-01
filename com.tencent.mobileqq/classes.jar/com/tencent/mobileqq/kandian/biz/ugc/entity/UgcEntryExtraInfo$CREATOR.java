package com.tencent.mobileqq.kandian.biz.ugc.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/entity/UgcEntryExtraInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/kandian/biz/ugc/entity/UgcEntryExtraInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/kandian/biz/ugc/entity/UgcEntryExtraInfo;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class UgcEntryExtraInfo$CREATOR
  implements Parcelable.Creator<UgcEntryExtraInfo>
{
  @NotNull
  public UgcEntryExtraInfo a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new UgcEntryExtraInfo(paramParcel);
  }
  
  @NotNull
  public UgcEntryExtraInfo[] a(int paramInt)
  {
    return new UgcEntryExtraInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.entity.UgcEntryExtraInfo.CREATOR
 * JD-Core Version:    0.7.0.1
 */