package com.tencent.shadow.dynamic.host;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.shadow.proguard.p;

public final class PpsStatus
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new p();
  public final boolean loaderLoaded;
  public final boolean runtimeLoaded;
  public final String uuid;
  public final boolean uuidManagerSet;
  
  public PpsStatus(Parcel paramParcel)
  {
    this.uuid = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.runtimeLoaded = bool1;
      if (paramParcel.readByte() == 0) {
        break label62;
      }
      bool1 = true;
      label37:
      this.loaderLoaded = bool1;
      if (paramParcel.readByte() == 0) {
        break label67;
      }
    }
    label62:
    label67:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.uuidManagerSet = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label37;
    }
  }
  
  public PpsStatus(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.uuid = paramString;
    this.runtimeLoaded = paramBoolean1;
    this.loaderLoaded = paramBoolean2;
    this.uuidManagerSet = paramBoolean3;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.uuid);
    if (this.runtimeLoaded)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.loaderLoaded) {
        break label61;
      }
      paramInt = 1;
      label34:
      paramParcel.writeByte((byte)paramInt);
      if (!this.uuidManagerSet) {
        break label66;
      }
    }
    label61:
    label66:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label34;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.PpsStatus
 * JD-Core Version:    0.7.0.1
 */