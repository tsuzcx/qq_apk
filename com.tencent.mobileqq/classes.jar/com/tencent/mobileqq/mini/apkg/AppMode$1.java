package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class AppMode$1
  implements Parcelable.Creator<AppMode>
{
  public AppMode createFromParcel(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMode localAppMode = new AppMode();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localAppMode.interMode = bool1;
      if (paramParcel.readInt() != 1) {
        break label163;
      }
      bool1 = true;
      label37:
      localAppMode.authoritySilent = bool1;
      if (paramParcel.readInt() != 1) {
        break label168;
      }
      bool1 = true;
      label53:
      localAppMode.keepOffPullList = bool1;
      if (paramParcel.readInt() != 1) {
        break label173;
      }
      bool1 = true;
      label69:
      localAppMode.closeTopRightCapsule = bool1;
      if (paramParcel.readInt() != 1) {
        break label178;
      }
      bool1 = true;
      label85:
      localAppMode.openNativeApi = bool1;
      if (paramParcel.readInt() != 1) {
        break label183;
      }
      bool1 = true;
      label101:
      localAppMode.hideAppSearch = bool1;
      if (paramParcel.readInt() != 1) {
        break label188;
      }
      bool1 = true;
      label117:
      localAppMode.isAppStore = bool1;
      if (paramParcel.readInt() != 1) {
        break label193;
      }
      bool1 = true;
      label133:
      localAppMode.isWangKa = bool1;
      if (paramParcel.readInt() != 1) {
        break label198;
      }
    }
    label163:
    label168:
    label173:
    label178:
    label183:
    label188:
    label193:
    label198:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localAppMode.isInterLoading = bool1;
      return localAppMode;
      bool1 = false;
      break;
      bool1 = false;
      break label37;
      bool1 = false;
      break label53;
      bool1 = false;
      break label69;
      bool1 = false;
      break label85;
      bool1 = false;
      break label101;
      bool1 = false;
      break label117;
      bool1 = false;
      break label133;
    }
  }
  
  public AppMode[] newArray(int paramInt)
  {
    return new AppMode[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.AppMode.1
 * JD-Core Version:    0.7.0.1
 */