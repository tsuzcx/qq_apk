package com.tencent.mobileqq.profilesetting;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/profilesetting/ReqSetSettingItem$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/profilesetting/ReqSetSettingItem;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/profilesetting/ReqSetSettingItem;", "profilecard-temp-api_release"}, k=1, mv={1, 1, 16})
public final class ReqSetSettingItem$Companion$CREATOR$1
  implements Parcelable.Creator<ReqSetSettingItem>
{
  @NotNull
  public ReqSetSettingItem a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new ReqSetSettingItem(paramParcel);
  }
  
  @NotNull
  public ReqSetSettingItem[] a(int paramInt)
  {
    return new ReqSetSettingItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ReqSetSettingItem.Companion.CREATOR.1
 * JD-Core Version:    0.7.0.1
 */