package com.tencent.tmassistantsdk;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<TMAssistantCallYYBTaskInfo>
{
  public TMAssistantCallYYBTaskInfo a(Parcel paramParcel)
  {
    return new TMAssistantCallYYBTaskInfo(paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readLong(), paramParcel.readLong(), paramParcel.readString());
  }
  
  public TMAssistantCallYYBTaskInfo[] a(int paramInt)
  {
    return new TMAssistantCallYYBTaskInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.a
 * JD-Core Version:    0.7.0.1
 */