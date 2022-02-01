package com.tencent.qqmini.sdk.manager;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class InstalledEngine$1
  implements Parcelable.Creator<InstalledEngine>
{
  public InstalledEngine createFromParcel(Parcel paramParcel)
  {
    InstalledEngine localInstalledEngine = new InstalledEngine();
    localInstalledEngine.engineName = paramParcel.readString();
    localInstalledEngine.engineDir = paramParcel.readString();
    localInstalledEngine.engineVersion = ((EngineVersion)paramParcel.readParcelable(EngineVersion.class.getClassLoader()));
    localInstalledEngine.engineType = paramParcel.readInt();
    int i = paramParcel.readByte();
    boolean bool2 = true;
    boolean bool1;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localInstalledEngine.isVerify = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localInstalledEngine.isPersist = bool1;
    localInstalledEngine.loadStatus = paramParcel.readInt();
    return localInstalledEngine;
  }
  
  public InstalledEngine[] newArray(int paramInt)
  {
    return new InstalledEngine[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.InstalledEngine.1
 * JD-Core Version:    0.7.0.1
 */