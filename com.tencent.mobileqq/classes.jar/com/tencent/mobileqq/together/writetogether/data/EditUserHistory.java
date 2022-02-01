package com.tencent.mobileqq.together.writetogether.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import benx;

public class EditUserHistory
  implements Parcelable
{
  public static final Parcelable.Creator<EditUserHistory> CREATOR = new benx();
  public long a;
  public String a;
  public String b;
  
  public EditUserHistory() {}
  
  public EditUserHistory(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.b = paramParcel.readString();
  }
  
  public EditUserHistory(String paramString1, long paramLong, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Long = paramLong;
    this.b = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.data.EditUserHistory
 * JD-Core Version:    0.7.0.1
 */