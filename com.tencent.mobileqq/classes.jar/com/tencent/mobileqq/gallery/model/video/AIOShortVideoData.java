package com.tencent.mobileqq.gallery.model.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;

public class AIOShortVideoData
  extends GalleryBaseData
  implements Parcelable
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
  public String f;
  public boolean f;
  public int g;
  public String g;
  public boolean g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  
  public AIOShortVideoData()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.jdField_e_of_type_Long = paramParcel.readLong();
    this.jdField_g_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.h = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.i = paramParcel.readInt();
    this.k = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.f);
    paramParcel.writeLong(this.jdField_e_of_type_Long);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeInt(this.h);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.k);
    paramParcel.writeInt(this.j);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.model.video.AIOShortVideoData
 * JD-Core Version:    0.7.0.1
 */