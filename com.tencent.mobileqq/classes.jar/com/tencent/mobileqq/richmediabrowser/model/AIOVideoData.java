package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Parcel;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;

public class AIOVideoData
  extends AIOBrowserBaseData
{
  public String a = "I:N";
  public String b = "I:N";
  public int c;
  public String c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public boolean e;
  public int f;
  public long f;
  public String f;
  public boolean f;
  public int g;
  public String g;
  public boolean g;
  public int h;
  public String h;
  public boolean h;
  public int i = 0;
  public boolean i;
  public int j;
  public int k = 0;
  public int l;
  public int m;
  
  public AIOVideoData()
  {
    this.jdField_g_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_h_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getType()
  {
    return 101;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    super.readFromParcel(paramParcel);
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Long = paramParcel.readLong();
    this.jdField_g_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_h_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.i = paramParcel.readInt();
    this.k = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeLong(this.jdField_e_of_type_Long);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_h_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.k);
    paramParcel.writeInt(this.j);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOVideoData
 * JD-Core Version:    0.7.0.1
 */