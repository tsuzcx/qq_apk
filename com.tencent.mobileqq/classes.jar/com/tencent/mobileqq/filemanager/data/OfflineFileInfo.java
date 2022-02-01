package com.tencent.mobileqq.filemanager.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class OfflineFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<OfflineFileInfo> CREATOR = new OfflineFileInfo.1();
  public boolean a;
  public String b;
  public String c;
  public long d;
  public int e;
  public String f;
  public long g;
  public long h;
  public long i;
  public String j;
  public String k;
  private int l = 1;
  
  public OfflineFileInfo() {}
  
  public OfflineFileInfo(Parcel paramParcel)
  {
    this.l = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.g = paramParcel.readLong();
    this.h = paramParcel.readLong();
    this.i = paramParcel.readLong();
    this.k = paramParcel.readString();
    this.j = paramParcel.readString();
    if (this.l == 2)
    {
      this.a = true;
      return;
    }
    this.a = false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bSend[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    localStringBuilder.append("strUuid[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    localStringBuilder.append("uFriendUin[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    localStringBuilder.append("nDangerLv[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("]");
    localStringBuilder.append("strFileName[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("]");
    localStringBuilder.append("nFileSize[");
    localStringBuilder.append(this.g);
    localStringBuilder.append("]");
    localStringBuilder.append("nLiftTime[");
    localStringBuilder.append(this.h);
    localStringBuilder.append("]");
    localStringBuilder.append("nUploadTime[");
    localStringBuilder.append(this.i);
    localStringBuilder.append("]");
    localStringBuilder.append("md5[");
    localStringBuilder.append(this.j);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.a) {
      this.l = 2;
    } else {
      this.l = 1;
    }
    paramParcel.writeInt(this.l);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeLong(this.g);
    paramParcel.writeLong(this.h);
    paramParcel.writeLong(this.i);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.OfflineFileInfo
 * JD-Core Version:    0.7.0.1
 */