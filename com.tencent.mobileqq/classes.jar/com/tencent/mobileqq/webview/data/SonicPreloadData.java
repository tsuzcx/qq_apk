package com.tencent.mobileqq.webview.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SonicPreloadData
  implements Parcelable
{
  public static final Parcelable.Creator<SonicPreloadData> CREATOR = new SonicPreloadData.1();
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  
  public SonicPreloadData(int paramInt1, String paramString, boolean paramBoolean, long paramLong, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong;
    this.b = paramInt2;
  }
  
  public SonicPreloadData(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Long = paramParcel.readLong();
      this.b = paramParcel.readInt();
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "SonicPreloadData{id='" + this.jdField_a_of_type_Int + '\'' + "url='" + this.jdField_a_of_type_JavaLangString + '\'' + ", accountRelated='" + this.jdField_a_of_type_Boolean + '\'' + ", templateChangeTime='" + this.jdField_a_of_type_Long + '\'' + ", noCacheFilePreloadType='" + this.b + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeInt(this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.data.SonicPreloadData
 * JD-Core Version:    0.7.0.1
 */