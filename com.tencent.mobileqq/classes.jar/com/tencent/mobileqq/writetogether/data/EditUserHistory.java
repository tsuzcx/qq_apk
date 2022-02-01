package com.tencent.mobileqq.writetogether.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EditUserHistory
  implements Parcelable
{
  public static final Parcelable.Creator<EditUserHistory> CREATOR = new EditUserHistory.1();
  public String a;
  public long b;
  public String c;
  
  public EditUserHistory() {}
  
  protected EditUserHistory(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readString();
  }
  
  public EditUserHistory(String paramString1, long paramLong, String paramString2)
  {
    this.a = paramString1;
    this.b = paramLong;
    this.c = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.data.EditUserHistory
 * JD-Core Version:    0.7.0.1
 */