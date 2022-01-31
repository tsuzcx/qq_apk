package com.tencent.mobileqq.nearby.now.model;

import aetm;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Comments$Comment
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new aetm();
  public int a;
  public long a;
  public MedalInfo a;
  public String a;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public String e;
  
  public Comments$Comment() {}
  
  public Comments$Comment(Parcel paramParcel)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalInfo = ((MedalInfo)paramParcel.readParcelable(MedalInfo.class.getClassLoader()));
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.e = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return hashCode();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Comment))
    {
      paramObject = (Comment)paramObject;
      bool1 = bool2;
      if (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    return super.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalInfo, paramInt);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.Comments.Comment
 * JD-Core Version:    0.7.0.1
 */