package com.tencent.mobileqq.intervideo.yiqikan;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avwz;

public class NewTogetherRoomMessageData
  implements Parcelable
{
  public static final Parcelable.Creator<NewTogetherRoomMessageData> CREATOR = new avwz();
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public NewTogetherRoomMessageData()
  {
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public NewTogetherRoomMessageData(Parcel paramParcel)
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" groupUin = " + this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" groupOwnerUin = " + this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" roomid = " + this.jdField_a_of_type_Long);
    localStringBuilder.append(" oldRoomid = " + this.jdField_b_of_type_Long);
    localStringBuilder.append(" roomName = " + this.d);
    localStringBuilder.append(" jumpScheme = " + this.e);
    localStringBuilder.append(" roomCover = " + this.f);
    localStringBuilder.append(" roomtype = " + this.jdField_a_of_type_Int);
    localStringBuilder.append(" fromid = " + this.g);
    localStringBuilder.append(" oldRoomtype = " + this.jdField_c_of_type_Int);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData
 * JD-Core Version:    0.7.0.1
 */