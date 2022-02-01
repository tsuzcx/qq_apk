package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LocalMediaInfo
  implements Parcelable, Comparable<LocalMediaInfo>
{
  public static final Parcelable.Creator<LocalMediaInfo> CREATOR = new LocalMediaInfo.1();
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
  public int g = 0;
  public int h;
  public int i;
  public int j;
  
  public LocalMediaInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 2;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(-1);
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
  }
  
  public int a(LocalMediaInfo paramLocalMediaInfo)
  {
    int k = -1;
    if (paramLocalMediaInfo == null) {
      return -1;
    }
    long l1 = paramLocalMediaInfo.jdField_d_of_type_Long;
    long l2 = this.jdField_d_of_type_Long;
    if (l1 > l2) {
      return 1;
    }
    if (l1 == l2) {
      k = 0;
    }
    return k;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocalMediaInfo{_id=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", path='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileSize=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", addedDate=");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", modifiedDate=");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append(", orientation=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mDuration=");
    localStringBuilder.append(this.jdField_e_of_type_Long);
    localStringBuilder.append(", selectStatus=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", rotation=");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(", thumbWidth=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", thumbHeight=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", index=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", position=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangInteger);
    localStringBuilder.append(", mMimeType='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mediaWidth=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", mediaHeight=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.LocalMediaInfo
 * JD-Core Version:    0.7.0.1
 */