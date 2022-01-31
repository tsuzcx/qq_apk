package com.tencent.mobileqq.troop.homework.arithmetic.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bbym;

public class HWGuideItem
  implements Parcelable
{
  public static final Parcelable.Creator<HWGuideItem> CREATOR = new bbym();
  public String a;
  public String b;
  
  public HWGuideItem(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.data.HWGuideItem
 * JD-Core Version:    0.7.0.1
 */