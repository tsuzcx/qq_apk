package com.tencent.qqmini.sdk.launcher.model;

import NS_MINI_INTERFACE.INTERFACE.StAppMode;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bdmm;
import com.tencent.mobileqq.pb.PBBoolField;

public class AppMode
  implements Parcelable
{
  public static final Parcelable.Creator<AppMode> CREATOR = new bdmm();
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  
  public static AppMode a(INTERFACE.StAppMode paramStAppMode)
  {
    AppMode localAppMode = new AppMode();
    if (paramStAppMode != null)
    {
      localAppMode.a = paramStAppMode.interMode.get();
      localAppMode.b = paramStAppMode.authoritySilent.get();
      localAppMode.c = paramStAppMode.keepOffPullList.get();
      localAppMode.d = paramStAppMode.closeTopRightCapsule.get();
      localAppMode.e = paramStAppMode.openNativeApi.get();
      localAppMode.f = paramStAppMode.hideAppSearch.get();
      localAppMode.g = paramStAppMode.isAppStore.get();
      localAppMode.i = paramStAppMode.interLoading.get();
    }
    return localAppMode;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    if (this.a)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.b) {
        break label134;
      }
      paramInt = 1;
      label25:
      paramParcel.writeInt(paramInt);
      if (!this.c) {
        break label139;
      }
      paramInt = 1;
      label39:
      paramParcel.writeInt(paramInt);
      if (!this.d) {
        break label144;
      }
      paramInt = 1;
      label53:
      paramParcel.writeInt(paramInt);
      if (!this.e) {
        break label149;
      }
      paramInt = 1;
      label67:
      paramParcel.writeInt(paramInt);
      if (!this.f) {
        break label154;
      }
      paramInt = 1;
      label81:
      paramParcel.writeInt(paramInt);
      if (!this.g) {
        break label159;
      }
      paramInt = 1;
      label95:
      paramParcel.writeInt(paramInt);
      if (!this.h) {
        break label164;
      }
      paramInt = 1;
      label109:
      paramParcel.writeInt(paramInt);
      if (!this.i) {
        break label169;
      }
    }
    label134:
    label139:
    label144:
    label149:
    label154:
    label159:
    label164:
    label169:
    for (paramInt = j;; paramInt = 0)
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.AppMode
 * JD-Core Version:    0.7.0.1
 */