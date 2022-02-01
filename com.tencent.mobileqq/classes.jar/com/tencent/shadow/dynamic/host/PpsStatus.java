package com.tencent.shadow.dynamic.host;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class PpsStatus
  implements Parcelable
{
  public static final Parcelable.Creator<PpsStatus> CREATOR = new PpsStatus.1();
  public final boolean loaderLoaded;
  public final boolean runtimeLoaded;
  public final String uuid;
  public final boolean uuidManagerSet;
  
  PpsStatus(Parcel paramParcel)
  {
    this.uuid = paramParcel.readString();
    int i = paramParcel.readByte();
    boolean bool2 = true;
    boolean bool1;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.runtimeLoaded = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.loaderLoaded = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.uuidManagerSet = bool1;
  }
  
  PpsStatus(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.uuid = paramString;
    this.runtimeLoaded = paramBoolean1;
    this.loaderLoaded = paramBoolean2;
    this.uuidManagerSet = paramBoolean3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uuid);
    paramParcel.writeByte((byte)this.runtimeLoaded);
    paramParcel.writeByte((byte)this.loaderLoaded);
    paramParcel.writeByte((byte)this.uuidManagerSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.PpsStatus
 * JD-Core Version:    0.7.0.1
 */