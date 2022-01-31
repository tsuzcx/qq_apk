package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import auym;

public class LocalMediaInfo
  implements Parcelable, Comparable<LocalMediaInfo>
{
  public static final Parcelable.Creator<LocalMediaInfo> CREATOR = new auym();
  public int a;
  public long a;
  public Integer a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public long d;
  public String d;
  public int e;
  public long e;
  public String e;
  public int f;
  public String f;
  public int g;
  public int h;
  public int i;
  public int j;
  
  public LocalMediaInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(-1);
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
  }
  
  public int a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {}
    do
    {
      return -1;
      if (paramLocalMediaInfo.jdField_d_of_type_Long > this.jdField_d_of_type_Long) {
        return 1;
      }
    } while (paramLocalMediaInfo.jdField_d_of_type_Long != this.jdField_d_of_type_Long);
    return 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "LocalMediaInfo{_id=" + this.jdField_a_of_type_Long + ", path='" + this.jdField_b_of_type_JavaLangString + '\'' + ", fileSize=" + this.jdField_b_of_type_Long + ", addedDate=" + this.jdField_c_of_type_Long + ", modifiedDate=" + this.jdField_d_of_type_Long + ", orientation=" + this.jdField_b_of_type_Int + ", mDuration=" + this.jdField_e_of_type_Long + ", selectStatus=" + this.jdField_a_of_type_Int + ", rotation=" + this.jdField_e_of_type_Int + ", thumbWidth=" + this.h + ", thumbHeight=" + this.i + ", index=" + this.j + ", position=" + this.jdField_a_of_type_JavaLangInteger + ", mMimeType='" + this.jdField_c_of_type_JavaLangString + '\'' + ", mediaWidth=" + this.jdField_c_of_type_Int + ", mediaHeight=" + this.jdField_d_of_type_Int + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeLong(this.jdField_e_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.jdField_a_of_type_JavaLangInteger.intValue());
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.LocalMediaInfo
 * JD-Core Version:    0.7.0.1
 */