package com.tencent.shadow.core.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class InstalledApk$1
  implements Parcelable.Creator<InstalledApk>
{
  public InstalledApk createFromParcel(Parcel paramParcel)
  {
    return new InstalledApk(paramParcel);
  }
  
  public InstalledApk[] newArray(int paramInt)
  {
    return new InstalledApk[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.common.InstalledApk.1
 * JD-Core Version:    0.7.0.1
 */