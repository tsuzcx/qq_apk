package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Setting$1
  implements Parcelable.Creator<Setting>
{
  public Setting a(Parcel paramParcel)
  {
    Setting localSetting = new Setting();
    localSetting.readFromParcel(paramParcel);
    return localSetting;
  }
  
  public Setting[] a(int paramInt)
  {
    return new Setting[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.Setting.1
 * JD-Core Version:    0.7.0.1
 */