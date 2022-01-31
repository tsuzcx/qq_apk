package com.tencent.mobileqq.nearby.now.model;

import afbg;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class VideoData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new afbg();
  public int a;
  public long a;
  public LocationInfo a;
  public String a;
  public ArrayList a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public String j;
  public String k;
  
  public VideoData()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public VideoData(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label219;
      }
    }
    label219:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.jdField_g_of_type_JavaLangString = paramParcel.readString();
      this.h = paramParcel.readString();
      this.jdField_b_of_type_Long = paramParcel.readLong();
      this.jdField_c_of_type_Long = paramParcel.readLong();
      this.j = paramParcel.readString();
      this.k = paramParcel.readString();
      this.jdField_e_of_type_Long = paramParcel.readLong();
      this.jdField_f_of_type_Int = paramParcel.readInt();
      this.jdField_g_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.jdField_e_of_type_Int = paramParcel.readInt();
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.equals(""));
  }
  
  public int describeContents()
  {
    return hashCode();
  }
  
  public String toString()
  {
    return "VideoData{id='" + this.jdField_a_of_type_JavaLangString + '\'' + ", videoUrl='" + this.jdField_b_of_type_JavaLangString + '\'' + ", coverUrl='" + this.jdField_c_of_type_JavaLangString + '\'' + ", doodleUrl='" + this.jdField_d_of_type_JavaLangString + '\'' + ", headerUrl='" + this.jdField_f_of_type_JavaLangString + '\'' + ", anchorNickName='" + this.jdField_g_of_type_JavaLangString + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = 1;
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_b_of_type_Boolean) {
        break label206;
      }
    }
    label206:
    for (paramInt = m;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
      paramParcel.writeString(this.h);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeString(this.j);
      paramParcel.writeString(this.k);
      paramParcel.writeLong(this.jdField_e_of_type_Long);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      paramParcel.writeInt(this.jdField_g_of_type_Int);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.VideoData
 * JD-Core Version:    0.7.0.1
 */