package com.tencent.mobileqq.minigame.manager;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class InstalledEngine$1
  implements Parcelable.Creator<InstalledEngine>
{
  public InstalledEngine createFromParcel(Parcel paramParcel)
  {
    boolean bool2 = true;
    InstalledEngine localInstalledEngine = new InstalledEngine();
    localInstalledEngine.engineName = paramParcel.readString();
    localInstalledEngine.engineDir = paramParcel.readString();
    localInstalledEngine.engineVersion = ((EngineVersion)paramParcel.readParcelable(EngineVersion.class.getClassLoader()));
    localInstalledEngine.engineType = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      localInstalledEngine.isVerify = bool1;
      if (paramParcel.readByte() == 0) {
        break label102;
      }
    }
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localInstalledEngine.isPersist = bool1;
      localInstalledEngine.loadStatus = paramParcel.readInt();
      return localInstalledEngine;
      bool1 = false;
      break;
    }
  }
  
  public InstalledEngine[] newArray(int paramInt)
  {
    return new InstalledEngine[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.InstalledEngine.1
 * JD-Core Version:    0.7.0.1
 */