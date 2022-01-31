package com.tencent.qqmini.sdk.launcher.model;

import NS_MINI_INTERFACE.INTERFACE.StAppMode;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import berm;
import com.tencent.mobileqq.pb.PBBoolField;

public class AppMode
  implements Parcelable
{
  public static final Parcelable.Creator<AppMode> CREATOR = new berm();
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  public boolean j;
  
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
      localAppMode.h = paramStAppMode.isWangKa.get();
      localAppMode.i = paramStAppMode.interLoading.get();
      localAppMode.j = paramStAppMode.isLimitedAccess.get();
    }
    return localAppMode;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int k = 1;
    if (this.a)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.b) {
        break label148;
      }
      paramInt = 1;
      label25:
      paramParcel.writeInt(paramInt);
      if (!this.c) {
        break label153;
      }
      paramInt = 1;
      label39:
      paramParcel.writeInt(paramInt);
      if (!this.d) {
        break label158;
      }
      paramInt = 1;
      label53:
      paramParcel.writeInt(paramInt);
      if (!this.e) {
        break label163;
      }
      paramInt = 1;
      label67:
      paramParcel.writeInt(paramInt);
      if (!this.f) {
        break label168;
      }
      paramInt = 1;
      label81:
      paramParcel.writeInt(paramInt);
      if (!this.g) {
        break label173;
      }
      paramInt = 1;
      label95:
      paramParcel.writeInt(paramInt);
      if (!this.h) {
        break label178;
      }
      paramInt = 1;
      label109:
      paramParcel.writeInt(paramInt);
      if (!this.i) {
        break label183;
      }
      paramInt = 1;
      label123:
      paramParcel.writeInt(paramInt);
      if (!this.j) {
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
    for (paramInt = k;; paramInt = 0)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.AppMode
 * JD-Core Version:    0.7.0.1
 */