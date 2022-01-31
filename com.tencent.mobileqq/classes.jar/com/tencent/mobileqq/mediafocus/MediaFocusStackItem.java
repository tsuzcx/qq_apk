package com.tencent.mobileqq.mediafocus;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import arkn;

public class MediaFocusStackItem
  implements Parcelable
{
  public static final Parcelable.Creator<MediaFocusStackItem> CREATOR = new arkn();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public MediaFocusStackItem(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public MediaFocusStackItem(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "MediaFocusStackItem{type='" + this.jdField_a_of_type_Int + '\'' + ", time='" + this.jdField_a_of_type_Long + '\'' + ", id='" + this.jdField_a_of_type_JavaLangString + '\'' + ", pname='" + this.b + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusStackItem
 * JD-Core Version:    0.7.0.1
 */