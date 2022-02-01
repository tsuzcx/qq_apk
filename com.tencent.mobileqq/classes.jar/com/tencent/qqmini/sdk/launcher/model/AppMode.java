package com.tencent.qqmini.sdk.launcher.model;

import NS_MINI_INTERFACE.INTERFACE.StAppMode;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.PBBoolField;

public class AppMode
  implements Parcelable
{
  public static final Parcelable.Creator<AppMode> CREATOR = new AppMode.1();
  public boolean authoritySilent;
  public boolean closeTopRightCapsule;
  public boolean hideAppSearch;
  public boolean interLoading;
  public boolean interMode;
  public boolean isAppStore;
  public boolean isLimitedAccess;
  public boolean isWangKa;
  public boolean keepOffPullList;
  public boolean openNativeApi;
  
  public static AppMode from(INTERFACE.StAppMode paramStAppMode)
  {
    AppMode localAppMode = new AppMode();
    if (paramStAppMode != null)
    {
      localAppMode.interMode = paramStAppMode.interMode.get();
      localAppMode.authoritySilent = paramStAppMode.authoritySilent.get();
      localAppMode.keepOffPullList = paramStAppMode.keepOffPullList.get();
      localAppMode.closeTopRightCapsule = paramStAppMode.closeTopRightCapsule.get();
      localAppMode.openNativeApi = paramStAppMode.openNativeApi.get();
      localAppMode.hideAppSearch = paramStAppMode.hideAppSearch.get();
      localAppMode.isAppStore = paramStAppMode.isAppStore.get();
      localAppMode.isWangKa = paramStAppMode.isWangKa.get();
      localAppMode.interLoading = paramStAppMode.interLoading.get();
      localAppMode.isLimitedAccess = paramStAppMode.isLimitedAccess.get();
    }
    return localAppMode;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    if (this.interMode)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.authoritySilent) {
        break label148;
      }
      paramInt = 1;
      label25:
      paramParcel.writeInt(paramInt);
      if (!this.keepOffPullList) {
        break label153;
      }
      paramInt = 1;
      label39:
      paramParcel.writeInt(paramInt);
      if (!this.closeTopRightCapsule) {
        break label158;
      }
      paramInt = 1;
      label53:
      paramParcel.writeInt(paramInt);
      if (!this.openNativeApi) {
        break label163;
      }
      paramInt = 1;
      label67:
      paramParcel.writeInt(paramInt);
      if (!this.hideAppSearch) {
        break label168;
      }
      paramInt = 1;
      label81:
      paramParcel.writeInt(paramInt);
      if (!this.isAppStore) {
        break label173;
      }
      paramInt = 1;
      label95:
      paramParcel.writeInt(paramInt);
      if (!this.isWangKa) {
        break label178;
      }
      paramInt = 1;
      label109:
      paramParcel.writeInt(paramInt);
      if (!this.interLoading) {
        break label183;
      }
      paramInt = 1;
      label123:
      paramParcel.writeInt(paramInt);
      if (!this.isLimitedAccess) {
        break label188;
      }
    }
    label148:
    label153:
    label158:
    label163:
    label168:
    label173:
    label178:
    label183:
    label188:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label25;
      paramInt = 0;
      break label39;
      paramInt = 0;
      break label53;
      paramInt = 0;
      break label67;
      paramInt = 0;
      break label81;
      paramInt = 0;
      break label95;
      paramInt = 0;
      break label109;
      paramInt = 0;
      break label123;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.AppMode
 * JD-Core Version:    0.7.0.1
 */