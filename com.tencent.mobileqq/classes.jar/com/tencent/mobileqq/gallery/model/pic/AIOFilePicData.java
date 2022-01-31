package com.tencent.mobileqq.gallery.model.pic;

import android.os.Parcel;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;

public class AIOFilePicData
  extends GalleryBaseData
{
  public String a;
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
  public int i;
  public String i;
  
  public AIOFilePicData()
  {
    this.jdField_c_of_type_JavaLangString = "I:N";
    this.jdField_d_of_type_JavaLangString = "I:N";
    this.jdField_e_of_type_JavaLangString = "I:N";
  }
  
  public int a()
  {
    return 3;
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.a = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_g_of_type_Boolean = Boolean.valueOf(paramParcel.readString()).booleanValue();
    this.jdField_e_of_type_Long = Long.valueOf(paramParcel.readString()).longValue();
    this.jdField_f_of_type_Long = Long.valueOf(paramParcel.readString()).longValue();
    this.jdField_h_of_type_Boolean = Boolean.valueOf(paramParcel.readString()).booleanValue();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.jdField_i_of_type_JavaLangString = paramParcel.readString();
    this.jdField_g_of_type_Int = paramParcel.readInt();
    this.jdField_h_of_type_Int = paramParcel.readInt();
    this.jdField_i_of_type_Int = paramParcel.readInt();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeString(String.valueOf(this.jdField_g_of_type_Boolean));
    paramParcel.writeString(String.valueOf(this.jdField_e_of_type_Long));
    paramParcel.writeString(String.valueOf(this.jdField_f_of_type_Long));
    paramParcel.writeString(String.valueOf(this.jdField_h_of_type_Boolean));
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeInt(this.jdField_h_of_type_Int);
    paramParcel.writeInt(this.jdField_i_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.model.pic.AIOFilePicData
 * JD-Core Version:    0.7.0.1
 */