package com.tencent.qidian;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class QidianProfileCardActivity$QidianCompoundProfileItem
  implements Parcelable
{
  public static final Parcelable.Creator<QidianCompoundProfileItem> CREATOR = new QidianProfileCardActivity.QidianCompoundProfileItem.1();
  public String a;
  public String b;
  public String c;
  public boolean d = false;
  public int e;
  public boolean f = false;
  public String g;
  public String h;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeByte((byte)this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeByte((byte)this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.QidianCompoundProfileItem
 * JD-Core Version:    0.7.0.1
 */