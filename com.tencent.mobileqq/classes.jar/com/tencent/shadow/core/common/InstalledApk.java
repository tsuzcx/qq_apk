package com.tencent.shadow.core.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class InstalledApk
  implements Parcelable
{
  public static final Parcelable.Creator<InstalledApk> CREATOR = new InstalledApk.1();
  public final String apkFilePath;
  public final String libraryPath;
  public final String oDexPath;
  public final byte[] parcelExtras;
  
  protected InstalledApk(Parcel paramParcel)
  {
    this.apkFilePath = paramParcel.readString();
    this.oDexPath = paramParcel.readString();
    this.libraryPath = paramParcel.readString();
    int i = paramParcel.readInt();
    if (i > 0) {
      this.parcelExtras = new byte[i];
    } else {
      this.parcelExtras = null;
    }
    byte[] arrayOfByte = this.parcelExtras;
    if (arrayOfByte != null) {
      paramParcel.readByteArray(arrayOfByte);
    }
  }
  
  public InstalledApk(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, null);
  }
  
  public InstalledApk(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    this.apkFilePath = paramString1;
    this.oDexPath = paramString2;
    this.libraryPath = paramString3;
    this.parcelExtras = paramArrayOfByte;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.apkFilePath);
    paramParcel.writeString(this.oDexPath);
    paramParcel.writeString(this.libraryPath);
    byte[] arrayOfByte = this.parcelExtras;
    if (arrayOfByte == null) {
      paramInt = 0;
    } else {
      paramInt = arrayOfByte.length;
    }
    paramParcel.writeInt(paramInt);
    arrayOfByte = this.parcelExtras;
    if (arrayOfByte != null) {
      paramParcel.writeByteArray(arrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.core.common.InstalledApk
 * JD-Core Version:    0.7.0.1
 */