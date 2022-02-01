package com.tencent.qidian;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class QidianProfileCardActivity$QidianSimpleProfileItem
  implements Parcelable
{
  public static final Parcelable.Creator<QidianSimpleProfileItem> CREATOR = new QidianProfileCardActivity.QidianSimpleProfileItem.1();
  public String a;
  public String b;
  public boolean c;
  public int d = 1;
  public int e = 0;
  public String f;
  public boolean g = false;
  public boolean h = false;
  public int i = 0;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeByte((byte)this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeByte((byte)this.g);
    paramParcel.writeByte((byte)this.h);
    paramParcel.writeInt(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.QidianSimpleProfileItem
 * JD-Core Version:    0.7.0.1
 */