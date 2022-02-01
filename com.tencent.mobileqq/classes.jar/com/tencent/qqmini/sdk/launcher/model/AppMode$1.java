package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class AppMode$1
  implements Parcelable.Creator<AppMode>
{
  public AppMode createFromParcel(Parcel paramParcel)
  {
    AppMode localAppMode = new AppMode();
    localAppMode.interMode = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.authoritySilent = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.keepOffPullList = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.closeTopRightCapsule = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.openNativeApi = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.hideAppSearch = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.isAppStore = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.isWangKa = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.interLoading = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.isLimitedAccess = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.isPayForFriend = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.useAppInfoWhenNavigate = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.disableAddToMyApp = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.disableAddToMyFavor = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.reloadWithFirstPageChange = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.unlimitedApiRight = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.disableShareToAIO = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.disableShareToQZone = AppMode.isEqOne(paramParcel.readInt());
    localAppMode.disableShareToWeChat = AppMode.isEqOne(paramParcel.readInt());
    return localAppMode;
  }
  
  public AppMode[] newArray(int paramInt)
  {
    return new AppMode[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.AppMode.1
 * JD-Core Version:    0.7.0.1
 */